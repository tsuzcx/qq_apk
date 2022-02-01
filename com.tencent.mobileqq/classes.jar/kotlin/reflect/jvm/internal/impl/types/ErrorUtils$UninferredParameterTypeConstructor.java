package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ErrorUtils$UninferredParameterTypeConstructor
  implements TypeConstructor
{
  private final TypeConstructor errorTypeConstructor;
  private final TypeParameterDescriptor typeParameterDescriptor;
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    KotlinBuiltIns localKotlinBuiltIns = DescriptorUtilsKt.getBuiltIns(this.typeParameterDescriptor);
    if (localKotlinBuiltIns == null) {
      $$$reportNull$$$0(4);
    }
    return localKotlinBuiltIns;
  }
  
  @Nullable
  public ClassifierDescriptor getDeclarationDescriptor()
  {
    return this.errorTypeConstructor.getDeclarationDescriptor();
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    List localList = this.errorTypeConstructor.getParameters();
    if (localList == null) {
      $$$reportNull$$$0(2);
    }
    return localList;
  }
  
  @NotNull
  public Collection<KotlinType> getSupertypes()
  {
    Collection localCollection = this.errorTypeConstructor.getSupertypes();
    if (localCollection == null) {
      $$$reportNull$$$0(3);
    }
    return localCollection;
  }
  
  @NotNull
  public TypeParameterDescriptor getTypeParameterDescriptor()
  {
    TypeParameterDescriptor localTypeParameterDescriptor = this.typeParameterDescriptor;
    if (localTypeParameterDescriptor == null) {
      $$$reportNull$$$0(1);
    }
    return localTypeParameterDescriptor;
  }
  
  public boolean isDenotable()
  {
    return this.errorTypeConstructor.isDenotable();
  }
  
  @NotNull
  public TypeConstructor refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(5);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.ErrorUtils.UninferredParameterTypeConstructor
 * JD-Core Version:    0.7.0.1
 */