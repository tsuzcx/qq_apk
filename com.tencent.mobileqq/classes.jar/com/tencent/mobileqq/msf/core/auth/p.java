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
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRegGetSMSVerifyLoginAccount error " + paramArrayOfByte1, paramArrayOfByte1);
    }
  }
  
  public void a(int paramInt, WUserSigInfo paramWUserSigInfo, String paramString, ErrMsg paramErrMsg, HashMap paramHashMap)
  {
    if (this.g) {
      for (;;)
      {
        try
        {
          localFromServiceMsg = u.a(this.d);
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
          int j = 0;
          i = j;
          if (paramInt == 0)
          {
            boolean bool = TextUtils.isEmpty(paramString);
            i = j;
            if (bool) {}
          }
        }
        catch (Exception paramWUserSigInfo)
        {
          FromServiceMsg localFromServiceMsg;
          int i;
          label206:
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "onLoginByGateway error " + paramWUserSigInfo, paramWUserSigInfo);
          return;
        }
        for (;;)
        {
          try
          {
            a(paramString);
            n.a(this.e, l.e, this.d, localFromServiceMsg, paramString, paramWUserSigInfo);
          }
          catch (Exception paramWUserSigInfo)
          {
            paramInt = 0;
            break label206;
          }
          try
          {
            if (this.a) {
              l.a(paramString);
            }
            i = 1;
            if (i != 0) {
              continue;
            }
            this.e.addRespToQuque(this.d, localFromServiceMsg);
            return;
          }
          catch (Exception paramWUserSigInfo)
          {
            paramInt = 1;
            break label206;
          }
        }
        QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "onLoginByGateway succ exception " + paramWUserSigInfo.toString(), paramWUserSigInfo);
        i = paramInt;
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (this.g) {}
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
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSVerifyLoginAccount error " + paramString1, paramString1);
    }
  }
  
  public void a(String paramString, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnException " + paramString);
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
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnException error " + paramString, paramString);
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
    if (this.g) {}
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
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStViaSMSVerifyLogin error " + paramString, paramString);
    }
  }
  
  public void a(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, this.d.getRequestSsoSeq() + " OnGetStWithPasswd " + paramErrMsg.getMessage() + " " + MsfSdkUtils.getShortUin(paramString1) + ",  isVerifyPasswd=" + this.h + " appUseWt=" + this.g + " ret=" + paramInt2 + " " + this.d);
    Object localObject1;
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
          localObject2 = u.a(this.d);
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
                          break label1550;
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
                n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
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
              n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
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
            label1550:
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
    label830:
    label1235:
    label1243:
    do
    {
      for (;;)
      {
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
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnGetStWithoutPasswd error " + paramString, paramString);
          return;
        }
        FromServiceMsg localFromServiceMsg = o.a(this.d);
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
                break label1235;
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
                      break label1243;
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
              break label830;
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
        FromServiceMsg localFromServiceMsg = u.a(this.d);
        localFromServiceMsg.setMsfCommand(MsfCommand.wt_RefreshSMSData);
        localFromServiceMsg.setMsgSuccess();
        localFromServiceMsg.addAttribute("userAccount", paramString);
        localFromServiceMsg.addAttribute("smsAppid", Long.valueOf(paramLong));
        localFromServiceMsg.addAttribute("sigInfo", paramWUserSigInfo);
        localFromServiceMsg.addAttribute("remainMsgCnt", Integer.valueOf(paramInt1));
        localFromServiceMsg.addAttribute("timeLimit", Integer.valueOf(paramInt2));
        localFromServiceMsg.addAttribute("ret", Integer.valueOf(paramInt3));
        localFromServiceMsg.addAttribute("lastError", paramErrMsg);
        localFromServiceMsg.addAttribute("smsExtraData", WtloginHelper.getLoginResultData(paramWUserSigInfo, 1347));
        if (paramInt3 == 0)
        {
          n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
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
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshSMSVerifyLoginAccount error " + paramString1, paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.g) {}
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
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshPictureData error, isVerifyPasswd, " + paramString, paramString);
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
        QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnRefreshPictureData error, appUseWt, " + paramString, paramString);
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
    FromServiceMsg localFromServiceMsg;
    if (this.g) {
      try
      {
        paramWUserSigInfo = new ErrMsg();
        paramWUserSigInfo.setMessage(new String(paramArrayOfByte2, "utf-8"));
        localFromServiceMsg = u.a(this.d);
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
      localFromServiceMsg = u.a(this.d);
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
    FromServiceMsg localFromServiceMsg = o.a(this.d);
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
                    break label698;
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
          n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          n.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
        }
        n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        n.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        try
        {
          a(paramString);
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
      label698:
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
          localFromServiceMsg = u.a(this.d);
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
          n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          n.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
          n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
          this.f = paramWUserSigInfo._seqence;
          n.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
          return;
          try
          {
            a(paramString);
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
          break label511;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetStExt ret: " + paramInt + " , t is null.");
          continue;
          continue;
          label511:
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
      paramString = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 40);
      if (paramString != null)
      {
        paramString = new String(paramString);
        localFromServiceMsg.attributes.put("resp_register_picture_url", paramString);
        if (QLog.isColorLevel()) {
          QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | bindFaceUrl=" + paramString);
        }
      }
      paramWUserSigInfo = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 51);
      if (paramWUserSigInfo != null)
      {
        paramWUserSigInfo = new String(paramWUserSigInfo);
        localFromServiceMsg.attributes.put("resp_phone_protect_uins_url", paramWUserSigInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Register_WtProviderImpl", 2, "OnRegQueryClientSentMsgStatus | phoneProtectUinsUrl=" + paramWUserSigInfo);
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
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCheckDevLockSms ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = u.a(this.d);
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
      paramWUserSigInfo = o.a(this.d);
      paramWUserSigInfo.setBusinessFail(3001, String.valueOf(paramInt));
      paramWUserSigInfo.attributes.put("msg", paramArrayOfByte);
      MsfSdkUtils.addFromMsgProcessName("*", paramWUserSigInfo);
      this.e.addRespToQuque(this.d, paramWUserSigInfo);
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "found RegError " + paramInt + " on call " + this.d.getServiceCmd());
      return;
    }
    paramWUserSigInfo = o.a(this.d);
    if ((paramInt == 7) || (paramInt == 59))
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
      FromServiceMsg localFromServiceMsg = u.a(this.d);
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
    //   16: ldc_w 903
    //   19: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload 4
    //   24: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 30	com/tencent/mobileqq/msf/core/auth/p:h	Z
    //   37: ifeq +170 -> 207
    //   40: aload_0
    //   41: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   44: invokestatic 123	com/tencent/mobileqq/msf/service/u:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   47: astore_3
    //   48: aload_3
    //   49: ldc_w 905
    //   52: invokevirtual 908	com/tencent/qphone/base/remote/FromServiceMsg:setServiceCmd	(Ljava/lang/String;)V
    //   55: aload_3
    //   56: getstatic 911	com/tencent/mobileqq/msf/sdk/MsfCommand:verifyPasswdImage	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   59: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   62: aload_3
    //   63: ldc 125
    //   65: aload_1
    //   66: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: pop
    //   70: aload_3
    //   71: ldc_w 790
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
    //   92: ldc_w 319
    //   95: aload 5
    //   97: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: iload 4
    //   103: tableswitch	default:+901 -> 1004, 0:+97->200, 1:+25->128, 2:+38->141
    //   129: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   132: aload_0
    //   133: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   136: aload_3
    //   137: invokevirtual 115	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   140: return
    //   141: aload_3
    //   142: ldc_w 913
    //   145: getstatic 213	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   148: aload_1
    //   149: invokevirtual 386	oicq/wlogin_sdk/request/WtloginHelper:GetPictureData	(Ljava/lang/String;)[B
    //   152: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   155: pop
    //   156: aload_3
    //   157: sipush 2020
    //   160: aload 5
    //   162: invokevirtual 296	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 267	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   168: goto -40 -> 128
    //   171: astore_1
    //   172: ldc 156
    //   174: iconst_1
    //   175: new 173	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 915
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
    //   211: ifeq +252 -> 463
    //   214: iconst_0
    //   215: newarray byte
    //   217: astore 7
    //   219: aload 7
    //   221: astore 6
    //   223: iload 4
    //   225: tableswitch	default:+783 -> 1008, 0:+213->438, 1:+27->252, 2:+201->426
    //   253: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   256: invokestatic 123	com/tencent/mobileqq/msf/service/u:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   259: astore 7
    //   261: aload 7
    //   263: getstatic 918	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_CheckPictureAndGetSt	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   266: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   269: aload 7
    //   271: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   274: aload 7
    //   276: ldc 125
    //   278: aload_1
    //   279: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   282: pop
    //   283: aload 7
    //   285: ldc_w 790
    //   288: aload_2
    //   289: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   292: pop
    //   293: aload 7
    //   295: ldc_w 913
    //   298: aload 6
    //   300: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   303: pop
    //   304: aload 7
    //   306: ldc 199
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
    //   328: ldc_w 319
    //   331: aload 5
    //   333: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   336: pop
    //   337: aload 7
    //   339: ldc_w 364
    //   342: aload_0
    //   343: aload_3
    //   344: invokevirtual 367	com/tencent/mobileqq/msf/core/auth/p:a	(Loicq/wlogin_sdk/request/WUserSigInfo;)[B
    //   347: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   350: pop
    //   351: aload 7
    //   353: ldc_w 369
    //   356: aload_3
    //   357: sipush 128
    //   360: invokestatic 373	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSig	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   363: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   366: pop
    //   367: aload 7
    //   369: ldc_w 375
    //   372: aload_3
    //   373: sipush 128
    //   376: invokestatic 378	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSigKey	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   379: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: pop
    //   383: aload_0
    //   384: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   387: aload_0
    //   388: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   391: aload 7
    //   393: invokevirtual 115	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   396: return
    //   397: astore_1
    //   398: ldc 156
    //   400: iconst_1
    //   401: new 173	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 920
    //   411: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_1
    //   415: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: aload_1
    //   422: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   425: return
    //   426: getstatic 213	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   429: aload_1
    //   430: invokevirtual 386	oicq/wlogin_sdk/request/WtloginHelper:GetPictureData	(Ljava/lang/String;)[B
    //   433: astore 6
    //   435: goto -183 -> 252
    //   438: getstatic 390	com/tencent/mobileqq/msf/core/auth/l:d	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   441: invokevirtual 394	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
    //   444: iconst_0
    //   445: invokevirtual 399	com/tencent/mobileqq/msf/core/auth/b:a	(Z)V
    //   448: aload 7
    //   450: astore 6
    //   452: goto -200 -> 252
    //   455: astore_1
    //   456: aload_1
    //   457: invokevirtual 425	java/lang/Exception:printStackTrace	()V
    //   460: goto -77 -> 383
    //   463: aload_0
    //   464: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   467: invokestatic 276	com/tencent/mobileqq/msf/core/o:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   470: astore 6
    //   472: aload 6
    //   474: getstatic 918	com/tencent/mobileqq/msf/sdk/MsfCommand:wt_CheckPictureAndGetSt	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   477: invokevirtual 84	com/tencent/qphone/base/remote/FromServiceMsg:setMsfCommand	(Lcom/tencent/mobileqq/msf/sdk/MsfCommand;)V
    //   480: aload 6
    //   482: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   485: aload 6
    //   487: ldc 125
    //   489: aload_1
    //   490: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   493: pop
    //   494: aload 6
    //   496: ldc_w 790
    //   499: aload_2
    //   500: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   503: pop
    //   504: aload 6
    //   506: ldc_w 722
    //   509: aload_3
    //   510: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   513: pop
    //   514: aload 6
    //   516: ldc 141
    //   518: iload 4
    //   520: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   523: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   526: pop
    //   527: aload 6
    //   529: ldc_w 319
    //   532: aload 5
    //   534: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   537: pop
    //   538: aload 6
    //   540: ldc_w 364
    //   543: aload_0
    //   544: aload_3
    //   545: invokevirtual 367	com/tencent/mobileqq/msf/core/auth/p:a	(Loicq/wlogin_sdk/request/WUserSigInfo;)[B
    //   548: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   551: pop
    //   552: aload 6
    //   554: ldc_w 369
    //   557: aload_3
    //   558: sipush 128
    //   561: invokestatic 373	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSig	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   564: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   567: pop
    //   568: aload 6
    //   570: aload_3
    //   571: getfield 322	oicq/wlogin_sdk/request/WUserSigInfo:uin	Ljava/lang/String;
    //   574: invokevirtual 74	com/tencent/qphone/base/remote/FromServiceMsg:setUin	(Ljava/lang/String;)V
    //   577: aload 6
    //   579: ldc_w 375
    //   582: aload_3
    //   583: sipush 128
    //   586: invokestatic 378	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSigKey	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   589: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   592: pop
    //   593: iload 4
    //   595: lookupswitch	default:+49->644, -1000:+347->942, 0:+280->875, 2:+180->775, 160:+230->825, 239:+230->825
    //   645: iconst_3
    //   646: sipush 1001
    //   649: aload 5
    //   651: invokevirtual 296	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   654: invokevirtual 267	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
    //   657: ldc 156
    //   659: iconst_1
    //   660: ldc_w 922
    //   663: invokestatic 403	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: iload 4
    //   668: ifeq +71 -> 739
    //   671: aload 5
    //   673: invokevirtual 406	oicq/wlogin_sdk/tools/ErrMsg:getType	()I
    //   676: iconst_1
    //   677: if_icmpne +17 -> 694
    //   680: aload 6
    //   682: ldc_w 408
    //   685: aload 5
    //   687: invokevirtual 383	oicq/wlogin_sdk/tools/ErrMsg:getOtherinfo	()Ljava/lang/String;
    //   690: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   693: pop
    //   694: iload 4
    //   696: bipush 116
    //   698: if_icmpeq +10 -> 708
    //   701: iload 4
    //   703: bipush 41
    //   705: if_icmpne +34 -> 739
    //   708: aload_3
    //   709: ldc_w 409
    //   712: invokestatic 413	oicq/wlogin_sdk/request/WtloginHelper:GetUserSigInfoTicket	(Loicq/wlogin_sdk/request/WUserSigInfo;I)Loicq/wlogin_sdk/request/Ticket;
    //   715: astore_1
    //   716: aload_1
    //   717: ifnull +22 -> 739
    //   720: aload_1
    //   721: getfield 418	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   724: astore_1
    //   725: aload_1
    //   726: ifnull +236 -> 962
    //   729: aload 6
    //   731: ldc_w 420
    //   734: aload_1
    //   735: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   738: pop
    //   739: aload 6
    //   741: ldc_w 422
    //   744: iload 4
    //   746: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   749: invokevirtual 135	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   752: pop
    //   753: aload_0
    //   754: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   757: aload_0
    //   758: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   761: aload 6
    //   763: invokevirtual 115	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   766: return
    //   767: astore_2
    //   768: aload_2
    //   769: invokevirtual 425	java/lang/Exception:printStackTrace	()V
    //   772: goto -179 -> 593
    //   775: getstatic 428	com/tencent/mobileqq/msf/core/auth/n:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   778: aload_0
    //   779: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   782: invokevirtual 204	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   785: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   788: aload_0
    //   789: invokevirtual 431	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   792: pop
    //   793: aload_0
    //   794: aload_3
    //   795: getfield 218	oicq/wlogin_sdk/request/WUserSigInfo:_seqence	J
    //   798: putfield 433	com/tencent/mobileqq/msf/core/auth/p:f	J
    //   801: aload_1
    //   802: aload_0
    //   803: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   806: aload_0
    //   807: getfield 433	com/tencent/mobileqq/msf/core/auth/p:f	J
    //   810: aload_0
    //   811: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   814: aload 6
    //   816: aload 5
    //   818: invokevirtual 296	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   821: invokestatic 436	com/tencent/mobileqq/msf/core/auth/n:b	(Ljava/lang/String;Lcom/tencent/mobileqq/msf/core/MsfCore;JLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;)V
    //   824: return
    //   825: getstatic 428	com/tencent/mobileqq/msf/core/auth/n:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   828: aload_0
    //   829: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   832: invokevirtual 204	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   835: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   838: aload_0
    //   839: invokevirtual 431	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   842: pop
    //   843: aload_0
    //   844: aload_3
    //   845: getfield 218	oicq/wlogin_sdk/request/WUserSigInfo:_seqence	J
    //   848: putfield 433	com/tencent/mobileqq/msf/core/auth/p:f	J
    //   851: aload_1
    //   852: aload_0
    //   853: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   856: aload_0
    //   857: getfield 433	com/tencent/mobileqq/msf/core/auth/p:f	J
    //   860: aload_0
    //   861: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   864: aload 6
    //   866: aload 5
    //   868: invokevirtual 296	oicq/wlogin_sdk/tools/ErrMsg:getMessage	()Ljava/lang/String;
    //   871: invokestatic 443	com/tencent/mobileqq/msf/core/auth/n:a	(Ljava/lang/String;Lcom/tencent/mobileqq/msf/core/MsfCore;JLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;)V
    //   874: return
    //   875: aload_0
    //   876: aload_1
    //   877: invokespecial 232	com/tencent/mobileqq/msf/core/auth/p:a	(Ljava/lang/String;)V
    //   880: aload_0
    //   881: getfield 32	com/tencent/mobileqq/msf/core/auth/p:e	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   884: getstatic 213	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   887: aload_0
    //   888: getfield 34	com/tencent/mobileqq/msf/core/auth/p:d	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   891: aload 6
    //   893: aload_1
    //   894: aload_3
    //   895: invokestatic 237	com/tencent/mobileqq/msf/core/auth/n:a	(Lcom/tencent/mobileqq/msf/core/MsfCore;Loicq/wlogin_sdk/request/WtloginHelper;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;)V
    //   898: aload_0
    //   899: getfield 24	com/tencent/mobileqq/msf/core/auth/p:a	Z
    //   902: ifeq +105 -> 1007
    //   905: aload_1
    //   906: invokestatic 238	com/tencent/mobileqq/msf/core/auth/l:a	(Ljava/lang/String;)V
    //   909: return
    //   910: astore_1
    //   911: ldc 156
    //   913: iconst_1
    //   914: new 173	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   921: ldc_w 810
    //   924: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload_1
    //   928: invokevirtual 241	java/lang/Exception:toString	()Ljava/lang/String;
    //   931: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: aload_1
    //   938: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   941: return
    //   942: aload 6
    //   944: sipush 1002
    //   947: invokevirtual 360	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(I)V
    //   950: ldc 156
    //   952: iconst_1
    //   953: ldc_w 924
    //   956: invokestatic 403	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   959: goto -293 -> 666
    //   962: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   965: ifeq -226 -> 739
    //   968: ldc 156
    //   970: iconst_1
    //   971: new 173	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   978: ldc_w 926
    //   981: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: iload 4
    //   986: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   989: ldc_w 462
    //   992: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   998: invokestatic 403	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1001: goto -262 -> 739
    //   1004: goto -876 -> 128
    //   1007: return
    //   1008: aload 7
    //   1010: astore 6
    //   1012: goto -760 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1015	0	this	p
    //   0	1015	1	paramString	String
    //   0	1015	2	paramArrayOfByte	byte[]
    //   0	1015	3	paramWUserSigInfo	WUserSigInfo
    //   0	1015	4	paramInt	int
    //   0	1015	5	paramErrMsg	ErrMsg
    //   221	790	6	localObject1	Object
    //   217	792	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	101	171	java/lang/Exception
    //   128	140	171	java/lang/Exception
    //   141	168	171	java/lang/Exception
    //   200	204	171	java/lang/Exception
    //   214	219	397	java/lang/Exception
    //   252	367	397	java/lang/Exception
    //   383	396	397	java/lang/Exception
    //   426	435	397	java/lang/Exception
    //   438	448	397	java/lang/Exception
    //   456	460	397	java/lang/Exception
    //   367	383	455	java/lang/Exception
    //   577	593	767	java/lang/Exception
    //   875	909	910	java/lang/Exception
  }
  
  public void b(WUserSigInfo paramWUserSigInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter.MsfProvider", 2, "OnCloseDevLock ret:" + paramInt);
    }
    if (this.g) {}
    try
    {
      FromServiceMsg localFromServiceMsg = u.a(this.d);
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
    paramWUserSigInfo = o.a(this.d);
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
      FromServiceMsg localFromServiceMsg = u.a(this.d);
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
    paramWUserSigInfo = o.a(this.d);
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
      for (;;)
      {
        FromServiceMsg localFromServiceMsg;
        try
        {
          localFromServiceMsg = u.a(this.d);
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
            localFromServiceMsg.addAttribute("smsExtraData", WtloginHelper.getLoginResultData(paramWUserSigInfo, 1347));
            switch (paramInt)
            {
            case 2: 
              localFromServiceMsg.setBusinessFail(1001, paramErrMsg.getMessage());
              QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt failed");
              break label579;
              paramString = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4194304);
              if (paramString != null)
              {
                paramString = paramString._sig;
                if (paramString == null) {
                  break label534;
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
          n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        }
        catch (Exception paramString)
        {
          QLog.d("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt error " + paramString, paramString);
          return;
        }
        this.f = paramWUserSigInfo._seqence;
        n.b(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        n.d.put(Integer.valueOf(this.d.getRequestSsoSeq()), this);
        this.f = paramWUserSigInfo._seqence;
        n.a(paramString, this.e, this.f, this.d, localFromServiceMsg, paramErrMsg.getMessage());
        return;
        try
        {
          a(paramString);
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
        label534:
        if (QLog.isColorLevel())
        {
          QLog.e("MSF.C.WTLoginCenter.MsfProvider", 1, "OnCheckSMSAndGetSt ret: " + paramInt + " , t is null.");
          continue;
          continue;
          label579:
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
    paramWUserSigInfo = o.a(this.d);
    paramWUserSigInfo.setMsgSuccess();
    paramWUserSigInfo.attributes.put("resp_register_resultcode", Integer.valueOf(1));
    paramWUserSigInfo.attributes.put("resp_register_promptinfo", paramArrayOfByte);
    this.e.addRespToQuque(this.d, paramWUserSigInfo);
  }
  
  public void d(WUserSigInfo paramWUserSigInfo, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.g) {}
    FromServiceMsg localFromServiceMsg = o.a(this.d);
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
      paramArrayOfByte = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 40);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        localFromServiceMsg.attributes.put("resp_verify_account_faceUrl", paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | bindFaceUrl=" + paramArrayOfByte);
        }
      }
      paramWUserSigInfo = WtloginHelper.getRegTlvValue(paramWUserSigInfo, 51);
      if (paramWUserSigInfo != null)
      {
        paramWUserSigInfo = new String(paramWUserSigInfo);
        localFromServiceMsg.attributes.put("resp_phone_protect_uins_url", paramWUserSigInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Login_Optimize_WtProviderImpl", 2, "OnRegSubmitMsgChk | phoneProtectUinsUrl=" + paramWUserSigInfo);
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