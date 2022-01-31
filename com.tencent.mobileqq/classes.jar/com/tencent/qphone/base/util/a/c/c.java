package com.tencent.qphone.base.util.a.c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class c
{
  FileOutputStream a;
  
  public c(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.createNewFile();
    }
    this.a = new FileOutputStream(paramString, true);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.close();
    }
  }
  
  public void a(MappedByteBuffer paramMappedByteBuffer)
  {
    try
    {
      this.a.getChannel().write(paramMappedByteBuffer);
      return;
    }
    catch (IOException paramMappedByteBuffer)
    {
      paramMappedByteBuffer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.c.c
 * JD-Core Version:    0.7.0.1
 */