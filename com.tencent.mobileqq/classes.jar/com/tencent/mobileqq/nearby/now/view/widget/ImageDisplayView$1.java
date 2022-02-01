package com.tencent.mobileqq.nearby.now.view.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class ImageDisplayView$1
  implements Runnable
{
  ImageDisplayView$1(ImageDisplayView paramImageDisplayView, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(this.a);
        localObject1 = localBitmap;
        int i = new ExifInterface(this.a).getAttributeInt("Orientation", 0);
        localObject1 = localBitmap;
        Object localObject2 = new Matrix();
        switch (i)
        {
        case 8: 
          localObject1 = localBitmap;
          localObject2 = ThreadManager.getUIHandler();
          continue;
          localObject1 = localBitmap;
          ((Matrix)localObject2).postRotate(270.0F);
          break;
        case 7: 
          localObject1 = localBitmap;
          ((Matrix)localObject2).postRotate(270.0F);
          localObject1 = localBitmap;
          ((Matrix)localObject2).postScale(-1.0F, 1.0F);
          break;
        case 6: 
          localObject1 = localBitmap;
          ((Matrix)localObject2).postRotate(90.0F);
          break;
        case 5: 
          localObject1 = localBitmap;
          ((Matrix)localObject2).postRotate(90.0F);
          localObject1 = localBitmap;
          ((Matrix)localObject2).postScale(-1.0F, 1.0F);
          break;
        case 4: 
          localObject1 = localBitmap;
          ((Matrix)localObject2).postRotate(180.0F);
          localObject1 = localBitmap;
          ((Matrix)localObject2).postScale(-1.0F, 1.0F);
          break;
        case 3: 
          localObject1 = localBitmap;
          ((Matrix)localObject2).postRotate(180.0F);
          break;
        case 2: 
          localObject1 = localBitmap;
          ((Matrix)localObject2).postScale(-1.0F, 1.0F);
          localObject1 = localBitmap;
          localObject2 = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject2, true);
          localObject1 = localBitmap;
          ThreadManager.getUIHandler().post(new ImageDisplayView.1.2(this, (Bitmap)localObject2));
          return;
          localObject1 = localBitmap;
          ((MqqHandler)localObject2).post(new ImageDisplayView.1.1(this, localBitmap));
          return;
        }
      }
      catch (Exception localException)
      {
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        return;
      }
      if (localObject1 == null) {
        return;
      }
      ThreadManager.getUIHandler().post(new ImageDisplayView.1.3(this, localObject1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView.1
 * JD-Core Version:    0.7.0.1
 */