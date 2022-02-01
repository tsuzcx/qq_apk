package com.tencent.mobileqq.guild.privatechannel.ext;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateDeleteViewModel;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class GuildPrivateDeleteMemberFragment
  extends QQGuildTitleBarFragment
{
  public String o;
  protected GuildSelectDeleteMemberLayout p;
  private GuildPrivateDeleteViewModel q;
  private IGProGuildInfo r;
  
  public static Intent a(IGProGuildInfo paramIGProGuildInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("QQGuildCustomTitleBarFragment", 1, "guild is null");
      QQToast.makeText(paramActivity, 1, paramActivity.getResources().getString(2131889041), 1).show();
      return;
    }
    paramAppInterface = a(((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString1));
    paramAppInterface.putExtra("select_type", 2);
    paramAppInterface.putExtra("title_str", paramString3);
    paramAppInterface.putExtra("extra_channel_id", paramString2);
    QPublicFragmentActivity.Launcher.a(paramActivity, paramAppInterface, QPublicFragmentActivity.class, GuildPrivateDeleteMemberFragment.class, paramInt);
  }
  
  private void i()
  {
    Object localObject = getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("select_type", 0);
    String str1 = ((Intent)localObject).getStringExtra("title_str");
    String str2 = ((Intent)localObject).getStringExtra("extra_channel_id");
    String[] arrayOfString = ((Intent)localObject).getStringArrayExtra("selected_list");
    GuildPrivateMemberListAdapter.UserInfoUIData[] arrayOfUserInfoUIData = (GuildPrivateMemberListAdapter.UserInfoUIData[])((Intent)localObject).getSerializableExtra("select_member_info_list");
    this.r = ((IGProGuildInfo)((Intent)localObject).getSerializableExtra("extra_guild_guild_info"));
    this.p = ((GuildSelectDeleteMemberLayout)this.l.findViewById(2131437913));
    this.p.setInitData(l(), i);
    a(false);
    this.q = ((GuildPrivateDeleteViewModel)ViewModelProviderHelper.a(this, GuildPrivateDeleteViewModel.a).get(GuildPrivateDeleteViewModel.class));
    this.q.a(l(), this.r.getGuildID(), str2);
    this.p.setDataModel(this.q, this, this.r.getGuildID(), str2, this.r);
    this.q.e().observe(this, new GuildPrivateDeleteMemberFragment.1(this));
    a(str1);
    this.o = getResources().getString(2131888784);
    this.d.setText(this.o);
    this.p.setSelectMemberCallback(new GuildPrivateDeleteMemberFragment.2(this));
    if ((arrayOfUserInfoUIData != null) && (arrayOfUserInfoUIData.length > 0))
    {
      localObject = Arrays.asList(arrayOfUserInfoUIData);
      this.p.a((List)localObject);
    }
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      this.p.setSelectItems(arrayOfString);
    }
  }
  
  private void j()
  {
    if (getActivity() != null)
    {
      getActivity().setResult(10006);
      getActivity().finish();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    i();
  }
  
  protected int b()
  {
    return 2131625111;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772126, 2130772007);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2) && (paramInt2 == -1)) {
      return;
    }
    if (paramInt2 == 10006) {
      j();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.p.c();
    this.q.g();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getQBaseActivity().overridePendingTransition(0, 2130772131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.ext.GuildPrivateDeleteMemberFragment
 * JD-Core Version:    0.7.0.1
 */