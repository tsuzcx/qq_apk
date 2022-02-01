package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class EnumValue
  extends ConstantValue<Pair<? extends ClassId, ? extends Name>>
{
  @NotNull
  private final ClassId enumClassId;
  @NotNull
  private final Name enumEntryName;
  
  public EnumValue(@NotNull ClassId paramClassId, @NotNull Name paramName)
  {
    super(TuplesKt.to(paramClassId, paramName));
    this.enumClassId = paramClassId;
    this.enumEntryName = paramName;
  }
  
  @NotNull
  public final Name getEnumEntryName()
  {
    return this.enumEntryName;
  }
  
  @NotNull
  public KotlinType getType(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    paramModuleDescriptor = FindClassInModuleKt.findClassAcrossModuleDependencies(paramModuleDescriptor, this.enumClassId);
    if (paramModuleDescriptor != null)
    {
      if (!DescriptorUtils.isEnumClass((DeclarationDescriptor)paramModuleDescriptor)) {
        paramModuleDescriptor = null;
      }
      if (paramModuleDescriptor != null)
      {
        paramModuleDescriptor = paramModuleDescriptor.getDefaultType();
        if (paramModuleDescriptor != null) {
          return (KotlinType)paramModuleDescriptor;
        }
      }
    }
    paramModuleDescriptor = new StringBuilder();
    paramModuleDescriptor.append("Containing class for error-class based enum entry ");
    paramModuleDescriptor.append(this.enumClassId);
    paramModuleDescriptor.append('.');
    paramModuleDescriptor.append(this.enumEntryName);
    paramModuleDescriptor = ErrorUtils.createErrorType(paramModuleDescriptor.toString());
    Intrinsics.checkExpressionValueIsNotNull(paramModuleDescriptor, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
    return (KotlinType)paramModuleDescriptor;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.enumClassId.getShortClassName());
    localStringBuilder.append('.');
    localStringBuilder.append(this.enumEntryName);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue
 * JD-Core Version:    0.7.0.1
 */