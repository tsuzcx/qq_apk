package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.video.decode.ShortVideoSoLoad;

public class FileFFmpegUtils
{
  public static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (String str = "trim_process_pie";; str = "trim_process_pic") {
      return ShortVideoSoLoad.getShortVideoSoPath(paramContext) + str;
    }
  }
  
  public static String b(Context paramContext)
  {
    paramContext = ShortVideoSoLoad.getShortVideoSoPath(paramContext);
    String str = VideoEnvironment.getShortVideoSoLibName();
    return paramContext + str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.FileFFmpegUtils
 * JD-Core Version:    0.7.0.1
 */