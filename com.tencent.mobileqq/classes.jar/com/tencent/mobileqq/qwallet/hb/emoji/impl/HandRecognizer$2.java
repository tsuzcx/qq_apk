package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class HandRecognizer$2
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      localObject2 = new YuvImage(this.jdField_a_of_type_ArrayOfByte, ((Camera.Parameters)localObject1).getPreviewFormat(), this.jdField_a_of_type_Int, this.b, null);
      localObject1 = new ByteArrayOutputStream();
      ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, this.jdField_a_of_type_Int, this.b), 80, (OutputStream)localObject1);
      localObject2 = ((ByteArrayOutputStream)localObject1).toByteArray();
      localObject2 = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length);
      if (!BitmapUtils.isLegal((Bitmap)localObject2)) {
        return;
      }
      BitmapUtils.rotateBitmap((Bitmap)localObject2, 270);
      ((ByteArrayOutputStream)localObject1).close();
      if (QLog.isColorLevel())
      {
        localObject1 = HandRecognizer.a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("【onPreviewFrameHandler】 index: ");
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append(" handType,");
        throw new NullPointerException();
      }
      QLog.isColorLevel();
      return;
    }
    catch (Throwable localThrowable)
    {
      String str = HandRecognizer.a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("【onPreviewFrameHandler】 recognize hand error ");
      ((StringBuilder)localObject2).append(QLog.getStackTraceString(localThrowable));
      QLog.e(str, 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.HandRecognizer.2
 * JD-Core Version:    0.7.0.1
 */