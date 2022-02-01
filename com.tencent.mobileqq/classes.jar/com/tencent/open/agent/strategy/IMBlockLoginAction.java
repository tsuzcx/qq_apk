package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor;
import com.tencent.open.agent.util.AuthModelUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import mqq.app.MobileQQ;

public class IMBlockLoginAction
  extends BaseAction
{
  private BroadcastReceiver b;
  
  public IMBlockLoginAction(String paramString)
  {
    super(paramString);
  }
  
  private void b(Activity paramActivity)
  {
    if (!OpenSdkIFrameProcessor.a()) {
      return;
    }
    this.b = new IMBlockLoginAction.2(this, paramActivity);
    paramActivity.registerReceiver(this.b, new IntentFilter("mqq.opensdk.intent.action.PUZZLEVERIFYCODE"));
  }
  
  private void c(Activity paramActivity)
  {
    SSOLog.a("IMBlockLoginAction", new Object[] { "unregisterReceiver mPuzzleVerifyCodeReceiver=", this.b });
    BroadcastReceiver localBroadcastReceiver = this.b;
    if (localBroadcastReceiver != null)
    {
      paramActivity.unregisterReceiver(localBroadcastReceiver);
      this.b = null;
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    Object localObject = paramActivity.getIntent();
    paramBundle = ((Intent)localObject).getStringExtra("appid");
    String str1 = ((Intent)localObject).getStringExtra("uin");
    String str2 = ((Intent)localObject).getStringExtra("passwd");
    boolean bool = ((Intent)localObject).getBooleanExtra("is_from_login", false);
    b(paramActivity);
    localObject = (AbstractOpenSdkAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    ((AbstractOpenSdkAppInterface)localObject).a(1, null);
    AuthModelUtil.a(paramBundle, str1, str2, new IMBlockLoginAction.1(this, bool, (AbstractOpenSdkAppInterface)localObject, paramActivity));
  }
  
  protected boolean b(Activity paramActivity, Bundle paramBundle)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.strategy.IMBlockLoginAction
 * JD-Core Version:    0.7.0.1
 */