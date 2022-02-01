package com.tencent.mobileqq.phonecontact.util;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class PhoneContactUtils$1$1
  implements Runnable
{
  PhoneContactUtils$1$1(PhoneContactUtils.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.a != null) {
      this.this$0.a.setImageBitmap(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("IMCore.PhoneContact.PhoneContactUtils", 2, "loadIconAsync end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.util.PhoneContactUtils.1.1
 * JD-Core Version:    0.7.0.1
 */