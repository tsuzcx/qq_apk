package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection<+Lkotlin.reflect.jvm.internal.impl.types.KotlinType;>;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver.QualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SignatureEnhancement$SignatureParts
{
  private final AnnotationTypeQualifierResolver.QualifierApplicabilityType containerApplicabilityType;
  private final LazyJavaResolverContext containerContext;
  private final Collection<KotlinType> fromOverridden;
  private final KotlinType fromOverride;
  private final boolean isCovariant;
  private final Annotated typeContainer;
  
  public SignatureEnhancement$SignatureParts(Annotated paramAnnotated, @Nullable KotlinType paramKotlinType, @NotNull Collection<? extends KotlinType> paramCollection, @NotNull boolean paramBoolean, LazyJavaResolverContext paramLazyJavaResolverContext, @NotNull AnnotationTypeQualifierResolver.QualifierApplicabilityType paramQualifierApplicabilityType)
  {
    this.typeContainer = paramKotlinType;
    this.fromOverride = paramCollection;
    this.fromOverridden = paramBoolean;
    this.isCovariant = paramLazyJavaResolverContext;
    this.containerContext = paramQualifierApplicabilityType;
    this.containerApplicabilityType = localObject;
  }
  
  private final Function1<Integer, JavaTypeQualifiers> computeIndexedQualifiersForOverride()
  {
    Object localObject2 = (Iterable)this.fromOverridden;
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(toIndexed((KotlinType)((Iterator)localObject2).next()));
    }
    localObject2 = (List)localObject1;
    List localList = toIndexed(this.fromOverride);
    if (this.isCovariant)
    {
      localObject1 = (Iterable)this.fromOverridden;
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject1).hasNext())
        {
          i = 0;
          break;
          localObject1 = ((Iterable)localObject1).iterator();
        }
        localObject3 = (KotlinType)((Iterator)localObject1).next();
      } while (!(KotlinTypeChecker.DEFAULT.equalTypes((KotlinType)localObject3, this.fromOverride) ^ true));
      i = 1;
      if (i != 0)
      {
        i = 1;
        break label194;
      }
    }
    int i = 0;
    label194:
    int j;
    if (i != 0) {
      j = 1;
    } else {
      j = localList.size();
    }
    Object localObject3 = new JavaTypeQualifiers[j];
    int k = 0;
    while (k < j)
    {
      boolean bool;
      if (k == 0) {
        bool = true;
      } else {
        bool = false;
      }
      int m;
      if ((!bool) && (i != 0)) {
        m = 0;
      } else {
        m = 1;
      }
      if ((_Assertions.ENABLED) && (m == 0)) {
        throw ((Throwable)new AssertionError("Only head type constructors should be computed"));
      }
      localObject1 = (TypeAndDefaultQualifiers)localList.get(k);
      KotlinType localKotlinType = ((TypeAndDefaultQualifiers)localObject1).component1();
      JavaTypeQualifiers localJavaTypeQualifiers = ((TypeAndDefaultQualifiers)localObject1).component2();
      localObject1 = (Iterable)localObject2;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = ((Iterable)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (TypeAndDefaultQualifiers)CollectionsKt.getOrNull((List)localIterator.next(), k);
        if (localObject1 != null) {
          localObject1 = ((TypeAndDefaultQualifiers)localObject1).getType();
        } else {
          localObject1 = null;
        }
        if (localObject1 != null) {
          localCollection.add(localObject1);
        }
      }
      localObject3[k] = computeQualifiersForOverride(localKotlinType, (Collection)(List)localCollection, localJavaTypeQualifiers, bool);
      k += 1;
    }
    return (Function1)new SignatureEnhancement.SignatureParts.computeIndexedQualifiersForOverride.1((JavaTypeQualifiers[])localObject3);
  }
  
  private final JavaTypeQualifiers computeQualifiersForOverride(@NotNull KotlinType paramKotlinType, Collection<? extends KotlinType> paramCollection, JavaTypeQualifiers paramJavaTypeQualifiers, boolean paramBoolean)
  {
    paramCollection = (Iterable)paramCollection;
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramCollection, 10));
    Object localObject2 = paramCollection.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(extractQualifiers((KotlinType)((Iterator)localObject2).next()));
    }
    Iterable localIterable = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = localIterable.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((JavaTypeQualifiers)((Iterator)localObject2).next()).getMutability();
      if (localObject3 != null) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    Object localObject3 = CollectionsKt.toSet((Iterable)localObject1);
    localObject1 = (Collection)new ArrayList();
    localObject2 = localIterable.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((JavaTypeQualifiers)((Iterator)localObject2).next()).getNullability();
      if (localObject4 != null) {
        ((Collection)localObject1).add(localObject4);
      }
    }
    Object localObject4 = CollectionsKt.toSet((Iterable)localObject1);
    localObject1 = (Collection)new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      localObject2 = extractQualifiers(TypeWithEnhancementKt.unwrapEnhancement((KotlinType)paramCollection.next())).getNullability();
      if (localObject2 != null) {
        ((Collection)localObject1).add(localObject2);
      }
    }
    Set localSet = CollectionsKt.toSet((Iterable)localObject1);
    paramJavaTypeQualifiers = extractQualifiersFromAnnotations(paramKotlinType, paramBoolean, paramJavaTypeQualifiers);
    boolean bool1 = paramJavaTypeQualifiers.isNullabilityQualifierForWarning();
    boolean bool2 = true;
    localObject1 = null;
    if ((bool1 ^ true)) {
      paramKotlinType = paramJavaTypeQualifiers;
    } else {
      paramKotlinType = null;
    }
    if (paramKotlinType != null) {
      paramKotlinType = paramKotlinType.getNullability();
    } else {
      paramKotlinType = null;
    }
    NullabilityQualifier localNullabilityQualifier = paramJavaTypeQualifiers.getNullability();
    if ((this.isCovariant) && (paramBoolean)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject2 = SignatureEnhancementKt.select((Set)localObject4, paramKotlinType, bool1);
    paramCollection = (Collection<? extends KotlinType>)localObject1;
    int i;
    if (localObject2 != null)
    {
      if ((isForVarargParameter()) && (paramBoolean) && (localObject2 == NullabilityQualifier.NULLABLE)) {
        i = 1;
      } else {
        i = 0;
      }
      paramCollection = (Collection<? extends KotlinType>)localObject1;
      if (i == 0) {
        paramCollection = (Collection<? extends KotlinType>)localObject2;
      }
    }
    localObject1 = (MutabilityQualifier)SignatureEnhancementKt.select((Set)localObject3, MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, paramJavaTypeQualifiers.getMutability(), bool1);
    if ((localNullabilityQualifier == paramKotlinType) && (!(Intrinsics.areEqual(localSet, localObject4) ^ true))) {
      i = 0;
    } else {
      i = 1;
    }
    if (!paramJavaTypeQualifiers.isNotNullTypeParameter())
    {
      if (((localIterable instanceof Collection)) && (((Collection)localIterable).isEmpty())) {}
      do
      {
        while (!paramKotlinType.hasNext())
        {
          j = 0;
          break;
          paramKotlinType = localIterable.iterator();
        }
      } while (!((JavaTypeQualifiers)paramKotlinType.next()).isNotNullTypeParameter());
      int j = 1;
      if (j == 0)
      {
        paramBoolean = false;
        break label582;
      }
    }
    paramBoolean = true;
    label582:
    if ((paramCollection == null) && (i != 0)) {
      return SignatureEnhancementKt.createJavaTypeQualifiers(SignatureEnhancementKt.select(localSet, localNullabilityQualifier, bool1), (MutabilityQualifier)localObject1, true, paramBoolean);
    }
    if (paramCollection == null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    return SignatureEnhancementKt.createJavaTypeQualifiers(paramCollection, (MutabilityQualifier)localObject1, bool1, paramBoolean);
  }
  
  private final NullabilityQualifierWithMigrationStatus extractNullability(@NotNull Annotations paramAnnotations)
  {
    Object localObject = (Iterable)paramAnnotations;
    paramAnnotations = this.this$0;
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      NullabilityQualifierWithMigrationStatus localNullabilityQualifierWithMigrationStatus = paramAnnotations.extractNullability((AnnotationDescriptor)((Iterator)localObject).next());
      if (localNullabilityQualifierWithMigrationStatus != null) {
        return localNullabilityQualifierWithMigrationStatus;
      }
    }
    return null;
  }
  
  private final JavaTypeQualifiers extractQualifiers(@NotNull KotlinType paramKotlinType)
  {
    if (FlexibleTypesKt.isFlexible(paramKotlinType))
    {
      localObject1 = FlexibleTypesKt.asFlexibleType(paramKotlinType);
      localObject1 = new Pair(((FlexibleType)localObject1).getLowerBound(), ((FlexibleType)localObject1).getUpperBound());
    }
    else
    {
      localObject1 = new Pair(paramKotlinType, paramKotlinType);
    }
    KotlinType localKotlinType1 = (KotlinType)((Pair)localObject1).component1();
    KotlinType localKotlinType2 = (KotlinType)((Pair)localObject1).component2();
    JavaToKotlinClassMap localJavaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
    if (localKotlinType1.isMarkedNullable()) {}
    for (Object localObject1 = NullabilityQualifier.NULLABLE;; localObject1 = NullabilityQualifier.NOT_NULL)
    {
      localObject2 = localObject1;
      break label98;
      if (localKotlinType2.isMarkedNullable()) {
        break;
      }
    }
    Object localObject2 = null;
    label98:
    if (localJavaToKotlinClassMap.isReadOnly(localKotlinType1)) {
      localObject1 = MutabilityQualifier.READ_ONLY;
    } else if (localJavaToKotlinClassMap.isMutable(localKotlinType2)) {
      localObject1 = MutabilityQualifier.MUTABLE;
    } else {
      localObject1 = null;
    }
    return new JavaTypeQualifiers(localObject2, (MutabilityQualifier)localObject1, paramKotlinType.unwrap() instanceof NotNullTypeParameter, false, 8, null);
  }
  
  private final JavaTypeQualifiers extractQualifiersFromAnnotations(@NotNull KotlinType paramKotlinType, boolean paramBoolean, JavaTypeQualifiers paramJavaTypeQualifiers)
  {
    if (paramBoolean)
    {
      localObject1 = this.typeContainer;
      if (localObject1 != null)
      {
        localObject1 = AnnotationsKt.composeAnnotations(((Annotated)localObject1).getAnnotations(), paramKotlinType.getAnnotations());
        break label40;
      }
    }
    Object localObject1 = paramKotlinType.getAnnotations();
    label40:
    Object localObject2 = new SignatureEnhancement.SignatureParts.extractQualifiersFromAnnotations.1((Annotations)localObject1);
    Object localObject3 = SignatureEnhancement.SignatureParts.extractQualifiersFromAnnotations.2.INSTANCE;
    NullabilityQualifier localNullabilityQualifier = null;
    if (paramBoolean)
    {
      paramJavaTypeQualifiers = this.containerContext.getDefaultTypeQualifiers();
      if (paramJavaTypeQualifiers != null) {
        paramJavaTypeQualifiers = paramJavaTypeQualifiers.get(this.containerApplicabilityType);
      } else {
        paramJavaTypeQualifiers = null;
      }
    }
    localObject1 = extractNullability((Annotations)localObject1);
    if (localObject1 != null) {
      paramJavaTypeQualifiers = (JavaTypeQualifiers)localObject1;
    } else if ((paramJavaTypeQualifiers != null) && (paramJavaTypeQualifiers.getNullability() != null)) {
      paramJavaTypeQualifiers = new NullabilityQualifierWithMigrationStatus(paramJavaTypeQualifiers.getNullability(), paramJavaTypeQualifiers.isNullabilityQualifierForWarning());
    } else {
      paramJavaTypeQualifiers = null;
    }
    if (paramJavaTypeQualifiers != null) {
      localObject1 = paramJavaTypeQualifiers.getQualifier();
    } else {
      localObject1 = null;
    }
    localObject2 = (MutabilityQualifier)((SignatureEnhancement.SignatureParts.extractQualifiersFromAnnotations.2)localObject3).invoke(((SignatureEnhancement.SignatureParts.extractQualifiersFromAnnotations.1)localObject2).invoke(JvmAnnotationNamesKt.getREAD_ONLY_ANNOTATIONS(), MutabilityQualifier.READ_ONLY), ((SignatureEnhancement.SignatureParts.extractQualifiersFromAnnotations.1)localObject2).invoke(JvmAnnotationNamesKt.getMUTABLE_ANNOTATIONS(), MutabilityQualifier.MUTABLE));
    if (paramJavaTypeQualifiers != null) {
      localNullabilityQualifier = paramJavaTypeQualifiers.getQualifier();
    }
    localObject3 = NullabilityQualifier.NOT_NULL;
    boolean bool2 = false;
    if ((localNullabilityQualifier == localObject3) && (TypeUtilsKt.isTypeParameter(paramKotlinType))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    boolean bool1 = bool2;
    if (paramJavaTypeQualifiers != null)
    {
      bool1 = bool2;
      if (paramJavaTypeQualifiers.isForWarningOnly() == true) {
        bool1 = true;
      }
    }
    return new JavaTypeQualifiers((NullabilityQualifier)localObject1, (MutabilityQualifier)localObject2, paramBoolean, bool1);
  }
  
  private final boolean isForVarargParameter()
  {
    Object localObject1 = this.typeContainer;
    boolean bool = localObject1 instanceof ValueParameterDescriptor;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    ValueParameterDescriptor localValueParameterDescriptor = (ValueParameterDescriptor)localObject1;
    localObject1 = localObject2;
    if (localValueParameterDescriptor != null) {
      localObject1 = localValueParameterDescriptor.getVarargElementType();
    }
    return localObject1 != null;
  }
  
  private final List<TypeAndDefaultQualifiers> toIndexed(@NotNull KotlinType paramKotlinType)
  {
    ArrayList localArrayList = new ArrayList(1);
    new SignatureEnhancement.SignatureParts.toIndexed.1(localArrayList).invoke(paramKotlinType, this.containerContext);
    return (List)localArrayList;
  }
  
  @NotNull
  public final SignatureEnhancement.PartEnhancementResult enhance(@Nullable TypeEnhancementInfo paramTypeEnhancementInfo)
  {
    Function1 localFunction1 = computeIndexedQualifiersForOverride();
    if (paramTypeEnhancementInfo != null) {
      paramTypeEnhancementInfo = (Function1)new SignatureEnhancement.SignatureParts.enhance..inlined.let.lambda.1(paramTypeEnhancementInfo, localFunction1);
    } else {
      paramTypeEnhancementInfo = null;
    }
    boolean bool = TypeUtils.contains(this.fromOverride, (Function1)SignatureEnhancement.SignatureParts.enhance.containsFunctionN.1.INSTANCE);
    KotlinType localKotlinType = this.fromOverride;
    if (paramTypeEnhancementInfo == null) {
      paramTypeEnhancementInfo = localFunction1;
    }
    paramTypeEnhancementInfo = TypeEnhancementKt.enhance(localKotlinType, paramTypeEnhancementInfo);
    if (paramTypeEnhancementInfo != null) {
      return new SignatureEnhancement.PartEnhancementResult(paramTypeEnhancementInfo, true, bool);
    }
    return new SignatureEnhancement.PartEnhancementResult(this.fromOverride, false, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts
 * JD-Core Version:    0.7.0.1
 */