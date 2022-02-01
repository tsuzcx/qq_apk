package com.tencent.timi.game.gift.impl.timi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.data.service.GiftListData;
import com.tencent.mobileqq.qqgift.data.service.GiftSendReqData;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.data.QQGiftDtParams;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.utils.Logger;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/TimiGiftPanelFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/qqgift/mvvm/business/view/IQQGiftPanelView$OnPanelEventListener;", "()V", "appId", "", "busId", "", "gameId", "gameType", "giftPanel", "Lcom/tencent/mobileqq/qqgift/mvvm/business/view/IQQGiftPanelView;", "giftSdk", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftSDK;", "programmeId", "receiverHead", "receiverNick", "receiverUin", "", "roomId", "rootView", "Landroid/view/View;", "senderHead", "senderNick", "senderUin", "source", "traceDetail", "initWindowStyleAndAnimation", "", "activity", "Landroid/app/Activity;", "needImmersive", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFinish", "onPanelHide", "onPanelItemClick", "data", "Lcom/tencent/mobileqq/qqgift/data/service/GiftServiceData;", "position", "onPanelItemSelected", "onPanelShow", "onPostThemeChanged", "onRechargeClick", "onSendGiftCallback", "isSuccess", "errCode", "onSendGiftCancel", "onSendGiftClick", "onSendGiftSuccess", "giftId", "giftName", "materialId", "effectLevel", "giftType", "giftNum", "hitSeq", "allHitCount", "onViewCreated", "view", "openGiftPanel", "setStatusBarImmersive", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGiftPanelFragment
  extends QPublicBaseFragment
  implements IQQGiftPanelView.OnPanelEventListener
{
  public static final TimiGiftPanelFragment.Companion a = new TimiGiftPanelFragment.Companion(null);
  private int b;
  private long c;
  private long d;
  private String e = "";
  private String f = "";
  private long g;
  private String h = "";
  private String i = "";
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  private IQQGiftSDK p;
  private IQQGiftPanelView q;
  private View r;
  private HashMap s;
  
  private final void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6)
  {
    Activity localActivity = (Activity)getActivity();
    if (localActivity != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("giftId: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" giftName: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" materialId: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" effectLevel: ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" giftType: ");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(" giftNum: ");
      ((StringBuilder)localObject).append(paramInt5);
      ((StringBuilder)localObject).append(" hitSeq: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" allHitCount: ");
      ((StringBuilder)localObject).append(paramInt6);
      ((StringBuilder)localObject).append(" sender: ");
      ((StringBuilder)localObject).append(LogUtil.wrapLogUin(String.valueOf(this.d)));
      ((StringBuilder)localObject).append(" senderHead: ");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(" sendNick: ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(" receiver: ");
      ((StringBuilder)localObject).append(LogUtil.wrapLogUin(String.valueOf(this.g)));
      ((StringBuilder)localObject).append(" receiverHead: ");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(" receiverNick: ");
      ((StringBuilder)localObject).append(this.h);
      Logger.b("TimiGiftPanelFragment", ((StringBuilder)localObject).toString());
      localActivity.setResult(-1);
      localObject = new GiftMessage();
      ((GiftMessage)localObject).effectLevel = paramInt3;
      ((GiftMessage)localObject).giftID = paramInt1;
      ((GiftMessage)localObject).giftName = paramString;
      ((GiftMessage)localObject).materialID = paramInt2;
      ((GiftMessage)localObject).giftType = paramInt4;
      ((GiftMessage)localObject).giftNum = paramInt5;
      ((GiftMessage)localObject).sender = this.d;
      ((GiftMessage)localObject).senderHead = this.f;
      ((GiftMessage)localObject).senderNick = this.e;
      ((GiftMessage)localObject).receiverNick = this.h;
      ((GiftMessage)localObject).receiverHead = this.i;
      ((GiftMessage)localObject).comboSeq = paramLong;
      ((GiftMessage)localObject).allComboCnt = paramInt6;
      paramString = this.q;
      if ((paramString != null) && (paramInt4 == 1) && (paramInt3 == 1))
      {
        if (paramString != null) {
          paramString.b();
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed((Runnable)new TimiGiftPanelFragment.onSendGiftSuccess.1(this, (GiftMessage)localObject, localActivity), 500L);
        return;
      }
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new TimiGiftPanelFragment.onSendGiftSuccess.2(this, (GiftMessage)localObject));
    }
  }
  
  private final void e()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity != null)
    {
      Object localObject1 = this.p;
      if ((localObject1 != null) && (localObject1 != null) && (!((IQQGiftSDK)localObject1).k()))
      {
        if (this.q == null)
        {
          localObject1 = this.p;
          localObject2 = null;
          if (localObject1 != null)
          {
            localObject1 = ((IQQGiftSDK)localObject1).e();
            if (localObject1 != null)
            {
              localObject1 = ((IQQGiftViewModule)localObject1).a(localQBaseActivity, 1);
              break label74;
            }
          }
          localObject1 = null;
          label74:
          this.q = ((IQQGiftPanelView)localObject1);
          IQQGiftPanelView localIQQGiftPanelView = this.q;
          if (localIQQGiftPanelView != null)
          {
            localObject1 = localObject2;
            if (localIQQGiftPanelView != null) {
              localObject1 = localIQQGiftPanelView.a((IQQGiftPanelView.OnPanelEventListener)this);
            }
            localIQQGiftPanelView.setPanelEventListener((IQQGiftPanelView.OnPanelEventListener)localObject1);
          }
        }
        localObject1 = new GiftListData();
        ((GiftListData)localObject1).a = 2;
        ((GiftListData)localObject1).b = this.j;
        ((GiftListData)localObject1).c = this.k;
        ((GiftListData)localObject1).d = String.valueOf(this.g);
        Object localObject2 = this.q;
        if (localObject2 != null) {
          ((IQQGiftPanelView)localObject2).setSceneData((GiftListData)localObject1);
        }
        localObject1 = this.q;
        if (localObject1 != null)
        {
          localObject2 = new QQGiftDtParams();
          ((QQGiftDtParams)localObject2).a = this.n;
          ((QQGiftDtParams)localObject2).b = String.valueOf(this.d);
          ((QQGiftDtParams)localObject2).c = String.valueOf(this.g);
          ((QQGiftDtParams)localObject2).d = String.valueOf(this.c);
          ((QQGiftDtParams)localObject2).e = this.l;
          ((QQGiftDtParams)localObject2).f = "0";
          ((QQGiftDtParams)localObject2).g = this.o;
          ((QQGiftDtParams)localObject2).h = this.m;
          ((QQGiftDtParams)localObject2).i = "0";
          ((QQGiftDtParams)localObject2).j = "0";
          ((IQQGiftPanelView)localObject1).setDtParams((QQGiftDtParams)localObject2);
        }
        localObject1 = this.r;
        if (localObject1 != null)
        {
          localObject2 = this.q;
          if (localObject2 != null) {
            ((IQQGiftPanelView)localObject2).a((View)localObject1);
          }
        }
        else
        {
          QLog.d("TimiGiftPanelFragment", 1, "[openGiftPanel] rootView is null!");
          localQBaseActivity.setResult(0);
          localQBaseActivity.finish();
        }
      }
    }
  }
  
  private final void f()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.setResult(0);
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed((Runnable)new TimiGiftPanelFragment.onSendGiftCancel.1(this), 500L);
  }
  
  private final void g()
  {
    if (getQBaseActivity() == null)
    {
      QLog.e("TimiGiftPanelFragment", 1, "setStatusBarImmersive qBaseActivity is null");
      return;
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      if (getQBaseActivity().mSystemBarComp == null)
      {
        getQBaseActivity().setImmersiveStatus(0);
        return;
      }
      getQBaseActivity().mSystemBarComp.setStatusBarDrawable(null);
      getQBaseActivity().mSystemBarComp.setStatusBarColor(0);
      getQBaseActivity().mSystemBarComp.setStatusColor(0);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(@Nullable GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean, @Nullable GiftServiceData paramGiftServiceData, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSendGiftCallback: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramInt);
    Logger.c("TimiGiftPanelFragment", localStringBuilder.toString());
    if ((paramBoolean) && (paramGiftServiceData != null)) {
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new TimiGiftPanelFragment.onSendGiftCallback.1(this, paramGiftServiceData));
    }
    return false;
  }
  
  public boolean b()
  {
    f();
    return false;
  }
  
  public boolean b(@Nullable GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean c(@Nullable GiftServiceData paramGiftServiceData, int paramInt)
  {
    if (paramGiftServiceData == null) {
      return true;
    }
    paramGiftServiceData = new GiftSendReqData();
    paramGiftServiceData.a = this.d;
    paramGiftServiceData.b = this.g;
    Object localObject = paramGiftServiceData.f;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "giftSendReqData.extData");
    ((Map)localObject).put("room_id", String.valueOf(this.c));
    localObject = this.p;
    if (localObject != null)
    {
      localObject = ((IQQGiftSDK)localObject).d();
      if (localObject != null) {
        ((IQQGiftServiceModule)localObject).a(paramGiftServiceData);
      }
    }
    return false;
  }
  
  public void d()
  {
    HashMap localHashMap = this.s;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void initWindowStyleAndAnimation(@Nullable Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    if (paramViewGroup != null)
    {
      this.r = ((View)new FrameLayout(paramViewGroup.getContext()));
      g();
      paramLayoutInflater = this.r;
    }
    else
    {
      paramLayoutInflater = null;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onPostThemeChanged()
  {
    g();
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      Intent localIntent = paramBundle.getIntent();
      if (localIntent != null)
      {
        this.b = localIntent.getIntExtra("extra_business_id", 0);
        this.c = localIntent.getLongExtra("extra_room_id", 0L);
        this.d = localIntent.getLongExtra("extra_sender_uin", 0L);
        paramBundle = localIntent.getStringExtra("extra_sender_nick");
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getStringExtra(EXT_SENDER_NICK)");
        this.e = paramBundle;
        paramBundle = localIntent.getStringExtra("extra_sender_head");
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getStringExtra(EXT_SENDER_HEAD)");
        this.f = paramBundle;
        this.g = localIntent.getLongExtra("extra_receiver_uin", 0L);
        paramBundle = localIntent.getStringExtra("extra_receiver_nick");
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getStringExtra(EXT_RECEIVER_NICK)");
        this.h = paramBundle;
        paramBundle = localIntent.getStringExtra("extra_receiver_head");
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getStringExtra(EXT_RECEIVER_HEAD)");
        this.i = paramBundle;
        paramBundle = localIntent.getStringExtra("extra_source");
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getStringExtra(EXT_SOURCE)");
        this.j = paramBundle;
        paramBundle = localIntent.getStringExtra("extra_game_type");
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getStringExtra(EXT_GAME_TYPE)");
        this.k = paramBundle;
        paramBundle = localIntent.getStringExtra("extra_programme_id");
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getStringExtra(EXT_PROGRAMME_ID)");
        this.l = paramBundle;
        paramBundle = localIntent.getStringExtra("extra_app_id");
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getStringExtra(EXT_APP_ID)");
        this.m = paramBundle;
        paramBundle = localIntent.getStringExtra("extra_trace_detail");
        if (paramBundle == null) {
          paramBundle = "";
        }
        this.n = paramBundle;
        paramBundle = localIntent.getStringExtra("extra_game_id");
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "getStringExtra(EXT_GAME_ID)");
        this.o = paramBundle;
      }
    }
    this.p = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(this.b);
    paramView.post((Runnable)new TimiGiftPanelFragment.onViewCreated.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftPanelFragment
 * JD-Core Version:    0.7.0.1
 */