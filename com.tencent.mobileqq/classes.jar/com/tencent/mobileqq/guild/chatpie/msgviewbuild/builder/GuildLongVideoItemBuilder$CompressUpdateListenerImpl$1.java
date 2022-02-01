package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class GuildLongVideoItemBuilder$CompressUpdateListenerImpl$1
  implements Runnable
{
  GuildLongVideoItemBuilder$CompressUpdateListenerImpl$1(GuildLongVideoItemBuilder.CompressUpdateListenerImpl paramCompressUpdateListenerImpl, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean, GuildLongVideoItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.frienduin);
    ((StringBuilder)localObject).append(this.a.uniseq);
    localObject = ((StringBuilder)localObject).toString();
    if (this.b)
    {
      this.c.c.setDrawStatus(1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<MessageProgressView> CompressUpdateListenerImpl , onLaunch, run,  keyStr = ");
        localStringBuilder.append((String)localObject);
        QLog.d("GuildShortVideoItemBuilder", 2, localStringBuilder.toString());
      }
      this.c.c.setAnimProgress(HardCodeUtil.a(2131911491), (String)localObject);
      this.c.c.h = 10;
      this.c.c.setVideoCompressStatus(true);
      return;
    }
    this.c.c.a((String)localObject, 1.0F);
    this.c.c.setAnimProgress(10, (String)localObject);
    this.c.c.setVideoCompressStatus(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder.CompressUpdateListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */