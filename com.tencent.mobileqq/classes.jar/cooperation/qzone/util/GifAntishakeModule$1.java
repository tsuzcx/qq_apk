package cooperation.qzone.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import bheg;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.pfc.opencv.QzoneVision;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class GifAntishakeModule$1
  implements Runnable
{
  GifAntishakeModule$1(GifAntishakeModule paramGifAntishakeModule, int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList, Bitmap paramBitmap, int paramInt4, int paramInt5, String[] paramArrayOfString, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "frame: " + this.val$frame + ", startAntishake at " + System.currentTimeMillis());
      }
      Bitmap localBitmap1 = Bitmap.createBitmap(this.val$width, this.val$height, Bitmap.Config.RGB_565);
      Bitmap localBitmap2 = (Bitmap)this.val$beforeBitmap.get(this.val$frame);
      if ((this.val$flagBitmap != null) && (localBitmap2 != null) && (localBitmap1 != null))
      {
        QzoneVision.getAntiShakeBitmap(this.val$flagBitmap, localBitmap2, localBitmap1);
        localBitmap2 = Bitmap.createBitmap(localBitmap1, this.val$widshrink, this.val$heishrink, localBitmap1.getWidth() - this.val$widshrink * 2, localBitmap1.getHeight() - this.val$heishrink * 2);
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "frame: " + this.val$frame + ", endAntishake and startSave at " + System.currentTimeMillis());
        }
        String str = PhotoUtils.getCameraPath(GifAntishakeModule.access$000(this.this$0), ".IMG" + this.val$frame, ".jpg");
        bheg.a(localBitmap2, new File(str));
        if (!localBitmap1.isRecycled()) {
          localBitmap1.recycle();
        }
        if (!localBitmap2.isRecycled()) {
          localBitmap2.recycle();
        }
        this.val$outputPath[this.val$frame] = str;
        GifAntishakeModule.access$108();
        GifAntishakeModule.access$200(this.this$0, GifAntishakeModule.access$100());
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVision", 2, "frame: " + this.val$frame + ", endSave at " + System.currentTimeMillis());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.GifAntishakeModule.1
 * JD-Core Version:    0.7.0.1
 */