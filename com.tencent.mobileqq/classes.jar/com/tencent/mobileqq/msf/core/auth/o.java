package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
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

class o
{
  boolean a = false;
  boolean b = true;
  WtloginMsfListener c;
  ToServiceMsg d;
  MsfCore e;
  long f;
  boolean g = false;
  boolean h = false;
  
  public o(MsfCore paramMsfCore, ToServiceMsg paramToServiceMsg)
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
    if ((this.d != null) && (this.d.getAttributes().get("refresh_token_src") != null)) {
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
  
  public void a(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("userAccount", Long.valueOf(paramLong));
      localFromServiceMsg.addAttribute("supersig", paramArrayOfByte1);
      localFromServiceMsg.addAttribute("contactssig", paramArrayOfByte2);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("msg", paramArrayOfByte3);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRegGetSMSVerifyLoginAccount error " + paramArrayOfByte1, paramArrayOfByte1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
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
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSVerifyLoginAccount error " + paramString1, paramString1);
    }
  }
  
  public void a(String paramString, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnException " + paramString);
    if (this.g) {
      try
      {
        paramWUserSigInfo = com.tencent.mobileqq.msf.service.l.a(this.d);
        paramWUserSigInfo.setBusinessFail(3002, paramString);
        paramWUserSigInfo.addAttribute("error", paramString);
        paramWUserSigInfo.addAttribute("cmd", Integer.valueOf(paramInt));
        this.e.addRespToQuque(this.d, paramWUserSigInfo);
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnException error " + paramString, paramString);
        return;
      }
    }
    paramWUserSigInfo = t.a(this.d);
    paramWUserSigInfo.setBusinessFail(3001, paramString);
    MsfSdkUtils.addFromMsgProcessName("*", paramWUserSigInfo);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
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
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStViaSMSVerifyLogin error " + paramString, paramString);
    }
  }
  
  public void a(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, this.d.getRequestSsoSeq() + " OnGetStWithPasswd " + paramErrMsg.getMessage() + " " + MsfSdkUtils.getShortUin(paramString1) + ",  isVerifyPasswd=" + this.h + " appUseWt=" + this.g + " ret=" + paramInt2 + " " + this.d);
    Object localObject1;
    if (this.h)
    {
      localObject1 = t.a(this.d);
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
      switch (paramInt2)
      {
      default: 
        ((FromServiceMsg)localObject1).setBusinessFail(1001, paramErrMsg.getMessage());
      }
      for (;;)
      {
        this.e.addRespToQuque(this.d, (FromServiceMsg)localObject1);
        return;
        ((FromServiceMsg)localObject1).setMsgSuccess();
        continue;
        ((FromServiceMsg)localObject1).setBusinessFail(2020, paramErrMsg.getMessage());
        paramErrMsg = l.e.GetPictureData(((FromServiceMsg)localObject1).getUin(), paramWUserSigInfo._seqence);
        paramString2 = new VerifyCodeInfo();
        paramString2.ssoSeq = ((FromServiceMsg)localObject1).getRequestSsoSeq();
        paramString2.verifyimage = paramErrMsg;
        try
        {
          paramString2.verifyNote = m.a(paramString1, l.e.GetPicturePrompt(paramString1, paramWUserSigInfo._seqence));
          ((FromServiceMsg)localObject1).addAttribute("resp_verify_image", paramString2.verifyimage);
          ((FromServiceMsg)localObject1).addAttribute("resp_verify_msg", paramString2.verifyNote);
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "getImagePrompt exception " + paramString1.toString(), paramString1);
            paramString2.verifyNote = "getTipErr";
          }
        }
        ((FromServiceMsg)localObject1).setBusinessFail(2005, paramErrMsg.getMessage());
        continue;
        ((FromServiceMsg)localObject1).setBusinessFail(1002);
      }
    }
    if (this.g) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new byte[0];
        localObject1 = localObject2;
        switch (paramInt2)
        {
        case 1: 
          localObject2 = com.tencent.mobileqq.msf.service.l.a(this.d);
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
      }
      catch (Exception paramString1)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd error " + paramString1, paramString1);
        return;
      }
      if (TextUtils.isEmpty(paramErrMsg.getOtherinfo()))
      {
        localObject1 = l.e.GetPictureData(paramString1);
      }
      else
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "puzzle CAPTCHA " + paramErrMsg.getOtherinfo());
          localObject1 = localObject2;
          continue;
          l.d.getAccountCenter().a(false);
          localObject1 = localObject2;
          continue;
          localObject1 = t.a(this.d);
          ((FromServiceMsg)localObject1).setMsgSuccess();
          ((FromServiceMsg)localObject1).addAttribute("userAccount", paramString1);
          ((FromServiceMsg)localObject1).addAttribute("dwAppid", Long.valueOf(paramLong1));
          ((FromServiceMsg)localObject1).addAttribute("dwMainSigMap", Integer.valueOf(paramInt1));
          ((FromServiceMsg)localObject1).addAttribute("dwSubDstAppid", Long.valueOf(paramLong2));
          ((FromServiceMsg)localObject1).addAttribute("userPasswd", paramString2);
          ((FromServiceMsg)localObject1).addAttribute("userSigInfo", paramWUserSigInfo);
          ((FromServiceMsg)localObject1).addAttribute("wtTicket", a(paramWUserSigInfo));
          ((FromServiceMsg)localObject1).addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
          for (;;)
          {
            for (;;)
            {
              try
              {
                ((FromServiceMsg)localObject1).addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
                ((FromServiceMsg)localObject1).addAttribute("ret", Integer.valueOf(paramInt2));
                ((FromServiceMsg)localObject1).addAttribute("lastError", paramErrMsg);
                ((FromServiceMsg)localObject1).setUin(paramWUserSigInfo.uin);
                switch (paramInt2)
                {
                default: 
                  QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd fail, " + paramErrMsg.getMessage());
                  ((FromServiceMsg)localObject1).setBusinessFail(1001, paramErrMsg.getMessage());
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
                        if (paramString1 == null) {
                          break label1518;
                        }
                        ((FromServiceMsg)localObject1).addAttribute("resp_login_lhsig", paramString1);
                      }
                    }
                  }
                  ((FromServiceMsg)localObject1).addAttribute("resp_logini_ret", Integer.valueOf(paramInt2));
                  this.e.addRespToQuque(this.d, (FromServiceMsg)localObject1);
                  return;
                }
              }
              catch (Exception paramString2)
              {
                paramString2.printStackTrace();
                continue;
                m.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
                this.f = paramWUserSigInfo._seqence;
                if (TextUtils.isEmpty(paramErrMsg.getOtherinfo()))
                {
                  m.b(paramString1, this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getMessage());
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "appUseWt = false; puzzle CAPTCHA " + paramErrMsg.getOtherinfo());
                }
                m.a(this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getOtherinfo());
                return;
              }
              m.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
              this.f = paramWUserSigInfo._seqence;
              m.a(paramString1, this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getMessage());
              return;
              a(paramString1);
              if ((paramWUserSigInfo != null) && (paramWUserSigInfo._login_bitmap == 0)) {
                try
                {
                  m.a(this.e, l.e, this.d, (FromServiceMsg)localObject1, paramString1, paramWUserSigInfo);
                  if (!this.a) {
                    break;
                  }
                  l.a(paramString1);
                  return;
                }
                catch (Exception paramString1)
                {
                  QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd succ exception " + paramString1.toString(), paramString1);
                  return;
                }
              }
            }
            ((FromServiceMsg)localObject1).setMsgSuccess();
            ((FromServiceMsg)localObject1).addAttribute("__attribute_tag_servertimediff", Long.valueOf(l.e.GetTimeDifference() * 1000L));
            continue;
            ((FromServiceMsg)localObject1).setBusinessFail(2005, paramErrMsg.getMessage());
            continue;
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd timeout");
            ((FromServiceMsg)localObject1).setBusinessFail(1002);
            continue;
            label1518:
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd ret: " + paramInt2 + " , t is null.");
          }
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
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
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "onGetA1WithA1 error " + paramString, paramString);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, this.d.getRequestSsoSeq() + " found not need continue handle msg OnGetStWithoutPasswd.");
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, int paramInt2, ErrMsg paramErrMsg)
  {
    if (this.g) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd serviceCmd=" + this.d.getServiceCmd() + " ssoseq=" + this.d.getRequestSsoSeq() + " ret=" + paramInt2 + " error=" + paramErrMsg);
    }
    label825:
    label1209:
    do
    {
      for (;;)
      {
        try
        {
          paramArrayOfLong = com.tencent.mobileqq.msf.service.l.a(this.d);
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
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd error " + paramString, paramString);
          return;
        }
        FromServiceMsg localFromServiceMsg = t.a(this.d);
        localFromServiceMsg.addAttribute("wtTicket", a(paramWUserSigInfo));
        localFromServiceMsg.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
        try
        {
          localFromServiceMsg.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
          paramLong2 = 0L;
          paramLong1 = paramLong2;
          if (localFromServiceMsg.getAttributes().containsKey("__timestamp_net2msf"))
          {
            paramLong1 = paramLong2;
            if (localFromServiceMsg.getAttributes().containsKey("__timestamp_app2msf")) {
              paramLong1 = ((Long)localFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)this.d.getAttribute("__timestamp_app2msf")).longValue();
            }
          }
          paramLong2 = com.tencent.mobileqq.msf.core.c.j.a(this.d, localFromServiceMsg);
          i = 0;
          j = 0;
          switch (paramInt2)
          {
          default: 
            paramArrayOfLong = paramErrMsg.getMessage();
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd2 fail, " + paramInt2 + " " + paramArrayOfLong);
            if ((paramInt2 != 1) && (paramInt2 != 192))
            {
              i = j;
              if (!util.shouldKick(paramInt2)) {}
            }
            else
            {
              QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, Thread.currentThread().getName() + " wtlogin kickout setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(localFromServiceMsg.getUin()));
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
            if (this.b) {
              if (j != 0)
              {
                this.e.addRespToQuque(null, localFromServiceMsg);
                return;
              }
            }
            break;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i;
            localException.printStackTrace();
            continue;
            paramErrMsg = new StringBuilder().append(this.d.getRequestSsoSeq()).append(" serviceCmd=").append(this.d.getServiceCmd()).append(" OnGetStWithoutPasswd2 succ, dwMainSigMap=").append(paramInt1).append(", dwDstSubAppid.length=");
            if (paramArrayOfLong == null)
            {
              paramInt2 = 0;
              paramArrayOfLong = paramErrMsg.append(paramInt2).append(", st.length=");
              if (paramArrayOfByte != null) {
                break label1201;
              }
            }
            CustomSigContent localCustomSigContent;
            for (paramInt2 = 0;; paramInt2 = paramArrayOfByte.length)
            {
              for (;;)
              {
                QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, paramInt2);
                try
                {
                  for (;;)
                  {
                    a(paramString);
                    localFromServiceMsg.setMsgSuccess();
                    paramArrayOfByte = new RespondCustomSig();
                    paramArrayOfByte.reserved = new byte[0];
                    paramArrayOfByte.SigList = new ArrayList();
                    localCustomSigContent = new CustomSigContent();
                    localCustomSigContent.sResult = 0;
                    localCustomSigContent.SigContent = new byte[0];
                    if (!this.d.getServiceCmd().equals("login.chgTok_WEBVIEW_KEY")) {
                      break label1209;
                    }
                    paramArrayOfLong = WtloginHelper.GetTicketSig(paramWUserSigInfo, 32);
                    paramArrayOfByte = WtloginHelper.GetTicketSig(paramWUserSigInfo, 4096);
                    paramErrMsg = WtloginHelper.GetTicketSig(paramWUserSigInfo, 1048576);
                    paramWUserSigInfo = WtloginHelper.GetTicketSig(paramWUserSigInfo, 134217728);
                    this.e.getAccountCenter().b(paramString, paramArrayOfLong);
                    this.e.getAccountCenter().a(paramString, paramArrayOfByte, System.currentTimeMillis());
                    this.e.getAccountCenter().a(paramString, System.currentTimeMillis());
                    this.e.getAccountCenter().g.a(this.d, localFromServiceMsg);
                    try
                    {
                      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd2 " + MsfSdkUtils.getShortStringKey(paramArrayOfByte) + " " + MsfSdkUtils.getShortStringKey(paramErrMsg) + " " + MsfSdkUtils.getShortHexKey(paramArrayOfLong) + " " + MsfSdkUtils.getShortHexKey(paramWUserSigInfo));
                      if (this.e.getStatReporter() == null) {
                        break;
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
                }
                catch (Exception paramString)
                {
                  QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithPasswd2 error " + paramString.toString(), paramString);
                  j = i;
                }
              }
              paramInt2 = paramArrayOfLong.length;
              break label825;
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
                for (;;)
                {
                  QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "readD2Key error " + paramWUserSigInfo);
                }
              }
              j.a(paramErrMsg, 0, paramArrayOfLong, paramArrayOfLong.length);
              paramArrayOfLong = new CustomSigContent();
              paramArrayOfLong.sResult = 0;
              paramArrayOfLong.SigContent = new byte[0];
              paramArrayOfLong.ulSigType = 18L;
              paramArrayOfLong.SigContent = arrayOfByte1;
              paramArrayOfByte.SigList.add(paramArrayOfLong);
              localCustomSigContent.ulSigType = 0L;
              localCustomSigContent.SigContent = arrayOfByte2;
              paramArrayOfByte.SigList.add(localCustomSigContent);
              paramArrayOfLong = new CustomSigContent();
              paramArrayOfLong.ulSigType = 20L;
              paramArrayOfLong.SigContent = paramErrMsg;
              paramArrayOfByte.SigList.add(paramArrayOfLong);
              localFromServiceMsg.addAttribute(localFromServiceMsg.getServiceCmd(), paramArrayOfByte);
              this.e.getAccountCenter().g.a(this.d, localFromServiceMsg);
              if (this.e.getStatReporter() == null) {
                break;
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
              localCustomSigContent.ulSigType = 16L;
              localCustomSigContent.SigContent = WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 16384);
              paramArrayOfByte.SigList.add(localCustomSigContent);
            }
            paramArrayOfLong = new UniPacket(true);
            paramArrayOfLong.setEncodeName("UTF-8");
            paramArrayOfLong.put("RespondCustomSig", paramArrayOfByte);
            localFromServiceMsg.putWupBuffer(paramArrayOfLong.encode());
            localFromServiceMsg.addAttribute(localFromServiceMsg.getServiceCmd(), paramArrayOfByte);
            if (this.a) {
              l.a(paramString);
            }
            int j = i;
            if (this.e.getStatReporter() != null)
            {
              this.e.getStatReporter().a(true, paramString, paramLong1, 0, paramLong2, "OtherTicket", a(this.d));
              j = i;
              continue;
              localFromServiceMsg.setBusinessFail(1002);
              QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd timeout");
              j = i;
              if (this.e.getStatReporter() != null)
              {
                this.e.getStatReporter().a(false, paramString, paramLong1, -1000, paramLong2, a(paramInt1), a(this.d));
                j = i;
              }
            }
          }
          this.e.addRespToQuque(this.d, localFromServiceMsg);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    label1201:
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnGetStWithoutPasswd2 found not need contine handle msg.");
  }
  
  public void a(String paramString, long paramLong, WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRefreshSMSData ret:" + paramInt3);
    }
    if (this.g) {
      try
      {
        FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
        localFromServiceMsg.setMsfCommand(MsfCommand.wt_RefreshSMSData);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", paramString);
        localFromServiceMsg.addAttribute("smsAppid", Long.valueOf(paramLong));
        localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
        localFromServiceMsg.addAttribute("remainMsgCnt", Integer.valueOf(paramInt1));
        localFromServiceMsg.addAttribute("timeLimit", Integer.valueOf(paramInt2));
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt3));
        localFromServiceMsg.addAttribute("lastError", paramErrMsg);
        if (paramInt3 == 0)
        {
          m.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          m.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
        }
        localFromServiceMsg.setBusinessFail(1001, paramErrMsg.getMessage());
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshSMSData error " + paramString, paramString);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
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
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshSMSVerifyLoginAccount error " + paramString1, paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("mobile", paramString1);
      localFromServiceMsg.addAttribute("errMsg", paramErrMsg);
      localFromServiceMsg.addAttribute("msgCode", paramString2);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnVerifySMSVerifyLoginAccount error " + paramString1, paramString1);
    }
  }
  
  public void a(String paramString, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.h) {
      try
      {
        paramWUserSigInfo = com.tencent.mobileqq.msf.service.l.a(this.d);
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
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshPictureData error, isVerifyPasswd, " + paramString, paramString);
        return;
      }
    }
    if (this.g) {
      try
      {
        paramWUserSigInfo = com.tencent.mobileqq.msf.service.l.a(this.d);
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
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshPictureData error, appUseWt, " + paramString, paramString);
        return;
      }
    }
    paramArrayOfByte = t.a(this.d);
    if (paramInt == 0)
    {
      m.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
      this.f = paramWUserSigInfo._seqence;
      m.b(paramString, this.e, this.f, this.d, paramArrayOfByte, paramErrMsg.getMessage());
      return;
    }
    paramArrayOfByte.setBusinessFail(1001, paramErrMsg.getMessage());
    this.e.addRespToQuque(this.d, paramArrayOfByte);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, long paramLong, List paramList, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    FromServiceMsg localFromServiceMsg;
    if (this.g) {
      try
      {
        paramWUserSigInfo = new ErrMsg();
        paramWUserSigInfo.setMessage(new String(paramArrayOfByte2, "utf-8"));
        localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", paramString);
        localFromServiceMsg.addAttribute("appName", paramArrayOfByte1);
        localFromServiceMsg.addAttribute("time", Long.valueOf(paramLong));
        paramString = new ArrayList();
        if (paramList != null)
        {
          paramArrayOfByte1 = ((ArrayList)paramList).iterator();
          while (paramArrayOfByte1.hasNext())
          {
            paramString.add(HexUtil.bytes2HexStr((byte[])paramArrayOfByte1.next()));
            continue;
            return;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnVerifyCode error " + paramString, paramString);
      }
    }
    localFromServiceMsg.addAttribute("data", paramString);
    localFromServiceMsg.addAttribute("errMsg", paramArrayOfByte2);
    localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
    localFromServiceMsg.addAttribute("msg", paramWUserSigInfo);
    this.e.addRespToQuque(this.d, localFromServiceMsg);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt)
  {
    if (this.g) {}
    try
    {
      ErrMsg localErrMsg = new ErrMsg();
      localErrMsg.setMessage(new String(paramArrayOfByte2, "utf-8"));
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
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
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCloseCode error " + paramString, paramString);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckWebsigAndGetSt ret" + paramInt);
    }
    if (this.g)
    {
      if (paramInt == 0) {
        l.d.getAccountCenter().a(false);
      }
      localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
      localFromServiceMsg.setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("userAccount", paramString);
      localFromServiceMsg.addAttribute("userInput", paramArrayOfByte);
      localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("lastError", paramErrMsg);
      localFromServiceMsg.addAttribute("wtTicket", a(paramWUserSigInfo));
      localFromServiceMsg.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
      try
      {
        localFromServiceMsg.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
        this.e.addRespToQuque(this.d, localFromServiceMsg);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    FromServiceMsg localFromServiceMsg = t.a(this.d);
    localFromServiceMsg.setMsfCommand(MsfCommand.submitPuzzleVerifyCodeTicket);
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.addAttribute("userAccount", paramString);
    localFromServiceMsg.addAttribute("userInput", paramArrayOfByte);
    localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
    localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
    localFromServiceMsg.addAttribute("lastError", paramErrMsg);
    localFromServiceMsg.addAttribute("wtTicket", a(paramWUserSigInfo));
    localFromServiceMsg.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
    localFromServiceMsg.setUin(paramWUserSigInfo.uin);
    for (;;)
    {
      for (;;)
      {
        try
        {
          localFromServiceMsg.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
          switch (paramInt)
          {
          default: 
            localFromServiceMsg.setBusinessFail(1001, paramErrMsg.getMessage());
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt failed");
            if (paramInt != 0)
            {
              if (paramErrMsg.getType() == 1) {
                localFromServiceMsg.addAttribute("resp_login_url", paramErrMsg.getOtherinfo());
              }
              if ((paramInt == 116) || (paramInt == 41))
              {
                paramString = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4194304);
                if (paramString != null)
                {
                  paramString = paramString._sig;
                  if (paramString == null) {
                    break label681;
                  }
                  localFromServiceMsg.addAttribute("resp_login_lhsig", paramString);
                }
              }
            }
            localFromServiceMsg.addAttribute("resp_logini_ret", Integer.valueOf(paramInt));
            this.e.addRespToQuque(this.d, localFromServiceMsg);
            return;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          continue;
          m.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          m.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
        }
        m.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        m.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        try
        {
          m.a(this.e, l.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
          if (!this.a) {
            break;
          }
          l.a(paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt succ exception " + paramString.toString(), paramString);
          return;
        }
      }
      localFromServiceMsg.setBusinessFail(1002);
      QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt timeout");
      continue;
      label681:
      if (QLog.isColorLevel()) {
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckWebsigAndGetSt ret: " + paramInt + " , t is null.");
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRefreshSMSData ret:" + paramInt);
    }
    if (this.g) {
      for (;;)
      {
        FromServiceMsg localFromServiceMsg;
        try
        {
          localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
          localFromServiceMsg.setMsfCommand(MsfCommand.wt_CheckSMSAndGetStExt);
          localFromServiceMsg.setMsgSuccess();
          localFromServiceMsg.addAttribute("userAccount", paramString);
          localFromServiceMsg.addAttribute("userInput", paramArrayOfByte);
          localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
          localFromServiceMsg.addAttribute("st", paramArrayOfByte1);
          localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
          localFromServiceMsg.addAttribute("lastError", paramErrMsg);
          switch (paramInt)
          {
          case 2: 
            localFromServiceMsg.setBusinessFail(1001, paramErrMsg.getMessage());
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt failed");
          }
        }
        catch (Exception paramString)
        {
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt error " + paramString, paramString);
          return;
        }
        paramString = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4194304);
        if (paramString != null)
        {
          paramString = paramString._sig;
          if (paramString != null) {
            localFromServiceMsg.addAttribute("resp_login_lhsig", paramString);
          }
        }
        else
        {
          this.e.addRespToQuque(this.d, localFromServiceMsg);
          return;
          m.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          m.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
          m.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          m.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
          try
          {
            m.a(this.e, l.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
            if (!this.a) {
              break;
            }
            l.a(paramString);
            return;
          }
          catch (Exception paramString)
          {
            QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt succ exception " + paramString.toString(), paramString);
            return;
          }
          localFromServiceMsg.setBusinessFail(1002);
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt timeout");
          break label494;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt ret: " + paramInt + " , t is null.");
          continue;
          continue;
          label494:
          if (paramInt != 116) {
            if (paramInt != 41) {}
          }
        }
      }
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.g) {}
    paramWUserSigInfo = t.a(this.d);
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
    FromServiceMsg localFromServiceMsg = t.a(this.d);
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt1));
    localFromServiceMsg.attributes.put("resp_register_shNextResendTime", Integer.valueOf(paramInt2));
    localFromServiceMsg.attributes.put("resp_register_shTotalTimeOver", Integer.valueOf(paramInt3));
    localFromServiceMsg.attributes.put("res_register_errmsg", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | ret=" + paramInt1);
    }
    if (paramInt1 == 0)
    {
      paramString = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 36);
      if (paramString != null)
      {
        paramString = new String(paramString);
        localFromServiceMsg.addAttribute("resp_register_uin", paramString);
        if (QLog.isColorLevel()) {
          QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | uin=" + paramString);
        }
      }
      paramString = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 6);
      if (paramString == null) {}
    }
    try
    {
      paramString = new String(paramString, "utf-8");
      localFromServiceMsg.attributes.put("resp_register_nick", paramString);
      if (QLog.isColorLevel()) {
        QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | nick=" + paramString);
      }
      paramWUserSigInfo = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 40);
      if (paramWUserSigInfo != null)
      {
        paramWUserSigInfo = new String(paramWUserSigInfo);
        localFromServiceMsg.attributes.put("resp_register_picture_url", paramWUserSigInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | bindFaceUrl=" + paramWUserSigInfo);
        }
      }
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = t.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    paramWUserSigInfo.attributes.put("resp_register_uin", String.valueOf(paramLong));
    paramWUserSigInfo.attributes.put("resp_register_contactssig", paramArrayOfByte2);
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte3);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckDevLockSms ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
      localFromServiceMsg.setMsfCommand(MsfCommand.wt_CheckDevLockSms);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("lastError", paramErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramWUserSigInfo)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckDevLockSms error " + paramWUserSigInfo, paramWUserSigInfo);
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.g)
    {
      paramWUserSigInfo = t.a(this.d);
      paramWUserSigInfo.setBusinessFail(3001, String.valueOf(paramInt));
      paramWUserSigInfo.attributes.put("msg", paramArrayOfByte);
      MsfSdkUtils.addFromMsgProcessName("*", paramWUserSigInfo);
      this.e.addRespToQuque(this.d, paramWUserSigInfo);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "found RegError " + paramInt + " on call " + this.d.getServiceCmd());
      return;
    }
    paramWUserSigInfo = t.a(this.d);
    if (paramInt == 7)
    {
      paramWUserSigInfo.setMsgSuccess();
      paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
      paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    }
    for (;;)
    {
      this.e.addRespToQuque(this.d, paramWUserSigInfo);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "found RegError " + paramInt + " on call " + this.d.getServiceCmd());
      return;
      paramWUserSigInfo.setBusinessFail(3001, String.valueOf(paramInt));
      paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
      MsfSdkUtils.addFromMsgProcessName("*", paramWUserSigInfo);
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, String paramString)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = t.a(this.d);
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
    paramWUserSigInfo = t.a(this.d);
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(4));
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramString2.getBytes());
    }
    for (;;)
    {
      this.e.addRespToQuque(this.d, paramWUserSigInfo);
      return;
      paramWUserSigInfo.setMsgSuccess();
      paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramString1.getBytes());
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckDevLockStatus ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
      localFromServiceMsg.setMsfCommand(MsfCommand.wt_CheckDevLockStatus);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("devLockInfo", paramDevlockInfo);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("lastError", paramErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramWUserSigInfo)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckDevLockStatus error " + paramWUserSigInfo, paramWUserSigInfo);
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = t.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(3));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  byte[] a(WUserSigInfo paramWUserSigInfo)
  {
    Object localObject = this.d.getAttribute("targetTicket");
    if ((localObject != null) && ((localObject instanceof Integer))) {}
    for (int i = ((Integer)localObject).intValue();; i = 4096) {
      return WtloginHelper.GetTicketSig(paramWUserSigInfo, i);
    }
  }
  
  /* Error */
  public void b(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    // Byte code:
    //   0: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 150
    //   8: iconst_2
    //   9: new 152	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 860
    //   19: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload 4
    //   24: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 30	com/tencent/mobileqq/msf/core/auth/o:h	Z
    //   37: ifeq +170 -> 207
    //   40: aload_0
    //   41: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   44: invokestatic 123	com/tencent/mobileqq/msf/service/l:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   47: astore_3
    //   48: aload_3
    //   49: ldc_w 862
    //   52: invokevirtual 865	com/tencent/qphone/base/remote/FromServiceMsg:setServiceCmd	(Ljava/lang/String;)V
    //   55: aload_3
    //   56: getstatic 868	com/tencent/mobileqq/msf/sdk/MsfCommand:verifyPasswdImage	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   59: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   62: aload_3
    //   63: ldc 125
    //   65: aload_1
    //   66: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: aload_3
    //   71: ldc_w 752
    //   74: aload_2
    //   75: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: aload_3
    //   80: ldc 141
    //   82: iload 4
    //   84: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload_3
    //   92: ldc 255
    //   94: aload 5
    //   96: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: iload 4
    //   102: tableswitch	default:+889 -> 991, 0:+98->200, 1:+26->128, 2:+39->141
    //   129: getfield 32	com/tencent/mobileqq/msf/core/auth/o:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   132: aload_0
    //   133: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   136: aload_3
    //   137: invokevirtual 115	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   140: return
    //   141: aload_3
    //   142: ldc_w 870
    //   145: getstatic 266	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   148: aload_1
    //   149: invokevirtual 346	oicq/wlogin_sdk/request/WtloginHelper:GetPictureData	(Ljava/lang/String;)[B
    //   152: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: aload_3
    //   157: sipush 2020
    //   160: aload 5
    //   162: invokevirtual 230	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 198	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   168: goto -40 -> 128
    //   171: astore_1
    //   172: ldc 150
    //   174: iconst_1
    //   175: new 152	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 872
    //   185: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload_1
    //   196: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   199: return
    //   200: aload_3
    //   201: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   204: goto -76 -> 128
    //   207: aload_0
    //   208: getfield 28	com/tencent/mobileqq/msf/core/auth/o:g	Z
    //   211: ifeq +251 -> 462
    //   214: iconst_0
    //   215: newarray byte
    //   217: astore 7
    //   219: aload 7
    //   221: astore 6
    //   223: iload 4
    //   225: tableswitch	default:+770 -> 995, 0:+212->437, 1:+27->252, 2:+200->425
    //   253: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   256: invokestatic 123	com/tencent/mobileqq/msf/service/l:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   259: astore 7
    //   261: aload 7
    //   263: getstatic 875	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_CheckPictureAndGetSt	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   266: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   269: aload 7
    //   271: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   274: aload 7
    //   276: ldc 125
    //   278: aload_1
    //   279: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: aload 7
    //   285: ldc_w 752
    //   288: aload_2
    //   289: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   292: pop
    //   293: aload 7
    //   295: ldc_w 870
    //   298: aload 6
    //   300: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   303: pop
    //   304: aload 7
    //   306: ldc 253
    //   308: aload_3
    //   309: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   312: pop
    //   313: aload 7
    //   315: ldc 141
    //   317: iload 4
    //   319: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   322: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: aload 7
    //   328: ldc 255
    //   330: aload 5
    //   332: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   335: pop
    //   336: aload 7
    //   338: ldc_w 318
    //   341: aload_0
    //   342: aload_3
    //   343: invokevirtual 321	com/tencent/mobileqq/msf/core/auth/o:a	(Loicq/wlogin_sdk/request/WUserSigInfo;)[B
    //   346: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   349: pop
    //   350: aload 7
    //   352: ldc_w 323
    //   355: aload_3
    //   356: sipush 128
    //   359: invokestatic 327	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSig	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   362: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   365: pop
    //   366: aload 7
    //   368: ldc_w 329
    //   371: aload_3
    //   372: sipush 128
    //   375: invokestatic 332	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSigKey	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   378: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   381: pop
    //   382: aload_0
    //   383: getfield 32	com/tencent/mobileqq/msf/core/auth/o:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   386: aload_0
    //   387: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   390: aload 7
    //   392: invokevirtual 115	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   395: return
    //   396: astore_1
    //   397: ldc 150
    //   399: iconst_1
    //   400: new 152	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 877
    //   410: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload_1
    //   414: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: aload_1
    //   421: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   424: return
    //   425: getstatic 266	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   428: aload_1
    //   429: invokevirtual 346	oicq/wlogin_sdk/request/WtloginHelper:GetPictureData	(Ljava/lang/String;)[B
    //   432: astore 6
    //   434: goto -182 -> 252
    //   437: getstatic 354	com/tencent/mobileqq/msf/core/auth/l:d	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   440: invokevirtual 358	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   443: iconst_0
    //   444: invokevirtual 363	com/tencent/mobileqq/msf/core/auth/b:a	(Z)V
    //   447: aload 7
    //   449: astore 6
    //   451: goto -199 -> 252
    //   454: astore_1
    //   455: aload_1
    //   456: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   459: goto -77 -> 382
    //   462: aload_0
    //   463: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   466: invokestatic 207	com/tencent/mobileqq/msf/core/t:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   469: astore 6
    //   471: aload 6
    //   473: getstatic 875	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_CheckPictureAndGetSt	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   476: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   479: aload 6
    //   481: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   484: aload 6
    //   486: ldc 125
    //   488: aload_1
    //   489: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   492: pop
    //   493: aload 6
    //   495: ldc_w 752
    //   498: aload_2
    //   499: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   502: pop
    //   503: aload 6
    //   505: ldc_w 689
    //   508: aload_3
    //   509: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   512: pop
    //   513: aload 6
    //   515: ldc 141
    //   517: iload 4
    //   519: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   525: pop
    //   526: aload 6
    //   528: ldc 255
    //   530: aload 5
    //   532: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   535: pop
    //   536: aload 6
    //   538: ldc_w 318
    //   541: aload_0
    //   542: aload_3
    //   543: invokevirtual 321	com/tencent/mobileqq/msf/core/auth/o:a	(Loicq/wlogin_sdk/request/WUserSigInfo;)[B
    //   546: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   549: pop
    //   550: aload 6
    //   552: ldc_w 323
    //   555: aload_3
    //   556: sipush 128
    //   559: invokestatic 327	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSig	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   562: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   565: pop
    //   566: aload 6
    //   568: aload_3
    //   569: getfield 261	oicq/wlogin_sdk/request/WUserSigInfo:uin	Ljava/lang/String;
    //   572: invokevirtual 74	com/tencent/qphone/base/remote/FromServiceMsg:setUin	(Ljava/lang/String;)V
    //   575: aload 6
    //   577: ldc_w 329
    //   580: aload_3
    //   581: sipush 128
    //   584: invokestatic 332	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSigKey	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   587: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   590: pop
    //   591: iload 4
    //   593: lookupswitch	default:+43->636, -1000:+336->929, 0:+274->867, 2:+174->767, 160:+224->817
    //   637: iconst_3
    //   638: sipush 1001
    //   641: aload 5
    //   643: invokevirtual 230	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   646: invokevirtual 198	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   649: ldc 150
    //   651: iconst_1
    //   652: ldc_w 879
    //   655: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: iload 4
    //   660: ifeq +71 -> 731
    //   663: aload 5
    //   665: invokevirtual 370	oicq/wlogin_sdk/tools/ErrMsg:getType	()I
    //   668: iconst_1
    //   669: if_icmpne +17 -> 686
    //   672: aload 6
    //   674: ldc_w 372
    //   677: aload 5
    //   679: invokevirtual 337	oicq/wlogin_sdk/tools/ErrMsg:getOtherinfo	()Ljava/lang/String;
    //   682: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   685: pop
    //   686: iload 4
    //   688: bipush 116
    //   690: if_icmpeq +10 -> 700
    //   693: iload 4
    //   695: bipush 41
    //   697: if_icmpne +34 -> 731
    //   700: aload_3
    //   701: ldc_w 373
    //   704: invokestatic 377	oicq/wlogin_sdk/request/WtloginHelper:GetUserSigInfoTicket	(Loicq/wlogin_sdk/request/WUserSigInfo;I)Loicq/wlogin_sdk/request/Ticket;
    //   707: astore_1
    //   708: aload_1
    //   709: ifnull +22 -> 731
    //   712: aload_1
    //   713: getfield 382	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   716: astore_1
    //   717: aload_1
    //   718: ifnull +231 -> 949
    //   721: aload 6
    //   723: ldc_w 384
    //   726: aload_1
    //   727: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   730: pop
    //   731: aload 6
    //   733: ldc_w 386
    //   736: iload 4
    //   738: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   741: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   744: pop
    //   745: aload_0
    //   746: getfield 32	com/tencent/mobileqq/msf/core/auth/o:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   749: aload_0
    //   750: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   753: aload 6
    //   755: invokevirtual 115	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   758: return
    //   759: astore_2
    //   760: aload_2
    //   761: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   764: goto -173 -> 591
    //   767: getstatic 392	com/tencent/mobileqq/msf/core/auth/m:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   770: aload_0
    //   771: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   774: invokevirtual 220	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   777: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   780: aload_0
    //   781: invokevirtual 398	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   784: pop
    //   785: aload_0
    //   786: aload_3
    //   787: getfield 272	oicq/wlogin_sdk/request/WUserSigInfo:_seqence	J
    //   790: putfield 400	com/tencent/mobileqq/msf/core/auth/o:f	J
    //   793: aload_1
    //   794: aload_0
    //   795: getfield 32	com/tencent/mobileqq/msf/core/auth/o:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   798: aload_0
    //   799: getfield 400	com/tencent/mobileqq/msf/core/auth/o:f	J
    //   802: aload_0
    //   803: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   806: aload 6
    //   808: aload 5
    //   810: invokevirtual 230	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   813: invokestatic 403	com/tencent/mobileqq/msf/core/auth/m:b	(Ljava/lang/String;Lcom/tencent/mobileqq/msf/core/MsfCore;JLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;)V
    //   816: return
    //   817: getstatic 392	com/tencent/mobileqq/msf/core/auth/m:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   820: aload_0
    //   821: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   824: invokevirtual 220	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   827: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   830: aload_0
    //   831: invokevirtual 398	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   834: pop
    //   835: aload_0
    //   836: aload_3
    //   837: getfield 272	oicq/wlogin_sdk/request/WUserSigInfo:_seqence	J
    //   840: putfield 400	com/tencent/mobileqq/msf/core/auth/o:f	J
    //   843: aload_1
    //   844: aload_0
    //   845: getfield 32	com/tencent/mobileqq/msf/core/auth/o:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   848: aload_0
    //   849: getfield 400	com/tencent/mobileqq/msf/core/auth/o:f	J
    //   852: aload_0
    //   853: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   856: aload 6
    //   858: aload 5
    //   860: invokevirtual 230	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   863: invokestatic 410	com/tencent/mobileqq/msf/core/auth/m:a	(Ljava/lang/String;Lcom/tencent/mobileqq/msf/core/MsfCore;JLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;)V
    //   866: return
    //   867: aload_0
    //   868: getfield 32	com/tencent/mobileqq/msf/core/auth/o:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   871: getstatic 266	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   874: aload_0
    //   875: getfield 34	com/tencent/mobileqq/msf/core/auth/o:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   878: aload 6
    //   880: aload_1
    //   881: aload_3
    //   882: invokestatic 418	com/tencent/mobileqq/msf/core/auth/m:a	(Lcom/tencent/mobileqq/msf/core/MsfCore;Loicq/wlogin_sdk/request/WtloginHelper;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;)V
    //   885: aload_0
    //   886: getfield 24	com/tencent/mobileqq/msf/core/auth/o:a	Z
    //   889: ifeq +105 -> 994
    //   892: aload_1
    //   893: invokestatic 419	com/tencent/mobileqq/msf/core/auth/l:a	(Ljava/lang/String;)V
    //   896: return
    //   897: astore_1
    //   898: ldc 150
    //   900: iconst_1
    //   901: new 152	java/lang/StringBuilder
    //   904: dup
    //   905: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   908: ldc_w 772
    //   911: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: aload_1
    //   915: invokevirtual 308	java/lang/Exception:toString	()Ljava/lang/String;
    //   918: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: aload_1
    //   925: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   928: return
    //   929: aload 6
    //   931: sipush 1002
    //   934: invokevirtual 314	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(I)V
    //   937: ldc 150
    //   939: iconst_1
    //   940: ldc_w 881
    //   943: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: goto -288 -> 658
    //   949: invokestatic 350	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   952: ifeq -221 -> 731
    //   955: ldc 150
    //   957: iconst_1
    //   958: new 152	java/lang/StringBuilder
    //   961: dup
    //   962: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   965: ldc_w 883
    //   968: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: iload 4
    //   973: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   976: ldc_w 435
    //   979: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   988: goto -257 -> 731
    //   991: goto -863 -> 128
    //   994: return
    //   995: aload 7
    //   997: astore 6
    //   999: goto -747 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1002	0	this	o
    //   0	1002	1	paramString	String
    //   0	1002	2	paramArrayOfByte	byte[]
    //   0	1002	3	paramWUserSigInfo	WUserSigInfo
    //   0	1002	4	paramInt	int
    //   0	1002	5	paramErrMsg	ErrMsg
    //   221	777	6	localObject1	Object
    //   217	779	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	100	171	java/lang/Exception
    //   128	140	171	java/lang/Exception
    //   141	168	171	java/lang/Exception
    //   200	204	171	java/lang/Exception
    //   214	219	396	java/lang/Exception
    //   252	366	396	java/lang/Exception
    //   382	395	396	java/lang/Exception
    //   425	434	396	java/lang/Exception
    //   437	447	396	java/lang/Exception
    //   455	459	396	java/lang/Exception
    //   366	382	454	java/lang/Exception
    //   575	591	759	java/lang/Exception
    //   867	896	897	java/lang/Exception
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCloseDevLock ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
      localFromServiceMsg.setMsfCommand(MsfCommand.wt_CloseDevLock);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("lastError", paramErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramWUserSigInfo)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCloseDevLock error " + paramWUserSigInfo, paramWUserSigInfo);
    }
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "WtProviderImpl.OnRegQueryAccount ret = " + paramInt + " appUseWt=" + this.g);
    }
    if (this.g) {
      return;
    }
    paramWUserSigInfo = t.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnAskDevLockSms ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
      localFromServiceMsg.setMsfCommand(MsfCommand.wt_AskDevLockSms);
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
      localFromServiceMsg.addAttribute("devLockInfo", paramDevlockInfo);
      localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
      localFromServiceMsg.addAttribute("lastError", paramErrMsg);
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (Exception paramWUserSigInfo)
    {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnAskDevLockSms error " + paramWUserSigInfo, paramWUserSigInfo);
    }
  }
  
  public void c(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRefreshSMSData ret:" + paramInt);
    }
    if (this.g) {
      label543:
      for (;;)
      {
        FromServiceMsg localFromServiceMsg;
        try
        {
          localFromServiceMsg = com.tencent.mobileqq.msf.service.l.a(this.d);
          localFromServiceMsg.setMsfCommand(MsfCommand.wt_CheckSMSAndGetSt);
          localFromServiceMsg.setMsgSuccess();
          localFromServiceMsg.addAttribute("userAccount", paramString);
          localFromServiceMsg.addAttribute("userInput", paramArrayOfByte);
          localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
          localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt));
          localFromServiceMsg.addAttribute("lastError", paramErrMsg);
          localFromServiceMsg.addAttribute("userSigInfo", paramWUserSigInfo);
          localFromServiceMsg.addAttribute("wtTicket", a(paramWUserSigInfo));
          localFromServiceMsg.addAttribute("st_temp", WtloginHelper.GetTicketSig(paramWUserSigInfo, 128));
          try
          {
            localFromServiceMsg.addAttribute("st_temp_key", WtloginHelper.GetTicketSigKey(paramWUserSigInfo, 128));
            switch (paramInt)
            {
            default: 
              localFromServiceMsg.setBusinessFail(1001, paramErrMsg.getMessage());
              QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt failed");
              break label543;
              paramString = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4194304);
              if (paramString != null)
              {
                paramString = paramString._sig;
                if (paramString == null) {
                  break label501;
                }
                localFromServiceMsg.addAttribute("resp_login_lhsig", paramString);
              }
              this.e.addRespToQuque(this.d, localFromServiceMsg);
              return;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
            continue;
          }
          m.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        }
        catch (Exception paramString)
        {
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt error " + paramString, paramString);
          return;
        }
        this.f = paramWUserSigInfo._seqence;
        m.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        m.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        m.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        try
        {
          m.a(this.e, l.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
          if (!this.a) {
            break;
          }
          l.a(paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckPictureAndGetSt succ exception " + paramString.toString(), paramString);
          return;
        }
        localFromServiceMsg.setBusinessFail(1002);
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt timeout");
        label501:
        if (QLog.isColorLevel())
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt ret: " + paramInt + " , t is null.");
          continue;
          if (paramInt != 116) {
            if (paramInt != 41) {}
          }
        }
      }
    }
  }
  
  public void c(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.g) {
      return;
    }
    paramWUserSigInfo = t.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(1));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void d(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.g) {}
    FromServiceMsg localFromServiceMsg = t.a(this.d);
    localFromServiceMsg.setMsgSuccess();
    localFromServiceMsg.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    localFromServiceMsg.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | ret=" + paramInt);
    }
    if (paramInt == 0)
    {
      paramArrayOfByte = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 36);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        localFromServiceMsg.addAttribute("bind_qq_uin", paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | uin=" + paramArrayOfByte);
        }
      }
      paramArrayOfByte = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 6);
      if (paramArrayOfByte == null) {}
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      localFromServiceMsg.attributes.put("resp_verify_account_nick", paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | bindQQNick=" + paramArrayOfByte);
      }
      paramWUserSigInfo = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 40);
      if (paramWUserSigInfo != null)
      {
        paramWUserSigInfo = new String(paramWUserSigInfo);
        localFromServiceMsg.attributes.put("resp_verify_account_faceUrl", paramWUserSigInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | bindFaceUrl=" + paramWUserSigInfo);
        }
      }
      this.e.addRespToQuque(this.d, localFromServiceMsg);
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void e(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_WtProviderImpl", 2, "ret=" + paramInt);
    }
    if (this.g) {
      return;
    }
    paramWUserSigInfo = t.a(this.d);
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
    FromServiceMsg localFromServiceMsg = t.a(this.d);
    localFromServiceMsg.setMsgSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_WtProviderImpl", 2, "ret=" + paramInt);
    }
    Object localObject = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 31);
    if (localObject != null)
    {
      localObject = String.valueOf(util.buf_to_int64((byte[])localObject, 0));
      localFromServiceMsg.attributes.put("resp_register_uin", localObject);
      if (QLog.isColorLevel()) {
        QLog.d("Login_Optimize_WtProviderImpl", 2, "uin=" + (String)localObject);
      }
    }
    paramWUserSigInfo = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 30);
    if (paramWUserSigInfo != null)
    {
      paramWUserSigInfo = new String(paramWUserSigInfo);
      localFromServiceMsg.attributes.put("to_register_cr_mobile", paramWUserSigInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Login_Optimize_WtProviderImpl", 2, "phoneNum=" + paramWUserSigInfo);
      }
    }
    localFromServiceMsg.attributes.put("resp_register_resultcode", Integer.valueOf(paramInt));
    localFromServiceMsg.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, localFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.o
 * JD-Core Version:    0.7.0.1
 */