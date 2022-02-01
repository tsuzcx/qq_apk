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
  
  static void clear()
  {
    try
    {
      SonicUtils.log("SonicSdk_SonicChunkDataHelper", 4, "Session clear all ChunkData!");
      try
      {
        SonicDBHelper.getInstance().getWritableDatabase().delete("SessionChunkData", null, null);
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clear encounter error!");
        localStringBuilder.append(localThrowable.getMessage());
        SonicUtils.log("SonicSdk_SonicChunkDataHelper", 6, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  static String[] getAllSessionChunkDataColumn()
  {
    return new String[] { "sessionId", "eTag", "chunkKey", "chunkSha1" };
  }
  
  @NonNull
  static List<SonicChunkDataHelper.ChunkData> getChunkDataList(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        paramString1 = SonicDBHelper.getInstance().getWritableDatabase().query("SessionChunkData", getAllSessionChunkDataColumn(), "sessionId=? and eTag=?", new String[] { paramString1, paramString2 }, null, null, null);
        if ((paramString1 != null) && (paramString1.moveToFirst())) {
          do
          {
            localArrayList.add(querySessionData(paramString1));
          } while (paramString1.moveToNext());
        }
        if (paramString1 != null)
        {
          paramString1.close();
          return localArrayList;
        }
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("getWritableDatabase encounter error.");
        paramString2.append(paramString1.getMessage());
        SonicUtils.log("SonicSdk_SonicChunkDataHelper", 6, paramString2.toString());
      }
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
    if (!TextUtils.isEmpty(paramString))
    {
      SonicUtils.log("SonicSdk_SonicChunkDataHelper", 4, String.format("Session (%s) removeChunkData", new Object[] { paramString }));
      try
      {
        SonicDBHelper.getInstance().getWritableDatabase().delete("SessionChunkData", "sessionId=?", new String[] { paramString });
        return;
      }
      catch (Throwable paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getWritableDatabase encounter error.");
        localStringBuilder.append(paramString.getMessage());
        SonicUtils.log("SonicSdk_SonicChunkDataHelper", 6, localStringBuilder.toString());
      }
    }
  }
  
  static void saveChunkData(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString3)) {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramString3);
        paramString3 = (String)localObject1;
        if (((JSONObject)localObject1).has("data"))
        {
          paramString3 = (String)localObject1;
          if (((JSONObject)localObject1).has("html-sha1"))
          {
            paramString3 = (String)localObject1;
            if (((JSONObject)localObject1).has("template-tag")) {
              paramString3 = ((JSONObject)localObject1).optJSONObject("data");
            }
          }
        }
        if ((paramString3 != null) && (!TextUtils.isEmpty(paramString2)))
        {
          localObject1 = paramString3.keys();
          Pattern localPattern = Pattern.compile("\\{chunk_([0-9a-zA-Z-_])+\\}");
          ArrayList localArrayList = new ArrayList();
          if (((Iterator)localObject1).hasNext())
          {
            String str1 = ((Iterator)localObject1).next().toString();
            String str2 = paramString3.optString(str1);
            if ((!TextUtils.isEmpty(str1)) && (str1.startsWith("{chunk_")) && (!TextUtils.isEmpty(str2)) && (localPattern.matcher(str1).find()))
            {
              localObject2 = new SonicChunkDataHelper.ChunkData();
              ((SonicChunkDataHelper.ChunkData)localObject2).sessionId = paramString1;
              ((SonicChunkDataHelper.ChunkData)localObject2).chunkKey = str1;
              ((SonicChunkDataHelper.ChunkData)localObject2).chunkSha1 = SonicUtils.getSHA1(str2);
              ((SonicChunkDataHelper.ChunkData)localObject2).eTag = paramString2;
              localArrayList.add(localObject2);
              continue;
            }
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("saveChunkData error, key is  ");
            ((StringBuilder)localObject2).append(str1);
            ((StringBuilder)localObject2).append(", data isn't empty: ");
            if (TextUtils.isEmpty(str2)) {
              break label346;
            }
            bool = true;
            ((StringBuilder)localObject2).append(bool);
            SonicUtils.log("SonicSdk_SonicChunkDataHelper", 5, ((StringBuilder)localObject2).toString());
            continue;
          }
          if (localArrayList.size() > 0)
          {
            saveChunkData(paramString1, localArrayList);
            return;
          }
        }
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("saveChunkData error:");
        paramString2.append(paramString1.getMessage());
        SonicUtils.log("SonicSdk_SonicChunkDataHelper", 6, paramString2.toString());
      }
      return;
      label346:
      boolean bool = false;
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
        paramList = new StringBuilder();
        paramList.append("getWritableDatabase encounter error.");
        paramList.append(paramString.getMessage());
        SonicUtils.log("SonicSdk_SonicChunkDataHelper", 6, paramList.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicChunkDataHelper
 * JD-Core Version:    0.7.0.1
 */