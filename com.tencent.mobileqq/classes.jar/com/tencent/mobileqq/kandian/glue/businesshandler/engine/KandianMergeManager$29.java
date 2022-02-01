package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoySettingActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class KandianMergeManager$29
  implements BusinessObserver
{
  KandianMergeManager$29(KandianMergeManager paramKandianMergeManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    mobileqq_mp.GetMessageConfigurationResponse localGetMessageConfigurationResponse;
    if (paramBoolean) {
      localGetMessageConfigurationResponse = new mobileqq_mp.GetMessageConfigurationResponse();
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label258;
      }
      localGetMessageConfigurationResponse.mergeFrom(paramBundle);
      if ((!localGetMessageConfigurationResponse.ret_info.has()) || (!localGetMessageConfigurationResponse.ret_info.ret_code.has())) {
        break label243;
      }
      paramInt = localGetMessageConfigurationResponse.ret_info.ret_code.get();
      if (paramInt != 0) {
        break label205;
      }
      if (!localGetMessageConfigurationResponse.type.has()) {
        break label281;
      }
      paramInt = localGetMessageConfigurationResponse.type.get();
      if (paramInt != 1) {
        break label286;
      }
      paramBoolean = true;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        continue;
        paramBoolean = false;
      }
    }
    paramBundle = BaseActivity.sTopActivity;
    if (!ReadInJoyHelper.f(KandianMergeManager.c(this.a))) {
      if ((paramBundle instanceof ReadInJoySettingActivity))
      {
        paramBundle = (ReadInJoySettingActivity)paramBundle;
        if (paramBundle.b())
        {
          QLog.d("KandianMergeManager", 1, "setting: has set kandian status");
        }
        else
        {
          this.a.a(paramBoolean);
          paramBundle.a(paramBoolean);
        }
      }
      else
      {
        this.a.a(paramBoolean);
      }
    }
    paramBundle = new StringBuilder();
    paramBundle.append("result:");
    paramBundle.append(paramInt);
    QLog.d("KandianMergeManager", 1, paramBundle.toString());
    return;
    label205:
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("request Kandian status fail code:");
      paramBundle.append(paramInt);
      QLog.d("KandianMergeManager", 2, paramBundle.toString());
      return;
      label243:
      if (QLog.isColorLevel())
      {
        QLog.d("KandianMergeManager", 2, "request Kandian status wrong resp");
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("KandianMergeManager", 2, "request Kandian status fail data null");
          return;
          QLog.d("KandianMergeManager", 1, "failed to handle request Kandian status configuration");
        }
      }
    }
    label258:
    label281:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.29
 * JD-Core Version:    0.7.0.1
 */