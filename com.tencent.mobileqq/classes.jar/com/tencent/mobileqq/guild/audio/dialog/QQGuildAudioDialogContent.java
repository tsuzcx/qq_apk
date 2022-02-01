package com.tencent.mobileqq.guild.audio.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.audio.AudioRoom;
import com.tencent.mobileqq.guild.audio.AudioRoom.IInitCallback;
import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.widget.audiofaceview.AudioFacesView;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.NetworkState.NetworkStateListener;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogContent;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "mApp", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "mAudioFacesView", "Lcom/tencent/mobileqq/guild/audio/widget/audiofaceview/AudioFacesView;", "mAudioRoomObserver", "Lcom/tencent/mobileqq/guild/audio/AudioRoomObserver;", "mAvatarContainer", "Landroid/view/View;", "mBottomBar", "Lcom/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogBottom;", "mChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "mEnterRoom", "", "mEntranceType", "", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mIsExited", "mMainTipView", "mNetBarListener", "Landroid/view/View$OnClickListener;", "mNetTipView", "Lcom/tencent/mobileqq/banner/TipsBar;", "mNetworkListener", "Lcooperation/qzone/util/NetworkState$NetworkStateListener;", "mRootView", "Landroid/view/ViewGroup;", "mTitleBar", "Lcom/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogTitleBar;", "changeMargin", "", "margin", "filterWantedSource", "from", "", "fixBottomPanel", "fixTipsLayout", "init", "initBars", "initNetBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroyView", "onPause", "onViewCreated", "view", "setBottomPanelListener", "setDialog", "dialog", "setDtElement", "setDtPage", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildAudioDialogContent
  extends QPublicBaseFragment
{
  public static final QQGuildAudioDialogContent.Companion a = new QQGuildAudioDialogContent.Companion(null);
  private QQGuildAudioDialogTitleBar b;
  private QQGuildAudioDialogBottom c;
  private AudioFacesView d;
  private TipsBar e;
  private View f;
  private View g;
  private ViewGroup h;
  private BottomSheetDialog i;
  private BaseQQAppInterface j;
  private IGProGuildInfo k;
  private IGProChannelInfo l;
  private boolean m;
  private boolean n;
  private int o;
  private final NetworkState.NetworkStateListener p = (NetworkState.NetworkStateListener)new QQGuildAudioDialogContent.mNetworkListener.1(this);
  private final AudioRoomObserver q = (AudioRoomObserver)new QQGuildAudioDialogContent.mAudioRoomObserver.1(this);
  private final View.OnClickListener r = (View.OnClickListener)new QQGuildAudioDialogContent.mNetBarListener.1(this);
  private HashMap s;
  
  private final boolean a(String paramString)
  {
    return (Intrinsics.areEqual(paramString, "onFetchAudioChannelUserList")) || (Intrinsics.areEqual(paramString, "onAudioChannelUserExit"));
  }
  
  private final void c()
  {
    Object localObject1 = this.b;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
    }
    Object localObject2 = this.k;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
    }
    Object localObject3 = this.l;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    BaseQQAppInterface localBaseQQAppInterface = this.j;
    if (localBaseQQAppInterface == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mApp");
    }
    ((QQGuildAudioDialogTitleBar)localObject1).a((IGProGuildInfo)localObject2, (IGProChannelInfo)localObject3, localBaseQQAppInterface);
    localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    localObject2 = this.k;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
    }
    localObject3 = this.l;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    localBaseQQAppInterface = this.j;
    if (localBaseQQAppInterface == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mApp");
    }
    ((QQGuildAudioDialogBottom)localObject1).a((IGProGuildInfo)localObject2, (IGProChannelInfo)localObject3, localBaseQQAppInterface);
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAudioFacesView");
    }
    localObject2 = this.j;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mApp");
    }
    localObject3 = this.f;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mMainTipView");
    }
    ((AudioFacesView)localObject1).a((BaseQQAppInterface)localObject2, (View)localObject3, 3);
  }
  
  @SuppressLint({"UseRequireInsteadOfGet"})
  private final void d()
  {
    Object localObject1 = getContext();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context!!");
    this.c = new QQGuildAudioDialogBottom((Context)localObject1);
    localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDialog");
    }
    localObject1 = ((BottomSheetDialog)localObject1).getWindow();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mDialog.window");
    localObject1 = (CoordinatorLayout)((Window)localObject1).getDecorView().findViewById(2131431416);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "layout");
    localObject1 = ((CoordinatorLayout)localObject1).getParent();
    if (localObject1 != null)
    {
      localObject1 = (ViewGroup)localObject1;
      FrameLayout localFrameLayout = new FrameLayout(getContext());
      Object localObject2 = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject2).gravity = 80;
      localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.c;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
      }
      localFrameLayout.addView((View)localObject2);
      ((ViewGroup)localObject1).addView((View)localFrameLayout);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  private final void e()
  {
    Object localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDialog");
    }
    localObject1 = ((BottomSheetDialog)localObject1).getWindow();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mDialog.window");
    Object localObject3 = (CoordinatorLayout)((Window)localObject1).getDecorView().findViewById(2131431416);
    localObject1 = this.h;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    localObject1 = (FrameLayout)((ViewGroup)localObject1).findViewById(2131434540);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "tipsView");
    Object localObject2 = ((FrameLayout)localObject1).getParent();
    if (localObject2 != null)
    {
      Object localObject4 = (ViewGroup)localObject2;
      localObject2 = (View)localObject1;
      ((ViewGroup)localObject4).removeView((View)localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "layout");
      localObject3 = ((CoordinatorLayout)localObject3).getParent();
      if (localObject3 != null)
      {
        localObject3 = (ViewGroup)localObject3;
        localObject4 = new FrameLayout(getContext());
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 1;
        localLayoutParams.topMargin += Utils.a(600.0F, getResources());
        ((FrameLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
        ((FrameLayout)localObject4).addView((View)localObject2);
        localObject2 = this.c;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
        }
        ((QQGuildAudioDialogBottom)localObject2).a((FrameLayout)localObject1);
        ((ViewGroup)localObject3).addView((View)localObject4);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  private final void f()
  {
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNetTipView");
    }
    ((TipsBar)localObject).setBarType(4);
    TipsBar localTipsBar = this.e;
    if (localTipsBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNetTipView");
    }
    localObject = getContext();
    if (localObject != null) {
      localObject = ((Context)localObject).getString(2131892107);
    } else {
      localObject = null;
    }
    localTipsBar.setTipsText((CharSequence)localObject);
    localTipsBar = this.e;
    if (localTipsBar == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNetTipView");
    }
    localObject = getContext();
    if (localObject != null) {
      localObject = ((Context)localObject).getResources();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localTipsBar.setTipsIcon(((Resources)localObject).getDrawable(2130839452, null));
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNetTipView");
    }
    ((TipsBar)localObject).setOnClickListener(this.r);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNetTipView");
    }
    int i1;
    if (NetworkState.isNetSupport()) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((TipsBar)localObject).setVisibility(i1);
  }
  
  private final void g()
  {
    VideoReport.addToDetectionWhitelist((Activity)getActivity());
    Object localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mDialog");
    }
    localObject1 = ((BottomSheetDialog)localObject1).getWindow();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mDialog.window");
    Object localObject2 = (FrameLayout)((Window)localObject1).getDecorView().findViewById(2131431280);
    VideoReport.setPageId(localObject2, "pg_sgrp_voicechannel_aio");
    localObject1 = (Map)new HashMap();
    Object localObject3 = this.l;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    localObject3 = ((IGProChannelInfo)localObject3).getChannelName();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "mChannelInfo.channelName");
    ((Map)localObject1).put("sgrp_sub_channel_name", localObject3);
    localObject3 = this.l;
    if (localObject3 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    ((Map)localObject1).put("sgrp_sub_channel_capacity", Integer.valueOf(((IGProChannelInfo)localObject3).getChannelMemberMax()));
    localObject3 = (IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class);
    localObject2 = (View)localObject2;
    IGProChannelInfo localIGProChannelInfo = this.l;
    if (localIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    ((IGuildDTReportApi)localObject3).setChannelPageParams((View)localObject2, localIGProChannelInfo, (Map)localObject1);
  }
  
  private final void h()
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementId(((QQGuildAudioDialogBottom)localObject).findViewById(2131428857), "em_sgrp_voicechannel_join");
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementExposePolicy(((QQGuildAudioDialogBottom)localObject).findViewById(2131428857), ExposurePolicy.REPORT_ALL);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementClickPolicy(((QQGuildAudioDialogBottom)localObject).findViewById(2131428857), ClickPolicy.REPORT_ALL);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
    }
    VideoReport.setElementId(((QQGuildAudioDialogTitleBar)localObject).findViewById(2131428868), "em_sgrp_voicechannel_set");
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
    }
    VideoReport.setElementExposePolicy(((QQGuildAudioDialogTitleBar)localObject).findViewById(2131428868), ExposurePolicy.REPORT_ALL);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
    }
    VideoReport.setElementClickPolicy(((QQGuildAudioDialogTitleBar)localObject).findViewById(2131428868), ClickPolicy.REPORT_ALL);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
    }
    VideoReport.setElementId(((QQGuildAudioDialogTitleBar)localObject).findViewById(2131428855), "em_sgrp_voicechannel_top_invite");
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
    }
    VideoReport.setElementExposePolicy(((QQGuildAudioDialogTitleBar)localObject).findViewById(2131428855), ExposurePolicy.REPORT_ALL);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
    }
    VideoReport.setElementClickPolicy(((QQGuildAudioDialogTitleBar)localObject).findViewById(2131428855), ClickPolicy.REPORT_ALL);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementId(((QQGuildAudioDialogBottom)localObject).findViewById(2131428851), "em_sgrp_voicechannel_hangup");
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementExposePolicy(((QQGuildAudioDialogBottom)localObject).findViewById(2131428851), ExposurePolicy.REPORT_ALL);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementClickPolicy(((QQGuildAudioDialogBottom)localObject).findViewById(2131428851), ClickPolicy.REPORT_ALL);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementId(((QQGuildAudioDialogBottom)localObject).findViewById(2131428873), "em_sgrp_voicechannel_microphone");
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementExposePolicy(((QQGuildAudioDialogBottom)localObject).findViewById(2131428873), ExposurePolicy.REPORT_ALL);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementClickPolicy(((QQGuildAudioDialogBottom)localObject).findViewById(2131428873), ClickPolicy.REPORT_ALL);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementId(((QQGuildAudioDialogBottom)localObject).findViewById(2131428872), "em_sgrp_voicechannel_loudspeaker");
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementExposePolicy(((QQGuildAudioDialogBottom)localObject).findViewById(2131428872), ExposurePolicy.REPORT_ALL);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    VideoReport.setElementClickPolicy(((QQGuildAudioDialogBottom)localObject).findViewById(2131428872), ClickPolicy.REPORT_ALL);
  }
  
  private final void i()
  {
    AudioRoomLiveData.a.a().observe(getViewLifecycleOwner(), (Observer)new QQGuildAudioDialogContent.setBottomPanelListener.1(this));
  }
  
  public final void a()
  {
    Object localObject1 = this.b;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
    }
    ((QQGuildAudioDialogTitleBar)localObject1).a();
    localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    ((QQGuildAudioDialogBottom)localObject1).a();
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAudioFacesView");
    }
    Object localObject2 = this.k;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
    }
    IGProChannelInfo localIGProChannelInfo = this.l;
    if (localIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    ((AudioFacesView)localObject1).a((IGProGuildInfo)localObject2, localIGProChannelInfo);
    NetworkState.addListener(this.p);
    localObject1 = this.j;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mApp");
    }
    ((BaseQQAppInterface)localObject1).addObserver((BusinessObserver)this.q);
    localObject1 = AudioRoom.b();
    localObject2 = this.l;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    ((AudioRoom)localObject1).a((IGProChannelInfo)localObject2, (AudioRoom.IInitCallback)new QQGuildAudioDialogContent.init.1(this), this.m);
  }
  
  public final void a(int paramInt)
  {
    ViewGroup localViewGroup = this.h;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    QQGuildAudioDialogBottom localQQGuildAudioDialogBottom = this.c;
    if (localQQGuildAudioDialogBottom == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    localViewGroup.setPadding(0, 0, 0, paramInt + localQQGuildAudioDialogBottom.getHeight());
  }
  
  public final void a(@NotNull BottomSheetDialog paramBottomSheetDialog)
  {
    Intrinsics.checkParameterIsNotNull(paramBottomSheetDialog, "dialog");
    this.i = paramBottomSheetDialog;
  }
  
  public void b()
  {
    HashMap localHashMap = this.s;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      Serializable localSerializable = paramBundle.getSerializable("extra_guild_guild_info");
      if (localSerializable != null)
      {
        this.k = ((IGProGuildInfo)localSerializable);
        localSerializable = paramBundle.getSerializable("extra_guild_channel_info");
        if (localSerializable != null)
        {
          this.l = ((IGProChannelInfo)localSerializable);
          localSerializable = paramBundle.getSerializable("EXTRA_KEY_ENTER_ROOM");
          if (localSerializable != null)
          {
            this.m = ((Boolean)localSerializable).booleanValue();
            paramBundle = paramBundle.getSerializable("extra_entrance_from");
            if (paramBundle != null) {
              this.o = ((Integer)paramBundle).intValue();
            } else {
              throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo");
      }
    }
    paramBundle = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "qBaseActivity");
    paramBundle = paramBundle.getAppRuntime();
    if (paramBundle != null)
    {
      this.j = ((BaseQQAppInterface)paramBundle);
      paramBundle = this.j;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mApp");
      }
      AudioRoom.a(paramBundle);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131624992, null);
    if (paramLayoutInflater != null)
    {
      this.h = ((ViewGroup)paramLayoutInflater);
      paramLayoutInflater = this.h;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
      }
      paramLayoutInflater = (View)paramLayoutInflater;
      AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = AudioRoom.b();
    IGProChannelInfo localIGProChannelInfo = this.l;
    if (localIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    ((AudioRoom)localObject).a(localIGProChannelInfo);
    localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mApp");
    }
    ((BaseQQAppInterface)localObject).removeObserver((BusinessObserver)this.q);
    NetworkState.removeListener(this.p);
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
    }
    ((QQGuildAudioDialogTitleBar)localObject).b();
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    ((QQGuildAudioDialogBottom)localObject).b();
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAudioFacesView");
    }
    ((AudioFacesView)localObject).a();
    b();
  }
  
  public void onPause()
  {
    super.onPause();
    NetworkState.removeListener(this.p);
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramView = this.h;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramView = paramView.findViewById(2131434701);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "mRootView.findViewById(R.id.guild_nav_bar)");
    this.b = ((QQGuildAudioDialogTitleBar)paramView);
    paramView = this.h;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramView = paramView.findViewById(2131439202);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "mRootView.findViewById<TipsBar>(R.id.net_tips_bar)");
    this.e = ((TipsBar)paramView);
    paramView = this.h;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramView = paramView.findViewById(2131434533);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "mRootView.findViewById(R…d.guild_audio_heads_view)");
    this.d = ((AudioFacesView)paramView);
    paramView = this.d;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAudioFacesView");
    }
    paramView.a(getContext());
    paramView = this.h;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramView = paramView.findViewById(2131434539);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "mRootView.findViewById<V…uild_audio_main_tip_view)");
    this.f = paramView;
    paramView = this.h;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramView = paramView.findViewById(2131434532);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "mRootView.findViewById<V…d_audio_avatar_container)");
    this.g = paramView;
    d();
    e();
    c();
    f();
    i();
    g();
    h();
    paramView = this.c;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
    }
    paramBundle = this.g;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAvatarContainer");
    }
    paramView.a(paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogContent
 * JD-Core Version:    0.7.0.1
 */