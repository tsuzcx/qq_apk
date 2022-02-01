package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildRuntimeApi;
import com.tencent.mobileqq.guild.audio.AudioRoom;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;

public class GuildRuntimeApiImpl
  implements IGuildRuntimeApi
{
  private void handleAudioRoomAccountRelease()
  {
    if (AudioRoom.b() != null)
    {
      AudioRoom.b().a(null);
      GuildFloatWindowUtils.a();
    }
  }
  
  public void handleAccountRelease()
  {
    handleAudioRoomAccountRelease();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildRuntimeApiImpl
 * JD-Core Version:    0.7.0.1
 */