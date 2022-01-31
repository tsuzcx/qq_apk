package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.auth.d;
import com.tencent.mobileqq.msf.core.auth.l;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.push.RegPushReason;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.x;
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
  public static final String KEY_MOBILEQQAPPID = "key_mobileQQAppid";
  public static final String MOBILEQQSDROOT_PATH = Environment.getExternalStorageDirectory().getPath() + "/tencent";
  private static final String OLDKSID_PATH = Environment.getExternalStorageDirectory().getPath() + "/msf";
  private static final String ONLINE_STATUS;
  private static final String SAVEPATH_IMEI = BaseApplication.getContext().getFilesDir() + "/imei";
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
  public f lightSender;
  public g lightTcpSender;
  private com.tencent.mobileqq.msf.core.net.c.a mDeepSleepDetector;
  public int mLocaleId;
  public MsfMonitorCallback mMsfMonitorCallback = null;
  public AtomicBoolean mbIsInfoLoginGetted = new AtomicBoolean();
  r msfAlarmer;
  private int msfAppid = -1;
  private MsfExitReceiver msfExitReceiver;
  LinkedBlockingQueue msfMessagePairs = new LinkedBlockingQueue();
  public com.tencent.mobileqq.msf.core.c.b mtaReporter;
  public NetConnInfoCenter netConnICenter;
  public com.tencent.mobileqq.msf.core.c.e netFlowStore;
  public volatile String nowSocketConnAdd;
  public com.tencent.mobileqq.msf.core.push.g pushManager;
  public com.tencent.mobileqq.msf.core.quicksend.b quicksender;
  public ag sender;
  com.tencent.mobileqq.msf.core.a.c ssoListManager;
  private ah ssoRespHandler;
  com.tencent.mobileqq.msf.core.d.a standbyModeManager;
  public k statReporter;
  MsfStore store;
  AtomicBoolean suspended = new AtomicBoolean(false);
  public SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.getDefault());
  private l wtLoginCenter;
  
  static
  {
    ONLINE_STATUS = BaseApplication.getContext().getFilesDir() + "/onlinestatus";
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
    com.tencent.mobileqq.msf.service.e.a("*", null, localFromServiceMsg);
  }
  
  private void initLocaleId()
  {
    try
    {
      this.mLocaleId = SettingCloneUtil.readValueForInt(BaseApplication.getContext(), null, null, "qqsetting_locale_id", 0);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.MsfCore", 2, "initLocaleId, sLocaleId = " + this.mLocaleId);
      }
      return;
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
    long l1;
    long l2;
    long l3;
    String str3;
    if (paramToServiceMsg != null) {
      if (paramFromServiceMsg.isSuccess())
      {
        if ((paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) || (paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth) || (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin))
        {
          l1 = System.currentTimeMillis();
          l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
          l3 = k.a(paramToServiceMsg, paramFromServiceMsg);
          String str1 = "0";
          str3 = "0";
          if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
            str1 = (String)paramToServiceMsg.getAttribute("_tag_socket");
          }
          if (paramToServiceMsg.getAttributes().containsKey("_tag_localsocket")) {
            str3 = (String)paramToServiceMsg.getAttribute("_tag_localsocket");
          }
          if (getStatReporter() != null) {
            getStatReporter().a(true, l1 - l2, paramFromServiceMsg.getBusinessFailCode(), l3, str1, str3, paramFromServiceMsg.getServiceCmd().equals("login.chguin"), 0L);
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
      else
      {
        if (paramFromServiceMsg.getResultCode() != 1012) {
          break label510;
        }
        try
        {
          if (paramToServiceMsg.getAttribute("to_login_alsoCheckTime") == null)
          {
            paramToServiceMsg.addAttribute("to_login_alsoCheckTime", Integer.valueOf(1));
            if (paramToServiceMsg.getMsfCommand() != MsfCommand.changeUinLogin) {
              break label477;
            }
            ChangeUinLogin(paramToServiceMsg);
          }
        }
        catch (Exception localException)
        {
          QLog.d("MSF.C.MsfCore", 1, "addRespToQuque process code client time error failed " + localException.toString());
        }
      }
    }
    for (;;)
    {
      String str2;
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
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
        if (com.tencent.mobileqq.msf.core.a.a.x()) {
          paramToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
        }
      }
      paramFromServiceMsg.addAttribute("__timestamp_msf2app", Long.valueOf(System.currentTimeMillis()));
      this.msfMessagePairs.add(new MsfMessagePair(paramString, paramToServiceMsg, paramFromServiceMsg));
      return;
      label477:
      if (paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth)
      {
        login(paramToServiceMsg);
        return;
      }
      if (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin)
      {
        wt_GetStViaSMSVerifyLogin(paramToServiceMsg);
        return;
        label510:
        if ((paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) && (paramToServiceMsg.getAttributes().containsKey("__timestamp_app2msf")))
        {
          l1 = -1L;
          if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
            l1 = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
          }
          l3 = k.a(paramToServiceMsg, paramFromServiceMsg);
          str2 = "0";
          str3 = "0";
          if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
            str2 = (String)paramToServiceMsg.getAttribute("_tag_socket");
          }
          if (paramToServiceMsg.getAttributes().containsKey("_tag_localsocket")) {
            str3 = (String)paramToServiceMsg.getAttribute("_tag_localsocket");
          }
          boolean bool = paramFromServiceMsg.getServiceCmd().equals("login.chguin");
          if (paramFromServiceMsg.getBusinessFailCode() == 1002)
          {
            l2 = 0L;
            if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net"))
            {
              if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
                l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue() - ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
              }
              if (getStatReporter() != null) {
                getStatReporter().a(false, l1, 1014, l3, str2, str3, bool, l2);
              }
            }
            else if (getStatReporter() != null)
            {
              getStatReporter().a(false, l1, paramFromServiceMsg.getBusinessFailCode(), l3, str2, str3, bool, 0L);
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
            getStatReporter().a(true, l1, paramFromServiceMsg.getBusinessFailCode(), l3, str2, str3, bool, 0L);
          }
        }
      }
    }
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
    String str = null;
    if (this.accountCenter != null) {
      str = this.accountCenter.i();
    }
    return str;
  }
  
  public r getMsfAlarmer()
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
  
  public com.tencent.mobileqq.msf.core.c.e getNetFlowStore()
  {
    return this.netFlowStore;
  }
  
  public HandlerThread getNetworkHandlerThread()
  {
    return u.c();
  }
  
  public void getPluginConfig(ToServiceMsg paramToServiceMsg)
  {
    this.configManager.a(paramToServiceMsg);
  }
  
  public com.tencent.mobileqq.msf.core.a.c getSsoListManager()
  {
    return this.ssoListManager;
  }
  
  public ah getSsoRespHandler()
  {
    return this.ssoRespHandler;
  }
  
  public com.tencent.mobileqq.msf.core.d.a getStandyModeManager()
  {
    return this.standbyModeManager;
  }
  
  public k getStatReporter()
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
    int i;
    int j;
    int k;
    if (paramToServiceMsg != null)
    {
      paramContext = new String[paramToServiceMsg.length];
      i = 0;
      while (i < paramContext.length)
      {
        paramContext[i] = MD5.toMD5(paramToServiceMsg[i].toCharsString()).toLowerCase();
        i += 1;
      }
      paramToServiceMsg = com.tencent.mobileqq.msf.core.auth.c.a(BaseApplication.getContext().getPackageManager(), paramInt);
      if (paramToServiceMsg == null) {
        break label189;
      }
      j = 0;
      paramInt = 0;
      i = paramInt;
      if (j < paramToServiceMsg.length)
      {
        String str = MD5.toMD5(paramToServiceMsg[j].toCharsString()).toLowerCase();
        int m = paramContext.length;
        k = 0;
        label121:
        i = paramInt;
        if (k < m)
        {
          if (!paramContext[k].equals(str)) {
            break label164;
          }
          i = 1;
        }
        if (i == 0) {
          break label173;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return this.accountCenter.h();
        label164:
        k += 1;
        break label121;
        label173:
        j += 1;
        paramInt = i;
        break;
      }
      return "";
      label189:
      i = 0;
    }
  }
  
  public boolean init(Context paramContext, boolean paramBoolean)
  {
    QLog.d("MSF.C.MsfCore", 1, "MsfCore init begin. isPublic=true isGray=false");
    long l1 = SystemClock.elapsedRealtime();
    sCore = this;
    this.mbIsInfoLoginGetted.set(false);
    k localk = new k(this);
    localk.e();
    QLog.d("MSF.C.MsfCore", 1, "init RQD cost=" + (SystemClock.elapsedRealtime() - l1));
    long l2 = SystemClock.elapsedRealtime();
    boolean bool1 = false;
    int k = -1;
    int i = -1;
    int j;
    try
    {
      j = c.g(paramContext);
      i = j;
      int m = c.e(paramContext);
      i = m;
      if ((j == -1) || (i == -1) || (i != j)) {
        bool1 = true;
      }
      k = j;
      j = i;
    }
    catch (Exception localException2)
    {
      try
      {
        File localFile = new File(MOBILEQQSDROOT_PATH);
        if (localFile.exists()) {
          break label222;
        }
        localFile.mkdirs();
        localFile = new File(OLDKSID_PATH);
        if ((!localFile.exists()) || (!localFile.isDirectory())) {
          break label256;
        }
        localFile.delete();
        QLog.i("MSF.C.MsfCore", 1, "check copysolib platform=" + c.c(paramContext) + " installAppVersionCode=" + j + " isNewVersion=" + bool1);
        bool2 = "x86".equals(c.c(paramContext));
        if (!bool2) {
          break label555;
        }
      }
      catch (Exception localException2)
      {
        try
        {
          boolean bool2;
          c.a(paramContext, c.c(paramContext), bool1, j, new String[] { "libcodecwrapperV2.so", "libmsfbootV2.so", "libNativeRQD.so", "libwtecdh.so" });
          for (;;)
          {
            QLog.d("MSF.C.MsfCore", 1, "init copySo cost=" + (SystemClock.elapsedRealtime() - l2));
            l2 = SystemClock.elapsedRealtime();
            if ((bool1) && (!bool2)) {}
            QLog.d("MSF.C.MsfCore", 1, "init removeSo cost=" + (SystemClock.elapsedRealtime() - l2));
            l2 = SystemClock.elapsedRealtime();
            try
            {
              this.store = new MsfStore();
              if (this.store.init(paramContext)) {
                break label652;
              }
              QLog.e("MSF.C.MsfCore", 1, "MsfStore init fail");
              return false;
            }
            catch (Exception paramContext)
            {
              QLog.e("MSF.C.MsfCore", 1, "MsfStore init error " + paramContext);
              return false;
            }
            localException1 = localException1;
            QLog.e("MSF.C.MsfCore", 1, "checkAppVersionCode error " + localException1, localException1);
            bool1 = true;
            j = k;
            k = i;
            break;
            localException2 = localException2;
            QLog.e("MSF.C.MsfCore", 1, "File operation error " + localException2);
            break label256;
            c.a(paramContext, c.c(paramContext), bool1, j, new String[] { "libcodecwrapperV2.so", "libNativeRQD.so" });
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            localException3.printStackTrace();
            QLog.d("MSF.C.MsfCore", 1, "cp txlib error " + localException3);
          }
        }
      }
    }
    com.tencent.mobileqq.msf.service.g.t = bool1;
    t.c();
    if (Build.VERSION.SDK_INT >= 26) {
      this.mDeepSleepDetector = new com.tencent.mobileqq.msf.core.net.c.a(u.f());
    }
    QLog.d("MSF.C.MsfCore", 1, "init deviceInfo cost=" + (SystemClock.elapsedRealtime() - l2));
    l2 = SystemClock.elapsedRealtime();
    label222:
    QLog.d("MSF.C.MsfCore", 1, "init msfStore cost=" + (SystemClock.elapsedRealtime() - l2));
    label256:
    label555:
    l2 = SystemClock.elapsedRealtime();
    try
    {
      label652:
      String str = MsfStore.getNativeConfigStore().getConfig("key_mobileQQAppid");
      if ((str != null) && (str.length() > 0))
      {
        mobileQQAppid = Integer.parseInt(str);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.MsfCore", 2, "load mobileQQAppid " + mobileQQAppid);
        }
      }
    }
    catch (Exception localException7)
    {
      try
      {
        this.msfAlarmer = new r(this);
        this.msfAlarmer.a();
        QLog.d("MSF.C.MsfCore", 1, "init msfAlarm cost=" + (SystemClock.elapsedRealtime() - l2));
        l2 = SystemClock.elapsedRealtime();
      }
      catch (Exception localException7)
      {
        try
        {
          this.configManager = new com.tencent.mobileqq.msf.core.a.a(this);
          this.configManager.a();
        }
        catch (Exception localException7)
        {
          try
          {
            this.ssoListManager = new com.tencent.mobileqq.msf.core.a.c(this);
            this.ssoListManager.a();
            QLog.d("MSF.C.MsfCore", 1, "init sso&config cost=" + (SystemClock.elapsedRealtime() - l2));
            l2 = SystemClock.elapsedRealtime();
          }
          catch (Exception localException7)
          {
            try
            {
              for (;;)
              {
                this.netConnICenter = new NetConnInfoCenter();
                NetConnInfoCenter.init(this);
                QLog.d("MSF.C.MsfCore", 1, "init network center cost=" + (SystemClock.elapsedRealtime() - l2));
                l2 = SystemClock.elapsedRealtime();
                try
                {
                  this.sender = new ag(this);
                  if (this.sender.a(paramContext)) {
                    break;
                  }
                  QLog.e("MSF.C.MsfCore", 1, "Sender init fail");
                  return false;
                }
                catch (Exception paramContext)
                {
                  QLog.e("MSF.C.MsfCore", 1, "Sender init failed " + paramContext);
                  return false;
                }
                localException4 = localException4;
                QLog.e("MSF.C.MsfCore", 1, "load mobileQQAppid failed " + localException4);
                continue;
                localException5 = localException5;
                QLog.e("MSF.C.MsfCore", 1, "msfAlarmer init failed " + localException5);
                continue;
                localException6 = localException6;
                QLog.e("MSF.C.MsfCore", 1, "configManager init failed " + localException6);
              }
              localException7 = localException7;
              QLog.e("MSF.C.MsfCore", 1, "SsoListManager init failed " + localException7);
            }
            catch (Exception localException8)
            {
              for (;;)
              {
                QLog.e("MSF.C.MsfCore", 1, "MsfCore init netConnInfoCenter error " + localException8, localException8);
              }
            }
          }
        }
      }
    }
    QLog.d("MSF.C.MsfCore", 1, "init nativeConfigStore cost=" + (SystemClock.elapsedRealtime() - l2));
    l2 = SystemClock.elapsedRealtime();
    this.wtLoginCenter = new l();
    this.wtLoginCenter.a(this);
    QLog.d("MSF.C.MsfCore", 1, "init wtlogin cost=" + (SystemClock.elapsedRealtime() - l2));
    l2 = SystemClock.elapsedRealtime();
    this.accountCenter = new com.tencent.mobileqq.msf.core.auth.b(this);
    this.accountCenter.a(true);
    QLog.d("MSF.C.MsfCore", 2, "init accountCenter cost=" + (SystemClock.elapsedRealtime() - l2));
    l2 = SystemClock.elapsedRealtime();
    this.ssoRespHandler = new ah(this);
    try
    {
      this.lightSender = new f(this, paramContext);
      if (com.tencent.mobileqq.msf.core.quicksend.b.f()) {
        this.lightTcpSender = new g(this, paramContext);
      }
      this.accountCenter.a();
      QLog.d("MSF.C.MsfCore", 1, "init sender&light cost=" + (SystemClock.elapsedRealtime() - l2));
      l2 = SystemClock.elapsedRealtime();
    }
    catch (Exception paramContext)
    {
      try
      {
        this.pushManager = new com.tencent.mobileqq.msf.core.push.g(this);
        this.pushManager.a(paramContext, paramBoolean);
        if (!bool1) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          this.configManager.a("0", 60000);
          QLog.d("MSF.C.MsfCore", 1, "init push cost=" + (SystemClock.elapsedRealtime() - l2));
          l2 = SystemClock.elapsedRealtime();
          this.standbyModeManager = new com.tencent.mobileqq.msf.core.d.a(this);
          this.msfExitReceiver = new MsfExitReceiver();
        }
        catch (Exception paramContext)
        {
          try
          {
            do
            {
              for (;;)
              {
                this.quicksender = new com.tencent.mobileqq.msf.core.quicksend.b(this);
                this.accountCenter.g.b();
                QLog.d("MSF.C.MsfCore", 1, "init standby&quickSender cost=" + (SystemClock.elapsedRealtime() - l2));
                SystemClock.elapsedRealtime();
                new s(this, localk, bool1, j, k).start();
                this.coreInitFinished.set(true);
                initLocaleId();
                QLog.d("MSF.C.MsfCore", 1, "MsfCore init finished. cost=" + (SystemClock.elapsedRealtime() - l1));
                return true;
                localException9 = localException9;
                QLog.e("MSF.C.MsfCore", 1, "LightSender init failed " + localException9);
                continue;
                paramContext = paramContext;
                QLog.e("MSF.C.MsfCore", 1, "PushManager init failed " + paramContext);
              }
              paramContext = paramContext;
            } while (!QLog.isColorLevel());
            QLog.d("MSF.C.MsfCore", 2, paramContext.toString(), paramContext);
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              QLog.d("MSF.C.MsfCore", 1, paramContext.toString(), paramContext);
            }
          }
        }
      }
    }
  }
  
  public boolean isOffline()
  {
    if (this.accountCenter != null) {
      return "0".equals(this.accountCenter.i());
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
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.MsfCore", 2, "recv " + paramToServiceMsg.getUin() + " login req");
    }
    paramToServiceMsg.getAttributes().put("grayCheck", Boolean.valueOf(true));
    if (isUseWtlogin()) {
      return this.wtLoginCenter.a(paramToServiceMsg, false);
    }
    return this.accountCenter.a(paramToServiceMsg, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public void openUinPCActive(String paramString1, String paramString2, boolean paramBoolean)
  {
    QLog.d("msfCore", 1, "openUinPCActive by " + paramString2 + " opened: " + paramBoolean);
    this.pushManager.s().a(paramString1, paramBoolean);
  }
  
  public void proxyRegister(x paramx, ToServiceMsg paramToServiceMsg)
  {
    this.pushManager.a(paramx, paramToServiceMsg);
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
    CommandCallbackerInfo localCommandCallbackerInfo = com.tencent.mobileqq.msf.sdk.y.a(paramToServiceMsg);
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
    if (this.statReporter != null) {
      this.statReporter.a(paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void reportRDM(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.statReporter != null) {
      this.statReporter.a(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
    }
  }
  
  public void resume()
  {
    this.suspended.set(false);
  }
  
  public void screenOn()
  {
    if (this.mDeepSleepDetector != null) {
      this.mDeepSleepDetector.a();
    }
  }
  
  public void sendMsgSignal()
  {
    if (this.sender != null) {
      this.sender.p();
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
        ak.b(this, paramToServiceMsg);
        com.tencent.mobileqq.a.a.a.a().b(paramToServiceMsg);
      }
      for (;;)
      {
        return paramToServiceMsg.getRequestSsoSeq();
        if ("RegPrxySvc.infoSync".equals(paramToServiceMsg.getServiceCmd())) {
          ak.a(this, paramToServiceMsg);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
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
    QLog.d("msfCore", 1, "startPCActivePolling by " + paramString2);
    try
    {
      y.a().a(true);
      this.pushManager.s().a(paramString1);
      if (this.statReporter != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("uin", paramString1);
        localHashMap.put("src", String.valueOf(paramString2));
        this.statReporter.a("dim.Msf.PCActiveStartEvent", true, 0L, 0L, localHashMap, false, false);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("msfCore", 2, "startPCActivePolling", localThrowable);
        }
      }
      QLog.d("msfCore", 1, "stop try report startPCActivePolling by reporter null");
    }
  }
  
  public void stopPCActivePolling(String paramString)
  {
    QLog.d("msfCore", 1, "stopPCActivePolling by " + paramString);
    try
    {
      y.a().a(false);
      this.pushManager.s().a();
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("msfCore", 2, "stopPCActivePolling", paramString);
        }
      }
    }
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
    CommandCallbackerInfo localCommandCallbackerInfo = com.tencent.mobileqq.msf.sdk.y.a(paramToServiceMsg);
    this.pushManager.b(localCommandCallbackerInfo, paramToServiceMsg);
  }
  
  public void unRegisterPush(ToServiceMsg paramToServiceMsg)
  {
    PushRegisterInfo localPushRegisterInfo = com.tencent.mobileqq.msf.sdk.y.b(paramToServiceMsg);
    this.pushManager.a(localPushRegisterInfo, paramToServiceMsg);
    if ((this.accountCenter != null) && (!TextUtils.isEmpty(paramToServiceMsg.getUin())) && (this.accountCenter.i().equals(paramToServiceMsg.getUin()))) {
      this.accountCenter.c("0", "unRegPush");
    }
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
    this.wtLoginCenter.L(paramToServiceMsg);
  }
  
  public void wt_GetStWithPasswd(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.o(paramToServiceMsg);
  }
  
  public void wt_GetStWithoutPasswd(ToServiceMsg paramToServiceMsg)
  {
    this.wtLoginCenter.q(paramToServiceMsg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.MsfCore
 * JD-Core Version:    0.7.0.1
 */