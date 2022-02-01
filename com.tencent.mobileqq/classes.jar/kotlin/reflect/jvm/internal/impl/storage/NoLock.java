package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.jetbrains.annotations.NotNull;

class NoLock
  implements Lock
{
  public static final Lock INSTANCE = new NoLock();
  
  public void lock() {}
  
  public void lockInterruptibly()
  {
    throw new UnsupportedOperationException("Should not be called");
  }
  
  @NotNull
  public Condition newCondition()
  {
    throw new UnsupportedOperationException("Should not be called");
  }
  
  public boolean tryLock()
  {
    throw new UnsupportedOperationException("Should not be called");
  }
  
  public boolean tryLock(long paramLong, @NotNull TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit == null) {
      $$$reportNull$$$0(0);
    }
    throw new UnsupportedOperationException("Should not be called");
  }
  
  public void unlock() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.NoLock
 * JD-Core Version:    0.7.0.1
 */