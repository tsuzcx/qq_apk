package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate;

public abstract interface AccessibilityChannel$AccessibilityMessageHandler
  extends FlutterJNI.AccessibilityDelegate
{
  public abstract void announce(@NonNull String paramString);
  
  public abstract void onLongPress(int paramInt);
  
  public abstract void onTap(int paramInt);
  
  public abstract void onTooltip(@NonNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
 * JD-Core Version:    0.7.0.1
 */