package com.tencent.xaction.api.data;

import androidx.annotation.Keep;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/InterpolatorData;", "", "type", "", "value", "Ljava/util/ArrayList;", "", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getValue", "()Ljava/util/ArrayList;", "setValue", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class InterpolatorData
{
  @NotNull
  private String type;
  @Nullable
  private ArrayList<Float> value;
  
  public InterpolatorData()
  {
    this(null, null, 3, null);
  }
  
  public InterpolatorData(@NotNull String paramString, @Nullable ArrayList<Float> paramArrayList)
  {
    this.type = paramString;
    this.value = paramArrayList;
  }
  
  @NotNull
  public final String component1()
  {
    return this.type;
  }
  
  @Nullable
  public final ArrayList<Float> component2()
  {
    return this.value;
  }
  
  @NotNull
  public final InterpolatorData copy(@NotNull String paramString, @Nullable ArrayList<Float> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    return new InterpolatorData(paramString, paramArrayList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof InterpolatorData))
      {
        paramObject = (InterpolatorData)paramObject;
        if ((Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.value, paramObject.value))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getType()
  {
    return this.type;
  }
  
  @Nullable
  public final ArrayList<Float> getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    Object localObject = this.type;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.value;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  public final void setType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.type = paramString;
  }
  
  public final void setValue(@Nullable ArrayList<Float> paramArrayList)
  {
    this.value = paramArrayList;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InterpolatorData(type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.data.InterpolatorData
 * JD-Core Version:    0.7.0.1
 */