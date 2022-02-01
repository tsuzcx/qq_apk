package com.tencent.mobileqq.danmaku.tool;

final class SortedLinkedList$Node<T>
{
  public Node<T> a;
  public final T a;
  public Node<T> b;
  
  public SortedLinkedList$Node()
  {
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node = this;
    this.b = this;
  }
  
  public SortedLinkedList$Node(T paramT, Node<T> paramNode1, Node<T> paramNode2)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node = paramNode1;
    this.b = paramNode2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.tool.SortedLinkedList.Node
 * JD-Core Version:    0.7.0.1
 */