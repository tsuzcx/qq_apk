package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.live.QQGuildLiveRoomStartParams;
import com.tencent.mobileqq.guild.live.QQGuildLiveStartParamsCache;
import com.tencent.mobileqq.guild.widget.BlurBGImageView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/MoreSetDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "mBlurView", "Lcom/tencent/mobileqq/guild/widget/BlurBGImageView;", "mChannelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mComment", "Landroid/widget/ImageView;", "mCommentTv", "Landroid/widget/TextView;", "mGift", "mGiftTv", "mHasBanComment", "", "mHasBanGift", "", "initBlurView", "", "initIconStatus", "view", "Landroid/view/View;", "onClick", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "setLiveComment", "setLiveGift", "updateDialog", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class MoreSetDialog
  extends DialogFragment
  implements View.OnClickListener
{
  private final String a = "MoreSetDialog";
  private BlurBGImageView b;
  private ImageView c;
  private TextView d;
  private ImageView e;
  private TextView f;
  private IGProChannelInfo g;
  private int h;
  private boolean i;
  private HashMap j;
  
  public MoreSetDialog()
  {
    setStyle(2, getTheme());
  }
  
  private final void a(View paramView)
  {
    Object localObject = paramView.findViewById(2131436400);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.iv_guild_live_comment)");
    this.c = ((ImageView)localObject);
    localObject = paramView.findViewById(2131448512);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.tv_guild_live_comment)");
    this.d = ((TextView)localObject);
    localObject = paramView.findViewById(2131436401);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view.findViewById(R.id.iv_guild_live_gift)");
    this.e = ((ImageView)localObject);
    paramView = paramView.findViewById(2131448513);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.tv_guild_live_gift)");
    this.f = ((TextView)paramView);
    paramView = this.g;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    this.h = paramView.getBannedSpeak();
    if (this.h == 1)
    {
      paramView = this.c;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mComment");
      }
      paramView.setImageDrawable(getResources().getDrawable(2130840833));
      paramView = this.d;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCommentTv");
      }
      paramView.setText(2131890443);
    }
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mComment");
    }
    paramView = (View.OnClickListener)this;
    ((ImageView)localObject).setOnClickListener(paramView);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mGift");
    }
    ((ImageView)localObject).setOnClickListener(paramView);
  }
  
  private final void b()
  {
    Dialog localDialog = getDialog();
    if (localDialog != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localDialog, "dialog ?: return");
      Window localWindow = localDialog.getWindow();
      if (localWindow != null)
      {
        localWindow.setLayout(-1, -2);
        localWindow.setGravity(80);
      }
      localDialog.setCanceledOnTouchOutside(true);
    }
  }
  
  private final void c()
  {
    if (getView() != null)
    {
      Object localObject1 = requireView().findViewById(2131429645);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "requireView().findViewById(R.id.bottom_blur)");
      this.b = ((BlurBGImageView)localObject1);
      localObject1 = this.b;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
      }
      ((BlurBGImageView)localObject1).setScaleFactor(8);
      localObject1 = this.b;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mBlurView");
      }
      Object localObject2 = requireActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "requireActivity()");
      localObject2 = ((FragmentActivity)localObject2).getWindow();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "requireActivity().window");
      ((BlurBGImageView)localObject1).a(((Window)localObject2).getDecorView());
    }
  }
  
  private final void d()
  {
    if (this.h == 1)
    {
      this.h = 0;
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mComment");
      }
      ((ImageView)localObject).setImageDrawable(getResources().getDrawable(2130840832));
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCommentTv");
      }
      ((TextView)localObject).setText(2131890425);
    }
    else
    {
      this.h = 1;
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mComment");
      }
      ((ImageView)localObject).setImageDrawable(getResources().getDrawable(2130840833));
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mCommentTv");
      }
      ((TextView)localObject).setText(2131890443);
    }
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "appRuntime.getRuntimeSer…va, ProcessConstant.MAIN)");
    localObject = (IGPSService)localObject;
    IGProChannelInfo localIGProChannelInfo = this.g;
    if (localIGProChannelInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    ((IGPSService)localObject).setChannelBannedSpeak(localIGProChannelInfo.getChannelUin(), this.h, (IResultWithSecurityCallback)new MoreSetDialog.setLiveComment.1(this));
  }
  
  private final void e()
  {
    Object localObject;
    boolean bool;
    if (this.i)
    {
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mGift");
      }
      ((ImageView)localObject).setImageDrawable(getResources().getDrawable(2130840835));
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mGiftTv");
      }
      ((TextView)localObject).setText(2131890426);
      bool = false;
    }
    else
    {
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mGift");
      }
      ((ImageView)localObject).setImageDrawable(getResources().getDrawable(2130840836));
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mGiftTv");
      }
      ((TextView)localObject).setText(2131890444);
      bool = true;
    }
    this.i = bool;
  }
  
  public void a()
  {
    HashMap localHashMap = this.j;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    int k = paramView.getId();
    if (k == 2131436400) {
      d();
    } else if (k == 2131436401) {
      e();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131625070, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onStart()
  {
    super.onStart();
    b();
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramBundle = QQGuildLiveStartParamsCache.a();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "QQGuildLiveStartParamsCache.getCache()");
    paramBundle = paramBundle.getChannelInfo();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "QQGuildLiveStartParamsCache.getCache().channelInfo");
    this.g = paramBundle;
    paramBundle = this.g;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
    }
    if (paramBundle == null)
    {
      QLog.d(this.a, 1, "getCache().getChannelInfo() == null, please check it.");
      return;
    }
    paramView.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new MoreSetDialog.onViewCreated.1(this));
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.MoreSetDialog
 * JD-Core Version:    0.7.0.1
 */