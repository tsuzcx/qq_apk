package com.tencent.mobileqq.shortvideo;

import ayde;
import bbqh;
import bbqp;
import bbqx;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, bbqx parambbqx) {}
  
  public void run()
  {
    bbqp localbbqp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer();
    if (localbbqp.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_Bbqx))
    {
      localbbqp.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_Bbqx);
      localbbqp.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localbbqp.a.remove(this.jdField_a_of_type_Bbqx.a.jdField_a_of_type_JavaLangString);
      ayde.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_Bbqx.a.jdField_a_of_type_Long + ",curHandingNum:" + localbbqp.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */