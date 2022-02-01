package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/ResDescription;", "", "resName", "", "pkgSuffix", "preload", "", "preloadEngine", "", "Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getPkgSuffix", "()Ljava/lang/String;", "setPkgSuffix", "(Ljava/lang/String;)V", "getPreload", "()Z", "setPreload", "(Z)V", "getPreloadEngine", "()Ljava/util/List;", "setPreloadEngine", "(Ljava/util/List;)V", "getResName", "setResName", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ResDescription
{
  @SerializedName("res_name")
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @SerializedName("preload_engine")
  @NotNull
  private List<? extends PreloadEngineOption> jdField_a_of_type_JavaUtilList;
  @SerializedName("preload")
  private boolean jdField_a_of_type_Boolean;
  @SerializedName("pkg_suffix")
  @NotNull
  private String b;
  
  public ResDescription()
  {
    this(null, null, false, null, 15, null);
  }
  
  public ResDescription(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean, @NotNull List<? extends PreloadEngineOption> paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ResDescription))
      {
        paramObject = (ResDescription)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.jdField_a_of_type_Boolean == paramObject.jdField_a_of_type_Boolean) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaUtilList, paramObject.jdField_a_of_type_JavaUtilList))) {}
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResDescription(resName=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", pkgSuffix=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", preload=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", preloadEngine=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.ResDescription
 * JD-Core Version:    0.7.0.1
 */