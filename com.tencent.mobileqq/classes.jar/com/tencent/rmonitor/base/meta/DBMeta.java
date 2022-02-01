package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/DBMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "processName", "", "threadName", "dbPath", "table", "sql", "explain", "extInfo", "sqlTimeCost", "", "createTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getCreateTime", "()J", "getDbPath", "()Ljava/lang/String;", "getExplain", "getExtInfo", "getProcessName", "getSql", "getSqlTimeCost", "getTable", "getThreadName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DBMeta
  extends MonitorMeta
{
  private final long createTime;
  @NotNull
  private final String dbPath;
  @NotNull
  private final String explain;
  @NotNull
  private final String extInfo;
  @NotNull
  private final String processName;
  @NotNull
  private final String sql;
  private final long sqlTimeCost;
  @NotNull
  private final String table;
  @NotNull
  private final String threadName;
  
  public DBMeta(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, long paramLong1, long paramLong2)
  {
    this.processName = paramString1;
    this.threadName = paramString2;
    this.dbPath = paramString3;
    this.table = paramString4;
    this.sql = paramString5;
    this.explain = paramString6;
    this.extInfo = paramString7;
    this.sqlTimeCost = paramLong1;
    this.createTime = paramLong2;
  }
  
  @NotNull
  public final String component1()
  {
    return this.processName;
  }
  
  @NotNull
  public final String component2()
  {
    return this.threadName;
  }
  
  @NotNull
  public final String component3()
  {
    return this.dbPath;
  }
  
  @NotNull
  public final String component4()
  {
    return this.table;
  }
  
  @NotNull
  public final String component5()
  {
    return this.sql;
  }
  
  @NotNull
  public final String component6()
  {
    return this.explain;
  }
  
  @NotNull
  public final String component7()
  {
    return this.extInfo;
  }
  
  public final long component8()
  {
    return this.sqlTimeCost;
  }
  
  public final long component9()
  {
    return this.createTime;
  }
  
  @NotNull
  public final DBMeta copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "processName");
    Intrinsics.checkParameterIsNotNull(paramString2, "threadName");
    Intrinsics.checkParameterIsNotNull(paramString3, "dbPath");
    Intrinsics.checkParameterIsNotNull(paramString4, "table");
    Intrinsics.checkParameterIsNotNull(paramString5, "sql");
    Intrinsics.checkParameterIsNotNull(paramString6, "explain");
    Intrinsics.checkParameterIsNotNull(paramString7, "extInfo");
    return new DBMeta(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramLong1, paramLong2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DBMeta))
      {
        paramObject = (DBMeta)paramObject;
        if ((Intrinsics.areEqual(this.processName, paramObject.processName)) && (Intrinsics.areEqual(this.threadName, paramObject.threadName)) && (Intrinsics.areEqual(this.dbPath, paramObject.dbPath)) && (Intrinsics.areEqual(this.table, paramObject.table)) && (Intrinsics.areEqual(this.sql, paramObject.sql)) && (Intrinsics.areEqual(this.explain, paramObject.explain)) && (Intrinsics.areEqual(this.extInfo, paramObject.extInfo)))
        {
          int i;
          if (this.sqlTimeCost == paramObject.sqlTimeCost) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            if (this.createTime == paramObject.createTime) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0) {
              return true;
            }
          }
        }
      }
      return false;
    }
    return true;
  }
  
  public final long getCreateTime()
  {
    return this.createTime;
  }
  
  @NotNull
  public final String getDbPath()
  {
    return this.dbPath;
  }
  
  @NotNull
  public final String getExplain()
  {
    return this.explain;
  }
  
  @NotNull
  public final String getExtInfo()
  {
    return this.extInfo;
  }
  
  @NotNull
  public final String getProcessName()
  {
    return this.processName;
  }
  
  @NotNull
  public final String getSql()
  {
    return this.sql;
  }
  
  public final long getSqlTimeCost()
  {
    return this.sqlTimeCost;
  }
  
  @NotNull
  public final String getTable()
  {
    return this.table;
  }
  
  @NotNull
  public final String getThreadName()
  {
    return this.threadName;
  }
  
  public int hashCode()
  {
    String str = this.processName;
    int i2 = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.threadName;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.dbPath;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.table;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.sql;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.explain;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.extInfo;
    if (str != null) {
      i2 = str.hashCode();
    }
    long l = this.sqlTimeCost;
    int i3 = (int)(l ^ l >>> 32);
    l = this.createTime;
    return (((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DBMeta(processName=");
    localStringBuilder.append(this.processName);
    localStringBuilder.append(", threadName=");
    localStringBuilder.append(this.threadName);
    localStringBuilder.append(", dbPath=");
    localStringBuilder.append(this.dbPath);
    localStringBuilder.append(", table=");
    localStringBuilder.append(this.table);
    localStringBuilder.append(", sql=");
    localStringBuilder.append(this.sql);
    localStringBuilder.append(", explain=");
    localStringBuilder.append(this.explain);
    localStringBuilder.append(", extInfo=");
    localStringBuilder.append(this.extInfo);
    localStringBuilder.append(", sqlTimeCost=");
    localStringBuilder.append(this.sqlTimeCost);
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.createTime);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.DBMeta
 * JD-Core Version:    0.7.0.1
 */