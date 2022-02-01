package com.tencent.mobileqq.msf.core.auth;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ag;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class n
{
  static final String a = "MSF.C.WTLoginCenter.MsfProvider";
  public static final String b = "process";
  public static final String c = "com.tencent.mobileqq:openSdk";
  static ConcurrentHashMap d = new ConcurrentHashMap();
  public static final int e = 262208;
  public static final int f = 34869344;
  public static final int g = 1052704;
  
  public static int a(WUserSigInfo paramWUserSigInfo, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, WtloginMsfListener paramWtloginMsfListener)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SendData uin:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" serviceCmd:");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" timeout:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" isWTSendSelf:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" wUserSigInfo:");
      ((StringBuilder)localObject1).append(HexUtil.bytes2HexStr(paramWUserSigInfo._reserveData));
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject1).toString());
    }
    if (!paramBoolean)
    {
      paramInt = c(paramWUserSigInfo);
      localObject2 = (p)d.get(Integer.valueOf(paramInt));
      if (localObject2 == null)
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("can not find WtloginWrapper sendData for ");
        paramWUserSigInfo.append(paramInt);
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString());
        return -1;
      }
      ((p)localObject2).c = paramWtloginMsfListener;
      ToServiceMsg localToServiceMsg = ((p)localObject2).d;
      if ((localToServiceMsg.getMsfCommand() == MsfCommand.wt_name2uin) && (paramString2.equals("wtlogin.login"))) {
        ((p)localObject2).e.getAccountCenter().b(localToServiceMsg.getUin(), paramString1);
      }
      MsfCommand localMsfCommand = localToServiceMsg.getMsfCommand();
      localObject1 = localToServiceMsg;
      paramWtloginMsfListener = (WtloginMsfListener)localObject2;
      paramWUserSigInfo = localMsfCommand;
      if (localMsfCommand != MsfCommand.wt_CheckSMSVerifyLoginAccount)
      {
        localObject1 = localToServiceMsg;
        paramWtloginMsfListener = (WtloginMsfListener)localObject2;
        paramWUserSigInfo = localMsfCommand;
        if (localMsfCommand != MsfCommand.wt_RefreshSMSVerifyLoginCode)
        {
          localObject1 = localToServiceMsg;
          paramWtloginMsfListener = (WtloginMsfListener)localObject2;
          paramWUserSigInfo = localMsfCommand;
          if (localMsfCommand != MsfCommand.wt_VerifySMSVerifyLoginCode) {
            if (paramString2.equals("wtlogin.login"))
            {
              paramWUserSigInfo = MsfCommand.wt_loginAuth;
              localObject1 = localToServiceMsg;
              paramWtloginMsfListener = (WtloginMsfListener)localObject2;
            }
            else
            {
              localObject1 = localToServiceMsg;
              paramWtloginMsfListener = (WtloginMsfListener)localObject2;
              paramWUserSigInfo = localMsfCommand;
              if (paramString2.equals("wtlogin.name2uin"))
              {
                paramWUserSigInfo = MsfCommand.wt_name2uin;
                localObject1 = localToServiceMsg;
                paramWtloginMsfListener = (WtloginMsfListener)localObject2;
              }
            }
          }
        }
      }
    }
    else
    {
      localObject1 = new ToServiceMsg("", paramString1, paramString2);
      ((ToServiceMsg)localObject1).setAppId(l.d.getMsfAppid());
      ((ToServiceMsg)localObject1).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject1).setTimeout(paramInt);
      MsfSdkUtils.addToMsgProcessName("*", (ToServiceMsg)localObject1);
      paramWUserSigInfo = MsfCommand.wt_other;
      ((ToServiceMsg)localObject1).setMsfCommand(paramWUserSigInfo);
      a((ToServiceMsg)localObject1);
      a(l.d, (ToServiceMsg)localObject1);
      localObject2 = (p)d.get(Integer.valueOf(((ToServiceMsg)localObject1).getRequestSsoSeq()));
      ((p)localObject2).c = paramWtloginMsfListener;
      paramWtloginMsfListener = (WtloginMsfListener)localObject2;
    }
    paramInt = paramArrayOfByte.length + 4;
    Object localObject2 = ByteBuffer.allocate(paramInt);
    ((ByteBuffer)localObject2).order(ByteOrder.BIG_ENDIAN);
    ((ByteBuffer)localObject2).putInt(paramInt);
    ((ByteBuffer)localObject2).put(paramArrayOfByte);
    ((ToServiceMsg)localObject1).setUin(paramString1);
    ((ToServiceMsg)localObject1).setServiceCmd(paramString2);
    ((ToServiceMsg)localObject1).setMsfCommand(paramWUserSigInfo);
    ((ToServiceMsg)localObject1).putWupBuffer(((ByteBuffer)localObject2).array());
    return paramWtloginMsfListener.e.sendSsoMsg((ToServiceMsg)localObject1);
  }
  
  static p a(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (paramToServiceMsg.getMsfCommand() != MsfCommand.refreVerifyCode)
      {
        localObject1 = localObject2;
        if (paramToServiceMsg.getMsfCommand() != MsfCommand.submitVerifyCode)
        {
          localObject1 = localObject2;
          if (paramToServiceMsg.getMsfCommand() != MsfCommand.wt_CheckPictureAndGetSt)
          {
            localObject1 = localObject2;
            if (paramToServiceMsg.getMsfCommand() != MsfCommand.wt_RefreshPictureData)
            {
              localObject1 = localObject2;
              if (paramToServiceMsg.getRequestSsoSeq() == -1)
              {
                localObject1 = localObject2;
                paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
              }
              localObject1 = localObject2;
              paramMsfCore = new p(paramMsfCore, paramToServiceMsg);
              break label151;
            }
          }
        }
      }
      localObject1 = localObject2;
      paramMsfCore = (p)d.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      if (paramMsfCore == null)
      {
        try
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("can not find wtloginMsfListener VerifyCode for ");
          ((StringBuilder)localObject1).append(paramToServiceMsg.getRequestSsoSeq());
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, ((StringBuilder)localObject1).toString());
          return null;
        }
        catch (Exception paramToServiceMsg) {}
      }
      else
      {
        label151:
        localObject1 = paramMsfCore;
        paramMsfCore.d = paramToServiceMsg;
        localObject1 = paramMsfCore;
        d.put(Integer.valueOf(paramMsfCore.d.getRequestSsoSeq()), paramMsfCore);
        return paramMsfCore;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      paramMsfCore = (MsfCore)localObject1;
      paramToServiceMsg.printStackTrace();
    }
    return paramMsfCore;
  }
  
  public static p a(WUserSigInfo paramWUserSigInfo)
  {
    int i = c(paramWUserSigInfo);
    return (p)d.get(Integer.valueOf(i));
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 3))
    {
      int i = 0;
      int k = util.buf_to_int32(paramArrayOfByte, 0);
      int j = 4;
      while (i < k)
      {
        int n = paramArrayOfByte.length;
        int m = j + 1;
        if (n < m) {
          break;
        }
        n = util.buf_to_int8(paramArrayOfByte, j);
        int i1 = paramArrayOfByte.length;
        j = m + n;
        if (i1 < j) {
          break;
        }
        paramString = new String(paramArrayOfByte, m, n);
        if (paramArrayOfByte.length < j + 2) {
          break;
        }
        m = util.buf_to_int32(paramArrayOfByte, j);
        n = j + 4;
        i1 = paramArrayOfByte.length;
        j = n + m;
        if (i1 < j) {
          break;
        }
        String str = new String(paramArrayOfByte, n, m);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_data:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" value:");
        localStringBuilder.append(str);
        util.LOGI(localStringBuilder.toString());
        if (paramString.equals("pic_reason")) {
          return str;
        }
        i += 1;
      }
    }
    return null;
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
    String str;
    if (paramWtloginHelper.GetBasicUserInfo(paramString, localWloginSimpleInfo).booleanValue()) {
      str = String.valueOf(localWloginSimpleInfo._uin);
    } else {
      str = paramString;
    }
    byte[] arrayOfByte3 = new byte[16];
    byte[] arrayOfByte4 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 262144);
    Object localObject1 = new byte[0];
    try
    {
      byte[] arrayOfByte1 = WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 262144);
      localObject1 = arrayOfByte1;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("readD2Key error ");
      ((StringBuilder)localObject2).append(localException);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, ((StringBuilder)localObject2).toString());
    }
    byte[] arrayOfByte2 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 64);
    Object localObject2 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 4096);
    byte[] arrayOfByte5 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 32);
    j.a(arrayOfByte3, 0, (byte[])localObject1, localObject1.length);
    localObject1 = new a(str);
    ((a)localObject1).e(arrayOfByte2);
    ((a)localObject1).h(arrayOfByte4);
    ((a)localObject1).j(arrayOfByte3);
    ((a)localObject1).b((byte[])localObject2);
    ((a)localObject1).c(arrayOfByte5);
    ((a)localObject1).c(u.b(paramToServiceMsg));
    if (paramWtloginHelper.GetBasicUserInfo(paramString, localWloginSimpleInfo).booleanValue())
    {
      ((a)localObject1).b(localWloginSimpleInfo._age[0]);
      ((a)localObject1).n(localWloginSimpleInfo._nick);
      int i;
      if (localWloginSimpleInfo._gender[0] == 1) {
        i = 1;
      } else {
        i = 2;
      }
      ((a)localObject1).c(i);
      ((a)localObject1).a(util.buf_to_int16(localWloginSimpleInfo._face, 0));
    }
    paramString = new StringBuilder();
    paramString.append(Thread.currentThread().getName());
    paramString.append(" handleLoginSucc updateAccount ");
    paramString.append(MsfSdkUtils.getShortUin(((a)localObject1).d()));
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramString.toString());
    paramFromServiceMsg.addAttribute("resp_simpleAccount", paramMsfCore.getAccountCenter().c((a)localObject1).o().toStoreString());
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.addAttribute("__attribute_tag_servertimediff", Long.valueOf(paramWtloginHelper.GetTimeDifference() * 1000L));
    paramMsfCore.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
    paramWtloginHelper = (String)paramToServiceMsg.getAttribute("from_where");
    if ((!"subaccount".equals(paramWtloginHelper)) && (!"ssoAccountAction".equals(paramWtloginHelper)))
    {
      paramMsfCore.getAccountCenter().c(str, "login");
      paramMsfCore.stopPCActivePolling("login");
    }
    if ((paramWUserSigInfo._device_token != null) && (paramWUserSigInfo._device_token.length > 0))
    {
      m.a(str, paramWUserSigInfo._device_token);
      l.e.SetUinDeviceToken(false);
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
    p localp = (p)d.get(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
    if (localp == null)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("can not find wtloginMsfListener onRecvData for ");
      paramToServiceMsg.append(paramFromServiceMsg.getRequestSsoSeq());
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramToServiceMsg.toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRecvData find wtloginMsfListener for ");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getRequestSsoSeq());
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, ((StringBuilder)localObject).toString());
    localObject = (String)paramToServiceMsg.getAttribute("to_wtlogin_oldcmd");
    if (localObject != null) {
      paramToServiceMsg.setServiceCmd((String)localObject);
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg.order(ByteOrder.BIG_ENDIAN);
      int i = paramToServiceMsg.getInt() - 4;
      localObject = new byte[i];
      paramToServiceMsg.get((byte[])localObject, 0, i);
      localp.c.onReceiveData(paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd(), (byte[])localObject);
      return;
    }
    localp.c.onReceiveFail(paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd(), paramFromServiceMsg.getBusinessFailCode());
  }
  
  public static void a(String paramString1, MsfCore paramMsfCore, long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString2)
  {
    try
    {
      paramString1 = l.e.GetDevLockInfo(paramString1, paramLong);
      if (paramFromServiceMsg.getAttribute("timeLimit") != null) {
        paramString1.TimeLimit = ((Integer)paramFromServiceMsg.getAttribute("timeLimit")).intValue();
      }
      if ((paramString1 != null) && (QLog.isColorLevel()) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("GetDevLockInfo: ");
        localStringBuilder.append(paramString1.Mobile);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramString1.DevSetup);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, localStringBuilder.toString());
      }
      paramFromServiceMsg.addAttribute("resp_devlockinfo", paramString1);
      paramFromServiceMsg.setBusinessFail(2016, paramString2);
      paramMsfCore.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Exception paramString1)
    {
      paramMsfCore = new StringBuilder();
      paramMsfCore.append("OnGetStWithPasswd exception ");
      paramMsfCore.append(paramString1.toString());
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramMsfCore.toString(), paramString1);
    }
  }
  
  public static p b(WUserSigInfo paramWUserSigInfo)
  {
    int i = c(paramWUserSigInfo);
    return (p)d.remove(Integer.valueOf(i));
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWUSigInfoFromSeq error ");
      localStringBuilder.append(paramInt);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, localStringBuilder.toString(), localException);
    }
    return null;
  }
  
  public static void b(String paramString1, MsfCore paramMsfCore, long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString2)
  {
    try
    {
      Object localObject = l.e.GetPictureData(paramFromServiceMsg.getUin(), paramLong);
      ag.a(paramFromServiceMsg);
      VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
      localVerifyCodeInfo.ssoSeq = paramFromServiceMsg.getRequestSsoSeq();
      localVerifyCodeInfo.verifyimage = ((byte[])localObject);
      try
      {
        localVerifyCodeInfo.verifyNote = a(paramString1, l.e.GetPicturePrompt(paramString1, paramLong));
      }
      catch (Exception paramString1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getImagePrompt exception ");
        ((StringBuilder)localObject).append(paramString1.toString());
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, ((StringBuilder)localObject).toString(), paramString1);
        localVerifyCodeInfo.verifyNote = "getTipErr";
      }
      VerifyCodeInfo.putVerifyCodeInfo(paramFromServiceMsg, localVerifyCodeInfo);
      paramFromServiceMsg.setBusinessFail(2002, paramString2);
      paramMsfCore.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Exception paramString1)
    {
      paramMsfCore = new StringBuilder();
      paramMsfCore.append("OnGetStWithPasswd exception ");
      paramMsfCore.append(paramString1.toString());
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramMsfCore.toString(), paramString1);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSsoSeqFromInfo error ");
      localStringBuilder.append(paramWUserSigInfo);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, localStringBuilder.toString(), localException);
    }
    return -1;
  }
  
  public static WUserSigInfo c(int paramInt)
  {
    try
    {
      localObject = com.tencent.mobileqq.msf.core.a.a.bg();
      WUserSigInfo localWUserSigInfo = new WUserSigInfo();
      localWUserSigInfo._reserveData = MsfSdkUtils.convertInt2Bytes(paramInt);
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localWUserSigInfo._domains.add(((Iterator)localObject).next());
        }
      }
      return localWUserSigInfo;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getWUSigInfoFromSeq error ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, ((StringBuilder)localObject).toString(), localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.n
 * JD-Core Version:    0.7.0.1
 */