package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class RopeByteString
  extends ByteString
{
  private static final int[] minLengthByDepth;
  private int hash = 0;
  private final ByteString left;
  private final int leftLength;
  private final ByteString right;
  private final int totalLength;
  private final int treeDepth;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    int j = 1;
    for (;;)
    {
      int k = j;
      if (i <= 0) {
        break;
      }
      localArrayList.add(Integer.valueOf(i));
      j = i;
      i = k + i;
    }
    localArrayList.add(Integer.valueOf(2147483647));
    minLengthByDepth = new int[localArrayList.size()];
    i = 0;
    for (;;)
    {
      int[] arrayOfInt = minLengthByDepth;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
  }
  
  private RopeByteString(ByteString paramByteString1, ByteString paramByteString2)
  {
    this.left = paramByteString1;
    this.right = paramByteString2;
    this.leftLength = paramByteString1.size();
    this.totalLength = (this.leftLength + paramByteString2.size());
    this.treeDepth = (Math.max(paramByteString1.getTreeDepth(), paramByteString2.getTreeDepth()) + 1);
  }
  
  static ByteString concatenate(ByteString paramByteString1, ByteString paramByteString2)
  {
    RopeByteString localRopeByteString;
    if ((paramByteString1 instanceof RopeByteString)) {
      localRopeByteString = (RopeByteString)paramByteString1;
    } else {
      localRopeByteString = null;
    }
    if (paramByteString2.size() == 0) {
      return paramByteString1;
    }
    if (paramByteString1.size() == 0) {}
    int i;
    for (;;)
    {
      return paramByteString2;
      i = paramByteString1.size() + paramByteString2.size();
      if (i < 128) {
        return concatenateBytes(paramByteString1, paramByteString2);
      }
      if ((localRopeByteString != null) && (localRopeByteString.right.size() + paramByteString2.size() < 128))
      {
        paramByteString1 = concatenateBytes(localRopeByteString.right, paramByteString2);
        paramByteString2 = new RopeByteString(localRopeByteString.left, paramByteString1);
      }
      else
      {
        if ((localRopeByteString == null) || (localRopeByteString.left.getTreeDepth() <= localRopeByteString.right.getTreeDepth()) || (localRopeByteString.getTreeDepth() <= paramByteString2.getTreeDepth())) {
          break;
        }
        paramByteString1 = new RopeByteString(localRopeByteString.right, paramByteString2);
        paramByteString2 = new RopeByteString(localRopeByteString.left, paramByteString1);
      }
    }
    int j = Math.max(paramByteString1.getTreeDepth(), paramByteString2.getTreeDepth());
    if (i >= minLengthByDepth[(j + 1)]) {
      return new RopeByteString(paramByteString1, paramByteString2);
    }
    return RopeByteString.Balancer.access$100(new RopeByteString.Balancer(null), paramByteString1, paramByteString2);
  }
  
  private static LiteralByteString concatenateBytes(ByteString paramByteString1, ByteString paramByteString2)
  {
    int i = paramByteString1.size();
    int j = paramByteString2.size();
    byte[] arrayOfByte = new byte[i + j];
    paramByteString1.copyTo(arrayOfByte, 0, 0, i);
    paramByteString2.copyTo(arrayOfByte, 0, i, j);
    return new LiteralByteString(arrayOfByte);
  }
  
  private boolean equalsFragments(ByteString paramByteString)
  {
    RopeByteString.PieceIterator localPieceIterator1 = new RopeByteString.PieceIterator(this, null);
    LiteralByteString localLiteralByteString = (LiteralByteString)localPieceIterator1.next();
    RopeByteString.PieceIterator localPieceIterator2 = new RopeByteString.PieceIterator(paramByteString, null);
    paramByteString = (LiteralByteString)localPieceIterator2.next();
    int j = 0;
    int i = 0;
    int k = 0;
    for (;;)
    {
      int i1 = localLiteralByteString.size() - j;
      int m = paramByteString.size() - i;
      int n = Math.min(i1, m);
      boolean bool;
      if (j == 0) {
        bool = localLiteralByteString.equalsRange(paramByteString, i, n);
      } else {
        bool = paramByteString.equalsRange(localLiteralByteString, j, n);
      }
      if (!bool) {
        return false;
      }
      k += n;
      int i2 = this.totalLength;
      if (k >= i2)
      {
        if (k == i2) {
          return true;
        }
        throw new IllegalStateException();
      }
      if (n == i1)
      {
        localLiteralByteString = (LiteralByteString)localPieceIterator1.next();
        j = 0;
      }
      else
      {
        j += n;
      }
      if (n == m)
      {
        paramByteString = (LiteralByteString)localPieceIterator2.next();
        i = 0;
      }
      else
      {
        i += n;
      }
    }
  }
  
  protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.leftLength;
    if (paramInt1 + paramInt3 <= i)
    {
      this.left.copyToInternal(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return;
    }
    if (paramInt1 >= i)
    {
      this.right.copyToInternal(paramArrayOfByte, paramInt1 - i, paramInt2, paramInt3);
      return;
    }
    i -= paramInt1;
    this.left.copyToInternal(paramArrayOfByte, paramInt1, paramInt2, i);
    this.right.copyToInternal(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ByteString)) {
      return false;
    }
    paramObject = (ByteString)paramObject;
    if (this.totalLength != paramObject.size()) {
      return false;
    }
    if (this.totalLength == 0) {
      return true;
    }
    if (this.hash != 0)
    {
      int i = paramObject.peekCachedHashCode();
      if ((i != 0) && (this.hash != i)) {
        return false;
      }
    }
    return equalsFragments(paramObject);
  }
  
  protected int getTreeDepth()
  {
    return this.treeDepth;
  }
  
  public int hashCode()
  {
    int j = this.hash;
    int i = j;
    if (j == 0)
    {
      i = this.totalLength;
      j = partialHash(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.hash = i;
    }
    return i;
  }
  
  protected boolean isBalanced()
  {
    return this.totalLength >= minLengthByDepth[this.treeDepth];
  }
  
  public boolean isValidUtf8()
  {
    ByteString localByteString = this.left;
    int i = this.leftLength;
    boolean bool = false;
    i = localByteString.partialIsValidUtf8(0, 0, i);
    localByteString = this.right;
    if (localByteString.partialIsValidUtf8(i, 0, localByteString.size()) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public ByteString.ByteIterator iterator()
  {
    return new RopeByteString.RopeByteIterator(this, null);
  }
  
  public CodedInputStream newCodedInput()
  {
    return CodedInputStream.newInstance(new RopeByteString.RopeInputStream(this));
  }
  
  protected int partialHash(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.leftLength;
    if (paramInt2 + paramInt3 <= i) {
      return this.left.partialHash(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= i) {
      return this.right.partialHash(paramInt1, paramInt2 - i, paramInt3);
    }
    i -= paramInt2;
    paramInt1 = this.left.partialHash(paramInt1, paramInt2, i);
    return this.right.partialHash(paramInt1, 0, paramInt3 - i);
  }
  
  protected int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.leftLength;
    if (paramInt2 + paramInt3 <= i) {
      return this.left.partialIsValidUtf8(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= i) {
      return this.right.partialIsValidUtf8(paramInt1, paramInt2 - i, paramInt3);
    }
    i -= paramInt2;
    paramInt1 = this.left.partialIsValidUtf8(paramInt1, paramInt2, i);
    return this.right.partialIsValidUtf8(paramInt1, 0, paramInt3 - i);
  }
  
  protected int peekCachedHashCode()
  {
    return this.hash;
  }
  
  public int size()
  {
    return this.totalLength;
  }
  
  public String toString(String paramString)
  {
    return new String(toByteArray(), paramString);
  }
  
  void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    int i = this.leftLength;
    if (paramInt1 + paramInt2 <= i)
    {
      this.left.writeToInternal(paramOutputStream, paramInt1, paramInt2);
      return;
    }
    if (paramInt1 >= i)
    {
      this.right.writeToInternal(paramOutputStream, paramInt1 - i, paramInt2);
      return;
    }
    i -= paramInt1;
    this.left.writeToInternal(paramOutputStream, paramInt1, i);
    this.right.writeToInternal(paramOutputStream, 0, paramInt2 - i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.RopeByteString
 * JD-Core Version:    0.7.0.1
 */