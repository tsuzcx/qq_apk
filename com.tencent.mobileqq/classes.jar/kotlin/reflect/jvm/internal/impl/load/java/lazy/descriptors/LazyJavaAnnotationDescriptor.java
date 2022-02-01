package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaAnnotationDescriptor
  implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor
{
  @NotNull
  private final NotNullLazyValue allValueArguments$delegate;
  private final LazyJavaResolverContext c;
  @Nullable
  private final NullableLazyValue fqName$delegate;
  private final boolean isIdeExternalAnnotation;
  private final JavaAnnotation javaAnnotation;
  @NotNull
  private final JavaSourceElement source;
  @NotNull
  private final NotNullLazyValue type$delegate;
  
  public LazyJavaAnnotationDescriptor(@NotNull LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull JavaAnnotation paramJavaAnnotation)
  {
    this.c = paramLazyJavaResolverContext;
    this.javaAnnotation = paramJavaAnnotation;
    this.fqName$delegate = this.c.getStorageManager().createNullableLazyValue((Function0)new LazyJavaAnnotationDescriptor.fqName.2(this));
    this.type$delegate = this.c.getStorageManager().createLazyValue((Function0)new LazyJavaAnnotationDescriptor.type.2(this));
    this.source = this.c.getComponents().getSourceElementFactory().source((JavaElement)this.javaAnnotation);
    this.allValueArguments$delegate = this.c.getStorageManager().createLazyValue((Function0)new LazyJavaAnnotationDescriptor.allValueArguments.2(this));
    this.isIdeExternalAnnotation = this.javaAnnotation.isIdeExternalAnnotation();
  }
  
  private final ClassDescriptor createTypeForMissingDependencies(FqName paramFqName)
  {
    ModuleDescriptor localModuleDescriptor = this.c.getModule();
    paramFqName = ClassId.topLevel(paramFqName);
    Intrinsics.checkExpressionValueIsNotNull(paramFqName, "ClassId.topLevel(fqName)");
    return FindClassInModuleKt.findNonGenericClassAcrossDependencies(localModuleDescriptor, paramFqName, this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses());
  }
  
  private final ConstantValue<?> resolveAnnotationArgument(JavaAnnotationArgument paramJavaAnnotationArgument)
  {
    if ((paramJavaAnnotationArgument instanceof JavaLiteralAnnotationArgument)) {
      return ConstantValueFactory.INSTANCE.createConstantValue(((JavaLiteralAnnotationArgument)paramJavaAnnotationArgument).getValue());
    }
    if ((paramJavaAnnotationArgument instanceof JavaEnumValueAnnotationArgument))
    {
      paramJavaAnnotationArgument = (JavaEnumValueAnnotationArgument)paramJavaAnnotationArgument;
      return resolveFromEnumValue(paramJavaAnnotationArgument.getEnumClassId(), paramJavaAnnotationArgument.getEntryName());
    }
    if ((paramJavaAnnotationArgument instanceof JavaArrayAnnotationArgument))
    {
      Name localName = paramJavaAnnotationArgument.getName();
      if (localName == null)
      {
        localName = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
        Intrinsics.checkExpressionValueIsNotNull(localName, "DEFAULT_ANNOTATION_MEMBER_NAME");
      }
      return resolveFromArray(localName, ((JavaArrayAnnotationArgument)paramJavaAnnotationArgument).getElements());
    }
    if ((paramJavaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument)) {
      return resolveFromAnnotation(((JavaAnnotationAsAnnotationArgument)paramJavaAnnotationArgument).getAnnotation());
    }
    if ((paramJavaAnnotationArgument instanceof JavaClassObjectAnnotationArgument)) {
      return resolveFromJavaClassObjectType(((JavaClassObjectAnnotationArgument)paramJavaAnnotationArgument).getReferencedType());
    }
    return null;
  }
  
  private final ConstantValue<?> resolveFromAnnotation(JavaAnnotation paramJavaAnnotation)
  {
    return (ConstantValue)new AnnotationValue((AnnotationDescriptor)new LazyJavaAnnotationDescriptor(this.c, paramJavaAnnotation));
  }
  
  private final ConstantValue<?> resolveFromArray(Name paramName, List<? extends JavaAnnotationArgument> paramList)
  {
    Object localObject = getType();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "type");
    if (KotlinTypeKt.isError((KotlinType)localObject)) {
      return null;
    }
    localObject = DescriptorUtilsKt.getAnnotationClass(this);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramName = DescriptorResolverUtils.getAnnotationParameterByName(paramName, (ClassDescriptor)localObject);
    if (paramName != null)
    {
      paramName = paramName.getType();
      if (paramName != null) {}
    }
    else
    {
      paramName = (KotlinType)this.c.getComponents().getModule().getBuiltIns().getArrayType(Variance.INVARIANT, (KotlinType)ErrorUtils.createErrorType("Unknown array element type"));
    }
    Intrinsics.checkExpressionValueIsNotNull(paramName, "DescriptorResolverUtils.… type\")\n                )");
    paramList = (Iterable)paramList;
    localObject = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = resolveAnnotationArgument((JavaAnnotationArgument)localIterator.next());
      if (paramList == null) {
        paramList = (ConstantValue)new NullValue();
      }
      ((Collection)localObject).add(paramList);
    }
    paramList = (List)localObject;
    return (ConstantValue)ConstantValueFactory.INSTANCE.createArrayValue(paramList, paramName);
  }
  
  private final ConstantValue<?> resolveFromEnumValue(ClassId paramClassId, Name paramName)
  {
    if ((paramClassId != null) && (paramName != null)) {
      return (ConstantValue)new EnumValue(paramClassId, paramName);
    }
    return null;
  }
  
  private final ConstantValue<?> resolveFromJavaClassObjectType(JavaType paramJavaType)
  {
    return KClassValue.Companion.create(this.c.getTypeResolver().transformJavaType(paramJavaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null)));
  }
  
  @NotNull
  public Map<Name, ConstantValue<?>> getAllValueArguments()
  {
    return (Map)StorageKt.getValue(this.allValueArguments$delegate, this, $$delegatedProperties[2]);
  }
  
  @Nullable
  public FqName getFqName()
  {
    return (FqName)StorageKt.getValue(this.fqName$delegate, this, $$delegatedProperties[0]);
  }
  
  @NotNull
  public JavaSourceElement getSource()
  {
    return this.source;
  }
  
  @NotNull
  public SimpleType getType()
  {
    return (SimpleType)StorageKt.getValue(this.type$delegate, this, $$delegatedProperties[1]);
  }
  
  public boolean isIdeExternalAnnotation()
  {
    return this.isIdeExternalAnnotation;
  }
  
  @NotNull
  public String toString()
  {
    return DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.FQ_NAMES_IN_TYPES, (AnnotationDescriptor)this, null, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor
 * JD-Core Version:    0.7.0.1
 */