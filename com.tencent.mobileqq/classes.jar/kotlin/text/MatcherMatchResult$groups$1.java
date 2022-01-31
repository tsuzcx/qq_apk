package kotlin.text;

import java.util.Iterator;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementations;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class MatcherMatchResult$groups$1
  extends AbstractCollection<MatchGroup>
  implements MatchNamedGroupCollection
{
  @Nullable
  public MatchGroup get(int paramInt)
  {
    IntRange localIntRange = RegexKt.access$range(MatcherMatchResult.access$getMatchResult$p(this.this$0), paramInt);
    if (localIntRange.getStart().intValue() >= 0)
    {
      String str = MatcherMatchResult.access$getMatchResult$p(this.this$0).group(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(str, "matchResult.group(index)");
      return new MatchGroup(str, localIntRange);
    }
    return null;
  }
  
  @Nullable
  public MatchGroup get(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(MatcherMatchResult.access$getMatchResult$p(this.this$0), paramString);
  }
  
  public int getSize()
  {
    return MatcherMatchResult.access$getMatchResult$p(this.this$0).groupCount() + 1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  @NotNull
  public Iterator<MatchGroup> iterator()
  {
    return SequencesKt.map(CollectionsKt.asSequence((Iterable)CollectionsKt.getIndices(this)), (Function1)new MatcherMatchResult.groups.1.iterator.1(this)).iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.MatcherMatchResult.groups.1
 * JD-Core Version:    0.7.0.1
 */