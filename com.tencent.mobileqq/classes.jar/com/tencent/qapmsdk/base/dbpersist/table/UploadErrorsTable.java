package com.tencent.qapmsdk.base.dbpersist.table;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/table/UploadErrorsTable;", "Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;", "()V", "insert", "", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class UploadErrorsTable
  extends BaseTable
{
  private static final String COLUMN_ERROR_CODE = "error_code";
  private static final String COLUMN_ERROR_MSG = "error_msg";
  private static final String COLUMN_HTTP_GET = "http_get";
  private static final String COLUMN_ID = "_id";
  private static final String COLUMN_PLUGIN = "plugin";
  private static final String COLUMN_PROCESS_NAME = "process_name";
  private static final String COLUMN_PRODUCT_ID = "p_id";
  private static final String COLUMN_STATUS = "status";
  private static final String COLUMN_UIN = "uin";
  private static final String COLUMN_UPLOAD_TIME = "uploadtime";
  private static final String COLUMN_VERSION = "version";
  private static final String CREATE_UPLOAD_ERRORS = "CREATE TABLE upload_errors (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id INT,version TEXT,uin TEXT,plugin SMALLINT,uploadtime BIGINT,error_code SMALLINT,error_msg TEXT,http_get TEXT,status TINYINT);";
  public static final UploadErrorsTable.Companion Companion = new UploadErrorsTable.Companion(null);
  private static final String TABLE_UPLOAD_ERRORS = "upload_errors";
  
  static
  {
    new UploadErrorsTable();
  }
  
  public UploadErrorsTable()
  {
    super("upload_errors", "CREATE TABLE upload_errors (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id INT,version TEXT,uin TEXT,plugin SMALLINT,uploadtime BIGINT,error_code SMALLINT,error_msg TEXT,http_get TEXT,status TINYINT);");
  }
  
  public int insert(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    return 0;
  }
  
  @Nullable
  public Object search(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends Object> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    return paramFunction0.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.table.UploadErrorsTable
 * JD-Core Version:    0.7.0.1
 */