package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeAttributes
{
  @NotNull
  private final JavaTypeFlexibility flexibility;
  @NotNull
  private final TypeUsage howThisTypeIsUsed;
  private final boolean isForAnnotationParameter;
  @Nullable
  private final TypeParameterDescriptor upperBoundOfTypeParameter;
  
  public JavaTypeAttributes(@NotNull TypeUsage paramTypeUsage, @NotNull JavaTypeFlexibility paramJavaTypeFlexibility, boolean paramBoolean, @Nullable TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    this.howThisTypeIsUsed = paramTypeUsage;
    this.flexibility = paramJavaTypeFlexibility;
    this.isForAnnotationParameter = paramBoolean;
    this.upperBoundOfTypeParameter = paramTypeParameterDescriptor;
  }
  
  @NotNull
  public final JavaTypeAttributes copy(@NotNull TypeUsage paramTypeUsage, @NotNull JavaTypeFlexibility paramJavaTypeFlexibility, boolean paramBoolean, @Nullable TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeUsage, "howThisTypeIsUsed");
    Intrinsics.checkParameterIsNotNull(paramJavaTypeFlexibility, "flexibility");
    return new JavaTypeAttributes(paramTypeUsage, paramJavaTypeFlexibility, paramBoolean, paramTypeParameterDescriptor);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof JavaTypeAttributes))
      {
        paramObject = (JavaTypeAttributes)paramObject;
        if ((Intrinsics.areEqual(this.howThisTypeIsUsed, paramObject.howThisTypeIsUsed)) && (Intrinsics.areEqual(this.flexibility, paramObject.flexibility)) && (this.isForAnnotationParameter == paramObject.isForAnnotationParameter) && (Intrinsics.areEqual(this.upperBoundOfTypeParameter, paramObject.upperBoundOfTypeParameter))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final JavaTypeFlexibility getFlexibility()
  {
    return this.flexibility;
  }
  
  @NotNull
  public final TypeUsage getHowThisTypeIsUsed()
  {
    return this.howThisTypeIsUsed;
  }
  
  @Nullable
  public final TypeParameterDescriptor getUpperBoundOfTypeParameter()
  {
    return this.upperBoundOfTypeParameter;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isForAnnotationParameter()
  {
    return this.isForAnnotationParameter;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JavaTypeAttributes(howThisTypeIsUsed=");
    localStringBuilder.append(this.howThisTypeIsUsed);
    localStringBuilder.append(", flexibility=");
    localStringBuilder.append(this.flexibility);
    localStringBuilder.append(", isForAnnotationParameter=");
    localStringBuilder.append(this.isForAnnotationParameter);
    localStringBuilder.append(", upperBoundOfTypeParameter=");
    localStringBuilder.append(this.upperBoundOfTypeParameter);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final JavaTypeAttributes withFlexibility(@NotNull JavaTypeFlexibility paramJavaTypeFlexibility)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaTypeFlexibility, "flexibility");
    return copy$default(this, null, paramJavaTypeFlexibility, false, null, 13, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes
 * JD-Core Version:    0.7.0.1
 */