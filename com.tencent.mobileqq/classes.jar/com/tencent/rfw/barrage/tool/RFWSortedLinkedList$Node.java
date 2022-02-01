package com.tencent.rfw.barrage.tool;

final class RFWSortedLinkedList$Node<T>
{
  public final T a;
  public Node<T> b;
  public Node<T> c;
  
  public RFWSortedLinkedList$Node()
  {
    this.a = null;
    this.b = this;
    this.c = this;
  }
  
  public RFWSortedLinkedList$Node(T paramT, Node<T> paramNode1, Node<T> paramNode2)
  {
    this.a = paramT;
    this.b = paramNode1;
    this.c = paramNode2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rfw.barrage.tool.RFWSortedLinkedList.Node
 * JD-Core Version:    0.7.0.1
 */