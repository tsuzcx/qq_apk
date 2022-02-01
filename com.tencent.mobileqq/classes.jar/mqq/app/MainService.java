package mqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.handler.IAuthHandler;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfMsgHandler;
import com.tencent.mobileqq.msf.sdk.handler.INotifyHandler;
import com.tencent.mobileqq.msf.sdk.handler.IPushHandler;
import com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IServerMsgPushHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqRegulatorCallback;
import mqq.util.AbstractUnifiedMonitor;
import mqq.util.IServiceCmdCallback;

public class MainService
{
  public static final String CMD_PRE_AUTH = "QQConnectLogin.pre_auth";
  public static final String MSFPROCESSNAMETAG = ":MSF";
  public static final String MSF_SERVICE_NAME = "com.tencent.mobileqq.msf.service.MsfService";
  public static final String QQPROCESSNAME = "com.tencent.mobileqq";
  public static final String SERVICE_CMD = "serviceCmd";
  private static final String TAG = MainService.class.getSimpleName();
  public static final String UIN_NOT_MATCH_TAG = "uinNotMatch";
  public static boolean isDebugVersion = false;
  public static boolean isGrayVersion = false;
  private static IServiceCmdCallback sCmdCallback = null;
  public static int sNativeTidOfReceiver = -1;
  public static long sPwdPacketTime;
  public static long sReceiverCpuTime = 0L;
  public static MqqRegulatorCallback sRegulatorCallback;
  private static AbstractUnifiedMonitor um = null;
  private IAuthHandler authHandler = new MainService.7(this);
  public int cbExceedCount = 0;
  public int cbIncreaseCount = 0;
  public long cbIncreaseTime = 0L;
  public long cbLastUpdateSPTime = 0L;
  private IErrorHandler errorHandler = new MainService.MyErrorHandler(this, null);
  private MobileQQ mApplicaiton;
  private volatile AppRuntime.InterceptKickListener mInterceptKickListener;
  private final Map<Integer, Class<? extends MSFServlet>> mRequestServlets = new ConcurrentHashMap();
  private final Runnable mSFReceiver = new MainService.2(this);
  private IMsfMsgHandler msfMsgHandler = new MainService.3(this);
  private Thread msfRecvThread;
  private final MsfRespHandleUtil msfRespHandleUtil;
  public final MsfServiceSdk msfSub;
  INotifyHandler notifyHandler = new MainService.5(this);
  private IPushHandler pushHandler = new MainService.4(this);
  private boolean recvThreadRegulatoring = false;
  private IRegisterUinHandler registerUinHandler = new MainService.6(this);
  private int reportThreshold = -1;
  private IServerInfoHandler serverInfoHandler = new MainService.8(this);
  private IServerMsgPushHandler serverMsgPushHandler = new MainService.9(this);
  private int umNotReported = 0;
  
  MainService(MobileQQ paramMobileQQ, int paramInt, String paramString, boolean paramBoolean)
  {
    this.mApplicaiton = paramMobileQQ;
    this.msfSub = MsfServiceSdk.get();
    this.msfSub.init(paramMobileQQ, paramInt, paramString, "com.tencent.mobileqq.msf.service.MsfService", this.errorHandler, MobileQQ.processName);
    this.msfRespHandleUtil = new MsfRespHandleUtil(new IMsfHandler[] { this.msfMsgHandler, this.pushHandler, this.notifyHandler, this.authHandler, this.registerUinHandler, this.serverMsgPushHandler, this.serverInfoHandler });
    if (paramBoolean) {
      start();
    }
  }
  
