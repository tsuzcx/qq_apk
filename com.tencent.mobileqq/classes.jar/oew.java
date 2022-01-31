import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.3;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.3.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class oew
  implements ImageAssetDelegate
{
  public oew(ReadInJoyLottieDrawable.3 param3) {}
  
  @Nullable
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    paramLottieImageAsset = paramLottieImageAsset.getFileName();
    paramLottieImageAsset = this.a.a[0].getAbsolutePath() + "/" + paramLottieImageAsset;
    Bitmap localBitmap = (Bitmap)oet.b().get(paramLottieImageAsset);
    if (localBitmap != null) {
      return localBitmap;
    }
    ThreadManager.excute(new ReadInJoyLottieDrawable.3.1.1(this, paramLottieImageAsset), 64, null, true);
    try
    {
      localBitmap = BitmapFactory.decodeFile(paramLottieImageAsset);
      return localBitmap;
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation path: " + paramLottieImageAsset);
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation oom: " + paramLottieImageAsset);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oew
 * JD-Core Version:    0.7.0.1
 */