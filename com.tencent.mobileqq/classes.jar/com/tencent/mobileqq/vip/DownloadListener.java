package com.tencent.mobileqq.vip;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.download.api.IDownloadAdapter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public abstract class DownloadListener
{
  String wifiFlow;
  String xgFlow;
  
  public DownloadListener() {}
  
  public DownloadListener(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  private void reportErrorToMM(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.e("DownloadListener", 2, "-->report MM");
    }
    if (paramDownloadTask.a() != 3)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("-->report MM:command=");
        localStringBuilder.append(paramDownloadTask.c);
        localStringBuilder.append(",error code=");
        localStringBuilder.append(paramDownloadTask.jdField_a_of_type_Int);
        localStringBuilder.append(",uin=");
        localStringBuilder.append(paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.a);
        QLog.e("DownloadListener", 2, localStringBuilder.toString());
      }
      vipReportCgi(paramDownloadTask);
    }
  }
  
  private void vipReportCgi(DownloadTask paramDownloadTask)
  {
    ((IDownloadAdapter)QRoute.api(IDownloadAdapter.class)).vipReportCgi(paramDownloadTask);
  }
  
  public void onCancel(DownloadTask paramDownloadTask) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    paramDownloadTask.h = System.currentTimeMillis();
    if (paramDownloadTask.a((byte)1)) {
      reportErrorToMM(paramDownloadTask);
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadListener", 2, "onNetMobile2None...");
    }
  }
  
  public void onNetWifi2Mobile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadListener", 2, "onNetWifi2Mobile...");
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadListener", 2, "onNetWifi2None...");
    }
  }
  
  public void onPause(DownloadTask paramDownloadTask) {}
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    paramDownloadTask.g = System.currentTimeMillis();
    return true;
  }
  
  public void report(AppInterface paramAppInterface, long paramLong)
  {
    if ((this.wifiFlow != null) && (this.xgFlow != null) && (paramAppInterface != null))
    {
      int i = NetworkUtil.getSystemNetwork(paramAppInterface.getApplication().getApplicationContext());
      if (i > 0)
      {
        if (i == 1)
        {
          paramAppInterface = new String[3];
          paramAppInterface[0] = this.wifiFlow;
          paramAppInterface[1] = "param_WIFIFlow";
          paramAppInterface[2] = "param_Flow";
        }
        else
        {
          paramAppInterface = new String[3];
          paramAppInterface[0] = this.xgFlow;
          paramAppInterface[1] = "param_XGFlow";
          paramAppInterface[2] = "param_Flow";
        }
      }
      else {
        paramAppInterface = null;
      }
      if ((paramAppInterface != null) && (paramLong > 0L) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("report | tags=");
        localStringBuilder.append(paramAppInterface);
        localStringBuilder.append(",len=");
        localStringBuilder.append(paramLong);
        QLog.d("com.tencent.mobileqq.vip.DownloadListener", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloadListener
 * JD-Core Version:    0.7.0.1
 */