package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "Lkotlin/text/CharCategory;", "invoke"}, k=3, mv={1, 1, 16})
final class CharCategory$Companion$categoryMap$2
  extends Lambda
  implements Function0<Map<Integer, ? extends CharCategory>>
{
  public static final 2 INSTANCE = new 2();
  
  CharCategory$Companion$categoryMap$2()
  {
    super(0);
  }
  
  @NotNull
  public final Map<Integer, CharCategory> invoke()
  {
    CharCategory[] arrayOfCharCategory = CharCategory.values();
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(arrayOfCharCategory.length), 16));
    int j = arrayOfCharCategory.length;
    int i = 0;
    while (i < j)
    {
      CharCategory localCharCategory = arrayOfCharCategory[i];
      localMap.put(Integer.valueOf(localCharCategory.getValue()), localCharCategory);
      i += 1;
    }
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.CharCategory.Companion.categoryMap.2
 * JD-Core Version:    0.7.0.1
 */