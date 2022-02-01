package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties.LazyVal;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Visited;
import kotlin.reflect.jvm.internal.impl.utils.DFS.VisitedWithSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"allSuperclasses", "", "Lkotlin/reflect/KClass;", "allSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSupertypes", "Lkotlin/reflect/KType;", "allSupertypes$annotations", "getAllSupertypes", "companionObject", "companionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "companionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "Lkotlin/reflect/KFunction;", "declaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberExtensionFunctions", "declaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", "T", "declaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "declaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "declaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMembers", "Lkotlin/reflect/KCallable;", "declaredMembers$annotations", "getDeclaredMembers", "defaultType", "defaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "functions$annotations", "getFunctions", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "memberExtensionFunctions", "memberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "memberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "memberFunctions$annotations", "getMemberFunctions", "memberProperties", "memberProperties$annotations", "getMemberProperties", "primaryConstructor", "primaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "staticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "staticProperties$annotations", "getStaticProperties", "superclasses", "", "superclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "isSubclassOf", "base", "isSuperclassOf", "derived", "safeCast", "kotlin-reflection"}, k=2, mv={1, 1, 16})
@JvmName(name="KClasses")
public final class KClasses
{
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T> T cast(@NotNull KClass<T> paramKClass, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$cast");
    if (paramKClass.isInstance(paramObject))
    {
      if (paramObject != null) {
        return paramObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type T");
    }
    paramObject = new StringBuilder();
    paramObject.append("Value cannot be cast to ");
    paramObject.append(paramKClass.getQualifiedName());
    throw ((Throwable)new TypeCastException(paramObject.toString()));
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T> T createInstance(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$createInstance");
    Iterator localIterator = ((Iterable)paramKClass.getConstructors()).iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject3 = localIterator.next();
      Object localObject4 = (Iterable)((KFunction)localObject3).getParameters();
      if (((localObject4 instanceof Collection)) && (((Collection)localObject4).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject4).hasNext())
        {
          j = 1;
          break;
          localObject4 = ((Iterable)localObject4).iterator();
        }
      } while (((KParameter)((Iterator)localObject4).next()).isOptional());
      int j = 0;
      if (j != 0)
      {
        if (i != 0)
        {
          localObject1 = localObject2;
          break label160;
        }
        localObject1 = localObject3;
        i = 1;
      }
    }
    if (i == 0) {
      localObject1 = localObject2;
    }
    label160:
    localObject1 = (KFunction)localObject1;
    if (localObject1 != null) {
      return ((KFunction)localObject1).callBy(MapsKt.emptyMap());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Class should have a single no-arg constructor: ");
    ((StringBuilder)localObject1).append(paramKClass);
    paramKClass = (Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramKClass;
    }
  }
  
  @NotNull
  public static final Collection<KClass<?>> getAllSuperclasses(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$allSuperclasses");
    paramKClass = (Iterable)getAllSupertypes(paramKClass);
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramKClass, 10));
    Iterator localIterator = paramKClass.iterator();
    while (localIterator.hasNext())
    {
      KType localKType = (KType)localIterator.next();
      KClassifier localKClassifier = localKType.getClassifier();
      paramKClass = localKClassifier;
      if (!(localKClassifier instanceof KClass)) {
        paramKClass = null;
      }
      paramKClass = (KClass)paramKClass;
      if (paramKClass != null)
      {
        localCollection.add(paramKClass);
      }
      else
      {
        paramKClass = new StringBuilder();
        paramKClass.append("Supertype not a class: ");
        paramKClass.append(localKType);
        throw ((Throwable)new KotlinReflectionInternalError(paramKClass.toString()));
      }
    }
    return (Collection)localCollection;
  }
  
  @NotNull
  public static final Collection<KType> getAllSupertypes(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$allSupertypes");
    paramKClass = DFS.dfs((Collection)paramKClass.getSupertypes(), (DFS.Neighbors)KClasses.allSupertypes.1.INSTANCE, (DFS.Visited)new DFS.VisitedWithSet(), (DFS.NodeHandler)new KClasses.allSupertypes.2());
    Intrinsics.checkExpressionValueIsNotNull(paramKClass, "DFS.dfs(\n            sup…    }\n            }\n    )");
    return (Collection)paramKClass;
  }
  
  @Nullable
  public static final KClass<?> getCompanionObject(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$companionObject");
    Iterator localIterator = ((Iterable)paramKClass.getNestedClasses()).iterator();
    while (localIterator.hasNext())
    {
      paramKClass = localIterator.next();
      KClass localKClass = (KClass)paramKClass;
      if (localKClass != null)
      {
        if (((KClassImpl)localKClass).getDescriptor().isCompanionObject()) {
          break label78;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
      }
    }
    paramKClass = null;
    label78:
    return (KClass)paramKClass;
  }
  
  @Nullable
  public static final Object getCompanionObjectInstance(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$companionObjectInstance");
    paramKClass = getCompanionObject(paramKClass);
    if (paramKClass != null) {
      return paramKClass.getObjectInstance();
    }
    return null;
  }
  
  @NotNull
  public static final Collection<KFunction<?>> getDeclaredFunctions(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$declaredFunctions");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getDeclaredMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof KFunction)) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$declaredMemberExtensionFunctions");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getDeclaredNonStaticMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      KCallableImpl localKCallableImpl = (KCallableImpl)localObject2;
      int i;
      if ((isExtension(localKCallableImpl)) && ((localKCallableImpl instanceof KFunction))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$declaredMemberExtensionProperties");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getDeclaredNonStaticMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      KCallableImpl localKCallableImpl = (KCallableImpl)localObject2;
      int i;
      if ((isExtension(localKCallableImpl)) && ((localKCallableImpl instanceof KProperty2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final Collection<KFunction<?>> getDeclaredMemberFunctions(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$declaredMemberFunctions");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getDeclaredNonStaticMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      KCallableImpl localKCallableImpl = (KCallableImpl)localObject2;
      int i;
      if ((isNotExtension(localKCallableImpl)) && ((localKCallableImpl instanceof KFunction))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$declaredMemberProperties");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getDeclaredNonStaticMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      KCallableImpl localKCallableImpl = (KCallableImpl)localObject2;
      int i;
      if ((isNotExtension(localKCallableImpl)) && ((localKCallableImpl instanceof KProperty1))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final Collection<KCallable<?>> getDeclaredMembers(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$declaredMembers");
    return ((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getDeclaredMembers();
  }
  
  @NotNull
  public static final KType getDefaultType(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$defaultType");
    SimpleType localSimpleType = ((KClassImpl)paramKClass).getDescriptor().getDefaultType();
    Intrinsics.checkExpressionValueIsNotNull(localSimpleType, "(this as KClassImpl<*>).descriptor.defaultType");
    return (KType)new KTypeImpl((KotlinType)localSimpleType, (Function0)new KClasses.defaultType.1(paramKClass));
  }
  
  @NotNull
  public static final Collection<KFunction<?>> getFunctions(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$functions");
    Object localObject1 = (Iterable)paramKClass.getMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof KFunction)) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final Collection<KFunction<?>> getMemberExtensionFunctions(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$memberExtensionFunctions");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getAllNonStaticMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      KCallableImpl localKCallableImpl = (KCallableImpl)localObject2;
      int i;
      if ((isExtension(localKCallableImpl)) && ((localKCallableImpl instanceof KFunction))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$memberExtensionProperties");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getAllNonStaticMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      KCallableImpl localKCallableImpl = (KCallableImpl)localObject2;
      int i;
      if ((isExtension(localKCallableImpl)) && ((localKCallableImpl instanceof KProperty2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final Collection<KFunction<?>> getMemberFunctions(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$memberFunctions");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getAllNonStaticMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      KCallableImpl localKCallableImpl = (KCallableImpl)localObject2;
      int i;
      if ((isNotExtension(localKCallableImpl)) && ((localKCallableImpl instanceof KFunction))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$memberProperties");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getAllNonStaticMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      KCallableImpl localKCallableImpl = (KCallableImpl)localObject2;
      int i;
      if ((isNotExtension(localKCallableImpl)) && ((localKCallableImpl instanceof KProperty1))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @Nullable
  public static final <T> KFunction<T> getPrimaryConstructor(@NotNull KClass<T> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$primaryConstructor");
    Iterator localIterator = ((Iterable)((KClassImpl)paramKClass).getConstructors()).iterator();
    while (localIterator.hasNext())
    {
      paramKClass = localIterator.next();
      Object localObject = (KFunction)paramKClass;
      if (localObject != null)
      {
        localObject = ((KFunctionImpl)localObject).getDescriptor();
        if (localObject != null)
        {
          if (((ConstructorDescriptor)localObject).isPrimary()) {
            break label99;
          }
        }
        else {
          throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
      }
    }
    paramKClass = null;
    label99:
    return (KFunction)paramKClass;
  }
  
  @NotNull
  public static final Collection<KFunction<?>> getStaticFunctions(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$staticFunctions");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getAllStaticMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof KFunction)) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final Collection<KProperty0<?>> getStaticProperties(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$staticProperties");
    Object localObject1 = (Iterable)((KClassImpl.Data)((KClassImpl)paramKClass).getData().invoke()).getAllStaticMembers();
    paramKClass = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      KCallableImpl localKCallableImpl = (KCallableImpl)localObject2;
      int i;
      if ((isNotExtension(localKCallableImpl)) && ((localKCallableImpl instanceof KProperty0))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramKClass.add(localObject2);
      }
    }
    return (Collection)paramKClass;
  }
  
  @NotNull
  public static final List<KClass<?>> getSuperclasses(@NotNull KClass<?> paramKClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$superclasses");
    paramKClass = (Iterable)paramKClass.getSupertypes();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramKClass.iterator();
    while (localIterator.hasNext())
    {
      KClassifier localKClassifier = ((KType)localIterator.next()).getClassifier();
      paramKClass = localKClassifier;
      if (!(localKClassifier instanceof KClass)) {
        paramKClass = null;
      }
      paramKClass = (KClass)paramKClass;
      if (paramKClass != null) {
        localCollection.add(paramKClass);
      }
    }
    return (List)localCollection;
  }
  
  private static final boolean isExtension(@NotNull KCallableImpl<?> paramKCallableImpl)
  {
    return paramKCallableImpl.getDescriptor().getExtensionReceiverParameter() != null;
  }
  
  private static final boolean isNotExtension(@NotNull KCallableImpl<?> paramKCallableImpl)
  {
    return isExtension(paramKCallableImpl) ^ true;
  }
  
  @SinceKotlin(version="1.1")
  public static final boolean isSubclassOf(@NotNull KClass<?> paramKClass1, @NotNull KClass<?> paramKClass2)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass1, "$this$isSubclassOf");
    Intrinsics.checkParameterIsNotNull(paramKClass2, "base");
    if (!Intrinsics.areEqual(paramKClass1, paramKClass2))
    {
      Collection localCollection = (Collection)CollectionsKt.listOf(paramKClass1);
      Function1 localFunction1 = (Function1)KClasses.isSubclassOf.1.INSTANCE;
      paramKClass1 = localFunction1;
      if (localFunction1 != null) {
        paramKClass1 = new KClasses.sam.org_jetbrains_kotlin_utils_DFS_Neighbors.0(localFunction1);
      }
      paramKClass1 = DFS.ifAny(localCollection, (DFS.Neighbors)paramKClass1, (Function1)new KClasses.isSubclassOf.2(paramKClass2));
      Intrinsics.checkExpressionValueIsNotNull(paramKClass1, "DFS.ifAny(listOf(this), …erclasses) { it == base }");
      if (!paramKClass1.booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  @SinceKotlin(version="1.1")
  public static final boolean isSuperclassOf(@NotNull KClass<?> paramKClass1, @NotNull KClass<?> paramKClass2)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass1, "$this$isSuperclassOf");
    Intrinsics.checkParameterIsNotNull(paramKClass2, "derived");
    return isSubclassOf(paramKClass2, paramKClass1);
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final <T> T safeCast(@NotNull KClass<T> paramKClass, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$safeCast");
    if (paramKClass.isInstance(paramObject))
    {
      if (paramObject != null) {
        return paramObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type T");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KClasses
 * JD-Core Version:    0.7.0.1
 */