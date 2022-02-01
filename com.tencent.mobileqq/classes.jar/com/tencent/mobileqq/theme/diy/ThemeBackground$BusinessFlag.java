package com.tencent.mobileqq.theme.diy;

public class ThemeBackground$BusinessFlag
{
  private final String type;
  public boolean use3D;
  public boolean useAETC;
  public boolean useApng;
  public boolean useEffect;
  public boolean useStatic;
  public boolean useVideo;
  
  public ThemeBackground$BusinessFlag(String paramString)
  {
    this.type = paramString;
  }
  
  private void log() {}
  
  private void reset()
  {
    this.useStatic = false;
    this.useEffect = false;
    this.useApng = false;
    this.useVideo = false;
    this.use3D = false;
    this.useAETC = false;
  }
  
  public void setUse3D()
  {
    reset();
    this.use3D = true;
    log();
  }
  
  public void setUseAETC()
  {
    reset();
    this.useAETC = true;
    log();
  }
  
  public void setUseApng()
  {
    reset();
    this.useApng = true;
    log();
  }
  
  public void setUseEffect()
  {
    reset();
    this.useEffect = true;
    log();
  }
  
  public void setUseStatic()
  {
    reset();
    this.useStatic = true;
    log();
  }
  
  public void setUseVideo()
  {
    reset();
    this.useVideo = true;
    log();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground.BusinessFlag
 * JD-Core Version:    0.7.0.1
 */