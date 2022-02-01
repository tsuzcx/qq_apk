package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"}, k=1, mv={1, 1, 16})
public abstract class AtomicOp<T>
  extends OpDescriptor
{
  private static final AtomicReferenceFieldUpdater _consensus$FU = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
  private volatile Object _consensus = AtomicKt.access$getNO_DECISION$p();
  
  public abstract void complete(T paramT, @Nullable Object paramObject);
  
  @Nullable
  public final Object decide(@Nullable Object paramObject)
  {
    if (DebugKt.getASSERTIONS_ENABLED())
    {
      int i;
      if (paramObject != AtomicKt.access$getNO_DECISION$p()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    Object localObject = this._consensus;
    if (localObject != AtomicKt.access$getNO_DECISION$p()) {
      return localObject;
    }
    if (_consensus$FU.compareAndSet(this, AtomicKt.access$getNO_DECISION$p(), paramObject)) {
      return paramObject;
    }
    return this._consensus;
  }
  
  @NotNull
  public AtomicOp<?> getAtomicOp()
  {
    return this;
  }
  
  public long getOpSequence()
  {
    return 0L;
  }
  
  public final boolean isDecided()
  {
    return this._consensus != AtomicKt.access$getNO_DECISION$p();
  }
  
  @Nullable
  public final Object perform(@Nullable Object paramObject)
  {
    Object localObject2 = this._consensus;
    Object localObject1 = localObject2;
    if (localObject2 == AtomicKt.access$getNO_DECISION$p()) {
      localObject1 = decide(prepare(paramObject));
    }
    complete(paramObject, localObject1);
    return localObject1;
  }
  
  @Nullable
  public abstract Object prepare(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.AtomicOp
 * JD-Core Version:    0.7.0.1
 */