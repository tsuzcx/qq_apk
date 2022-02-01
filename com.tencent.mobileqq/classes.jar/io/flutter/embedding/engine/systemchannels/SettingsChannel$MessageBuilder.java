package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import java.util.HashMap;
import java.util.Map;

public class SettingsChannel$MessageBuilder
{
  @NonNull
  private final BasicMessageChannel<Object> channel;
  @NonNull
  private Map<String, Object> message = new HashMap();
  
  SettingsChannel$MessageBuilder(@NonNull BasicMessageChannel<Object> paramBasicMessageChannel)
  {
    this.channel = paramBasicMessageChannel;
  }
  
  public void send()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sending message: \ntextScaleFactor: ");
    localStringBuilder.append(this.message.get("textScaleFactor"));
    localStringBuilder.append("\nalwaysUse24HourFormat: ");
    localStringBuilder.append(this.message.get("alwaysUse24HourFormat"));
    localStringBuilder.append("\nplatformBrightness: ");
    localStringBuilder.append(this.message.get("platformBrightness"));
    Log.v("SettingsChannel", localStringBuilder.toString());
    this.channel.send(this.message);
  }
  
  @NonNull
  public MessageBuilder setPlatformBrightness(@NonNull SettingsChannel.PlatformBrightness paramPlatformBrightness)
  {
    this.message.put("platformBrightness", paramPlatformBrightness.name);
    return this;
  }
  
  @NonNull
  public MessageBuilder setTextScaleFactor(float paramFloat)
  {
    this.message.put("textScaleFactor", Float.valueOf(paramFloat));
    return this;
  }
  
  @NonNull
  public MessageBuilder setUse24HourFormat(boolean paramBoolean)
  {
    this.message.put("alwaysUse24HourFormat", Boolean.valueOf(paramBoolean));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.SettingsChannel.MessageBuilder
 * JD-Core Version:    0.7.0.1
 */