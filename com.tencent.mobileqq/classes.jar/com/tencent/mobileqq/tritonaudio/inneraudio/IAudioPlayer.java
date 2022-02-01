package com.tencent.mobileqq.tritonaudio.inneraudio;

public abstract interface IAudioPlayer
{
  public abstract int getAudioId();
  
  public abstract String getAudioPath();
  
  public abstract boolean getAutoPlay();
  
  public abstract double getBufferedTime();
  
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract boolean getLoop();
  
  public abstract float getStartTime();
  
  public abstract IAudioStateChangeListener getStateChangeListener();
  
  public abstract float getVolume();
  
  public abstract boolean isNeedResume();
  
  public abstract boolean isPaused();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract void seekTo(float paramFloat);
  
  public abstract void setAudioId(int paramInt);
  
  public abstract void setAudioPath(String paramString);
  
  public abstract void setAutoPlay(boolean paramBoolean);
  
  public abstract void setLoop(boolean paramBoolean);
  
  public abstract void setNeedResume(boolean paramBoolean);
  
  public abstract void setStartTime(float paramFloat);
  
  public abstract void setStateChangeListener(IAudioStateChangeListener paramIAudioStateChangeListener);
  
  public abstract void setVolume(float paramFloat);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.IAudioPlayer
 * JD-Core Version:    0.7.0.1
 */