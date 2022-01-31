import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.3;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.4;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.5;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.6;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.7;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class qya
  extends qxf
{
  public static final String a;
  public Handler a;
  public ImageView a;
  public LinearLayout a;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public LottieDrawable a;
  public ImageView b;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private boolean jdField_b_of_type_Boolean;
  private ImageView c;
  private ViewGroup e;
  private ViewGroup f;
  
  static
  {
    jdField_a_of_type_JavaLangString = qya.class.getSimpleName();
  }
  
  qya(View paramView, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramView, paramActivity, 0);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.e = ((ViewGroup)paramView.findViewById(2131367437));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131367438));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131367435));
    this.f = ((ViewGroup)paramView.findViewById(2131367436));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367440));
    this.c = ((ImageView)paramView.findViewById(2131376015));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366593));
    if (rmc.a().b())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366582));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363282));
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oqe.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
        if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetImageView.setTag(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(this);
        this.c.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131369581));
        paramView.addOnAttachStateChangeListener(new qyc(this, new qyb(this)));
        return;
      }
      catch (Exception paramActivity)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, paramActivity.toString());
        continue;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.post(new MultiVideoNormalItemHolder.3(this));
  }
  
  private void a(RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.864F, 1, 0.0F);; localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.864F, 1, 1.0F))
    {
      localScaleAnimation.setDuration(350L);
      localScaleAnimation.setAnimationListener(new qye(this, paramRelativeLayout));
      paramRelativeLayout.startAnimation(localScaleAnimation);
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a;
    if ((rmc.a().b()) && (paramString.equals(localArticleInfo.innerUniqueID)) && (paramBoolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new MultiVideoNormalItemHolder.4(this));
      if (localArticleInfo.fusionBiuInfo != null)
      {
        localArticleInfo.fusionBiuInfo.a = 0L;
        localArticleInfo.fusionBiuInfo.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (localArticleInfo != null) && (rmc.a().b()) && (localArticleInfo.innerUniqueID != null) && (localArticleInfo.innerUniqueID.equals(paramString)))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (paramInt == 5) {
          h();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841217);
      }
      if (localArticleInfo.fusionBiuInfo != null)
      {
        localArticleInfo.fusionBiuInfo.jdField_b_of_type_Boolean = paramBoolean;
        localArticleInfo.fusionBiuInfo.a = paramLong;
      }
    }
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.K))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth();
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.K, localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.J)) || (!qol.d()))
        {
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.J.endsWith("zip"))
        {
          oqe localoqe = oqe.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.J);
          localoqe.setRepeatCount(0);
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(localoqe);
          if (this.jdField_b_of_type_Boolean)
          {
            localoqe.playAnimation();
            this.jdField_b_of_type_Boolean = false;
          }
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.J, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  private void g()
  {
    int[] arrayOfInt;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getVisibility() == 0)
    {
      arrayOfInt = qxo.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Boolean);
      if ((arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0)) {}
    }
    else
    {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.topMargin = arrayOfInt[0];
    localLayoutParams.rightMargin = arrayOfInt[1];
    if (this.jdField_a_of_type_Boolean) {
      localLayoutParams.width = actn.a(91.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams.height = actn.a(28.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams.height = actn.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = actn.a(78.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_b_of_type_AndroidWidgetImageView.invalidate();
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleX(1.62F);
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleY(1.62F);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getComposition();
      long l = 1249L;
      if (localObject != null) {
        l = ((LottieComposition)localObject).getDuration();
      }
      localObject = new MultiVideoNormalItemHolder.5(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject, l);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MultiVideoNormalItemHolder.6(this), ((float)l * 0.3F));
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oqe.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    super.a(paramVideoInfo);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b()
  {
    super.b();
    if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k);
        VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k);
        VideoFeedsAccessibilityHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k);
      }
      nzx.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    }
    b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    ImageView localImageView;
    if ((rmc.a().b()) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.fusionBiuInfo != null))
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.fusionBiuInfo.jdField_b_of_type_Boolean) {
        break label171;
      }
    }
    label171:
    for (int i = 2130841217;; i = 2130842516)
    {
      localImageView.setImageResource(i);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.fusionBiuInfo.c = true;
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    g();
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.s > 0) {
      a();
    }
    for (;;)
    {
      f();
      g();
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setMaxWidth(2147483647);
    }
  }
  
  public void d()
  {
    super.d();
    b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    a();
    f();
    g();
    ImageView localImageView;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.fusionBiuInfo != null))
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.fusionBiuInfo.jdField_b_of_type_Boolean) {
        break label98;
      }
    }
    label98:
    for (int i = 2130841217;; i = 2130842516)
    {
      localImageView.setImageResource(i);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.fusionBiuInfo.c = true;
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    boolean bool = true;
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLocationInWindow(arrayOfInt);
    if (bbct.l() - bawz.a(this.itemView.getContext(), 0.0F) > arrayOfInt[1] + bawz.a(this.itemView.getContext(), 100.0F)) {
      if (!bool) {
        break label89;
      }
    }
    label89:
    for (RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().findViewById(2131363285);; localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().findViewById(2131363286))
    {
      if (localRelativeLayout != null) {
        break label112;
      }
      return;
      bool = false;
      break;
    }
    label112:
    localRelativeLayout.setVisibility(4);
    ThreadManager.getUIHandler().post(new MultiVideoNormalItemHolder.7(this, bool, arrayOfInt, localRelativeLayout, paramBoolean));
  }
  
  public void e()
  {
    super.e();
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getDrawable() instanceof oqe)))
    {
      ((oqe)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getDrawable()).playAnimation();
      return;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    qya localqya = (qya)paramView.getTag();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367436: 
    case 2131367438: 
      this.jdField_a_of_type_Qxu.d(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      return;
    case 2131367432: 
      this.jdField_a_of_type_Qxu.c(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      return;
    case 2131376015: 
      this.jdField_a_of_type_Qxu.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      return;
    }
    this.jdField_a_of_type_Qxu.g(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    try
    {
      rmc.a().a(localqya.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.fusionBiuInfo.jdField_b_of_type_Boolean);
      return;
    }
    catch (NullPointerException paramView)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "yangbaobao " + paramView.toString());
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qya
 * JD-Core Version:    0.7.0.1
 */