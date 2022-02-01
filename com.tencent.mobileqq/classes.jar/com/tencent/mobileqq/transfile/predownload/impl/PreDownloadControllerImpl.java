package com.tencent.mobileqq.transfile.predownload.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class PreDownloadControllerImpl
  implements IPreDownloadController
{
  private static final String TAG = "PreDownload.Controller";
  private boolean enable = true;
  private PreDownloadScheduler mScheduler;
  
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
  
  public void onAppBackground()
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (this.mScheduler == null) {
        bool = true;
      }
      QLog.d("PreDownload.Controller", 2, new Object[] { "onAppBackground, ", Boolean.valueOf(bool) });
    }
    PreDownloadScheduler localPreDownloadScheduler = this.mScheduler;
    if (localPreDownloadScheduler != null) {
      localPreDownloadScheduler.onAppBackground();
    }
  }
  
  public void onAppForeground()
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (this.mScheduler == null) {
        bool = true;
      }
      QLog.d("PreDownload.Controller", 2, new Object[] { "onAppForeground, ", Boolean.valueOf(bool) });
    }
    PreDownloadScheduler localPreDownloadScheduler = this.mScheduler;
    if (localPreDownloadScheduler != null) {
      localPreDownloadScheduler.onAppForground();
    }
  }
  
  public void onAppLiteStart(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (this.mScheduler == null) {
        bool = true;
      }
      QLog.d("PreDownload.Controller", 2, new Object[] { "onAppLiteStart, ", Boolean.valueOf(bool), " isLiteStart=", Boolean.valueOf(paramBoolean) });
    }
    PreDownloadScheduler localPreDownloadScheduler = this.mScheduler;
    if (localPreDownloadScheduler != null) {
      localPreDownloadScheduler.onAppLiteStart(paramBoolean);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof BaseQQAppInterface))
    {
      this.mScheduler = new PreDownloadScheduler((BaseQQAppInterface)paramAppRuntime);
      this.mScheduler.setEnable(this.enable);
    }
  }
  
  public void onDestroy()
  {
    PreDownloadScheduler localPreDownloadScheduler = this.mScheduler;
    if (localPreDownloadScheduler != null) {
      localPreDownloadScheduler.onDestroy();
    }
  }
  
  public void onTaskEnd(AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTaskEnd: ");
      localStringBuilder.append(paramAbsPreDownloadTask);
      QLog.d("PreDownload.Controller", 2, localStringBuilder.toString());
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
  
  public void startPreDownload()
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (this.mScheduler == null) {
        bool = true;
      }
      QLog.d("PreDownload.Controller", 2, new Object[] { "startPreDownload, ", Boolean.valueOf(bool) });
    }
    PreDownloadScheduler localPreDownloadScheduler = this.mScheduler;
    if (localPreDownloadScheduler != null) {
      localPreDownloadScheduler.startPreDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.impl.PreDownloadControllerImpl
 * JD-Core Version:    0.7.0.1
 */