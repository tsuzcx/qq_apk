package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"all", "", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "chunked", "", "", "size", "", "R", "chunkedSequence", "count", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAtOrElse", "index", "defaultValue", "elementAtOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "find", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "findLast", "first", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "flatMap", "flatMapTo", "", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fold", "initial", "operation", "acc", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOfFirst", "indexOfLast", "last", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "", "mapIndexedNotNullTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "none", "onEach", "S", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "partition", "random", "Lkotlin/random/Random;", "randomOrNull", "(Ljava/lang/CharSequence;Lkotlin/random/Random;)Ljava/lang/Character;", "reduce", "reduceIndexed", "reduceOrNull", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Character;", "reduceRight", "reduceRightIndexed", "reduceRightOrNull", "reversed", "scan", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scanIndexed", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduce", "scanReduceIndexed", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sumBy", "sumByDouble", "", "take", "takeLast", "takeLastWhile", "takeWhile", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toSet", "", "windowed", "step", "partialWindows", "windowedSequence", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "zipWithNext", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt___StringsKt
  extends StringsKt___StringsJvmKt
{
  public static final boolean all(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$all");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean any(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$any");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean any(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    boolean bool2 = false;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$any");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramCharSequence.length())
      {
        if (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final Iterable<Character> asIterable(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$asIterable");
    if ((paramCharSequence instanceof String))
    {
      if (paramCharSequence.length() == 0) {}
      for (int i = 1; i != 0; i = 0) {
        return (Iterable)CollectionsKt.emptyList();
      }
    }
    return (Iterable)new StringsKt___StringsKt.asIterable..inlined.Iterable.1(paramCharSequence);
  }
  
  @NotNull
  public static final Sequence<Character> asSequence(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$asSequence");
    if ((paramCharSequence instanceof String))
    {
      if (paramCharSequence.length() == 0) {}
      for (int i = 1; i != 0; i = 0) {
        return SequencesKt.emptySequence();
      }
    }
    return (Sequence)new StringsKt___StringsKt.asSequence..inlined.Sequence.1(paramCharSequence);
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associate(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associate");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramCharSequence.length()), 16));
    int i = 0;
    while (i < paramCharSequence.length())
    {
      Pair localPair = (Pair)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)));
      localMap.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K> Map<K, Character> associateBy(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramCharSequence.length()), 16));
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      localMap.put(paramFunction1.invoke(Character.valueOf(c)), Character.valueOf(c));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> associateBy(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends K> paramFunction1, @NotNull Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramCharSequence.length()), 16));
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      localMap.put(paramFunction1.invoke(Character.valueOf(c)), paramFunction11.invoke(Character.valueOf(c)));
      i += 1;
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(@NotNull CharSequence paramCharSequence, @NotNull M paramM, @NotNull Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      paramM.put(paramFunction1.invoke(Character.valueOf(c)), Character.valueOf(c));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull CharSequence paramCharSequence, @NotNull M paramM, @NotNull Function1<? super Character, ? extends K> paramFunction1, @NotNull Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      paramM.put(paramFunction1.invoke(Character.valueOf(c)), paramFunction11.invoke(Character.valueOf(c)));
      i += 1;
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull CharSequence paramCharSequence, @NotNull M paramM, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      Pair localPair = (Pair)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)));
      paramM.put(localPair.getFirst(), localPair.getSecond());
      i += 1;
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <V> Map<Character, V> associateWith(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateWith");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "valueSelector");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paramCharSequence.length()), 16));
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      ((Map)localLinkedHashMap).put(Character.valueOf(c), paramFunction1.invoke(Character.valueOf(c)));
      i += 1;
    }
    return (Map)localLinkedHashMap;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(@NotNull CharSequence paramCharSequence, @NotNull M paramM, @NotNull Function1<? super Character, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$associateWithTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "valueSelector");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      paramM.put(Character.valueOf(c), paramFunction1.invoke(Character.valueOf(c)));
      i += 1;
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final List<String> chunked(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$chunked");
    return StringsKt.windowed(paramCharSequence, paramInt, paramInt, true);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <R> List<R> chunked(@NotNull CharSequence paramCharSequence, int paramInt, @NotNull Function1<? super CharSequence, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$chunked");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return StringsKt.windowed(paramCharSequence, paramInt, paramInt, true, paramFunction1);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final Sequence<String> chunkedSequence(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$chunkedSequence");
    return StringsKt.chunkedSequence(paramCharSequence, paramInt, (Function1)StringsKt___StringsKt.chunkedSequence.1.INSTANCE);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <R> Sequence<R> chunkedSequence(@NotNull CharSequence paramCharSequence, int paramInt, @NotNull Function1<? super CharSequence, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$chunkedSequence");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    return StringsKt.windowedSequence(paramCharSequence, paramInt, paramInt, true, paramFunction1);
  }
  
  @InlineOnly
  private static final int count(@NotNull CharSequence paramCharSequence)
  {
    return paramCharSequence.length();
  }
  
  public static final int count(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$count");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int k;
    for (int j = 0; i < paramCharSequence.length(); j = k)
    {
      k = j;
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  @NotNull
  public static final CharSequence drop(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString()));
    }
    return paramCharSequence.subSequence(RangesKt.coerceAtMost(paramInt, paramCharSequence.length()), paramCharSequence.length());
  }
  
  @NotNull
  public static final String drop(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString()));
    }
    paramString = paramString.substring(RangesKt.coerceAtMost(paramInt, paramString.length()));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
    return paramString;
  }
  
  @NotNull
  public static final CharSequence dropLast(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString()));
    }
    return StringsKt.take(paramCharSequence, RangesKt.coerceAtLeast(paramCharSequence.length() - paramInt, 0));
  }
  
  @NotNull
  public static final String dropLast(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString()));
    }
    return StringsKt.take(paramString, RangesKt.coerceAtLeast(paramString.length() - paramInt, 0));
  }
  
  @NotNull
  public static final CharSequence dropLastWhile(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = StringsKt.getLastIndex(paramCharSequence);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return paramCharSequence.subSequence(0, i + 1);
      }
      i -= 1;
    }
    return (CharSequence)"";
  }
  
  @NotNull
  public static final String dropLastWhile(@NotNull String paramString, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$dropLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = StringsKt.getLastIndex((CharSequence)paramString);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue())
      {
        paramString = paramString.substring(0, i + 1);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return paramString;
      }
      i -= 1;
    }
    return "";
  }
  
  @NotNull
  public static final CharSequence dropWhile(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return paramCharSequence.subSequence(i, paramCharSequence.length());
      }
      i += 1;
    }
    return (CharSequence)"";
  }
  
  @NotNull
  public static final String dropWhile(@NotNull String paramString, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$dropWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = ((CharSequence)paramString).length();
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue())
      {
        paramString = paramString.substring(i);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
        return paramString;
      }
      i += 1;
    }
    return "";
  }
  
  @InlineOnly
  private static final char elementAtOrElse(@NotNull CharSequence paramCharSequence, int paramInt, Function1<? super Integer, Character> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= StringsKt.getLastIndex(paramCharSequence))) {
      return paramCharSequence.charAt(paramInt);
    }
    return ((Character)paramFunction1.invoke(Integer.valueOf(paramInt))).charValue();
  }
  
  @InlineOnly
  private static final Character elementAtOrNull(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    return StringsKt.getOrNull(paramCharSequence, paramInt);
  }
  
  @NotNull
  public static final CharSequence filter(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Appendable localAppendable = (Appendable)new StringBuilder();
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      i += 1;
    }
    return (CharSequence)localAppendable;
  }
  
  @NotNull
  public static final String filter(@NotNull String paramString, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$filter");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramString = (CharSequence)paramString;
    Appendable localAppendable = (Appendable)new StringBuilder();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      i += 1;
    }
    paramString = ((StringBuilder)localAppendable).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "filterTo(StringBuilder(), predicate).toString()");
    return paramString;
  }
  
  @NotNull
  public static final CharSequence filterIndexed(@NotNull CharSequence paramCharSequence, @NotNull Function2<? super Integer, ? super Character, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    Appendable localAppendable = (Appendable)new StringBuilder();
    int j = 0;
    while (j < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(j);
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      j += 1;
      i += 1;
    }
    return (CharSequence)localAppendable;
  }
  
  @NotNull
  public static final String filterIndexed(@NotNull String paramString, @NotNull Function2<? super Integer, ? super Character, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramString, "$this$filterIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    paramString = (CharSequence)paramString;
    Appendable localAppendable = (Appendable)new StringBuilder();
    int j = 0;
    while (j < paramString.length())
    {
      char c = paramString.charAt(j);
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      j += 1;
      i += 1;
    }
    paramString = ((StringBuilder)localAppendable).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "filterIndexedTo(StringBu…(), predicate).toString()");
    return paramString;
  }
  
  @NotNull
  public static final <C extends Appendable> C filterIndexedTo(@NotNull CharSequence paramCharSequence, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Character, Boolean> paramFunction2)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filterIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "predicate");
    int j = 0;
    while (j < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(j);
      if (((Boolean)paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(c))).booleanValue()) {
        paramC.append(c);
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final CharSequence filterNot(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Appendable localAppendable = (Appendable)new StringBuilder();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      i += 1;
    }
    return (CharSequence)localAppendable;
  }
  
  @NotNull
  public static final String filterNot(@NotNull String paramString, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$filterNot");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramString = (CharSequence)paramString;
    Appendable localAppendable = (Appendable)new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localAppendable.append(c);
      }
      i += 1;
    }
    paramString = ((StringBuilder)localAppendable).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "filterNotTo(StringBuilder(), predicate).toString()");
    return paramString;
  }
  
  @NotNull
  public static final <C extends Appendable> C filterNotTo(@NotNull CharSequence paramCharSequence, @NotNull C paramC, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filterNotTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        paramC.append(c);
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <C extends Appendable> C filterTo(@NotNull CharSequence paramCharSequence, @NotNull C paramC, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$filterTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        paramC.append(c);
      }
      i += 1;
    }
    return paramC;
  }
  
  @InlineOnly
  private static final Character find(@NotNull CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return Character.valueOf(c);
      }
      i += 1;
    }
    return null;
  }
  
  @InlineOnly
  private static final Character findLast(@NotNull CharSequence paramCharSequence, Function1<? super Character, Boolean> paramFunction1)
  {
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return Character.valueOf(c);
      }
      i -= 1;
    }
    return null;
  }
  
  public static final char first(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$first");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Char sequence is empty."));
    }
    return paramCharSequence.charAt(0);
  }
  
  public static final char first(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$first");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return c;
      }
      i += 1;
    }
    throw ((Throwable)new NoSuchElementException("Char sequence contains no character matching the predicate."));
  }
  
  @Nullable
  public static final Character firstOrNull(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$firstOrNull");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Character.valueOf(paramCharSequence.charAt(0));
  }
  
  @Nullable
  public static final Character firstOrNull(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$firstOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return Character.valueOf(c);
      }
      i += 1;
    }
    return null;
  }
  
  @NotNull
  public static final <R> List<R> flatMap(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$flatMap");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      CollectionsKt.addAll(localCollection, (Iterable)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i))));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull CharSequence paramCharSequence, @NotNull C paramC, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$flatMapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      CollectionsKt.addAll(paramC, (Iterable)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i))));
      i += 1;
    }
    return paramC;
  }
  
  public static final <R> R fold(@NotNull CharSequence paramCharSequence, R paramR, @NotNull Function2<? super R, ? super Character, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      paramR = paramFunction2.invoke(paramR, Character.valueOf(paramCharSequence.charAt(i)));
      i += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldIndexed(@NotNull CharSequence paramCharSequence, R paramR, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$foldIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= paramCharSequence.length()) {
        break;
      }
      char c = paramCharSequence.charAt(j);
      i = k + 1;
      paramR = paramFunction3.invoke(Integer.valueOf(k), paramR, Character.valueOf(c));
      j += 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRight(@NotNull CharSequence paramCharSequence, R paramR, @NotNull Function2<? super Character, ? super R, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$foldRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int i = StringsKt.getLastIndex(paramCharSequence);
    while (i >= 0)
    {
      paramR = paramFunction2.invoke(Character.valueOf(paramCharSequence.charAt(i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final <R> R foldRightIndexed(@NotNull CharSequence paramCharSequence, R paramR, @NotNull Function3<? super Integer, ? super Character, ? super R, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$foldRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int i = StringsKt.getLastIndex(paramCharSequence);
    while (i >= 0)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(paramCharSequence.charAt(i)), paramR);
      i -= 1;
    }
    return paramR;
  }
  
  public static final void forEach(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$forEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)));
      i += 1;
    }
  }
  
  public static final void forEachIndexed(@NotNull CharSequence paramCharSequence, @NotNull Function2<? super Integer, ? super Character, Unit> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$forEachIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= paramCharSequence.length()) {
        break;
      }
      char c = paramCharSequence.charAt(j);
      i = k + 1;
      paramFunction2.invoke(Integer.valueOf(k), Character.valueOf(c));
      j += 1;
    }
  }
  
  @InlineOnly
  private static final char getOrElse(@NotNull CharSequence paramCharSequence, int paramInt, Function1<? super Integer, Character> paramFunction1)
  {
    if ((paramInt >= 0) && (paramInt <= StringsKt.getLastIndex(paramCharSequence))) {
      return paramCharSequence.charAt(paramInt);
    }
    return ((Character)paramFunction1.invoke(Integer.valueOf(paramInt))).charValue();
  }
  
  @Nullable
  public static final Character getOrNull(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= StringsKt.getLastIndex(paramCharSequence))) {
      return Character.valueOf(paramCharSequence.charAt(paramInt));
    }
    return null;
  }
  
  @NotNull
  public static final <K> Map<K, List<Character>> groupBy(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Map localMap = (Map)new LinkedHashMap();
    int i = 0;
    if (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      Object localObject2 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Character.valueOf(c));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, V> Map<K, List<V>> groupBy(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends K> paramFunction1, @NotNull Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$groupBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    Map localMap = (Map)new LinkedHashMap();
    int i = 0;
    if (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      Object localObject2 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject1 = localMap.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        localMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Character.valueOf(c)));
        i += 1;
        break;
      }
    }
    return localMap;
  }
  
  @NotNull
  public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(@NotNull CharSequence paramCharSequence, @NotNull M paramM, @NotNull Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    int i = 0;
    if (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      Object localObject2 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(Character.valueOf(c));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @NotNull
  public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull CharSequence paramCharSequence, @NotNull M paramM, @NotNull Function1<? super Character, ? extends K> paramFunction1, @NotNull Function1<? super Character, ? extends V> paramFunction11)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$groupByTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    Intrinsics.checkParameterIsNotNull(paramFunction11, "valueTransform");
    int i = 0;
    if (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      Object localObject2 = paramFunction1.invoke(Character.valueOf(c));
      Object localObject1 = paramM.get(localObject2);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        paramM.put(localObject2, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add(paramFunction11.invoke(Character.valueOf(c)));
        i += 1;
        break;
      }
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <K> Grouping<Character, K> groupingBy(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends K> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$groupingBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "keySelector");
    return (Grouping)new StringsKt___StringsKt.groupingBy.1(paramCharSequence, paramFunction1);
  }
  
  public static final int indexOfFirst(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOfFirst");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    int j = paramCharSequence.length();
    while (i < j)
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int indexOfLast(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOfLast");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static final char last(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$last");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Char sequence is empty."));
    }
    return paramCharSequence.charAt(StringsKt.getLastIndex(paramCharSequence));
  }
  
  public static final char last(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$last");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return c;
      }
      i -= 1;
    }
    throw ((Throwable)new NoSuchElementException("Char sequence contains no character matching the predicate."));
  }
  
  @Nullable
  public static final Character lastOrNull(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastOrNull");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Character.valueOf(paramCharSequence.charAt(paramCharSequence.length() - 1));
  }
  
  @Nullable
  public static final Character lastOrNull(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        return Character.valueOf(c);
      }
      i -= 1;
    }
    return null;
  }
  
  @NotNull
  public static final <R> List<R> map(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$map");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList(paramCharSequence.length());
    int i = 0;
    while (i < paramCharSequence.length())
    {
      localCollection.add(paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i))));
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> mapIndexed(@NotNull CharSequence paramCharSequence, @NotNull Function2<? super Integer, ? super Character, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList(paramCharSequence.length());
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= paramCharSequence.length()) {
        break;
      }
      char c = paramCharSequence.charAt(j);
      i = k + 1;
      localCollection.add(paramFunction2.invoke(Integer.valueOf(k), Character.valueOf(c)));
      j += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R> List<R> mapIndexedNotNull(@NotNull CharSequence paramCharSequence, @NotNull Function2<? super Integer, ? super Character, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapIndexedNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int i = 0;
    while (j < paramCharSequence.length())
    {
      Object localObject = paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(paramCharSequence.charAt(j)));
      if (localObject != null) {
        localCollection.add(localObject);
      }
      j += 1;
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull CharSequence paramCharSequence, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Character, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapIndexedNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int i = 0;
    while (j < paramCharSequence.length())
    {
      Object localObject = paramFunction2.invoke(Integer.valueOf(i), Character.valueOf(paramCharSequence.charAt(j)));
      if (localObject != null) {
        paramC.add(localObject);
      }
      j += 1;
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull CharSequence paramCharSequence, @NotNull C paramC, @NotNull Function2<? super Integer, ? super Character, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapIndexedTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int i = 0;
    for (;;)
    {
      int k = i;
      if (j >= paramCharSequence.length()) {
        break;
      }
      char c = paramCharSequence.charAt(j);
      i = k + 1;
      paramC.add(paramFunction2.invoke(Integer.valueOf(k), Character.valueOf(c)));
      j += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R> List<R> mapNotNull(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapNotNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Collection localCollection = (Collection)new ArrayList();
    int i = 0;
    while (i < paramCharSequence.length())
    {
      Object localObject = paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)));
      if (localObject != null) {
        localCollection.add(localObject);
      }
      i += 1;
    }
    return (List)localCollection;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapNotNullTo(@NotNull CharSequence paramCharSequence, @NotNull C paramC, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapNotNullTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      Object localObject = paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)));
      if (localObject != null) {
        paramC.add(localObject);
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final <R, C extends Collection<? super R>> C mapTo(@NotNull CharSequence paramCharSequence, @NotNull C paramC, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$mapTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      paramC.add(paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i))));
      i += 1;
    }
    return paramC;
  }
  
  @Nullable
  public static final Character max(@NotNull CharSequence paramCharSequence)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$max");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    char c2 = c1;
    if (1 <= k)
    {
      c2 = c1;
      i = j;
      for (;;)
      {
        char c3 = paramCharSequence.charAt(i);
        c1 = c2;
        if (c2 < c3) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        c2 = c1;
      }
    }
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Character maxBy(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$maxBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    if (k == 0) {
      return Character.valueOf(c1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Character.valueOf(c1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        c2 = paramCharSequence.charAt(i);
        Comparable localComparable = (Comparable)paramFunction1.invoke(Character.valueOf(c2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) < 0)
        {
          localObject2 = localComparable;
          c1 = c2;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    char c2 = c1;
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final Character maxWith(@NotNull CharSequence paramCharSequence, @NotNull Comparator<? super Character> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$maxWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    char c2 = c1;
    if (1 <= k)
    {
      c2 = c1;
      i = j;
      for (;;)
      {
        char c3 = paramCharSequence.charAt(i);
        c1 = c2;
        if (paramComparator.compare(Character.valueOf(c2), Character.valueOf(c3)) < 0) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        c2 = c1;
      }
    }
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final Character min(@NotNull CharSequence paramCharSequence)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$min");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    char c2 = c1;
    if (1 <= k)
    {
      c2 = c1;
      i = j;
      for (;;)
      {
        char c3 = paramCharSequence.charAt(i);
        c1 = c2;
        if (c2 > c3) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        c2 = c1;
      }
    }
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final <R extends Comparable<? super R>> Character minBy(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, ? extends R> paramFunction1)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$minBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    if (k == 0) {
      return Character.valueOf(c1);
    }
    Object localObject1 = (Comparable)paramFunction1.invoke(Character.valueOf(c1));
    if (1 <= k)
    {
      i = j;
      for (;;)
      {
        c2 = paramCharSequence.charAt(i);
        Comparable localComparable = (Comparable)paramFunction1.invoke(Character.valueOf(c2));
        Object localObject2 = localObject1;
        if (((Comparable)localObject1).compareTo(localComparable) > 0)
        {
          localObject2 = localComparable;
          c1 = c2;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        localObject1 = localObject2;
      }
    }
    char c2 = c1;
    return Character.valueOf(c2);
  }
  
  @Nullable
  public static final Character minWith(@NotNull CharSequence paramCharSequence, @NotNull Comparator<? super Character> paramComparator)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$minWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    char c2 = c1;
    if (1 <= k)
    {
      c2 = c1;
      i = j;
      for (;;)
      {
        char c3 = paramCharSequence.charAt(i);
        c1 = c2;
        if (paramComparator.compare(Character.valueOf(c2), Character.valueOf(c3)) > 0) {
          c1 = c3;
        }
        c2 = c1;
        if (i == k) {
          break;
        }
        i += 1;
        c2 = c1;
      }
    }
    return Character.valueOf(c2);
  }
  
  public static final boolean none(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$none");
    return paramCharSequence.length() == 0;
  }
  
  public static final boolean none(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$none");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <S extends CharSequence> S onEach(@NotNull S paramS, @NotNull Function1<? super Character, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramS, "$this$onEach");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    int i = 0;
    while (i < paramS.length())
    {
      paramFunction1.invoke(Character.valueOf(paramS.charAt(i)));
      i += 1;
    }
    return paramS;
  }
  
  @NotNull
  public static final Pair<CharSequence, CharSequence> partition(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = 0;
    if (i < paramCharSequence.length())
    {
      char c = paramCharSequence.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localStringBuilder1.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder2.append(c);
      }
    }
    return new Pair(localStringBuilder1, localStringBuilder2);
  }
  
  @NotNull
  public static final Pair<String, String> partition(@NotNull String paramString, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$partition");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        localStringBuilder1.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder2.append(c);
      }
    }
    return new Pair(localStringBuilder1.toString(), localStringBuilder2.toString());
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final char random(@NotNull CharSequence paramCharSequence)
  {
    return StringsKt.random(paramCharSequence, (Random)Random.Default);
  }
  
  @SinceKotlin(version="1.3")
  public static final char random(@NotNull CharSequence paramCharSequence, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new NoSuchElementException("Char sequence is empty."));
    }
    return paramCharSequence.charAt(paramRandom.nextInt(paramCharSequence.length()));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final Character randomOrNull(@NotNull CharSequence paramCharSequence)
  {
    return StringsKt.randomOrNull(paramCharSequence, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Character randomOrNull(@NotNull CharSequence paramCharSequence, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return Character.valueOf(paramCharSequence.charAt(paramRandom.nextInt(paramCharSequence.length())));
  }
  
  public static final char reduce(@NotNull CharSequence paramCharSequence, @NotNull Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced."));
    }
    char c1 = paramCharSequence.charAt(0);
    int j = StringsKt.getLastIndex(paramCharSequence);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        c1 = ((Character)paramFunction2.invoke(Character.valueOf(c1), Character.valueOf(paramCharSequence.charAt(i)))).charValue();
        c2 = c1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    char c2 = c1;
    return c2;
  }
  
  public static final char reduceIndexed(@NotNull CharSequence paramCharSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced."));
    }
    char c1 = paramCharSequence.charAt(0);
    int j = StringsKt.getLastIndex(paramCharSequence);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        c1 = ((Character)paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(c1), Character.valueOf(paramCharSequence.charAt(i)))).charValue();
        c2 = c1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    char c2 = c1;
    return c2;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Character reduceOrNull(@NotNull CharSequence paramCharSequence, @NotNull Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reduceOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    char c1 = paramCharSequence.charAt(0);
    int j = StringsKt.getLastIndex(paramCharSequence);
    if (1 <= j)
    {
      i = 1;
      for (;;)
      {
        c1 = ((Character)paramFunction2.invoke(Character.valueOf(c1), Character.valueOf(paramCharSequence.charAt(i)))).charValue();
        c2 = c1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    char c2 = c1;
    return Character.valueOf(c2);
  }
  
  public static final char reduceRight(@NotNull CharSequence paramCharSequence, @NotNull Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reduceRight");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = StringsKt.getLastIndex(paramCharSequence);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced."));
    }
    int i = j - 1;
    char c = paramCharSequence.charAt(j);
    while (i >= 0)
    {
      c = ((Character)paramFunction2.invoke(Character.valueOf(paramCharSequence.charAt(i)), Character.valueOf(c))).charValue();
      i -= 1;
    }
    return c;
  }
  
  public static final char reduceRightIndexed(@NotNull CharSequence paramCharSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reduceRightIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    int j = StringsKt.getLastIndex(paramCharSequence);
    if (j < 0) {
      throw ((Throwable)new UnsupportedOperationException("Empty char sequence can't be reduced."));
    }
    int i = j - 1;
    char c = paramCharSequence.charAt(j);
    while (i >= 0)
    {
      c = ((Character)paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(paramCharSequence.charAt(i)), Character.valueOf(c))).charValue();
      i -= 1;
    }
    return c;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @Nullable
  public static final Character reduceRightOrNull(@NotNull CharSequence paramCharSequence, @NotNull Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reduceRightOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    int j = StringsKt.getLastIndex(paramCharSequence);
    if (j < 0) {
      return null;
    }
    int i = j - 1;
    char c = paramCharSequence.charAt(j);
    while (i >= 0)
    {
      c = ((Character)paramFunction2.invoke(Character.valueOf(paramCharSequence.charAt(i)), Character.valueOf(c))).charValue();
      i -= 1;
    }
    return Character.valueOf(c);
  }
  
  @NotNull
  public static final CharSequence reversed(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$reversed");
    paramCharSequence = new StringBuilder(paramCharSequence).reverse();
    Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "StringBuilder(this).reverse()");
    return (CharSequence)paramCharSequence;
  }
  
  @InlineOnly
  private static final String reversed(@NotNull String paramString)
  {
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.reversed((CharSequence)paramString).toString();
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R> List<R> scan(@NotNull CharSequence paramCharSequence, R paramR, @NotNull Function2<? super R, ? super Character, ? extends R> paramFunction2)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$scan");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramCharSequence.length() + 1);
    localArrayList.add(paramR);
    i = j;
    while (i < paramCharSequence.length())
    {
      paramR = paramFunction2.invoke(paramR, Character.valueOf(paramCharSequence.charAt(i)));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <R> List<R> scanIndexed(@NotNull CharSequence paramCharSequence, R paramR, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> paramFunction3)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$scanIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.listOf(paramR);
    }
    ArrayList localArrayList = new ArrayList(paramCharSequence.length() + 1);
    localArrayList.add(paramR);
    int k = paramCharSequence.length();
    i = j;
    while (i < k)
    {
      paramR = paramFunction3.invoke(Integer.valueOf(i), paramR, Character.valueOf(paramCharSequence.charAt(i)));
      localArrayList.add(paramR);
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<Character> scanReduce(@NotNull CharSequence paramCharSequence, @NotNull Function2<? super Character, ? super Character, Character> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$scanReduce");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    char c = paramCharSequence.charAt(0);
    ArrayList localArrayList = new ArrayList(paramCharSequence.length());
    localArrayList.add(Character.valueOf(c));
    int j = paramCharSequence.length();
    i = 1;
    while (i < j)
    {
      c = ((Character)paramFunction2.invoke(Character.valueOf(c), Character.valueOf(paramCharSequence.charAt(i)))).charValue();
      localArrayList.add(Character.valueOf(c));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final List<Character> scanReduceIndexed(@NotNull CharSequence paramCharSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$scanReduceIndexed");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return CollectionsKt.emptyList();
    }
    char c = paramCharSequence.charAt(0);
    ArrayList localArrayList = new ArrayList(paramCharSequence.length());
    localArrayList.add(Character.valueOf(c));
    int j = paramCharSequence.length();
    i = 1;
    while (i < j)
    {
      c = ((Character)paramFunction3.invoke(Integer.valueOf(i), Character.valueOf(c), Character.valueOf(paramCharSequence.charAt(i)))).charValue();
      localArrayList.add(Character.valueOf(c));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  public static final char single(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$single");
    switch (paramCharSequence.length())
    {
    default: 
      throw ((Throwable)new IllegalArgumentException("Char sequence has more than one element."));
    case 0: 
      throw ((Throwable)new NoSuchElementException("Char sequence is empty."));
    }
    return paramCharSequence.charAt(0);
  }
  
  public static final char single(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$single");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Character localCharacter = (Character)null;
    int k;
    for (int j = 0; i < paramCharSequence.length(); j = k)
    {
      char c = paramCharSequence.charAt(i);
      k = j;
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue())
      {
        if (j != 0) {
          throw ((Throwable)new IllegalArgumentException("Char sequence contains more than one matching element."));
        }
        localCharacter = Character.valueOf(c);
        k = 1;
      }
      i += 1;
    }
    if (j == 0) {
      throw ((Throwable)new NoSuchElementException("Char sequence contains no character matching the predicate."));
    }
    if (localCharacter == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Char");
    }
    return localCharacter.charValue();
  }
  
  @Nullable
  public static final Character singleOrNull(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$singleOrNull");
    if (paramCharSequence.length() == 1) {
      return Character.valueOf(paramCharSequence.charAt(0));
    }
    return null;
  }
  
  @Nullable
  public static final Character singleOrNull(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$singleOrNull");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Character localCharacter = (Character)null;
    int j = 0;
    if (i < paramCharSequence.length())
    {
      c = paramCharSequence.charAt(i);
      k = j;
      if (((Boolean)paramFunction1.invoke(Character.valueOf(c))).booleanValue()) {
        if (j == 0) {}
      }
    }
    while (j == 0)
    {
      char c;
      return null;
      localCharacter = Character.valueOf(c);
      int k = 1;
      i += 1;
      j = k;
      break;
    }
    return localCharacter;
  }
  
  @NotNull
  public static final CharSequence slice(@NotNull CharSequence paramCharSequence, @NotNull Iterable<Integer> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIterable, "indices");
    int i = CollectionsKt.collectionSizeOrDefault(paramIterable, 10);
    if (i == 0) {
      return (CharSequence)"";
    }
    StringBuilder localStringBuilder = new StringBuilder(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localStringBuilder.append(paramCharSequence.charAt(((Number)paramIterable.next()).intValue()));
    }
    return (CharSequence)localStringBuilder;
  }
  
  @NotNull
  public static final CharSequence slice(@NotNull CharSequence paramCharSequence, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return (CharSequence)"";
    }
    return StringsKt.subSequence(paramCharSequence, paramIntRange);
  }
  
  @InlineOnly
  private static final String slice(@NotNull String paramString, Iterable<Integer> paramIterable)
  {
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.slice((CharSequence)paramString, paramIterable).toString();
  }
  
  @NotNull
  public static final String slice(@NotNull String paramString, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$slice");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "indices");
    if (paramIntRange.isEmpty()) {
      return "";
    }
    return StringsKt.substring(paramString, paramIntRange);
  }
  
  public static final int sumBy(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Integer> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$sumBy");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    int i = 0;
    int j = 0;
    while (i < paramCharSequence.length())
    {
      j += ((Number)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).intValue();
      i += 1;
    }
    return j;
  }
  
  public static final double sumByDouble(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Double> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$sumByDouble");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "selector");
    double d = 0.0D;
    int i = 0;
    while (i < paramCharSequence.length())
    {
      d += ((Number)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).doubleValue();
      i += 1;
    }
    return d;
  }
  
  @NotNull
  public static final CharSequence take(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString()));
    }
    return paramCharSequence.subSequence(0, RangesKt.coerceAtMost(paramInt, paramCharSequence.length()));
  }
  
  @NotNull
  public static final String take(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString()));
    }
    paramString = paramString.substring(0, RangesKt.coerceAtMost(paramInt, paramString.length()));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString;
  }
  
  @NotNull
  public static final CharSequence takeLast(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString()));
    }
    i = paramCharSequence.length();
    return paramCharSequence.subSequence(i - RangesKt.coerceAtMost(paramInt, i), i);
  }
  
  @NotNull
  public static final String takeLast(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString()));
    }
    i = paramString.length();
    paramString = paramString.substring(i - RangesKt.coerceAtMost(paramInt, i));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
    return paramString;
  }
  
  @NotNull
  public static final CharSequence takeLastWhile(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = StringsKt.getLastIndex(paramCharSequence);
    while (i >= 0)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return paramCharSequence.subSequence(i + 1, paramCharSequence.length());
      }
      i -= 1;
    }
    return paramCharSequence.subSequence(0, paramCharSequence.length());
  }
  
  @NotNull
  public static final String takeLastWhile(@NotNull String paramString, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$takeLastWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = StringsKt.getLastIndex((CharSequence)paramString);
    for (;;)
    {
      String str = paramString;
      if (i >= 0)
      {
        if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue())
        {
          str = paramString.substring(i + 1);
          Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
        }
      }
      else {
        return str;
      }
      i -= 1;
    }
  }
  
  @NotNull
  public static final CharSequence takeWhile(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(i)))).booleanValue()) {
        return paramCharSequence.subSequence(0, i);
      }
      i += 1;
    }
    return paramCharSequence.subSequence(0, paramCharSequence.length());
  }
  
  @NotNull
  public static final String takeWhile(@NotNull String paramString, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$takeWhile");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < j)
      {
        if (!((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue())
        {
          str = paramString.substring(0, i);
          Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
      else {
        return str;
      }
      i += 1;
    }
  }
  
  @NotNull
  public static final <C extends Collection<? super Character>> C toCollection(@NotNull CharSequence paramCharSequence, @NotNull C paramC)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toCollection");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    int i = 0;
    while (i < paramCharSequence.length())
    {
      paramC.add(Character.valueOf(paramCharSequence.charAt(i)));
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final HashSet<Character> toHashSet(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toHashSet");
    return (HashSet)StringsKt.toCollection(paramCharSequence, (Collection)new HashSet(MapsKt.mapCapacity(paramCharSequence.length())));
  }
  
  @NotNull
  public static final List<Character> toList(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toList");
    switch (paramCharSequence.length())
    {
    default: 
      return StringsKt.toMutableList(paramCharSequence);
    case 0: 
      return CollectionsKt.emptyList();
    }
    return CollectionsKt.listOf(Character.valueOf(paramCharSequence.charAt(0)));
  }
  
  @NotNull
  public static final List<Character> toMutableList(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toMutableList");
    return (List)StringsKt.toCollection(paramCharSequence, (Collection)new ArrayList(paramCharSequence.length()));
  }
  
  @NotNull
  public static final Set<Character> toSet(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$toSet");
    switch (paramCharSequence.length())
    {
    default: 
      return (Set)StringsKt.toCollection(paramCharSequence, (Collection)new LinkedHashSet(MapsKt.mapCapacity(paramCharSequence.length())));
    case 0: 
      return SetsKt.emptySet();
    }
    return SetsKt.setOf(Character.valueOf(paramCharSequence.charAt(0)));
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final List<String> windowed(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$windowed");
    return StringsKt.windowed(paramCharSequence, paramInt1, paramInt2, paramBoolean, (Function1)StringsKt___StringsKt.windowed.1.INSTANCE);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <R> List<R> windowed(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean, @NotNull Function1<? super CharSequence, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$windowed");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    SlidingWindowKt.checkWindowSizeStep(paramInt1, paramInt2);
    int k = paramCharSequence.length();
    int j = k / paramInt2;
    int i;
    ArrayList localArrayList;
    if (k % paramInt2 == 0)
    {
      i = 0;
      localArrayList = new ArrayList(j + i);
      i = 0;
    }
    for (;;)
    {
      if (i < 0) {}
      do
      {
        do
        {
          return (List)localArrayList;
          i = 1;
          break;
        } while (k <= i);
        int m = i + paramInt1;
        if (m >= 0)
        {
          j = m;
          if (m <= k) {
            break label115;
          }
        }
      } while (!paramBoolean);
      j = k;
      label115:
      localArrayList.add(paramFunction1.invoke(paramCharSequence.subSequence(i, j)));
      i += paramInt2;
    }
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final Sequence<String> windowedSequence(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$windowedSequence");
    return StringsKt.windowedSequence(paramCharSequence, paramInt1, paramInt2, paramBoolean, (Function1)StringsKt___StringsKt.windowedSequence.1.INSTANCE);
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <R> Sequence<R> windowedSequence(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2, boolean paramBoolean, @NotNull Function1<? super CharSequence, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$windowedSequence");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    SlidingWindowKt.checkWindowSizeStep(paramInt1, paramInt2);
    if (paramBoolean) {}
    for (IntRange localIntRange = StringsKt.getIndices(paramCharSequence);; localIntRange = RangesKt.until(0, paramCharSequence.length() - paramInt1 + 1)) {
      return SequencesKt.map(CollectionsKt.asSequence((Iterable)RangesKt.step((IntProgression)localIntRange, paramInt2)), (Function1)new StringsKt___StringsKt.windowedSequence.2(paramCharSequence, paramInt1, paramFunction1));
    }
  }
  
  @NotNull
  public static final Iterable<IndexedValue<Character>> withIndex(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$withIndex");
    return (Iterable)new IndexingIterable((Function0)new StringsKt___StringsKt.withIndex.1(paramCharSequence));
  }
  
  @NotNull
  public static final List<Pair<Character, Character>> zip(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    int j = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Character.valueOf(paramCharSequence1.charAt(i)), Character.valueOf(paramCharSequence2.charAt(i))));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @NotNull
  public static final <V> List<V> zip(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull Function2<? super Character, ? super Character, ? extends V> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$zip");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Character.valueOf(paramCharSequence1.charAt(i)), Character.valueOf(paramCharSequence2.charAt(i))));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final List<Pair<Character, Character>> zipWithNext(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$zipWithNext");
    int j = paramCharSequence.length() - 1;
    if (j < 1) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(TuplesKt.to(Character.valueOf(paramCharSequence.charAt(i)), Character.valueOf(paramCharSequence.charAt(i + 1))));
      i += 1;
    }
    return (List)localArrayList;
  }
  
  @SinceKotlin(version="1.2")
  @NotNull
  public static final <R> List<R> zipWithNext(@NotNull CharSequence paramCharSequence, @NotNull Function2<? super Character, ? super Character, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$zipWithNext");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "transform");
    int j = paramCharSequence.length() - 1;
    if (j < 1) {
      return CollectionsKt.emptyList();
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramFunction2.invoke(Character.valueOf(paramCharSequence.charAt(i)), Character.valueOf(paramCharSequence.charAt(i + 1))));
      i += 1;
    }
    return (List)localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.StringsKt___StringsKt
 * JD-Core Version:    0.7.0.1
 */