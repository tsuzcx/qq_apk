package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsShareController$AddColorNoteAction
  extends ShareAction
{
  VideoFeedsShareController$AddColorNoteAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (VideoFeedsShareController.a(this.a) != null)
    {
      if (VideoFeedsShareController.a(this.a).canAddColorNote())
      {
        QLog.d("VideoFeedsShareController", 2, "mColorNoteController ：add colorNote");
        VideoFeedsShareController.a(this.a).insertColorNote();
        QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690892), 5000).a();
        return;
      }
      VideoFeedsShareController.a(this.a).onCannotAdd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.AddColorNoteAction
 * JD-Core Version:    0.7.0.1
 */