package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/selects/SeqNumber;", "<init>", "()V", "", "next", "()J", "kotlinx-coroutines-core", ""}, k=1, mv={1, 1, 16})
public final class SeqNumber
{
  private static final AtomicLongFieldUpdater number$FU = AtomicLongFieldUpdater.newUpdater(SeqNumber.class, "number");
  private volatile long number = 1L;
  
  public final long next()
  {
    return number$FU.incrementAndGet(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SeqNumber
 * JD-Core Version:    0.7.0.1
 */