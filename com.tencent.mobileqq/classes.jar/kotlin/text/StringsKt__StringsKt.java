package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
public class StringsKt__StringsKt
  extends StringsKt__StringsJVMKt
{
  @NotNull
  public static final String commonPrefixWith(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$commonPrefixWith");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    int j = Math.min(paramCharSequence1.length(), paramCharSequence2.length());
    int i = 0;
    while ((i < j) && (CharsKt.equals(paramCharSequence1.charAt(i), paramCharSequence2.charAt(i), paramBoolean))) {
      i += 1;
    }
    if (!StringsKt.hasSurrogatePairAt(paramCharSequence1, i - 1))
    {
      j = i;
      if (!StringsKt.hasSurrogatePairAt(paramCharSequence2, i - 1)) {}
    }
    else
    {
      j = i - 1;
    }
    return paramCharSequence1.subSequence(0, j).toString();
  }
  
  @NotNull
  public static final String commonSuffixWith(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$commonSuffixWith");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    int k = paramCharSequence1.length();
    int m = paramCharSequence2.length();
    int j = Math.min(k, m);
    int i = 0;
    while ((i < j) && (CharsKt.equals(paramCharSequence1.charAt(k - i - 1), paramCharSequence2.charAt(m - i - 1), paramBoolean))) {
      i += 1;
    }
    if (!StringsKt.hasSurrogatePairAt(paramCharSequence1, k - i - 1))
    {
      j = i;
      if (!StringsKt.hasSurrogatePairAt(paramCharSequence2, m - i - 1)) {}
    }
    else
    {
      j = i - 1;
    }
    return paramCharSequence1.subSequence(k - j, k).toString();
  }
  
  public static final boolean contains(@NotNull CharSequence paramCharSequence, char paramChar, boolean paramBoolean)
  {
    boolean bool = false;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$contains");
    if (StringsKt.indexOf$default(paramCharSequence, paramChar, 0, paramBoolean, 2, null) >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public static final boolean contains(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$contains");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    if ((paramCharSequence2 instanceof String)) {
      return StringsKt.indexOf$default(paramCharSequence1, (String)paramCharSequence2, 0, paramBoolean, 2, null) >= 0;
    }
    return indexOf$StringsKt__StringsKt$default(paramCharSequence1, paramCharSequence2, 0, paramCharSequence1.length(), paramBoolean, false, 16, null) >= 0;
  }
  
  @InlineOnly
  private static final boolean contains(@NotNull CharSequence paramCharSequence, Regex paramRegex)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$contains");
    return paramRegex.containsMatchIn(paramCharSequence);
  }
  
  public static final boolean endsWith(@NotNull CharSequence paramCharSequence, char paramChar, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$endsWith");
    return (paramCharSequence.length() > 0) && (CharsKt.equals(paramCharSequence.charAt(StringsKt.getLastIndex(paramCharSequence)), paramChar, paramBoolean));
  }
  
  public static final boolean endsWith(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$endsWith");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "suffix");
    if ((!paramBoolean) && ((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return StringsKt.endsWith$default((String)paramCharSequence1, (String)paramCharSequence2, false, 2, null);
    }
    return StringsKt.regionMatchesImpl(paramCharSequence1, paramCharSequence1.length() - paramCharSequence2.length(), paramCharSequence2, 0, paramCharSequence2.length(), paramBoolean);
  }
  
  @Nullable
  public static final Pair<Integer, String> findAnyOf(@NotNull CharSequence paramCharSequence, @NotNull Collection<String> paramCollection, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$findAnyOf");
    Intrinsics.checkParameterIsNotNull(paramCollection, "strings");
    return findAnyOf$StringsKt__StringsKt(paramCharSequence, paramCollection, paramInt, paramBoolean, false);
  }
  
  private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(@NotNull CharSequence paramCharSequence, Collection<String> paramCollection, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (paramCollection.size() == 1))
    {
      paramCollection = (String)CollectionsKt.single((Iterable)paramCollection);
      if (!paramBoolean2) {}
      for (paramInt = StringsKt.indexOf$default(paramCharSequence, paramCollection, paramInt, false, 4, null); paramInt < 0; paramInt = StringsKt.lastIndexOf$default(paramCharSequence, paramCollection, paramInt, false, 4, null)) {
        return null;
      }
      return TuplesKt.to(Integer.valueOf(paramInt), paramCollection);
    }
    Object localObject;
    int i;
    int j;
    int k;
    if (!paramBoolean2)
    {
      localObject = (IntProgression)new IntRange(RangesKt.coerceAtLeast(paramInt, 0), paramCharSequence.length());
      if (!(paramCharSequence instanceof String)) {
        break label267;
      }
      i = ((IntProgression)localObject).getFirst();
      j = ((IntProgression)localObject).getLast();
      k = ((IntProgression)localObject).getStep();
      if (k < 0) {
        break label235;
      }
      if (i > j) {
        break label245;
      }
      paramInt = i;
    }
    Iterator localIterator;
    String str;
    label235:
    do
    {
      localIterator = ((Iterable)paramCollection).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
        str = (String)localObject;
      } while (!StringsKt.regionMatches(str, 0, (String)paramCharSequence, paramInt, str.length(), paramBoolean1));
      localObject = (String)localObject;
      if (localObject == null) {
        break label253;
      }
      return TuplesKt.to(Integer.valueOf(paramInt), localObject);
      localObject = RangesKt.downTo(RangesKt.coerceAtMost(paramInt, StringsKt.getLastIndex(paramCharSequence)), 0);
      break;
      paramInt = i;
    } while (i >= j);
    label245:
    label253:
    do
    {
      do
      {
        return null;
        localObject = null;
        break;
      } while (paramInt == j);
      paramInt += k;
      break;
      paramInt = ((IntProgression)localObject).getFirst();
      i = ((IntProgression)localObject).getLast();
      j = ((IntProgression)localObject).getStep();
      if (j < 0) {
        break label377;
      }
    } while (paramInt > i);
    for (;;)
    {
      label267:
      label298:
      localIterator = ((Iterable)paramCollection).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
        str = (String)localObject;
      } while (!StringsKt.regionMatchesImpl((CharSequence)str, 0, paramCharSequence, paramInt, str.length(), paramBoolean1));
      for (;;)
      {
        localObject = (String)localObject;
        if (localObject == null) {
          break label392;
        }
        return TuplesKt.to(Integer.valueOf(paramInt), localObject);
        label377:
        if (paramInt < i) {
          break;
        }
        break label298;
        localObject = null;
      }
      label392:
      if (paramInt == i) {
        break;
      }
      paramInt += j;
    }
  }
  
  @Nullable
  public static final Pair<Integer, String> findLastAnyOf(@NotNull CharSequence paramCharSequence, @NotNull Collection<String> paramCollection, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$findLastAnyOf");
    Intrinsics.checkParameterIsNotNull(paramCollection, "strings");
    return findAnyOf$StringsKt__StringsKt(paramCharSequence, paramCollection, paramInt, paramBoolean, true);
  }
  
  @NotNull
  public static final IntRange getIndices(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indices");
    return new IntRange(0, paramCharSequence.length() - 1);
  }
  
  public static final int getLastIndex(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastIndex");
    return paramCharSequence.length() - 1;
  }
  
  public static final boolean hasSurrogatePairAt(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$hasSurrogatePairAt");
    int i = paramCharSequence.length();
    if (paramInt < 0) {}
    while ((i - 2 < paramInt) || (!Character.isHighSurrogate(paramCharSequence.charAt(paramInt))) || (!Character.isLowSurrogate(paramCharSequence.charAt(paramInt + 1)))) {
      return false;
    }
    return true;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends CharSequence,  extends R, R> R ifBlank(C paramC, Function0<? extends R> paramFunction0)
  {
    Object localObject = paramC;
    if (StringsKt.isBlank(paramC)) {
      localObject = paramFunction0.invoke();
    }
    return localObject;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends CharSequence,  extends R, R> R ifEmpty(C paramC, Function0<? extends R> paramFunction0)
  {
    if (paramC.length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramC = paramFunction0.invoke();
      }
      return paramC;
    }
  }
  
  public static final int indexOf(@NotNull CharSequence paramCharSequence, char paramChar, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOf");
    if ((paramBoolean) || (!(paramCharSequence instanceof String))) {
      return StringsKt.indexOfAny(paramCharSequence, new char[] { paramChar }, paramInt, paramBoolean);
    }
    return ((String)paramCharSequence).indexOf(paramChar, paramInt);
  }
  
  public static final int indexOf(@NotNull CharSequence paramCharSequence, @NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOf");
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    if ((paramBoolean) || (!(paramCharSequence instanceof String))) {
      return indexOf$StringsKt__StringsKt$default(paramCharSequence, (CharSequence)paramString, paramInt, paramCharSequence.length(), paramBoolean, false, 16, null);
    }
    return ((String)paramCharSequence).indexOf(paramString, paramInt);
  }
  
  private static final int indexOf$StringsKt__StringsKt(@NotNull CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    IntProgression localIntProgression;
    int i;
    int j;
    if (!paramBoolean2)
    {
      localIntProgression = (IntProgression)new IntRange(RangesKt.coerceAtLeast(paramInt1, 0), RangesKt.coerceAtMost(paramInt2, paramCharSequence1.length()));
      if ((!(paramCharSequence1 instanceof String)) || (!(paramCharSequence2 instanceof String))) {
        break label152;
      }
      paramInt2 = localIntProgression.getFirst();
      i = localIntProgression.getLast();
      j = localIntProgression.getStep();
      if (j < 0) {
        break label128;
      }
      if (paramInt2 > i) {
        break label136;
      }
      paramInt1 = paramInt2;
    }
    label128:
    do
    {
      if (!StringsKt.regionMatches((String)paramCharSequence2, 0, (String)paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
        break label138;
      }
      paramInt2 = paramInt1;
      return paramInt2;
      localIntProgression = RangesKt.downTo(RangesKt.coerceAtMost(paramInt1, StringsKt.getLastIndex(paramCharSequence1)), RangesKt.coerceAtLeast(paramInt2, 0));
      break;
      paramInt1 = paramInt2;
    } while (paramInt2 >= i);
    label136:
    label138:
    label152:
    do
    {
      do
      {
        return -1;
      } while (paramInt1 == i);
      paramInt1 += j;
      break;
      paramInt1 = localIntProgression.getFirst();
      i = localIntProgression.getLast();
      j = localIntProgression.getStep();
      if (j < 0) {
        break label217;
      }
    } while (paramInt1 > i);
    for (;;)
    {
      paramInt2 = paramInt1;
      if (StringsKt.regionMatchesImpl(paramCharSequence2, 0, paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
        break;
      }
      if (paramInt1 == i) {
        break label136;
      }
      paramInt1 += j;
      continue;
      label217:
      if (paramInt1 < i) {
        break label136;
      }
    }
  }
  
  public static final int indexOfAny(@NotNull CharSequence paramCharSequence, @NotNull Collection<String> paramCollection, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOfAny");
    Intrinsics.checkParameterIsNotNull(paramCollection, "strings");
    paramCharSequence = findAnyOf$StringsKt__StringsKt(paramCharSequence, paramCollection, paramInt, paramBoolean, false);
    if (paramCharSequence != null)
    {
      paramCharSequence = (Integer)paramCharSequence.getFirst();
      if (paramCharSequence != null) {
        return paramCharSequence.intValue();
      }
    }
    return -1;
  }
  
  public static final int indexOfAny(@NotNull CharSequence paramCharSequence, @NotNull char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$indexOfAny");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      i = ArraysKt.single(paramArrayOfChar);
      i = ((String)paramCharSequence).indexOf(i, paramInt);
      return i;
    }
    paramInt = RangesKt.coerceAtLeast(paramInt, 0);
    int k = StringsKt.getLastIndex(paramCharSequence);
    if (paramInt <= k)
    {
      label70:
      char c = paramCharSequence.charAt(paramInt);
      int j = paramArrayOfChar.length;
      i = 0;
      label86:
      if (i < j) {
        if (!CharsKt.equals(paramArrayOfChar[i], c, paramBoolean)) {}
      }
      for (j = 1;; j = 0)
      {
        i = paramInt;
        if (j != 0) {
          break;
        }
        if (paramInt == k) {
          break label145;
        }
        paramInt += 1;
        break label70;
        i += 1;
        break label86;
      }
    }
    label145:
    return -1;
  }
  
  @InlineOnly
  private static final boolean isEmpty(@NotNull CharSequence paramCharSequence)
  {
    return paramCharSequence.length() == 0;
  }
  
  @InlineOnly
  private static final boolean isNotBlank(@NotNull CharSequence paramCharSequence)
  {
    return !StringsKt.isBlank(paramCharSequence);
  }
  
  @InlineOnly
  private static final boolean isNotEmpty(@NotNull CharSequence paramCharSequence)
  {
    return paramCharSequence.length() > 0;
  }
  
  @InlineOnly
  private static final boolean isNullOrBlank(@Nullable CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (StringsKt.isBlank(paramCharSequence));
  }
  
  @InlineOnly
  private static final boolean isNullOrEmpty(@Nullable CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  @NotNull
  public static final CharIterator iterator(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$iterator");
    return (CharIterator)new StringsKt__StringsKt.iterator.1(paramCharSequence);
  }
  
  public static final int lastIndexOf(@NotNull CharSequence paramCharSequence, char paramChar, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastIndexOf");
    if ((paramBoolean) || (!(paramCharSequence instanceof String))) {
      return StringsKt.lastIndexOfAny(paramCharSequence, new char[] { paramChar }, paramInt, paramBoolean);
    }
    return ((String)paramCharSequence).lastIndexOf(paramChar, paramInt);
  }
  
  public static final int lastIndexOf(@NotNull CharSequence paramCharSequence, @NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastIndexOf");
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    if ((paramBoolean) || (!(paramCharSequence instanceof String))) {
      return indexOf$StringsKt__StringsKt(paramCharSequence, (CharSequence)paramString, paramInt, 0, paramBoolean, true);
    }
    return ((String)paramCharSequence).lastIndexOf(paramString, paramInt);
  }
  
  public static final int lastIndexOfAny(@NotNull CharSequence paramCharSequence, @NotNull Collection<String> paramCollection, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastIndexOfAny");
    Intrinsics.checkParameterIsNotNull(paramCollection, "strings");
    paramCharSequence = findAnyOf$StringsKt__StringsKt(paramCharSequence, paramCollection, paramInt, paramBoolean, true);
    if (paramCharSequence != null)
    {
      paramCharSequence = (Integer)paramCharSequence.getFirst();
      if (paramCharSequence != null) {
        return paramCharSequence.intValue();
      }
    }
    return -1;
  }
  
  public static final int lastIndexOfAny(@NotNull CharSequence paramCharSequence, @NotNull char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lastIndexOfAny");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      i = ArraysKt.single(paramArrayOfChar);
      i = ((String)paramCharSequence).lastIndexOf(i, paramInt);
      return i;
    }
    paramInt = RangesKt.coerceAtMost(paramInt, StringsKt.getLastIndex(paramCharSequence));
    label61:
    if (paramInt >= 0)
    {
      char c = paramCharSequence.charAt(paramInt);
      int j = paramArrayOfChar.length;
      i = 0;
      label81:
      if (i < j) {
        if (!CharsKt.equals(paramArrayOfChar[i], c, paramBoolean)) {}
      }
      for (j = 1;; j = 0)
      {
        i = paramInt;
        if (j != 0) {
          break;
        }
        paramInt -= 1;
        break label61;
        i += 1;
        break label81;
      }
    }
    return -1;
  }
  
  @NotNull
  public static final Sequence<String> lineSequence(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lineSequence");
    return StringsKt.splitToSequence$default(paramCharSequence, new String[] { "\r\n", "\n", "\r" }, false, 0, 6, null);
  }
  
  @NotNull
  public static final List<String> lines(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$lines");
    return SequencesKt.toList(StringsKt.lineSequence(paramCharSequence));
  }
  
  @InlineOnly
  private static final boolean matches(@NotNull CharSequence paramCharSequence, Regex paramRegex)
  {
    return paramRegex.matches(paramCharSequence);
  }
  
  @InlineOnly
  private static final String orEmpty(@Nullable String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  @NotNull
  public static final CharSequence padEnd(@NotNull CharSequence paramCharSequence, int paramInt, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$padEnd");
    if (paramInt < 0) {
      throw ((Throwable)new IllegalArgumentException("Desired length " + paramInt + " is less than zero."));
    }
    if (paramInt <= paramCharSequence.length()) {
      return paramCharSequence.subSequence(0, paramCharSequence.length());
    }
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    localStringBuilder.append(paramCharSequence);
    int i = 1;
    int j = paramInt - paramCharSequence.length();
    if (1 <= j)
    {
      paramInt = i;
      for (;;)
      {
        localStringBuilder.append(paramChar);
        if (paramInt == j) {
          break;
        }
        paramInt += 1;
      }
    }
    return (CharSequence)localStringBuilder;
  }
  
  @NotNull
  public static final String padEnd(@NotNull String paramString, int paramInt, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$padEnd");
    return StringsKt.padEnd((CharSequence)paramString, paramInt, paramChar).toString();
  }
  
  @NotNull
  public static final CharSequence padStart(@NotNull CharSequence paramCharSequence, int paramInt, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$padStart");
    if (paramInt < 0) {
      throw ((Throwable)new IllegalArgumentException("Desired length " + paramInt + " is less than zero."));
    }
    if (paramInt <= paramCharSequence.length()) {
      return paramCharSequence.subSequence(0, paramCharSequence.length());
    }
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    int i = 1;
    int j = paramInt - paramCharSequence.length();
    if (1 <= j)
    {
      paramInt = i;
      for (;;)
      {
        localStringBuilder.append(paramChar);
        if (paramInt == j) {
          break;
        }
        paramInt += 1;
      }
    }
    localStringBuilder.append(paramCharSequence);
    return (CharSequence)localStringBuilder;
  }
  
  @NotNull
  public static final String padStart(@NotNull String paramString, int paramInt, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$padStart");
    return StringsKt.padStart((CharSequence)paramString, paramInt, paramChar).toString();
  }
  
  private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(@NotNull CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Limit must be non-negative, but was " + paramInt2 + '.').toString()));
    }
    return (Sequence)new DelimitedRangesSequence(paramCharSequence, paramInt1, paramInt2, (Function2)new StringsKt__StringsKt.rangesDelimitedBy.2(paramArrayOfChar, paramBoolean));
  }
  
  private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(@NotNull CharSequence paramCharSequence, String[] paramArrayOfString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Limit must be non-negative, but was " + paramInt2 + '.').toString()));
    }
    return (Sequence)new DelimitedRangesSequence(paramCharSequence, paramInt1, paramInt2, (Function2)new StringsKt__StringsKt.rangesDelimitedBy.4(ArraysKt.asList(paramArrayOfString), paramBoolean));
  }
  
  public static final boolean regionMatchesImpl(@NotNull CharSequence paramCharSequence1, int paramInt1, @NotNull CharSequence paramCharSequence2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$regionMatchesImpl");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "other");
    if ((paramInt2 < 0) || (paramInt1 < 0) || (paramInt1 > paramCharSequence1.length() - paramInt3) || (paramInt2 > paramCharSequence2.length() - paramInt3)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramInt3) {
        break label96;
      }
      if (!CharsKt.equals(paramCharSequence1.charAt(paramInt1 + i), paramCharSequence2.charAt(paramInt2 + i), paramBoolean)) {
        break;
      }
      i += 1;
    }
    label96:
    return true;
  }
  
  @NotNull
  public static final CharSequence removePrefix(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$removePrefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    if (StringsKt.startsWith$default(paramCharSequence1, paramCharSequence2, false, 2, null)) {
      return paramCharSequence1.subSequence(paramCharSequence2.length(), paramCharSequence1.length());
    }
    return paramCharSequence1.subSequence(0, paramCharSequence1.length());
  }
  
  @NotNull
  public static final String removePrefix(@NotNull String paramString, @NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$removePrefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "prefix");
    String str = paramString;
    if (StringsKt.startsWith$default((CharSequence)paramString, paramCharSequence, false, 2, null))
    {
      str = paramString.substring(paramCharSequence.length());
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
    }
    return str;
  }
  
  @NotNull
  public static final CharSequence removeRange(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$removeRange");
    if (paramInt2 < paramInt1) {
      throw ((Throwable)new IndexOutOfBoundsException("End index (" + paramInt2 + ") is less than start index (" + paramInt1 + ")."));
    }
    if (paramInt2 == paramInt1) {
      return paramCharSequence.subSequence(0, paramCharSequence.length());
    }
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length() - (paramInt2 - paramInt1));
    Intrinsics.checkExpressionValueIsNotNull(localStringBuilder.append(paramCharSequence, 0, paramInt1), "this.append(value, startIndex, endIndex)");
    Intrinsics.checkExpressionValueIsNotNull(localStringBuilder.append(paramCharSequence, paramInt2, paramCharSequence.length()), "this.append(value, startIndex, endIndex)");
    return (CharSequence)localStringBuilder;
  }
  
  @NotNull
  public static final CharSequence removeRange(@NotNull CharSequence paramCharSequence, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$removeRange");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    return StringsKt.removeRange(paramCharSequence, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @InlineOnly
  private static final String removeRange(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.removeRange((CharSequence)paramString, paramInt1, paramInt2).toString();
  }
  
  @InlineOnly
  private static final String removeRange(@NotNull String paramString, IntRange paramIntRange)
  {
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.removeRange((CharSequence)paramString, paramIntRange).toString();
  }
  
  @NotNull
  public static final CharSequence removeSuffix(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$removeSuffix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "suffix");
    if (StringsKt.endsWith$default(paramCharSequence1, paramCharSequence2, false, 2, null)) {
      return paramCharSequence1.subSequence(0, paramCharSequence1.length() - paramCharSequence2.length());
    }
    return paramCharSequence1.subSequence(0, paramCharSequence1.length());
  }
  
  @NotNull
  public static final String removeSuffix(@NotNull String paramString, @NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$removeSuffix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "suffix");
    String str = paramString;
    if (StringsKt.endsWith$default((CharSequence)paramString, paramCharSequence, false, 2, null))
    {
      str = paramString.substring(0, paramString.length() - paramCharSequence.length());
      Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    return str;
  }
  
  @NotNull
  public static final CharSequence removeSurrounding(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$removeSurrounding");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "delimiter");
    return StringsKt.removeSurrounding(paramCharSequence1, paramCharSequence2, paramCharSequence2);
  }
  
  @NotNull
  public static final CharSequence removeSurrounding(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, @NotNull CharSequence paramCharSequence3)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$removeSurrounding");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence3, "suffix");
    if ((paramCharSequence1.length() >= paramCharSequence2.length() + paramCharSequence3.length()) && (StringsKt.startsWith$default(paramCharSequence1, paramCharSequence2, false, 2, null)) && (StringsKt.endsWith$default(paramCharSequence1, paramCharSequence3, false, 2, null))) {
      return paramCharSequence1.subSequence(paramCharSequence2.length(), paramCharSequence1.length() - paramCharSequence3.length());
    }
    return paramCharSequence1.subSequence(0, paramCharSequence1.length());
  }
  
  @NotNull
  public static final String removeSurrounding(@NotNull String paramString, @NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$removeSurrounding");
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "delimiter");
    return StringsKt.removeSurrounding(paramString, paramCharSequence, paramCharSequence);
  }
  
  @NotNull
  public static final String removeSurrounding(@NotNull String paramString, @NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$removeSurrounding");
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "prefix");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "suffix");
    String str = paramString;
    if (paramString.length() >= paramCharSequence1.length() + paramCharSequence2.length())
    {
      str = paramString;
      if (StringsKt.startsWith$default((CharSequence)paramString, paramCharSequence1, false, 2, null))
      {
        str = paramString;
        if (StringsKt.endsWith$default((CharSequence)paramString, paramCharSequence2, false, 2, null))
        {
          str = paramString.substring(paramCharSequence1.length(), paramString.length() - paramCharSequence2.length());
          Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
      }
    }
    return str;
  }
  
  @InlineOnly
  private static final String replace(@NotNull CharSequence paramCharSequence, Regex paramRegex, String paramString)
  {
    return paramRegex.replace(paramCharSequence, paramString);
  }
  
  @InlineOnly
  private static final String replace(@NotNull CharSequence paramCharSequence, Regex paramRegex, Function1<? super MatchResult, ? extends CharSequence> paramFunction1)
  {
    return paramRegex.replace(paramCharSequence, paramFunction1);
  }
  
  @NotNull
  public static final String replaceAfter(@NotNull String paramString1, char paramChar, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceAfter");
    Intrinsics.checkParameterIsNotNull(paramString2, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    int j = paramString1.length();
    return StringsKt.replaceRange((CharSequence)paramString1, i + 1, j, (CharSequence)paramString2).toString();
  }
  
  @NotNull
  public static final String replaceAfter(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceAfter");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString4, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString4;
    }
    int j = paramString2.length();
    int k = paramString1.length();
    return StringsKt.replaceRange((CharSequence)paramString1, i + j, k, (CharSequence)paramString3).toString();
  }
  
  @NotNull
  public static final String replaceAfterLast(@NotNull String paramString1, char paramChar, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceAfterLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    int j = paramString1.length();
    return StringsKt.replaceRange((CharSequence)paramString1, i + 1, j, (CharSequence)paramString2).toString();
  }
  
  @NotNull
  public static final String replaceAfterLast(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceAfterLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString4, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString4;
    }
    int j = paramString2.length();
    int k = paramString1.length();
    return StringsKt.replaceRange((CharSequence)paramString1, i + j, k, (CharSequence)paramString3).toString();
  }
  
  @NotNull
  public static final String replaceBefore(@NotNull String paramString1, char paramChar, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceBefore");
    Intrinsics.checkParameterIsNotNull(paramString2, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    return StringsKt.replaceRange((CharSequence)paramString1, 0, i, (CharSequence)paramString2).toString();
  }
  
  @NotNull
  public static final String replaceBefore(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceBefore");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString4, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString4;
    }
    return StringsKt.replaceRange((CharSequence)paramString1, 0, i, (CharSequence)paramString3).toString();
  }
  
  @NotNull
  public static final String replaceBeforeLast(@NotNull String paramString1, char paramChar, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceBeforeLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    return StringsKt.replaceRange((CharSequence)paramString1, 0, i, (CharSequence)paramString2).toString();
  }
  
  @NotNull
  public static final String replaceBeforeLast(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceBeforeLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "replacement");
    Intrinsics.checkParameterIsNotNull(paramString4, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString4;
    }
    return StringsKt.replaceRange((CharSequence)paramString1, 0, i, (CharSequence)paramString3).toString();
  }
  
  @InlineOnly
  private static final String replaceFirst(@NotNull CharSequence paramCharSequence, Regex paramRegex, String paramString)
  {
    return paramRegex.replaceFirst(paramCharSequence, paramString);
  }
  
  @NotNull
  public static final CharSequence replaceRange(@NotNull CharSequence paramCharSequence1, int paramInt1, int paramInt2, @NotNull CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$replaceRange");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "replacement");
    if (paramInt2 < paramInt1) {
      throw ((Throwable)new IndexOutOfBoundsException("End index (" + paramInt2 + ") is less than start index (" + paramInt1 + ")."));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Intrinsics.checkExpressionValueIsNotNull(localStringBuilder.append(paramCharSequence1, 0, paramInt1), "this.append(value, startIndex, endIndex)");
    localStringBuilder.append(paramCharSequence2);
    Intrinsics.checkExpressionValueIsNotNull(localStringBuilder.append(paramCharSequence1, paramInt2, paramCharSequence1.length()), "this.append(value, startIndex, endIndex)");
    return (CharSequence)localStringBuilder;
  }
  
  @NotNull
  public static final CharSequence replaceRange(@NotNull CharSequence paramCharSequence1, @NotNull IntRange paramIntRange, @NotNull CharSequence paramCharSequence2)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$replaceRange");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "replacement");
    return StringsKt.replaceRange(paramCharSequence1, paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1, paramCharSequence2);
  }
  
  @InlineOnly
  private static final String replaceRange(@NotNull String paramString, int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.replaceRange((CharSequence)paramString, paramInt1, paramInt2, paramCharSequence).toString();
  }
  
  @InlineOnly
  private static final String replaceRange(@NotNull String paramString, IntRange paramIntRange, CharSequence paramCharSequence)
  {
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.replaceRange((CharSequence)paramString, paramIntRange, paramCharSequence).toString();
  }
  
  @InlineOnly
  private static final List<String> split(@NotNull CharSequence paramCharSequence, Regex paramRegex, int paramInt)
  {
    return paramRegex.split(paramCharSequence, paramInt);
  }
  
  @NotNull
  public static final List<String> split(@NotNull CharSequence paramCharSequence, @NotNull char[] paramArrayOfChar, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$split");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "delimiters");
    if (paramArrayOfChar.length == 1) {
      return split$StringsKt__StringsKt(paramCharSequence, String.valueOf(paramArrayOfChar[0]), paramBoolean, paramInt);
    }
    Object localObject = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(paramCharSequence, paramArrayOfChar, 0, paramBoolean, paramInt, 2, null));
    paramArrayOfChar = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfChar.add(StringsKt.substring(paramCharSequence, (IntRange)((Iterator)localObject).next()));
    }
    return (List)paramArrayOfChar;
  }
  
  @NotNull
  public static final List<String> split(@NotNull CharSequence paramCharSequence, @NotNull String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$split");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "delimiters");
    if (paramArrayOfString.length == 1)
    {
      localObject = paramArrayOfString[0];
      if (((CharSequence)localObject).length() == 0) {}
      for (int i = 1; i == 0; i = 0) {
        return split$StringsKt__StringsKt(paramCharSequence, (String)localObject, paramBoolean, paramInt);
      }
    }
    Object localObject = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(paramCharSequence, paramArrayOfString, 0, paramBoolean, paramInt, 2, null));
    paramArrayOfString = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfString.add(StringsKt.substring(paramCharSequence, (IntRange)((Iterator)localObject).next()));
    }
    return (List)paramArrayOfString;
  }
  
  private static final List<String> split$StringsKt__StringsKt(@NotNull CharSequence paramCharSequence, String paramString, boolean paramBoolean, int paramInt)
  {
    int j = 10;
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Limit must be non-negative, but was " + paramInt + '.').toString()));
    }
    int k = StringsKt.indexOf(paramCharSequence, paramString, 0, paramBoolean);
    if ((k == -1) || (paramInt == 1)) {
      return CollectionsKt.listOf(paramCharSequence.toString());
    }
    ArrayList localArrayList;
    label123:
    int m;
    if (paramInt > 0)
    {
      i = 1;
      if (i != 0) {
        j = RangesKt.coerceAtMost(paramInt, 10);
      }
      localArrayList = new ArrayList(j);
      j = 0;
      localArrayList.add(paramCharSequence.subSequence(j, k).toString());
      m = paramString.length() + k;
      if ((i == 0) || (localArrayList.size() != paramInt - 1)) {
        break label202;
      }
    }
    for (;;)
    {
      localArrayList.add(paramCharSequence.subSequence(m, paramCharSequence.length()).toString());
      return (List)localArrayList;
      i = 0;
      break;
      label202:
      int n = StringsKt.indexOf(paramCharSequence, paramString, m, paramBoolean);
      k = n;
      j = m;
      if (n != -1) {
        break label123;
      }
    }
  }
  
  @NotNull
  public static final Sequence<String> splitToSequence(@NotNull CharSequence paramCharSequence, @NotNull char[] paramArrayOfChar, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$splitToSequence");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "delimiters");
    return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(paramCharSequence, paramArrayOfChar, 0, paramBoolean, paramInt, 2, null), (Function1)new StringsKt__StringsKt.splitToSequence.2(paramCharSequence));
  }
  
  @NotNull
  public static final Sequence<String> splitToSequence(@NotNull CharSequence paramCharSequence, @NotNull String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$splitToSequence");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "delimiters");
    return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(paramCharSequence, paramArrayOfString, 0, paramBoolean, paramInt, 2, null), (Function1)new StringsKt__StringsKt.splitToSequence.1(paramCharSequence));
  }
  
  public static final boolean startsWith(@NotNull CharSequence paramCharSequence, char paramChar, boolean paramBoolean)
  {
    boolean bool2 = false;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$startsWith");
    boolean bool1 = bool2;
    if (paramCharSequence.length() > 0)
    {
      bool1 = bool2;
      if (CharsKt.equals(paramCharSequence.charAt(0), paramChar, paramBoolean)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final boolean startsWith(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    if ((!paramBoolean) && ((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return StringsKt.startsWith$default((String)paramCharSequence1, (String)paramCharSequence2, paramInt, false, 4, null);
    }
    return StringsKt.regionMatchesImpl(paramCharSequence1, paramInt, paramCharSequence2, 0, paramCharSequence2.length(), paramBoolean);
  }
  
  public static final boolean startsWith(@NotNull CharSequence paramCharSequence1, @NotNull CharSequence paramCharSequence2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence1, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramCharSequence2, "prefix");
    if ((!paramBoolean) && ((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return StringsKt.startsWith$default((String)paramCharSequence1, (String)paramCharSequence2, false, 2, null);
    }
    return StringsKt.regionMatchesImpl(paramCharSequence1, 0, paramCharSequence2, 0, paramCharSequence2.length(), paramBoolean);
  }
  
  @NotNull
  public static final CharSequence subSequence(@NotNull CharSequence paramCharSequence, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$subSequence");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    return paramCharSequence.subSequence(paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
  }
  
  @Deprecated(message="Use parameters named startIndex and endIndex.", replaceWith=@ReplaceWith(expression="subSequence(startIndex = start, endIndex = end)", imports={}))
  @InlineOnly
  private static final CharSequence subSequence(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    return paramString.subSequence(paramInt1, paramInt2);
  }
  
  @InlineOnly
  private static final String substring(@NotNull CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return paramCharSequence.subSequence(paramInt1, paramInt2).toString();
  }
  
  @NotNull
  public static final String substring(@NotNull CharSequence paramCharSequence, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$substring");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    return paramCharSequence.subSequence(paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1).toString();
  }
  
  @NotNull
  public static final String substring(@NotNull String paramString, @NotNull IntRange paramIntRange)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$substring");
    Intrinsics.checkParameterIsNotNull(paramIntRange, "range");
    paramString = paramString.substring(paramIntRange.getStart().intValue(), paramIntRange.getEndInclusive().intValue() + 1);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString;
  }
  
  @NotNull
  public static final String substringAfter(@NotNull String paramString1, char paramChar, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringAfter");
    Intrinsics.checkParameterIsNotNull(paramString2, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString2;
    }
    paramString1 = paramString1.substring(i + 1, paramString1.length());
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  @NotNull
  public static final String substringAfter(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringAfter");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    paramString1 = paramString1.substring(i + paramString2.length(), paramString1.length());
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  @NotNull
  public static final String substringAfterLast(@NotNull String paramString1, char paramChar, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringAfterLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString2;
    }
    paramString1 = paramString1.substring(i + 1, paramString1.length());
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  @NotNull
  public static final String substringAfterLast(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringAfterLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    paramString1 = paramString1.substring(i + paramString2.length(), paramString1.length());
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  @NotNull
  public static final String substringBefore(@NotNull String paramString1, char paramChar, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringBefore");
    Intrinsics.checkParameterIsNotNull(paramString2, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString2;
    }
    paramString1 = paramString1.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  @NotNull
  public static final String substringBefore(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringBefore");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.indexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    paramString1 = paramString1.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  @NotNull
  public static final String substringBeforeLast(@NotNull String paramString1, char paramChar, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringBeforeLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramChar, 0, false, 6, null);
    if (i == -1) {
      return paramString2;
    }
    paramString1 = paramString1.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  @NotNull
  public static final String substringBeforeLast(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$substringBeforeLast");
    Intrinsics.checkParameterIsNotNull(paramString2, "delimiter");
    Intrinsics.checkParameterIsNotNull(paramString3, "missingDelimiterValue");
    int i = StringsKt.lastIndexOf$default((CharSequence)paramString1, paramString2, 0, false, 6, null);
    if (i == -1) {
      return paramString3;
    }
    paramString1 = paramString1.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return paramString1;
  }
  
  @NotNull
  public static final CharSequence trim(@NotNull CharSequence paramCharSequence)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trim");
    int j = paramCharSequence.length() - 1;
    int k = 0;
    int m;
    label32:
    boolean bool;
    if (k <= j) {
      if (i == 0)
      {
        m = k;
        bool = CharsKt.isWhitespace(paramCharSequence.charAt(m));
        if (i != 0) {
          break label72;
        }
        if (bool) {
          break label65;
        }
        i = 1;
      }
    }
    for (;;)
    {
      break;
      m = j;
      break label32;
      label65:
      k += 1;
      continue;
      label72:
      if (!bool) {
        return paramCharSequence.subSequence(k, j + 1);
      }
      j -= 1;
    }
  }
  
  @NotNull
  public static final CharSequence trim(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trim");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int j = paramCharSequence.length() - 1;
    int k = 0;
    int m;
    label42:
    boolean bool;
    if (k <= j) {
      if (i == 0)
      {
        m = k;
        bool = ((Boolean)paramFunction1.invoke(Character.valueOf(paramCharSequence.charAt(m)))).booleanValue();
        if (i != 0) {
          break label96;
        }
        if (bool) {
          break label87;
        }
        i = 1;
      }
    }
    for (;;)
    {
      break;
      m = j;
      break label42;
      label87:
      k += 1;
      continue;
      label96:
      if (!bool) {
        return paramCharSequence.subSequence(k, j + 1);
      }
      j -= 1;
    }
  }
  
  @NotNull
  public static final CharSequence trim(@NotNull CharSequence paramCharSequence, @NotNull char... paramVarArgs)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trim");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    int j = paramCharSequence.length() - 1;
    int k = 0;
    int m;
    label42:
    boolean bool;
    if (k <= j) {
      if (i == 0)
      {
        m = k;
        bool = ArraysKt.contains(paramVarArgs, paramCharSequence.charAt(m));
        if (i != 0) {
          break label85;
        }
        if (bool) {
          break label76;
        }
        i = 1;
      }
    }
    for (;;)
    {
      break;
      m = j;
      break label42;
      label76:
      k += 1;
      continue;
      label85:
      if (!bool) {
        return paramCharSequence.subSequence(k, j + 1);
      }
      j -= 1;
    }
  }
  
  @InlineOnly
  private static final String trim(@NotNull String paramString)
  {
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.trim((CharSequence)paramString).toString();
  }
  
  @NotNull
  public static final String trim(@NotNull String paramString, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trim");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramString = (CharSequence)paramString;
    int j = paramString.length() - 1;
    int k = 0;
    int m;
    label47:
    boolean bool;
    if (k <= j) {
      if (i == 0)
      {
        m = k;
        bool = ((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(m)))).booleanValue();
        if (i != 0) {
          break label101;
        }
        if (bool) {
          break label92;
        }
        i = 1;
      }
    }
    for (;;)
    {
      break;
      m = j;
      break label47;
      label92:
      k += 1;
      continue;
      label101:
      if (!bool) {
        return paramString.subSequence(k, j + 1).toString();
      }
      j -= 1;
    }
  }
  
  @NotNull
  public static final String trim(@NotNull String paramString, @NotNull char... paramVarArgs)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trim");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    paramString = (CharSequence)paramString;
    int j = paramString.length() - 1;
    int k = 0;
    int m;
    label47:
    boolean bool;
    if (k <= j) {
      if (i == 0)
      {
        m = k;
        bool = ArraysKt.contains(paramVarArgs, paramString.charAt(m));
        if (i != 0) {
          break label90;
        }
        if (bool) {
          break label81;
        }
        i = 1;
      }
    }
    for (;;)
    {
      break;
      m = j;
      break label47;
      label81:
      k += 1;
      continue;
      label90:
      if (!bool) {
        return paramString.subSequence(k, j + 1).toString();
      }
      j -= 1;
    }
  }
  
  @NotNull
  public static final CharSequence trimEnd(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimEnd");
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (!CharsKt.isWhitespace(paramCharSequence.charAt(i))) {
        return paramCharSequence.subSequence(0, i + 1);
      }
      i -= 1;
    }
    return (CharSequence)"";
  }
  
  @NotNull
  public static final CharSequence trimEnd(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimEnd");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    int i = paramCharSequence.length() - 1;
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
  public static final CharSequence trimEnd(@NotNull CharSequence paramCharSequence, @NotNull char... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimEnd");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    int i = paramCharSequence.length() - 1;
    while (i >= 0)
    {
      if (!ArraysKt.contains(paramVarArgs, paramCharSequence.charAt(i))) {
        return paramCharSequence.subSequence(0, i + 1);
      }
      i -= 1;
    }
    return (CharSequence)"";
  }
  
  @InlineOnly
  private static final String trimEnd(@NotNull String paramString)
  {
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.trimEnd((CharSequence)paramString).toString();
  }
  
  @NotNull
  public static final String trimEnd(@NotNull String paramString, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trimEnd");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramString = (CharSequence)paramString;
    int i = paramString.length() - 1;
    if (i >= 0) {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue()) {}
    }
    for (paramString = paramString.subSequence(0, i + 1);; paramString = (CharSequence)"")
    {
      return paramString.toString();
      i -= 1;
      break;
    }
  }
  
  @NotNull
  public static final String trimEnd(@NotNull String paramString, @NotNull char... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trimEnd");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    paramString = (CharSequence)paramString;
    int i = paramString.length() - 1;
    if (i >= 0) {
      if (ArraysKt.contains(paramVarArgs, paramString.charAt(i))) {}
    }
    for (paramString = paramString.subSequence(0, i + 1);; paramString = (CharSequence)"")
    {
      return paramString.toString();
      i -= 1;
      break;
    }
  }
  
  @NotNull
  public static final CharSequence trimStart(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimStart");
    int i = 0;
    int j = paramCharSequence.length();
    while (i < j)
    {
      if (!CharsKt.isWhitespace(paramCharSequence.charAt(i))) {
        return paramCharSequence.subSequence(i, paramCharSequence.length());
      }
      i += 1;
    }
    return (CharSequence)"";
  }
  
  @NotNull
  public static final CharSequence trimStart(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimStart");
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
  public static final CharSequence trimStart(@NotNull CharSequence paramCharSequence, @NotNull char... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "$this$trimStart");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    int i = 0;
    int j = paramCharSequence.length();
    while (i < j)
    {
      if (!ArraysKt.contains(paramVarArgs, paramCharSequence.charAt(i))) {
        return paramCharSequence.subSequence(i, paramCharSequence.length());
      }
      i += 1;
    }
    return (CharSequence)"";
  }
  
  @InlineOnly
  private static final String trimStart(@NotNull String paramString)
  {
    if (paramString == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return StringsKt.trimStart((CharSequence)paramString).toString();
  }
  
  @NotNull
  public static final String trimStart(@NotNull String paramString, @NotNull Function1<? super Character, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trimStart");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    paramString = (CharSequence)paramString;
    int j = paramString.length();
    int i = 0;
    if (i < j) {
      if (((Boolean)paramFunction1.invoke(Character.valueOf(paramString.charAt(i)))).booleanValue()) {}
    }
    for (paramString = paramString.subSequence(i, paramString.length());; paramString = (CharSequence)"")
    {
      return paramString.toString();
      i += 1;
      break;
    }
  }
  
  @NotNull
  public static final String trimStart(@NotNull String paramString, @NotNull char... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trimStart");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "chars");
    paramString = (CharSequence)paramString;
    int i = 0;
    int j = paramString.length();
    if (i < j) {
      if (ArraysKt.contains(paramVarArgs, paramString.charAt(i))) {}
    }
    for (paramString = paramString.subSequence(i, paramString.length());; paramString = (CharSequence)"")
    {
      return paramString.toString();
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.StringsKt__StringsKt
 * JD-Core Version:    0.7.0.1
 */