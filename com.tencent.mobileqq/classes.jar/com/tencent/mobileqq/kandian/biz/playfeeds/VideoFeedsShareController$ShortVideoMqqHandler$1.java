package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import mqq.os.MqqHandler;

class VideoFeedsShareController$ShortVideoMqqHandler$1
  implements DialogInterface.OnClickListener
{
  VideoFeedsShareController$ShortVideoMqqHandler$1(VideoFeedsShareController.ShortVideoMqqHandler paramShortVideoMqqHandler, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ThreadManager.getFileThreadHandler();
    String str = this.a;
    VideoFeedsShareController.ShortVideoMqqHandler localShortVideoMqqHandler = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoFeedsShareController.f(this.b.a).getIntent().getExtras().getString("thumbfile_md5"));
    localStringBuilder.append(".mp4");
    paramDialogInterface.post(new ShortVideoUtils.VideoFileSaveRunnable(str, localShortVideoMqqHandler, localStringBuilder.toString(), true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.ShortVideoMqqHandler.1
 * JD-Core Version:    0.7.0.1
 */