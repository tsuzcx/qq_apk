package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ConcurrentModificationException;

class SmartList$SingletonIterator
  extends SmartList.SingletonIteratorBase<E>
{
  private final int myInitialModCount;
  
  public SmartList$SingletonIterator(SmartList paramSmartList)
  {
    super(null);
    this.myInitialModCount = SmartList.access$100(paramSmartList);
  }
  
  protected void checkCoModification()
  {
    if (SmartList.access$300(this.this$0) == this.myInitialModCount) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ModCount: ");
    localStringBuilder.append(SmartList.access$400(this.this$0));
    localStringBuilder.append("; expected: ");
    localStringBuilder.append(this.myInitialModCount);
    throw new ConcurrentModificationException(localStringBuilder.toString());
  }
  
  protected E getElement()
  {
    return SmartList.access$200(this.this$0);
  }
  
  public void remove()
  {
    checkCoModification();
    this.this$0.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIterator
 * JD-Core Version:    0.7.0.1
 */