package com.tencent.mobileqq.phonecontact.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class RecommendedListResp
  implements Parcelable
{
  public static final Parcelable.Creator<RecommendedListResp> CREATOR = new RecommendedListResp.1();
  public int a;
  public int b;
  public long c;
  public List<PhoneInfo> d = new ArrayList();
  
  public RecommendedListResp() {}
  
  protected RecommendedListResp(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readLong();
    this.d = paramParcel.createTypedArrayList(PhoneInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeTypedList(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.data.RecommendedListResp
 * JD-Core Version:    0.7.0.1
 */