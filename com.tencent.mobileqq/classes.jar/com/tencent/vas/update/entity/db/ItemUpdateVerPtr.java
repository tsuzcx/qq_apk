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
    }
    catch (Exception paramItemUpdateVerPtr)
    {
      paramItemUpdateVerPtr.printStackTrace();
      VasUpdateWrapper.getLog().e("VasUpdate_ItemUpdateVerPtr", "node ItemUpdate error ", paramItemUpdateVerPtr);
    }
    return localJSONObject.toString();
  }
  
  public static ItemUpdateVerPtr parseJsonToItemUpdateVerPrt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      ItemUpdateVerPtr localItemUpdateVerPtr = new ItemUpdateVerPtr();
      paramString = new JSONObject(paramString);
      if (paramString.opt("nodeList") != null) {
        return null;
      }
      localItemUpdateVerPtr.mItemId = paramString.optString("itemId");
      localItemUpdateVerPtr.mSrcMd5 = paramString.optString("srcMd5");
      localItemUpdateVerPtr.mDstMd5 = paramString.optString("dstMd5");
      localItemUpdateVerPtr.mFrom = paramString.optString("from");
      localItemUpdateVerPtr.mLastRunTime = paramString.optLong("nLastRunTime");
      localItemUpdateVerPtr.mRunCount = paramString.optInt("nRunCount");
      localItemUpdateVerPtr.mAppVersion = paramString.optString("appVersion");
      return localItemUpdateVerPtr;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      VasUpdateWrapper.getLog().e("VasUpdate_ItemUpdateVerPtr", "node ItemUpdate error ", paramString);
    }
    return null;
  }
  
  public boolean checkItemIsCurrentVersion()
  {
    String str = VasUpdateWrapper.getCommonManager().getAppVersion();
    IVasLog localIVasLog = VasUpdateWrapper.getLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkItemIsCurrentVersion itemId = ");
    localStringBuilder.append(this.mItemId);
    localStringBuilder.append(" localVersion = ");
    localStringBuilder.append(str);
    localStringBuilder.append(" itemVersion = ");
    localStringBuilder.append(this.mAppVersion);
    localIVasLog.e("VasUpdate_ItemUpdateVerPtr", localStringBuilder.toString());
    if (TextUtils.isEmpty(this.mAppVersion)) {
      return true;
    }
    return (str == null) || (str.compareTo(this.mAppVersion) >= 0);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" itemId = ");
    localStringBuilder.append(this.mItemId);
    localStringBuilder.append(" mLastRunTime = ");
    localStringBuilder.append(this.mLastRunTime);
    localStringBuilder.append(" count = ");
    localStringBuilder.append(this.mRunCount);
    localStringBuilder.append(" from = ");
    localStringBuilder.append(this.mFrom);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.entity.db.ItemUpdateVerPtr
 * JD-Core Version:    0.7.0.1
 */