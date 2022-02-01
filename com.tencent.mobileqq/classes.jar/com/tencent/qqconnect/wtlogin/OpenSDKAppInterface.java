package com.tencent.qqconnect.wtlogin;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.open.agent.entity.QQLiteBridgeParam;
import com.tencent.open.agent.util.AuthBeaconReporter;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.SSOLog;
import mqq.app.MobileQQ;

public class OpenSDKAppInterface
  extends AbstractOpenSdkAppInterface
{
  private BroadcastReceiver a;
  
  public OpenSDKAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public Object a(QQLiteBridgeParam paramQQLiteBridgeParam)
  {
    return QQLiteStatusMgr.a(paramQQLiteBridgeParam);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Step.AmStepFactory.b(8, BaseApplicationImpl.sDirector, null).step();
    Step.AmStepFactory.b(12, BaseApplicationImpl.sDirector, null).step();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate: invoked.  savedInstanceState: ");
    localStringBuilder.append(paramBundle);
    SSOLog.b("OpenSDKAppInterface", localStringBuilder.toString());
    AuthReporter.a(new AuthBeaconReporter());
    this.a = new OpenSDKAppInterface.1(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("mqq.intent.action.ACCOUNT_KICKED");
    this.app.registerReceiver(this.a, paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.unregisterReceiver(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.OpenSDKAppInterface
 * JD-Core Version:    0.7.0.1
 */