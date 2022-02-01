package kotlin.text;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/MatchGroupCollection;", "", "Lkotlin/text/MatchGroup;", "get", "index", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface MatchGroupCollection
  extends Collection<MatchGroup>, KMappedMarker
{
  @Nullable
  public abstract MatchGroup get(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.MatchGroupCollection
 * JD-Core Version:    0.7.0.1
 */