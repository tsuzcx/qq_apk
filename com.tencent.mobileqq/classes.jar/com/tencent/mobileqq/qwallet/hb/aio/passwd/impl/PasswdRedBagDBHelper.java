package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qphone.base.util.QLog;

public class PasswdRedBagDBHelper
  extends SQLiteOpenHelper
{
  public PasswdRedBagDBHelper(Context paramContext, String paramString)
  {
    super(paramContext, localStringBuilder.toString(), null, 5);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onCreate execSQL sqlRedBags=");
        localStringBuilder.append("CREATE TABLE IF NOT EXISTS red_bags (redbag_id VARCHAR PRIMARY KEY, redbag_index VARCHAR, uint64_creator_uin VARCHAR, expire_time INTEGER, password VARCHAR, is_open INTEGER, is_finish INTEGER, is_overdue INTEGER, redbag_type INTEGER, last_password VARCHAR, ext_str VARCHAR);");
        localStringBuilder.append(" sqlRedBagRelation=");
        localStringBuilder.append("CREATE TABLE IF NOT EXISTS red_bag_relations (code VARCHAR, source VARCHAR, redbag_id VARCHAR, authkey VARCHAR );");
        localStringBuilder.append(" sqlUpdateTimes=");
        localStringBuilder.append("CREATE TABLE IF NOT EXISTS update_times (code INTEGER, source INTEGER, last_update_time INTEGER, PRIMARY KEY(code,source));");
        QLog.d("PasswdRedBagDBHelper", 2, localStringBuilder.toString());
      }
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS red_bags (redbag_id VARCHAR PRIMARY KEY, redbag_index VARCHAR, uint64_creator_uin VARCHAR, expire_time INTEGER, password VARCHAR, is_open INTEGER, is_finish INTEGER, is_overdue INTEGER, redbag_type INTEGER, last_password VARCHAR, ext_str VARCHAR);");
    }
    catch (SQLException localSQLException1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PasswdRedBagDBHelper", 2, " onCreate execSQL exception", localSQLException1);
      }
    }
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS red_bag_relations (code VARCHAR, source VARCHAR, redbag_id VARCHAR, authkey VARCHAR );");
    }
    catch (SQLException localSQLException2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PasswdRedBagDBHelper", 2, " onCreate execSQL exception", localSQLException2);
      }
    }
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_times (code INTEGER, source INTEGER, last_update_time INTEGER, PRIMARY KEY(code,source));");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PasswdRedBagDBHelper", 2, " onCreate execSQL exception", paramSQLiteDatabase);
      }
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onUpgrade<<<<<oldVersion: ");
      localStringBuilder1.append(paramInt1);
      localStringBuilder1.append(" newVersion: ");
      localStringBuilder1.append(paramInt2);
      QLog.d("PasswdRedBagDBHelper", 2, localStringBuilder1.toString());
      i = paramInt1;
    }
    while (i < paramInt2)
    {
      StringBuilder localStringBuilder2;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4)
            {
              try
              {
                paramSQLiteDatabase.execSQL("ALTER TABLE red_bags ADD COLUMN ext_str VARCHAR ");
              }
              catch (Exception localException1)
              {
                if (!QLog.isColorLevel()) {
                  break label324;
                }
              }
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append(" exception occurred when ");
              localStringBuilder2.append("ALTER TABLE red_bags ADD COLUMN ext_str VARCHAR ");
              QLog.e("PasswdRedBagDBHelper", 2, localStringBuilder2.toString(), localException1);
            }
          }
          else
          {
            try
            {
              paramSQLiteDatabase.execSQL("ALTER TABLE red_bags ADD COLUMN last_password VARCHAR ");
            }
            catch (Exception localException2)
            {
              if (!QLog.isColorLevel()) {
                break label324;
              }
            }
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(" exception occurred when ");
            localStringBuilder2.append("ALTER TABLE red_bags ADD COLUMN last_password VARCHAR ");
            QLog.e("PasswdRedBagDBHelper", 2, localStringBuilder2.toString(), localException2);
          }
        }
        else
        {
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE red_bags ADD COLUMN redbag_type INTEGER DEFAULT 0");
          }
          catch (Exception localException3)
          {
            if (!QLog.isColorLevel()) {
              break label324;
            }
          }
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(" exception occurred when ");
          localStringBuilder2.append("ALTER TABLE red_bags ADD COLUMN redbag_type INTEGER DEFAULT 0");
          QLog.e("PasswdRedBagDBHelper", 2, localStringBuilder2.toString(), localException3);
        }
      }
      else {
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE red_bags ADD COLUMN redbag_index VARCHAR ");
        }
        catch (Exception localException4)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(" exception occurred when ");
            localStringBuilder2.append("ALTER TABLE red_bags ADD COLUMN redbag_index VARCHAR ");
            QLog.e("PasswdRedBagDBHelper", 2, localStringBuilder2.toString(), localException4);
          }
        }
      }
      label324:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagDBHelper
 * JD-Core Version:    0.7.0.1
 */