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
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SonicUtils.log("SonicSdk_SonicResourceDataHelper", 6, "getWritableDatabase encounter error." + localThrowable.getMessage());
      }
    }
    finally {}
  }
  
  static List<SonicResourceDataHelper.ResourceData> getAllResourceData()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = SonicDBHelper.getInstance().getWritableDatabase().query("ResourceData", getAllResourceDataColumn(), null, null, null, null, "");
      while ((localCursor != null) && (localCursor.moveToNext())) {
        localArrayList.add(queryResourceData(localCursor));
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SonicUtils.log("SonicSdk_SonicResourceDataHelper", 6, "getWritableDatabase encounter error." + localThrowable.getMessage());
        Object localObject = null;
      }
    }
    return localArrayList;
  }
  
  public static String[] getAllResourceDataColumn()
  {
    return new String[] { "resourceID", "resourceSha1", "resourceSize", "resourceUpdateTime", "cacheExpiredTime" };
  }
  
  @NonNull
  private static ContentValues getContentValues(String paramString, SonicResourceDataHelper.ResourceData paramResourceData)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("resourceID", paramString);
    localContentValues.put("resourceSha1", paramResourceData.resourceSha1);
    localContentValues.put("resourceSize", Long.valueOf(paramResourceData.resourceSize));
    localContentValues.put("resourceUpdateTime", Long.valueOf(paramResourceData.lastUpdateTime));
    localContentValues.put("cacheExpiredTime", Long.valueOf(paramResourceData.expiredTime));
    return localContentValues;
  }
  
  private static SonicResourceDataHelper.ResourceData getResourceData(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject = null;
    paramString = paramSQLiteDatabase.query("ResourceData", getAllResourceDataColumn(), "resourceID=?", new String[] { paramString }, null, null, null);
    paramSQLiteDatabase = localObject;
    if (paramString != null)
    {
      paramSQLiteDatabase = localObject;
      if (paramString.moveToFirst()) {
        paramSQLiteDatabase = queryResourceData(paramString);
      }
    }
    if (paramString != null) {
      paramString.close();
    }
    return paramSQLiteDatabase;
  }
  
  @NonNull
  public static SonicResourceDataHelper.ResourceData getResourceData(String paramString)
  {
    try
    {
      paramString = getResourceData(SonicDBHelper.getInstance().getWritableDatabase(), paramString);
      Object localObject = paramString;
      if (paramString == null) {
        localObject = new SonicResourceDataHelper.ResourceData();
      }
      return localObject;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        SonicUtils.log("SonicSdk_SonicResourceDataHelper", 6, "getWritableDatabase encounter error." + paramString.getMessage());
        paramString = null;
      }
    }
  }
  
  private static void insertResourceData(SQLiteDatabase paramSQLiteDatabase, String paramString, SonicResourceDataHelper.ResourceData paramResourceData)
  {
    paramSQLiteDatabase.insert("ResourceData", null, getContentValues(paramString, paramResourceData));
  }
  
  private static SonicResourceDataHelper.ResourceData queryResourceData(Cursor paramCursor)
  {
    SonicResourceDataHelper.ResourceData localResourceData = new SonicResourceDataHelper.ResourceData();
    localResourceData.resourceId = paramCursor.getString(paramCursor.getColumnIndex("resourceID"));
    localResourceData.resourceSha1 = paramCursor.getString(paramCursor.getColumnIndex("resourceSha1"));
    localResourceData.resourceSize = paramCursor.getLong(paramCursor.getColumnIndex("resourceSize"));
    localResourceData.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("resourceUpdateTime"));
    localResourceData.expiredTime = paramCursor.getLong(paramCursor.getColumnIndex("cacheExpiredTime"));
    return localResourceData;
  }
  
  static void removeResourceData(String paramString)
  {
    try
    {
      SonicDBHelper.getInstance().getWritableDatabase().delete("ResourceData", "resourceID=?", new String[] { paramString });
      return;
    }
    catch (Throwable paramString)
    {
      SonicUtils.log("SonicSdk_SonicResourceDataHelper", 6, "getWritableDatabase encounter error." + paramString.getMessage());
    }
  }
  
  private static void saveResourceData(SQLiteDatabase paramSQLiteDatabase, String paramString, SonicResourceDataHelper.ResourceData paramResourceData)
  {
    paramResourceData.resourceId = paramString;
    if (getResourceData(paramSQLiteDatabase, paramString) != null)
    {
      updateResourceData(paramSQLiteDatabase, paramString, paramResourceData);
      return;
    }
    insertResourceData(paramSQLiteDatabase, paramString, paramResourceData);
  }
  
  static void saveResourceData(String paramString, SonicResourceDataHelper.ResourceData paramResourceData)
  {
    try
    {
      saveResourceData(SonicDBHelper.getInstance().getWritableDatabase(), paramString, paramResourceData);
      return;
    }
    catch (Throwable paramString)
    {
      SonicUtils.log("SonicSdk_SonicResourceDataHelper", 6, "getWritableDatabase encounter error." + paramString.getMessage());
    }
  }
  
  private static void updateResourceData(SQLiteDatabase paramSQLiteDatabase, String paramString, SonicResourceDataHelper.ResourceData paramResourceData)
  {
    paramSQLiteDatabase.update("ResourceData", getContentValues(paramString, paramResourceData), "resourceID=?", new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicResourceDataHelper
 * JD-Core Version:    0.7.0.1
 */