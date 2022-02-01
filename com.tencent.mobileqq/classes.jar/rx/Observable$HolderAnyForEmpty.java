package rx;

import rx.internal.operators.OperatorAny;
import rx.internal.util.UtilityFunctions;

class Observable$HolderAnyForEmpty
{
  static final OperatorAny<?> INSTANCE = new OperatorAny(UtilityFunctions.alwaysTrue(), true);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Observable.HolderAnyForEmpty
 * JD-Core Version:    0.7.0.1
 */