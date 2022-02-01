package com.tencent.qqlive.module.videoreport.dtreport.audio.playback;

class AudioUtil
{
  static int floatByteCount()
  {
    return 4;
  }
  
  static int getBytesPerSample(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 4) {
        return 2;
      }
      return 4;
    }
    return 1;
  }
  
  static int shortByteSize()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.audio.playback.AudioUtil
 * JD-Core Version:    0.7.0.1
 */