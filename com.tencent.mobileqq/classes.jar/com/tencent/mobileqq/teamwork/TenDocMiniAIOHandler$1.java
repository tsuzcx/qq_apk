package com.tencent.mobileqq.teamwork;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.armap.FaceObserver;
import com.tencent.qphone.base.util.QLog;

class TenDocMiniAIOHandler$1
  implements FaceObserver
{
  TenDocMiniAIOHandler$1(TenDocMiniAIOHandler paramTenDocMiniAIOHandler, ImageView paramImageView) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFaceUpdate uin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" -- ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" head:");
      localStringBuilder.append(paramBitmap);
      QLog.i("SwiftMiniAIOHandler", 4, localStringBuilder.toString());
    }
    if (paramBitmap != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocMiniAIOHandler.1
 * JD-Core Version:    0.7.0.1
 */