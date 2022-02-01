package com.tencent.thumbplayer.api.capability;

public class TPVCodecCapabilityForSet
{
  private int level;
  private int lowerboundHeight;
  private int lowerboundWidth;
  private int profile;
  private int upperboundHeight;
  private int upperboundWidth;
  
  public TPVCodecCapabilityForSet(int paramInt1, int paramInt2)
  {
    this.upperboundWidth = paramInt1;
    this.upperboundHeight = paramInt2;
    this.lowerboundWidth = 0;
    this.lowerboundHeight = 0;
    this.profile = -1;
    this.level = -1;
  }
  
  public TPVCodecCapabilityForSet(int paramInt1, int paramInt2, int paramInt3)
  {
    this.upperboundWidth = paramInt1;
    this.upperboundHeight = paramInt2;
    this.profile = paramInt3;
    this.lowerboundWidth = 0;
    this.lowerboundHeight = 0;
    this.level = -1;
  }
  
  public TPVCodecCapabilityForSet(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.upperboundWidth = paramInt1;
    this.upperboundHeight = paramInt2;
    this.lowerboundWidth = paramInt3;
    this.lowerboundHeight = paramInt4;
    this.profile = paramInt5;
    this.level = paramInt6;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public int getLowerboundHeight()
  {
    return this.lowerboundHeight;
  }
  
  public int getLowerboundWidth()
  {
    return this.lowerboundWidth;
  }
  
  public int getProfile()
  {
    return this.profile;
  }
  
  public int getUpperboundHeight()
  {
    return this.upperboundHeight;
  }
  
  public int getUpperboundWidth()
  {
    return this.upperboundWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForSet
 * JD-Core Version:    0.7.0.1
 */