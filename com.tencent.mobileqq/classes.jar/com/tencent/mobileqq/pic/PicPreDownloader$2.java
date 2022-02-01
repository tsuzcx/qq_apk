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
      this.this$0.a(this.a, -1);
      return;
    }
    PicPreDownloader.a(this.this$0, this.a, this.b, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.2
 * JD-Core Version:    0.7.0.1
 */