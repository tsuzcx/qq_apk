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
    Bitmap[] arrayOfBitmap = new Bitmap[this.jdField_a_of_type_ArrayOfJavaLangString.length];
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        try
        {
          arrayOfBitmap[i] = BitmapFactory.decodeFile(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
          i += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            localOutOfMemoryError.printStackTrace();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      Object localObject = arrayOfBitmap[localRandom.nextInt(this.jdField_a_of_type_ArrayOfJavaLangString.length)];
      if (localObject != null)
      {
        localObject = Flake.a(this.this$0.getWidth(), (Bitmap)localObject, 3, this.this$0.getResources());
        ((Flake)localObject).a = (this.this$0.getWidth() / 2);
        ((Flake)localObject).b = AIOUtils.a(205.0F, this.this$0.getResources());
        this.this$0.a.add(localObject);
        localObject = this.this$0;
        ((FlakeView)localObject).e += 1;
      }
      i += 1;
    }
    this.this$0.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FlakeView.1
 * JD-Core Version:    0.7.0.1
 */