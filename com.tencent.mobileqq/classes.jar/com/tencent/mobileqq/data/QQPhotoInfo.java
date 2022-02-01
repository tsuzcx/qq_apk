package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class QQPhotoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QQPhotoInfo> CREATOR = new QQPhotoInfo.1();
  private static List<WeakReference<QQPhotoInfo>> photoInfoCache = new ArrayList();
  private long id;
  private String mPath;
  private int selectStatus;
  
  private QQPhotoInfo(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.mPath = paramParcel.readString();
    this.selectStatus = paramParcel.readInt();
  }
  
  private boolean compare(QQPhotoInfo paramQQPhotoInfo)
  {
    return this.mPath.equals(paramQQPhotoInfo.mPath);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof QQPhotoInfo))) {
      return compare((QQPhotoInfo)paramObject);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.mPath.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.mPath);
    paramParcel.writeInt(this.selectStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQPhotoInfo
 * JD-Core Version:    0.7.0.1
 */