package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Arrays;
import java.util.Stack;

class RopeByteString$Balancer
{
  private final Stack<ByteString> prefixesStack = new Stack();
  
  private ByteString balance(ByteString paramByteString1, ByteString paramByteString2)
  {
    doBalance(paramByteString1);
    doBalance(paramByteString2);
    for (paramByteString1 = (ByteString)this.prefixesStack.pop(); !this.prefixesStack.isEmpty(); paramByteString1 = new RopeByteString((ByteString)this.prefixesStack.pop(), paramByteString1, null)) {}
    return paramByteString1;
  }
  
  private void doBalance(ByteString paramByteString)
  {
    if (paramByteString.isBalanced())
    {
      insert(paramByteString);
      return;
    }
    if ((paramByteString instanceof RopeByteString))
    {
      paramByteString = (RopeByteString)paramByteString;
      doBalance(RopeByteString.access$400(paramByteString));
      doBalance(RopeByteString.access$500(paramByteString));
      return;
    }
    paramByteString = String.valueOf(String.valueOf(paramByteString.getClass()));
    StringBuilder localStringBuilder = new StringBuilder(paramByteString.length() + 49);
    localStringBuilder.append("Has a new type of ByteString been created? Found ");
    localStringBuilder.append(paramByteString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private int getDepthBinForLength(int paramInt)
  {
    int i = Arrays.binarySearch(RopeByteString.access$600(), paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    return paramInt;
  }
  
  private void insert(ByteString paramByteString)
  {
    int i = getDepthBinForLength(paramByteString.size());
    int j = RopeByteString.access$600()[(i + 1)];
    if ((!this.prefixesStack.isEmpty()) && (((ByteString)this.prefixesStack.peek()).size() < j))
    {
      i = RopeByteString.access$600()[i];
      for (Object localObject = (ByteString)this.prefixesStack.pop(); (!this.prefixesStack.isEmpty()) && (((ByteString)this.prefixesStack.peek()).size() < i); localObject = new RopeByteString((ByteString)this.prefixesStack.pop(), (ByteString)localObject, null)) {}
      for (paramByteString = new RopeByteString((ByteString)localObject, paramByteString, null); !this.prefixesStack.isEmpty(); paramByteString = new RopeByteString((ByteString)this.prefixesStack.pop(), paramByteString, null))
      {
        i = getDepthBinForLength(paramByteString.size());
        i = RopeByteString.access$600()[(i + 1)];
        if (((ByteString)this.prefixesStack.peek()).size() >= i) {
          break;
        }
      }
      this.prefixesStack.push(paramByteString);
      return;
    }
    this.prefixesStack.push(paramByteString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.RopeByteString.Balancer
 * JD-Core Version:    0.7.0.1
 */