package kotlin.reflect.jvm.internal.impl.types;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

public final class IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    return ComparisonsKt.compareValues((Comparable)((KotlinType)paramT1).toString(), (Comparable)((KotlinType)paramT2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.makeDebugNameForIntersectionType..inlined.sortedBy.1
 * JD-Core Version:    0.7.0.1
 */