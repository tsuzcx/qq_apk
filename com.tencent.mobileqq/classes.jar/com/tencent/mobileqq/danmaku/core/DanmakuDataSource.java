package com.tencent.mobileqq.danmaku.core;

import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.mobileqq.danmaku.tool.PlayerTimer;
import com.tencent.mobileqq.danmaku.tool.SortedLinkedList;
import com.tencent.mobileqq.danmaku.util.Logger;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class DanmakuDataSource
{
  private volatile long jdField_a_of_type_Long = -1L;
  private final PlayerTimer jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer;
  private final SortedLinkedList<BaseDanmaku> jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList;
  private final List<BaseDanmaku> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public DanmakuDataSource(PlayerTimer paramPlayerTimer, DanmakuManager.DanmakuComparator paramDanmakuComparator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer = paramPlayerTimer;
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList = new SortedLinkedList(paramDanmakuComparator, new DanmakuDataSource.1(this));
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(List<BaseDanmaku> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)paramList.get(i);
      if (localBaseDanmaku.d() <= this.jdField_a_of_type_Long) {
        localBaseDanmaku.a();
      }
      i -= 1;
    }
  }
  
  private void c()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      Logger.b("DanmakuDataSource", "lock is blocked");
      Thread.yield();
    }
  }
  
  private void d()
  {
    while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false))
    {
      Logger.e("DanmakuDataSource", "update end is blocked! this can not happend!");
      Thread.yield();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList.a();
  }
  
  public BaseDanmaku a()
  {
    return (BaseDanmaku)this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList.a();
  }
  
  List<BaseDanmaku> a()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList.a(this.jdField_a_of_type_ComTencentMobileqqDanmakuToolPlayerTimer.a(), this.jdField_a_of_type_JavaUtilList, 3);
    a(this.jdField_a_of_type_JavaUtilList);
    d();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    Logger.a("DanmakuDataSource", "clear danmaku queue");
    c();
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList.a();
    d();
  }
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    c();
    Logger.c("DanmakuDataSource", "addNow: danmaku = " + paramBaseDanmaku);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList.b(paramBaseDanmaku);
    d();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList.a() > 0)) {
      return true;
    }
    return false;
  }
  
  public void b()
  {
    c();
    BaseDanmaku localBaseDanmaku = (BaseDanmaku)this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList.b();
    if (localBaseDanmaku == null) {}
    for (this.jdField_a_of_type_Long = -1L;; this.jdField_a_of_type_Long = localBaseDanmaku.d())
    {
      d();
      return;
    }
  }
  
  public void b(BaseDanmaku paramBaseDanmaku)
  {
    c();
    Logger.c("DanmakuDataSource", "addLast: danmaku = " + paramBaseDanmaku);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuToolSortedLinkedList.a(paramBaseDanmaku);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.core.DanmakuDataSource
 * JD-Core Version:    0.7.0.1
 */