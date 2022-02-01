package com.tencent.thumbplayer.core.common;

import java.io.Serializable;

final class TPMediaDecoderInfo$DecoderProfileLevel
  implements Serializable
{
  public int level;
  public int profile;
  
  public TPMediaDecoderInfo$DecoderProfileLevel(TPMediaDecoderInfo paramTPMediaDecoderInfo, int paramInt1, int paramInt2)
  {
    this.profile = paramInt1;
    this.level = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPMediaDecoderInfo.DecoderProfileLevel
 * JD-Core Version:    0.7.0.1
 */