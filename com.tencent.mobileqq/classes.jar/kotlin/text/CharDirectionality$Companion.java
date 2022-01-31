package kotlin.text;

import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/CharDirectionality$Companion;", "", "()V", "directionalityMap", "", "", "Lkotlin/text/CharDirectionality;", "getDirectionalityMap", "()Ljava/util/Map;", "directionalityMap$delegate", "Lkotlin/Lazy;", "valueOf", "directionality", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class CharDirectionality$Companion
{
  private final Map<Integer, CharDirectionality> getDirectionalityMap()
  {
    Lazy localLazy = CharDirectionality.access$getDirectionalityMap$cp();
    Companion localCompanion = CharDirectionality.Companion;
    return (Map)localLazy.getValue();
  }
  
  @NotNull
  public final CharDirectionality valueOf(int paramInt)
  {
    CharDirectionality localCharDirectionality = (CharDirectionality)((Companion)this).getDirectionalityMap().get(Integer.valueOf(paramInt));
    if (localCharDirectionality != null) {
      return localCharDirectionality;
    }
    throw ((Throwable)new IllegalArgumentException("Directionality #" + paramInt + " is not defined."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.CharDirectionality.Companion
 * JD-Core Version:    0.7.0.1
 */