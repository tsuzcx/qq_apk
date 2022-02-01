package com.tencent.mobileqq.qqaudio.audioplayer;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IAudioDeviceService
  extends AudioSenorManager.IAudioSenorListener, IRuntimeService
{
  public abstract void registerAudioDeviceListener(IAudioDeviceService.IAudioDeviceListener paramIAudioDeviceListener);
  
  public abstract void unRegisterAudioDeviceListener(IAudioDeviceService.IAudioDeviceListener paramIAudioDeviceListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.IAudioDeviceService
 * JD-Core Version:    0.7.0.1
 */