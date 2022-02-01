package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/LinkedListChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "()V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class LinkedListChannel<E>
  extends AbstractChannel<E>
{
  protected final boolean isBufferAlwaysEmpty()
  {
    return true;
  }
  
  protected final boolean isBufferAlwaysFull()
  {
    return false;
  }
  
  protected final boolean isBufferEmpty()
  {
    return true;
  }
  
  protected final boolean isBufferFull()
  {
    return false;
  }
  
  @NotNull
  protected Object offerInternal(E paramE)
  {
    Object localObject;
    do
    {
      localObject = super.offerInternal(paramE);
      if (localObject == AbstractChannelKt.OFFER_SUCCESS) {
        return AbstractChannelKt.OFFER_SUCCESS;
      }
      if (localObject != AbstractChannelKt.OFFER_FAILED) {
        break;
      }
      localObject = sendBuffered(paramE);
      if (localObject == null) {
        return AbstractChannelKt.OFFER_SUCCESS;
      }
    } while (!(localObject instanceof Closed));
    return localObject;
    if ((localObject instanceof Closed)) {
      return localObject;
    }
    paramE = new StringBuilder();
    paramE.append("Invalid offerInternal result ");
    paramE.append(localObject);
    paramE = (Throwable)new IllegalStateException(paramE.toString().toString());
    for (;;)
    {
      throw paramE;
    }
  }
  
  @NotNull
  protected Object offerSelectInternal(E paramE, @NotNull SelectInstance<?> paramSelectInstance)
  {
    Object localObject;
    do
    {
      if (getHasReceiveOrClosed())
      {
        localObject = super.offerSelectInternal(paramE, paramSelectInstance);
      }
      else
      {
        localObject = paramSelectInstance.performAtomicTrySelect((AtomicDesc)describeSendBuffered(paramE));
        if (localObject == null) {
          localObject = AbstractChannelKt.OFFER_SUCCESS;
        }
      }
      if (localObject == SelectKt.getALREADY_SELECTED()) {
        return SelectKt.getALREADY_SELECTED();
      }
      if (localObject == AbstractChannelKt.OFFER_SUCCESS) {
        return AbstractChannelKt.OFFER_SUCCESS;
      }
    } while ((localObject == AbstractChannelKt.OFFER_FAILED) || (localObject == AtomicKt.RETRY_ATOMIC));
    if ((localObject instanceof Closed)) {
      return localObject;
    }
    paramE = new StringBuilder();
    paramE.append("Invalid result ");
    paramE.append(localObject);
    paramE = (Throwable)new IllegalStateException(paramE.toString().toString());
    for (;;)
    {
      throw paramE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.LinkedListChannel
 * JD-Core Version:    0.7.0.1
 */