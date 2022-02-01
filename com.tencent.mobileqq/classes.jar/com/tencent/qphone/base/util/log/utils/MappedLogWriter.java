package com.tencent.qphone.base.util.log.utils;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedLogWriter
{
  private static final String TAG = "MappedLogWriter";
  FileOutputStream fileOutputStream;
  
  public MappedLogWriter(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.createNewFile();
    }
    this.fileOutputStream = new FileOutputStream(paramString, true);
  }
  
  public void close()
  {
    FileOutputStream localFileOutputStream = this.fileOutputStream;
    if (localFileOutputStream != null) {
      localFileOutputStream.close();
    }
  }
  
  public void writeThroughByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return;
      }
      try
      {
        this.fileOutputStream.getChannel().write(ByteBuffer.wrap(paramArrayOfByte));
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        Log.e("MappedLogWriter", "writeThroughByteArray failed. ", paramArrayOfByte);
      }
    }
  }
  
  public void writeThroughMmapBuffer(MappedByteBuffer paramMappedByteBuffer)
  {
    try
    {
      this.fileOutputStream.getChannel().write(paramMappedByteBuffer);
      return;
    }
    catch (IOException paramMappedByteBuffer)
    {
      paramMappedByteBuffer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.utils.MappedLogWriter
 * JD-Core Version:    0.7.0.1
 */