package io.flutter.embedding.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

public abstract interface FlutterJNI$AccessibilityDelegate
{
  public abstract void updateCustomAccessibilityActions(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString);
  
  public abstract void updateSemantics(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */