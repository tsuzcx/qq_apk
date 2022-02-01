package cooperation.qzone.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.utils.ImageUtil;
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
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("frame: ");
        ((StringBuilder)localObject1).append(this.val$frame);
        ((StringBuilder)localObject1).append(", startAntishake at ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis());
        QLog.d("QzoneVision", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = Bitmap.createBitmap(this.val$width, this.val$height, Bitmap.Config.RGB_565);
      Bitmap localBitmap = (Bitmap)this.val$beforeBitmap.get(this.val$frame);
      if ((this.val$flagBitmap != null) && (localBitmap != null) && (localObject1 != null))
      {
        QzoneVision.getAntiShakeBitmap(this.val$flagBitmap, localBitmap, (Bitmap)localObject1);
        localBitmap = Bitmap.createBitmap((Bitmap)localObject1, this.val$widshrink, this.val$heishrink, ((Bitmap)localObject1).getWidth() - this.val$widshrink * 2, ((Bitmap)localObject1).getHeight() - this.val$heishrink * 2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("frame: ");
          ((StringBuilder)localObject2).append(this.val$frame);
          ((StringBuilder)localObject2).append(", endAntishake and startSave at ");
          ((StringBuilder)localObject2).append(System.currentTimeMillis());
          QLog.d("QzoneVision", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = GifAntishakeModule.access$000(this.this$0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(".IMG");
        localStringBuilder.append(this.val$frame);
        localObject2 = PhotoUtils.getCameraPath((String)localObject2, localStringBuilder.toString(), ".jpg");
        ImageUtil.a(localBitmap, new File((String)localObject2));
        if (!((Bitmap)localObject1).isRecycled()) {
          ((Bitmap)localObject1).recycle();
        }
        if (!localBitmap.isRecycled()) {
          localBitmap.recycle();
        }
        this.val$outputPath[this.val$frame] = localObject2;
        GifAntishakeModule.access$108();
        GifAntishakeModule.access$200(this.this$0, GifAntishakeModule.access$100());
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("frame: ");
          ((StringBuilder)localObject1).append(this.val$frame);
          ((StringBuilder)localObject1).append(", endSave at ");
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          QLog.d("QzoneVision", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.util.GifAntishakeModule.1
 * JD-Core Version:    0.7.0.1
 */