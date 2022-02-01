package com.tencent.vas.update.entity.db;

import java.util.ArrayList;
import org.json.JSONObject;

public class Preload
{
  public ArrayList<PreloadItem> mItemList;
  public int mPreLoadVersion;
  
  public static Preload parseJsonToPreaload(JSONObject paramJSONObject)
  {
    Preload localPreload = new Preload();
    if (paramJSONObject == null) {
      return localPreload;
    }
    localPreload.mPreLoadVersion = paramJSONObject.optInt("plver");
    localPreload.mItemList = PreloadItem.parsePreloadItemList(paramJSONObject.optJSONArray("item_list"));
    if (localPreload.mItemList == null) {
      localPreload.mItemList = new ArrayList();
    }
    return localPreload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.entity.db.Preload
 * JD-Core Version:    0.7.0.1
 */