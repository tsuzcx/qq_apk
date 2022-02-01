package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.Logger;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseShortVideoOprerator$2
  implements Runnable
{
  BaseShortVideoOprerator$2(QQAppInterface paramQQAppInterface, ShortVideoReq paramShortVideoReq) {}
  
  public void run()
  {
    ShortVideoPreDownloader localShortVideoPreDownloader = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer();
    if (localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq))
    {
      localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
      localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localShortVideoPreDownloader.a.remove(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_JavaLangString);
      Logger.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_Long + ",curHandingNum:" + localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.2
 * JD-Core Version:    0.7.0.1
 */