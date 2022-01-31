import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.ShortVideoItemDelegate.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAioGuideView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGradientMaskView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class qao
  extends qah
{
  private qap a;
  
  public qao(pzs parampzs, qap paramqap)
  {
    super(parampzs, paramqap);
    this.jdField_a_of_type_Qap = paramqap;
  }
  
  private void a(VideoInfo paramVideoInfo, TextView paramTextView)
  {
    if (paramVideoInfo.e())
    {
      paramTextView.setText(qcn.c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_Int) + ajjy.a(2131650434));
      paramTextView.setVisibility(0);
      return;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && (paramVideoInfo.jdField_a_of_type_Int != 5) && (paramVideoInfo.s > 0))
    {
      paramTextView.setText(qcn.a(paramVideoInfo.s));
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qap.x == null) {
      return;
    }
    if (paramVideoInfo.e()) {}
    for (boolean bool = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Boolean; (TextUtils.isEmpty(paramVideoInfo.j)) || ("16888".equals(paramVideoInfo.j)) || (paramVideoInfo.jdField_c_of_type_Boolean) || (paramVideoInfo.a(pzs.a(this.jdField_a_of_type_Pzs))); bool = paramVideoInfo.jdField_k_of_type_Boolean)
    {
      this.jdField_a_of_type_Qap.x.setVisibility(8);
      return;
    }
    if (bool)
    {
      localTextView = this.jdField_a_of_type_Qap.x;
      if (paramVideoInfo.e()) {}
      for (paramVideoInfo = ajjy.a(2131650427);; paramVideoInfo = ajjy.a(2131650414))
      {
        localTextView.setText(paramVideoInfo);
        this.jdField_a_of_type_Qap.x.setBackgroundDrawable(qft.a(pzs.a(this.jdField_a_of_type_Pzs), 2130842474));
        this.jdField_a_of_type_Qap.x.setCompoundDrawables(null, null, null, null);
        if ((!paramBoolean) || (this.jdField_a_of_type_Qap != pzs.a(this.jdField_a_of_type_Pzs)) || (pzs.a(this.jdField_a_of_type_Pzs) == null) || (!bool) || (this.jdField_a_of_type_Qap.x.getVisibility() != 0)) {
          break;
        }
        pzs.a(this.jdField_a_of_type_Pzs).sendEmptyMessageDelayed(7, 3000L);
        return;
      }
    }
    TextView localTextView = this.jdField_a_of_type_Qap.x;
    if (paramVideoInfo.e()) {}
    for (paramVideoInfo = ajjy.a(2131650449);; paramVideoInfo = ajjy.a(2131650436))
    {
      localTextView.setText(paramVideoInfo);
      this.jdField_a_of_type_Qap.x.setBackgroundDrawable(qft.a(pzs.a(this.jdField_a_of_type_Pzs), 2130842343));
      break;
    }
    if (bool)
    {
      this.jdField_a_of_type_Qap.x.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Qap.x.setVisibility(0);
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.K))
    {
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth();
      paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.K, localURLDrawableOptions);
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable(paramVideoInfo);
      return;
    }
    this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  private void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qap.g.getLayoutParams();
      localMarginLayoutParams.bottomMargin = aciy.a(0.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
      this.jdField_a_of_type_Qap.g.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qap.g.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (aciy.a(15.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources()) - 20);
    this.jdField_a_of_type_Qap.g.setLayoutParams(localMarginLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (pzs.a(this.jdField_a_of_type_Pzs) != null) {
      pzs.a(this.jdField_a_of_type_Pzs).a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    b(true);
    Object localObject1;
    if (this.jdField_a_of_type_Qap.m.getVisibility() == 0)
    {
      if (!paramVideoInfo.e()) {
        break label517;
      }
      this.jdField_a_of_type_Qap.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_Qap.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      this.jdField_a_of_type_Qap.l.setVisibility(0);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = pzs.a(this.jdField_a_of_type_Pzs);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = pzs.a(this.jdField_a_of_type_Pzs);
    }
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.b), (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(azue.b(azvv.a(pzs.a(this.jdField_a_of_type_Pzs), 40.0F), azvv.a(pzs.a(this.jdField_a_of_type_Pzs), 40.0F), azvv.a(pzs.a(this.jdField_a_of_type_Pzs), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(azue.i);
        this.jdField_a_of_type_Qap.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a());
        b(paramVideoInfo, false);
        this.jdField_a_of_type_Qap.n.setTag(this.jdField_a_of_type_Qap);
        this.jdField_a_of_type_Qap.n.setOnClickListener(this.jdField_a_of_type_Pzs);
        this.jdField_a_of_type_Qap.x.setTag(this.jdField_a_of_type_Qap);
        this.jdField_a_of_type_Qap.x.setOnClickListener(this.jdField_a_of_type_Pzs);
        j(true);
        if (this.jdField_a_of_type_Qap.o.getVisibility() == 0) {
          a(this.jdField_a_of_type_Qap, paramVideoInfo);
        }
        if (!paramVideoInfo.b(pzs.a(this.jdField_a_of_type_Pzs))) {
          break label900;
        }
        this.jdField_a_of_type_Qap.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
        if ((pzs.a(this.jdField_a_of_type_Pzs) == this.jdField_a_of_type_Qap) && (pzs.a(this.jdField_a_of_type_Pzs)))
        {
          b(false);
          j(false);
        }
        if (paramVideoInfo.a()) {
          this.jdField_a_of_type_Qap.jdField_i_of_type_AndroidWidgetImageView.setImageDrawable(pzs.a(this.jdField_a_of_type_Pzs, a(paramVideoInfo.l)));
        }
        try
        {
          localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo;
          if ((qzk.a().b()) && (localObject1 != null))
          {
            localObject3 = this.jdField_a_of_type_Qap.jdField_h_of_type_AndroidWidgetImageView;
            if (!((FusionBiuInfo)localObject1).b) {
              break label914;
            }
            i = 2130841140;
            ((ImageView)localObject3).setImageResource(i);
            if (this.jdField_a_of_type_Qap != null) {
              ((FusionBiuInfo)localObject1).jdField_c_of_type_Boolean = true;
            }
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          Object localObject3;
          int i;
          Object localObject2;
          localNullPointerException.printStackTrace();
          continue;
        }
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Qap, this.jdField_a_of_type_Pzs);
        pzs.a(this.jdField_a_of_type_Pzs, this.jdField_a_of_type_Qap.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo);
        pzs.a(this.jdField_a_of_type_Pzs, this.jdField_a_of_type_Qap.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo, Boolean.valueOf(pzs.a(this.jdField_a_of_type_Pzs)));
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
      label517:
      if (!paramVideoInfo.b)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.jdField_k_of_type_JavaLangString))
        {
          this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_k_of_type_JavaLangString);
          this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
          VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.jdField_k_of_type_JavaLangString);
          VideoFeedsAccessibilityHelper.c(this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramVideoInfo.jdField_k_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(paramVideoInfo.j))
        {
          localObject2 = azwp.a(pzs.a(this.jdField_a_of_type_Pzs), 1, paramVideoInfo.j, 3, pzs.a(this.jdField_a_of_type_Pzs), pzs.a(this.jdField_a_of_type_Pzs));
          this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject2);
        }
      }
      for (;;)
      {
        c(paramVideoInfo);
        if (pzs.l(this.jdField_a_of_type_Pzs)) {
          this.jdField_a_of_type_Qap.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
        }
        this.jdField_a_of_type_Qap.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_a_of_type_Qap.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        this.jdField_a_of_type_Qap.l.setVisibility(8);
        break;
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = pzs.a(this.jdField_a_of_type_Pzs);
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = pzs.a(this.jdField_a_of_type_Pzs);
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(paramVideoInfo.E)) {
              break label854;
            }
            localObject2 = new URL("http://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
            localObject2 = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
            ((URLDrawable)localObject2).setDecodeHandler(azue.a);
            this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject2);
          }
          catch (MalformedURLException localMalformedURLException2) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException2.getMessage());
          break;
          label854:
          URL localURL = new URL(paramVideoInfo.E);
        }
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(paramVideoInfo.j);
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(paramVideoInfo.j);
      }
      label900:
      this.jdField_a_of_type_Qap.jdField_h_of_type_AndroidViewViewGroup.setVisibility(0);
      continue;
      label914:
      i = 2130842442;
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    this.jdField_a_of_type_Qap.w.getPaint().setFakeBoldText(false);
    if (pzs.a(this.jdField_a_of_type_Pzs) != null) {
      pzs.a(this.jdField_a_of_type_Pzs).a(paramVideoInfo, this.jdField_a_of_type_Qap, false);
    }
    if (paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) {
      if ((this.jdField_a_of_type_Qap.j != null) && (this.jdField_a_of_type_Qap.j.getVisibility() != 8))
      {
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.1(this, paramVideoInfo));
        this.jdField_a_of_type_Qap.d.setBackgroundDrawable(null);
        if (!paramVideoInfo.b(pzs.a(this.jdField_a_of_type_Pzs))) {
          break label366;
        }
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(0);
        label134:
        k(false);
        if ((pzs.a(this.jdField_a_of_type_Pzs).a()) && (pzs.k(this.jdField_a_of_type_Pzs)))
        {
          pzs.h(this.jdField_a_of_type_Pzs, false);
          d(true);
        }
        if ((this.jdField_a_of_type_Qap.jdField_c_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_Int != 0)) {
          break label381;
        }
        if (this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
          this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = new VideoFeedsAioGuideView(pzs.a(this.jdField_a_of_type_Pzs), pzs.a(this.jdField_a_of_type_Pzs), pzs.a(this.jdField_a_of_type_Pzs));
        }
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a(this.jdField_a_of_type_Qap);
        label252:
        if (!paramVideoInfo.b(pzs.a(this.jdField_a_of_type_Pzs))) {
          break label412;
        }
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      }
    }
    for (;;)
    {
      a(paramVideoInfo, this.jdField_a_of_type_Qap.jdField_b_of_type_AndroidWidgetTextView);
      return;
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(pzs.a(this.jdField_a_of_type_Pzs), this.jdField_a_of_type_Pzs, paramVideoInfo, pzs.c(this.jdField_a_of_type_Pzs), pzs.e(this.jdField_a_of_type_Pzs));
      break;
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(8);
      break;
      label366:
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsGradientMaskView.setVisibility(8);
      break label134;
      label381:
      if (this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) {
        break label252;
      }
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.c();
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView = null;
      break label252;
      label412:
      if (paramVideoInfo.a() != null)
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        localObject = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(azue.w);
        ((URLDrawable)localObject).setAlpha(35);
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
    if (!paramVideoInfo.b)
    {
      if (paramVideoInfo.e())
      {
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.a());
        VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_JavaLangString);
      }
    }
    else
    {
      c(paramVideoInfo);
      this.jdField_a_of_type_Qap.w.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_Qap.v.setText(paramVideoInfo.jdField_c_of_type_JavaLangString);
      pzs.a(this.jdField_a_of_type_Pzs, this.jdField_a_of_type_Qap, paramVideoInfo);
      b(paramVideoInfo, true);
      if ((paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.getVisibility() == 8))
      {
        if ((this.jdField_a_of_type_Qap.j == null) || (this.jdField_a_of_type_Qap.j.getVisibility() == 8)) {
          break label273;
        }
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.post(new VideoFeedsAdapter.ShortVideoItemDelegate.2(this, paramVideoInfo));
      }
    }
    for (;;)
    {
      pzs.a(this.jdField_a_of_type_Pzs, paramVideoInfo);
      a(paramVideoInfo, this.jdField_a_of_type_Qap.jdField_b_of_type_AndroidWidgetTextView);
      pzs.a(this.jdField_a_of_type_Pzs, this.jdField_a_of_type_Qap.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo);
      pzs.a(this.jdField_a_of_type_Pzs, this.jdField_a_of_type_Qap.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, paramVideoInfo, Boolean.valueOf(pzs.a(this.jdField_a_of_type_Pzs)));
      return;
      if (TextUtils.isEmpty(paramVideoInfo.jdField_k_of_type_JavaLangString)) {
        break;
      }
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.jdField_k_of_type_JavaLangString);
      VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramVideoInfo.jdField_k_of_type_JavaLangString);
      break;
      label273:
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setHorizontalMargin(0);
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setVisibility(0);
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsTopicViewGroup.setArticleInfo(pzs.a(this.jdField_a_of_type_Pzs), this.jdField_a_of_type_Pzs, paramVideoInfo, pzs.c(this.jdField_a_of_type_Pzs), pzs.e(this.jdField_a_of_type_Pzs));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Qap.d.getVisibility() == 8) {}
    for (boolean bool = true;; bool = false)
    {
      h(bool);
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Qap.jdField_b_of_type_ComTencentImageURLImageView.clearAnimation();
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Qap.jdField_a_of_type_Qeq.a.b(pzs.a(this.jdField_a_of_type_Pzs)))
      {
        this.jdField_a_of_type_Qap.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, qcn.b(pzs.a(this.jdField_a_of_type_Pzs)));
        k(true);
      }
      if (this.jdField_a_of_type_Qap.d.getVisibility() == 0) {
        this.jdField_a_of_type_Qap.d.setVisibility(8);
      }
      this.jdField_a_of_type_Qap.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    }
    if (!this.jdField_a_of_type_Qap.jdField_a_of_type_Qeq.a.b(pzs.a(this.jdField_a_of_type_Pzs)))
    {
      this.jdField_a_of_type_Qap.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      k(false);
      this.jdField_a_of_type_Qap.jdField_h_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Qap.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Qap.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_Qap.d.setBackgroundDrawable(pzs.b(this.jdField_a_of_type_Pzs));
      k(true);
      if (this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) {
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
      }
    }
    label216:
    for (;;)
    {
      if (this.jdField_a_of_type_Qap.jdField_a_of_type_Qeq != null) {
        pzs.a(this.jdField_a_of_type_Pzs, this.jdField_a_of_type_Qap.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_Qap.jdField_a_of_type_Qeq.a, Boolean.valueOf(paramBoolean));
      }
      return;
      this.jdField_a_of_type_Qap.d.setBackgroundDrawable(null);
      if (!pzs.a(this.jdField_a_of_type_Pzs).a()) {
        k(false);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView == null) || (this.jdField_a_of_type_Qap.jdField_c_of_type_Int != 0) || (this.jdField_a_of_type_Qap.jdField_a_of_type_Qeq == null) || (this.jdField_a_of_type_Qap.jdField_a_of_type_Qeq.a.jdField_a_of_type_Int != 0)) {
          break label216;
        }
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
        break;
        this.jdField_a_of_type_Qap.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, qcn.b(pzs.a(this.jdField_a_of_type_Pzs)));
      }
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    super.h(paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Qap.jdField_i_of_type_AndroidViewViewGroup.getVisibility() == 0)
      {
        qcn.a(this.jdField_a_of_type_Qap.jdField_i_of_type_AndroidViewViewGroup, 8, 200);
        this.jdField_a_of_type_Qap.jdField_i_of_type_AndroidViewViewGroup.animate().translationY(20.0F).setDuration(200L).start();
        this.jdField_a_of_type_Qap.g.animate().translationY(-20.0F).setDuration(200L).start();
      }
      if ((this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) && (!pzs.a(this.jdField_a_of_type_Pzs))) {
        this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.a();
      }
      return;
    }
    if ((!pzs.a(this.jdField_a_of_type_Pzs)) && (this.jdField_a_of_type_Qap.jdField_i_of_type_AndroidViewViewGroup.getVisibility() == 8))
    {
      qcn.a(this.jdField_a_of_type_Qap.jdField_i_of_type_AndroidViewViewGroup, 0, 200);
      this.jdField_a_of_type_Qap.jdField_i_of_type_AndroidViewViewGroup.animate().translationY(0.0F).setDuration(200L).start();
      this.jdField_a_of_type_Qap.g.animate().translationY(0.0F).setDuration(200L).start();
    }
    if (this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView != null) {
      this.jdField_a_of_type_Qap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAioGuideView.b();
    }
    this.jdField_a_of_type_Qap.r.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qao
 * JD-Core Version:    0.7.0.1
 */