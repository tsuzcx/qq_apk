package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion;
import org.jetbrains.annotations.NotNull;

public class JvmBuiltInsSettings
  implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter
{
  @NotNull
  private static final Set<String> BLACK_LIST_CONSTRUCTOR_SIGNATURES;
  @NotNull
  private static final Set<String> BLACK_LIST_METHOD_SIGNATURES;
  public static final JvmBuiltInsSettings.Companion Companion = new JvmBuiltInsSettings.Companion(null);
  @NotNull
  private static final Set<String> DROP_LIST_METHOD_SIGNATURES = SetsKt.plus((Set)SignatureBuildingComponents.INSTANCE.inJavaUtil("Collection", new String[] { "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;" }), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
  @NotNull
  private static final Set<String> MUTABLE_METHOD_SIGNATURES;
  @NotNull
  private static final Set<String> WHITE_LIST_CONSTRUCTOR_SIGNATURES;
  @NotNull
  private static final Set<String> WHITE_LIST_METHOD_SIGNATURES;
  private final NotNullLazyValue cloneableType$delegate;
  private final Lazy isAdditionalBuiltInsFeatureSupported$delegate;
  private final JavaToKotlinClassMap j2kClassMap;
  private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
  private final KotlinType mockSerializableType;
  private final ModuleDescriptor moduleDescriptor;
  private final NotNullLazyValue notConsideredDeprecation$delegate;
  private final Lazy ownerModuleDescriptor$delegate;
  
  static
  {
    SignatureBuildingComponents localSignatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
    BLACK_LIST_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(JvmBuiltInsSettings.Companion.access$buildPrimitiveValueMethodsSet(Companion), (Iterable)localSignatureBuildingComponents.inJavaUtil("List", new String[] { "sort(Ljava/util/Comparator;)V" })), (Iterable)localSignatureBuildingComponents.inJavaLang("String", new String[] { "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;" })), (Iterable)localSignatureBuildingComponents.inJavaLang("Double", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)localSignatureBuildingComponents.inJavaLang("Float", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)localSignatureBuildingComponents.inJavaLang("Enum", new String[] { "getDeclaringClass()Ljava/lang/Class;", "finalize()V" }));
    localSignatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
    WHITE_LIST_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set)localSignatureBuildingComponents.inJavaLang("CharSequence", new String[] { "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;" }), (Iterable)localSignatureBuildingComponents.inJavaUtil("Iterator", new String[] { "forEachRemaining(Ljava/util/function/Consumer;)V" })), (Iterable)localSignatureBuildingComponents.inJavaLang("Iterable", new String[] { "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;" })), (Iterable)localSignatureBuildingComponents.inJavaLang("Throwable", new String[] { "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V" })), (Iterable)localSignatureBuildingComponents.inJavaUtil("Collection", new String[] { "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z" })), (Iterable)localSignatureBuildingComponents.inJavaUtil("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V" })), (Iterable)localSignatureBuildingComponents.inJavaUtil("Map", new String[] { "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;" }));
    localSignatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
    MUTABLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus((Set)localSignatureBuildingComponents.inJavaUtil("Collection", new String[] { "removeIf(Ljava/util/function/Predicate;)Z" }), (Iterable)localSignatureBuildingComponents.inJavaUtil("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V" })), (Iterable)localSignatureBuildingComponents.inJavaUtil("Map", new String[] { "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z" }));
    localSignatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
    Object localObject = JvmBuiltInsSettings.Companion.access$buildPrimitiveStringConstructorsSet(Companion);
    String[] arrayOfString = localSignatureBuildingComponents.constructors(new String[] { "D" });
    localObject = SetsKt.plus((Set)localObject, (Iterable)localSignatureBuildingComponents.inJavaLang("Float", (String[])Arrays.copyOf(arrayOfString, arrayOfString.length)));
    arrayOfString = localSignatureBuildingComponents.constructors(new String[] { "[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;" });
    BLACK_LIST_CONSTRUCTOR_SIGNATURES = SetsKt.plus((Set)localObject, (Iterable)localSignatureBuildingComponents.inJavaLang("String", (String[])Arrays.copyOf(arrayOfString, arrayOfString.length)));
    localSignatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
    localObject = localSignatureBuildingComponents.constructors(new String[] { "Ljava/lang/String;Ljava/lang/Throwable;ZZ" });
    WHITE_LIST_CONSTRUCTOR_SIGNATURES = (Set)localSignatureBuildingComponents.inJavaLang("Throwable", (String[])Arrays.copyOf((Object[])localObject, localObject.length));
  }
  
  public JvmBuiltInsSettings(@NotNull ModuleDescriptor paramModuleDescriptor, @NotNull StorageManager paramStorageManager, @NotNull Function0<? extends ModuleDescriptor> paramFunction0, @NotNull Function0<Boolean> paramFunction01)
  {
    this.moduleDescriptor = paramModuleDescriptor;
    this.j2kClassMap = JavaToKotlinClassMap.INSTANCE;
    this.ownerModuleDescriptor$delegate = LazyKt.lazy(paramFunction0);
    this.isAdditionalBuiltInsFeatureSupported$delegate = LazyKt.lazy(paramFunction01);
    this.mockSerializableType = createMockJavaIoSerializableType(paramStorageManager);
    this.cloneableType$delegate = paramStorageManager.createLazyValue((Function0)new JvmBuiltInsSettings.cloneableType.2(this, paramStorageManager));
    this.javaAnalogueClassesWithCustomSupertypeCache = paramStorageManager.createCacheWithNotNullValues();
    this.notConsideredDeprecation$delegate = paramStorageManager.createLazyValue((Function0)new JvmBuiltInsSettings.notConsideredDeprecation.2(this));
  }
  
  private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor paramDeserializedClassDescriptor, SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    paramSimpleFunctionDescriptor = paramSimpleFunctionDescriptor.newCopyBuilder();
    paramSimpleFunctionDescriptor.setOwner((DeclarationDescriptor)paramDeserializedClassDescriptor);
    paramSimpleFunctionDescriptor.setVisibility(Visibilities.PUBLIC);
    paramSimpleFunctionDescriptor.setReturnType((KotlinType)paramDeserializedClassDescriptor.getDefaultType());
    paramSimpleFunctionDescriptor.setDispatchReceiverParameter(paramDeserializedClassDescriptor.getThisAsReceiverParameter());
    paramDeserializedClassDescriptor = paramSimpleFunctionDescriptor.build();
    if (paramDeserializedClassDescriptor == null) {
      Intrinsics.throwNpe();
    }
    return (SimpleFunctionDescriptor)paramDeserializedClassDescriptor;
  }
  
  private final KotlinType createMockJavaIoSerializableType(@NotNull StorageManager paramStorageManager)
  {
    JvmBuiltInsSettings.createMockJavaIoSerializableType.mockJavaIoPackageFragment.1 local1 = new JvmBuiltInsSettings.createMockJavaIoSerializableType.mockJavaIoPackageFragment.1(this, this.moduleDescriptor, new FqName("java.io"));
    List localList = CollectionsKt.listOf(new LazyWrappedType(paramStorageManager, (Function0)new JvmBuiltInsSettings.createMockJavaIoSerializableType.superTypes.1(this)));
    paramStorageManager = new ClassDescriptorImpl((DeclarationDescriptor)local1, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, (Collection)localList, SourceElement.NO_SOURCE, false, paramStorageManager);
    paramStorageManager.initialize((MemberScope)MemberScope.Empty.INSTANCE, SetsKt.emptySet(), null);
    paramStorageManager = paramStorageManager.getDefaultType();
    Intrinsics.checkExpressionValueIsNotNull(paramStorageManager, "mockSerializableClass.defaultType");
    return (KotlinType)paramStorageManager;
  }
  
  private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(ClassDescriptor paramClassDescriptor, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> paramFunction1)
  {
    Object localObject2 = getJavaAnalogue(paramClassDescriptor);
    if (localObject2 != null)
    {
      Object localObject1 = this.j2kClassMap;
      Object localObject3 = (DeclarationDescriptor)localObject2;
      Object localObject6 = (Iterable)((JavaToKotlinClassMap)localObject1).mapPlatformClass(DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)localObject3), FallbackBuiltIns.Companion.getInstance());
      Object localObject4 = (ClassDescriptor)CollectionsKt.lastOrNull((Iterable)localObject6);
      if (localObject4 != null)
      {
        localObject1 = SmartSet.Companion;
        Object localObject5 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext()) {
          ((Collection)localObject5).add(DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)((Iterator)localObject6).next()));
        }
        localObject1 = ((SmartSet.Companion)localObject1).create((Collection)localObject5);
        boolean bool = this.j2kClassMap.isMutable(paramClassDescriptor);
        paramClassDescriptor = ((ClassDescriptor)this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)localObject3), (Function0)new JvmBuiltInsSettings.getAdditionalFunctions.fakeJavaClassDescriptor.1((LazyJavaClassDescriptor)localObject2, (ClassDescriptor)localObject4))).getUnsubstitutedMemberScope();
        Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        paramFunction1 = (Iterable)paramFunction1.invoke(paramClassDescriptor);
        paramClassDescriptor = (Collection)new ArrayList();
        paramFunction1 = paramFunction1.iterator();
        while (paramFunction1.hasNext())
        {
          localObject2 = paramFunction1.next();
          localObject3 = (SimpleFunctionDescriptor)localObject2;
          localObject4 = ((SimpleFunctionDescriptor)localObject3).getKind();
          localObject5 = CallableMemberDescriptor.Kind.DECLARATION;
          int j = 0;
          int i;
          if (localObject4 != localObject5)
          {
            i = j;
          }
          else if (!((SimpleFunctionDescriptor)localObject3).getVisibility().isPublicAPI())
          {
            i = j;
          }
          else if (KotlinBuiltIns.isDeprecated((DeclarationDescriptor)localObject3))
          {
            i = j;
          }
          else
          {
            localObject4 = ((SimpleFunctionDescriptor)localObject3).getOverriddenDescriptors();
            Intrinsics.checkExpressionValueIsNotNull(localObject4, "analogueMember.overriddenDescriptors");
            localObject4 = (Iterable)localObject4;
            if (((localObject4 instanceof Collection)) && (((Collection)localObject4).isEmpty())) {}
            do
            {
              while (!((Iterator)localObject4).hasNext())
              {
                i = 0;
                break;
                localObject4 = ((Iterable)localObject4).iterator();
              }
              localObject5 = (FunctionDescriptor)((Iterator)localObject4).next();
              Intrinsics.checkExpressionValueIsNotNull(localObject5, "it");
              localObject5 = ((FunctionDescriptor)localObject5).getContainingDeclaration();
              Intrinsics.checkExpressionValueIsNotNull(localObject5, "it.containingDeclaration");
            } while (!((SmartSet)localObject1).contains(DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)localObject5)));
            i = 1;
            if (i != 0)
            {
              i = j;
            }
            else
            {
              i = j;
              if (!isMutabilityViolation((SimpleFunctionDescriptor)localObject3, bool)) {
                i = 1;
              }
            }
          }
          if (i != 0) {
            paramClassDescriptor.add(localObject2);
          }
        }
        return (Collection)paramClassDescriptor;
      }
      return (Collection)CollectionsKt.emptyList();
    }
    return (Collection)CollectionsKt.emptyList();
  }
  
  private final SimpleType getCloneableType()
  {
    return (SimpleType)StorageKt.getValue(this.cloneableType$delegate, this, $$delegatedProperties[0]);
  }
  
  private final LazyJavaClassDescriptor getJavaAnalogue(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (KotlinBuiltIns.isAny(paramClassDescriptor)) {
      return null;
    }
    paramClassDescriptor = (DeclarationDescriptor)paramClassDescriptor;
    if (!KotlinBuiltIns.isUnderKotlinPackage(paramClassDescriptor)) {
      return null;
    }
    paramClassDescriptor = DescriptorUtilsKt.getFqNameUnsafe(paramClassDescriptor);
    if (!paramClassDescriptor.isSafe()) {
      return null;
    }
    paramClassDescriptor = this.j2kClassMap.mapKotlinToJava(paramClassDescriptor);
    if (paramClassDescriptor != null)
    {
      paramClassDescriptor = paramClassDescriptor.asSingleFqName();
      if (paramClassDescriptor != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "j2kClassMap.mapKotlinToJ…leFqName() ?: return null");
        ClassDescriptor localClassDescriptor = DescriptorUtilKt.resolveClassByFqName(getOwnerModuleDescriptor(), paramClassDescriptor, (LookupLocation)NoLookupLocation.FROM_BUILTINS);
        paramClassDescriptor = localClassDescriptor;
        if (!(localClassDescriptor instanceof LazyJavaClassDescriptor)) {
          paramClassDescriptor = null;
        }
        return (LazyJavaClassDescriptor)paramClassDescriptor;
      }
    }
    return null;
  }
  
  private final JvmBuiltInsSettings.JDKMemberStatus getJdkMethodStatus(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Object localObject = paramFunctionDescriptor.getContainingDeclaration();
    if (localObject != null)
    {
      localObject = (ClassDescriptor)localObject;
      paramFunctionDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default(paramFunctionDescriptor, false, false, 3, null);
      Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
      localObjectRef.element = ((JvmBuiltInsSettings.JDKMemberStatus)null);
      paramFunctionDescriptor = DFS.dfs((Collection)CollectionsKt.listOf(localObject), (DFS.Neighbors)new JvmBuiltInsSettings.getJdkMethodStatus.1(this), (DFS.NodeHandler)new JvmBuiltInsSettings.getJdkMethodStatus.2(paramFunctionDescriptor, localObjectRef));
      Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "DFS.dfs<ClassDescriptor,…CONSIDERED\n            })");
      return (JvmBuiltInsSettings.JDKMemberStatus)paramFunctionDescriptor;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
  }
  
  private final Annotations getNotConsideredDeprecation()
  {
    return (Annotations)StorageKt.getValue(this.notConsideredDeprecation$delegate, this, $$delegatedProperties[1]);
  }
  
  private final ModuleDescriptor getOwnerModuleDescriptor()
  {
    return (ModuleDescriptor)this.ownerModuleDescriptor$delegate.getValue();
  }
  
  private final boolean isAdditionalBuiltInsFeatureSupported()
  {
    return ((Boolean)this.isAdditionalBuiltInsFeatureSupported$delegate.getValue()).booleanValue();
  }
  
  private final boolean isMutabilityViolation(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor, boolean paramBoolean)
  {
    Object localObject = paramSimpleFunctionDescriptor.getContainingDeclaration();
    if (localObject != null)
    {
      localObject = (ClassDescriptor)localObject;
      String str = MethodSignatureMappingKt.computeJvmDescriptor$default((FunctionDescriptor)paramSimpleFunctionDescriptor, false, false, 3, null);
      if ((paramBoolean ^ MUTABLE_METHOD_SIGNATURES.contains(SignatureBuildingComponents.INSTANCE.signature((ClassDescriptor)localObject, str)))) {
        return true;
      }
      paramSimpleFunctionDescriptor = DFS.ifAny((Collection)CollectionsKt.listOf(paramSimpleFunctionDescriptor), (DFS.Neighbors)JvmBuiltInsSettings.isMutabilityViolation.1.INSTANCE, (Function1)new JvmBuiltInsSettings.isMutabilityViolation.2(this));
      Intrinsics.checkExpressionValueIsNotNull(paramSimpleFunctionDescriptor, "DFS.ifAny<CallableMember…lassDescriptor)\n        }");
      return paramSimpleFunctionDescriptor.booleanValue();
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
  }
  
  private final boolean isTrivialCopyConstructorFor(@NotNull ConstructorDescriptor paramConstructorDescriptor, ClassDescriptor paramClassDescriptor)
  {
    if (paramConstructorDescriptor.getValueParameters().size() == 1)
    {
      paramConstructorDescriptor = paramConstructorDescriptor.getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(paramConstructorDescriptor, "valueParameters");
      paramConstructorDescriptor = CollectionsKt.single(paramConstructorDescriptor);
      Intrinsics.checkExpressionValueIsNotNull(paramConstructorDescriptor, "valueParameters.single()");
      paramConstructorDescriptor = ((ValueParameterDescriptor)paramConstructorDescriptor).getType().getConstructor().getDeclarationDescriptor();
      if (paramConstructorDescriptor != null) {
        paramConstructorDescriptor = DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)paramConstructorDescriptor);
      } else {
        paramConstructorDescriptor = null;
      }
      if (Intrinsics.areEqual(paramConstructorDescriptor, DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)paramClassDescriptor))) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    if ((paramClassDescriptor.getKind() == ClassKind.CLASS) && (isAdditionalBuiltInsFeatureSupported()))
    {
      Object localObject3 = getJavaAnalogue(paramClassDescriptor);
      if (localObject3 != null)
      {
        Object localObject1 = JavaToKotlinClassMap.mapJavaToKotlin$default(this.j2kClassMap, DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)localObject3), FallbackBuiltIns.Companion.getInstance(), null, 4, null);
        if (localObject1 != null)
        {
          ClassDescriptor localClassDescriptor = (ClassDescriptor)localObject3;
          TypeSubstitutor localTypeSubstitutor = MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor)localObject1, localClassDescriptor).buildSubstitutor();
          Object localObject2 = new JvmBuiltInsSettings.getConstructors.1(localTypeSubstitutor);
          Object localObject4 = (Iterable)((LazyJavaClassDescriptor)localObject3).getConstructors();
          localObject3 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject4).iterator();
          Object localObject5;
          Object localObject6;
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = ((Iterator)localObject4).next();
            localObject6 = (ClassConstructorDescriptor)localObject5;
            Intrinsics.checkExpressionValueIsNotNull(localObject6, "javaConstructor");
            if (((ClassConstructorDescriptor)localObject6).getVisibility().isPublicAPI())
            {
              Object localObject7 = ((ClassDescriptor)localObject1).getConstructors();
              Intrinsics.checkExpressionValueIsNotNull(localObject7, "defaultKotlinVersion.constructors");
              localObject7 = (Iterable)localObject7;
              if (((localObject7 instanceof Collection)) && (((Collection)localObject7).isEmpty())) {}
              ClassConstructorDescriptor localClassConstructorDescriptor;
              do
              {
                while (!((Iterator)localObject7).hasNext())
                {
                  i = 1;
                  break;
                  localObject7 = ((Iterable)localObject7).iterator();
                }
                localClassConstructorDescriptor = (ClassConstructorDescriptor)((Iterator)localObject7).next();
                Intrinsics.checkExpressionValueIsNotNull(localClassConstructorDescriptor, "it");
              } while (!((JvmBuiltInsSettings.getConstructors.1)localObject2).invoke((ConstructorDescriptor)localClassConstructorDescriptor, (ConstructorDescriptor)localObject6));
              i = 0;
              if ((i != 0) && (!isTrivialCopyConstructorFor((ConstructorDescriptor)localObject6, paramClassDescriptor)) && (!KotlinBuiltIns.isDeprecated((DeclarationDescriptor)localObject6)) && (!BLACK_LIST_CONSTRUCTOR_SIGNATURES.contains(SignatureBuildingComponents.INSTANCE.signature(localClassDescriptor, MethodSignatureMappingKt.computeJvmDescriptor$default((FunctionDescriptor)localObject6, false, false, 3, null)))))
              {
                i = 1;
                break label352;
              }
            }
            int i = 0;
            label352:
            if (i != 0) {
              ((Collection)localObject3).add(localObject5);
            }
          }
          localObject2 = (Iterable)localObject3;
          localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ClassConstructorDescriptor)((Iterator)localObject2).next();
            localObject4 = ((ClassConstructorDescriptor)localObject3).newCopyBuilder();
            ((FunctionDescriptor.CopyBuilder)localObject4).setOwner((DeclarationDescriptor)paramClassDescriptor);
            ((FunctionDescriptor.CopyBuilder)localObject4).setReturnType((KotlinType)paramClassDescriptor.getDefaultType());
            ((FunctionDescriptor.CopyBuilder)localObject4).setPreserveSourceElement();
            ((FunctionDescriptor.CopyBuilder)localObject4).setSubstitution(localTypeSubstitutor.getSubstitution());
            localObject5 = WHITE_LIST_CONSTRUCTOR_SIGNATURES;
            localObject6 = SignatureBuildingComponents.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "javaConstructor");
            if (!((Set)localObject5).contains(((SignatureBuildingComponents)localObject6).signature(localClassDescriptor, MethodSignatureMappingKt.computeJvmDescriptor$default((FunctionDescriptor)localObject3, false, false, 3, null)))) {
              ((FunctionDescriptor.CopyBuilder)localObject4).setAdditionalAnnotations(getNotConsideredDeprecation());
            }
            localObject3 = ((FunctionDescriptor.CopyBuilder)localObject4).build();
            if (localObject3 != null) {
              ((Collection)localObject1).add((ClassConstructorDescriptor)localObject3);
            } else {
              throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            }
          }
          return (Collection)localObject1;
        }
        return (Collection)CollectionsKt.emptyList();
      }
      return (Collection)CollectionsKt.emptyList();
    }
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name paramName, @NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    int i;
    Object localObject3;
    if ((Intrinsics.areEqual(paramName, CloneableClassScope.Companion.getCLONE_NAME())) && ((paramClassDescriptor instanceof DeserializedClassDescriptor)) && (KotlinBuiltIns.isArrayOrPrimitiveArray(paramClassDescriptor)))
    {
      paramClassDescriptor = (DeserializedClassDescriptor)paramClassDescriptor;
      localObject1 = paramClassDescriptor.getClassProto().getFunctionList();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "classDescriptor.classProto.functionList");
      localObject1 = (Iterable)localObject1;
      boolean bool = localObject1 instanceof Collection;
      int j = 0;
      if ((bool) && (((Collection)localObject1).isEmpty()))
      {
        i = j;
      }
      else
      {
        localObject1 = ((Iterable)localObject1).iterator();
        do
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ProtoBuf.Function)((Iterator)localObject1).next();
          localObject3 = paramClassDescriptor.getC().getNameResolver();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "functionProto");
        } while (!Intrinsics.areEqual(NameResolverUtilKt.getName((NameResolver)localObject3, ((ProtoBuf.Function)localObject2).getName()), CloneableClassScope.Companion.getCLONE_NAME()));
        i = 1;
      }
      if (i != 0) {
        return (Collection)CollectionsKt.emptyList();
      }
      return (Collection)CollectionsKt.listOf(createCloneForArray(paramClassDescriptor, (SimpleFunctionDescriptor)CollectionsKt.single((Iterable)getCloneableType().getMemberScope().getContributedFunctions(paramName, (LookupLocation)NoLookupLocation.FROM_BUILTINS))));
    }
    if (!isAdditionalBuiltInsFeatureSupported()) {
      return (Collection)CollectionsKt.emptyList();
    }
    paramName = (Iterable)getAdditionalFunctions(paramClassDescriptor, (Function1)new JvmBuiltInsSettings.getFunctions.2(paramName));
    Object localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramName.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramName = (SimpleFunctionDescriptor)((Iterator)localObject2).next();
      localObject3 = paramName.getContainingDeclaration();
      if (localObject3 != null)
      {
        localObject3 = paramName.substitute(MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor)localObject3, paramClassDescriptor).buildSubstitutor());
        if (localObject3 != null)
        {
          localObject3 = ((SimpleFunctionDescriptor)localObject3).newCopyBuilder();
          ((FunctionDescriptor.CopyBuilder)localObject3).setOwner((DeclarationDescriptor)paramClassDescriptor);
          ((FunctionDescriptor.CopyBuilder)localObject3).setDispatchReceiverParameter(paramClassDescriptor.getThisAsReceiverParameter());
          ((FunctionDescriptor.CopyBuilder)localObject3).setPreserveSourceElement();
          paramName = getJdkMethodStatus((FunctionDescriptor)paramName);
          i = JvmBuiltInsSettings.WhenMappings.$EnumSwitchMapping$0[paramName.ordinal()];
          paramName = null;
          if (i != 1)
          {
            if (i != 2) {
              if (i == 3) {
                break label490;
              }
            } else {
              Intrinsics.checkExpressionValueIsNotNull(((FunctionDescriptor.CopyBuilder)localObject3).setAdditionalAnnotations(getNotConsideredDeprecation()), "setAdditionalAnnotations(notConsideredDeprecation)");
            }
          }
          else
          {
            if (ModalityKt.isFinalClass(paramClassDescriptor)) {
              break label490;
            }
            Intrinsics.checkExpressionValueIsNotNull(((FunctionDescriptor.CopyBuilder)localObject3).setHiddenForResolutionEverywhereBesideSupercalls(), "setHiddenForResolutionEverywhereBesideSupercalls()");
          }
          paramName = ((FunctionDescriptor.CopyBuilder)localObject3).build();
          if (paramName == null) {
            Intrinsics.throwNpe();
          }
          paramName = (SimpleFunctionDescriptor)paramName;
          label490:
          if (paramName != null) {
            ((Collection)localObject1).add(paramName);
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      }
    }
    return (Collection)localObject1;
  }
  
  @NotNull
  public Set<Name> getFunctionsNames(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    if (!isAdditionalBuiltInsFeatureSupported()) {
      return SetsKt.emptySet();
    }
    paramClassDescriptor = getJavaAnalogue(paramClassDescriptor);
    if (paramClassDescriptor != null)
    {
      paramClassDescriptor = paramClassDescriptor.getUnsubstitutedMemberScope();
      if (paramClassDescriptor != null)
      {
        paramClassDescriptor = paramClassDescriptor.getFunctionNames();
        if (paramClassDescriptor != null) {
          return paramClassDescriptor;
        }
      }
    }
    return SetsKt.emptySet();
  }
  
  @NotNull
  public Collection<KotlinType> getSupertypes(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    paramClassDescriptor = DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)paramClassDescriptor);
    if (JvmBuiltInsSettings.Companion.access$isArrayOrPrimitiveArray(Companion, paramClassDescriptor))
    {
      paramClassDescriptor = getCloneableType();
      Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "cloneableType");
      return (Collection)CollectionsKt.listOf(new KotlinType[] { (KotlinType)paramClassDescriptor, this.mockSerializableType });
    }
    if (Companion.isSerializableInJava(paramClassDescriptor)) {
      return (Collection)CollectionsKt.listOf(this.mockSerializableType);
    }
    return (Collection)CollectionsKt.emptyList();
  }
  
  public boolean isFunctionAvailable(@NotNull ClassDescriptor paramClassDescriptor, @NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    Intrinsics.checkParameterIsNotNull(paramSimpleFunctionDescriptor, "functionDescriptor");
    Object localObject = getJavaAnalogue(paramClassDescriptor);
    if (localObject != null)
    {
      if (!paramSimpleFunctionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
        return true;
      }
      boolean bool1 = isAdditionalBuiltInsFeatureSupported();
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramClassDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default((FunctionDescriptor)paramSimpleFunctionDescriptor, false, false, 3, null);
      localObject = ((LazyJavaClassDescriptor)localObject).getUnsubstitutedMemberScope();
      paramSimpleFunctionDescriptor = paramSimpleFunctionDescriptor.getName();
      Intrinsics.checkExpressionValueIsNotNull(paramSimpleFunctionDescriptor, "functionDescriptor.name");
      paramSimpleFunctionDescriptor = (Iterable)((LazyJavaClassMemberScope)localObject).getContributedFunctions(paramSimpleFunctionDescriptor, (LookupLocation)NoLookupLocation.FROM_BUILTINS);
      if (((paramSimpleFunctionDescriptor instanceof Collection)) && (((Collection)paramSimpleFunctionDescriptor).isEmpty())) {
        return false;
      }
      paramSimpleFunctionDescriptor = paramSimpleFunctionDescriptor.iterator();
      do
      {
        bool1 = bool2;
        if (!paramSimpleFunctionDescriptor.hasNext()) {
          break;
        }
      } while (!Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default((FunctionDescriptor)paramSimpleFunctionDescriptor.next(), false, false, 3, null), paramClassDescriptor));
      bool1 = true;
      return bool1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings
 * JD-Core Version:    0.7.0.1
 */