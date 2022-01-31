package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.text.TextUtils;
import basd;
import basg;
import basl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import nfw;

public class StepServiceAsync
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StepServiceAsync", 2, "StepServiceAsync call!");
    }
    Object localObject = (nfw)this.a.app.a(139);
    ((nfw)localObject).a = true;
    ((nfw)localObject).b = System.currentTimeMillis();
    ((nfw)localObject).a(null, null, false, null);
    localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if (!basg.a())
    {
      QLog.i("StepServiceAsync", 1, "step counter unsupported model.");
      return super.a();
    }
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.health_ban.name(), "");
    QLog.i("StepServiceAsync", 1, "ban_info:" + str);
    if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 0))
    {
      localObject = new NewIntent((Context)localObject, basl.class);
      ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_health_switch");
      ((NewIntent)localObject).putExtra("isOpen", false);
      this.a.app.startServlet((NewIntent)localObject);
      QLog.e("StepServiceAsync", 1, "step counter found current model banned!");
      return super.a();
    }
    if (!SignUtils.isSupportKeyStore()) {}
    for (boolean bool = true;; bool = false)
    {
      basd.b = bool;
      localObject = (basg)this.a.app.getManager(260);
      if (basd.a(1)) {
        ((basg)localObject).a("login");
      }
      ((basg)localObject).a();
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepServiceAsync
 * JD-Core Version:    0.7.0.1
 */