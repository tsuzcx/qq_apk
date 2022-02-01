package com.tencent.mobileqq.search.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AssociateSearchWordsFragment$AssociateItem
  implements Parcelable
{
  public static final Parcelable.Creator<AssociateItem> CREATOR = new AssociateSearchWordsFragment.AssociateItem.1();
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public int g;
  public String h;
  public int i;
  
  public AssociateSearchWordsFragment$AssociateItem() {}
  
  public AssociateSearchWordsFragment$AssociateItem(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readString();
    this.i = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeInt(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateItem
 * JD-Core Version:    0.7.0.1
 */