package com.tencent.mobileqq.guild.privatechannel.ext;

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
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateAddViewModel;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class GuildPrivateAddMemberFragment
  extends QQGuildTitleBarFragment
{
  public String o;
  protected GuildPrivateAddMemberLayout p;
  private GuildPrivateAddViewModel q;
  private IGProGuildInfo r;
  
  public static Intent a(IGProGuildInfo paramIGProGuildInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QQGuildCustomTitleBarFragment", 1, "guild is null");
      QQToast.makeText(paramActivity, 1, paramActivity.getResources().getString(2131889041), 1).show();
      return;
    }
    paramAppInterface = a(((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString1));
    paramAppInterface.putExtra("select_type", paramInt1);
    paramAppInterface.putExtra("title_str", paramString3);
    paramAppInterface.putExtra("extra_channel_id", paramString2);
    QPublicFragmentActivity.Launcher.a(paramActivity, paramAppInterface, QPublicFragmentActivity.class, GuildPrivateAddMemberFragment.class, paramInt2);
  }
  
  private void i()
  {
    Object localObject2 = getActivity().getIntent();
    int i = ((Intent)localObject2).getIntExtra("select_type", 0);
    Object localObject1 = ((Intent)localObject2).getStringExtra("title_str");
    String[] arrayOfString = ((Intent)localObject2).getStringArrayExtra("selected_list");
    GuildPrivateMemberListAdapter.UserInfoUIData[] arrayOfUserInfoUIData = (GuildPrivateMemberListAdapter.UserInfoUIData[])((Intent)localObject2).getSerializableExtra("select_member_info_list");
    this.r = ((IGProGuildInfo)((Intent)localObject2).getSerializableExtra("extra_guild_guild_info"));
    localObject2 = ((Intent)localObject2).getStringExtra("extra_channel_id");
    this.p = ((GuildPrivateAddMemberLayout)this.l.findViewById(2131437913));
    this.p.setInitData(l(), i);
    a(2131887648, new GuildPrivateAddMemberFragment.1(this));
    b(2131888784, new GuildPrivateAddMemberFragment.2(this));
    a(false);
    this.q = ((GuildPrivateAddViewModel)ViewModelProviderHelper.a(this, GuildPrivateAddViewModel.a).get(GuildPrivateAddViewModel.class));
    this.q.a(l(), this.r.getGuildID(), (String)localObject2);
    this.p.setDataModel(this.q, this, this.r);
    a((String)localObject1, getResources().getString(2131887648), getResources().getString(2131888784));
    this.p.setSelectMemberCallback(new GuildPrivateAddMemberFragment.3(this));
    if ((arrayOfUserInfoUIData != null) && (arrayOfUserInfoUIData.length > 0))
    {
      localObject1 = Arrays.asList(arrayOfUserInfoUIData);
      this.p.a((List)localObject1);
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
    return 2131625110;
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
    this.q.f();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getQBaseActivity().overridePendingTransition(2130772007, 2130772135);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.ext.GuildPrivateAddMemberFragment
 * JD-Core Version:    0.7.0.1
 */