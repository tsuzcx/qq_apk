package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public abstract class ContinuationImpl
  extends BaseContinuationImpl
{
  private final CoroutineContext _context;
  private transient Continuation<Object> intercepted;
  
  public ContinuationImpl(@Nullable Continuation<Object> paramContinuation)
  {
    this(paramContinuation, localCoroutineContext);
  }
  
  public ContinuationImpl(@Nullable Continuation<Object> paramContinuation, @Nullable CoroutineContext paramCoroutineContext)
  {
    super(paramContinuation);
    this._context = paramCoroutineContext;
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    CoroutineContext localCoroutineContext = this._context;
    if (localCoroutineContext == null) {
      Intrinsics.throwNpe();
    }
    return localCoroutineContext;
  }
  
  @NotNull
  public final Continuation<Object> intercepted()
  {
    Object localObject = this.intercepted;
    if (localObject != null) {
      return localObject;
    }
    localObject = (ContinuationInterceptor)getContext().get((CoroutineContext.Key)ContinuationInterceptor.Key);
    if (localObject != null)
    {
      localObject = ((ContinuationInterceptor)localObject).interceptContinuation((Continuation)this);
      if (localObject != null) {}
    }
    else
    {
      localObject = (Continuation)this;
    }
    this.intercepted = ((Continuation)localObject);
    return localObject;
  }
  
  protected void releaseIntercepted()
  {
    Continuation localContinuation = this.intercepted;
    if ((localContinuation != null) && (localContinuation != (ContinuationImpl)this))
    {
      CoroutineContext.Element localElement = getContext().get((CoroutineContext.Key)ContinuationInterceptor.Key);
      if (localElement == null) {
        Intrinsics.throwNpe();
      }
      ((ContinuationInterceptor)localElement).releaseInterceptedContinuation(localContinuation);
    }
    this.intercepted = ((Continuation)CompletedContinuation.INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.ContinuationImpl
 * JD-Core Version:    0.7.0.1
 */