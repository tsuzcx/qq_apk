package com.tencent.mobileqq.wifi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.wifisdk.ui.api.BaseFragImplManager;
import com.wifisdk.ui.fragments.BaseFragmentImpl;

public class QWifiFragImplManager
  extends BaseFragImplManager
{
  public void finishFragImpl(BaseFragmentImpl paramBaseFragmentImpl)
  {
    paramBaseFragmentImpl = paramBaseFragmentImpl.getFragment();
    if (paramBaseFragmentImpl != null)
    {
      paramBaseFragmentImpl = paramBaseFragmentImpl.getActivity();
      if (paramBaseFragmentImpl != null) {
        paramBaseFragmentImpl.finish();
      }
    }
  }
  
  public void switchFragImpl(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    if (paramInt2 == 1) {
      localObject = new QWifiListFragment();
    }
    while (localObject == null)
    {
      return;
      if (paramInt2 == 2) {
        localObject = new QWifiSecurityFragment();
      }
    }
    PublicFragmentActivity.a(paramContext, paramIntent, localObject.getClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.QWifiFragImplManager
 * JD-Core Version:    0.7.0.1
 */