package com.tencent.qqmini.miniapp.widget.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

class MiniAppCamera$3
  implements Runnable
{
  MiniAppCamera$3(MiniAppCamera paramMiniAppCamera, byte[] paramArrayOfByte, boolean paramBoolean, String paramString, MiniAppCamera.GetPhotoCallback paramGetPhotoCallback) {}
  
  public void run()
  {
    float f2 = 0.0F;
    Log.i("MiniAppCamera", "run: onPictureTaken");
    long l4;
    try
    {
      long l1 = Runtime.getRuntime().totalMemory() / 1024L;
      long l2 = Runtime.getRuntime().maxMemory() / 1024L;
      long l3 = Runtime.getRuntime().freeMemory() / 1024L;
      l4 = l2 - (l1 - l3);
      QMLog.d("MiniAppCamera", "remain= " + l4 + ",totalMemory=" + l1 + ",maxMemory=" + l2 + ",freeMemory" + l3);
      if (l4 >= 51200L) {
        break label543;
      }
      System.gc();
    }
    catch (Exception localException)
    {
      Object localObject1;
      int i;
      int j;
      Object localObject2;
      float f6;
      float f1;
      Log.e("MiniAppCamera", "run: nativeTakePhoto ", localException);
      this.val$callback.onGetPhoto(null);
      return;
    }
    localObject1 = BitmapFactory.decodeByteArray(this.val$data, 0, this.val$data.length);
    i = ((Bitmap)localObject1).getWidth();
    j = ((Bitmap)localObject1).getHeight();
    localObject2 = new Matrix();
    f6 = MiniAppCamera.access$100(this.this$0);
    Log.i("MiniAppCamera", "run: " + this.this$0.getWidth() + ":" + this.this$0.getHeight());
    float f4;
    float f3;
    float f5;
    if (this.val$adapt)
    {
      f4 = Math.max(this.this$0.getHeight() / i, this.this$0.getWidth() / j);
      f3 = i;
      f1 = j;
      f3 = (this.this$0.getHeight() - f3 * f4) / f4;
      f5 = (this.this$0.getWidth() - f1 * f4) / f4;
      f1 = f3;
      if (f3 <= 0.0F) {
        break label555;
      }
      f1 = 0.0F;
    }
    for (;;)
    {
      ((Matrix)localObject2).postRotate(f6);
      ((Matrix)localObject2).postScale(f2, f2);
      if (!this.this$0.isBackCameraNow) {
        ((Matrix)localObject2).postScale(-1.0F, 1.0F);
      }
      localObject2 = Bitmap.createBitmap((Bitmap)localObject1, (int)(-f1 / 2.0F), (int)(-f3 / 2.0F), (int)(f1 + ((Bitmap)localObject1).getWidth()), (int)(f3 + ((Bitmap)localObject1).getHeight()), (Matrix)localObject2, true);
      f1 = MiniAppCamera.access$200(this.this$0, this.val$quality);
      localObject1 = localObject2;
      if (f1 < 1.0F)
      {
        localObject1 = new Matrix();
        ((Matrix)localObject1).postScale(f1, f1);
        localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, true);
      }
      localObject2 = new File(this.this$0.getTmpPath("jpg"));
      ((File)localObject2).getParentFile().mkdirs();
      localObject1 = MiniAppCamera.access$300((Bitmap)localObject1, (File)localObject2, this.val$quality);
      Log.i("MiniAppCamera", "run: return");
      this.val$callback.onGetPhoto((String)localObject1);
      return;
      f3 = 0.0F;
      f1 = 0.0F;
      f2 = 1.0F;
      continue;
      label543:
      label555:
      do
      {
        f2 = f5;
        break label562;
        if (l4 >= 81920L) {
          break;
        }
        break;
      } while (f5 <= 0.0F);
      label562:
      f3 = f2;
      f2 = f4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.3
 * JD-Core Version:    0.7.0.1
 */