package kotlinx.coroutines;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(level=DeprecationLevel.ERROR, message="This is internal API and may be removed in the future releases")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJobInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)V", "initParentJobInternal", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStartInternal$kotlinx_coroutines_core", "()V", "onStartInternal", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class JobSupport
  implements ChildJob, Job, ParentJob, SelectClause0
{
  private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
  private volatile Object _parentHandle;
  private volatile Object _state;
  
  public JobSupport(boolean paramBoolean)
  {
    Empty localEmpty;
    if (paramBoolean) {
      localEmpty = JobSupportKt.access$getEMPTY_ACTIVE$p();
    } else {
      localEmpty = JobSupportKt.access$getEMPTY_NEW$p();
    }
    this._state = localEmpty;
    this._parentHandle = null;
  }
  
  private final boolean addLastAtomic(Object paramObject, NodeList paramNodeList, JobNode<?> paramJobNode)
  {
    paramNodeList = (LockFreeLinkedListNode)paramNodeList;
    paramJobNode = (LockFreeLinkedListNode)paramJobNode;
    paramObject = (LockFreeLinkedListNode.CondAddOp)new JobSupport.addLastAtomic..inlined.addLastIf.1(paramJobNode, paramJobNode, this, paramObject);
    int i;
    do
    {
      i = paramNodeList.getPrevNode().tryCondAddNext(paramJobNode, paramNodeList, paramObject);
      bool = true;
      if (i == 1) {
        break;
      }
    } while (i != 2);
    boolean bool = false;
    return bool;
  }
  
  private final void addSuppressedExceptions(Throwable paramThrowable, List<? extends Throwable> paramList)
  {
    if (paramList.size() <= 1) {
      return;
    }
    Set localSet = Collections.newSetFromMap((Map)new IdentityHashMap(paramList.size()));
    Throwable localThrowable;
    if (!DebugKt.getRECOVER_STACK_TRACES()) {
      localThrowable = paramThrowable;
    } else {
      localThrowable = StackTraceRecoveryKt.unwrapImpl(paramThrowable);
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (Throwable)localIterator.next();
      if (DebugKt.getRECOVER_STACK_TRACES()) {
        paramList = StackTraceRecoveryKt.unwrapImpl(paramList);
      }
      if ((paramList != paramThrowable) && (paramList != localThrowable) && (!(paramList instanceof CancellationException)) && (localSet.add(paramList))) {
        ExceptionsKt.addSuppressed(paramThrowable, paramList);
      }
    }
  }
  
  private final Object cancelMakeCompleting(Object paramObject)
  {
    Object localObject;
    do
    {
      localObject = getState$kotlinx_coroutines_core();
      if ((!(localObject instanceof Incomplete)) || (((localObject instanceof JobSupport.Finishing)) && (((JobSupport.Finishing)localObject).isCompleting()))) {
        break;
      }
      localObject = tryMakeCompleting(localObject, new CompletedExceptionally(createCauseException(paramObject), false, 2, null));
    } while (localObject == JobSupportKt.access$getCOMPLETING_RETRY$p());
    return localObject;
    return JobSupportKt.access$getCOMPLETING_ALREADY$p();
  }
  
  private final boolean cancelParent(Throwable paramThrowable)
  {
    boolean bool2 = isScopedCoroutine();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    bool2 = paramThrowable instanceof CancellationException;
    ChildHandle localChildHandle = getParentHandle$kotlinx_coroutines_core();
    if (localChildHandle != null)
    {
      if (localChildHandle == NonDisposableHandle.INSTANCE) {
        return bool2;
      }
      if (!localChildHandle.childCancelled(paramThrowable))
      {
        if (bool2) {
          return true;
        }
        bool1 = false;
      }
      return bool1;
    }
    return bool2;
  }
  
  private final void completeStateFinalization(Incomplete paramIncomplete, Object paramObject)
  {
    Object localObject = getParentHandle$kotlinx_coroutines_core();
    if (localObject != null)
    {
      ((ChildHandle)localObject).dispose();
      setParentHandle$kotlinx_coroutines_core((ChildHandle)NonDisposableHandle.INSTANCE);
    }
    boolean bool = paramObject instanceof CompletedExceptionally;
    localObject = null;
    if (!bool) {
      paramObject = null;
    }
    CompletedExceptionally localCompletedExceptionally = (CompletedExceptionally)paramObject;
    paramObject = localObject;
    if (localCompletedExceptionally != null) {
      paramObject = localCompletedExceptionally.cause;
    }
    if ((paramIncomplete instanceof JobNode)) {
      try
      {
        ((JobNode)paramIncomplete).invoke(paramObject);
        return;
      }
      catch (Throwable paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Exception in completion handler ");
        ((StringBuilder)localObject).append(paramIncomplete);
        ((StringBuilder)localObject).append(" for ");
        ((StringBuilder)localObject).append(this);
        handleOnCompletionException$kotlinx_coroutines_core((Throwable)new CompletionHandlerException(((StringBuilder)localObject).toString(), paramObject));
        return;
      }
    }
    paramIncomplete = paramIncomplete.getList();
    if (paramIncomplete != null) {
      notifyCompletion(paramIncomplete, paramObject);
    }
  }
  
  private final void continueCompleting(JobSupport.Finishing paramFinishing, ChildHandleNode paramChildHandleNode, Object paramObject)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (getState$kotlinx_coroutines_core() == paramFinishing) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    paramChildHandleNode = nextChild((LockFreeLinkedListNode)paramChildHandleNode);
    if ((paramChildHandleNode != null) && (tryWaitForChild(paramFinishing, paramChildHandleNode, paramObject))) {
      return;
    }
    afterCompletion(finalizeFinishingState(paramFinishing, paramObject));
  }
  
  private final Throwable createCauseException(Object paramObject)
  {
    boolean bool;
    if (paramObject != null) {
      bool = paramObject instanceof Throwable;
    } else {
      bool = true;
    }
    if (bool)
    {
      if (paramObject != null) {
        return (Throwable)paramObject;
      }
      paramObject = (String)null;
      paramObject = (Throwable)null;
      return (Throwable)new JobCancellationException(access$cancellationExceptionMessage(this), paramObject, (Job)this);
    }
    if (paramObject != null) {
      return (Throwable)((ParentJob)paramObject).getChildJobCancellationCause();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
  }
  
  private final Object finalizeFinishingState(JobSupport.Finishing paramFinishing, Object paramObject)
  {
    boolean bool = DebugKt.getASSERTIONS_ENABLED();
    int j = 1;
    int i;
    if (bool)
    {
      if (getState$kotlinx_coroutines_core() == paramFinishing) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if ((DebugKt.getASSERTIONS_ENABLED()) && (!(paramFinishing.isSealed() ^ true))) {
      throw ((Throwable)new AssertionError());
    }
    if ((DebugKt.getASSERTIONS_ENABLED()) && (!paramFinishing.isCompleting())) {
      throw ((Throwable)new AssertionError());
    }
    if (!(paramObject instanceof CompletedExceptionally)) {
      localObject = null;
    } else {
      localObject = paramObject;
    }
    Object localObject = (CompletedExceptionally)localObject;
    if (localObject != null) {
      localObject = ((CompletedExceptionally)localObject).cause;
    } else {
      localObject = null;
    }
    try
    {
      bool = paramFinishing.isCancelling();
      List localList = paramFinishing.sealLocked((Throwable)localObject);
      Throwable localThrowable = getFinalRootCause(paramFinishing, localList);
      if (localThrowable != null) {
        addSuppressedExceptions(localThrowable, localList);
      }
      if ((localThrowable != null) && (localThrowable != localObject)) {
        paramObject = new CompletedExceptionally(localThrowable, false, 2, null);
      }
      if (localThrowable != null)
      {
        i = j;
        if (!cancelParent(localThrowable)) {
          if (handleJobException(localThrowable)) {
            i = j;
          } else {
            i = 0;
          }
        }
        if (i != 0) {
          if (paramObject != null) {
            ((CompletedExceptionally)paramObject).makeHandled();
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
          }
        }
      }
      if (!bool) {
        onCancelling(localThrowable);
      }
      onCompletionInternal(paramObject);
      bool = _state$FU.compareAndSet(this, paramFinishing, JobSupportKt.boxIncomplete(paramObject));
      if ((DebugKt.getASSERTIONS_ENABLED()) && (!bool)) {
        throw ((Throwable)new AssertionError());
      }
      completeStateFinalization((Incomplete)paramFinishing, paramObject);
      return paramObject;
    }
    finally {}
  }
  
  private final ChildHandleNode firstChild(Incomplete paramIncomplete)
  {
    boolean bool = paramIncomplete instanceof ChildHandleNode;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    } else {
      localObject1 = paramIncomplete;
    }
    Object localObject1 = (ChildHandleNode)localObject1;
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = paramIncomplete.getList();
    paramIncomplete = localObject2;
    if (localObject1 != null) {
      paramIncomplete = nextChild((LockFreeLinkedListNode)localObject1);
    }
    return paramIncomplete;
  }
  
  private final Throwable getExceptionOrNull(@Nullable Object paramObject)
  {
    boolean bool = paramObject instanceof CompletedExceptionally;
    Object localObject = null;
    if (!bool) {
      paramObject = null;
    }
    CompletedExceptionally localCompletedExceptionally = (CompletedExceptionally)paramObject;
    paramObject = localObject;
    if (localCompletedExceptionally != null) {
      paramObject = localCompletedExceptionally.cause;
    }
    return paramObject;
  }
  
  private final Throwable getFinalRootCause(JobSupport.Finishing paramFinishing, List<? extends Throwable> paramList)
  {
    if (paramList.isEmpty())
    {
      if (paramFinishing.isCancelling())
      {
        paramFinishing = (String)null;
        paramFinishing = (Throwable)null;
        return (Throwable)new JobCancellationException(access$cancellationExceptionMessage(this), paramFinishing, (Job)this);
      }
      return null;
    }
    Object localObject1 = (Iterable)paramList;
    Object localObject2 = ((Iterable)localObject1).iterator();
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      paramFinishing = ((Iterator)localObject2).next();
      if (!((Throwable)paramFinishing instanceof CancellationException)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label107;
      }
    }
    paramFinishing = null;
    label107:
    paramFinishing = (Throwable)paramFinishing;
    if (paramFinishing != null) {
      return paramFinishing;
    }
    paramList = (Throwable)paramList.get(0);
    if ((paramList instanceof TimeoutCancellationException))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramFinishing = ((Iterator)localObject1).next();
        localObject2 = (Throwable)paramFinishing;
        if ((localObject2 != paramList) && ((localObject2 instanceof TimeoutCancellationException))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          break label199;
        }
      }
      paramFinishing = null;
      label199:
      paramFinishing = (Throwable)paramFinishing;
      if (paramFinishing != null) {
        return paramFinishing;
      }
    }
    return paramList;
  }
  
  private final NodeList getOrPromoteCancellingList(Incomplete paramIncomplete)
  {
    Object localObject = paramIncomplete.getList();
    if (localObject != null) {
      return localObject;
    }
    if ((paramIncomplete instanceof Empty)) {
      return new NodeList();
    }
    if ((paramIncomplete instanceof JobNode))
    {
      promoteSingleToNodeList((JobNode)paramIncomplete);
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("State should have list: ");
    ((StringBuilder)localObject).append(paramIncomplete);
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
  }
  
  private final boolean isCancelling(@NotNull Incomplete paramIncomplete)
  {
    return ((paramIncomplete instanceof JobSupport.Finishing)) && (((JobSupport.Finishing)paramIncomplete).isCancelling());
  }
  
  private final boolean joinInternal()
  {
    Object localObject;
    do
    {
      localObject = getState$kotlinx_coroutines_core();
      if (!(localObject instanceof Incomplete)) {
        return false;
      }
    } while (startInternal(localObject) < 0);
    return true;
  }
  
  private final Void loopOnState(Function1<Object, Unit> paramFunction1)
  {
    for (;;)
    {
      paramFunction1.invoke(getState$kotlinx_coroutines_core());
    }
  }
  
  private final Object makeCancelling(Object paramObject)
  {
    Object localObject1 = (Throwable)null;
    Object localObject3 = getState$kotlinx_coroutines_core();
    if ((localObject3 instanceof JobSupport.Finishing)) {}
    for (;;)
    {
      try
      {
        if (((JobSupport.Finishing)localObject3).isSealed())
        {
          paramObject = JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
          return paramObject;
        }
        boolean bool = ((JobSupport.Finishing)localObject3).isCancelling();
        if (paramObject != null) {
          break label273;
        }
        if (!bool)
        {
          break label273;
          localObject1 = createCauseException(paramObject);
          ((JobSupport.Finishing)localObject3).addExceptionLocked((Throwable)localObject1);
        }
        paramObject = ((JobSupport.Finishing)localObject3).getRootCause();
        if (!(bool ^ true)) {
          paramObject = null;
        }
        if (paramObject != null) {
          notifyCancelling(((JobSupport.Finishing)localObject3).getList(), paramObject);
        }
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
      }
      finally {}
      if ((localObject3 instanceof Incomplete))
      {
        Object localObject2;
        if (localObject1 != null) {
          localObject2 = localObject1;
        } else {
          localObject2 = createCauseException(paramObject);
        }
        Incomplete localIncomplete = (Incomplete)localObject3;
        if (localIncomplete.isActive())
        {
          localObject1 = localObject2;
          if (!tryMakeCancelling(localIncomplete, (Throwable)localObject2)) {
            break;
          }
          return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }
        localObject1 = tryMakeCompleting(localObject3, new CompletedExceptionally((Throwable)localObject2, false, 2, null));
        if (localObject1 != JobSupportKt.access$getCOMPLETING_ALREADY$p())
        {
          if (localObject1 == JobSupportKt.access$getCOMPLETING_RETRY$p())
          {
            localObject1 = localObject2;
            break;
          }
          return localObject1;
        }
        paramObject = new StringBuilder();
        paramObject.append("Cannot happen in ");
        paramObject.append(localObject3);
        throw ((Throwable)new IllegalStateException(paramObject.toString().toString()));
      }
      return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
      label273:
      if (localObject1 == null) {}
    }
  }
  
  private final JobNode<?> makeNode(Function1<? super Throwable, Unit> paramFunction1, boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramBoolean)
    {
      if ((paramFunction1 instanceof JobCancellingNode)) {
        localObject1 = paramFunction1;
      }
      localObject1 = (JobCancellingNode)localObject1;
      if (localObject1 != null)
      {
        if (DebugKt.getASSERTIONS_ENABLED())
        {
          if (((JobCancellingNode)localObject1).job != (JobSupport)this) {
            i = 0;
          }
          if (i == 0) {
            throw ((Throwable)new AssertionError());
          }
        }
        if (localObject1 != null) {
          return (JobNode)localObject1;
        }
      }
      return (JobNode)new InvokeOnCancelling((Job)this, paramFunction1);
    }
    if (!(paramFunction1 instanceof JobNode)) {
      localObject1 = localObject2;
    } else {
      localObject1 = paramFunction1;
    }
    localObject1 = (JobNode)localObject1;
    if (localObject1 != null)
    {
      if (DebugKt.getASSERTIONS_ENABLED())
      {
        if ((((JobNode)localObject1).job == (JobSupport)this) && (!(localObject1 instanceof JobCancellingNode))) {
          i = j;
        } else {
          i = 0;
        }
        if (i == 0) {
          throw ((Throwable)new AssertionError());
        }
      }
      if (localObject1 != null) {
        return localObject1;
      }
    }
    return (JobNode)new InvokeOnCompletion((Job)this, paramFunction1);
  }
  
  private final ChildHandleNode nextChild(@NotNull LockFreeLinkedListNode paramLockFreeLinkedListNode)
  {
    LockFreeLinkedListNode localLockFreeLinkedListNode;
    for (;;)
    {
      localLockFreeLinkedListNode = paramLockFreeLinkedListNode;
      if (!paramLockFreeLinkedListNode.isRemoved()) {
        break;
      }
      paramLockFreeLinkedListNode = paramLockFreeLinkedListNode.getPrevNode();
    }
    do
    {
      for (;;)
      {
        paramLockFreeLinkedListNode = localLockFreeLinkedListNode.getNextNode();
        if (!paramLockFreeLinkedListNode.isRemoved()) {
          break;
        }
        localLockFreeLinkedListNode = paramLockFreeLinkedListNode;
      }
      if ((paramLockFreeLinkedListNode instanceof ChildHandleNode)) {
        return (ChildHandleNode)paramLockFreeLinkedListNode;
      }
      localLockFreeLinkedListNode = paramLockFreeLinkedListNode;
    } while (!(paramLockFreeLinkedListNode instanceof NodeList));
    return null;
  }
  
  private final void notifyCancelling(NodeList paramNodeList, Throwable paramThrowable)
  {
    onCancelling(paramThrowable);
    Object localObject1 = (Throwable)null;
    LockFreeLinkedListHead localLockFreeLinkedListHead = (LockFreeLinkedListHead)paramNodeList;
    paramNodeList = localLockFreeLinkedListHead.getNext();
    if (paramNodeList != null)
    {
      paramNodeList = (LockFreeLinkedListNode)paramNodeList;
      while ((Intrinsics.areEqual(paramNodeList, localLockFreeLinkedListHead) ^ true))
      {
        Object localObject2 = localObject1;
        if ((paramNodeList instanceof JobCancellingNode))
        {
          localObject2 = (JobNode)paramNodeList;
          try
          {
            ((JobNode)localObject2).invoke(paramThrowable);
            localObject2 = localObject1;
          }
          catch (Throwable localThrowable)
          {
            if (localObject1 != null)
            {
              ExceptionsKt.addSuppressed((Throwable)localObject1, localThrowable);
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                break label162;
              }
            }
            localObject1 = (JobSupport)this;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Exception in completion handler ");
            localStringBuilder.append(localObject2);
            localStringBuilder.append(" for ");
            localStringBuilder.append(localObject1);
            localObject2 = (Throwable)new CompletionHandlerException(localStringBuilder.toString(), localThrowable);
            localObject1 = Unit.INSTANCE;
          }
        }
        label162:
        paramNodeList = paramNodeList.getNextNode();
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        handleOnCompletionException$kotlinx_coroutines_core((Throwable)localObject1);
      }
      cancelParent(paramThrowable);
      return;
    }
    paramNodeList = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw paramNodeList;
    }
  }
  
  private final void notifyCompletion(@NotNull NodeList paramNodeList, Throwable paramThrowable)
  {
    Object localObject1 = (Throwable)null;
    LockFreeLinkedListHead localLockFreeLinkedListHead = (LockFreeLinkedListHead)paramNodeList;
    paramNodeList = localLockFreeLinkedListHead.getNext();
    if (paramNodeList != null)
    {
      paramNodeList = (LockFreeLinkedListNode)paramNodeList;
      while ((Intrinsics.areEqual(paramNodeList, localLockFreeLinkedListHead) ^ true))
      {
        Object localObject2 = localObject1;
        if ((paramNodeList instanceof JobNode))
        {
          localObject2 = (JobNode)paramNodeList;
          try
          {
            ((JobNode)localObject2).invoke(paramThrowable);
            localObject2 = localObject1;
          }
          catch (Throwable localThrowable)
          {
            if (localObject1 != null)
            {
              ExceptionsKt.addSuppressed((Throwable)localObject1, localThrowable);
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                break label157;
              }
            }
            localObject1 = (JobSupport)this;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Exception in completion handler ");
            localStringBuilder.append(localObject2);
            localStringBuilder.append(" for ");
            localStringBuilder.append(localObject1);
            localObject2 = (Throwable)new CompletionHandlerException(localStringBuilder.toString(), localThrowable);
            localObject1 = Unit.INSTANCE;
          }
        }
        label157:
        paramNodeList = paramNodeList.getNextNode();
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        handleOnCompletionException$kotlinx_coroutines_core((Throwable)localObject1);
      }
      return;
    }
    paramNodeList = new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    for (;;)
    {
      throw paramNodeList;
    }
  }
  
  private final void promoteEmptyToNodeList(Empty paramEmpty)
  {
    Object localObject = new NodeList();
    if (paramEmpty.isActive()) {
      localObject = (Incomplete)localObject;
    } else {
      localObject = (Incomplete)new InactiveNodeList((NodeList)localObject);
    }
    _state$FU.compareAndSet(this, paramEmpty, localObject);
  }
  
  private final void promoteSingleToNodeList(JobNode<?> paramJobNode)
  {
    paramJobNode.addOneIfEmpty((LockFreeLinkedListNode)new NodeList());
    LockFreeLinkedListNode localLockFreeLinkedListNode = paramJobNode.getNextNode();
    _state$FU.compareAndSet(this, paramJobNode, localLockFreeLinkedListNode);
  }
  
  private final int startInternal(Object paramObject)
  {
    if ((paramObject instanceof Empty))
    {
      if (((Empty)paramObject).isActive()) {
        return 0;
      }
      if (!_state$FU.compareAndSet(this, paramObject, JobSupportKt.access$getEMPTY_ACTIVE$p())) {
        return -1;
      }
      onStartInternal$kotlinx_coroutines_core();
      return 1;
    }
    if ((paramObject instanceof InactiveNodeList))
    {
      if (!_state$FU.compareAndSet(this, paramObject, ((InactiveNodeList)paramObject).getList())) {
        return -1;
      }
      onStartInternal$kotlinx_coroutines_core();
      return 1;
    }
    return 0;
  }
  
  private final String stateString(Object paramObject)
  {
    boolean bool = paramObject instanceof JobSupport.Finishing;
    String str = "Active";
    if (bool)
    {
      JobSupport.Finishing localFinishing = (JobSupport.Finishing)paramObject;
      if (localFinishing.isCancelling()) {
        return "Cancelling";
      }
      paramObject = str;
      if (localFinishing.isCompleting()) {
        return "Completing";
      }
    }
    else
    {
      if ((paramObject instanceof Incomplete))
      {
        if (((Incomplete)paramObject).isActive()) {
          return "Active";
        }
        return "New";
      }
      if ((paramObject instanceof CompletedExceptionally)) {
        return "Cancelled";
      }
      paramObject = "Completed";
    }
    return paramObject;
  }
  
  private final boolean tryFinalizeSimpleState(Incomplete paramIncomplete, Object paramObject)
  {
    int i;
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      if ((!(paramIncomplete instanceof Empty)) && (!(paramIncomplete instanceof JobNode))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      if (!(paramObject instanceof CompletedExceptionally)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (!_state$FU.compareAndSet(this, paramIncomplete, JobSupportKt.boxIncomplete(paramObject))) {
      return false;
    }
    onCancelling(null);
    onCompletionInternal(paramObject);
    completeStateFinalization(paramIncomplete, paramObject);
    return true;
  }
  
  private final boolean tryMakeCancelling(Incomplete paramIncomplete, Throwable paramThrowable)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (!(paramIncomplete instanceof JobSupport.Finishing)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if ((DebugKt.getASSERTIONS_ENABLED()) && (!paramIncomplete.isActive())) {
      throw ((Throwable)new AssertionError());
    }
    NodeList localNodeList = getOrPromoteCancellingList(paramIncomplete);
    if (localNodeList != null)
    {
      JobSupport.Finishing localFinishing = new JobSupport.Finishing(localNodeList, false, paramThrowable);
      if (!_state$FU.compareAndSet(this, paramIncomplete, localFinishing)) {
        return false;
      }
      notifyCancelling(localNodeList, paramThrowable);
      return true;
    }
    return false;
  }
  
  private final Object tryMakeCompleting(Object paramObject1, Object paramObject2)
  {
    if (!(paramObject1 instanceof Incomplete)) {
      return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    }
    if ((((paramObject1 instanceof Empty)) || ((paramObject1 instanceof JobNode))) && (!(paramObject1 instanceof ChildHandleNode)) && (!(paramObject2 instanceof CompletedExceptionally)))
    {
      if (tryFinalizeSimpleState((Incomplete)paramObject1, paramObject2)) {
        return paramObject2;
      }
      return JobSupportKt.access$getCOMPLETING_RETRY$p();
    }
    return tryMakeCompletingSlowPath((Incomplete)paramObject1, paramObject2);
  }
  
  private final Object tryMakeCompletingSlowPath(Incomplete paramIncomplete, Object paramObject)
  {
    NodeList localNodeList = getOrPromoteCancellingList(paramIncomplete);
    boolean bool;
    Unit localUnit;
    Object localObject1;
    Object localObject2;
    if (localNodeList != null)
    {
      bool = paramIncomplete instanceof JobSupport.Finishing;
      localUnit = null;
      if (!bool) {
        localObject1 = null;
      } else {
        localObject1 = paramIncomplete;
      }
      localObject1 = (JobSupport.Finishing)localObject1;
      if (localObject1 == null) {
        localObject1 = new JobSupport.Finishing(localNodeList, false, null);
      }
      localObject2 = (Throwable)null;
    }
    for (;;)
    {
      try
      {
        if (((JobSupport.Finishing)localObject1).isCompleting())
        {
          paramIncomplete = JobSupportKt.access$getCOMPLETING_ALREADY$p();
          return paramIncomplete;
        }
        ((JobSupport.Finishing)localObject1).setCompleting(true);
        if ((localObject1 != paramIncomplete) && (!_state$FU.compareAndSet(this, paramIncomplete, localObject1)))
        {
          paramIncomplete = JobSupportKt.access$getCOMPLETING_RETRY$p();
          return paramIncomplete;
        }
        if ((DebugKt.getASSERTIONS_ENABLED()) && (!(((JobSupport.Finishing)localObject1).isSealed() ^ true))) {
          throw ((Throwable)new AssertionError());
        }
        bool = ((JobSupport.Finishing)localObject1).isCancelling();
        if ((paramObject instanceof CompletedExceptionally)) {
          break label277;
        }
        localObject2 = null;
        localObject2 = (CompletedExceptionally)localObject2;
        if (localObject2 != null) {
          ((JobSupport.Finishing)localObject1).addExceptionLocked(((CompletedExceptionally)localObject2).cause);
        }
        Throwable localThrowable = ((JobSupport.Finishing)localObject1).getRootCause();
        localObject2 = localUnit;
        if ((true ^ bool)) {
          localObject2 = localThrowable;
        }
        localUnit = Unit.INSTANCE;
        if (localObject2 != null) {
          notifyCancelling(localNodeList, (Throwable)localObject2);
        }
        paramIncomplete = firstChild(paramIncomplete);
        if ((paramIncomplete != null) && (tryWaitForChild((JobSupport.Finishing)localObject1, paramIncomplete, paramObject))) {
          return JobSupportKt.COMPLETING_WAITING_CHILDREN;
        }
        return finalizeFinishingState((JobSupport.Finishing)localObject1, paramObject);
      }
      finally {}
      return JobSupportKt.access$getCOMPLETING_RETRY$p();
      label277:
      localObject2 = paramObject;
    }
  }
  
  private final boolean tryWaitForChild(JobSupport.Finishing paramFinishing, ChildHandleNode paramChildHandleNode, Object paramObject)
  {
    do
    {
      if (Job.DefaultImpls.invokeOnCompletion$default(paramChildHandleNode.childJob, false, false, (Function1)new JobSupport.ChildCompletion(this, paramFinishing, paramChildHandleNode, paramObject), 1, null) != NonDisposableHandle.INSTANCE) {
        return true;
      }
      paramChildHandleNode = nextChild((LockFreeLinkedListNode)paramChildHandleNode);
    } while (paramChildHandleNode != null);
    return false;
  }
  
  protected void afterCompletion(@Nullable Object paramObject) {}
  
  @NotNull
  public final ChildHandle attachChild(@NotNull ChildJob paramChildJob)
  {
    paramChildJob = Job.DefaultImpls.invokeOnCompletion$default(this, true, false, (Function1)new ChildHandleNode(this, paramChildJob), 2, null);
    if (paramChildJob != null) {
      return (ChildHandle)paramChildJob;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
  }
  
  @Nullable
  public final Object awaitInternal$kotlinx_coroutines_core(@NotNull Continuation<Object> paramContinuation)
  {
    Object localObject;
    do
    {
      localObject = getState$kotlinx_coroutines_core();
      if (!(localObject instanceof Incomplete))
      {
        if ((localObject instanceof CompletedExceptionally))
        {
          localObject = ((CompletedExceptionally)localObject).cause;
          if (DebugKt.getRECOVER_STACK_TRACES())
          {
            if (!(paramContinuation instanceof CoroutineStackFrame)) {
              throw ((Throwable)localObject);
            }
            throw StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)localObject, (CoroutineStackFrame)paramContinuation);
          }
          throw ((Throwable)localObject);
        }
        return JobSupportKt.unboxState(localObject);
      }
    } while (startInternal(localObject) < 0);
    return awaitSuspend(paramContinuation);
  }
  
  public void cancel(@Nullable CancellationException paramCancellationException)
  {
    if (paramCancellationException != null)
    {
      paramCancellationException = (Throwable)paramCancellationException;
    }
    else
    {
      paramCancellationException = (String)null;
      paramCancellationException = (Throwable)null;
      paramCancellationException = (Throwable)new JobCancellationException(access$cancellationExceptionMessage(this), paramCancellationException, (Job)this);
    }
    cancelInternal(paramCancellationException);
  }
  
  public final boolean cancelCoroutine(@Nullable Throwable paramThrowable)
  {
    return cancelImpl$kotlinx_coroutines_core(paramThrowable);
  }
  
  public final boolean cancelImpl$kotlinx_coroutines_core(@Nullable Object paramObject)
  {
    Object localObject1 = JobSupportKt.access$getCOMPLETING_ALREADY$p();
    if (getOnCancelComplete$kotlinx_coroutines_core())
    {
      localObject2 = cancelMakeCompleting(paramObject);
      localObject1 = localObject2;
      if (localObject2 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
        return true;
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
      localObject2 = makeCancelling(paramObject);
    }
    if (localObject2 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
      return true;
    }
    if (localObject2 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
      return true;
    }
    if (localObject2 == JobSupportKt.access$getTOO_LATE_TO_CANCEL$p()) {
      return false;
    }
    afterCompletion(localObject2);
    return true;
  }
  
  public void cancelInternal(@NotNull Throwable paramThrowable)
  {
    cancelImpl$kotlinx_coroutines_core(paramThrowable);
  }
  
  @NotNull
  protected String cancellationExceptionMessage()
  {
    return "Job was cancelled";
  }
  
  public boolean childCancelled(@NotNull Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CancellationException)) {
      return true;
    }
    return (cancelImpl$kotlinx_coroutines_core(paramThrowable)) && (getHandlesException$kotlinx_coroutines_core());
  }
  
  @NotNull
  public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    if (paramString == null) {
      paramString = access$cancellationExceptionMessage(this);
    }
    return new JobCancellationException(paramString, paramThrowable, (Job)this);
  }
  
  public <R> R fold(R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return Job.DefaultImpls.fold(this, paramR, paramFunction2);
  }
  
  @Nullable
  public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> paramKey)
  {
    return Job.DefaultImpls.get(this, paramKey);
  }
  
  @NotNull
  public final CancellationException getCancellationException()
  {
    Object localObject = getState$kotlinx_coroutines_core();
    if ((localObject instanceof JobSupport.Finishing))
    {
      localObject = ((JobSupport.Finishing)localObject).getRootCause();
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(DebugStringsKt.getClassSimpleName(this));
        localStringBuilder.append(" is cancelling");
        localObject = toCancellationException((Throwable)localObject, localStringBuilder.toString());
        if (localObject != null) {
          return localObject;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Job is still new or active: ");
      ((StringBuilder)localObject).append(this);
      throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
    }
    if (!(localObject instanceof Incomplete))
    {
      if ((localObject instanceof CompletedExceptionally)) {
        return toCancellationException$default(this, ((CompletedExceptionally)localObject).cause, null, 1, null);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(DebugStringsKt.getClassSimpleName(this));
      ((StringBuilder)localObject).append(" has completed normally");
      return (CancellationException)new JobCancellationException(((StringBuilder)localObject).toString(), null, (Job)this);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Job is still new or active: ");
    ((StringBuilder)localObject).append(this);
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
  }
  
  @NotNull
  public CancellationException getChildJobCancellationCause()
  {
    Object localObject3 = getState$kotlinx_coroutines_core();
    boolean bool = localObject3 instanceof JobSupport.Finishing;
    Object localObject2 = null;
    if (bool)
    {
      localObject1 = ((JobSupport.Finishing)localObject3).getRootCause();
    }
    else if ((localObject3 instanceof CompletedExceptionally))
    {
      localObject1 = ((CompletedExceptionally)localObject3).cause;
    }
    else
    {
      if ((localObject3 instanceof Incomplete)) {
        break label130;
      }
      localObject1 = null;
    }
    if ((localObject1 instanceof CancellationException)) {
      localObject2 = localObject1;
    }
    localObject2 = (CancellationException)localObject2;
    if (localObject2 != null) {
      return localObject2;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Parent job is ");
    ((StringBuilder)localObject2).append(stateString(localObject3));
    return (CancellationException)new JobCancellationException(((StringBuilder)localObject2).toString(), (Throwable)localObject1, (Job)this);
    label130:
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Cannot be cancelling child in this state: ");
    ((StringBuilder)localObject1).append(localObject3);
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject1).toString().toString()));
  }
  
  @NotNull
  public final Sequence<Job> getChildren()
  {
    return SequencesKt.sequence((Function2)new JobSupport.children.1(this, null));
  }
  
  @Nullable
  public final Object getCompletedInternal$kotlinx_coroutines_core()
  {
    Object localObject = getState$kotlinx_coroutines_core();
    int i;
    if (!(localObject instanceof Incomplete)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (!(localObject instanceof CompletedExceptionally)) {
        return JobSupportKt.unboxState(localObject);
      }
      throw ((CompletedExceptionally)localObject).cause;
    }
    throw ((Throwable)new IllegalStateException("This job has not completed yet".toString()));
  }
  
  @Nullable
  protected final Throwable getCompletionCause()
  {
    Object localObject = getState$kotlinx_coroutines_core();
    if ((localObject instanceof JobSupport.Finishing))
    {
      localObject = ((JobSupport.Finishing)localObject).getRootCause();
      if (localObject != null) {
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Job is still new or active: ");
      ((StringBuilder)localObject).append(this);
      throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
    }
    if (!(localObject instanceof Incomplete))
    {
      if ((localObject instanceof CompletedExceptionally)) {
        return ((CompletedExceptionally)localObject).cause;
      }
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Job is still new or active: ");
    ((StringBuilder)localObject).append(this);
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
  }
  
  protected final boolean getCompletionCauseHandled()
  {
    Object localObject = getState$kotlinx_coroutines_core();
    return ((localObject instanceof CompletedExceptionally)) && (((CompletedExceptionally)localObject).getHandled());
  }
  
  @Nullable
  public final Throwable getCompletionExceptionOrNull()
  {
    Object localObject = getState$kotlinx_coroutines_core();
    int i;
    if (!(localObject instanceof Incomplete)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return getExceptionOrNull(localObject);
    }
    throw ((Throwable)new IllegalStateException("This job has not completed yet".toString()));
  }
  
  public boolean getHandlesException$kotlinx_coroutines_core()
  {
    return true;
  }
  
  @NotNull
  public final CoroutineContext.Key<?> getKey()
  {
    return (CoroutineContext.Key)Job.Key;
  }
  
  public boolean getOnCancelComplete$kotlinx_coroutines_core()
  {
    return false;
  }
  
  @NotNull
  public final SelectClause0 getOnJoin()
  {
    return (SelectClause0)this;
  }
  
  @Nullable
  public final ChildHandle getParentHandle$kotlinx_coroutines_core()
  {
    return (ChildHandle)this._parentHandle;
  }
  
  @Nullable
  public final Object getState$kotlinx_coroutines_core()
  {
    for (;;)
    {
      Object localObject = this._state;
      if (!(localObject instanceof OpDescriptor)) {
        return localObject;
      }
      ((OpDescriptor)localObject).perform(this);
    }
  }
  
  protected boolean handleJobException(@NotNull Throwable paramThrowable)
  {
    return false;
  }
  
  public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable paramThrowable)
  {
    throw paramThrowable;
  }
  
  public final void initParentJobInternal$kotlinx_coroutines_core(@Nullable Job paramJob)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (getParentHandle$kotlinx_coroutines_core() == null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (paramJob == null)
    {
      setParentHandle$kotlinx_coroutines_core((ChildHandle)NonDisposableHandle.INSTANCE);
      return;
    }
    paramJob.start();
    paramJob = paramJob.attachChild((ChildJob)this);
    setParentHandle$kotlinx_coroutines_core(paramJob);
    if (isCompleted())
    {
      paramJob.dispose();
      setParentHandle$kotlinx_coroutines_core((ChildHandle)NonDisposableHandle.INSTANCE);
    }
  }
  
  @NotNull
  public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    return invokeOnCompletion(false, true, paramFunction1);
  }
  
  @NotNull
  public final DisposableHandle invokeOnCompletion(boolean paramBoolean1, boolean paramBoolean2, @NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    Object localObject4 = null;
    Object localObject1 = (JobNode)null;
    Object localObject5;
    NodeList localNodeList;
    for (;;)
    {
      localObject5 = getState$kotlinx_coroutines_core();
      if ((localObject5 instanceof Empty))
      {
        localObject2 = (Empty)localObject5;
        if (((Empty)localObject2).isActive())
        {
          if (localObject1 != null) {
            localObject2 = localObject1;
          } else {
            localObject2 = makeNode(paramFunction1, paramBoolean1);
          }
          localObject1 = localObject2;
          if (_state$FU.compareAndSet(this, localObject5, localObject2)) {
            return (DisposableHandle)localObject2;
          }
        }
        else
        {
          promoteEmptyToNodeList((Empty)localObject2);
        }
      }
      else
      {
        if (!(localObject5 instanceof Incomplete)) {
          break label384;
        }
        localNodeList = ((Incomplete)localObject5).getList();
        if (localNodeList != null) {
          break label144;
        }
        if (localObject5 == null) {
          break;
        }
        promoteSingleToNodeList((JobNode)localObject5);
      }
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
    label144:
    Throwable localThrowable2 = (Throwable)null;
    DisposableHandle localDisposableHandle = (DisposableHandle)NonDisposableHandle.INSTANCE;
    Object localObject3 = localObject1;
    Throwable localThrowable1 = localThrowable2;
    Object localObject2 = localDisposableHandle;
    if (paramBoolean1)
    {
      localObject3 = localObject1;
      localThrowable1 = localThrowable2;
      localObject2 = localDisposableHandle;
      if (!(localObject5 instanceof JobSupport.Finishing)) {}
    }
    for (;;)
    {
      try
      {
        localThrowable1 = ((JobSupport.Finishing)localObject5).getRootCause();
        if (localThrowable1 == null) {
          break label442;
        }
        localObject3 = localObject1;
        localObject2 = localDisposableHandle;
        if ((paramFunction1 instanceof ChildHandleNode))
        {
          localObject3 = localObject1;
          localObject2 = localDisposableHandle;
          if (!((JobSupport.Finishing)localObject5).isCompleting())
          {
            break label442;
            localObject1 = makeNode(paramFunction1, paramBoolean1);
            boolean bool = addLastAtomic(localObject5, localNodeList, (JobNode)localObject1);
            if (!bool) {
              break;
            }
            if (localThrowable1 == null)
            {
              paramFunction1 = (DisposableHandle)localObject1;
              return paramFunction1;
            }
            localObject2 = (DisposableHandle)localObject1;
            localObject3 = localObject1;
          }
        }
        localObject1 = Unit.INSTANCE;
      }
      finally {}
      if (localThrowable1 != null)
      {
        if (paramBoolean2) {
          paramFunction1.invoke(localThrowable1);
        }
        return localObject2;
      }
      if (localObject3 == null) {
        localObject3 = makeNode(paramFunction1, paramBoolean1);
      }
      localObject1 = localObject3;
      if (!addLastAtomic(localObject5, localNodeList, (JobNode)localObject3)) {
        break;
      }
      return (DisposableHandle)localObject3;
      label384:
      if (paramBoolean2)
      {
        localObject1 = localObject5;
        if (!(localObject5 instanceof CompletedExceptionally)) {
          localObject1 = null;
        }
        localObject2 = (CompletedExceptionally)localObject1;
        localObject1 = localObject4;
        if (localObject2 != null) {
          localObject1 = ((CompletedExceptionally)localObject2).cause;
        }
        paramFunction1.invoke(localObject1);
      }
      return (DisposableHandle)NonDisposableHandle.INSTANCE;
      label442:
      if (localObject1 == null) {}
    }
  }
  
  public boolean isActive()
  {
    Object localObject = getState$kotlinx_coroutines_core();
    return ((localObject instanceof Incomplete)) && (((Incomplete)localObject).isActive());
  }
  
  public final boolean isCancelled()
  {
    Object localObject = getState$kotlinx_coroutines_core();
    return ((localObject instanceof CompletedExceptionally)) || (((localObject instanceof JobSupport.Finishing)) && (((JobSupport.Finishing)localObject).isCancelling()));
  }
  
  public final boolean isCompleted()
  {
    return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
  }
  
  public final boolean isCompletedExceptionally()
  {
    return getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
  }
  
  protected boolean isScopedCoroutine()
  {
    return false;
  }
  
  @Nullable
  public final Object join(@NotNull Continuation<? super Unit> paramContinuation)
  {
    if (!joinInternal())
    {
      YieldKt.checkCompletion(paramContinuation.getContext());
      return Unit.INSTANCE;
    }
    paramContinuation = joinSuspend(paramContinuation);
    if (paramContinuation == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
      return paramContinuation;
    }
    return Unit.INSTANCE;
  }
  
  public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object paramObject)
  {
    Object localObject;
    do
    {
      localObject = tryMakeCompleting(getState$kotlinx_coroutines_core(), paramObject);
      if (localObject == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
        return false;
      }
      if (localObject == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
        return true;
      }
    } while (localObject == JobSupportKt.access$getCOMPLETING_RETRY$p());
    afterCompletion(localObject);
    return true;
  }
  
  @Nullable
  public final Object makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object paramObject)
  {
    do
    {
      localObject = tryMakeCompleting(getState$kotlinx_coroutines_core(), paramObject);
      if (localObject == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
        break;
      }
    } while (localObject == JobSupportKt.access$getCOMPLETING_RETRY$p());
    return localObject;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Job ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" is already complete or completing, ");
    ((StringBuilder)localObject).append("but is being completed with ");
    ((StringBuilder)localObject).append(paramObject);
    paramObject = (Throwable)new IllegalStateException(((StringBuilder)localObject).toString(), getExceptionOrNull(paramObject));
    for (;;)
    {
      throw paramObject;
    }
  }
  
  @NotNull
  public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey)
  {
    return Job.DefaultImpls.minusKey(this, paramKey);
  }
  
  @NotNull
  public String nameString$kotlinx_coroutines_core()
  {
    return DebugStringsKt.getClassSimpleName(this);
  }
  
  protected void onCancelling(@Nullable Throwable paramThrowable) {}
  
  protected void onCompletionInternal(@Nullable Object paramObject) {}
  
  public void onStartInternal$kotlinx_coroutines_core() {}
  
  public final void parentCancelled(@NotNull ParentJob paramParentJob)
  {
    cancelImpl$kotlinx_coroutines_core(paramParentJob);
  }
  
  @NotNull
  public CoroutineContext plus(@NotNull CoroutineContext paramCoroutineContext)
  {
    return Job.DefaultImpls.plus(this, paramCoroutineContext);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
  @NotNull
  public Job plus(@NotNull Job paramJob)
  {
    return Job.DefaultImpls.plus(this, paramJob);
  }
  
  public final <R> void registerSelectClause0(@NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> paramFunction1)
  {
    Object localObject;
    do
    {
      localObject = getState$kotlinx_coroutines_core();
      if (paramSelectInstance.isSelected()) {
        return;
      }
      if (!(localObject instanceof Incomplete))
      {
        if (paramSelectInstance.trySelect()) {
          UndispatchedKt.startCoroutineUnintercepted(paramFunction1, paramSelectInstance.getCompletion());
        }
        return;
      }
    } while (startInternal(localObject) != 0);
    paramSelectInstance.disposeOnSelect(invokeOnCompletion((Function1)new SelectJoinOnCompletion(this, paramSelectInstance, paramFunction1)));
  }
  
  public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    Object localObject;
    do
    {
      localObject = getState$kotlinx_coroutines_core();
      if (paramSelectInstance.isSelected()) {
        return;
      }
      if (!(localObject instanceof Incomplete))
      {
        if (paramSelectInstance.trySelect())
        {
          if ((localObject instanceof CompletedExceptionally))
          {
            paramSelectInstance.resumeSelectWithException(((CompletedExceptionally)localObject).cause);
            return;
          }
          UndispatchedKt.startCoroutineUnintercepted(paramFunction2, JobSupportKt.unboxState(localObject), paramSelectInstance.getCompletion());
        }
        return;
      }
    } while (startInternal(localObject) != 0);
    paramSelectInstance.disposeOnSelect(invokeOnCompletion((Function1)new SelectAwaitOnCompletion(this, paramSelectInstance, paramFunction2)));
  }
  
  public final void removeNode$kotlinx_coroutines_core(@NotNull JobNode<?> paramJobNode)
  {
    Object localObject;
    do
    {
      localObject = getState$kotlinx_coroutines_core();
      if (!(localObject instanceof JobNode)) {
        break;
      }
      if (localObject != paramJobNode) {
        return;
      }
    } while (!_state$FU.compareAndSet(this, localObject, JobSupportKt.access$getEMPTY_ACTIVE$p()));
    return;
    if (((localObject instanceof Incomplete)) && (((Incomplete)localObject).getList() != null)) {
      paramJobNode.remove();
    }
  }
  
  public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    Object localObject = getState$kotlinx_coroutines_core();
    if ((localObject instanceof CompletedExceptionally))
    {
      paramSelectInstance.resumeSelectWithException(((CompletedExceptionally)localObject).cause);
      return;
    }
    CancellableKt.startCoroutineCancellable(paramFunction2, JobSupportKt.unboxState(localObject), paramSelectInstance.getCompletion());
  }
  
  public final void setParentHandle$kotlinx_coroutines_core(@Nullable ChildHandle paramChildHandle)
  {
    this._parentHandle = paramChildHandle;
  }
  
  public final boolean start()
  {
    int i;
    do
    {
      i = startInternal(getState$kotlinx_coroutines_core());
      if (i == 0) {
        break;
      }
    } while (i != 1);
    return true;
    return false;
  }
  
  @NotNull
  protected final CancellationException toCancellationException(@NotNull Throwable paramThrowable, @Nullable String paramString)
  {
    if (!(paramThrowable instanceof CancellationException)) {
      localObject = null;
    } else {
      localObject = paramThrowable;
    }
    Object localObject = (CancellationException)localObject;
    if (localObject != null) {
      return localObject;
    }
    if (paramString == null) {
      paramString = access$cancellationExceptionMessage(this);
    }
    return (CancellationException)new JobCancellationException(paramString, paramThrowable, (Job)this);
  }
  
  @InternalCoroutinesApi
  @NotNull
  public final String toDebugString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(nameString$kotlinx_coroutines_core());
    localStringBuilder.append('{');
    localStringBuilder.append(stateString(getState$kotlinx_coroutines_core()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toDebugString());
    localStringBuilder.append('@');
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobSupport
 * JD-Core Version:    0.7.0.1
 */