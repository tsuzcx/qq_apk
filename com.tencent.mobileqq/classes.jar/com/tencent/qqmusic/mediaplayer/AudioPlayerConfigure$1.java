package com.tencent.qqmusic.mediaplayer;

final class AudioPlayerConfigure$1
  implements ISoLibraryLoader
{
  public String findLibPath(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.startsWith("lib"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lib");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = (String)localObject;
    if (!((String)localObject).endsWith(".so"))
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(".so");
      paramString = paramString.toString();
    }
    return paramString;
  }
  
  public boolean load(String paramString)
  {
    System.loadLibrary(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure.1
 * JD-Core Version:    0.7.0.1
 */