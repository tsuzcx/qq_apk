package com.tencent.mobileqq.qqlive.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.biz.sdk.QQLiveSDKHelper;
import com.tencent.qphone.base.util.QLog;

public class QQLiveBaseFragment
  extends QPublicBaseFragment
{
  protected IQQLiveSDK a;
  
  private void a()
  {
    if (getQBaseActivity().getAppRuntime() == null)
    {
      QLog.e("QQLiveBaseFragment", 1, "the app runtime is null");
      return;
    }
    this.a = QQLiveSDKHelper.a(getQBaseActivity().getAppRuntime());
    QQLiveSDKHelper.a(this.a, null);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment
 * JD-Core Version:    0.7.0.1
 */