package com.tencent.mobileqq.download.unite.core;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.download.unite.util.UniteDownloadUtil.DownloadDialogListener;

class DownloadManagerInterceptor$1
  implements UniteDownloadUtil.DownloadDialogListener
{
  DownloadManagerInterceptor$1(DownloadManagerInterceptor paramDownloadManagerInterceptor, Runnable paramRunnable) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 16, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.core.DownloadManagerInterceptor.1
 * JD-Core Version:    0.7.0.1
 */