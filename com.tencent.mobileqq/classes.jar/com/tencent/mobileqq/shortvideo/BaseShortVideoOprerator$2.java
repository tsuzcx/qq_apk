package com.tencent.mobileqq.shortvideo;

import ayxi;
import bcef;
import bcen;
import bcev;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, bcev parambcev) {}
  
  public void run()
  {
    bcen localbcen = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localbcen.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_Bcev))
    {
      localbcen.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_Bcev);
      localbcen.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localbcen.a.remove(this.jdField_a_of_type_Bcev.a.jdField_a_of_type_JavaLangString);
      ayxi.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_Bcev.a.jdField_a_of_type_Long + ",curHandingNum:" + localbcen.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */