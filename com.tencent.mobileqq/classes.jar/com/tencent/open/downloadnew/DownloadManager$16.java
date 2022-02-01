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
      MyAppApi.a().h();
    }
    this.this$0.a(this.this$0.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.16
 * JD-Core Version:    0.7.0.1
 */