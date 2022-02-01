package com.tencent.mobileqq.shortvideo;

import azpw;
import bcwx;
import bcxf;
import bcxn;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, bcxn parambcxn) {}
  
  public void run()
  {
    bcxf localbcxf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localbcxf.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_Bcxn))
    {
      localbcxf.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_Bcxn);
      localbcxf.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localbcxf.a.remove(this.jdField_a_of_type_Bcxn.a.jdField_a_of_type_JavaLangString);
      azpw.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_Bcxn.a.jdField_a_of_type_Long + ",curHandingNum:" + localbcxf.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */