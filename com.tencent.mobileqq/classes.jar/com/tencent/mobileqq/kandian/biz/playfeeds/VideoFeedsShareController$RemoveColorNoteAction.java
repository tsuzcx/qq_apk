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

class VideoFeedsShareController$RemoveColorNoteAction
  extends ShareAction
{
  VideoFeedsShareController$RemoveColorNoteAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((VideoFeedsShareController.l(this.a) != null) && (VideoFeedsShareController.l(this.a).isColorNoteExist()))
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131887835), 5000).show();
      VideoFeedsShareController.l(this.a).deleteColorNote();
      QLog.d("VideoFeedsShareController", 2, "mColorNoteController ： delete colorNote");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.RemoveColorNoteAction
 * JD-Core Version:    0.7.0.1
 */