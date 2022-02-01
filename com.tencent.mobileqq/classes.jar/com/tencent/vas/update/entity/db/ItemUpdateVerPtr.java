package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import org.json.JSONObject;

public class ItemUpdateVerPtr
{
  private static final String TAG = "VasUpdate_ItemUpdateVerPtr";
  public String mAppVersion = "";
  public String mDstMd5;
  public String mFrom;
  public String mItemId;
  public long mLastRunTime;
  public int mRunCount;
  public String mSrcMd5;
  
  public static String convertItemUpdateVerPrtToJson(ItemUpdateVerPtr paramItemUpdateVerPtr)
  {
    if (paramItemUpdateVerPtr == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("itemId", paramItemUpdateVerPtr.mItemId);
      localJSONObject.put("srcMd5", paramItemUpdateVerPtr.mSrcMd5);
      localJSONObject.put("dstMd5", paramItemUpdateVerPtr.mDstMd5);
      localJSONObject.put("from", paramItemUpdateVerPtr.mFrom);
      localJSONObject.put("nLastRunTime", paramItemUpdateVerPtr.mLastRunTime);
      localJSONObject.put("nRunCount", paramItemUpdateVerPtr.mRunCount);
      localJSONObject.put("appVersion", paramItemUpdateVerPtr.mAppVersion);
      return localJSONObject.toString();
    }
    catch (Exception paramItemUpdateVerPtr)
    {
      for (;;)
      {
        paramItemUpdateVerPtr.printStackTrace();
        VasUpdateWrapper.getLog().e("VasUpdate_ItemUpdateVerPtr", "node ItemUpdate error ", paramItemUpdateVerPtr);
      }
    }
  }
  
  public static ItemUpdateVerPtr parseJsonToItemUpdateVerPrt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        ItemUpdateVerPtr localItemUpdateVerPtr = new ItemUpdateVerPtr();
        paramString = new JSONObject(paramString);
        if (paramString.opt("nodeList") == null)
        {
          localItemUpdateVerPtr.mItemId = paramString.optString("itemId");
          localItemUpdateVerPtr.mSrcMd5 = paramString.optString("srcMd5");
          localItemUpdateVerPtr.mDstMd5 = paramString.optString("dstMd5");
          localItemUpdateVerPtr.mFrom = paramString.optString("from");
          localItemUpdateVerPtr.mLastRunTime = paramString.optLong("nLastRunTime");
          localItemUpdateVerPtr.mRunCount = paramString.optInt("nRunCount");
          localItemUpdateVerPtr.mAppVersion = paramString.optString("appVersion");
          return localItemUpdateVerPtr;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        VasUpdateWrapper.getLog().e("VasUpdate_ItemUpdateVerPtr", "node ItemUpdate error ", paramString);
      }
    }
    return null;
  }
  
  public boolean checkItemIsCurrentVersion()
  {
    String str = VasUpdateWrapper.getCommonManager().getAppVersion();
    VasUpdateWrapper.getLog().e("VasUpdate_ItemUpdateVerPtr", "checkItemIsCurrentVersion itemId = " + this.mItemId + " localVersion = " + str + " itemVersion = " + this.mAppVersion);
    if (TextUtils.isEmpty(this.mAppVersion)) {}
    while ((str == null) || (str.compareTo(this.mAppVersion) >= 0)) {
      return true;
    }
    return false;
  }
  
  @NonNull
  public String toString()
  {
    return " itemId = " + this.mItemId + " mLastRunTime = " + this.mLastRunTime + " count = " + this.mRunCount + " from = " + this.mFrom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.entity.db.ItemUpdateVerPtr
 * JD-Core Version:    0.7.0.1
 */