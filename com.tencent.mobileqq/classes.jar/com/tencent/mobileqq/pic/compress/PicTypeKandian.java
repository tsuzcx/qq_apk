package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class PicTypeKandian
  extends PicTypeNormal
{
  PicTypeKandian(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int c()
  {
    return 80;
  }
  
  protected final int[] g()
  {
    if (this.l.p == 2) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 2560;
    arrayOfInt[1] = (arrayOfInt[0] * 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PicType.SendPhotoMaxLongSide = ");
    localStringBuilder.append(arrayOfInt[0]);
    Logger.a("PicTypeNormal", "getScaleLargerSide", localStringBuilder.toString());
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicTypeKandian
 * JD-Core Version:    0.7.0.1
 */