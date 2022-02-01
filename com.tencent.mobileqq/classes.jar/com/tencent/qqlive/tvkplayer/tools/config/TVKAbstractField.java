package com.tencent.qqlive.tvkplayer.tools.config;

public abstract class TVKAbstractField
{
  public static final int APP_CONFIG = 2;
  public static final int SDK_CONFIG = 1;
  private int mConfigLevel = 0;
  private int mConfigPriv = 0;
  
  protected TVKAbstractField(int paramInt)
  {
    this.mConfigPriv = paramInt;
  }
  
  public int getConfigLevel()
  {
    return this.mConfigLevel;
  }
  
  public int getConfigPrivilege()
  {
    return this.mConfigPriv;
  }
  
  public void setConfigLevel(int paramInt)
  {
    this.mConfigLevel = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.config.TVKAbstractField
 * JD-Core Version:    0.7.0.1
 */