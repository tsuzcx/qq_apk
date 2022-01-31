package com.tencent.mobileqq.msf.core.auth;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ag;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class m
{
  static final String a = "MSF.C.WTLoginCenter.MsfProvider";
  static ConcurrentHashMap b = new ConcurrentHashMap();
  public static final int c = 262208;
  public static final int d = 34869344;
  public static final int e = 1052704;
  
  public static int a(WUserSigInfo paramWUserSigInfo, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, WtloginMsfListener paramWtloginMsfListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "SendData uin:" + paramString1 + " serviceCmd:" + paramString2 + " timeout:" + paramInt + " isWTSendSelf:" + paramBoolean + " wUserSigInfo:" + HexUtil.bytes2HexStr(paramWUserSigInfo._reserveData));
    }
    Object localObject;
    ToServiceMsg localToServiceMsg2;
    MsfCommand localMsfCommand;
    ToServiceMsg localToServiceMsg1;
    if (!paramBoolean)
    {
      paramInt = c(paramWUserSigInfo);
      localObject = (o)b.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "can not find WtloginWrapper sendData for " + paramInt);
        return -1;
      }
      ((o)localObject).c = paramWtloginMsfListener;
      localToServiceMsg2 = ((o)localObject).d;
      if ((localToServiceMsg2.getMsfCommand() == MsfCommand.wt_name2uin) && (paramString2.equals("wtlogin.login"))) {
        ((o)localObject).e.getAccountCenter().b(localToServiceMsg2.getUin(), paramString1);
      }
      localMsfCommand = localToServiceMsg2.getMsfCommand();
      paramWtloginMsfListener = (WtloginMsfListener)localObject;
      paramWUserSigInfo = localMsfCommand;
      localToServiceMsg1 = localToServiceMsg2;
      if (localMsfCommand != MsfCommand.wt_CheckSMSVerifyLoginAccount)
      {
        paramWtloginMsfListener = (WtloginMsfListener)localObject;
        paramWUserSigInfo = localMsfCommand;
        localToServiceMsg1 = localToServiceMsg2;
        if (localMsfCommand != MsfCommand.wt_RefreshSMSVerifyLoginCode)
        {
          paramWtloginMsfListener = (WtloginMsfListener)localObject;
          paramWUserSigInfo = localMsfCommand;
          localToServiceMsg1 = localToServiceMsg2;
          if (localMsfCommand != MsfCommand.wt_VerifySMSVerifyLoginCode)
          {
            if (!paramString2.equals("wtlogin.login")) {
              break label347;
            }
            paramWUserSigInfo = MsfCommand.wt_loginAuth;
            localToServiceMsg1 = localToServiceMsg2;
            paramWtloginMsfListener = (WtloginMsfListener)localObject;
          }
        }
      }
    }
    for (;;)
    {
      paramInt = paramArrayOfByte.length + 4;
      localObject = ByteBuffer.allocate(paramInt);
      ((ByteBuffer)localObject).order(ByteOrder.BIG_ENDIAN);
      ((ByteBuffer)localObject).putInt(paramInt);
      ((ByteBuffer)localObject).put(paramArrayOfByte);
      localToServiceMsg1.setUin(paramString1);
      localToServiceMsg1.setServiceCmd(paramString2);
      localToServiceMsg1.setMsfCommand(paramWUserSigInfo);
      localToServiceMsg1.putWupBuffer(((ByteBuffer)localObject).array());
      return paramWtloginMsfListener.e.sendSsoMsg(localToServiceMsg1);
      label347:
      paramWtloginMsfListener = (WtloginMsfListener)localObject;
      paramWUserSigInfo = localMsfCommand;
      localToServiceMsg1 = localToServiceMsg2;
      if (paramString2.equals("wtlogin.name2uin"))
      {
        paramWUserSigInfo = MsfCommand.wt_name2uin;
        paramWtloginMsfListener = (WtloginMsfListener)localObject;
        localToServiceMsg1 = localToServiceMsg2;
        continue;
        localToServiceMsg1 = new ToServiceMsg("", paramString1, paramString2);
        localToServiceMsg1.setAppId(l.d.getMsfAppid());
        localToServiceMsg1.setRequestSsoSeq(MsfCore.getNextSeq());
        localToServiceMsg1.setTimeout(paramInt);
        MsfSdkUtils.addToMsgProcessName("*", localToServiceMsg1);
        paramWUserSigInfo = MsfCommand.wt_other;
        localToServiceMsg1.setMsfCommand(paramWUserSigInfo);
        a(localToServiceMsg1);
        a(l.d, localToServiceMsg1);
        localObject = (o)b.get(Integer.valueOf(localToServiceMsg1.getRequestSsoSeq()));
        ((o)localObject).c = paramWtloginMsfListener;
        paramWtloginMsfListener = (WtloginMsfListener)localObject;
      }
    }
  }
  
  static o a(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if ((paramToServiceMsg.getMsfCommand() == MsfCommand.refreVerifyCode) || (paramToServiceMsg.getMsfCommand() == MsfCommand.submitVerifyCode) || (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_CheckPictureAndGetSt) || (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_RefreshPictureData))
      {
        paramMsfCore = (o)b.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
        localObject = paramMsfCore;
        if (paramMsfCore != null) {
          break label119;
        }
      }
      try
      {
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "can not find wtloginMsfListener VerifyCode for " + paramToServiceMsg.getRequestSsoSeq());
        return null;
      }
      catch (Exception paramToServiceMsg) {}
      if (paramToServiceMsg.getRequestSsoSeq() == -1) {
        paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      }
      Object localObject = new o(paramMsfCore, paramToServiceMsg);
      label119:
      paramMsfCore = (MsfCore)localObject;
      ((o)localObject).d = paramToServiceMsg;
      paramMsfCore = (MsfCore)localObject;
      b.put(Integer.valueOf(((o)localObject).d.getRequestSsoSeq()), localObject);
      return localObject;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        paramMsfCore = null;
      }
    }
    paramToServiceMsg.printStackTrace();
    return paramMsfCore;
  }
  
  public static o a(WUserSigInfo paramWUserSigInfo)
  {
    int i = c(paramWUserSigInfo);
    return (o)b.get(Integer.valueOf(i));
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    int k;
    int j;
    int i;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 3))
    {
      k = util.buf_to_int32(paramArrayOfByte, 0);
      j = 4;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || (paramArrayOfByte.length < j + 1)) {}
      int m;
      do
      {
        do
        {
          do
          {
            return null;
            m = util.buf_to_int8(paramArrayOfByte, j);
            j += 1;
          } while (paramArrayOfByte.length < j + m);
          paramString = new String(paramArrayOfByte, j, m);
          m = j + m;
        } while (paramArrayOfByte.length < m + 2);
        j = util.buf_to_int32(paramArrayOfByte, m);
        m += 4;
      } while (paramArrayOfByte.length < m + j);
      String str = new String(paramArrayOfByte, m, j);
      util.LOGI("key_data:" + paramString + " value:" + str);
      if (paramString.equals("pic_reason")) {
        return str;
      }
      i += 1;
      j += m;
    }
  }
  
  public static void a(int paramInt) {}
  
  public static void a(MsfCore paramMsfCore, long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString)
  {
    VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
    localVerifyCodeInfo.ssoSeq = paramFromServiceMsg.getRequestSsoSeq();
    localVerifyCodeInfo.verifyurl = paramString;
    VerifyCodeInfo.putVerifyCodeInfo(paramFromServiceMsg, localVerifyCodeInfo);
    paramFromServiceMsg.setBusinessFail(2002, "");
    paramMsfCore.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public static void a(MsfCore paramMsfCore, WtloginHelper paramWtloginHelper, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString, WUserSigInfo paramWUserSigInfo)
  {
    if (paramWUserSigInfo == null) {
      return;
    }
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "wtlogin succ.");
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    if (paramWtloginHelper.GetBasicUserInfo(paramString, localWloginSimpleInfo).booleanValue()) {}
    for (String str = String.valueOf(localWloginSimpleInfo._uin);; str = paramString)
    {
      byte[] arrayOfByte2 = new byte[16];
      byte[] arrayOfByte3 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 262144);
      Object localObject = new byte[0];
      try
      {
        arrayOfByte1 = WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 262144);
        localObject = arrayOfByte1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          byte[] arrayOfByte1;
          byte[] arrayOfByte4;
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "readD2Key error " + localException);
          continue;
          int i = 2;
        }
      }
      arrayOfByte1 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 64);
      arrayOfByte4 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 4096);
      paramWUserSigInfo = WtloginHelper.GetTicketSig(paramWUserSigInfo, 32);
      j.a(arrayOfByte2, 0, (byte[])localObject, localObject.length);
      localObject = new a(str);
      ((a)localObject).e(arrayOfByte1);
      ((a)localObject).h(arrayOfByte3);
      ((a)localObject).j(arrayOfByte2);
      ((a)localObject).b(arrayOfByte4);
      ((a)localObject).c(paramWUserSigInfo);
      ((a)localObject).c(com.tencent.mobileqq.msf.service.l.b(paramToServiceMsg));
      if (paramWtloginHelper.GetBasicUserInfo(paramString, localWloginSimpleInfo).booleanValue())
      {
        ((a)localObject).b(localWloginSimpleInfo._age[0]);
        ((a)localObject).n(localWloginSimpleInfo._nick);
        if (localWloginSimpleInfo._gender[0] == 1)
        {
          i = 1;
          ((a)localObject).c(i);
          ((a)localObject).a(util.buf_to_int16(localWloginSimpleInfo._face, 0));
        }
      }
      else
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, Thread.currentThread().getName() + " handleLoginSucc updateAccount " + MsfSdkUtils.getShortUin(((a)localObject).d()));
        paramFromServiceMsg.addAttribute("resp_simpleAccount", paramMsfCore.getAccountCenter().c((a)localObject).o().toStoreString());
        paramFromServiceMsg.setMsgSuccess();
        paramFromServiceMsg.addAttribute("__attribute_tag_servertimediff", Long.valueOf(paramWtloginHelper.GetTimeDifference() * 1000L));
        paramMsfCore.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        paramWtloginHelper = (String)paramToServiceMsg.getAttribute("from_where");
        if (("subaccount".equals(paramWtloginHelper)) || ("ssoAccountAction".equals(paramWtloginHelper))) {
          break;
        }
        paramMsfCore.getAccountCenter().c(str, "login");
        paramMsfCore.stopPCActivePolling("login");
        return;
      }
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    if (paramToServiceMsg.getAttribute("__timestamp_app2msf") == null) {
      paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
    }
    paramToServiceMsg.addAttribute("to_wtlogin_oldcmd", paramToServiceMsg.getServiceCmd());
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    o localo = (o)b.get(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
    if (localo == null)
    {
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "can not find wtloginMsfListener onRecvData for " + paramFromServiceMsg.getRequestSsoSeq());
      return;
    }
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "onRecvData find wtloginMsfListener for " + paramFromServiceMsg.getRequestSsoSeq());
    Object localObject = (String)paramToServiceMsg.getAttribute("to_wtlogin_oldcmd");
    if (localObject != null) {
      paramToServiceMsg.setServiceCmd((String)localObject);
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg.order(ByteOrder.BIG_ENDIAN);
      int i = paramToServiceMsg.getInt();
      localObject = new byte[i - 4];
      paramToServiceMsg.get((byte[])localObject, 0, i - 4);
      localo.c.onReceiveData(paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd(), (byte[])localObject);
      return;
    }
    localo.c.onReceiveFail(paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd(), paramFromServiceMsg.getBusinessFailCode());
  }
  
  public static void a(String paramString1, MsfCore paramMsfCore, long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString2)
  {
    try
    {
      paramString1 = l.e.GetDevLockInfo(paramString1, paramLong);
      if (paramFromServiceMsg.getAttribute("timeLimit") != null) {
        paramString1.TimeLimit = ((Integer)paramFromServiceMsg.getAttribute("timeLimit")).intValue();
      }
      if ((paramString1 != null) && (QLog.isColorLevel()) && (QLog.isColorLevel())) {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "GetDevLockInfo: " + paramString1.Mobile + " " + paramString1.DevSetup);
      }
      paramFromServiceMsg.addAttribute("resp_devlockinfo", paramString1);
      paramFromServiceMsg.setBusinessFail(2016, paramString2);
      paramMsfCore.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd exception " + paramString1.toString(), paramString1);
    }
  }
  
  public static o b(WUserSigInfo paramWUserSigInfo)
  {
    int i = c(paramWUserSigInfo);
    return (o)b.remove(Integer.valueOf(i));
  }
  
  public static WUserSigInfo b(int paramInt)
  {
    try
    {
      WUserSigInfo localWUserSigInfo = new WUserSigInfo();
      localWUserSigInfo._reserveData = MsfSdkUtils.convertInt2Bytes(paramInt);
      return localWUserSigInfo;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "getWUSigInfoFromSeq error " + paramInt, localException);
    }
    return null;
  }
  
  public static void b(String paramString1, MsfCore paramMsfCore, long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString2)
  {
    try
    {
      byte[] arrayOfByte = l.e.GetPictureData(paramFromServiceMsg.getUin(), paramLong);
      ag.a(paramFromServiceMsg);
      VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
      localVerifyCodeInfo.ssoSeq = paramFromServiceMsg.getRequestSsoSeq();
      localVerifyCodeInfo.verifyimage = arrayOfByte;
      try
      {
        localVerifyCodeInfo.verifyNote = a(paramString1, l.e.GetPicturePrompt(paramString1, paramLong));
        VerifyCodeInfo.putVerifyCodeInfo(paramFromServiceMsg, localVerifyCodeInfo);
        paramFromServiceMsg.setBusinessFail(2002, paramString2);
        paramMsfCore.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "getImagePrompt exception " + paramString1.toString(), paramString1);
          localVerifyCodeInfo.verifyNote = "getTipErr";
        }
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd exception " + paramString1.toString(), paramString1);
    }
  }
  
  public static int c(WUserSigInfo paramWUserSigInfo)
  {
    try
    {
      int i = MsfSdkUtils.convertBytes2Int(paramWUserSigInfo._reserveData);
      return i;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "getSsoSeqFromInfo error " + paramWUserSigInfo, localException);
    }
    return -1;
  }
  
  /* Error */
  public static WUserSigInfo c(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 609	com/tencent/mobileqq/msf/core/a/a:bf	()Ljava/util/HashSet;
    //   3: astore_3
    //   4: new 60	oicq/wlogin_sdk/request/WUserSigInfo
    //   7: dup
    //   8: invokespecial 565	oicq/wlogin_sdk/request/WUserSigInfo:<init>	()V
    //   11: astore_2
    //   12: aload_2
    //   13: iload_0
    //   14: invokestatic 569	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:convertInt2Bytes	(I)[B
    //   17: putfield 64	oicq/wlogin_sdk/request/WUserSigInfo:_reserveData	[B
    //   20: aload_2
    //   21: astore_1
    //   22: aload_3
    //   23: ifnull +68 -> 91
    //   26: aload_3
    //   27: invokevirtual 615	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   30: astore_3
    //   31: aload_2
    //   32: astore_1
    //   33: aload_3
    //   34: invokeinterface 620 1 0
    //   39: ifeq +52 -> 91
    //   42: aload_2
    //   43: getfield 624	oicq/wlogin_sdk/request/WUserSigInfo:_domains	Ljava/util/List;
    //   46: aload_3
    //   47: invokeinterface 628 1 0
    //   52: invokeinterface 633 2 0
    //   57: pop
    //   58: goto -27 -> 31
    //   61: astore_1
    //   62: ldc 8
    //   64: iconst_1
    //   65: new 37	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 571
    //   75: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload_0
    //   79: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aload_1
    //   86: invokestatic 573	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramInt	int
    //   21	12	1	localWUserSigInfo1	WUserSigInfo
    //   61	25	1	localException	Exception
    //   90	2	1	localWUserSigInfo2	WUserSigInfo
    //   11	32	2	localWUserSigInfo3	WUserSigInfo
    //   3	44	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	20	61	java/lang/Exception
    //   26	31	61	java/lang/Exception
    //   33	58	61	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.m
 * JD-Core Version:    0.7.0.1
 */