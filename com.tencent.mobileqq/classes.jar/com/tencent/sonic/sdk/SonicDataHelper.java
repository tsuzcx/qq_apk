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
  
  /* Error */
  static void clear()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 58	com/tencent/sonic/sdk/SonicDBHelper:getInstance	()Lcom/tencent/sonic/sdk/SonicDBHelper;
    //   6: invokevirtual 62	com/tencent/sonic/sdk/SonicDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: ldc 41
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 68	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   16: pop
    //   17: goto +43 -> 60
    //   20: astore_0
    //   21: goto +43 -> 64
    //   24: astore_0
    //   25: new 70	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   32: astore_1
    //   33: aload_1
    //   34: ldc 73
    //   36: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: aload_0
    //   42: invokevirtual 81	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   45: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 44
    //   51: bipush 6
    //   53: aload_1
    //   54: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 90	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: ldc 2
    //   62: monitorexit
    //   63: return
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	1	0	localObject	Object
    //   24	44	0	localThrowable	Throwable
    //   32	22	1	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	17	20	finally
    //   25	60	20	finally
    //   3	17	24	java/lang/Throwable
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
      StringBuilder localStringBuilder;
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWritableDatabase encounter error.");
      localStringBuilder.append(localThrowable.getMessage());
      SonicUtils.log("SonicSdk_SonicDataHelper", 6, localStringBuilder.toString());
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
    paramString = paramSQLiteDatabase.query("SessionData", getAllSessionDataColumn(), "sessionID=?", new String[] { paramString }, null, null, null);
    if ((paramString != null) && (paramString.moveToFirst())) {
      paramSQLiteDatabase = querySessionData(paramString);
    } else {
      paramSQLiteDatabase = null;
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
    }
    catch (Throwable paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getWritableDatabase encounter error.");
      ((StringBuilder)localObject).append(paramString.getMessage());
      SonicUtils.log("SonicSdk_SonicDataHelper", 6, ((StringBuilder)localObject).toString());
      paramString = null;
    }
    Object localObject = paramString;
    if (paramString == null) {
      localObject = new SonicDataHelper.SessionData();
    }
    return localObject;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeSessionData encounter error.");
      localStringBuilder.append(paramString.getMessage());
      SonicUtils.log("SonicSdk_SonicDataHelper", 6, localStringBuilder.toString());
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
      paramSessionData = new StringBuilder();
      paramSessionData.append("getWritableDatabase encounter error.");
      paramSessionData.append(paramString.getMessage());
      SonicUtils.log("SonicSdk_SonicDataHelper", 6, paramSessionData.toString());
    }
  }
  
  static boolean setSonicUnavailableTime(String paramString, long paramLong)
  {
    Object localObject2 = null;
    SQLiteDatabase localSQLiteDatabase;
    try
    {
      localSQLiteDatabase = SonicDBHelper.getInstance().getWritableDatabase();
      try
      {
        SonicDataHelper.SessionData localSessionData = getSessionData(localSQLiteDatabase, paramString);
      }
      catch (Throwable localThrowable1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      localSQLiteDatabase = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("getWritableDatabase encounter error.");
    localStringBuilder.append(localThrowable2.getMessage());
    SonicUtils.log("SonicSdk_SonicDataHelper", 6, localStringBuilder.toString());
    Object localObject1 = localObject2;
    if (localSQLiteDatabase == null) {
      return false;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWritableDatabase encounter error.");
      localStringBuilder.append(paramString.getMessage());
      SonicUtils.log("SonicSdk_SonicDataHelper", 6, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicDataHelper
 * JD-Core Version:    0.7.0.1
 */