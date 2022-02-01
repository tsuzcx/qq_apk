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
  
  /* Error */
  static void clear()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 43	com/tencent/sonic/sdk/SonicDBHelper:getInstance	()Lcom/tencent/sonic/sdk/SonicDBHelper;
    //   6: invokevirtual 47	com/tencent/sonic/sdk/SonicDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: ldc 26
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 53	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   16: pop
    //   17: goto +43 -> 60
    //   20: astore_0
    //   21: goto +43 -> 64
    //   24: astore_0
    //   25: new 55	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   32: astore_1
    //   33: aload_1
    //   34: ldc 58
    //   36: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: aload_0
    //   42: invokevirtual 66	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   45: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 29
    //   51: bipush 6
    //   53: aload_1
    //   54: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 75	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  static List<SonicResourceDataHelper.ResourceData> getAllResourceData()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor2;
    try
    {
      Cursor localCursor1 = SonicDBHelper.getInstance().getWritableDatabase().query("ResourceData", getAllResourceDataColumn(), null, null, null, null, "");
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWritableDatabase encounter error.");
      localStringBuilder.append(localThrowable.getMessage());
      SonicUtils.log("SonicSdk_SonicResourceDataHelper", 6, localStringBuilder.toString());
      localCursor2 = null;
    }
    while ((localCursor2 != null) && (localCursor2.moveToNext())) {
      localArrayList.add(queryResourceData(localCursor2));
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
    paramString = paramSQLiteDatabase.query("ResourceData", getAllResourceDataColumn(), "resourceID=?", new String[] { paramString }, null, null, null);
    if ((paramString != null) && (paramString.moveToFirst())) {
      paramSQLiteDatabase = queryResourceData(paramString);
    } else {
      paramSQLiteDatabase = null;
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
    }
    catch (Throwable paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getWritableDatabase encounter error.");
      ((StringBuilder)localObject).append(paramString.getMessage());
      SonicUtils.log("SonicSdk_SonicResourceDataHelper", 6, ((StringBuilder)localObject).toString());
      paramString = null;
    }
    Object localObject = paramString;
    if (paramString == null) {
      localObject = new SonicResourceDataHelper.ResourceData();
    }
    return localObject;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWritableDatabase encounter error.");
      localStringBuilder.append(paramString.getMessage());
      SonicUtils.log("SonicSdk_SonicResourceDataHelper", 6, localStringBuilder.toString());
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
      paramResourceData = new StringBuilder();
      paramResourceData.append("getWritableDatabase encounter error.");
      paramResourceData.append(paramString.getMessage());
      SonicUtils.log("SonicSdk_SonicResourceDataHelper", 6, paramResourceData.toString());
    }
  }
  
  private static void updateResourceData(SQLiteDatabase paramSQLiteDatabase, String paramString, SonicResourceDataHelper.ResourceData paramResourceData)
  {
    paramSQLiteDatabase.update("ResourceData", getContentValues(paramString, paramResourceData), "resourceID=?", new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicResourceDataHelper
 * JD-Core Version:    0.7.0.1
 */