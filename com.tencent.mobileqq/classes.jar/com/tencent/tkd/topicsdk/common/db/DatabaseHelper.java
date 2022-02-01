package com.tencent.tkd.topicsdk.common.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/db/DatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "()V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DatabaseHelper
  extends SQLiteOpenHelper
{
  public static final DatabaseHelper.Companion a = new DatabaseHelper.Companion(null);
  
  public DatabaseHelper()
  {
    super(TopicSDK.a.a().b().b(), "TopicSDK_DB", null, 2);
  }
  
  public void onCreate(@Nullable SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase != null) {
      paramSQLiteDatabase.execSQL("create table draft_info_table(id integer primary key autoincrement,timestamp integer,key varchar(64),user_id varchar(64),draft_info blob)");
    }
  }
  
  public void onUpgrade(@Nullable SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 2) && (paramSQLiteDatabase != null)) {
      paramSQLiteDatabase.execSQL("alter table draft_info_table add user_id varchar(64)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.db.DatabaseHelper
 * JD-Core Version:    0.7.0.1
 */