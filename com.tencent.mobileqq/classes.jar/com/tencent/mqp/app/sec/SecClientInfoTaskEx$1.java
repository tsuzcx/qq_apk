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
    Object localObject1 = null;
    for (;;)
    {
      QQAppInterface localQQAppInterface;
      String str;
      ClientInfoB.ReportDetectResultPacket localReportDetectResultPacket;
      Object localObject3;
      try
      {
        localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localQQAppInterface == null) {
          return;
        }
        str = "" + SecClientInfoTaskEx.a(this.this$0);
        localReportDetectResultPacket = new ClientInfoB.ReportDetectResultPacket();
        localObject3 = new ClientInfoB.EnvParamPacket();
        ((ClientInfoB.EnvParamPacket)localObject3).u32_platform.set(1);
        ((ClientInfoB.EnvParamPacket)localObject3).str_sysversion.set(Build.VERSION.RELEASE);
        ((ClientInfoB.EnvParamPacket)localObject3).str_qqversion.set("8.3.0.4480");
        ((ClientInfoB.EnvParamPacket)localObject3).u32_appid.set(AppSetting.a());
        ((ClientInfoB.EnvParamPacket)localObject3).bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
        ((ClientInfoB.EnvParamPacket)localObject3).str_uin.set(str);
        localReportDetectResultPacket.uint32_cmd.set(1);
        localReportDetectResultPacket.envParam.set((MessageMicro)localObject3);
        if (SecClientInfoTaskEx.a(this.this$0) == 1)
        {
          localObject1 = SecClientInfoTaskEx.a(SecClientInfoTaskEx.b(this.this$0));
          if (localObject1 != null) {
            localReportDetectResultPacket.bytes_buffer.set(ByteStringMicro.copyFrom((byte[])localObject1));
          }
          localObject1 = new ToServiceMsg("mobileqq.service", str, "ClientInfoB.SecReport");
          if (localObject1 == null) {
            break;
          }
          ((ToServiceMsg)localObject1).putWupBuffer(localReportDetectResultPacket.toByteArray());
          ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
          ((ToServiceMsg)localObject1).setNeedCallback(false);
          localQQAppInterface.sendToService((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      if (SecClientInfoTaskEx.a(this.this$0) == 2)
      {
        if (!SecClientInfoTaskEx.a())
        {
          localObject2 = localQQAppInterface.getApplication().getFilesDir().getParent() + "/lib/libhobi.so";
          localObject3 = new File((String)localObject2);
          if ((localObject3 != null) && (((File)localObject3).exists())) {
            SecClientInfoTaskEx.a(SecUtil.getFileMd5((String)localObject2));
          }
          SecClientInfoTaskEx.a(true);
        }
        if ((SecClientInfoTaskEx.a() != null) && (SecClientInfoTaskEx.a().length() > 0)) {
          localReportDetectResultPacket.str_safemd5.set(SecClientInfoTaskEx.a());
        }
        Object localObject2 = str + SecClientInfoTaskEx.b(this.this$0);
        localObject3 = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject3).update(((String)localObject2).getBytes());
        localReportDetectResultPacket.bytes_buffer.set(ByteStringMicro.copyFrom(((MessageDigest)localObject3).digest()));
        localObject2 = SecClientInfoTaskEx.a(SecClientInfoTaskEx.b(this.this$0) >> 1 & 0x7FFFFFFF);
        if (localObject2 != null) {
          localReportDetectResultPacket.bytes_buffer2.set(ByteStringMicro.copyFrom((byte[])localObject2));
        }
        localObject2 = new ToServiceMsg("mobileqq.service", str, "ClientInfoD.SecReport");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mqp.app.sec.SecClientInfoTaskEx.1
 * JD-Core Version:    0.7.0.1
 */