import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder.5;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder.6;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder.7;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder.8;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsOptView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import mqq.os.MqqHandler;

public class qaq
  extends qag
  implements qsa
{
  TextView A;
  public TextView B;
  public TextView C;
  public TextView D;
  public TextView E;
  TextView F;
  TextView G;
  TextView H;
  public TextView I;
  public TextView J;
  public Activity a;
  public Handler a;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  public ReadInjoyHeaderAdDownloadView a;
  VideoFeedsOptView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView;
  public ReadInJoyHeadImageView a;
  ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  public LottieDrawable a;
  VideoFeedsOptView b;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  VideoFeedsOptView jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView;
  URLImageView d;
  public URLImageView e;
  URLImageView f;
  public URLImageView g;
  public ImageView h;
  public ImageView i;
  public ImageView j;
  ImageView k;
  public ViewGroup m;
  ViewGroup n;
  public ViewGroup o;
  ViewGroup p;
  public ViewGroup q;
  ViewGroup r;
  public ViewGroup s;
  public View t;
  ViewGroup t;
  View u;
  public ViewGroup u;
  public View v;
  public View w;
  public TextView w;
  public View x;
  TextView x;
  TextView y;
  TextView z;
  
  public qaq(View paramView, int paramInt, Activity paramActivity)
  {
    super(paramView, paramInt);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.t = paramView;
    this.w = ((TextView)paramView.findViewById(2131311623));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView = ((VideoFeedsOptView)paramView.findViewById(2131305439));
    this.b = ((VideoFeedsOptView)paramView.findViewById(2131305440));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView = ((VideoFeedsOptView)paramView.findViewById(2131305441));
    this.m = ((ViewGroup)paramView.findViewById(2131301854));
    this.n = ((ViewGroup)paramView.findViewById(2131301826));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131301827));
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131301824));
    this.x = ((TextView)paramView.findViewById(2131301821));
    this.o = ((ViewGroup)paramView.findViewById(2131300986));
    this.h = ((ImageView)paramView.findViewById(2131300970));
    if (paramInt == 2)
    {
      this.j = ((ImageView)paramView.findViewById(2131297732));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131305345));
    }
    this.i = ((ImageView)paramView.findViewById(2131300978));
    this.p = ((ViewGroup)paramView.findViewById(2131300996));
    this.k = ((ImageView)paramView.findViewById(2131300972));
    this.y = ((TextView)paramView.findViewById(2131300974));
    this.z = ((TextView)paramView.findViewById(2131300995));
    this.q = ((ViewGroup)paramView.findViewById(2131313138));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131306892));
    if (paramInt == 2) {
      a(paramView);
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.h.setVisibility(8);
      this.j.setVisibility(0);
      this.j.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.j.invalidate();
      this.j.setScaleX(1.43F);
      this.j.setScaleY(1.43F);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setRepeatCount(0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.getComposition();
      long l = 1249L;
      if (localObject != null) {
        l = ((LottieComposition)localObject).getDuration();
      }
      localObject = new VideoFeedsAdapter.VideoItemHolder.7(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)localObject, l);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsAdapter.VideoItemHolder.8(this), ((float)l * 0.3F));
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = oet.a("https://pub.idqqimg.com/pc/misc/files/20191128/2058eba02bfd4a65b05383b47e7f5e62.zip");
  }
  
  private void a(View paramView)
  {
    paramView.addOnAttachStateChangeListener(new qas(this, new qar(this)));
    ThreadManager.getUIHandler().post(new VideoFeedsAdapter.VideoItemHolder.3(this));
  }
  
  private void a(RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.874F, 1, 0.0F);; localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.874F, 1, 1.0F))
    {
      localScaleAnimation.setDuration(350L);
      localScaleAnimation.setAnimationListener(new qat(this, paramRelativeLayout));
      paramRelativeLayout.startAnimation(localScaleAnimation);
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qeq.a.a;
    if ((qzk.a().b()) && (paramString.equals(localArticleInfo.innerUniqueID)) && (paramBoolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsAdapter.VideoItemHolder.6(this));
      if (localArticleInfo.fusionBiuInfo != null)
      {
        localArticleInfo.fusionBiuInfo.a = 0L;
        localArticleInfo.fusionBiuInfo.b = false;
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qeq.a.a;
    if ((qzk.a().b()) && (localArticleInfo.innerUniqueID != null) && (localArticleInfo.innerUniqueID.equals(paramString)))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (paramInt == 4) {
          a();
        }
        this.h.setImageResource(2130841140);
      }
      if (localArticleInfo.fusionBiuInfo != null)
      {
        localArticleInfo.fusionBiuInfo.b = paramBoolean;
        localArticleInfo.fusionBiuInfo.a = paramLong;
      }
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramActivity.getWindow().getDecorView().findViewById(2131297737);
    if (localRelativeLayout == null) {
      return;
    }
    localRelativeLayout.setVisibility(4);
    ThreadManager.getUIHandler().post(new VideoFeedsAdapter.VideoItemHolder.5(this, localRelativeLayout, paramBoolean, paramActivity));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
    {
      VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, paramString);
      VideoFeedsAccessibilityHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qaq
 * JD-Core Version:    0.7.0.1
 */