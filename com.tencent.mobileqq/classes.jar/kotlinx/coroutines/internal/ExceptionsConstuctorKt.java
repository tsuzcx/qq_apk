package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class ExceptionsConstuctorKt
{
  private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
  private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap();
  private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);
  
  private static final Function1<Throwable, Throwable> createConstructor(Constructor<?> paramConstructor)
  {
    Object localObject3 = paramConstructor.getParameterTypes();
    int i = localObject3.length;
    Object localObject2 = null;
    Object localObject1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return null;
        }
        localObject1 = localObject2;
        if (Intrinsics.areEqual(localObject3[0], String.class))
        {
          localObject1 = localObject2;
          if (Intrinsics.areEqual(localObject3[1], Throwable.class)) {
            return (Function1)new ExceptionsConstuctorKt.createConstructor..inlined.safeCtor.1(paramConstructor);
          }
        }
      }
      else
      {
        localObject3 = localObject3[0];
        if (Intrinsics.areEqual(localObject3, Throwable.class)) {
          return (Function1)new ExceptionsConstuctorKt.createConstructor..inlined.safeCtor.2(paramConstructor);
        }
        localObject1 = localObject2;
        if (Intrinsics.areEqual(localObject3, String.class)) {
          return (Function1)new ExceptionsConstuctorKt.createConstructor..inlined.safeCtor.3(paramConstructor);
        }
      }
    }
    else {
      localObject1 = (Function1)new ExceptionsConstuctorKt.createConstructor..inlined.safeCtor.4(paramConstructor);
    }
    return localObject1;
  }
  
  private static final int fieldsCount(@NotNull Class<?> paramClass, int paramInt)
  {
    do
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int m = arrayOfField.length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if ((Modifier.isStatic(arrayOfField[i].getModifiers()) ^ true)) {
          k = j + 1;
        }
        i += 1;
      }
      paramInt += j;
      paramClass = paramClass.getSuperclass();
    } while (paramClass != null);
    return paramInt;
  }
  
  private static final int fieldsCountOrDefault(@NotNull Class<?> paramClass, int paramInt)
  {
    JvmClassMappingKt.getKotlinClass(paramClass);
    try
    {
      localObject = Result.Companion;
      paramClass = Result.constructor-impl(Integer.valueOf(fieldsCount$default(paramClass, 0, 1, null)));
    }
    catch (Throwable paramClass)
    {
      localObject = Result.Companion;
      paramClass = Result.constructor-impl(ResultKt.createFailure(paramClass));
    }
    Object localObject = paramClass;
    if (Result.isFailure-impl(paramClass)) {
      localObject = Integer.valueOf(paramInt);
    }
    return ((Number)localObject).intValue();
  }
  
  private static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> paramFunction1)
  {
    return (Function1)new ExceptionsConstuctorKt.safeCtor.1(paramFunction1);
  }
  
  @Nullable
  public static final <E extends Throwable> E tryCopyException(@NotNull E paramE)
  {
    boolean bool = paramE instanceof CopyableThrowable;
    Object localObject3 = null;
    if (bool)
    {
      try
      {
        localObject1 = Result.Companion;
        paramE = Result.constructor-impl(((CopyableThrowable)paramE).createCopy());
      }
      catch (Throwable paramE)
      {
        localObject1 = Result.Companion;
        paramE = Result.constructor-impl(ResultKt.createFailure(paramE));
      }
      localObject1 = paramE;
      if (Result.isFailure-impl(paramE)) {
        localObject1 = null;
      }
      return (Throwable)localObject1;
    }
    Object localObject1 = cacheLock.readLock();
    ((ReentrantReadWriteLock.ReadLock)localObject1).lock();
    try
    {
      Object localObject2 = (Function1)exceptionCtors.get(paramE.getClass());
      ((ReentrantReadWriteLock.ReadLock)localObject1).unlock();
      if (localObject2 != null) {
        return (Throwable)((Function1)localObject2).invoke(paramE);
      }
      int i = throwableFields;
      localObject1 = paramE.getClass();
      int m = 0;
      int n = 0;
      int i1 = 0;
      int k = 0;
      if (i != fieldsCountOrDefault((Class)localObject1, 0))
      {
        localObject2 = cacheLock;
        localObject1 = ((ReentrantReadWriteLock)localObject2).readLock();
        if (((ReentrantReadWriteLock)localObject2).getWriteHoldCount() == 0) {
          i = ((ReentrantReadWriteLock)localObject2).getReadHoldCount();
        } else {
          i = 0;
        }
        j = 0;
        while (j < i)
        {
          ((ReentrantReadWriteLock.ReadLock)localObject1).unlock();
          j += 1;
        }
        localObject2 = ((ReentrantReadWriteLock)localObject2).writeLock();
        ((ReentrantReadWriteLock.WriteLock)localObject2).lock();
        try
        {
          ((Map)exceptionCtors).put(paramE.getClass(), ExceptionsConstuctorKt.tryCopyException.4.1.INSTANCE);
          paramE = Unit.INSTANCE;
          return null;
        }
        finally
        {
          j = m;
          while (j < i)
          {
            ((ReentrantReadWriteLock.ReadLock)localObject1).lock();
            j += 1;
          }
          ((ReentrantReadWriteLock.WriteLock)localObject2).unlock();
        }
      }
      localObject1 = (Function1)null;
      Object localObject4 = ArraysKt.sortedWith(paramE.getClass().getConstructors(), (Comparator)new ExceptionsConstuctorKt.tryCopyException..inlined.sortedByDescending.1()).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject2 = createConstructor((Constructor)((Iterator)localObject4).next());
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      localObject2 = cacheLock;
      localObject4 = ((ReentrantReadWriteLock)localObject2).readLock();
      if (((ReentrantReadWriteLock)localObject2).getWriteHoldCount() == 0) {
        i = ((ReentrantReadWriteLock)localObject2).getReadHoldCount();
      } else {
        i = 0;
      }
      int j = 0;
      while (j < i)
      {
        ((ReentrantReadWriteLock.ReadLock)localObject4).unlock();
        j += 1;
      }
      ReentrantReadWriteLock.WriteLock localWriteLock = ((ReentrantReadWriteLock)localObject2).writeLock();
      localWriteLock.lock();
      try
      {
        Map localMap = (Map)exceptionCtors;
        Class localClass = paramE.getClass();
        if (localObject1 != null) {
          localObject2 = localObject1;
        } else {
          localObject2 = (Function1)ExceptionsConstuctorKt.tryCopyException.5.1.INSTANCE;
        }
        localMap.put(localClass, localObject2);
        localObject2 = Unit.INSTANCE;
        j = n;
        while (j < i)
        {
          ((ReentrantReadWriteLock.ReadLock)localObject4).lock();
          j += 1;
        }
        localWriteLock.unlock();
        localObject2 = localObject3;
        if (localObject1 != null) {
          localObject2 = (Throwable)((Function1)localObject1).invoke(paramE);
        }
        return localObject2;
      }
      finally
      {
        j = i1;
        while (j < i)
        {
          ((ReentrantReadWriteLock.ReadLock)localObject4).lock();
          j += 1;
        }
        localWriteLock.unlock();
      }
      throw paramE;
    }
    finally
    {
      ((ReentrantReadWriteLock.ReadLock)localObject1).unlock();
    }
    for (;;) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.ExceptionsConstuctorKt
 * JD-Core Version:    0.7.0.1
 */