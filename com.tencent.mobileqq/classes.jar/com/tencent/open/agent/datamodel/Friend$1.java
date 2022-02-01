package com.tencent.open.agent.datamodel;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Friend$1
  implements Parcelable.Creator<Friend>
{
  public Friend a(Parcel paramParcel)
  {
    Friend localFriend = new Friend();
    localFriend.a = paramParcel.readString();
    localFriend.b = paramParcel.readString();
    localFriend.c = paramParcel.readString();
    localFriend.d = paramParcel.readString();
    localFriend.e = paramParcel.readInt();
    localFriend.f = paramParcel.readString();
    return localFriend;
  }
  
  public Friend[] a(int paramInt)
  {
    return new Friend[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.Friend.1
 * JD-Core Version:    0.7.0.1
 */