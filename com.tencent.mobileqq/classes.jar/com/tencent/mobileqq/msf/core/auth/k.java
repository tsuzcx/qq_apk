package com.tencent.mobileqq.msf.core.auth;

import com.qq.jce.wup.UniPacket;
import com.qq.jce.wup.WupHexUtil;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.msf.service.protocol.security.i;
import com.tencent.msf.service.protocol.security.l;
import com.tencent.msf.service.protocol.security.o;
import com.tencent.msf.service.protocol.security.p;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class k
{
  public static final String a = "MSF.C.AccountRespHandler";
  b b;
  
  public k(b paramb)
  {
    this.b = paramb;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1;
    Object localObject2;
    if ((paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getWupBuffer() != null) && (paramFromServiceMsg.getWupBuffer().length > 0))
    {
      localObject1 = new UniPacket(true);
      ((UniPacket)localObject1).setEncodeName("UTF-8");
      ((UniPacket)localObject1).decode(paramFromServiceMsg.getWupBuffer());
      localObject2 = (com.tencent.msf.service.protocol.security.k)((UniPacket)localObject1).getByClass("RespondHeader", new com.tencent.msf.service.protocol.security.k());
      if (localObject2 != null)
      {
        if (!this.b.b.containsKey(((com.tencent.msf.service.protocol.security.k)localObject2).d)) {
          this.b.b(((com.tencent.msf.service.protocol.security.k)localObject2).d);
        }
        a locala = (a)this.b.b.get(((com.tencent.msf.service.protocol.security.k)localObject2).d);
        if (((com.tencent.msf.service.protocol.security.k)localObject2).f == 101)
        {
          this.b.e.a(paramToServiceMsg, paramFromServiceMsg, (UniPacket)localObject1, (com.tencent.msf.service.protocol.security.k)localObject2);
          this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        Object localObject3;
        if ((((com.tencent.msf.service.protocol.security.k)localObject2).f != 0) && (((com.tencent.msf.service.protocol.security.k)localObject2).f != 10))
        {
          if (((com.tencent.msf.service.protocol.security.k)localObject2).f == 203)
          {
            localObject1 = (i)((UniPacket)localObject1).getByClass("RespondAuth", new i());
            if ((localObject1 != null) && (((i)localObject1).b != null)) {
              localObject1 = ((i)localObject1).b;
            } else {
              localObject1 = "password error";
            }
            paramFromServiceMsg.setBusinessFail(2005, (String)localObject1);
            this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          if (((com.tencent.msf.service.protocol.security.k)localObject2).f == 235)
          {
            localObject1 = (com.tencent.msf.service.protocol.security.j)((UniPacket)localObject1).getByClass("RespondGetServerTime", new com.tencent.msf.service.protocol.security.j());
            if (localObject1 != null)
            {
              this.b.a((int)(((com.tencent.msf.service.protocol.security.j)localObject1).b - System.currentTimeMillis() / 1000L));
              if ((paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth) || (paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) || (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin))
              {
                if (paramToServiceMsg.getAttribute("to_login_alsoCheckTime") == null)
                {
                  paramToServiceMsg.addAttribute("to_login_alsoCheckTime", Integer.valueOf(1));
                  if (paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth)
                  {
                    this.b.a.login(paramToServiceMsg);
                    return;
                  }
                  if (paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin)
                  {
                    this.b.a.ChangeUinLogin(paramToServiceMsg);
                    return;
                  }
                  if (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin)
                  {
                    this.b.a.wt_GetStViaSMSVerifyLogin(paramToServiceMsg);
                    return;
                  }
                  QLog.d("AuthRespHandler", 2, "HandlerLoginResp authResp.result == com.tencent.msf.service.protocol.security.Const.RESULT_A1Overtime and go else?? what happen?");
                }
                return;
              }
            }
            paramFromServiceMsg.setBusinessFail(1012, "client time error");
            this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          localObject1 = (i)((UniPacket)localObject1).getByClass("RespondAuth", new i());
          if ((localObject1 != null) && (((i)localObject1).b != null)) {
            localObject1 = ((i)localObject1).b;
          } else {
            localObject1 = "loginFailed.";
          }
          if ((((com.tencent.msf.service.protocol.security.k)localObject2).b == 14) || (((com.tencent.msf.service.protocol.security.k)localObject2).b == 0))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(Thread.currentThread().getName());
            ((StringBuilder)localObject3).append(" HandlerLoginResp setAccountNoLogin uin=");
            ((StringBuilder)localObject3).append(MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
            QLog.d("MSF.C.AccountRespHandler", 1, ((StringBuilder)localObject3).toString());
            this.b.k(paramFromServiceMsg.getUin());
          }
          paramFromServiceMsg.setBusinessFail(((com.tencent.msf.service.protocol.security.k)localObject2).f, (String)localObject1);
          if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_refreToken)
          {
            this.b.g.a(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        int i = ((com.tencent.msf.service.protocol.security.k)localObject2).b;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 6)
            {
              if (i != 9)
              {
                if (i == 17) {
                  return;
                }
                switch (i)
                {
                default: 
                  this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
                  return;
                case 15: 
                  paramToServiceMsg = (com.tencent.msf.service.protocol.security.j)((UniPacket)localObject1).getByClass("RespondGetServerTime", new com.tencent.msf.service.protocol.security.j());
                  if (paramToServiceMsg == null) {
                    break;
                  }
                  NetConnInfoCenter.handleGetServerTimeResp(paramToServiceMsg.b);
                  return;
                case 14: 
                  localObject3 = (o)((UniPacket)localObject1).getByClass("ResponseAuthWlogin", new o());
                  if (localObject3 != null)
                  {
                    localObject3 = ((o)localObject3).d;
                    if (localObject3 != null) {
                      i = localObject3.length;
                    }
                  }
                  this.b.e.a((UniPacket)localObject1, locala);
                  this.b.e.a(paramToServiceMsg, paramFromServiceMsg, (com.tencent.msf.service.protocol.security.k)localObject2);
                  return;
                case 13: 
                  this.b.a(paramToServiceMsg.getUin(), (com.tencent.msf.service.protocol.security.k)localObject2);
                  locala.d(((com.tencent.msf.service.protocol.security.k)localObject2).e);
                  paramFromServiceMsg.addAttribute(paramFromServiceMsg.getServiceCmd(), ((com.tencent.msf.service.protocol.security.k)localObject2).d);
                  localObject1 = (p)((UniPacket)localObject1).getByClass("ResponseNameExchangeUin", new p());
                  if (localObject1 != null)
                  {
                    localObject2 = ((p)localObject1).d;
                    if (localObject2 != null) {
                      i = localObject2.length;
                    }
                    paramFromServiceMsg.addAttribute("__base_tag_sigSession", ((p)localObject1).e);
                  }
                  this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
                  return;
                }
              }
              RespondCustomSig localRespondCustomSig = (RespondCustomSig)((UniPacket)localObject1).getByClass("RespondCustomSig", new RespondCustomSig());
              ArrayList localArrayList = new ArrayList();
              i = 0;
              int j = 0;
              localObject1 = localObject2;
              while (i < localRespondCustomSig.SigList.size())
              {
                localObject2 = (CustomSigContent)localRespondCustomSig.SigList.get(i);
                int k;
                if (((CustomSigContent)localObject2).ulSigType == 13L)
                {
                  Object localObject4 = new Cryptor();
                  byte[] arrayOfByte = ((CustomSigContent)localObject2).SigContent;
                  localObject3 = locala.f();
                  Object localObject5;
                  if (localObject3 != null)
                  {
                    localObject2 = localObject3;
                    if (localObject3.length != 0) {}
                  }
                  else
                  {
                    localObject5 = this.b.l(((com.tencent.msf.service.protocol.security.k)localObject1).d);
                    localObject2 = localObject3;
                    if (localObject5 != null) {
                      localObject2 = ((a)localObject5).f();
                    }
                  }
                  if ((localObject2 != null) && (localObject2.length != 0))
                  {
                    localObject2 = MD5.toMD5Byte((byte[])localObject2);
                    if ((localObject2 != null) && (localObject2.length != 0))
                    {
                      localObject2 = ((Cryptor)localObject4).decrypt(arrayOfByte, (byte[])localObject2);
                      if ((localObject2 != null) && (localObject2.length != 0))
                      {
                        localObject3 = new byte[4];
                        arrayOfByte = new byte[16];
                        localObject4 = new byte[2];
                        j.a((byte[])localObject3, 0, (byte[])localObject2, 4);
                        j.a(arrayOfByte, 0, (byte[])localObject2, 4, 16);
                        j.a((byte[])localObject4, 0, (byte[])localObject2, 20, 2);
                        localObject5 = new int[2];
                        localObject5[0] = localObject4[0];
                        localObject5[0] <<= 8;
                        localObject5[1] = localObject4[1];
                        j = localObject5[0] + localObject5[1];
                        k = localObject2.length;
                        int m = j + 22;
                        if (k != m)
                        {
                          localObject3 = new StringBuilder();
                          ((StringBuilder)localObject3).append("D3.length is ");
                          ((StringBuilder)localObject3).append(localObject2.length);
                          ((StringBuilder)localObject3).append(", but expected to be ");
                          ((StringBuilder)localObject3).append(m);
                          QLog.d("MSF.C.AccountRespHandler", 2, ((StringBuilder)localObject3).toString());
                        }
                        else
                        {
                          localObject4 = new byte[j];
                          j.a((byte[])localObject4, 0, (byte[])localObject2, 22, j);
                          localObject2 = new StringBuilder();
                          ((StringBuilder)localObject2).append(WupHexUtil.bytes2HexStr((byte[])localObject3));
                          ((StringBuilder)localObject2).append(",");
                          ((StringBuilder)localObject2).append(WupHexUtil.bytes2HexStr(arrayOfByte));
                          ((StringBuilder)localObject2).append(",");
                          ((StringBuilder)localObject2).append(WupHexUtil.bytes2HexStr((byte[])localObject4));
                          localArrayList.add(((StringBuilder)localObject2).toString());
                        }
                      }
                      else
                      {
                        localObject2 = new StringBuilder();
                        ((StringBuilder)localObject2).append("D3 decrypt by A2 failed, D3 is ");
                        ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr(arrayOfByte));
                        QLog.d("MSF.C.AccountRespHandler", 2, ((StringBuilder)localObject2).toString());
                      }
                    }
                    else
                    {
                      QLog.d("MSF.C.AccountRespHandler", 2, "dekey A2 is null!");
                    }
                  }
                  else
                  {
                    QLog.d("MSF.C.AccountRespHandler", 2, "A2 is null!");
                  }
                  k = 1;
                }
                else
                {
                  localArrayList.add(((CustomSigContent)localObject2).toString());
                  k = j;
                  if (((CustomSigContent)localObject2).ulSigType == 3L)
                  {
                    paramFromServiceMsg.addAttribute("A8", localObject2);
                    k = j;
                  }
                }
                i += 1;
                j = k;
              }
              if (j != 0) {
                paramFromServiceMsg.addAttribute(paramFromServiceMsg.getServiceCmd(), localArrayList);
              } else {
                paramFromServiceMsg.addAttribute(paramFromServiceMsg.getServiceCmd(), localRespondCustomSig);
              }
              if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_refreToken)
              {
                this.b.g.a(paramToServiceMsg, paramFromServiceMsg);
                return;
              }
              this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            localObject1 = (l)((UniPacket)localObject1).getByClass("RespondReFetchSid", new l());
            this.b.a(paramFromServiceMsg.getUin(), new String(((l)localObject1).b), System.currentTimeMillis());
            paramFromServiceMsg.addAttribute(paramFromServiceMsg.getServiceCmd(), ((l)localObject1).b);
            if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_refreToken)
            {
              this.b.g.a(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          try
          {
            if (((UniPacket)localObject1).getServantName().equals("Login.Register"))
            {
              this.b.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            localObject3 = (o)((UniPacket)localObject1).getByClass("ResponseAuthWlogin", new o());
            if (localObject3 != null)
            {
              localObject3 = ((o)localObject3).d;
              if (localObject3 != null) {
                i = localObject3.length;
              }
            }
            this.b.e.a((UniPacket)localObject1, locala);
            this.b.e.a(paramToServiceMsg, paramFromServiceMsg, (com.tencent.msf.service.protocol.security.k)localObject2);
            return;
          }
          catch (Exception paramToServiceMsg)
          {
            QLog.d("MSF.C.AccountRespHandler", 2, "handle _CMD_ID_VERIFY_PIC failed.", paramToServiceMsg);
            return;
          }
        }
        this.b.e.a(paramToServiceMsg, paramFromServiceMsg, (com.tencent.msf.service.protocol.security.k)localObject2);
      }
    }
    else if ((paramToServiceMsg.getMsfCommand() == MsfCommand.changeUinLogin) || (paramToServiceMsg.getMsfCommand() == MsfCommand.loginAuth) || (paramToServiceMsg.getMsfCommand() == MsfCommand.wt_GetStViaSMSVerifyLogin))
    {
      boolean bool = paramFromServiceMsg.getServiceCmd().equals("login.chguin");
      long l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
      long l3 = com.tencent.mobileqq.msf.core.d.j.a(paramToServiceMsg, paramFromServiceMsg);
      if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
        localObject1 = (String)paramToServiceMsg.getAttribute("_tag_socket");
      } else {
        localObject1 = "0";
      }
      if (paramToServiceMsg.getAttributes().containsKey("_tag_localsocket")) {
        localObject2 = (String)paramToServiceMsg.getAttribute("_tag_localsocket");
      } else {
        localObject2 = "0";
      }
      if (paramFromServiceMsg.getBusinessFailCode() == 1002)
      {
        long l1 = 0L;
        if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net"))
        {
          if (paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
            l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue() - ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
          }
          if (this.b.a.getStatReporter() != null) {
            this.b.a.getStatReporter().a(false, l2, 1014, l3, (String)localObject1, (String)localObject2, bool, l1);
          }
        }
        else if (this.b.a.getStatReporter() != null)
        {
          this.b.a.getStatReporter().a(false, l2, paramFromServiceMsg.getBusinessFailCode(), l3, (String)localObject1, (String)localObject2, bool, 0L);
        }
      }
      else if (paramFromServiceMsg.getBusinessFailCode() == 2008)
      {
        if (this.b.a.getStatReporter() != null) {
          this.b.a.getStatReporter().a(paramToServiceMsg.getUin(), false, l2, paramFromServiceMsg.getBusinessFailCode(), l3);
        }
      }
      else if (this.b.a.getStatReporter() != null)
      {
        this.b.a.getStatReporter().a(true, l2, paramFromServiceMsg.getBusinessFailCode(), l3, (String)localObject1, (String)localObject2, bool, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.k
 * JD-Core Version:    0.7.0.1
 */