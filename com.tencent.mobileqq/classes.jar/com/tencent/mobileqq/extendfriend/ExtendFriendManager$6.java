package com.tencent.mobileqq.extendfriend;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.flutter.download.QFlutterDownloader;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendManager$6
  implements Runnable
{
  ExtendFriendManager$6(ExtendFriendManager paramExtendFriendManager) {}
  
  public void run()
  {
    Object localObject = ExtendFriendManager.a(this.this$0);
    if (localObject == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "parseConfig() try preload qflutter engine && app");
      }
      localObject = (EarlyDownloadManager)((QQAppInterface)localObject).getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      EarlyHandler localEarlyHandler = ((EarlyDownloadManager)localObject).a("qq.android.flutter.engine.v8.5.5_v2");
      if ((localEarlyHandler instanceof QFlutterDownloader)) {
        ((QFlutterDownloader)localEarlyHandler).a(false);
      }
      localObject = ((EarlyDownloadManager)localObject).a("qq.android.flutter.app.v8.5.5_v2");
    } while (!(localObject instanceof QFlutterDownloader));
    ((QFlutterDownloader)localObject).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.6
 * JD-Core Version:    0.7.0.1
 */