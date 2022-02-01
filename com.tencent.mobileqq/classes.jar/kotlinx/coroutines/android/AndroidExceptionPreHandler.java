package kotlinx.coroutines.android;

import android.os.Build.VERSION;
import android.support.annotation.Keep;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "_preHandler", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "preHandler", "Ljava/lang/reflect/Method;", "kotlinx-coroutines-android"}, k=1, mv={1, 1, 16})
@Keep
public final class AndroidExceptionPreHandler
  extends AbstractCoroutineContextElement
  implements CoroutineExceptionHandler
{
  private volatile Object _preHandler = this;
  
  public AndroidExceptionPreHandler()
  {
    super((CoroutineContext.Key)CoroutineExceptionHandler.Key);
  }
  
  private final Method preHandler()
  {
    Object localObject = this._preHandler;
    if (localObject != (AndroidExceptionPreHandler)this) {
      return (Method)localObject;
    }
    localObject = null;
    int j = 0;
    try
    {
      Method localMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
      int i = j;
      if (Modifier.isPublic(localMethod.getModifiers()))
      {
        boolean bool = Modifier.isStatic(localMethod.getModifiers());
        i = j;
        if (bool) {
          i = 1;
        }
      }
      if (i != 0) {
        localObject = localMethod;
      }
    }
    catch (Throwable localThrowable)
    {
      label77:
      break label77;
    }
    this._preHandler = localObject;
    return localObject;
  }
  
  public void handleException(@NotNull CoroutineContext paramCoroutineContext, @NotNull Throwable paramThrowable)
  {
    Thread localThread = Thread.currentThread();
    if (Build.VERSION.SDK_INT >= 28)
    {
      localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramThrowable);
      return;
    }
    paramCoroutineContext = preHandler();
    if (paramCoroutineContext != null) {
      paramCoroutineContext = paramCoroutineContext.invoke(null, new Object[0]);
    } else {
      paramCoroutineContext = null;
    }
    CoroutineContext localCoroutineContext = paramCoroutineContext;
    if (!(paramCoroutineContext instanceof Thread.UncaughtExceptionHandler)) {
      localCoroutineContext = null;
    }
    paramCoroutineContext = (Thread.UncaughtExceptionHandler)localCoroutineContext;
    if (paramCoroutineContext != null) {
      paramCoroutineContext.uncaughtException(localThread, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.android.AndroidExceptionPreHandler
 * JD-Core Version:    0.7.0.1
 */