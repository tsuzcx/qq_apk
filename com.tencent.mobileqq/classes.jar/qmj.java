import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.10;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.5;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.7;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.8;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.9;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class qmj
  extends qmg
{
  public Handler a;
  private qmo a;
  
  public qmj(qlp paramqlp, qmo paramqmo)
  {
    super(paramqlp, paramqmo);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Qmo = paramqmo;
    if (!paramqmo.jdField_a_of_type_Boolean) {
      a(paramqmo.itemView);
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.874F, 1, 0.0F);; localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.874F, 1, 1.0F))
    {
      localScaleAnimation.setDuration(350L);
      localScaleAnimation.setAnimationListener(new qmm(this, paramRelativeLayout));
      paramRelativeLayout.startAnimation(localScaleAnimation);
      return;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramVideoInfo.e())
    {
      paramTextView.setText(qoi.c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_Int) + ajya.a(2131716236));
      paramTextView.setVisibility(0);
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && (paramVideoInfo.jdField_a_of_type_Int != 5) && (paramVideoInfo.s > 0))
    {
      paramTextView.setText(qoi.a(paramVideoInfo.s));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qmo.jdField_a_of_type_Qql.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if ((rlz.a().b()) && (paramString.equals(localArticleInfo.innerUniqueID)) && (paramBoolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsAdapter.ShortVideoItemDelegate.8(this));
      if (localArticleInfo.fusionBiuInfo != null)
      {
        localArticleInfo.fusionBiuInfo.a = 0L;
        localArticleInfo.fusionBiuInfo.b = false;
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qmo.jdField_a_of_type_Qql.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if ((rlz.a().b()) && (localArticleInfo.innerUniqueID != null) && (localArticleInfo.innerUniqueID.equals(paramString)))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (paramInt == 4) {
          e();
        }
        this.jdField_a_of_type_Qmo.jdField_k_of_type_AndroidWidgetImageView.setImageResource(2130841214);
      }
      if (localArticleInfo.fusionBiuInfo != null)
      {
        localArticleInfo.fusionBiuInfo.b = paramBoolean;
        localArticleInfo.fusionBiuInfo.a = paramLong;
      }
    }
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qmo.jdField_a_of_type_Qjn == null) {
      return;
    }
    if (paramVideoInfo.e()) {}
    for (boolean bool = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Boolean; (TextUtils.isEmpty(paramVideoInfo.j)) || ("16888".equals(paramVideoInfo.j)) || (paramVideoInfo.jdField_c_of_type_Boolean) || (paramVideoInfo.a(qlp.a(this.jdField_a_of_type_Qlp))); bool = paramVideoInfo.jdField_k_of_type_Boolean)
    {
      this.jdField_a_of_type_Qmo.jdField_a_of_type_Qjn.a().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Qmo.jdField_a_of_type_Qjn.a(paramVideoInfo, paramVideoInfo.jdField_k_of_type_Boolean);
    if ((paramBoolean) && (this.jdField_a_of_type_Qmo == qlp.a(this.jdField_a_of_type_Qlp)) && (qlp.a(this.jdField_a_of_type_Qlp) != null) && (bool) && (this.jdField_a_of_type_Qmo.jdField_a_of_type_Qjn.a().getVisibility() == 0))
    {
      qlp.a(this.jdField_a_of_type_Qlp).sendEmptyMessageDelayed(7, this.jdField_a_of_type_Qmo.jdField_a_of_type_Qjn.a());
      return;
    }
    if (bool)
    {
      this.jdField_a_of_type_Qmo.jdField_a_of_type_Qjn.a().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Qmo.jdField_a_of_type_Qjn.a().setVisibility(0);
  }
  
  private void d(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.K))
    {
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth();
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.K, localURLDrawableOptions);
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_Qmo.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Qmo.m.setVisibility(0);
      this.jdField_a_of_type_Qmo.m.setImageDrawable(this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_a_of_type_Qmo.m.invalidate();
      this.jdField_a_of_type_Qmo.m.setScaleX(1.43F);
      this.jdField_a_of_type_Qmo.m.setScaleY(1.43F);
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(0);
      Object localObject = this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getComposition();
      long l = 1249L;
      if (localObject != null) {
        l = ((LottieComposition)localObject).getDuration();
      }
      localObject = new VideoFeedsAdapter.ShortVideoItemDelegate.9(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject, l);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsAdapter.ShortVideoItemDelegate.10(this), ((float)l * 0.3F));
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return;
    }
    this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oqb.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
  }
  
  private void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qmo.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = actj.a(0.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
      this.jdField_a_of_type_Qmo.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qmo.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (actj.a(15.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources()) - 20);
    this.jdField_a_of_type_Qmo.g.setLayoutParams(localMarginLayoutParams);
  }
  
  int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qmo.jdField_a_of_type_Boolean)
    {
      if (paramBoolean) {
        return 2130842549;
      }
      return 2130842551;
    }
    return super.a(paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (qlp.a(this.jdField_a_of_type_Qlp) != null) {
      qlp.a(this.jdField_a_of_type_Qlp).a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramActivity.getWindow().getDecorView().findViewById(2131363286);
    if (localRelativeLayout == null) {
      return;
    }
    localRelativeLayout.setVisibility(4);
    ThreadManager.getUIHandler().post(new VideoFeedsAdapter.ShortVideoItemDelegate.7(this, localRelativeLayout, paramBoolean, paramActivity));
  }
  
  public void a(View paramView)
  {
    paramView.addOnAttachStateChangeListener(new qml(this, new qmk(this)));
    ThreadManager.getUIHandler().post(new VideoFeedsAdapter.ShortVideoItemDelegate.5(this));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    b(true);
    Object localObject1;
    if (this.jdField_a_of_type_Qmo.jdField_k_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      if (!paramVideoInfo.e()) {
        break label536;
      }
      this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_Qmo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      this.jdField_a_of_type_Qmo.e.setVisibility(0);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = qlp.a(this.jdField_a_of_type_Qlp);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = qlp.a(this.jdField_a_of_type_Qlp);
    }
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.b), (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(bavw.b(baxn.a(qlp.a(this.jdField_a_of_type_Qlp), 40.0F), baxn.a(qlp.a(this.jdField_a_of_type_Qlp), 40.0F), baxn.a(qlp.a(this.jdField_a_of_type_Qlp), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bavw.i);
        this.jdField_a_of_type_Qmo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a());
        b(paramVideoInfo, false);
        this.jdField_a_of_type_Qmo.jdField_k_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_Qmo);
        this.jdField_a_of_type_Qmo.jdField_k_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_Qlp);
        this.jdField_a_of_type_Qmo.jdField_a_of_type_Qjn.a().setTag(this.jdField_a_of_type_Qmo);
        this.jdField_a_of_type_Qmo.jdField_a_of_type_Qjn.a().setOnClickListener(this.jdField_a_of_type_Qlp);
        j(true);
        if (this.jdField_a_of_type_Qmo.jdField_l_of_type_AndroidViewViewGroup.getVisibility() == 0) {
          a(this.jdField_a_of_type_Qmo, paramVideoInfo);
        }
        if (!paramVideoInfo.b(qlp.a(this.jdField_a_of_type_Qlp))) {
          break label914;
        }
        this.jdField_a_of_type_Qmo.h.setVisibility(8);
        if ((qlp.a(this.jdField_a_of_type_Qlp) == this.jdField_a_of_type_Qmo) && (qlp.a(this.jdField_a_of_type_Qlp)))
        {
          b(false);
          j(false);
        }
        if (paramVideoInfo.a()) {
          this.jdField_a_of_type_Qmo.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable(qlp.a(this.jdField_a_of_type_Qlp, a(paramVideoInfo.l)));
        }
        try
        {
          localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
          if ((!this.jdField_a_of_type_Qmo.jdField_a_of_type_Boolean) && (rlz.a().b()) && (localObject1 != null))
          {
            ImageView localImageView = this.jdField_a_of_type_Qmo.jdField_k_of_type_AndroidWidgetImageView;
            if (!((FusionBiuInfo)localObject1).b) {
              break label928;
            }
            i = 2130841214;
            localImageView.setImageResource(i);
            if (this.jdField_a_of_type_Qmo != null) {
              ((FusionBiuInfo)localObject1).jdField_c_of_type_Boolean = true;
            }
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          int i;
          Object localObject2;
          localNullPointerException.printStackTrace();
          continue;
        }
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Qmo, this.jdField_a_of_type_Qlp);
        qlp.a(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qmo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo);
        qlp.a(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qmo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo, Boolean.valueOf(qlp.a(this.jdField_a_of_type_Qlp)));
        return;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException1.getMessage());
        continue;
      }
      label536:
      if (!paramVideoInfo.b)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.jdField_k_of_type_JavaLangString))
        {
          this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_k_of_type_JavaLangString);
          this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
          VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.jdField_k_of_type_JavaLangString);
          VideoFeedsAccessibilityHelper.c(this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramVideoInfo.jdField_k_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(paramVideoInfo.E))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getWidth();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getHeight();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = qlp.a(this.jdField_a_of_type_Qlp);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = qlp.a(this.jdField_a_of_type_Qlp);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.getDrawable(new URL(paramVideoInfo.E), (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(bavw.a);
          this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject2);
          d(paramVideoInfo);
          if (qlp.l(this.jdField_a_of_type_Qlp)) {
            this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
          }
          this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          this.jdField_a_of_type_Qmo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
          this.jdField_a_of_type_Qmo.e.setVisibility(8);
        }
        catch (MalformedURLException localMalformedURLException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException2.getMessage());
          continue;
        }
        if (!TextUtils.isEmpty(paramVideoInfo.j))
        {
          this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(qlp.a(this.jdField_a_of_type_Qlp));
          this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(Long.valueOf(paramVideoInfo.j).longValue(), false);
        }
        else
        {
          this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(qlp.a(this.jdField_a_of_type_Qlp));
          continue;
          this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(paramVideoInfo.j);
          this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(paramVideoInfo.j);
        }
      }
      label914:
      this.jdField_a_of_type_Qmo.h.setVisibility(0);
      continue;
      label928:
      i = 2130842517;
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.jdField_a_of_type_Qmo.B.getPaint().setFakeBoldText(false);
    if (qlp.a(this.jdField_a_of_type_Qlp) != null) {
      qlp.a(this.jdField_a_of_type_Qlp).a(paramVideoInfo, this.jdField_a_of_type_Qmo, false);
    }
    if (paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) {
      if ((this.jdField_a_of_type_Qmo.i != null) && (this.jdField_a_of_type_Qmo.i.getVisibility() != 8))
      {
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.1(this, paramVideoInfo));
        this.jdField_a_of_type_Qmo.d.setBackgroundDrawable(null);
        if (!paramVideoInfo.b(qlp.a(this.jdField_a_of_type_Qlp))) {
          break label387;
        }
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
        if (this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        label155:
        k(false);
        if ((qlp.a(this.jdField_a_of_type_Qlp).a()) && (qlp.k(this.jdField_a_of_type_Qlp)))
        {
          qlp.h(this.jdField_a_of_type_Qlp, false);
          d(true);
        }
        if ((this.jdField_a_of_type_Qmo.jdField_c_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_Int != 0)) {
          break label424;
        }
        if (this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
          this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = new VideoFeedsAioGuideView(qlp.a(this.jdField_a_of_type_Qlp), qlp.a(this.jdField_a_of_type_Qlp), qlp.a(this.jdField_a_of_type_Qlp));
        }
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a(this.jdField_a_of_type_Qmo);
        label273:
        if (!paramVideoInfo.b(qlp.a(this.jdField_a_of_type_Qlp))) {
          break label455;
        }
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      }
    }
    for (;;)
    {
      a(paramVideoInfo, this.jdField_a_of_type_Qmo.jdField_b_of_type_AndroidWidgetTextView);
      return;
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(qlp.a(this.jdField_a_of_type_Qlp), this.jdField_a_of_type_Qlp, paramVideoInfo, qlp.c(this.jdField_a_of_type_Qlp), qlp.e(this.jdField_a_of_type_Qlp));
      break;
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(8);
      break;
      label387:
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(8);
      if (this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidViewView == null) {
        break label155;
      }
      this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label155;
      label424:
      if (this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
        break label273;
      }
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.c();
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = null;
      break label273;
      label455:
      if (paramVideoInfo.a() != null)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        localObject = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(bavw.w);
        ((URLDrawable)localObject).setAlpha(35);
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
    label171:
    Object localObject;
    if (!paramVideoInfo.b)
    {
      if (paramVideoInfo.e())
      {
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a());
        VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      d(paramVideoInfo);
      this.jdField_a_of_type_Qmo.B.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_Qmo.A.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      qlp.a(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qmo, paramVideoInfo);
      b(paramVideoInfo, true);
      if ((paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.getVisibility() == 8))
      {
        if ((this.jdField_a_of_type_Qmo.i == null) || (this.jdField_a_of_type_Qmo.i.getVisibility() == 8)) {
          break label462;
        }
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.2(this, paramVideoInfo));
        qlp.a(this.jdField_a_of_type_Qlp, paramVideoInfo);
      }
      a(paramVideoInfo, this.jdField_a_of_type_Qmo.jdField_b_of_type_AndroidWidgetTextView);
      qlp.a(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qmo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo);
      qlp.a(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qmo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo, Boolean.valueOf(qlp.a(this.jdField_a_of_type_Qlp)));
      if (!this.jdField_a_of_type_Qmo.jdField_a_of_type_Boolean)
      {
        localObject = null;
        if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          localObject = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
        }
        if ((rlz.a().b()) && (localObject != null))
        {
          paramVideoInfo = this.jdField_a_of_type_Qmo.jdField_k_of_type_AndroidWidgetImageView;
          if (!((FusionBiuInfo)localObject).b) {
            break label523;
          }
        }
      }
    }
    label523:
    for (int i = 2130841214;; i = 2130842517)
    {
      paramVideoInfo.setImageResource(i);
      ((FusionBiuInfo)localObject).jdField_c_of_type_Boolean = true;
      return;
      if (!TextUtils.isEmpty(paramVideoInfo.jdField_k_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_k_of_type_JavaLangString);
        VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.jdField_k_of_type_JavaLangString);
      }
      if ((!TextUtils.isEmpty(paramVideoInfo.E)) || (TextUtils.isEmpty(paramVideoInfo.j)))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bbef.a(true);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bbef.a(true);
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageSrc(paramVideoInfo.E);
        break;
      }
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(bbef.a(true));
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(Long.valueOf(paramVideoInfo.j).longValue(), false);
      break;
      label462:
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
      this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(qlp.a(this.jdField_a_of_type_Qlp), this.jdField_a_of_type_Qlp, paramVideoInfo, qlp.c(this.jdField_a_of_type_Qlp), qlp.e(this.jdField_a_of_type_Qlp));
      break label171;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Qmo.d.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      h(bool);
      return;
    }
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_Qmo.jdField_a_of_type_Boolean)
    {
      qoi.b(this.jdField_a_of_type_Qmo.D, paramVideoInfo.e, "评论");
      this.jdField_a_of_type_Qmo.j.setImageResource(2130842548);
      return;
    }
    super.c(paramVideoInfo);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qmo.jdField_b_of_type_ComTencentImageURLImageView.clearAnimation();
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Qmo.jdField_a_of_type_Qql.a.b(qlp.a(this.jdField_a_of_type_Qlp)))
      {
        this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, qoi.b(qlp.a(this.jdField_a_of_type_Qlp)));
        k(true);
      }
      if (this.jdField_a_of_type_Qmo.d.getVisibility() == 0) {
        this.jdField_a_of_type_Qmo.d.setVisibility(8);
      }
      this.jdField_a_of_type_Qmo.h.setVisibility(8);
      return;
    }
    if (!this.jdField_a_of_type_Qmo.jdField_a_of_type_Qql.a.b(qlp.a(this.jdField_a_of_type_Qlp)))
    {
      this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      k(false);
      this.jdField_a_of_type_Qmo.h.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Qmo.h.setVisibility(8);
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_Qmo.d.setBackgroundDrawable(qlp.b(this.jdField_a_of_type_Qlp));
      k(true);
      if (this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) {
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
      }
    }
    label216:
    for (;;)
    {
      if (this.jdField_a_of_type_Qmo.jdField_a_of_type_Qql != null) {
        qlp.a(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qmo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Qmo.jdField_a_of_type_Qql.a, Boolean.valueOf(paramBoolean));
      }
      return;
      this.jdField_a_of_type_Qmo.d.setBackgroundDrawable(null);
      if (!qlp.a(this.jdField_a_of_type_Qlp).a()) {
        k(false);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) || (this.jdField_a_of_type_Qmo.jdField_c_of_type_Int != 0) || (this.jdField_a_of_type_Qmo.jdField_a_of_type_Qql == null) || (this.jdField_a_of_type_Qmo.jdField_a_of_type_Qql.a.jdField_a_of_type_Int != 0)) {
          break label216;
        }
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
        break;
        this.jdField_a_of_type_Qmo.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, qoi.b(qlp.a(this.jdField_a_of_type_Qlp)));
      }
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    super.h(paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Qmo.o.getVisibility() == 0)
      {
        qoi.a(this.jdField_a_of_type_Qmo.o, 8, 200);
        this.jdField_a_of_type_Qmo.o.animate().translationY(20.0F).setDuration(200L).start();
        this.jdField_a_of_type_Qmo.g.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (!qlp.a(this.jdField_a_of_type_Qlp))) {
        this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
      }
    }
    do
    {
      return;
      if ((!qlp.a(this.jdField_a_of_type_Qlp)) && (this.jdField_a_of_type_Qmo.o.getVisibility() == 8))
      {
        qoi.a(this.jdField_a_of_type_Qmo.o, 0, 200);
        this.jdField_a_of_type_Qmo.o.animate().translationY(0.0F).setDuration(200L).start();
        this.jdField_a_of_type_Qmo.g.animate().translationY(0.0F).setDuration(200L).start();
      }
    } while (this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null);
    this.jdField_a_of_type_Qmo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmj
 * JD-Core Version:    0.7.0.1
 */