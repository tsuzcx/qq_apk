package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaScope$MethodSignatureData
{
  @NotNull
  private final List<String> errors;
  private final boolean hasStableParameterNames;
  @Nullable
  private final KotlinType receiverType;
  @NotNull
  private final KotlinType returnType;
  @NotNull
  private final List<TypeParameterDescriptor> typeParameters;
  @NotNull
  private final List<ValueParameterDescriptor> valueParameters;
  
  public LazyJavaScope$MethodSignatureData(@NotNull KotlinType paramKotlinType1, @Nullable KotlinType paramKotlinType2, @NotNull List<? extends ValueParameterDescriptor> paramList, @NotNull List<? extends TypeParameterDescriptor> paramList1, boolean paramBoolean, @NotNull List<String> paramList2)
  {
    this.returnType = paramKotlinType1;
    this.receiverType = paramKotlinType2;
    this.valueParameters = paramList;
    this.typeParameters = paramList1;
    this.hasStableParameterNames = paramBoolean;
    this.errors = paramList2;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MethodSignatureData))
      {
        paramObject = (MethodSignatureData)paramObject;
        if ((Intrinsics.areEqual(this.returnType, paramObject.returnType)) && (Intrinsics.areEqual(this.receiverType, paramObject.receiverType)) && (Intrinsics.areEqual(this.valueParameters, paramObject.valueParameters)) && (Intrinsics.areEqual(this.typeParameters, paramObject.typeParameters)) && (this.hasStableParameterNames == paramObject.hasStableParameterNames) && (Intrinsics.areEqual(this.errors, paramObject.errors))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final List<String> getErrors()
  {
    return this.errors;
  }
  
  public final boolean getHasStableParameterNames()
  {
    return this.hasStableParameterNames;
  }
  
  @Nullable
  public final KotlinType getReceiverType()
  {
    return this.receiverType;
  }
  
  @NotNull
  public final KotlinType getReturnType()
  {
    return this.returnType;
  }
  
  @NotNull
  public final List<TypeParameterDescriptor> getTypeParameters()
  {
    return this.typeParameters;
  }
  
  @NotNull
  public final List<ValueParameterDescriptor> getValueParameters()
  {
    return this.valueParameters;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MethodSignatureData(returnType=");
    localStringBuilder.append(this.returnType);
    localStringBuilder.append(", receiverType=");
    localStringBuilder.append(this.receiverType);
    localStringBuilder.append(", valueParameters=");
    localStringBuilder.append(this.valueParameters);
    localStringBuilder.append(", typeParameters=");
    localStringBuilder.append(this.typeParameters);
    localStringBuilder.append(", hasStableParameterNames=");
    localStringBuilder.append(this.hasStableParameterNames);
    localStringBuilder.append(", errors=");
    localStringBuilder.append(this.errors);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.MethodSignatureData
 * JD-Core Version:    0.7.0.1
 */