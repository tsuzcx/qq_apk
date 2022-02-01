package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.AccessibilityBridge.Action;

public class AccessibilityChannel
{
  private static final String TAG = "AccessibilityChannel";
  @NonNull
  public final BasicMessageChannel<Object> channel;
  @NonNull
  public final FlutterJNI flutterJNI;
  @Nullable
  private AccessibilityChannel.AccessibilityMessageHandler handler;
  private final BasicMessageChannel.MessageHandler<Object> parsingMessageHandler = new AccessibilityChannel.1(this);
  
  public AccessibilityChannel(@NonNull DartExecutor paramDartExecutor, @NonNull FlutterJNI paramFlutterJNI)
  {
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/accessibility", StandardMessageCodec.INSTANCE);
    this.channel.setMessageHandler(this.parsingMessageHandler);
    this.flutterJNI = paramFlutterJNI;
  }
  
  public void dispatchSemanticsAction(int paramInt, @NonNull AccessibilityBridge.Action paramAction)
  {
    this.flutterJNI.dispatchSemanticsAction(paramInt, paramAction);
  }
  
  public void dispatchSemanticsAction(int paramInt, @NonNull AccessibilityBridge.Action paramAction, @Nullable Object paramObject)
  {
    this.flutterJNI.dispatchSemanticsAction(paramInt, paramAction, paramObject);
  }
  
  public void onAndroidAccessibilityDisabled()
  {
    this.flutterJNI.setSemanticsEnabled(false);
  }
  
  public void onAndroidAccessibilityEnabled()
  {
    this.flutterJNI.setSemanticsEnabled(true);
  }
  
  public void setAccessibilityFeatures(int paramInt)
  {
    this.flutterJNI.setAccessibilityFeatures(paramInt);
  }
  
  public void setAccessibilityMessageHandler(@Nullable AccessibilityChannel.AccessibilityMessageHandler paramAccessibilityMessageHandler)
  {
    this.handler = paramAccessibilityMessageHandler;
    this.flutterJNI.setAccessibilityDelegate(paramAccessibilityMessageHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.AccessibilityChannel
 * JD-Core Version:    0.7.0.1
 */