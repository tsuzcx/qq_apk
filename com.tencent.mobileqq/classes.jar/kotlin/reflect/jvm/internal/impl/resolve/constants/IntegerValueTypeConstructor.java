package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntegerValueTypeConstructor
  implements TypeConstructor
{
  private final ModuleDescriptor module;
  private final ArrayList<KotlinType> supertypes;
  private final long value;
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    return this.module.getBuiltIns();
  }
  
  @Nullable
  public Void getDeclarationDescriptor()
  {
    return null;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public Collection<KotlinType> getSupertypes()
  {
    return (Collection)this.supertypes;
  }
  
  public boolean isDenotable()
  {
    return false;
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
    localStringBuilder.append("IntegerValueType(");
    localStringBuilder.append(this.value);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor
 * JD-Core Version:    0.7.0.1
 */