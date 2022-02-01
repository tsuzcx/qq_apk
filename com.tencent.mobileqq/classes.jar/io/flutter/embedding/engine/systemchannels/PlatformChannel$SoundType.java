package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;

public enum PlatformChannel$SoundType
{
  CLICK("SystemSoundType.click");
  
  @NonNull
  private final String encodedName;
  
  private PlatformChannel$SoundType(@NonNull String paramString)
  {
    this.encodedName = paramString;
  }
  
  @NonNull
  static SoundType fromValue(@NonNull String paramString)
  {
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      SoundType localSoundType = localObject[i];
      if (localSoundType.encodedName.equals(paramString)) {
        return localSoundType;
      }
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No such SoundType: ");
    ((StringBuilder)localObject).append(paramString);
    throw new NoSuchFieldException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType
 * JD-Core Version:    0.7.0.1
 */