import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJVideoRewardCoinManager.showRewardCoinPopupWindow.2;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJVideoRewardCoinManager;", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "context", "Landroid/app/Activity;", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJVideoRewardCoinManager$Callback;", "(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJVideoRewardCoinManager$Callback;)V", "btnAnimEnable", "", "coinCount", "", "curSelectItem", "curVideoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "hasRewardCoin", "headerHint", "Landroid/widget/TextView;", "lastRequestMyCoinCountTime", "", "multiCoinBtn", "Landroid/view/View;", "multiCoinIcon", "Landroid/widget/ImageView;", "multiCoinText", "myCoinCountText", "oneCoinBtn", "oneCoinIcon", "oneCoinText", "popupWindow", "Landroid/widget/PopupWindow;", "popupWindowView", "rewardCoinBtn", "rewardSelectedItem", "dismissPopupWindow", "", "getAnimDrawable", "Lcom/tencent/image/URLDrawable;", "url", "", "getRewardCoinCount", "index", "initPopupwindow", "initUI", "isShowing", "onBackPress", "onDestory", "onQueryUserCoinResult", "success", "retCode", "retMsg", "userCoin", "Lcom/tencent/biz/pubaccount/readinjoy/model/RIJCoinInfoModule$UserCoinInfo;", "onRewardCoinToUinResult", "reportAction", "action", "setCoinCountText", "showRewardCoinPopupWindow", "videoInfo", "Callback", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rkk
  extends pvq
{
  public static final rkm a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private rkl jdField_a_of_type_Rkl;
  private final boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  static
  {
    jdField_a_of_type_Rkm = new rkm(null);
  }
  
  public rkk(@Nullable Activity paramActivity, @Nullable rkl paramrkl)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rkl = paramrkl;
    this.jdField_a_of_type_Boolean = rjy.a.c();
    this.jdField_c_of_type_Int = -1;
    pvm.a().a((pvq)this);
    if (this.jdField_a_of_type_Boolean)
    {
      a("https://kd.qpic.cn/bankjiang/apngs/one_cake_apng_ee6293e7.png");
      a("https://kd.qpic.cn/bankjiang/apngs/three_cack_apng_7b412611.png");
    }
  }
  
  private final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return rjy.a.e();
    }
    return rjy.a.f();
  }
  
  private final URLDrawable a(String paramString)
  {
    bhop localbhop = new bhop();
    localbhop.a(1);
    return bhoo.a(paramString, localbhop, null, 4, null);
  }
  
  private final void a(String paramString, boolean paramBoolean)
  {
    int i = 1;
    Object localObject = new suu(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("video_mode", Integer.valueOf(1)).a("number", Integer.valueOf(this.jdField_a_of_type_Int + 1));
    sut localsut;
    if (paramBoolean)
    {
      localsut = ((suu)localObject).a("result", Integer.valueOf(i)).a();
      Intrinsics.checkExpressionValueIsNotNull(localsut, "VideoR5.Builder(curVideo…\n                .build()");
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label111;
      }
    }
    label111:
    for (localObject = ((VideoInfo)localObject).g;; localObject = null)
    {
      olh.a(null, "", paramString, paramString, 0, 0, (String)localObject, "", "", localsut.a(), false);
      return;
      i = 2;
      break;
    }
  }
  
  private final void d()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidViewView);
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    }
    localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.setAnimationStyle(2131755853);
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
      localPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)new rkn(this));
    }
  }
  
  private final void e()
  {
    Object localObject2 = null;
    Object localObject1 = LayoutInflater.from((Context)this.jdField_a_of_type_AndroidAppActivity);
    if (localObject1 != null)
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(2131560416, null);
      this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label479;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131377357);
      label51:
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label484;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131377362);
      label76:
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label489;
      }
      localObject1 = ((View)localObject1).findViewById(2131377352);
      label98:
      this.jdField_b_of_type_AndroidViewView = ((View)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label494;
      }
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377354);
      label123:
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label499;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131377360);
      label148:
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label504;
      }
      localObject1 = ((View)localObject1).findViewById(2131377351);
      label170:
      this.jdField_c_of_type_AndroidViewView = ((View)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label509;
      }
      localObject1 = (ImageView)((View)localObject1).findViewById(2131377353);
      label195:
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label514;
      }
    }
    label514:
    for (localObject1 = (TextView)((View)localObject1).findViewById(2131377358);; localObject1 = null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      View localView = this.jdField_a_of_type_AndroidViewView;
      localObject1 = localObject2;
      if (localView != null) {
        localObject1 = localView.findViewById(2131377356);
      }
      this.jdField_d_of_type_AndroidViewView = ((View)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)rjy.a.a());
      }
      localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)(rjy.a.e() + "个月饼"));
      }
      localObject1 = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)(rjy.a.f() + "个月饼"));
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new rko(this));
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new rkp(this));
      }
      localObject1 = this.jdField_b_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new rkq(this));
      }
      localObject1 = this.jdField_c_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new rkr(this));
      }
      localObject1 = this.jdField_d_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new rks(this));
      }
      return;
      localObject1 = null;
      break;
      label479:
      localObject1 = null;
      break label51;
      label484:
      localObject1 = null;
      break label76;
      label489:
      localObject1 = null;
      break label98;
      label494:
      localObject1 = null;
      break label123;
      label499:
      localObject1 = null;
      break label148;
      label504:
      localObject1 = null;
      break label170;
      label509:
      localObject1 = null;
      break label195;
    }
  }
  
  private final void e(int paramInt)
  {
    if (paramInt > 0) {}
    for (String str = six.e(paramInt);; str = "0")
    {
      TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setText((CharSequence)("可投喂月饼 " + str + " 〉"));
      }
      return;
    }
  }
  
  private final void f()
  {
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
    this.jdField_a_of_type_AndroidViewView = ((View)null);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
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
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      e();
    }
    paramVideoInfo = this.jdField_c_of_type_AndroidViewView;
    if (paramVideoInfo != null) {
      paramVideoInfo.setBackgroundDrawable(null);
    }
    paramVideoInfo = this.jdField_b_of_type_AndroidViewView;
    if (paramVideoInfo != null) {
      paramVideoInfo.setBackgroundResource(2130841774);
    }
    paramVideoInfo = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramVideoInfo != null) {
      paramVideoInfo.setImageResource(2130843231);
    }
    if (this.jdField_c_of_type_Int >= 0) {
      e(this.jdField_c_of_type_Int);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramVideoInfo = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramVideoInfo != null) {
        paramVideoInfo.postDelayed((Runnable)new RIJVideoRewardCoinManager.showRewardCoinPopupWindow.2(this), 500L);
      }
    }
    d();
    paramVideoInfo = this.jdField_a_of_type_Rkl;
    if (paramVideoInfo != null) {
      paramVideoInfo.a(true);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localObject != null)
    {
      paramVideoInfo = this.jdField_a_of_type_AndroidAppActivity;
      if (paramVideoInfo != null)
      {
        paramVideoInfo = paramVideoInfo.getWindow();
        if (paramVideoInfo != null)
        {
          paramVideoInfo = paramVideoInfo.getDecorView();
          ((PopupWindow)localObject).showAsDropDown(paramVideoInfo, 0, -six.b(this.jdField_a_of_type_AndroidAppActivity)[1]);
        }
      }
    }
    else
    {
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= rjy.a()) {
        break label313;
      }
    }
    label313:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (rjy.a()))
      {
        pvj.a().t();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      a(this, "0X800B2E8", false, 2, null);
      return;
      paramVideoInfo = null;
      break;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoRewardCoinManager", 2, "onRewardCoinToUinResult: success=" + paramBoolean + ", retCode=" + paramInt + ", retMsg=" + paramString);
    }
    f();
    this.jdField_b_of_type_Boolean = false;
    a("0X800B2EC", paramBoolean);
    if (paramBoolean)
    {
      paramInt = a(this.jdField_b_of_type_Int);
      this.jdField_c_of_type_Int -= paramInt;
      paramString = this.jdField_a_of_type_Rkl;
      if (paramString != null) {
        paramString.a(true, "喂饼成功", this.jdField_b_of_type_Int);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 1034) {
          break;
        }
        paramString = this.jdField_a_of_type_Rkl;
      } while (paramString == null);
      paramString.a(false, "月饼不足", this.jdField_b_of_type_Int);
      return;
      paramString = this.jdField_a_of_type_Rkl;
    } while (paramString == null);
    paramString.a(false, "喂饼失败", this.jdField_b_of_type_Int);
  }
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable qgl paramqgl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoRewardCoinManager", 2, "onQueryUserCoinResult: success=" + paramBoolean + ", retCode=" + paramInt + ", retMsg=" + paramString + ", userCoin=" + paramqgl);
    }
    if (paramBoolean) {
      if (paramqgl == null) {
        break label90;
      }
    }
    label90:
    for (paramInt = paramqgl.jdField_a_of_type_Int;; paramInt = 0)
    {
      this.jdField_c_of_type_Int = paramInt;
      e(paramInt);
      return;
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
      f();
      return true;
    }
    return false;
  }
  
  public final void c()
  {
    pvm.a().b((pvq)this);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)null);
    this.jdField_a_of_type_Rkl = ((rkl)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkk
 * JD-Core Version:    0.7.0.1
 */