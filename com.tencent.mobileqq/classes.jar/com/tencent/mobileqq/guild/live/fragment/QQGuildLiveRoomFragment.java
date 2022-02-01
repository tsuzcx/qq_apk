package com.tencent.mobileqq.guild.live.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.audio.frame.FloatWindowPermissionHandler;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.live.fragment.audience.module.chatbar.QQGuildChatBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar.QQGuildSubTopBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.QQGuildSubVideoBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLandLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.topbar.QQGuildTopBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.audience.module.videobar.QQGuildVideoBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveRoomBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveRootControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveSubVideoBarControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl;
import com.tencent.mobileqq.guild.live.livemanager.LiveRoomEventListener;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveRoomCommMgr;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildEndLiveModel;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVM;
import com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveViewModelProvider;
import com.tencent.mobileqq.guild.live.viewmodel.module.QQGuildAnchorInfoVM;
import com.tencent.mobileqq.guild.live.widget.GuildLiveBlurURLImageView;
import com.tencent.mobileqq.guild.live.widget.GuildLiveGiftMsgAnimView;
import com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout;
import com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.OnPageSwipeListener;
import com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.OnSwipeListener;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.io.Serializable;

public class QQGuildLiveRoomFragment
  extends QQGuildLiveRoomBaseFragment
  implements IGuildLiveRootControl, LiveRoomEventListener, GuildLiveSwipeBackLayout.OnPageSwipeListener, GuildLiveSwipeBackLayout.OnSwipeListener
{
  private QQGuildLiveRoomVM d;
  private QQGuildAnchorInfoVM e;
  private FloatWindowPermissionHandler f;
  private FrameLayout g;
  private FrameLayout h;
  private FrameLayout i;
  private FrameLayout j;
  private FrameLayout k;
  private View l;
  private FrameLayout m;
  private FrameLayout n;
  private GuildLiveGiftMsgAnimView o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private GuildLiveBlurURLImageView t;
  private GuildLiveSwipeBackLayout u;
  private View v;
  
  private void a(FrameLayout paramFrameLayout)
  {
    if (getContext() == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramFrameLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = (DisplayUtil.a(getContext()).a * 9 / 16);
    paramFrameLayout.setLayoutParams(localLayoutParams);
  }
  
  private void a(@NonNull FrameLayout paramFrameLayout, View paramView)
  {
    if (paramView == null)
    {
      paramFrameLayout.removeAllViews();
      return;
    }
    if ((paramView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    paramFrameLayout.addView(paramView);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.equals("http://down.qq.com/innovate/guild/guild_live_channel/live_channel_room_bg.png", paramString))
    {
      this.t.a(paramString);
      return;
    }
    this.t.a(paramString, "http://down.qq.com/innovate/guild/guild_live_channel/live_channel_room_bg.png", 80, 88);
  }
  
  private void d(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.i;
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    localFrameLayout.setVisibility(i1);
    e(paramBoolean ^ true);
    if (paramBoolean) {
      a(2131434663, QQGuildTopBarLandLiveFragment.d());
    } else {
      a(2131434663, QQGuildTopBarLiveFragment.d());
    }
    f(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    this.g.setVisibility(i1);
    this.h.setVisibility(i1);
    this.k.setVisibility(i1);
    this.n.setVisibility(i1);
  }
  
  private void f(boolean paramBoolean)
  {
    if (getContext() == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setVideoFullScreen fullScreen:");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("QGL.QQGuildLiveRoomFragment", 1, ((StringBuilder)localObject).toString());
    localObject = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    if (paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      ((RelativeLayout.LayoutParams)localObject).height = -1;
      if (Build.VERSION.SDK_INT >= 17) {
        ((RelativeLayout.LayoutParams)localObject).removeRule(3);
      }
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      ((RelativeLayout.LayoutParams)localObject).height = (DisplayUtil.a(getContext()).a * 9 / 16);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131434650);
    }
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void g(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ThreadManagerV2.getUIHandlerV2().post(new QQGuildLiveRoomFragment.10(this));
      return;
    }
    if (this.p)
    {
      QLog.i("QGL.QQGuildLiveRoomFragment", 1, "mNeedExitRoomIfZoomFloatFailure.");
      QQGuildLiveRoomCommMgr.a().e();
      this.p = false;
      return;
    }
    if (this.q)
    {
      if (((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), Boolean.valueOf(false))).booleanValue()) {
        t();
      } else {
        f();
      }
      this.q = false;
    }
  }
  
  private void j()
  {
    if (getActivity() != null)
    {
      int i3 = LiuHaiUtils.b(getActivity());
      int i1;
      if (getActivity().getRequestedOrientation() == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i2 = i3;
      if (i1 == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LiuHaiUtils.sNotchHeight=");
        ((StringBuilder)localObject).append(LiuHaiUtils.d);
        QLog.i("QGL.QQGuildLiveRoomFragment", 1, ((StringBuilder)localObject).toString());
        i2 = i3;
        if (LiuHaiUtils.d > 0) {
          i2 = LiuHaiUtils.d;
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("marginTop=");
      ((StringBuilder)localObject).append(i2);
      QLog.i("QGL.QQGuildLiveRoomFragment", 1, ((StringBuilder)localObject).toString());
      localObject = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, i2, 0, 0);
      this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void k()
  {
    if (getActivity() != null)
    {
      LiuHaiUtils.f(getActivity());
      LiuHaiUtils.enableNotch(getActivity());
      LiuHaiUtils.i(getActivity());
    }
  }
  
  private boolean l()
  {
    FragmentActivity localFragmentActivity = getActivity();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFragmentActivity != null)
    {
      bool1 = bool2;
      if (getActivity().getRequestedOrientation() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QGL.QQGuildLiveRoomFragment", 1, "initAudienceFragments.");
    }
    a(2131434624, QQGuildChatBarLiveFragment.d());
    a(2131434672, QQGuildVideoBarLiveFragment.d());
    a(2131434659, QQGuildSubVideoBarLiveFragment.d());
    a(2131434650, QQGuildSubTopBarLiveFragment.d());
    a(2131434663, QQGuildTopBarLiveFragment.d());
  }
  
  private void n()
  {
    if (getActivity() != null)
    {
      int i1;
      if (getActivity().getRequestedOrientation() == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        this.u.b();
        return;
      }
      ((Boolean)LiveDataExtKt.a(QQGuildLiveRoomUiData.a().b(), Boolean.valueOf(false))).booleanValue();
      this.u.c();
    }
  }
  
  private boolean o()
  {
    if (this.f == null) {
      this.f = new FloatWindowPermissionHandler(getActivity());
    }
    boolean bool = this.f.a();
    if (!bool)
    {
      this.f.a(new QQGuildLiveRoomFragment.9(this));
      this.f.b();
      return bool;
    }
    q();
    return bool;
  }
  
  private boolean p()
  {
    if (this.f == null) {
      this.f = new FloatWindowPermissionHandler(getActivity());
    }
    boolean bool = this.f.a();
    q();
    return bool;
  }
  
  private void q()
  {
    FloatWindowPermissionHandler localFloatWindowPermissionHandler = this.f;
    if (localFloatWindowPermissionHandler != null)
    {
      localFloatWindowPermissionHandler.c();
      this.f = null;
    }
  }
  
  private void r()
  {
    if (!this.r)
    {
      QLog.i("QGL.QQGuildLiveRoomFragment", 1, "need try enter float window.");
      this.d.a(false);
      this.p = true;
      b(true);
    }
    else if (this.s)
    {
      b(false);
    }
    this.s = false;
    this.r = false;
  }
  
  private boolean s()
  {
    if (p()) {
      return true;
    }
    this.q = true;
    b(true);
    return false;
  }
  
  private void t()
  {
    if (getContext() == null) {
      return;
    }
    String str1 = getResources().getString(2131890431);
    String str2 = getResources().getString(2131890432);
    String str3 = getResources().getString(2131890433);
    DialogUtil.a(getContext(), 230, null, str1, str2, str3, new QQGuildLiveRoomFragment.11(this), new QQGuildLiveRoomFragment.12(this)).show();
  }
  
  protected void a()
  {
    this.d = ((QQGuildLiveRoomVM)QQGuildLiveViewModelProvider.a(this).get(QQGuildLiveRoomVM.class));
    this.d.b();
    this.e = ((QQGuildAnchorInfoVM)QQGuildLiveViewModelProvider.a(this).get(QQGuildAnchorInfoVM.class));
    this.e.e();
  }
  
  protected void a(@NonNull View paramView)
  {
    this.u = ((GuildLiveSwipeBackLayout)paramView.findViewById(2131434640));
    this.u.b();
    this.u.setOnPageSwipeListener(this);
    this.u.setOnSwipeListener(this);
    this.v = paramView.findViewById(2131434661);
    this.t = ((GuildLiveBlurURLImageView)paramView.findViewById(2131434639));
    this.l = paramView.findViewById(2131434663);
    this.j = ((FrameLayout)paramView.findViewById(2131434672));
    this.i = ((FrameLayout)paramView.findViewById(2131434659));
    this.h = ((FrameLayout)paramView.findViewById(2131434650));
    this.g = ((FrameLayout)paramView.findViewById(2131434624));
    this.k = ((FrameLayout)paramView.findViewById(2131434636));
    this.n = ((FrameLayout)paramView.findViewById(2131434642));
    this.o = new GuildLiveGiftMsgAnimView(getContext());
    a(this.n, this.o);
    this.m = ((FrameLayout)paramView.findViewById(2131434628));
    k();
    j();
    a(this.i);
    m();
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void a(@NonNull QQGuildEndLiveModel paramQQGuildEndLiveModel)
  {
    if ((getActivity() != null) && (getActivity().getRequestedOrientation() == 0)) {
      getActivity().setRequestedOrientation(1);
    }
    this.d.b(false);
    if (this.a.d() != null) {
      this.a.d().a(paramQQGuildEndLiveModel);
    }
  }
  
  public void a(@Nullable String paramString)
  {
    this.d.a(false);
    if ((!TextUtils.isEmpty(paramString)) && (getContext() != null))
    {
      QLog.i("QGL.QQGuildLiveRoomFragment", 1, "onAutoExitRoomPage. showDialog.");
      paramString = DialogUtil.a(getContext(), 230, null, paramString, null, getString(2131890251), new QQGuildLiveRoomFragment.7(this), null);
      paramString.setOnCancelListener(new QQGuildLiveRoomFragment.8(this));
      paramString.show();
      return;
    }
    QLog.i("QGL.QQGuildLiveRoomFragment", 1, "onAutoExitRoomPage. finishActivity.");
    f();
  }
  
  public void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    this.k.setVisibility(i1);
    this.n.setVisibility(i1);
  }
  
  protected int b()
  {
    return 2131625058;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!o())) {
      return;
    }
    if ((!paramBoolean) && (!p()))
    {
      f();
      return;
    }
    Object localObject1 = QQGuildLiveRoomUiData.a();
    Object localObject2 = (Boolean)((QQGuildLiveRoomUiData)localObject1).e().getValue();
    int i2 = 1;
    int i1;
    if ((localObject2 != null) && (!((Boolean)localObject2).booleanValue())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      i2 = 2;
    }
    localObject1 = (View)((QQGuildLiveRoomUiData)localObject1).d().getValue();
    localObject2 = QQGuildLiveStartParamsCache.a().getChannelInfo();
    IGProGuildInfo localIGProGuildInfo = QQGuildLiveStartParamsCache.a().getGuildInfo();
    this.d.a(false);
    f();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130772128);
    }
    GuildFloatWindowUtils.a((View)localObject1, localIGProGuildInfo, (IGProChannelInfo)localObject2, i2);
  }
  
  public boolean c(boolean paramBoolean)
  {
    if ((paramBoolean) && (!p())) {
      return s();
    }
    return true;
  }
  
  protected void cs_()
  {
    this.d.g().observe(getViewLifecycleOwner(), new QQGuildLiveRoomFragment.1(this));
    this.d.e().observe(getViewLifecycleOwner(), new QQGuildLiveRoomFragment.2(this));
    QQGuildLiveRoomUiData.a().i().observe(getViewLifecycleOwner(), new QQGuildLiveRoomFragment.3(this));
    this.d.h().observe(getViewLifecycleOwner(), new QQGuildLiveRoomFragment.4(this));
    this.e.d().observe(getViewLifecycleOwner(), new QQGuildLiveRoomFragment.5(this));
    QQGuildLiveRoomUiData.a().b().observe(getViewLifecycleOwner(), new QQGuildLiveRoomFragment.6(this));
  }
  
  public FrameLayout d()
  {
    return this.m;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public void f()
  {
    this.r = true;
    super.f();
  }
  
  public void g()
  {
    this.s = true;
    f();
  }
  
  public void h() {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if ((getArguments() != null) && (getArguments().getBoolean("arg_from_float")))
    {
      paramActivity.overridePendingTransition(2130772127, 0);
      return;
    }
    paramActivity.overridePendingTransition(2130772129, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    QQGuildLiveEventHelper.a().a(this);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public boolean onBackEvent()
  {
    if ((getActivity() != null) && (getActivity().getRequestedOrientation() == 0))
    {
      getActivity().setRequestedOrientation(1);
      return true;
    }
    if (!super.onBackEvent())
    {
      if (!p())
      {
        s();
        return true;
      }
      this.s = true;
      f();
    }
    return true;
  }
  
  public void onConfigurationChanged(@NonNull Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnConfigurationChanged newConfig.orientation=");
      localStringBuilder.append(paramConfiguration.orientation);
      QLog.i("QGL.QQGuildLiveRoomFragment", 1, localStringBuilder.toString());
    }
    int i2 = paramConfiguration.orientation;
    int i1 = 0;
    boolean bool;
    if (i2 == 2) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      QQGuildUIUtil.a(getActivity(), false, false);
    } else {
      QQGuildUIUtil.a(getActivity(), true, true);
    }
    d(bool);
    j();
    n();
    paramConfiguration = this.v;
    if (bool) {
      i1 = 8;
    }
    paramConfiguration.setVisibility(i1);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    if (getArguments() != null)
    {
      Serializable localSerializable = getArguments().getSerializable("arg_start_params");
      if ((localSerializable instanceof QQGuildLiveRoomStartParams)) {
        QQGuildLiveStartParamsCache.a((QQGuildLiveRoomStartParams)localSerializable);
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    r();
    this.d.i();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((getView() instanceof ViewGroup)) {
      ((ViewGroup)getView()).removeAllViews();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    QQGuildLiveEventHelper.a().b(this);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.d.a(paramIntent))
    {
      this.d.b(false);
      if ((getActivity() != null) && (getActivity().getRequestedOrientation() == 0)) {
        getActivity().setRequestedOrientation(1);
      }
    }
  }
  
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.remove("android:viewHierarchyState");
    paramBundle.remove("android:fragments");
    paramBundle.remove("android:support:fragments");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.QQGuildLiveRoomFragment
 * JD-Core Version:    0.7.0.1
 */