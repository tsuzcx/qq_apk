package com.tencent.mobileqq.filemanager.app;

import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.HashMap;
import java.util.List;

class QFileAppStorePromoteManager$FetchAppInfoCallback$1
  implements Runnable
{
  QFileAppStorePromoteManager$FetchAppInfoCallback$1(QFileAppStorePromoteManager.FetchAppInfoCallback paramFetchAppInfoCallback, int paramInt1, int paramInt2, List paramList) {}
  
  public void run()
  {
    QFileAppStorePromoteManager.IGetAppDetailCallback localIGetAppDetailCallback = (QFileAppStorePromoteManager.IGetAppDetailCallback)QFileAppStorePromoteManager.b(this.d.a).get(Integer.valueOf(this.a));
    if (localIGetAppDetailCallback != null)
    {
      boolean bool;
      if (this.b == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localIGetAppDetailCallback.a(bool, (AppDetail)this.c.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.FetchAppInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */