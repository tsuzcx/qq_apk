package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.service.q;
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
  
  public void a(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRegGetSMSVerifyLoginAccount error " + paramArrayOfByte1, paramArrayOfByte1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
        paramWUserSigInfo = q.a(this.d);
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
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
          paramString2.verifyNote = n.a(paramString1, l.e.GetPicturePrompt(paramString1, paramWUserSigInfo._seqence));
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
          localObject2 = q.a(this.d);
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
                          break label1530;
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
                n.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
                this.f = paramWUserSigInfo._seqence;
                if (TextUtils.isEmpty(paramErrMsg.getOtherinfo()))
                {
                  n.b(paramString1, this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getMessage());
                  return;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "appUseWt = false; puzzle CAPTCHA " + paramErrMsg.getOtherinfo());
                }
                n.a(this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getOtherinfo());
                return;
              }
              n.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
              this.f = paramWUserSigInfo._seqence;
              n.a(paramString1, this.e, this.f, this.d, (FromServiceMsg)localObject1, paramErrMsg.getMessage());
              return;
              a(paramString1);
              if ((paramWUserSigInfo != null) && (paramWUserSigInfo._login_bitmap == 0)) {
                try
                {
                  n.a(this.e, l.e, this.d, (FromServiceMsg)localObject1, paramString1, paramWUserSigInfo);
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
            label1530:
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
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
    label829:
    label1231:
    label1239:
    do
    {
      for (;;)
      {
        try
        {
          paramArrayOfLong = q.a(this.d);
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
          paramLong2 = k.a(this.d, localFromServiceMsg);
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
                break label1231;
              }
            }
            Object localObject;
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
                    localObject = new CustomSigContent();
                    ((CustomSigContent)localObject).sResult = 0;
                    ((CustomSigContent)localObject).SigContent = new byte[0];
                    if (!this.d.getServiceCmd().equals("login.chgTok_WEBVIEW_KEY")) {
                      break label1239;
                    }
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
                      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd2 " + MsfSdkUtils.getShortStringKey(paramArrayOfByte) + " " + MsfSdkUtils.getShortStringKey(paramErrMsg) + " " + MsfSdkUtils.getShortHexKey(paramArrayOfLong) + " " + MsfSdkUtils.getShortHexKey((byte[])localObject));
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
              break label829;
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
        FromServiceMsg localFromServiceMsg = q.a(this.d);
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
          n.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          n.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
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
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
        paramWUserSigInfo = q.a(this.d);
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
        paramWUserSigInfo = q.a(this.d);
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
      n.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
      this.f = paramWUserSigInfo._seqence;
      n.b(paramString, this.e, this.f, this.d, paramArrayOfByte, paramErrMsg.getMessage());
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
        localFromServiceMsg = q.a(this.d);
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
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
      localFromServiceMsg = q.a(this.d);
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
                    break label685;
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
          n.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          n.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
        }
        n.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        n.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        try
        {
          n.a(this.e, l.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
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
      label685:
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
          localFromServiceMsg = q.a(this.d);
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
          n.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          n.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
          n.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          n.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
          try
          {
            n.a(this.e, l.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
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
          break label498;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt ret: " + paramInt + " , t is null.");
          continue;
          continue;
          label498:
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
  
  public void a(WUserSigInfo paramWUserSigInfo, int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
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
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckDevLockSms ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(8));
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
    //   0: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 156
    //   8: iconst_2
    //   9: new 173	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 873
    //   19: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload 4
    //   24: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 30	com/tencent/mobileqq/msf/core/auth/p:h	Z
    //   37: ifeq +170 -> 207
    //   40: aload_0
    //   41: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   44: invokestatic 123	com/tencent/mobileqq/msf/service/q:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   47: astore_3
    //   48: aload_3
    //   49: ldc_w 875
    //   52: invokevirtual 878	com/tencent/qphone/base/remote/FromServiceMsg:setServiceCmd	(Ljava/lang/String;)V
    //   55: aload_3
    //   56: getstatic 881	com/tencent/mobileqq/msf/sdk/MsfCommand:verifyPasswdImage	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   59: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   62: aload_3
    //   63: ldc 125
    //   65: aload_1
    //   66: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: aload_3
    //   71: ldc_w 767
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
    //   92: ldc_w 271
    //   95: aload 5
    //   97: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: iload 4
    //   103: tableswitch	default:+892 -> 995, 0:+97->200, 1:+25->128, 2:+38->141
    //   129: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   132: aload_0
    //   133: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   136: aload_3
    //   137: invokevirtual 115	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   140: return
    //   141: aload_3
    //   142: ldc_w 883
    //   145: getstatic 282	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   148: aload_1
    //   149: invokevirtual 362	oicq/wlogin_sdk/request/WtloginHelper:GetPictureData	(Ljava/lang/String;)[B
    //   152: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: aload_3
    //   157: sipush 2020
    //   160: aload 5
    //   162: invokevirtual 246	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 214	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   168: goto -40 -> 128
    //   171: astore_1
    //   172: ldc 156
    //   174: iconst_1
    //   175: new 173	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 885
    //   185: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload_1
    //   196: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   199: return
    //   200: aload_3
    //   201: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   204: goto -76 -> 128
    //   207: aload_0
    //   208: getfield 28	com/tencent/mobileqq/msf/core/auth/p:g	Z
    //   211: ifeq +253 -> 464
    //   214: iconst_0
    //   215: newarray byte
    //   217: astore 7
    //   219: aload 7
    //   221: astore 6
    //   223: iload 4
    //   225: tableswitch	default:+774 -> 999, 0:+214->439, 1:+27->252, 2:+202->427
    //   253: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   256: invokestatic 123	com/tencent/mobileqq/msf/service/q:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   259: astore 7
    //   261: aload 7
    //   263: getstatic 888	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_CheckPictureAndGetSt	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   266: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   269: aload 7
    //   271: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   274: aload 7
    //   276: ldc 125
    //   278: aload_1
    //   279: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: aload 7
    //   285: ldc_w 767
    //   288: aload_2
    //   289: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   292: pop
    //   293: aload 7
    //   295: ldc_w 883
    //   298: aload 6
    //   300: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   303: pop
    //   304: aload 7
    //   306: ldc_w 269
    //   309: aload_3
    //   310: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   313: pop
    //   314: aload 7
    //   316: ldc 141
    //   318: iload 4
    //   320: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   326: pop
    //   327: aload 7
    //   329: ldc_w 271
    //   332: aload 5
    //   334: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   337: pop
    //   338: aload 7
    //   340: ldc_w 334
    //   343: aload_0
    //   344: aload_3
    //   345: invokevirtual 337	com/tencent/mobileqq/msf/core/auth/p:a	(Loicq/wlogin_sdk/request/WUserSigInfo;)[B
    //   348: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   351: pop
    //   352: aload 7
    //   354: ldc_w 339
    //   357: aload_3
    //   358: sipush 128
    //   361: invokestatic 343	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSig	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   364: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   367: pop
    //   368: aload 7
    //   370: ldc_w 345
    //   373: aload_3
    //   374: sipush 128
    //   377: invokestatic 348	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSigKey	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   380: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: pop
    //   384: aload_0
    //   385: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   388: aload_0
    //   389: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   392: aload 7
    //   394: invokevirtual 115	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   397: return
    //   398: astore_1
    //   399: ldc 156
    //   401: iconst_1
    //   402: new 173	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   409: ldc_w 890
    //   412: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_1
    //   416: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: aload_1
    //   423: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   426: return
    //   427: getstatic 282	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   430: aload_1
    //   431: invokevirtual 362	oicq/wlogin_sdk/request/WtloginHelper:GetPictureData	(Ljava/lang/String;)[B
    //   434: astore 6
    //   436: goto -184 -> 252
    //   439: getstatic 366	com/tencent/mobileqq/msf/core/auth/l:d	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   442: invokevirtual 370	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   445: iconst_0
    //   446: invokevirtual 375	com/tencent/mobileqq/msf/core/auth/b:a	(Z)V
    //   449: aload 7
    //   451: astore 6
    //   453: goto -201 -> 252
    //   456: astore_1
    //   457: aload_1
    //   458: invokevirtual 401	java/lang/Exception:printStackTrace	()V
    //   461: goto -77 -> 384
    //   464: aload_0
    //   465: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   468: invokestatic 223	com/tencent/mobileqq/msf/core/t:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   471: astore 6
    //   473: aload 6
    //   475: getstatic 888	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_CheckPictureAndGetSt	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   478: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   481: aload 6
    //   483: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   486: aload 6
    //   488: ldc 125
    //   490: aload_1
    //   491: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   494: pop
    //   495: aload 6
    //   497: ldc_w 767
    //   500: aload_2
    //   501: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   504: pop
    //   505: aload 6
    //   507: ldc_w 704
    //   510: aload_3
    //   511: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   514: pop
    //   515: aload 6
    //   517: ldc 141
    //   519: iload 4
    //   521: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   524: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   527: pop
    //   528: aload 6
    //   530: ldc_w 271
    //   533: aload 5
    //   535: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   538: pop
    //   539: aload 6
    //   541: ldc_w 334
    //   544: aload_0
    //   545: aload_3
    //   546: invokevirtual 337	com/tencent/mobileqq/msf/core/auth/p:a	(Loicq/wlogin_sdk/request/WUserSigInfo;)[B
    //   549: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   552: pop
    //   553: aload 6
    //   555: ldc_w 339
    //   558: aload_3
    //   559: sipush 128
    //   562: invokestatic 343	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSig	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   565: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   568: pop
    //   569: aload 6
    //   571: aload_3
    //   572: getfield 277	oicq/wlogin_sdk/request/WUserSigInfo:uin	Ljava/lang/String;
    //   575: invokevirtual 74	com/tencent/qphone/base/remote/FromServiceMsg:setUin	(Ljava/lang/String;)V
    //   578: aload 6
    //   580: ldc_w 345
    //   583: aload_3
    //   584: sipush 128
    //   587: invokestatic 348	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSigKey	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   590: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   593: pop
    //   594: iload 4
    //   596: lookupswitch	default:+44->640, -1000:+337->933, 0:+275->871, 2:+175->771, 160:+225->821
    //   641: iconst_3
    //   642: sipush 1001
    //   645: aload 5
    //   647: invokevirtual 246	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   650: invokevirtual 214	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   653: ldc 156
    //   655: iconst_1
    //   656: ldc_w 892
    //   659: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   662: iload 4
    //   664: ifeq +71 -> 735
    //   667: aload 5
    //   669: invokevirtual 382	oicq/wlogin_sdk/tools/ErrMsg:getType	()I
    //   672: iconst_1
    //   673: if_icmpne +17 -> 690
    //   676: aload 6
    //   678: ldc_w 384
    //   681: aload 5
    //   683: invokevirtual 353	oicq/wlogin_sdk/tools/ErrMsg:getOtherinfo	()Ljava/lang/String;
    //   686: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   689: pop
    //   690: iload 4
    //   692: bipush 116
    //   694: if_icmpeq +10 -> 704
    //   697: iload 4
    //   699: bipush 41
    //   701: if_icmpne +34 -> 735
    //   704: aload_3
    //   705: ldc_w 385
    //   708: invokestatic 389	oicq/wlogin_sdk/request/WtloginHelper:GetUserSigInfoTicket	(Loicq/wlogin_sdk/request/WUserSigInfo;I)Loicq/wlogin_sdk/request/Ticket;
    //   711: astore_1
    //   712: aload_1
    //   713: ifnull +22 -> 735
    //   716: aload_1
    //   717: getfield 394	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   720: astore_1
    //   721: aload_1
    //   722: ifnull +231 -> 953
    //   725: aload 6
    //   727: ldc_w 396
    //   730: aload_1
    //   731: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   734: pop
    //   735: aload 6
    //   737: ldc_w 398
    //   740: iload 4
    //   742: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   745: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   748: pop
    //   749: aload_0
    //   750: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   753: aload_0
    //   754: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   757: aload 6
    //   759: invokevirtual 115	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   762: return
    //   763: astore_2
    //   764: aload_2
    //   765: invokevirtual 401	java/lang/Exception:printStackTrace	()V
    //   768: goto -174 -> 594
    //   771: getstatic 404	com/tencent/mobileqq/msf/core/auth/n:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   774: aload_0
    //   775: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   778: invokevirtual 236	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   781: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   784: aload_0
    //   785: invokevirtual 407	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   788: pop
    //   789: aload_0
    //   790: aload_3
    //   791: getfield 288	oicq/wlogin_sdk/request/WUserSigInfo:_seqence	J
    //   794: putfield 409	com/tencent/mobileqq/msf/core/auth/p:f	J
    //   797: aload_1
    //   798: aload_0
    //   799: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   802: aload_0
    //   803: getfield 409	com/tencent/mobileqq/msf/core/auth/p:f	J
    //   806: aload_0
    //   807: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   810: aload 6
    //   812: aload 5
    //   814: invokevirtual 246	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   817: invokestatic 412	com/tencent/mobileqq/msf/core/auth/n:b	(Ljava/lang/String;Lcom/tencent/mobileqq/msf/core/MsfCore;JLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;)V
    //   820: return
    //   821: getstatic 404	com/tencent/mobileqq/msf/core/auth/n:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   824: aload_0
    //   825: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   828: invokevirtual 236	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   831: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   834: aload_0
    //   835: invokevirtual 407	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   838: pop
    //   839: aload_0
    //   840: aload_3
    //   841: getfield 288	oicq/wlogin_sdk/request/WUserSigInfo:_seqence	J
    //   844: putfield 409	com/tencent/mobileqq/msf/core/auth/p:f	J
    //   847: aload_1
    //   848: aload_0
    //   849: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   852: aload_0
    //   853: getfield 409	com/tencent/mobileqq/msf/core/auth/p:f	J
    //   856: aload_0
    //   857: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   860: aload 6
    //   862: aload 5
    //   864: invokevirtual 246	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   867: invokestatic 419	com/tencent/mobileqq/msf/core/auth/n:a	(Ljava/lang/String;Lcom/tencent/mobileqq/msf/core/MsfCore;JLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;)V
    //   870: return
    //   871: aload_0
    //   872: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   875: getstatic 282	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   878: aload_0
    //   879: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   882: aload 6
    //   884: aload_1
    //   885: aload_3
    //   886: invokestatic 427	com/tencent/mobileqq/msf/core/auth/n:a	(Lcom/tencent/mobileqq/msf/core/MsfCore;Loicq/wlogin_sdk/request/WtloginHelper;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;)V
    //   889: aload_0
    //   890: getfield 24	com/tencent/mobileqq/msf/core/auth/p:a	Z
    //   893: ifeq +105 -> 998
    //   896: aload_1
    //   897: invokestatic 428	com/tencent/mobileqq/msf/core/auth/l:a	(Ljava/lang/String;)V
    //   900: return
    //   901: astore_1
    //   902: ldc 156
    //   904: iconst_1
    //   905: new 173	java/lang/StringBuilder
    //   908: dup
    //   909: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   912: ldc_w 787
    //   915: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload_1
    //   919: invokevirtual 324	java/lang/Exception:toString	()Ljava/lang/String;
    //   922: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: aload_1
    //   929: invokestatic 326	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   932: return
    //   933: aload 6
    //   935: sipush 1002
    //   938: invokevirtual 330	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(I)V
    //   941: ldc 156
    //   943: iconst_1
    //   944: ldc_w 894
    //   947: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   950: goto -288 -> 662
    //   953: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   956: ifeq -221 -> 735
    //   959: ldc 156
    //   961: iconst_1
    //   962: new 173	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   969: ldc_w 896
    //   972: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: iload 4
    //   977: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   980: ldc_w 444
    //   983: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: invokestatic 379	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   992: goto -257 -> 735
    //   995: goto -867 -> 128
    //   998: return
    //   999: aload 7
    //   1001: astore 6
    //   1003: goto -751 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1006	0	this	p
    //   0	1006	1	paramString	String
    //   0	1006	2	paramArrayOfByte	byte[]
    //   0	1006	3	paramWUserSigInfo	WUserSigInfo
    //   0	1006	4	paramInt	int
    //   0	1006	5	paramErrMsg	ErrMsg
    //   221	781	6	localObject1	Object
    //   217	783	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	101	171	java/lang/Exception
    //   128	140	171	java/lang/Exception
    //   141	168	171	java/lang/Exception
    //   200	204	171	java/lang/Exception
    //   214	219	398	java/lang/Exception
    //   252	368	398	java/lang/Exception
    //   384	397	398	java/lang/Exception
    //   427	436	398	java/lang/Exception
    //   439	449	398	java/lang/Exception
    //   457	461	398	java/lang/Exception
    //   368	384	456	java/lang/Exception
    //   578	594	763	java/lang/Exception
    //   871	900	901	java/lang/Exception
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCloseDevLock ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
      FromServiceMsg localFromServiceMsg = q.a(this.d);
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
  
  public void b(WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte)
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
  
  public void c(String paramString, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnRefreshSMSData ret:" + paramInt);
    }
    if (this.g) {
      label547:
      for (;;)
      {
        FromServiceMsg localFromServiceMsg;
        try
        {
          localFromServiceMsg = q.a(this.d);
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
              break label547;
              paramString = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4194304);
              if (paramString != null)
              {
                paramString = paramString._sig;
                if (paramString == null) {
                  break label505;
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
          n.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        }
        catch (Exception paramString)
        {
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt error " + paramString, paramString);
          return;
        }
        this.f = paramWUserSigInfo._seqence;
        n.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        n.b.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        n.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        try
        {
          n.a(this.e, l.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
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
        label505:
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
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.p
 * JD-Core Version:    0.7.0.1
 */