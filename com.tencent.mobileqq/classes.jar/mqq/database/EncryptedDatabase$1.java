package mqq.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;

class EncryptedDatabase$1
  implements SQLiteDatabase.CursorFactory
{
  String[] ex = { "sqlite_master", "sqlite_sequence", "sqlite_temp_master" };
  
  EncryptedDatabase$1(EncryptedDatabase paramEncryptedDatabase) {}
  
  public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    return new EncryptedDatabase.1.1(this, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.database.EncryptedDatabase.1
 * JD-Core Version:    0.7.0.1
 */