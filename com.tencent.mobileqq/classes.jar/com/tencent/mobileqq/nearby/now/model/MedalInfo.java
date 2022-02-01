package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class MedalInfo
  implements Parcelable
{
  public static final Parcelable.Creator<MedalInfo> CREATOR = new MedalInfo.1();
  public int a;
  public int b;
  public int c;
  public List<MedalItem> d = new ArrayList();
  
  public MedalInfo() {}
  
  protected MedalInfo(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    paramParcel.readTypedList(this.d, MedalItem.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MedalInfo)) {}
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    List localList = this.d;
    if (localList != null) {
      paramParcel.writeTypedList(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.MedalInfo
 * JD-Core Version:    0.7.0.1
 */