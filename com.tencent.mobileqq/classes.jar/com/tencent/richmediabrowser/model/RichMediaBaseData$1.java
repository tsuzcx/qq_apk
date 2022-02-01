package com.tencent.richmediabrowser.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RichMediaBaseData$1
  implements Parcelable.Creator<RichMediaBaseData>
{
  public RichMediaBaseData createFromParcel(Parcel paramParcel)
  {
    Object localObject = paramParcel.readString();
    try
    {
      localObject = RichMediaBaseData.newInstance((String)localObject);
      ((RichMediaBaseData)localObject).readFromParcel(paramParcel);
      return localObject;
    }
    catch (ClassNotFoundException paramParcel)
    {
      throw new RuntimeException(paramParcel);
    }
  }
  
  public RichMediaBaseData[] newArray(int paramInt)
  {
    return new RichMediaBaseData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.RichMediaBaseData.1
 * JD-Core Version:    0.7.0.1
 */