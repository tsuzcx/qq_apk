package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaAnnotationDescriptor
  implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor
{
  @Nullable
  private final JavaAnnotationArgument firstArgument;
  @NotNull
  private final FqName fqName;
  private final boolean isIdeExternalAnnotation;
  @NotNull
  private final SourceElement source;
  @NotNull
  private final NotNullLazyValue type$delegate;
  
  public JavaAnnotationDescriptor(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @Nullable JavaAnnotation paramJavaAnnotation, @NotNull FqName paramFqName)
  {
    this.fqName = paramFqName;
    if (paramJavaAnnotation != null)
    {
      paramFqName = paramLazyJavaResolverContext.getComponents().getSourceElementFactory().source((JavaElement)paramJavaAnnotation);
      if (paramFqName != null)
      {
        paramFqName = (SourceElement)paramFqName;
        break label64;
      }
    }
    paramFqName = SourceElement.NO_SOURCE;
    Intrinsics.checkExpressionValueIsNotNull(paramFqName, "SourceElement.NO_SOURCE");
    label64:
    this.source = paramFqName;
    this.type$delegate = paramLazyJavaResolverContext.getStorageManager().createLazyValue((Function0)new JavaAnnotationDescriptor.type.2(this, paramLazyJavaResolverContext));
    if (paramJavaAnnotation != null)
    {
      paramLazyJavaResolverContext = paramJavaAnnotation.getArguments();
      if (paramLazyJavaResolverContext != null)
      {
        paramLazyJavaResolverContext = (JavaAnnotationArgument)CollectionsKt.firstOrNull((Iterable)paramLazyJavaResolverContext);
        break label125;
      }
    }
    paramLazyJavaResolverContext = null;
    label125:
    this.firstArgument = paramLazyJavaResolverContext;
    boolean bool = true;
    if ((paramJavaAnnotation == null) || (paramJavaAnnotation.isIdeExternalAnnotation() != true)) {
      bool = false;
    }
    this.isIdeExternalAnnotation = bool;
  }
  
  @NotNull
  public Map<Name, ConstantValue<?>> getAllValueArguments()
  {
    return MapsKt.emptyMap();
  }
  
  @Nullable
  protected final JavaAnnotationArgument getFirstArgument()
  {
    return this.firstArgument;
  }
  
  @NotNull
  public FqName getFqName()
  {
    return this.fqName;
  }
  
  @NotNull
  public SourceElement getSource()
  {
    return this.source;
  }
  
  @NotNull
  public SimpleType getType()
  {
    return (SimpleType)StorageKt.getValue(this.type$delegate, this, $$delegatedProperties[0]);
  }
  
  public boolean isIdeExternalAnnotation()
  {
    return this.isIdeExternalAnnotation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor
 * JD-Core Version:    0.7.0.1
 */