package kotlinx.coroutines.channels;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/RendezvousChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "()V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public class RendezvousChannel<E>
  extends AbstractChannel<E>
{
  protected final boolean isBufferAlwaysEmpty()
  {
    return true;
  }
  
  protected final boolean isBufferAlwaysFull()
  {
    return true;
  }
  
  protected final boolean isBufferEmpty()
  {
    return true;
  }
  
  protected final boolean isBufferFull()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.RendezvousChannel
 * JD-Core Version:    0.7.0.1
 */