package com.tencent.mobileqq.mini.widget.media;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import bcif;
import bggl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class MiniAppCamera$2$1
  implements Runnable
{
  MiniAppCamera$2$1(MiniAppCamera.2 param2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Log.i("MiniAppCamera", "run: onPictureTaken");
    long l4;
    try
    {
      long l1 = Runtime.getRuntime().totalMemory() / 1024L;
      long l2 = Runtime.getRuntime().maxMemory() / 1024L;
      long l3 = Runtime.getRuntime().freeMemory() / 1024L;
      l4 = l2 - (l1 - l3);
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppCamera", 2, "remain= " + l4 + ",totalMemory=" + l1 + ",maxMemory=" + l2 + ",freeMemory" + l3);
      }
      if (l4 >= 51200L) {
        break label640;
      }
      URLDrawable.clearMemoryCache();
      System.gc();
    }
    catch (Exception localException)
    {
      Object localObject2;
      int i;
      int j;
      Object localObject3;
      Log.e("MiniAppCamera", "run: nativeTakePhoto ", localException);
      this.this$1.val$callback.onGetPhoto(null);
      return;
    }
    localObject2 = bggl.a(this.val$data, 0, this.val$data.length);
    i = ((Bitmap)localObject2).getWidth();
    j = ((Bitmap)localObject2).getHeight();
    localObject3 = new Matrix();
    float f1;
    float f4;
    float f2;
    float f5;
    if (bcif.d(bcif.g))
    {
      if (!this.this$1.this$0.isBackCameraNow) {
        break label682;
      }
      f1 = 270.0F;
      break label652;
      Log.i("MiniAppCamera", "run: " + this.this$1.this$0.getWidth() + ":" + this.this$1.this$0.getHeight());
      if (!this.this$1.val$adapt) {
        break label699;
      }
      f4 = Math.max(this.this$1.this$0.getHeight() / i, this.this$1.this$0.getWidth() / j);
      f2 = i;
      f1 = j;
      f2 = (this.this$1.this$0.getHeight() - f2 * f4) / f4;
      f5 = (this.this$1.this$0.getWidth() - f1 * f4) / f4;
      f1 = f2;
      if (f2 <= 0.0F) {
        break label657;
      }
      f1 = 0.0F;
      break label657;
    }
    for (;;)
    {
      label359:
      Object localObject1;
      ((Matrix)localObject3).postRotate(localObject1);
      ((Matrix)localObject3).postScale(f1, f1);
      if (!this.this$1.this$0.isBackCameraNow) {
        ((Matrix)localObject3).postScale(-1.0F, 1.0F);
      }
      localObject3 = Bitmap.createBitmap((Bitmap)localObject2, (int)(-f4 / 2.0F), (int)(-f2 / 2.0F), (int)(f4 + ((Bitmap)localObject2).getWidth()), (int)(f2 + ((Bitmap)localObject2).getHeight()), (Matrix)localObject3, true);
      f1 = 1.0F;
      if ("normal".equals(this.this$1.val$quality)) {
        f1 = 0.8F;
      }
      for (;;)
      {
        localObject2 = localObject3;
        if (f1 < 1.0F)
        {
          localObject2 = new Matrix();
          ((Matrix)localObject2).postScale(f1, f1);
          localObject2 = Bitmap.createBitmap((Bitmap)localObject3, 0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), (Matrix)localObject2, true);
        }
        localObject3 = new File(MiniAppFileManager.getInstance().getTmpPath("jpg"));
        ((File)localObject3).getParentFile().mkdirs();
        localObject2 = MiniAppCamera.access$000((Bitmap)localObject2, (File)localObject3, this.this$1.val$quality);
        Log.i("MiniAppCamera", "run: return");
        this.this$1.val$callback.onGetPhoto((String)localObject2);
        return;
        if (!this.this$1.this$0.isBackCameraNow) {
          break label693;
        }
        f1 = 90.0F;
        break;
        boolean bool = "low".equals(this.this$1.val$quality);
        if (bool) {
          f1 = 0.6F;
        }
      }
      label640:
      if (l4 >= 81920L) {
        break;
      }
      break;
      label652:
      float f3;
      for (;;)
      {
        f3 = f1;
        break;
        label657:
        f2 = f5;
        if (f5 > 0.0F) {
          f2 = 0.0F;
        }
        f5 = f1;
        f1 = f4;
        f4 = f5;
        break label359;
        label682:
        f1 = 90.0F;
      }
      for (;;)
      {
        f3 = f1;
        break;
        label693:
        f1 = 270.0F;
      }
      label699:
      f2 = 0.0F;
      f1 = 1.0F;
      f4 = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppCamera.2.1
 * JD-Core Version:    0.7.0.1
 */