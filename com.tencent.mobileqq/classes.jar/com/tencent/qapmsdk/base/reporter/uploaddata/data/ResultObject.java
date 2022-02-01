package com.tencent.qapmsdk.base.reporter.uploaddata.data;

import com.tencent.qapmsdk.common.reporter.BaseJsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "Lcom/tencent/qapmsdk/common/reporter/BaseJsonObject;", "reportType", "", "eventName", "", "isSucceed", "", "elapse", "", "size", "params", "Lorg/json/JSONObject;", "isRealTime", "isMerge", "uin", "(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZLjava/lang/String;)V", "dbId", "getDbId", "()I", "setDbId", "(I)V", "getElapse", "()J", "setElapse", "(J)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "()Z", "setMerge", "(Z)V", "setRealTime", "setSucceed", "getParams", "()Lorg/json/JSONObject;", "setParams", "(Lorg/json/JSONObject;)V", "getReportType", "setReportType", "getSize", "setSize", "getUin", "setUin", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ResultObject
  extends BaseJsonObject
{
  private int dbId;
  private long elapse;
  @NotNull
  private String eventName;
  private boolean isMerge;
  private boolean isRealTime;
  private boolean isSucceed;
  @NotNull
  private JSONObject params;
  private int reportType;
  private long size;
  @NotNull
  private String uin;
  
  public ResultObject()
  {
    this(0, null, false, 0L, 0L, null, false, false, null, 511, null);
  }
  
  public ResultObject(int paramInt, @NotNull String paramString1, boolean paramBoolean1, long paramLong1, long paramLong2, @NotNull JSONObject paramJSONObject, boolean paramBoolean2, boolean paramBoolean3, @NotNull String paramString2)
  {
    this.reportType = paramInt;
    this.eventName = paramString1;
    this.isSucceed = paramBoolean1;
    this.elapse = paramLong1;
    this.size = paramLong2;
    this.params = paramJSONObject;
    this.isRealTime = paramBoolean2;
    this.isMerge = paramBoolean3;
    this.uin = paramString2;
  }
  
  public final int component1()
  {
    return this.reportType;
  }
  
  @NotNull
  public final String component2()
  {
    return this.eventName;
  }
  
  public final boolean component3()
  {
    return this.isSucceed;
  }
  
  public final long component4()
  {
    return this.elapse;
  }
  
  public final long component5()
  {
    return this.size;
  }
  
  @NotNull
  public final JSONObject component6()
  {
    return this.params;
  }
  
  public final boolean component7()
  {
    return this.isRealTime;
  }
  
  public final boolean component8()
  {
    return this.isMerge;
  }
  
  @NotNull
  public final String component9()
  {
    return this.uin;
  }
  
  @NotNull
  public final ResultObject copy(int paramInt, @NotNull String paramString1, boolean paramBoolean1, long paramLong1, long paramLong2, @NotNull JSONObject paramJSONObject, boolean paramBoolean2, boolean paramBoolean3, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "eventName");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "params");
    Intrinsics.checkParameterIsNotNull(paramString2, "uin");
    return new ResultObject(paramInt, paramString1, paramBoolean1, paramLong1, paramLong2, paramJSONObject, paramBoolean2, paramBoolean3, paramString2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ResultObject))
      {
        paramObject = (ResultObject)paramObject;
        int i;
        if (this.reportType == paramObject.reportType) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i != 0) && (Intrinsics.areEqual(this.eventName, paramObject.eventName)))
        {
          if (this.isSucceed == paramObject.isSucceed) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            if (this.elapse == paramObject.elapse) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              if (this.size == paramObject.size) {
                i = 1;
              } else {
                i = 0;
              }
              if ((i != 0) && (Intrinsics.areEqual(this.params, paramObject.params)))
              {
                if (this.isRealTime == paramObject.isRealTime) {
                  i = 1;
                } else {
                  i = 0;
                }
                if (i != 0)
                {
                  if (this.isMerge == paramObject.isMerge) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                  if ((i != 0) && (Intrinsics.areEqual(this.uin, paramObject.uin))) {
                    return true;
                  }
                }
              }
            }
          }
        }
      }
      return false;
    }
    return true;
  }
  
  public final int getDbId()
  {
    return this.dbId;
  }
  
  public final long getElapse()
  {
    return this.elapse;
  }
  
  @NotNull
  public final String getEventName()
  {
    return this.eventName;
  }
  
  @NotNull
  public final JSONObject getParams()
  {
    return this.params;
  }
  
  public final int getReportType()
  {
    return this.reportType;
  }
  
  public final long getSize()
  {
    return this.size;
  }
  
  @NotNull
  public final String getUin()
  {
    return this.uin;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isMerge()
  {
    return this.isMerge;
  }
  
  public final boolean isRealTime()
  {
    return this.isRealTime;
  }
  
  public final boolean isSucceed()
  {
    return this.isSucceed;
  }
  
  public final void setDbId(int paramInt)
  {
    this.dbId = paramInt;
  }
  
  public final void setElapse(long paramLong)
  {
    this.elapse = paramLong;
  }
  
  public final void setEventName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.eventName = paramString;
  }
  
  public final void setMerge(boolean paramBoolean)
  {
    this.isMerge = paramBoolean;
  }
  
  public final void setParams(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "<set-?>");
    this.params = paramJSONObject;
  }
  
  public final void setRealTime(boolean paramBoolean)
  {
    this.isRealTime = paramBoolean;
  }
  
  public final void setReportType(int paramInt)
  {
    this.reportType = paramInt;
  }
  
  public final void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public final void setSucceed(boolean paramBoolean)
  {
    this.isSucceed = paramBoolean;
  }
  
  public final void setUin(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.uin = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResultObject(reportType=");
    localStringBuilder.append(this.reportType);
    localStringBuilder.append(", eventName=");
    localStringBuilder.append(this.eventName);
    localStringBuilder.append(", isSucceed=");
    localStringBuilder.append(this.isSucceed);
    localStringBuilder.append(", elapse=");
    localStringBuilder.append(this.elapse);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.params);
    localStringBuilder.append(", isRealTime=");
    localStringBuilder.append(this.isRealTime);
    localStringBuilder.append(", isMerge=");
    localStringBuilder.append(this.isMerge);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject
 * JD-Core Version:    0.7.0.1
 */