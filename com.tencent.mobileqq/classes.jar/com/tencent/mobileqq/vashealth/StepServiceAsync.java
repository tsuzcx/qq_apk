package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.text.TextUtils;
import bdyp;
import bdys;
import bdyx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import nud;

public class StepServiceAsync
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StepServiceAsync", 2, "StepServiceAsync call!");
    }
    Object localObject = (nud)this.a.app.a(139);
    ((nud)localObject).a = true;
    ((nud)localObject).b = System.currentTimeMillis();
    ((nud)localObject).a(null, null, false, null);
    localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if (!bdys.a())
    {
      QLog.i("StepServiceAsync", 1, "step counter unsupported model.");
      return super.a();
    }
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.health_ban.name(), "");
    QLog.i("StepServiceAsync", 1, "ban_info:" + str);
    if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 0))
    {
      localObject = new NewIntent((Context)localObject, bdyx.class);
      ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_health_switch");
      ((NewIntent)localObject).putExtra("isOpen", false);
      this.a.app.startServlet((NewIntent)localObject);
      QLog.e("StepServiceAsync", 1, "step counter found current model banned!");
      return super.a();
    }
    if (!SignUtils.isSupportKeyStore()) {}
    for (boolean bool = true;; bool = false)
    {
      bdyp.b = bool;
      localObject = (bdys)this.a.app.getManager(260);
      if (bdyp.a(1)) {
        ((bdys)localObject).a("login");
      }
      ((bdys)localObject).a();
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepServiceAsync
 * JD-Core Version:    0.7.0.1
 */