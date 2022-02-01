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
    Log.i("MiniAppCamera", "run: onPictureTaken");
    for (;;)
    {
      float f4;
      float f5;
      try
      {
        long l1 = Runtime.getRuntime().totalMemory() / 1024L;
        long l2 = Runtime.getRuntime().maxMemory() / 1024L;
        long l3 = Runtime.getRuntime().freeMemory() / 1024L;
        long l4 = l2 - (l1 - l3);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("remain= ");
        ((StringBuilder)localObject1).append(l4);
        ((StringBuilder)localObject1).append(",totalMemory=");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append(",maxMemory=");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(",freeMemory");
        ((StringBuilder)localObject1).append(l3);
        QMLog.d("MiniAppCamera", ((StringBuilder)localObject1).toString());
        if (l4 < 51200L) {
          System.gc();
        }
        localObject1 = BitmapFactory.decodeByteArray(this.val$data, 0, this.val$data.length);
        int i = ((Bitmap)localObject1).getWidth();
        int j = ((Bitmap)localObject1).getHeight();
        localObject2 = new Matrix();
        f6 = MiniAppCamera.access$100(this.this$0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("run: ");
        localStringBuilder.append(this.this$0.getWidth());
        localStringBuilder.append(":");
        localStringBuilder.append(this.this$0.getHeight());
        Log.i("MiniAppCamera", localStringBuilder.toString());
        boolean bool = this.val$adapt;
        f2 = 0.0F;
        f3 = 0.0F;
        if (!bool) {
          break label605;
        }
        f3 = this.this$0.getHeight();
        f1 = i;
        f3 /= f1;
        f4 = this.this$0.getWidth();
        f5 = j;
        f4 = Math.max(f3, f4 / f5);
        f3 = (this.this$0.getHeight() - f1 * f4) / f4;
        f5 = (this.this$0.getWidth() - f5 * f4) / f4;
        f1 = f3;
        if (f3 <= 0.0F) {
          break label582;
        }
        f1 = 0.0F;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2;
        float f6;
        Log.e("MiniAppCamera", "run: nativeTakePhoto ", localException);
        this.val$callback.onGetPhoto(null);
        return;
      }
      ((Matrix)localObject2).postRotate(f6);
      ((Matrix)localObject2).postScale(f2, f2);
      if (!this.this$0.isBackCameraNow) {
        ((Matrix)localObject2).postScale(-1.0F, 1.0F);
      }
      localObject2 = Bitmap.createBitmap((Bitmap)localObject1, (int)(-f3 / 2.0F), (int)(-f1 / 2.0F), (int)(((Bitmap)localObject1).getWidth() + f3), (int)(((Bitmap)localObject1).getHeight() + f1), (Matrix)localObject2, true);
      float f1 = MiniAppCamera.access$200(this.this$0, this.val$quality);
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
      label582:
      if (f5 <= 0.0F) {
        f2 = f5;
      }
      float f3 = f1;
      f1 = f2;
      float f2 = f4;
      continue;
      label605:
      f1 = 0.0F;
      f2 = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.3
 * JD-Core Version:    0.7.0.1
 */