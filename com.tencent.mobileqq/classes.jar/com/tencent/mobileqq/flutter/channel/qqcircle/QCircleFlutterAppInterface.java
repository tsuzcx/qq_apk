package com.tencent.mobileqq.flutter.channel.qqcircle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import aumt;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.IToolProcEventListener;

public class QCircleFlutterAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  private EntityManagerFactory a;
  
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
    paramString = getAccount();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QCircleFlutterAppInterface", 1, "[getEntityManagerFactory] invalid account, account=" + paramString);
      return null;
    }
    if (this.a == null) {
      this.a = new aumt(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFlutterAppInterface", 2, "[getEntityManagerFactory] account=" + paramString + ", factory=" + this.a + ", tid=" + Process.myTid());
    }
    return this.a;
  }
  
  public void onBeforeExitProc()
  {
    QLog.e("QCircleFlutterAppInterface", 1, "[onBeforeExitProc]");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFlutterAppInterface", 2, "[onCreate]");
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    QLog.w("QCircleFlutterAppInterface", 1, "[onReceiveAccountAction] s=" + paramString);
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    QLog.e("QCircleFlutterAppInterface", 1, "[onReceiveLegalExitProcAction]");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterAppInterface
 * JD-Core Version:    0.7.0.1
 */