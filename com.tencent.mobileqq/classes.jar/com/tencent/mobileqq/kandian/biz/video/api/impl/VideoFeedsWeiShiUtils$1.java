package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.app.Activity;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity;

final class VideoFeedsWeiShiUtils$1
  implements View.OnSystemUiVisibilityChangeListener
{
  public void onSystemUiVisibilityChange(int paramInt)
  {
    this.a.getWindow().getDecorView().setSystemUiVisibility(5894);
    Activity localActivity = this.b;
    if ((localActivity instanceof VideoFeedsPlayActivity)) {
      VideoFeedsHelper.h(localActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsWeiShiUtils.1
 * JD-Core Version:    0.7.0.1
 */