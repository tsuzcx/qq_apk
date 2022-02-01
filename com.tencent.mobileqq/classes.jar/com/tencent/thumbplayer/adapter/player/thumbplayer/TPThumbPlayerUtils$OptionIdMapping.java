package com.tencent.thumbplayer.adapter.player.thumbplayer;

public class TPThumbPlayerUtils$OptionIdMapping
{
  private final int nativePlayerOptionalID;
  private final int optionalIDType;
  
  public TPThumbPlayerUtils$OptionIdMapping()
  {
    this.optionalIDType = -1;
    this.nativePlayerOptionalID = -1;
  }
  
  public TPThumbPlayerUtils$OptionIdMapping(int paramInt1, int paramInt2)
  {
    this.optionalIDType = paramInt1;
    this.nativePlayerOptionalID = paramInt2;
  }
  
  public int getNativePlayerOptionalID()
  {
    return this.nativePlayerOptionalID;
  }
  
  public int getOptionalIDType()
  {
    return this.optionalIDType;
  }
  
  public boolean isIllegal()
  {
    return (this.optionalIDType == -1) || (this.nativePlayerOptionalID == -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils.OptionIdMapping
 * JD-Core Version:    0.7.0.1
 */