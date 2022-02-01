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
  private String jdField_a_of_type_JavaLangString;
  @SerializedName("opt")
  @NotNull
  private List<? extends PreloadEngineOption> jdField_a_of_type_JavaUtilList;
  
  public PreloadConfig()
  {
    this(null, null, 3, null);
  }
  
  public PreloadConfig(@NotNull String paramString, @NotNull List<? extends PreloadEngineOption> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PreloadConfig))
      {
        paramObject = (PreloadConfig)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaUtilList, paramObject.jdField_a_of_type_JavaUtilList))) {}
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
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
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
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", opt=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.PreloadConfig
 * JD-Core Version:    0.7.0.1
 */