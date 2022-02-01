package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FakePureImplementationsProvider
{
  public static final FakePureImplementationsProvider INSTANCE;
  private static final HashMap<FqName, FqName> pureImplementations;
  
  static
  {
    FakePureImplementationsProvider localFakePureImplementationsProvider = new FakePureImplementationsProvider();
    INSTANCE = localFakePureImplementationsProvider;
    pureImplementations = new HashMap();
    FqName localFqName = KotlinBuiltIns.FQ_NAMES.mutableList;
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "FQ_NAMES.mutableList");
    localFakePureImplementationsProvider.implementedWith(localFqName, localFakePureImplementationsProvider.fqNameListOf(new String[] { "java.util.ArrayList", "java.util.LinkedList" }));
    localFqName = KotlinBuiltIns.FQ_NAMES.mutableSet;
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "FQ_NAMES.mutableSet");
    localFakePureImplementationsProvider.implementedWith(localFqName, localFakePureImplementationsProvider.fqNameListOf(new String[] { "java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet" }));
    localFqName = KotlinBuiltIns.FQ_NAMES.mutableMap;
    Intrinsics.checkExpressionValueIsNotNull(localFqName, "FQ_NAMES.mutableMap");
    localFakePureImplementationsProvider.implementedWith(localFqName, localFakePureImplementationsProvider.fqNameListOf(new String[] { "java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap" }));
    localFakePureImplementationsProvider.implementedWith(new FqName("java.util.function.Function"), localFakePureImplementationsProvider.fqNameListOf(new String[] { "java.util.function.UnaryOperator" }));
    localFakePureImplementationsProvider.implementedWith(new FqName("java.util.function.BiFunction"), localFakePureImplementationsProvider.fqNameListOf(new String[] { "java.util.function.BinaryOperator" }));
  }
  
  private final List<FqName> fqNameListOf(String... paramVarArgs)
  {
    Collection localCollection = (Collection)new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new FqName(paramVarArgs[i]));
      i += 1;
    }
    return (List)localCollection;
  }
  
  private final void implementedWith(@NotNull FqName paramFqName, List<FqName> paramList)
  {
    Object localObject1 = (Iterable)paramList;
    paramList = (Map)pureImplementations;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      FqName localFqName = (FqName)localObject2;
      paramList.put(localObject2, paramFqName);
    }
  }
  
  @Nullable
  public final FqName getPurelyImplementedInterface(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "classFqName");
    return (FqName)pureImplementations.get(paramFqName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider
 * JD-Core Version:    0.7.0.1
 */