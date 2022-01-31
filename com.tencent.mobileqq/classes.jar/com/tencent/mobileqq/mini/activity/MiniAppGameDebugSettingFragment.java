package com.tencent.mobileqq.mini.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.debug.EnvSwitchActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;

public class MiniAppGameDebugSettingFragment
  extends IphoneTitleBarFragment
{
  private static final String PREF_KEY_USE_OLD_DESKTOP = "pref_key_use_old_desktop";
  private static final String PREF_KEY_USE_SYSTEM_WEBVIEW = "pref_key_use_system_webview";
  private SharedPreferences sharedPreferences;
  
  public static boolean disableUseSystemWebView(Context paramContext)
  {
    return false;
  }
  
  public static boolean shouldUseSystemWebView(Context paramContext)
  {
    return false;
  }
  
  public static boolean shouleUseOldDeskTop()
  {
    return false;
  }
  
  public int getContentLayoutId()
  {
    return 2131561969;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.sharedPreferences = getActivity().app.getApp().getSharedPreferences(EnvSwitchActivity.KEY_ENV_SWITCH, 4);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = (FormSwitchItem)paramView.findViewById(2131370317);
    paramBundle.setChecked(this.sharedPreferences.getBoolean("pref_key_use_system_webview", false));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.1(this));
    paramView = (FormSwitchItem)paramView.findViewById(2131370316);
    paramView.setChecked(this.sharedPreferences.getBoolean("pref_key_use_old_desktop", false));
    paramView.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */