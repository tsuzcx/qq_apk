import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class qgw
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private noa jdField_a_of_type_Noa;
  private qaq jdField_a_of_type_Qaq;
  private qgz jdField_a_of_type_Qgz;
  private qha jdField_a_of_type_Qha;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public qgw(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Int = aciy.a(2.0F, paramActivity.getResources());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Noa = new noa();
    this.jdField_a_of_type_Noa.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Qha = new qha();
    this.jdField_a_of_type_Qha.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private qgz a()
  {
    if (this.jdField_a_of_type_Qgz != null) {
      return this.jdField_a_of_type_Qgz;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_a_of_type_Qha.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))) {}
    for (this.jdField_a_of_type_Qgz = this.jdField_a_of_type_Qha;; this.jdField_a_of_type_Qgz = this.jdField_a_of_type_Noa) {
      do
      {
        if (this.jdField_a_of_type_Qgz != null) {
          this.jdField_a_of_type_Qgz.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        }
        return this.jdField_a_of_type_Qgz;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType != 2));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, qaq paramqaq)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qaq = paramqaq;
    Object localObject;
    if ((paramqaq.u == null) && ((paramqaq instanceof qap)))
    {
      paramqaq.u = ((ViewGroup)((ViewStub)paramqaq.m.findViewById(2131313141)).inflate());
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(aciy.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
      paramqaq.u.setBackgroundDrawable((Drawable)localObject);
      paramqaq.g = ((URLImageView)paramqaq.u.findViewById(2131301873));
      paramqaq.I = ((TextView)paramqaq.u.findViewById(2131301876));
      paramqaq.J = ((TextView)paramqaq.u.findViewById(2131301875));
      paramqaq.v = paramqaq.u.findViewById(2131303733);
      paramqaq.w = paramqaq.u.findViewById(2131301874);
      paramqaq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramqaq.u.findViewById(2131301871));
      paramqaq.x = paramqaq.u.findViewById(2131301872);
    }
    if (paramqaq.u != null)
    {
      paramqaq.u.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      a(paramqaq, (String)localObject, this.jdField_a_of_type_Int, 18);
      localObject = "";
      if (a() != null) {
        localObject = a().b();
      }
      paramqaq.I.setText((CharSequence)localObject);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      paramqaq.J.setText((CharSequence)localObject);
      paramqaq.u.setTag(paramqaq);
      paramqaq.u.setOnClickListener(this);
      paramqaq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setTag(paramqaq);
      paramqaq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
      paramqaq.w.setTag(paramqaq);
      paramqaq.w.setOnClickListener(this);
      qcn.a(paramqaq.u, 200);
      if (a() != null) {
        a().a(paramVideoInfo, paramqaq);
      }
    }
  }
  
  private void a(qaq paramqaq, String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      localURLDrawableOptions.mRequestWidth = aciy.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localURLDrawableOptions.mRequestHeight = aciy.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localURLDrawable.setTag(azue.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
      localURLDrawable.setDecodeHandler(azue.i);
      paramqaq.g.setImageDrawable(localURLDrawable);
      return;
    }
    catch (Exception paramqaq)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramString);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Qaq.u == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Qaq.u.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = aciy.a(26.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Qaq.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Qaq.J.setVisibility(8);
    this.jdField_a_of_type_Qaq.w.setVisibility(8);
    this.jdField_a_of_type_Qaq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_Qaq.x.setVisibility(8);
    localObject = this.jdField_a_of_type_Qaq.g.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = aciy.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = aciy.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Qaq.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_Qaq.v.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Qaq.v.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qaq.J.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = aciy.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Qaq.J.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void c()
  {
    if (this.b) {}
    while ((this.jdField_a_of_type_Qaq.u == null) || (this.jdField_a_of_type_Qaq.u.getVisibility() != 0)) {
      return;
    }
    this.b = true;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qaq.u.getLayoutParams();
    int j = this.jdField_a_of_type_Qaq.u.getMeasuredWidth();
    int k = this.jdField_a_of_type_Qaq.u.getMeasuredHeight();
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_Qaq.g.getLayoutParams();
    int m = localLayoutParams1.width;
    int n = localLayoutParams1.height;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i1 = aciy.a(41.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = aciy.a(197.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = aciy.a(33.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = this.jdField_a_of_type_Qaq.v.getMeasuredWidth();
    if (a() == 1) {}
    for (int i = aciy.a(123.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;; i = aciy.a(140.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4)
    {
      ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_Qaq.v.getLayoutParams();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new qgx(this, localLayoutParams, j, i2 - j, k, i1 - k, localLayoutParams1, m, i3 - n, n, localLayoutParams2, i4, i));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new qgy(this));
      this.jdField_a_of_type_Qaq.u.setTag(2131297012, this.jdField_a_of_type_AndroidAnimationValueAnimator);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
  }
  
  public int a()
  {
    if (a() != null) {
      return a().a();
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Noa != null) {
      this.jdField_a_of_type_Noa.a();
    }
    if (this.jdField_a_of_type_Qha != null) {
      this.jdField_a_of_type_Qha.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (a() != null) {
      a().a(paramInt1, paramInt2);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, qaq paramqaq, double paramDouble)
  {
    if (paramqaq.d.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
        if ((paramqaq.u == null) || (paramqaq.u.getVisibility() != 0)) {
          break;
        }
      } while ((!this.jdField_a_of_type_Boolean) || (a() == null) || (!a().a(paramVideoInfo, paramqaq, paramDouble)));
      c();
      return;
    } while (((paramVideoInfo != null) && (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString))) || (a() == null) || (!a().a()) || (!a().a(paramVideoInfo)));
    a(paramVideoInfo, paramqaq);
  }
  
  public void a(qaq paramqaq)
  {
    if ((paramqaq != null) && (paramqaq.u != null))
    {
      paramqaq.u.setVisibility(8);
      b();
    }
  }
  
  public void a(qaq paramqaq1, qaq paramqaq2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    a(paramqaq1);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramqaq2.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Qgz = null;
  }
  
  public void a(qaq paramqaq, boolean paramBoolean, double paramDouble)
  {
    if (paramBoolean) {}
    while ((a() == null) || (paramqaq == null)) {
      return;
    }
    a(paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramqaq, paramDouble);
  }
  
  public void onClick(View paramView)
  {
    if (a() != null) {
      a().onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgw
 * JD-Core Version:    0.7.0.1
 */