package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;

public class SettingsChannel
{
  private static final String ALWAYS_USE_24_HOUR_FORMAT = "alwaysUse24HourFormat";
  public static final String CHANNEL_NAME = "flutter/settings";
  private static final String PLATFORM_BRIGHTNESS = "platformBrightness";
  private static final String TAG = "SettingsChannel";
  private static final String TEXT_SCALE_FACTOR = "textScaleFactor";
  @NonNull
  public final BasicMessageChannel<Object> channel;
  
  public SettingsChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/settings", JSONMessageCodec.INSTANCE);
  }
  
  @NonNull
  public SettingsChannel.MessageBuilder startMessage()
  {
    return new SettingsChannel.MessageBuilder(this.channel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.SettingsChannel
 * JD-Core Version:    0.7.0.1
 */