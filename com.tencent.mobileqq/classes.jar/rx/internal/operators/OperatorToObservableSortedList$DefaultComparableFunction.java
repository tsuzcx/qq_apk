package rx.internal.operators;

import java.util.Comparator;

class OperatorToObservableSortedList$DefaultComparableFunction
  implements Comparator<Object>
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    return ((Comparable)paramObject1).compareTo((Comparable)paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorToObservableSortedList.DefaultComparableFunction
 * JD-Core Version:    0.7.0.1
 */