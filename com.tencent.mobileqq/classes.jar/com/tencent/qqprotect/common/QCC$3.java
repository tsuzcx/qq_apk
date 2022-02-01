package com.tencent.qqprotect.common;

import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.ims.XpsReport.XpsClientDataReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.app.MobileQQ;

final class QCC$3
  implements Runnable
{
  QCC$3(int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localAppInterface != null)
      {
        XpsReport.XpsClientDataReq localXpsClientDataReq = new XpsReport.XpsClientDataReq();
        localXpsClientDataReq.scene_id.set(this.a);
        localXpsClientDataReq.ccdata.set(ByteStringMicro.copyFrom(this.b));
        ProtoUtils.a(localAppInterface, localXpsClientDataReq.toByteArray(), "trpc.qqxps.gateway.SSOProxy.Forward");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.common.QCC.3
 * JD-Core Version:    0.7.0.1
 */