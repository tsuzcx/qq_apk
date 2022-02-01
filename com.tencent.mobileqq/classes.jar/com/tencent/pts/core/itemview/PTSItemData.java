package com.tencent.pts.core.itemview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public class PTSItemData
  implements Parcelable
{
  public static final Parcelable.Creator<PTSItemData> CREATOR = new PTSItemData.1();
  public static final String TAG = "PTSItemData";
  private String frameTreeJson;
  private String itemId;
  private String jsonData;
  private String pageJs;
  private String pageName;
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof PTSItemData)) {
      return (TextUtils.equals(this.itemId, ((PTSItemData)paramObject).getItemID())) && (TextUtils.equals(this.jsonData, ((PTSItemData)paramObject).getJSONData()));
    }
    return false;
  }
  
  public String getFrameTreeJson()
  {
    return this.frameTreeJson;
  }
  
  public String getItemID()
  {
    return this.itemId;
  }
  
  public String getJSONData()
  {
    return this.jsonData;
  }
  
  public String getPageJs()
  {
    return this.pageJs;
  }
  
  public String getPageName()
  {
    return this.pageName;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.itemId);
    paramParcel.writeString(this.pageName);
    paramParcel.writeString(this.jsonData);
    paramParcel.writeString(this.frameTreeJson);
    paramParcel.writeString(this.pageJs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemData
 * JD-Core Version:    0.7.0.1
 */