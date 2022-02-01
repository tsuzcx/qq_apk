package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/sequences/Sequence;)V", "sequenceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ConstrainedOnceSequence<T>
  implements Sequence<T>
{
  private final AtomicReference<Sequence<T>> sequenceRef;
  
  public ConstrainedOnceSequence(@NotNull Sequence<? extends T> paramSequence)
  {
    this.sequenceRef = new AtomicReference(paramSequence);
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    Sequence localSequence = (Sequence)this.sequenceRef.getAndSet(null);
    if (localSequence != null) {
      return localSequence.iterator();
    }
    throw ((Throwable)new IllegalStateException("This sequence can be consumed only once."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.sequences.ConstrainedOnceSequence
 * JD-Core Version:    0.7.0.1
 */