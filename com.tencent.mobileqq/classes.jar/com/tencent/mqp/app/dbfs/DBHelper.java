package com.tencent.mqp.app.dbfs;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBHelper
  extends SQLiteOpenHelper
{
  public long a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("t_PathNode", null, " ID_node=?", new String[] { "" + paramLong }, null, null, null);
    if (localCursor.moveToFirst() == true)
    {
      paramLong = localCursor.getLong(2);
      localCursor.close();
      localSQLiteDatabase.close();
      return paramLong;
    }
    localCursor.close();
    localSQLiteDatabase.close();
    return -1L;
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("ID_blob", Long.valueOf(paramLong2));
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    paramLong1 = localSQLiteDatabase.update("t_PathNode", localContentValues, " ID_node=?", new String[] { "" + paramLong1 });
    localSQLiteDatabase.close();
    return paramLong1;
  }
  
  public long a(long paramLong1, long paramLong2, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("ID_parent", Long.valueOf(paramLong1));
    localContentValues.put("ID_blob", Long.valueOf(paramLong2));
    localContentValues.put("name", paramString);
    localSQLiteDatabase.beginTransaction();
    try
    {
      paramLong1 = localSQLiteDatabase.insert("t_PathNode", null, localContentValues);
      localSQLiteDatabase.setTransactionSuccessful();
      return paramLong1;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
      localSQLiteDatabase.close();
    }
  }
  
  public long a(long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    paramString = localSQLiteDatabase.query("t_PathNode", null, " ID_parent=? and name=? ", new String[] { "" + paramLong, paramString }, null, null, null);
    if (paramString.moveToFirst() == true)
    {
      paramLong = paramString.getLong(0);
      paramString.close();
      localSQLiteDatabase.close();
      return paramLong;
    }
    paramString.close();
    localSQLiteDatabase.close();
    return -1L;
  }
  
  public long a(byte[] paramArrayOfByte)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("Content", paramArrayOfByte);
    long l = localSQLiteDatabase.insert("t_BlobNode", null, localContentValues);
    localSQLiteDatabase.close();
    return l;
  }
  
  public void a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    localSQLiteDatabase.delete("t_BlobNode", " ID_blob=? ", new String[] { "" + paramLong });
    localSQLiteDatabase.close();
  }
  
  public String[] a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("t_PathNode", null, " ID_parent=? ", new String[] { "" + paramLong }, null, null, null);
    if (localCursor.moveToFirst() == true)
    {
      Object localObject = new ArrayList();
      do
      {
        ((ArrayList)localObject).add(localCursor.getString(3));
      } while (localCursor.moveToNext());
      localObject = (String[])((ArrayList)localObject).toArray(new String[0]);
      localCursor.close();
      localSQLiteDatabase.close();
      return localObject;
    }
    localCursor.close();
    localSQLiteDatabase.close();
    return null;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_PathNode");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_BlobNode");
    paramSQLiteDatabase.execSQL("create table t_PathNode( ID_node\t\tinteger primary key autoincrement, ID_parent\tinteger default(-1), ID_blob\t\tinteger default(-1), name\t\t\tvarchar(64));");
    paramSQLiteDatabase.execSQL("create table t_BlobNode( ID_blob\t\tinteger primary key autoincrement, Content\t\tblob, hash\t\t\tchar(20) , ctime\t\tTIMESTAMP, mtime\t\tTIMESTAMP, atime\t\tTIMESTAMP );");
    paramSQLiteDatabase.execSQL("create index i_pathIndex on t_PathNode (ID_parent, name);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_PathNode");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_BlobNode");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBHelper
 * JD-Core Version:    0.7.0.1
 */