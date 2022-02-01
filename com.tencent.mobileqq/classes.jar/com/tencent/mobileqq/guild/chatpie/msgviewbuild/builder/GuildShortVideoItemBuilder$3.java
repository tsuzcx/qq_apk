package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

class GuildShortVideoItemBuilder$3
  implements VideoPlayerCallback
{
  GuildShortVideoItemBuilder$3(GuildShortVideoItemBuilder paramGuildShortVideoItemBuilder) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playShortVideoByPath, onLoopBack, id = ");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("GuildShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = AIOSingleReporter.a().b(Long.valueOf(paramLong1));
    this.a.a((MessageForShortVideo)localObject, paramLong2);
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStateChange , state =  ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", msgUniseq = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("GuildShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 4)
    {
      localObject = AIOSingleReporter.a().b(Long.valueOf(paramLong));
      if ((localObject != null) && (!AIOSingleReporter.a().a(Long.valueOf(paramLong))))
      {
        ShortVideoUtils.reportVideoPlay(this.a.g, "0X8008E51", this.a.c, (MessageRecord)localObject, this.a.b);
        if (!AIOSingleReporter.a().c(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          AIOSingleReporter.a().d(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.reportVideoPlay(this.a.g, "0X8008E50", this.a.c, (MessageRecord)localObject, this.a.b);
        }
        AIOSingleReporter.a().a(Long.valueOf(paramLong), true);
      }
    }
    Object localObject = this.a.a(paramLong);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("holder == null, msgUniseq = ");
        ((StringBuilder)localObject).append(paramLong);
        QLog.w("GuildShortVideoRealItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (paramInt == 5) {
      return;
    }
    if ((paramInt != 7) && (paramInt != 8))
    {
      if (paramInt == 4)
      {
        GuildShortVideoItemBuilder.a(this.a).removeCallbacksAndMessages(null);
        this.a.b((GuildShortVideoItemBuilder.Holder)localObject);
        localObject = AIOSingleReporter.a().b(Long.valueOf(paramLong));
        if (localObject != null) {
          this.a.a((MessageForShortVideo)localObject, 0L);
        }
      }
      else if (paramInt == 1)
      {
        MessageForShortVideo localMessageForShortVideo = AIOSingleReporter.a().b(Long.valueOf(paramLong));
        if (localMessageForShortVideo != null)
        {
          ((GuildShortVideoItemBuilder.Holder)localObject).b.setVisibility(0);
          this.a.c(localMessageForShortVideo, (GuildShortVideoItemBuilder.Holder)localObject);
        }
      }
    }
    else
    {
      GuildShortVideoItemBuilder.a(this.a).removeCallbacksAndMessages(null);
      ((GuildShortVideoItemBuilder.Holder)localObject).b.setVisibility(0);
      this.a.a((GuildShortVideoItemBuilder.Holder)localObject);
      if (paramInt == 8)
      {
        localObject = AIOSingleReporter.a().b(Long.valueOf(paramLong));
        if (localObject != null) {
          this.a.a((MessageForShortVideo)localObject, ((MessageForShortVideo)localObject).videoFileTime * 1000);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildShortVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */