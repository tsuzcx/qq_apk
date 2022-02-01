package com.tencent.open.agent.datamodel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Friend
  implements Parcelable
{
  public static final Parcelable.Creator<Friend> CREATOR = new Friend.1();
  public String a;
  public String b;
  public String c;
  public String d;
  public int e = -1;
  public String f;
  public int g;
  public int h;
  public String i;
  public String j;
  
  public Friend()
  {
    this.b = "";
    this.c = "";
    this.d = "";
    this.g = -1;
    this.h = -1;
    this.i = "";
    this.j = "";
  }
  
  public Friend(Friend paramFriend)
  {
    this.a = paramFriend.a;
    this.b = paramFriend.b;
    this.c = paramFriend.c;
    this.d = paramFriend.d;
    this.g = paramFriend.g;
    this.h = paramFriend.h;
    this.i = paramFriend.i;
    this.j = paramFriend.j;
    this.e = paramFriend.e;
    this.f = paramFriend.f;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (Friend)paramObject;
    String str = this.a;
    if (str != null) {
      return str.equals(paramObject.a);
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.a;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.Friend
 * JD-Core Version:    0.7.0.1
 */