package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GuildLongVideoItemBuilder$1
  implements ActionSheet.OnButtonClickListener
{
  GuildLongVideoItemBuilder$1(GuildLongVideoItemBuilder paramGuildLongVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, GuildLongVideoItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (this.a.uiOperatorFlag == 2)
      {
        this.d.a(this.b, 10, false);
        this.d.c(this.a, this.b);
      }
      else if (this.a.uiOperatorFlag == 1)
      {
        if (this.a.videoFileStatus == 1004) {
          ShortVideoUtils.reportCancelSendVideo("0X800A375", this.d.c.a);
        }
        paramView = this.d;
        GuildLongVideoItemBuilder.a(paramView, this.b, true, paramView);
        paramView = this.a;
        paramView.isPause = false;
        if ((!TextUtils.isEmpty(paramView.md5)) && (this.a.videoFileStatus == 1004) && (AioVideoTransFileController.c(this.d.g, this.a.frienduin, this.a.uniseq)))
        {
          this.a.videoFileStatus = 1002;
          if (QLog.isColorLevel()) {
            QLog.i("GuildShortVideoItemBuilder", 2, "onErrorIconClick resumeSending!");
          }
        }
        else if ((this.a.md5 == null) && ((this.a.videoFileStatus == 1005) || (this.a.videoFileStatus == 1004)))
        {
          this.b.h.setVisibility(8);
          this.b.i.setVisibility(8);
          this.b.g.setVisibility(8);
          paramView = new VideoCompressProcessor.CompressTask(this.d.g, this.d.b, this.a, GuildLongVideoItemBuilder.a(this.d));
          VideoCompressProcessor.a().a(this.a.uniseq, paramView);
        }
        else
        {
          this.d.a(this.b, 10, false);
          this.d.a(this.a, this.b);
        }
        GuildLongVideoItemBuilder.b(this.d);
      }
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */