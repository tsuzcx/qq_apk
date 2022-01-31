package com.tencent.mobileqq.vip;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.agent.report.ReportCenter;
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
      if (QLog.isColorLevel()) {
        QLog.e("DownloadListener", 2, "-->report MM:command=" + paramDownloadTask.c + ",error code=" + paramDownloadTask.jdField_a_of_type_Int + ",uin=" + paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.jdField_a_of_type_Long);
      }
      ReportCenter.a().a(paramDownloadTask.c, 100, paramDownloadTask.jdField_a_of_type_Int, String.valueOf(paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.jdField_a_of_type_Long), paramDownloadTask.jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo.jdField_a_of_type_Int, "[会员中心]下载资源失败.", true);
    }
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
    String[] arrayOfString;
    if ((this.wifiFlow != null) && (this.xgFlow != null) && (paramAppInterface != null))
    {
      arrayOfString = null;
      int i = NetworkUtil.a(paramAppInterface.getApplication().getApplicationContext());
      if (i > 0)
      {
        if (i != 1) {
          break label134;
        }
        arrayOfString = new String[3];
        arrayOfString[0] = this.wifiFlow;
        arrayOfString[1] = "param_WIFIFlow";
        arrayOfString[2] = "param_Flow";
      }
    }
    for (;;)
    {
      if ((arrayOfString != null) && (paramLong > 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.mobileqq.vip.DownloadListener", 2, "report | tags=" + arrayOfString + ",len=" + paramLong);
        }
        paramAppInterface.sendAppDataIncerment(paramAppInterface.getCurrentAccountUin(), arrayOfString, paramLong);
      }
      return;
      label134:
      arrayOfString = new String[3];
      arrayOfString[0] = this.xgFlow;
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloadListener
 * JD-Core Version:    0.7.0.1
 */