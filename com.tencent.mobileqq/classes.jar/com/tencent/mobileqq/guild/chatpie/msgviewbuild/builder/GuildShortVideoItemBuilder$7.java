package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.ResultListener;
import com.tencent.qphone.base.util.QLog;

class GuildShortVideoItemBuilder$7
  implements ResultListener
{
  GuildShortVideoItemBuilder$7(GuildShortVideoItemBuilder paramGuildShortVideoItemBuilder) {}
  
  public void a(int paramInt)
  {
    GuildShortVideoItemBuilder localGuildShortVideoItemBuilder = this.a;
    long l;
    if (GuildShortVideoItemBuilder.b(localGuildShortVideoItemBuilder) != null) {
      l = GuildShortVideoItemBuilder.b(this.a).uniseq;
    } else {
      l = -1L;
    }
    GuildShortVideoItemBuilder.a(localGuildShortVideoItemBuilder, l);
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte2 = new StringBuilder();
      paramArrayOfByte2.append("onEncodeSuccess curMsg:");
      if (GuildShortVideoItemBuilder.b(this.a) != null) {
        paramString2 = Long.valueOf(GuildShortVideoItemBuilder.b(this.a).uniseq);
      } else {
        paramString2 = "";
      }
      paramArrayOfByte2.append(paramString2);
      QLog.i("GuildShortVideoRealItemBuilder", 2, paramArrayOfByte2.toString());
    }
    if (GuildShortVideoItemBuilder.b(this.a) != null)
    {
      GuildShortVideoItemBuilder.b(this.a).md5 = HexUtil.bytes2HexStr(paramArrayOfByte1);
      new GuildShortVideoItemBuilder.UploadTask(this.a.g, this.a.b, GuildShortVideoItemBuilder.b(this.a), paramString1, this.a).run();
      return;
    }
    ShortVideoExceptionReporter.a(new RuntimeException("onMediaMessageSend failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildShortVideoItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */