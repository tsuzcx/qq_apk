package com.tencent.vbox;

import com.tencent.vbox.decode.VboxDecoder;
import com.tencent.vbox.decode.VboxHardDecoder;
import com.tencent.vbox.decode.VboxRgbDecoder;
import com.tencent.vbox.encode.VboxEncoder;
import com.tencent.vbox.encode.VboxHardEncoder;
import com.tencent.vbox.encode.VboxSoftEncoder;

public class VboxFactory
{
  public static final int HARD = 1;
  public static final int SOFT = 2;
  
  public static VboxDecoder createDecoder(String paramString, int paramInt)
  {
    if (paramInt == 1) {
      return new VboxHardDecoder(paramString);
    }
    return new VboxRgbDecoder(paramString);
  }
  
  public static VboxEncoder createEncoder(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 1) {
      return new VboxHardEncoder(paramString, paramInt1, paramInt2);
    }
    return new VboxSoftEncoder(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.VboxFactory
 * JD-Core Version:    0.7.0.1
 */