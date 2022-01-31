package com.tencent.sonic.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

class SonicChunkDataHelper
{
  public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS SessionChunkData ( id  integer PRIMARY KEY autoincrement , sessionId text not null , eTag text not null , chunkKey text not null , chunkSha1 text not null ); ";
  public static final String SESSION_CHUNK_COLUMN_CHUNK_KEY = "chunkKey";
  public static final String SESSION_CHUNK_COLUMN_CHUNK_SHA1 = "chunkSha1";
  public static final String SESSION_CHUNK_COLUMN_SESSION_ETAG = "eTag";
  public static final String SESSION_CHUNK_COLUMN_SESSION_ID = "sessionId";
  static final String SESSION_CHUNK_KEY_END = "}";
  static final String SESSION_CHUNK_KEY_PATTERN = "\\{chunk_([0-9a-zA-Z-_])+\\}";
  static final String SESSION_CHUNK_KEY_START = "{chunk_";
  public static final int SESSION_CHUNK_SEND_HASH_BITS = 12;
  public static final String SESSION_CHUNK_TABLE_NAME = "SessionChunkData";
  private static final String TAG = "SonicSdk_SonicChunkDataHelper";
  
  /* Error */
  static void clear()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 38
    //   5: iconst_4
    //   6: ldc 48
    //   8: invokestatic 54	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   11: invokestatic 60	com/tencent/sonic/sdk/SonicDBHelper:getInstance	()Lcom/tencent/sonic/sdk/SonicDBHelper;
    //   14: invokevirtual 64	com/tencent/sonic/sdk/SonicDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc 35
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 70	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   24: pop
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: ldc 38
    //   32: bipush 6
    //   34: new 72	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   41: ldc 75
    //   43: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: invokevirtual 83	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   50: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 54	com/tencent/sonic/sdk/SonicUtils:log	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: goto -34 -> 25
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	18	0	localThrowable	Throwable
    //   62	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	25	29	java/lang/Throwable
    //   3	11	62	finally
    //   11	25	62	finally
    //   30	59	62	finally
  }
  
  static String[] getAllSessionChunkDataColumn()
  {
    return new String[] { "sessionId", "eTag", "chunkKey", "chunkSha1" };
  }
  
  @NonNull
  static List<SonicChunkDataHelper.ChunkData> getChunkDataList(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      paramString1 = SonicDBHelper.getInstance().getWritableDatabase().query("SessionChunkData", getAllSessionChunkDataColumn(), "sessionId=? and eTag=?", new String[] { paramString1, paramString2 }, null, null, null);
      if ((paramString1 != null) && (paramString1.moveToFirst())) {
        do
        {
          localArrayList.add(querySessionData(paramString1));
        } while (paramString1.moveToNext());
      }
      if (paramString1 != null) {
        paramString1.close();
      }
      return localArrayList;
    }
    catch (Throwable paramString1)
    {
      SonicUtils.log("SonicSdk_SonicChunkDataHelper", 6, "getWritableDatabase encounter error." + paramString1.getMessage());
    }
    return localArrayList;
  }
  
  @NonNull
  private static ContentValues getContentValues(String paramString, SonicChunkDataHelper.ChunkData paramChunkData)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("sessionId", paramString);
    localContentValues.put("eTag", paramChunkData.eTag);
    localContentValues.put("chunkKey", paramChunkData.chunkKey);
    localContentValues.put("chunkSha1", paramChunkData.chunkSha1);
    return localContentValues;
  }
  
  private static SonicChunkDataHelper.ChunkData querySessionData(Cursor paramCursor)
  {
    SonicChunkDataHelper.ChunkData localChunkData = new SonicChunkDataHelper.ChunkData();
    localChunkData.sessionId = paramCursor.getString(paramCursor.getColumnIndex("sessionId"));
    localChunkData.eTag = paramCursor.getString(paramCursor.getColumnIndex("eTag"));
    localChunkData.chunkKey = paramCursor.getString(paramCursor.getColumnIndex("chunkKey"));
    localChunkData.chunkSha1 = paramCursor.getString(paramCursor.getColumnIndex("chunkSha1"));
    return localChunkData;
  }
  
  static void removeChunkData(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      SonicUtils.log("SonicSdk_SonicChunkDataHelper", 4, String.format("Session (%s) removeChunkData", new Object[] { paramString }));
    }
    try
    {
      SonicDBHelper.getInstance().getWritableDatabase().delete("SessionChunkData", "sessionId=?", new String[] { paramString });
      return;
    }
    catch (Throwable paramString)
    {
      SonicUtils.log("SonicSdk_SonicChunkDataHelper", 6, "getWritableDatabase encounter error." + paramString.getMessage());
    }
  }
  
  static void saveChunkData(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString1))) {}
    label58:
    ArrayList localArrayList;
    label91:
    Object localObject;
    String str;
    for (;;)
    {
      return;
      try
      {
        paramString3 = new JSONObject(paramString3);
        if ((!paramString3.has("data")) || (!paramString3.has("html-sha1")) || (!paramString3.has("template-tag"))) {
          break label311;
        }
        paramString3 = paramString3.optJSONObject("data");
        if ((paramString3 != null) && (!TextUtils.isEmpty(paramString2)))
        {
          Iterator localIterator = paramString3.keys();
          Pattern localPattern = Pattern.compile("\\{chunk_([0-9a-zA-Z-_])+\\}");
          localArrayList = new ArrayList();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label294;
            }
            localObject = localIterator.next().toString();
            str = paramString3.optString((String)localObject);
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).startsWith("{chunk_")) || (TextUtils.isEmpty(str)) || (!localPattern.matcher((CharSequence)localObject).find())) {
              break;
            }
            SonicChunkDataHelper.ChunkData localChunkData = new SonicChunkDataHelper.ChunkData();
            localChunkData.sessionId = paramString1;
            localChunkData.chunkKey = ((String)localObject);
            localChunkData.chunkSha1 = SonicUtils.getSHA1(str);
            localChunkData.eTag = paramString2;
            localArrayList.add(localChunkData);
          }
          localObject = new StringBuilder().append("saveChunkData error, key is  ").append((String)localObject).append(", data isn't empty: ");
        }
      }
      catch (Throwable paramString1)
      {
        SonicUtils.log("SonicSdk_SonicChunkDataHelper", 6, "saveChunkData error:" + paramString1.getMessage());
        return;
      }
    }
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool = true;; bool = false)
    {
      SonicUtils.log("SonicSdk_SonicChunkDataHelper", 5, bool);
      break label91;
      label294:
      if (localArrayList.size() <= 0) {
        break;
      }
      saveChunkData(paramString1, localArrayList);
      return;
      label311:
      break label58;
    }
  }
  
  private static void saveChunkData(String paramString, List<SonicChunkDataHelper.ChunkData> paramList)
  {
    removeChunkData(paramString);
    if ((paramList != null) && (paramList.size() > 0) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        SQLiteDatabase localSQLiteDatabase = SonicDBHelper.getInstance().getWritableDatabase();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          SonicChunkDataHelper.ChunkData localChunkData = (SonicChunkDataHelper.ChunkData)paramList.next();
          localSQLiteDatabase.insert("SessionChunkData", null, getContentValues(paramString, localChunkData));
          SonicUtils.log("SonicSdk_SonicChunkDataHelper", 4, String.format("Session (%s) saveChunkData, key=(%s), X-sonic-chunk=(%s)", new Object[] { paramString, localChunkData.chunkKey, localChunkData.chunkSha1 }));
        }
        return;
      }
      catch (Throwable paramString)
      {
        SonicUtils.log("SonicSdk_SonicChunkDataHelper", 6, "getWritableDatabase encounter error." + paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicChunkDataHelper
 * JD-Core Version:    0.7.0.1
 */