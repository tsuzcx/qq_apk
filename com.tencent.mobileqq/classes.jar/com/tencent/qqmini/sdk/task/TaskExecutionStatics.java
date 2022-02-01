package com.tencent.qqmini.sdk.task;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "", "name", "", "runDurationMs", "", "totalRunDurationMs", "status", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;", "message", "subSteps", "", "(Ljava/lang/String;JJLcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;Ljava/lang/String;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "getName", "getRunDurationMs", "()J", "getStatus", "()Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;", "getSubSteps", "()Ljava/util/List;", "getTotalRunDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Status", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
public final class TaskExecutionStatics
{
  @NotNull
  private final String message;
  @NotNull
  private final String name;
  private final long runDurationMs;
  @NotNull
  private final TaskExecutionStatics.Status status;
  @NotNull
  private final List<TaskExecutionStatics> subSteps;
  private final long totalRunDurationMs;
  
  @JvmOverloads
  public TaskExecutionStatics(@NotNull String paramString, long paramLong)
  {
    this(paramString, paramLong, 0L, null, null, null, 60, null);
  }
  
  @JvmOverloads
  public TaskExecutionStatics(@NotNull String paramString, long paramLong1, long paramLong2)
  {
    this(paramString, paramLong1, paramLong2, null, null, null, 56, null);
  }
  
  @JvmOverloads
  public TaskExecutionStatics(@NotNull String paramString, long paramLong1, long paramLong2, @NotNull TaskExecutionStatics.Status paramStatus)
  {
    this(paramString, paramLong1, paramLong2, paramStatus, null, null, 48, null);
  }
  
  @JvmOverloads
  public TaskExecutionStatics(@NotNull String paramString1, long paramLong1, long paramLong2, @NotNull TaskExecutionStatics.Status paramStatus, @NotNull String paramString2)
  {
    this(paramString1, paramLong1, paramLong2, paramStatus, paramString2, null, 32, null);
  }
  
  @JvmOverloads
  public TaskExecutionStatics(@NotNull String paramString1, long paramLong1, long paramLong2, @NotNull TaskExecutionStatics.Status paramStatus, @NotNull String paramString2, @NotNull List<TaskExecutionStatics> paramList)
  {
    this.name = paramString1;
    this.runDurationMs = paramLong1;
    this.totalRunDurationMs = paramLong2;
    this.status = paramStatus;
    this.message = paramString2;
    this.subSteps = paramList;
  }
  
  @NotNull
  public final String component1()
  {
    return this.name;
  }
  
  public final long component2()
  {
    return this.runDurationMs;
  }
  
  public final long component3()
  {
    return this.totalRunDurationMs;
  }
  
  @NotNull
  public final TaskExecutionStatics.Status component4()
  {
    return this.status;
  }
  
  @NotNull
  public final String component5()
  {
    return this.message;
  }
  
  @NotNull
  public final List<TaskExecutionStatics> component6()
  {
    return this.subSteps;
  }
  
  @NotNull
  public final TaskExecutionStatics copy(@NotNull String paramString1, long paramLong1, long paramLong2, @NotNull TaskExecutionStatics.Status paramStatus, @NotNull String paramString2, @NotNull List<TaskExecutionStatics> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramStatus, "status");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    Intrinsics.checkParameterIsNotNull(paramList, "subSteps");
    return new TaskExecutionStatics(paramString1, paramLong1, paramLong2, paramStatus, paramString2, paramList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TaskExecutionStatics))
      {
        paramObject = (TaskExecutionStatics)paramObject;
        if ((Intrinsics.areEqual(this.name, paramObject.name)) && (this.runDurationMs == paramObject.runDurationMs) && (this.totalRunDurationMs == paramObject.totalRunDurationMs) && (Intrinsics.areEqual(this.status, paramObject.status)) && (Intrinsics.areEqual(this.message, paramObject.message)) && (Intrinsics.areEqual(this.subSteps, paramObject.subSteps))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getMessage()
  {
    return this.message;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  public final long getRunDurationMs()
  {
    return this.runDurationMs;
  }
  
  @NotNull
  public final TaskExecutionStatics.Status getStatus()
  {
    return this.status;
  }
  
  @NotNull
  public final List<TaskExecutionStatics> getSubSteps()
  {
    return this.subSteps;
  }
  
  public final long getTotalRunDurationMs()
  {
    return this.totalRunDurationMs;
  }
  
  public int hashCode()
  {
    Object localObject = this.name;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    long l = this.runDurationMs;
    int n = (int)(l ^ l >>> 32);
    l = this.totalRunDurationMs;
    int i1 = (int)(l ^ l >>> 32);
    localObject = this.status;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.message;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.subSteps;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((((i * 31 + n) * 31 + i1) * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TaskExecutionStatics(name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", runDurationMs=");
    localStringBuilder.append(this.runDurationMs);
    localStringBuilder.append(", totalRunDurationMs=");
    localStringBuilder.append(this.totalRunDurationMs);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.message);
    localStringBuilder.append(", subSteps=");
    localStringBuilder.append(this.subSteps);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskExecutionStatics
 * JD-Core Version:    0.7.0.1
 */