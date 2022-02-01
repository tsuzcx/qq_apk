package com.tencent.mobileqq.qqlive.filter.download;

import com.tencent.mobileqq.qqlive.anchor.room.editor.QQLiveAEResPreLoadCallback;
import com.tencent.mobileqq.qqlive.filter.data.MetaMaterial;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

class QQLiveAEResDownloader$2$1
  implements ResDownLoadListener
{
  QQLiveAEResDownloader$2$1(QQLiveAEResDownloader.2 param2, int paramInt1, MetaMaterial paramMetaMaterial, CountDownLatch paramCountDownLatch, int paramInt2) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[preDownloadAllRes] on download finish, index: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.b.b);
    QLog.d("QQLiveAEResDownloader", 4, localStringBuilder.toString());
    this.c.countDown();
    this.e.a.a(this.d - this.c.getCount(), this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.download.QQLiveAEResDownloader.2.1
 * JD-Core Version:    0.7.0.1
 */