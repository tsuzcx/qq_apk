package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/io/LinesSequence$iterator$1", "", "", "done", "", "nextValue", "hasNext", "next", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class LinesSequence$iterator$1
  implements Iterator<String>, KMappedMarker
{
  private boolean done;
  private String nextValue;
  
  public boolean hasNext()
  {
    if ((this.nextValue == null) && (!this.done))
    {
      this.nextValue = LinesSequence.access$getReader$p(this.this$0).readLine();
      if (this.nextValue == null) {
        this.done = true;
      }
    }
    return this.nextValue != null;
  }
  
  @NotNull
  public String next()
  {
    if (hasNext())
    {
      String str = this.nextValue;
      this.nextValue = ((String)null);
      if (str == null) {
        Intrinsics.throwNpe();
      }
      return str;
    }
    throw ((Throwable)new NoSuchElementException());
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.LinesSequence.iterator.1
 * JD-Core Version:    0.7.0.1
 */