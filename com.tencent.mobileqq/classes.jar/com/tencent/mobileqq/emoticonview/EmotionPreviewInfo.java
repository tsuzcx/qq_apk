package com.tencent.mobileqq.emoticonview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EmotionPreviewInfo
  implements Parcelable
{
  public static final Parcelable.Creator<EmotionPreviewInfo> CREATOR = new EmotionPreviewInfo.1();
  public boolean isCheck;
  public String path;
  
  public EmotionPreviewInfo() {}
  
  public EmotionPreviewInfo(Parcel paramParcel)
  {
    this.path = paramParcel.readString();
    int i = paramParcel.readByte();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.isCheck = bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(" path: ");
    localStringBuilder.append(this.path);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.path);
    paramParcel.writeByte((byte)this.isCheck);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewInfo
 * JD-Core Version:    0.7.0.1
 */