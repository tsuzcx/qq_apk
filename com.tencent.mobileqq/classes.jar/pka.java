import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.FusionBiuButton.3;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.FusionBiuButton.4;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.FusionBiuButton.5;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

public class pka
  extends ButtonBase
  implements View.OnAttachStateChangeListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  
  public pka(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a()
  {
    pkb localpkb = new pkb(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addOnAttachStateChangeListener(new pkc(this, localpkb));
  }
  
  private void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramVafContext.getContext());
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramVafContext.getContext());
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(paramVafContext.getContext());
    Object localObject = new ViewGroup.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(baxn.a(paramVafContext.getContext(), 44.0F), baxn.a(paramVafContext.getContext(), 44.0F));
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(baxn.a(paramVafContext.getContext(), 10.0F), baxn.a(paramVafContext.getContext(), 10.0F), baxn.a(paramVafContext.getContext(), 8.0F), baxn.a(paramVafContext.getContext(), 10.0F));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841204);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    localObject = new LinearLayout.LayoutParams(baxn.a(paramVafContext.getContext(), 48.0F), baxn.a(paramVafContext.getContext(), 44.0F));
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    int i = baxn.a(paramVafContext.getContext(), 8.2F);
    int j = baxn.a(paramVafContext.getContext(), -1.0F);
    int k = baxn.a(paramVafContext.getContext(), -0.5F);
    int m = baxn.a(paramVafContext.getContext(), 4.8F);
    this.jdField_b_of_type_AndroidWidgetImageView.setPadding(i, j, k, m);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.addOnAttachStateChangeListener(this);
    a();
  }
  
  private void a(boolean paramBoolean)
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLocationInWindow(arrayOfInt);
    long l1 = bbdh.k();
    long l2 = arrayOfInt[0];
    long l3 = baxn.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 65.0F);
    osj.a().b(paramBoolean, l1 - l2 - l3);
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if ((localArticleInfo != null) && (rlz.a().b()) && (paramString.equals(localArticleInfo.innerUniqueID)) && (paramBoolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new FusionBiuButton.3(this));
      if (localArticleInfo.fusionBiuInfo != null)
      {
        localArticleInfo.fusionBiuInfo.a = 0L;
        localArticleInfo.fusionBiuInfo.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if ((localArticleInfo != null) && (rlz.a().b()) && (localArticleInfo.innerUniqueID != null) && (localArticleInfo.innerUniqueID.equals(paramString)))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (paramInt == this.jdField_a_of_type_Int) {
          e();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841214);
      }
      if (localArticleInfo.fusionBiuInfo != null)
      {
        localArticleInfo.fusionBiuInfo.jdField_b_of_type_Boolean = paramBoolean;
        localArticleInfo.fusionBiuInfo.a = paramLong;
      }
    }
  }
  
  private void b()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oqb.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FusionBiuButton", 1, localException.toString());
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.removeAllUpdateListeners();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    FusionBiuInfo localFusionBiuInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
    if (localFusionBiuInfo != null)
    {
      if (localFusionBiuInfo.jdField_b_of_type_Boolean) {
        break label77;
      }
      rlz.a().a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), onh.a(), 1, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    for (;;)
    {
      rlz.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 1, 1);
      return;
      label77:
      rlz.a().a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.a, onh.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_b_of_type_AndroidWidgetImageView.invalidate();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getComposition();
      long l = 1249L;
      if (localObject != null) {
        l = ((LottieComposition)localObject).getDuration();
      }
      localObject = new FusionBiuButton.4(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject, l);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FusionBiuButton.5(this), ((float)l * 0.3F));
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return;
    }
    b();
  }
  
  private void f()
  {
    ImageView localImageView;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo != null))
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_b_of_type_Boolean) {
        break label55;
      }
    }
    label55:
    for (int i = 2130841214;; i = 2130841204)
    {
      localImageView.setImageResource(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.c = true;
      return;
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
    f();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      rlz.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, 0, 1, 1);
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public boolean onClick()
  {
    if (rlz.a().b()) {
      d();
    }
    try
    {
      rlz.a().a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_b_of_type_Boolean);
      return true;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.e("FusionBiuButton", 1, "yangbaobao " + localNullPointerException.toString());
      localNullPointerException.printStackTrace();
    }
    return true;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(paramInt1 - baxn.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 10.0F), paramInt2, paramInt3 - baxn.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 10.0F), paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.makeMeasureSpec(baxn.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 44.0F), 0);
    paramInt2 = View.MeasureSpec.makeMeasureSpec(baxn.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext(), 44.0F), 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    b();
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    c();
  }
  
  public void setBackgroundColorForStates() {}
  
  public void setBackgroundForStates() {}
  
  public void setCompoundDrawableForStates() {}
  
  public void setTextColorForStates() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pka
 * JD-Core Version:    0.7.0.1
 */