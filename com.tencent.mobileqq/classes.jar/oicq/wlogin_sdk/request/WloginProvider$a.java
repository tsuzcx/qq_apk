package oicq.wlogin_sdk.request;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import oicq.wlogin_sdk.tools.util;

class WloginProvider$a
  extends SQLiteOpenHelper
{
  public WloginProvider$a(WloginProvider paramWloginProvider, Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL(String.format("CREATE TABLE %s (id INTEGER PRIMARY KEY AUTOINCREMENT, appid INTEGER, subappid INTEGER, pubkey TEXT, pubkey_md5 TEXT)", new Object[] { "rsa_pubkey" }));
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      util.printException(paramSQLiteDatabase, "");
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS rsa_pubkey");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WloginProvider.a
 * JD-Core Version:    0.7.0.1
 */