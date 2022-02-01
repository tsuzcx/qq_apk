package com.tencent.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ExpandableListConnector$GroupMetadata
  implements Parcelable, Comparable<GroupMetadata>
{
  public static final Parcelable.Creator<GroupMetadata> CREATOR = new ExpandableListConnector.GroupMetadata.1();
  static final int REFRESH = -1;
  int flPos;
  long gId;
  int gPos;
  int lastChildFlPos;
  
  static GroupMetadata obtain(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    GroupMetadata localGroupMetadata = new GroupMetadata();
    localGroupMetadata.flPos = paramInt1;
    localGroupMetadata.lastChildFlPos = paramInt2;
    localGroupMetadata.gPos = paramInt3;
    localGroupMetadata.gId = paramLong;
    return localGroupMetadata;
  }
  
  public int compareTo(GroupMetadata paramGroupMetadata)
  {
    if (paramGroupMetadata != null) {
      return this.gPos - paramGroupMetadata.gPos;
    }
    throw new IllegalArgumentException();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.flPos);
    paramParcel.writeInt(this.lastChildFlPos);
    paramParcel.writeInt(this.gPos);
    paramParcel.writeLong(this.gId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector.GroupMetadata
 * JD-Core Version:    0.7.0.1
 */