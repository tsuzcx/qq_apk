package com.tencent.pts.core.itemview;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PTSItemData$1
  implements Parcelable.Creator<PTSItemData>
{
  public PTSItemData createFromParcel(Parcel paramParcel)
  {
    return new PTSItemData.Builder().withItemID(paramParcel.readString()).withPageName(paramParcel.readString()).withJsonData(paramParcel.readString()).withFrameTreeJson(paramParcel.readString()).withPageJs(paramParcel.readString()).build();
  }
  
  public PTSItemData[] newArray(int paramInt)
  {
    return new PTSItemData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemData.1
 * JD-Core Version:    0.7.0.1
 */