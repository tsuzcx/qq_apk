package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DescriptorUtils
{
  public static final FqName CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL;
  public static final FqName CONTINUATION_INTERFACE_FQ_NAME_RELEASE;
  public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL;
  public static final FqName COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL;
  public static final FqName COROUTINES_PACKAGE_FQ_NAME_RELEASE;
  public static final Name ENUM_VALUES = Name.identifier("values");
  public static final Name ENUM_VALUE_OF = Name.identifier("valueOf");
  public static final FqName JVM_NAME = new FqName("kotlin.jvm.JvmName");
  public static final FqName RESULT_FQ_NAME;
  
  static
  {
    COROUTINES_PACKAGE_FQ_NAME_RELEASE = new FqName("kotlin.coroutines");
    COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL = COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier("experimental"));
    COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL = COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier("intrinsics"));
    CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL = COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier("Continuation"));
    CONTINUATION_INTERFACE_FQ_NAME_RELEASE = COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier("Continuation"));
    RESULT_FQ_NAME = new FqName("kotlin.Result");
  }
  
  public static boolean areInSameModule(@NotNull DeclarationDescriptor paramDeclarationDescriptor1, @NotNull DeclarationDescriptor paramDeclarationDescriptor2)
  {
    if (paramDeclarationDescriptor1 == null) {
      $$$reportNull$$$0(14);
    }
    if (paramDeclarationDescriptor2 == null) {
      $$$reportNull$$$0(15);
    }
    return getContainingModule(paramDeclarationDescriptor1).equals(getContainingModule(paramDeclarationDescriptor2));
  }
  
  private static <D extends CallableDescriptor> void collectAllOverriddenDescriptors(@NotNull D paramD, @NotNull Set<D> paramSet)
  {
    if (paramD == null) {
      $$$reportNull$$$0(66);
    }
    if (paramSet == null) {
      $$$reportNull$$$0(67);
    }
    if (paramSet.contains(paramD)) {
      return;
    }
    paramD = paramD.getOriginal().getOverriddenDescriptors().iterator();
    while (paramD.hasNext())
    {
      CallableDescriptor localCallableDescriptor = ((CallableDescriptor)paramD.next()).getOriginal();
      collectAllOverriddenDescriptors(localCallableDescriptor, paramSet);
      paramSet.add(localCallableDescriptor);
    }
  }
  
  @NotNull
  public static <D extends CallableDescriptor> Set<D> getAllOverriddenDescriptors(@NotNull D paramD)
  {
    if (paramD == null) {
      $$$reportNull$$$0(64);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    collectAllOverriddenDescriptors(paramD.getOriginal(), localLinkedHashSet);
    return localLinkedHashSet;
  }
  
  @NotNull
  public static ClassDescriptor getClassDescriptorForType(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(43);
    }
    return getClassDescriptorForTypeConstructor(paramKotlinType.getConstructor());
  }
  
  @NotNull
  public static ClassDescriptor getClassDescriptorForTypeConstructor(@NotNull TypeConstructor paramTypeConstructor)
  {
    if (paramTypeConstructor == null) {
      $$$reportNull$$$0(44);
    }
    paramTypeConstructor = (ClassDescriptor)paramTypeConstructor.getDeclarationDescriptor();
    if (paramTypeConstructor == null) {
      $$$reportNull$$$0(45);
    }
    return paramTypeConstructor;
  }
  
  @NotNull
  public static ModuleDescriptor getContainingModule(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(19);
    }
    paramDeclarationDescriptor = getContainingModuleOrNull(paramDeclarationDescriptor);
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(20);
    }
    return paramDeclarationDescriptor;
  }
  
  @Nullable
  public static ModuleDescriptor getContainingModuleOrNull(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    DeclarationDescriptor localDeclarationDescriptor = paramDeclarationDescriptor;
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(21);
    }
    for (localDeclarationDescriptor = paramDeclarationDescriptor; localDeclarationDescriptor != null; localDeclarationDescriptor = localDeclarationDescriptor.getContainingDeclaration())
    {
      if ((localDeclarationDescriptor instanceof ModuleDescriptor)) {
        return (ModuleDescriptor)localDeclarationDescriptor;
      }
      if ((localDeclarationDescriptor instanceof PackageViewDescriptor)) {
        return ((PackageViewDescriptor)localDeclarationDescriptor).getModule();
      }
    }
    return null;
  }
  
  @Nullable
  public static ModuleDescriptor getContainingModuleOrNull(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(18);
    }
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if (paramKotlinType == null) {
      return null;
    }
    return getContainingModuleOrNull(paramKotlinType);
  }
  
  @NotNull
  public static SourceFile getContainingSourceFile(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(74);
    }
    Object localObject = paramDeclarationDescriptor;
    if ((paramDeclarationDescriptor instanceof PropertySetterDescriptor)) {
      localObject = ((PropertySetterDescriptor)paramDeclarationDescriptor).getCorrespondingProperty();
    }
    if ((localObject instanceof DeclarationDescriptorWithSource))
    {
      paramDeclarationDescriptor = ((DeclarationDescriptorWithSource)localObject).getSource().getContainingFile();
      if (paramDeclarationDescriptor == null) {
        $$$reportNull$$$0(75);
      }
      return paramDeclarationDescriptor;
    }
    paramDeclarationDescriptor = SourceFile.NO_SOURCE_FILE;
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(76);
    }
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  public static Visibility getDefaultConstructorVisibility(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(46);
    }
    ClassKind localClassKind = paramClassDescriptor.getKind();
    if ((localClassKind != ClassKind.ENUM_CLASS) && (!localClassKind.isSingleton()) && (!isSealedClass(paramClassDescriptor)))
    {
      if (isAnonymousObject(paramClassDescriptor))
      {
        paramClassDescriptor = Visibilities.DEFAULT_VISIBILITY;
        if (paramClassDescriptor == null) {
          $$$reportNull$$$0(48);
        }
        return paramClassDescriptor;
      }
      paramClassDescriptor = Visibilities.PUBLIC;
      if (paramClassDescriptor == null) {
        $$$reportNull$$$0(49);
      }
      return paramClassDescriptor;
    }
    paramClassDescriptor = Visibilities.PRIVATE;
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(47);
    }
    return paramClassDescriptor;
  }
  
  @Nullable
  public static ReceiverParameterDescriptor getDispatchReceiverParameterIfNeeded(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(0);
    }
    if ((paramDeclarationDescriptor instanceof ClassDescriptor)) {
      return ((ClassDescriptor)paramDeclarationDescriptor).getThisAsReceiverParameter();
    }
    return null;
  }
  
  @NotNull
  public static FqNameUnsafe getFqName(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(2);
    }
    FqName localFqName = getFqNameSafeIfPossible(paramDeclarationDescriptor);
    if (localFqName != null) {
      return localFqName.toUnsafe();
    }
    return getFqNameUnsafe(paramDeclarationDescriptor);
  }
  
  @NotNull
  public static FqName getFqNameSafe(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(3);
    }
    FqName localFqName = getFqNameSafeIfPossible(paramDeclarationDescriptor);
    if (localFqName != null) {
      paramDeclarationDescriptor = localFqName;
    } else {
      paramDeclarationDescriptor = getFqNameUnsafe(paramDeclarationDescriptor).toSafe();
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(4);
    }
    return paramDeclarationDescriptor;
  }
  
  @Nullable
  private static FqName getFqNameSafeIfPossible(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(5);
    }
    if ((!(paramDeclarationDescriptor instanceof ModuleDescriptor)) && (!ErrorUtils.isError(paramDeclarationDescriptor)))
    {
      if ((paramDeclarationDescriptor instanceof PackageViewDescriptor)) {
        return ((PackageViewDescriptor)paramDeclarationDescriptor).getFqName();
      }
      if ((paramDeclarationDescriptor instanceof PackageFragmentDescriptor)) {
        return ((PackageFragmentDescriptor)paramDeclarationDescriptor).getFqName();
      }
      return null;
    }
    return FqName.ROOT;
  }
  
  @NotNull
  private static FqNameUnsafe getFqNameUnsafe(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(6);
    }
    paramDeclarationDescriptor = getFqName(paramDeclarationDescriptor.getContainingDeclaration()).child(paramDeclarationDescriptor.getName());
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(7);
    }
    return paramDeclarationDescriptor;
  }
  
  @Nullable
  public static <D extends DeclarationDescriptor> D getParentOfType(@Nullable DeclarationDescriptor paramDeclarationDescriptor, @NotNull Class<D> paramClass)
  {
    if (paramClass == null) {
      $$$reportNull$$$0(16);
    }
    return getParentOfType(paramDeclarationDescriptor, paramClass, true);
  }
  
  @Nullable
  public static <D extends DeclarationDescriptor> D getParentOfType(@Nullable DeclarationDescriptor paramDeclarationDescriptor, @NotNull Class<D> paramClass, boolean paramBoolean)
  {
    if (paramClass == null) {
      $$$reportNull$$$0(17);
    }
    if (paramDeclarationDescriptor == null) {
      return null;
    }
    DeclarationDescriptor localDeclarationDescriptor = paramDeclarationDescriptor;
    if (paramBoolean) {}
    for (localDeclarationDescriptor = paramDeclarationDescriptor.getContainingDeclaration(); localDeclarationDescriptor != null; localDeclarationDescriptor = localDeclarationDescriptor.getContainingDeclaration()) {
      if (paramClass.isInstance(localDeclarationDescriptor)) {
        return localDeclarationDescriptor;
      }
    }
    return null;
  }
  
  @Nullable
  public static ClassDescriptor getSuperClassDescriptor(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(42);
    }
    paramClassDescriptor = paramClassDescriptor.getTypeConstructor().getSupertypes().iterator();
    while (paramClassDescriptor.hasNext())
    {
      ClassDescriptor localClassDescriptor = getClassDescriptorForType((KotlinType)paramClassDescriptor.next());
      if (localClassDescriptor.getKind() != ClassKind.INTERFACE) {
        return localClassDescriptor;
      }
    }
    return null;
  }
  
  public static boolean isAnnotationClass(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    return isKindOf(paramDeclarationDescriptor, ClassKind.ANNOTATION_CLASS);
  }
  
  public static boolean isAnonymousObject(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(32);
    }
    return (isClass(paramDeclarationDescriptor)) && (paramDeclarationDescriptor.getName().equals(SpecialNames.NO_NAME_PROVIDED));
  }
  
  public static boolean isClass(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    return isKindOf(paramDeclarationDescriptor, ClassKind.CLASS);
  }
  
  public static boolean isClassOrEnumClass(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    return (isClass(paramDeclarationDescriptor)) || (isEnumClass(paramDeclarationDescriptor));
  }
  
  public static boolean isCompanionObject(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    return (isKindOf(paramDeclarationDescriptor, ClassKind.OBJECT)) && (((ClassDescriptor)paramDeclarationDescriptor).isCompanionObject());
  }
  
  public static boolean isDescriptorWithLocalVisibility(DeclarationDescriptor paramDeclarationDescriptor)
  {
    return ((paramDeclarationDescriptor instanceof DeclarationDescriptorWithVisibility)) && (((DeclarationDescriptorWithVisibility)paramDeclarationDescriptor).getVisibility() == Visibilities.LOCAL);
  }
  
  public static boolean isDirectSubclass(@NotNull ClassDescriptor paramClassDescriptor1, @NotNull ClassDescriptor paramClassDescriptor2)
  {
    if (paramClassDescriptor1 == null) {
      $$$reportNull$$$0(24);
    }
    if (paramClassDescriptor2 == null) {
      $$$reportNull$$$0(25);
    }
    paramClassDescriptor1 = paramClassDescriptor1.getTypeConstructor().getSupertypes().iterator();
    while (paramClassDescriptor1.hasNext()) {
      if (isSameClass((KotlinType)paramClassDescriptor1.next(), paramClassDescriptor2.getOriginal())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isEnumClass(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    return isKindOf(paramDeclarationDescriptor, ClassKind.ENUM_CLASS);
  }
  
  public static boolean isEnumEntry(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(34);
    }
    return isKindOf(paramDeclarationDescriptor, ClassKind.ENUM_ENTRY);
  }
  
  public static boolean isInterface(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    return isKindOf(paramDeclarationDescriptor, ClassKind.INTERFACE);
  }
  
  private static boolean isKindOf(@Nullable DeclarationDescriptor paramDeclarationDescriptor, @NotNull ClassKind paramClassKind)
  {
    if (paramClassKind == null) {
      $$$reportNull$$$0(35);
    }
    return ((paramDeclarationDescriptor instanceof ClassDescriptor)) && (((ClassDescriptor)paramDeclarationDescriptor).getKind() == paramClassKind);
  }
  
  public static boolean isLocal(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    DeclarationDescriptor localDeclarationDescriptor = paramDeclarationDescriptor;
    if (paramDeclarationDescriptor == null)
    {
      $$$reportNull$$$0(1);
      localDeclarationDescriptor = paramDeclarationDescriptor;
    }
    while (localDeclarationDescriptor != null) {
      if (!isAnonymousObject(localDeclarationDescriptor))
      {
        if (isDescriptorWithLocalVisibility(localDeclarationDescriptor)) {
          return true;
        }
        localDeclarationDescriptor = localDeclarationDescriptor.getContainingDeclaration();
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  private static boolean isSameClass(@NotNull KotlinType paramKotlinType, @NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(28);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(29);
    }
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if (paramKotlinType != null)
    {
      paramKotlinType = paramKotlinType.getOriginal();
      if (((paramKotlinType instanceof ClassifierDescriptor)) && ((paramDeclarationDescriptor instanceof ClassifierDescriptor)) && (((ClassifierDescriptor)paramDeclarationDescriptor).getTypeConstructor().equals(((ClassifierDescriptor)paramKotlinType).getTypeConstructor()))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSealedClass(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    return (isKindOf(paramDeclarationDescriptor, ClassKind.CLASS)) && (((ClassDescriptor)paramDeclarationDescriptor).getModality() == Modality.SEALED);
  }
  
  public static boolean isSubclass(@NotNull ClassDescriptor paramClassDescriptor1, @NotNull ClassDescriptor paramClassDescriptor2)
  {
    if (paramClassDescriptor1 == null) {
      $$$reportNull$$$0(26);
    }
    if (paramClassDescriptor2 == null) {
      $$$reportNull$$$0(27);
    }
    return isSubtypeOfClass(paramClassDescriptor1.getDefaultType(), paramClassDescriptor2.getOriginal());
  }
  
  public static boolean isSubtypeOfClass(@NotNull KotlinType paramKotlinType, @NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(30);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(31);
    }
    if (isSameClass(paramKotlinType, paramDeclarationDescriptor)) {
      return true;
    }
    paramKotlinType = paramKotlinType.getConstructor().getSupertypes().iterator();
    while (paramKotlinType.hasNext()) {
      if (isSubtypeOfClass((KotlinType)paramKotlinType.next(), paramDeclarationDescriptor)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isTopLevelDeclaration(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    return (paramDeclarationDescriptor != null) && ((paramDeclarationDescriptor.getContainingDeclaration() instanceof PackageFragmentDescriptor));
  }
  
  public static boolean shouldRecordInitializerForProperty(@NotNull VariableDescriptor paramVariableDescriptor, @NotNull KotlinType paramKotlinType)
  {
    if (paramVariableDescriptor == null) {
      $$$reportNull$$$0(59);
    }
    if (paramKotlinType == null) {
      $$$reportNull$$$0(60);
    }
    boolean bool3 = paramVariableDescriptor.isVar();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (KotlinTypeKt.isError(paramKotlinType)) {
        return false;
      }
      if (TypeUtils.acceptsNullable(paramKotlinType)) {
        return true;
      }
      paramVariableDescriptor = DescriptorUtilsKt.getBuiltIns(paramVariableDescriptor);
      if ((!KotlinBuiltIns.isPrimitiveType(paramKotlinType)) && (!KotlinTypeChecker.DEFAULT.equalTypes(paramVariableDescriptor.getStringType(), paramKotlinType)) && (!KotlinTypeChecker.DEFAULT.equalTypes(paramVariableDescriptor.getNumber().getDefaultType(), paramKotlinType)) && (!KotlinTypeChecker.DEFAULT.equalTypes(paramVariableDescriptor.getAnyType(), paramKotlinType)))
      {
        bool1 = bool2;
        if (!UnsignedTypes.INSTANCE.isUnsignedType(paramKotlinType)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @NotNull
  public static <D extends CallableMemberDescriptor> D unwrapFakeOverride(@NotNull D paramD)
  {
    Object localObject = paramD;
    if (paramD == null)
    {
      $$$reportNull$$$0(55);
      localObject = paramD;
    }
    while (((CallableMemberDescriptor)localObject).getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE)
    {
      paramD = ((CallableMemberDescriptor)localObject).getOverriddenDescriptors();
      if (!paramD.isEmpty())
      {
        localObject = (CallableMemberDescriptor)paramD.iterator().next();
      }
      else
      {
        paramD = new StringBuilder();
        paramD.append("Fake override should have at least one overridden descriptor: ");
        paramD.append(localObject);
        throw new IllegalStateException(paramD.toString());
      }
    }
    if (localObject == null) {
      $$$reportNull$$$0(56);
    }
    return localObject;
  }
  
  @NotNull
  public static <D extends DeclarationDescriptorWithVisibility> D unwrapFakeOverrideToAnyDeclaration(@NotNull D paramD)
  {
    if (paramD == null) {
      $$$reportNull$$$0(57);
    }
    if ((paramD instanceof CallableMemberDescriptor)) {
      return unwrapFakeOverride((CallableMemberDescriptor)paramD);
    }
    if (paramD == null) {
      $$$reportNull$$$0(58);
    }
    return paramD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils
 * JD-Core Version:    0.7.0.1
 */