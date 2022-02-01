package com.tencent.mobileqq.msf.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.a.c;
import com.tencent.mobileqq.msf.core.net.a.b;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffData;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffItem;
import com.tencent.msf.service.protocol.pb.SSOReserveField.ReserveFields;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class ac$a
  extends CodecWarpper
{
  ac$a(ac paramac) {}
  
  private com.tencent.qphone.base.a a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return com.tencent.qphone.base.a.u;
    case -2: 
      return com.tencent.qphone.base.a.v;
    case -3: 
      return com.tencent.qphone.base.a.w;
    case -4: 
      return com.tencent.qphone.base.a.x;
    case -5: 
      return com.tencent.qphone.base.a.j;
    case -6: 
      return com.tencent.qphone.base.a.r;
    case -7: 
      return com.tencent.qphone.base.a.s;
    }
    return com.tencent.qphone.base.a.y;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (MsfService.getCore().getStatReporter() != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("fail_code", String.valueOf(paramInt1));
      localHashMap.put("data_len", String.valueOf(paramInt2));
      MsfService.getCore().getStatReporter().a("msf_invalid_data", false, 0L, 0L, localHashMap, true, false);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      try
      {
        paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
        if ((!TextUtils.isEmpty(paramFromServiceMsg)) && (paramFromServiceMsg.equals("SharpSvr.s2c")))
        {
          u.a("MSF:VideoPush", 3000L);
          return;
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.e(tag, 1, "checkVideoPushCmd fail.", paramFromServiceMsg);
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(ByteBuffer paramByteBuffer)
  {
    if (!ac.w()) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramByteBuffer.remaining() < 16)
    {
      localObject1 = tag;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setGatewayIpV6, remaining = ");
      ((StringBuilder)localObject2).append(paramByteBuffer.remaining());
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new StringBuilder();
        localObject2 = new byte[2];
        i = 0;
        if (i < 8)
        {
          paramByteBuffer.get((byte[])localObject2);
          ((StringBuilder)localObject1).append(HexUtil.bytes2HexStr((byte[])localObject2));
          if (i == 7) {
            break label266;
          }
          ((StringBuilder)localObject1).append(":");
          break label266;
        }
        paramByteBuffer = f.a(((StringBuilder)localObject1).toString().toLowerCase());
        ac.e(paramByteBuffer);
        if (QLog.isDevelopLevel())
        {
          localObject1 = tag;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setGatewayIpV6, ip = ");
          ((StringBuilder)localObject2).append(paramByteBuffer);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = tag;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setGatewayIpV6, ");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ip = ");
          localStringBuilder.append(paramByteBuffer);
          ((StringBuilder)localObject2).append(com.tencent.mobileqq.msf.core.b.a.a(localStringBuilder.toString()));
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          return;
        }
      }
      catch (Throwable paramByteBuffer)
      {
        if (QLog.isColorLevel()) {
          QLog.d(tag, 2, "setGatewayIpV6 throws e", paramByteBuffer);
        }
      }
      return;
      label266:
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = tag;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("MSF.C.CodecWarpper loginMerge onInvalidData ");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(" size is ");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", try to closeConn");
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    this.a.b.l().b(a(paramInt1));
    localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append(ac.d(this.a));
    ((StringBuffer)localObject1).append("|");
    ((StringBuffer)localObject1).append(MsfCore.mobileQQAppid);
    ((StringBuffer)localObject1).append("|");
    ((StringBuffer)localObject1).append(paramInt3);
    ((StringBuffer)localObject1).append("|");
    ((StringBuffer)localObject1).append(paramInt1);
    ((StringBuffer)localObject1).append("|");
    ((StringBuffer)localObject1).append(this.a.b.l().b().a());
    if (QLog.isDevelopLevel())
    {
      localObject2 = tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CodecStatHelper Report loginMerge_error ");
      localStringBuilder.append(((StringBuffer)localObject1).toString());
      QLog.d((String)localObject2, 4, localStringBuilder.toString());
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("loginMerge_failDetail", ((StringBuffer)localObject1).toString());
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a("loginMerge_error", true, 0L, 0L, (Map)localObject2, false, false);
    }
  }
  
  public void onInvalidData(int paramInt1, int paramInt2)
  {
    String str = tag;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MSF.C.CodecWarpper onInvalidData ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" size is ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", try to closeConn");
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    this.a.b.l().b(a(paramInt1));
    try
    {
      this.a.b.i();
    }
    catch (Exception localException)
    {
      localObject = tag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("call findResponseDataError error ");
      localStringBuilder.append(localException);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2);
  }
  
  public void onInvalidSign()
  {
    QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidSign");
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.a.D.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_InvalidSign");
    localFromServiceMsg.setBusinessFail(2014, "onInvalidSign");
    localFromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    this.a.D.addRespToQuque(null, localFromServiceMsg);
    ac.v().set(true);
  }
  
  public void onResponse(int paramInt1, Object paramObject, int paramInt2)
  {
    if (paramObject != null)
    {
      Object localObject2;
      Object localObject4;
      try
      {
        if (ac.V != -1) {
          ac.V = -1;
        }
        this.a.T = System.currentTimeMillis();
        ac.U = this.a.T;
        localObject2 = (FromServiceMsg)paramObject;
        try
        {
          paramInt1 = ((FromServiceMsg)localObject2).getWupBuffer().length;
          boolean bool = ((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge");
          Object localObject1;
          Object localObject3;
          if (bool)
          {
            ((FromServiceMsg)localObject2).setRequestSsoSeq(((FromServiceMsg)localObject2).getAppSeq());
            if (!((FromServiceMsg)localObject2).isSuccess())
            {
              if (QLog.isColorLevel()) {
                localObject1 = ((FromServiceMsg)localObject2).getServiceCmd();
              } else {
                localObject1 = com.tencent.mobileqq.msf.core.b.a.a(((FromServiceMsg)localObject2).getServiceCmd());
              }
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("failed merge netRecv ssoSeq:");
              ((StringBuilder)localObject3).append(((FromServiceMsg)localObject2).getRequestSsoSeq());
              ((StringBuilder)localObject3).append(" cmd: ");
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append(" len: ");
              ((StringBuilder)localObject3).append(((FromServiceMsg)localObject2).getWupBuffer().length);
              QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject3).toString());
              localObject1 = (ArrayList)this.a.e.remove(Integer.valueOf(((FromServiceMsg)localObject2).getRequestSsoSeq()));
              if (((FromServiceMsg)localObject2).getBusinessFailCode() == -10107)
              {
                if (this.a.r) {
                  this.a.r = false;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("merge not support, ");
                ((StringBuilder)localObject3).append(Arrays.toString(((ArrayList)localObject1).toArray()));
                ((StringBuilder)localObject3).append("resend, close merge.");
                QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject3).toString());
              }
              if (localObject1 != null)
              {
                localObject1 = ((ArrayList)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  paramInt1 = ((Integer)((Iterator)localObject1).next()).intValue();
                  localObject3 = this.a.D.sender.c(paramInt1);
                  if (localObject3 != null) {
                    ac.a(this.a, (ToServiceMsg)localObject3);
                  }
                }
              }
            }
          }
          Object localObject5;
          if ((((FromServiceMsg)localObject2).getFlag() & 0x1) != 0)
          {
            localObject1 = ((FromServiceMsg)localObject2).getWupBuffer();
            int i = localObject1.length;
            if (i > 4)
            {
              i = (localObject1[0] & 0xFF) << 24 | 0x0 | (localObject1[1] & 0xFF) << 16 | (localObject1[2] & 0xFF) << 8 | localObject1[3] & 0xFF;
              try
              {
                localObject3 = new byte[i];
                System.arraycopy(localObject1, 4, localObject3, 0, i - 4);
                localObject3 = com.tencent.qphone.base.util.j.b((byte[])localObject3);
                localObject5 = new byte[localObject3.length + 4];
                localObject5[0] = ((byte)(localObject3.length + 4 >> 24 & 0xFF));
                localObject5[1] = ((byte)(localObject3.length + 4 >> 16 & 0xFF));
                localObject5[2] = ((byte)(localObject3.length + 4 >> 8 & 0xFF));
                localObject5[3] = ((byte)(localObject3.length + 4 & 0xFF));
                System.arraycopy(localObject3, 0, localObject5, 4, localObject3.length);
                ((FromServiceMsg)localObject2).putWupBuffer((byte[])localObject5);
              }
              catch (Exception localException)
              {
                if (QLog.isColorLevel())
                {
                  localObject5 = tag;
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("uncompress data failed ");
                  localStringBuilder.append(localException);
                  QLog.d((String)localObject5, 2, localStringBuilder.toString());
                }
                if (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge"))
                {
                  onInvalidData(-7, localObject1.length);
                  return;
                }
                a(-7, localObject1.length, ((FromServiceMsg)localObject2).getRequestSsoSeq());
                return;
              }
            }
            else
            {
              if (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge"))
              {
                onInvalidData(-6, localObject1.length);
                return;
              }
              a(-6, localObject1.length, ((FromServiceMsg)localObject2).getRequestSsoSeq());
              return;
            }
          }
          if ((((FromServiceMsg)localObject2).isSuccess()) && (((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge")))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("netRecv Delay FromServiceMsg ssoSeq:");
            ((StringBuilder)localObject1).append(((FromServiceMsg)localObject2).getRequestSsoSeq());
            ((StringBuilder)localObject1).append(" scmd: ");
            ((StringBuilder)localObject1).append(((FromServiceMsg)localObject2).getServiceCmd());
            ((StringBuilder)localObject1).append(" len: ");
            ((StringBuilder)localObject1).append(paramInt1);
            ((StringBuilder)localObject1).append(" uncompressed len: ");
            ((StringBuilder)localObject1).append(((FromServiceMsg)localObject2).getWupBuffer().length);
            QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject1).toString());
            localObject1 = new SSOLoginMerge.BusiBuffData();
            localObject4 = new byte[((FromServiceMsg)localObject2).getWupBuffer().length - 4];
            System.arraycopy(((FromServiceMsg)localObject2).getWupBuffer(), 4, localObject4, 0, localObject4.length);
            localObject1 = ((SSOLoginMerge.BusiBuffData)((SSOLoginMerge.BusiBuffData)localObject1).mergeFrom((byte[])localObject4)).BusiBuffVec.get().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject4 = (SSOLoginMerge.BusiBuffItem)((Iterator)localObject1).next();
              localObject5 = new FromServiceMsg();
              ((FromServiceMsg)localObject5).setServiceCmd(((SSOLoginMerge.BusiBuffItem)localObject4).ServiceCmd.get());
              ((FromServiceMsg)localObject5).setRequestSsoSeq(((SSOLoginMerge.BusiBuffItem)localObject4).SeqNo.get());
              ((FromServiceMsg)localObject5).putWupBuffer(((SSOLoginMerge.BusiBuffItem)localObject4).BusiBuff.get().toByteArray());
              ((FromServiceMsg)localObject5).setAppSeq(((FromServiceMsg)localObject5).getRequestSsoSeq());
              ((FromServiceMsg)localObject5).setMsgSuccess();
              ((FromServiceMsg)localObject5).setUin(((FromServiceMsg)localObject2).getUin());
              ((FromServiceMsg)localObject5).putWupBuffer(ac.b(((FromServiceMsg)localObject5).getWupBuffer()));
              a((FromServiceMsg)localObject5, ((FromServiceMsg)localObject5).getWupBuffer().length);
            }
          }
          a((FromServiceMsg)localObject2, paramInt2);
          return;
        }
        catch (Throwable localThrowable1) {}
        if (!localThrowable2.toString().contains("InvalidProtocol")) {
          break label1044;
        }
      }
      catch (Throwable localThrowable2)
      {
        localObject2 = null;
      }
      if (localObject2 != null) {
        a(-8, paramInt2, ((FromServiceMsg)localObject2).getRequestSsoSeq());
      }
      label1044:
      if (QLog.isColorLevel())
      {
        localObject2 = tag;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("handleSsoResp ");
        ((StringBuilder)localObject4).append(paramObject);
        ((StringBuilder)localObject4).append(" error ");
        ((StringBuilder)localObject4).append(localThrowable2.toString());
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject4).toString(), localThrowable2);
      }
    }
    return;
  }
  
  public void onResponse(int paramInt1, Object paramObject, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramObject != null) {}
    label1591:
    label1660:
    label1661:
    label1662:
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      try
      {
        if (ac.V != -1) {
          ac.V = -1;
        }
        this.a.T = System.currentTimeMillis();
        ac.U = this.a.T;
        localObject2 = (FromServiceMsg)paramObject;
        try
        {
          paramInt1 = ((FromServiceMsg)localObject2).getWupBuffer().length;
          int i = ((FromServiceMsg)localObject2).getResultCode();
          Object localObject3;
          switch (i)
          {
          default: 
            break;
          case -10110: 
            this.a.D.ssoListManager.e();
            this.a.D.sender.b.l().b(com.tencent.qphone.base.a.h);
            this.a.D.isReconnectSso.set(false);
            localObject1 = tag;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("close conn, handleHttpSsoResp result code: ");
            ((StringBuilder)localObject3).append(((FromServiceMsg)localObject2).getResultCode());
            QLog.d((String)localObject1, 1, ((StringBuilder)localObject3).toString());
            break;
          case -10111: 
            localObject1 = tag;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleHttpSsoResp result code: ");
            ((StringBuilder)localObject3).append(((FromServiceMsg)localObject2).getResultCode());
            QLog.d((String)localObject1, 1, ((StringBuilder)localObject3).toString());
            this.a.D.ssoListManager.e();
            if (NetConnInfoCenter.getActiveNetIpFamily(true) != 2)
            {
              this.a.D.sender.b.l().b(com.tencent.qphone.base.a.h);
              this.a.D.isReconnectSso.set(false);
              QLog.d(tag, 1, "close conn");
            }
            break;
          case -10112: 
            localObject1 = tag;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleHttpSsoResp result code: ");
            ((StringBuilder)localObject3).append(((FromServiceMsg)localObject2).getResultCode());
            QLog.d((String)localObject1, 1, ((StringBuilder)localObject3).toString());
          }
          boolean bool = ((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge");
          if (bool)
          {
            ((FromServiceMsg)localObject2).setRequestSsoSeq(((FromServiceMsg)localObject2).getAppSeq());
            if (!((FromServiceMsg)localObject2).isSuccess())
            {
              if (QLog.isColorLevel()) {
                localObject1 = ((FromServiceMsg)localObject2).getServiceCmd();
              } else {
                localObject1 = com.tencent.mobileqq.msf.core.b.a.a(((FromServiceMsg)localObject2).getServiceCmd());
              }
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("failed merge netRecv ssoSeq:");
              ((StringBuilder)localObject3).append(((FromServiceMsg)localObject2).getRequestSsoSeq());
              ((StringBuilder)localObject3).append(" cmd: ");
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append(" len: ");
              ((StringBuilder)localObject3).append(((FromServiceMsg)localObject2).getWupBuffer().length);
              QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject3).toString());
              localObject1 = (ArrayList)this.a.e.remove(Integer.valueOf(((FromServiceMsg)localObject2).getRequestSsoSeq()));
              if (((FromServiceMsg)localObject2).getBusinessFailCode() == -10107)
              {
                if (this.a.r) {
                  this.a.r = false;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("merge not support, ");
                ((StringBuilder)localObject3).append(Arrays.toString(((ArrayList)localObject1).toArray()));
                ((StringBuilder)localObject3).append("resend, close merge.");
                QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject3).toString());
              }
              if (localObject1 != null)
              {
                paramArrayOfByte = ((ArrayList)localObject1).iterator();
                if (!paramArrayOfByte.hasNext()) {
                  break label1661;
                }
                paramInt1 = ((Integer)paramArrayOfByte.next()).intValue();
                localObject1 = this.a.D.sender.c(paramInt1);
                if (localObject1 == null) {
                  continue;
                }
                ac.a(this.a, (ToServiceMsg)localObject1);
                continue;
              }
            }
          }
          if ((((FromServiceMsg)localObject2).getFlag() & 0x1) != 0)
          {
            localObject1 = ((FromServiceMsg)localObject2).getWupBuffer();
            i = localObject1.length;
            if (i > 4)
            {
              i = (localObject1[0] & 0xFF) << 24 | 0x0 | (localObject1[1] & 0xFF) << 16 | (localObject1[2] & 0xFF) << 8 | localObject1[3] & 0xFF;
              try
              {
                localObject3 = new byte[i];
                System.arraycopy(localObject1, 4, localObject3, 0, i - 4);
                localObject3 = com.tencent.qphone.base.util.j.b((byte[])localObject3);
                localObject4 = new byte[localObject3.length + 4];
                localObject4[0] = ((byte)(localObject3.length + 4 >> 24 & 0xFF));
                localObject4[1] = ((byte)(localObject3.length + 4 >> 16 & 0xFF));
                localObject4[2] = ((byte)(localObject3.length + 4 >> 8 & 0xFF));
                localObject4[3] = ((byte)(localObject3.length + 4 & 0xFF));
                System.arraycopy(localObject3, 0, localObject4, 4, localObject3.length);
                ((FromServiceMsg)localObject2).putWupBuffer((byte[])localObject4);
              }
              catch (Exception paramArrayOfByte)
              {
                Object localObject4;
                if (QLog.isColorLevel())
                {
                  localObject3 = tag;
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("uncompress data failed ");
                  ((StringBuilder)localObject4).append(paramArrayOfByte);
                  QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
                }
                if (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge"))
                {
                  onInvalidData(-7, localObject1.length);
                  return;
                }
                a(-7, localObject1.length, ((FromServiceMsg)localObject2).getRequestSsoSeq());
                return;
              }
            }
            else
            {
              if (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge"))
              {
                onInvalidData(-6, localObject1.length);
                return;
              }
              a(-6, localObject1.length, ((FromServiceMsg)localObject2).getRequestSsoSeq());
              return;
            }
          }
          if (paramArrayOfByte == null) {
            break label1662;
          }
          try
          {
            if (!((FromServiceMsg)localObject2).getServiceCmd().equals("MessageSvc.PushNotify")) {
              break label1662;
            }
            long l = SystemClock.elapsedRealtime();
            try
            {
              ac.w = com.tencent.mobileqq.msf.core.c.j.a(false, l - 5000L, l);
              localObject1 = new SSOReserveField.ReserveFields();
              ((SSOReserveField.ReserveFields)localObject1).mergeFrom(paramArrayOfByte);
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append(((SSOReserveField.ReserveFields)localObject1).sso_send.get());
              paramArrayOfByte.append("|");
              paramArrayOfByte.append(System.currentTimeMillis());
              ((FromServiceMsg)localObject2).addAttribute("sso_push_timestamp", paramArrayOfByte.toString());
              localObject1 = tag;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("pushnotify add timestamp ");
              ((StringBuilder)localObject3).append(paramArrayOfByte.toString());
              QLog.d((String)localObject1, 1, ((StringBuilder)localObject3).toString());
              if (this.a.D.statReporter == null) {
                continue;
              }
              this.a.D.statReporter.a("dim.Msf.PushRecvEvent", true, 0L, 0L, null, false, false);
            }
            catch (Exception paramArrayOfByte) {}
            QLog.d(tag, 1, "resolve sso reserve field failed", paramArrayOfByte);
          }
          catch (Exception paramArrayOfByte) {}
          if ((((FromServiceMsg)localObject2).isSuccess()) && (((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge")))
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("netRecv Delay FromServiceMsg ssoSeq:");
            paramArrayOfByte.append(((FromServiceMsg)localObject2).getRequestSsoSeq());
            paramArrayOfByte.append(" scmd: ");
            paramArrayOfByte.append(((FromServiceMsg)localObject2).getServiceCmd());
            paramArrayOfByte.append(" len: ");
            paramArrayOfByte.append(paramInt1);
            paramArrayOfByte.append(" uncompressed len: ");
            paramArrayOfByte.append(((FromServiceMsg)localObject2).getWupBuffer().length);
            QLog.d("MSF.C.NetConnTag", 1, paramArrayOfByte.toString());
            paramArrayOfByte = new SSOLoginMerge.BusiBuffData();
            localObject1 = new byte[((FromServiceMsg)localObject2).getWupBuffer().length - 4];
            System.arraycopy(((FromServiceMsg)localObject2).getWupBuffer(), 4, localObject1, 0, localObject1.length);
            paramArrayOfByte = ((SSOLoginMerge.BusiBuffData)paramArrayOfByte.mergeFrom((byte[])localObject1)).BusiBuffVec.get().iterator();
            if (!paramArrayOfByte.hasNext()) {
              break label1660;
            }
            localObject1 = (SSOLoginMerge.BusiBuffItem)paramArrayOfByte.next();
            localObject3 = new FromServiceMsg();
            ((FromServiceMsg)localObject3).setServiceCmd(((SSOLoginMerge.BusiBuffItem)localObject1).ServiceCmd.get());
            ((FromServiceMsg)localObject3).setRequestSsoSeq(((SSOLoginMerge.BusiBuffItem)localObject1).SeqNo.get());
            ((FromServiceMsg)localObject3).putWupBuffer(((SSOLoginMerge.BusiBuffItem)localObject1).BusiBuff.get().toByteArray());
            ((FromServiceMsg)localObject3).setAppSeq(((FromServiceMsg)localObject3).getRequestSsoSeq());
            ((FromServiceMsg)localObject3).setMsgSuccess();
            ((FromServiceMsg)localObject3).setUin(((FromServiceMsg)localObject2).getUin());
            ((FromServiceMsg)localObject3).putWupBuffer(ac.b(((FromServiceMsg)localObject3).getWupBuffer()));
            a((FromServiceMsg)localObject3, ((FromServiceMsg)localObject3).getWupBuffer().length);
            continue;
          }
          if ((((FromServiceMsg)localObject2).isSuccess()) && (((FromServiceMsg)localObject2).getServiceCmd().equals("RegPrxySvc.oidb_0x769")))
          {
            MsfPullConfigUtil.parseConfigResponse(((FromServiceMsg)localObject2).getWupBuffer(), true);
            return;
          }
          a((FromServiceMsg)localObject2, paramInt2);
          return;
        }
        catch (Throwable paramArrayOfByte)
        {
          localObject1 = localObject2;
        }
        if (!paramArrayOfByte.toString().contains("InvalidProtocol")) {
          break label1591;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        localObject1 = null;
      }
      if (localObject1 != null) {
        a(-8, paramInt2, ((FromServiceMsg)localObject1).getRequestSsoSeq());
      }
      if (QLog.isColorLevel())
      {
        localObject1 = tag;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleSsoResp ");
        ((StringBuilder)localObject2).append(paramObject);
        ((StringBuilder)localObject2).append(" error ");
        ((StringBuilder)localObject2).append(paramArrayOfByte.toString());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString(), paramArrayOfByte);
      }
      return;
      return;
    }
  }
  
  public int onSSOPingResponse(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject1;
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = tag;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MSF.C.CodecWarpper onSSOPingResponse error, data null, connId = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d(paramArrayOfByte, 1, ((StringBuilder)localObject1).toString());
      return -1;
    }
    Object localObject2;
    if (paramArrayOfByte.length <= 4)
    {
      localObject1 = tag;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("MSF.C.CodecWarpper onSSOPingResponse error, length: ");
      ((StringBuilder)localObject2).append(paramArrayOfByte.length);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return 1;
    }
    int j = paramArrayOfByte.length;
    for (;;)
    {
      long l1;
      try
      {
        Object localObject3 = ByteBuffer.wrap(paramArrayOfByte);
        int i = ((ByteBuffer)localObject3).getInt();
        if (i != j) {
          return 1;
        }
        ((ByteBuffer)localObject3).getInt();
        ((ByteBuffer)localObject3).getInt();
        int k = ((ByteBuffer)localObject3).get() - 1;
        if (k > 0)
        {
          if (k > i - 13) {
            return 1;
          }
          localObject1 = new byte[k];
          ((ByteBuffer)localObject3).get((byte[])localObject1, 0, k);
          localObject1 = new String((byte[])localObject1);
          boolean bool = ((String)localObject1).equals("MSF");
          if ((!bool) && (!((String)localObject1).equals("GWv4")) && (com.tencent.mobileqq.msf.core.a.a.aQ()))
          {
            bool = b.b();
            if (bool) {
              try
              {
                b.b(paramArrayOfByte);
                return 0;
              }
              catch (Exception paramArrayOfByte)
              {
                QLog.d(tag, 1, "heartbeatproxy failed to process back msg ", paramArrayOfByte);
                return 0;
              }
            }
          }
          i = ((ByteBuffer)localObject3).get();
          ((ByteBuffer)localObject3).position(((ByteBuffer)localObject3).position() + i - 1);
          i = ((ByteBuffer)localObject3).getInt();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i >> 24 & 0xFF);
          ((StringBuilder)localObject2).append('.');
          ((StringBuilder)localObject2).append(i >> 16 & 0xFF);
          ((StringBuilder)localObject2).append('.');
          ((StringBuilder)localObject2).append(i >> 8 & 0xFF);
          ((StringBuilder)localObject2).append('.');
          ((StringBuilder)localObject2).append(i & 0xFF);
          localObject2 = ((StringBuilder)localObject2).toString();
          a((ByteBuffer)localObject3);
          Object localObject4;
          if ("GWv4".equals(localObject1))
          {
            ac.O = i;
            if (paramArrayOfByte.length == 50)
            {
              localObject4 = new byte[24];
              ((ByteBuffer)localObject3).get((byte[])localObject4, 0, 24);
              ac.N = (byte[])localObject4;
              if (QLog.isColorLevel())
              {
                localObject3 = tag;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("MSF.C.CodecWarpper onSSOPingResponse sGwV4Sec:");
                ((StringBuilder)localObject4).append(ac.N);
                QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
              }
            }
          }
          if (QLog.isColorLevel())
          {
            localObject3 = tag;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("MSF.C.CodecWarpper onSSOPingResponse cmd:");
            ((StringBuilder)localObject4).append((String)localObject1);
            ((StringBuilder)localObject4).append(", ip=");
            ((StringBuilder)localObject4).append((String)localObject2);
            ((StringBuilder)localObject4).append(", totalsize=");
            ((StringBuilder)localObject4).append(j);
            QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
          }
          bool = QLog.isColorLevel();
          if (bool)
          {
            localObject3 = new StringBuilder();
            i = 0;
            if (i < j)
            {
              if (i % 4 == 0) {
                ((StringBuilder)localObject3).append("\n");
              }
              localObject2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
              localObject1 = localObject2;
              if (((String)localObject2).length() == 1)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("0");
                ((StringBuilder)localObject1).append((String)localObject2);
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append(" ");
              i += 1;
              continue;
            }
            paramArrayOfByte = tag;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("MSF.C.CodecWarpper onSSOPingResponse pingBack=");
            ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
            QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject1).toString());
          }
          this.a.b.e(paramInt);
          localObject1 = this.a.b.l().h();
          if ((localObject1 == null) || (((ToServiceMsg)localObject1).getAttribute("__timestamp_msf2net") == null)) {
            break label1142;
          }
          l2 = SystemClock.elapsedRealtime() - ((Long)((ToServiceMsg)localObject1).getAttribute("__timestamp_msf2net")).longValue();
          l1 = l2;
          if (l2 >= 0L) {
            break label1129;
          }
          l1 = 0L;
          break label1129;
          if (localObject1 != null)
          {
            com.tencent.mobileqq.a.a.a.a().a(((ToServiceMsg)localObject1).getRequestSsoSeq(), l2);
            localObject2 = new StringBuilder();
            paramArrayOfByte = ((ToServiceMsg)localObject1).getServiceCmd();
            bool = QLog.isDevelopLevel();
            if (bool)
            {
              if (l2 == 0L)
              {
                paramArrayOfByte = String.valueOf(l2);
              }
              else
              {
                paramArrayOfByte = new StringBuilder();
                paramArrayOfByte.append(l2);
                paramArrayOfByte.append(NetConnInfoCenter.getSignalStrengthsLog());
                paramArrayOfByte = paramArrayOfByte.toString();
              }
              ((StringBuilder)localObject2).append("netRecv ssoSeq:");
              ((StringBuilder)localObject2).append(((ToServiceMsg)localObject1).getRequestSsoSeq());
              ((StringBuilder)localObject2).append(" uin:");
              ((StringBuilder)localObject2).append(((ToServiceMsg)localObject1).getUin());
              ((StringBuilder)localObject2).append(" cmd:");
              ((StringBuilder)localObject2).append(((ToServiceMsg)localObject1).getServiceCmd());
              ((StringBuilder)localObject2).append(" len:");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(" costTime:");
              ((StringBuilder)localObject2).append(paramArrayOfByte);
              QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject2).toString());
            }
            else
            {
              ((StringBuilder)localObject2).append("netRecv ssoSeq:");
              ((StringBuilder)localObject2).append(((ToServiceMsg)localObject1).getRequestSsoSeq());
              ((StringBuilder)localObject2).append(" uin:");
              ((StringBuilder)localObject2).append(MsfSdkUtils.getShortUin(((ToServiceMsg)localObject1).getUin()));
              ((StringBuilder)localObject2).append(" cmd:");
              ((StringBuilder)localObject2).append(com.tencent.mobileqq.msf.core.b.a.a(paramArrayOfByte));
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append(" ");
              paramArrayOfByte.append(((ToServiceMsg)localObject1).getRequestSsoSeq() + j);
              ((StringBuilder)localObject2).append(paramArrayOfByte.toString());
              QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject2).toString());
            }
          }
        }
        else
        {
          return 1;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, exception : ", paramArrayOfByte);
      }
      return 0;
      label1129:
      long l2 = l1;
      if (l1 > 2147483647L) {
        label1142:
        l2 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ac.a
 * JD-Core Version:    0.7.0.1
 */