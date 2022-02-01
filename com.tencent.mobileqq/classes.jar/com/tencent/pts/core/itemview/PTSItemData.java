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
    boolean bool3 = paramObject instanceof PTSItemData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      String str = this.itemId;
      paramObject = (PTSItemData)paramObject;
      bool1 = bool2;
      if (TextUtils.equals(str, paramObject.getItemID()))
      {
        bool1 = bool2;
        if (TextUtils.equals(this.jsonData, paramObject.getJSONData())) {
          bool1 = true;
        }
      }
    }
    return bool1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemData
 * JD-Core Version:    0.7.0.1
 */