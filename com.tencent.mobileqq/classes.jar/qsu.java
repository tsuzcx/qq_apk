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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
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

public class qsu
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private nzi jdField_a_of_type_Nzi;
  private qmp jdField_a_of_type_Qmp;
  private qtb jdField_a_of_type_Qtb;
  private qtc jdField_a_of_type_Qtc;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public qsu(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Int = actj.a(2.0F, paramActivity.getResources());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Nzi = new nzi();
    this.jdField_a_of_type_Nzi.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Qtc = new qtc();
    this.jdField_a_of_type_Qtc.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private qtb a()
  {
    if (this.jdField_a_of_type_Qtb != null) {
      return this.jdField_a_of_type_Qtb;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_a_of_type_Qtc.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))) {}
    for (this.jdField_a_of_type_Qtb = this.jdField_a_of_type_Qtc;; this.jdField_a_of_type_Qtb = this.jdField_a_of_type_Nzi) {
      do
      {
        if (this.jdField_a_of_type_Qtb != null) {
          this.jdField_a_of_type_Qtb.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        }
        return this.jdField_a_of_type_Qtb;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType != 2));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, qmp paramqmp)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qmp = paramqmp;
    Object localObject;
    if ((paramqmp.jdField_t_of_type_AndroidViewViewGroup == null) && ((paramqmp instanceof qmo)))
    {
      paramqmp.jdField_t_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)((qmo)paramqmp).o.findViewById(2131378970)).inflate());
      int i = actj.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramqmp.jdField_t_of_type_AndroidViewViewGroup.setPadding(i, i, i, i);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(actj.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
      paramqmp.jdField_t_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
      paramqmp.g = ((URLImageView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367486));
      paramqmp.P = ((TextView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367493));
      paramqmp.Q = ((TextView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367492));
      paramqmp.jdField_v_of_type_AndroidViewView = paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131369402);
      paramqmp.w = paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367491);
      paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367483));
      paramqmp.x = paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367485);
    }
    if (paramqmp.jdField_t_of_type_AndroidViewViewGroup != null)
    {
      paramqmp.jdField_t_of_type_AndroidViewViewGroup.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      a(paramqmp.g, (String)localObject, this.jdField_a_of_type_Int, 18, -1);
      localObject = "";
      if (a() != null) {
        localObject = a().b();
      }
      paramqmp.P.setText((CharSequence)localObject);
      paramqmp.P.setVisibility(0);
      paramqmp.g.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      paramqmp.Q.setText((CharSequence)localObject);
      paramqmp.jdField_t_of_type_AndroidViewViewGroup.setTag(paramqmp);
      paramqmp.jdField_t_of_type_AndroidViewViewGroup.setOnClickListener(this);
      paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setTag(paramqmp);
      paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
      paramqmp.w.setTag(paramqmp);
      paramqmp.w.setOnClickListener(this);
      qoi.a(paramqmp.jdField_t_of_type_AndroidViewViewGroup, 200);
      if (a() != null) {
        a().a(paramVideoInfo, paramqmp);
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
          localURLDrawableOptions.mRequestWidth = actj.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawableOptions.mRequestHeight = actj.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawable.setTag(bavw.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(bavw.j);
        }
        catch (Exception paramURLImageView)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(bavw.i);
          continue;
        }
        paramURLImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(bavw.j);
      }
    }
  }
  
  private void a(qmp paramqmp, boolean paramBoolean)
  {
    int k = 0;
    int j;
    if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1)
    {
      i = 1;
      Object localObject;
      if ((i == 0) && (paramqmp.k != null))
      {
        localObject = paramqmp.k;
        if (!paramBoolean) {
          break label158;
        }
        j = 0;
        label46:
        ((ViewGroup)localObject).setVisibility(j);
      }
      if (paramqmp.B != null)
      {
        localObject = paramqmp.B;
        if (!paramBoolean) {
          break label165;
        }
        j = 0;
        label73:
        ((TextView)localObject).setVisibility(j);
      }
      if ((i != 0) && (paramqmp.jdField_t_of_type_AndroidViewView != null) && (paramqmp.jdField_t_of_type_AndroidViewView.findViewById(2131367439) != null))
      {
        localObject = paramqmp.jdField_t_of_type_AndroidViewView.findViewById(2131367439);
        if (!paramBoolean) {
          break label172;
        }
        i = 0;
        label122:
        ((View)localObject).setVisibility(i);
      }
      if (paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
      {
        paramqmp = paramqmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
        if (!paramBoolean) {
          break label178;
        }
      }
    }
    label158:
    label165:
    label172:
    label178:
    for (int i = k;; i = 8)
    {
      paramqmp.setVisibility(i);
      return;
      i = 0;
      break;
      j = 8;
      break label46;
      j = 8;
      break label73;
      i = 8;
      break label122;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Qmp == null) || (this.jdField_a_of_type_Qmp.jdField_v_of_type_AndroidViewViewGroup == null)) {
          continue;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.getLayoutParams();
        i = this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.getMeasuredHeight();
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
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new qsw(this, localLayoutParams, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new qsx(this, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_Qmp.jdField_v_of_type_AndroidViewViewGroup.setTag(2131362550, this.jdField_a_of_type_AndroidAnimationValueAnimator);
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
    if (this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = actj.a(26.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Qmp.Q.setVisibility(8);
    this.jdField_a_of_type_Qmp.w.setVisibility(8);
    this.jdField_a_of_type_Qmp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_Qmp.x.setVisibility(8);
    localObject = this.jdField_a_of_type_Qmp.g.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = actj.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = actj.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Qmp.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_Qmp.jdField_v_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Qmp.jdField_v_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qmp.Q.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = actj.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Qmp.Q.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(VideoInfo paramVideoInfo, qmp paramqmp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showNewShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qmp = paramqmp;
    for (;;)
    {
      try
      {
        if ((paramqmp.jdField_t_of_type_AndroidViewViewGroup == null) && ((paramqmp instanceof qmo)))
        {
          paramqmp.jdField_t_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)paramqmp.o.findViewById(2131378970)).inflate());
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setCornerRadius(actj.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject1).setColor(Color.parseColor("#E6FFFFFF"));
          paramqmp.u = ((LinearLayout)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131378972));
          paramqmp.u.setBackgroundDrawable((Drawable)localObject1);
          paramqmp.u.setVisibility(0);
          paramqmp.h = ((URLImageView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367489));
          paramqmp.i = ((URLImageView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367488));
          paramqmp.R = ((TextView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367487));
          paramqmp.S = ((TextView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361962));
          paramqmp.T = ((TextView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361959));
          paramqmp.U = ((TextView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361961));
          paramqmp.n = ((ImageView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361958));
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setCornerRadius(actj.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#12B7F5"));
          paramqmp.jdField_a_of_type_AndroidWidgetButton = ((Button)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361957));
          paramqmp.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject2);
          paramqmp.b = ((ReadInjoyHeaderAdDownloadView)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367484));
          paramqmp.jdField_v_of_type_AndroidViewViewGroup = ((ViewGroup)paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361960));
          paramqmp.jdField_v_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject1);
          paramqmp.y = paramqmp.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367490);
        }
        if (paramqmp.jdField_t_of_type_AndroidViewViewGroup == null) {
          break;
        }
        paramqmp.jdField_t_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject1 = "";
        if (a() != null) {
          localObject1 = a().a();
        }
        c();
        if (a() == 0)
        {
          a(paramqmp.h, (String)localObject1, actj.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
          a(paramqmp.i, (String)localObject1, actj.a(5.2F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 75, 1);
          paramqmp.y.setVisibility(4);
          a(a(), paramqmp);
          if (a() == null) {
            break label860;
          }
          str = a().b();
          i = a().a();
          localObject3 = a().a();
          localObject2 = a().c();
          localObject1 = a().d();
          paramqmp.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
          paramqmp.T.setText((CharSequence)localObject1);
          if (i == 0)
          {
            paramqmp.T.setVisibility(0);
            paramqmp.R.setText(str);
            paramqmp.S.setText(str);
            paramqmp.U.setText((CharSequence)localObject3);
            paramqmp.jdField_t_of_type_AndroidViewViewGroup.setTag(paramqmp);
            paramqmp.jdField_t_of_type_AndroidViewViewGroup.setOnClickListener(this);
            paramqmp.b.setTag(paramqmp);
            paramqmp.b.setOnClickListener(this);
            paramqmp.n.setTag(paramqmp);
            paramqmp.n.setOnClickListener(this);
            paramqmp.jdField_a_of_type_AndroidWidgetButton.setTag(paramqmp);
            paramqmp.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
            paramqmp.u.setTag(paramqmp);
            paramqmp.u.setOnClickListener(this);
            paramqmp.jdField_v_of_type_AndroidViewViewGroup.setTag(paramqmp);
            paramqmp.jdField_v_of_type_AndroidViewViewGroup.setOnClickListener(this);
            qoi.a(paramqmp.jdField_t_of_type_AndroidViewViewGroup, 200);
            if (a() == null) {
              break;
            }
            a().a(paramVideoInfo, paramqmp);
            a().a(new qsv(this));
          }
        }
        else
        {
          a(paramqmp.h, (String)localObject1, actj.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
          a(paramqmp.i, (String)localObject1, actj.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
          paramqmp.y.setVisibility(0);
          continue;
        }
        paramqmp.T.setVisibility(4);
      }
      catch (Exception paramVideoInfo)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramVideoInfo.getMessage());
        return;
      }
      continue;
      label860:
      String str = "";
      Object localObject3 = "";
      Object localObject2 = "";
      Object localObject1 = "";
      int i = -1;
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qmp.jdField_v_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qmp.u == null) || (this.jdField_a_of_type_Qmp.h == null)) {
      return;
    }
    this.jdField_a_of_type_Qmp.jdField_v_of_type_AndroidViewViewGroup.setVisibility(8);
    String str = "";
    if (a() != null) {
      str = a().a();
    }
    this.jdField_a_of_type_Qmp.i.setVisibility(8);
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(actj.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    ((GradientDrawable)localObject).setColor(Color.parseColor("#E6FFFFFF"));
    this.jdField_a_of_type_Qmp.u.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_Qmp.u.setVisibility(0);
    localObject = this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = -2;
    ((ViewGroup.LayoutParams)localObject).width = -2;
    int i = actj.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.setPadding(0, i, 0, i);
    this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    a(this.jdField_a_of_type_Qmp.h, str, actj.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
    a(this.jdField_a_of_type_Qmp, true);
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup == null) || (a().b())) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    a(true, true);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.getLayoutParams();
    int j = this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.getMeasuredWidth();
    int k = this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.getMeasuredHeight();
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_Qmp.g.getLayoutParams();
    int m = localLayoutParams1.width;
    int n = localLayoutParams1.height;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i1 = actj.a(41.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = actj.a(197.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = actj.a(33.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = this.jdField_a_of_type_Qmp.jdField_v_of_type_AndroidViewView.getMeasuredWidth();
    if (a() == 1) {}
    for (int i = actj.a(123.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;; i = actj.a(140.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4)
    {
      ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_Qmp.jdField_v_of_type_AndroidViewView.getLayoutParams();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new qsy(this, localLayoutParams, j, i2 - j, k, i1 - k, localLayoutParams1, m, i3 - n, n, localLayoutParams2, i4, i));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new qsz(this));
      this.jdField_a_of_type_Qmp.jdField_t_of_type_AndroidViewViewGroup.setTag(2131362550, this.jdField_a_of_type_AndroidAnimationValueAnimator);
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
    if (this.jdField_a_of_type_Nzi != null) {
      this.jdField_a_of_type_Nzi.a();
    }
    if (this.jdField_a_of_type_Qtc != null) {
      this.jdField_a_of_type_Qtc.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (a() != null) {
      a().a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, qmp paramqmp)
  {
    ViewGroup.LayoutParams localLayoutParams = paramqmp.jdField_v_of_type_AndroidViewViewGroup.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)paramqmp.R.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramqmp.i.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramqmp.S.getLayoutParams();
    if (paramInt == 0)
    {
      paramqmp.h.setPadding(0, 0, 0, 0);
      paramqmp.i.setPadding(0, 0, 0, 0);
      localLayoutParams.height = actj.a(75.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = actj.a(246.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = actj.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = actj.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = actj.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = actj.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams3.topMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams3.topMargin = actj.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      paramqmp.S.setLayoutParams(localLayoutParams3);
      paramqmp.i.setLayoutParams(localLayoutParams2);
      paramqmp.jdField_v_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      paramqmp.R.setLayoutParams(localLayoutParams1);
      return;
      paramInt = actj.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramqmp.h.setPadding(paramInt, paramInt, paramInt, paramInt);
      paramqmp.i.setPadding(paramInt, paramInt, paramInt, paramInt);
      localLayoutParams.height = actj.a(68.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = actj.a(225.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = actj.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = actj.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = actj.a(-2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = actj.a(-3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
  }
  
  public void a(VideoInfo paramVideoInfo, qmp paramqmp, double paramDouble, long paramLong)
  {
    if (paramqmp.d.getVisibility() == 0) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          if ((paramqmp.jdField_t_of_type_AndroidViewViewGroup == null) || (paramqmp.jdField_t_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
            break;
          }
        } while ((!this.jdField_a_of_type_Boolean) || (a() == null) || (!a().a(paramVideoInfo, paramqmp, paramDouble, paramLong)));
        if (!a())
        {
          e();
          return;
        }
        d();
        return;
      } while (((paramVideoInfo != null) && (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString))) || (a() == null) || (!a().a()) || (!a().a(paramVideoInfo)) || (paramVideoInfo == null));
      if (!a())
      {
        a(paramVideoInfo, paramqmp);
        return;
      }
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
            i = Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.B).intValue();
          }
        }
      }
    } while ((paramDouble == 0.0D) || (paramDouble <= i));
    b(paramVideoInfo, paramqmp);
  }
  
  public void a(qmp paramqmp)
  {
    if ((paramqmp != null) && (paramqmp.jdField_t_of_type_AndroidViewViewGroup != null))
    {
      paramqmp.jdField_t_of_type_AndroidViewViewGroup.setVisibility(8);
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
      catch (Exception paramqmp)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + paramqmp.getMessage());
      }
    }
  }
  
  public void a(qmp paramqmp1, qmp paramqmp2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    a(paramqmp1);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramqmp2.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Qtb = null;
  }
  
  public void a(qmp paramqmp, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {}
    while ((a() == null) || (paramqmp == null)) {
      return;
    }
    a(paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramqmp, paramDouble, paramLong);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qsu
 * JD-Core Version:    0.7.0.1
 */