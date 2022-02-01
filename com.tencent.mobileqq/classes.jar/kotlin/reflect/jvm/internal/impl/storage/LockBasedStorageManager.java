package kotlin.reflect.jvm.internal.impl.storage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public class LockBasedStorageManager
  implements StorageManager
{
  public static final StorageManager NO_LOCKS = new LockBasedStorageManager.1("NO_LOCKS", LockBasedStorageManager.ExceptionHandlingStrategy.THROW, NoLock.INSTANCE);
  private static final String PACKAGE_NAME = StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
  private final String debugText;
  private final LockBasedStorageManager.ExceptionHandlingStrategy exceptionHandlingStrategy;
  protected final Lock lock;
  
  public LockBasedStorageManager(String paramString)
  {
    this(paramString, LockBasedStorageManager.ExceptionHandlingStrategy.THROW, new ReentrantLock());
  }
  
  private LockBasedStorageManager(@NotNull String paramString, @NotNull LockBasedStorageManager.ExceptionHandlingStrategy paramExceptionHandlingStrategy, @NotNull Lock paramLock)
  {
    this.lock = paramLock;
    this.exceptionHandlingStrategy = paramExceptionHandlingStrategy;
    this.debugText = paramString;
  }
  
  @NotNull
  private static <K> ConcurrentMap<K, Object> createConcurrentHashMap()
  {
    return new ConcurrentHashMap(3, 1.0F, 2);
  }
  
  @NotNull
  private static <T extends Throwable> T sanitizeStackTrace(@NotNull T paramT)
  {
    if (paramT == null) {
      $$$reportNull$$$0(27);
    }
    Object localObject = paramT.getStackTrace();
    int m = localObject.length;
    int k = -1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      if (!localObject[i].getClassName().startsWith(PACKAGE_NAME))
      {
        j = i;
        break;
      }
      i += 1;
    }
    localObject = Arrays.asList((Object[])localObject).subList(j, m);
    paramT.setStackTrace((StackTraceElement[])((List)localObject).toArray(new StackTraceElement[((List)localObject).size()]));
    if (paramT == null) {
      $$$reportNull$$$0(28);
    }
    return paramT;
  }
  
  /* Error */
  public <T> T compute(@NotNull Function0<? extends T> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: bipush 26
    //   6: invokestatic 125	kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager:$$$reportNull$$$0	(I)V
    //   9: aload_0
    //   10: getfield 128	kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager:lock	Ljava/util/concurrent/locks/Lock;
    //   13: invokeinterface 197 1 0
    //   18: aload_1
    //   19: invokeinterface 203 1 0
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 128	kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager:lock	Ljava/util/concurrent/locks/Lock;
    //   29: invokeinterface 206 1 0
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: goto +15 -> 52
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 130	kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager:exceptionHandlingStrategy	Lkotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy;
    //   45: aload_1
    //   46: invokeinterface 210 2 0
    //   51: athrow
    //   52: aload_0
    //   53: getfield 128	kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager:lock	Ljava/util/concurrent/locks/Lock;
    //   56: invokeinterface 206 1 0
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	LockBasedStorageManager
    //   0	63	1	paramFunction0	Function0<? extends T>
    // Exception table:
    //   from	to	target	type
    //   18	25	36	finally
    //   41	52	36	finally
    //   18	25	40	java/lang/Throwable
  }
  
  @NotNull
  public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues()
  {
    return new LockBasedStorageManager.CacheWithNotNullValuesBasedOnMemoizedFunction(this, createConcurrentHashMap(), null);
  }
  
  @NotNull
  public <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> paramFunction0)
  {
    if (paramFunction0 == null) {
      $$$reportNull$$$0(15);
    }
    return new LockBasedStorageManager.LockBasedNotNullLazyValue(this, paramFunction0);
  }
  
  @NotNull
  public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> paramFunction0, Function1<? super Boolean, ? extends T> paramFunction1, @NotNull Function1<? super T, Unit> paramFunction11)
  {
    if (paramFunction0 == null) {
      $$$reportNull$$$0(20);
    }
    if (paramFunction11 == null) {
      $$$reportNull$$$0(21);
    }
    return new LockBasedStorageManager.4(this, this, paramFunction0, paramFunction1, paramFunction11);
  }
  
  @NotNull
  public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    if (paramFunction1 == null) {
      $$$reportNull$$$0(7);
    }
    paramFunction1 = createMemoizedFunction(paramFunction1, createConcurrentHashMap());
    if (paramFunction1 == null) {
      $$$reportNull$$$0(8);
    }
    return paramFunction1;
  }
  
  @NotNull
  public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> paramFunction1, @NotNull ConcurrentMap<K, Object> paramConcurrentMap)
  {
    if (paramFunction1 == null) {
      $$$reportNull$$$0(9);
    }
    if (paramConcurrentMap == null) {
      $$$reportNull$$$0(10);
    }
    return new LockBasedStorageManager.MapBasedMemoizedFunctionToNotNull(this, paramConcurrentMap, paramFunction1);
  }
  
  @NotNull
  public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    if (paramFunction1 == null) {
      $$$reportNull$$$0(11);
    }
    paramFunction1 = createMemoizedFunctionWithNullableValues(paramFunction1, createConcurrentHashMap());
    if (paramFunction1 == null) {
      $$$reportNull$$$0(12);
    }
    return paramFunction1;
  }
  
  @NotNull
  public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> paramFunction1, @NotNull ConcurrentMap<K, Object> paramConcurrentMap)
  {
    if (paramFunction1 == null) {
      $$$reportNull$$$0(13);
    }
    if (paramConcurrentMap == null) {
      $$$reportNull$$$0(14);
    }
    return new LockBasedStorageManager.MapBasedMemoizedFunction(this, paramConcurrentMap, paramFunction1);
  }
  
  @NotNull
  public <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> paramFunction0)
  {
    if (paramFunction0 == null) {
      $$$reportNull$$$0(22);
    }
    return new LockBasedStorageManager.LockBasedLazyValue(this, paramFunction0);
  }
  
  @NotNull
  public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> paramFunction0, @NotNull T paramT)
  {
    if (paramFunction0 == null) {
      $$$reportNull$$$0(18);
    }
    if (paramT == null) {
      $$$reportNull$$$0(19);
    }
    return new LockBasedStorageManager.3(this, this, paramFunction0, paramT);
  }
  
  @NotNull
  protected <T> LockBasedStorageManager.RecursionDetectedResult<T> recursionDetectedDefault()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Recursive call in a lazy value under ");
    localStringBuilder.append(this);
    throw ((IllegalStateException)sanitizeStackTrace(new IllegalStateException(localStringBuilder.toString())));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    localStringBuilder.append(" (");
    localStringBuilder.append(this.debugText);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager
 * JD-Core Version:    0.7.0.1
 */