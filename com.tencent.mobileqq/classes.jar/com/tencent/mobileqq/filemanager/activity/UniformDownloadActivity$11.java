package com.tencent.mobileqq.filemanager.activity;

import android.os.Bundle;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.qphone.base.util.QLog;

class UniformDownloadActivity$11
  implements IUniformDownloaderListener
{
  UniformDownloadActivity$11(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = UniformDownloadActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UniformDownloader onDownloadStart progress = ");
      localStringBuilder.append(paramInt);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.2(this));
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramString = UniformDownloadActivity.a;
      paramBundle = new StringBuilder();
      paramBundle.append("UniformDownloader onDownloadFailed errCode = ");
      paramBundle.append(paramInt);
      QLog.d(paramString, 2, paramBundle.toString());
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.6(this));
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadSucess ");
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.1(this));
    ReportController.b(null, "dc00898", "", "", "0X8008FFA", "0X8008FFA", 1, 0, "", "", "", "");
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = UniformDownloadActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UniformDownloader onDownloadProgress progress = ");
      localStringBuilder.append(paramInt);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.4(this, paramInt));
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = UniformDownloadActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UniformDownloader onDownloadPause progress = ");
      localStringBuilder.append(paramInt);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.5(this));
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = UniformDownloadActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UniformDownloader onDownloadResume progress = ");
      localStringBuilder.append(paramInt);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11
 * JD-Core Version:    0.7.0.1
 */