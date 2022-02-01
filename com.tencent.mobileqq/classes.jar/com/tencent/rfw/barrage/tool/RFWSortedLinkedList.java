package com.tencent.rfw.barrage.tool;

import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.util.RFWQQUtils;
import java.util.Comparator;
import java.util.List;

public class RFWSortedLinkedList<T>
{
  private final RFWSortedLinkedList.Node<T> a;
  private final Comparator<T> b;
  private final RFWSortedLinkedList.TimeComparator c;
  private int d = 0;
  
  public RFWSortedLinkedList(Comparator<T> paramComparator, RFWSortedLinkedList.TimeComparator<T> paramTimeComparator)
  {
    this.c = paramTimeComparator;
    this.a = new RFWSortedLinkedList.Node();
    this.b = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, RFWSortedLinkedList.Node<T> paramNode)
  {
    if (!RFWQQUtils.b()) {
      return;
    }
    if (((paramList == null) || (paramList.isEmpty())) && (!b()) && ((paramNode.a instanceof RFWBaseBarrage))) {
      Math.abs(((RFWBaseBarrage)paramNode.a).x() - paramLong);
    }
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    RFWSortedLinkedList.Node localNode1 = this.a.b;
    int j;
    for (int i = 0; (i < paramInt) && (localNode1 != this.a) && (this.c.a(localNode1.a, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localNode1.a);
        j = i + 1;
      }
      this.d -= 1;
      localNode1 = localNode1.b;
    }
    a(paramLong, paramList, localNode1);
    RFWSortedLinkedList.Node localNode2 = this.a;
    localNode2.b = localNode1;
    localNode1.c = localNode2;
    return paramList;
  }
  
  public void a()
  {
    RFWSortedLinkedList.Node localNode = this.a;
    localNode.b = localNode;
    localNode.c = localNode;
    this.d = 0;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (RFWSortedLinkedList.Node localNode = this.a.c; (localNode != this.a) && (this.b.compare(localNode.a, paramT) > 0); localNode = localNode.c) {}
    if (paramT.equals(localNode.a)) {
      return false;
    }
    paramT = new RFWSortedLinkedList.Node(paramT, localNode.b, localNode);
    localNode.b.c = paramT;
    localNode.b = paramT;
    this.d += 1;
    return true;
  }
  
  public boolean b()
  {
    return this.a.b == this.a;
  }
  
  public T c()
  {
    RFWSortedLinkedList.Node localNode = this.a.c;
    if (localNode != this.a) {
      return localNode.a;
    }
    return null;
  }
  
  public int d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.tool.RFWSortedLinkedList
 * JD-Core Version:    0.7.0.1
 */