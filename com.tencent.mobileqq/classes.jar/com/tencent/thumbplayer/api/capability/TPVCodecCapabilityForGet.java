package com.tencent.thumbplayer.api.capability;

public class TPVCodecCapabilityForGet
{
  public int maxFramerateFormaxLumaSamples;
  private int maxLevel;
  private int maxLumaSamples;
  private int maxProfile;
  
  public TPVCodecCapabilityForGet(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.maxLumaSamples = paramInt1;
    this.maxProfile = paramInt2;
    this.maxLevel = paramInt3;
    this.maxFramerateFormaxLumaSamples = paramInt4;
  }
  
  public int getMaxFramerateFormaxLumaSamples()
  {
    return this.maxFramerateFormaxLumaSamples;
  }
  
  public int getMaxLevel()
  {
    return this.maxLevel;
  }
  
  public int getMaxLumaSamples()
  {
    return this.maxLumaSamples;
  }
  
  public int getMaxProfile()
  {
    return this.maxProfile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForGet
 * JD-Core Version:    0.7.0.1
 */