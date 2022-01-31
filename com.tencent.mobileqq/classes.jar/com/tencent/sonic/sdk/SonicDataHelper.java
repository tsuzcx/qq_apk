package com.tencent.sonic.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

class SonicDataHelper
{
  public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS SessionData ( id  integer PRIMARY KEY autoincrement , sessionID text not null , eTag text not null , templateTag text , htmlSha1 text not null , UnavailableTime integer default 0 , htmlSize integer default 0 , templateUpdateTime integer default 0 , cacheExpiredTime integer default 0 , cacheHitCount integer default 0 , isRedPointPreload integer default 0 ); ";
  protected static final String SESSION_DATA_COLUMN_CACHE_EXPIRED_TIME = "cacheExpiredTime";
  protected static final String SESSION_DATA_COLUMN_CACHE_HIT_COUNT = "cacheHitCount";
  protected static final String SESSION_DATA_COLUMN_ETAG = "eTag";
  protected static final String SESSION_DATA_COLUMN_HTML_SHA1 = "htmlSha1";
  protected static final String SESSION_DATA_COLUMN_HTML_SIZE = "htmlSize";
  protected static final String SESSION_DATA_COLUMN_IS_RED_POINT_PRELOAD = "isRedPointPreload";
  protected static final String SESSION_DATA_COLUMN_SESSION_ID = "sessionID";
  protected static final String SESSION_DATA_COLUMN_TEMPLATE_EAG = "templateTag";
  protected static final String SESSION_DATA_COLUMN_TEMPLATE_UPDATE_TIME = "templateUpdateTime";
  protected static final String SESSION_DATA_COLUMN_UNAVAILABLE_TIME = "UnavailableTime";
  protected static final String Sonic_SESSION_TABLE_NAME = "SessionData";
  private static final String TAG = "SonicSdk_SonicDataHelper";
  
  static void clear()
  {
    try
    {
      SonicDBHelper.getInstance().getWritableDatabase().delete("SessionData", null, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        SonicUtils.log("SonicSdk_SonicDataHelper", 6, "getWritableDatabase encounter error." + localThrowable.getMessage());
      }
    }
    finally {}
  }
  
