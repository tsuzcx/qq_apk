package com.tencent.mobileqq.guild.privatechannel.dialog;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout;
import com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel;
import com.tencent.mobileqq.guild.util.QQGuildTextUtils.CharacterCountInfo;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText.ITextEditEventListener;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuildPrivateSubSelectMemberFragment
  extends BaseCreateSubChannelFragment
  implements Handler.Callback, View.OnClickListener, CharacterCountEditText.ITextEditEventListener
{
  private final WeakReferenceHandler d = new WeakReferenceHandler(Looper.getMainLooper(), this);
  protected GuildSelectGuildMemberLayout e;
  protected QQGuildMemberListViewModel f;
  protected IGProGuildInfo g;
  public String h = "完成";
  private TextView i;
  private GuildPrivateMemberListAdapter.UserInfoUIData[] j;
  private String[] k;
  private GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback l;
  private View m;
  
  public static GuildPrivateSubSelectMemberFragment a(CreateSubChannelInfo paramCreateSubChannelInfo, IGProGuildInfo paramIGProGuildInfo, String[] paramArrayOfString, GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback paramOnMemberSelectCallback)
  {
    GuildPrivateSubSelectMemberFragment localGuildPrivateSubSelectMemberFragment = new GuildPrivateSubSelectMemberFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    if (paramArrayOfString != null) {
      localBundle.putStringArray("selected_list", paramArrayOfString);
    }
    if (paramArrayOfUserInfoUIData != null) {
      localBundle.putSerializable("select_member_info_list", paramArrayOfUserInfoUIData);
    }
    localBundle.putParcelable("extra_key_subchannel_info", paramCreateSubChannelInfo);
    localGuildPrivateSubSelectMemberFragment.setArguments(localBundle);
    localGuildPrivateSubSelectMemberFragment.a(paramOnMemberSelectCallback);
    return localGuildPrivateSubSelectMemberFragment;
  }
  
  @RequiresApi(api=21)
  private void g()
  {
    this.e = ((GuildSelectGuildMemberLayout)this.a.findViewById(2131437913));
    this.i = ((TextView)this.a.findViewById(2131446561));
    this.m = this.a.findViewById(2131429230);
    this.e.setInitData(a(), 0, true, 1);
    this.e.m.setBackgroundColor(16777215);
    this.m.setOnClickListener(new GuildPrivateSubSelectMemberFragment.1(this));
    a(2131888784, new GuildPrivateSubSelectMemberFragment.2(this));
    a(false);
    d();
    e();
    f();
    Object localObject = this.j;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = Arrays.asList((Object[])localObject);
      this.e.a((List)localObject);
    }
    localObject = this.k;
    if ((localObject != null) && (localObject.length > 0)) {
      ((IGPSService)a().getRuntimeService(IGPSService.class, "")).fetchUserInfo(this.g.getGuildID(), new ArrayList(Arrays.asList(this.k)), false, new GuildPrivateSubSelectMemberFragment.3(this));
    }
    h();
  }
  
  private void h()
  {
    if (this.c != null)
    {
      this.c.a(new -..Lambda.GuildPrivateSubSelectMemberFragment.gc7mNKu0GuzeFN8HX8Zb4CkFOqg(this));
      ((BottomSheetDialog)this.c.getDialog()).a().b(new GuildPrivateSubSelectMemberFragment.4(this));
    }
  }
  
  private void i()
  {
    if (this.c != null) {
      this.c.c();
    }
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.i.setVisibility(0);
    this.i.setText(getResources().getString(paramInt));
    this.i.setEnabled(true);
    if (paramOnClickListener != null) {
      this.i.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void a(GuildPrivateAppSubSelectMemberDialogFragment.OnMemberSelectCallback paramOnMemberSelectCallback)
  {
    this.l = paramOnMemberSelectCallback;
  }
  
  public void a(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo) {}
  
  void a(String paramString, int paramInt)
  {
    this.i.setVisibility(0);
    this.i.setText(paramString);
    this.i.setBackgroundResource(0);
    this.i.setTextColor(paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.i.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      this.i.setTextColor(-16777216);
      return;
    }
    this.i.setTextColor(-2130706433);
  }
  
  protected int b()
  {
    return 2131625131;
  }
  
  public void b(QQGuildTextUtils.CharacterCountInfo paramCharacterCountInfo) {}
  
  @RequiresApi(api=21)
  protected void c()
  {
    g();
  }
  
  public void d() {}
  
  protected void e()
  {
    this.f = ((QQGuildMemberListViewModel)ViewModelProviderHelper.a(this, QQGuildMemberListViewModel.u).get(QQGuildMemberListViewModel.class));
    this.f.a(a(), this.g, "");
    this.e.setDataModel(this.f, this, this.g);
  }
  
  public void f()
  {
    this.e.setSelectMemberCallback(new GuildPrivateSubSelectMemberFragment.5(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.c != null)) {
      this.c.c();
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if ((n != 2131446561) && (n == 2131429230)) {
      this.d.sendEmptyMessageDelayed(1, 200L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    this.g = ((IGProGuildInfo)paramBundle.getSerializable("extra_guild_guild_info"));
    this.j = ((GuildPrivateMemberListAdapter.UserInfoUIData[])paramBundle.getSerializable("select_member_info_list"));
    this.k = paramBundle.getStringArray("selected_list");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e.c();
    this.f.u();
    onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateSubSelectMemberFragment
 * JD-Core Version:    0.7.0.1
 */