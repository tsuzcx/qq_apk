package com.tencent.mobileqq.kandian.biz.video.column;

import android.widget.ImageView;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/column/VideoColumnGuideManager$fetchGuideBgImg$1$1", "Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCallback;", "onFail", "", "request", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "exception", "", "onProgress", "progress", "", "onSuccess", "bitmap", "Lcom/tencent/mobileqq/kandian/base/image/api/ICloseableBitmap;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnGuideManager$fetchGuideBgImg$1$1
  implements IBitmapCallback
{
  public void a(@Nullable ImageRequest paramImageRequest, int paramInt) {}
  
  public void a(@Nullable ImageRequest paramImageRequest, @Nullable ICloseableBitmap paramICloseableBitmap)
  {
    VideoColumnGuideManager localVideoColumnGuideManager = this.a.this$0;
    if (paramICloseableBitmap != null) {
      paramImageRequest = paramICloseableBitmap.b();
    } else {
      paramImageRequest = null;
    }
    VideoColumnGuideManager.a(localVideoColumnGuideManager, paramImageRequest);
    VideoColumnGuideManager.a(this.a.this$0, true);
    paramImageRequest = VideoColumnGuideManager.b(this.a.this$0);
    if (paramImageRequest != null) {
      paramImageRequest.setImageBitmap(VideoColumnGuideManager.c(this.a.this$0));
    }
    VideoColumnGuideManager.d(this.a.this$0);
  }
  
  public void a(@Nullable ImageRequest paramImageRequest, @Nullable Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetch guide bg img fail: ");
    if (paramThrowable != null) {
      paramImageRequest = paramThrowable.getMessage();
    } else {
      paramImageRequest = null;
    }
    localStringBuilder.append(paramImageRequest);
    QLog.e("VideoColumnGuideManager", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.column.VideoColumnGuideManager.fetchGuideBgImg.1.1
 * JD-Core Version:    0.7.0.1
 */