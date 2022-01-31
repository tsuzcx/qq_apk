package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.util.DecryptListener;

public class CfConfig
{
  private static DecryptListener sDecryptListener;
  
  public static DecryptListener getDecryptListener()
  {
    return sDecryptListener;
  }
  
  public static void setDecryptListener(DecryptListener paramDecryptListener)
  {
    sDecryptListener = paramDecryptListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.CfConfig
 * JD-Core Version:    0.7.0.1
 */