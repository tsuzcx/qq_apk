package com.tencent.mobileqq.portal;

import android.graphics.BitmapFactory;

class FlakeView$3
  implements Runnable
{
  FlakeView$3(FlakeView paramFlakeView, String paramString) {}
  
  public void run()
  {
    try
    {
      this.this$0.a = BitmapFactory.decodeFile(this.a);
      this.this$0.r = true;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FlakeView.3
 * JD-Core Version:    0.7.0.1
 */