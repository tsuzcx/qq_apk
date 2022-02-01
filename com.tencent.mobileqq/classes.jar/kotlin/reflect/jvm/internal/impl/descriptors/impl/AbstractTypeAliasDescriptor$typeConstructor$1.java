package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeAliasDescriptor$typeConstructor$1
  implements TypeConstructor
{
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    return DescriptorUtilsKt.getBuiltIns((DeclarationDescriptor)getDeclarationDescriptor());
  }
  
  @NotNull
  public TypeAliasDescriptor getDeclarationDescriptor()
  {
    return (TypeAliasDescriptor)this.this$0;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    return this.this$0.getTypeConstructorTypeParameters();
  }
  
  @NotNull
  public Collection<KotlinType> getSupertypes()
  {
    Collection localCollection = getDeclarationDescriptor().getUnderlyingType().getConstructor().getSupertypes();
    Intrinsics.checkExpressionValueIsNotNull(localCollection, "declarationDescriptor.un…pe.constructor.supertypes");
    return localCollection;
  }
  
  public boolean isDenotable()
  {
    return true;
  }
  
  @NotNull
  public TypeConstructor refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return (TypeConstructor)this;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[typealias ");
    localStringBuilder.append(getDeclarationDescriptor().getName().asString());
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.typeConstructor.1
 * JD-Core Version:    0.7.0.1
 */