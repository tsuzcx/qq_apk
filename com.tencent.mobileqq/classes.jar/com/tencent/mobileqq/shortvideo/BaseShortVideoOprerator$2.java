package com.tencent.mobileqq.shortvideo;

import awiw;
import azdg;
import azdo;
import azdx;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, azdx paramazdx) {}
  
  public void run()
  {
    azdo localazdo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localazdo.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_Azdx))
    {
      localazdo.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_Azdx);
      localazdo.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localazdo.a.remove(this.jdField_a_of_type_Azdx.a.jdField_a_of_type_JavaLangString);
      awiw.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_Azdx.a.jdField_a_of_type_Long + ",curHandingNum:" + localazdo.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */