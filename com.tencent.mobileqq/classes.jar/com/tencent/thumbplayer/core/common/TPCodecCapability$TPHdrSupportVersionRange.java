package com.tencent.thumbplayer.core.common;

import java.io.Serializable;

public class TPCodecCapability$TPHdrSupportVersionRange
  implements Serializable
{
  public int lowerboundPatchVersion;
  public int lowerboundSystemVersion;
  public int upperboundPatchVersion;
  public int upperboundSystemVersion;
  
  public TPCodecCapability$TPHdrSupportVersionRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.upperboundSystemVersion = paramInt1;
    this.lowerboundSystemVersion = paramInt2;
    this.upperboundPatchVersion = paramInt3;
    this.lowerboundPatchVersion = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecCapability.TPHdrSupportVersionRange
 * JD-Core Version:    0.7.0.1
 */