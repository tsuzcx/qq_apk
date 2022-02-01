package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class VideoFeedsShareController$ShortVideoMqqHandler
  extends MqqHandler
{
  private VideoFeedsShareController$ShortVideoMqqHandler(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        if (VideoFeedsShareController.e(this.a) != null)
        {
          if (VideoFeedsShareController.e(this.a).a != 0) {
            return;
          }
          paramMessage = SVUtils.a(VideoFeedsShareController.e(this.a).aQ, "mp4");
          DialogUtil.a(VideoFeedsShareController.f(this.a), 232, VideoFeedsShareController.f(this.a).getResources().getString(2131916643), VideoFeedsShareController.f(this.a).getResources().getString(2131916642), 2131916626, 2131915687, new VideoFeedsShareController.ShortVideoMqqHandler.1(this, paramMessage), new VideoFeedsShareController.ShortVideoMqqHandler.2(this)).show();
          return;
        }
        return;
      }
      String str = VideoFeedsShareController.f(this.a).getString(2131916612);
      paramMessage = (String)paramMessage.obj;
      Activity localActivity = VideoFeedsShareController.f(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramMessage);
      QQToast.makeText(localActivity, 2, localStringBuilder.toString(), 0).show();
      ImageUtil.b(VideoFeedsShareController.f(this.a), paramMessage);
      return;
    }
    QQToast.makeText(VideoFeedsShareController.f(this.a), 2131916611, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.ShortVideoMqqHandler
 * JD-Core Version:    0.7.0.1
 */