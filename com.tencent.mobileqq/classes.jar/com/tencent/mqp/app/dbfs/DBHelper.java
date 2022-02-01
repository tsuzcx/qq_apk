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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramLong);
    localObject = localSQLiteDatabase.query("t_PathNode", null, " ID_node=?", new String[] { ((StringBuilder)localObject).toString() }, null, null, null);
    if (((Cursor)localObject).moveToFirst() == true)
    {
      paramLong = ((Cursor)localObject).getLong(2);
      ((Cursor)localObject).close();
      localSQLiteDatabase.close();
      return paramLong;
    }
    ((Cursor)localObject).close();
    localSQLiteDatabase.close();
    return -1L;
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("ID_blob", Long.valueOf(paramLong2));
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong1);
    paramLong1 = localSQLiteDatabase.update("t_PathNode", localContentValues, " ID_node=?", new String[] { localStringBuilder.toString() });
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    paramString = localSQLiteDatabase.query("t_PathNode", null, " ID_parent=? and name=? ", new String[] { localStringBuilder.toString(), paramString }, null, null, null);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    localSQLiteDatabase.delete("t_BlobNode", " ID_blob=? ", new String[] { localStringBuilder.toString() });
    localSQLiteDatabase.close();
  }
  
  public String[] a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramLong);
    localObject1 = localSQLiteDatabase.query("t_PathNode", null, " ID_parent=? ", new String[] { ((StringBuilder)localObject1).toString() }, null, null, null);
    if (((Cursor)localObject1).moveToFirst() == true)
    {
      Object localObject2 = new ArrayList();
      do
      {
        ((ArrayList)localObject2).add(((Cursor)localObject1).getString(3));
      } while (((Cursor)localObject1).moveToNext());
      localObject2 = (String[])((ArrayList)localObject2).toArray(new String[0]);
      ((Cursor)localObject1).close();
      localSQLiteDatabase.close();
      return localObject2;
    }
    ((Cursor)localObject1).close();
    localSQLiteDatabase.close();
    return null;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_PathNode");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_BlobNode");
    paramSQLiteDatabase.execSQL("create table t_PathNode( ID_node        integer primary key autoincrement, ID_parent    integer default(-1), ID_blob        integer default(-1), name            varchar(64));");
    paramSQLiteDatabase.execSQL("create table t_BlobNode( ID_blob        integer primary key autoincrement, Content        blob, hash            char(20) , ctime        TIMESTAMP, mtime        TIMESTAMP, atime        TIMESTAMP );");
    paramSQLiteDatabase.execSQL("create index i_pathIndex on t_PathNode (ID_parent, name);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_PathNode");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_BlobNode");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.dbfs.DBHelper
 * JD-Core Version:    0.7.0.1
 */