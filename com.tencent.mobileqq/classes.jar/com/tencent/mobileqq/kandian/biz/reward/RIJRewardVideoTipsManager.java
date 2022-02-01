package com.tencent.mobileqq.kandian.biz.reward;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.widget.IReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.discovery.BubblePopupWindow;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import cooperation.liveroom.LiveRoomGiftCallback;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardVideoTipsManager;", "", "context", "Landroid/app/Activity;", "rewardCoinManager", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager;", "(Landroid/app/Activity;Lcom/tencent/mobileqq/kandian/biz/reward/RIJVideoRewardCoinManager;)V", "curItemNeedShowGuide", "", "enable", "handler", "Landroid/os/Handler;", "holder", "Lcom/tencent/mobileqq/kandian/biz/playfeeds/videofeeds/ShortVideoItemHolder;", "isFullScreen", "()Z", "setFullScreen", "(Z)V", "popupWindow", "Lcom/tencent/mobileqq/kandian/biz/video/discovery/BubblePopupWindow;", "promptView", "Landroid/widget/TextView;", "rewardCoinGuideWordWidth", "", "rewardCoinGuideWords", "", "rewardSuccessAnimEnable", "rewardSuccessTipsWordWidth", "rewardSuccessTipsWords", "targetPercent", "", "vpngImageView", "Lcom/tencent/mobileqq/vpng/view/VPNGImageView;", "dismissPopupWindow", "", "initPromptView", "onCenterViewChanged", "itemHolder", "onDestory", "onProgressChanged", "pos", "", "duration", "isCommentVisiable", "onRewardSuccess", "type", "releaseVpng", "showBubblePopupWindow", "contentView", "Landroid/view/View;", "archer", "width", "xOffset", "yOffset", "callback", "Lkotlin/Function1;", "showRewardCoinGuide", "showRewardSuccessTips", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardVideoTipsManager
{
  public static final RIJRewardVideoTipsManager.Companion a;
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ShortVideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
  private RIJVideoRewardCoinManager jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager;
  private BubblePopupWindow jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
  private VPNGImageView jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  private final boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardVideoTipsManager$Companion = new RIJRewardVideoTipsManager.Companion(null);
  }
  
  public RIJRewardVideoTipsManager(@Nullable Activity paramActivity, @Nullable RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager = paramRIJVideoRewardCoinManager;
    this.jdField_a_of_type_Boolean = RIJRewardTaskConfig.a();
    this.jdField_a_of_type_Float = RIJRewardTaskConfig.a.a();
    this.jdField_a_of_type_JavaLangString = RIJRewardTaskConfig.a.b();
    this.jdField_b_of_type_JavaLangString = RIJRewardTaskConfig.a.c();
    this.jdField_b_of_type_Boolean = RIJRewardTaskConfig.a.b();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private final void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, Function1<? super BubblePopupWindow, Unit> paramFunction1)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
    if ((localObject != null) && (localObject != null) && (((BubblePopupWindow)localObject).isShowing() == true)) {
      return;
    }
    if ((paramView1 != null) && ((paramView1.getParent() instanceof ViewGroup)))
    {
      localObject = paramView1.getParent();
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(paramView1);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
    int i = ViewUtils.a(10.0F);
    int j = ViewUtils.a(6.0F);
    int k = ViewUtils.a(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow = new BubblePopupWindow((Context)this.jdField_a_of_type_AndroidAppActivity);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
    if (localObject != null) {
      ((BubblePopupWindow)localObject).setContentView(paramView1);
    }
    paramView1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
    if (paramView1 != null) {
      paramView1.setWidth(paramInt1);
    }
    paramView1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
    if (paramView1 != null) {
      paramView1.a(k / 2);
    }
    paramView1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
    if (paramView1 != null) {
      paramView1.a(k, j);
    }
    paramView1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
    if (paramView1 != null) {
      paramView1.b((int)4294942528L);
    }
    paramView1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
    if (paramView1 != null) {
      paramView1.c(i);
    }
    paramFunction1.invoke(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow);
    if (ReadInJoyHelper.b())
    {
      paramView1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
      if (paramView1 != null) {
        paramView1.setAnimationStyle(2131756211);
      }
    }
    try
    {
      paramView1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
      if (paramView1 != null)
      {
        paramView1.showAsDropDown(paramView2, paramInt2, paramInt3, 3);
        return;
        paramView1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
        if (paramView1 != null) {
          paramView1.setAnimationStyle(2131756212);
        }
        paramView1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
        if (paramView1 != null) {
          paramView1.showAsDropDown(paramView2, paramInt2, paramInt3, 48);
        }
      }
      return;
    }
    catch (Exception paramView1) {}
  }
  
  private final void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
    if (localObject1 != null) {
      localObject1 = ((VPNGImageView)localObject1).getParent();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof ViewGroup)) {
      localObject2 = null;
    }
    localObject1 = (ViewGroup)localObject2;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).removeView((View)this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
    if (localObject1 != null) {
      ((VPNGImageView)localObject1).onRelease();
    }
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView = ((VPNGImageView)null);
  }
  
  private final void c()
  {
    if (this.d) {
      return;
    }
    e();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
    if (localObject != null)
    {
      localObject = ((ShortVideoItemHolder)localObject).a;
      if (localObject != null)
      {
        localObject = ((IReadInJoyHeadImageView)localObject).a();
        if (localObject != null)
        {
          TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
          if (localTextView != null) {
            localTextView.setText((CharSequence)this.jdField_b_of_type_JavaLangString);
          }
          int i;
          if (ReadInJoyHelper.b()) {
            i = -this.jdField_b_of_type_Int - ViewUtils.a(8.0F);
          } else {
            i = 0;
          }
          int j;
          if (ReadInJoyHelper.b()) {
            j = -((View)localObject).getHeight() + ViewUtils.a(5.0F);
          } else {
            j = -((View)localObject).getHeight() - ViewUtils.a(50.0F);
          }
          a((View)this.jdField_a_of_type_AndroidWidgetTextView, (View)localObject, this.jdField_b_of_type_Int, i, j, (Function1)new RIJRewardVideoTipsManager.showRewardSuccessTips.1.1((View)localObject));
        }
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)new RIJRewardVideoTipsManager.showRewardSuccessTips.2(this), 2000L);
  }
  
  private final void d()
  {
    e();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
    if (localObject != null)
    {
      localObject = ((ShortVideoItemHolder)localObject).c();
      if (localObject != null)
      {
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localTextView != null) {
          localTextView.setText((CharSequence)this.jdField_a_of_type_JavaLangString);
        }
        int i;
        if (ReadInJoyHelper.b()) {
          i = -this.jdField_a_of_type_Int;
        } else {
          i = -this.jdField_a_of_type_Int + ((ViewGroup)localObject).getWidth() + ViewUtils.a(8.0F);
        }
        int j;
        if (ReadInJoyHelper.b()) {
          j = -((ViewGroup)localObject).getHeight() + ViewUtils.a(5.0F);
        } else {
          j = -((ViewGroup)localObject).getHeight() - ViewUtils.a(30.0F);
        }
        a((View)this.jdField_a_of_type_AndroidWidgetTextView, (View)localObject, this.jdField_a_of_type_Int, i, j, (Function1)new RIJRewardVideoTipsManager.showRewardCoinGuide.1.1((ViewGroup)localObject));
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)new RIJRewardVideoTipsManager.showRewardCoinGuide.2(this), 2000L);
  }
  
  private final void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      int i = ViewUtils.a(8.0F);
      int j = ViewUtils.a(10.0F);
      TextView localTextView = new TextView((Context)this.jdField_a_of_type_AndroidAppActivity);
      localTextView.setId(2131378460);
      localTextView.setGravity(17);
      localTextView.setTextSize(2, 14.0F);
      localTextView.setTextColor(-1);
      localTextView.setPadding(j, i, j, i);
      localTextView.setSingleLine(true);
      float f1 = localTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangString);
      float f2 = j * 2;
      this.jdField_a_of_type_Int = ((int)(f1 + f2 + ViewUtils.a(6.0F)));
      this.jdField_b_of_type_Int = ((int)(localTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangString) + f2 + ViewUtils.a(6.0F)));
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
    }
  }
  
  private final void f()
  {
    try
    {
      BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow;
      if (localBubblePopupWindow != null) {
        localBubblePopupWindow.dismiss();
      }
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoDiscoveryBubblePopupWindow = ((BubblePopupWindow)null);
  }
  
  public final void a()
  {
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager = ((RIJVideoRewardCoinManager)null);
    b();
  }
  
  public final void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      Object localObject2 = "https://kd.qpic.cn/bankjiang/images/oneCoinAnimation_1109_cb1cc6ed.mp4";
      Object localObject1 = localObject2;
      if (paramInt != 0) {
        if (paramInt != 1) {
          localObject1 = localObject2;
        } else {
          localObject1 = "https://kd.qpic.cn/bankjiang/images/threeCoinAnimation_1109_11efdc28.mp4";
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView = new VPNGImageView((Context)this.jdField_a_of_type_AndroidAppActivity);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
      if (localObject2 != null) {
        ((VPNGImageView)localObject2).setBackgroundColor(1275068416);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
      if (localObject2 != null) {
        ((VPNGImageView)localObject2).setPlayOnSubThread(true);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
      if (localObject2 != null) {
        ((VPNGImageView)localObject2).setVideo((String)localObject1, false, 1, (LiveRoomGiftCallback)new RIJRewardVideoTipsManager.onRewardSuccess.1(this));
      }
      localObject1 = this.jdField_a_of_type_AndroidAppActivity;
      if (localObject1 != null)
      {
        localObject1 = ((Activity)localObject1).getWindow();
        if (localObject1 != null)
        {
          localObject1 = ((Window)localObject1).getDecorView();
          break label134;
        }
      }
      localObject1 = null;
      label134:
      localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup)localObject2;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).addView((View)this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView, -1, -1);
      }
    }
    else
    {
      c();
    }
  }
  
  public final void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int k = 1;
    if (!paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder;
      if (localObject != null)
      {
        localObject = ((ShortVideoItemHolder)localObject).d;
        if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 8))
        {
          i = 1;
          break label50;
        }
      }
    }
    int i = 0;
    label50:
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager;
    if (localObject != null) {
      paramBoolean = ((RIJVideoRewardCoinManager)localObject).a();
    } else {
      paramBoolean = false;
    }
    int j;
    if ((paramLong2 > 0L) && ((float)paramLong1 / (float)paramLong2 > this.jdField_a_of_type_Float)) {
      j = 1;
    } else {
      j = 0;
    }
    if ((!this.jdField_a_of_type_Boolean) || (!RIJRewardTaskConfig.a.d())) {
      k = 0;
    }
    if ((i != 0) && (this.c) && (!paramBoolean) && (j != 0) && (k != 0))
    {
      this.c = false;
      RIJRewardTaskConfig.a.a();
      d();
    }
  }
  
  public final void a(@Nullable ShortVideoItemHolder paramShortVideoItemHolder)
  {
    if (paramShortVideoItemHolder != null)
    {
      ViewGroup localViewGroup = paramShortVideoItemHolder.c();
      if ((localViewGroup != null) && (localViewGroup.getVisibility() == 0))
      {
        bool = true;
        break label27;
      }
    }
    boolean bool = false;
    label27:
    this.c = bool;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideofeedsShortVideoItemHolder = paramShortVideoItemHolder;
    f();
    b();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardVideoTipsManager
 * JD-Core Version:    0.7.0.1
 */