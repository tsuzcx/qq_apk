package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FileInfo$1
  implements Parcelable.Creator<FileInfo>
{
  public FileInfo a(Parcel paramParcel)
  {
    return new FileInfo(paramParcel, null);
  }
  
  public FileInfo[] a(int paramInt)
  {
    return new FileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileInfo.1
 * JD-Core Version:    0.7.0.1
 */