package com.tencent.mobileqq.mini.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.debug.EnvSwitchActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

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
  
  public static boolean shouldAlwaysUseNullListForLoadingAdSelect()
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
    return 2131562414;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.sharedPreferences = getActivity().app.getApp().getSharedPreferences(EnvSwitchActivity.KEY_ENV_SWITCH, 4);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = (FormSwitchItem)paramView.findViewById(2131371189);
    paramBundle.setChecked(this.sharedPreferences.getBoolean("pref_key_use_system_webview", false));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.1(this));
    paramBundle = (FormSwitchItem)paramView.findViewById(2131371187);
    paramBundle.setChecked(this.sharedPreferences.getBoolean("pref_key_use_old_desktop", false));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.2(this));
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)paramView.findViewById(2131371188);
    paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_sdk_minigame_", 4);
    localFormSwitchItem.setChecked(paramBundle.getBoolean("_minigame_start_with_sdk", false));
    localFormSwitchItem.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.3(this, paramBundle));
    localFormSwitchItem = (FormSwitchItem)paramView.findViewById(2131371164);
    localFormSwitchItem.setChecked(BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_sdk_miniapp_", 4).getBoolean("_miniapp_start_with_sdk", true));
    localFormSwitchItem.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.4(this));
    localFormSwitchItem = (FormSwitchItem)paramView.findViewById(2131371163);
    localFormSwitchItem.setChecked(paramBundle.getBoolean("_minigame_enable_jank_canary_brief", false));
    localFormSwitchItem.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.5(this, paramBundle));
    paramBundle = (FormSwitchItem)paramView.findViewById(2131371167);
    paramBundle.setChecked(BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_ipv6only_miniapp_", 4).getBoolean("_user_ipv6only_miniapp_", false));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.6(this));
    paramBundle = (FormSwitchItem)paramView.findViewById(2131371166);
    paramBundle.setChecked(BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_embedded_video_", 4).getBoolean("_user_embedded_video_", true));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.7(this));
    paramBundle = (FormSwitchItem)paramView.findViewById(2131371165);
    paramBundle.setChecked(BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_embedded_live_", 4).getBoolean("_user_embedded_live_", true));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.8(this));
    paramView = (FormSwitchItem)paramView.findViewById(2131371168);
    paramView.setChecked(BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_loadingad_select_use_nulllist_", 4).getBoolean("_loadingad_select_use_nulllist_", false));
    paramView.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */