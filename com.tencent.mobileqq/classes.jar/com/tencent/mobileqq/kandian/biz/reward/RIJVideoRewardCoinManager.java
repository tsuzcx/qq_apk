package com.tencent.mobileqq.kandian.biz.reward;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.reward.UserCoinInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager;", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "context", "Landroid/app/Activity;", "callback", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager$Callback;", "(Landroid/app/Activity;Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager$Callback;)V", "btnAnimEnable", "", "coinCount", "", "curSelectItem", "hasRewardCoin", "headerHint", "Landroid/widget/TextView;", "lastRequestMyCoinCountTime", "", "multiCoinBtn", "Landroid/view/View;", "multiCoinIcon", "Landroid/widget/ImageView;", "multiCoinIconSelectedBg", "multiCoinText", "myCoinCountText", "oneCoinBtn", "oneCoinIcon", "oneCoinIconSelectedBg", "oneCoinText", "popupWindow", "Landroid/widget/PopupWindow;", "popupWindowView", "rewardCoinBtn", "rewardInfo", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager$RIJRewardInfo;", "rewardSelectedItem", "sceneType", "dismissPopupWindow", "", "doUpdateCoinAlpha", "doUpdateCoinImage", "doUpdateCoinText", "coinTextImageView", "itemIndex", "drawableSelected", "drawableUnselected", "drawableUrlSelected", "", "drawableUrlUnselected", "getAnimDrawable", "Lcom/tencent/image/URLDrawable;", "url", "initPopupwindow", "initUI", "isShowing", "onBackPress", "onDestory", "onQueryUserCoinResult", "success", "retCode", "retMsg", "userCoin", "Lcom/tencent/mobileqq/kandian/repo/reward/UserCoinInfo;", "onRewardCoinToUinResult", "reportAction", "action", "setCoinCountText", "showRewardCoinPopupWindow", "videoInfo", "scene", "udpateCoinUI", "Callback", "Companion", "RIJRewardData", "RIJRewardInfo", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJVideoRewardCoinManager
  extends ReadInJoyObserver
{
  public static final RIJVideoRewardCoinManager.Companion a = new RIJVideoRewardCoinManager.Companion(null);
  private View b;
  private TextView c;
  private TextView d;
  private View e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private View i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private View m;
  private PopupWindow n;
  private RIJVideoRewardCoinManager.RIJRewardInfo o;
  private final boolean p;
  private boolean q;
  private int r;
  private int s;
  private long t;
  private int u;
  private int v;
  private Activity w;
  private RIJVideoRewardCoinManager.Callback x;
  
  public RIJVideoRewardCoinManager(@Nullable Activity paramActivity, @Nullable RIJVideoRewardCoinManager.Callback paramCallback)
  {
    this.w = paramActivity;
    this.x = paramCallback;
    this.p = RIJRewardTaskConfig.a.m();
    this.u = -1;
    this.v = 1;
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyObserver)this);
    if (this.p)
    {
      e("https://kd.qpic.cn/bankjiang/images/oneCoinApng_1108_f3a3676c.png");
      e("https://kd.qpic.cn/bankjiang/images/threeCoinApng_1108_aeb44235.png");
    }
  }
  
  private final void a(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (paramInt1 == this.r) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    Object localObject2 = null;
    Object localObject3;
    Object localObject1;
    if (paramInt1 != 0)
    {
      localObject3 = this.w;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((Activity)localObject3).getResources();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Resources)localObject3).getDrawable(paramInt2);
        }
      }
    }
    else
    {
      localObject3 = this.w;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((Activity)localObject3).getResources();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Resources)localObject3).getDrawable(paramInt3);
        }
      }
    }
    if (paramInt1 == 0) {
      paramString1 = paramString2;
    }
    if (!TextUtils.isEmpty((CharSequence)paramString1))
    {
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      if (paramString2 != null) {
        paramString2.mFailedDrawable = ((Drawable)localObject1);
      }
      paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "URLDrawable.getDrawable(drawableUrl, options)");
      if (paramImageView != null) {
        paramImageView.setImageDrawable((Drawable)paramString1);
      }
    }
    else if (paramImageView != null)
    {
      paramImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private final void a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = this.o;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((RIJVideoRewardCoinManager.RIJRewardInfo)localObject1).c();
    } else {
      localObject1 = null;
    }
    Object localObject3 = new VideoR5.Builder((VideoInfo)localObject1).b("video_mode", Integer.valueOf(this.v));
    localObject1 = this.o;
    if (localObject1 != null)
    {
      localObject1 = ((RIJVideoRewardCoinManager.RIJRewardInfo)localObject1).a();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localObject1 = ((VideoR5.Builder)localObject3).b("rowkey", localObject1).b("number", Integer.valueOf(this.r + 1));
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    localObject3 = ((VideoR5.Builder)localObject1).b("result", Integer.valueOf(i1)).b("click_type", Integer.valueOf(1)).b();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "VideoR5.Builder(rewardIn…\n                .build()");
    RIJVideoRewardCoinManager.RIJRewardInfo localRIJRewardInfo = this.o;
    localObject1 = localObject2;
    if (localRIJRewardInfo != null) {
      localObject1 = localRIJRewardInfo.a();
    }
    PublicAccountReportUtils.a(null, "", paramString, paramString, 0, 0, (String)localObject1, "", "", ((VideoR5)localObject3).a(), false);
  }
  
  private final URLDrawable e(String paramString)
  {
    ApngOptions localApngOptions = new ApngOptions();
    localApngOptions.a(1);
    return ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramString, localApngOptions);
  }
  
  private final void g(int paramInt)
  {
    String str;
    if (paramInt > 0) {
      str = VideoFeedsHelper.e(paramInt);
    } else {
      str = "0";
    }
    TextView localTextView = this.d;
    if (localTextView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("可投硬币 ");
      localStringBuilder.append(str);
      localStringBuilder.append(" 〉");
      localTextView.setText((CharSequence)localStringBuilder.toString());
    }
  }
  
  private final void m()
  {
    this.n = new PopupWindow(this.b);
    PopupWindow localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    }
    localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.setAnimationStyle(2131953363);
    }
    localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.setWidth(-1);
    }
    localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.setHeight(-1);
    }
    localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.setTouchable(true);
    }
    localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.setFocusable(false);
    }
    localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.setSoftInputMode(2);
    }
    localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.setInputMethodMode(2);
    }
    localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.setClippingEnabled(false);
    }
    localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)new RIJVideoRewardCoinManager.initPopupwindow.1(this));
    }
  }
  
  private final void n()
  {
    Object localObject1 = LayoutInflater.from((Context)this.w);
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131626426, null);
    } else {
      localObject1 = null;
    }
    this.b = ((View)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = (TextView)((View)localObject1).findViewById(2131445590);
    } else {
      localObject1 = null;
    }
    this.c = ((TextView)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = (TextView)((View)localObject1).findViewById(2131445595);
    } else {
      localObject1 = null;
    }
    this.d = ((TextView)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((View)localObject1).findViewById(2131445583);
    } else {
      localObject1 = null;
    }
    this.e = ((View)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131445586);
    } else {
      localObject1 = null;
    }
    this.f = ((ImageView)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131445587);
    } else {
      localObject1 = null;
    }
    this.h = ((ImageView)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131445593);
    } else {
      localObject1 = null;
    }
    this.g = ((ImageView)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((View)localObject1).findViewById(2131445582);
    } else {
      localObject1 = null;
    }
    this.i = ((View)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131445585);
    } else {
      localObject1 = null;
    }
    this.l = ((ImageView)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131445584);
    } else {
      localObject1 = null;
    }
    this.j = ((ImageView)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131445591);
    } else {
      localObject1 = null;
    }
    this.k = ((ImageView)localObject1);
    View localView = this.b;
    localObject1 = localObject2;
    if (localView != null) {
      localObject1 = localView.findViewById(2131445589);
    }
    this.m = ((View)localObject1);
    localObject1 = this.c;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)RIJRewardTaskConfig.a.f());
    }
    o();
    localObject1 = this.d;
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.1(this));
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.2(this));
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.3(this));
    }
    localObject1 = this.i;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.4(this));
    }
    localObject1 = this.m;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.5(this));
    }
  }
  
  private final void o()
  {
    a(this.g, 0, 2130844253, 2130844254, RIJRewardTaskConfig.a.n(), RIJRewardTaskConfig.a.p());
    a(this.k, 1, 2130844257, 2130844258, RIJRewardTaskConfig.a.o(), RIJRewardTaskConfig.a.q());
    q();
    p();
  }
  
  private final void p()
  {
    View localView;
    if (this.r == 0)
    {
      localView = this.e;
      if (localView != null) {
        localView.setAlpha(1.0F);
      }
      localView = this.i;
      if (localView != null) {
        localView.setAlpha(0.7F);
      }
    }
    else
    {
      localView = this.e;
      if (localView != null) {
        localView.setAlpha(0.7F);
      }
      localView = this.i;
      if (localView != null) {
        localView.setAlpha(1.0F);
      }
    }
  }
  
  private final void q()
  {
    ImageView localImageView;
    if (this.r == 0)
    {
      if (this.p)
      {
        localImageView = this.f;
        if (localImageView != null) {
          localImageView.setImageDrawable((Drawable)e("https://kd.qpic.cn/bankjiang/images/oneCoinApng_1108_f3a3676c.png"));
        }
      }
      else
      {
        localImageView = this.h;
        if (localImageView != null) {
          localImageView.setVisibility(0);
        }
        localImageView = this.l;
        if (localImageView != null) {
          localImageView.setVisibility(8);
        }
      }
    }
    else if (this.p)
    {
      localImageView = this.j;
      if (localImageView != null) {
        localImageView.setImageDrawable((Drawable)e("https://kd.qpic.cn/bankjiang/images/threeCoinApng_1108_aeb44235.png"));
      }
    }
    else
    {
      localImageView = this.h;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      localImageView = this.l;
      if (localImageView != null) {
        localImageView.setVisibility(0);
      }
    }
  }
  
  private final void r()
  {
    PopupWindow localPopupWindow = this.n;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
    this.b = ((View)null);
  }
  
  public final void a(@NotNull RIJVideoRewardCoinManager.RIJRewardInfo paramRIJRewardInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJRewardInfo, "videoInfo");
    this.v = paramInt;
    Object localObject = this.n;
    if (localObject != null) {
      ((PopupWindow)localObject).dismiss();
    }
    View localView = this.b;
    if (localView != null)
    {
      ViewParent localViewParent = localView.getParent();
      localObject = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject = null;
      }
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(localView);
      }
    }
    this.o = paramRIJRewardInfo;
    this.q = false;
    this.r = 0;
    if (this.b == null) {
      n();
    }
    paramInt = this.u;
    if (paramInt >= 0) {
      g(paramInt);
    }
    if (this.p)
    {
      paramRIJRewardInfo = this.f;
      if (paramRIJRewardInfo != null) {
        paramRIJRewardInfo.postDelayed((Runnable)new RIJVideoRewardCoinManager.showRewardCoinPopupWindow.2(this), 500L);
      }
    }
    m();
    paramRIJRewardInfo = this.x;
    paramInt = 1;
    if (paramRIJRewardInfo != null) {
      paramRIJRewardInfo.a(true, this.v);
    }
    if (FastWebPTSUtils.a(this.v))
    {
      localObject = this.n;
      if (localObject != null)
      {
        paramRIJRewardInfo = this.w;
        if (paramRIJRewardInfo != null)
        {
          paramRIJRewardInfo = paramRIJRewardInfo.getWindow();
          if (paramRIJRewardInfo != null)
          {
            paramRIJRewardInfo = paramRIJRewardInfo.getDecorView();
            break label219;
          }
        }
        paramRIJRewardInfo = null;
        label219:
        ((PopupWindow)localObject).showAsDropDown(paramRIJRewardInfo, 0, 0);
      }
    }
    else
    {
      localObject = this.n;
      if (localObject != null)
      {
        paramRIJRewardInfo = this.w;
        if (paramRIJRewardInfo != null)
        {
          paramRIJRewardInfo = paramRIJRewardInfo.getWindow();
          if (paramRIJRewardInfo != null)
          {
            paramRIJRewardInfo = paramRIJRewardInfo.getDecorView();
            break label266;
          }
        }
        paramRIJRewardInfo = null;
        label266:
        ((PopupWindow)localObject).showAsDropDown(paramRIJRewardInfo, 0, -VideoFeedsHelper.c(this.w)[1]);
      }
    }
    if (System.currentTimeMillis() - this.t <= RIJRewardTaskConfig.b()) {
      paramInt = 0;
    }
    if ((paramInt != 0) && (RIJRewardTaskConfig.a()))
    {
      ReadInJoyLogicEngine.a().ae();
      this.t = System.currentTimeMillis();
    }
    a(this, "0X800B2E8", false, 2, null);
  }
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRewardCoinToUinResult: success=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", retCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", retMsg=");
      localStringBuilder.append(paramString);
      QLog.d("RIJVideoRewardCoinManager", 2, localStringBuilder.toString());
    }
    r();
    this.q = false;
    a("0X800B2EC", paramBoolean);
    if (paramBoolean)
    {
      paramInt = a.a(this.s);
      this.u -= paramInt;
      paramString = this.x;
      if (paramString != null) {
        paramString.a(true, "投币成功", this.s, this.v);
      }
    }
    else if (paramInt == 1034)
    {
      paramString = this.x;
      if (paramString != null) {
        paramString.a(false, "硬币不够", this.s, this.v);
      }
    }
    else
    {
      paramString = this.x;
      if (paramString != null) {
        paramString.a(false, "投币失败", this.s, this.v);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable UserCoinInfo paramUserCoinInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQueryUserCoinResult: success=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", retCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", retMsg=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", userCoin=");
      localStringBuilder.append(paramUserCoinInfo);
      QLog.d("RIJVideoRewardCoinManager", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (paramUserCoinInfo != null) {
        paramInt = paramUserCoinInfo.a;
      } else {
        paramInt = 0;
      }
      this.u = paramInt;
      g(paramInt);
    }
  }
  
  public final void i()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this);
    this.w = ((Activity)null);
    this.x = ((RIJVideoRewardCoinManager.Callback)null);
  }
  
  public final boolean j()
  {
    PopupWindow localPopupWindow = this.n;
    if (localPopupWindow != null) {
      return localPopupWindow.isShowing();
    }
    return false;
  }
  
  public final boolean k()
  {
    View localView = this.b;
    if ((localView != null) && (localView.isShown() == true))
    {
      r();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager
 * JD-Core Version:    0.7.0.1
 */