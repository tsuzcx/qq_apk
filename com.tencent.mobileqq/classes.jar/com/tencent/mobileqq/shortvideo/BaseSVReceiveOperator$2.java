package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.Logger;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseSVReceiveOperator$2
  implements Runnable
{
  BaseSVReceiveOperator$2(BaseQQAppInterface paramBaseQQAppInterface, ShortVideoReq paramShortVideoReq) {}
  
  public void run()
  {
    ShortVideoPreDownloader localShortVideoPreDownloader = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).getShortVideoPredownloer();
    if (localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.contains(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq))
    {
      localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
      localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
      localShortVideoPreDownloader.a.remove(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uniseq:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.jdField_a_of_type_Long);
      localStringBuilder.append(",curHandingNum:");
      localStringBuilder.append(localShortVideoPreDownloader.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      Logger.a("PIC_TAG_PRELOAD", "onDownload", localStringBuilder.toString());
      ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).getShortVideoPredownloer().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseSVReceiveOperator.2
 * JD-Core Version:    0.7.0.1
 */