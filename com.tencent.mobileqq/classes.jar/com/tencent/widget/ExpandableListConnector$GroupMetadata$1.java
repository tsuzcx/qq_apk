package com.tencent.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ExpandableListConnector$GroupMetadata$1
  implements Parcelable.Creator<ExpandableListConnector.GroupMetadata>
{
  public ExpandableListConnector.GroupMetadata createFromParcel(Parcel paramParcel)
  {
    return ExpandableListConnector.GroupMetadata.obtain(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readLong());
  }
  
  public ExpandableListConnector.GroupMetadata[] newArray(int paramInt)
  {
    return new ExpandableListConnector.GroupMetadata[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector.GroupMetadata.1
 * JD-Core Version:    0.7.0.1
 */