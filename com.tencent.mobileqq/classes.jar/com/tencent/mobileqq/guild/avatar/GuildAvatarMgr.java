package com.tencent.mobileqq.guild.avatar;

import java.util.concurrent.CopyOnWriteArrayList;

public class GuildAvatarMgr
  implements IAvatarDownloadCallback, IGuildAvatarMgr
{
  private GuildAvatarCache a = new GuildAvatarCache();
  private GuildAvatarDownloader b = new GuildAvatarDownloader();
  private CopyOnWriteArrayList<IAvatarRequestCallback> c = new CopyOnWriteArrayList();
  
  public GuildAvatarMgr()
  {
    this.b.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.avatar.GuildAvatarMgr
 * JD-Core Version:    0.7.0.1
 */