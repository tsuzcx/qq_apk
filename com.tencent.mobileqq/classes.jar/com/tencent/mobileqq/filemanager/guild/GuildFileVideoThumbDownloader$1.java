package com.tencent.mobileqq.filemanager.guild;

import com.tencent.qphone.base.util.QLog;

class GuildFileVideoThumbDownloader$1
  implements Runnable
{
  GuildFileVideoThumbDownloader$1(GuildFileVideoThumbDownloader paramGuildFileVideoThumbDownloader, GuildFileVideoThumbDownloader.VideoSession paramVideoSession) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download retry download retryIndex = ");
    localStringBuilder.append(GuildFileVideoThumbDownloader.VideoSession.b(this.a));
    QLog.d("GuildVideoThumbDownloader<FileAssistant>", 2, localStringBuilder.toString());
    this.this$0.a(this.a.b, GuildFileVideoThumbDownloader.VideoSession.c(this.a), GuildFileVideoThumbDownloader.VideoSession.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.guild.GuildFileVideoThumbDownloader.1
 * JD-Core Version:    0.7.0.1
 */