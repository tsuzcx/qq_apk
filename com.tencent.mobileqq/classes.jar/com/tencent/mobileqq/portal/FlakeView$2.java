package com.tencent.mobileqq.portal;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Random;

class FlakeView$2
  implements Runnable
{
  FlakeView$2(FlakeView paramFlakeView, int paramInt, Bitmap[] paramArrayOfBitmap) {}
  
  public void run()
  {
    Random localRandom = new Random();
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      int j = localRandom.nextInt(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length);
      Object localObject = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j];
      if (localObject != null)
      {
        localObject = Flake.a(this.this$0.getWidth(), (Bitmap)localObject, 3, this.this$0.getResources());
        ((Flake)localObject).a = (this.this$0.getWidth() / 2);
        ((Flake)localObject).b = AIOUtils.b(205.0F, this.this$0.getResources());
        this.this$0.a.add(localObject);
        localObject = this.this$0;
        ((FlakeView)localObject).e += 1;
      }
      i += 1;
    }
    this.this$0.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FlakeView.2
 * JD-Core Version:    0.7.0.1
 */