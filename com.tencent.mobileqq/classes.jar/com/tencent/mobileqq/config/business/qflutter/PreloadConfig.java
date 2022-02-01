package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/PreloadConfig;", "", "mod", "", "opt", "", "Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption;", "(Ljava/lang/String;Ljava/util/List;)V", "getMod", "()Ljava/lang/String;", "setMod", "(Ljava/lang/String;)V", "getOpt", "()Ljava/util/List;", "setOpt", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PreloadConfig
{
  @SerializedName("mod")
  @NotNull
  private String a;
  @SerializedName("opt")
  @NotNull
  private List<? extends PreloadEngineOption> b;
  
  public PreloadConfig()
  {
    this(null, null, 3, null);
  }
  
  public PreloadConfig(@NotNull String paramString, @NotNull List<? extends PreloadEngineOption> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PreloadConfig))
      {
        paramObject = (PreloadConfig)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreloadConfig(mod=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", opt=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.PreloadConfig
 * JD-Core Version:    0.7.0.1
 */