package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.NullabilityQualifierWithApplicability;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.Jsr305State;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnnotationTypeQualifierResolver
{
  private final boolean disabled;
  private final Jsr305State jsr305State;
  private final MemoizedFunctionToNullable<ClassDescriptor, AnnotationDescriptor> resolvedNicknames;
  
  public AnnotationTypeQualifierResolver(@NotNull StorageManager paramStorageManager, @NotNull Jsr305State paramJsr305State)
  {
    this.jsr305State = paramJsr305State;
    this.resolvedNicknames = paramStorageManager.createMemoizedFunctionWithNullableValues((Function1)new AnnotationTypeQualifierResolver.resolvedNicknames.1((AnnotationTypeQualifierResolver)this));
    this.disabled = this.jsr305State.getDisabled();
  }
  
  private final AnnotationDescriptor computeTypeQualifierNickname(ClassDescriptor paramClassDescriptor)
  {
    if (!paramClassDescriptor.getAnnotations().hasAnnotation(AnnotationTypeQualifierResolverKt.getTYPE_QUALIFIER_NICKNAME_FQNAME())) {
      return null;
    }
    paramClassDescriptor = ((Iterable)paramClassDescriptor.getAnnotations()).iterator();
    while (paramClassDescriptor.hasNext())
    {
      AnnotationDescriptor localAnnotationDescriptor = (AnnotationDescriptor)paramClassDescriptor.next();
      localAnnotationDescriptor = ((AnnotationTypeQualifierResolver)this).resolveTypeQualifierAnnotation(localAnnotationDescriptor);
      if (localAnnotationDescriptor != null) {
        return localAnnotationDescriptor;
      }
    }
    return null;
  }
  
  private final List<AnnotationTypeQualifierResolver.QualifierApplicabilityType> mapConstantToQualifierApplicabilityTypes(@NotNull ConstantValue<?> paramConstantValue)
  {
    if ((paramConstantValue instanceof ArrayValue))
    {
      Object localObject = (Iterable)((ArrayValue)paramConstantValue).getValue();
      paramConstantValue = (Collection)new ArrayList();
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        CollectionsKt.addAll(paramConstantValue, (Iterable)mapConstantToQualifierApplicabilityTypes((ConstantValue)((Iterator)localObject).next()));
      }
      return (List)paramConstantValue;
    }
    if ((paramConstantValue instanceof EnumValue))
    {
      paramConstantValue = ((EnumValue)paramConstantValue).getEnumEntryName().getIdentifier();
      switch (paramConstantValue.hashCode())
      {
      default: 
        break;
      case 446088073: 
        if (paramConstantValue.equals("PARAMETER")) {
          paramConstantValue = AnnotationTypeQualifierResolver.QualifierApplicabilityType.VALUE_PARAMETER;
        }
        break;
      case 107598562: 
        if (paramConstantValue.equals("TYPE_USE")) {
          paramConstantValue = AnnotationTypeQualifierResolver.QualifierApplicabilityType.TYPE_USE;
        }
        break;
      case 66889946: 
        if (paramConstantValue.equals("FIELD")) {
          paramConstantValue = AnnotationTypeQualifierResolver.QualifierApplicabilityType.FIELD;
        }
        break;
      case -2024225567: 
        if (paramConstantValue.equals("METHOD")) {
          paramConstantValue = AnnotationTypeQualifierResolver.QualifierApplicabilityType.METHOD_RETURN_TYPE;
        }
        break;
      }
      paramConstantValue = null;
      return CollectionsKt.listOfNotNull(paramConstantValue);
    }
    return CollectionsKt.emptyList();
  }
  
  private final ReportLevel migrationAnnotationStatus(@NotNull ClassDescriptor paramClassDescriptor)
  {
    paramClassDescriptor = paramClassDescriptor.getAnnotations().findAnnotation(AnnotationTypeQualifierResolverKt.getMIGRATION_ANNOTATION_FQNAME());
    Object localObject2 = null;
    if (paramClassDescriptor != null) {
      paramClassDescriptor = DescriptorUtilsKt.firstArgument(paramClassDescriptor);
    } else {
      paramClassDescriptor = null;
    }
    Object localObject1 = paramClassDescriptor;
    if (!(paramClassDescriptor instanceof EnumValue)) {
      localObject1 = null;
    }
    localObject1 = (EnumValue)localObject1;
    paramClassDescriptor = localObject2;
    if (localObject1 != null)
    {
      paramClassDescriptor = this.jsr305State.getMigration();
      if (paramClassDescriptor != null) {
        return paramClassDescriptor;
      }
      localObject1 = ((EnumValue)localObject1).getEnumEntryName().asString();
      int i = ((String)localObject1).hashCode();
      if (i != -2137067054)
      {
        if (i != -1838656823)
        {
          if (i != 2656902) {
            return null;
          }
          paramClassDescriptor = localObject2;
          if (((String)localObject1).equals("WARN")) {
            return ReportLevel.WARN;
          }
        }
        else
        {
          paramClassDescriptor = localObject2;
          if (((String)localObject1).equals("STRICT")) {
            return ReportLevel.STRICT;
          }
        }
      }
      else
      {
        paramClassDescriptor = localObject2;
        if (((String)localObject1).equals("IGNORE")) {
          paramClassDescriptor = ReportLevel.IGNORE;
        }
      }
    }
    return paramClassDescriptor;
  }
  
  private final AnnotationDescriptor resolveTypeQualifierNickname(ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor.getKind() != ClassKind.ANNOTATION_CLASS) {
      return null;
    }
    return (AnnotationDescriptor)this.resolvedNicknames.invoke(paramClassDescriptor);
  }
  
  public final boolean getDisabled()
  {
    return this.disabled;
  }
  
  @NotNull
  public final ReportLevel resolveJsr305AnnotationState(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationDescriptor, "annotationDescriptor");
    paramAnnotationDescriptor = resolveJsr305CustomState(paramAnnotationDescriptor);
    if (paramAnnotationDescriptor != null) {
      return paramAnnotationDescriptor;
    }
    return this.jsr305State.getGlobal();
  }
  
  @Nullable
  public final ReportLevel resolveJsr305CustomState(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationDescriptor, "annotationDescriptor");
    Map localMap = this.jsr305State.getUser();
    Object localObject1 = paramAnnotationDescriptor.getFqName();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((FqName)localObject1).asString();
    } else {
      localObject1 = null;
    }
    localObject1 = (ReportLevel)localMap.get(localObject1);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = DescriptorUtilsKt.getAnnotationClass(paramAnnotationDescriptor);
    paramAnnotationDescriptor = localObject2;
    if (localObject1 != null) {
      paramAnnotationDescriptor = migrationAnnotationStatus((ClassDescriptor)localObject1);
    }
    return paramAnnotationDescriptor;
  }
  
  @Nullable
  public final NullabilityQualifierWithApplicability resolveQualifierBuiltInDefaultAnnotation(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationDescriptor, "annotationDescriptor");
    if (this.jsr305State.getDisabled()) {
      return null;
    }
    Object localObject = (NullabilityQualifierWithApplicability)AnnotationTypeQualifierResolverKt.getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS().get(paramAnnotationDescriptor.getFqName());
    if (localObject != null)
    {
      NullabilityQualifierWithMigrationStatus localNullabilityQualifierWithMigrationStatus = ((NullabilityQualifierWithApplicability)localObject).component1();
      localObject = ((NullabilityQualifierWithApplicability)localObject).component2();
      paramAnnotationDescriptor = resolveJsr305AnnotationState(paramAnnotationDescriptor);
      int i;
      if (paramAnnotationDescriptor != ReportLevel.IGNORE) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        paramAnnotationDescriptor = null;
      }
      if (paramAnnotationDescriptor != null) {
        return new NullabilityQualifierWithApplicability(NullabilityQualifierWithMigrationStatus.copy$default(localNullabilityQualifierWithMigrationStatus, null, paramAnnotationDescriptor.isWarning(), 1, null), (Collection)localObject);
      }
      return null;
    }
    return (NullabilityQualifierWithApplicability)null;
  }
  
  @Nullable
  public final AnnotationDescriptor resolveTypeQualifierAnnotation(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationDescriptor, "annotationDescriptor");
    if (this.jsr305State.getDisabled()) {
      return null;
    }
    ClassDescriptor localClassDescriptor = DescriptorUtilsKt.getAnnotationClass(paramAnnotationDescriptor);
    if (localClassDescriptor != null)
    {
      if (AnnotationTypeQualifierResolverKt.access$isAnnotatedWithTypeQualifier$p(localClassDescriptor)) {
        return paramAnnotationDescriptor;
      }
      return resolveTypeQualifierNickname(localClassDescriptor);
    }
    return null;
  }
  
  @Nullable
  public final AnnotationTypeQualifierResolver.TypeQualifierWithApplicability resolveTypeQualifierDefaultAnnotation(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationDescriptor, "annotationDescriptor");
    if (this.jsr305State.getDisabled()) {
      return null;
    }
    Object localObject1 = DescriptorUtilsKt.getAnnotationClass(paramAnnotationDescriptor);
    if (localObject1 != null)
    {
      if (!((ClassDescriptor)localObject1).getAnnotations().hasAnnotation(AnnotationTypeQualifierResolverKt.getTYPE_QUALIFIER_DEFAULT_FQNAME())) {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        paramAnnotationDescriptor = DescriptorUtilsKt.getAnnotationClass(paramAnnotationDescriptor);
        if (paramAnnotationDescriptor == null) {
          Intrinsics.throwNpe();
        }
        paramAnnotationDescriptor = paramAnnotationDescriptor.getAnnotations().findAnnotation(AnnotationTypeQualifierResolverKt.getTYPE_QUALIFIER_DEFAULT_FQNAME());
        if (paramAnnotationDescriptor == null) {
          Intrinsics.throwNpe();
        }
        paramAnnotationDescriptor = paramAnnotationDescriptor.getAllValueArguments();
        Collection localCollection = (Collection)new ArrayList();
        Iterator localIterator = paramAnnotationDescriptor.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          paramAnnotationDescriptor = (Name)((Map.Entry)localObject2).getKey();
          localObject2 = (ConstantValue)((Map.Entry)localObject2).getValue();
          if (Intrinsics.areEqual(paramAnnotationDescriptor, JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
            paramAnnotationDescriptor = mapConstantToQualifierApplicabilityTypes((ConstantValue)localObject2);
          } else {
            paramAnnotationDescriptor = CollectionsKt.emptyList();
          }
          CollectionsKt.addAll(localCollection, (Iterable)paramAnnotationDescriptor);
        }
        paramAnnotationDescriptor = ((Iterable)localCollection).iterator();
        int i = 0;
        while (paramAnnotationDescriptor.hasNext()) {
          i |= 1 << ((AnnotationTypeQualifierResolver.QualifierApplicabilityType)paramAnnotationDescriptor.next()).ordinal();
        }
        localObject1 = ((Iterable)((ClassDescriptor)localObject1).getAnnotations()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramAnnotationDescriptor = ((Iterator)localObject1).next();
          int j;
          if (resolveTypeQualifierAnnotation((AnnotationDescriptor)paramAnnotationDescriptor) != null) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0) {
            break label313;
          }
        }
        paramAnnotationDescriptor = null;
        label313:
        paramAnnotationDescriptor = (AnnotationDescriptor)paramAnnotationDescriptor;
        if (paramAnnotationDescriptor != null) {
          return new AnnotationTypeQualifierResolver.TypeQualifierWithApplicability(paramAnnotationDescriptor, i);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver
 * JD-Core Version:    0.7.0.1
 */