package com.tencent.mobileqq.flutter.channel.qqcircle;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.IToolProcEventListener;

public class QCircleFlutterAppInterface
  extends BaseToolAppInterface
  implements IToolProcEventListener
{
  public QCircleFlutterAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    return null;
  }
  
  public void onBeforeExitProc()
  {
    QLog.e("QCircleFlutterAppInterface", 1, "[onBeforeExitProc]");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFlutterAppInterface", 2, "[onCreate]");
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    paramIntent = new StringBuilder();
    paramIntent.append("[onReceiveAccountAction] s=");
    paramIntent.append(paramString);
    QLog.w("QCircleFlutterAppInterface", 1, paramIntent.toString());
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    QLog.e("QCircleFlutterAppInterface", 1, "[onReceiveLegalExitProcAction]");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterAppInterface
 * JD-Core Version:    0.7.0.1
 */