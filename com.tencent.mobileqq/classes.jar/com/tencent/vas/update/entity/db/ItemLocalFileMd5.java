package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ItemLocalFileMd5
{
  public String mItemId;
  public long mLastFileModified;
  public String mOriginMd5;
  
  public static String convertItemLocalFileMd5ToJson(ItemLocalFileMd5 paramItemLocalFileMd5)
  {
    if (paramItemLocalFileMd5 == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("itemId", paramItemLocalFileMd5.mItemId);
      localJSONObject.put("lastModified", paramItemLocalFileMd5.mLastFileModified);
      localJSONObject.put("originMd5", paramItemLocalFileMd5.mOriginMd5);
      return localJSONObject.toString();
    }
    catch (JSONException paramItemLocalFileMd5)
    {
      for (;;)
      {
        paramItemLocalFileMd5.printStackTrace();
      }
    }
  }
  
  public static ItemLocalFileMd5 parseJsonToItemLocalFileMd5(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ItemLocalFileMd5 localItemLocalFileMd5 = new ItemLocalFileMd5();
    try
    {
      paramString = new JSONObject(paramString);
      localItemLocalFileMd5.mItemId = paramString.optString("itemId");
      localItemLocalFileMd5.mLastFileModified = paramString.optLong("lastModified");
      localItemLocalFileMd5.mOriginMd5 = paramString.optString("originMd5");
      return localItemLocalFileMd5;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localItemLocalFileMd5;
  }
  
  @NonNull
  public String toString()
  {
    return " itemId = " + this.mItemId + " , lastModified = " + this.mLastFileModified + " , originMd5 = " + this.mOriginMd5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.entity.db.ItemLocalFileMd5
 * JD-Core Version:    0.7.0.1
 */