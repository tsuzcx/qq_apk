package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;

class PicPreDownloader$2
  implements Runnable
{
  PicPreDownloader$2(PicPreDownloader paramPicPreDownloader, MessageForPic paramMessageForPic, int paramInt) {}
  
  public void run()
  {
    if (!PicPreDownloader.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productAsync(): cannot preDownload");
      }
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -1);
      return;
    }
    PicPreDownloader.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_Int, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.2
 * JD-Core Version:    0.7.0.1
 */