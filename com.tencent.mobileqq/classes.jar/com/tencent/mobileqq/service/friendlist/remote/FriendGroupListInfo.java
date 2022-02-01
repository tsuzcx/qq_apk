package com.tencent.mobileqq.service.friendlist.remote;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class FriendGroupListInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FriendGroupListInfo> CREATOR = new FriendGroupListInfo.1();
  public int a;
  public List<FriendGroupInfo> b;
  
  public FriendGroupListInfo()
  {
    this.a = 0;
    this.b = new ArrayList();
  }
  
  public FriendGroupListInfo(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    int j = paramParcel.readInt();
    this.b = new ArrayList();
    int i = 0;
    while (i < j)
    {
      FriendGroupInfo localFriendGroupInfo = new FriendGroupInfo();
      localFriendGroupInfo.b(paramParcel);
      this.b.add(localFriendGroupInfo);
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b.size());
    paramInt = 0;
    while (paramInt < this.b.size())
    {
      ((FriendGroupInfo)this.b.get(paramInt)).a(paramParcel);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.remote.FriendGroupListInfo
 * JD-Core Version:    0.7.0.1
 */