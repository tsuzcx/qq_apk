package com.tencent.ttpic.filter.aifilter;

import com.tencent.ttpic.openapi.util.CfConfig;
import com.tencent.ttpic.util.DecryptListener;

final class MultiFilterParamConnect$2
  implements DecryptListener
{
  public byte[] decrypt(byte[] paramArrayOfByte)
  {
    return CfConfig.getDecryptListener().decrypt(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.MultiFilterParamConnect.2
 * JD-Core Version:    0.7.0.1
 */