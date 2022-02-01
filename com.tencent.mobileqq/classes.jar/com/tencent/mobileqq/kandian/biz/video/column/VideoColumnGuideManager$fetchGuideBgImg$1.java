package com.tencent.mobileqq.kandian.biz.video.column;

import android.widget.ImageView;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoColumnGuideManager$fetchGuideBgImg$1
  implements Runnable
{
  VideoColumnGuideManager$fetchGuideBgImg$1(VideoColumnGuideManager paramVideoColumnGuideManager) {}
  
  public final void run()
  {
    ImageRequest localImageRequest = new ImageRequest();
    ImageView localImageView = VideoColumnGuideManager.a(this.this$0);
    int j = 0;
    if (localImageView != null) {
      i = localImageView.getWidth();
    } else {
      i = 0;
    }
    localImageRequest.jdField_a_of_type_Int = i;
    localImageView = VideoColumnGuideManager.a(this.this$0);
    int i = j;
    if (localImageView != null) {
      i = localImageView.getHeight();
    }
    localImageRequest.b = i;
    localImageRequest.jdField_a_of_type_JavaNetURL = new URL("https://kd.qpic.cn/kamlin/assets/video_column_guide_bg_d59dfa8a.jpg");
    ((IImageManager)QRoute.api(IImageManager.class)).loadImage(localImageRequest, (IBitmapCallback)new VideoColumnGuideManager.fetchGuideBgImg.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.column.VideoColumnGuideManager.fetchGuideBgImg.1
 * JD-Core Version:    0.7.0.1
 */