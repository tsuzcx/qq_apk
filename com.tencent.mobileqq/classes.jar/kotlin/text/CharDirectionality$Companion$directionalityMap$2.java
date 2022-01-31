package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "Lkotlin/text/CharDirectionality;", "invoke"}, k=3, mv={1, 1, 16})
final class CharDirectionality$Companion$directionalityMap$2
  extends Lambda
  implements Function0<Map<Integer, ? extends CharDirectionality>>
{
  public static final 2 INSTANCE = new 2();
  
  CharDirectionality$Companion$directionalityMap$2()
  {
    super(0);
  }
  
  @NotNull
  public final Map<Integer, CharDirectionality> invoke()
  {
    CharDirectionality[] arrayOfCharDirectionality = CharDirectionality.values();
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(arrayOfCharDirectionality.length), 16));
    int j = arrayOfCharDirectionality.length;
    int i = 0;
    while (i < j)
    {
      CharDirectionality localCharDirectionality = arrayOfCharDirectionality[i];
      localMap.put(Integer.valueOf(localCharDirectionality.getValue()), localCharDirectionality);
      i += 1;
    }
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.CharDirectionality.Companion.directionalityMap.2
 * JD-Core Version:    0.7.0.1
 */