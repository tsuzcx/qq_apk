package com.tencent.mobileqq.service.friendlist.remote;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class FriendListInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FriendListInfo> CREATOR = new FriendListInfo.1();
  public int a;
  public List<FriendSingleInfo> b;
  
  public FriendListInfo()
  {
    this.a = 0;
    this.b = new ArrayList();
  }
  
  public FriendListInfo(Parcel paramParcel)
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
      FriendSingleInfo localFriendSingleInfo = new FriendSingleInfo();
      localFriendSingleInfo.a(paramParcel);
      this.b.add(localFriendSingleInfo);
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
    int i = 0;
    while (i < this.b.size())
    {
      ((FriendSingleInfo)this.b.get(i)).writeToParcel(paramParcel, paramInt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.remote.FriendListInfo
 * JD-Core Version:    0.7.0.1
 */