package com.tencent.qapmsdk.base.reporter.ab;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/ab/AbType;", "", "()V", "createTime", "", "timeOutMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "active", "", "canReportWith", "", "perfType", "getDescription", "initValue", "setPerfTimeout", "timeoutMills", "unActive", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract class AbType
{
  private long createTime = 9223372036854775807L;
  private final ConcurrentHashMap<Integer, Long> timeOutMap = new ConcurrentHashMap();
  @NotNull
  private String value = "";
  
  public abstract void active();
  
  public boolean canReportWith(int paramInt)
  {
    Long localLong = (Long)this.timeOutMap.get(Integer.valueOf(paramInt));
    if (localLong != null) {
      return System.currentTimeMillis() - this.createTime < localLong.longValue();
    }
    return false;
  }
  
  @Nullable
  public abstract String getDescription();
  
  @NotNull
  public final String getValue()
  {
    return this.value;
  }
  
  public void initValue(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.createTime = System.currentTimeMillis();
    this.value = paramString;
  }
  
  public void setPerfTimeout(int paramInt, long paramLong)
  {
    long l = paramLong;
    if (paramLong != 9223372036854775807L) {
      l = paramLong + (System.currentTimeMillis() - this.createTime);
    }
    ((Map)this.timeOutMap).put(Integer.valueOf(paramInt), Long.valueOf(l));
  }
  
  public final void setValue(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.value = paramString;
  }
  
  public abstract void unActive();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ab.AbType
 * JD-Core Version:    0.7.0.1
 */