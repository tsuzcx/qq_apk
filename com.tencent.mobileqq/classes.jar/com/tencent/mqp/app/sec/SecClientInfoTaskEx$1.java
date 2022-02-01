package com.tencent.mqp.app.sec;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.ClientInfoB.EnvParamPacket;
import com.tencent.ims.ClientInfoB.ReportDetectResultPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.io.File;
import java.security.MessageDigest;
import mqq.app.MobileQQ;

class SecClientInfoTaskEx$1
  implements Runnable
{
  SecClientInfoTaskEx$1(SecClientInfoTaskEx paramSecClientInfoTaskEx) {}
  
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
      ((StringBuilder)localObject3).append(SecClientInfoTaskEx.a(this.this$0));
      String str = ((StringBuilder)localObject3).toString();
      localObject3 = new ClientInfoB.ReportDetectResultPacket();
      Object localObject4 = new ClientInfoB.EnvParamPacket();
      ((ClientInfoB.EnvParamPacket)localObject4).u32_platform.set(1);
      ((ClientInfoB.EnvParamPacket)localObject4).str_sysversion.set(Build.VERSION.RELEASE);
      ((ClientInfoB.EnvParamPacket)localObject4).str_qqversion.set("8.7.0.5295");
      ((ClientInfoB.EnvParamPacket)localObject4).u32_appid.set(AppSetting.a());
      ((ClientInfoB.EnvParamPacket)localObject4).bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
      ((ClientInfoB.EnvParamPacket)localObject4).str_uin.set(str);
      ((ClientInfoB.ReportDetectResultPacket)localObject3).uint32_cmd.set(1);
      ((ClientInfoB.ReportDetectResultPacket)localObject3).envParam.set((MessageMicro)localObject4);
      int i = SecClientInfoTaskEx.a(this.this$0);
      if (i == 1)
      {
        localObject1 = SecClientInfoTaskEx.a(SecClientInfoTaskEx.b(this.this$0));
        if (localObject1 != null) {
          ((ClientInfoB.ReportDetectResultPacket)localObject3).bytes_buffer.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        localObject1 = new ToServiceMsg("mobileqq.service", str, "ClientInfoB.SecReport");
      }
      else if (SecClientInfoTaskEx.a(this.this$0) == 2)
      {
        if (!SecClientInfoTaskEx.a())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((QQAppInterface)localObject2).getApplication().getFilesDir().getParent());
          ((StringBuilder)localObject1).append("/lib/libhobi.so");
          localObject1 = ((StringBuilder)localObject1).toString();
          if (new File((String)localObject1).exists()) {
            SecClientInfoTaskEx.a(SecUtil.getFileMd5((String)localObject1));
          }
          SecClientInfoTaskEx.a(true);
        }
        if ((SecClientInfoTaskEx.a() != null) && (SecClientInfoTaskEx.a().length() > 0)) {
          ((ClientInfoB.ReportDetectResultPacket)localObject3).str_safemd5.set(SecClientInfoTaskEx.a());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(SecClientInfoTaskEx.b(this.this$0));
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject4 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject4).update(((String)localObject1).getBytes());
        ((ClientInfoB.ReportDetectResultPacket)localObject3).bytes_buffer.set(ByteStringMicro.copyFrom(((MessageDigest)localObject4).digest()));
        localObject1 = SecClientInfoTaskEx.a(SecClientInfoTaskEx.b(this.this$0) >> 1 & 0x7FFFFFFF);
        if (localObject1 != null) {
          ((ClientInfoB.ReportDetectResultPacket)localObject3).bytes_buffer2.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        localObject1 = new ToServiceMsg("mobileqq.service", str, "ClientInfoD.SecReport");
      }
      if (localObject1 != null)
      {
        ((ToServiceMsg)localObject1).putWupBuffer(((ClientInfoB.ReportDetectResultPacket)localObject3).toByteArray());
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
 * Qualified Name:     com.tencent.mqp.app.sec.SecClientInfoTaskEx.1
 * JD-Core Version:    0.7.0.1
 */