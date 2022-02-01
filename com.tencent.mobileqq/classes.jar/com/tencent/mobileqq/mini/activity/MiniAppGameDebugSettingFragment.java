package com.tencent.mobileqq.mini.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
  
  protected int getContentLayoutId()
  {
    return 2131562373;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.sharedPreferences = getBaseActivity().app.getApp().getSharedPreferences("envSwitch", 4);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = (FormSwitchItem)paramView.findViewById(2131371389);
    paramBundle.setChecked(this.sharedPreferences.getBoolean("pref_key_use_system_webview", false));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.1(this));
    paramBundle = (FormSwitchItem)paramView.findViewById(2131371387);
    paramBundle.setChecked(this.sharedPreferences.getBoolean("pref_key_use_old_desktop", false));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.2(this));
    Object localObject1 = (FormSwitchItem)paramView.findViewById(2131371388);
    paramBundle = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((StringBuilder)localObject2).append("_user_sdk_minigame_");
    paramBundle = paramBundle.getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    ((FormSwitchItem)localObject1).setChecked(paramBundle.getBoolean("_minigame_start_with_sdk", false));
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.3(this, paramBundle));
    localObject1 = (FormSwitchItem)paramView.findViewById(2131371354);
    localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStringBuilder.append("_user_sdk_miniapp_");
    ((FormSwitchItem)localObject1).setChecked(((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 4).getBoolean("_miniapp_start_with_sdk", true));
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.4(this));
    localObject1 = (FormSwitchItem)paramView.findViewById(2131371353);
    ((FormSwitchItem)localObject1).setChecked(paramBundle.getBoolean("_minigame_enable_jank_canary_brief", false));
    ((FormSwitchItem)localObject1).setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.5(this, paramBundle));
    paramBundle = (FormSwitchItem)paramView.findViewById(2131371357);
    localObject1 = BaseApplicationImpl.getApplication();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((StringBuilder)localObject2).append("_user_ipv6only_miniapp_");
    paramBundle.setChecked(((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4).getBoolean("_user_ipv6only_miniapp_", false));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.6(this));
    paramBundle = (FormSwitchItem)paramView.findViewById(2131371356);
    localObject1 = BaseApplicationImpl.getApplication();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((StringBuilder)localObject2).append("_user_embedded_video_");
    paramBundle.setChecked(((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4).getBoolean("_user_embedded_video_", true));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.7(this));
    paramBundle = (FormSwitchItem)paramView.findViewById(2131371355);
    localObject1 = BaseApplicationImpl.getApplication();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((StringBuilder)localObject2).append("_user_embedded_live_");
    paramBundle.setChecked(((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4).getBoolean("_user_embedded_live_", true));
    paramBundle.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.8(this));
    paramView = (FormSwitchItem)paramView.findViewById(2131371358);
    paramBundle = BaseApplicationImpl.getApplication();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((StringBuilder)localObject1).append("_loadingad_select_use_nulllist_");
    paramView.setChecked(paramBundle.getSharedPreferences(((StringBuilder)localObject1).toString(), 4).getBoolean("_loadingad_select_use_nulllist_", false));
    paramView.setOnCheckedChangeListener(new MiniAppGameDebugSettingFragment.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */