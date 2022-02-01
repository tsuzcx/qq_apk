package com.tencent.tbs.log.file;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class FilePrinter$Writer
{
  private File mLogFile;
  private String mLogFileName;
  private OutputStream mOutputStream;
  
  private FilePrinter$Writer(FilePrinter paramFilePrinter) {}
  
  void appendLog(String paramString)
  {
    if (this.mOutputStream != null) {}
    for (;;)
    {
      try
      {
        if (FilePrinter.access$400(this.this$0))
        {
          String str = Encryption.createKeyOfPlainText();
          byte[] arrayOfByte = Encryption.getEncryptedKeyBytes("tbslog.txt", str);
          if (arrayOfByte != null)
          {
            paramString = Encryption.getEncryptedLogBytes(str, paramString, arrayOfByte);
            if (paramString != null) {
              this.mOutputStream.write(paramString);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (this.mOutputStream == null) {
          continue;
        }
        try
        {
          this.mOutputStream.flush();
          return;
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      finally
      {
        if (this.mOutputStream == null) {
          break label134;
        }
      }
      try
      {
        this.mOutputStream.flush();
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (!TextUtils.isEmpty(paramString)) {
        this.mOutputStream.write(paramString.getBytes());
      }
    }
    try
    {
      this.mOutputStream.flush();
      label134:
      throw paramString;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  boolean close()
  {
    if (this.mOutputStream != null) {}
    try
    {
      this.mOutputStream.close();
      return true;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return false;
    }
    finally
    {
      this.mOutputStream = null;
      this.mLogFile = null;
    }
  }
  
  File getFile()
  {
    return this.mLogFile;
  }
  
  String getFileName()
  {
    return this.mLogFileName;
  }
  
  boolean isOpened()
  {
    return this.mOutputStream != null;
  }
  
  boolean open(String paramString)
  {
    this.mLogFileName = paramString;
    this.mLogFile = new File(FilePrinter.access$300(this.this$0), paramString);
    if (!this.mLogFile.exists()) {}
    try
    {
      paramString = this.mLogFile.getParentFile();
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      this.mLogFile.createNewFile();
      return false;
    }
    catch (IOException paramString)
    {
      try
      {
        this.mOutputStream = new BufferedOutputStream(new FileOutputStream(this.mLogFile, true));
        return true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.mLogFile = null;
      }
      paramString = paramString;
      paramString.printStackTrace();
      this.mLogFile = null;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.log.file.FilePrinter.Writer
 * JD-Core Version:    0.7.0.1
 */