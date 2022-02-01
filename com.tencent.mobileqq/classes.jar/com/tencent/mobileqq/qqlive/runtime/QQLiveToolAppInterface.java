package com.tencent.mobileqq.qqlive.runtime;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qqlive.record.QQLiveRoomRecordManagerProxy;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.Constants.LogoutReason;
import mqq.app.IToolProcEventListener;
import mqq.app.MobileQQ;

public class QQLiveToolAppInterface
  extends BaseToolAppInterface
  implements IToolProcEventListener
{
  private MobileQQServiceBase a;
  
  public QQLiveToolAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    super(paramMobileQQ, paramString);
  }
  
  private void a()
  {
    MobileQQServiceBase localMobileQQServiceBase = this.a;
    if (localMobileQQServiceBase != null) {
      localMobileQQServiceBase.destroy();
    }
  }
  
  public void exit(boolean paramBoolean)
  {
    a();
    super.exit(paramBoolean);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.d();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public MobileQQServiceBase getMobileQQService()
  {
    return this.a;
  }
  
  public String getModuleId()
  {
    return "qq_live_tool";
  }
  
  protected void logout(Constants.LogoutReason paramLogoutReason, boolean paramBoolean)
  {
    a();
    super.logout(paramLogoutReason, paramBoolean);
  }
  
  public void onBeforeExitProc() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = new QQLiveToolService(this);
  }
  
  protected void onDestroy()
  {
    a();
    super.onDestroy();
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    return QQLiveRoomRecordManagerProxy.a(null) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.runtime.QQLiveToolAppInterface
 * JD-Core Version:    0.7.0.1
 */