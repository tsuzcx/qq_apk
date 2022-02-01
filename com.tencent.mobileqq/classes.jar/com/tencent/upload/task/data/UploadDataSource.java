package com.tencent.upload.task.data;

import android.os.Parcelable;

public abstract class UploadDataSource
  implements Parcelable
{
  public abstract String calcSha1();
  
  public abstract boolean exists();
  
  public abstract long getDataLength();
  
  public boolean isValid()
  {
    return getDataLength() > 0L;
  }
  
  public abstract long readData(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.task.data.UploadDataSource
 * JD-Core Version:    0.7.0.1
 */