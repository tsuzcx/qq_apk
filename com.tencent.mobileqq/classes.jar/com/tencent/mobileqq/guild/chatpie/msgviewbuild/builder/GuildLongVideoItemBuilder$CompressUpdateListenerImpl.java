package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressUpdateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;

class GuildLongVideoItemBuilder$CompressUpdateListenerImpl
  implements VideoCompressProcessor.CompressUpdateListener
{
  private GuildLongVideoItemBuilder$CompressUpdateListenerImpl(GuildLongVideoItemBuilder paramGuildLongVideoItemBuilder) {}
  
  public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
  {
    GuildLongVideoItemBuilder.Holder localHolder = GuildLongVideoItemBuilder.a(this.a, paramMessageForShortVideo);
    if (localHolder == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(paramMessageForShortVideo.uniseq);
    paramMessageForShortVideo = localStringBuilder.toString();
    localHolder.c.setAnimProgress(HardCodeUtil.a(2131911473), paramMessageForShortVideo);
    localHolder.c.a(paramMessageForShortVideo, paramFloat);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<MessageProgressView> CompressUpdateListener,onFinish. seq = ");
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      QLog.d("GuildShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    UiThreadUtil.a(new GuildLongVideoItemBuilder.CompressUpdateListenerImpl.2(this, paramMessageForShortVideo, paramInt));
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    GuildLongVideoItemBuilder.Holder localHolder = GuildLongVideoItemBuilder.a(this.a, paramMessageForShortVideo);
    if (localHolder == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<MessageProgressView> CompressUpdateListenerImpl , onLaunch. seq = ");
      localStringBuilder.append(paramMessageForShortVideo.uniseq);
      QLog.d("GuildShortVideoItemBuilder", 2, localStringBuilder.toString());
    }
    UiThreadUtil.a(new GuildLongVideoItemBuilder.CompressUpdateListenerImpl.1(this, paramMessageForShortVideo, paramBoolean, localHolder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder.CompressUpdateListenerImpl
 * JD-Core Version:    0.7.0.1
 */