package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;

public class PicTypeKandian
  extends PicTypeNormal
{
  PicTypeKandian(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a()
  {
    return 80;
  }
  
  protected final int[] a()
  {
    if (this.a.g == 2) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 2560;
    arrayOfInt[1] = (arrayOfInt[0] * 2);
    Logger.a("PicTypeNormal", "getScaleLargerSide", "PicType.SendPhotoMaxLongSide = " + arrayOfInt[0]);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeKandian
 * JD-Core Version:    0.7.0.1
 */