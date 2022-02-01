package com.tencent.qqmusic.mediaplayer.audiofx;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface IAudioListenerBuilder
{
  @Nullable
  public abstract IAudioListener createAudioEffect(@NonNull Bundle paramBundle);
  
  @Nullable
  public abstract Bundle getConfiguration(int paramInt, @Nullable Bundle paramBundle);
  
  @NonNull
  public abstract String getId();
  
  public abstract void init(Context paramContext);
  
  public abstract boolean isEnabled();
  
  public abstract void release();
  
  public abstract void setConfiguration(int paramInt, Bundle paramBundle);
  
  public abstract boolean setEnabled(boolean paramBoolean);
  
  public abstract void setListener(OnBuilderStateChangedListener paramOnBuilderStateChangedListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audiofx.IAudioListenerBuilder
 * JD-Core Version:    0.7.0.1
 */