package com.tencent.open.agent;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class PublicFragmentActivityForOpenSDK
  extends PublicFragmentActivity
{
  public void doOnBackPressed()
  {
    QLog.d("PublicFragmentActivityForOpenSDK", 1, "PublicFragmentActivityForOpenSDK->doOnBackPressed");
    super.doOnBackPressed();
    PublicBaseFragment localPublicBaseFragment = a();
    if ((localPublicBaseFragment instanceof OpenAuthorityFragment)) {
      ((OpenAuthorityFragment)localPublicBaseFragment).k();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.d("PublicFragmentActivityForOpenSDK", 1, "PublicFragmentActivityForOpenSDK->doOnCreate");
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    QLog.d("PublicFragmentActivityForOpenSDK", 1, "PublicFragmentActivityForOpenSDK->doOnNewIntent");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.PublicFragmentActivityForOpenSDK
 * JD-Core Version:    0.7.0.1
 */