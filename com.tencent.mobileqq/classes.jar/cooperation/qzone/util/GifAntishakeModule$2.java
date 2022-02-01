package cooperation.qzone.util;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class GifAntishakeModule$2
  implements Runnable
{
  GifAntishakeModule$2(GifAntishakeModule paramGifAntishakeModule, ArrayList paramArrayList, int paramInt1, CountDownLatch paramCountDownLatch, Bitmap paramBitmap, int paramInt2, boolean[] paramArrayOfBoolean) {}
  
  public void run()
  {
    Bitmap localBitmap = (Bitmap)this.val$bitmapArrayList.get(this.val$num);
    if (localBitmap == null)
    {
      this.val$countDownLatch.countDown();
      return;
    }
    if (this.val$num != 0)
    {
      long l = System.currentTimeMillis();
      int i = GifAntishakeModule.getDistance(GifAntishakeModule.getDhash(this.val$flag), GifAntishakeModule.getDhash(localBitmap));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DHash: 第一帧与第");
        localStringBuilder.append(this.val$num + 1);
        localStringBuilder.append("帧的相似度为 dif=");
        localStringBuilder.append(i);
        localStringBuilder.append(" now:");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.d("QzoneVision", 2, localStringBuilder.toString());
      }
      if ((localBitmap.getWidth() == this.val$flag.getWidth()) && (localBitmap.getHeight() == this.val$flag.getHeight()) && (GifAntishakeModule.access$300(this.this$0, this.val$totalFrameNum, i))) {
        this.val$simResult[this.val$num] = true;
      }
    }
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.util.GifAntishakeModule.2
 * JD-Core Version:    0.7.0.1
 */