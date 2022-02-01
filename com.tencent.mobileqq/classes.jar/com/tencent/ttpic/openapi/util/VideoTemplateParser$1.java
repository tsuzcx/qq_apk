package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.Coffee;
import com.tencent.ttpic.util.DecryptListener;

final class VideoTemplateParser$1
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = Coffee.drink(paramArrayOfByte, Coffee.getDefaultSign());
      return paramArrayOfByte;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      LogUtils.e(VideoTemplateParser.access$000(), paramArrayOfByte.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoTemplateParser.1
 * JD-Core Version:    0.7.0.1
 */