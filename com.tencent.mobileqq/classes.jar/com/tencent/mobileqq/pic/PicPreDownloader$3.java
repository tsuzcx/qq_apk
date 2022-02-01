package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;

class PicPreDownloader$3
  implements Runnable
{
  PicPreDownloader$3(PicPreDownloader paramPicPreDownloader, MessageForPic paramMessageForPic, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!PicPreDownloader.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productAsync, cannot preDownload");
      }
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -1);
      return;
    }
    PicPreDownloader.b(this.this$0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */