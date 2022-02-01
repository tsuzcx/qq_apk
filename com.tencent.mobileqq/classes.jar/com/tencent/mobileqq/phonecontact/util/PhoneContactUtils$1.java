package com.tencent.mobileqq.phonecontact.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

final class PhoneContactUtils$1
  implements Runnable
{
  PhoneContactUtils$1(Resources paramResources, AppInterface paramAppInterface, ImageView paramImageView) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.a, 2130846450);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.i("IMCore.PhoneContact.PhoneContactUtils", 1, "Throwable", localThrowable);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      QLog.i("IMCore.PhoneContact.PhoneContactUtils", 1, "OutOfMemoryError", localOutOfMemoryError);
    }
    Object localObject = null;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadIconAsync bmp: ");
      localStringBuilder.append(localObject);
      QLog.i("IMCore.PhoneContact.PhoneContactUtils", 2, localStringBuilder.toString());
    }
    this.b.runOnUiThread(new PhoneContactUtils.1.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.PhoneContactUtils.1
 * JD-Core Version:    0.7.0.1
 */