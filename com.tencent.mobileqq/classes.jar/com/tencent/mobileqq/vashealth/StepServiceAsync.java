package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.text.TextUtils;
import bigb;
import bige;
import bigj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import oer;

public class StepServiceAsync
  extends AsyncStep
{
  public int a()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("StepServiceAsync", 2, "StepServiceAsync call!");
    }
    Object localObject = (oer)this.a.app.a(139);
    ((oer)localObject).a = true;
    ((oer)localObject).b = System.currentTimeMillis();
    ((oer)localObject).a(null, null, false, null, 1);
    localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if (!bige.a())
    {
      QLog.i("StepServiceAsync", 1, "step counter unsupported model.");
      return super.a();
    }
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.health_ban.name(), "");
    QLog.i("StepServiceAsync", 1, "ban_info:" + str);
    if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 0))
    {
      localObject = new NewIntent((Context)localObject, bigj.class);
      ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_health_switch");
      ((NewIntent)localObject).putExtra("isOpen", false);
      this.a.app.startServlet((NewIntent)localObject);
      QLog.e("StepServiceAsync", 1, "step counter found current model banned!");
      return super.a();
    }
    if (!SignUtils.isSupportKeyStore()) {
      bool = true;
    }
    bigb.b = bool;
    localObject = (bige)this.a.app.getManager(260);
    if (bigb.a(1)) {
      ((bige)localObject).a("login");
    }
    ((bige)localObject).a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepServiceAsync
 * JD-Core Version:    0.7.0.1
 */