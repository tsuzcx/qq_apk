package com.tencent.mobileqq.guild.audio.widget;

import com.tencent.mobileqq.guild.audio.AudioRoom;

class AudioSmallScreen$2
  implements Runnable
{
  AudioSmallScreen$2(AudioSmallScreen paramAudioSmallScreen) {}
  
  public void run()
  {
    AudioRoom localAudioRoom = AudioRoom.b();
    AudioSmallScreen.a(this.this$0, localAudioRoom.e());
    if (AudioSmallScreen.c(this.this$0))
    {
      AudioSmallScreen.a(this.this$0, 2130840726);
      return;
    }
    AudioSmallScreen.a(this.this$0, 2130840725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.AudioSmallScreen.2
 * JD-Core Version:    0.7.0.1
 */