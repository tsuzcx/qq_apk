package kotlin.io;

import java.io.BufferedInputStream;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/io/ByteStreamsKt$iterator$1", "Lkotlin/collections/ByteIterator;", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "nextByte", "", "getNextByte", "()I", "setNextByte", "(I)V", "nextPrepared", "getNextPrepared", "setNextPrepared", "hasNext", "", "prepareNext", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ByteStreamsKt$iterator$1
  extends ByteIterator
{
  private boolean finished;
  private int nextByte = -1;
  private boolean nextPrepared;
  
  ByteStreamsKt$iterator$1(BufferedInputStream paramBufferedInputStream) {}
  
  private final void prepareNext()
  {
    if ((!this.nextPrepared) && (!this.finished))
    {
      this.nextByte = this.$this_iterator.read();
      boolean bool = true;
      this.nextPrepared = true;
      if (this.nextByte != -1) {
        bool = false;
      }
      this.finished = bool;
    }
  }
  
  public final boolean getFinished()
  {
    return this.finished;
  }
  
  public final int getNextByte()
  {
    return this.nextByte;
  }
  
  public final boolean getNextPrepared()
  {
    return this.nextPrepared;
  }
  
  public boolean hasNext()
  {
    prepareNext();
    return this.finished ^ true;
  }
  
  public byte nextByte()
  {
    prepareNext();
    if (!this.finished)
    {
      byte b = (byte)this.nextByte;
      this.nextPrepared = false;
      return b;
    }
    throw ((Throwable)new NoSuchElementException("Input stream is over."));
  }
  
  public final void setFinished(boolean paramBoolean)
  {
    this.finished = paramBoolean;
  }
  
  public final void setNextByte(int paramInt)
  {
    this.nextByte = paramInt;
  }
  
  public final void setNextPrepared(boolean paramBoolean)
  {
    this.nextPrepared = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.ByteStreamsKt.iterator.1
 * JD-Core Version:    0.7.0.1
 */