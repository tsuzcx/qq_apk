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
    paramDiskCache = paramDiskCache.directory;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".tmp");
    this.dirtyFile = new File(paramDiskCache, localStringBuilder.toString());
  }
  
  void abort(boolean paramBoolean)
  {
    if ((!paramBoolean) || (this.dirtyFile.length() <= 0L))
    {
      this.dirtyFile.delete();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dirtyFile delete as abort: ");
      localStringBuilder.append(this.dirtyFile.getPath());
      QLog.d("DiskCache", 2, localStringBuilder.toString());
    }
  }
  
  File commit()
  {
    Object localObject = this.this$0.getCleanFile(this.key);
    if (((File)localObject).exists()) {
      return localObject;
    }
    if ((this.dirtyFile.exists()) && (this.dirtyFile.length() > 0L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dirtyFile rename: ");
      localStringBuilder.append(this.dirtyFile.getPath());
      QLog.d("DiskCache", 2, localStringBuilder.toString());
      this.dirtyFile.renameTo((File)localObject);
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dirtyFile delete: ");
    ((StringBuilder)localObject).append(this.dirtyFile.getPath());
    QLog.d("DiskCache", 2, ((StringBuilder)localObject).toString());
    this.dirtyFile.delete();
    throw new IOException("write 0 length file or null File");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.DiskCache.Editor
 * JD-Core Version:    0.7.0.1
 */