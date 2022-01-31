package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.net.GdtAdHandler;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class StepServiceAsync
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StepServiceAsync", 2, "StepServiceAsync call!");
    }
    Object localObject = (GdtAdHandler)this.a.b.a(110);
    ((GdtAdHandler)localObject).a = true;
    ((GdtAdHandler)localObject).b = System.currentTimeMillis();
    ((GdtAdHandler)localObject).a(null, null, false, null);
    localObject = (VasExtensionHandler)this.a.b.a(71);
    if (NetworkUtil.h(BaseApplicationImpl.getApplication().getApplicationContext())) {
      ((VasExtensionHandler)localObject).a(((ApolloDaoManager)this.a.b.getManager(154)).a);
    }
    for (;;)
    {
      localObject = BaseApplicationImpl.getApplication().getApplicationContext();
      if (SportManager.a()) {
        break;
      }
      QLog.i("StepServiceAsync", 1, "step counter unsupported model.");
      return super.a();
      ApolloUtil.a();
    }
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.health_ban.name(), "");
    if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 0))
    {
      localObject = new NewIntent((Context)localObject, StepCounterServlert.class);
      ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_health_switch");
      ((NewIntent)localObject).putExtra("isOpen", false);
      this.a.b.startServlet((NewIntent)localObject);
      QLog.e("StepServiceAsync", 1, "step counter found current model banned!");
      return super.a();
    }
    if (!SignUtils.isSupportKeyStore()) {}
    for (boolean bool = true;; bool = false)
    {
      SSOHttpUtils.b = bool;
      localObject = (SportManager)this.a.b.getManager(259);
      if (SSOHttpUtils.a(1)) {
        ((SportManager)localObject).a("login");
      }
      ((SportManager)localObject).a();
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepServiceAsync
 * JD-Core Version:    0.7.0.1
 */