package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginMsfListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

class p
{
  boolean a = false;
  boolean b = true;
  WtloginMsfListener c;
  ToServiceMsg d;
  MsfCore e;
  long f;
  boolean g = false;
  boolean h = false;
  
  public p(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
  {
    this.e = paramMsfCore;
    this.d = paramToServiceMsg;
  }
  
  private String a(int paramInt)
  {
    if ((paramInt & 0x101020) == 1052704) {
      return "WebTicket";
    }
    if ((paramInt & 0x40040) == 262208) {
      return "BasicTicket";
    }
    return "OtherTicket";
  }
  
  private String a(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = this.d;
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes().get("refresh_token_src") != null)) {
      return (String)this.d.getAttributes().get("refresh_token_src");
    }
    return "OtherSrc";
  }
  
  private void a(String paramString)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramString, "msf.ticketchanged");
    localFromServiceMsg.setUin(paramString);
    localFromServiceMsg.setMsfCommand(MsfCommand.onTicketChanged);
    localFromServiceMsg.setAppId(this.e.getMsfAppid());
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    this.e.addRespToQuque(null, localFromServiceMsg);
  }
  
  public void a(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (this.g) {
      try
      {
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", Long.valueOf(paramLong));
        localFromServiceMsg.addAttribute("supersig", paramArrayOfByte1);
        localFromServiceMsg.addAttribute("contactssig", paramArrayOfByte2);
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
        localFromServiceMsg.addAttribute("msg", paramArrayOfByte3);
        if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRegGetSMSVerifyLoginAccount|lhsig success");
          }
          localFromServiceMsg.attributes.put("resp_register_lh_sig", paramArrayOfByte4);
        }
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramArrayOfByte1)
      {
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("OnRegGetSMSVerifyLoginAccount error ");
        paramArrayOfByte2.append(paramArrayOfByte1);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte2.toString(), paramArrayOfByte1);
      }
    }
  }
  
  public void a(int paramInt, WUserSigInfo paramWUserSigInfo, String paramString, ErrMsg paramErrMsg, HashMap paramHashMap)
  {
    if (this.g) {
      try
      {
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
        localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
        localFromServiceMsg.addAttribute("uin", paramString);
        localFromServiceMsg.addAttribute("extraMap", paramHashMap);
        localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
        localFromServiceMsg.addAttribute("key_sso_seq", Integer.valueOf(this.d.getRequestSsoSeq()));
        localFromServiceMsg.addAttribute("key_to_service_msg", this.d);
        if (paramWUserSigInfo != null) {
          localFromServiceMsg.addAttribute("resp_devlockinfo", l.e.GetDevLockInfo(null, paramWUserSigInfo._seqence));
        }
        int k = 0;
        int j = 0;
        int i = k;
        if (paramInt == 0)
        {
          boolean bool = TextUtils.isEmpty(paramString);
          i = k;
          if (!bool)
          {
            try
            {
              a(paramString);
              n.a(this.e, l.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
              try
              {
                if (this.a) {
                  l.a(paramString);
                }
                i = 1;
              }
              catch (Exception paramWUserSigInfo)
              {
                i = 1;
              }
              paramString = new StringBuilder();
            }
            catch (Exception paramWUserSigInfo)
            {
              i = j;
            }
            paramString.append("onLoginByGateway succ exception ");
            paramString.append(paramWUserSigInfo.toString());
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramString.toString(), paramWUserSigInfo);
          }
        }
        if (i == 0)
        {
          this.e.addRespToQuque(this.d, localFromServiceMsg);
          return;
        }
      }
      catch (Exception paramWUserSigInfo)
      {
        paramString = new StringBuilder();
        paramString.append("onLoginByGateway error ");
        paramString.append(paramWUserSigInfo);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramString.toString(), paramWUserSigInfo);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (this.g) {
      try
      {
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("appid", Long.valueOf(paramLong1));
        localFromServiceMsg.addAttribute("subAppid", Long.valueOf(paramLong2));
        localFromServiceMsg.addAttribute("countryCode", paramString1);
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt3));
        localFromServiceMsg.addAttribute("mobile", paramString2);
        localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
        localFromServiceMsg.addAttribute("msg", paramString3);
        localFromServiceMsg.addAttribute("msgCnt", Integer.valueOf(paramInt1));
        localFromServiceMsg.addAttribute("timeLimit", Integer.valueOf(paramInt2));
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("OnCheckSMSVerifyLoginAccount error ");
        paramString2.append(paramString1);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramString2.toString(), paramString1);
      }
    }
  }
  
  public void a(String paramString, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    paramWUserSigInfo = new StringBuilder();
    paramWUserSigInfo.append("OnException ");
    paramWUserSigInfo.append(paramString);
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString());
    if (this.g) {
      try
      {
        paramWUserSigInfo = u.a(this.d);
        paramWUserSigInfo.setBusinessFail(3002, paramString);
        paramWUserSigInfo.addAttribute("error", paramString);
        paramWUserSigInfo.addAttribute("cmd", Integer.valueOf(paramInt));
        this.e.addRespToQuque(this.d, paramWUserSigInfo);
        return;
      }
      catch (Exception paramString)
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnException error ");
        paramWUserSigInfo.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString(), paramString);
        return;
      }
    }
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setBusinessFail(3001, paramString);
    MsfSdkUtils.addFromMsgProcessName("*", paramWUserSigInfo);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.g) {
      try
      {
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", paramString);
        localFromServiceMsg.addAttribute("dwAppid", Long.valueOf(paramLong1));
        localFromServiceMsg.addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt2));
        localFromServiceMsg.addAttribute("dwSubDstAppid", Long.valueOf(paramLong2));
        localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString)
      {
        paramErrMsg = new StringBuilder();
        paramErrMsg.append("OnGetStViaSMSVerifyLogin error ");
        paramErrMsg.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramErrMsg.toString(), paramString);
      }
    }
  }
  
  public void a(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.d.getRequestSsoSeq());
    ((StringBuilder)localObject1).append(" OnGetStWithPasswd ");
    ((StringBuilder)localObject1).append(paramErrMsg.getMessage());
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(MsfSdkUtils.getShortUin(paramString1));
    ((StringBuilder)localObject1).append(",  isVerifyPasswd=");
    ((StringBuilder)localObject1).append(this.h);
    ((StringBuilder)localObject1).append(" appUseWt=");
    ((StringBuilder)localObject1).append(this.g);
    ((StringBuilder)localObject1).append(" ret=");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(this.d);
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, ((StringBuilder)localObject1).toString());
    if (this.h)
    {
      localObject1 = o.a(this.d);
      ((FromServiceMsg)localObject1).setMsgSuccess();
      this.d.setMsfCommand(MsfCommand.verifyPasswd);
      ((FromServiceMsg)localObject1).setMsfCommand(MsfCommand.verifyPasswd);
      ((FromServiceMsg)localObject1).addAttribute("userAccount", paramString1);
      ((FromServiceMsg)localObject1).addAttribute("dwAppid", Long.valueOf(paramLong1));
      ((FromServiceMsg)localObject1).addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
      ((FromServiceMsg)localObject1).addAttribute("dwSubDstAppid", Long.valueOf(paramLong2));
      ((FromServiceMsg)localObject1).addAttribute("userPasswd", paramString2);
      ((FromServiceMsg)localObject1).addAttribute("userSigInfo", paramWUserSigInfo);
      ((FromServiceMsg)localObject1).addAttribute("ret", Integer.valueOf(paramInt2));
      ((FromServiceMsg)localObject1).addAttribute("lastError", paramErrMsg);
      ((FromServiceMsg)localObject1).setUin(paramWUserSigInfo.uin);
      if (paramInt2 != -1000) {
        if (paramInt2 != 0) {
          if (paramInt2 != 1) {
            if (paramInt2 != 2) {
              ((FromServiceMsg)localObject1).setBusinessFail(1001, paramErrMsg.getMessage());
            }
          }
        }
      }
      for (;;)
      {
        break;
        ((FromServiceMsg)localObject1).setBusinessFail(2020, paramErrMsg.getMessage());
        paramErrMsg = l.e.GetPictureData(((FromServiceMsg)localObject1).getUin(), paramWUserSigInfo._seqence);
        paramString2 = new VerifyCodeInfo();
        paramString2.ssoSeq = ((FromServiceMsg)localObject1).getRequestSsoSeq();
        paramString2.verifyimage = paramErrMsg;
        try
        {
          paramString2.verifyNote = n.a(paramString1, l.e.GetPicturePrompt(paramString1, paramWUserSigInfo._seqence));
        }
        catch (Exception paramString1)
        {
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append("getImagePrompt exception ");
          paramWUserSigInfo.append(paramString1.toString());
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString(), paramString1);
          paramString2.verifyNote = "getTipErr";
        }
        ((FromServiceMsg)localObject1).addAttribute("resp_verify_image", paramString2.verifyimage);
        ((FromServiceMsg)localObject1).addAttribute("resp_verify_msg", paramString2.verifyNote);
        continue;
        ((FromServiceMsg)localObject1).setBusinessFail(2005, paramErrMsg.getMessage());
        continue;
        ((FromServiceMsg)localObject1).setMsgSuccess();
        continue;
        ((FromServiceMsg)localObject1).setBusinessFail(1002);
      }
      this.e.addRespToQuque(this.d, (FromServiceMsg)localObject1);
      return;
    }
    if (this.g) {}
    label1623:
    for (;;)
    {
      try
      {
        localObject1 = new byte[0];
        if (paramInt2 != 0)
        {
          if (paramInt2 != 2) {
            break label1623;
          }
          if (TextUtils.isEmpty(paramErrMsg.getOtherinfo()))
          {
            localObject1 = l.e.GetPictureData(paramString1);
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label1623;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("puzzle CAPTCHA ");
            ((StringBuilder)localObject2).append(paramErrMsg.getOtherinfo());
            QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject2).toString());
            break label1623;
          }
        }
        else
        {
          l.d.getAccountCenter().a(false);
          break label1623;
        }
        Object localObject2 = u.a(this.d);
        ((FromServiceMsg)localObject2).setMsgSuccess();
        ((FromServiceMsg)localObject2).addAttribute("userAccount", paramString1);
        ((FromServiceMsg)localObject2).addAttribute("dwAppid", Long.valueOf(paramLong1));
        ((FromServiceMsg)localObject2).addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
        ((FromServiceMsg)localObject2).addAttribute("dwSubDstAppid", Long.valueOf(paramLong2));
        ((FromServiceMsg)localObject2).addAttribute("userPasswd", paramString2);
        ((FromServiceMsg)localObject2).addAttribute("pictureData", localObject1);
        ((FromServiceMsg)localObject2).addAttribute("userSigInfo", paramWUserSigInfo);
        ((FromServiceMsg)localObject2).addAttribute("wtTicket", a(paramWUserSigInfo));
        ((FromServiceMsg)localObject2).addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
        ((FromServiceMsg)localObject2).addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
        ((FromServiceMsg)localObject2).addAttribute("ret", Integer.valueOf(paramInt2));
        ((FromServiceMsg)localObject2).addAttribute("lastError", paramErrMsg);
        this.e.addRespToQuque(this.d, (FromServiceMsg)localObject2);
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("OnGetStWithPasswd error ");
        paramString2.append(paramString1);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramString2.toString(), paramString1);
        return;
      }
      localObject1 = o.a(this.d);
      ((FromServiceMsg)localObject1).setMsgSuccess();
      ((FromServiceMsg)localObject1).addAttribute("userAccount", paramString1);
      ((FromServiceMsg)localObject1).addAttribute("dwAppid", Long.valueOf(paramLong1));
      ((FromServiceMsg)localObject1).addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
      ((FromServiceMsg)localObject1).addAttribute("dwSubDstAppid", Long.valueOf(paramLong2));
      ((FromServiceMsg)localObject1).addAttribute("userPasswd", paramString2);
      ((FromServiceMsg)localObject1).addAttribute("userSigInfo", paramWUserSigInfo);
      ((FromServiceMsg)localObject1).addAttribute("wtTicket", a(paramWUserSigInfo));
      ((FromServiceMsg)localObject1).addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
      try
      {
        ((FromServiceMsg)localObject1).addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
      }
      ((FromServiceMsg)localObject1).addAttribute("ret", Integer.valueOf(paramInt2));
      ((FromServiceMsg)localObject1).addAttribute("lastError", paramErrMsg);
      ((FromServiceMsg)localObject1).setUin(paramWUserSigInfo.uin);
      if (paramInt2 != -1000)
      {
        if ((paramInt2 != 160) && (paramInt2 != 239))
        {
          if (paramInt2 != 0) {
            if (paramInt2 != 1) {
              if (paramInt2 != 2)
              {
                paramString1 = new StringBuilder();
                paramString1.append("OnGetStWithPasswd fail, ");
                paramString1.append(paramErrMsg.getMessage());
                QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramString1.toString());
                ((FromServiceMsg)localObject1).setBusinessFail(1001, paramErrMsg.getMessage());
              }
            }
          }
          for (;;)
          {
            break;
            n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
            this.f = paramWUserSigInfo._seqence;
            if (TextUtils.isEmpty(paramErrMsg.getOtherinfo()))
            {
              n.b(paramString1, this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getMessage());
              return;
            }
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("appUseWt = false; puzzle CAPTCHA ");
              paramString1.append(paramErrMsg.getOtherinfo());
              QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, paramString1.toString());
            }
            n.a(this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getOtherinfo());
            return;
            ((FromServiceMsg)localObject1).setBusinessFail(2005, paramErrMsg.getMessage());
            continue;
            a(paramString1);
            if ((paramWUserSigInfo != null) && (paramWUserSigInfo._login_bitmap == 0))
            {
              try
              {
                n.a(this.e, l.e, this.d, (FromServiceMsg)localObject1, paramString1, paramWUserSigInfo);
                if (this.a)
                {
                  l.a(paramString1);
                  return;
                }
              }
              catch (Exception paramString1)
              {
                paramString2 = new StringBuilder();
                paramString2.append("OnGetStWithPasswd succ exception ");
                paramString2.append(paramString1.toString());
                QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramString2.toString(), paramString1);
              }
              return;
            }
            ((FromServiceMsg)localObject1).setMsgSuccess();
            ((FromServiceMsg)localObject1).addAttribute("__attribute_tag_servertimediff", Long.valueOf(l.e.GetTimeDifference() * 1000L));
          }
        }
        n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        n.a(paramString1, this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getMessage());
        return;
      }
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd timeout");
      ((FromServiceMsg)localObject1).setBusinessFail(1002);
      if (paramInt2 != 0)
      {
        if (paramErrMsg.getType() == 1) {
          ((FromServiceMsg)localObject1).addAttribute("resp_login_url", paramErrMsg.getOtherinfo());
        }
        if ((paramInt2 == 116) || (paramInt2 == 41))
        {
          paramString1 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4194304);
          if (paramString1 != null)
          {
            paramString1 = paramString1._sig;
            if (paramString1 != null)
            {
              ((FromServiceMsg)localObject1).addAttribute("resp_login_lhsig", paramString1);
            }
            else
            {
              paramString1 = new StringBuilder();
              paramString1.append("OnGetStWithPasswd ret: ");
              paramString1.append(paramInt2);
              paramString1.append(" , t is null.");
              QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramString1.toString());
            }
          }
        }
      }
      ((FromServiceMsg)localObject1).addAttribute("resp_logini_ret", Integer.valueOf(paramInt2));
      this.e.addRespToQuque(this.d, (FromServiceMsg)localObject1);
      return;
    }
  }
  
  public void a(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.g) {
      try
      {
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", paramString);
        localFromServiceMsg.addAttribute("dwSrcAppid", Long.valueOf(paramLong1));
        localFromServiceMsg.addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
        localFromServiceMsg.addAttribute("dwSubSrcAppid", Long.valueOf(paramLong2));
        localFromServiceMsg.addAttribute("dstAppName", paramArrayOfByte1);
        localFromServiceMsg.addAttribute("dwDstSsoVer", Long.valueOf(paramLong3));
        localFromServiceMsg.addAttribute("dwDstAppid", Long.valueOf(paramLong4));
        localFromServiceMsg.addAttribute("dwSubDstAppid", Long.valueOf(paramLong5));
        localFromServiceMsg.addAttribute("dstAppVer", paramArrayOfByte2);
        localFromServiceMsg.addAttribute("dstAppSign", paramArrayOfByte3);
        localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
        localFromServiceMsg.addAttribute("fastLoginInfo", paramWFastLoginInfo);
        localFromServiceMsg.addAttribute("wtTicket", paramWFastLoginInfo._outA1.clone());
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt2));
        localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString)
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("onGetA1WithA1 error ");
        paramArrayOfByte1.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte1.toString(), paramString);
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(this.d.getRequestSsoSeq());
      paramString.append(" found not need continue handle msg OnGetStWithoutPasswd.");
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, paramString.toString());
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.g)
    {
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("OnGetStWithoutPasswd serviceCmd=");
      paramArrayOfLong.append(this.d.getServiceCmd());
      paramArrayOfLong.append(" ssoseq=");
      paramArrayOfLong.append(this.d.getRequestSsoSeq());
      paramArrayOfLong.append(" ret=");
      paramArrayOfLong.append(paramInt2);
      paramArrayOfLong.append(" error=");
      paramArrayOfLong.append(paramErrMsg);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfLong.toString());
      try
      {
        paramArrayOfLong = u.a(this.d);
        paramArrayOfLong.setMsgSuccess();
        paramArrayOfLong.addAttribute("userAccount", paramString);
        paramArrayOfLong.addAttribute("dwSrcAppid", Long.valueOf(paramLong1));
        paramArrayOfLong.addAttribute("dwDstAppid", Long.valueOf(paramLong2));
        paramArrayOfLong.addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
        paramArrayOfLong.addAttribute("dwSubDstAppid", Long.valueOf(paramLong3));
        paramArrayOfLong.addAttribute("userSigInfo", paramWUserSigInfo);
        paramArrayOfLong.addAttribute("wtTicket", a(paramWUserSigInfo));
        paramArrayOfLong.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
        paramArrayOfLong.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
        paramArrayOfLong.addAttribute("openid", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 32768));
        paramArrayOfLong.addAttribute("accessToken", WtloginHelper.GetTicketSig(paramWUserSigInfo, 32768));
        paramArrayOfLong.addAttribute("ret", Integer.valueOf(paramInt2));
        paramArrayOfLong.addAttribute("lastError", paramErrMsg);
        this.e.addRespToQuque(this.d, paramArrayOfLong);
        return;
      }
      catch (Exception paramString)
      {
        paramArrayOfLong = new StringBuilder();
        paramArrayOfLong.append("OnGetStWithoutPasswd error ");
        paramArrayOfLong.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfLong.toString(), paramString);
        return;
      }
    }
    FromServiceMsg localFromServiceMsg = o.a(this.d);
    localFromServiceMsg.addAttribute("wtTicket", a(paramWUserSigInfo));
    localFromServiceMsg.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
    try
    {
      localFromServiceMsg.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if ((localFromServiceMsg.getAttributes().containsKey("__timestamp_net2msf")) && (localFromServiceMsg.getAttributes().containsKey("__timestamp_app2msf"))) {
      paramLong1 = ((Long)localFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)this.d.getAttribute("__timestamp_app2msf")).longValue();
    } else {
      paramLong1 = 0L;
    }
    paramLong2 = com.tencent.mobileqq.msf.core.c.j.a(this.d, localFromServiceMsg);
    int i = 0;
    int j = 0;
    if (paramInt2 != -1000)
    {
      if (paramInt2 != 0)
      {
        paramArrayOfLong = paramErrMsg.getMessage();
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnGetStWithoutPasswd2 fail, ");
        paramWUserSigInfo.append(paramInt2);
        paramWUserSigInfo.append(" ");
        paramWUserSigInfo.append(paramArrayOfLong);
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString());
        if ((paramInt2 != 1) && (paramInt2 != 192))
        {
          i = j;
          if (!util.shouldKick(paramInt2)) {}
        }
        else
        {
          paramWUserSigInfo = new StringBuilder();
          paramWUserSigInfo.append(Thread.currentThread().getName());
          paramWUserSigInfo.append(" wtlogin kickout setAccountNoLogin uin=");
          paramWUserSigInfo.append(MsfSdkUtils.getShortUin(localFromServiceMsg.getUin()));
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString());
          this.e.getAccountCenter().k(localFromServiceMsg.getUin());
          localFromServiceMsg.setBusinessFail(2001, paramArrayOfLong);
          localFromServiceMsg.addAttribute("changetoken", Boolean.valueOf(true));
          MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
          i = 1;
        }
        if (this.e.getStatReporter() != null) {
          this.e.getStatReporter().a(false, paramString, paramLong1, paramInt2, paramLong2, a(paramInt1), a(this.d));
        }
        j = i;
        if (paramInt2 == 15)
        {
          j = i;
          if (this.e.getStatReporter() != null)
          {
            this.e.getStatReporter().a(paramLong1, localFromServiceMsg.getBusinessFailCode(), paramLong2);
            j = i;
          }
        }
      }
      else
      {
        paramErrMsg = new StringBuilder();
        paramErrMsg.append(this.d.getRequestSsoSeq());
        paramErrMsg.append(" serviceCmd=");
        paramErrMsg.append(this.d.getServiceCmd());
        paramErrMsg.append(" OnGetStWithoutPasswd2 succ, dwMainSigMap=");
        paramErrMsg.append(paramInt1);
        paramErrMsg.append(", dwDstSubAppid.length=");
        if (paramArrayOfLong == null) {
          paramInt2 = 0;
        } else {
          paramInt2 = paramArrayOfLong.length;
        }
        paramErrMsg.append(paramInt2);
        paramErrMsg.append(", st.length=");
        if (paramArrayOfByte == null) {
          paramInt2 = 0;
        } else {
          paramInt2 = paramArrayOfByte.length;
        }
        paramErrMsg.append(paramInt2);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramErrMsg.toString());
        try
        {
          a(paramString);
          localFromServiceMsg.setMsgSuccess();
          paramArrayOfByte = new RespondCustomSig();
          paramArrayOfByte.reserved = new byte[0];
          paramArrayOfByte.SigList = new ArrayList();
          Object localObject = new CustomSigContent();
          ((CustomSigContent)localObject).sResult = 0;
          ((CustomSigContent)localObject).SigContent = new byte[0];
          if (this.d.getServiceCmd().equals("login.chgTok_WEBVIEW_KEY"))
          {
            paramArrayOfLong = WtloginHelper.GetTicketSig(paramWUserSigInfo, 32);
            paramArrayOfByte = WtloginHelper.GetTicketSig(paramWUserSigInfo, 4096);
            paramErrMsg = WtloginHelper.GetTicketSig(paramWUserSigInfo, 1048576);
            localObject = WtloginHelper.GetTicketSig(paramWUserSigInfo, 134217728);
            this.e.getAccountCenter().b(paramString, paramArrayOfLong);
            this.e.getAccountCenter().a(paramString, paramArrayOfByte, System.currentTimeMillis());
            this.e.getAccountCenter().a(paramString, System.currentTimeMillis());
            this.e.getAccountCenter().g.a(this.d, localFromServiceMsg);
            if ((paramWUserSigInfo._device_token != null) && (paramWUserSigInfo._device_token.length > 0)) {
              m.a(paramString, paramWUserSigInfo._device_token);
            }
            try
            {
              paramWUserSigInfo = new StringBuilder();
              paramWUserSigInfo.append("OnGetStWithoutPasswd2 ");
              paramWUserSigInfo.append(MsfSdkUtils.getShortStringKey(paramArrayOfByte));
              paramWUserSigInfo.append(" ");
              paramWUserSigInfo.append(MsfSdkUtils.getShortStringKey(paramErrMsg));
              paramWUserSigInfo.append(" ");
              paramWUserSigInfo.append(MsfSdkUtils.getShortHexKey(paramArrayOfLong));
              paramWUserSigInfo.append(" ");
              paramWUserSigInfo.append(MsfSdkUtils.getShortHexKey((byte[])localObject));
              QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString());
              if (this.e.getStatReporter() == null) {
                break label1992;
              }
              this.e.getStatReporter().a(true, paramString, paramLong1, 0, paramLong2, "WebTicket", a(this.d));
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              return;
            }
          }
          if (this.d.getServiceCmd().equals("login.chgTok_A2D2"))
          {
            byte[] arrayOfByte1 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 262144);
            byte[] arrayOfByte2 = WtloginHelper.GetTicketSig(paramWUserSigInfo, 64);
            paramErrMsg = new byte[16];
            paramArrayOfLong = new byte[0];
            try
            {
              paramWUserSigInfo = WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 262144);
              paramArrayOfLong = paramWUserSigInfo;
            }
            catch (Exception paramWUserSigInfo)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("readD2Key error ");
              localStringBuilder.append(paramWUserSigInfo);
              QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, localStringBuilder.toString());
            }
            j.a(paramErrMsg, 0, paramArrayOfLong, paramArrayOfLong.length);
            paramArrayOfLong = new CustomSigContent();
            paramArrayOfLong.sResult = 0;
            paramArrayOfLong.SigContent = new byte[0];
            paramArrayOfLong.ulSigType = 18L;
            paramArrayOfLong.SigContent = arrayOfByte1;
            paramArrayOfByte.SigList.add(paramArrayOfLong);
            ((CustomSigContent)localObject).ulSigType = 0L;
            ((CustomSigContent)localObject).SigContent = arrayOfByte2;
            paramArrayOfByte.SigList.add(localObject);
            paramArrayOfLong = new CustomSigContent();
            paramArrayOfLong.ulSigType = 20L;
            paramArrayOfLong.SigContent = paramErrMsg;
            paramArrayOfByte.SigList.add(paramArrayOfLong);
            localFromServiceMsg.addAttribute(localFromServiceMsg.getServiceCmd(), paramArrayOfByte);
            this.e.getAccountCenter().g.a(this.d, localFromServiceMsg);
            if (this.e.getStatReporter() == null) {
              return;
            }
            this.e.getStatReporter().a(true, paramString, paramLong1, 0, paramLong2, "BasicTicket", a(this.d));
            return;
          }
          if (this.d.getServiceCmd().equals("login.chgTok_DA2"))
          {
            paramArrayOfLong = WtloginHelper.GetTicketSig(paramWUserSigInfo, 33554432);
            localFromServiceMsg.getAttributes().put("da2", paramArrayOfLong);
            if (this.e.getStatReporter() != null) {
              this.e.getStatReporter().a(true, paramString, paramLong1, 0, paramLong2, "BusTicket", a(this.d));
            }
            MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
            this.e.addRespToQuque(this.d, localFromServiceMsg);
            return;
          }
          if ((paramInt1 & 0x4000) == 16384)
          {
            ((CustomSigContent)localObject).ulSigType = 16L;
            ((CustomSigContent)localObject).SigContent = WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 16384);
            paramArrayOfByte.SigList.add(localObject);
          }
          paramArrayOfLong = new UniPacket(true);
          paramArrayOfLong.setEncodeName("UTF-8");
          paramArrayOfLong.put("RespondCustomSig", paramArrayOfByte);
          localFromServiceMsg.putWupBuffer(paramArrayOfLong.encode());
          localFromServiceMsg.addAttribute(localFromServiceMsg.getServiceCmd(), paramArrayOfByte);
          if (this.a) {
            l.a(paramString);
          }
          j = i;
          if (this.e.getStatReporter() == null) {
            break label1939;
          }
          this.e.getStatReporter().a(true, paramString, paramLong1, 0, paramLong2, "OtherTicket", a(this.d));
          j = i;
        }
        catch (Exception paramString)
        {
          paramArrayOfLong = new StringBuilder();
          paramArrayOfLong.append("OnGetStWithPasswd2 error ");
          paramArrayOfLong.append(paramString.toString());
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfLong.toString(), paramString);
          j = i;
        }
      }
    }
    else
    {
      localFromServiceMsg.setBusinessFail(1002);
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd timeout");
      j = i;
      if (this.e.getStatReporter() != null)
      {
        this.e.getStatReporter().a(false, paramString, paramLong1, -1000, paramLong2, a(paramInt1), a(this.d));
        j = i;
      }
    }
    label1939:
    if (this.b)
    {
      if (j != 0)
      {
        this.e.addRespToQuque(null, localFromServiceMsg);
        return;
      }
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnGetStWithoutPasswd2 found not need contine handle msg.");
    }
    return;
    label1992:
    return;
  }
  
  public void a(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnRefreshSMSData ret:");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (this.g) {
      try
      {
        localObject = u.a(this.d);
        ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.wt_RefreshSMSData);
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).addAttribute("userAccount", paramString);
        ((FromServiceMsg)localObject).addAttribute("smsAppid", Long.valueOf(paramLong));
        ((FromServiceMsg)localObject).addAttribute("sigInfo", paramWUserSigInfo);
        ((FromServiceMsg)localObject).addAttribute("remainMsgCnt", Integer.valueOf(paramInt1));
        ((FromServiceMsg)localObject).addAttribute("timeLimit", Integer.valueOf(paramInt2));
        ((FromServiceMsg)localObject).addAttribute("ret", Integer.valueOf(paramInt3));
        ((FromServiceMsg)localObject).addAttribute("lastError", paramErrMsg);
        ((FromServiceMsg)localObject).addAttribute("smsExtraData", WtloginHelper.getLoginResultData(paramWUserSigInfo, 1347));
        if (paramInt3 == 0)
        {
          n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          n.a(paramString, this.e, this.f, this.d, (FromServiceMsg)localObject, paramErrMsg.getMessage());
          return;
        }
        ((FromServiceMsg)localObject).setBusinessFail(1001, paramErrMsg.getMessage());
        this.e.addRespToQuque(this.d, (FromServiceMsg)localObject);
        return;
      }
      catch (Exception paramString)
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnRefreshSMSData error ");
        paramWUserSigInfo.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString(), paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (this.g) {
      try
      {
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt3));
        localFromServiceMsg.addAttribute("mobile", paramString1);
        localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
        localFromServiceMsg.addAttribute("msg", paramString2);
        localFromServiceMsg.addAttribute("msgCnt", Integer.valueOf(paramInt1));
        localFromServiceMsg.addAttribute("timeLimit", Integer.valueOf(paramInt2));
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("OnRefreshSMSVerifyLoginAccount error ");
        paramString2.append(paramString1);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramString2.toString(), paramString1);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.g) {
      try
      {
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
        localFromServiceMsg.addAttribute("mobile", paramString1);
        localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
        localFromServiceMsg.addAttribute("msgCode", paramString2);
        localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnVerifySMSVerifyLoginAccount error ", paramString1);
      }
    }
  }
  
  public void a(String paramString, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.h) {
      try
      {
        paramWUserSigInfo = u.a(this.d);
        paramWUserSigInfo.setMsgSuccess();
        paramWUserSigInfo.addAttribute("userAccount", paramString);
        paramWUserSigInfo.addAttribute("pictureData", paramArrayOfByte);
        paramWUserSigInfo.addAttribute("ret", Integer.valueOf(paramInt));
        paramWUserSigInfo.addAttribute("lastError", paramErrMsg);
        this.e.addRespToQuque(this.d, paramWUserSigInfo);
        return;
      }
      catch (Exception paramString)
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnRefreshPictureData error, isVerifyPasswd, ");
        paramWUserSigInfo.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString(), paramString);
        return;
      }
    }
    if (this.g) {
      try
      {
        paramWUserSigInfo = u.a(this.d);
        paramWUserSigInfo.setMsgSuccess();
        paramWUserSigInfo.addAttribute("userAccount", paramString);
        paramWUserSigInfo.addAttribute("pictureData", paramArrayOfByte);
        paramWUserSigInfo.addAttribute("ret", Integer.valueOf(paramInt));
        paramWUserSigInfo.addAttribute("lastError", paramErrMsg);
        this.e.addRespToQuque(this.d, paramWUserSigInfo);
        return;
      }
      catch (Exception paramString)
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("OnRefreshPictureData error, appUseWt, ");
        paramWUserSigInfo.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString(), paramString);
        return;
      }
    }
    paramArrayOfByte = o.a(this.d);
    if (paramInt == 0)
    {
      n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
      this.f = paramWUserSigInfo._seqence;
      n.b(paramString, this.e, this.f, this.d, paramArrayOfByte, paramErrMsg.getMessage());
      return;
    }
    paramArrayOfByte.setBusinessFail(1001, paramErrMsg.getMessage());
    this.e.addRespToQuque(this.d, paramArrayOfByte);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, long paramLong, List paramList, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    if (this.g) {
      try
      {
        paramWUserSigInfo = new ErrMsg();
        paramWUserSigInfo.setMessage(new String(paramArrayOfByte2, "utf-8"));
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", paramString);
        localFromServiceMsg.addAttribute("appName", paramArrayOfByte1);
        localFromServiceMsg.addAttribute("time", Long.valueOf(paramLong));
        paramString = new ArrayList();
        if (paramList != null)
        {
          paramArrayOfByte1 = ((ArrayList)paramList).iterator();
          while (paramArrayOfByte1.hasNext()) {
            paramString.add(HexUtil.bytes2HexStr((byte[])paramArrayOfByte1.next()));
          }
        }
        localFromServiceMsg.addAttribute("data", paramString);
        localFromServiceMsg.addAttribute("errMsg", paramArrayOfByte2);
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
        localFromServiceMsg.addAttribute("msg", paramWUserSigInfo);
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString)
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("OnVerifyCode error ");
        paramArrayOfByte1.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte1.toString(), paramString);
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    if (this.g) {
      try
      {
        ErrMsg localErrMsg = new ErrMsg();
        localErrMsg.setMessage(new String(paramArrayOfByte2, "utf-8"));
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", paramString);
        localFromServiceMsg.addAttribute("appName", paramArrayOfByte1);
        localFromServiceMsg.addAttribute("time", Long.valueOf(paramLong));
        localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
        localFromServiceMsg.addAttribute("errMsg", paramArrayOfByte2);
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
        localFromServiceMsg.addAttribute("msg", localErrMsg);
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString)
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("OnCloseCode error ");
        paramArrayOfByte1.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte1.toString(), paramString);
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnCheckWebsigAndGetSt ret");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (this.g)
    {
      if (paramInt == 0) {
        l.d.getAccountCenter().a(false);
      }
      localObject = u.a(this.d);
      ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
      ((FromServiceMsg)localObject).setMsgSuccess();
      ((FromServiceMsg)localObject).addAttribute("userAccount", paramString);
      ((FromServiceMsg)localObject).addAttribute("userInput", paramArrayOfByte);
      ((FromServiceMsg)localObject).addAttribute("userSigInfo", paramWUserSigInfo);
      ((FromServiceMsg)localObject).addAttribute("ret", Integer.valueOf(paramInt));
      ((FromServiceMsg)localObject).addAttribute("lastError", paramErrMsg);
      ((FromServiceMsg)localObject).addAttribute("wtTicket", a(paramWUserSigInfo));
      ((FromServiceMsg)localObject).addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
      try
      {
        ((FromServiceMsg)localObject).addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      this.e.addRespToQuque(this.d, (FromServiceMsg)localObject);
      return;
    }
    Object localObject = o.a(this.d);
    ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
    ((FromServiceMsg)localObject).setMsgSuccess();
    ((FromServiceMsg)localObject).addAttribute("userAccount", paramString);
    ((FromServiceMsg)localObject).addAttribute("userInput", paramArrayOfByte);
    ((FromServiceMsg)localObject).addAttribute("sigInfo", paramWUserSigInfo);
    ((FromServiceMsg)localObject).addAttribute("ret", Integer.valueOf(paramInt));
    ((FromServiceMsg)localObject).addAttribute("lastError", paramErrMsg);
    ((FromServiceMsg)localObject).addAttribute("wtTicket", a(paramWUserSigInfo));
    ((FromServiceMsg)localObject).addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
    ((FromServiceMsg)localObject).setUin(paramWUserSigInfo.uin);
    try
    {
      ((FromServiceMsg)localObject).addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    if (paramInt != -1000)
    {
      if (paramInt != 0)
      {
        if (paramInt != 2)
        {
          if ((paramInt != 160) && (paramInt != 239))
          {
            ((FromServiceMsg)localObject).setBusinessFail(1001, paramErrMsg.getMessage());
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt failed");
          }
          else
          {
            n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
            this.f = paramWUserSigInfo._seqence;
            n.a(paramString, this.e, this.f, this.d, (FromServiceMsg)localObject, paramErrMsg.getMessage());
          }
        }
        else
        {
          n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          n.b(paramString, this.e, this.f, this.d, (FromServiceMsg)localObject, paramErrMsg.getMessage());
        }
      }
      else {
        try
        {
          a(paramString);
          n.a(this.e, l.e, this.d, (FromServiceMsg)localObject, paramString, paramWUserSigInfo);
          if (this.a)
          {
            l.a(paramString);
            return;
          }
        }
        catch (Exception paramString)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("OnCheckWebsigAndGetSt succ exception ");
          paramArrayOfByte.append(paramString.toString());
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte.toString(), paramString);
        }
      }
    }
    else
    {
      ((FromServiceMsg)localObject).setBusinessFail(1002);
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt timeout");
    }
    if (paramInt != 0)
    {
      if (paramErrMsg.getType() == 1) {
        ((FromServiceMsg)localObject).addAttribute("resp_login_url", paramErrMsg.getOtherinfo());
      }
      if ((paramInt == 116) || (paramInt == 41))
      {
        paramString = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4194304);
        if (paramString != null)
        {
          paramString = paramString._sig;
          if (paramString != null)
          {
            ((FromServiceMsg)localObject).addAttribute("resp_login_lhsig", paramString);
          }
          else if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("OnCheckWebsigAndGetSt ret: ");
            paramString.append(paramInt);
            paramString.append(" , t is null.");
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramString.toString());
          }
        }
      }
    }
    ((FromServiceMsg)localObject).addAttribute("resp_logini_ret", Integer.valueOf(paramInt));
    this.e.addRespToQuque(this.d, (FromServiceMsg)localObject);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnRefreshSMSData ret:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (this.g) {}
    for (;;)
    {
      try
      {
        localObject = u.a(this.d);
        ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.wt_CheckSMSAndGetStExt);
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).addAttribute("userAccount", paramString);
        ((FromServiceMsg)localObject).addAttribute("userInput", paramArrayOfByte);
        ((FromServiceMsg)localObject).addAttribute("sigInfo", paramWUserSigInfo);
        ((FromServiceMsg)localObject).addAttribute("st", paramArrayOfByte1);
        ((FromServiceMsg)localObject).addAttribute("ret", Integer.valueOf(paramInt));
        ((FromServiceMsg)localObject).addAttribute("lastError", paramErrMsg);
        if (paramInt != -1000)
        {
          if (paramInt != 0)
          {
            if (paramInt != 2)
            {
              if ((paramInt != 160) && (paramInt != 239))
              {
                ((FromServiceMsg)localObject).setBusinessFail(1001, paramErrMsg.getMessage());
                QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt failed");
                break label520;
              }
              n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
              this.f = paramWUserSigInfo._seqence;
              n.a(paramString, this.e, this.f, this.d, (FromServiceMsg)localObject, paramErrMsg.getMessage());
              return;
            }
            n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
            this.f = paramWUserSigInfo._seqence;
            n.b(paramString, this.e, this.f, this.d, (FromServiceMsg)localObject, paramErrMsg.getMessage());
            return;
          }
          try
          {
            a(paramString);
            n.a(this.e, l.e, this.d, (FromServiceMsg)localObject, paramString, paramWUserSigInfo);
            if (!this.a) {
              break label519;
            }
            l.a(paramString);
            return;
          }
          catch (Exception paramString)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("OnCheckPictureAndGetSt succ exception ");
            paramArrayOfByte.append(paramString.toString());
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte.toString(), paramString);
            return;
          }
        }
        ((FromServiceMsg)localObject).setBusinessFail(1002);
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt timeout");
      }
      catch (Exception paramString)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("OnCheckSMSAndGetSt error ");
        paramArrayOfByte.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte.toString(), paramString);
      }
      paramString = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4194304);
      if (paramString != null)
      {
        paramString = paramString._sig;
        if (paramString != null)
        {
          ((FromServiceMsg)localObject).addAttribute("resp_login_lhsig", paramString);
        }
        else if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("OnCheckSMSAndGetStExt ret: ");
          paramString.append(paramInt);
          paramString.append(" , t is null.");
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramString.toString());
        }
      }
      this.e.addRespToQuque(this.d, (FromServiceMsg)localObject);
      return;
      return;
      label519:
      return;
      label520:
      if (paramInt != 116) {
        if (paramInt != 41) {}
      }
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = this.g;
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt1));
    paramWUserSigInfo.attributes.put("resp_register_shNextResendTime", Integer.valueOf(paramInt2));
    paramWUserSigInfo.attributes.put("resp_register_shTotalTimeOver", Integer.valueOf(paramInt3));
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.g) {
      return;
    }
    FromServiceMsg localFromServiceMsg = o.a(this.d);
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt1));
    localFromServiceMsg.attributes.put("resp_register_shNextResendTime", Integer.valueOf(paramInt2));
    localFromServiceMsg.attributes.put("resp_register_shTotalTimeOver", Integer.valueOf(paramInt3));
    localFromServiceMsg.attributes.put("res_register_errmsg", paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("OnRegQueryClientSentMsgStatus | ret=");
      paramString.append(paramInt1);
      QLog.d("Register_WtProviderImpl", 2, paramString.toString());
    }
    if (paramInt1 == 0)
    {
      paramString = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 36);
      StringBuilder localStringBuilder;
      if (paramString != null)
      {
        paramString = new String(paramString);
        localFromServiceMsg.addAttribute("resp_register_uin", paramString);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnRegQueryClientSentMsgStatus | uin=");
          localStringBuilder.append(paramString);
          QLog.d("Register_WtProviderImpl", 2, localStringBuilder.toString());
        }
      }
      paramString = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 6);
      if (paramString != null) {
        try
        {
          paramString = new String(paramString, "utf-8");
          localFromServiceMsg.attributes.put("resp_register_nick", paramString);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("OnRegQueryClientSentMsgStatus | nick=");
            localStringBuilder.append(paramString);
            QLog.d("Register_WtProviderImpl", 2, localStringBuilder.toString());
          }
        }
        catch (UnsupportedEncodingException paramString)
        {
          paramString.printStackTrace();
        }
      }
      paramString = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 40);
      if (paramString != null)
      {
        paramString = new String(paramString);
        localFromServiceMsg.attributes.put("resp_register_picture_url", paramString);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnRegQueryClientSentMsgStatus | bindFaceUrl=");
          localStringBuilder.append(paramString);
          QLog.d("Register_WtProviderImpl", 2, localStringBuilder.toString());
        }
      }
      paramWUserSigInfo = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 51);
      if (paramWUserSigInfo != null)
      {
        paramWUserSigInfo = new String(paramWUserSigInfo);
        localFromServiceMsg.attributes.put("resp_phone_protect_uins_url", paramWUserSigInfo);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("OnRegQueryClientSentMsgStatus | phoneProtectUinsUrl=");
          paramString.append(paramWUserSigInfo);
          QLog.d("Register_WtProviderImpl", 2, paramString.toString());
        }
      }
    }
    this.e.addRespToQuque(this.d, localFromServiceMsg);
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    paramWUserSigInfo.attributes.put("resp_register_uin", String.valueOf(paramLong));
    paramWUserSigInfo.attributes.put("resp_register_contactssig", paramArrayOfByte2);
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte3);
    paramWUserSigInfo.attributes.put("resp_register_supersig", paramArrayOfByte1);
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRegGetAccount lhsig success");
      }
      paramWUserSigInfo.attributes.put("resp_register_lh_sig", paramArrayOfByte4);
    }
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnCheckDevLockSms ret:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (this.g) {
      try
      {
        localObject = u.a(this.d);
        ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.wt_CheckDevLockSms);
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).addAttribute("sigInfo", paramWUserSigInfo);
        ((FromServiceMsg)localObject).addAttribute("ret", Integer.valueOf(paramInt));
        ((FromServiceMsg)localObject).addAttribute("lastError", paramErrMsg);
        this.e.addRespToQuque(this.d, (FromServiceMsg)localObject);
        return;
      }
      catch (Exception paramWUserSigInfo)
      {
        paramErrMsg = new StringBuilder();
        paramErrMsg.append("OnCheckDevLockSms error ");
        paramErrMsg.append(paramWUserSigInfo);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramErrMsg.toString(), paramWUserSigInfo);
      }
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.g)
    {
      paramWUserSigInfo = o.a(this.d);
      paramWUserSigInfo.setBusinessFail(3001, String.valueOf(paramInt));
      paramWUserSigInfo.attributes.put("msg", paramArrayOfByte);
      MsfSdkUtils.addFromMsgProcessName("*", paramWUserSigInfo);
      this.e.addRespToQuque(this.d, paramWUserSigInfo);
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("found RegError ");
      paramWUserSigInfo.append(paramInt);
      paramWUserSigInfo.append(" on call ");
      paramWUserSigInfo.append(this.d.getServiceCmd());
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString());
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    if ((paramInt != 7) && (paramInt != 59))
    {
      paramWUserSigInfo.setBusinessFail(3001, String.valueOf(paramInt));
      paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
      MsfSdkUtils.addFromMsgProcessName("*", paramWUserSigInfo);
    }
    else
    {
      paramWUserSigInfo.setMsgSuccess();
      paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
      paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    }
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
    paramWUserSigInfo = new StringBuilder();
    paramWUserSigInfo.append("found RegError ");
    paramWUserSigInfo.append(paramInt);
    paramWUserSigInfo.append(" on call ");
    paramWUserSigInfo.append(this.d.getServiceCmd());
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramWUserSigInfo.toString());
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, String paramString)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(2));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramString.getBytes());
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, String paramString1, String paramString2)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(4));
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramString2.getBytes());
    }
    else
    {
      paramWUserSigInfo.setMsgSuccess();
      paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramString1.getBytes());
    }
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnCheckDevLockStatus ret:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (this.g) {
      try
      {
        localObject = u.a(this.d);
        ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.wt_CheckDevLockStatus);
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).addAttribute("sigInfo", paramWUserSigInfo);
        ((FromServiceMsg)localObject).addAttribute("devLockInfo", paramDevlockInfo);
        ((FromServiceMsg)localObject).addAttribute("ret", Integer.valueOf(paramInt));
        ((FromServiceMsg)localObject).addAttribute("lastError", paramErrMsg);
        this.e.addRespToQuque(this.d, (FromServiceMsg)localObject);
        return;
      }
      catch (Exception paramWUserSigInfo)
      {
        paramDevlockInfo = new StringBuilder();
        paramDevlockInfo.append("OnCheckDevLockStatus error ");
        paramDevlockInfo.append(paramWUserSigInfo);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramDevlockInfo.toString(), paramWUserSigInfo);
      }
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(8));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, Object paramObject)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(9));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  byte[] a(WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = this.d.getAttribute("targetTicket");
    int i;
    if ((localObject != null) && ((localObject instanceof Integer))) {
      i = ((Integer)localObject).intValue();
    } else {
      i = 4096;
    }
    return WtloginHelper.GetTicketSig(paramWUserSigInfo, i);
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnCheckPictureAndGetSt ret");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (this.h) {
      try
      {
        paramWUserSigInfo = u.a(this.d);
        paramWUserSigInfo.setServiceCmd("login.verifyPasswdImage");
        paramWUserSigInfo.setMsfCommand(MsfCommand.verifyPasswdImage);
        paramWUserSigInfo.addAttribute("userAccount", paramString);
        paramWUserSigInfo.addAttribute("userInput", paramArrayOfByte);
        paramWUserSigInfo.addAttribute("ret", Integer.valueOf(paramInt));
        paramWUserSigInfo.addAttribute("lastError", paramErrMsg);
        if (paramInt != 0)
        {
          if (paramInt == 2)
          {
            paramWUserSigInfo.addAttribute("image_buf", l.e.GetPictureData(paramString));
            paramWUserSigInfo.setBusinessFail(2020, paramErrMsg.getMessage());
          }
        }
        else {
          paramWUserSigInfo.setMsgSuccess();
        }
        this.e.addRespToQuque(this.d, paramWUserSigInfo);
        return;
      }
      catch (Exception paramString)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("OnCheckPictureAndGetSt error, veryify pwd, ");
        paramArrayOfByte.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte.toString(), paramString);
        return;
      }
    }
    if (this.g) {}
    label985:
    for (;;)
    {
      try
      {
        localObject = new byte[0];
        if (paramInt != 0)
        {
          if (paramInt != 2) {
            break label985;
          }
          localObject = l.e.GetPictureData(paramString);
        }
        else
        {
          l.d.getAccountCenter().a(false);
          break label985;
        }
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsfCommand(MsfCommand.wt_CheckPictureAndGetSt);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", paramString);
        localFromServiceMsg.addAttribute("userInput", paramArrayOfByte);
        localFromServiceMsg.addAttribute("image_buf", localObject);
        localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
        localFromServiceMsg.addAttribute("lastError", paramErrMsg);
        localFromServiceMsg.addAttribute("wtTicket", a(paramWUserSigInfo));
        localFromServiceMsg.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
        try
        {
          localFromServiceMsg.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("OnCheckPictureAndGetSt error, appuserwt, ");
        paramArrayOfByte.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte.toString(), paramString);
        return;
      }
      localObject = o.a(this.d);
      ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.wt_CheckPictureAndGetSt);
      ((FromServiceMsg)localObject).setMsgSuccess();
      ((FromServiceMsg)localObject).addAttribute("userAccount", paramString);
      ((FromServiceMsg)localObject).addAttribute("userInput", paramArrayOfByte);
      ((FromServiceMsg)localObject).addAttribute("sigInfo", paramWUserSigInfo);
      ((FromServiceMsg)localObject).addAttribute("ret", Integer.valueOf(paramInt));
      ((FromServiceMsg)localObject).addAttribute("lastError", paramErrMsg);
      ((FromServiceMsg)localObject).addAttribute("wtTicket", a(paramWUserSigInfo));
      ((FromServiceMsg)localObject).addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
      ((FromServiceMsg)localObject).setUin(paramWUserSigInfo.uin);
      try
      {
        ((FromServiceMsg)localObject).addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      if (paramInt != -1000)
      {
        if (paramInt != 0)
        {
          if (paramInt != 2)
          {
            if ((paramInt != 160) && (paramInt != 239))
            {
              ((FromServiceMsg)localObject).setBusinessFail(1001, paramErrMsg.getMessage());
              QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt failed");
            }
            else
            {
              n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
              this.f = paramWUserSigInfo._seqence;
              n.a(paramString, this.e, this.f, this.d, (FromServiceMsg)localObject, paramErrMsg.getMessage());
            }
          }
          else
          {
            n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
            this.f = paramWUserSigInfo._seqence;
            n.b(paramString, this.e, this.f, this.d, (FromServiceMsg)localObject, paramErrMsg.getMessage());
          }
        }
        else {
          try
          {
            a(paramString);
            n.a(this.e, l.e, this.d, (FromServiceMsg)localObject, paramString, paramWUserSigInfo);
            if (this.a)
            {
              l.a(paramString);
              return;
            }
          }
          catch (Exception paramString)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("OnCheckPictureAndGetSt succ exception ");
            paramArrayOfByte.append(paramString.toString());
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte.toString(), paramString);
          }
        }
      }
      else
      {
        ((FromServiceMsg)localObject).setBusinessFail(1002);
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt timeout");
      }
      if (paramInt != 0)
      {
        if (paramErrMsg.getType() == 1) {
          ((FromServiceMsg)localObject).addAttribute("resp_login_url", paramErrMsg.getOtherinfo());
        }
        if ((paramInt == 116) || (paramInt == 41))
        {
          paramString = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4194304);
          if (paramString != null)
          {
            paramString = paramString._sig;
            if (paramString != null)
            {
              ((FromServiceMsg)localObject).addAttribute("resp_login_lhsig", paramString);
            }
            else if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("OnCheckPictureAndGetSt ret: ");
              paramString.append(paramInt);
              paramString.append(" , t is null.");
              QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramString.toString());
            }
          }
        }
      }
      ((FromServiceMsg)localObject).addAttribute("resp_logini_ret", Integer.valueOf(paramInt));
      this.e.addRespToQuque(this.d, (FromServiceMsg)localObject);
      return;
    }
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnCloseDevLock ret:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (this.g) {
      try
      {
        localObject = u.a(this.d);
        ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.wt_CloseDevLock);
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).addAttribute("sigInfo", paramWUserSigInfo);
        ((FromServiceMsg)localObject).addAttribute("ret", Integer.valueOf(paramInt));
        ((FromServiceMsg)localObject).addAttribute("lastError", paramErrMsg);
        this.e.addRespToQuque(this.d, (FromServiceMsg)localObject);
        return;
      }
      catch (Exception paramWUserSigInfo)
      {
        paramErrMsg = new StringBuilder();
        paramErrMsg.append("OnCloseDevLock error ");
        paramErrMsg.append(paramWUserSigInfo);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramErrMsg.toString(), paramWUserSigInfo);
      }
    }
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("WtProviderImpl.OnRegQueryAccount ret = ");
      paramWUserSigInfo.append(paramInt);
      paramWUserSigInfo.append(" appUseWt=");
      paramWUserSigInfo.append(this.g);
      QLog.d("queryMobile", 2, paramWUserSigInfo.toString());
    }
    if (this.g) {
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnAskDevLockSms ret:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (this.g) {
      try
      {
        localObject = u.a(this.d);
        ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.wt_AskDevLockSms);
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).addAttribute("sigInfo", paramWUserSigInfo);
        ((FromServiceMsg)localObject).addAttribute("devLockInfo", paramDevlockInfo);
        ((FromServiceMsg)localObject).addAttribute("ret", Integer.valueOf(paramInt));
        ((FromServiceMsg)localObject).addAttribute("lastError", paramErrMsg);
        this.e.addRespToQuque(this.d, (FromServiceMsg)localObject);
        return;
      }
      catch (Exception paramWUserSigInfo)
      {
        paramDevlockInfo = new StringBuilder();
        paramDevlockInfo.append("OnAskDevLockSms error ");
        paramDevlockInfo.append(paramWUserSigInfo);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramDevlockInfo.toString(), paramWUserSigInfo);
      }
    }
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(3));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void c(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnRefreshSMSData ret:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, ((StringBuilder)localObject).toString());
    }
    if (this.g) {}
    for (;;)
    {
      try
      {
        localObject = u.a(this.d);
        ((FromServiceMsg)localObject).setMsfCommand(MsfCommand.wt_CheckSMSAndGetSt);
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).addAttribute("userAccount", paramString);
        ((FromServiceMsg)localObject).addAttribute("userInput", paramArrayOfByte);
        ((FromServiceMsg)localObject).addAttribute("sigInfo", paramWUserSigInfo);
        ((FromServiceMsg)localObject).addAttribute("ret", Integer.valueOf(paramInt));
        ((FromServiceMsg)localObject).addAttribute("lastError", paramErrMsg);
        ((FromServiceMsg)localObject).addAttribute("userSigInfo", paramWUserSigInfo);
        ((FromServiceMsg)localObject).addAttribute("wtTicket", a(paramWUserSigInfo));
        ((FromServiceMsg)localObject).addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
        try
        {
          ((FromServiceMsg)localObject).addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
        ((FromServiceMsg)localObject).addAttribute("smsExtraData", WtloginHelper.getLoginResultData(paramWUserSigInfo, 1347));
        if (paramInt != -1000)
        {
          if (paramInt != 0)
          {
            if (paramInt != 2)
            {
              if ((paramInt != 160) && (paramInt != 239))
              {
                ((FromServiceMsg)localObject).setBusinessFail(1001, paramErrMsg.getMessage());
                QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt failed");
                break label588;
              }
              n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
              this.f = paramWUserSigInfo._seqence;
              n.a(paramString, this.e, this.f, this.d, (FromServiceMsg)localObject, paramErrMsg.getMessage());
              return;
            }
            n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
            this.f = paramWUserSigInfo._seqence;
            n.b(paramString, this.e, this.f, this.d, (FromServiceMsg)localObject, paramErrMsg.getMessage());
            return;
          }
          try
          {
            a(paramString);
            n.a(this.e, l.e, this.d, (FromServiceMsg)localObject, paramString, paramWUserSigInfo);
            if (!this.a) {
              break label587;
            }
            l.a(paramString);
            return;
          }
          catch (Exception paramString)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("OnCheckPictureAndGetSt succ exception ");
            paramArrayOfByte.append(paramString.toString());
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte.toString(), paramString);
            return;
          }
        }
        ((FromServiceMsg)localObject).setBusinessFail(1002);
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt timeout");
      }
      catch (Exception paramString)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("OnCheckSMSAndGetSt error ");
        paramArrayOfByte.append(paramString);
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramArrayOfByte.toString(), paramString);
      }
      paramString = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4194304);
      if (paramString != null)
      {
        paramString = paramString._sig;
        if (paramString != null)
        {
          ((FromServiceMsg)localObject).addAttribute("resp_login_lhsig", paramString);
        }
        else if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("OnCheckSMSAndGetSt ret: ");
          paramString.append(paramInt);
          paramString.append(" , t is null.");
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, paramString.toString());
        }
      }
      this.e.addRespToQuque(this.d, (FromServiceMsg)localObject);
      return;
      return;
      label587:
      return;
      label588:
      if (paramInt != 116) {
        if (paramInt != 41) {}
      }
    }
  }
  
  public void c(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(1));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void d(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = this.g;
    FromServiceMsg localFromServiceMsg = o.a(this.d);
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    localFromServiceMsg.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("OnRegSubmitMsgChk | ret=");
      paramArrayOfByte.append(paramInt);
      QLog.d("Login_Optimize_WtProviderImpl", 2, paramArrayOfByte.toString());
    }
    if (paramInt == 0)
    {
      paramArrayOfByte = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 36);
      StringBuilder localStringBuilder;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        localFromServiceMsg.addAttribute("bind_qq_uin", paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnRegSubmitMsgChk | uin=");
          localStringBuilder.append(paramArrayOfByte);
          QLog.d("Login_Optimize_WtProviderImpl", 2, localStringBuilder.toString());
        }
      }
      paramArrayOfByte = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 6);
      if (paramArrayOfByte != null) {
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
          localFromServiceMsg.attributes.put("resp_verify_account_nick", paramArrayOfByte);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("OnRegSubmitMsgChk | bindQQNick=");
            localStringBuilder.append(paramArrayOfByte);
            QLog.d("Login_Optimize_WtProviderImpl", 2, localStringBuilder.toString());
          }
        }
        catch (UnsupportedEncodingException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
      paramArrayOfByte = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 40);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        localFromServiceMsg.attributes.put("resp_verify_account_faceUrl", paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnRegSubmitMsgChk | bindFaceUrl=");
          localStringBuilder.append(paramArrayOfByte);
          QLog.d("Login_Optimize_WtProviderImpl", 2, localStringBuilder.toString());
        }
      }
      paramWUserSigInfo = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 51);
      if (paramWUserSigInfo != null)
      {
        paramWUserSigInfo = new String(paramWUserSigInfo);
        localFromServiceMsg.attributes.put("resp_phone_protect_uins_url", paramWUserSigInfo);
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("OnRegSubmitMsgChk | phoneProtectUinsUrl=");
          paramArrayOfByte.append(paramWUserSigInfo);
          QLog.d("Login_Optimize_WtProviderImpl", 2, paramArrayOfByte.toString());
        }
      }
    }
    this.e.addRespToQuque(this.d, localFromServiceMsg);
  }
  
  public void e(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("ret=");
      paramWUserSigInfo.append(paramInt);
      QLog.d("Login_Optimize_WtProviderImpl", 2, paramWUserSigInfo.toString());
    }
    if (this.g) {
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void f(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.g) {
      return;
    }
    FromServiceMsg localFromServiceMsg = o.a(this.d);
    localFromServiceMsg.setMsgSuccess();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ret=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Login_Optimize_WtProviderImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 31);
    if (localObject != null)
    {
      localObject = String.valueOf(util.buf_to_int64((byte[])localObject, 0));
      localFromServiceMsg.attributes.put("resp_register_uin", localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin=");
        localStringBuilder.append((String)localObject);
        QLog.d("Login_Optimize_WtProviderImpl", 2, localStringBuilder.toString());
      }
    }
    paramWUserSigInfo = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 30);
    if (paramWUserSigInfo != null)
    {
      paramWUserSigInfo = new String(paramWUserSigInfo);
      localFromServiceMsg.attributes.put("to_register_cr_mobile", paramWUserSigInfo);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("phoneNum=");
        ((StringBuilder)localObject).append(paramWUserSigInfo);
        QLog.d("Login_Optimize_WtProviderImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
    localFromServiceMsg.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    localFromServiceMsg.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, localFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.p
 * JD-Core Version:    0.7.0.1
 */