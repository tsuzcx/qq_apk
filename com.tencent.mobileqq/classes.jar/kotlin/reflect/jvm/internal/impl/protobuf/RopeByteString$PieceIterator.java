package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class RopeByteString$PieceIterator
  implements Iterator<LiteralByteString>
{
  private final Stack<RopeByteString> breadCrumbs = new Stack();
  private LiteralByteString next = getLeafByLeft(paramByteString);
  
  private RopeByteString$PieceIterator(ByteString paramByteString) {}
  
  private LiteralByteString getLeafByLeft(ByteString paramByteString)
  {
    while ((paramByteString instanceof RopeByteString))
    {
      paramByteString = (RopeByteString)paramByteString;
      this.breadCrumbs.push(paramByteString);
      paramByteString = RopeByteString.access$400(paramByteString);
    }
    return (LiteralByteString)paramByteString;
  }
  
  private LiteralByteString getNextNonEmptyLeaf()
  {
    LiteralByteString localLiteralByteString;
    do
    {
      if (this.breadCrumbs.isEmpty()) {
        return null;
      }
      localLiteralByteString = getLeafByLeft(RopeByteString.access$500((RopeByteString)this.breadCrumbs.pop()));
    } while (localLiteralByteString.isEmpty());
    return localLiteralByteString;
  }
  
  public boolean hasNext()
  {
    return this.next != null;
  }
  
  public LiteralByteString next()
  {
    LiteralByteString localLiteralByteString = this.next;
    if (localLiteralByteString != null)
    {
      this.next = getNextNonEmptyLeaf();
      return localLiteralByteString;
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.RopeByteString.PieceIterator
 * JD-Core Version:    0.7.0.1
 */