package com.tencent.mobileqq.magicface.drawable;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class PngGifEngine$1
  implements Runnable
{
  PngGifEngine$1(PngGifEngine paramPngGifEngine) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngGifEngine", 2, "func run begins.");
    }
    Object localObject1 = this.this$0.a();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    long l2 = SystemClock.uptimeMillis();
    Object localObject2 = PngGifEngine.a((String)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("func run, bitmap:");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.d("PngGifEngine", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.this$0;
    if (localObject2 != null) {}
    try
    {
      if ((!((Bitmap)localObject2).isRecycled()) && (this.this$0.jdField_a_of_type_AndroidOsHandler != null))
      {
        long l1 = SystemClock.uptimeMillis();
        l2 += this.this$0.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngGifEngine$PngGifTaskParam.b;
        localObject2 = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localObject2);
        if (l1 > l2) {
          this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        } else {
          this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, l2 - l1);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngGifEngine.1
 * JD-Core Version:    0.7.0.1
 */