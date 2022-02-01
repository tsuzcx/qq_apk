package kotlin.reflect.jvm.internal.impl.storage;

import org.jetbrains.annotations.NotNull;

public abstract interface LockBasedStorageManager$ExceptionHandlingStrategy
{
  public static final ExceptionHandlingStrategy THROW = new LockBasedStorageManager.ExceptionHandlingStrategy.1();
  
  @NotNull
  public abstract RuntimeException handleException(@NotNull Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy
 * JD-Core Version:    0.7.0.1
 */