package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.auth.l;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.push.RegPushReason;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.aa;
import com.tencent.mobileqq.msf.sdk.z;
import com.tencent.mobileqq.msf.service.e;
import com.tencent.mobileqq.msf.service.k;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MsfCore
{
  private static final long DEFAULT_DELAY_IP_RACE = 100L;
  private static final String KEY_DELAY_IP_RACE = "delay_ap_race";
  public static final String KEY_MOBILEQQAPPID = "key_mobileQQAppid";
  private static final long MAX_DELAY_IP_RACE = 1000L;
  private static final long MIN__DELAY_IP_RACE = -1000L;
  public static final String MOBILEQQSDROOT_PATH;
  private static final String OLDKSID_PATH;
  private static final String ONLINE_STATUS;
  private static final String SAVEPATH_IMEI;
  public static final int SysVerSion = Build.VERSION.SDK_INT;
  public static int mobileQQAppid = 0;
  public static MsfCore sCore;
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private static final String tag = "MSF.C.MsfCore";
  private com.tencent.mobileqq.msf.core.auth.b accountCenter;
  public boolean bLoadUseTxlib = false;
  private boolean bTxlibSoExist = false;
  public com.tencent.mobileqq.msf.core.a.a configManager;
  AtomicBoolean coreInitFinished = new AtomicBoolean();
  public AtomicLong delayIpRace = new AtomicLong(100L);
  public AtomicBoolean isReconnectSso = new AtomicBoolean();
  public g lightSender;
  public h lightTcpSender;
  private com.tencent.mobileqq.msf.core.net.c.a mDeepSleepDetector;
  public int mLocaleId;
  public MsfMonitorCallback mMsfMonitorCallback = null;
  public AtomicBoolean mbIsInfoLoginGetted = new AtomicBoolean();
  m msfAlarmer;
  private int msfAppid = -1;
  private MsfExitReceiver msfExitReceiver;
  LinkedBlockingQueue msfMessagePairs = new LinkedBlockingQueue();
  public NetConnInfoCenter netConnICenter;
  public com.tencent.mobileqq.msf.core.d.d netFlowStore;
  public volatile String nowSocketConnAdd;
  public com.tencent.mobileqq.msf.core.push.g pushManager;
  public com.tencent.mobileqq.msf.core.quicksend.b quicksender;
  public ad sender;
  com.tencent.mobileqq.msf.core.a.c ssoListManager;
  private ag ssoRespHandler;
  com.tencent.mobileqq.msf.core.e.a standbyModeManager;
  public j statReporter;
  MsfStore store;
  AtomicBoolean suspended = new AtomicBoolean(false);
  public SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());
  private l wtLoginCenter;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tencent");
    MOBILEQQSDROOT_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/msf");
    OLDKSID_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append("/imei");
    SAVEPATH_IMEI = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append("/onlinestatus");
    ONLINE_STATUS = localStringBuilder.toString();
    mobileQQAppid = -1;
  }
  
  public static String getIMEIPath()
  {
    return SAVEPATH_IMEI;
  }
  
  public static int getNextSeq()
  {
    try
    {
      int i = seqFactory.incrementAndGet();
      if (i > 1000000) {
        seqFactory.set(new Random().nextInt(100000) + 60000);
      }
      return i;
    }
    finally {}
  }
  
  public static String getOnlineStatusPath()
  {
    return ONLINE_STATUS;
  }
  
  public static void initAppProMsg(String paramString, int paramInt)
  {
    int i = QLog.getUIN_REPORTLOG_LEVEL();
    FromServiceMsg localFromServiceMsg = new FromServiceMsg("0", "cmd_pushSetConfig");
    localFromServiceMsg.setAppId(paramInt);
    localFromServiceMsg.setMsfCommand(MsfCommand.pushSetConfig);
    MsfSdkUtils.addFromMsgProcessName(paramString, localFromServiceMsg);
    localFromServiceMsg.addAttribute(localFromServiceMsg.getServiceCmd(), Integer.valueOf(i));
    localFromServiceMsg.addAttribute("_attr_socket_connstate", Integer.valueOf(NetConnInfoCenter.socketConnState));
    localFromServiceMsg.addAttribute("_attr_server", Long.valueOf(NetConnInfoCenter.servetTimeSecondInterv));
    localFromServiceMsg.addAttribute("_attr_deviceGUID", l.a());
    localFromServiceMsg.addAttribute("_attr_app_timeout", Integer.valueOf(com.tencent.mobileqq.msf.core.a.a.br()));
    localFromServiceMsg.setMsgSuccess();
    e.a("*", null, localFromServiceMsg);
  }
  
  private void initLocaleId()
  {
    try
    {
      this.mLocaleId = SettingCloneUtil.readValueForInt(BaseApplication.getContext(), null, null, "qqsetting_locale_id", 0);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initLocaleId, sLocaleId = ");
        localStringBuilder.append(this.mLocaleId);
        QLog.d("MSF.C.MsfCore", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MSF.C.MsfCore", 2, "initLocaleId error !", localException);
    }
  }
  
  public int ChangeUinLogin(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg.getAttributes().put("grayCheck", Boolean.valueOf(true));
    if (isUseWtlogin()) {
      return this.wtLoginCenter.a(paramToServiceMsg, true);
    }
    return this.accountCenter.c(paramToServiceMsg);
  }
  
  public void addRespToQuque(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    addRespToQuque(null, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void addRespToQuque(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      String str1 = "0";
      long l1;
      long l2;
      long l3;
      Object localObject;
      String str2;
      if (bool)
      {
        if ((paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) || (paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth) || (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin))
        {
          l1 = System.currentTimeMillis();
          l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
          l3 = j.a(paramToServiceMsg, paramFromServiceMsg);
          if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
            localObject = (String)paramToServiceMsg.getAttribute("_tag_socket");
          } else {
            localObject = "0";
          }
          if (paramToServiceMsg.getAttributes().containsKey("_tag_localsocket")) {
            str1 = (String)paramToServiceMsg.getAttribute("_tag_localsocket");
          }
          if (getStatReporter() != null) {
            getStatReporter().a(true, l1 - l2, paramFromServiceMsg.getBusinessFailCode(), l3, (String)localObject, str1, paramFromServiceMsg.getServiceCmd().equals("login.chguin"), 0L);
          }
          if (paramFromServiceMsg.getServiceCmd().equals("login.chguin"))
          {
            paramToServiceMsg.setUin((String)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd()));
            paramString = new byte[0];
            if (paramFromServiceMsg.getAttribute("__base_tag_sigSession") != null) {
              paramString = (byte[])paramFromServiceMsg.getAttribute("__base_tag_sigSession");
            }
            paramToServiceMsg.setRequestSsoSeq(getNextSeq());
            paramToServiceMsg.setServiceCmd("login.auth");
            this.accountCenter.a(paramToServiceMsg, 16, 0, paramString);
          }
        }
      }
      else if (paramFromServiceMsg.getResultCode() == 1012)
      {
        try
        {
          if (paramToServiceMsg.getAttribute("to_login_alsoCheckTime") != null) {
            break label725;
          }
          paramToServiceMsg.addAttribute("to_login_alsoCheckTime", Integer.valueOf(1));
          if (paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin)
          {
            ChangeUinLogin(paramToServiceMsg);
            return;
          }
          if (paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth)
          {
            login(paramToServiceMsg);
            return;
          }
          if (paramToServiceMsg.getMsfCommand() != MsfCommand.wt_GetStViaSMSVerifyLogin) {
            break label725;
          }
          wt_GetStViaSMSVerifyLogin(paramToServiceMsg);
          return;
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addRespToQuque process code client time error failed ");
          ((StringBuilder)localObject).append(localException.toString());
          QLog.d("MSF.C.MsfCore", 1, ((StringBuilder)localObject).toString());
        }
      }
      else if ((paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) && (paramToServiceMsg.getAttributes().containsKey("__timestamp_app2msf")))
      {
        l1 = -1L;
        if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
          l1 = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
        }
        l3 = j.a(paramToServiceMsg, paramFromServiceMsg);
        if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
          localObject = (String)paramToServiceMsg.getAttribute("_tag_socket");
        } else {
          localObject = "0";
        }
        if (paramToServiceMsg.getAttributes().containsKey("_tag_localsocket")) {
          str2 = (String)paramToServiceMsg.getAttribute("_tag_localsocket");
        }
        bool = paramFromServiceMsg.getServiceCmd().equals("login.chguin");
        if (paramFromServiceMsg.getBusinessFailCode() == 1002)
        {
          l2 = 0L;
          if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net"))
          {
            if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
              l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue() - ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
            }
            if (getStatReporter() != null) {
              getStatReporter().a(false, l1, 1014, l3, (String)localObject, str2, bool, l2);
            }
          }
          else if (getStatReporter() != null)
          {
            getStatReporter().a(false, l1, paramFromServiceMsg.getBusinessFailCode(), l3, (String)localObject, str2, bool, 0L);
          }
        }
        else if (paramFromServiceMsg.getBusinessFailCode() == 2008)
        {
          if (getStatReporter() != null) {
            getStatReporter().a(paramToServiceMsg.getUin(), false, l1, paramFromServiceMsg.getBusinessFailCode(), l3);
          }
        }
        else if (getStatReporter() != null)
        {
          getStatReporter().a(true, l1, paramFromServiceMsg.getBusinessFailCode(), l3, (String)localObject, str2, bool, 0L);
        }
      }
      label725:
      if (paramToServiceMsg.getAttributes().containsKey("to_login_changeuin"))
      {
        str2 = (String)paramToServiceMsg.getAttribute("to_login_changeuin");
        paramFromServiceMsg.addAttribute("to_login_changeuin", paramFromServiceMsg.getUin());
        paramToServiceMsg.setUin(str2);
      }
      if (paramToServiceMsg.getAttributes().containsKey("to_srcCmd"))
      {
        str2 = (String)paramToServiceMsg.getAttribute("to_srcCmd");
        paramToServiceMsg.setServiceCmd(str2);
        paramFromServiceMsg.setServiceCmd(str2);
      }
    }
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      if (com.tencent.mobileqq.msf.core.a.a.x()) {
        paramToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
      }
    }
    paramFromServiceMsg.addAttribute("__timestamp_msf2app", Long.valueOf(System.currentTimeMillis()));
    this.msfMessagePairs.add(new MsfMessagePair(paramString, paramToServiceMsg, paramFromServiceMsg));
  }
  
  public int changeTokenAfterLogin(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    if (isUseWtlogin()) {
      return this.wtLoginCenter.b(paramToServiceMsg, paramBoolean);
    }
    return this.accountCenter.a(paramToServiceMsg, paramBoolean);
  }
  
  public com.tencent.mobileqq.msf.core.auth.b getAccountCenter()
  {
    return this.accountCenter;
  }
  
  public com.tencent.mobileqq.msf.core.net.c.a getDeepSleepDetector()
  {
    return this.mDeepSleepDetector;
  }
  
  public String getMainAccount()
  {
    com.tencent.mobileqq.msf.core.auth.b localb = this.accountCenter;
    if (localb != null) {
      return localb.i();
    }
    return null;
  }
  
  public m getMsfAlarmer()
  {
    return this.msfAlarmer;
  }
  
  public int getMsfAppid()
  {
    return this.msfAppid;
  }
  
  public LinkedBlockingQueue getMsfMessagePairs()
  {
    return this.msfMessagePairs;
  }
  
  public com.tencent.mobileqq.msf.core.d.d getNetFlowStore()
  {
    return this.netFlowStore;
  }
  
  public HandlerThread getNetworkHandlerThread()
  {
    return q.c();
  }
  
  public void getPluginConfig(ToServiceMsg paramToServiceMsg)
  {
    this.configManager.a(paramToServiceMsg);
  }
  
  public com.tencent.mobileqq.msf.core.a.c getSsoListManager()
  {
    return this.ssoListManager;
  }
  
  public ag getSsoRespHandler()
  {
    return this.ssoRespHandler;
  }
  
  public com.tencent.mobileqq.msf.core.e.a getStandyModeManager()
  {
    return this.standbyModeManager;
  }
  
  public j getStatReporter()
  {
    return this.statReporter;
  }
  
  public long getUinPushExtStatus(String paramString)
  {
    return this.pushManager.b(paramString);
  }
  
  public int getUinPushStatus(String paramString)
  {
    return this.pushManager.a(paramString);
  }
  
  public l getWtLoginCenter()
  {
    return this.wtLoginCenter;
  }
  
  public void handleAccountSyncRequest(Context paramContext, ToServiceMsg paramToServiceMsg, int paramInt)
  {
    String[] arrayOfString = paramContext.getPackageManager().getPackagesForUid(paramInt);
    paramContext = paramContext.getPackageName();
    this.accountCenter.c.a(paramToServiceMsg, arrayOfString, paramContext, paramInt);
  }
  
  public String handleGetAccountKey(Context paramContext, ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg = com.tencent.mobileqq.msf.core.auth.c.a(BaseApplication.getContext().getPackageManager(), new String[] { BaseApplication.getContext().getPackageName() });
    if (paramToServiceMsg != null)
    {
      paramContext = new String[paramToServiceMsg.length];
      int i = 0;
      while (i < paramContext.length)
      {
        paramContext[i] = MD5.toMD5(paramToServiceMsg[i].toCharsString()).toLowerCase();
        i += 1;
      }
      paramToServiceMsg = com.tencent.mobileqq.msf.core.auth.c.a(BaseApplication.getContext().getPackageManager(), paramInt);
      if (paramToServiceMsg != null)
      {
        int j = 0;
        for (paramInt = 0;; paramInt = i)
        {
          i = paramInt;
          if (j >= paramToServiceMsg.length) {
            break;
          }
          String str = MD5.toMD5(paramToServiceMsg[j].toCharsString()).toLowerCase();
          int m = paramContext.length;
          int k = 0;
          for (;;)
          {
            i = paramInt;
            if (k >= m) {
              break;
            }
            if (paramContext[k].equals(str))
            {
              i = 1;
              break;
            }
            k += 1;
          }
          if (i != 0) {
            break;
          }
          j += 1;
        }
      }
      i = 0;
      if (i != 0) {
        return this.accountCenter.h();
      }
    }
    return "";
  }
  
  public boolean init(Context paramContext, boolean paramBoolean)
  {
    QLog.d("MSF.C.MsfCore", 1, "MsfCore init begin. isPublic=true isGray=false");
    long l1 = SystemClock.elapsedRealtime();
    sCore = this;
    this.mbIsInfoLoginGetted.set(false);
    Object localObject5 = new j(this);
    ((j)localObject5).e();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("init RQD cost=");
    localStringBuilder1.append(SystemClock.elapsedRealtime() - l1);
    QLog.d("MSF.C.MsfCore", 1, localStringBuilder1.toString());
    long l2 = SystemClock.elapsedRealtime();
    int i;
    try
    {
      i = c.g(paramContext);
      try
      {
        j = c.e(paramContext);
        if ((i != -1) && (j != -1) && (j == i)) {
          bool = false;
        } else {
          bool = true;
        }
      }
      catch (Exception localException1) {}
      localStringBuilder6 = new StringBuilder();
    }
    catch (Exception localException2)
    {
      i = -1;
    }
    localStringBuilder6.append("checkAppVersionCode error ");
    localStringBuilder6.append(localException2);
    QLog.e("MSF.C.MsfCore", 1, localStringBuilder6.toString(), localException2);
    boolean bool = true;
    int j = -1;
    k.t = bool;
    o.c();
    if (Build.VERSION.SDK_INT >= 26) {
      this.mDeepSleepDetector = new com.tencent.mobileqq.msf.core.net.c.a(q.f());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init deviceInfo cost=");
    ((StringBuilder)localObject1).append(SystemClock.elapsedRealtime() - l2);
    QLog.d("MSF.C.MsfCore", 1, ((StringBuilder)localObject1).toString());
    l2 = SystemClock.elapsedRealtime();
    try
    {
      localObject1 = new File(MOBILEQQSDROOT_PATH);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      localObject1 = new File(OLDKSID_PATH);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory())) {
        ((File)localObject1).delete();
      }
    }
    catch (Exception localException3)
    {
      localStringBuilder6 = new StringBuilder();
      localStringBuilder6.append("File operation error ");
      localStringBuilder6.append(localException3);
      QLog.e("MSF.C.MsfCore", 1, localStringBuilder6.toString());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("check copysolib platform=");
    ((StringBuilder)localObject2).append(c.c(paramContext));
    ((StringBuilder)localObject2).append(" installAppVersionCode=");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append(" isNewVersion=");
    ((StringBuilder)localObject2).append(bool);
    QLog.i("MSF.C.MsfCore", 1, ((StringBuilder)localObject2).toString());
    if ("x86".equals(c.c(paramContext))) {}
    try
    {
      c.a(paramContext, c.c(paramContext), bool, j, new String[] { "libcodecwrapperV2.so", "libmsfbootV2.so", "libNativeRQD.so", "libwtecdh.so" });
      break label523;
      localObject2 = c.c(paramContext);
      label523:
      try
      {
        c.a(paramContext, (String)localObject2, bool, j, new String[] { "libcodecwrapperV2.so", "libNativeRQD.so" });
      }
      catch (Exception localException4) {}
      localException5.printStackTrace();
    }
    catch (Exception localException5) {}
    StringBuilder localStringBuilder6 = new StringBuilder();
    localStringBuilder6.append("cp txlib error ");
    localStringBuilder6.append(localException5);
    QLog.d("MSF.C.MsfCore", 1, localStringBuilder6.toString());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("init copySo cost=");
    ((StringBuilder)localObject3).append(SystemClock.elapsedRealtime() - l2);
    QLog.d("MSF.C.MsfCore", 1, ((StringBuilder)localObject3).toString());
    l2 = SystemClock.elapsedRealtime();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("init removeSo cost=");
    ((StringBuilder)localObject3).append(SystemClock.elapsedRealtime() - l2);
    QLog.d("MSF.C.MsfCore", 1, ((StringBuilder)localObject3).toString());
    l2 = SystemClock.elapsedRealtime();
    try
    {
      this.store = new MsfStore();
      if (!this.store.init(paramContext))
      {
        QLog.e("MSF.C.MsfCore", 1, "MsfStore init fail");
        return false;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("init msfStore cost=");
      ((StringBuilder)localObject3).append(SystemClock.elapsedRealtime() - l2);
      QLog.d("MSF.C.MsfCore", 1, ((StringBuilder)localObject3).toString());
      l2 = SystemClock.elapsedRealtime();
      try
      {
        localObject3 = MsfStore.getNativeConfigStore().getConfig("key_mobileQQAppid");
        if ((localObject3 != null) && (((String)localObject3).length() > 0))
        {
          mobileQQAppid = Integer.parseInt((String)localObject3);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("load mobileQQAppid ");
            ((StringBuilder)localObject3).append(mobileQQAppid);
            QLog.d("MSF.C.MsfCore", 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
      catch (Exception localException6)
      {
        localStringBuilder6 = new StringBuilder();
        localStringBuilder6.append("load mobileQQAppid failed ");
        localStringBuilder6.append(localException6);
        QLog.e("MSF.C.MsfCore", 1, localStringBuilder6.toString());
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("init nativeConfigStore cost=");
      localStringBuilder2.append(SystemClock.elapsedRealtime() - l2);
      QLog.d("MSF.C.MsfCore", 1, localStringBuilder2.toString());
      l2 = SystemClock.elapsedRealtime();
      this.wtLoginCenter = new l();
      this.wtLoginCenter.a(this);
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("init wtlogin cost=");
      localStringBuilder2.append(SystemClock.elapsedRealtime() - l2);
      QLog.d("MSF.C.MsfCore", 1, localStringBuilder2.toString());
      l2 = SystemClock.elapsedRealtime();
      this.accountCenter = new com.tencent.mobileqq.msf.core.auth.b(this);
      this.accountCenter.a(true);
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("init accountCenter cost=");
      localStringBuilder2.append(SystemClock.elapsedRealtime() - l2);
      QLog.d("MSF.C.MsfCore", 2, localStringBuilder2.toString());
      l2 = SystemClock.elapsedRealtime();
      this.ssoRespHandler = new ag(this);
      try
      {
        this.msfAlarmer = new m(this);
        this.msfAlarmer.a();
      }
      catch (Exception localException7)
      {
        localStringBuilder6 = new StringBuilder();
        localStringBuilder6.append("msfAlarmer init failed ");
        localStringBuilder6.append(localException7);
        QLog.e("MSF.C.MsfCore", 1, localStringBuilder6.toString());
      }
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("init msfAlarm cost=");
      localStringBuilder3.append(SystemClock.elapsedRealtime() - l2);
      QLog.d("MSF.C.MsfCore", 1, localStringBuilder3.toString());
      l2 = SystemClock.elapsedRealtime();
      try
      {
        this.configManager = new com.tencent.mobileqq.msf.core.a.a(this);
        this.configManager.a();
      }
      catch (Exception localException8)
      {
        localStringBuilder6 = new StringBuilder();
        localStringBuilder6.append("configManager init failed ");
        localStringBuilder6.append(localException8);
        QLog.e("MSF.C.MsfCore", 1, localStringBuilder6.toString());
      }
      try
      {
        this.ssoListManager = new com.tencent.mobileqq.msf.core.a.c(this);
        this.ssoListManager.a();
      }
      catch (Exception localException9)
      {
        localStringBuilder6 = new StringBuilder();
        localStringBuilder6.append("SsoListManager init failed ");
        localStringBuilder6.append(localException9);
        QLog.e("MSF.C.MsfCore", 1, localStringBuilder6.toString());
      }
      StringBuilder localStringBuilder4 = new StringBuilder();
      localStringBuilder4.append("init sso&config cost=");
      localStringBuilder4.append(SystemClock.elapsedRealtime() - l2);
      QLog.d("MSF.C.MsfCore", 1, localStringBuilder4.toString());
      l2 = SystemClock.elapsedRealtime();
      try
      {
        this.netConnICenter = new NetConnInfoCenter();
        NetConnInfoCenter.init(this);
      }
      catch (Exception localException10)
      {
        localStringBuilder6 = new StringBuilder();
        localStringBuilder6.append("MsfCore init netConnInfoCenter error ");
        localStringBuilder6.append(localException10);
        QLog.e("MSF.C.MsfCore", 1, localStringBuilder6.toString(), localException10);
      }
      StringBuilder localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append("init network center cost=");
      localStringBuilder5.append(SystemClock.elapsedRealtime() - l2);
      QLog.d("MSF.C.MsfCore", 1, localStringBuilder5.toString());
      l2 = SystemClock.elapsedRealtime();
      ((j)localObject5).f();
      if (((j)localObject5).c())
      {
        this.statReporter = ((j)localObject5);
        if (k.f)
        {
          QLog.d("MSF.C.MsfCore", 1, "MSF_Alive_Log do report JobScheduler alive MSF to rdm in msfcore init");
          k.a(true);
        }
        this.store.reportLoadCfgTempFile();
      }
      localStringBuilder5 = new StringBuilder();
      localStringBuilder5.append("init beacon Cost=");
      localStringBuilder5.append(SystemClock.elapsedRealtime() - l2);
      QLog.d("MSF.C.MsfCore", 1, localStringBuilder5.toString());
      l2 = SystemClock.elapsedRealtime();
      Object localObject4;
      try
      {
        this.sender = new ad(this);
        if (!this.sender.a(paramContext))
        {
          QLog.e("MSF.C.MsfCore", 1, "Sender init fail");
          return false;
        }
        try
        {
          this.lightSender = new g(this, paramContext);
          if (com.tencent.mobileqq.msf.core.quicksend.b.g()) {
            this.lightTcpSender = new h(this, paramContext);
          }
        }
        catch (Exception localException11)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("LightSender init failed ");
          ((StringBuilder)localObject5).append(localException11);
          QLog.e("MSF.C.MsfCore", 1, ((StringBuilder)localObject5).toString());
        }
        this.accountCenter.a();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("init sender&light cost=");
        ((StringBuilder)localObject4).append(SystemClock.elapsedRealtime() - l2);
        QLog.d("MSF.C.MsfCore", 1, ((StringBuilder)localObject4).toString());
        l2 = SystemClock.elapsedRealtime();
        try
        {
          this.pushManager = new com.tencent.mobileqq.msf.core.push.g(this);
          this.pushManager.a(paramContext, paramBoolean);
        }
        catch (Exception paramContext)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("PushManager init failed ");
          ((StringBuilder)localObject4).append(paramContext);
          QLog.e("MSF.C.MsfCore", 1, ((StringBuilder)localObject4).toString());
        }
        if (bool) {
          try
          {
            this.configManager.a("0", 60000);
          }
          catch (Exception paramContext)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.MsfCore", 2, paramContext.toString(), paramContext);
            }
          }
        }
        paramContext = new StringBuilder();
        paramContext.append("init push cost=");
        paramContext.append(SystemClock.elapsedRealtime() - l2);
        QLog.d("MSF.C.MsfCore", 1, paramContext.toString());
        l2 = SystemClock.elapsedRealtime();
        this.standbyModeManager = new com.tencent.mobileqq.msf.core.e.a(this);
        this.msfExitReceiver = new MsfExitReceiver();
        try
        {
          this.quicksender = new com.tencent.mobileqq.msf.core.quicksend.b(this);
          this.accountCenter.g.b();
        }
        catch (Exception paramContext)
        {
          QLog.d("MSF.C.MsfCore", 1, paramContext.toString(), paramContext);
        }
        paramContext = new StringBuilder();
        paramContext.append("init standby&quickSender cost=");
        paramContext.append(SystemClock.elapsedRealtime() - l2);
        QLog.d("MSF.C.MsfCore", 1, paramContext.toString());
        SystemClock.elapsedRealtime();
        new n(this, j, i, paramBoolean).start();
        this.coreInitFinished.set(true);
        initLocaleId();
        paramContext = BaseApplication.getContext().getSharedPreferences("sp_msf_common", 0);
        localObject4 = this.delayIpRace;
        ((AtomicLong)localObject4).set(paramContext.getLong("delay_ap_race", ((AtomicLong)localObject4).get()));
        paramContext = new StringBuilder();
        paramContext.append("MsfCore init finished. cost=");
        paramContext.append(SystemClock.elapsedRealtime() - l1);
        QLog.d("MSF.C.MsfCore", 1, paramContext.toString());
        return true;
      }
      catch (Exception paramContext)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("Sender init failed ");
        ((StringBuilder)localObject4).append(paramContext);
        QLog.e("MSF.C.MsfCore", 1, ((StringBuilder)localObject4).toString());
        return false;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("MsfStore init error ");
      ((StringBuilder)localObject4).append(paramContext);
      QLog.e("MSF.C.MsfCore", 1, ((StringBuilder)localObject4).toString());
    }
  }
  
  public boolean isOffline()
  {
    com.tencent.mobileqq.msf.core.auth.b localb = this.accountCenter;
    if (localb != null) {
      return "0".equals(localb.i());
    }
    return true;
  }
  
  public boolean isSuspended()
  {
    return this.suspended.get();
  }
  
  public boolean isUseWtlogin()
  {
    return com.tencent.mobileqq.msf.core.a.a.n();
  }
  
  public int login(ToServiceMsg paramToServiceMsg)
  {
    return login(paramToServiceMsg, 16, 0, new byte[0]);
  }
  
  public int login(ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recv ");
      localStringBuilder.append(paramToServiceMsg.getUin());
      localStringBuilder.append(" login req");
      QLog.d("MSF.C.MsfCore", 2, localStringBuilder.toString());
    }
    paramToServiceMsg.getAttributes().put("grayCheck", Boolean.valueOf(true));
    if (isUseWtlogin()) {
      return this.wtLoginCenter.a(paramToServiceMsg, false);
    }
    return this.accountCenter.a(paramToServiceMsg, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public void openUinPCActive(String paramString1, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openUinPCActive by ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" opened: ");
    localStringBuilder.append(paramBoolean);
    QLog.d("msfCore", 1, localStringBuilder.toString());
    this.pushManager.q().a(paramString1, paramBoolean);
  }
  
  public void proxyRegister(z paramz, ToServiceMsg paramToServiceMsg)
  {
    this.pushManager.a(paramz, paramToServiceMsg);
  }
  
  public void proxyUnRegister(String paramString, ToServiceMsg paramToServiceMsg)
  {
    this.pushManager.a(paramString, paramToServiceMsg);
  }
  
  public void reSendMsg(ToServiceMsg paramToServiceMsg)
  {
    this.sender.b(paramToServiceMsg);
  }
  
  public int refreVerifycode(ToServiceMsg paramToServiceMsg)
  {
    if (isUseWtlogin()) {
      return this.wtLoginCenter.d(paramToServiceMsg);
    }
    return this.accountCenter.b(paramToServiceMsg);
  }
  
  public void refreshDA2(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.r(paramToServiceMsg);
  }
  
  public void refreshWebviewTickets(String paramString1, String paramString2)
  {
    paramString1 = new ToServiceMsg("", paramString1, "login.chgTok_WEBVIEW_KEY");
    paramString1.setMsfCommand(MsfCommand._msf_refreToken);
    paramString1.setRequestSsoSeq(getNextSeq());
    paramString1.setAppId(getMsfAppid());
    paramString1.setTimeout(30000L);
    paramString1.getAttributes().put("refresh_token_src", paramString2);
    changeTokenAfterLogin(paramString1, true);
  }
  
  public void registerCmdCall(ToServiceMsg paramToServiceMsg)
  {
    CommandCallbackerInfo localCommandCallbackerInfo = aa.a(paramToServiceMsg);
    this.pushManager.a(localCommandCallbackerInfo, paramToServiceMsg);
  }
  
  public void registerPush(ToServiceMsg paramToServiceMsg, RegPushReason paramRegPushReason)
  {
    if ((this.accountCenter != null) && (!TextUtils.isEmpty(paramToServiceMsg.getUin()))) {
      this.accountCenter.c(paramToServiceMsg.getUin(), "regPush");
    }
    this.pushManager.a(paramToServiceMsg, paramRegPushReason);
  }
  
  public int report(ToServiceMsg paramToServiceMsg)
  {
    return this.configManager.b(paramToServiceMsg);
  }
  
  public void reportDeadObjException(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    j localj = this.statReporter;
    if (localj != null) {
      localj.a(paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void reportRDM(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    j localj = this.statReporter;
    if (localj != null) {
      localj.a(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
    }
  }
  
  public void resume()
  {
    this.suspended.set(false);
  }
  
  public void screenOn()
  {
    com.tencent.mobileqq.msf.core.net.c.a locala = this.mDeepSleepDetector;
    if (locala != null) {
      locala.a();
    }
  }
  
  public void sendMsgSignal()
  {
    ad localad = this.sender;
    if (localad != null) {
      localad.r();
    }
  }
  
  public int sendSsoMsg(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    this.sender.b(paramToServiceMsg);
    com.tencent.mobileqq.a.a.a.a().a(paramToServiceMsg, false);
    try
    {
      if ("MessageSvc.PbSendMsg".equals(paramToServiceMsg.getServiceCmd()))
      {
        aj.b(this, paramToServiceMsg);
        com.tencent.mobileqq.a.a.a.a().b(paramToServiceMsg);
      }
      else if ("RegPrxySvc.infoSync".equals(paramToServiceMsg.getServiceCmd()))
      {
        aj.a(this, paramToServiceMsg);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return paramToServiceMsg.getRequestSsoSeq();
  }
  
  public void setDelayIpRace(long paramLong)
  {
    long l;
    if (paramLong >= -1000L)
    {
      l = paramLong;
      if (paramLong <= 1000L) {}
    }
    else
    {
      l = 100L;
    }
    this.delayIpRace.set(l);
    BaseApplication.getContext().getSharedPreferences("sp_msf_common", 0).edit().putLong("delay_ap_race", l).apply();
  }
  
  public void setMsfAppid(int paramInt)
  {
    this.msfAppid = paramInt;
  }
  
  public void setMsfMonitorCallback(MsfMonitorCallback paramMsfMonitorCallback)
  {
    this.mMsfMonitorCallback = paramMsfMonitorCallback;
  }
  
  public void startPCActivePolling(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPCActivePolling by ");
    localStringBuilder.append(paramString2);
    QLog.d("msfCore", 1, localStringBuilder.toString());
    try
    {
      v.a().a(true);
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("msfCore", 2, "startPCActivePolling", localThrowable);
      }
    }
    this.pushManager.q().a(paramString1);
    if (this.statReporter != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", paramString1);
      localHashMap.put("src", String.valueOf(paramString2));
      this.statReporter.a("dim_Msf_PCActiveStartEvent", true, 0L, 0L, localHashMap, false, false);
      return;
    }
    QLog.d("msfCore", 1, "stop try report startPCActivePolling by reporter null");
  }
  
  public void stopPCActivePolling(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopPCActivePolling by ");
    localStringBuilder.append(paramString);
    QLog.d("msfCore", 1, localStringBuilder.toString());
    try
    {
      v.a().a(false);
    }
    catch (Throwable paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("msfCore", 2, "stopPCActivePolling", paramString);
      }
    }
    this.pushManager.q().a();
  }
  
  public int submitPuzzleVerifyCodeTicket(ToServiceMsg paramToServiceMsg)
  {
    if (isUseWtlogin()) {
      return this.wtLoginCenter.f(paramToServiceMsg);
    }
    return -1;
  }
  
  public int submitVerifycode(ToServiceMsg paramToServiceMsg)
  {
    if (isUseWtlogin()) {
      return this.wtLoginCenter.e(paramToServiceMsg);
    }
    return this.accountCenter.a(paramToServiceMsg);
  }
  
  public void suspend()
  {
    this.suspended.set(true);
  }
  
  public boolean syncDelAccount(ToServiceMsg paramToServiceMsg)
  {
    QLog.d("MSF.C.MsfCore", 1, "syncDelAccount");
    String str = (String)paramToServiceMsg.getAttribute(paramToServiceMsg.getServiceCmd());
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("alias");
    this.accountCenter.a(str, paramToServiceMsg);
    return true;
  }
  
  public ArrayList syncGetLoginedAccountList()
  {
    return this.accountCenter.d();
  }
  
  public String syncGetServerConfig(ToServiceMsg paramToServiceMsg)
  {
    return this.configManager.c(paramToServiceMsg);
  }
  
  public void unRegisterCmdCall(ToServiceMsg paramToServiceMsg)
  {
    CommandCallbackerInfo localCommandCallbackerInfo = aa.a(paramToServiceMsg);
    this.pushManager.b(localCommandCallbackerInfo, paramToServiceMsg);
  }
  
  public void unRegisterPush(ToServiceMsg paramToServiceMsg)
  {
    PushRegisterInfo localPushRegisterInfo = aa.b(paramToServiceMsg);
    this.pushManager.a(localPushRegisterInfo, paramToServiceMsg);
    if ((this.accountCenter != null) && (!TextUtils.isEmpty(paramToServiceMsg.getUin())) && (this.accountCenter.i().equals(paramToServiceMsg.getUin()))) {
      this.accountCenter.c("0", "unRegPush");
    }
  }
  
  public void updateBatteryStatus(ToServiceMsg paramToServiceMsg)
  {
    this.pushManager.a(paramToServiceMsg);
  }
  
  public void verifyPasswd(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.c(paramToServiceMsg);
  }
  
  public void verifyPasswdImage(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.a(paramToServiceMsg);
  }
  
  public void verifyPasswdRefreshImage(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.b(paramToServiceMsg);
  }
  
  public void wt_AskDevLockSms(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.z(paramToServiceMsg);
  }
  
  public void wt_CancelCode(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.w(paramToServiceMsg);
  }
  
  public void wt_CheckDevLockSms(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.A(paramToServiceMsg);
  }
  
  public void wt_CheckDevLockStatus(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.y(paramToServiceMsg);
  }
  
  public void wt_CheckPictureAndGetSt(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.s(paramToServiceMsg);
  }
  
  public void wt_CheckSMSAndGetSt(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.F(paramToServiceMsg);
  }
  
  public void wt_CheckSMSAndGetStExt(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.G(paramToServiceMsg);
  }
  
  public void wt_CheckSMSVerifyLoginAccount(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.I(paramToServiceMsg);
  }
  
  public void wt_CloseCode(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.v(paramToServiceMsg);
  }
  
  public void wt_CloseDevLock(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.B(paramToServiceMsg);
  }
  
  public void wt_GetA1WithA1(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.x(paramToServiceMsg);
  }
  
  public void wt_GetOpenKeyWithoutPasswd(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.p(paramToServiceMsg);
  }
  
  public void wt_GetStViaSMSVerifyLogin(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.M(paramToServiceMsg);
  }
  
  public void wt_GetStWithPasswd(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.o(paramToServiceMsg);
  }
  
  public void wt_GetStWithoutPasswd(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.q(paramToServiceMsg);
  }
  
  public void wt_QuickLoginByGateway(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.L(paramToServiceMsg);
  }
  
  public void wt_RefreshPictureData(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.t(paramToServiceMsg);
  }
  
  public void wt_RefreshSMSData(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.E(paramToServiceMsg);
  }
  
  public void wt_RefreshSMSVerifyLoginCode(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.J(paramToServiceMsg);
  }
  
  public void wt_RegGetSMSVerifyLoginAccount(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.H(paramToServiceMsg);
  }
  
  public void wt_SetDevlockMobileType(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.D(paramToServiceMsg);
  }
  
  public void wt_VerifyCode(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.u(paramToServiceMsg);
  }
  
  public void wt_VerifySMSVerifyLoginCode(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.K(paramToServiceMsg);
  }
  
  public void wt_setRegDevLockFlag(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.C(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.MsfCore
 * JD-Core Version:    0.7.0.1
 */