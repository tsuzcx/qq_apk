package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaToKotlinClassMap
{
  private static final ClassId FUNCTION_N_CLASS_ID;
  @NotNull
  private static final FqName FUNCTION_N_FQ_NAME;
  public static final JavaToKotlinClassMap INSTANCE;
  private static final ClassId K_FUNCTION_CLASS_ID;
  private static final String NUMBERED_FUNCTION_PREFIX;
  private static final String NUMBERED_K_FUNCTION_PREFIX;
  private static final String NUMBERED_K_SUSPEND_FUNCTION_PREFIX;
  private static final String NUMBERED_SUSPEND_FUNCTION_PREFIX;
  private static final HashMap<FqNameUnsafe, ClassId> javaToKotlin;
  private static final HashMap<FqNameUnsafe, ClassId> kotlinToJava;
  @NotNull
  private static final List<JavaToKotlinClassMap.PlatformMutabilityMapping> mutabilityMappings;
  private static final HashMap<FqNameUnsafe, FqName> mutableToReadOnly;
  private static final HashMap<FqNameUnsafe, FqName> readOnlyToMutable;
  
  static
  {
    JavaToKotlinClassMap localJavaToKotlinClassMap = new JavaToKotlinClassMap();
    INSTANCE = localJavaToKotlinClassMap;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FunctionClassDescriptor.Kind.Function.getPackageFqName().toString());
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(FunctionClassDescriptor.Kind.Function.getClassNamePrefix());
    NUMBERED_FUNCTION_PREFIX = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FunctionClassDescriptor.Kind.KFunction.getPackageFqName().toString());
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(FunctionClassDescriptor.Kind.KFunction.getClassNamePrefix());
    NUMBERED_K_FUNCTION_PREFIX = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FunctionClassDescriptor.Kind.SuspendFunction.getPackageFqName().toString());
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(FunctionClassDescriptor.Kind.SuspendFunction.getClassNamePrefix());
    NUMBERED_SUSPEND_FUNCTION_PREFIX = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FunctionClassDescriptor.Kind.KSuspendFunction.getPackageFqName().toString());
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(FunctionClassDescriptor.Kind.KSuspendFunction.getClassNamePrefix());
    NUMBERED_K_SUSPEND_FUNCTION_PREFIX = ((StringBuilder)localObject1).toString();
    localObject1 = ClassId.topLevel(new FqName("kotlin.jvm.functions.FunctionN"));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassId.topLevel(FqName(…vm.functions.FunctionN\"))");
    FUNCTION_N_CLASS_ID = (ClassId)localObject1;
    localObject1 = FUNCTION_N_CLASS_ID.asSingleFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FUNCTION_N_CLASS_ID.asSingleFqName()");
    FUNCTION_N_FQ_NAME = (FqName)localObject1;
    localObject1 = ClassId.topLevel(new FqName("kotlin.reflect.KFunction"));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassId.topLevel(FqName(…tlin.reflect.KFunction\"))");
    K_FUNCTION_CLASS_ID = (ClassId)localObject1;
    javaToKotlin = new HashMap();
    kotlinToJava = new HashMap();
    mutableToReadOnly = new HashMap();
    readOnlyToMutable = new HashMap();
    localObject1 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.iterable);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassId.topLevel(FQ_NAMES.iterable)");
    Object localObject3 = KotlinBuiltIns.FQ_NAMES.mutableIterable;
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "FQ_NAMES.mutableIterable");
    Object localObject2 = ((ClassId)localObject1).getPackageFqName();
    Object localObject4 = ((ClassId)localObject1).getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "kotlinReadOnly.packageFqName");
    localObject3 = FqNamesUtilKt.tail((FqName)localObject3, (FqName)localObject4);
    int j = 0;
    localObject2 = new ClassId((FqName)localObject2, (FqName)localObject3, false);
    localObject1 = new JavaToKotlinClassMap.PlatformMutabilityMapping(access$classId(localJavaToKotlinClassMap, Iterable.class), (ClassId)localObject1, (ClassId)localObject2);
    localObject2 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.iterator);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "ClassId.topLevel(FQ_NAMES.iterator)");
    localObject3 = KotlinBuiltIns.FQ_NAMES.mutableIterator;
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "FQ_NAMES.mutableIterator");
    localObject4 = ((ClassId)localObject2).getPackageFqName();
    Object localObject5 = ((ClassId)localObject2).getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "kotlinReadOnly.packageFqName");
    localObject3 = new ClassId((FqName)localObject4, FqNamesUtilKt.tail((FqName)localObject3, (FqName)localObject5), false);
    localObject2 = new JavaToKotlinClassMap.PlatformMutabilityMapping(access$classId(localJavaToKotlinClassMap, Iterator.class), (ClassId)localObject2, (ClassId)localObject3);
    localObject3 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.collection);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "ClassId.topLevel(FQ_NAMES.collection)");
    localObject4 = KotlinBuiltIns.FQ_NAMES.mutableCollection;
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "FQ_NAMES.mutableCollection");
    localObject5 = ((ClassId)localObject3).getPackageFqName();
    Object localObject6 = ((ClassId)localObject3).getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "kotlinReadOnly.packageFqName");
    localObject4 = new ClassId((FqName)localObject5, FqNamesUtilKt.tail((FqName)localObject4, (FqName)localObject6), false);
    localObject3 = new JavaToKotlinClassMap.PlatformMutabilityMapping(access$classId(localJavaToKotlinClassMap, Collection.class), (ClassId)localObject3, (ClassId)localObject4);
    localObject4 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.list);
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "ClassId.topLevel(FQ_NAMES.list)");
    localObject5 = KotlinBuiltIns.FQ_NAMES.mutableList;
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "FQ_NAMES.mutableList");
    localObject6 = ((ClassId)localObject4).getPackageFqName();
    Object localObject7 = ((ClassId)localObject4).getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "kotlinReadOnly.packageFqName");
    localObject5 = new ClassId((FqName)localObject6, FqNamesUtilKt.tail((FqName)localObject5, (FqName)localObject7), false);
    localObject4 = new JavaToKotlinClassMap.PlatformMutabilityMapping(access$classId(localJavaToKotlinClassMap, List.class), (ClassId)localObject4, (ClassId)localObject5);
    localObject5 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.set);
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "ClassId.topLevel(FQ_NAMES.set)");
    localObject6 = KotlinBuiltIns.FQ_NAMES.mutableSet;
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "FQ_NAMES.mutableSet");
    localObject7 = ((ClassId)localObject5).getPackageFqName();
    Object localObject8 = ((ClassId)localObject5).getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "kotlinReadOnly.packageFqName");
    localObject6 = new ClassId((FqName)localObject7, FqNamesUtilKt.tail((FqName)localObject6, (FqName)localObject8), false);
    localObject5 = new JavaToKotlinClassMap.PlatformMutabilityMapping(access$classId(localJavaToKotlinClassMap, Set.class), (ClassId)localObject5, (ClassId)localObject6);
    localObject6 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.listIterator);
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "ClassId.topLevel(FQ_NAMES.listIterator)");
    localObject7 = KotlinBuiltIns.FQ_NAMES.mutableListIterator;
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "FQ_NAMES.mutableListIterator");
    localObject8 = ((ClassId)localObject6).getPackageFqName();
    Object localObject9 = ((ClassId)localObject6).getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "kotlinReadOnly.packageFqName");
    localObject7 = new ClassId((FqName)localObject8, FqNamesUtilKt.tail((FqName)localObject7, (FqName)localObject9), false);
    localObject6 = new JavaToKotlinClassMap.PlatformMutabilityMapping(access$classId(localJavaToKotlinClassMap, ListIterator.class), (ClassId)localObject6, (ClassId)localObject7);
    localObject7 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.map);
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "ClassId.topLevel(FQ_NAMES.map)");
    localObject8 = KotlinBuiltIns.FQ_NAMES.mutableMap;
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "FQ_NAMES.mutableMap");
    localObject9 = ((ClassId)localObject7).getPackageFqName();
    FqName localFqName1 = ((ClassId)localObject7).getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localFqName1, "kotlinReadOnly.packageFqName");
    localObject8 = new ClassId((FqName)localObject9, FqNamesUtilKt.tail((FqName)localObject8, localFqName1), false);
    localObject7 = new JavaToKotlinClassMap.PlatformMutabilityMapping(access$classId(localJavaToKotlinClassMap, Map.class), (ClassId)localObject7, (ClassId)localObject8);
    localObject8 = ClassId.topLevel(KotlinBuiltIns.FQ_NAMES.map).createNestedClassId(KotlinBuiltIns.FQ_NAMES.mapEntry.shortName());
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
    localObject9 = KotlinBuiltIns.FQ_NAMES.mutableMapEntry;
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "FQ_NAMES.mutableMapEntry");
    localFqName1 = ((ClassId)localObject8).getPackageFqName();
    FqName localFqName2 = ((ClassId)localObject8).getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localFqName2, "kotlinReadOnly.packageFqName");
    localObject9 = new ClassId(localFqName1, FqNamesUtilKt.tail((FqName)localObject9, localFqName2), false);
    mutabilityMappings = CollectionsKt.listOf(new JavaToKotlinClassMap.PlatformMutabilityMapping[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, new JavaToKotlinClassMap.PlatformMutabilityMapping(access$classId(localJavaToKotlinClassMap, Map.Entry.class), (ClassId)localObject8, (ClassId)localObject9) });
    localObject1 = KotlinBuiltIns.FQ_NAMES.any;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FQ_NAMES.any");
    localJavaToKotlinClassMap.addTopLevel(Object.class, (FqNameUnsafe)localObject1);
    localObject1 = KotlinBuiltIns.FQ_NAMES.string;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FQ_NAMES.string");
    localJavaToKotlinClassMap.addTopLevel(String.class, (FqNameUnsafe)localObject1);
    localObject1 = KotlinBuiltIns.FQ_NAMES.charSequence;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FQ_NAMES.charSequence");
    localJavaToKotlinClassMap.addTopLevel(CharSequence.class, (FqNameUnsafe)localObject1);
    localObject1 = KotlinBuiltIns.FQ_NAMES.throwable;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FQ_NAMES.throwable");
    localJavaToKotlinClassMap.addTopLevel(Throwable.class, (FqName)localObject1);
    localObject1 = KotlinBuiltIns.FQ_NAMES.cloneable;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FQ_NAMES.cloneable");
    localJavaToKotlinClassMap.addTopLevel(Cloneable.class, (FqNameUnsafe)localObject1);
    localObject1 = KotlinBuiltIns.FQ_NAMES.number;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FQ_NAMES.number");
    localJavaToKotlinClassMap.addTopLevel(Number.class, (FqNameUnsafe)localObject1);
    localObject1 = KotlinBuiltIns.FQ_NAMES.comparable;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FQ_NAMES.comparable");
    localJavaToKotlinClassMap.addTopLevel(Comparable.class, (FqName)localObject1);
    localObject1 = KotlinBuiltIns.FQ_NAMES._enum;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FQ_NAMES._enum");
    localJavaToKotlinClassMap.addTopLevel(Enum.class, (FqNameUnsafe)localObject1);
    localObject1 = KotlinBuiltIns.FQ_NAMES.annotation;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FQ_NAMES.annotation");
    localJavaToKotlinClassMap.addTopLevel(Annotation.class, (FqName)localObject1);
    localObject1 = mutabilityMappings.iterator();
    while (((Iterator)localObject1).hasNext()) {
      localJavaToKotlinClassMap.addMapping((JavaToKotlinClassMap.PlatformMutabilityMapping)((Iterator)localObject1).next());
    }
    localObject1 = JvmPrimitiveType.values();
    int k = localObject1.length;
    int i = 0;
    while (i < k)
    {
      localObject3 = localObject1[i];
      localObject2 = ClassId.topLevel(((JvmPrimitiveType)localObject3).getWrapperFqName());
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ClassId.topLevel(jvmType.wrapperFqName)");
      localObject3 = ClassId.topLevel(KotlinBuiltIns.getPrimitiveFqName(((JvmPrimitiveType)localObject3).getPrimitiveType()));
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
      localJavaToKotlinClassMap.add((ClassId)localObject2, (ClassId)localObject3);
      i += 1;
    }
    localObject1 = CompanionObjectMapping.INSTANCE.allClassesWithIntrinsicCompanions().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ClassId)((Iterator)localObject1).next();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("kotlin.jvm.internal.");
      ((StringBuilder)localObject3).append(((ClassId)localObject2).getShortClassName().asString());
      ((StringBuilder)localObject3).append("CompanionObject");
      localObject3 = ClassId.topLevel(new FqName(((StringBuilder)localObject3).toString()));
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
      localObject2 = ((ClassId)localObject2).createNestedClassId(SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
      localJavaToKotlinClassMap.add((ClassId)localObject3, (ClassId)localObject2);
    }
    i = 0;
    while (i < 23)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("kotlin.jvm.functions.Function");
      ((StringBuilder)localObject1).append(i);
      localObject1 = ClassId.topLevel(new FqName(((StringBuilder)localObject1).toString()));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
      localObject2 = KotlinBuiltIns.getFunctionClassId(i);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "KotlinBuiltIns.getFunctionClassId(i)");
      localJavaToKotlinClassMap.add((ClassId)localObject1, (ClassId)localObject2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(NUMBERED_K_FUNCTION_PREFIX);
      ((StringBuilder)localObject1).append(i);
      localJavaToKotlinClassMap.addKotlinToJava(new FqName(((StringBuilder)localObject1).toString()), K_FUNCTION_CLASS_ID);
      i += 1;
    }
    i = j;
    while (i < 22)
    {
      localObject1 = FunctionClassDescriptor.Kind.KSuspendFunction;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((FunctionClassDescriptor.Kind)localObject1).getPackageFqName().toString());
      ((StringBuilder)localObject2).append(".");
      ((StringBuilder)localObject2).append(((FunctionClassDescriptor.Kind)localObject1).getClassNamePrefix());
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(i);
      localJavaToKotlinClassMap.addKotlinToJava(new FqName(((StringBuilder)localObject2).toString()), K_FUNCTION_CLASS_ID);
      i += 1;
    }
    localObject1 = KotlinBuiltIns.FQ_NAMES.nothing.toSafe();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "FQ_NAMES.nothing.toSafe()");
    localJavaToKotlinClassMap.addKotlinToJava((FqName)localObject1, localJavaToKotlinClassMap.classId(Void.class));
  }
  
  private final void add(ClassId paramClassId1, ClassId paramClassId2)
  {
    addJavaToKotlin(paramClassId1, paramClassId2);
    paramClassId2 = paramClassId2.asSingleFqName();
    Intrinsics.checkExpressionValueIsNotNull(paramClassId2, "kotlinClassId.asSingleFqName()");
    addKotlinToJava(paramClassId2, paramClassId1);
  }
  
  private final void addJavaToKotlin(ClassId paramClassId1, ClassId paramClassId2)
  {
    Map localMap = (Map)javaToKotlin;
    paramClassId1 = paramClassId1.asSingleFqName().toUnsafe();
    Intrinsics.checkExpressionValueIsNotNull(paramClassId1, "javaClassId.asSingleFqName().toUnsafe()");
    localMap.put(paramClassId1, paramClassId2);
  }
  
  private final void addKotlinToJava(FqName paramFqName, ClassId paramClassId)
  {
    Map localMap = (Map)kotlinToJava;
    paramFqName = paramFqName.toUnsafe();
    Intrinsics.checkExpressionValueIsNotNull(paramFqName, "kotlinFqNameUnsafe.toUnsafe()");
    localMap.put(paramFqName, paramClassId);
  }
  
  private final void addMapping(JavaToKotlinClassMap.PlatformMutabilityMapping paramPlatformMutabilityMapping)
  {
    Object localObject1 = paramPlatformMutabilityMapping.component1();
    Object localObject2 = paramPlatformMutabilityMapping.component2();
    paramPlatformMutabilityMapping = paramPlatformMutabilityMapping.component3();
    add((ClassId)localObject1, (ClassId)localObject2);
    Object localObject3 = paramPlatformMutabilityMapping.asSingleFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "mutableClassId.asSingleFqName()");
    addKotlinToJava((FqName)localObject3, (ClassId)localObject1);
    localObject2 = ((ClassId)localObject2).asSingleFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "readOnlyClassId.asSingleFqName()");
    localObject1 = paramPlatformMutabilityMapping.asSingleFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mutableClassId.asSingleFqName()");
    localObject3 = (Map)mutableToReadOnly;
    paramPlatformMutabilityMapping = paramPlatformMutabilityMapping.asSingleFqName().toUnsafe();
    Intrinsics.checkExpressionValueIsNotNull(paramPlatformMutabilityMapping, "mutableClassId.asSingleFqName().toUnsafe()");
    ((Map)localObject3).put(paramPlatformMutabilityMapping, localObject2);
    paramPlatformMutabilityMapping = (Map)readOnlyToMutable;
    localObject2 = ((FqName)localObject2).toUnsafe();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "readOnlyFqName.toUnsafe()");
    paramPlatformMutabilityMapping.put(localObject2, localObject1);
  }
  
  private final void addTopLevel(Class<?> paramClass, FqName paramFqName)
  {
    paramClass = classId(paramClass);
    paramFqName = ClassId.topLevel(paramFqName);
    Intrinsics.checkExpressionValueIsNotNull(paramFqName, "ClassId.topLevel(kotlinFqName)");
    add(paramClass, paramFqName);
  }
  
  private final void addTopLevel(Class<?> paramClass, FqNameUnsafe paramFqNameUnsafe)
  {
    paramFqNameUnsafe = paramFqNameUnsafe.toSafe();
    Intrinsics.checkExpressionValueIsNotNull(paramFqNameUnsafe, "kotlinFqName.toSafe()");
    addTopLevel(paramClass, paramFqNameUnsafe);
  }
  
  private final ClassId classId(Class<?> paramClass)
  {
    int i;
    if ((!paramClass.isPrimitive()) && (!paramClass.isArray())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid class: ");
      ((StringBuilder)localObject).append(paramClass);
      throw ((Throwable)new AssertionError(((StringBuilder)localObject).toString()));
    }
    Object localObject = paramClass.getDeclaringClass();
    if (localObject == null)
    {
      paramClass = ClassId.topLevel(new FqName(paramClass.getCanonicalName()));
      Intrinsics.checkExpressionValueIsNotNull(paramClass, "ClassId.topLevel(FqName(clazz.canonicalName))");
      return paramClass;
    }
    paramClass = classId((Class)localObject).createNestedClassId(Name.identifier(paramClass.getSimpleName()));
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "classId(outer).createNes…tifier(clazz.simpleName))");
    return paramClass;
  }
  
  private final ClassDescriptor convertToOppositeMutability(ClassDescriptor paramClassDescriptor, Map<FqNameUnsafe, FqName> paramMap, String paramString)
  {
    DeclarationDescriptor localDeclarationDescriptor = (DeclarationDescriptor)paramClassDescriptor;
    paramMap = (FqName)paramMap.get(DescriptorUtils.getFqName(localDeclarationDescriptor));
    if (paramMap != null)
    {
      paramClassDescriptor = DescriptorUtilsKt.getBuiltIns(localDeclarationDescriptor).getBuiltInClassByFqName(paramMap);
      Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
      return paramClassDescriptor;
    }
    paramMap = new StringBuilder();
    paramMap.append("Given class ");
    paramMap.append(paramClassDescriptor);
    paramMap.append(" is not a ");
    paramMap.append(paramString);
    paramMap.append(" collection");
    throw ((Throwable)new IllegalArgumentException(paramMap.toString()));
  }
  
  private final boolean isKotlinFunctionWithBigArity(FqNameUnsafe paramFqNameUnsafe, String paramString)
  {
    paramFqNameUnsafe = paramFqNameUnsafe.asString();
    Intrinsics.checkExpressionValueIsNotNull(paramFqNameUnsafe, "kotlinFqName.asString()");
    paramFqNameUnsafe = StringsKt.substringAfter(paramFqNameUnsafe, paramString, "");
    paramString = (CharSequence)paramFqNameUnsafe;
    int i;
    if (paramString.length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && (!StringsKt.startsWith$default(paramString, '0', false, 2, null)))
    {
      paramFqNameUnsafe = StringsKt.toIntOrNull(paramFqNameUnsafe);
      return (paramFqNameUnsafe != null) && (paramFqNameUnsafe.intValue() >= 23);
    }
    return false;
  }
  
  @NotNull
  public final ClassDescriptor convertMutableToReadOnly(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "mutable");
    return convertToOppositeMutability(paramClassDescriptor, (Map)mutableToReadOnly, "mutable");
  }
  
  @NotNull
  public final ClassDescriptor convertReadOnlyToMutable(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "readOnly");
    return convertToOppositeMutability(paramClassDescriptor, (Map)readOnlyToMutable, "read-only");
  }
  
  @NotNull
  public final FqName getFUNCTION_N_FQ_NAME()
  {
    return FUNCTION_N_FQ_NAME;
  }
  
  @NotNull
  public final List<JavaToKotlinClassMap.PlatformMutabilityMapping> getMutabilityMappings()
  {
    return mutabilityMappings;
  }
  
  public final boolean isMutable(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "mutable");
    return isMutable(DescriptorUtils.getFqName((DeclarationDescriptor)paramClassDescriptor));
  }
  
  public final boolean isMutable(@Nullable FqNameUnsafe paramFqNameUnsafe)
  {
    Map localMap = (Map)mutableToReadOnly;
    if (localMap != null) {
      return localMap.containsKey(paramFqNameUnsafe);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
  }
  
  public final boolean isMutable(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    paramKotlinType = TypeUtils.getClassDescriptor(paramKotlinType);
    return (paramKotlinType != null) && (isMutable(paramKotlinType));
  }
  
  public final boolean isReadOnly(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "readOnly");
    return isReadOnly(DescriptorUtils.getFqName((DeclarationDescriptor)paramClassDescriptor));
  }
  
  public final boolean isReadOnly(@Nullable FqNameUnsafe paramFqNameUnsafe)
  {
    Map localMap = (Map)readOnlyToMutable;
    if (localMap != null) {
      return localMap.containsKey(paramFqNameUnsafe);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
  }
  
  public final boolean isReadOnly(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    paramKotlinType = TypeUtils.getClassDescriptor(paramKotlinType);
    return (paramKotlinType != null) && (isReadOnly(paramKotlinType));
  }
  
  @Nullable
  public final ClassDescriptor mapJavaToKotlin(@NotNull FqName paramFqName, @NotNull KotlinBuiltIns paramKotlinBuiltIns, @Nullable Integer paramInteger)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Intrinsics.checkParameterIsNotNull(paramKotlinBuiltIns, "builtIns");
    if ((paramInteger != null) && (Intrinsics.areEqual(paramFqName, FUNCTION_N_FQ_NAME))) {
      paramFqName = KotlinBuiltIns.getFunctionClassId(paramInteger.intValue());
    } else {
      paramFqName = mapJavaToKotlin(paramFqName);
    }
    if (paramFqName != null) {
      return paramKotlinBuiltIns.getBuiltInClassByFqName(paramFqName.asSingleFqName());
    }
    return null;
  }
  
  @Nullable
  public final ClassId mapJavaToKotlin(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return (ClassId)javaToKotlin.get(paramFqName.toUnsafe());
  }
  
  @Nullable
  public final ClassId mapKotlinToJava(@NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    Intrinsics.checkParameterIsNotNull(paramFqNameUnsafe, "kotlinFqName");
    if (isKotlinFunctionWithBigArity(paramFqNameUnsafe, NUMBERED_FUNCTION_PREFIX)) {
      return FUNCTION_N_CLASS_ID;
    }
    if (isKotlinFunctionWithBigArity(paramFqNameUnsafe, NUMBERED_SUSPEND_FUNCTION_PREFIX)) {
      return FUNCTION_N_CLASS_ID;
    }
    if (isKotlinFunctionWithBigArity(paramFqNameUnsafe, NUMBERED_K_FUNCTION_PREFIX)) {
      return K_FUNCTION_CLASS_ID;
    }
    if (isKotlinFunctionWithBigArity(paramFqNameUnsafe, NUMBERED_K_SUSPEND_FUNCTION_PREFIX)) {
      return K_FUNCTION_CLASS_ID;
    }
    return (ClassId)kotlinToJava.get(paramFqNameUnsafe);
  }
  
  @NotNull
  public final Collection<ClassDescriptor> mapPlatformClass(@NotNull FqName paramFqName, @NotNull KotlinBuiltIns paramKotlinBuiltIns)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Intrinsics.checkParameterIsNotNull(paramKotlinBuiltIns, "builtIns");
    paramFqName = mapJavaToKotlin$default(this, paramFqName, paramKotlinBuiltIns, null, 4, null);
    if (paramFqName != null)
    {
      FqName localFqName = (FqName)readOnlyToMutable.get(DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)paramFqName));
      if (localFqName != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localFqName, "readOnlyToMutable[kotlin…eturn setOf(kotlinAnalog)");
        paramKotlinBuiltIns = paramKotlinBuiltIns.getBuiltInClassByFqName(localFqName);
        Intrinsics.checkExpressionValueIsNotNull(paramKotlinBuiltIns, "builtIns.getBuiltInClass…otlinMutableAnalogFqName)");
        return (Collection)CollectionsKt.listOf(new ClassDescriptor[] { paramFqName, paramKotlinBuiltIns });
      }
      return (Collection)SetsKt.setOf(paramFqName);
    }
    return (Collection)SetsKt.emptySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap
 * JD-Core Version:    0.7.0.1
 */