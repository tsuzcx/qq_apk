package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Random;

class FlakeView$1
  implements Runnable
{
  FlakeView$1(FlakeView paramFlakeView, String[] paramArrayOfString, int paramInt) {}
  
  public void run()
  {
    Random localRandom = new Random();
    Bitmap[] arrayOfBitmap = new Bitmap[this.a.length];
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = this.a;
      if (i >= arrayOfString.length) {
        break;
      }
      try
      {
        arrayOfBitmap[i] = BitmapFactory.decodeFile(arrayOfString[i]);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
      i += 1;
    }
    i = 0;
    while (i < this.b)
    {
      Object localObject = arrayOfBitmap[localRandom.nextInt(this.a.length)];
      if (localObject != null)
      {
        localObject = Flake.a(this.this$0.getWidth(), (Bitmap)localObject, 3, this.this$0.getResources());
        ((Flake)localObject).a = (this.this$0.getWidth() / 2);
        ((Flake)localObject).b = AIOUtils.b(205.0F, this.this$0.getResources());
        this.this$0.j.add(localObject);
        localObject = this.this$0;
        ((FlakeView)localObject).h += 1;
      }
      i += 1;
    }
    this.this$0.q = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FlakeView.1
 * JD-Core Version:    0.7.0.1
 */