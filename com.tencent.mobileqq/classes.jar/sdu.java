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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sdu
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private opl jdField_a_of_type_Opl;
  private rxy jdField_a_of_type_Rxy;
  private seb jdField_a_of_type_Seb;
  private sec jdField_a_of_type_Sec;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public sdu(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Int = afur.a(2.0F, paramActivity.getResources());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Opl = new opl();
    this.jdField_a_of_type_Opl.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Sec = new sec();
    this.jdField_a_of_type_Sec.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private seb a()
  {
    if (this.jdField_a_of_type_Seb != null) {
      return this.jdField_a_of_type_Seb;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_a_of_type_Sec.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))) {}
    for (this.jdField_a_of_type_Seb = this.jdField_a_of_type_Sec;; this.jdField_a_of_type_Seb = this.jdField_a_of_type_Opl) {
      do
      {
        if (this.jdField_a_of_type_Seb != null) {
          this.jdField_a_of_type_Seb.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        }
        return this.jdField_a_of_type_Seb;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType != 2));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, rxy paramrxy)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rxy = paramrxy;
    Object localObject;
    if ((paramrxy.jdField_y_of_type_AndroidViewViewGroup == null) && ((paramrxy instanceof rxv)))
    {
      paramrxy.jdField_y_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)((rxv)paramrxy).jdField_r_of_type_AndroidViewViewGroup.findViewById(2131380635)).inflate());
      int i = afur.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrxy.jdField_y_of_type_AndroidViewViewGroup.setPadding(i, i, i, i);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(afur.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
      paramrxy.jdField_y_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
      paramrxy.h = ((URLImageView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367931));
      paramrxy.M = ((TextView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367938));
      paramrxy.N = ((TextView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367937));
      paramrxy.v = paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131370088);
      paramrxy.w = paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367936);
      paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367928));
      paramrxy.x = paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367930);
      paramrxy.O = ((TextView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367307));
      paramrxy.jdField_y_of_type_AndroidViewView = paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367316);
      paramrxy.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362107));
    }
    if ((paramrxy.jdField_y_of_type_AndroidViewViewGroup != null) && (paramrxy.h != null) && (paramrxy.M != null) && (paramrxy.N != null) && (paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView != null) && (paramrxy.w != null))
    {
      paramrxy.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      a(paramrxy.h, (String)localObject, this.jdField_a_of_type_Int, 18, -1);
      String str = "";
      localObject = str;
      if (a() != null)
      {
        localObject = str;
        if (a().b() != null) {
          localObject = a().b();
        }
      }
      paramrxy.M.setText((CharSequence)localObject);
      paramrxy.M.setVisibility(0);
      paramrxy.h.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      paramrxy.jdField_b_of_type_AndroidWidgetFrameLayout.setTag(paramrxy);
      paramrxy.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      paramrxy.N.setText((CharSequence)localObject);
      paramrxy.jdField_y_of_type_AndroidViewViewGroup.setTag(paramrxy);
      paramrxy.jdField_y_of_type_AndroidViewViewGroup.setOnClickListener(this);
      paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setTag(paramrxy);
      paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
      paramrxy.w.setTag(paramrxy);
      paramrxy.w.setOnClickListener(this);
      ryx.a(paramrxy.jdField_y_of_type_AndroidViewViewGroup, 200);
      if (a() != null) {
        a().a(paramVideoInfo, paramrxy);
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
          localURLDrawableOptions.mRequestWidth = afur.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawableOptions.mRequestHeight = afur.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawable.setTag(bgey.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(bgey.k);
        }
        catch (Exception paramURLImageView)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(bgey.j);
          continue;
        }
        paramURLImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(bgey.k);
      }
    }
  }
  
  private void a(rxy paramrxy, boolean paramBoolean)
  {
    int j = 0;
    boolean bool = bmqa.d();
    Object localObject;
    if ((!bool) && (paramrxy.m != null))
    {
      localObject = paramrxy.m;
      if (paramBoolean)
      {
        i = 0;
        ((ViewGroup)localObject).setVisibility(i);
      }
    }
    else
    {
      if (paramrxy.jdField_z_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramrxy.jdField_z_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label143;
        }
        i = 0;
        label57:
        ((TextView)localObject).setVisibility(i);
      }
      if ((bool) && (paramrxy.jdField_r_of_type_AndroidViewView != null) && (paramrxy.jdField_r_of_type_AndroidViewView.findViewById(2131367890) != null))
      {
        localObject = paramrxy.jdField_r_of_type_AndroidViewView.findViewById(2131367890);
        if (!paramBoolean) {
          break label149;
        }
        i = 0;
        label106:
        ((View)localObject).setVisibility(i);
      }
      if (paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
      {
        paramrxy = paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
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
      paramrxy.setVisibility(i);
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
        if ((this.jdField_a_of_type_Rxy == null) || (this.jdField_a_of_type_Rxy.A == null)) {
          continue;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.getLayoutParams();
        i = this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.getMeasuredHeight();
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
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new sdw(this, localLayoutParams, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new sdx(this, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_Rxy.A.setTag(2131362680, this.jdField_a_of_type_AndroidAnimationValueAnimator);
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
    if (this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = afur.a(26.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Rxy.N.setVisibility(8);
    this.jdField_a_of_type_Rxy.w.setVisibility(8);
    this.jdField_a_of_type_Rxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_Rxy.x.setVisibility(8);
    localObject = this.jdField_a_of_type_Rxy.h.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = afur.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = afur.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rxy.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_Rxy.v.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Rxy.v.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rxy.N.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = afur.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rxy.N.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Rxy.O.setVisibility(8);
    this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(VideoInfo paramVideoInfo, rxy paramrxy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showNewShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rxy = paramrxy;
    for (;;)
    {
      try
      {
        if ((paramrxy.jdField_y_of_type_AndroidViewViewGroup == null) && ((paramrxy instanceof rxv)))
        {
          paramrxy.jdField_y_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)paramrxy.jdField_r_of_type_AndroidViewViewGroup.findViewById(2131380635)).inflate());
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setCornerRadius(afur.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject1).setColor(Color.parseColor("#E6FFFFFF"));
          paramrxy.jdField_z_of_type_AndroidViewViewGroup = ((LinearLayout)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131380637));
          paramrxy.jdField_z_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject1);
          paramrxy.jdField_z_of_type_AndroidViewViewGroup.setVisibility(0);
          paramrxy.i = ((URLImageView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367934));
          paramrxy.j = ((URLImageView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367933));
          paramrxy.P = ((TextView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367932));
          paramrxy.Q = ((TextView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362021));
          paramrxy.R = ((TextView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362018));
          paramrxy.S = ((TextView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362020));
          paramrxy.p = ((ImageView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362017));
          paramrxy.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362107));
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setCornerRadius(afur.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#12B7F5"));
          paramrxy.jdField_a_of_type_AndroidWidgetButton = ((Button)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362016));
          paramrxy.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject2);
          paramrxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367929));
          paramrxy.A = ((ViewGroup)paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362019));
          paramrxy.A.setBackgroundDrawable((Drawable)localObject1);
          paramrxy.jdField_z_of_type_AndroidViewView = paramrxy.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131367935);
        }
        if (paramrxy.jdField_y_of_type_AndroidViewViewGroup == null) {
          break;
        }
        paramrxy.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject1 = "";
        if (a() != null) {
          localObject1 = a().a();
        }
        c();
        if ((a() == 0) || (a() == 3))
        {
          a(paramrxy.i, (String)localObject1, afur.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
          a(paramrxy.j, (String)localObject1, afur.a(5.2F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 75, 1);
          paramrxy.jdField_z_of_type_AndroidViewView.setVisibility(4);
          a(a(), paramrxy);
          if (a() == null) {
            break label992;
          }
          localObject1 = a().b();
          i = a().a();
          localObject2 = a().a();
          str = a().c();
          localObject3 = a().d();
          paramrxy.jdField_a_of_type_AndroidWidgetButton.setText(str);
          paramrxy.R.setText((CharSequence)localObject3);
          if ((i == 0) || (i == 3))
          {
            paramrxy.R.setVisibility(0);
            if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.c == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.c))) {
              break label985;
            }
            localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.c;
            paramrxy.P.setText((CharSequence)localObject3);
            paramrxy.Q.setText((CharSequence)localObject1);
            paramrxy.S.setText((CharSequence)localObject2);
            paramrxy.jdField_y_of_type_AndroidViewViewGroup.setTag(paramrxy);
            paramrxy.jdField_y_of_type_AndroidViewViewGroup.setOnClickListener(this);
            paramrxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setTag(paramrxy);
            paramrxy.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
            paramrxy.p.setTag(paramrxy);
            paramrxy.p.setOnClickListener(this);
            paramrxy.jdField_b_of_type_AndroidWidgetFrameLayout.setTag(paramrxy);
            paramrxy.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
            paramrxy.jdField_a_of_type_AndroidWidgetButton.setTag(paramrxy);
            paramrxy.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
            paramrxy.jdField_z_of_type_AndroidViewViewGroup.setTag(paramrxy);
            paramrxy.jdField_z_of_type_AndroidViewViewGroup.setOnClickListener(this);
            paramrxy.A.setTag(paramrxy);
            paramrxy.A.setOnClickListener(this);
            ryx.a(paramrxy.jdField_y_of_type_AndroidViewViewGroup, 200);
            if (a() == null) {
              break;
            }
            a().a(paramVideoInfo, paramrxy);
            a().a(new sdv(this));
          }
        }
        else
        {
          a(paramrxy.i, (String)localObject1, afur.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
          a(paramrxy.j, (String)localObject1, afur.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
          paramrxy.jdField_z_of_type_AndroidViewView.setVisibility(0);
          continue;
        }
        paramrxy.R.setVisibility(4);
      }
      catch (Exception paramVideoInfo)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramVideoInfo.getMessage());
        return;
      }
      continue;
      label985:
      Object localObject3 = localObject1;
      continue;
      label992:
      Object localObject2 = "";
      localObject3 = "";
      int i = -1;
      Object localObject1 = "";
      String str = "";
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rxy.A == null) || (this.jdField_a_of_type_Rxy.jdField_z_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rxy.i == null)) {
      return;
    }
    this.jdField_a_of_type_Rxy.A.setVisibility(8);
    String str = "";
    if (a() != null) {
      str = a().a();
    }
    this.jdField_a_of_type_Rxy.j.setVisibility(8);
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(afur.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    ((GradientDrawable)localObject).setColor(Color.parseColor("#E6FFFFFF"));
    this.jdField_a_of_type_Rxy.jdField_z_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_Rxy.jdField_z_of_type_AndroidViewViewGroup.setVisibility(0);
    localObject = this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = -2;
    ((ViewGroup.LayoutParams)localObject).width = -2;
    int i = afur.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.setPadding(0, i, 0, i);
    this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    a(this.jdField_a_of_type_Rxy.i, str, afur.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
    a(this.jdField_a_of_type_Rxy, true);
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup == null) || (a().b())) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    a(true, true);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.getLayoutParams();
    int j = this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.getMeasuredWidth();
    int k = this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.getMeasuredHeight();
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_Rxy.h.getLayoutParams();
    int m = localLayoutParams1.width;
    int n = localLayoutParams1.height;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i1 = afur.a(41.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = afur.a(197.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = afur.a(33.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = this.jdField_a_of_type_Rxy.v.getMeasuredWidth();
    int i;
    if (a() == 1) {
      i = afur.a(123.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_Rxy.v.getLayoutParams();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new sdy(this, localLayoutParams, j, i2 - j, k, i1 - k, localLayoutParams1, m, i3 - n, n, localLayoutParams2, i4, i));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new sdz(this));
      this.jdField_a_of_type_Rxy.jdField_y_of_type_AndroidViewViewGroup.setTag(2131362680, this.jdField_a_of_type_AndroidAnimationValueAnimator);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
      if (a() == 3) {
        i = afur.a(115.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;
      } else {
        i = afur.a(140.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;
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
    if (this.jdField_a_of_type_Opl != null) {
      this.jdField_a_of_type_Opl.a();
    }
    if (this.jdField_a_of_type_Sec != null) {
      this.jdField_a_of_type_Sec.a();
    }
  }
  
  public void a(int paramInt, rxy paramrxy)
  {
    ViewGroup.LayoutParams localLayoutParams = paramrxy.A.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)paramrxy.P.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramrxy.j.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramrxy.Q.getLayoutParams();
    if ((paramInt == 0) || (paramInt == 3))
    {
      paramrxy.i.setPadding(0, 0, 0, 0);
      paramrxy.j.setPadding(0, 0, 0, 0);
      localLayoutParams.height = afur.a(75.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = afur.a(246.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = afur.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = afur.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = afur.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = afur.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams3.topMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams3.topMargin = afur.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      paramrxy.Q.setLayoutParams(localLayoutParams3);
      paramrxy.j.setLayoutParams(localLayoutParams2);
      paramrxy.A.setLayoutParams(localLayoutParams);
      paramrxy.P.setLayoutParams(localLayoutParams1);
      return;
      paramInt = afur.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrxy.i.setPadding(paramInt, paramInt, paramInt, paramInt);
      paramrxy.j.setPadding(paramInt, paramInt, paramInt, paramInt);
      localLayoutParams.height = afur.a(68.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = afur.a(225.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = afur.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = afur.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = afur.a(-2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = afur.a(-3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
  }
  
  public void a(VideoInfo paramVideoInfo, rxy paramrxy, double paramDouble, long paramLong)
  {
    if (paramrxy.d.getVisibility() == 0) {}
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
            if ((paramrxy.jdField_y_of_type_AndroidViewViewGroup == null) || (paramrxy.jdField_y_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
              break;
            }
          } while ((!this.jdField_a_of_type_Boolean) || (a() == null) || (!a().a(paramVideoInfo, paramrxy, paramDouble, paramLong)));
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
          a(paramVideoInfo, paramrxy);
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
    b(paramVideoInfo, paramrxy);
  }
  
  public void a(rxy paramrxy)
  {
    if ((paramrxy != null) && (paramrxy.jdField_y_of_type_AndroidViewViewGroup != null))
    {
      paramrxy.jdField_y_of_type_AndroidViewViewGroup.setVisibility(8);
      if ((a() instanceof opl)) {
        ((opl)a()).jdField_a_of_type_Boolean = false;
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
      catch (Exception paramrxy)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + paramrxy.getMessage());
      }
    }
  }
  
  public void a(rxy paramrxy1, rxy paramrxy2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    a(paramrxy1);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramrxy2.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Seb = null;
  }
  
  public void a(rxy paramrxy, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {}
    while ((a() == null) || (paramrxy == null) || (((a() instanceof opl)) && (((opl)a()).jdField_a_of_type_Boolean))) {
      return;
    }
    a(paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramrxy, paramDouble, paramLong);
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
 * Qualified Name:     sdu
 * JD-Core Version:    0.7.0.1
 */