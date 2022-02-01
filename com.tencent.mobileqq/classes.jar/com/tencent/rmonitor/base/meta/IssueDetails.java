package com.tencent.rmonitor.base.meta;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/IssueDetails;", "", "mode", "", "stage", "", "stack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(ILjava/lang/String;Ljava/util/ArrayList;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class IssueDetails
{
  @SerializedName("mode")
  @JvmField
  public int mode;
  @SerializedName("stack")
  @JvmField
  @Nullable
  public ArrayList<String> stack;
  @SerializedName("stage")
  @JvmField
  @NotNull
  public String stage;
  
  public IssueDetails(int paramInt, @NotNull String paramString, @Nullable ArrayList<String> paramArrayList)
  {
    this.mode = paramInt;
    this.stage = paramString;
    this.stack = paramArrayList;
  }
  
  public final int component1()
  {
    return this.mode;
  }
  
  @NotNull
  public final String component2()
  {
    return this.stage;
  }
  
  @Nullable
  public final ArrayList<String> component3()
  {
    return this.stack;
  }
  
  @NotNull
  public final IssueDetails copy(int paramInt, @NotNull String paramString, @Nullable ArrayList<String> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "stage");
    return new IssueDetails(paramInt, paramString, paramArrayList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof IssueDetails))
      {
        paramObject = (IssueDetails)paramObject;
        int i;
        if (this.mode == paramObject.mode) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i != 0) && (Intrinsics.areEqual(this.stage, paramObject.stage)) && (Intrinsics.areEqual(this.stack, paramObject.stack))) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int k = this.mode;
    Object localObject = this.stage;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.stack;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (k * 31 + i) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IssueDetails(mode=");
    localStringBuilder.append(this.mode);
    localStringBuilder.append(", stage=");
    localStringBuilder.append(this.stage);
    localStringBuilder.append(", stack=");
    localStringBuilder.append(this.stack);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.IssueDetails
 * JD-Core Version:    0.7.0.1
 */