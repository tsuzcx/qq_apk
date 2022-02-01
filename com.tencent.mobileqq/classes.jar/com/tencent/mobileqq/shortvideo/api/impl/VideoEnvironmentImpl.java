package com.tencent.mobileqq.shortvideo.api.impl;

import android.content.Context;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.api.IVideoEnvironment;
import com.tencent.video.decode.ShortVideoSoLoad;

public class VideoEnvironmentImpl
  implements IVideoEnvironment
{
  public boolean checkAndLoadAVCodec()
  {
    return VideoEnvironment.checkAndLoadAVCodec();
  }
  
  public int getAVCodecVersion()
  {
    return VideoEnvironment.getAVCodecVersion();
  }
  
  public String getShortVideoSoLibName()
  {
    return VideoEnvironment.getShortVideoSoLibName();
  }
  
  public String getShortVideoSoPath(Context paramContext)
  {
    return ShortVideoSoLoad.getShortVideoSoPath(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.api.impl.VideoEnvironmentImpl
 * JD-Core Version:    0.7.0.1
 */