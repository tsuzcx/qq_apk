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
        if (VideoFeedsShareController.a(this.a) != null)
        {
          if (VideoFeedsShareController.a(this.a).jdField_a_of_type_Int != 0) {
            return;
          }
          paramMessage = SVUtils.a(VideoFeedsShareController.a(this.a).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
          DialogUtil.a(VideoFeedsShareController.a(this.a), 232, VideoFeedsShareController.a(this.a).getResources().getString(2131719107), VideoFeedsShareController.a(this.a).getResources().getString(2131719106), 2131719090, 2131718205, new VideoFeedsShareController.ShortVideoMqqHandler.1(this, paramMessage), new VideoFeedsShareController.ShortVideoMqqHandler.2(this)).show();
          return;
        }
        return;
      }
      String str = VideoFeedsShareController.a(this.a).getString(2131719076);
      paramMessage = (String)paramMessage.obj;
      Activity localActivity = VideoFeedsShareController.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramMessage);
      QQToast.a(localActivity, 2, localStringBuilder.toString(), 0).a();
      ImageUtil.a(VideoFeedsShareController.a(this.a), paramMessage);
      return;
    }
    QQToast.a(VideoFeedsShareController.a(this.a), 2131719075, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.ShortVideoMqqHandler
 * JD-Core Version:    0.7.0.1
 */