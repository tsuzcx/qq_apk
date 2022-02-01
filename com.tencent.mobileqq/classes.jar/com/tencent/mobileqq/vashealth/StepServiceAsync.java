package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class StepServiceAsync
  extends AsyncStep
{
  public int a()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("StepServiceAsync", 2, "StepServiceAsync call!");
    }
    Object localObject = (EcshopAdHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.ESHOP_AD_HANDLER);
    ((EcshopAdHandler)localObject).a = true;
    ((EcshopAdHandler)localObject).b = System.currentTimeMillis();
    ((EcshopAdHandler)localObject).a(null, null, false, null, 33);
    localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if (!SportManager.a())
    {
      QLog.i("StepServiceAsync", 1, "step counter unsupported model.");
      return super.a();
    }
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.health_ban.name(), "");
    QLog.i("StepServiceAsync", 1, "ban_info:" + str);
    if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 0))
    {
      localObject = new NewIntent((Context)localObject, StepCounterServlert.class);
      ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_health_switch");
      ((NewIntent)localObject).putExtra("isOpen", false);
      this.a.a.startServlet((NewIntent)localObject);
      QLog.e("StepServiceAsync", 1, "step counter found current model banned!");
      return super.a();
    }
    if (!SignUtils.isSupportKeyStore()) {
      bool = true;
    }
    SSOHttpUtils.b = bool;
    localObject = (SportManager)this.a.a.getManager(QQManagerFactory.SPORT_MANAGER);
    if (SSOHttpUtils.a(1)) {
      ((SportManager)localObject).a("login");
    }
    ((SportManager)localObject).a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepServiceAsync
 * JD-Core Version:    0.7.0.1
 */