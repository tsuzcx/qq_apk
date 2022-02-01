package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PreloadItem
{
  private static final String TAG = "PreloadItem";
  public int mFlag;
  public String mItemId;
  
  public static JSONObject convertToJson(PreloadItem paramPreloadItem)
  {
    if (paramPreloadItem == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("item_id", paramPreloadItem.mItemId);
      localJSONObject.put("flag", paramPreloadItem.mFlag);
      return localJSONObject;
    }
    catch (JSONException paramPreloadItem)
    {
      paramPreloadItem.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static PreloadItem parseJsonToItem(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    PreloadItem localPreloadItem = new PreloadItem();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("item_id")) {
        localPreloadItem.mItemId = paramString.optString("item_id");
      } else {
        localPreloadItem.mItemId = CommonUtil.sComposeItemId(paramString.optLong("bid"), paramString.optString("scid"));
      }
      localPreloadItem.mFlag = paramString.optInt("flag");
      return localPreloadItem;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localPreloadItem;
  }
  
  public static ArrayList<PreloadItem> parsePreloadItemList(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          localObject = parseJsonToItem(((JSONObject)localObject).toString());
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Throwable paramJSONArray)
    {
      paramJSONArray.printStackTrace();
      VasUpdateWrapper.getLog().a("PreloadItem", "parsePreloadItemList exception", paramJSONArray);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.entity.db.PreloadItem
 * JD-Core Version:    0.7.0.1
 */