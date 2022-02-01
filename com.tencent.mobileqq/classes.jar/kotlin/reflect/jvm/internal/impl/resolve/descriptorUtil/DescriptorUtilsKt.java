package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.Ref;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorUtilsKt
{
  private static final Name RETENTION_PARAMETER_NAME;
  
  static
  {
    Name localName = Name.identifier("value");
    Intrinsics.checkExpressionValueIsNotNull(localName, "Name.identifier(\"value\")");
    RETENTION_PARAMETER_NAME = localName;
  }
  
  @NotNull
  public static final Collection<ClassDescriptor> computeSealedSubclasses(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "sealedClass");
    if (paramClassDescriptor.getModality() != Modality.SEALED) {
      return (Collection)CollectionsKt.emptyList();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    DescriptorUtilsKt.computeSealedSubclasses.1 local1 = new DescriptorUtilsKt.computeSealedSubclasses.1(paramClassDescriptor, localLinkedHashSet);
    DeclarationDescriptor localDeclarationDescriptor = paramClassDescriptor.getContainingDeclaration();
    Intrinsics.checkExpressionValueIsNotNull(localDeclarationDescriptor, "sealedClass.containingDeclaration");
    if ((localDeclarationDescriptor instanceof PackageFragmentDescriptor)) {
      local1.invoke(((PackageFragmentDescriptor)localDeclarationDescriptor).getMemberScope(), false);
    }
    paramClassDescriptor = paramClassDescriptor.getUnsubstitutedInnerClassesScope();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "sealedClass.unsubstitutedInnerClassesScope");
    local1.invoke(paramClassDescriptor, true);
    return (Collection)localLinkedHashSet;
  }
  
  public static final boolean declaresOrInheritsDefaultValue(@NotNull ValueParameterDescriptor paramValueParameterDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramValueParameterDescriptor, "$this$declaresOrInheritsDefaultValue");
    paramValueParameterDescriptor = DFS.ifAny((Collection)CollectionsKt.listOf(paramValueParameterDescriptor), (DFS.Neighbors)DescriptorUtilsKt.declaresOrInheritsDefaultValue.1.INSTANCE, (Function1)DescriptorUtilsKt.declaresOrInheritsDefaultValue.2.INSTANCE);
    Intrinsics.checkExpressionValueIsNotNull(paramValueParameterDescriptor, "DFS.ifAny(\n        listO…eclaresDefaultValue\n    )");
    return paramValueParameterDescriptor.booleanValue();
  }
  
  @Nullable
  public static final ConstantValue<?> firstArgument(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationDescriptor, "$this$firstArgument");
    return (ConstantValue)CollectionsKt.firstOrNull((Iterable)paramAnnotationDescriptor.getAllValueArguments().values());
  }
  
  @Nullable
  public static final CallableMemberDescriptor firstOverridden(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, boolean paramBoolean, @NotNull Function1<? super CallableMemberDescriptor, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "$this$firstOverridden");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((CallableMemberDescriptor)null);
    return (CallableMemberDescriptor)DFS.dfs((Collection)CollectionsKt.listOf(paramCallableMemberDescriptor), (DFS.Neighbors)new DescriptorUtilsKt.firstOverridden.1(paramBoolean), (DFS.NodeHandler)new DescriptorUtilsKt.firstOverridden.2(localObjectRef, paramFunction1));
  }
  
  @Nullable
  public static final FqName fqNameOrNull(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$fqNameOrNull");
    paramDeclarationDescriptor = getFqNameUnsafe(paramDeclarationDescriptor);
    boolean bool = paramDeclarationDescriptor.isSafe();
    FqName localFqName = null;
    if (!bool) {
      paramDeclarationDescriptor = null;
    }
    if (paramDeclarationDescriptor != null) {
      localFqName = paramDeclarationDescriptor.toSafe();
    }
    return localFqName;
  }
  
  @Nullable
  public static final ClassDescriptor getAnnotationClass(@NotNull AnnotationDescriptor paramAnnotationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationDescriptor, "$this$annotationClass");
    ClassifierDescriptor localClassifierDescriptor = paramAnnotationDescriptor.getType().getConstructor().getDeclarationDescriptor();
    paramAnnotationDescriptor = localClassifierDescriptor;
    if (!(localClassifierDescriptor instanceof ClassDescriptor)) {
      paramAnnotationDescriptor = null;
    }
    return (ClassDescriptor)paramAnnotationDescriptor;
  }
  
  @NotNull
  public static final KotlinBuiltIns getBuiltIns(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$builtIns");
    return getModule(paramDeclarationDescriptor).getBuiltIns();
  }
  
  @Nullable
  public static final ClassId getClassId(@Nullable ClassifierDescriptor paramClassifierDescriptor)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramClassifierDescriptor != null)
    {
      Object localObject3 = paramClassifierDescriptor.getContainingDeclaration();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        if ((localObject3 instanceof PackageFragmentDescriptor)) {
          return new ClassId(((PackageFragmentDescriptor)localObject3).getFqName(), paramClassifierDescriptor.getName());
        }
        localObject1 = localObject2;
        if ((localObject3 instanceof ClassifierDescriptorWithTypeParameters))
        {
          localObject3 = getClassId((ClassifierDescriptor)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((ClassId)localObject3).createNestedClassId(paramClassifierDescriptor.getName());
          }
        }
      }
    }
    return localObject1;
  }
  
  @NotNull
  public static final FqName getFqNameSafe(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$fqNameSafe");
    paramDeclarationDescriptor = DescriptorUtils.getFqNameSafe(paramDeclarationDescriptor);
    Intrinsics.checkExpressionValueIsNotNull(paramDeclarationDescriptor, "DescriptorUtils.getFqNameSafe(this)");
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  public static final FqNameUnsafe getFqNameUnsafe(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$fqNameUnsafe");
    paramDeclarationDescriptor = DescriptorUtils.getFqName(paramDeclarationDescriptor);
    Intrinsics.checkExpressionValueIsNotNull(paramDeclarationDescriptor, "DescriptorUtils.getFqName(this)");
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  public static final KotlinTypeRefiner getKotlinTypeRefiner(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "$this$getKotlinTypeRefiner");
    paramModuleDescriptor = (Ref)paramModuleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
    if (paramModuleDescriptor != null)
    {
      paramModuleDescriptor = (KotlinTypeRefiner)paramModuleDescriptor.getValue();
      if (paramModuleDescriptor != null) {
        return paramModuleDescriptor;
      }
    }
    return (KotlinTypeRefiner)KotlinTypeRefiner.Default.INSTANCE;
  }
  
  @NotNull
  public static final ModuleDescriptor getModule(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$module");
    paramDeclarationDescriptor = DescriptorUtils.getContainingModule(paramDeclarationDescriptor);
    Intrinsics.checkExpressionValueIsNotNull(paramDeclarationDescriptor, "DescriptorUtils.getContainingModule(this)");
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  public static final Sequence<DeclarationDescriptor> getParents(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$parents");
    return SequencesKt.drop(getParentsWithSelf(paramDeclarationDescriptor), 1);
  }
  
  @NotNull
  public static final Sequence<DeclarationDescriptor> getParentsWithSelf(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "$this$parentsWithSelf");
    return SequencesKt.generateSequence(paramDeclarationDescriptor, (Function1)DescriptorUtilsKt.parentsWithSelf.1.INSTANCE);
  }
  
  @NotNull
  public static final CallableMemberDescriptor getPropertyIfAccessor(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "$this$propertyIfAccessor");
    CallableMemberDescriptor localCallableMemberDescriptor = paramCallableMemberDescriptor;
    if ((paramCallableMemberDescriptor instanceof PropertyAccessorDescriptor))
    {
      paramCallableMemberDescriptor = ((PropertyAccessorDescriptor)paramCallableMemberDescriptor).getCorrespondingProperty();
      Intrinsics.checkExpressionValueIsNotNull(paramCallableMemberDescriptor, "correspondingProperty");
      localCallableMemberDescriptor = (CallableMemberDescriptor)paramCallableMemberDescriptor;
    }
    return localCallableMemberDescriptor;
  }
  
  @Nullable
  public static final ClassDescriptor getSuperClassNotAny(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "$this$getSuperClassNotAny");
    paramClassDescriptor = paramClassDescriptor.getDefaultType().getConstructor().getSupertypes().iterator();
    while (paramClassDescriptor.hasNext())
    {
      Object localObject = (KotlinType)paramClassDescriptor.next();
      if (!KotlinBuiltIns.isAnyOrNullableAny((KotlinType)localObject))
      {
        localObject = ((KotlinType)localObject).getConstructor().getDeclarationDescriptor();
        if (DescriptorUtils.isClassOrEnumClass((DeclarationDescriptor)localObject))
        {
          if (localObject != null) {
            return (ClassDescriptor)localObject;
          }
          throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
      }
    }
    return null;
  }
  
  public static final boolean isTypeRefinementEnabled(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "$this$isTypeRefinementEnabled");
    paramModuleDescriptor = (Ref)paramModuleDescriptor.getCapability(KotlinTypeRefinerKt.getREFINER_CAPABILITY());
    if (paramModuleDescriptor != null) {
      paramModuleDescriptor = (KotlinTypeRefiner)paramModuleDescriptor.getValue();
    } else {
      paramModuleDescriptor = null;
    }
    return paramModuleDescriptor != null;
  }
  
  @Nullable
  public static final ClassDescriptor resolveTopLevelClass(@NotNull ModuleDescriptor paramModuleDescriptor, @NotNull FqName paramFqName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "$this$resolveTopLevelClass");
    Intrinsics.checkParameterIsNotNull(paramFqName, "topLevelClassFqName");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "location");
    boolean bool = paramFqName.isRoot();
    if ((_Assertions.ENABLED) && (!(bool ^ true))) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    FqName localFqName = paramFqName.parent();
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "topLevelClassFqName.parent()");
    paramModuleDescriptor = paramModuleDescriptor.getPackage(localFqName).getMemberScope();
    paramFqName = paramFqName.shortName();
    Intrinsics.checkExpressionValueIsNotNull(paramFqName, "topLevelClassFqName.shortName()");
    paramFqName = paramModuleDescriptor.getContributedClassifier(paramFqName, paramLookupLocation);
    paramModuleDescriptor = paramFqName;
    if (!(paramFqName instanceof ClassDescriptor)) {
      paramModuleDescriptor = null;
    }
    return (ClassDescriptor)paramModuleDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt
 * JD-Core Version:    0.7.0.1
 */