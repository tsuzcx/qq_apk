package com.tencent.mobileqq.troop.troopapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class TroopAppShortcutFragment
  extends PublicBaseFragment
{
  private TroopAppShortcutContainer a;
  
  public void a()
  {
    SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)getBaseActivity()).mSystemBarComp;
    if (localSystemBarCompact != null)
    {
      localSystemBarCompact.setStatusDrawable(null);
      localSystemBarCompact.setStatusBarColor(0);
      localSystemBarCompact.setStatusColor(0);
      if (!ThemeUtil.isNowThemeIsNight(getBaseActivity().app, true, null)) {
        ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
      }
    }
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a();
    paramBundle = this.a;
    if (paramBundle != null)
    {
      paramBundle.a();
      this.a.b();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    TroopAppShortcutContainer localTroopAppShortcutContainer = this.a;
    if (localTroopAppShortcutContainer != null) {
      localTroopAppShortcutContainer.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = getBaseActivity().getIntent().getStringExtra("troop_uin");
    paramViewGroup = (SessionInfo)getBaseActivity().getIntent().getParcelableExtra("session_info");
    int i = getBaseActivity().getIntent().getIntExtra("reportfrom", 2);
    this.a = new TroopAppShortcutFragment.1(this, getBaseActivity().app, getBaseActivity(), getBaseActivity(), paramViewGroup, paramLayoutInflater, 2);
    paramLayoutInflater = this.a;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.a() != null))
    {
      this.a.a(i);
      paramLayoutInflater = this.a.a();
    }
    else
    {
      paramLayoutInflater = null;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    TroopAppShortcutContainer localTroopAppShortcutContainer = this.a;
    if (localTroopAppShortcutContainer != null)
    {
      localTroopAppShortcutContainer.c();
      this.a.g();
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment
 * JD-Core Version:    0.7.0.1
 */