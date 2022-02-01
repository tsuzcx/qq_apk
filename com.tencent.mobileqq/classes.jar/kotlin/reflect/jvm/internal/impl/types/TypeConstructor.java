package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface TypeConstructor
  extends TypeConstructorMarker
{
  @NotNull
  public abstract KotlinBuiltIns getBuiltIns();
  
  @Nullable
  public abstract ClassifierDescriptor getDeclarationDescriptor();
  
  @NotNull
  public abstract List<TypeParameterDescriptor> getParameters();
  
  @NotNull
  public abstract Collection<KotlinType> getSupertypes();
  
  public abstract boolean isDenotable();
  
  @NotNull
  public abstract TypeConstructor refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeConstructor
 * JD-Core Version:    0.7.0.1
 */