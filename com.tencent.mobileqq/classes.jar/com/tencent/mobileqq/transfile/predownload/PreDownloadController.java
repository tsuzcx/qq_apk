package com.tencent.mobileqq.transfile.predownload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class PreDownloadController
  implements Manager
{
  private static final String TAG = "PreDownload.Controller";
  public static final int VERSION = 0;
  private boolean enable = true;
  private QQAppInterface mApp;
  private PreDownloadScheduler mScheduler;
  
  public PreDownloadController(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
    this.mScheduler = ((PreDownloadScheduler)this.mApp.getManager(233));
    this.mScheduler.setEnable(this.enable);
  }
  
  public static String getPreDownloadPathStatic(int paramInt, String paramString, boolean paramBoolean)
  {
    return PreDownloadScheduler.getPreDownloadPathStatic(paramInt, paramString, paramBoolean);
  }
  
  public static ArrayList<String> onVersionUpdate(int paramInt1, int paramInt2)
  {
    return new ArrayList(5);
  }
  
  public AbsPreDownloadTask cancelPreDownload(String paramString)
  {
    return this.mScheduler.cancelPreDownload(paramString);
  }
  
  public boolean couldDownload()
  {
    return this.mScheduler.checkState();
  }
  
  public String getPreDownloadPath(int paramInt, String paramString, boolean paramBoolean)
  {
    return this.mScheduler.getPreDownloadPath(paramInt, paramString, paramBoolean);
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void onDestroy() {}
  
  void onTaskEnd(AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Controller", 2, "onTaskEnd: " + paramAbsPreDownloadTask);
    }
    this.mScheduler.onTaskEnd(paramAbsPreDownloadTask);
  }
  
  public void preDownloadSuccess(String paramString, long paramLong)
  {
    this.mScheduler.preDownloadSuccess(paramString, paramLong);
  }
  
  public boolean requestPreDownload(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    return this.mScheduler.requestPreDownload(paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramBoolean, paramAbsPreDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.PreDownloadController
 * JD-Core Version:    0.7.0.1
 */