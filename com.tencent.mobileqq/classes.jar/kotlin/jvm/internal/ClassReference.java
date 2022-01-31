package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ClassReference
  implements ClassBasedDeclarationContainer, KClass<Object>
{
  public static final ClassReference.Companion Companion;
  private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
  private static final HashMap<String, String> classFqNames;
  private static final HashMap<String, String> primitiveFqNames;
  private static final HashMap<String, String> primitiveWrapperFqNames;
  private static final Map<String, String> simpleNames;
  @NotNull
  private final Class<?> jClass;
  
  static
  {
    int i = 0;
    Companion = new ClassReference.Companion(null);
    Object localObject2 = (Iterable)CollectionsKt.listOf(new Class[] { Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class });
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      ((Collection)localObject1).add(TuplesKt.to((Class)localObject3, Integer.valueOf(i)));
      i += 1;
    }
    FUNCTION_CLASSES = MapsKt.toMap((Iterable)localObject1);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("char", "kotlin.Char");
    ((HashMap)localObject1).put("byte", "kotlin.Byte");
    ((HashMap)localObject1).put("short", "kotlin.Short");
    ((HashMap)localObject1).put("int", "kotlin.Int");
    ((HashMap)localObject1).put("float", "kotlin.Float");
    ((HashMap)localObject1).put("long", "kotlin.Long");
    ((HashMap)localObject1).put("double", "kotlin.Double");
    primitiveFqNames = (HashMap)localObject1;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("java.lang.Boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("java.lang.Character", "kotlin.Char");
    ((HashMap)localObject1).put("java.lang.Byte", "kotlin.Byte");
    ((HashMap)localObject1).put("java.lang.Short", "kotlin.Short");
    ((HashMap)localObject1).put("java.lang.Integer", "kotlin.Int");
    ((HashMap)localObject1).put("java.lang.Float", "kotlin.Float");
    ((HashMap)localObject1).put("java.lang.Long", "kotlin.Long");
    ((HashMap)localObject1).put("java.lang.Double", "kotlin.Double");
    primitiveWrapperFqNames = (HashMap)localObject1;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("java.lang.Object", "kotlin.Any");
    ((HashMap)localObject1).put("java.lang.String", "kotlin.String");
    ((HashMap)localObject1).put("java.lang.CharSequence", "kotlin.CharSequence");
    ((HashMap)localObject1).put("java.lang.Throwable", "kotlin.Throwable");
    ((HashMap)localObject1).put("java.lang.Cloneable", "kotlin.Cloneable");
    ((HashMap)localObject1).put("java.lang.Number", "kotlin.Number");
    ((HashMap)localObject1).put("java.lang.Comparable", "kotlin.Comparable");
    ((HashMap)localObject1).put("java.lang.Enum", "kotlin.Enum");
    ((HashMap)localObject1).put("java.lang.annotation.Annotation", "kotlin.Annotation");
    ((HashMap)localObject1).put("java.lang.Iterable", "kotlin.collections.Iterable");
    ((HashMap)localObject1).put("java.util.Iterator", "kotlin.collections.Iterator");
    ((HashMap)localObject1).put("java.util.Collection", "kotlin.collections.Collection");
    ((HashMap)localObject1).put("java.util.List", "kotlin.collections.List");
    ((HashMap)localObject1).put("java.util.Set", "kotlin.collections.Set");
    ((HashMap)localObject1).put("java.util.ListIterator", "kotlin.collections.ListIterator");
    ((HashMap)localObject1).put("java.util.Map", "kotlin.collections.Map");
    ((HashMap)localObject1).put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
    ((HashMap)localObject1).put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
    ((HashMap)localObject1).put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
    ((HashMap)localObject1).putAll((Map)primitiveFqNames);
    ((HashMap)localObject1).putAll((Map)primitiveWrapperFqNames);
    localObject2 = primitiveFqNames.values();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "primitiveFqNames.values");
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      localObject3 = (Map)localObject1;
      localObject4 = (String)localObject4;
      StringBuilder localStringBuilder = new StringBuilder().append("kotlin.jvm.internal.");
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "kotlinName");
      localObject4 = TuplesKt.to(StringsKt.substringAfterLast$default((String)localObject4, '.', null, 2, null) + "CompanionObject", (String)localObject4 + ".Companion");
      ((Map)localObject3).put(((Pair)localObject4).getFirst(), ((Pair)localObject4).getSecond());
    }
    localObject2 = (Map)localObject1;
    localObject2 = FUNCTION_CLASSES.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject4 = (Class)((Map.Entry)localObject3).getKey();
      i = ((Number)((Map.Entry)localObject3).getValue()).intValue();
      ((HashMap)localObject1).put(((Class)localObject4).getName(), "kotlin.Function" + i);
    }
    classFqNames = (HashMap)localObject1;
    localObject2 = (Map)classFqNames;
    localObject1 = (Map)new LinkedHashMap(MapsKt.mapCapacity(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), StringsKt.substringAfterLast$default((String)((Map.Entry)localObject3).getValue(), '.', null, 2, null));
    }
    simpleNames = (Map)localObject1;
  }
  
  public ClassReference(@NotNull Class<?> paramClass)
  {
    this.jClass = paramClass;
  }
  
  private final Void error()
  {
    throw ((Throwable)new KotlinReflectionNotSupportedError());
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ClassReference)) && (Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass)paramObject)));
  }
  
  @NotNull
  public List<Annotation> getAnnotations()
  {
    error();
    throw null;
  }
  
  @NotNull
  public Collection<KFunction<Object>> getConstructors()
  {
    error();
    throw null;
  }
  
  @NotNull
  public Class<?> getJClass()
  {
    return this.jClass;
  }
  
  @NotNull
  public Collection<KCallable<?>> getMembers()
  {
    error();
    throw null;
  }
  
  @NotNull
  public Collection<KClass<?>> getNestedClasses()
  {
    error();
    throw null;
  }
  
  @Nullable
  public Object getObjectInstance()
  {
    error();
    throw null;
  }
  
  @Nullable
  public String getQualifiedName()
  {
    return Companion.getClassQualifiedName(getJClass());
  }
  
  @NotNull
  public List<KClass<? extends Object>> getSealedSubclasses()
  {
    error();
    throw null;
  }
  
  @Nullable
  public String getSimpleName()
  {
    return Companion.getClassSimpleName(getJClass());
  }
  
  @NotNull
  public List<KType> getSupertypes()
  {
    error();
    throw null;
  }
  
  @NotNull
  public List<KTypeParameter> getTypeParameters()
  {
    error();
    throw null;
  }
  
  @Nullable
  public KVisibility getVisibility()
  {
    error();
    throw null;
  }
  
  public int hashCode()
  {
    return JvmClassMappingKt.getJavaObjectType(this).hashCode();
  }
  
  public boolean isAbstract()
  {
    error();
    throw null;
  }
  
  public boolean isCompanion()
  {
    error();
    throw null;
  }
  
  public boolean isData()
  {
    error();
    throw null;
  }
  
  public boolean isFinal()
  {
    error();
    throw null;
  }
  
  public boolean isInner()
  {
    error();
    throw null;
  }
  
  @SinceKotlin(version="1.1")
  public boolean isInstance(@Nullable Object paramObject)
  {
    return Companion.isInstance(paramObject, getJClass());
  }
  
  public boolean isOpen()
  {
    error();
    throw null;
  }
  
  public boolean isSealed()
  {
    error();
    throw null;
  }
  
  @NotNull
  public String toString()
  {
    return getJClass().toString() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.jvm.internal.ClassReference
 * JD-Core Version:    0.7.0.1
 */