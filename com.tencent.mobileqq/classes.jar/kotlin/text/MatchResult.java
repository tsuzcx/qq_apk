package kotlin.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/MatchResult;", "", "destructured", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "Destructured", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface MatchResult
{
  @NotNull
  public abstract MatchResult.Destructured getDestructured();
  
  @NotNull
  public abstract List<String> getGroupValues();
  
  @NotNull
  public abstract MatchGroupCollection getGroups();
  
  @NotNull
  public abstract IntRange getRange();
  
  @NotNull
  public abstract String getValue();
  
  @Nullable
  public abstract MatchResult next();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.MatchResult
 * JD-Core Version:    0.7.0.1
 */