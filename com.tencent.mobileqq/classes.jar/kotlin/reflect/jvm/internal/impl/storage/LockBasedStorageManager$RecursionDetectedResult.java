package kotlin.reflect.jvm.internal.impl.storage;

import org.jetbrains.annotations.NotNull;

class LockBasedStorageManager$RecursionDetectedResult<T>
{
  private final boolean fallThrough;
  private final T value;
  
  private LockBasedStorageManager$RecursionDetectedResult(T paramT, boolean paramBoolean)
  {
    this.value = paramT;
    this.fallThrough = paramBoolean;
  }
  
  @NotNull
  public static <T> RecursionDetectedResult<T> fallThrough()
  {
    return new RecursionDetectedResult(null, true);
  }
  
  @NotNull
  public static <T> RecursionDetectedResult<T> value(T paramT)
  {
    return new RecursionDetectedResult(paramT, false);
  }
  
  public T getValue()
  {
    return this.value;
  }
  
  public boolean isFallThrough()
  {
    return this.fallThrough;
  }
  
  public String toString()
  {
    if (isFallThrough()) {
      return "FALL_THROUGH";
    }
    return String.valueOf(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.RecursionDetectedResult
 * JD-Core Version:    0.7.0.1
 */