package com.tencent.mobileqq.pic.operator;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import java.io.File;

class DownloadPicOperator$1
  implements Runnable
{
  DownloadPicOperator$1(DownloadPicOperator paramDownloadPicOperator, DownCallBack.DownResult paramDownResult) {}
  
  public void run()
  {
    if ((this.a != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqPicPicReq.a != null) && (this.a.b != null))
    {
      MessageForPic localMessageForPic = this.this$0.jdField_a_of_type_ComTencentMobileqqPicPicReq.a;
      File localFile = new File(this.a.b);
      if (this.a.a == 0)
      {
        PicStatisticsManager localPicStatisticsManager = ((PicPreDownloadImpl)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPicPreDownload.class, "")).picStatisticsManager;
        if (localPicStatisticsManager != null)
        {
          long l = localFile.length();
          int i = this.a.c;
          if (i != 1) {
            if (i != 65537)
            {
              if (i != 131075) {
                break label157;
              }
            }
            else
            {
              localPicStatisticsManager.a(13059, l);
              break label157;
            }
          }
          localPicStatisticsManager.a(13060, l);
          localPicStatisticsManager.b(localMessageForPic);
        }
      }
    }
    label157:
    ((PicPreDownloadImpl)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPicPreDownload.class, "")).picPreDownloader.a(this.this$0.jdField_a_of_type_ComTencentMobileqqPicPicReq, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.DownloadPicOperator.1
 * JD-Core Version:    0.7.0.1
 */