package rx.internal.operators;

import rx.functions.Func2;

final class OperatorSequenceEqual$2
  implements Func2<Object, Object, Boolean>
{
  OperatorSequenceEqual$2(Func2 paramFunc2) {}
  
  public Boolean call(Object paramObject1, Object paramObject2)
  {
    int i;
    if (paramObject1 == OperatorSequenceEqual.LOCAL_ONCOMPLETED) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramObject2 == OperatorSequenceEqual.LOCAL_ONCOMPLETED) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i != 0) && (j != 0)) {
      return Boolean.valueOf(true);
    }
    if ((i == 0) && (j == 0)) {
      return (Boolean)this.val$equality.call(paramObject1, paramObject2);
    }
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorSequenceEqual.2
 * JD-Core Version:    0.7.0.1
 */