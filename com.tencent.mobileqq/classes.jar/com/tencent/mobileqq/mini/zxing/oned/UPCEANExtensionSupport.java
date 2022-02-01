package com.tencent.mobileqq.mini.zxing.oned;

import com.tencent.mobileqq.mini.zxing.ReaderException;
import com.tencent.mobileqq.mini.zxing.Result;
import com.tencent.mobileqq.mini.zxing.common.BitArray;

final class UPCEANExtensionSupport
{
  private static final int[] EXTENSION_START_PATTERN = { 1, 1, 2 };
  private final UPCEANExtension5Support fiveSupport = new UPCEANExtension5Support();
  private final UPCEANExtension2Support twoSupport = new UPCEANExtension2Support();
  
  Result decodeRow(int paramInt1, BitArray paramBitArray, int paramInt2)
  {
    int[] arrayOfInt = UPCEANReader.findGuardPattern(paramBitArray, paramInt2, false, EXTENSION_START_PATTERN);
    try
    {
      Result localResult = this.fiveSupport.decodeRow(paramInt1, paramBitArray, arrayOfInt);
      return localResult;
    }
    catch (ReaderException localReaderException)
    {
      label27:
      break label27;
    }
    return this.twoSupport.decodeRow(paramInt1, paramBitArray, arrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.UPCEANExtensionSupport
 * JD-Core Version:    0.7.0.1
 */