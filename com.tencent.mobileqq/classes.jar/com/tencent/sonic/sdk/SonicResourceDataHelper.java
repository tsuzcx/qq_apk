package com.tencent.sonic.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class SonicResourceDataHelper
{
  public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS ResourceData ( id  integer PRIMARY KEY autoincrement , resourceID text not null , resourceSha1 text not null , resourceSize integer default 0 , resourceUpdateTime integer default 0 , cacheExpiredTime integer default 0 ); ";
  private static final String RESOURCE_DATA_COLUMN_CACHE_EXPIRED_TIME = "cacheExpiredTime";
  private static final String RESOURCE_DATA_COLUMN_LAST_UPDATE_TIME = "resourceUpdateTime";
  private static final String RESOURCE_DATA_COLUMN_RESOURCE_ID = "resourceID";
  private static final String RESOURCE_DATA_COLUMN_RESOURCE_SHA1 = "resourceSha1";
  private static final String RESOURCE_DATA_COLUMN_RESOURCE_SIZE = "resourceSize";
  private static final String Sonic_RESOURCE_TABLE_NAME = "ResourceData";
  private static final String TAG = "SonicSdk_SonicResourceDataHelper";
  
  static void clear()
  {
    try
    {
      SonicDBHelper.getInstance().getWritableDatabase().delete("ResourceData", null, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static List<ResourceData> getAllResourceData()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = SonicDBHelper.getInstance().getWritableDatabase().query("ResourceData", getAllResourceDataColumn(), null, null, null, null, "");
    while ((localCursor != null) && (localCursor.moveToNext())) {
      localArrayList.add(queryResourceData(localCursor));
    }
    return localArrayList;
  }
  
  public static String[] getAllResourceDataColumn()
  {
    return new String[] { "resourceID", "resourceSha1", "resourceSize", "resourceUpdateTime", "cacheExpiredTime" };
  }
  
  @NonNull
  private static ContentValues getContentValues(String paramString, ResourceData paramResourceData)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("resourceID", paramString);
    localContentValues.put("resourceSha1", paramResourceData.resourceSha1);
    localContentValues.put("resourceSize", Long.valueOf(paramResourceData.resourceSize));
    localContentValues.put("resourceUpdateTime", Long.valueOf(paramResourceData.lastUpdateTime));
    localContentValues.put("cacheExpiredTime", Long.valueOf(paramResourceData.expiredTime));
    return localContentValues;
  }
  
  private static ResourceData getResourceData(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Cursor localCursor = paramSQLiteDatabase.query("ResourceData", getAllResourceDataColumn(), "resourceID=?", new String[] { paramString }, null, null, null);
    paramString = null;
    paramSQLiteDatabase = paramString;
    if (localCursor != null)
    {
      paramSQLiteDatabase = paramString;
      if (localCursor.moveToFirst()) {
        paramSQLiteDatabase = queryResourceData(localCursor);
      }
    }
    if (localCursor != null) {
      localCursor.close();
    }
    return paramSQLiteDatabase;
  }
  
  @NonNull
  public static ResourceData getResourceData(String paramString)
  {
    ResourceData localResourceData = getResourceData(SonicDBHelper.getInstance().getWritableDatabase(), paramString);
    paramString = localResourceData;
    if (localResourceData == null) {
      paramString = new ResourceData();
    }
    return paramString;
  }
  
  private static void insertResourceData(SQLiteDatabase paramSQLiteDatabase, String paramString, ResourceData paramResourceData)
  {
    paramSQLiteDatabase.insert("ResourceData", null, getContentValues(paramString, paramResourceData));
  }
  
  private static ResourceData queryResourceData(Cursor paramCursor)
  {
    ResourceData localResourceData = new ResourceData();
    localResourceData.resourceId = paramCursor.getString(paramCursor.getColumnIndex("resourceID"));
    localResourceData.resourceSha1 = paramCursor.getString(paramCursor.getColumnIndex("resourceSha1"));
    localResourceData.resourceSize = paramCursor.getLong(paramCursor.getColumnIndex("resourceSize"));
    localResourceData.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("resourceUpdateTime"));
    localResourceData.expiredTime = paramCursor.getLong(paramCursor.getColumnIndex("cacheExpiredTime"));
    return localResourceData;
  }
  
  static void removeResourceData(String paramString)
  {
    SonicDBHelper.getInstance().getWritableDatabase().delete("ResourceData", "resourceID=?", new String[] { paramString });
  }
  
  private static void saveResourceData(SQLiteDatabase paramSQLiteDatabase, String paramString, ResourceData paramResourceData)
  {
    paramResourceData.resourceId = paramString;
    if (getResourceData(paramSQLiteDatabase, paramString) != null)
    {
      updateResourceData(paramSQLiteDatabase, paramString, paramResourceData);
      return;
    }
    insertResourceData(paramSQLiteDatabase, paramString, paramResourceData);
  }
  
  static void saveResourceData(String paramString, ResourceData paramResourceData)
  {
    saveResourceData(SonicDBHelper.getInstance().getWritableDatabase(), paramString, paramResourceData);
  }
  
  private static void updateResourceData(SQLiteDatabase paramSQLiteDatabase, String paramString, ResourceData paramResourceData)
  {
    paramSQLiteDatabase.update("ResourceData", getContentValues(paramString, paramResourceData), "resourceID=?", new String[] { paramString });
  }
  
  public static class ResourceData
  {
    public long expiredTime;
    long lastUpdateTime;
    String resourceId;
    public String resourceSha1;
    public long resourceSize;
    
    public void reset()
    {
      this.resourceSha1 = "";
      this.resourceSize = 0L;
      this.lastUpdateTime = 0L;
      this.expiredTime = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicResourceDataHelper
 * JD-Core Version:    0.7.0.1
 */