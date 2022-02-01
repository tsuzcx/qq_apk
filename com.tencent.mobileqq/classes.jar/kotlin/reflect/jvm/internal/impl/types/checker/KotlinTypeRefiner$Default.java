package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinTypeRefiner$Default
  extends KotlinTypeRefiner
{
  public static final Default INSTANCE = new Default();
  
  @Nullable
  public ClassDescriptor findClassAcrossModuleDependencies(@NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    return null;
  }
  
  @NotNull
  public <S extends MemberScope> S getOrPutScopeForClass(@NotNull ClassDescriptor paramClassDescriptor, @NotNull Function0<? extends S> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "compute");
    return (MemberScope)paramFunction0.invoke();
  }
  
  public boolean isRefinementNeededForModule(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "moduleDescriptor");
    return false;
  }
  
  public boolean isRefinementNeededForTypeConstructor(@NotNull TypeConstructor paramTypeConstructor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "typeConstructor");
    return false;
  }
  
  @Nullable
  public ClassDescriptor refineDescriptor(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "descriptor");
    return null;
  }
  
  @NotNull
  public Collection<KotlinType> refineSupertypes(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    paramClassDescriptor = paramClassDescriptor.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "classDescriptor.typeConstructor");
    paramClassDescriptor = paramClassDescriptor.getSupertypes();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "classDescriptor.typeConstructor.supertypes");
    return paramClassDescriptor;
  }
  
  @NotNull
  public KotlinType refineType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    return paramKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default
 * JD-Core Version:    0.7.0.1
 */