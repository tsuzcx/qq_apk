package com.tencent.mobileqq.troop.troopapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bgoq;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class TroopAppShortcutFragment
  extends PublicBaseFragment
{
  private TroopAppShortcutContainer a;
  
  public void a()
  {
    SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    if (localSystemBarCompact != null)
    {
      localSystemBarCompact.setStatusDrawable(null);
      localSystemBarCompact.setStatusBarColor(0);
      localSystemBarCompact.setStatusColor(0);
      if (!ThemeUtil.isNowThemeIsNight(getActivity().app, true, null)) {
        ImmersiveUtils.a(true, getActivity().getWindow());
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
    if (this.a != null)
    {
      this.a.a();
      this.a.b();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = getActivity().getIntent().getStringExtra("troop_uin");
    paramViewGroup = (SessionInfo)getActivity().getIntent().getParcelableExtra("session_info");
    int i = getActivity().getIntent().getIntExtra("reportfrom", 2);
    this.a = new bgoq(this, getActivity().app, getActivity(), getActivity(), paramViewGroup, paramLayoutInflater, 2);
    if ((this.a == null) || (this.a.a() == null)) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = this.a.a())
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.a.a(i);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null)
    {
      this.a.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment
 * JD-Core Version:    0.7.0.1
 */