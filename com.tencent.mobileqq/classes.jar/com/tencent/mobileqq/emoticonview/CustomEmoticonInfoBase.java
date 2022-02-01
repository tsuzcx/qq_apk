package com.tencent.mobileqq.emoticonview;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class CustomEmoticonInfoBase
  extends EmoticonInfo
  implements Parcelable
{
  public String eId;
  public String path;
  public String resID;
  public String roamingType;
  public String url;
  
  public CustomEmoticonInfoBase() {}
  
  protected CustomEmoticonInfoBase(Parcel paramParcel)
  {
    super(paramParcel);
    this.eId = paramParcel.readString();
    this.path = paramParcel.readString();
    this.url = paramParcel.readString();
    this.resID = paramParcel.readString();
    this.roamingType = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.eId);
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.resID);
    paramParcel.writeString(this.roamingType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CustomEmoticonInfoBase
 * JD-Core Version:    0.7.0.1
 */