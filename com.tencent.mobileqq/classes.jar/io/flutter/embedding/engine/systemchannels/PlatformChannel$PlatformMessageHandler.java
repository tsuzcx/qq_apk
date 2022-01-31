package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.List;

public abstract interface PlatformChannel$PlatformMessageHandler
{
  @Nullable
  public abstract CharSequence getClipboardData(@Nullable PlatformChannel.ClipboardContentFormat paramClipboardContentFormat);
  
  public abstract void playSystemSound(@NonNull PlatformChannel.SoundType paramSoundType);
  
  public abstract void popSystemNavigator();
  
  public abstract void restoreSystemUiOverlays();
  
  public abstract void setApplicationSwitcherDescription(@NonNull PlatformChannel.AppSwitcherDescription paramAppSwitcherDescription);
  
  public abstract void setClipboardData(@NonNull String paramString);
  
  public abstract void setPreferredOrientations(int paramInt);
  
  public abstract void setSystemUiOverlayStyle(@NonNull PlatformChannel.SystemChromeStyle paramSystemChromeStyle);
  
  public abstract void showSystemOverlays(@NonNull List<PlatformChannel.SystemUiOverlay> paramList);
  
  public abstract void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType paramHapticFeedbackType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler
 * JD-Core Version:    0.7.0.1
 */