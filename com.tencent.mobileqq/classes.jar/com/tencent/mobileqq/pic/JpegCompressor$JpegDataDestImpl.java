package com.tencent.mobileqq.pic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

class JpegCompressor$JpegDataDestImpl
  implements JpegDataDest
{
  private FileOutputStream writer = null;
  
  public JpegCompressor$JpegDataDestImpl(String paramString)
  {
    paramString = new File(paramString);
    try
    {
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      this.writer = new FileOutputStream(paramString);
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void dataArrived(ByteBuffer paramByteBuffer, boolean paramBoolean, Object paramObject)
  {
    try
    {
      paramObject = new byte[paramByteBuffer.capacity()];
      paramByteBuffer.get(paramObject);
      this.writer.write(paramObject, 0, paramObject.length);
      if (!paramBoolean) {}
    }
    catch (Exception paramByteBuffer)
    {
      for (;;)
      {
        try
        {
          this.writer.close();
          return;
        }
        catch (IOException paramByteBuffer)
        {
          paramByteBuffer.printStackTrace();
        }
        paramByteBuffer = paramByteBuffer;
        paramByteBuffer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegCompressor.JpegDataDestImpl
 * JD-Core Version:    0.7.0.1
 */