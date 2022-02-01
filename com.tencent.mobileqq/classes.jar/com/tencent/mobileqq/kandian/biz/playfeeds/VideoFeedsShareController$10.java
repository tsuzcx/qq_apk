package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView.OnComplainListener;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class VideoFeedsShareController$10
  implements ReadInJoyDisLikeDialogView.OnComplainListener
{
  VideoFeedsShareController$10(VideoFeedsShareController paramVideoFeedsShareController, VideoInfo paramVideoInfo) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsShareController", 2, "onDislikeDialogViewForAdComplain");
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", 2);
    VideoInfo localVideoInfo = this.a;
    if (localVideoInfo != null) {
      localIntent.putExtra("key_ad_info", localVideoInfo.as);
    }
    ReadInJoyActivityHelper.INSTANCE.launchReadInJoyUninterestComplainFragmentForResult(VideoFeedsShareController.f(this.b), localIntent);
    VideoFeedsShareController.k(this.b).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.10
 * JD-Core Version:    0.7.0.1
 */