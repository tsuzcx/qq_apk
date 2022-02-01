package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class KotlinTypeRefiner
{
  @Nullable
  public abstract ClassDescriptor findClassAcrossModuleDependencies(@NotNull ClassId paramClassId);
  
  @NotNull
  public abstract <S extends MemberScope> S getOrPutScopeForClass(@NotNull ClassDescriptor paramClassDescriptor, @NotNull Function0<? extends S> paramFunction0);
  
  public abstract boolean isRefinementNeededForModule(@NotNull ModuleDescriptor paramModuleDescriptor);
  
  public abstract boolean isRefinementNeededForTypeConstructor(@NotNull TypeConstructor paramTypeConstructor);
  
  @Nullable
  public abstract ClassifierDescriptor refineDescriptor(@NotNull DeclarationDescriptor paramDeclarationDescriptor);
  
  @NotNull
  public abstract Collection<KotlinType> refineSupertypes(@NotNull ClassDescriptor paramClassDescriptor);
  
  @NotNull
  public abstract KotlinType refineType(@NotNull KotlinType paramKotlinType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
 * JD-Core Version:    0.7.0.1
 */