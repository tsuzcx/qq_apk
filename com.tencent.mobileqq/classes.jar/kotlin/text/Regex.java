package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matches", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Regex
  implements Serializable
{
  public static final Regex.Companion Companion = new Regex.Companion(null);
  private Set<? extends RegexOption> _options;
  private final Pattern nativePattern;
  
  public Regex(@NotNull String paramString)
  {
    this(paramString);
  }
  
  public Regex(@NotNull String paramString, @NotNull Set<? extends RegexOption> paramSet)
  {
    this(paramString);
  }
  
  public Regex(@NotNull String paramString, @NotNull RegexOption paramRegexOption)
  {
    this(paramString);
  }
  
  @PublishedApi
  public Regex(@NotNull Pattern paramPattern)
  {
    this.nativePattern = paramPattern;
  }
  
  private final Object writeReplace()
  {
    String str = this.nativePattern.pattern();
    Intrinsics.checkExpressionValueIsNotNull(str, "nativePattern.pattern()");
    return new Regex.Serialized(str, this.nativePattern.flags());
  }
  
  public final boolean containsMatchIn(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "input");
    return this.nativePattern.matcher(paramCharSequence).find();
  }
  
  @Nullable
  public final MatchResult find(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "input");
    Matcher localMatcher = this.nativePattern.matcher(paramCharSequence);
    Intrinsics.checkExpressionValueIsNotNull(localMatcher, "nativePattern.matcher(input)");
    return RegexKt.access$findNext(localMatcher, paramInt, paramCharSequence);
  }
  
  @NotNull
  public final Sequence<MatchResult> findAll(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "input");
    return SequencesKt.generateSequence((Function0)new Regex.findAll.1(this, paramCharSequence, paramInt), (Function1)Regex.findAll.2.INSTANCE);
  }
  
  @NotNull
  public final Set<RegexOption> getOptions()
  {
    Object localObject = this._options;
    if (localObject != null) {
      return localObject;
    }
    int i = this.nativePattern.flags();
    localObject = EnumSet.allOf(RegexOption.class);
    CollectionsKt.retainAll((Iterable)localObject, (Function1)new Regex.fromInt..inlined.apply.lambda.1(i));
    localObject = Collections.unmodifiableSet((Set)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Collections.unmodifiable…mask == it.value }\n    })");
    this._options = ((Set)localObject);
    return localObject;
  }
  
  @NotNull
  public final String getPattern()
  {
    String str = this.nativePattern.pattern();
    Intrinsics.checkExpressionValueIsNotNull(str, "nativePattern.pattern()");
    return str;
  }
  
  @Nullable
  public final MatchResult matchEntire(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "input");
    Matcher localMatcher = this.nativePattern.matcher(paramCharSequence);
    Intrinsics.checkExpressionValueIsNotNull(localMatcher, "nativePattern.matcher(input)");
    return RegexKt.access$matchEntire(localMatcher, paramCharSequence);
  }
  
  public final boolean matches(@NotNull CharSequence paramCharSequence)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "input");
    return this.nativePattern.matcher(paramCharSequence).matches();
  }
  
  @NotNull
  public final String replace(@NotNull CharSequence paramCharSequence, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "input");
    Intrinsics.checkParameterIsNotNull(paramString, "replacement");
    paramCharSequence = this.nativePattern.matcher(paramCharSequence).replaceAll(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "nativePattern.matcher(in…).replaceAll(replacement)");
    return paramCharSequence;
  }
  
  @NotNull
  public final String replace(@NotNull CharSequence paramCharSequence, @NotNull Function1<? super MatchResult, ? extends CharSequence> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "input");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "transform");
    Object localObject = find$default(this, paramCharSequence, 0, 2, null);
    if (localObject != null)
    {
      int k = paramCharSequence.length();
      StringBuilder localStringBuilder = new StringBuilder(k);
      int j;
      MatchResult localMatchResult;
      do
      {
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localStringBuilder.append(paramCharSequence, i, ((MatchResult)localObject).getRange().getStart().intValue());
        localStringBuilder.append((CharSequence)paramFunction1.invoke(localObject));
        j = ((MatchResult)localObject).getRange().getEndInclusive().intValue() + 1;
        localMatchResult = ((MatchResult)localObject).next();
        if (j >= k) {
          break;
        }
        i = j;
        localObject = localMatchResult;
      } while (localMatchResult != null);
      if (j < k) {
        localStringBuilder.append(paramCharSequence, j, k);
      }
      paramCharSequence = localStringBuilder.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "sb.toString()");
      return paramCharSequence;
    }
    return paramCharSequence.toString();
  }
  
  @NotNull
  public final String replaceFirst(@NotNull CharSequence paramCharSequence, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "input");
    Intrinsics.checkParameterIsNotNull(paramString, "replacement");
    paramCharSequence = this.nativePattern.matcher(paramCharSequence).replaceFirst(paramString);
    Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "nativePattern.matcher(in…replaceFirst(replacement)");
    return paramCharSequence;
  }
  
  @NotNull
  public final List<String> split(@NotNull CharSequence paramCharSequence, int paramInt)
  {
    int j = 10;
    Intrinsics.checkParameterIsNotNull(paramCharSequence, "input");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("Limit must be non-negative, but was " + paramInt + '.').toString()));
    }
    Matcher localMatcher = this.nativePattern.matcher(paramCharSequence);
    if ((!localMatcher.find()) || (paramInt == 1)) {
      return CollectionsKt.listOf(paramCharSequence.toString());
    }
    i = j;
    if (paramInt > 0) {
      i = RangesKt.coerceAtMost(paramInt, 10);
    }
    ArrayList localArrayList = new ArrayList(i);
    j = paramInt - 1;
    paramInt = 0;
    localArrayList.add(paramCharSequence.subSequence(paramInt, localMatcher.start()).toString());
    i = localMatcher.end();
    if ((j >= 0) && (localArrayList.size() == j)) {}
    for (;;)
    {
      localArrayList.add(paramCharSequence.subSequence(i, paramCharSequence.length()).toString());
      return (List)localArrayList;
      paramInt = i;
      if (localMatcher.find()) {
        break;
      }
    }
  }
  
  @NotNull
  public final Pattern toPattern()
  {
    return this.nativePattern;
  }
  
  @NotNull
  public String toString()
  {
    String str = this.nativePattern.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "nativePattern.toString()");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.text.Regex
 * JD-Core Version:    0.7.0.1
 */