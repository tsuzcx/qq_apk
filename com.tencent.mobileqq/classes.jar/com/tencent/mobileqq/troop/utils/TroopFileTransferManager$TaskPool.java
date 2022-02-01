package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopFileTransferManager$TaskPool
{
  public int a;
  public LinkedList<TroopFileTransferManager.Task> a;
  public AtomicInteger a;
  
  public TroopFileTransferManager$TaskPool(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(TroopFileTransferManager.Task paramTask)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramTask);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet() > this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        return;
      }
      ThreadManager.post(new TroopFileTransferManager.TaskPool.1(this), 5, null, true);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool
 * JD-Core Version:    0.7.0.1
 */