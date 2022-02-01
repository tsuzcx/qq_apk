package com.tencent.mqp.app.sec;

import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.ClientInfoA.EnvParamPacket;
import com.tencent.ims.ClientInfoA.ReportDetectResultPacket;
import com.tencent.mdm.m;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.security.MessageDigest;
import mqq.app.MobileQQ;

class SecClientInfoTask$1
  implements Runnable
{
  SecClientInfoTask$1(SecClientInfoTask paramSecClientInfoTask) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = MobileQQ.sMobileQQ;
      Object localObject1 = null;
      localObject2 = (QQAppInterface)((MobileQQ)localObject2).waitAppRuntime(null);
      if (localObject2 == null) {
        return;
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(SecClientInfoTask.a(this.this$0));
      String str = ((StringBuilder)localObject3).toString();
      localObject3 = new ClientInfoA.ReportDetectResultPacket();
      Object localObject4 = new ClientInfoA.EnvParamPacket();
      ((ClientInfoA.EnvParamPacket)localObject4).u32_platform.set(1);
      ((ClientInfoA.EnvParamPacket)localObject4).str_sysversion.set(Build.VERSION.RELEASE);
      ((ClientInfoA.EnvParamPacket)localObject4).str_qqversion.set("8.7.0.5295");
      ((ClientInfoA.EnvParamPacket)localObject4).u32_appid.set(AppSetting.a());
      ((ClientInfoA.EnvParamPacket)localObject4).bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
      ((ClientInfoA.EnvParamPacket)localObject4).str_uin.set(str);
      ((ClientInfoA.ReportDetectResultPacket)localObject3).uint32_cmd.set(1);
      ((ClientInfoA.ReportDetectResultPacket)localObject3).envParam.set((MessageMicro)localObject4);
      int i = SecClientInfoTask.a(this.this$0);
      if (i == 1)
      {
        localObject1 = SecClientInfoTask.a(SecClientInfoTask.b(this.this$0));
        if (localObject1 != null) {
          ((ClientInfoA.ReportDetectResultPacket)localObject3).bytes_buffer.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        localObject1 = new ToServiceMsg("mobileqq.service", str, "ClientInfoA.SecReport");
      }
      else if (SecClientInfoTask.a(this.this$0) == 2)
      {
        if (!SecClientInfoTask.a())
        {
          SecClientInfoTask.a(m.a(((QQAppInterface)localObject2).getApplication().getApplicationInfo().sourceDir));
          SecClientInfoTask.a(true);
        }
        if ((SecClientInfoTask.a() != null) && (SecClientInfoTask.a().length() > 0)) {
          ((ClientInfoA.ReportDetectResultPacket)localObject3).str_qqmd5.set(SecClientInfoTask.a());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(SecUtil.toHexString(NetConnInfoCenter.GUID).toLowerCase());
        ((StringBuilder)localObject1).append(SecClientInfoTask.b(this.this$0));
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject4 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject4).update(((String)localObject1).getBytes());
        ((ClientInfoA.ReportDetectResultPacket)localObject3).bytes_buffer.set(ByteStringMicro.copyFrom(((MessageDigest)localObject4).digest()));
        localObject1 = SecClientInfoTask.a(SecClientInfoTask.b(this.this$0) >> 1 & 0x7FFFFFFF);
        if (localObject1 != null) {
          ((ClientInfoA.ReportDetectResultPacket)localObject3).bytes_buffer2.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        localObject1 = new ToServiceMsg("mobileqq.service", str, "ClientInfoC.SecReport");
      }
      if (localObject1 != null)
      {
        ((ToServiceMsg)localObject1).putWupBuffer(((ClientInfoA.ReportDetectResultPacket)localObject3).toByteArray());
        ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
        ((ToServiceMsg)localObject1).setNeedCallback(false);
        ((QQAppInterface)localObject2).sendToService((ToServiceMsg)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.SecClientInfoTask.1
 * JD-Core Version:    0.7.0.1
 */