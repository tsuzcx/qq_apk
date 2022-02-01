package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class StepServiceAsync
  extends AsyncStep
{
  protected int doStep()
  {
    ((IVasAdvApi)QRoute.api(IVasAdvApi.class)).requestPublicAccountAd();
    Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if (!((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isSupportStepCounter((Context)localObject))
    {
      QLog.i("StepServiceAsync", 1, "step counter unsupported model.");
      return super.doStep();
    }
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.health_ban.name(), "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ban_info:");
    localStringBuilder.append(str);
    QLog.i("StepServiceAsync", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 0))
    {
      localObject = ((IQQHealthApi)QRoute.api(IQQHealthApi.class)).getStepCounterServletIntent((Context)localObject);
      ((NewIntent)localObject).putExtra("isOpen", false);
      this.mAutomator.a.startServlet((NewIntent)localObject);
      QLog.e("StepServiceAsync", 1, "step counter found current model banned!");
      return super.doStep();
    }
    ((IQQHealthApi)QRoute.api(IQQHealthApi.class)).setIsOldMode(SignUtils.isSupportKeyStore() ^ true);
    localObject = (ISportManager)this.mAutomator.a.getRuntimeService(ISportManager.class, "multi");
    if (((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isNeedReport(this.mAutomator.a.getAccount())) {
      ((ISportManager)localObject).refreshCurrentStep("login");
    }
    ((ISportManager)localObject).doOnLogin();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepServiceAsync
 * JD-Core Version:    0.7.0.1
 */