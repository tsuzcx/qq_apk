package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.os.MqqHandler;

class VideoFeedsShareController$3
  implements ActionSheet.OnButtonClickListener
{
  VideoFeedsShareController$3(VideoFeedsShareController paramVideoFeedsShareController, ActionSheet paramActionSheet, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
    if (paramView != null)
    {
      if (paramView.equals(this.jdField_a_of_type_JavaLangString))
      {
        if (VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController) != null)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController;
          paramView.c(VideoFeedsShareController.a(paramView));
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController.a("0", "0", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
        return;
      }
      Object localObject;
      if (paramView.equals(this.b))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click menu to share to qzone, finalVideoExists=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        VideoFeedsShareController.a(paramView, ((StringBuilder)localObject).toString());
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = QZoneHelper.UserInfo.getInstance();
          QZoneHelper.forwardToPublishMood(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController), paramView, this.c, 10001);
          VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController).b(VideoFeedsShareController.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController));
        }
        else
        {
          QQToast.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController), 0, 2131719067, 0).b(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController).getResources().getDimensionPixelSize(2131299168));
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController.a("0", "1", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
        return;
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController), 0, 2131719067, 0).b(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController).getResources().getDimensionPixelSize(2131299168));
          return;
        }
        paramView = ThreadManager.getFileThreadHandler();
        localObject = this.c;
        MqqHandler localMqqHandler = VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5());
        localStringBuilder.append(".mp4");
        paramView.post(new ShortVideoUtils.VideoFileSaveRunnable((String)localObject, localMqqHandler, localStringBuilder.toString(), false));
        return;
      }
      if (paramView.equals(this.e))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController), 0, 2131719067, 0).b(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController).getResources().getDimensionPixelSize(2131299168));
          return;
        }
        paramView = new Intent("android.intent.action.VIEW");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file://");
        ((StringBuilder)localObject).append(this.c);
        paramView.setDataAndType(Uri.parse(((StringBuilder)localObject).toString()), "video/*");
        paramView.putExtra("big_brother_source_key", RIJJumpUtils.a(0));
        VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController).startActivity(paramView);
        VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController).b(VideoFeedsShareController.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.3
 * JD-Core Version:    0.7.0.1
 */