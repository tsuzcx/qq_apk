package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.OpDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "impl", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;)V", "opSequence", "", "getOpSequence", "()J", "complete", "", "affected", "failure", "completeSelect", "prepare", "prepareSelectOp", "toString", "", "undoPrepare", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class SelectBuilderImpl$AtomicSelectOp
  extends AtomicOp<Object>
{
  @JvmField
  @NotNull
  public final AtomicDesc desc;
  @JvmField
  @NotNull
  public final SelectBuilderImpl<?> impl;
  private final long opSequence;
  
  public SelectBuilderImpl$AtomicSelectOp(@NotNull SelectBuilderImpl<?> paramSelectBuilderImpl, @NotNull AtomicDesc paramAtomicDesc)
  {
    this.impl = paramSelectBuilderImpl;
    this.desc = paramAtomicDesc;
    this.opSequence = SelectKt.access$getSelectOpSequenceNumber$p().next();
    this.desc.setAtomicOp((AtomicOp)this);
  }
  
  private final void completeSelect(Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramObject = null;
    } else {
      paramObject = this.impl;
    }
    SelectBuilderImpl localSelectBuilderImpl = this.impl;
    if ((SelectBuilderImpl._state$FU.compareAndSet(localSelectBuilderImpl, this, paramObject)) && (i != 0)) {
      SelectBuilderImpl.access$doAfterSelect(this.impl);
    }
  }
  
  private final Object prepareSelectOp()
  {
    SelectBuilderImpl localSelectBuilderImpl1 = this.impl;
    SelectBuilderImpl localSelectBuilderImpl2;
    do
    {
      Object localObject;
      for (;;)
      {
        localObject = localSelectBuilderImpl1._state;
        if (localObject == (AtomicSelectOp)this) {
          return null;
        }
        if (!(localObject instanceof OpDescriptor)) {
          break;
        }
        ((OpDescriptor)localObject).perform(this.impl);
      }
      localSelectBuilderImpl2 = this.impl;
      if (localObject != localSelectBuilderImpl2) {
        break;
      }
    } while (!SelectBuilderImpl._state$FU.compareAndSet(localSelectBuilderImpl2, this.impl, this));
    return null;
    return SelectKt.getALREADY_SELECTED();
  }
  
  private final void undoPrepare()
  {
    SelectBuilderImpl localSelectBuilderImpl = this.impl;
    SelectBuilderImpl._state$FU.compareAndSet(localSelectBuilderImpl, this, this.impl);
  }
  
  public void complete(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    completeSelect(paramObject2);
    this.desc.complete((AtomicOp)this, paramObject2);
  }
  
  public long getOpSequence()
  {
    return this.opSequence;
  }
  
  @Nullable
  public Object prepare(@Nullable Object paramObject)
  {
    Object localObject;
    if (paramObject == null)
    {
      localObject = prepareSelectOp();
      if (localObject != null) {
        return localObject;
      }
    }
    try
    {
      localObject = this.desc.prepare((AtomicOp)this);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      if (paramObject == null) {
        undoPrepare();
      }
      throw localThrowable;
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AtomicSelectOp(sequence=");
    localStringBuilder.append(getOpSequence());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectBuilderImpl.AtomicSelectOp
 * JD-Core Version:    0.7.0.1
 */