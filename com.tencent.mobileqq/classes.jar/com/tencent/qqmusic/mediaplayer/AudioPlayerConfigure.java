package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

public class AudioPlayerConfigure
{
  private static final String LIB_PREFIX = "lib";
  private static final String LIB_SUFFIX = ".so";
  private static final String TAG = "AudioPlayerConfigure";
  static ISoLibraryLoader mISoLibraryLoader = new AudioPlayerConfigure.1();
  static int minAudioTrackWaitTimeMs = 300;
  private static boolean sIsNlogEnabled = false;
  
  public static boolean enableNativeLog(String paramString)
  {
    return enableNativeLog(NativeLibs.nlog.getName(), paramString);
  }
  
  public static boolean enableNativeLog(String paramString1, String paramString2)
  {
    if (sIsNlogEnabled) {
      return true;
    }
    String str = getSoLibraryLoader().findLibPath(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[enableNativeLog] loading log lib: ");
    localStringBuilder.append(str);
    Logger.i("AudioPlayerConfigure", localStringBuilder.toString());
    boolean bool;
    if (paramString2 == null) {
      bool = true;
    } else {
      bool = false;
    }
    if ((NLog.init(paramString1, paramString2, 0)) && (NativeLog.init(str) == 0))
    {
      sIsNlogEnabled = true;
      NLog.setWriteCallback(bool);
      Logger.i("AudioPlayerConfigure", "[enableNativeLog] succeed");
    }
    else
    {
      Logger.e("AudioPlayerConfigure", "[enableNativeLog] failed");
    }
    return sIsNlogEnabled;
  }
  
  private static byte[] findLibPath(byte[] paramArrayOfByte)
  {
    return mISoLibraryLoader.findLibPath(new String(paramArrayOfByte)).getBytes();
  }
  
  public static ISoLibraryLoader getSoLibraryLoader()
  {
    return mISoLibraryLoader;
  }
  
  public static void setAudioTrackMinWaitTimeMs(int paramInt)
  {
    minAudioTrackWaitTimeMs = paramInt;
  }
  
  public static void setLog(ILog paramILog)
  {
    if (paramILog != null) {
      paramILog.i("AudioPlayerConfigure", "QQMusicAudioPlayer codec version:1.19.1");
    }
    Logger.setLog(paramILog);
  }
  
  public static void setSoLibraryLoader(ISoLibraryLoader paramISoLibraryLoader)
  {
    if (paramISoLibraryLoader != null) {
      mISoLibraryLoader = paramISoLibraryLoader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure
 * JD-Core Version:    0.7.0.1
 */