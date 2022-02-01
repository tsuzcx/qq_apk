import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardVideoTipsManager.showRewardCoinGuide.1.1;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardVideoTipsManager.showRewardCoinGuide.2;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardVideoTipsManager.showRewardSuccessTips.1.1;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardVideoTipsManager.showRewardSuccessTips.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import cooperation.liveroom.LiveRoomGiftCallback;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardVideoTipsManager;", "", "context", "Landroid/app/Activity;", "rewardCoinManager", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJVideoRewardCoinManager;", "(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJVideoRewardCoinManager;)V", "curItemNeedShowGuide", "", "enable", "handler", "Landroid/os/Handler;", "holder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemHolder;", "popupWindow", "Lcom/tencent/biz/pubaccount/readinjoy/video/discovery/BubblePopupWindow;", "promptView", "Landroid/widget/TextView;", "rewardCoinGuideWordWidth", "", "rewardCoinGuideWords", "", "rewardSuccessAnimEnable", "rewardSuccessTipsWordWidth", "rewardSuccessTipsWords", "targetPercent", "", "vpngImageView", "Lcom/tencent/mobileqq/vpng/view/VPNGImageView;", "dismissPopupWindow", "", "initPromptView", "onCenterViewChanged", "itemHolder", "onDestory", "onProgressChanged", "pos", "", "duration", "isCommentVisiable", "onRewardSuccess", "type", "releaseVpng", "showBubblePopupWindow", "contentView", "Landroid/view/View;", "archer", "width", "xOffset", "yOffset", "callback", "Lkotlin/Function1;", "showRewardCoinGuide", "showRewardSuccessTips", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rkh
{
  public static final rki a;
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VPNGImageView jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
  private final String jdField_a_of_type_JavaLangString;
  private rkk jdField_a_of_type_Rkk;
  private sse jdField_a_of_type_Sse;
  private swr jdField_a_of_type_Swr;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  private final boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_Rki = new rki(null);
  }
  
  public rkh(@Nullable Activity paramActivity, @Nullable rkk paramrkk)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rkk = paramrkk;
    this.jdField_a_of_type_Boolean = rjy.a();
    this.jdField_a_of_type_Float = rjy.a.a();
    this.jdField_a_of_type_JavaLangString = rjy.a.b();
    this.jdField_b_of_type_JavaLangString = rjy.a.c();
    this.jdField_b_of_type_Boolean = rjy.a.b();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private final void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, Function1<? super sse, Unit> paramFunction1)
  {
    Object localObject;
    if (this.jdField_a_of_type_Sse != null)
    {
      localObject = this.jdField_a_of_type_Sse;
      if ((localObject == null) || (((sse)localObject).isShowing() != true)) {}
    }
    for (;;)
    {
      return;
      if ((paramView1 != null) && ((paramView1.getParent() instanceof ViewGroup)))
      {
        localObject = paramView1.getParent();
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup)localObject).removeView(paramView1);
      }
      int i = ViewUtils.dip2px(10.0F);
      int j = ViewUtils.dip2px(6.0F);
      int k = ViewUtils.dip2px(6.0F);
      this.jdField_a_of_type_Sse = new sse((Context)this.jdField_a_of_type_AndroidAppActivity);
      localObject = this.jdField_a_of_type_Sse;
      if (localObject != null) {
        ((sse)localObject).setContentView(paramView1);
      }
      paramView1 = this.jdField_a_of_type_Sse;
      if (paramView1 != null) {
        paramView1.setWidth(paramInt1);
      }
      paramView1 = this.jdField_a_of_type_Sse;
      if (paramView1 != null) {
        paramView1.a(k / 2);
      }
      paramView1 = this.jdField_a_of_type_Sse;
      if (paramView1 != null) {
        paramView1.a(k, j);
      }
      paramView1 = this.jdField_a_of_type_Sse;
      if (paramView1 != null) {
        paramView1.b((int)4294942528L);
      }
      paramView1 = this.jdField_a_of_type_Sse;
      if (paramView1 != null) {
        paramView1.c(i);
      }
      paramFunction1.invoke(this.jdField_a_of_type_Sse);
      if (bmhv.d())
      {
        paramView1 = this.jdField_a_of_type_Sse;
        if (paramView1 != null) {
          paramView1.setAnimationStyle(2131755851);
        }
        try
        {
          paramView1 = this.jdField_a_of_type_Sse;
          if (paramView1 == null) {
            continue;
          }
          paramView1.showAsDropDown(paramView2, paramInt2, paramInt3, 3);
          return;
        }
        catch (Exception paramView1) {}
      }
      else
      {
        paramView1 = this.jdField_a_of_type_Sse;
        if (paramView1 != null) {
          paramView1.setAnimationStyle(2131755852);
        }
        try
        {
          paramView1 = this.jdField_a_of_type_Sse;
          if (paramView1 != null)
          {
            paramView1.showAsDropDown(paramView2, paramInt2, paramInt3, 48);
            return;
          }
        }
        catch (Exception paramView1) {}
      }
    }
  }
  
  private final void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
    if (localObject1 != null) {}
    for (localObject1 = ((VPNGImageView)localObject1).getParent();; localObject1 = null)
    {
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
      return;
    }
  }
  
  private final void c()
  {
    e();
    Object localObject = this.jdField_a_of_type_Swr;
    int i;
    if (localObject != null)
    {
      localObject = ((swr)localObject).b;
      if (localObject != null)
      {
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localTextView != null) {
          localTextView.setText((CharSequence)this.jdField_b_of_type_JavaLangString);
        }
        if (!bmhv.d()) {
          break label136;
        }
        i = -this.jdField_b_of_type_Int - ViewUtils.dip2px(8.0F);
        if (!bmhv.d()) {
          break label141;
        }
      }
    }
    label136:
    label141:
    for (int j = -((ReadInJoyHeadImageView)localObject).getHeight() + ViewUtils.dip2px(5.0F);; j = -((ReadInJoyHeadImageView)localObject).getHeight() - ViewUtils.dip2px(50.0F))
    {
      a((View)this.jdField_a_of_type_AndroidWidgetTextView, (View)localObject, this.jdField_b_of_type_Int, i, j, (Function1)new RIJRewardVideoTipsManager.showRewardSuccessTips.1.1((ReadInJoyHeadImageView)localObject));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)new RIJRewardVideoTipsManager.showRewardSuccessTips.2(this), 2000L);
      return;
      i = 0;
      break;
    }
  }
  
  private final void d()
  {
    e();
    Object localObject = this.jdField_a_of_type_Swr;
    int i;
    if (localObject != null)
    {
      localObject = ((swr)localObject).c();
      if (localObject != null)
      {
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localTextView != null) {
          localTextView.setText((CharSequence)this.jdField_a_of_type_JavaLangString);
        }
        if (!bmhv.d()) {
          break label130;
        }
        i = -this.jdField_a_of_type_Int;
        if (!bmhv.d()) {
          break label150;
        }
      }
    }
    label130:
    label150:
    for (int j = -((ViewGroup)localObject).getHeight() + ViewUtils.dip2px(5.0F);; j = -((ViewGroup)localObject).getHeight() - ViewUtils.dip2px(30.0F))
    {
      a((View)this.jdField_a_of_type_AndroidWidgetTextView, (View)localObject, this.jdField_a_of_type_Int, i, j, (Function1)new RIJRewardVideoTipsManager.showRewardCoinGuide.1.1((ViewGroup)localObject));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)new RIJRewardVideoTipsManager.showRewardCoinGuide.2(this), 2000L);
      return;
      i = -this.jdField_a_of_type_Int + ((ViewGroup)localObject).getWidth() + ViewUtils.dip2px(8.0F);
      break;
    }
  }
  
  private final void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      int i = ViewUtils.dip2px(8.0F);
      int j = ViewUtils.dip2px(10.0F);
      TextView localTextView = new TextView((Context)this.jdField_a_of_type_AndroidAppActivity);
      localTextView.setId(2131378658);
      localTextView.setGravity(17);
      localTextView.setTextSize(2, 14.0F);
      localTextView.setTextColor(-1);
      localTextView.setPadding(j, i, j, i);
      localTextView.setSingleLine(true);
      this.jdField_a_of_type_Int = ((int)(localTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangString) + j * 2 + ViewUtils.dip2px(6.0F)));
      this.jdField_b_of_type_Int = ((int)(localTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangString) + j * 2 + ViewUtils.dip2px(6.0F)));
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView;
    }
  }
  
  private final void f()
  {
    try
    {
      sse localsse = this.jdField_a_of_type_Sse;
      if (localsse != null) {
        localsse.dismiss();
      }
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    this.jdField_a_of_type_Sse = ((sse)null);
  }
  
  public final void a()
  {
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)null);
    this.jdField_a_of_type_Rkk = ((rkk)null);
    b();
  }
  
  public final void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      Object localObject2;
      switch (paramInt)
      {
      default: 
        localObject1 = "https://kd.qpic.cn/bankjiang/videos/one_cack_video_980851a6.mp4";
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
          ((VPNGImageView)localObject2).setVideo((String)localObject1, false, 1, (LiveRoomGiftCallback)new rkj(this));
        }
        localObject1 = this.jdField_a_of_type_AndroidAppActivity;
        if (localObject1 != null)
        {
          localObject1 = ((Activity)localObject1).getWindow();
          if (localObject1 == null) {
            break;
          }
        }
        break;
      }
      for (Object localObject1 = ((Window)localObject1).getDecorView();; localObject1 = null)
      {
        localObject2 = localObject1;
        if (!(localObject1 instanceof ViewGroup)) {
          localObject2 = null;
        }
        localObject1 = (ViewGroup)localObject2;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).addView((View)this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView, -1, -1);
        }
        return;
        localObject1 = "https://kd.qpic.cn/bankjiang/videos/one_cack_video_980851a6.mp4";
        break;
        localObject1 = "https://kd.qpic.cn/bankjiang/videos/three_cake_video_6ea49db8.mp4";
        break;
      }
    }
    c();
  }
  
  public final void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int k = 1;
    int i;
    label62:
    int j;
    if (!paramBoolean)
    {
      Object localObject = this.jdField_a_of_type_Swr;
      if (localObject != null)
      {
        localObject = ((swr)localObject).d;
        if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 8))
        {
          i = 1;
          localObject = this.jdField_a_of_type_Rkk;
          if (localObject == null) {
            break label149;
          }
          paramBoolean = ((rkk)localObject).a();
          if ((paramLong2 <= 0L) || ((float)paramLong1 / (float)paramLong2 <= this.jdField_a_of_type_Float)) {
            break label155;
          }
          j = 1;
          label84:
          if ((!this.jdField_a_of_type_Boolean) || (!rjy.a.d())) {
            break label161;
          }
        }
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.c) && (!paramBoolean) && (j != 0) && (k != 0))
      {
        this.c = false;
        rjy.a.a();
        d();
      }
      return;
      i = 0;
      break;
      label149:
      paramBoolean = false;
      break label62;
      label155:
      j = 0;
      break label84;
      label161:
      k = 0;
    }
  }
  
  public final void a(@Nullable swr paramswr)
  {
    if (paramswr != null)
    {
      ViewGroup localViewGroup = paramswr.c();
      if ((localViewGroup == null) || (localViewGroup.getVisibility() != 0)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      this.jdField_a_of_type_Swr = paramswr;
      f();
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkh
 * JD-Core Version:    0.7.0.1
 */