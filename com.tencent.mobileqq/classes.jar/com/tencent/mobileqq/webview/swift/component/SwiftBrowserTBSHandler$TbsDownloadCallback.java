package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.webview.util.ITbsDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;
import java.lang.ref.WeakReference;

public class SwiftBrowserTBSHandler$TbsDownloadCallback
  implements TbsDownloader.TbsDownloaderCallback
{
  WeakReference<ITbsDownloader> a;
  
  public SwiftBrowserTBSHandler$TbsDownloadCallback(ITbsDownloader paramITbsDownloader)
  {
    this.a = new WeakReference(paramITbsDownloader);
  }
  
  public void onNeedDownloadFinish(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      QbSdk.setUploadCode(BaseApplication.getContext(), 156);
      if (QLog.isColorLevel()) {
        QLog.d("TBS_update", 2, "tbs need download");
      }
      WeakReference localWeakReference = this.a;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((ITbsDownloader)this.a.get()).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.TbsDownloadCallback
 * JD-Core Version:    0.7.0.1
 */