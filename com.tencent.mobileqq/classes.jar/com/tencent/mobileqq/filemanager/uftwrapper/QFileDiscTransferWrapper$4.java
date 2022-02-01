package com.tencent.mobileqq.filemanager.uftwrapper;

import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class QFileDiscTransferWrapper$4
  implements Runnable
{
  QFileDiscTransferWrapper$4(QFileDiscTransferWrapper paramQFileDiscTransferWrapper, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    QFileDiscTransferWrapper.DiscUploadWrapper localDiscUploadWrapper = new QFileDiscTransferWrapper.DiscUploadWrapper(QFileDiscTransferWrapper.a(this.this$0), this.a, QFileDiscTransferWrapper.b(this.this$0));
    QFileDiscTransferWrapper.a(this.this$0, this.a.nSessionId, localDiscUploadWrapper);
    localDiscUploadWrapper.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.4
 * JD-Core Version:    0.7.0.1
 */