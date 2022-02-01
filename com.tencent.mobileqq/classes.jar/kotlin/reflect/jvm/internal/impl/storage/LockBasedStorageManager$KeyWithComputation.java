package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;

class LockBasedStorageManager$KeyWithComputation<K, V>
{
  private final Function0<? extends V> computation;
  private final K key;
  
  public LockBasedStorageManager$KeyWithComputation(K paramK, Function0<? extends V> paramFunction0)
  {
    this.key = paramK;
    this.computation = paramFunction0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (KeyWithComputation)paramObject;
      return this.key.equals(paramObject.key);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.key.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.KeyWithComputation
 * JD-Core Version:    0.7.0.1
 */