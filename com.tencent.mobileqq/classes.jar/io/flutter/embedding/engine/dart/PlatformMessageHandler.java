package io.flutter.embedding.engine.dart;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract interface PlatformMessageHandler
{
  public abstract void handleMessageFromDart(@NonNull String paramString, @Nullable byte[] paramArrayOfByte, int paramInt);
  
  public abstract void handlePlatformMessageResponse(int paramInt, @Nullable byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.PlatformMessageHandler
 * JD-Core Version:    0.7.0.1
 */