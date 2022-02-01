package com.tencent.mobileqq.guild.audio.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.audio.AudioRoom;
import com.tencent.mobileqq.guild.audio.data.AudioRoomLiveData;
import com.tencent.mobileqq.guild.audio.data.DIALOG_STATUS;
import com.tencent.mobileqq.guild.audio.frame.FloatWindowPermissionHandler;
import com.tencent.mobileqq.guild.audio.frame.FloatWindowPermissionHandler.OnRequestPermissionListener;
import com.tencent.mobileqq.guild.audio.widget.QQGuildAudioChanelFloatingWrapper;
import com.tencent.mobileqq.guild.util.NavigationBarUtil;
import com.tencent.mobileqq.guild.util.QQGuildDisplayHelper;
import com.tencent.mobileqq.guild.window.GuildFloatWindowManager;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/audio/dialog/AudioRoomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "mBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "mChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mCloseDirectly", "", "mEnterRoom", "mEntranceType", "", "mFragment", "Lcom/tencent/mobileqq/guild/audio/dialog/QQGuildAudioDialogContent;", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mInitTopOffset", "mPermissionHandler", "Lcom/tencent/mobileqq/guild/audio/frame/FloatWindowPermissionHandler;", "mRootView", "Landroid/view/View;", "mScreenReceiver", "Landroid/content/BroadcastReceiver;", "mTriggerByHand", "calculateInitTopOffset", "calculateTopOffset", "getContentFragment", "initDialogBehavior", "", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "initDialogObserver", "initPermissionHandler", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "Landroid/content/DialogInterface;", "onStart", "onViewCreated", "view", "openFloatWindow", "registerReceiver", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioRoomDialog
  extends BottomSheetDialogFragment
{
  public static final AudioRoomDialog.Companion a = new AudioRoomDialog.Companion(null);
  private IGProGuildInfo b;
  private IGProChannelInfo c;
  private boolean d;
  private boolean e = true;
  private boolean f;
  private int g;
  private View h;
  private QQGuildAudioDialogContent i;
  private BottomSheetBehavior<FrameLayout> j;
  private FloatWindowPermissionHandler k;
  private final BroadcastReceiver l = (BroadcastReceiver)new AudioRoomDialog.mScreenReceiver.1(this);
  private int m;
  private HashMap n;
  
  private final void a(BottomSheetDialog paramBottomSheetDialog)
  {
    paramBottomSheetDialog = paramBottomSheetDialog.a();
    Intrinsics.checkExpressionValueIsNotNull(paramBottomSheetDialog, "dialog.behavior");
    this.j = paramBottomSheetDialog;
    paramBottomSheetDialog = this.j;
    if (paramBottomSheetDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
    }
    paramBottomSheetDialog.a(0);
    paramBottomSheetDialog = this.j;
    if (paramBottomSheetDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
    }
    paramBottomSheetDialog.b((BottomSheetBehavior.BottomSheetCallback)new AudioRoomDialog.initDialogBehavior.1(this));
    paramBottomSheetDialog = this.j;
    if (paramBottomSheetDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
    }
    paramBottomSheetDialog.a(false);
    paramBottomSheetDialog = this.j;
    if (paramBottomSheetDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
    }
    paramBottomSheetDialog.b(d());
    paramBottomSheetDialog = this.j;
    if (paramBottomSheetDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
    }
    paramBottomSheetDialog.a(0.5F);
    paramBottomSheetDialog = this.j;
    if (paramBottomSheetDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mBehavior");
    }
    paramBottomSheetDialog.d(3);
  }
  
  private final void b()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      BaseApplication.getContext().registerReceiver(this.l, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private final QQGuildAudioDialogContent c()
  {
    Object localObject = a;
    IGProGuildInfo localIGProGuildInfo = this.b;
    if (localIGProGuildInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
    }
    IGProChannelInfo localIGProChannelInfo = this.c;
    if (localIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    localObject = ((AudioRoomDialog.Companion)localObject).b(localIGProGuildInfo, localIGProChannelInfo, this.d, this.g);
    return QQGuildAudioDialogContent.a.a((Bundle)localObject);
  }
  
  private final int d()
  {
    this.m = (QQGuildDisplayHelper.b((Context)QBaseActivity.sTopActivity) - Utils.a(445.0F, getResources()) - NavigationBarUtil.a((Activity)getContext()));
    if (this.m < 0) {
      this.m = 0;
    }
    return this.m;
  }
  
  private final int e()
  {
    return QQGuildDisplayHelper.a((Context)QBaseActivity.sTopActivity) + Utils.a(24.0F, getResources());
  }
  
  private final void f()
  {
    AudioRoomLiveData.a.a().observe(getViewLifecycleOwner(), (Observer)new AudioRoomDialog.initDialogObserver.1(this));
    AudioRoomLiveData.a.b().observe(getViewLifecycleOwner(), (Observer)new AudioRoomDialog.initDialogObserver.2(this));
  }
  
  private final void g()
  {
    Object localObject = AudioRoom.b();
    IGProChannelInfo localIGProChannelInfo = this.c;
    if (localIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    if (!((AudioRoom)localObject).a(localIGProChannelInfo.getChannelUin())) {
      return;
    }
    localObject = this.k;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (!((FloatWindowPermissionHandler)localObject).a())
      {
        if (this.f) {
          return;
        }
        localObject = this.k;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        ((FloatWindowPermissionHandler)localObject).b();
        return;
      }
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
      }
      localIGProChannelInfo = this.c;
      if (localIGProChannelInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
      }
      GuildFloatWindowUtils.a((IGProGuildInfo)localObject, localIGProChannelInfo, true);
    }
  }
  
  private final void h()
  {
    this.k = new FloatWindowPermissionHandler((Activity)getActivity());
    FloatWindowPermissionHandler localFloatWindowPermissionHandler = this.k;
    if (localFloatWindowPermissionHandler == null) {
      Intrinsics.throwNpe();
    }
    localFloatWindowPermissionHandler.a((FloatWindowPermissionHandler.OnRequestPermissionListener)new AudioRoomDialog.initPermissionHandler.1(this));
  }
  
  public void a()
  {
    HashMap localHashMap = this.n;
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
        this.b = ((IGProGuildInfo)localSerializable);
        localSerializable = paramBundle.getSerializable("extra_guild_channel_info");
        if (localSerializable != null)
        {
          this.c = ((IGProChannelInfo)localSerializable);
          localSerializable = paramBundle.getSerializable("EXTRA_KEY_ENTER_ROOM");
          if (localSerializable != null)
          {
            this.d = ((Boolean)localSerializable).booleanValue();
            paramBundle = paramBundle.getSerializable("extra_entrance_from");
            if (paramBundle != null) {
              this.g = ((Integer)paramBundle).intValue();
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
    b();
    h();
  }
  
  @NotNull
  public Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    super.onCreateDialog(paramBundle);
    paramBundle = super.onCreateDialog(paramBundle);
    if (paramBundle != null)
    {
      BottomSheetDialog localBottomSheetDialog = (BottomSheetDialog)paramBundle;
      localBottomSheetDialog.setContentView(2131624990);
      paramBundle = localBottomSheetDialog.getWindow();
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "dialog.window");
      paramBundle.getAttributes().windowAnimations = 2131952042;
      a(localBottomSheetDialog);
      paramBundle = this.c;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
      }
      String str1 = paramBundle.getChannelUin();
      paramBundle = GuildFloatWindowManager.a;
      String str2 = QQGuildAudioChanelFloatingWrapper.CLASS_NAME;
      Intrinsics.checkExpressionValueIsNotNull(str2, "QQGuildAudioChanelFloatingWrapper.CLASS_NAME");
      paramBundle = paramBundle.c(str2);
      if (paramBundle != null) {
        paramBundle = paramBundle.getChannelUin();
      } else {
        paramBundle = null;
      }
      if (str1.equals(paramBundle)) {
        GuildFloatWindowUtils.a();
      }
      if (Intrinsics.areEqual((Boolean)AudioRoomLiveData.a.c().getValue(), Boolean.valueOf(true))) {
        localBottomSheetDialog.getWindow().clearFlags(2);
      }
      AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.OPEN);
      return (Dialog)localBottomSheetDialog;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131624990, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…dialog, container, false)");
    this.h = paramLayoutInflater;
    this.i = c();
    paramLayoutInflater = this.i;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mFragment");
    }
    paramViewGroup = getDialog();
    if (paramViewGroup != null)
    {
      paramLayoutInflater.a((BottomSheetDialog)paramViewGroup);
      paramLayoutInflater = getChildFragmentManager().beginTransaction();
      paramViewGroup = this.i;
      if (paramViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
      }
      paramLayoutInflater.replace(2131428847, (Fragment)paramViewGroup).commit();
      paramLayoutInflater = this.h;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
      }
      AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
  }
  
  public void onDismiss(@NotNull DialogInterface paramDialogInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramDialogInterface, "dialog");
    super.onDismiss(paramDialogInterface);
    AudioRoomLiveData.a.a().postValue(DIALOG_STATUS.UNKNOWN);
    BaseApplication.getContext().unregisterReceiver(this.l);
    g();
    this.f = false;
    AudioRoomLiveData.a.b().postValue(null);
  }
  
  public void onStart()
  {
    super.onStart();
    f();
    Object localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    localObject = ((View)localObject).getParent();
    if (localObject != null)
    {
      ((View)localObject).setBackgroundColor(0);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void show(@NotNull FragmentManager paramFragmentManager, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFragmentManager, "manager");
    Field localField = DialogFragment.class.getDeclaredField("mDismissed");
    Intrinsics.checkExpressionValueIsNotNull(localField, "dismissed");
    localField.setAccessible(true);
    localField.set(this, Boolean.valueOf(false));
    localField = DialogFragment.class.getDeclaredField("mShownByMe");
    Intrinsics.checkExpressionValueIsNotNull(localField, "shownByMe");
    localField.setAccessible(true);
    localField.set(this, Boolean.valueOf(true));
    paramFragmentManager = paramFragmentManager.beginTransaction();
    Intrinsics.checkExpressionValueIsNotNull(paramFragmentManager, "manager.beginTransaction()");
    paramFragmentManager.add((Fragment)this, paramString);
    paramFragmentManager.commitAllowingStateLoss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.AudioRoomDialog
 * JD-Core Version:    0.7.0.1
 */