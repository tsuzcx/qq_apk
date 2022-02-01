package com.tencent.mobileqq.danmaku.tool;

import com.tencent.mobileqq.danmaku.DanmakuDependImp;
import com.tencent.mobileqq.danmaku.IDanmakuDepend;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.util.Logger;
import java.util.Comparator;
import java.util.List;

public class SortedLinkedList<T>
{
  private int jdField_a_of_type_Int = 0;
  private final SortedLinkedList.Node<T> jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node;
  private final SortedLinkedList.TimeComparator jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$TimeComparator;
  private final Comparator<T> jdField_a_of_type_JavaUtilComparator;
  
  public SortedLinkedList(Comparator<T> paramComparator, SortedLinkedList.TimeComparator<T> paramTimeComparator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$TimeComparator = paramTimeComparator;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node = new SortedLinkedList.Node();
    this.jdField_a_of_type_JavaUtilComparator = paramComparator;
  }
  
  private void a(long paramLong, List<T> paramList, SortedLinkedList.Node<T> paramNode)
  {
    if ((DanmakuDependImp.a().a().a()) && ((paramList == null) || (paramList.isEmpty())) && (!a()) && ((paramNode.jdField_a_of_type_JavaLangObject instanceof BaseDanmaku)))
    {
      paramList = (BaseDanmaku)paramNode.jdField_a_of_type_JavaLangObject;
      long l = Math.abs(paramList.d() - paramLong);
      if (l > 60000L) {
        Logger.d("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + l + " , curTime = " + paramLong + ", curDanmaku = " + paramList);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.jdField_a_of_type_JavaLangObject;
  }
  
  public List<T> a(long paramLong, List<T> paramList, int paramInt)
  {
    SortedLinkedList.Node localNode = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node;
    int j;
    for (int i = 0; (i < paramInt) && (localNode != this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$TimeComparator.a(localNode.jdField_a_of_type_JavaLangObject, paramLong) <= 0); i = j)
    {
      j = i;
      if (paramList != null)
      {
        paramList.add(localNode.jdField_a_of_type_JavaLangObject);
        j = i + 1;
      }
      this.jdField_a_of_type_Int -= 1;
      localNode = localNode.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node;
    }
    a(paramLong, paramList, localNode);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node = localNode;
    localNode.b = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node;
    return paramList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.b = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node;
    this.jdField_a_of_type_Int = 0;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node == this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node;
  }
  
  public boolean a(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (SortedLinkedList.Node localNode = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.b; (localNode != this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node) && (this.jdField_a_of_type_JavaUtilComparator.compare(localNode.jdField_a_of_type_JavaLangObject, paramT) > 0); localNode = localNode.b) {}
    if (paramT.equals(localNode.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new SortedLinkedList.Node(paramT, localNode.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node, localNode);
    localNode.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.b = paramT;
    localNode.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
  
  public T b()
  {
    SortedLinkedList.Node localNode = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.b;
    if (localNode != this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node) {
      return localNode.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public boolean b(T paramT)
  {
    if (paramT == null) {
      return false;
    }
    for (SortedLinkedList.Node localNode = this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node; (localNode != this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node) && (this.jdField_a_of_type_JavaUtilComparator.compare(localNode.jdField_a_of_type_JavaLangObject, paramT) < 0); localNode = localNode.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node) {}
    if (paramT.equals(localNode.jdField_a_of_type_JavaLangObject)) {
      return false;
    }
    paramT = new SortedLinkedList.Node(paramT, localNode, localNode.b);
    localNode.b.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList$Node = paramT;
    localNode.b = paramT;
    this.jdField_a_of_type_Int += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.tool.SortedLinkedList
 * JD-Core Version:    0.7.0.1
 */