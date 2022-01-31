package rx.internal.operators;

abstract interface OperatorReplay$ReplayBuffer<T>
{
  public abstract void complete();
  
  public abstract void error(Throwable paramThrowable);
  
  public abstract void next(T paramT);
  
  public abstract void replay(OperatorReplay.InnerProducer<T> paramInnerProducer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.ReplayBuffer
 * JD-Core Version:    0.7.0.1
 */