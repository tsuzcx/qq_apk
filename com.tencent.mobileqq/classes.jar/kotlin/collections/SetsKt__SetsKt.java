package kotlin.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buildSet", "", "E", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptySet", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/SetsKt")
class SetsKt__SetsKt
  extends SetsKt__SetsJVMKt
{
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <E> Set<E> buildSet(int paramInt, @BuilderInference Function1<? super Set<E>, Unit> paramFunction1)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(paramInt));
    paramFunction1.invoke(localLinkedHashSet);
    return (Set)localLinkedHashSet;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <E> Set<E> buildSet(@BuilderInference Function1<? super Set<E>, Unit> paramFunction1)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramFunction1.invoke(localLinkedHashSet);
    return (Set)localLinkedHashSet;
  }
  
  @NotNull
  public static final <T> Set<T> emptySet()
  {
    return (Set)EmptySet.INSTANCE;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> HashSet<T> hashSetOf()
  {
    return new HashSet();
  }
  
  @NotNull
  public static final <T> HashSet<T> hashSetOf(@NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    return (HashSet)ArraysKt.toCollection(paramVarArgs, (Collection)new HashSet(MapsKt.mapCapacity(paramVarArgs.length)));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> LinkedHashSet<T> linkedSetOf()
  {
    return new LinkedHashSet();
  }
  
  @NotNull
  public static final <T> LinkedHashSet<T> linkedSetOf(@NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    return (LinkedHashSet)ArraysKt.toCollection(paramVarArgs, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramVarArgs.length)));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> Set<T> mutableSetOf()
  {
    return (Set)new LinkedHashSet();
  }
  
  @NotNull
  public static final <T> Set<T> mutableSetOf(@NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    return (Set)ArraysKt.toCollection(paramVarArgs, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramVarArgs.length)));
  }
  
  @NotNull
  public static final <T> Set<T> optimizeReadOnlySet(@NotNull Set<? extends T> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "$this$optimizeReadOnlySet");
    int i = paramSet.size();
    if (i != 0)
    {
      if (i != 1) {
        return paramSet;
      }
      return SetsKt.setOf(paramSet.iterator().next());
    }
    return SetsKt.emptySet();
  }
  
  @InlineOnly
  private static final <T> Set<T> orEmpty(@Nullable Set<? extends T> paramSet)
  {
    if (paramSet != null) {
      return paramSet;
    }
    return SetsKt.emptySet();
  }
  
  @InlineOnly
  private static final <T> Set<T> setOf()
  {
    return SetsKt.emptySet();
  }
  
  @NotNull
  public static final <T> Set<T> setOf(@NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    if (paramVarArgs.length > 0) {
      return ArraysKt.toSet(paramVarArgs);
    }
    return SetsKt.emptySet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.SetsKt__SetsKt
 * JD-Core Version:    0.7.0.1
 */