package com.tencent.mobileqq.pic.operator;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import java.io.File;

class DownloadPicOperator$1
  implements Runnable
{
  DownloadPicOperator$1(DownloadPicOperator paramDownloadPicOperator, DownCallBack.DownResult paramDownResult) {}
  
  public void run()
  {
    MessageForPic localMessageForPic;
    PicStatisticsManager localPicStatisticsManager;
    long l;
    if ((this.a != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqPicPicReq.a != null) && (this.a.b != null))
    {
      localMessageForPic = this.this$0.jdField_a_of_type_ComTencentMobileqqPicPicReq.a;
      File localFile = new File(this.a.b);
      if (this.a.a == 0)
      {
        localPicStatisticsManager = (PicStatisticsManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PICTURE_STATISTICS_MANAGER);
        if (localPicStatisticsManager != null)
        {
          l = localFile.length();
          switch (this.a.c)
          {
          }
        }
      }
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().a(this.this$0.jdField_a_of_type_ComTencentMobileqqPicPicReq, this.a);
      return;
      localPicStatisticsManager.a(13059, l);
      continue;
      localPicStatisticsManager.a(13060, l);
      localPicStatisticsManager.b(localMessageForPic);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.DownloadPicOperator.1
 * JD-Core Version:    0.7.0.1
 */