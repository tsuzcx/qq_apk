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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rup
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private rot jdField_a_of_type_Rot;
  private ruw jdField_a_of_type_Ruw;
  private rux jdField_a_of_type_Rux;
  private tow jdField_a_of_type_Tow;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private boolean jdField_b_of_type_Boolean;
  
  public rup(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Int = agej.a(2.0F, paramActivity.getResources());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Tow = new tow();
    this.jdField_a_of_type_Tow.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Rux = new rux();
    this.jdField_a_of_type_Rux.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private ruw a()
  {
    if (this.jdField_a_of_type_Ruw != null) {
      return this.jdField_a_of_type_Ruw;
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_a_of_type_Rux.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo))) {}
    for (this.jdField_a_of_type_Ruw = this.jdField_a_of_type_Rux;; this.jdField_a_of_type_Ruw = this.jdField_a_of_type_Tow) {
      do
      {
        if (this.jdField_a_of_type_Ruw != null) {
          this.jdField_a_of_type_Ruw.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
        }
        return this.jdField_a_of_type_Ruw;
      } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType != 2));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, rot paramrot)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rot = paramrot;
    Object localObject;
    if ((paramrot.jdField_x_of_type_AndroidViewViewGroup == null) && ((paramrot instanceof roq)))
    {
      paramrot.jdField_x_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)((roq)paramrot).q.findViewById(2131380821)).inflate());
      int i = agej.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrot.jdField_x_of_type_AndroidViewViewGroup.setPadding(i, i, i, i);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(agej.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
      paramrot.jdField_x_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
      paramrot.h = ((URLImageView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131368001));
      paramrot.M = ((TextView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131368008));
      paramrot.N = ((TextView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131368007));
      paramrot.v = paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131370183);
      paramrot.w = paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131368006);
      paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131367998));
      paramrot.jdField_x_of_type_AndroidViewView = paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131368000);
      paramrot.O = ((TextView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131367365));
      paramrot.jdField_y_of_type_AndroidViewView = paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131367374);
      paramrot.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131362113));
      paramrot.e = ((LinearLayout)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131380822));
    }
    if ((paramrot.jdField_x_of_type_AndroidViewViewGroup != null) && (paramrot.h != null) && (paramrot.M != null) && (paramrot.N != null) && (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView != null) && (paramrot.w != null))
    {
      paramrot.jdField_x_of_type_AndroidViewViewGroup.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      a(paramrot.h, (String)localObject, this.jdField_a_of_type_Int, 18, -1);
      String str = "";
      localObject = str;
      if (a() != null)
      {
        localObject = str;
        if (a().b() != null) {
          localObject = a().b();
        }
      }
      paramrot.M.setText((CharSequence)localObject);
      paramrot.M.setVisibility(0);
      paramrot.h.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      paramrot.jdField_b_of_type_AndroidWidgetFrameLayout.setTag(paramrot);
      paramrot.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      paramrot.N.setText((CharSequence)localObject);
      paramrot.jdField_x_of_type_AndroidViewViewGroup.setTag(paramrot);
      paramrot.jdField_x_of_type_AndroidViewViewGroup.setOnClickListener(this);
      paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setTag(paramrot);
      paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
      paramrot.w.setTag(paramrot);
      paramrot.w.setOnClickListener(this);
      rpt.a(paramrot.jdField_x_of_type_AndroidViewViewGroup, 200);
      if ((a() != null) && (!TextUtils.isEmpty(a().c())) && (paramrot.O != null)) {
        paramrot.O.setText(a().c());
      }
      if (a() != null) {
        a().a(paramVideoInfo, paramrot);
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
          localURLDrawableOptions.mRequestWidth = agej.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawableOptions.mRequestHeight = agej.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawable.setTag(bhez.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(bhez.k);
        }
        catch (Exception paramURLImageView)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(bhez.j);
          continue;
        }
        paramURLImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(bhez.k);
      }
    }
  }
  
  private void a(rot paramrot, boolean paramBoolean)
  {
    int j = 0;
    boolean bool = bnrf.d();
    Object localObject;
    if ((!bool) && (paramrot.l != null))
    {
      localObject = paramrot.l;
      if (paramBoolean)
      {
        i = 0;
        ((ViewGroup)localObject).setVisibility(i);
      }
    }
    else
    {
      if (paramrot.jdField_z_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramrot.jdField_z_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label143;
        }
        i = 0;
        label57:
        ((TextView)localObject).setVisibility(i);
      }
      if ((bool) && (paramrot.r != null) && (paramrot.r.findViewById(2131367960) != null))
      {
        localObject = paramrot.r.findViewById(2131367960);
        if (!paramBoolean) {
          break label149;
        }
        i = 0;
        label106:
        ((View)localObject).setVisibility(i);
      }
      if (paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
      {
        paramrot = paramrot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
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
      paramrot.setVisibility(i);
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
        if ((this.jdField_a_of_type_Rot == null) || (this.jdField_a_of_type_Rot.jdField_z_of_type_AndroidViewViewGroup == null)) {
          continue;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.getLayoutParams();
        i = this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.getMeasuredHeight();
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
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new rur(this, localLayoutParams, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new rus(this, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_Rot.jdField_z_of_type_AndroidViewViewGroup.setTag(2131362696, this.jdField_a_of_type_AndroidAnimationValueAnimator);
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
    if (this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = agej.a(26.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Rot.N.setVisibility(8);
    this.jdField_a_of_type_Rot.w.setVisibility(8);
    this.jdField_a_of_type_Rot.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewView.setVisibility(8);
    localObject = this.jdField_a_of_type_Rot.h.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = agej.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = agej.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rot.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_Rot.v.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Rot.v.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rot.N.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = agej.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rot.N.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Rot.O.setVisibility(8);
    this.jdField_a_of_type_Rot.jdField_y_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(VideoInfo paramVideoInfo, rot paramrot)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showNewShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rot = paramrot;
    for (;;)
    {
      try
      {
        if ((paramrot.jdField_x_of_type_AndroidViewViewGroup == null) && ((paramrot instanceof roq)))
        {
          paramrot.jdField_x_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)paramrot.q.findViewById(2131380821)).inflate());
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setCornerRadius(agej.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject1).setColor(Color.parseColor("#E6FFFFFF"));
          paramrot.jdField_y_of_type_AndroidViewViewGroup = ((LinearLayout)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131380823));
          paramrot.jdField_y_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject1);
          paramrot.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
          paramrot.i = ((URLImageView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131368004));
          paramrot.j = ((URLImageView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131368003));
          paramrot.P = ((TextView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131368002));
          paramrot.Q = ((TextView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131362025));
          paramrot.R = ((TextView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131362021));
          paramrot.S = ((TextView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131362023));
          paramrot.T = ((TextView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131362024));
          paramrot.p = ((ImageView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131362020));
          paramrot.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131362113));
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setCornerRadius(agej.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#12B7F5"));
          paramrot.jdField_a_of_type_AndroidWidgetButton = ((Button)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131362019));
          paramrot.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject2);
          paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131367999));
          paramrot.jdField_z_of_type_AndroidViewViewGroup = ((ViewGroup)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131362022));
          paramrot.jdField_z_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject1);
          paramrot.jdField_z_of_type_AndroidViewView = paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131368005);
          paramrot.e = ((LinearLayout)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131380822));
        }
        if (paramrot.jdField_x_of_type_AndroidViewViewGroup == null) {
          break;
        }
        paramrot.jdField_x_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject1 = "";
        if (a() != null) {
          localObject1 = a().a();
        }
        c();
        if (a() != 3)
        {
          b(paramrot);
          a(paramrot.i, (String)localObject1, agej.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 40, -1);
          if (a() == null) {
            break label1073;
          }
          localObject1 = a().b();
          i = a().a();
          localObject2 = a().a();
          str = a().c();
          localObject3 = a().d();
          paramrot.jdField_a_of_type_AndroidWidgetButton.setText(str);
          paramrot.R.setText((CharSequence)localObject3);
          if ((i != 0) && (i != 3)) {
            break label1055;
          }
          paramrot.R.setVisibility(0);
          if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.c == null) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.c)) || (i != 3)) {
            break label1066;
          }
          localObject3 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.c;
          paramrot.P.setText((CharSequence)localObject3);
          paramrot.Q.setText((CharSequence)localObject1);
          paramrot.S.setText((CharSequence)localObject2);
          paramrot.jdField_x_of_type_AndroidViewViewGroup.setTag(paramrot);
          paramrot.jdField_x_of_type_AndroidViewViewGroup.setOnClickListener(this);
          paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setTag(paramrot);
          paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
          paramrot.p.setTag(paramrot);
          paramrot.p.setOnClickListener(this);
          paramrot.jdField_b_of_type_AndroidWidgetFrameLayout.setTag(paramrot);
          paramrot.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
          paramrot.jdField_a_of_type_AndroidWidgetButton.setTag(paramrot);
          paramrot.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          paramrot.jdField_y_of_type_AndroidViewViewGroup.setTag(paramrot);
          paramrot.jdField_y_of_type_AndroidViewViewGroup.setOnClickListener(this);
          paramrot.jdField_z_of_type_AndroidViewViewGroup.setTag(paramrot);
          paramrot.jdField_z_of_type_AndroidViewViewGroup.setOnClickListener(this);
          rpt.a(paramrot.jdField_x_of_type_AndroidViewViewGroup, 200);
          if (a() == null) {
            break;
          }
          a().a(paramVideoInfo, paramrot);
          a().a(new ruq(this, paramrot));
          return;
        }
        if ((a() == 0) || (a() == 3))
        {
          a(paramrot.i, (String)localObject1, agej.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
          a(paramrot.j, (String)localObject1, agej.a(5.2F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 75, 1);
          paramrot.jdField_z_of_type_AndroidViewView.setVisibility(4);
          a(a(), paramrot);
          continue;
        }
        a(paramrot.i, (String)localObject1, agej.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
      }
      catch (Exception paramVideoInfo)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramVideoInfo.getMessage());
        return;
      }
      a(paramrot.j, (String)localObject1, agej.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
      paramrot.jdField_z_of_type_AndroidViewView.setVisibility(0);
      continue;
      label1055:
      paramrot.R.setVisibility(4);
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
  
  private void b(rot paramrot)
  {
    Object localObject2 = (LinearLayout.LayoutParams)paramrot.jdField_y_of_type_AndroidViewViewGroup.getLayoutParams();
    Object localObject1 = (RelativeLayout.LayoutParams)paramrot.S.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramrot.p.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramrot.Q.getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramrot.i.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams4 = (LinearLayout.LayoutParams)paramrot.e.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams3 = (LinearLayout.LayoutParams)paramrot.jdField_z_of_type_AndroidViewViewGroup.getLayoutParams();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(agej.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    localGradientDrawable.setColor(Color.parseColor("#80292A2F"));
    paramrot.e.setBackgroundDrawable(localGradientDrawable);
    localLayoutParams4.width = agej.a(243.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    localLayoutParams4.height = agej.a(48.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrot.e.setLayoutParams(localLayoutParams4);
    paramrot.jdField_x_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    paramrot.e.setPadding(0, 0, 0, 0);
    ((LinearLayout.LayoutParams)localObject2).rightMargin = agej.a(10.25F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((LinearLayout.LayoutParams)localObject2).leftMargin = agej.a(4.25F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((LinearLayout.LayoutParams)localObject2).topMargin = agej.a(4.25F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = agej.a(4.25F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((LinearLayout.LayoutParams)localObject2).width = agej.a(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((LinearLayout.LayoutParams)localObject2).height = agej.a(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrot.jdField_y_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramrot.i.setVisibility(0);
    paramrot.P.setVisibility(8);
    localLayoutParams.width = agej.a(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    localLayoutParams.height = agej.a(40.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrot.i.setLayoutParams(localLayoutParams);
    paramrot.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(agej.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    ((GradientDrawable)localObject2).setColor(Color.parseColor("#00292A2F"));
    paramrot.jdField_z_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject2);
    localLayoutParams3.width = agej.a(189.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    localLayoutParams3.height = -1;
    paramrot.jdField_z_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams3);
    paramrot.jdField_z_of_type_AndroidViewViewGroup.setVisibility(0);
    localLayoutParams2.topMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    localLayoutParams2.bottomMargin = agej.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrot.Q.setLayoutParams(localLayoutParams2);
    paramrot.Q.setTextColor(Color.parseColor("#EEEEEEEE"));
    paramrot.Q.setTextSize(14.0F);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = agej.a(5.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((RelativeLayout.LayoutParams)localObject1).topMargin = agej.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrot.S.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramrot.S.setTextSize(11.0F);
    paramrot.S.setTypeface(Typeface.defaultFromStyle(1));
    paramrot.R.setVisibility(8);
    localLayoutParams1.addRule(10, 0);
    localLayoutParams1.addRule(15, -1);
    localLayoutParams1.rightMargin = agej.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramrot.p.setImageResource(2130839479);
    paramrot.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    if (a() == 0) {
      if ((TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l)) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k))) {
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l)) || (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k)))
        {
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setCornerRadius(agej.a(2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject1).setColor(Color.parseColor("#FFFF4060"));
          paramrot.T.setVisibility(0);
          paramrot.T.setBackgroundDrawable((Drawable)localObject1);
          localLayoutParams1.leftMargin = agej.a(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        }
      }
    }
    for (;;)
    {
      paramrot.p.setLayoutParams(localLayoutParams1);
      return;
      paramrot.T.setVisibility(8);
      break;
      paramrot.T.setVisibility(8);
      break;
      if (a() == 2)
      {
        localLayoutParams1.leftMargin = agej.a(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      }
      else if (a() == 1)
      {
        paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setVisibility(0);
        localObject1 = (RelativeLayout.LayoutParams)paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = agej.a(7.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = agej.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).width = agej.a(28.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).height = agej.a(28.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131362020);
        paramrot.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramrot.jdField_a_of_type_AndroidWidgetButton = ((Button)paramrot.jdField_x_of_type_AndroidViewViewGroup.findViewById(2131362019));
        paramrot.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        localObject1 = (RelativeLayout.LayoutParams)paramrot.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = agej.a(25.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = agej.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = agej.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((RelativeLayout.LayoutParams)localObject1).addRule(12, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(11, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(15, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131362020);
        paramrot.jdField_a_of_type_AndroidWidgetButton.setMinWidth(agej.a(11.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        paramrot.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramrot.jdField_a_of_type_AndroidWidgetButton.setPadding(0, 0, 0, 0);
        paramrot.jdField_a_of_type_AndroidWidgetButton.setTextSize(11.0F);
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rot.jdField_z_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rot.jdField_y_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rot.i == null)) {
      return;
    }
    this.jdField_a_of_type_Rot.jdField_z_of_type_AndroidViewViewGroup.setVisibility(8);
    String str = "";
    if (a() != null) {
      str = a().a();
    }
    this.jdField_a_of_type_Rot.j.setVisibility(8);
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(agej.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    ((GradientDrawable)localObject).setColor(Color.parseColor("#E6FFFFFF"));
    this.jdField_a_of_type_Rot.jdField_y_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_Rot.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
    localObject = this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = -2;
    ((ViewGroup.LayoutParams)localObject).width = -2;
    int i = agej.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.setPadding(0, i, 0, i);
    this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    a(this.jdField_a_of_type_Rot.i, str, agej.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
    a(this.jdField_a_of_type_Rot, true);
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup == null) || (a().b())) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    a(true, true);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.getLayoutParams();
    int j = this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.getMeasuredWidth();
    int k = this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.getMeasuredHeight();
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_Rot.h.getLayoutParams();
    int m = localLayoutParams1.width;
    int n = localLayoutParams1.height;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i1 = agej.a(41.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = agej.a(197.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = agej.a(33.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = this.jdField_a_of_type_Rot.v.getMeasuredWidth();
    int i;
    if (a() == 1) {
      i = agej.a(123.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_Rot.v.getLayoutParams();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new rut(this, localLayoutParams, j, i2 - j, k, i1 - k, localLayoutParams1, m, i3 - n, n, localLayoutParams2, i4, i));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ruu(this));
      this.jdField_a_of_type_Rot.jdField_x_of_type_AndroidViewViewGroup.setTag(2131362696, this.jdField_a_of_type_AndroidAnimationValueAnimator);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      if (a() == 3) {
        i = agej.a(115.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;
      } else {
        i = agej.a(140.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;
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
    if (this.jdField_a_of_type_Tow != null) {
      this.jdField_a_of_type_Tow.b();
    }
    if (this.jdField_a_of_type_Rux != null) {
      this.jdField_a_of_type_Rux.b();
    }
  }
  
  public void a(int paramInt, rot paramrot)
  {
    ViewGroup.LayoutParams localLayoutParams = paramrot.jdField_z_of_type_AndroidViewViewGroup.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)paramrot.P.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramrot.j.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramrot.Q.getLayoutParams();
    if ((paramInt == 0) || (paramInt == 3))
    {
      paramrot.i.setPadding(0, 0, 0, 0);
      paramrot.j.setPadding(0, 0, 0, 0);
      localLayoutParams.height = agej.a(75.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = agej.a(246.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = agej.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = agej.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = agej.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = agej.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams3.topMargin = agej.a(7.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams3.topMargin = agej.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      paramrot.Q.setLayoutParams(localLayoutParams3);
      paramrot.j.setLayoutParams(localLayoutParams2);
      paramrot.jdField_z_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      paramrot.P.setLayoutParams(localLayoutParams1);
      return;
      paramInt = agej.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrot.i.setPadding(paramInt, paramInt, paramInt, paramInt);
      paramrot.j.setPadding(paramInt, paramInt, paramInt, paramInt);
      localLayoutParams.height = agej.a(68.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = agej.a(225.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = agej.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = agej.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = agej.a(-2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = agej.a(-3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    if (this.jdField_a_of_type_Tow != null) {
      this.jdField_a_of_type_Tow.b(paramVideoInfo);
    }
    if (this.jdField_a_of_type_Rux != null) {
      this.jdField_a_of_type_Rux.b(paramVideoInfo);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, rot paramrot, double paramDouble, long paramLong)
  {
    if (paramrot.d.getVisibility() == 0) {}
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
            if ((paramrot.jdField_x_of_type_AndroidViewViewGroup == null) || (paramrot.jdField_x_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
              break;
            }
          } while ((!this.jdField_a_of_type_Boolean) || (a() == null) || (!a().a(paramVideoInfo, paramrot, paramDouble, paramLong)));
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
          a(paramVideoInfo, paramrot);
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
    b(paramVideoInfo, paramrot);
  }
  
  public void a(rot paramrot)
  {
    if ((paramrot != null) && (paramrot.jdField_x_of_type_AndroidViewViewGroup != null))
    {
      paramrot.jdField_x_of_type_AndroidViewViewGroup.setVisibility(8);
      if ((a() instanceof tow)) {
        ((tow)a()).jdField_a_of_type_Boolean = false;
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
      catch (Exception paramrot)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + paramrot.getMessage());
      }
    }
  }
  
  public void a(rot paramrot1, rot paramrot2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    a(paramrot1);
    if (this.jdField_a_of_type_Ruw != null) {
      this.jdField_a_of_type_Ruw.a();
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramrot2.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Ruw = null;
  }
  
  public void a(rot paramrot, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {}
    do
    {
      do
      {
        return;
      } while ((a() == null) || (paramrot == null));
      a().a((paramLong * paramDouble));
    } while (((a() instanceof tow)) && (((tow)a()).jdField_a_of_type_Boolean));
    a(paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramrot, paramDouble, paramLong);
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
 * Qualified Name:     rup
 * JD-Core Version:    0.7.0.1
 */