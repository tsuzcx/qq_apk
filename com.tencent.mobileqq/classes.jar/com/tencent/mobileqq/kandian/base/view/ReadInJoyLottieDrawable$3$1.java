package com.tencent.mobileqq.kandian.base.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ReadInJoyLottieDrawable$3$1
  implements ImageAssetDelegate
{
  ReadInJoyLottieDrawable$3$1(ReadInJoyLottieDrawable.3 param3) {}
  
  @Nullable
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject = paramLottieImageAsset.getFileName();
    paramLottieImageAsset = ReadInJoyLottieDrawable.a(this.a.this$0, this.a.b, "images");
    if (paramLottieImageAsset == null) {
      paramLottieImageAsset = this.a.b[0];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLottieImageAsset.getAbsolutePath());
    localStringBuilder.append("/");
    localStringBuilder.append((String)localObject);
    paramLottieImageAsset = localStringBuilder.toString();
    localObject = (Bitmap)ReadInJoyLottieDrawable.b().get(paramLottieImageAsset);
    if (localObject != null) {
      return localObject;
    }
    ThreadManager.excute(new ReadInJoyLottieDrawable.3.1.1(this, paramLottieImageAsset), 64, null, true);
    try
    {
      localObject = BitmapFactory.decodeFile(paramLottieImageAsset);
      return localObject;
    }
    catch (Exception localException)
    {
      break label150;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label117:
      break label117;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadLottieAnimation oom: ");
    ((StringBuilder)localObject).append(paramLottieImageAsset);
    QLog.e("ReadInJoyLottieDrawable", 2, ((StringBuilder)localObject).toString());
    return null;
    label150:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadLottieAnimation path: ");
    ((StringBuilder)localObject).append(paramLottieImageAsset);
    QLog.e("ReadInJoyLottieDrawable", 2, ((StringBuilder)localObject).toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable.3.1
 * JD-Core Version:    0.7.0.1
 */