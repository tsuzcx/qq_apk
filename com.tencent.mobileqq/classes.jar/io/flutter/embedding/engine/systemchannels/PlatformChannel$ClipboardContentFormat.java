package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;

public enum PlatformChannel$ClipboardContentFormat
{
  PLAIN_TEXT("text/plain");
  
  @NonNull
  private String encodedName;
  
  private PlatformChannel$ClipboardContentFormat(@NonNull String paramString)
  {
    this.encodedName = paramString;
  }
  
  @NonNull
  static ClipboardContentFormat fromValue(@NonNull String paramString)
  {
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      ClipboardContentFormat localClipboardContentFormat = localObject[i];
      if (localClipboardContentFormat.encodedName.equals(paramString)) {
        return localClipboardContentFormat;
      }
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No such ClipboardContentFormat: ");
    ((StringBuilder)localObject).append(paramString);
    paramString = new NoSuchFieldException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat
 * JD-Core Version:    0.7.0.1
 */