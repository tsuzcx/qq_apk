package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.NoPlatformDependent;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class KotlinBuiltIns
{
  private static final FqName ANNOTATION_PACKAGE_FQ_NAME;
  public static final Name BUILTINS_MODULE_NAME = Name.special("<built-ins module>");
  public static final FqName BUILT_INS_PACKAGE_FQ_NAME;
  public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES;
  public static final Name BUILT_INS_PACKAGE_NAME = Name.identifier("kotlin");
  public static final FqName COLLECTIONS_PACKAGE_FQ_NAME;
  public static final KotlinBuiltIns.FqNames FQ_NAMES;
  public static final FqName RANGES_PACKAGE_FQ_NAME;
  public static final FqName TEXT_PACKAGE_FQ_NAME;
  private final MemoizedFunctionToNotNull<Name, ClassDescriptor> builtInClassesByName;
  private final NotNullLazyValue<Collection<PackageViewDescriptor>> builtInPackagesImportedByDefault;
  private ModuleDescriptorImpl builtInsModule;
  private final NotNullLazyValue<KotlinBuiltIns.Primitives> primitives;
  private final StorageManager storageManager;
  
  static
  {
    BUILT_INS_PACKAGE_FQ_NAME = FqName.topLevel(BUILT_INS_PACKAGE_NAME);
    ANNOTATION_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier("annotation"));
    COLLECTIONS_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier("collections"));
    RANGES_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier("ranges"));
    TEXT_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier("text"));
    BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(new FqName[] { BUILT_INS_PACKAGE_FQ_NAME, COLLECTIONS_PACKAGE_FQ_NAME, RANGES_PACKAGE_FQ_NAME, ANNOTATION_PACKAGE_FQ_NAME, ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier("internal")), DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE });
    FQ_NAMES = new KotlinBuiltIns.FqNames();
  }
  
  protected KotlinBuiltIns(@NotNull StorageManager paramStorageManager)
  {
    this.storageManager = paramStorageManager;
    this.builtInPackagesImportedByDefault = paramStorageManager.createLazyValue(new KotlinBuiltIns.1(this));
    this.primitives = paramStorageManager.createLazyValue(new KotlinBuiltIns.2(this));
    this.builtInClassesByName = paramStorageManager.createMemoizedFunction(new KotlinBuiltIns.3(this));
  }
  
  private static boolean classFqNameEquals(@NotNull ClassifierDescriptor paramClassifierDescriptor, @NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    if (paramClassifierDescriptor == null) {
      $$$reportNull$$$0(99);
    }
    if (paramFqNameUnsafe == null) {
      $$$reportNull$$$0(100);
    }
    return (paramClassifierDescriptor.getName().equals(paramFqNameUnsafe.shortName())) && (paramFqNameUnsafe.equals(DescriptorUtils.getFqName(paramClassifierDescriptor)));
  }
  
  @NotNull
  private ClassDescriptor getBuiltInClassByName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(13);
    }
    paramString = (ClassDescriptor)this.builtInClassesByName.invoke(Name.identifier(paramString));
    if (paramString == null) {
      $$$reportNull$$$0(14);
    }
    return paramString;
  }
  
  @NotNull
  private SimpleType getBuiltInTypeByClassName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(45);
    }
    paramString = getBuiltInClassByName(paramString).getDefaultType();
    if (paramString == null) {
      $$$reportNull$$$0(46);
    }
    return paramString;
  }
  
  @Nullable
  private static KotlinType getElementTypeForUnsignedArray(@NotNull KotlinType paramKotlinType, @NotNull ModuleDescriptor paramModuleDescriptor)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(70);
    }
    if (paramModuleDescriptor == null) {
      $$$reportNull$$$0(71);
    }
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if (paramKotlinType == null) {
      return null;
    }
    if (!UnsignedTypes.INSTANCE.isShortNameOfUnsignedArray(paramKotlinType.getName())) {
      return null;
    }
    paramKotlinType = DescriptorUtilsKt.getClassId(paramKotlinType);
    if (paramKotlinType == null) {
      return null;
    }
    paramKotlinType = UnsignedTypes.INSTANCE.getUnsignedClassIdByArrayClassId(paramKotlinType);
    if (paramKotlinType == null) {
      return null;
    }
    paramKotlinType = FindClassInModuleKt.findClassAcrossModuleDependencies(paramModuleDescriptor, paramKotlinType);
    if (paramKotlinType == null) {
      return null;
    }
    return paramKotlinType.getDefaultType();
  }
  
  @NotNull
  public static ClassId getFunctionClassId(int paramInt)
  {
    return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(paramInt)));
  }
  
  @NotNull
  public static String getFunctionName(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Function");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (localObject == null) {
      $$$reportNull$$$0(17);
    }
    return localObject;
  }
  
  @Nullable
  public static PrimitiveType getPrimitiveArrayType(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(77);
    }
    if (FQ_NAMES.primitiveArrayTypeShortNames.contains(paramDeclarationDescriptor.getName())) {
      return (PrimitiveType)FQ_NAMES.arrayClassFqNameToPrimitiveType.get(DescriptorUtils.getFqName(paramDeclarationDescriptor));
    }
    return null;
  }
  
  @NotNull
  private ClassDescriptor getPrimitiveClassDescriptor(@NotNull PrimitiveType paramPrimitiveType)
  {
    if (paramPrimitiveType == null) {
      $$$reportNull$$$0(15);
    }
    return getBuiltInClassByName(paramPrimitiveType.getTypeName().asString());
  }
  
  public static FqName getPrimitiveFqName(@NotNull PrimitiveType paramPrimitiveType)
  {
    if (paramPrimitiveType == null) {
      $$$reportNull$$$0(152);
    }
    return BUILT_INS_PACKAGE_FQ_NAME.child(paramPrimitiveType.getTypeName());
  }
  
  @Nullable
  public static PrimitiveType getPrimitiveType(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(76);
    }
    if (FQ_NAMES.primitiveTypeShortNames.contains(paramDeclarationDescriptor.getName())) {
      return (PrimitiveType)FQ_NAMES.fqNameToPrimitiveType.get(DescriptorUtils.getFqName(paramDeclarationDescriptor));
    }
    return null;
  }
  
  public static boolean isAny(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(104);
    }
    return classFqNameEquals(paramClassDescriptor, FQ_NAMES.any);
  }
  
  public static boolean isAnyOrNullableAny(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(130);
    }
    return isConstructedFromGivenClass(paramKotlinType, FQ_NAMES.any);
  }
  
  public static boolean isArray(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(84);
    }
    return isConstructedFromGivenClass(paramKotlinType, FQ_NAMES.array);
  }
  
  public static boolean isArrayOrPrimitiveArray(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(85);
    }
    return (classFqNameEquals(paramClassDescriptor, FQ_NAMES.array)) || (getPrimitiveArrayType(paramClassDescriptor) != null);
  }
  
  public static boolean isBoolean(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(106);
    }
    return isConstructedFromGivenClassAndNotNullable(paramKotlinType, FQ_NAMES._boolean);
  }
  
  public static boolean isBuiltIn(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(8);
    }
    boolean bool = false;
    if (DescriptorUtils.getParentOfType(paramDeclarationDescriptor, BuiltInsPackageFragment.class, false) != null) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isByte(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(113);
    }
    return isConstructedFromGivenClassAndNotNullable(paramKotlinType, FQ_NAMES._byte);
  }
  
  public static boolean isChar(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(110);
    }
    return isConstructedFromGivenClassAndNotNullable(paramKotlinType, FQ_NAMES._char);
  }
  
  private static boolean isConstructedFromGivenClass(@NotNull KotlinType paramKotlinType, @NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(93);
    }
    if (paramFqNameUnsafe == null) {
      $$$reportNull$$$0(94);
    }
    return isTypeConstructorForGivenClass(paramKotlinType.getConstructor(), paramFqNameUnsafe);
  }
  
  private static boolean isConstructedFromGivenClassAndNotNullable(@NotNull KotlinType paramKotlinType, @NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(125);
    }
    if (paramFqNameUnsafe == null) {
      $$$reportNull$$$0(126);
    }
    return (isConstructedFromGivenClass(paramKotlinType, paramFqNameUnsafe)) && (!paramKotlinType.isMarkedNullable());
  }
  
  public static boolean isDefaultBound(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(132);
    }
    return isNullableAny(paramKotlinType);
  }
  
  public static boolean isDeprecated(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(150);
    }
    boolean bool2 = paramDeclarationDescriptor.getOriginal().getAnnotations().hasAnnotation(FQ_NAMES.deprecated);
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    if ((paramDeclarationDescriptor instanceof PropertyDescriptor))
    {
      Object localObject = (PropertyDescriptor)paramDeclarationDescriptor;
      bool2 = ((PropertyDescriptor)localObject).isVar();
      paramDeclarationDescriptor = ((PropertyDescriptor)localObject).getGetter();
      localObject = ((PropertyDescriptor)localObject).getSetter();
      if ((paramDeclarationDescriptor != null) && (isDeprecated(paramDeclarationDescriptor)))
      {
        if (!bool2) {
          break label104;
        }
        if ((localObject != null) && (isDeprecated((DeclarationDescriptor)localObject))) {
          return true;
        }
      }
      bool1 = false;
      label104:
      return bool1;
    }
    return false;
  }
  
  public static boolean isDouble(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(119);
    }
    return (isDoubleOrNullableDouble(paramKotlinType)) && (!paramKotlinType.isMarkedNullable());
  }
  
  public static boolean isDoubleOrNullableDouble(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(124);
    }
    return isConstructedFromGivenClass(paramKotlinType, FQ_NAMES._double);
  }
  
  public static boolean isFloat(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(117);
    }
    return (isFloatOrNullableFloat(paramKotlinType)) && (!paramKotlinType.isMarkedNullable());
  }
  
  public static boolean isFloatOrNullableFloat(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(118);
    }
    return isConstructedFromGivenClass(paramKotlinType, FQ_NAMES._float);
  }
  
  public static boolean isInt(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(112);
    }
    return isConstructedFromGivenClassAndNotNullable(paramKotlinType, FQ_NAMES._int);
  }
  
  public static boolean isKClass(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(147);
    }
    return classFqNameEquals(paramClassDescriptor, FQ_NAMES.kClass);
  }
  
  public static boolean isLong(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(114);
    }
    return isConstructedFromGivenClassAndNotNullable(paramKotlinType, FQ_NAMES._long);
  }
  
  private static boolean isNotNullConstructedFromGivenClass(@NotNull KotlinType paramKotlinType, @NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(101);
    }
    if (paramFqNameUnsafe == null) {
      $$$reportNull$$$0(102);
    }
    return (!paramKotlinType.isMarkedNullable()) && (isConstructedFromGivenClass(paramKotlinType, paramFqNameUnsafe));
  }
  
  public static boolean isNothing(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(127);
    }
    return (isNothingOrNullableNothing(paramKotlinType)) && (!TypeUtils.isNullableType(paramKotlinType));
  }
  
  public static boolean isNothingOrNullableNothing(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(129);
    }
    return isConstructedFromGivenClass(paramKotlinType, FQ_NAMES.nothing);
  }
  
  public static boolean isNullableAny(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(131);
    }
    return (isAnyOrNullableAny(paramKotlinType)) && (paramKotlinType.isMarkedNullable());
  }
  
  public static boolean isPrimitiveArray(@NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    if (paramFqNameUnsafe == null) {
      $$$reportNull$$$0(75);
    }
    return FQ_NAMES.arrayClassFqNameToPrimitiveType.get(paramFqNameUnsafe) != null;
  }
  
  public static boolean isPrimitiveArray(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(87);
    }
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    return (paramKotlinType != null) && (getPrimitiveArrayType(paramKotlinType) != null);
  }
  
  public static boolean isPrimitiveClass(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(92);
    }
    return getPrimitiveType(paramClassDescriptor) != null;
  }
  
  public static boolean isPrimitiveType(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(90);
    }
    return (!paramKotlinType.isMarkedNullable()) && (isPrimitiveTypeOrNullablePrimitiveType(paramKotlinType));
  }
  
  public static boolean isPrimitiveTypeOrNullablePrimitiveType(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(91);
    }
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    return ((paramKotlinType instanceof ClassDescriptor)) && (isPrimitiveClass((ClassDescriptor)paramKotlinType));
  }
  
  public static boolean isShort(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(116);
    }
    return isConstructedFromGivenClassAndNotNullable(paramKotlinType, FQ_NAMES._short);
  }
  
  public static boolean isSpecialClassWithNoSupertypes(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(103);
    }
    return (classFqNameEquals(paramClassDescriptor, FQ_NAMES.any)) || (classFqNameEquals(paramClassDescriptor, FQ_NAMES.nothing));
  }
  
  public static boolean isString(@Nullable KotlinType paramKotlinType)
  {
    return (paramKotlinType != null) && (isNotNullConstructedFromGivenClass(paramKotlinType, FQ_NAMES.string));
  }
  
  public static boolean isTypeConstructorForGivenClass(@NotNull TypeConstructor paramTypeConstructor, @NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    if (paramTypeConstructor == null) {
      $$$reportNull$$$0(97);
    }
    if (paramFqNameUnsafe == null) {
      $$$reportNull$$$0(98);
    }
    paramTypeConstructor = paramTypeConstructor.getDeclarationDescriptor();
    return ((paramTypeConstructor instanceof ClassDescriptor)) && (classFqNameEquals(paramTypeConstructor, paramFqNameUnsafe));
  }
  
  public static boolean isUnderKotlinPackage(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    DeclarationDescriptor localDeclarationDescriptor = paramDeclarationDescriptor;
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(9);
    }
    for (localDeclarationDescriptor = paramDeclarationDescriptor; localDeclarationDescriptor != null; localDeclarationDescriptor = localDeclarationDescriptor.getContainingDeclaration()) {
      if ((localDeclarationDescriptor instanceof PackageFragmentDescriptor)) {
        return ((PackageFragmentDescriptor)localDeclarationDescriptor).getFqName().startsWith(BUILT_INS_PACKAGE_NAME);
      }
    }
    return false;
  }
  
  public static boolean isUnit(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(133);
    }
    return isNotNullConstructedFromGivenClass(paramKotlinType, FQ_NAMES.unit);
  }
  
  protected void createBuiltInsModule(boolean paramBoolean)
  {
    this.builtInsModule = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.storageManager, this, null);
    this.builtInsModule.initialize(BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.storageManager, this.builtInsModule, getClassDescriptorFactories(), getPlatformDependentDeclarationFilter(), getAdditionalClassPartsProvider(), paramBoolean));
    ModuleDescriptorImpl localModuleDescriptorImpl = this.builtInsModule;
    localModuleDescriptorImpl.setDependencies(new ModuleDescriptorImpl[] { localModuleDescriptorImpl });
  }
  
  @NotNull
  protected AdditionalClassPartsProvider getAdditionalClassPartsProvider()
  {
    AdditionalClassPartsProvider.None localNone = AdditionalClassPartsProvider.None.INSTANCE;
    if (localNone == null) {
      $$$reportNull$$$0(2);
    }
    return localNone;
  }
  
  @NotNull
  public ClassDescriptor getAny()
  {
    return getBuiltInClassByName("Any");
  }
  
  @NotNull
  public SimpleType getAnyType()
  {
    SimpleType localSimpleType = getAny().getDefaultType();
    if (localSimpleType == null) {
      $$$reportNull$$$0(49);
    }
    return localSimpleType;
  }
  
  @NotNull
  public ClassDescriptor getArray()
  {
    return getBuiltInClassByName("Array");
  }
  
  @NotNull
  public KotlinType getArrayElementType(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(66);
    }
    if (isArray(paramKotlinType))
    {
      if (paramKotlinType.getArguments().size() == 1)
      {
        paramKotlinType = ((TypeProjection)paramKotlinType.getArguments().get(0)).getType();
        if (paramKotlinType == null) {
          $$$reportNull$$$0(67);
        }
        return paramKotlinType;
      }
      throw new IllegalStateException();
    }
    Object localObject1 = TypeUtils.makeNotNullable(paramKotlinType);
    Object localObject2 = (KotlinType)((KotlinBuiltIns.Primitives)this.primitives.invoke()).kotlinArrayTypeToPrimitiveKotlinType.get(localObject1);
    if (localObject2 != null)
    {
      if (localObject2 == null) {
        $$$reportNull$$$0(68);
      }
      return localObject2;
    }
    localObject2 = DescriptorUtils.getContainingModuleOrNull((KotlinType)localObject1);
    if (localObject2 != null)
    {
      localObject1 = getElementTypeForUnsignedArray((KotlinType)localObject1, (ModuleDescriptor)localObject2);
      if (localObject1 != null)
      {
        if (localObject1 == null) {
          $$$reportNull$$$0(69);
        }
        return localObject1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("not array: ");
    ((StringBuilder)localObject1).append(paramKotlinType);
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
  }
  
  @NotNull
  public SimpleType getArrayType(@NotNull Variance paramVariance, @NotNull KotlinType paramKotlinType)
  {
    if (paramVariance == null) {
      $$$reportNull$$$0(78);
    }
    if (paramKotlinType == null) {
      $$$reportNull$$$0(79);
    }
    paramVariance = Collections.singletonList(new TypeProjectionImpl(paramVariance, paramKotlinType));
    paramVariance = KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), getArray(), paramVariance);
    if (paramVariance == null) {
      $$$reportNull$$$0(80);
    }
    return paramVariance;
  }
  
  @NotNull
  public SimpleType getBooleanType()
  {
    SimpleType localSimpleType = getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
    if (localSimpleType == null) {
      $$$reportNull$$$0(62);
    }
    return localSimpleType;
  }
  
  @NotNull
  public ClassDescriptor getBuiltInClassByFqName(@NotNull FqName paramFqName)
  {
    if (paramFqName == null) {
      $$$reportNull$$$0(11);
    }
    paramFqName = DescriptorUtilKt.resolveClassByFqName(this.builtInsModule, paramFqName, NoLookupLocation.FROM_BUILTINS);
    if (paramFqName == null) {
      $$$reportNull$$$0(12);
    }
    return paramFqName;
  }
  
  @NotNull
  public ModuleDescriptorImpl getBuiltInsModule()
  {
    ModuleDescriptorImpl localModuleDescriptorImpl = this.builtInsModule;
    if (localModuleDescriptorImpl == null) {
      $$$reportNull$$$0(6);
    }
    return localModuleDescriptorImpl;
  }
  
  @NotNull
  public MemberScope getBuiltInsPackageScope()
  {
    MemberScope localMemberScope = this.builtInsModule.getPackage(BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
    if (localMemberScope == null) {
      $$$reportNull$$$0(10);
    }
    return localMemberScope;
  }
  
  @NotNull
  public SimpleType getByteType()
  {
    SimpleType localSimpleType = getPrimitiveKotlinType(PrimitiveType.BYTE);
    if (localSimpleType == null) {
      $$$reportNull$$$0(55);
    }
    return localSimpleType;
  }
  
  @NotNull
  public SimpleType getCharType()
  {
    SimpleType localSimpleType = getPrimitiveKotlinType(PrimitiveType.CHAR);
    if (localSimpleType == null) {
      $$$reportNull$$$0(61);
    }
    return localSimpleType;
  }
  
  @NotNull
  protected Iterable<ClassDescriptorFactory> getClassDescriptorFactories()
  {
    List localList = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.storageManager, this.builtInsModule));
    if (localList == null) {
      $$$reportNull$$$0(4);
    }
    return localList;
  }
  
  @NotNull
  public ClassDescriptor getCollection()
  {
    ClassDescriptor localClassDescriptor = getBuiltInClassByFqName(FQ_NAMES.collection);
    if (localClassDescriptor == null) {
      $$$reportNull$$$0(33);
    }
    return localClassDescriptor;
  }
  
  @NotNull
  public ClassDescriptor getComparable()
  {
    return getBuiltInClassByName("Comparable");
  }
  
  @NotNull
  public SimpleType getDefaultBound()
  {
    SimpleType localSimpleType = getNullableAnyType();
    if (localSimpleType == null) {
      $$$reportNull$$$0(51);
    }
    return localSimpleType;
  }
  
  @NotNull
  public SimpleType getDoubleType()
  {
    SimpleType localSimpleType = getPrimitiveKotlinType(PrimitiveType.DOUBLE);
    if (localSimpleType == null) {
      $$$reportNull$$$0(60);
    }
    return localSimpleType;
  }
  
  @NotNull
  public SimpleType getFloatType()
  {
    SimpleType localSimpleType = getPrimitiveKotlinType(PrimitiveType.FLOAT);
    if (localSimpleType == null) {
      $$$reportNull$$$0(59);
    }
    return localSimpleType;
  }
  
  @NotNull
  public ClassDescriptor getFunction(int paramInt)
  {
    return getBuiltInClassByName(getFunctionName(paramInt));
  }
  
  @NotNull
  public SimpleType getIntType()
  {
    SimpleType localSimpleType = getPrimitiveKotlinType(PrimitiveType.INT);
    if (localSimpleType == null) {
      $$$reportNull$$$0(57);
    }
    return localSimpleType;
  }
  
  @NotNull
  public ClassDescriptor getKClass()
  {
    ClassDescriptor localClassDescriptor = getBuiltInClassByFqName(FQ_NAMES.kClass.toSafe());
    if (localClassDescriptor == null) {
      $$$reportNull$$$0(19);
    }
    return localClassDescriptor;
  }
  
  @NotNull
  public SimpleType getLongType()
  {
    SimpleType localSimpleType = getPrimitiveKotlinType(PrimitiveType.LONG);
    if (localSimpleType == null) {
      $$$reportNull$$$0(58);
    }
    return localSimpleType;
  }
  
  @NotNull
  public ClassDescriptor getNothing()
  {
    return getBuiltInClassByName("Nothing");
  }
  
  @NotNull
  public SimpleType getNothingType()
  {
    SimpleType localSimpleType = getNothing().getDefaultType();
    if (localSimpleType == null) {
      $$$reportNull$$$0(47);
    }
    return localSimpleType;
  }
  
  @NotNull
  public SimpleType getNullableAnyType()
  {
    SimpleType localSimpleType = getAnyType().makeNullableAsSpecified(true);
    if (localSimpleType == null) {
      $$$reportNull$$$0(50);
    }
    return localSimpleType;
  }
  
  @NotNull
  public SimpleType getNullableNothingType()
  {
    SimpleType localSimpleType = getNothingType().makeNullableAsSpecified(true);
    if (localSimpleType == null) {
      $$$reportNull$$$0(48);
    }
    return localSimpleType;
  }
  
  @NotNull
  public ClassDescriptor getNumber()
  {
    return getBuiltInClassByName("Number");
  }
  
  @NotNull
  public SimpleType getNumberType()
  {
    SimpleType localSimpleType = getNumber().getDefaultType();
    if (localSimpleType == null) {
      $$$reportNull$$$0(54);
    }
    return localSimpleType;
  }
  
  @NotNull
  protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter()
  {
    PlatformDependentDeclarationFilter.NoPlatformDependent localNoPlatformDependent = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
    if (localNoPlatformDependent == null) {
      $$$reportNull$$$0(3);
    }
    return localNoPlatformDependent;
  }
  
  @NotNull
  public SimpleType getPrimitiveArrayKotlinType(@NotNull PrimitiveType paramPrimitiveType)
  {
    if (paramPrimitiveType == null) {
      $$$reportNull$$$0(72);
    }
    paramPrimitiveType = (SimpleType)((KotlinBuiltIns.Primitives)this.primitives.invoke()).primitiveTypeToArrayKotlinType.get(paramPrimitiveType);
    if (paramPrimitiveType == null) {
      $$$reportNull$$$0(73);
    }
    return paramPrimitiveType;
  }
  
  @NotNull
  public SimpleType getPrimitiveKotlinType(@NotNull PrimitiveType paramPrimitiveType)
  {
    if (paramPrimitiveType == null) {
      $$$reportNull$$$0(52);
    }
    paramPrimitiveType = getPrimitiveClassDescriptor(paramPrimitiveType).getDefaultType();
    if (paramPrimitiveType == null) {
      $$$reportNull$$$0(53);
    }
    return paramPrimitiveType;
  }
  
  @NotNull
  public SimpleType getShortType()
  {
    SimpleType localSimpleType = getPrimitiveKotlinType(PrimitiveType.SHORT);
    if (localSimpleType == null) {
      $$$reportNull$$$0(56);
    }
    return localSimpleType;
  }
  
  @NotNull
  protected StorageManager getStorageManager()
  {
    StorageManager localStorageManager = this.storageManager;
    if (localStorageManager == null) {
      $$$reportNull$$$0(5);
    }
    return localStorageManager;
  }
  
  @NotNull
  public ClassDescriptor getString()
  {
    return getBuiltInClassByName("String");
  }
  
  @NotNull
  public SimpleType getStringType()
  {
    SimpleType localSimpleType = getString().getDefaultType();
    if (localSimpleType == null) {
      $$$reportNull$$$0(64);
    }
    return localSimpleType;
  }
  
  @NotNull
  public ClassDescriptor getSuspendFunction(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FunctionClassDescriptor.Kind.SuspendFunction.getClassNamePrefix());
    ((StringBuilder)localObject).append(paramInt);
    localObject = Name.identifier(((StringBuilder)localObject).toString());
    localObject = getBuiltInClassByFqName(DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME_RELEASE.child((Name)localObject));
    if (localObject == null) {
      $$$reportNull$$$0(18);
    }
    return localObject;
  }
  
  @NotNull
  public ClassDescriptor getUnit()
  {
    return getBuiltInClassByName("Unit");
  }
  
  @NotNull
  public SimpleType getUnitType()
  {
    SimpleType localSimpleType = getUnit().getDefaultType();
    if (localSimpleType == null) {
      $$$reportNull$$$0(63);
    }
    return localSimpleType;
  }
  
  public void setBuiltInsModule(@NotNull ModuleDescriptorImpl paramModuleDescriptorImpl)
  {
    if (paramModuleDescriptorImpl == null) {
      $$$reportNull$$$0(1);
    }
    this.storageManager.compute(new KotlinBuiltIns.4(this, paramModuleDescriptorImpl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
 * JD-Core Version:    0.7.0.1
 */