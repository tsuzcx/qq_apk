package com.tencent.qapmsdk.base.dbpersist.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "plugin", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "invoke"}, k=3, mv={1, 1, 15})
final class ConfigsTable$insert$1
  extends Lambda
  implements Function1<DefaultPluginConfig, Long>
{
  ConfigsTable$insert$1(ConfigsTable paramConfigsTable, ContentValues paramContentValues, SQLiteDatabase paramSQLiteDatabase)
  {
    super(1);
  }
  
  public final long invoke(@NotNull DefaultPluginConfig paramDefaultPluginConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDefaultPluginConfig, "plugin");
    this.$contentValues.put("p_id", Integer.valueOf(ConfigsTable.access$getPId$p(this.this$0)));
    this.$contentValues.put("version", ConfigsTable.access$getVersion$p(this.this$0));
    this.$contentValues.put("plugin", Integer.valueOf(paramDefaultPluginConfig.plugin));
    this.$contentValues.put("threshold", Integer.valueOf(paramDefaultPluginConfig.threshold));
    this.$contentValues.put("max_report_num", Integer.valueOf(paramDefaultPluginConfig.maxReportNum));
    this.$contentValues.put("event_sample_ratio", Float.valueOf(paramDefaultPluginConfig.eventSampleRatio));
    this.$contentValues.put("stack_depth", Integer.valueOf(paramDefaultPluginConfig.stackDepth));
    return this.$dataBase.insert("configs", "name", this.$contentValues);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.table.ConfigsTable.insert.1
 * JD-Core Version:    0.7.0.1
 */