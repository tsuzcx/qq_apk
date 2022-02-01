import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sbt
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private rvv jdField_a_of_type_Rvv;
  private sca jdField_a_of_type_Sca;
  private scb jdField_a_of_type_Scb;
  private tut jdField_a_of_type_Tut;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private boolean jdField_b_of_type_Boolean;
  
  public sbt(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Int = AIOUtils.dp2px(2.0F, paramActivity.getResources());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Tut = new tut();
    this.jdField_a_of_type_Tut.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Scb = new scb();
    this.jdField_a_of_type_Scb.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private sca a()
  {
    if (this.jdField_a_of_type_Sca != null) {
      return this.jdField_a_of_type_Sca;
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_a_of_type_Scb.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo))) {}
    for (this.jdField_a_of_type_Sca = this.jdField_a_of_type_Scb;; this.jdField_a_of_type_Sca = this.jdField_a_of_type_Tut) {
      do
      {
        if (this.jdField_a_of_type_Sca != null) {
          this.jdField_a_of_type_Sca.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
        }
        return this.jdField_a_of_type_Sca;
      } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType != 2));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, rvv paramrvv)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rvv = paramrvv;
    Object localObject;
    if ((paramrvv.jdField_y_of_type_AndroidViewViewGroup == null) && ((paramrvv instanceof rvs)))
    {
      paramrvv.jdField_y_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)((rvs)paramrvv).jdField_r_of_type_AndroidViewViewGroup.findViewById(2131380547)).inflate());
      int i = AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrvv.jdField_y_of_type_AndroidViewViewGroup.setPadding(i, i, i, i);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
      paramrvv.jdField_y_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
      paramrvv.h = ((URLImageView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368034));
      paramrvv.M = ((TextView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368041));
      paramrvv.N = ((TextView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368040));
      paramrvv.v = paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131370170);
      paramrvv.w = paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368039);
      paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368031));
      paramrvv.x = paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368033);
      paramrvv.O = ((TextView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367391));
      paramrvv.jdField_y_of_type_AndroidViewView = paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367401);
      paramrvv.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362113));
      paramrvv.e = ((LinearLayout)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131380548));
    }
    if ((paramrvv.jdField_y_of_type_AndroidViewViewGroup != null) && (paramrvv.h != null) && (paramrvv.M != null) && (paramrvv.N != null) && (paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView != null) && (paramrvv.w != null))
    {
      paramrvv.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      a(paramrvv.h, (String)localObject, this.jdField_a_of_type_Int, 18, -1);
      String str = "";
      localObject = str;
      if (a() != null)
      {
        localObject = str;
        if (a().b() != null) {
          localObject = a().b();
        }
      }
      paramrvv.M.setText((CharSequence)localObject);
      paramrvv.M.setVisibility(0);
      paramrvv.h.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      paramrvv.jdField_b_of_type_AndroidWidgetFrameLayout.setTag(paramrvv);
      paramrvv.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      paramrvv.N.setText((CharSequence)localObject);
      paramrvv.jdField_y_of_type_AndroidViewViewGroup.setTag(paramrvv);
      paramrvv.jdField_y_of_type_AndroidViewViewGroup.setOnClickListener(this);
      paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setTag(paramrvv);
      paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
      paramrvv.w.setTag(paramrvv);
      paramrvv.w.setOnClickListener(this);
      rwv.a(paramrvv.jdField_y_of_type_AndroidViewViewGroup, 200);
      if ((a() != null) && (!TextUtils.isEmpty(a().c())) && (paramrvv.O != null)) {
        paramrvv.O.setText(a().c());
      }
      if (a() != null) {
        a().a(paramVideoInfo, paramrvv);
      }
    }
  }
  
  private void a(URLImageView paramURLImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          if (paramInt3 != -1) {
            localURLDrawableOptions.mUseMemoryCache = false;
          }
          localURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
          localURLDrawableOptions.mRequestWidth = AIOUtils.dp2px(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawableOptions.mRequestHeight = AIOUtils.dp2px(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawable.setTag(bfol.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(bfol.k);
        }
        catch (Exception paramURLImageView)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(bfol.j);
          continue;
        }
        paramURLImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(bfol.k);
      }
    }
  }
  
  private void a(rvv paramrvv, boolean paramBoolean)
  {
    int j = 0;
    boolean bool = bkwm.d();
    Object localObject;
    if ((!bool) && (paramrvv.m != null))
    {
      localObject = paramrvv.m;
      if (paramBoolean)
      {
        i = 0;
        ((ViewGroup)localObject).setVisibility(i);
      }
    }
    else
    {
      if (paramrvv.jdField_z_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramrvv.jdField_z_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label143;
        }
        i = 0;
        label57:
        ((TextView)localObject).setVisibility(i);
      }
      if ((bool) && (paramrvv.jdField_r_of_type_AndroidViewView != null) && (paramrvv.jdField_r_of_type_AndroidViewView.findViewById(2131367993) != null))
      {
        localObject = paramrvv.jdField_r_of_type_AndroidViewView.findViewById(2131367993);
        if (!paramBoolean) {
          break label149;
        }
        i = 0;
        label106:
        ((View)localObject).setVisibility(i);
      }
      if (paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
      {
        paramrvv = paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
        if (!paramBoolean) {
          break label155;
        }
      }
    }
    label143:
    label149:
    label155:
    for (int i = j;; i = 8)
    {
      paramrvv.setVisibility(i);
      return;
      i = 8;
      break;
      i = 8;
      break label57;
      i = 8;
      break label106;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Rvv == null) || (this.jdField_a_of_type_Rvv.A == null)) {
          continue;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.getLayoutParams();
        i = this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.getMeasuredHeight();
        if (!paramBoolean1) {
          continue;
        }
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, -i });
        if (paramBoolean2) {
          this.jdField_b_of_type_Int = localLayoutParams.bottomMargin;
        }
      }
      catch (Exception localException)
      {
        LinearLayout.LayoutParams localLayoutParams;
        int i;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("VideoFeedsSoftAdBarController", 2, "animateNewStyle error：" + localException.getMessage());
        return;
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { -i, this.jdField_b_of_type_Int });
        continue;
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new sbv(this, localLayoutParams, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new sbw(this, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_Rvv.A.setTag(2131362701, this.jdField_a_of_type_AndroidAnimationValueAnimator);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      if (!paramBoolean2) {
        continue;
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { -i, 0 });
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.dp2px(26.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Rvv.N.setVisibility(8);
    this.jdField_a_of_type_Rvv.w.setVisibility(8);
    this.jdField_a_of_type_Rvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_Rvv.x.setVisibility(8);
    localObject = this.jdField_a_of_type_Rvv.h.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = AIOUtils.dp2px(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.dp2px(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rvv.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_Rvv.v.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Rvv.v.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rvv.N.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.dp2px(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rvv.N.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Rvv.O.setVisibility(8);
    this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(VideoInfo paramVideoInfo, rvv paramrvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showNewShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rvv = paramrvv;
    for (;;)
    {
      try
      {
        if ((paramrvv.jdField_y_of_type_AndroidViewViewGroup == null) && ((paramrvv instanceof rvs)))
        {
          paramrvv.jdField_y_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)paramrvv.jdField_r_of_type_AndroidViewViewGroup.findViewById(2131380547)).inflate());
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setCornerRadius(AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject1).setColor(Color.parseColor("#E6FFFFFF"));
          paramrvv.jdField_z_of_type_AndroidViewViewGroup = ((LinearLayout)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131380549));
          paramrvv.jdField_z_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject1);
          paramrvv.jdField_z_of_type_AndroidViewViewGroup.setVisibility(0);
          paramrvv.i = ((URLImageView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368037));
          paramrvv.j = ((URLImageView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368036));
          paramrvv.P = ((TextView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368035));
          paramrvv.Q = ((TextView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362024));
          paramrvv.R = ((TextView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362020));
          paramrvv.S = ((TextView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362022));
          paramrvv.T = ((TextView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362023));
          paramrvv.p = ((ImageView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362019));
          paramrvv.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362113));
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#12B7F5"));
          paramrvv.jdField_a_of_type_AndroidWidgetButton = ((Button)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362018));
          paramrvv.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject2);
          paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368032));
          paramrvv.A = ((ViewGroup)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362021));
          paramrvv.A.setBackgroundDrawable((Drawable)localObject1);
          paramrvv.jdField_z_of_type_AndroidViewView = paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368038);
          paramrvv.e = ((LinearLayout)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131380548));
        }
        if (paramrvv.jdField_y_of_type_AndroidViewViewGroup == null) {
          break;
        }
        paramrvv.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject1 = "";
        if (a() != null) {
          localObject1 = a().a();
        }
        c();
        if (a() != 3)
        {
          b(paramrvv);
          a(paramrvv.i, (String)localObject1, AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 40, -1);
          if (a() == null) {
            break label1073;
          }
          localObject1 = a().b();
          i = a().a();
          localObject2 = a().a();
          str = a().c();
          localObject3 = a().d();
          paramrvv.jdField_a_of_type_AndroidWidgetButton.setText(str);
          paramrvv.R.setText((CharSequence)localObject3);
          if ((i != 0) && (i != 3)) {
            break label1055;
          }
          paramrvv.R.setVisibility(0);
          if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.c == null) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.c)) || (i != 3)) {
            break label1066;
          }
          localObject3 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.c;
          paramrvv.P.setText((CharSequence)localObject3);
          paramrvv.Q.setText((CharSequence)localObject1);
          paramrvv.S.setText((CharSequence)localObject2);
          paramrvv.jdField_y_of_type_AndroidViewViewGroup.setTag(paramrvv);
          paramrvv.jdField_y_of_type_AndroidViewViewGroup.setOnClickListener(this);
          paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setTag(paramrvv);
          paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
          paramrvv.p.setTag(paramrvv);
          paramrvv.p.setOnClickListener(this);
          paramrvv.jdField_b_of_type_AndroidWidgetFrameLayout.setTag(paramrvv);
          paramrvv.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
          paramrvv.jdField_a_of_type_AndroidWidgetButton.setTag(paramrvv);
          paramrvv.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          paramrvv.jdField_z_of_type_AndroidViewViewGroup.setTag(paramrvv);
          paramrvv.jdField_z_of_type_AndroidViewViewGroup.setOnClickListener(this);
          paramrvv.A.setTag(paramrvv);
          paramrvv.A.setOnClickListener(this);
          rwv.a(paramrvv.jdField_y_of_type_AndroidViewViewGroup, 200);
          if (a() == null) {
            break;
          }
          a().a(paramVideoInfo, paramrvv);
          a().a(new sbu(this, paramrvv));
          return;
        }
        if ((a() == 0) || (a() == 3))
        {
          a(paramrvv.i, (String)localObject1, AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
          a(paramrvv.j, (String)localObject1, AIOUtils.dp2px(5.2F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 75, 1);
          paramrvv.jdField_z_of_type_AndroidViewView.setVisibility(4);
          a(a(), paramrvv);
          continue;
        }
        a(paramrvv.i, (String)localObject1, AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
      }
      catch (Exception paramVideoInfo)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramVideoInfo.getMessage());
        return;
      }
      a(paramrvv.j, (String)localObject1, AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
      paramrvv.jdField_z_of_type_AndroidViewView.setVisibility(0);
      continue;
      label1055:
      paramrvv.R.setVisibility(4);
      continue;
      label1066:
      Object localObject3 = localObject1;
      continue;
      label1073:
      Object localObject2 = "";
      localObject3 = "";
      int i = -1;
      Object localObject1 = "";
      String str = "";
    }
  }
  
  private void b(rvv paramrvv)
  {
    Object localObject2 = (LinearLayout.LayoutParams)paramrvv.jdField_z_of_type_AndroidViewViewGroup.getLayoutParams();
    Object localObject1 = (RelativeLayout.LayoutParams)paramrvv.S.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramrvv.p.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramrvv.Q.getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramrvv.i.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams4 = (LinearLayout.LayoutParams)paramrvv.e.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams3 = (LinearLayout.LayoutParams)paramrvv.A.getLayoutParams();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    localGradientDrawable.setColor(Color.parseColor("#80292A2F"));
    paramrvv.e.setBackgroundDrawable(localGradientDrawable);
    localLayoutParams4.width = AIOUtils.dp2px(243.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    localLayoutParams4.height = AIOUtils.dp2px(48.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrvv.e.setLayoutParams(localLayoutParams4);
    paramrvv.jdField_y_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    paramrvv.e.setPadding(0, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(10.25F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(4.25F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(4.25F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.dp2px(4.25F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((LinearLayout.LayoutParams)localObject2).width = AIOUtils.dp2px(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((LinearLayout.LayoutParams)localObject2).height = AIOUtils.dp2px(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrvv.jdField_z_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramrvv.i.setVisibility(0);
    paramrvv.P.setVisibility(8);
    localLayoutParams.width = AIOUtils.dp2px(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    localLayoutParams.height = AIOUtils.dp2px(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrvv.i.setLayoutParams(localLayoutParams);
    paramrvv.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.dp2px(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    ((GradientDrawable)localObject2).setColor(Color.parseColor("#00292A2F"));
    paramrvv.A.setBackgroundDrawable((Drawable)localObject2);
    localLayoutParams3.width = AIOUtils.dp2px(189.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    localLayoutParams3.height = -1;
    paramrvv.A.setLayoutParams(localLayoutParams3);
    paramrvv.A.setVisibility(0);
    localLayoutParams2.topMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    localLayoutParams2.bottomMargin = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrvv.Q.setLayoutParams(localLayoutParams2);
    paramrvv.Q.setTextColor(Color.parseColor("#EEEEEEEE"));
    paramrvv.Q.setTextSize(14.0F);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.dp2px(5.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.dp2px(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrvv.S.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramrvv.S.setTextSize(11.0F);
    paramrvv.S.setTypeface(Typeface.defaultFromStyle(1));
    paramrvv.R.setVisibility(8);
    localLayoutParams1.addRule(10, 0);
    localLayoutParams1.addRule(15, -1);
    localLayoutParams1.rightMargin = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrvv.p.setImageResource(2130839514);
    paramrvv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    if (a() == 0) {
      if ((TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l)) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k))) {
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l)) || (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k)))
        {
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setCornerRadius(AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject1).setColor(Color.parseColor("#FFFF4060"));
          paramrvv.T.setVisibility(0);
          paramrvv.T.setBackgroundDrawable((Drawable)localObject1);
          localLayoutParams1.leftMargin = AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        }
      }
    }
    for (;;)
    {
      paramrvv.p.setLayoutParams(localLayoutParams1);
      return;
      paramrvv.T.setVisibility(8);
      break;
      paramrvv.T.setVisibility(8);
      break;
      if (a() == 2)
      {
        localLayoutParams1.leftMargin = AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      }
      else if (a() == 1)
      {
        paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setVisibility(0);
        localObject1 = (RelativeLayout.LayoutParams)paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.dp2px(7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.dp2px(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).height = AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131362019);
        paramrvv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramrvv.jdField_a_of_type_AndroidWidgetButton = ((Button)paramrvv.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362018));
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        localObject1 = (RelativeLayout.LayoutParams)paramrvv.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = AIOUtils.dp2px(25.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.dp2px(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131362019);
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setMinWidth(AIOUtils.dp2px(11.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setPadding(0, 0, 0, 0);
        paramrvv.jdField_a_of_type_AndroidWidgetButton.setTextSize(11.0F);
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rvv.A == null) || (this.jdField_a_of_type_Rvv.jdField_z_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rvv.i == null)) {
      return;
    }
    this.jdField_a_of_type_Rvv.A.setVisibility(8);
    String str = "";
    if (a() != null) {
      str = a().a();
    }
    this.jdField_a_of_type_Rvv.j.setVisibility(8);
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    ((GradientDrawable)localObject).setColor(Color.parseColor("#E6FFFFFF"));
    this.jdField_a_of_type_Rvv.jdField_z_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_Rvv.jdField_z_of_type_AndroidViewViewGroup.setVisibility(0);
    localObject = this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = -2;
    ((ViewGroup.LayoutParams)localObject).width = -2;
    int i = AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.setPadding(0, i, 0, i);
    this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    a(this.jdField_a_of_type_Rvv.i, str, AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
    a(this.jdField_a_of_type_Rvv, true);
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup == null) || (a().b())) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    a(true, true);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.getLayoutParams();
    int j = this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.getMeasuredWidth();
    int k = this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.getMeasuredHeight();
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_Rvv.h.getLayoutParams();
    int m = localLayoutParams1.width;
    int n = localLayoutParams1.height;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i1 = AIOUtils.dp2px(41.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = AIOUtils.dp2px(197.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = AIOUtils.dp2px(33.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = this.jdField_a_of_type_Rvv.v.getMeasuredWidth();
    int i;
    if (a() == 1) {
      i = AIOUtils.dp2px(123.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_Rvv.v.getLayoutParams();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new sbx(this, localLayoutParams, j, i2 - j, k, i1 - k, localLayoutParams1, m, i3 - n, n, localLayoutParams2, i4, i));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new sby(this));
      this.jdField_a_of_type_Rvv.jdField_y_of_type_AndroidViewViewGroup.setTag(2131362701, this.jdField_a_of_type_AndroidAnimationValueAnimator);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      if (a() == 3) {
        i = AIOUtils.dp2px(115.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;
      } else {
        i = AIOUtils.dp2px(140.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;
      }
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
    if (this.jdField_a_of_type_Tut != null) {
      this.jdField_a_of_type_Tut.b();
    }
    if (this.jdField_a_of_type_Scb != null) {
      this.jdField_a_of_type_Scb.b();
    }
  }
  
  public void a(int paramInt, rvv paramrvv)
  {
    ViewGroup.LayoutParams localLayoutParams = paramrvv.A.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)paramrvv.P.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramrvv.j.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramrvv.Q.getLayoutParams();
    if ((paramInt == 0) || (paramInt == 3))
    {
      paramrvv.i.setPadding(0, 0, 0, 0);
      paramrvv.j.setPadding(0, 0, 0, 0);
      localLayoutParams.height = AIOUtils.dp2px(75.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = AIOUtils.dp2px(246.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = AIOUtils.dp2px(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = AIOUtils.dp2px(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams3.topMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams3.topMargin = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      paramrvv.Q.setLayoutParams(localLayoutParams3);
      paramrvv.j.setLayoutParams(localLayoutParams2);
      paramrvv.A.setLayoutParams(localLayoutParams);
      paramrvv.P.setLayoutParams(localLayoutParams1);
      return;
      paramInt = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrvv.i.setPadding(paramInt, paramInt, paramInt, paramInt);
      paramrvv.j.setPadding(paramInt, paramInt, paramInt, paramInt);
      localLayoutParams.height = AIOUtils.dp2px(68.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = AIOUtils.dp2px(225.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = AIOUtils.dp2px(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = AIOUtils.dp2px(-2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = AIOUtils.dp2px(-3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    if (this.jdField_a_of_type_Tut != null) {
      this.jdField_a_of_type_Tut.b(paramVideoInfo);
    }
    if (this.jdField_a_of_type_Scb != null) {
      this.jdField_a_of_type_Scb.b(paramVideoInfo);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, rvv paramrvv, double paramDouble, long paramLong)
  {
    if (paramrvv.d.getVisibility() == 0) {}
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramrvv.jdField_y_of_type_AndroidViewViewGroup == null) || (paramrvv.jdField_y_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
              break;
            }
          } while ((!this.jdField_a_of_type_Boolean) || (a() == null) || (!a().a(paramVideoInfo, paramrvv, paramDouble, paramLong)));
          if (!a())
          {
            e();
            return;
          }
          d();
          return;
        } while (((paramVideoInfo != null) && (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString))) || (a() == null) || (!a().a()) || (!a().a(paramVideoInfo)) || (paramVideoInfo == null));
        if (a()) {
          break;
        }
        try
        {
          a(paramVideoInfo, paramrvv);
          return;
        }
        catch (Exception paramVideoInfo) {}
      } while (!QLog.isColorLevel());
      QLog.e("VideoFeedsSoftAdBarController", 2, "show shunt bar error:" + paramVideoInfo.getMessage());
      return;
      paramDouble = paramLong / 1000L * paramDouble / 100.0D;
      int j = 0;
      i = j;
      if (paramVideoInfo != null)
      {
        i = j;
        if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
        {
          i = j;
          if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) {
            i = Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.C).intValue();
          }
        }
      }
    } while ((paramDouble == 0.0D) || (paramDouble <= i));
    b(paramVideoInfo, paramrvv);
  }
  
  public void a(rvv paramrvv)
  {
    if ((paramrvv != null) && (paramrvv.jdField_y_of_type_AndroidViewViewGroup != null))
    {
      paramrvv.jdField_y_of_type_AndroidViewViewGroup.setVisibility(8);
      if ((a() instanceof tut)) {
        ((tut)a()).jdField_a_of_type_Boolean = false;
      }
      try
      {
        if (!a())
        {
          b();
          return;
        }
        c();
        return;
      }
      catch (Exception paramrvv)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + paramrvv.getMessage());
      }
    }
  }
  
  public void a(rvv paramrvv1, rvv paramrvv2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    a(paramrvv1);
    if (this.jdField_a_of_type_Sca != null) {
      this.jdField_a_of_type_Sca.a();
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramrvv2.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Sca = null;
  }
  
  public void a(rvv paramrvv, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {}
    do
    {
      do
      {
        return;
      } while ((a() == null) || (paramrvv == null));
      a().a((paramLong * paramDouble));
    } while (((a() instanceof tut)) && (((tut)a()).jdField_a_of_type_Boolean));
    a(paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramrvv, paramDouble, paramLong);
  }
  
  public boolean a()
  {
    if (a() != null) {
      return a().c();
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (a() != null) {
      a().onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbt
 * JD-Core Version:    0.7.0.1
 */