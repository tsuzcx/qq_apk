package com.wifisdk.ui.api;

import android.content.Context;
import android.content.Intent;
import com.wifisdk.ui.fragments.BaseFragmentImpl;
import com.wifisdk.ui.fragments.WifiSDKFloorFragImpl;
import com.wifisdk.ui.fragments.WifiSDKMainFragImpl;
import com.wifisdk.ui.fragments.WifiSDKSecurityFragImpl;

public abstract class BaseFragImplManager
{
  public static final int FRAG_IMPL_NONE = 0;
  public static final int FRAG_IMPL_WIFI_FLOOR = 3;
  public static final int FRAG_IMPL_WIFI_LIST = 1;
  public static final int FRAG_IMPL_WIFI_SECURITY = 2;
  public static final String KEY_FRAG_IMPL_ID = "wffim_k100";
  
  public abstract void finishFragImpl(BaseFragmentImpl paramBaseFragmentImpl);
  
  public final BaseFragmentImpl newFragImpl(int paramInt)
  {
    if (paramInt == 1) {
      return new WifiSDKMainFragImpl();
    }
    if (paramInt == 2) {
      return new WifiSDKSecurityFragImpl();
    }
    if (paramInt == 3) {
      return new WifiSDKFloorFragImpl();
    }
    return null;
  }
  
  public abstract void switchFragImpl(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.wifisdk.ui.api.BaseFragImplManager
 * JD-Core Version:    0.7.0.1
 */