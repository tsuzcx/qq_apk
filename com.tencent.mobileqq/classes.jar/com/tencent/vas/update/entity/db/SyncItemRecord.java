package com.tencent.vas.update.entity.db;

import com.tencent.vas.update.util.CommonUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SyncItemRecord
{
  public String mAppVersion;
  public String mItemId;
  public String mMD5;
  public int mType;
  
  public static SyncItemRecord parseJsonToItem(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    SyncItemRecord localSyncItemRecord = new SyncItemRecord();
    localSyncItemRecord.mItemId = CommonUtil.sComposeItemId(paramJSONObject.optInt("bid"), paramJSONObject.optString("scid"));
    localSyncItemRecord.mType = paramJSONObject.optInt("optype");
    localSyncItemRecord.mMD5 = paramJSONObject.optString("version");
    localSyncItemRecord.mAppVersion = paramJSONObject.optString("appVersion");
    return localSyncItemRecord;
  }
  
  public static ArrayList<SyncItemRecord> parseVcrList(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      SyncItemRecord localSyncItemRecord = parseJsonToItem(paramJSONArray.optJSONObject(i));
      if (localSyncItemRecord != null) {
        localArrayList.add(localSyncItemRecord);
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.entity.db.SyncItemRecord
 * JD-Core Version:    0.7.0.1
 */