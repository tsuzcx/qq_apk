package kotlin.internal.jdk8;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "()V", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "kotlin-stdlib-jdk8"}, k=1, mv={1, 1, 16})
public class JDK8PlatformImplementations
  extends JDK7PlatformImplementations
{
  @NotNull
  public Random defaultPlatformRandom()
  {
    return (Random)new PlatformThreadLocalRandom();
  }
  
  @Nullable
  public MatchGroup getMatchResultNamedGroup(@NotNull MatchResult paramMatchResult, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMatchResult, "matchResult");
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    boolean bool = paramMatchResult instanceof Matcher;
    Object localObject = null;
    if (!bool) {
      paramMatchResult = null;
    }
    Matcher localMatcher = (Matcher)paramMatchResult;
    if (localMatcher != null)
    {
      IntRange localIntRange = new IntRange(localMatcher.start(paramString), localMatcher.end(paramString) - 1);
      paramMatchResult = localObject;
      if (localIntRange.getStart().intValue() >= 0)
      {
        paramMatchResult = localMatcher.group(paramString);
        Intrinsics.checkExpressionValueIsNotNull(paramMatchResult, "matcher.group(name)");
        paramMatchResult = new MatchGroup(paramMatchResult, localIntRange);
      }
      return paramMatchResult;
    }
    throw ((Throwable)new UnsupportedOperationException("Retrieving groups by name is not supported on this platform."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     kotlin.internal.jdk8.JDK8PlatformImplementations
 * JD-Core Version:    0.7.0.1
 */