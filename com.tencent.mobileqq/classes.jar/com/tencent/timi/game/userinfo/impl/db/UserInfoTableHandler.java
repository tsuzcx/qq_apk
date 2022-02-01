package com.tencent.timi.game.userinfo.impl.db;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiDatabaseTableHandler;
import com.tencent.timi.game.utils.Logger;

public class UserInfoTableHandler
  implements BaseTimiDatabaseTableHandler
{
  public boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("UserInfoTableHandler#onDatabaseUpgrade oldVersion=");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(", newVersion=");
    paramSQLiteDatabase.append(paramInt2);
    Logger.a("BaseTimiDatabaseTableHandler", paramSQLiteDatabase.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.db.UserInfoTableHandler
 * JD-Core Version:    0.7.0.1
 */