package com.tencent.qqprotect.common;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.ims.SafeReport.RspBody;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

final class QSecRptController$2
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new SafeReport.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if ((paramBundle.uint32_result.has()) && (QLog.isColorLevel())) {
        QLog.d("QSRPT", 2, String.format("report result: %d", new Object[] { Integer.valueOf(paramBundle.uint32_result.get()) }));
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.common.QSecRptController.2
 * JD-Core Version:    0.7.0.1
 */