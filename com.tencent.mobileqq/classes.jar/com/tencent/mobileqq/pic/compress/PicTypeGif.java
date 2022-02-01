package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class PicTypeGif
  extends PicType
{
  PicTypeGif(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a(CompressInfo paramCompressInfo)
  {
    return 2;
  }
  
  protected boolean f()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeGif
 * JD-Core Version:    0.7.0.1
 */