package com.tencent.qphone.base.util.log.processor;

import android.annotation.TargetApi;
import java.util.zip.Deflater;

public class DeflateCompressor
  implements IByteProcessor
{
  private static final int DEFLATE_OFFSET = 10;
  private final boolean compress;
  Deflater deflater = new Deflater();
  public ProcessByteData out = new ProcessByteData(2058);
  
  public DeflateCompressor(boolean paramBoolean)
  {
    this.compress = paramBoolean;
    this.deflater.setStrategy(1);
    this.deflater.setLevel(1);
  }
  
  @TargetApi(19)
  public ProcessByteData handleData(ProcessByteData paramProcessByteData)
  {
    ProcessByteData localProcessByteData = paramProcessByteData;
    if (this.compress)
    {
      this.deflater.setInput(paramProcessByteData.bytes, paramProcessByteData.offset, paramProcessByteData.length);
      this.out.length = this.deflater.deflate(this.out.bytes, 0, this.out.capacity, 2);
      this.out.offset = 0;
      localProcessByteData = this.out;
    }
    return localProcessByteData;
  }
  
  public void reset()
  {
    this.deflater.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.processor.DeflateCompressor
 * JD-Core Version:    0.7.0.1
 */