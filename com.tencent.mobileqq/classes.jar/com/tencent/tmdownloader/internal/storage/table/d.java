package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.storage.a.a;
import java.util.HashMap;

public class d
  implements c
{
  private static int a(String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if ((paramString1 == null) || (paramString2 == null)) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("settingField", paramString1);
        localContentValues.put("value", paramString2);
        localContentValues.put("type", paramString3);
        int j = paramSQLiteDatabase.update("settingInfo", localContentValues, "settingField = ?", new String[] { paramString1 });
        i = j;
        if (j > 0) {
          continue;
        }
        return 0;
      }
      catch (Exception paramString1)
      {
        paramString1 = paramString1;
        ab.c("DownloadSettingTable", "exception: ", paramString1);
        paramString1.printStackTrace();
        return -2;
      }
      finally {}
    }
  }
  
  public static HashMap<String, String> a()
  {
    Cursor localCursor2 = null;
    Object localObject3 = null;
    Cursor localCursor3 = null;
    localHashMap = new HashMap();
    localCursor1 = localCursor2;
    localObject1 = localObject3;
    do
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = a.c().getReadableDatabase();
        if (localSQLiteDatabase == null) {
          continue;
        }
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        localCursor2 = localSQLiteDatabase.rawQuery("select * from settingInfo", null);
        localCursor3 = localCursor2;
        if (localCursor2 == null) {
          continue;
        }
        localCursor3 = localCursor2;
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        if (!localCursor2.moveToFirst()) {
          continue;
        }
        boolean bool;
        do
        {
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          localHashMap.put(localCursor2.getString(localCursor2.getColumnIndex("settingField")), localCursor2.getString(localCursor2.getColumnIndex("value")));
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          bool = localCursor2.moveToNext();
        } while (bool);
        if (localCursor2 != null) {
          localCursor2.close();
        }
      }
      catch (Exception localException)
      {
        do
        {
          localObject1 = localCursor1;
          ab.c("DownloadSettingTable", "exception: ", localException);
          localObject1 = localCursor1;
          localException.printStackTrace();
        } while (localCursor1 == null);
        localCursor1.close();
        return localHashMap;
      }
      finally
      {
        if (localObject1 == null) {
          break;
        }
        ((Cursor)localObject1).close();
      }
      return localHashMap;
    } while (localCursor3 == null);
    localCursor3.close();
    return localHashMap;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = a.c().getWritableDatabase();
      if ((localSQLiteDatabase != null) && (a(paramString1, paramString2, paramString3, localSQLiteDatabase) <= 0))
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("settingField", paramString1);
        localContentValues.put("value", paramString2);
        localContentValues.put("type", paramString3);
        localSQLiteDatabase.insert("settingInfo", null, localContentValues);
      }
      return;
    }
    catch (Exception paramString1)
    {
      ab.c("DownloadSettingTable", "exception: ", paramString1);
      paramString1.printStackTrace();
    }
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists settingInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, settingField TEXT , value TEXT,type TEXT);";
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public String tableName()
  {
    return "settingInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.d
 * JD-Core Version:    0.7.0.1
 */