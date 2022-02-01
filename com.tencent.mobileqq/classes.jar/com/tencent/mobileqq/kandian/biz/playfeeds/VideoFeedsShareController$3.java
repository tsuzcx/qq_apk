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
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    paramView = this.a.getContent(paramInt);
    if (paramView != null)
    {
      if (paramView.equals(this.b))
      {
        if (VideoFeedsShareController.e(this.i) != null)
        {
          paramView = this.i;
          paramView.c(VideoFeedsShareController.e(paramView));
        }
        this.i.a("0", "0", "0", this.c.getMd5(), "0", this.c.videoFileTime, 0L, 0, -1, 0, null, true);
        return;
      }
      Object localObject;
      if (paramView.equals(this.d))
      {
        paramView = this.i;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click menu to share to qzone, finalVideoExists=");
        ((StringBuilder)localObject).append(this.e);
        VideoFeedsShareController.a(paramView, ((StringBuilder)localObject).toString());
        if (this.e)
        {
          paramView = QZoneHelper.UserInfo.getInstance();
          QZoneHelper.forwardToPublishMood(VideoFeedsShareController.f(this.i), paramView, this.f, 10001);
          VideoFeedsShareController.b(this.i).b(VideoFeedsShareController.c(this.i));
        }
        else
        {
          QQToast.makeText(VideoFeedsShareController.f(this.i), 0, 2131916603, 0).show(VideoFeedsShareController.f(this.i).getResources().getDimensionPixelSize(2131299920));
        }
        this.i.a("0", "1", "0", this.c.getMd5(), "0", this.c.videoFileTime, 0L, 0, -1, 0, null, true);
        return;
      }
      if (paramView.equals(this.g))
      {
        if (!this.e)
        {
          QQToast.makeText(VideoFeedsShareController.f(this.i), 0, 2131916603, 0).show(VideoFeedsShareController.f(this.i).getResources().getDimensionPixelSize(2131299920));
          return;
        }
        paramView = ThreadManager.getFileThreadHandler();
        localObject = this.f;
        MqqHandler localMqqHandler = VideoFeedsShareController.g(this.i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.c.getMd5());
        localStringBuilder.append(".mp4");
        paramView.post(new ShortVideoUtils.VideoFileSaveRunnable((String)localObject, localMqqHandler, localStringBuilder.toString(), false));
        return;
      }
      if (paramView.equals(this.h))
      {
        if (!this.e)
        {
          QQToast.makeText(VideoFeedsShareController.f(this.i), 0, 2131916603, 0).show(VideoFeedsShareController.f(this.i).getResources().getDimensionPixelSize(2131299920));
          return;
        }
        paramView = new Intent("android.intent.action.VIEW");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file://");
        ((StringBuilder)localObject).append(this.f);
        paramView.setDataAndType(Uri.parse(((StringBuilder)localObject).toString()), "video/*");
        paramView.putExtra("big_brother_source_key", RIJJumpUtils.a(0));
        VideoFeedsShareController.f(this.i).startActivity(paramView);
        VideoFeedsShareController.b(this.i).b(VideoFeedsShareController.c(this.i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.3
 * JD-Core Version:    0.7.0.1
 */