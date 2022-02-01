package com.tencent.mobileqq.dinifly.parser.moshi;

final class LinkedHashTreeMap$AvlBuilder<K, V>
{
  private int leavesSkipped;
  private int leavesToSkip;
  private int size;
  private LinkedHashTreeMap.Node<K, V> stack;
  
  void add(LinkedHashTreeMap.Node<K, V> paramNode)
  {
    paramNode.right = null;
    paramNode.parent = null;
    paramNode.left = null;
    paramNode.height = 1;
    int i = this.leavesToSkip;
    int j;
    if (i > 0)
    {
      j = this.size;
      if ((j & 0x1) == 0)
      {
        this.size = (j + 1);
        this.leavesToSkip = (i - 1);
        this.leavesSkipped += 1;
      }
    }
    paramNode.parent = this.stack;
    this.stack = paramNode;
    this.size += 1;
    i = this.leavesToSkip;
    if (i > 0)
    {
      j = this.size;
      if ((j & 0x1) == 0)
      {
        this.size = (j + 1);
        this.leavesToSkip = (i - 1);
        this.leavesSkipped += 1;
      }
    }
    i = 4;
    for (;;)
    {
      j = this.size;
      int k = i - 1;
      if ((j & k) != k) {
        break;
      }
      j = this.leavesSkipped;
      LinkedHashTreeMap.Node localNode1;
      if (j == 0)
      {
        paramNode = this.stack;
        localNode1 = paramNode.parent;
        LinkedHashTreeMap.Node localNode2 = localNode1.parent;
        localNode1.parent = localNode2.parent;
        this.stack = localNode1;
        localNode1.left = localNode2;
        localNode1.right = paramNode;
        paramNode.height += 1;
        localNode2.parent = localNode1;
        paramNode.parent = localNode1;
      }
      else if (j == 1)
      {
        paramNode = this.stack;
        localNode1 = paramNode.parent;
        this.stack = localNode1;
        localNode1.right = paramNode;
        paramNode.height += 1;
        paramNode.parent = localNode1;
        this.leavesSkipped = 0;
      }
      else if (j == 2)
      {
        this.leavesSkipped = 0;
      }
      i *= 2;
    }
  }
  
  void reset(int paramInt)
  {
    this.leavesToSkip = (Integer.highestOneBit(paramInt) * 2 - 1 - paramInt);
    this.size = 0;
    this.leavesSkipped = 0;
    this.stack = null;
  }
  
  LinkedHashTreeMap.Node<K, V> root()
  {
    LinkedHashTreeMap.Node localNode = this.stack;
    if (localNode.parent == null) {
      return localNode;
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.moshi.LinkedHashTreeMap.AvlBuilder
 * JD-Core Version:    0.7.0.1
 */