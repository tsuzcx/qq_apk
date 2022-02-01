package com.tencent.mobileqq.guild.privatechannel;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class GuildPrivateSelectMemberFragment
  extends QQGuildTitleBarFragment
{
  public String o;
  protected GuildSelectGuildMemberLayout p;
  private QQGuildMemberListViewModel q;
  private IGProGuildInfo r;
  
  public static Intent a(IGProGuildInfo paramIGProGuildInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramAppInterface, paramString1, paramString2, paramInt1, null, null, paramInt2);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, String[] paramArrayOfString, GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, int paramInt2)
  {
    a(paramActivity, paramAppInterface, paramString1, paramString2, paramInt1, paramArrayOfString, paramArrayOfUserInfoUIData, false, paramInt2);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, String[] paramArrayOfString, GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, boolean paramBoolean, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QQGuildCustomTitleBarFragment", 1, "guild is null");
      QQToast.makeText(paramActivity, 1, paramActivity.getResources().getString(2131889041), 1).show();
      return;
    }
    paramAppInterface = a(((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString1));
    paramAppInterface.putExtra("select_type", paramInt1);
    paramAppInterface.putExtra("title_str", paramString2);
    paramAppInterface.putExtra("show_grid", paramBoolean);
    if (paramArrayOfString != null) {
      paramAppInterface.putExtra("selected_list", paramArrayOfString);
    }
    if (paramArrayOfUserInfoUIData != null) {
      paramAppInterface.putExtra("select_member_info_list", paramArrayOfUserInfoUIData);
    }
    QPublicFragmentActivity.Launcher.a(paramActivity, paramAppInterface, QPublicFragmentActivity.class, GuildPrivateSelectMemberFragment.class, paramInt2);
  }
  
  private void i()
  {
    Object localObject = getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("select_type", 0);
    String str = ((Intent)localObject).getStringExtra("title_str");
    boolean bool = ((Intent)localObject).getBooleanExtra("show_grid", false);
    String[] arrayOfString = ((Intent)localObject).getStringArrayExtra("selected_list");
    GuildPrivateMemberListAdapter.UserInfoUIData[] arrayOfUserInfoUIData = (GuildPrivateMemberListAdapter.UserInfoUIData[])((Intent)localObject).getSerializableExtra("select_member_info_list");
    this.r = ((IGProGuildInfo)((Intent)localObject).getSerializableExtra("extra_guild_guild_info"));
    this.p = ((GuildSelectGuildMemberLayout)this.l.findViewById(2131437913));
    this.p.setInitData(l(), i, bool);
    a(2131887648, new GuildPrivateSelectMemberFragment.1(this));
    b(2131888784, new GuildPrivateSelectMemberFragment.2(this));
    a(false);
    this.q = ((QQGuildMemberListViewModel)ViewModelProviderHelper.a(this, QQGuildMemberListViewModel.u).get(QQGuildMemberListViewModel.class));
    this.q.a(this);
    this.p.setDataModel(this.q, this, this.r);
    a(str, getResources().getString(2131887648), getResources().getString(2131888784));
    this.p.setSelectMemberCallback(new GuildPrivateSelectMemberFragment.3(this));
    if ((arrayOfUserInfoUIData != null) && (arrayOfUserInfoUIData.length > 0))
    {
      localObject = Arrays.asList(arrayOfUserInfoUIData);
      this.p.a((List)localObject);
    }
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      this.p.setSelectItems(arrayOfString);
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    i();
  }
  
  void a(String paramString, int paramInt)
  {
    this.d.setVisibility(0);
    this.d.setText(paramString);
    this.d.setBackgroundResource(0);
    this.d.setTextColor(paramInt);
    paramString = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    paramString.addRule(11);
    paramString.width = -2;
    paramString.height = -2;
    paramString.rightMargin = ((int)(DeviceInfoUtil.a * 12.0F));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1);
    this.b.setText(paramString2);
    this.d.setText(paramString3);
    this.o = paramString3;
  }
  
  protected int b()
  {
    return 2131625118;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772133, 2130772007);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.p.c();
    this.q.u();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getQBaseActivity().overridePendingTransition(0, 2130772135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildPrivateSelectMemberFragment
 * JD-Core Version:    0.7.0.1
 */