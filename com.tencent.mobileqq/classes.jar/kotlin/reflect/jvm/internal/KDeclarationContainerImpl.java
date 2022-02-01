package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls;
import kotlin.text.MatchResult;
import kotlin.text.MatchResult.Destructured;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "", "returnType", "isStaticDefault", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetConstructor", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public abstract class KDeclarationContainerImpl
  implements ClassBasedDeclarationContainer
{
  public static final KDeclarationContainerImpl.Companion Companion = new KDeclarationContainerImpl.Companion(null);
  private static final Class<?> DEFAULT_CONSTRUCTOR_MARKER = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
  @NotNull
  private static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");
  
  private final void addParametersAndMasks(List<Class<?>> paramList, String paramString, boolean paramBoolean)
  {
    paramString = loadParameterTypes(paramString);
    paramList.addAll((Collection)paramString);
    int j = (paramString.size() + 32 - 1) / 32;
    int i = 0;
    while (i < j)
    {
      paramString = Integer.TYPE;
      Intrinsics.checkExpressionValueIsNotNull(paramString, "Integer.TYPE");
      paramList.add(paramString);
      i += 1;
    }
    if (paramBoolean) {
      paramString = DEFAULT_CONSTRUCTOR_MARKER;
    } else {
      paramString = Object.class;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramString, "if (isConstructor) DEFAU…RKER else Any::class.java");
    paramList.add(paramString);
  }
  
  private final KPropertyImpl<?> createProperty(PropertyDescriptor paramPropertyDescriptor)
  {
    Object localObject = paramPropertyDescriptor.getDispatchReceiverParameter();
    int j = 0;
    int i;
    if (localObject != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramPropertyDescriptor.getExtensionReceiverParameter() != null) {
      j = 1;
    }
    i += j;
    if (paramPropertyDescriptor.isVar())
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            return (KPropertyImpl)new KMutableProperty2Impl(this, paramPropertyDescriptor);
          }
        }
        else {
          return (KPropertyImpl)new KMutableProperty1Impl(this, paramPropertyDescriptor);
        }
      }
      else {
        return (KPropertyImpl)new KMutableProperty0Impl(this, paramPropertyDescriptor);
      }
    }
    else
    {
      if (i == 0) {
        break label179;
      }
      if (i == 1) {
        break label166;
      }
      if (i == 2) {
        return (KPropertyImpl)new KProperty2Impl(this, paramPropertyDescriptor);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unsupported property: ");
    ((StringBuilder)localObject).append(paramPropertyDescriptor);
    throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject).toString()));
    label166:
    return (KPropertyImpl)new KProperty1Impl(this, paramPropertyDescriptor);
    label179:
    return (KPropertyImpl)new KProperty0Impl(this, paramPropertyDescriptor);
  }
  
  private final List<Class<?>> loadParameterTypes(String paramString)
  {
    Object localObject = new ArrayList();
    int i = 1;
    while (paramString.charAt(i) != ')')
    {
      int j = i;
      while (paramString.charAt(j) == '[') {
        j += 1;
      }
      char c = paramString.charAt(j);
      if (StringsKt.contains$default((CharSequence)"VZCBSIFJD", c, false, 2, null))
      {
        j += 1;
      }
      else
      {
        if (c != 'L') {
          break label118;
        }
        j = StringsKt.indexOf$default((CharSequence)paramString, ';', i, false, 4, null) + 1;
      }
      ((ArrayList)localObject).add(parseType(paramString, i, j));
      i = j;
      continue;
      label118:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown type prefix in the method signature: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject).toString()));
    }
    return (List)localObject;
  }
  
  private final Class<?> loadReturnType(String paramString)
  {
    return parseType(paramString, StringsKt.indexOf$default((CharSequence)paramString, ')', 0, false, 6, null) + 1, paramString.length());
  }
  
  private final Method lookupMethod(@NotNull Class<?> paramClass1, String paramString, Class<?>[] paramArrayOfClass, Class<?> paramClass2, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramArrayOfClass[0] = paramClass1;
    }
    Object localObject1 = tryGetMethod(paramClass1, paramString, paramArrayOfClass, paramClass2);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = paramClass1.getSuperclass();
    if (localObject1 != null)
    {
      localObject1 = lookupMethod((Class)localObject1, paramString, paramArrayOfClass, paramClass2, paramBoolean);
      if (localObject1 != null) {
        return localObject1;
      }
    }
    paramClass1 = paramClass1.getInterfaces();
    int j = paramClass1.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = paramClass1[i];
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "superInterface");
      Object localObject2 = lookupMethod((Class)localObject1, paramString, paramArrayOfClass, paramClass2, paramBoolean);
      if (localObject2 != null) {
        return localObject2;
      }
      if (paramBoolean)
      {
        localObject2 = ((Class)localObject1).getClassLoader();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "superInterface.classLoader");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((Class)localObject1).getName());
        localStringBuilder.append("$DefaultImpls");
        localObject2 = ReflectJavaClassFinderKt.tryLoadClass((ClassLoader)localObject2, localStringBuilder.toString());
        if (localObject2 != null)
        {
          paramArrayOfClass[0] = localObject1;
          localObject1 = tryGetMethod((Class)localObject2, paramString, paramArrayOfClass, paramClass2);
          if (localObject1 != null) {
            return localObject1;
          }
        }
      }
      i += 1;
    }
    return null;
  }
  
  private final Class<?> parseType(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramString.charAt(paramInt1);
    if (i != 70)
    {
      if (i != 76)
      {
        if (i != 83)
        {
          if (i != 86)
          {
            if (i != 73)
            {
              if (i != 74)
              {
                if (i != 90)
                {
                  if (i != 91)
                  {
                    switch (i)
                    {
                    default: 
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append("Unknown type prefix in the method signature: ");
                      ((StringBuilder)localObject).append(paramString);
                      throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject).toString()));
                    case 68: 
                      return Double.TYPE;
                    case 67: 
                      return Character.TYPE;
                    }
                    return Byte.TYPE;
                  }
                  return ReflectClassUtilKt.createArrayType(parseType(paramString, paramInt1 + 1, paramInt2));
                }
                return Boolean.TYPE;
              }
              return Long.TYPE;
            }
            return Integer.TYPE;
          }
          paramString = Void.TYPE;
          Intrinsics.checkExpressionValueIsNotNull(paramString, "Void.TYPE");
          return paramString;
        }
        return Short.TYPE;
      }
      Object localObject = ReflectClassUtilKt.getSafeClassLoader(getJClass());
      if (paramString != null)
      {
        paramString = paramString.substring(paramInt1 + 1, paramInt2 - 1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramString = ((ClassLoader)localObject).loadClass(StringsKt.replace$default(paramString, '/', '.', false, 4, null));
        Intrinsics.checkExpressionValueIsNotNull(paramString, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
        return paramString;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return Float.TYPE;
  }
  
  private final Constructor<?> tryGetConstructor(@NotNull Class<?> paramClass, List<? extends Class<?>> paramList)
  {
    try
    {
      paramList = ((Collection)paramList).toArray(new Class[0]);
      if (paramList != null)
      {
        paramList = (Class[])paramList;
        return paramClass.getDeclaredConstructor((Class[])Arrays.copyOf(paramList, paramList.length));
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    catch (NoSuchMethodException paramClass)
    {
      label48:
      break label48;
    }
    return null;
  }
  
  private final Method tryGetMethod(@NotNull Class<?> paramClass1, String paramString, Class<?>[] paramArrayOfClass, Class<?> paramClass2)
  {
    try
    {
      Method localMethod = paramClass1.getDeclaredMethod(paramString, (Class[])Arrays.copyOf(paramArrayOfClass, paramArrayOfClass.length));
      Intrinsics.checkExpressionValueIsNotNull(localMethod, "result");
      if (Intrinsics.areEqual(localMethod.getReturnType(), paramClass2)) {
        return localMethod;
      }
      paramClass1 = paramClass1.getDeclaredMethods();
      Intrinsics.checkExpressionValueIsNotNull(paramClass1, "declaredMethods");
      int k = paramClass1.length;
      int i = 0;
      while (i < k)
      {
        localMethod = paramClass1[i];
        Intrinsics.checkExpressionValueIsNotNull(localMethod, "method");
        if ((Intrinsics.areEqual(localMethod.getName(), paramString)) && (Intrinsics.areEqual(localMethod.getReturnType(), paramClass2)))
        {
          Class[] arrayOfClass = localMethod.getParameterTypes();
          if (arrayOfClass == null) {
            Intrinsics.throwNpe();
          }
          boolean bool = Arrays.equals(arrayOfClass, paramArrayOfClass);
          if (bool)
          {
            j = 1;
            break label142;
          }
        }
        int j = 0;
        label142:
        if (j != 0) {
          return localMethod;
        }
        i += 1;
      }
      return null;
    }
    catch (NoSuchMethodException paramClass1) {}
    return null;
  }
  
  @Nullable
  public final Constructor<?> findConstructorBySignature(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "desc");
    return tryGetConstructor(getJClass(), loadParameterTypes(paramString));
  }
  
  @Nullable
  public final Constructor<?> findDefaultConstructor(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "desc");
    Class localClass = getJClass();
    List localList = (List)new ArrayList();
    addParametersAndMasks(localList, paramString, true);
    return tryGetConstructor(localClass, localList);
  }
  
  @Nullable
  public final Method findDefaultMethod(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "desc");
    if (Intrinsics.areEqual(paramString1, "<init>")) {
      return null;
    }
    Object localObject = new ArrayList();
    if (paramBoolean) {
      ((ArrayList)localObject).add(getJClass());
    }
    addParametersAndMasks((List)localObject, paramString2, false);
    Class localClass = getMethodOwner();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("$default");
    paramString1 = localStringBuilder.toString();
    localObject = ((Collection)localObject).toArray(new Class[0]);
    if (localObject != null) {
      return lookupMethod(localClass, paramString1, (Class[])localObject, loadReturnType(paramString2), paramBoolean);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  @NotNull
  public final FunctionDescriptor findFunctionDescriptor(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "signature");
    if (Intrinsics.areEqual(paramString1, "<init>"))
    {
      localObject1 = (Collection)CollectionsKt.toList((Iterable)getConstructorDescriptors());
    }
    else
    {
      localObject1 = Name.identifier(paramString1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "Name.identifier(name)");
      localObject1 = getFunctions((Name)localObject1);
    }
    Object localObject1 = (Iterable)localObject1;
    Object localObject2 = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = localIterator.next();
      FunctionDescriptor localFunctionDescriptor = (FunctionDescriptor)localObject3;
      if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature(localFunctionDescriptor).asString(), paramString2)) {
        ((Collection)localObject2).add(localObject3);
      }
    }
    localObject2 = (List)localObject2;
    int j = ((List)localObject2).size();
    int i = 1;
    if (j != 1)
    {
      localObject2 = CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)"\n", null, null, 0, null, (Function1)KDeclarationContainerImpl.findFunctionDescriptor.allMembers.1.INSTANCE, 30, null);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Function '");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("' (JVM signature: ");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(") not resolved in ");
      ((StringBuilder)localObject1).append(this);
      ((StringBuilder)localObject1).append(':');
      if (((CharSequence)localObject2).length() != 0) {
        i = 0;
      }
      if (i != 0)
      {
        paramString1 = " no members found";
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append('\n');
        paramString1.append((String)localObject2);
        paramString1 = paramString1.toString();
      }
      ((StringBuilder)localObject1).append(paramString1);
      throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
    }
    return (FunctionDescriptor)CollectionsKt.single((List)localObject2);
  }
  
  @Nullable
  public final Method findMethodBySignature(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "desc");
    if (Intrinsics.areEqual(paramString1, "<init>")) {
      return null;
    }
    Object localObject = ((Collection)loadParameterTypes(paramString2)).toArray(new Class[0]);
    if (localObject != null)
    {
      localObject = (Class[])localObject;
      paramString2 = loadReturnType(paramString2);
      Method localMethod = lookupMethod(getMethodOwner(), paramString1, (Class[])localObject, paramString2, false);
      if (localMethod != null) {
        return localMethod;
      }
      if (getMethodOwner().isInterface())
      {
        paramString1 = lookupMethod(Object.class, paramString1, (Class[])localObject, paramString2, false);
        if (paramString1 != null) {
          return paramString1;
        }
      }
      return null;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  @NotNull
  public final PropertyDescriptor findPropertyDescriptor(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "signature");
    Object localObject1 = LOCAL_PROPERTY_SIGNATURE.matchEntire((CharSequence)paramString2);
    int i = 1;
    if (localObject1 != null)
    {
      paramString1 = (String)((MatchResult)localObject1).getDestructured().getMatch().getGroupValues().get(1);
      paramString2 = getLocalProperty(Integer.parseInt(paramString1));
      if (paramString2 != null) {
        return paramString2;
      }
      paramString2 = new StringBuilder();
      paramString2.append("Local property #");
      paramString2.append(paramString1);
      paramString2.append(" not found in ");
      paramString2.append(getJClass());
      throw ((Throwable)new KotlinReflectionInternalError(paramString2.toString()));
    }
    localObject1 = Name.identifier(paramString1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "Name.identifier(name)");
    Object localObject2 = (Iterable)getProperties((Name)localObject1);
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (PropertyDescriptor)localObject3;
      if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor)localObject4).asString(), paramString2)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (List)localObject1;
    if (!((List)localObject1).isEmpty())
    {
      if (((List)localObject1).size() != 1)
      {
        localObject1 = (Iterable)localObject1;
        localObject3 = (Map)new LinkedHashMap();
        localObject4 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          Visibility localVisibility = ((PropertyDescriptor)localObject5).getVisibility();
          localObject2 = ((Map)localObject3).get(localVisibility);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            ((Map)localObject3).put(localVisibility, localObject1);
          }
          ((List)localObject1).add(localObject5);
        }
        localObject1 = MapsKt.toSortedMap((Map)localObject3, (Comparator)KDeclarationContainerImpl.findPropertyDescriptor.mostVisibleProperties.2.INSTANCE).values();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "properties\n             …                }).values");
        localObject1 = (List)CollectionsKt.last((Iterable)localObject1);
        if (((List)localObject1).size() == 1)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "mostVisibleProperties");
          return (PropertyDescriptor)CollectionsKt.first((List)localObject1);
        }
        localObject1 = Name.identifier(paramString1);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "Name.identifier(name)");
        localObject2 = CollectionsKt.joinToString$default((Iterable)getProperties((Name)localObject1), (CharSequence)"\n", null, null, 0, null, (Function1)KDeclarationContainerImpl.findPropertyDescriptor.allMembers.1.INSTANCE, 30, null);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Property '");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append("' (JVM signature: ");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(") not resolved in ");
        ((StringBuilder)localObject1).append(this);
        ((StringBuilder)localObject1).append(':');
        if (((CharSequence)localObject2).length() != 0) {
          i = 0;
        }
        if (i != 0)
        {
          paramString1 = " no members found";
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append('\n');
          paramString1.append((String)localObject2);
          paramString1 = paramString1.toString();
        }
        ((StringBuilder)localObject1).append(paramString1);
        throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
      }
      return (PropertyDescriptor)CollectionsKt.single((List)localObject1);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Property '");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("' (JVM signature: ");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(") not resolved in ");
    ((StringBuilder)localObject1).append(this);
    paramString1 = (Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramString1;
    }
  }
  
  @NotNull
  public abstract Collection<ConstructorDescriptor> getConstructorDescriptors();
  
  @NotNull
  public abstract Collection<FunctionDescriptor> getFunctions(@NotNull Name paramName);
  
  @Nullable
  public abstract PropertyDescriptor getLocalProperty(int paramInt);
  
  @NotNull
  protected final Collection<KCallableImpl<?>> getMembers(@NotNull MemberScope paramMemberScope, @NotNull KDeclarationContainerImpl.MemberBelonginess paramMemberBelonginess)
  {
    Intrinsics.checkParameterIsNotNull(paramMemberScope, "scope");
    Intrinsics.checkParameterIsNotNull(paramMemberBelonginess, "belonginess");
    KDeclarationContainerImpl.getMembers.visitor.1 local1 = new KDeclarationContainerImpl.getMembers.visitor.1(this);
    paramMemberScope = (Iterable)ResolutionScope.DefaultImpls.getContributedDescriptors$default(paramMemberScope, null, null, 3, null);
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramMemberScope.iterator();
    while (localIterator.hasNext())
    {
      paramMemberScope = (DeclarationDescriptor)localIterator.next();
      if ((paramMemberScope instanceof CallableMemberDescriptor))
      {
        CallableMemberDescriptor localCallableMemberDescriptor = (CallableMemberDescriptor)paramMemberScope;
        if (((Intrinsics.areEqual(localCallableMemberDescriptor.getVisibility(), Visibilities.INVISIBLE_FAKE) ^ true)) && (paramMemberBelonginess.accept(localCallableMemberDescriptor)))
        {
          paramMemberScope = (KCallableImpl)paramMemberScope.accept((DeclarationDescriptorVisitor)local1, Unit.INSTANCE);
          break label138;
        }
      }
      paramMemberScope = null;
      label138:
      if (paramMemberScope != null) {
        localCollection.add(paramMemberScope);
      }
    }
    return (Collection)CollectionsKt.toList((Iterable)localCollection);
  }
  
  @NotNull
  protected Class<?> getMethodOwner()
  {
    Class localClass = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
    if (localClass != null) {
      return localClass;
    }
    return getJClass();
  }
  
  @NotNull
  public abstract Collection<PropertyDescriptor> getProperties(@NotNull Name paramName);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KDeclarationContainerImpl
 * JD-Core Version:    0.7.0.1
 */