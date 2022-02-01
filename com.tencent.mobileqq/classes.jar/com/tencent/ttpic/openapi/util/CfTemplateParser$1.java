package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.util.DecryptListener;

final class CfTemplateParser$1
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    DecryptListener localDecryptListener = CfConfig.getDecryptListener();
    byte[] arrayOfByte = paramArrayOfByte;
    if (localDecryptListener != null) {
      arrayOfByte = localDecryptListener.decrypt(paramArrayOfByte);
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.CfTemplateParser.1
 * JD-Core Version:    0.7.0.1
 */