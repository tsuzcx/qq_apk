package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class KidModeServlet$DefaultRequestHandler
  implements KidModeServlet.RequestHandler
{
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, Bundle paramBundle, KidModeServlet.ResponseHandler paramResponseHandler)
  {
    if (paramInt1 != 0)
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(paramInt1);
      localOIDBSSOPkg.uint32_service_type.set(paramInt2);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      paramQQAppInterface.startServlet(KidModeServlet.a(paramQQAppInterface, paramString, localOIDBSSOPkg.toByteArray(), paramBundle, paramResponseHandler));
      return;
    }
    paramQQAppInterface.startServlet(KidModeServlet.a(paramQQAppInterface, paramString, paramArrayOfByte, paramBundle, paramResponseHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeServlet.DefaultRequestHandler
 * JD-Core Version:    0.7.0.1
 */