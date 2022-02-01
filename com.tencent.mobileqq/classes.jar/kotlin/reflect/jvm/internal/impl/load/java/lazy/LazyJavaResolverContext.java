package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.Lazy;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaResolverContext
{
  @NotNull
  private final JavaResolverComponents components;
  @Nullable
  private final Lazy defaultTypeQualifiers$delegate;
  @NotNull
  private final Lazy<JavaTypeQualifiersByElementType> delegateForDefaultTypeQualifiers;
  @NotNull
  private final TypeParameterResolver typeParameterResolver;
  @NotNull
  private final JavaTypeResolver typeResolver;
  
  public LazyJavaResolverContext(@NotNull JavaResolverComponents paramJavaResolverComponents, @NotNull TypeParameterResolver paramTypeParameterResolver, @NotNull Lazy<JavaTypeQualifiersByElementType> paramLazy)
  {
    this.components = paramJavaResolverComponents;
    this.typeParameterResolver = paramTypeParameterResolver;
    this.delegateForDefaultTypeQualifiers = paramLazy;
    this.defaultTypeQualifiers$delegate = this.delegateForDefaultTypeQualifiers;
    this.typeResolver = new JavaTypeResolver(this, this.typeParameterResolver);
  }
  
  @NotNull
  public final JavaResolverComponents getComponents()
  {
    return this.components;
  }
  
  @Nullable
  public final JavaTypeQualifiersByElementType getDefaultTypeQualifiers()
  {
    return (JavaTypeQualifiersByElementType)this.defaultTypeQualifiers$delegate.getValue();
  }
  
  @NotNull
  public final Lazy<JavaTypeQualifiersByElementType> getDelegateForDefaultTypeQualifiers$descriptors_jvm()
  {
    return this.delegateForDefaultTypeQualifiers;
  }
  
  @NotNull
  public final ModuleDescriptor getModule()
  {
    return this.components.getModule();
  }
  
  @NotNull
  public final StorageManager getStorageManager()
  {
    return this.components.getStorageManager();
  }
  
  @NotNull
  public final TypeParameterResolver getTypeParameterResolver()
  {
    return this.typeParameterResolver;
  }
  
  @NotNull
  public final JavaTypeResolver getTypeResolver()
  {
    return this.typeResolver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext
 * JD-Core Version:    0.7.0.1
 */