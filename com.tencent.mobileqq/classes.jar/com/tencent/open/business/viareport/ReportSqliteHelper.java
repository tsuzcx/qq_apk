package com.tencent.open.business.viareport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.tencent.open.base.LogUtility;

public class ReportSqliteHelper
  extends SQLiteOpenHelper
{
  protected static ReportSqliteHelper a;
  protected String a;
  protected String b = "CREATE TABLE IF NOT EXISTS table_old_data( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
  protected String c = "CREATE TABLE IF NOT EXISTS table_appcircle_setting(_id INTEGER PRIMARY KEY AUTOINCREMENT,uin TEXT,key TEXT,value TEXT,data BLOB);";
  protected String d = "CREATE TABLE IF NOT EXISTS table_appcircle_report( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
  
  protected ReportSqliteHelper(Context paramContext)
  {
    super(paramContext, "open_report.db", null, 3);
    this.jdField_a_of_type_JavaLangString = "CREATE TABLE IF NOT EXISTS table_new_data( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
  }
  
  public static ReportSqliteHelper a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBusinessViareportReportSqliteHelper == null) {
        jdField_a_of_type_ComTencentOpenBusinessViareportReportSqliteHelper = new ReportSqliteHelper(paramContext);
      }
      paramContext = jdField_a_of_type_ComTencentOpenBusinessViareportReportSqliteHelper;
      return paramContext;
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sql1:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    LogUtility.b("opensdk", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("sql2:");
    localStringBuilder.append(this.b);
    LogUtility.b("opensdk", localStringBuilder.toString());
    paramSQLiteDatabase.execSQL(this.jdField_a_of_type_JavaLangString);
    paramSQLiteDatabase.execSQL(this.b);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("circleTest create table:");
    localStringBuilder.append(this.c);
    Log.i("ReportSqliteHelper", localStringBuilder.toString());
    paramSQLiteDatabase.execSQL(this.c);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_new_data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_old_data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_appcircle_setting");
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_new_data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_old_data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_appcircle_setting");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportSqliteHelper
 * JD-Core Version:    0.7.0.1
 */