  static List<SonicDataHelper.SessionData> getAllSessionByHitCount()
  {
    localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = SonicDBHelper.getInstance().getWritableDatabase().query("SessionData", getAllSessionDataColumn(), null, null, null, null, "cacheHitCount ASC");
      while ((localCursor != null) && (localCursor.moveToNext())) {
        localArrayList.add(querySessionData(localCursor));
      }
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      SonicUtils.log("SonicSdk_SonicDataHelper", 6, "getWritableDatabase encounter error." + localThrowable.getMessage());
    }
  }
  
  static String[] getAllSessionDataColumn()
  {
    return new String[] { "sessionID", "eTag", "templateTag", "htmlSha1", "UnavailableTime", "htmlSize", "templateUpdateTime", "cacheExpiredTime", "cacheHitCount", "isRedPointPreload" };
  }
  
  @NonNull
  private static ContentValues getContentValues(String paramString, SonicDataHelper.SessionData paramSessionData)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("sessionID", paramString);
    localContentValues.put("eTag", paramSessionData.eTag);
    localContentValues.put("htmlSha1", paramSessionData.htmlSha1);
    localContentValues.put("htmlSize", Long.valueOf(paramSessionData.htmlSize));
    localContentValues.put("templateTag", paramSessionData.templateTag);
    localContentValues.put("templateUpdateTime", Long.valueOf(paramSessionData.templateUpdateTime));
    localContentValues.put("cacheExpiredTime", Long.valueOf(paramSessionData.expiredTime));
    localContentValues.put("UnavailableTime", Long.valueOf(paramSessionData.unAvailableTime));
    localContentValues.put("cacheHitCount", Integer.valueOf(paramSessionData.cacheHitCount));
    localContentValues.put("isRedPointPreload", Integer.valueOf(paramSessionData.isRedPointPreload));
    return localContentValues;
  }
  
  static long getLastSonicUnavailableTime(String paramString)
  {
    return getSessionData(paramString).unAvailableTime;
  }
  
  private static SonicDataHelper.SessionData getSessionData(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject = null;
    paramString = paramSQLiteDatabase.query("SessionData", getAllSessionDataColumn(), "sessionID=?", new String[] { paramString }, null, null, null);
    paramSQLiteDatabase = localObject;
    if (paramString != null)
    {
      paramSQLiteDatabase = localObject;
      if (paramString.moveToFirst()) {
        paramSQLiteDatabase = querySessionData(paramString);
      }
    }
    if (paramString != null) {
      paramString.close();
    }
    return paramSQLiteDatabase;
  }
  
  @NonNull
  static SonicDataHelper.SessionData getSessionData(String paramString)
  {
    try
    {
      paramString = getSessionData(SonicDBHelper.getInstance().getWritableDatabase(), paramString);
      Object localObject = paramString;
      if (paramString == null) {
        localObject = new SonicDataHelper.SessionData();
      }
      return localObject;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        SonicUtils.log("SonicSdk_SonicDataHelper", 6, "getWritableDatabase encounter error." + paramString.getMessage());
        paramString = null;
      }
    }
  }
  
  static long getTemplateUpdateTime(String paramString)
  {
    return getSessionData(paramString).templateUpdateTime;
  }
  
  private static void insertSessionData(SQLiteDatabase paramSQLiteDatabase, String paramString, SonicDataHelper.SessionData paramSessionData)
  {
    paramSQLiteDatabase.insert("SessionData", null, getContentValues(paramString, paramSessionData));
  }
  
  private static SonicDataHelper.SessionData querySessionData(Cursor paramCursor)
  {
    SonicDataHelper.SessionData localSessionData = new SonicDataHelper.SessionData();
    localSessionData.sessionId = paramCursor.getString(paramCursor.getColumnIndex("sessionID"));
    localSessionData.eTag = paramCursor.getString(paramCursor.getColumnIndex("eTag"));
    localSessionData.htmlSha1 = paramCursor.getString(paramCursor.getColumnIndex("htmlSha1"));
    localSessionData.htmlSize = paramCursor.getLong(paramCursor.getColumnIndex("htmlSize"));
    localSessionData.templateTag = paramCursor.getString(paramCursor.getColumnIndex("templateTag"));
    localSessionData.templateUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("templateUpdateTime"));
    localSessionData.expiredTime = paramCursor.getLong(paramCursor.getColumnIndex("cacheExpiredTime"));
    localSessionData.unAvailableTime = paramCursor.getLong(paramCursor.getColumnIndex("UnavailableTime"));
    localSessionData.cacheHitCount = paramCursor.getInt(paramCursor.getColumnIndex("cacheHitCount"));
    localSessionData.isRedPointPreload = paramCursor.getInt(paramCursor.getColumnIndex("isRedPointPreload"));
    return localSessionData;
  }
  
  static void removeSessionData(String paramString)
  {
    try
    {
      SonicDBHelper.getInstance().getWritableDatabase().delete("SessionData", "sessionID=?", new String[] { paramString });
      return;
    }
    catch (Throwable paramString)
    {
      SonicUtils.log("SonicSdk_SonicDataHelper", 6, "removeSessionData encounter error." + paramString.getMessage());
    }
  }
  
  private static void saveSessionData(SQLiteDatabase paramSQLiteDatabase, String paramString, SonicDataHelper.SessionData paramSessionData)
  {
    paramSessionData.sessionId = paramString;
    SonicDataHelper.SessionData localSessionData = getSessionData(paramSQLiteDatabase, paramString);
    if (localSessionData != null)
    {
      paramSessionData.cacheHitCount = localSessionData.cacheHitCount;
      updateSessionData(paramSQLiteDatabase, paramString, paramSessionData);
      return;
    }
    insertSessionData(paramSQLiteDatabase, paramString, paramSessionData);
  }
  
  static void saveSessionData(String paramString, SonicDataHelper.SessionData paramSessionData)
  {
    try
    {
      saveSessionData(SonicDBHelper.getInstance().getWritableDatabase(), paramString, paramSessionData);
      return;
    }
    catch (Throwable paramString)
    {
      SonicUtils.log("SonicSdk_SonicDataHelper", 6, "getWritableDatabase encounter error." + paramString.getMessage());
    }
  }
  
  static boolean setSonicUnavailableTime(String paramString, long paramLong)
  {
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = SonicDBHelper.getInstance().getWritableDatabase();
        SonicDataHelper.SessionData localSessionData;
        SonicUtils.log("SonicSdk_SonicDataHelper", 6, "getWritableDatabase encounter error." + localThrowable1.getMessage());
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localSessionData = getSessionData(localSQLiteDatabase, paramString);
          if (localSQLiteDatabase != null) {
            break;
          }
          return false;
        }
        catch (Throwable localThrowable2)
        {
          SQLiteDatabase localSQLiteDatabase;
          Object localObject1;
          break label27;
        }
        localThrowable1 = localThrowable1;
        localSQLiteDatabase = null;
      }
      label27:
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      ((SonicDataHelper.SessionData)localObject1).unAvailableTime = paramLong;
      updateSessionData(localSQLiteDatabase, paramString, (SonicDataHelper.SessionData)localObject1);
      return true;
    }
    localObject1 = new SonicDataHelper.SessionData();
    ((SonicDataHelper.SessionData)localObject1).sessionId = paramString;
    ((SonicDataHelper.SessionData)localObject1).eTag = "Unknown";
    ((SonicDataHelper.SessionData)localObject1).htmlSha1 = "Unknown";
    ((SonicDataHelper.SessionData)localObject1).unAvailableTime = paramLong;
    insertSessionData(localSQLiteDatabase, paramString, (SonicDataHelper.SessionData)localObject1);
    return true;
  }
  
  private static void updateSessionData(SQLiteDatabase paramSQLiteDatabase, String paramString, SonicDataHelper.SessionData paramSessionData)
  {
    paramSQLiteDatabase.update("SessionData", getContentValues(paramString, paramSessionData), "sessionID=?", new String[] { paramString });
  }
  
  private static void updateSonicCacheHitCount(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    SonicDataHelper.SessionData localSessionData = getSessionData(paramSQLiteDatabase, paramString);
    if (localSessionData != null)
    {
      localSessionData.cacheHitCount += 1;
      updateSessionData(paramSQLiteDatabase, paramString, localSessionData);
    }
  }
  
  static void updateSonicCacheHitCount(String paramString)
  {
    try
    {
      updateSonicCacheHitCount(SonicDBHelper.getInstance().getWritableDatabase(), paramString);
      return;
    }
    catch (Throwable paramString)
    {
      SonicUtils.log("SonicSdk_SonicDataHelper", 6, "getWritableDatabase encounter error." + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicDataHelper
 * JD-Core Version:    0.7.0.1
 */