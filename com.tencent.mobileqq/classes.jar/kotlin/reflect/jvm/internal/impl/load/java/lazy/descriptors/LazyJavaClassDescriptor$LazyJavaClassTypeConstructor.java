package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassDescriptor$LazyJavaClassTypeConstructor
  extends AbstractClassTypeConstructor
{
  private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
  
  public LazyJavaClassDescriptor$LazyJavaClassTypeConstructor()
  {
    super(LazyJavaClassDescriptor.access$getC$p(localLazyJavaClassDescriptor).getStorageManager());
    this.parameters = LazyJavaClassDescriptor.access$getC$p(localLazyJavaClassDescriptor).getStorageManager().createLazyValue((Function0)new LazyJavaClassDescriptor.LazyJavaClassTypeConstructor.parameters.1(this));
  }
  
  private final KotlinType getPurelyImplementedSupertype()
  {
    Object localObject1 = getPurelyImplementsFqNameFromAnnotation();
    int i;
    if (localObject1 != null)
    {
      if ((!((FqName)localObject1).isRoot()) && (((FqName)localObject1).startsWith(KotlinBuiltIns.BUILT_INS_PACKAGE_NAME))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {}
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = localObject1;
    } else {
      localObject2 = FakePureImplementationsProvider.INSTANCE.getPurelyImplementedInterface(DescriptorUtilsKt.getFqNameSafe(this.this$0));
    }
    if (localObject2 != null)
    {
      localObject2 = DescriptorUtilsKt.resolveTopLevelClass(LazyJavaClassDescriptor.access$getC$p(this.this$0).getModule(), (FqName)localObject2, (LookupLocation)NoLookupLocation.FROM_JAVA_LOADER);
      if (localObject2 != null)
      {
        Object localObject3 = ((ClassDescriptor)localObject2).getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "classDescriptor.typeConstructor");
        i = ((TypeConstructor)localObject3).getParameters().size();
        localObject3 = this.this$0.getTypeConstructor().getParameters();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "getTypeConstructor().parameters");
        int j = ((List)localObject3).size();
        Object localObject4;
        if (j == i)
        {
          localObject3 = (Iterable)localObject3;
          localObject1 = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (TypeParameterDescriptor)((Iterator)localObject3).next();
            Variance localVariance = Variance.INVARIANT;
            Intrinsics.checkExpressionValueIsNotNull(localObject4, "parameter");
            ((Collection)localObject1).add(new TypeProjectionImpl(localVariance, (KotlinType)((TypeParameterDescriptor)localObject4).getDefaultType()));
          }
          localObject1 = (List)localObject1;
        }
        else
        {
          if ((j != 1) || (i <= 1) || (localObject1 != null)) {
            break label417;
          }
          localObject1 = Variance.INVARIANT;
          localObject3 = kotlin.collections.CollectionsKt.single((List)localObject3);
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "typeParameters.single()");
          localObject1 = new TypeProjectionImpl((Variance)localObject1, (KotlinType)((TypeParameterDescriptor)localObject3).getDefaultType());
          localObject4 = (Iterable)new IntRange(1, i);
          localObject3 = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            ((IntIterator)localObject4).nextInt();
            ((Collection)localObject3).add(localObject1);
          }
          localObject1 = (List)localObject3;
        }
        return (KotlinType)KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), (ClassDescriptor)localObject2, (List)localObject1);
      }
    }
    label417:
    return null;
  }
  
  private final FqName getPurelyImplementsFqNameFromAnnotation()
  {
    Object localObject1 = this.this$0.getAnnotations();
    FqName localFqName = JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION;
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
    Object localObject2 = ((Annotations)localObject1).findAnnotation(localFqName);
    localFqName = null;
    localObject1 = localFqName;
    if (localObject2 != null)
    {
      localObject2 = kotlin.collections.CollectionsKt.singleOrNull((Iterable)((AnnotationDescriptor)localObject2).getAllValueArguments().values());
      localObject1 = localObject2;
      if (!(localObject2 instanceof StringValue)) {
        localObject1 = null;
      }
      localObject2 = (StringValue)localObject1;
      localObject1 = localFqName;
      if (localObject2 != null)
      {
        localObject2 = (String)((StringValue)localObject2).getValue();
        localObject1 = localFqName;
        if (localObject2 != null)
        {
          if (!FqNamesUtilKt.isValidJavaFqName((String)localObject2)) {
            return null;
          }
          localObject1 = new FqName((String)localObject2);
        }
      }
    }
    return localObject1;
  }
  
  @NotNull
  protected Collection<KotlinType> computeSupertypes()
  {
    Object localObject1 = this.this$0.getJClass().getSupertypes();
    ArrayList localArrayList = new ArrayList(((Collection)localObject1).size());
    Object localObject3 = new ArrayList(0);
    Object localObject4 = getPurelyImplementedSupertype();
    Object localObject5 = ((Collection)localObject1).iterator();
    Object localObject2;
    for (;;)
    {
      boolean bool = ((Iterator)localObject5).hasNext();
      localObject2 = null;
      localObject1 = null;
      if (!bool) {
        break;
      }
      localObject6 = (JavaClassifierType)((Iterator)localObject5).next();
      localObject2 = LazyJavaClassDescriptor.access$getC$p(this.this$0).getTypeResolver().transformJavaType((JavaType)localObject6, JavaTypeResolverKt.toAttributes$default(TypeUsage.SUPERTYPE, false, null, 3, null));
      if ((((KotlinType)localObject2).getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor)) {
        ((ArrayList)localObject3).add(localObject6);
      }
      localObject6 = ((KotlinType)localObject2).getConstructor();
      if (localObject4 != null) {
        localObject1 = ((KotlinType)localObject4).getConstructor();
      }
      if ((!Intrinsics.areEqual(localObject6, localObject1)) && (!KotlinBuiltIns.isAnyOrNullableAny((KotlinType)localObject2))) {
        localArrayList.add(localObject2);
      }
    }
    localObject5 = (Collection)localArrayList;
    Object localObject6 = LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(this.this$0);
    localObject1 = localObject2;
    if (localObject6 != null) {
      localObject1 = MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor)localObject6, (ClassDescriptor)this.this$0).buildSubstitutor().substitute((KotlinType)((ClassDescriptor)localObject6).getDefaultType(), Variance.INVARIANT);
    }
    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)localObject5, localObject1);
    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)localObject5, localObject4);
    if ((((Collection)localObject3).isEmpty() ^ true))
    {
      localObject1 = LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getErrorReporter();
      localObject2 = getDeclarationDescriptor();
      localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (JavaType)((Iterator)localObject4).next();
        if (localObject6 != null) {
          ((Collection)localObject3).add(((JavaClassifierType)localObject6).getPresentableText());
        } else {
          throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
        }
      }
      ((ErrorReporter)localObject1).reportIncompleteHierarchy((ClassDescriptor)localObject2, (List)localObject3);
    }
    if ((((Collection)localObject5).isEmpty() ^ true)) {
      localObject1 = kotlin.collections.CollectionsKt.toList((Iterable)localArrayList);
    } else {
      localObject1 = kotlin.collections.CollectionsKt.listOf(LazyJavaClassDescriptor.access$getC$p(this.this$0).getModule().getBuiltIns().getAnyType());
    }
    return (Collection)localObject1;
  }
  
  @NotNull
  public ClassDescriptor getDeclarationDescriptor()
  {
    return (ClassDescriptor)this.this$0;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    return (List)this.parameters.invoke();
  }
  
  @NotNull
  protected SupertypeLoopChecker getSupertypeLoopChecker()
  {
    return LazyJavaClassDescriptor.access$getC$p(this.this$0).getComponents().getSupertypeLoopChecker();
  }
  
  public boolean isDenotable()
  {
    return true;
  }
  
  @NotNull
  public String toString()
  {
    String str = this.this$0.getName().asString();
    Intrinsics.checkExpressionValueIsNotNull(str, "name.asString()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.LazyJavaClassTypeConstructor
 * JD-Core Version:    0.7.0.1
 */