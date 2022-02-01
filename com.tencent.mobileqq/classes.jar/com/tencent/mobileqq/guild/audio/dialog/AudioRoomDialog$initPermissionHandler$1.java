package com.tencent.mobileqq.guild.audio.dialog;

import com.tencent.mobileqq.guild.audio.AudioRoom;
import com.tencent.mobileqq.guild.audio.frame.FloatWindowPermissionHandler.OnRequestPermissionListener;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "grant", "", "onRequestPermission"}, k=3, mv={1, 1, 16})
final class AudioRoomDialog$initPermissionHandler$1
  implements FloatWindowPermissionHandler.OnRequestPermissionListener
{
  AudioRoomDialog$initPermissionHandler$1(AudioRoomDialog paramAudioRoomDialog) {}
  
  public final void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (AudioRoom.b().a(AudioRoomDialog.g(this.a).getChannelUin()))) {
      GuildFloatWindowUtils.a(AudioRoomDialog.h(this.a), AudioRoomDialog.g(this.a), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.AudioRoomDialog.initPermissionHandler.1
 * JD-Core Version:    0.7.0.1
 */