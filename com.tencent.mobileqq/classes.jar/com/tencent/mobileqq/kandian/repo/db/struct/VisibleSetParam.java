package com.tencent.mobileqq.kandian.repo.db.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VisibleSetParam
  implements Parcelable
{
  public static final Parcelable.Creator<VisibleSetParam> CREATOR = new VisibleSetParam.1();
  public static VisibleSetParam a = new VisibleSetParam(0, Collections.emptyList());
  public static VisibleSetParam b = new VisibleSetParam(2, Collections.emptyList());
  private final int c;
  private final List<Long> d;
  
  public VisibleSetParam(int paramInt, @NonNull List<Long> paramList)
  {
    this.c = paramInt;
    this.d = paramList;
  }
  
  protected VisibleSetParam(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.d = new ArrayList();
    paramParcel.readList(this.d, Long.class.getClassLoader());
  }
  
  public int a()
  {
    return this.c;
  }
  
  public List<Long> b()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VisibleSetParam{visible_type=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", uinWhiteList=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeList(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.VisibleSetParam
 * JD-Core Version:    0.7.0.1
 */