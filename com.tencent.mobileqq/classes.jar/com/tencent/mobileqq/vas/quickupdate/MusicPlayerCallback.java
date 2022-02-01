package com.tencent.mobileqq.vas.quickupdate;

public class MusicPlayerCallback
  extends BaseUpdateCallback
{
  public static MusicPlayerCallback sInstance = new MusicPlayerCallback();
  
  public long getBID()
  {
    return 39L;
  }
  
  protected String getRootDir()
  {
    return "musicPlayer";
  }
  
  protected String getScidPrefix()
  {
    return "musicPlayer.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.MusicPlayerCallback
 * JD-Core Version:    0.7.0.1
 */