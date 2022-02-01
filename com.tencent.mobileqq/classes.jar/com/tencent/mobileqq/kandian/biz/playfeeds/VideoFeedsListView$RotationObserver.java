package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsListView$RotationObserver
  extends ContentObserver
{
  private ContentResolver b;
  
  public VideoFeedsListView$RotationObserver(VideoFeedsListView paramVideoFeedsListView, Handler paramHandler)
  {
    super(paramHandler);
    this.b = VideoFeedsListView.h(paramVideoFeedsListView).getContentResolver();
  }
  
  public void a()
  {
    this.b.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    int i = Settings.System.getInt(VideoFeedsListView.h(this.a).getContentResolver(), "accelerometer_rotation", -1);
    Object localObject = this.a;
    paramBoolean = true;
    if (i != 1) {
      paramBoolean = false;
    }
    VideoFeedsListView.b((VideoFeedsListView)localObject, paramBoolean);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RotationObserver.onChange() : rotateState=");
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsListView.RotationObserver
 * JD-Core Version:    0.7.0.1
 */