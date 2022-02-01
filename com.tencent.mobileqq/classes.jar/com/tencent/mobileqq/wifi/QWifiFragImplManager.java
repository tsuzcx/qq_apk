package com.tencent.mobileqq.wifi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.wifisdk.ui.api.BaseFragImplManager;
import com.wifisdk.ui.fragments.BaseFragmentImpl;

public class QWifiFragImplManager
  extends BaseFragImplManager
{
  public void finishFragImpl(BaseFragmentImpl paramBaseFragmentImpl) {}
  
  public void switchFragImpl(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt2 == 1) {
      localObject = new QWifiListFragment();
    } else if (paramInt2 == 2) {
      localObject = new QWifiSecurityFragment();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    PublicFragmentActivity.a(paramContext, paramIntent, localObject.getClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.QWifiFragImplManager
 * JD-Core Version:    0.7.0.1
 */