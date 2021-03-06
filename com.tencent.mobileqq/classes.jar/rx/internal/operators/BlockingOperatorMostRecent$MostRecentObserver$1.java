package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.exceptions.Exceptions;

class BlockingOperatorMostRecent$MostRecentObserver$1
  implements Iterator<T>
{
  private Object buf = null;
  
  BlockingOperatorMostRecent$MostRecentObserver$1(BlockingOperatorMostRecent.MostRecentObserver paramMostRecentObserver) {}
  
  public boolean hasNext()
  {
    this.buf = this.this$0.value;
    return this.this$0.nl.isCompleted(this.buf) ^ true;
  }
  
  public T next()
  {
    try
    {
      if (this.buf == null) {
        this.buf = this.this$0.value;
      }
      if (!this.this$0.nl.isCompleted(this.buf))
      {
        if (!this.this$0.nl.isError(this.buf))
        {
          Object localObject1 = this.this$0.nl.getValue(this.buf);
          return localObject1;
        }
        throw Exceptions.propagate(this.this$0.nl.getError(this.buf));
      }
      throw new NoSuchElementException();
    }
    finally
    {
      this.buf = null;
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Read only iterator");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.BlockingOperatorMostRecent.MostRecentObserver.1
 * JD-Core Version:    0.7.0.1
 */