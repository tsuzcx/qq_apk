package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "checkPostponedCancellation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "cause", "", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "Lkotlin/Result;", "result", "resumeCancellableWith", "(Ljava/lang/Object;)V", "resumeCancelled", "()Z", "resumeUndispatchedWith", "resumeWith", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "_state", "Ljava/lang/Object;", "_state$annotations", "()V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "isReusable", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"}, k=1, mv={1, 1, 16})
public final class DispatchedContinuation<T>
  extends DispatchedTask<T>
  implements Continuation<T>, CoroutineStackFrame
{
  private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
  private volatile Object _reusableCancellableContinuation;
  @JvmField
  @Nullable
  public Object _state;
  @Nullable
  private final CoroutineStackFrame callerFrame;
  @JvmField
  @NotNull
  public final Continuation<T> continuation;
  @JvmField
  @NotNull
  public final Object countOrElement;
  @JvmField
  @NotNull
  public final CoroutineDispatcher dispatcher;
  
  public DispatchedContinuation(@NotNull CoroutineDispatcher paramCoroutineDispatcher, @NotNull Continuation<? super T> paramContinuation)
  {
    super(0);
    this.dispatcher = paramCoroutineDispatcher;
    this.continuation = paramContinuation;
    this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
    paramContinuation = this.continuation;
    paramCoroutineDispatcher = paramContinuation;
    if (!(paramContinuation instanceof CoroutineStackFrame)) {
      paramCoroutineDispatcher = null;
    }
    this.callerFrame = ((CoroutineStackFrame)paramCoroutineDispatcher);
    this.countOrElement = ThreadContextKt.threadContextElements(getContext());
    this._reusableCancellableContinuation = null;
  }
  
  @Nullable
  public final Throwable checkPostponedCancellation(@NotNull CancellableContinuation<?> paramCancellableContinuation)
  {
    Object localObject;
    do
    {
      localObject = this._reusableCancellableContinuation;
      if (localObject != DispatchedContinuationKt.REUSABLE_CLAIMED) {
        break;
      }
    } while (!_reusableCancellableContinuation$FU.compareAndSet(this, DispatchedContinuationKt.REUSABLE_CLAIMED, paramCancellableContinuation));
    return null;
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof Throwable))
    {
      if (_reusableCancellableContinuation$FU.compareAndSet(this, localObject, null)) {
        return (Throwable)localObject;
      }
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    paramCancellableContinuation = new StringBuilder();
    paramCancellableContinuation.append("Inconsistent state ");
    paramCancellableContinuation.append(localObject);
    paramCancellableContinuation = (Throwable)new IllegalStateException(paramCancellableContinuation.toString().toString());
    for (;;)
    {
      throw paramCancellableContinuation;
    }
  }
  
  @Nullable
  public final CancellableContinuationImpl<T> claimReusableCancellableContinuation()
  {
    do
    {
      localObject = this._reusableCancellableContinuation;
      if (localObject == null)
      {
        this._reusableCancellableContinuation = DispatchedContinuationKt.REUSABLE_CLAIMED;
        return null;
      }
      if (!(localObject instanceof CancellableContinuationImpl)) {
        break;
      }
    } while (!_reusableCancellableContinuation$FU.compareAndSet(this, localObject, DispatchedContinuationKt.REUSABLE_CLAIMED));
    return (CancellableContinuationImpl)localObject;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Inconsistent state ");
    localStringBuilder.append(localObject);
    Object localObject = (Throwable)new IllegalStateException(localStringBuilder.toString().toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public final void dispatchYield$kotlinx_coroutines_core(@NotNull CoroutineContext paramCoroutineContext, T paramT)
  {
    this._state = paramT;
    this.resumeMode = 1;
    this.dispatcher.dispatchYield(paramCoroutineContext, (Runnable)this);
  }
  
  @Nullable
  public CoroutineStackFrame getCallerFrame()
  {
    return this.callerFrame;
  }
  
  @NotNull
  public CoroutineContext getContext()
  {
    return this.continuation.getContext();
  }
  
  @NotNull
  public Continuation<T> getDelegate$kotlinx_coroutines_core()
  {
    return (Continuation)this;
  }
  
  @Nullable
  public final CancellableContinuationImpl<?> getReusableCancellableContinuation()
  {
    Object localObject2 = this._reusableCancellableContinuation;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof CancellableContinuationImpl)) {
      localObject1 = null;
    }
    return (CancellableContinuationImpl)localObject1;
  }
  
  @Nullable
  public StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final boolean isReusable()
  {
    return this._reusableCancellableContinuation != null;
  }
  
  public final boolean postponeCancellation(@NotNull Throwable paramThrowable)
  {
    Object localObject;
    do
    {
      do
      {
        localObject = this._reusableCancellableContinuation;
        if (!Intrinsics.areEqual(localObject, DispatchedContinuationKt.REUSABLE_CLAIMED)) {
          break;
        }
      } while (!_reusableCancellableContinuation$FU.compareAndSet(this, DispatchedContinuationKt.REUSABLE_CLAIMED, paramThrowable));
      return true;
      if ((localObject instanceof Throwable)) {
        return true;
      }
    } while (!_reusableCancellableContinuation$FU.compareAndSet(this, localObject, null));
    return false;
  }
  
  /* Error */
  public final void resumeCancellableWith(@NotNull Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 201	kotlinx/coroutines/CompletedExceptionallyKt:toState	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 106	kotlinx/coroutines/DispatchedContinuation:dispatcher	Lkotlinx/coroutines/CoroutineDispatcher;
    //   10: aload_0
    //   11: invokevirtual 120	kotlinx/coroutines/DispatchedContinuation:getContext	()Lkotlin/coroutines/CoroutineContext;
    //   14: invokevirtual 205	kotlinx/coroutines/CoroutineDispatcher:isDispatchNeeded	(Lkotlin/coroutines/CoroutineContext;)Z
    //   17: ifeq +30 -> 47
    //   20: aload_0
    //   21: aload 5
    //   23: putfield 116	kotlinx/coroutines/DispatchedContinuation:_state	Ljava/lang/Object;
    //   26: aload_0
    //   27: iconst_1
    //   28: putfield 178	kotlinx/coroutines/DispatchedContinuation:resumeMode	I
    //   31: aload_0
    //   32: getfield 106	kotlinx/coroutines/DispatchedContinuation:dispatcher	Lkotlinx/coroutines/CoroutineDispatcher;
    //   35: aload_0
    //   36: invokevirtual 120	kotlinx/coroutines/DispatchedContinuation:getContext	()Lkotlin/coroutines/CoroutineContext;
    //   39: aload_0
    //   40: checkcast 180	java/lang/Runnable
    //   43: invokevirtual 208	kotlinx/coroutines/CoroutineDispatcher:dispatch	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V
    //   46: return
    //   47: getstatic 214	kotlinx/coroutines/ThreadLocalEventLoop:INSTANCE	Lkotlinx/coroutines/ThreadLocalEventLoop;
    //   50: invokevirtual 218	kotlinx/coroutines/ThreadLocalEventLoop:getEventLoop$kotlinx_coroutines_core	()Lkotlinx/coroutines/EventLoop;
    //   53: astore 4
    //   55: aload 4
    //   57: invokevirtual 223	kotlinx/coroutines/EventLoop:isUnconfinedLoopActive	()Z
    //   60: ifeq +24 -> 84
    //   63: aload_0
    //   64: aload 5
    //   66: putfield 116	kotlinx/coroutines/DispatchedContinuation:_state	Ljava/lang/Object;
    //   69: aload_0
    //   70: iconst_1
    //   71: putfield 178	kotlinx/coroutines/DispatchedContinuation:resumeMode	I
    //   74: aload 4
    //   76: aload_0
    //   77: checkcast 5	kotlinx/coroutines/DispatchedTask
    //   80: invokevirtual 227	kotlinx/coroutines/EventLoop:dispatchUnconfined	(Lkotlinx/coroutines/DispatchedTask;)V
    //   83: return
    //   84: aload_0
    //   85: checkcast 5	kotlinx/coroutines/DispatchedTask
    //   88: astore 5
    //   90: aload 4
    //   92: iconst_1
    //   93: invokevirtual 231	kotlinx/coroutines/EventLoop:incrementUseCount	(Z)V
    //   96: aload_0
    //   97: invokevirtual 120	kotlinx/coroutines/DispatchedContinuation:getContext	()Lkotlin/coroutines/CoroutineContext;
    //   100: getstatic 237	kotlinx/coroutines/Job:Key	Lkotlinx/coroutines/Job$Key;
    //   103: checkcast 239	kotlin/coroutines/CoroutineContext$Key
    //   106: invokeinterface 245 2 0
    //   111: checkcast 233	kotlinx/coroutines/Job
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +186 -> 304
    //   121: aload 6
    //   123: invokeinterface 248 1 0
    //   128: ifne +176 -> 304
    //   131: aload 6
    //   133: invokeinterface 252 1 0
    //   138: checkcast 143	java/lang/Throwable
    //   141: astore 6
    //   143: getstatic 258	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   146: astore 7
    //   148: aload_0
    //   149: aload 6
    //   151: invokestatic 264	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   154: invokestatic 267	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   157: invokeinterface 269 2 0
    //   162: iconst_1
    //   163: istore_2
    //   164: goto +3 -> 167
    //   167: iload_2
    //   168: ifne +70 -> 238
    //   171: aload_0
    //   172: invokevirtual 120	kotlinx/coroutines/DispatchedContinuation:getContext	()Lkotlin/coroutines/CoroutineContext;
    //   175: astore 6
    //   177: aload 6
    //   179: aload_0
    //   180: getfield 128	kotlinx/coroutines/DispatchedContinuation:countOrElement	Ljava/lang/Object;
    //   183: invokestatic 273	kotlinx/coroutines/internal/ThreadContextKt:updateThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Ljava/lang/Object;
    //   186: astore 7
    //   188: aload_0
    //   189: getfield 108	kotlinx/coroutines/DispatchedContinuation:continuation	Lkotlin/coroutines/Continuation;
    //   192: aload_1
    //   193: invokeinterface 269 2 0
    //   198: getstatic 278	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   201: astore_1
    //   202: iconst_1
    //   203: invokestatic 283	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   206: aload 6
    //   208: aload 7
    //   210: invokestatic 286	kotlinx/coroutines/internal/ThreadContextKt:restoreThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V
    //   213: iconst_1
    //   214: invokestatic 289	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   217: goto +21 -> 238
    //   220: astore_1
    //   221: iconst_1
    //   222: invokestatic 283	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   225: aload 6
    //   227: aload 7
    //   229: invokestatic 286	kotlinx/coroutines/internal/ThreadContextKt:restoreThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V
    //   232: iconst_1
    //   233: invokestatic 289	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   236: aload_1
    //   237: athrow
    //   238: aload 4
    //   240: invokevirtual 292	kotlinx/coroutines/EventLoop:processUnconfinedEvent	()Z
    //   243: istore_3
    //   244: iload_3
    //   245: ifne -7 -> 238
    //   248: iconst_1
    //   249: invokestatic 283	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   252: goto +19 -> 271
    //   255: astore_1
    //   256: goto +26 -> 282
    //   259: astore_1
    //   260: aload 5
    //   262: aload_1
    //   263: aconst_null
    //   264: invokevirtual 296	kotlinx/coroutines/DispatchedTask:handleFatalException$kotlinx_coroutines_core	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   267: iconst_1
    //   268: invokestatic 283	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   271: aload 4
    //   273: iconst_1
    //   274: invokevirtual 299	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   277: iconst_1
    //   278: invokestatic 289	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   281: return
    //   282: iconst_1
    //   283: invokestatic 283	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   286: aload 4
    //   288: iconst_1
    //   289: invokevirtual 299	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   292: iconst_1
    //   293: invokestatic 289	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   296: goto +5 -> 301
    //   299: aload_1
    //   300: athrow
    //   301: goto -2 -> 299
    //   304: iconst_0
    //   305: istore_2
    //   306: goto -139 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	DispatchedContinuation
    //   0	309	1	paramObject	Object
    //   163	143	2	i	int
    //   243	2	3	bool	boolean
    //   53	234	4	localEventLoop	EventLoop
    //   4	257	5	localObject1	Object
    //   114	112	6	localObject2	Object
    //   146	82	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   188	202	220	finally
    //   96	116	255	finally
    //   121	162	255	finally
    //   171	188	255	finally
    //   202	217	255	finally
    //   221	238	255	finally
    //   238	244	255	finally
    //   260	267	255	finally
    //   96	116	259	java/lang/Throwable
    //   121	162	259	java/lang/Throwable
    //   171	188	259	java/lang/Throwable
    //   202	217	259	java/lang/Throwable
    //   221	238	259	java/lang/Throwable
    //   238	244	259	java/lang/Throwable
  }
  
  public final boolean resumeCancelled()
  {
    Object localObject = (Job)getContext().get((CoroutineContext.Key)Job.Key);
    if ((localObject != null) && (!((Job)localObject).isActive()))
    {
      localObject = (Throwable)((Job)localObject).getCancellationException();
      Result.Companion localCompanion = Result.Companion;
      resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable)localObject)));
      return true;
    }
    return false;
  }
  
  public final void resumeUndispatchedWith(@NotNull Object paramObject)
  {
    CoroutineContext localCoroutineContext = getContext();
    Object localObject = ThreadContextKt.updateThreadContext(localCoroutineContext, this.countOrElement);
    try
    {
      this.continuation.resumeWith(paramObject);
      paramObject = Unit.INSTANCE;
      return;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      ThreadContextKt.restoreThreadContext(localCoroutineContext, localObject);
      InlineMarker.finallyEnd(1);
    }
  }
  
  /* Error */
  public void resumeWith(@NotNull Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 108	kotlinx/coroutines/DispatchedContinuation:continuation	Lkotlin/coroutines/Continuation;
    //   4: invokeinterface 187 1 0
    //   9: astore_2
    //   10: aload_1
    //   11: invokestatic 201	kotlinx/coroutines/CompletedExceptionallyKt:toState	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore_3
    //   15: aload_0
    //   16: getfield 106	kotlinx/coroutines/DispatchedContinuation:dispatcher	Lkotlinx/coroutines/CoroutineDispatcher;
    //   19: aload_2
    //   20: invokevirtual 205	kotlinx/coroutines/CoroutineDispatcher:isDispatchNeeded	(Lkotlin/coroutines/CoroutineContext;)Z
    //   23: ifeq +26 -> 49
    //   26: aload_0
    //   27: aload_3
    //   28: putfield 116	kotlinx/coroutines/DispatchedContinuation:_state	Ljava/lang/Object;
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 178	kotlinx/coroutines/DispatchedContinuation:resumeMode	I
    //   36: aload_0
    //   37: getfield 106	kotlinx/coroutines/DispatchedContinuation:dispatcher	Lkotlinx/coroutines/CoroutineDispatcher;
    //   40: aload_2
    //   41: aload_0
    //   42: checkcast 180	java/lang/Runnable
    //   45: invokevirtual 208	kotlinx/coroutines/CoroutineDispatcher:dispatch	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V
    //   48: return
    //   49: getstatic 214	kotlinx/coroutines/ThreadLocalEventLoop:INSTANCE	Lkotlinx/coroutines/ThreadLocalEventLoop;
    //   52: invokevirtual 218	kotlinx/coroutines/ThreadLocalEventLoop:getEventLoop$kotlinx_coroutines_core	()Lkotlinx/coroutines/EventLoop;
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 223	kotlinx/coroutines/EventLoop:isUnconfinedLoopActive	()Z
    //   60: ifeq +22 -> 82
    //   63: aload_0
    //   64: aload_3
    //   65: putfield 116	kotlinx/coroutines/DispatchedContinuation:_state	Ljava/lang/Object;
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 178	kotlinx/coroutines/DispatchedContinuation:resumeMode	I
    //   73: aload_2
    //   74: aload_0
    //   75: checkcast 5	kotlinx/coroutines/DispatchedTask
    //   78: invokevirtual 227	kotlinx/coroutines/EventLoop:dispatchUnconfined	(Lkotlinx/coroutines/DispatchedTask;)V
    //   81: return
    //   82: aload_0
    //   83: checkcast 5	kotlinx/coroutines/DispatchedTask
    //   86: astore_3
    //   87: aload_2
    //   88: iconst_1
    //   89: invokevirtual 231	kotlinx/coroutines/EventLoop:incrementUseCount	(Z)V
    //   92: aload_0
    //   93: invokevirtual 120	kotlinx/coroutines/DispatchedContinuation:getContext	()Lkotlin/coroutines/CoroutineContext;
    //   96: astore 4
    //   98: aload 4
    //   100: aload_0
    //   101: getfield 128	kotlinx/coroutines/DispatchedContinuation:countOrElement	Ljava/lang/Object;
    //   104: invokestatic 273	kotlinx/coroutines/internal/ThreadContextKt:updateThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: astore 5
    //   109: aload_0
    //   110: getfield 108	kotlinx/coroutines/DispatchedContinuation:continuation	Lkotlin/coroutines/Continuation;
    //   113: aload_1
    //   114: invokeinterface 269 2 0
    //   119: getstatic 278	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   122: astore_1
    //   123: aload 4
    //   125: aload 5
    //   127: invokestatic 286	kotlinx/coroutines/internal/ThreadContextKt:restoreThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V
    //   130: aload_2
    //   131: invokevirtual 292	kotlinx/coroutines/EventLoop:processUnconfinedEvent	()Z
    //   134: ifne -4 -> 130
    //   137: goto +24 -> 161
    //   140: astore_1
    //   141: aload 4
    //   143: aload 5
    //   145: invokestatic 286	kotlinx/coroutines/internal/ThreadContextKt:restoreThreadContext	(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V
    //   148: aload_1
    //   149: athrow
    //   150: astore_1
    //   151: goto +16 -> 167
    //   154: astore_1
    //   155: aload_3
    //   156: aload_1
    //   157: aconst_null
    //   158: invokevirtual 296	kotlinx/coroutines/DispatchedTask:handleFatalException$kotlinx_coroutines_core	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   161: aload_2
    //   162: iconst_1
    //   163: invokevirtual 299	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   166: return
    //   167: aload_2
    //   168: iconst_1
    //   169: invokevirtual 299	kotlinx/coroutines/EventLoop:decrementUseCount	(Z)V
    //   172: goto +5 -> 177
    //   175: aload_1
    //   176: athrow
    //   177: goto -2 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	DispatchedContinuation
    //   0	180	1	paramObject	Object
    //   9	159	2	localObject1	Object
    //   14	142	3	localObject2	Object
    //   96	46	4	localCoroutineContext	CoroutineContext
    //   107	37	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   109	123	140	finally
    //   92	109	150	finally
    //   123	130	150	finally
    //   130	137	150	finally
    //   141	150	150	finally
    //   155	161	150	finally
    //   92	109	154	java/lang/Throwable
    //   123	130	154	java/lang/Throwable
    //   130	137	154	java/lang/Throwable
    //   141	150	154	java/lang/Throwable
  }
  
  @Nullable
  public Object takeState$kotlinx_coroutines_core()
  {
    Object localObject = this._state;
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (localObject != DispatchedContinuationKt.access$getUNDEFINED$p()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    this._state = DispatchedContinuationKt.access$getUNDEFINED$p();
    return localObject;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DispatchedContinuation[");
    localStringBuilder.append(this.dispatcher);
    localStringBuilder.append(", ");
    localStringBuilder.append(DebugStringsKt.toDebugString(this.continuation));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DispatchedContinuation
 * JD-Core Version:    0.7.0.1
 */