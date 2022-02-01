package com.tencent.open.applist;

import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;

class QZoneAppListActivity$1
  extends OnPluginInstallListener.Stub
{
  QZoneAppListActivity$1(QZoneAppListActivity paramQZoneAppListActivity) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    this.a.a(paramInt1 / paramInt2 * 100);
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    this.a.runOnUiThread(new QZoneAppListActivity.1.1(this));
  }
  
  public void onInstallFinish(String paramString)
  {
    QZoneAppListActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.applist.QZoneAppListActivity.1
 * JD-Core Version:    0.7.0.1
 */