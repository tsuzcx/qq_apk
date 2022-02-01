package com.tencent.mobileqq.guild.audio;

import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.qphone.base.util.QLog;

class AudioRoom$16$1
  implements PhoneStatusMonitor.PhoneStatusListener
{
  AudioRoom$16$1(AudioRoom.16 param16) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCallStateChanged");
    localStringBuilder.append(paramBoolean);
    QLog.i("AudioRoom", 4, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.a.this$0.a(false);
      return;
    }
    this.a.this$0.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRoom.16.1
 * JD-Core Version:    0.7.0.1
 */