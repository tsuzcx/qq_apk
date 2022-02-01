package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaTypeParameterResolver
  implements TypeParameterResolver
{
  private final LazyJavaResolverContext c;
  private final DeclarationDescriptor containingDeclaration;
  private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> resolve;
  private final Map<JavaTypeParameter, Integer> typeParameters;
  private final int typeParametersIndexOffset;
  
  public LazyJavaTypeParameterResolver(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull JavaTypeParameterListOwner paramJavaTypeParameterListOwner, int paramInt)
  {
    this.c = paramLazyJavaResolverContext;
    this.containingDeclaration = paramDeclarationDescriptor;
    this.typeParametersIndexOffset = paramInt;
    this.typeParameters = CollectionsKt.mapToIndex((Iterable)paramJavaTypeParameterListOwner.getTypeParameters());
    this.resolve = this.c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new LazyJavaTypeParameterResolver.resolve.1(this));
  }
  
  @Nullable
  public TypeParameterDescriptor resolveTypeParameter(@NotNull JavaTypeParameter paramJavaTypeParameter)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaTypeParameter, "javaTypeParameter");
    LazyJavaTypeParameterDescriptor localLazyJavaTypeParameterDescriptor = (LazyJavaTypeParameterDescriptor)this.resolve.invoke(paramJavaTypeParameter);
    if (localLazyJavaTypeParameterDescriptor != null) {
      return (TypeParameterDescriptor)localLazyJavaTypeParameterDescriptor;
    }
    return this.c.getTypeParameterResolver().resolveTypeParameter(paramJavaTypeParameter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver
 * JD-Core Version:    0.7.0.1
 */