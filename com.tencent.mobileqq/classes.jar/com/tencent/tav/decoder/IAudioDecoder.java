package com.tencent.tav.decoder;

import java.nio.ByteBuffer;

public abstract interface IAudioDecoder
  extends IDecoder
{
  public abstract ByteBuffer outputBuffer();
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.IAudioDecoder
 * JD-Core Version:    0.7.0.1
 */