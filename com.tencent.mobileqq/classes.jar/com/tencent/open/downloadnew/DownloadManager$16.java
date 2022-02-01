package com.tencent.open.downloadnew;

class DownloadManager$16
  implements Runnable
{
  DownloadManager$16(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = null;
    if (UpdateManager.a()) {
      UpdateManager.a().a();
    }
    if (MyAppApi.d()) {
      MyAppApi.a().j();
    }
    DownloadManager localDownloadManager = this.this$0;
    localDownloadManager.a(localDownloadManager.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.16
 * JD-Core Version:    0.7.0.1
 */