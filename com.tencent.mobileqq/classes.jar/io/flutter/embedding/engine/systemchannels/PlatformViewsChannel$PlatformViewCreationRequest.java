package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.nio.ByteBuffer;

public class PlatformViewsChannel$PlatformViewCreationRequest
{
  public final int direction;
  public final double logicalHeight;
  public final double logicalWidth;
  @Nullable
  public final ByteBuffer params;
  public final int viewId;
  @NonNull
  public final String viewType;
  
  public PlatformViewsChannel$PlatformViewCreationRequest(int paramInt1, @NonNull String paramString, double paramDouble1, double paramDouble2, int paramInt2, @Nullable ByteBuffer paramByteBuffer)
  {
    this.viewId = paramInt1;
    this.viewType = paramString;
    this.logicalWidth = paramDouble1;
    this.logicalHeight = paramDouble2;
    this.direction = paramInt2;
    this.params = paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewCreationRequest
 * JD-Core Version:    0.7.0.1
 */