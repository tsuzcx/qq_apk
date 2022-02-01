package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;

public class PlatformViewsChannel$PlatformViewTouch
{
  public final int action;
  public final int buttonState;
  public final int deviceId;
  @NonNull
  public final Number downTime;
  public final int edgeFlags;
  @NonNull
  public final Number eventTime;
  public final int flags;
  public final int metaState;
  public final long motionEventId;
  public final int pointerCount;
  @NonNull
  public final Object rawPointerCoords;
  @NonNull
  public final Object rawPointerPropertiesList;
  public final int source;
  public final int viewId;
  public final float xPrecision;
  public final float yPrecision;
  
  public PlatformViewsChannel$PlatformViewTouch(int paramInt1, @NonNull Number paramNumber1, @NonNull Number paramNumber2, int paramInt2, int paramInt3, @NonNull Object paramObject1, @NonNull Object paramObject2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8, int paramInt9, long paramLong)
  {
    this.viewId = paramInt1;
    this.downTime = paramNumber1;
    this.eventTime = paramNumber2;
    this.action = paramInt2;
    this.pointerCount = paramInt3;
    this.rawPointerPropertiesList = paramObject1;
    this.rawPointerCoords = paramObject2;
    this.metaState = paramInt4;
    this.buttonState = paramInt5;
    this.xPrecision = paramFloat1;
    this.yPrecision = paramFloat2;
    this.deviceId = paramInt6;
    this.edgeFlags = paramInt7;
    this.source = paramInt8;
    this.flags = paramInt9;
    this.motionEventId = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewTouch
 * JD-Core Version:    0.7.0.1
 */