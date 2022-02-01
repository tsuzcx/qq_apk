package com.tencent.mqp.app.dbfs;

import java.io.ByteArrayOutputStream;

public class DBStoredFile$FileOutputStream
  extends ByteArrayOutputStream
{
  public void close()
  {
    flush();
  }
  
  public void flush()
  {
    this.a.a(toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBStoredFile.FileOutputStream
 * JD-Core Version:    0.7.0.1
 */