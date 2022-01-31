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

public class qmm
  extends qmj
{
  public Handler a;
  private qmr a;
  
  public qmm(qls paramqls, qmr paramqmr)
  {
    super(paramqls, paramqmr);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Qmr = paramqmr;
    if (!paramqmr.jdField_a_of_type_Boolean) {
      a(paramqmr.itemView);
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.874F, 1, 0.0F);; localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.874F, 1, 1.0F))
    {
      localScaleAnimation.setDuration(350L);
      localScaleAnimation.setAnimationListener(new qmp(this, paramRelativeLayout));
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
      paramTextView.setText(qol.c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_Int) + ajyc.a(2131716225));
      paramTextView.setVisibility(0);
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && (paramVideoInfo.jdField_a_of_type_Int != 5) && (paramVideoInfo.s > 0))
    {
      paramTextView.setText(qol.a(paramVideoInfo.s));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qmr.jdField_a_of_type_Qqo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if ((rmc.a().b()) && (paramString.equals(localArticleInfo.innerUniqueID)) && (paramBoolean))
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
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qmr.jdField_a_of_type_Qqo.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if ((rmc.a().b()) && (localArticleInfo.innerUniqueID != null) && (localArticleInfo.innerUniqueID.equals(paramString)))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (paramInt == 4) {
          e();
        }
        this.jdField_a_of_type_Qmr.jdField_k_of_type_AndroidWidgetImageView.setImageResource(2130841217);
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
    if (this.jdField_a_of_type_Qmr.jdField_a_of_type_Qjq == null) {
      return;
    }
    if (paramVideoInfo.e()) {}
    for (boolean bool = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Boolean; (TextUtils.isEmpty(paramVideoInfo.j)) || ("16888".equals(paramVideoInfo.j)) || (paramVideoInfo.jdField_c_of_type_Boolean) || (paramVideoInfo.a(qls.a(this.jdField_a_of_type_Qls))); bool = paramVideoInfo.jdField_k_of_type_Boolean)
    {
      this.jdField_a_of_type_Qmr.jdField_a_of_type_Qjq.a().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Qmr.jdField_a_of_type_Qjq.a(paramVideoInfo, paramVideoInfo.jdField_k_of_type_Boolean);
    if ((paramBoolean) && (this.jdField_a_of_type_Qmr == qls.a(this.jdField_a_of_type_Qls)) && (qls.a(this.jdField_a_of_type_Qls) != null) && (bool) && (this.jdField_a_of_type_Qmr.jdField_a_of_type_Qjq.a().getVisibility() == 0))
    {
      qls.a(this.jdField_a_of_type_Qls).sendEmptyMessageDelayed(7, this.jdField_a_of_type_Qmr.jdField_a_of_type_Qjq.a());
      return;
    }
    if (bool)
    {
      this.jdField_a_of_type_Qmr.jdField_a_of_type_Qjq.a().setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Qmr.jdField_a_of_type_Qjq.a().setVisibility(0);
  }
  
  private void d(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.K))
    {
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth();
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.K, localURLDrawableOptions);
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_Qmr.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Qmr.m.setVisibility(0);
      this.jdField_a_of_type_Qmr.m.setImageDrawable(this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_a_of_type_Qmr.m.invalidate();
      this.jdField_a_of_type_Qmr.m.setScaleX(1.43F);
      this.jdField_a_of_type_Qmr.m.setScaleY(1.43F);
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(0);
      Object localObject = this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getComposition();
      long l = 1249L;
      if (localObject != null) {
        l = ((LottieComposition)localObject).getDuration();
      }
      localObject = new VideoFeedsAdapter.ShortVideoItemDelegate.9(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject, l);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsAdapter.ShortVideoItemDelegate.10(this), ((float)l * 0.3F));
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return;
    }
    this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oqe.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
  }
  
  private void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qmr.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = actn.a(0.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
      this.jdField_a_of_type_Qmr.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qmr.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (actn.a(15.0F, qls.a(this.jdField_a_of_type_Qls).getResources()) - 20);
    this.jdField_a_of_type_Qmr.g.setLayoutParams(localMarginLayoutParams);
  }
  
  int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean)
    {
      if (paramBoolean) {
        return 2130842548;
      }
      return 2130842550;
    }
    return super.a(paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (qls.a(this.jdField_a_of_type_Qls) != null) {
      qls.a(this.jdField_a_of_type_Qls).a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramActivity.getWindow().getDecorView().findViewById(2131363287);
    if (localRelativeLayout == null) {
      return;
    }
    localRelativeLayout.setVisibility(4);
    ThreadManager.getUIHandler().post(new VideoFeedsAdapter.ShortVideoItemDelegate.7(this, localRelativeLayout, paramBoolean, paramActivity));
  }
  
  public void a(View paramView)
  {
    paramView.addOnAttachStateChangeListener(new qmo(this, new qmn(this)));
    ThreadManager.getUIHandler().post(new VideoFeedsAdapter.ShortVideoItemDelegate.5(this));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    b(true);
    Object localObject1;
    if (this.jdField_a_of_type_Qmr.jdField_k_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      if (!paramVideoInfo.e()) {
        break label536;
      }
      this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_Qmr.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      this.jdField_a_of_type_Qmr.e.setVisibility(0);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = qls.a(this.jdField_a_of_type_Qls);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = qls.a(this.jdField_a_of_type_Qls);
    }
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.b), (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(bavi.b(bawz.a(qls.a(this.jdField_a_of_type_Qls), 40.0F), bawz.a(qls.a(this.jdField_a_of_type_Qls), 40.0F), bawz.a(qls.a(this.jdField_a_of_type_Qls), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(bavi.i);
        this.jdField_a_of_type_Qmr.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a());
        b(paramVideoInfo, false);
        this.jdField_a_of_type_Qmr.jdField_k_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_Qmr);
        this.jdField_a_of_type_Qmr.jdField_k_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_Qls);
        this.jdField_a_of_type_Qmr.jdField_a_of_type_Qjq.a().setTag(this.jdField_a_of_type_Qmr);
        this.jdField_a_of_type_Qmr.jdField_a_of_type_Qjq.a().setOnClickListener(this.jdField_a_of_type_Qls);
        j(true);
        if (this.jdField_a_of_type_Qmr.jdField_l_of_type_AndroidViewViewGroup.getVisibility() == 0) {
          a(this.jdField_a_of_type_Qmr, paramVideoInfo);
        }
        if (!paramVideoInfo.b(qls.a(this.jdField_a_of_type_Qls))) {
          break label914;
        }
        this.jdField_a_of_type_Qmr.h.setVisibility(8);
        if ((qls.a(this.jdField_a_of_type_Qls) == this.jdField_a_of_type_Qmr) && (qls.a(this.jdField_a_of_type_Qls)))
        {
          b(false);
          j(false);
        }
        if (paramVideoInfo.a()) {
          this.jdField_a_of_type_Qmr.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable(qls.a(this.jdField_a_of_type_Qls, a(paramVideoInfo.l)));
        }
        try
        {
          localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
          if ((!this.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean) && (rmc.a().b()) && (localObject1 != null))
          {
            ImageView localImageView = this.jdField_a_of_type_Qmr.jdField_k_of_type_AndroidWidgetImageView;
            if (!((FusionBiuInfo)localObject1).b) {
              break label928;
            }
            i = 2130841217;
            localImageView.setImageResource(i);
            if (this.jdField_a_of_type_Qmr != null) {
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
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Qmr, this.jdField_a_of_type_Qls);
        qls.a(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo);
        qls.a(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo, Boolean.valueOf(qls.a(this.jdField_a_of_type_Qls)));
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
          this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_k_of_type_JavaLangString);
          this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
          VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.jdField_k_of_type_JavaLangString);
          VideoFeedsAccessibilityHelper.c(this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramVideoInfo.jdField_k_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(paramVideoInfo.E))
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getWidth();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getHeight();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = qls.a(this.jdField_a_of_type_Qls);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = qls.a(this.jdField_a_of_type_Qls);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = URLDrawable.getDrawable(new URL(paramVideoInfo.E), (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(bavi.a);
          this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject2);
          d(paramVideoInfo);
          if (qls.l(this.jdField_a_of_type_Qls)) {
            this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
          }
          this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          this.jdField_a_of_type_Qmr.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
          this.jdField_a_of_type_Qmr.e.setVisibility(8);
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
          this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(qls.a(this.jdField_a_of_type_Qls));
          this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(Long.valueOf(paramVideoInfo.j).longValue(), false);
        }
        else
        {
          this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(qls.a(this.jdField_a_of_type_Qls));
          continue;
          this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(paramVideoInfo.j);
          this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(paramVideoInfo.j);
        }
      }
      label914:
      this.jdField_a_of_type_Qmr.h.setVisibility(0);
      continue;
      label928:
      i = 2130842516;
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.jdField_a_of_type_Qmr.B.getPaint().setFakeBoldText(false);
    if (qls.a(this.jdField_a_of_type_Qls) != null) {
      qls.a(this.jdField_a_of_type_Qls).a(paramVideoInfo, this.jdField_a_of_type_Qmr, false);
    }
    if (paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) {
      if ((this.jdField_a_of_type_Qmr.i != null) && (this.jdField_a_of_type_Qmr.i.getVisibility() != 8))
      {
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.1(this, paramVideoInfo));
        this.jdField_a_of_type_Qmr.d.setBackgroundDrawable(null);
        if (!paramVideoInfo.b(qls.a(this.jdField_a_of_type_Qls))) {
          break label387;
        }
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
        if (this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        label155:
        k(false);
        if ((qls.a(this.jdField_a_of_type_Qls).a()) && (qls.k(this.jdField_a_of_type_Qls)))
        {
          qls.h(this.jdField_a_of_type_Qls, false);
          d(true);
        }
        if ((this.jdField_a_of_type_Qmr.jdField_c_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_Int != 0)) {
          break label424;
        }
        if (this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
          this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = new VideoFeedsAioGuideView(qls.a(this.jdField_a_of_type_Qls), qls.a(this.jdField_a_of_type_Qls), qls.a(this.jdField_a_of_type_Qls));
        }
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a(this.jdField_a_of_type_Qmr);
        label273:
        if (!paramVideoInfo.b(qls.a(this.jdField_a_of_type_Qls))) {
          break label455;
        }
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      }
    }
    for (;;)
    {
      a(paramVideoInfo, this.jdField_a_of_type_Qmr.jdField_b_of_type_AndroidWidgetTextView);
      return;
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(qls.a(this.jdField_a_of_type_Qls), this.jdField_a_of_type_Qls, paramVideoInfo, qls.c(this.jdField_a_of_type_Qls), qls.e(this.jdField_a_of_type_Qls));
      break;
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(8);
      break;
      label387:
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(8);
      if (this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidViewView == null) {
        break label155;
      }
      this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label155;
      label424:
      if (this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
        break label273;
      }
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.c();
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = null;
      break label273;
      label455:
      if (paramVideoInfo.a() != null)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        localObject = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(bavi.w);
        ((URLDrawable)localObject).setAlpha(35);
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
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
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a());
        VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      d(paramVideoInfo);
      this.jdField_a_of_type_Qmr.B.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_Qmr.A.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      qls.a(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmr, paramVideoInfo);
      b(paramVideoInfo, true);
      if ((paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.getVisibility() == 8))
      {
        if ((this.jdField_a_of_type_Qmr.i == null) || (this.jdField_a_of_type_Qmr.i.getVisibility() == 8)) {
          break label462;
        }
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.2(this, paramVideoInfo));
        qls.a(this.jdField_a_of_type_Qls, paramVideoInfo);
      }
      a(paramVideoInfo, this.jdField_a_of_type_Qmr.jdField_b_of_type_AndroidWidgetTextView);
      qls.a(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo);
      qls.a(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo, Boolean.valueOf(qls.a(this.jdField_a_of_type_Qls)));
      if (!this.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean)
      {
        localObject = null;
        if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          localObject = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
        }
        if ((rmc.a().b()) && (localObject != null))
        {
          paramVideoInfo = this.jdField_a_of_type_Qmr.jdField_k_of_type_AndroidWidgetImageView;
          if (!((FusionBiuInfo)localObject).b) {
            break label523;
          }
        }
      }
    }
    label523:
    for (int i = 2130841217;; i = 2130842516)
    {
      paramVideoInfo.setImageResource(i);
      ((FusionBiuInfo)localObject).jdField_c_of_type_Boolean = true;
      return;
      if (!TextUtils.isEmpty(paramVideoInfo.jdField_k_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_k_of_type_JavaLangString);
        VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.jdField_k_of_type_JavaLangString);
      }
      if ((!TextUtils.isEmpty(paramVideoInfo.E)) || (TextUtils.isEmpty(paramVideoInfo.j)))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bbdr.a(true);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bbdr.a(true);
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageSrc(paramVideoInfo.E);
        break;
      }
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(bbdr.a(true));
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(Long.valueOf(paramVideoInfo.j).longValue(), false);
      break;
      label462:
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
      this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(qls.a(this.jdField_a_of_type_Qls), this.jdField_a_of_type_Qls, paramVideoInfo, qls.c(this.jdField_a_of_type_Qls), qls.e(this.jdField_a_of_type_Qls));
      break label171;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Qmr.d.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      h(bool);
      return;
    }
  }
  
  void c(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean)
    {
      qol.b(this.jdField_a_of_type_Qmr.D, paramVideoInfo.e, "评论");
      this.jdField_a_of_type_Qmr.j.setImageResource(2130842547);
      return;
    }
    super.c(paramVideoInfo);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qmr.jdField_b_of_type_ComTencentImageURLImageView.clearAnimation();
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Qmr.jdField_a_of_type_Qqo.a.b(qls.a(this.jdField_a_of_type_Qls)))
      {
        this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, qol.b(qls.a(this.jdField_a_of_type_Qls)));
        k(true);
      }
      if (this.jdField_a_of_type_Qmr.d.getVisibility() == 0) {
        this.jdField_a_of_type_Qmr.d.setVisibility(8);
      }
      this.jdField_a_of_type_Qmr.h.setVisibility(8);
      return;
    }
    if (!this.jdField_a_of_type_Qmr.jdField_a_of_type_Qqo.a.b(qls.a(this.jdField_a_of_type_Qls)))
    {
      this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      k(false);
      this.jdField_a_of_type_Qmr.h.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Qmr.h.setVisibility(8);
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_Qmr.d.setBackgroundDrawable(qls.b(this.jdField_a_of_type_Qls));
      k(true);
      if (this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) {
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
      }
    }
    label216:
    for (;;)
    {
      if (this.jdField_a_of_type_Qmr.jdField_a_of_type_Qqo != null) {
        qls.a(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmr.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Qmr.jdField_a_of_type_Qqo.a, Boolean.valueOf(paramBoolean));
      }
      return;
      this.jdField_a_of_type_Qmr.d.setBackgroundDrawable(null);
      if (!qls.a(this.jdField_a_of_type_Qls).a()) {
        k(false);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) || (this.jdField_a_of_type_Qmr.jdField_c_of_type_Int != 0) || (this.jdField_a_of_type_Qmr.jdField_a_of_type_Qqo == null) || (this.jdField_a_of_type_Qmr.jdField_a_of_type_Qqo.a.jdField_a_of_type_Int != 0)) {
          break label216;
        }
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
        break;
        this.jdField_a_of_type_Qmr.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, qol.b(qls.a(this.jdField_a_of_type_Qls)));
      }
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    super.h(paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Qmr.o.getVisibility() == 0)
      {
        qol.a(this.jdField_a_of_type_Qmr.o, 8, 200);
        this.jdField_a_of_type_Qmr.o.animate().translationY(20.0F).setDuration(200L).start();
        this.jdField_a_of_type_Qmr.g.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (!qls.a(this.jdField_a_of_type_Qls))) {
        this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
      }
    }
    do
    {
      return;
      if ((!qls.a(this.jdField_a_of_type_Qls)) && (this.jdField_a_of_type_Qmr.o.getVisibility() == 8))
      {
        qol.a(this.jdField_a_of_type_Qmr.o, 0, 200);
        this.jdField_a_of_type_Qmr.o.animate().translationY(0.0F).setDuration(200L).start();
        this.jdField_a_of_type_Qmr.g.animate().translationY(0.0F).setDuration(200L).start();
      }
    } while (this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null);
    this.jdField_a_of_type_Qmr.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qmm
 * JD-Core Version:    0.7.0.1
 */