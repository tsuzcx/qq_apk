package com.tencent.upload.task.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.upload.utils.FileUtils;

public class UploadDataSource$ByteDataSource
  extends UploadDataSource
{
  public static final Parcelable.Creator<ByteDataSource> CREATOR = new UploadDataSource.ByteDataSource.1();
  private byte[] mData;
  
  public UploadDataSource$ByteDataSource(Parcel paramParcel)
  {
    int j = (int)paramParcel.readLong();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    this.mData = new byte[i];
    paramParcel.readByteArray(this.mData);
  }
  
  public UploadDataSource$ByteDataSource(byte[] paramArrayOfByte)
  {
    this.mData = paramArrayOfByte;
  }
  
  public String calcSha1()
  {
    return FileUtils.getFileSha1(this.mData);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean exists()
  {
    return this.mData != null;
  }
  
  public long getDataLength()
  {
    byte[] arrayOfByte = this.mData;
    if (arrayOfByte != null) {
      return arrayOfByte.length;
    }
    return 0L;
  }
  
  public long readData(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    System.arraycopy(this.mData, (int)paramLong, paramArrayOfByte, paramInt2, paramInt1);
    return paramInt1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Byte:,Size:");
    localStringBuilder.append(getDataLength());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(getDataLength());
    paramParcel.writeByteArray(this.mData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.task.data.UploadDataSource.ByteDataSource
 * JD-Core Version:    0.7.0.1
 */