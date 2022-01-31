package com.tencent.pts.core.itemview;

import android.support.annotation.Nullable;
import android.text.TextUtils;

public class PTSItemData
{
  public final String TAG = "PTSItemData";
  private String mAppName;
  private String mAppPath;
  private String mItemID;
  private String mJsonData;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof PTSItemData)) {
      return TextUtils.equals(this.mItemID, ((PTSItemData)paramObject).getItemID());
    }
    return false;
  }
  
  public String getAppName()
  {
    return this.mAppName;
  }
  
  public String getAppPath()
  {
    return this.mAppPath;
  }
  
  public String getItemID()
  {
    return this.mItemID;
  }
  
  public String getJSONData()
  {
    return this.mJsonData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemData
 * JD-Core Version:    0.7.0.1
 */