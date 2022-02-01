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
  public static final RIJRewardVideoTipsManager.Companion a = new RIJRewardVideoTipsManager.Companion(null);
  private final boolean b;
  private final float c;
  private final String d;
  private final String e;
  private final boolean f;
  private int g;
  private int h;
  private boolean i;
  private ShortVideoItemHolder j;
  private BubblePopupWindow k;
  private TextView l;
  private VPNGImageView m;
  private Handler n;
  private boolean o;
  private Activity p;
  private RIJVideoRewardCoinManager q;
  
  public RIJRewardVideoTipsManager(@Nullable Activity paramActivity, @Nullable RIJVideoRewardCoinManager paramRIJVideoRewardCoinManager)
  {
    this.p = paramActivity;
    this.q = paramRIJVideoRewardCoinManager;
    this.b = RIJRewardTaskConfig.a();
    this.c = RIJRewardTaskConfig.a.i();
    this.d = RIJRewardTaskConfig.a.j();
    this.e = RIJRewardTaskConfig.a.k();
    this.f = RIJRewardTaskConfig.a.l();
    this.n = new Handler();
  }
  
  private final void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, Function1<? super BubblePopupWindow, Unit> paramFunction1)
  {
    Object localObject = this.k;
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
    int i1 = ViewUtils.dip2px(10.0F);
    int i2 = ViewUtils.dip2px(6.0F);
    int i3 = ViewUtils.dip2px(6.0F);
    this.k = new BubblePopupWindow((Context)this.p);
    localObject = this.k;
    if (localObject != null) {
      ((BubblePopupWindow)localObject).setContentView(paramView1);
    }
    paramView1 = this.k;
    if (paramView1 != null) {
      paramView1.setWidth(paramInt1);
    }
    paramView1 = this.k;
    if (paramView1 != null) {
      paramView1.a(i3 / 2);
    }
    paramView1 = this.k;
    if (paramView1 != null) {
      paramView1.a(i3, i2);
    }
    paramView1 = this.k;
    if (paramView1 != null) {
      paramView1.b((int)4294942528L);
    }
    paramView1 = this.k;
    if (paramView1 != null) {
      paramView1.c(i1);
    }
    paramFunction1.invoke(this.k);
    if (ReadInJoyHelper.b())
    {
      paramView1 = this.k;
      if (paramView1 != null) {
        paramView1.setAnimationStyle(2131953361);
      }
    }
    try
    {
      paramView1 = this.k;
      if (paramView1 != null)
      {
        paramView1.showAsDropDown(paramView2, paramInt2, paramInt3, 3);
        return;
        paramView1 = this.k;
        if (paramView1 != null) {
          paramView1.setAnimationStyle(2131953362);
        }
        paramView1 = this.k;
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
    Object localObject1 = this.m;
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
      ((ViewGroup)localObject1).removeView((View)this.m);
    }
    localObject1 = this.m;
    if (localObject1 != null) {
      ((VPNGImageView)localObject1).onRelease();
    }
    this.m = ((VPNGImageView)null);
  }
  
  private final void c()
  {
    if (this.o) {
      return;
    }
    e();
    Object localObject = this.j;
    if (localObject != null)
    {
      localObject = ((ShortVideoItemHolder)localObject).aK;
      if (localObject != null)
      {
        localObject = ((IReadInJoyHeadImageView)localObject).getView();
        if (localObject != null)
        {
          TextView localTextView = this.l;
          if (localTextView != null) {
            localTextView.setText((CharSequence)this.e);
          }
          int i1;
          if (ReadInJoyHelper.b()) {
            i1 = -this.h - ViewUtils.dip2px(8.0F);
          } else {
            i1 = 0;
          }
          int i2;
          if (ReadInJoyHelper.b()) {
            i2 = -((View)localObject).getHeight() + ViewUtils.dip2px(5.0F);
          } else {
            i2 = -((View)localObject).getHeight() - ViewUtils.dip2px(50.0F);
          }
          a((View)this.l, (View)localObject, this.h, i1, i2, (Function1)new RIJRewardVideoTipsManager.showRewardSuccessTips.1.1((View)localObject));
        }
      }
    }
    this.n.postDelayed((Runnable)new RIJRewardVideoTipsManager.showRewardSuccessTips.2(this), 2000L);
  }
  
  private final void d()
  {
    e();
    Object localObject = this.j;
    if (localObject != null)
    {
      localObject = ((ShortVideoItemHolder)localObject).v();
      if (localObject != null)
      {
        TextView localTextView = this.l;
        if (localTextView != null) {
          localTextView.setText((CharSequence)this.d);
        }
        int i1;
        if (ReadInJoyHelper.b()) {
          i1 = -this.g;
        } else {
          i1 = -this.g + ((ViewGroup)localObject).getWidth() + ViewUtils.dip2px(8.0F);
        }
        int i2;
        if (ReadInJoyHelper.b()) {
          i2 = -((ViewGroup)localObject).getHeight() + ViewUtils.dip2px(5.0F);
        } else {
          i2 = -((ViewGroup)localObject).getHeight() - ViewUtils.dip2px(30.0F);
        }
        a((View)this.l, (View)localObject, this.g, i1, i2, (Function1)new RIJRewardVideoTipsManager.showRewardCoinGuide.1.1((ViewGroup)localObject));
      }
    }
    this.n.postDelayed((Runnable)new RIJRewardVideoTipsManager.showRewardCoinGuide.2(this), 2000L);
  }
  
  private final void e()
  {
    if (this.l == null)
    {
      int i1 = ViewUtils.dip2px(8.0F);
      int i2 = ViewUtils.dip2px(10.0F);
      TextView localTextView = new TextView((Context)this.p);
      localTextView.setId(2131447062);
      localTextView.setGravity(17);
      localTextView.setTextSize(2, 14.0F);
      localTextView.setTextColor(-1);
      localTextView.setPadding(i2, i1, i2, i1);
      localTextView.setSingleLine(true);
      float f1 = localTextView.getPaint().measureText(this.d);
      float f2 = i2 * 2;
      this.g = ((int)(f1 + f2 + ViewUtils.dip2px(6.0F)));
      this.h = ((int)(localTextView.getPaint().measureText(this.e) + f2 + ViewUtils.dip2px(6.0F)));
      this.l = localTextView;
    }
  }
  
  private final void f()
  {
    try
    {
      BubblePopupWindow localBubblePopupWindow = this.k;
      if (localBubblePopupWindow != null) {
        localBubblePopupWindow.dismiss();
      }
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    this.k = ((BubblePopupWindow)null);
  }
  
  public final void a()
  {
    this.p = ((Activity)null);
    this.q = ((RIJVideoRewardCoinManager)null);
    b();
  }
  
  public final void a(int paramInt)
  {
    if (this.f)
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
      this.m = new VPNGImageView((Context)this.p);
      localObject2 = this.m;
      if (localObject2 != null) {
        ((VPNGImageView)localObject2).setBackgroundColor(1275068416);
      }
      localObject2 = this.m;
      if (localObject2 != null) {
        ((VPNGImageView)localObject2).setPlayOnSubThread(true);
      }
      localObject2 = this.m;
      if (localObject2 != null) {
        ((VPNGImageView)localObject2).setVideo((String)localObject1, false, 1, (LiveRoomGiftCallback)new RIJRewardVideoTipsManager.onRewardSuccess.1(this));
      }
      localObject1 = this.p;
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
        ((ViewGroup)localObject1).addView((View)this.m, -1, -1);
      }
    }
    else
    {
      c();
    }
  }
  
  public final void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i3 = 1;
    if (!paramBoolean)
    {
      localObject = this.j;
      if (localObject != null)
      {
        localObject = ((ShortVideoItemHolder)localObject).af;
        if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 8))
        {
          i1 = 1;
          break label50;
        }
      }
    }
    int i1 = 0;
    label50:
    Object localObject = this.q;
    if (localObject != null) {
      paramBoolean = ((RIJVideoRewardCoinManager)localObject).j();
    } else {
      paramBoolean = false;
    }
    int i2;
    if ((paramLong2 > 0L) && ((float)paramLong1 / (float)paramLong2 > this.c)) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((!this.b) || (!RIJRewardTaskConfig.a.r())) {
      i3 = 0;
    }
    if ((i1 != 0) && (this.i) && (!paramBoolean) && (i2 != 0) && (i3 != 0))
    {
      this.i = false;
      RIJRewardTaskConfig.a.s();
      d();
    }
  }
  
  public final void a(@Nullable ShortVideoItemHolder paramShortVideoItemHolder)
  {
    if (paramShortVideoItemHolder != null)
    {
      ViewGroup localViewGroup = paramShortVideoItemHolder.v();
      if ((localViewGroup != null) && (localViewGroup.getVisibility() == 0))
      {
        bool = true;
        break label27;
      }
    }
    boolean bool = false;
    label27:
    this.i = bool;
    this.j = paramShortVideoItemHolder;
    f();
    b();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardVideoTipsManager
 * JD-Core Version:    0.7.0.1
 */