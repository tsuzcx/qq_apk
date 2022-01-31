package rx.internal.operators;

import java.util.Comparator;
import rx.functions.Func2;

class OperatorToObservableSortedList$1
  implements Comparator<T>
{
  OperatorToObservableSortedList$1(OperatorToObservableSortedList paramOperatorToObservableSortedList, Func2 paramFunc2) {}
  
  public int compare(T paramT1, T paramT2)
  {
    return ((Integer)this.val$sortFunction.call(paramT1, paramT2)).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorToObservableSortedList.1
 * JD-Core Version:    0.7.0.1
 */