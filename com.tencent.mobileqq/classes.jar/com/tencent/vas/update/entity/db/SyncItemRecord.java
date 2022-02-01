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
    long l = paramJSONObject.optInt("bid");
    String str1 = paramJSONObject.optString("scid");
    int i = paramJSONObject.optInt("optype");
    String str2 = paramJSONObject.optString("version");
    paramJSONObject = paramJSONObject.optString("appVersion");
    localSyncItemRecord.mItemId = CommonUtil.sComposeItemId(l, str1);
    localSyncItemRecord.mType = i;
    localSyncItemRecord.mMD5 = str2;
    localSyncItemRecord.mAppVersion = paramJSONObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.entity.db.SyncItemRecord
 * JD-Core Version:    0.7.0.1
 */