package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.msf.core.auth.m;
import com.tencent.mobileqq.msf.sdk.handler.IErrorHandler;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.mobileqq.msf.sdk.utils.b;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;

public class MsfServiceSdk
  extends u
{
  static final String ServiceName = "com.tencent.mobileqq.msf.service.MsfService";
  static boolean isMainProcess = false;
  public static boolean isUseNewProxy = false;
  private static Object netImplRef;
  private static Field sDetailMessageField;
  private static MsfServiceSdk sdk = null;
  private static final String tag = "MsfServiceSdk";
  private final BroadcastReceiver msfServiceListener = new t(this);
  private IMsfProxy proxy;
  
  static
  {
    isUseNewProxy = false;
    netImplRef = null;
  }
  
  private void beforeSend(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.setAppId(this.appid);
    paramToServiceMsg.setTimeout(30000L);
    MsfSdkUtils.addToMsgProcessName(this.processName, paramToServiceMsg);
  }
  
  public static MsfServiceSdk get()
  {
    if (sdk == null) {}
    try
    {
      if (sdk == null)
      {
        testRandomProxy();
        MsfServiceSdk localMsfServiceSdk = new MsfServiceSdk();
        if (BaseApplication.getContext().getPackageName().equals(BaseApplication.processName)) {
          isMainProcess = true;
        }
        localMsfServiceSdk.proxy = h.a("com.tencent.mobileqq.msf.service.MsfService", isUseNewProxy);
        localMsfServiceSdk.proxy.init(localMsfServiceSdk);
        localMsfServiceSdk.appid = 88886666;
        netImplRef = AppNetConnInfo.getImpl();
        sdk = localMsfServiceSdk;
      }
      return sdk;
    }
    finally {}
  }
  
  private void registerServiceListener()
  {
    if (isMainProcess)
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.msf.ACTION_MSF_IPC_EXCEPTION");
      BaseApplication.getContext().registerReceiver(this.msfServiceListener, localIntentFilter);
      if (QLog.isColorLevel()) {
        QLog.d("MsfServiceSdk", 2, "register listener for IPC exception");
      }
    }
  }
  
  public static void reportStartServiceException(Class paramClass, Intent paramIntent, Throwable paramThrowable)
  {
    if ((paramClass == null) || (paramIntent == null) || (paramThrowable == null)) {
      return;
    }
    paramClass = new StringBuilder("StartServiceException");
    paramClass.append(" ");
    String str = paramIntent.getAction();
    if (!TextUtils.isEmpty(str)) {
      paramClass.append("Act:").append(str);
    }
    for (;;)
    {
      try
      {
        if (sDetailMessageField == null)
        {
          sDetailMessageField = Throwable.class.getDeclaredField("detailMessage");
          sDetailMessageField.setAccessible(true);
        }
        sDetailMessageField.set(paramThrowable, "StartServiceException" + " : " + paramThrowable.getMessage());
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MsfServiceSdk", 2, "StartServiceException failed : ", paramIntent);
        continue;
      }
      CrashReport.handleCatchException(Thread.currentThread(), paramThrowable, paramClass.toString(), null);
      return;
      paramIntent = paramIntent.getComponent();
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getClassName();
        paramClass.append("Clazz:").append(paramIntent);
      }
      else
      {
        paramClass.append("Intent:valid");
      }
    }
  }
  
  /* Error */
  private static void testRandomProxy()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 148	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   9: getstatic 237	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   12: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 239
    //   17: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 242	android/os/Build:MODEL	Ljava/lang/String;
    //   23: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokevirtual 245	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore 4
    //   34: ldc 247
    //   36: invokestatic 89	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   39: invokestatic 253	com/tencent/mobileqq/msf/core/c:c	(Landroid/content/Context;)Ljava/lang/String;
    //   42: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq +142 -> 187
    //   48: invokestatic 89	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   51: ldc 255
    //   53: iconst_4
    //   54: invokevirtual 259	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   57: astore_3
    //   58: aload_3
    //   59: ifnull +128 -> 187
    //   62: aload_3
    //   63: ldc_w 261
    //   66: iconst_m1
    //   67: invokeinterface 267 3 0
    //   72: istore_1
    //   73: iload_1
    //   74: istore_0
    //   75: iload_1
    //   76: iconst_m1
    //   77: if_icmpne +39 -> 116
    //   80: new 269	java/util/Random
    //   83: dup
    //   84: invokespecial 270	java/util/Random:<init>	()V
    //   87: bipush 100
    //   89: invokevirtual 274	java/util/Random:nextInt	(I)I
    //   92: istore_0
    //   93: iload_0
    //   94: istore_1
    //   95: aload_3
    //   96: invokeinterface 278 1 0
    //   101: ldc_w 261
    //   104: iload_0
    //   105: invokeinterface 284 3 0
    //   110: invokeinterface 287 1 0
    //   115: pop
    //   116: iload_0
    //   117: iconst_1
    //   118: if_icmpge +5 -> 123
    //   121: iconst_1
    //   122: istore_2
    //   123: iload_2
    //   124: putstatic 31	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:isUseNewProxy	Z
    //   127: ldc 21
    //   129: iconst_1
    //   130: new 148	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   137: aload 4
    //   139: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 289
    //   145: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: getstatic 31	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:isUseNewProxy	Z
    //   151: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   154: ldc_w 294
    //   157: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload_0
    //   161: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 300	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: return
    //   171: astore_3
    //   172: iconst_0
    //   173: istore_0
    //   174: aload_3
    //   175: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   178: goto -62 -> 116
    //   181: astore_3
    //   182: iload_1
    //   183: istore_0
    //   184: goto -10 -> 174
    //   187: iconst_0
    //   188: istore_0
    //   189: goto -73 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   74	115	0	i	int
    //   72	111	1	j	int
    //   1	123	2	bool	boolean
    //   57	39	3	localSharedPreferences	android.content.SharedPreferences
    //   171	4	3	localException1	Exception
    //   181	1	3	localException2	Exception
    //   32	106	4	str	String
    // Exception table:
    //   from	to	target	type
    //   34	58	171	java/lang/Exception
    //   62	73	171	java/lang/Exception
    //   80	93	181	java/lang/Exception
    //   95	116	181	java/lang/Exception
  }
  
  private void unregisterServiceListener()
  {
    if (isMainProcess) {}
    try
    {
      BaseApplication.getContext().unregisterReceiver(this.msfServiceListener);
      if (QLog.isColorLevel()) {
        QLog.d("MsfServiceSdk", 2, "unregister listener for IPC exception");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public ToServiceMsg checkQuickRegisterAccount(String paramString1, int paramInt, byte paramByte, String paramString2)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "wtlogin.trans_emp");
    paramString1.setMsfCommand(MsfCommand.quick_register_checkAccount);
    paramString1.setAppId(paramInt);
    paramString1.getAttributes().put("to_register_cr_language", Byte.valueOf(paramByte));
    paramString1.getAttributes().put("to_register_cr_appVersion", paramString2);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getA1WithA1(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    paramString.setMsfCommand(MsfCommand.wt_GetA1WithA1);
    paramString.getAttributes().put("dwSrcAppid", Long.valueOf(16L));
    paramString.getAttributes().put("dwSubSrcAppid", Long.valueOf(16L));
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getChangeTokenAfterLoginMsg(String paramString, int paramInt, HashMap paramHashMap)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.chgTok");
    paramString.setMsfCommand(MsfCommand.changeToken);
    paramString.getAttributes().put("to_login_token_cmdhead", Integer.valueOf(paramInt));
    paramString.getAttributes().put("to_login_token_map", paramHashMap);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getChangeUinAndLoginMsg(String paramString, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.changeUinLogin);
    localToServiceMsg.getAttributes().put("to_login_pwd", paramArrayOfByte);
    localToServiceMsg.getAttributes().put("to_login_changeuin", paramString);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getCheckMsfConErroMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "Check_msf_conErro");
    localToServiceMsg.setMsfCommand(MsfCommand.check_msf_conErro);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getCheckSMSAndGetStMsg(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new ToServiceMsg(this.msfServiceName, paramString, "cmd_appUseWtLogin");
    paramString.setMsfCommand(MsfCommand.wt_CheckSMSAndGetSt);
    paramString.getAttributes().put("userInput", paramArrayOfByte);
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public int getConnectedIPFamily()
  {
    return this.proxy.getMsfConnectedIPFamily();
  }
  
  public int getConnectedNetowrkType()
  {
    return this.proxy.getMsfConnectedNetType();
  }
  
  public ToServiceMsg getDataFlowMsg(String paramString, b paramb)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "socketnetflow");
    localToServiceMsg.setMsfCommand(MsfCommand.reportSocket);
    localToServiceMsg.extraData.putString("processName", paramString);
    localToServiceMsg.extraData.putString("ip", paramb.b);
    localToServiceMsg.extraData.putString("refer", paramb.c);
    localToServiceMsg.extraData.putInt("port", paramb.d);
    localToServiceMsg.extraData.putInt("flag", paramb.e);
    localToServiceMsg.extraData.putLong("buffersize", paramb.f);
    localToServiceMsg.extraData.putInt("networktype", paramb.g);
    localToServiceMsg.extraData.putString("mType", paramb.h);
    localToServiceMsg.extraData.putByte("status", paramb.i);
    localToServiceMsg.extraData.putLong("updatetime", paramb.k);
    localToServiceMsg.setNeedCallback(false);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getDelLoginedAccount(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "cmd_DelLoginedAccount");
    paramString1.setMsfCommand(MsfCommand.delLoginedAccount);
    paramString1.getAttributes().put(paramString1.getServiceCmd(), paramString2);
    paramString1.getAttributes().put("delAlias", paramString3);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public String getDeviceToken(String paramString)
  {
    return m.a(paramString);
  }
  
  public ToServiceMsg getKeyMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "MSF.getKey");
    paramString.setMsfCommand(MsfCommand.getKey);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getLoginMsg(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    paramString.setMsfCommand(MsfCommand.loginAuth);
    paramString.getAttributes().put("to_login_pwd", paramArrayOfByte);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getLoginWithoutPasswdMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.auth");
    paramString.setMsfCommand(MsfCommand.wt_GetStWithoutPasswd);
    paramString.getAttributes().put("dwSrcAppid", Long.valueOf(16L));
    paramString.getAttributes().put("dwDstAppid", Long.valueOf(16L));
    beforeSend(paramString);
    return paramString;
  }
  
  public String getMsfServiceName()
  {
    return "com.tencent.mobileqq.msf.service.MsfService";
  }
  
  public ToServiceMsg getPluginConfigMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "ResourceConfig.ClientReq");
    paramString.setMsfCommand(MsfCommand.getPluginConfig);
    beforeSend(paramString);
    QLog.d("Config", 1, "getPluginConfigMsg");
    return paramString;
  }
  
  public IMsfProxy getProxy()
  {
    return this.proxy;
  }
  
  public ToServiceMsg getQuickRegisterAccount(String paramString1, String paramString2, String paramString3, int paramInt, byte paramByte, String paramString4)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "wtlogin.trans_emp");
    paramString1.setMsfCommand(MsfCommand.quick_register_getAccount);
    paramString1.setAppId(paramInt);
    paramString1.getAttributes().put("To_register_pass", paramString2);
    paramString1.getAttributes().put("To_register_nick", paramString3);
    paramString1.getAttributes().put("to_register_cr_language", Byte.valueOf(paramByte));
    paramString1.getAttributes().put("to_register_cr_appVersion", paramString4);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getRefreVerifyCodeMsg(VerifyCodeInfo paramVerifyCodeInfo)
  {
    if (paramVerifyCodeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "getRefreVerifyCodeMsg info null!");
      }
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramVerifyCodeInfo.uin, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.refreVerifyCode);
    VerifyCodeInfo.putVerifyCodeInfo(localToServiceMsg, paramVerifyCodeInfo);
    localToServiceMsg.setRequestSsoSeq(paramVerifyCodeInfo.ssoSeq);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRefreshDevLockSmsMsg(String paramString)
  {
    paramString = new ToServiceMsg(this.msfServiceName, paramString, "cmd_appUseWtLogin");
    paramString.setMsfCommand(MsfCommand.wt_RefreshSMSData);
    paramString.getAttributes().put("smsAppid", Long.valueOf(9L));
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public ToServiceMsg getRefreshTicketsMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "cmd_refreshTickets");
    paramString.setMsfCommand(MsfCommand.refreshTickets);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getRegQueryAccountMsg(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.getAttributes().put("to_register_cr_mobile", paramString);
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_queryMobile);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCmdCallMsg(CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramCommandCallbackerInfo.uin, "push.cmdRegister");
    localToServiceMsg.setMsfCommand(MsfCommand.registerCmdCallback);
    aa.a(localToServiceMsg, paramCommandCallbackerInfo);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCommitMobileMsg(String paramString1, byte paramByte1, byte paramByte2, byte paramByte3, String paramString2, String paramString3, String paramString4, Long paramLong)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_commitMobile);
    localToServiceMsg.getAttributes().put("to_register_cr_country", Byte.valueOf(paramByte1));
    localToServiceMsg.getAttributes().put("to_register_cr_language", Byte.valueOf(paramByte2));
    localToServiceMsg.getAttributes().put("to_register_cr_pigType", Byte.valueOf(paramByte3));
    localToServiceMsg.getAttributes().put("to_register_cr_appName", paramString2);
    localToServiceMsg.getAttributes().put("to_register_cr_appVersion", paramString3);
    localToServiceMsg.getAttributes().put("to_register_cr_mobile", paramString4);
    localToServiceMsg.getAttributes().put("appid", paramLong);
    localToServiceMsg.getAttributes().put("To_register_captcha_sig", paramString1);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCommitPassMsg(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_commitPass);
    localToServiceMsg.getAttributes().put("To_register_smsCode", paramString1);
    localToServiceMsg.getAttributes().put("To_register_pass", paramString2);
    localToServiceMsg.getAttributes().put("To_register_nick", paramString3);
    localToServiceMsg.getAttributes().put("To_register_type", Boolean.valueOf(paramBoolean));
    localToServiceMsg.getAttributes().put("to_register_cr_appVersion", paramString4);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterCommitPassMsg(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, String paramString6)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_commitPass);
    localToServiceMsg.getAttributes().put("To_register_smsCode", paramString1);
    localToServiceMsg.getAttributes().put("To_register_pass", paramString2);
    localToServiceMsg.getAttributes().put("To_register_nick", paramString3);
    localToServiceMsg.getAttributes().put("To_register_type", Boolean.valueOf(paramBoolean));
    if ((paramString4 != null) && (paramString4.length() > 0)) {
      localToServiceMsg.getAttributes().put("To_register_lh_uin", paramString4);
    }
    for (;;)
    {
      localToServiceMsg.getAttributes().put("to_register_cr_appVersion", paramString6);
      beforeSend(localToServiceMsg);
      return localToServiceMsg;
      if ((paramString5 != null) && (paramString5.length() > 0)) {
        localToServiceMsg.getAttributes().put("To_register_unbind_lh_uin", paramString5);
      }
    }
  }
  
  public ToServiceMsg getRegisterCommitSmsCodeMsg(String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_commitSmsCode);
    localToServiceMsg.getAttributes().put("To_register_smsCode", paramString);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterProxyMsg(int paramInt, String paramString1, String paramString2, String paramString3, NotifyRegisterInfo paramNotifyRegisterInfo, CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "push.proxyRegister");
    paramString1.setMsfCommand(MsfCommand.proxyRegisterPush);
    z localz = new z();
    localz.a = paramInt;
    localz.b = paramString2;
    localz.c = paramString3;
    localz.d = paramNotifyRegisterInfo;
    localz.e = paramCommandCallbackerInfo;
    aa.a(paramString1, localz);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getRegisterPushMsg(PushRegisterInfo paramPushRegisterInfo)
  {
    if (paramPushRegisterInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "getRegisterPushMsg pushRegisterInfo null!");
      }
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramPushRegisterInfo.uin, "push.register");
    localToServiceMsg.setMsfCommand(MsfCommand.registerPush);
    aa.a(localToServiceMsg, paramPushRegisterInfo);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterQueryUpSmsStatMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_querySmsStat);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getRegisterSendReSendSmsMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "wtlogin.trans_emp");
    localToServiceMsg.setMsfCommand(MsfCommand.regUin_reSendSms);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getReportMsg(byte paramByte, String paramString)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "ConfigService.ClientReq");
    localToServiceMsg.setMsfCommand(MsfCommand.reportMsg);
    localToServiceMsg.getAttributes().put("to_report_type", Byte.valueOf(paramByte));
    localToServiceMsg.getAttributes().put("to_report_content", paramString);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getReportTrafficeMsg4Highway(Intent paramIntent)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "socketnetflow");
    localToServiceMsg.setMsfCommand(MsfCommand.reportSocket);
    localToServiceMsg.extraData.putString("ip", paramIntent.getStringExtra("ip"));
    localToServiceMsg.extraData.putString("processName", "com.tencent.mobileqq");
    localToServiceMsg.extraData.putString("refer", null);
    localToServiceMsg.extraData.putInt("port", paramIntent.getIntExtra("port", 0));
    localToServiceMsg.extraData.putString("mType", paramIntent.getStringExtra("mType"));
    localToServiceMsg.extraData.putInt("flag", paramIntent.getIntExtra("flag", 0));
    localToServiceMsg.extraData.putLong("buffersize", paramIntent.getLongExtra("buffersize", -1L));
    localToServiceMsg.extraData.putInt("networktype", paramIntent.getIntExtra("networktype", 1));
    localToServiceMsg.extraData.putByte("status", paramIntent.getByteExtra("status", (byte)0));
    localToServiceMsg.setNeedCallback(false);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getResetCmdCallMsg(String paramString, CommandCallbackerInfo paramCommandCallbackerInfo)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "push.resetCmds");
    paramString.setMsfCommand(MsfCommand.resetCmdCallback);
    aa.a(paramString, paramCommandCallbackerInfo);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getResumedMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "Msf.SetResume");
    localToServiceMsg.setMsfCommand(MsfCommand._setMsfResunmed);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getSendWtPkgMsg(String paramString1, long paramLong, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, paramString2);
    paramString1.setMsfCommand(MsfCommand.msf_send_wtpkg);
    beforeSend(paramString1);
    paramString1.setTimeout(paramInt);
    paramString1.getAttributes().put("wtsdkseq", Long.valueOf(paramLong));
    paramInt = paramArrayOfByte.length + 4;
    paramString2 = ByteBuffer.allocate(paramInt);
    paramString2.order(ByteOrder.BIG_ENDIAN);
    paramString2.putInt(paramInt);
    paramString2.put(paramArrayOfByte);
    paramString1.putWupBuffer(paramString2.array());
    return paramString1;
  }
  
  public ToServiceMsg getSubmitPuzzleVerifyCodeTicketMsg(String paramString, VerifyCodeInfo paramVerifyCodeInfo)
  {
    if (paramVerifyCodeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "getSubmitPuzzleVerifyCodeSigMsg info null!");
      }
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramVerifyCodeInfo.uin, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
    VerifyCodeInfo.putVerifyCodeInfo(localToServiceMsg, paramVerifyCodeInfo);
    localToServiceMsg.getAttributes().put("to_puzzle_verify_code_sig", paramString);
    localToServiceMsg.setRequestSsoSeq(paramVerifyCodeInfo.ssoSeq);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getSubmitVerifyCodeMsg(String paramString, VerifyCodeInfo paramVerifyCodeInfo)
  {
    if (paramVerifyCodeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "getSubmitVerifyCodeMsg info null!");
      }
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramVerifyCodeInfo.uin, "login.auth");
    localToServiceMsg.setMsfCommand(MsfCommand.submitVerifyCode);
    VerifyCodeInfo.putVerifyCodeInfo(localToServiceMsg, paramVerifyCodeInfo);
    localToServiceMsg.getAttributes().put("to_verify_code", paramString);
    localToServiceMsg.setRequestSsoSeq(paramVerifyCodeInfo.ssoSeq);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getSuspendMsg()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), "0", "Msf.SetSuspend");
    localToServiceMsg.setMsfCommand(MsfCommand._setMsfSuspend);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getUnRegisterProxyMsg(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "push.proxyUnRegister");
    paramString1.setMsfCommand(MsfCommand.proxyUnRegisterPush);
    paramString1.getAttributes().put(paramString1.getServiceCmd(), paramString2);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getUnRegisterPushMsg(PushRegisterInfo paramPushRegisterInfo)
  {
    if (paramPushRegisterInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "getUnRegisterPushMsg pushRegisterInfo null!");
      }
      return null;
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramPushRegisterInfo.uin, "push.unRegister");
    localToServiceMsg.setMsfCommand(MsfCommand.unRegisterPush);
    aa.a(localToServiceMsg, paramPushRegisterInfo);
    beforeSend(localToServiceMsg);
    return localToServiceMsg;
  }
  
  public ToServiceMsg getVerifyPasswdImageMsg(String paramString1, String paramString2)
  {
    paramString1 = new ToServiceMsg(getMsfServiceName(), paramString1, "login.verifyPasswdImage");
    paramString1.setMsfCommand(MsfCommand.verifyPasswdImage);
    paramString1.getAttributes().put("to_verify_passwd_image", paramString2);
    beforeSend(paramString1);
    return paramString1;
  }
  
  public ToServiceMsg getVerifyPasswdMsg(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.verifyPasswd");
    paramString.setMsfCommand(MsfCommand.verifyPasswd);
    paramString.getAttributes().put("to_login_pwd", paramArrayOfByte);
    beforeSend(paramString);
    return paramString;
  }
  
  public ToServiceMsg getVerifyPasswdRefreshImageMsg(String paramString)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "login.verifyPasswdRefreshImage");
    paramString.setMsfCommand(MsfCommand.verifyPasswdRefreshImage);
    beforeSend(paramString);
    return paramString;
  }
  
  public void init(Context paramContext, int paramInt, String paramString1, String paramString2, IErrorHandler paramIErrorHandler, String paramString3)
  {
    super.initSub(paramString3, paramInt, paramString2, paramString1, paramIErrorHandler);
    if (QLog.isColorLevel())
    {
      QLog.d("MsfServiceSdk", 2, "MsfServiceSdk init proxyNew=" + isUseNewProxy + " appid=" + paramInt + " msfServiceName=" + paramString2 + " bootBroadcastName=" + paramString1 + " processName=" + paramString3);
      return;
    }
    QLog.d("MsfServiceSdk", 1, "MsfServiceSdk init proxyNew=" + isUseNewProxy + " processName=" + paramString3);
  }
  
  public void initMsfService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsfServiceSdk", 4, "initMsfService");
    }
    registerServiceListener();
    this.proxy.initMsfService();
  }
  
  public int onKillProcess()
  {
    return this.proxy.onKillProcess();
  }
  
  public int onProcessViewableChanged(boolean paramBoolean, long paramLong)
  {
    return this.proxy.onProcessViewableChanged(paramBoolean, paramLong, BaseApplication.processName);
  }
  
  public void registerMsfService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsfServiceSdk", 4, "registerMsfService");
    }
    this.proxy.registerMsfService(false, false);
  }
  
  public void registerProxyDone()
  {
    QLog.d("MsfServiceSdk", 1, "registerProxyDone");
    this.proxy.registerProxyDone();
  }
  
  public int sendMsg(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (paramToServiceMsg.getServiceName().equals(getMsfServiceName())) {
      return this.proxy.sendMsg(paramToServiceMsg);
    }
    return h.a(paramToServiceMsg);
  }
  
  public void sendStartUseAccountBroadcast(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "sendStartUseAccountBroadcast context null!");
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent("com.tencent.mobileqq.usersync");
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("action", "enter");
      localIntent.setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("MsfServiceSdk", 2, "send bootAction user " + paramString + " enter broadcast");
  }
  
  public void sendstopUseAccountBroadcast(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.w("MsfServiceSdk", 2, "sendstopUseAccountBroadcast context null!");
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent("com.tencent.mobileqq.usersync");
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("action", "exit");
      localIntent.setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("MsfServiceSdk", 2, "send bootAction user " + paramString + " exit broadcast");
  }
  
  public void stopMsfService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsfServiceSdk", 4, "stopMsfService");
    }
    this.proxy.stopMsfService();
  }
  
  public ArrayList syncGetLoginedAccountList()
  {
    return MsfSdkUtils.getLoginedAccountList();
  }
  
  public int syncGetNetInfo()
  {
    return AppNetConnInfo.getConnInfo();
  }
  
  public String syncGetServerAppConfig()
  {
    return syncGetServerConfig("0", 2);
  }
  
  public String syncGetServerCommonConfig()
  {
    return syncGetServerConfig("0", 0);
  }
  
  public String syncGetServerConfig(String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg(getMsfServiceName(), paramString, "cmd_getServerConfig");
    localToServiceMsg.setMsfCommand(MsfCommand.getServerConfig);
    localToServiceMsg.getAttributes().put("to_getServerConfig_type", Integer.valueOf(paramInt));
    beforeSend(localToServiceMsg);
    sendMsg(localToServiceMsg);
    return MsfSdkUtils.getServerConfig(this.processName, paramInt, paramString);
  }
  
  public String syncGetServerUserConfig(String paramString)
  {
    return syncGetServerConfig(paramString, 1);
  }
  
  public void unRegisterMsfService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsfServiceSdk", 4, "unRegisterMsfService");
    }
    this.proxy.unRegisterMsfService(Boolean.valueOf(true));
  }
  
  public void unRegisterMsfService(Boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsfServiceSdk", 4, "unRegisterMsfService " + paramBoolean);
    }
    this.proxy.unRegisterMsfService(paramBoolean);
  }
  
  public void unbindMsfService()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsfServiceSdk", 4, "unbindMsfService");
    }
    unregisterServiceListener();
    this.proxy.unbindMsfService();
  }
  
  public ToServiceMsg updateBatterStatusMsg(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new ToServiceMsg(getMsfServiceName(), paramString, "push.register");
    paramString.setMsfCommand(MsfCommand.msf_update_battery);
    paramString.getAttributes().put("battery_capacity", Integer.valueOf(paramInt1));
    paramString.getAttributes().put("power_connect", Integer.valueOf(paramInt2));
    beforeSend(paramString);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfServiceSdk
 * JD-Core Version:    0.7.0.1
 */