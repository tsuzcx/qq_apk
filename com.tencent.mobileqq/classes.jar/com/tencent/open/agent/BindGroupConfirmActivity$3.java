package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import bcam;
import com.tencent.qphone.base.util.QLog;

class BindGroupConfirmActivity$3
  implements Runnable
{
  BindGroupConfirmActivity$3(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    for (;;)
    {
      return;
      Object localObject2 = null;
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(this.this$0.a, 2130841997);
        if (localBitmap == null) {
          continue;
        }
        localBitmap = bcam.a(this.this$0, localBitmap, 50, 50);
        if (localBitmap == null) {
          continue;
        }
        this.this$0.runOnUiThread(new BindGroupConfirmActivity.3.1(this, localBitmap));
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("BindGroupConfirmActivity", 2, "initUI decodeResource has OutOfMemoryError!");
            localObject1 = localObject2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.3
 * JD-Core Version:    0.7.0.1
 */