  private boolean isValidAccount(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString1, AppRuntime paramAppRuntime, boolean paramBoolean, String paramString2)
  {
    return (paramBoolean) || (paramString2.equals(paramAppRuntime.getAccount())) || (isWhiteCommand(paramFromServiceMsg)) || ((paramString1 != null) && (paramString1.equals("subaccount"))) || ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().containsKey("uinNotMatch")));
  }
  
  private boolean isWhiteCommand(FromServiceMsg paramFromServiceMsg)
  {
    return ("login.auth".equals(paramFromServiceMsg.getServiceCmd())) || ("wtlogin.login".equals(paramFromServiceMsg.getServiceCmd())) || (MsfCommand.wt_GetStViaSMSVerifyLogin.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_loginAuth.equals(paramFromServiceMsg.getMsfCommand())) || (MsfCommand.wt_name2uin.equals(paramFromServiceMsg.getMsfCommand())) || ("login.chguin".equals(paramFromServiceMsg.getServiceCmd()));
  }
  
  private void notifyCostTooLongIfDebug(FromServiceMsg paramFromServiceMsg, AppRuntime paramAppRuntime, long paramLong)
  {
    if ((isDebugVersion) && (paramLong >= 5000L) && (paramAppRuntime != null)) {
      paramAppRuntime.runOnUiThread(new MainService.1(this, paramFromServiceMsg, paramLong));
    }
  }
  
  private void receiveMessageFromMSF(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str1 = null;
    Object localObject2 = this.mApplicaiton.waitAppRuntime(null);
    Object localObject1 = localObject2;
    if (paramToServiceMsg != null) {
      localObject1 = ((AppRuntime)localObject2).getAppRuntime(paramToServiceMsg.extraData.getString("moduleId"));
    }
    if (QLog.isColorLevel()) {}
    for (long l1 = SystemClock.currentThreadTimeMillis();; l1 = 0L)
    {
      long l2;
      String str2;
      int i;
      if (paramToServiceMsg != null)
      {
        localObject2 = (Class)this.mRequestServlets.remove(Integer.valueOf(paramToServiceMsg.getAppSeq()));
        l2 = paramToServiceMsg.extraData.getLong("sendTime");
        l2 = System.currentTimeMillis() - l2;
        paramFromServiceMsg.addAttribute("msf_receive", Long.valueOf(System.currentTimeMillis()));
        if (paramFromServiceMsg.isSuccess())
        {
          if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "[MSF Receive]" + paramFromServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + "  " + localObject1.getClass().getSimpleName() + "@" + localObject1.hashCode() + "  cost=" + l2 + "ms.");
          }
          if (sCmdCallback != null) {
            sCmdCallback.onCmdResponse(paramFromServiceMsg.getServiceCmd());
          }
          recordKeyTimestamp(paramToServiceMsg, paramFromServiceMsg);
          str2 = (String)paramToServiceMsg.getAttribute("from_where");
          str1 = (String)paramToServiceMsg.getAttribute("mainaccount");
          i = 0;
        }
      }
      for (;;)
      {
        boolean bool = false;
        if ("0".equals(paramFromServiceMsg.getUin()))
        {
          paramFromServiceMsg.setUin(((AppRuntime)localObject1).getAccount());
          bool = true;
        }
        String str3 = paramFromServiceMsg.getUin();
        if ((str2 != null) && (str2.length() > 0)) {
          paramFromServiceMsg.addAttribute("from_where", str2);
        }
        if ((str1 != null) && (str1.length() > 0)) {
          paramFromServiceMsg.addAttribute("mainaccount", str1);
        }
        if (isValidAccount(paramToServiceMsg, paramFromServiceMsg, str2, (AppRuntime)localObject1, bool, str3))
        {
          startUnifiedMonitorReport();
          l2 = SystemClock.uptimeMillis();
          ((AppRuntime)localObject1).getServletContainer().notifyMSFServlet((Class)localObject2, paramFromServiceMsg);
          if (i != 0) {
            try
            {
              paramToServiceMsg = ((AppRuntime)localObject1).subRuntimeMap.values().iterator();
              while (paramToServiceMsg.hasNext()) {
                ((AppRuntime)paramToServiceMsg.next()).getServletContainer().notifyMSFServlet((Class)localObject2, paramFromServiceMsg);
              }
              l2 = SystemClock.uptimeMillis() - l2;
            }
            catch (Exception paramToServiceMsg)
            {
              if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "", paramToServiceMsg);
              }
            }
          }
          stopUnifiedMonitorReport(paramFromServiceMsg, l2);
          long l3 = SystemClock.currentThreadTimeMillis();
          sReceiverCpuTime = l3;
          if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, new Object[] { "[MSF End][notifyMSFServlet]", paramFromServiceMsg.getServiceCmd(), ",ssoseq=", Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()), ",cost=", Long.valueOf(l2), "ms, cpucost=", Long.valueOf(l3 - l1), "(", Long.valueOf(l3), ")." });
          }
          reportMsfLongCallback(paramFromServiceMsg, l2);
          reportMSFCallBackCost(l2, false);
          notifyCostTooLongIfDebug(paramFromServiceMsg, (AppRuntime)localObject1, l2);
        }
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("mqq", 2, "[MSF Receive]" + paramFromServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + "  " + localObject1.getClass().getSimpleName() + "@" + localObject1.hashCode() + "  code=" + paramFromServiceMsg.getResultCode() + ",cost=" + l2 + "ms.");
        break;
        if ((this.mApplicaiton.getQQProcessName().endsWith(":video")) || (QLog.isColorLevel())) {
          QLog.d("mqq", 1, "[MSF Push]" + paramFromServiceMsg.getServiceCmd() + ",ssoseq=" + paramFromServiceMsg.getRequestSsoSeq());
        }
        i = 1;
        str2 = null;
        localObject2 = null;
      }
    }
  }
  
  private void recordKeyTimestamp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    long l1 = paramToServiceMsg.extraData.getLong("sendTime", 0L);
    long l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_app2msf", Long.valueOf(0L))).longValue();
    long l3 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net", Long.valueOf(0L))).longValue();
    long l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf", Long.valueOf(0L))).longValue();
    long l5 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2app", Long.valueOf(0L))).longValue();
    long l6 = System.currentTimeMillis();
    paramFromServiceMsg.extraData.putLong("timestamp_app2msf_atAppSite", l1);
    paramFromServiceMsg.extraData.putLong("timestamp_app2msf_atMsfSite", l2);
    paramFromServiceMsg.extraData.putLong("timestamp_msf2net_atMsfSite", l3);
    paramFromServiceMsg.extraData.putLong("timestamp_net2msf_atMsfSite", l4);
    paramFromServiceMsg.extraData.putLong("timestamp_msf2app_atMsfSite", l5);
    paramFromServiceMsg.extraData.putLong("timestamp_msf2app_atAppSite", l6);
  }
  
  private void reportMsfLongCallback(FromServiceMsg paramFromServiceMsg, long paramLong)
  {
    if (paramLong >= 2000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("cmd", paramFromServiceMsg.getServiceCmd());
      paramFromServiceMsg = new RdmReq();
      paramFromServiceMsg.eventName = "longTimeCallback";
      paramFromServiceMsg.elapse = paramLong;
      paramFromServiceMsg.size = 0L;
      paramFromServiceMsg.isSucceed = true;
      paramFromServiceMsg.isRealTime = false;
      paramFromServiceMsg.params = localHashMap;
      paramFromServiceMsg = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), paramFromServiceMsg);
      paramFromServiceMsg.setNeedCallback(false);
      paramFromServiceMsg.extraData.putLong("sendTime", System.currentTimeMillis());
      this.msfSub.sendMsg(paramFromServiceMsg);
    }
  }
  
  public static void setServiceCmdCallback(IServiceCmdCallback paramIServiceCmdCallback)
  {
    sCmdCallback = paramIServiceCmdCallback;
  }
  
  public static void setUnifiedMonitorInstance(AbstractUnifiedMonitor paramAbstractUnifiedMonitor)
  {
    um = paramAbstractUnifiedMonitor;
  }
  
  private void startUnifiedMonitorReport()
  {
    if ((this.reportThreshold == -1) && (um != null))
    {
      if (!um.whetherReportDuringThisStartup(7)) {
        break label76;
      }
      this.reportThreshold = um.getThreshold(7);
      um.setMonitoredThread(7, Thread.currentThread(), null);
    }
    for (;;)
    {
      if ((um != null) && (um.whetherStackEnabled(7))) {
        um.reportStackIfTimeout(7);
      }
      return;
      label76:
      this.reportThreshold = -2;
    }
  }
  
  private void stopUnifiedMonitorReport(FromServiceMsg paramFromServiceMsg, long paramLong)
  {
    if (this.reportThreshold > 0)
    {
      if (paramLong > this.reportThreshold)
      {
        if (um.whetherReportThisTime(7)) {
          um.addEvent(7, paramFromServiceMsg.getServiceCmd(), (int)paramLong, this.umNotReported, null);
        }
        this.umNotReported = 0;
      }
    }
    else {
      return;
    }
    if (um.whetherStackEnabled(7)) {
      um.notifyNotTimeout(7);
    }
    this.umNotReported += 1;
  }
  
  public void clearServlets()
  {
    this.mRequestServlets.clear();
  }
  
  public void kick(AppRuntime.KickParams paramKickParams)
  {
    if ((paramKickParams != null) && ((this.errorHandler instanceof MainService.MyErrorHandler))) {
      ((MainService.MyErrorHandler)this.errorHandler).onKickedInternal((ToServiceMsg)paramKickParams.toServiceMsg, (FromServiceMsg)paramKickParams.fromServiceMsg, paramKickParams.isTokenExpired, paramKickParams.isSameDevice);
    }
  }
  
  public void onRecvVerifyManagerCallback(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    this.msfRespHandleUtil.handleRespMsg(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void reportMSFCallBackCost(long paramLong, boolean paramBoolean)
  {
    if (paramLong >= 0L)
    {
      this.cbIncreaseTime += paramLong;
      this.cbIncreaseCount += 1;
      if (paramLong >= 2000L) {
        this.cbExceedCount += 1;
      }
    }
    paramLong = SystemClock.elapsedRealtime();
    Object localObject1;
    long l2;
    long l1;
    int i;
    int j;
    if (this.cbLastUpdateSPTime > 0L)
    {
      if (paramLong - this.cbLastUpdateSPTime > 600000L) {
        paramBoolean = true;
      }
      if ((paramBoolean) && (this.cbIncreaseTime > 0L))
      {
        paramLong = System.currentTimeMillis();
        localObject1 = this.mApplicaiton.getSharedPreferences("msf_cb_report", 0);
        l2 = ((SharedPreferences)localObject1).getLong("cbLastReportTime", paramLong);
        l1 = ((SharedPreferences)localObject1).getLong("cbTotalTime", 0L);
        l1 = this.cbIncreaseTime + l1;
        i = ((SharedPreferences)localObject1).getInt("cbTotalCount", 0);
        j = this.cbIncreaseCount + i;
        i = ((SharedPreferences)localObject1).getInt("cbExceedCount", 0) + this.cbExceedCount;
        if (paramLong - l2 < 86400000L) {
          break label512;
        }
        l2 = 0L;
        if (j > 0) {
          l2 = l1 / j;
        }
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "reportMSFCallBackCost-->cbTotalTime:" + l1 + " ,cbTotalCount:" + j + " ,cbAverageTime:" + l2);
        }
        Object localObject2 = new RdmReq();
        HashMap localHashMap = new HashMap();
        localHashMap.put("cbAverageTime", String.valueOf(l2));
        localHashMap.put("cbTotalCount", String.valueOf(j));
        localHashMap.put("cbExceedCount", String.valueOf(i));
        ((RdmReq)localObject2).eventName = "MSFCallBackAvgCost";
        ((RdmReq)localObject2).elapse = l2;
        ((RdmReq)localObject2).size = 0L;
        ((RdmReq)localObject2).isSucceed = true;
        ((RdmReq)localObject2).isRealTime = false;
        ((RdmReq)localObject2).params = localHashMap;
        localObject2 = MsfMsgUtil.getRdmReportMsg(this.msfSub.getMsfServiceName(), (RdmReq)localObject2);
        ((ToServiceMsg)localObject2).extraData.putLong("sendTime", System.currentTimeMillis());
        this.msfSub.sendMsg((ToServiceMsg)localObject2);
        l2 = 0L;
        j = 0;
        i = 0;
        l1 = paramLong;
        paramLong = l2;
      }
    }
    for (;;)
    {
      localObject1 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putLong("cbLastReportTime", l1);
      ((SharedPreferences.Editor)localObject1).putLong("cbTotalTime", paramLong);
      ((SharedPreferences.Editor)localObject1).putInt("cbTotalCount", j);
      ((SharedPreferences.Editor)localObject1).putInt("cbExceedCount", i);
      ((SharedPreferences.Editor)localObject1).commit();
      this.cbLastUpdateSPTime = SystemClock.elapsedRealtime();
      this.cbIncreaseTime = 0L;
      this.cbIncreaseCount = 0;
      this.cbExceedCount = 0;
      return;
      this.cbLastUpdateSPTime = paramLong;
      break;
      label512:
      if (l2 > paramLong)
      {
        l2 = paramLong;
        paramLong = l1;
        l1 = l2;
      }
      else
      {
        paramLong = l1;
        l1 = l2;
      }
    }
  }
  
  void sendMessageToMSF(ToServiceMsg paramToServiceMsg, MSFServlet paramMSFServlet)
  {
    if (paramToServiceMsg.getServiceName() == null) {
      paramToServiceMsg.setServiceName(this.msfSub.getMsfServiceName());
    }
    this.mRequestServlets.put(Integer.valueOf(paramToServiceMsg.getAppSeq()), paramMSFServlet.getClass());
    paramToServiceMsg.extraData.putLong("sendTime", System.currentTimeMillis());
    paramToServiceMsg.extraData.putString("moduleId", paramMSFServlet.getAppRuntime().getModuleId());
    this.msfSub.sendMsg(paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "[MSF Send]" + paramToServiceMsg.getServiceCmd() + " appSeq:" + paramToServiceMsg.getAppSeq() + "  " + paramMSFServlet.getAppRuntime().getClass().getSimpleName() + "@" + paramMSFServlet.getAppRuntime().hashCode() + "  from " + paramMSFServlet.getClass().getSimpleName());
    }
    if (sCmdCallback != null) {
      sCmdCallback.onCmdRequest(paramToServiceMsg.getServiceCmd());
    }
  }
  
  public void setInterceptKickListener(AppRuntime.InterceptKickListener paramInterceptKickListener)
  {
    this.mInterceptKickListener = paramInterceptKickListener;
  }
  
  public void start()
  {
    if (this.msfRecvThread == null)
    {
      this.msfRecvThread = new Thread(this.mSFReceiver, "MSF-Receiver");
      QLog.d(TAG, 1, "start MSF-Receiver " + this.msfRecvThread.getId());
      if ((this.mApplicaiton == null) || (this.mApplicaiton.getQQProcessName() == null) || (!this.mApplicaiton.getQQProcessName().endsWith(":video"))) {
        break label130;
      }
      this.msfRecvThread.setPriority(10);
    }
    for (;;)
    {
      this.msfRecvThread.start();
      if (sRegulatorCallback != null) {
        this.recvThreadRegulatoring = sRegulatorCallback.regulatorThread(this.msfRecvThread);
      }
      return;
      label130:
      this.msfRecvThread.setPriority(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MainService
 * JD-Core Version:    0.7.0.1
 */