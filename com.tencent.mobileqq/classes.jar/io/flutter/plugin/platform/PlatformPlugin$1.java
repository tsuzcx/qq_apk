package io.flutter.plugin.platform;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.AppSwitcherDescription;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemChromeStyle;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay;
import java.util.List;

class PlatformPlugin$1
  implements PlatformChannel.PlatformMessageHandler
{
  PlatformPlugin$1(PlatformPlugin paramPlatformPlugin) {}
  
  public boolean clipboardHasStrings()
  {
    CharSequence localCharSequence = PlatformPlugin.access$700(this.this$0, PlatformChannel.ClipboardContentFormat.PLAIN_TEXT);
    return (localCharSequence != null) && (localCharSequence.length() > 0);
  }
  
  public CharSequence getClipboardData(@Nullable PlatformChannel.ClipboardContentFormat paramClipboardContentFormat)
  {
    return PlatformPlugin.access$700(this.this$0, paramClipboardContentFormat);
  }
  
  public void playSystemSound(@NonNull PlatformChannel.SoundType paramSoundType)
  {
    PlatformPlugin.access$000(this.this$0, paramSoundType);
  }
  
  public void popSystemNavigator()
  {
    PlatformPlugin.access$600(this.this$0);
  }
  
  public void restoreSystemUiOverlays()
  {
    PlatformPlugin.access$400(this.this$0);
  }
  
  public void setApplicationSwitcherDescription(@NonNull PlatformChannel.AppSwitcherDescription paramAppSwitcherDescription)
  {
    PlatformPlugin.access$200(this.this$0, paramAppSwitcherDescription);
  }
  
  public void setClipboardData(@NonNull String paramString)
  {
    PlatformPlugin.access$800(this.this$0, paramString);
  }
  
  public void setPreferredOrientations(int paramInt)
  {
    PlatformPlugin.access$100(this.this$0, paramInt);
  }
  
  public void setSystemUiOverlayStyle(@NonNull PlatformChannel.SystemChromeStyle paramSystemChromeStyle)
  {
    PlatformPlugin.access$500(this.this$0, paramSystemChromeStyle);
  }
  
  public void showSystemOverlays(@NonNull List<PlatformChannel.SystemUiOverlay> paramList)
  {
    PlatformPlugin.access$300(this.this$0, paramList);
  }
  
  public void vibrateHapticFeedback(@NonNull PlatformChannel.HapticFeedbackType paramHapticFeedbackType)
  {
    this.this$0.vibrateHapticFeedback(paramHapticFeedbackType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformPlugin.1
 * JD-Core Version:    0.7.0.1
 */