package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class DiskCache$Editor
{
  File dirtyFile;
  private String key;
  
  DiskCache$Editor(DiskCache paramDiskCache, String paramString)
  {
    if (!paramDiskCache.directory.exists()) {
      paramDiskCache.directory.mkdirs();
    }
    this.key = paramString;
    this.dirtyFile = new File(paramDiskCache.directory, paramString + ".tmp");
  }
  
  void abort(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.dirtyFile.length() <= 0L))
    {
      this.dirtyFile.delete();
      QLog.d("DiskCache", 2, "dirtyFile delete as abort: " + this.dirtyFile.getPath());
    }
  }
  
  File commit()
  {
    File localFile = this.this$0.getCleanFile(this.key);
    if (localFile.exists()) {
      return localFile;
    }
    if ((!this.dirtyFile.exists()) || (this.dirtyFile.length() <= 0L))
    {
      QLog.d("DiskCache", 2, "dirtyFile delete: " + this.dirtyFile.getPath());
      this.dirtyFile.delete();
      throw new IOException("write 0 length file or null File");
    }
    QLog.d("DiskCache", 2, "dirtyFile rename: " + this.dirtyFile.getPath());
    this.dirtyFile.renameTo(localFile);
    return localFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DiskCache.Editor
 * JD-Core Version:    0.7.0.1
 */