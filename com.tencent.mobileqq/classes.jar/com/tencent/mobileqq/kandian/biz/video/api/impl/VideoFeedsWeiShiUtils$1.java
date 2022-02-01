package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;

final class VideoFeedsWeiShiUtils$1
  implements View.OnSystemUiVisibilityChangeListener
{
  public void onSystemUiVisibilityChange(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWeShiGuideDialog.getWindow().getDecorView().setSystemUiVisibility(5894);
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof VideoFeedsPlayActivity)) {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsWeiShiUtils.1
 * JD-Core Version:    0.7.0.1
 */