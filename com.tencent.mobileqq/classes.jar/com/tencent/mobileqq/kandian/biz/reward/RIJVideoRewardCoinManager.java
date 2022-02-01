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
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
  public static final RIJVideoRewardCoinManager.Companion a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RIJVideoRewardCoinManager.Callback jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Callback;
  private RIJVideoRewardCoinManager.RIJRewardInfo jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$RIJRewardInfo;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private ImageView e;
  private ImageView f;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Companion = new RIJVideoRewardCoinManager.Companion(null);
  }
  
  public RIJVideoRewardCoinManager(@Nullable Activity paramActivity, @Nullable RIJVideoRewardCoinManager.Callback paramCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Callback = paramCallback;
    this.jdField_a_of_type_Boolean = RIJRewardTaskConfig.a.c();
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 1;
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyObserver)this);
    if (this.jdField_a_of_type_Boolean)
    {
      a("https://kd.qpic.cn/bankjiang/images/oneCoinApng_1108_f3a3676c.png");
      a("https://kd.qpic.cn/bankjiang/images/threeCoinApng_1108_aeb44235.png");
    }
  }
  
  private final URLDrawable a(String paramString)
  {
    ApngOptions localApngOptions = new ApngOptions();
    localApngOptions.a(1);
    return ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramString, localApngOptions);
  }
  
  private final void a(ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (paramInt1 == this.jdField_a_of_type_Int) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    Object localObject2 = null;
    Object localObject3;
    Object localObject1;
    if (paramInt1 != 0)
    {
      localObject3 = this.jdField_a_of_type_AndroidAppActivity;
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
      localObject3 = this.jdField_a_of_type_AndroidAppActivity;
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$RIJRewardInfo;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((RIJVideoRewardCoinManager.RIJRewardInfo)localObject1).a();
    } else {
      localObject1 = null;
    }
    Object localObject3 = new VideoR5.Builder((VideoInfo)localObject1).a("video_mode", Integer.valueOf(this.jdField_d_of_type_Int));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$RIJRewardInfo;
    if (localObject1 != null)
    {
      localObject1 = ((RIJVideoRewardCoinManager.RIJRewardInfo)localObject1).a();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localObject1 = ((VideoR5.Builder)localObject3).a("rowkey", localObject1).a("number", Integer.valueOf(this.jdField_a_of_type_Int + 1));
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    localObject3 = ((VideoR5.Builder)localObject1).a("result", Integer.valueOf(i)).a("click_type", Integer.valueOf(1)).a();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "VideoR5.Builder(rewardIn…\n                .build()");
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    RIJVideoRewardCoinManager.RIJRewardInfo localRIJRewardInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$RIJRewardInfo;
    localObject1 = localObject2;
    if (localRIJRewardInfo != null) {
      localObject1 = localRIJRewardInfo.a();
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, (String)localObject1, "", "", ((VideoR5)localObject3).a(), false);
  }
  
  private final void h(int paramInt)
  {
    String str;
    if (paramInt > 0) {
      str = VideoFeedsHelper.e(paramInt);
    } else {
      str = "0";
    }
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
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
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewView);
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setAnimationStyle(2131756213);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setWidth(-1);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setHeight(-1);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setTouchable(true);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setFocusable(false);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setSoftInputMode(2);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setInputMethodMode(2);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setClippingEnabled(false);
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)new RIJVideoRewardCoinManager.initPopupwindow.1(this));
    }
  }
  
  private final void n()
  {
    Object localObject1 = LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity);
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131560380, null);
    } else {
      localObject1 = null;
    }
    this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = (TextView)((View)localObject1).findViewById(2131377207);
    } else {
      localObject1 = null;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = (TextView)((View)localObject1).findViewById(2131377212);
    } else {
      localObject1 = null;
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = ((View)localObject1).findViewById(2131377200);
    } else {
      localObject1 = null;
    }
    this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377203);
    } else {
      localObject1 = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377204);
    } else {
      localObject1 = null;
    }
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377210);
    } else {
      localObject1 = null;
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = ((View)localObject1).findViewById(2131377199);
    } else {
      localObject1 = null;
    }
    this.jdField_c_of_type_AndroidViewView = ((View)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377202);
    } else {
      localObject1 = null;
    }
    this.f = ((ImageView)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377201);
    } else {
      localObject1 = null;
    }
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377208);
    } else {
      localObject1 = null;
    }
    this.e = ((ImageView)localObject1);
    View localView = this.jdField_a_of_type_AndroidViewView;
    localObject1 = localObject2;
    if (localView != null) {
      localObject1 = localView.findViewById(2131377206);
    }
    this.jdField_d_of_type_AndroidViewView = ((View)localObject1);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)RIJRewardTaskConfig.a.a());
    }
    q();
    localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject1 != null) {
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.1(this));
    }
    localObject1 = this.jdField_a_of_type_AndroidViewView;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.2(this));
    }
    localObject1 = this.jdField_b_of_type_AndroidViewView;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.3(this));
    }
    localObject1 = this.jdField_c_of_type_AndroidViewView;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.4(this));
    }
    localObject1 = this.jdField_d_of_type_AndroidViewView;
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener((View.OnClickListener)new RIJVideoRewardCoinManager.initUI.5(this));
    }
  }
  
  private final void q()
  {
    a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 2130843299, 2130843300, RIJRewardTaskConfig.a.d(), RIJRewardTaskConfig.a.f());
    a(this.e, 1, 2130843303, 2130843304, RIJRewardTaskConfig.a.e(), RIJRewardTaskConfig.a.g());
    s();
    r();
  }
  
  private final void r()
  {
    View localView;
    if (this.jdField_a_of_type_Int == 0)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setAlpha(1.0F);
      }
      localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null) {
        localView.setAlpha(0.7F);
      }
    }
    else
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setAlpha(0.7F);
      }
      localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null) {
        localView.setAlpha(1.0F);
      }
    }
  }
  
  private final void s()
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localImageView != null) {
          localImageView.setImageDrawable((Drawable)a("https://kd.qpic.cn/bankjiang/images/oneCoinApng_1108_f3a3676c.png"));
        }
      }
      else
      {
        localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
        if (localImageView != null) {
          localImageView.setVisibility(0);
        }
        localImageView = this.f;
        if (localImageView != null) {
          localImageView.setVisibility(8);
        }
      }
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      localImageView = this.jdField_d_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setImageDrawable((Drawable)a("https://kd.qpic.cn/bankjiang/images/threeCoinApng_1108_aeb44235.png"));
      }
    }
    else
    {
      localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
      localImageView = this.f;
      if (localImageView != null) {
        localImageView.setVisibility(0);
      }
    }
  }
  
  private final void t()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
    this.jdField_a_of_type_AndroidViewView = ((View)null);
  }
  
  public final void a(@NotNull RIJVideoRewardCoinManager.RIJRewardInfo paramRIJRewardInfo, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJRewardInfo, "videoInfo");
    this.jdField_d_of_type_Int = paramInt;
    Object localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localObject != null) {
      ((PopupWindow)localObject).dismiss();
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$RIJRewardInfo = paramRIJRewardInfo;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      n();
    }
    paramInt = this.jdField_c_of_type_Int;
    if (paramInt >= 0) {
      h(paramInt);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramRIJRewardInfo = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramRIJRewardInfo != null) {
        paramRIJRewardInfo.postDelayed((Runnable)new RIJVideoRewardCoinManager.showRewardCoinPopupWindow.2(this), 500L);
      }
    }
    m();
    paramRIJRewardInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Callback;
    paramInt = 1;
    if (paramRIJRewardInfo != null) {
      paramRIJRewardInfo.a(true, this.jdField_d_of_type_Int);
    }
    if (FastWebPTSUtils.a(this.jdField_d_of_type_Int))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
      if (localObject != null)
      {
        paramRIJRewardInfo = this.jdField_a_of_type_AndroidAppActivity;
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
      localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
      if (localObject != null)
      {
        paramRIJRewardInfo = this.jdField_a_of_type_AndroidAppActivity;
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
        ((PopupWindow)localObject).showAsDropDown(paramRIJRewardInfo, 0, -VideoFeedsHelper.b(this.jdField_a_of_type_AndroidAppActivity)[1]);
      }
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= RIJRewardTaskConfig.a()) {
      paramInt = 0;
    }
    if ((paramInt != 0) && (RIJRewardTaskConfig.a()))
    {
      ReadInJoyLogicEngine.a().u();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
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
    t();
    this.jdField_b_of_type_Boolean = false;
    a("0X800B2EC", paramBoolean);
    if (paramBoolean)
    {
      paramInt = jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Companion.a(this.jdField_b_of_type_Int);
      this.jdField_c_of_type_Int -= paramInt;
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Callback;
      if (paramString != null) {
        paramString.a(true, "投币成功", this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
      }
    }
    else if (paramInt == 1034)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Callback;
      if (paramString != null) {
        paramString.a(false, "硬币不够", this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
      }
    }
    else
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Callback;
      if (paramString != null) {
        paramString.a(false, "投币失败", this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
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
        paramInt = paramUserCoinInfo.jdField_a_of_type_Int;
      } else {
        paramInt = 0;
      }
      this.jdField_c_of_type_Int = paramInt;
      h(paramInt);
    }
  }
  
  public final boolean a()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      return localPopupWindow.isShowing();
    }
    return false;
  }
  
  public final boolean b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (localView.isShown() == true))
    {
      t();
      return true;
    }
    return false;
  }
  
  public final void j()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Callback = ((RIJVideoRewardCoinManager.Callback)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager
 * JD-Core Version:    0.7.0.1
 */