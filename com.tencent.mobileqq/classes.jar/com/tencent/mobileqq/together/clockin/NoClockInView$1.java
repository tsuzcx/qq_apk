package com.tencent.mobileqq.together.clockin;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.StackBlur;
import mqq.os.MqqHandler;

class NoClockInView$1
  implements Runnable
{
  NoClockInView$1(NoClockInView paramNoClockInView, Drawable paramDrawable) {}
  
  public void run()
  {
    Bitmap localBitmap = ImageUtil.a(this.a);
    Drawable localDrawable;
    if (localBitmap != null) {
      try
      {
        StackBlur.a(localBitmap, 5);
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(localBitmap);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        localBitmap.recycle();
        localDrawable = this.a;
      }
    } else {
      localDrawable = null;
    }
    ThreadManager.getUIHandler().post(new NoClockInView.1.1(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.NoClockInView.1
 * JD-Core Version:    0.7.0.1
 */