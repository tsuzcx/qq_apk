package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.graphics.Bitmap;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class GuildLongVideoItemBuilder$3
  implements VideoPlayerCallback
{
  GuildLongVideoItemBuilder$3(GuildLongVideoItemBuilder paramGuildLongVideoItemBuilder, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadComplete, id = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("GuildShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    if (GuildLongVideoItemBuilder.c(this.b) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuildShortVideoItemBuilder", 2, "onDownloadComplete , mListView is null.");
      }
      return;
    }
    Object localObject = AIOUtils.b(paramLong, GuildLongVideoItemBuilder.c(this.b).getAdapter());
    if ((localObject instanceof MessageForShortVideo))
    {
      localObject = (MessageForShortVideo)localObject;
      if (((((MessageForShortVideo)localObject).fileType == 6) || (((MessageForShortVideo)localObject).fileType == 17) || (((MessageForShortVideo)localObject).fileType == 9) || (((MessageForShortVideo)localObject).fileType == 67)) && (((MessageForShortVideo)localObject).videoFileStatus != 2003))
      {
        ((MessageForShortVideo)localObject).videoFileStatus = 2003;
        ((MessageForShortVideo)localObject).transferedSize = 0;
        ((MessageForShortVideo)localObject).videoFileProgress = 100;
        ((MessageForShortVideo)localObject).serial();
        this.b.g.getMessageFacade().a(((MessageForShortVideo)localObject).frienduin, this.b.c.a, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).msgData);
      }
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLoopBack, id = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" ,position = ");
      localStringBuilder.append(paramLong2);
      QLog.d("GuildShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    AIOSingleReporter.a().b(Long.valueOf(paramLong1));
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    GuildLongVideoItemBuilder.a(this.b, paramLong, paramInt1, paramInt2, paramInt3, paramString, this.a);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    GuildLongVideoItemBuilder.a(this.b, paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */