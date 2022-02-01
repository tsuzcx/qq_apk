package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class PicTypeTroopBar
  extends PicTypeNormal
{
  PicTypeTroopBar(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a()
  {
    if (this.a.g == 2) {
      return 100;
    }
    int i = this.a.h;
    if (i != 1)
    {
      if (i != 4) {}
      return 85;
    }
    return 90;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeTroopBar
 * JD-Core Version:    0.7.0.1
 */