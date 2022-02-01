package com.tencent.tav.coremedia;

import java.nio.ByteBuffer;

public abstract interface IAVResample
{
  public abstract void release();
  
  public abstract byte[] resample(ByteBuffer paramByteBuffer, int paramInt);
  
  public abstract void updateSrcFormat(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.coremedia.IAVResample
 * JD-Core Version:    0.7.0.1
 */