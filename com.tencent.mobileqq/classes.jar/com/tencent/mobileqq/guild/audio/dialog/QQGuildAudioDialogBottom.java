package com.tencent.mobileqq.guild.audio.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.audio.AudioRoom;
import com.tencent.mobileqq.guild.audio.AudioRoom.IEnterRoomCallback;
import com.tencent.mobileqq.guild.audio.AudioRoomObserver;
import com.tencent.mobileqq.guild.audio.AudioRouter;
import com.tencent.mobileqq.guild.audio.data.LocalUserInfo;
import com.tencent.mobileqq.guild.audio.widget.MicSpeakDrawable;
import com.tencent.mobileqq.guild.window.GuildFloatWindowManager;
import com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogBottom;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/audio/dialog/IAudioDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mApp", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "mAudioRoomObserver", "Lcom/tencent/mobileqq/guild/audio/AudioRoomObserver;", "mAudioRoute", "Ljava/util/concurrent/atomic/AtomicInteger;", "mBlurView", "Lcom/tencent/mobileqq/widget/QQBlurView;", "mChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mCheckBox", "Landroid/widget/CheckBox;", "mConfig", "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", "mGlobalMute", "", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mHandUp", "Landroid/widget/ImageView;", "mInRoomFl", "Landroid/view/View;", "mJoinBtn", "Landroid/widget/Button;", "mLastClickMills", "", "mLoadingAnim", "Landroid/view/animation/RotateAnimation;", "mLoadingImg", "mLoadingPanel", "Landroid/widget/LinearLayout;", "mMicEnabled", "mMicOnDrawable", "Lcom/tencent/mobileqq/guild/audio/widget/MicSpeakDrawable;", "mOutRoomFl", "mProtocol", "Landroid/widget/TextView;", "mQQPermission", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "mRootView", "mTips", "mTipsLayout", "mTrumpet", "mVoiceMic", "removeTipsRunnable", "Ljava/lang/Runnable;", "checkPermission", "create", "", "guildInfo", "channelInfo", "app", "createTipsView", "tipsLayout", "destroy", "enterRoom", "handleHandup", "handleJoinRoom", "handleProtocol", "handleTrumpt", "handleVoice", "initBlurView", "bgView", "initView", "onClick", "v", "refreshUI", "selfUserInfo", "Lcom/tencent/mobileqq/guild/audio/data/LocalUserInfo;", "showJoinAndClsLoading", "showTips", "tips", "", "start", "startLoadingAnim", "switchBottomUI", "inRoom", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildAudioDialogBottom
  extends FrameLayout
  implements View.OnClickListener, IAudioDialogView
{
  public static final QQGuildAudioDialogBottom.Companion a = new QQGuildAudioDialogBottom.Companion(null);
  private final AudioRoomObserver A = (AudioRoomObserver)new QQGuildAudioDialogBottom.mAudioRoomObserver.1(this);
  private final Runnable B = (Runnable)new QQGuildAudioDialogBottom.removeTipsRunnable.1(this);
  private View b;
  private View c;
  private View d;
  private Button e;
  private TextView f;
  private CheckBox g;
  private ImageView h;
  private ImageView i;
  private ImageView j;
  private QQBlurView k;
  private LinearLayout l;
  private ImageView m;
  private FrameLayout n;
  private TextView o;
  private MicSpeakDrawable p;
  private IGProGuildInfo q;
  private IGProChannelInfo r;
  private BaseQQAppInterface s;
  private boolean t;
  private final AtomicInteger u = new AtomicInteger(-1);
  private boolean v = true;
  private QQPermission w;
  private final BusinessConfig x = new BusinessConfig("biz_src_qqchannel_audio", "enter_audio_room");
  private RotateAnimation y;
  private long z;
  
  public QQGuildAudioDialogBottom(@NotNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public QQGuildAudioDialogBottom(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQGuildAudioDialogBottom(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final void a(Context paramContext)
  {
    paramContext = FrameLayout.inflate(paramContext, 2131624991, (ViewGroup)this);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "inflate(context, R.layou…_dialog_bottom_bar, this)");
    this.d = paramContext;
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428862);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_outroom_fl)");
    this.b = paramContext;
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428854);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_inroom_fl)");
    this.c = paramContext;
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428857);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_join_btn)");
    this.e = ((Button)paramContext);
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428844);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_checkbox)");
    this.g = ((CheckBox)paramContext);
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131448950);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.txt_protocol_details)");
    this.f = ((TextView)paramContext);
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428873);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_voice_iv)");
    this.h = ((ImageView)paramContext);
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428872);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_trumpet_iv)");
    this.i = ((ImageView)paramContext);
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428851);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_handup_iv)");
    this.j = ((ImageView)paramContext);
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131429645);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.bottom_blur)");
    this.k = ((QQBlurView)paramContext);
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428859);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_loading_ll)");
    this.l = ((LinearLayout)paramContext);
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext = paramContext.findViewById(2131428858);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.audio_loading)");
    this.m = ((ImageView)paramContext);
    int i1 = getResources().getDimensionPixelOffset(2131297582);
    this.p = new MicSpeakDrawable(getContext(), i1, i1);
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mJoinBtn");
    }
    paramContext = (View.OnClickListener)this;
    ((Button)localObject).setOnClickListener(paramContext);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mProtocol");
    }
    ((TextView)localObject).setOnClickListener(paramContext);
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mVoiceMic");
    }
    ((ImageView)localObject).setOnClickListener(paramContext);
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTrumpet");
    }
    ((ImageView)localObject).setOnClickListener(paramContext);
    localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mHandUp");
    }
    ((ImageView)localObject).setOnClickListener(paramContext);
    paramContext = this.g;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
    }
    paramContext.setOnClickListener((View.OnClickListener)new QQGuildAudioDialogBottom.initView.1(this));
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    paramContext.setOnTouchListener((View.OnTouchListener)QQGuildAudioDialogBottom.initView.2.a);
  }
  
  private final void a(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return;
    }
    ThreadManager.getUIHandler().post((Runnable)new QQGuildAudioDialogBottom.showTips.1(this, paramString));
  }
  
  private final void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mOutRoomFl");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mInRoomFl");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mInRoomFl");
      }
      i1 = ((View)localObject).getLayoutParams().height;
    }
    else
    {
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mOutRoomFl");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mInRoomFl");
      }
      ((View)localObject).setVisibility(8);
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mOutRoomFl");
      }
      i1 = ((View)localObject).getLayoutParams().height;
    }
    Object localObject = this.k;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
    }
    localObject = ((QQBlurView)localObject).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i1;
    QQBlurView localQQBlurView = this.k;
    if (localQQBlurView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
    }
    localQQBlurView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final boolean d()
  {
    QQPermission localQQPermission = this.w;
    if (localQQPermission == null) {
      Intrinsics.throwNpe();
    }
    return localQQPermission.a("android.permission.RECORD_AUDIO") == 0;
  }
  
  private final void e()
  {
    DialogUtil.a(getContext(), 230, getContext().getString(2131890633), (CharSequence)getContext().getString(2131890253), null, getContext().getString(2131890251), (DialogInterface.OnClickListener)QQGuildAudioDialogBottom.handleProtocol.1.a, (DialogInterface.OnClickListener)null).show();
  }
  
  private final void f()
  {
    if (this.t)
    {
      DialogUtil.a(getContext(), 230, null, (CharSequence)getContext().getString(2131890258), null, getContext().getString(2131890251), (DialogInterface.OnClickListener)QQGuildAudioDialogBottom.handleVoice.1.a, (DialogInterface.OnClickListener)null).show();
      return;
    }
    Object localObject = (Map)new HashMap();
    int i1;
    if (this.v) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    ((Map)localObject).put("sgrp_voicechannel_microphone_condition", Integer.valueOf(i1));
    ImageView localImageView = this.h;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mVoiceMic");
    }
    VideoReport.reportEvent("clck", localImageView, (Map)localObject);
    localObject = getContext();
    if (this.v) {
      i1 = 2131890245;
    } else {
      i1 = 2131890260;
    }
    a(((Context)localObject).getString(i1));
    AudioRoom.b().a(this.v ^ true);
  }
  
  private final void g()
  {
    Object localObject = new HashMap();
    int i1 = this.u.get();
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            i1 = 0;
            break label52;
          }
        }
        else
        {
          i1 = 3;
          break label52;
        }
      }
      i1 = 2;
    }
    else
    {
      i1 = 1;
    }
    label52:
    localObject = (Map)localObject;
    ((Map)localObject).put("sgrp_voicechannel_loudspeaker_condition", Integer.valueOf(i1));
    ImageView localImageView = this.i;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTrumpet");
    }
    VideoReport.reportEvent("clck", localImageView, (Map)localObject);
    if (this.u.get() != 2)
    {
      if (this.u.get() == 3) {
        return;
      }
      i1 = AudioRouter.b(this.u.get());
      if (i1 == 1)
      {
        localObject = getContext().getString(2131890261);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "context.getString(R.stri…guild_audio_open_speaker)");
      }
      else if (i1 == 0)
      {
        localObject = getContext().getString(2131890247);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "context.getString(R.stri…uild_audio_close_speaker)");
      }
      else
      {
        localObject = "";
      }
      a((String)localObject);
      AudioRoom.b().a(i1);
    }
  }
  
  private final void h()
  {
    ImageView localImageView = this.j;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mHandUp");
    }
    VideoReport.reportEvent("clck", localImageView, null);
    AudioRoom.b().a(null);
  }
  
  private final void i()
  {
    AudioRoom localAudioRoom = AudioRoom.b();
    IGProChannelInfo localIGProChannelInfo = this.r;
    if (localIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    localAudioRoom.a(localIGProChannelInfo, (AudioRoom.IEnterRoomCallback)new QQGuildAudioDialogBottom.enterRoom.1(this));
  }
  
  private final void j()
  {
    this.y = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    Object localObject = this.y;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLoadingAnim");
    }
    ((RotateAnimation)localObject).setRepeatCount(-1);
    localObject = this.y;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLoadingAnim");
    }
    ((RotateAnimation)localObject).setDuration(1500L);
    localObject = this.y;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLoadingAnim");
    }
    ((RotateAnimation)localObject).setInterpolator((Interpolator)new LinearInterpolator());
    localObject = this.m;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLoadingImg");
    }
    RotateAnimation localRotateAnimation = this.y;
    if (localRotateAnimation == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLoadingAnim");
    }
    ((ImageView)localObject).startAnimation((Animation)localRotateAnimation);
  }
  
  private final void k()
  {
    Object localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLoadingPanel");
    }
    ((LinearLayout)localObject).setVisibility(8);
    localObject = this.y;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLoadingAnim");
    }
    ((RotateAnimation)localObject).cancel();
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mJoinBtn");
    }
    ((Button)localObject).setVisibility(0);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
    }
    ((CheckBox)localObject).setBackground(getResources().getDrawable(2130840692));
  }
  
  public void a()
  {
    BaseQQAppInterface localBaseQQAppInterface = this.s;
    if (localBaseQQAppInterface == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mApp");
    }
    localBaseQQAppInterface.addObserver((BusinessObserver)this.A);
  }
  
  public final void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "bgView");
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    QQBlurView localQQBlurView = this.k;
    if (localQQBlurView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
    }
    localQQBlurView.setVisibility(0);
    localQQBlurView.a(paramView);
    localQQBlurView.b((View)localQQBlurView);
    localQQBlurView.c(-1);
    localQQBlurView.setEnableBlur(bool);
    localQQBlurView.b(0);
    localQQBlurView.a(8.0F);
    localQQBlurView.a(8);
    localQQBlurView.d();
    localQQBlurView.a();
  }
  
  public final void a(@NotNull FrameLayout paramFrameLayout)
  {
    Intrinsics.checkParameterIsNotNull(paramFrameLayout, "tipsLayout");
    this.n = paramFrameLayout;
    paramFrameLayout = this.n;
    if (paramFrameLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mTipsLayout");
    }
    paramFrameLayout = paramFrameLayout.findViewById(2131434541);
    Intrinsics.checkExpressionValueIsNotNull(paramFrameLayout, "mTipsLayout.findViewById…id.guild_audio_tips_text)");
    this.o = ((TextView)paramFrameLayout);
  }
  
  public final void a(@NotNull LocalUserInfo paramLocalUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramLocalUserInfo, "selfUserInfo");
    a(paramLocalUserInfo.c);
    this.t = paramLocalUserInfo.p;
    this.v = paramLocalUserInfo.m;
    this.u.set(paramLocalUserInfo.d);
    Object localObject;
    if ((paramLocalUserInfo.m) && (!this.t))
    {
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceMic");
      }
      MicSpeakDrawable localMicSpeakDrawable = this.p;
      if (localMicSpeakDrawable == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mMicOnDrawable");
      }
      ((ImageView)localObject).setBackground((Drawable)localMicSpeakDrawable);
      localObject = this.p;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mMicOnDrawable");
      }
      ((MicSpeakDrawable)localObject).a(paramLocalUserInfo.n);
    }
    else
    {
      localObject = this.h;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceMic");
      }
      ((ImageView)localObject).setBackgroundResource(2130840721);
    }
    if ((paramLocalUserInfo.d != 0) && (paramLocalUserInfo.d != 3))
    {
      if (paramLocalUserInfo.d == 1)
      {
        paramLocalUserInfo = this.i;
        if (paramLocalUserInfo == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mTrumpet");
        }
        paramLocalUserInfo.setImageResource(2130840735);
        return;
      }
      if (paramLocalUserInfo.d == 2)
      {
        paramLocalUserInfo = this.i;
        if (paramLocalUserInfo == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mTrumpet");
        }
        paramLocalUserInfo.setImageResource(2130840711);
      }
    }
    else
    {
      paramLocalUserInfo = this.i;
      if (paramLocalUserInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mTrumpet");
      }
      paramLocalUserInfo.setImageResource(2130840732);
    }
  }
  
  public void a(@NotNull IGProGuildInfo paramIGProGuildInfo, @NotNull IGProChannelInfo paramIGProChannelInfo, @NotNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramIGProGuildInfo, "guildInfo");
    Intrinsics.checkParameterIsNotNull(paramIGProChannelInfo, "channelInfo");
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    this.q = paramIGProGuildInfo;
    this.r = paramIGProChannelInfo;
    this.s = paramBaseQQAppInterface;
    paramIGProGuildInfo = MobileQQ.getContext().getSharedPreferences("join_audioroom_preferences", 0);
    paramIGProChannelInfo = this.g;
    if (paramIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
    }
    paramBaseQQAppInterface = new StringBuilder();
    paramBaseQQAppInterface.append("allow_join_audioroom");
    Object localObject = this.s;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mApp");
    }
    localObject = ((BaseQQAppInterface)localObject).getRuntimeService(IGPSService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mApp.getRuntimeService(I…va, ProcessConstant.MAIN)");
    paramBaseQQAppInterface.append(((IGPSService)localObject).getSelfTinyId());
    paramIGProChannelInfo.setChecked(paramIGProGuildInfo.getBoolean(paramBaseQQAppInterface.toString(), false));
    paramIGProGuildInfo = this.e;
    if (paramIGProGuildInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mJoinBtn");
    }
    paramIGProChannelInfo = this.g;
    if (paramIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
    }
    paramIGProGuildInfo.setEnabled(paramIGProChannelInfo.isChecked());
  }
  
  public void b()
  {
    Object localObject = this.k;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
    }
    if (localObject != null) {
      ((QQBlurView)localObject).c();
    }
    localObject = this.s;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mApp");
    }
    ((BaseQQAppInterface)localObject).removeObserver((BusinessObserver)this.A);
  }
  
  public final void c()
  {
    Object localObject1 = this.e;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mJoinBtn");
    }
    VideoReport.reportEvent("clck", localObject1, null);
    localObject1 = GuildLiveChannelFloatWrapper.class.getName();
    Object localObject2 = GuildFloatWindowManager.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "liveWindowClassName");
    if (((GuildFloatWindowManager)localObject2).b((String)localObject1))
    {
      QQToast.makeText(getContext(), 0, 2131890248, 0).show();
      return;
    }
    localObject1 = this.e;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mJoinBtn");
    }
    ((Button)localObject1).setVisibility(8);
    localObject1 = this.l;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mLoadingPanel");
    }
    ((LinearLayout)localObject1).setVisibility(0);
    localObject1 = this.g;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mCheckBox");
    }
    ((CheckBox)localObject1).setBackground(getResources().getDrawable(2130840690));
    j();
    if (this.w == null) {
      this.w = QQPermissionFactory.a((Activity)QBaseActivity.sTopActivity, this.x);
    }
    if (d())
    {
      i();
      localObject1 = MobileQQ.getContext().getSharedPreferences("join_audioroom_preferences", 0).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("allow_join_audioroom");
      Object localObject3 = this.s;
      if (localObject3 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mApp");
      }
      localObject3 = ((BaseQQAppInterface)localObject3).getRuntimeService(IGPSService.class, "");
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "mApp.getRuntimeService(I…va, ProcessConstant.MAIN)");
      ((StringBuilder)localObject2).append(((IGPSService)localObject3).getSelfTinyId());
      ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), true).apply();
      return;
    }
    localObject1 = this.w;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = (QQPermission.BasePermissionsListener)new QQGuildAudioDialogBottom.handleJoinRoom.1(this);
    ((QQPermission)localObject1).a(new String[] { "android.permission.RECORD_AUDIO" }, 2, (QQPermission.BasePermissionsListener)localObject2);
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (System.currentTimeMillis() - this.z < 500)
    {
      this.z = System.currentTimeMillis();
    }
    else
    {
      this.z = System.currentTimeMillis();
      int i1 = paramView.getId();
      if (i1 == 2131428857) {
        c();
      } else if (i1 == 2131448950) {
        e();
      } else if (i1 == 2131428873) {
        f();
      } else if (i1 == 2131428872) {
        g();
      } else if (i1 == 2131428851) {
        h();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioDialogBottom
 * JD-Core Version:    0.7.0.1
 */