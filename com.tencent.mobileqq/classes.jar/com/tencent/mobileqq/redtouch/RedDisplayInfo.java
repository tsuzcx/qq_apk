package com.tencent.mobileqq.redtouch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class RedDisplayInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RedDisplayInfo> CREATOR = new RedDisplayInfo.1();
  ArrayList<RedTypeInfo> a;
  private RedTypeInfo b;
  
  public List<RedTypeInfo> a()
  {
    return this.a;
  }
  
  public void a(RedTypeInfo paramRedTypeInfo)
  {
    this.b = paramRedTypeInfo;
  }
  
  public void a(ArrayList<RedTypeInfo> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public RedTypeInfo b()
  {
    return this.b;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
    paramParcel.writeSerializable(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedDisplayInfo
 * JD-Core Version:    0.7.0.1
 */