package com.tencent.mobileqq.magicface.drawable;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import atxv;
import atxw;
import com.tencent.qphone.base.util.QLog;

public class PngGifEngine$1
  implements Runnable
{
  public PngGifEngine$1(atxv paramatxv) {}
  
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
    Object localObject2 = atxv.a((String)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("PngGifEngine", 2, "func run, bitmap:" + localObject2);
    }
    localObject1 = this.this$0;
    if (localObject2 != null) {}
    for (;;)
    {
      long l1;
      try
      {
        if ((!((Bitmap)localObject2).isRecycled()) && (this.this$0.jdField_a_of_type_AndroidOsHandler != null))
        {
          l1 = SystemClock.uptimeMillis();
          l2 += this.this$0.jdField_a_of_type_Atxw.b;
          localObject2 = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localObject2);
          if (l1 > l2) {
            this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, l2 - l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngGifEngine.1
 * JD-Core Version:    0.7.0.1
 */