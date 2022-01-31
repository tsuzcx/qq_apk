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

public class qsx
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private nzl jdField_a_of_type_Nzl;
  private qms jdField_a_of_type_Qms;
  private qte jdField_a_of_type_Qte;
  private qtf jdField_a_of_type_Qtf;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public qsx(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Int = actn.a(2.0F, paramActivity.getResources());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Nzl = new nzl();
    this.jdField_a_of_type_Nzl.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Qtf = new qtf();
    this.jdField_a_of_type_Qtf.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private qte a()
  {
    if (this.jdField_a_of_type_Qte != null) {
      return this.jdField_a_of_type_Qte;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_a_of_type_Qtf.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))) {}
    for (this.jdField_a_of_type_Qte = this.jdField_a_of_type_Qtf;; this.jdField_a_of_type_Qte = this.jdField_a_of_type_Nzl) {
      do
      {
        if (this.jdField_a_of_type_Qte != null) {
          this.jdField_a_of_type_Qte.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        }
        return this.jdField_a_of_type_Qte;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType != 2));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, qms paramqms)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qms = paramqms;
    Object localObject;
    if ((paramqms.jdField_t_of_type_AndroidViewViewGroup == null) && ((paramqms instanceof qmr)))
    {
      paramqms.jdField_t_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)((qmr)paramqms).o.findViewById(2131378965)).inflate());
      int i = actn.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramqms.jdField_t_of_type_AndroidViewViewGroup.setPadding(i, i, i, i);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(actn.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
      paramqms.jdField_t_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
      paramqms.g = ((URLImageView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367486));
      paramqms.P = ((TextView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367493));
      paramqms.Q = ((TextView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367492));
      paramqms.jdField_v_of_type_AndroidViewView = paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131369403);
      paramqms.w = paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367491);
      paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367483));
      paramqms.x = paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367485);
    }
    if (paramqms.jdField_t_of_type_AndroidViewViewGroup != null)
    {
      paramqms.jdField_t_of_type_AndroidViewViewGroup.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      a(paramqms.g, (String)localObject, this.jdField_a_of_type_Int, 18, -1);
      localObject = "";
      if (a() != null) {
        localObject = a().b();
      }
      paramqms.P.setText((CharSequence)localObject);
      paramqms.P.setVisibility(0);
      paramqms.g.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      paramqms.Q.setText((CharSequence)localObject);
      paramqms.jdField_t_of_type_AndroidViewViewGroup.setTag(paramqms);
      paramqms.jdField_t_of_type_AndroidViewViewGroup.setOnClickListener(this);
      paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setTag(paramqms);
      paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
      paramqms.w.setTag(paramqms);
      paramqms.w.setOnClickListener(this);
      qol.a(paramqms.jdField_t_of_type_AndroidViewViewGroup, 200);
      if (a() != null) {
        a().a(paramVideoInfo, paramqms);
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
          localURLDrawableOptions.mRequestWidth = actn.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawableOptions.mRequestHeight = actn.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawable.setTag(bavi.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(bavi.j);
        }
        catch (Exception paramURLImageView)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(bavi.i);
          continue;
        }
        paramURLImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(bavi.j);
      }
    }
  }
  
  private void a(qms paramqms, boolean paramBoolean)
  {
    int k = 0;
    int j;
    if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1)
    {
      i = 1;
      Object localObject;
      if ((i == 0) && (paramqms.k != null))
      {
        localObject = paramqms.k;
        if (!paramBoolean) {
          break label158;
        }
        j = 0;
        label46:
        ((ViewGroup)localObject).setVisibility(j);
      }
      if (paramqms.B != null)
      {
        localObject = paramqms.B;
        if (!paramBoolean) {
          break label165;
        }
        j = 0;
        label73:
        ((TextView)localObject).setVisibility(j);
      }
      if ((i != 0) && (paramqms.jdField_t_of_type_AndroidViewView != null) && (paramqms.jdField_t_of_type_AndroidViewView.findViewById(2131367439) != null))
      {
        localObject = paramqms.jdField_t_of_type_AndroidViewView.findViewById(2131367439);
        if (!paramBoolean) {
          break label172;
        }
        i = 0;
        label122:
        ((View)localObject).setVisibility(i);
      }
      if (paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
      {
        paramqms = paramqms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
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
      paramqms.setVisibility(i);
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
        if ((this.jdField_a_of_type_Qms == null) || (this.jdField_a_of_type_Qms.jdField_v_of_type_AndroidViewViewGroup == null)) {
          continue;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.getLayoutParams();
        i = this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.getMeasuredHeight();
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
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new qsz(this, localLayoutParams, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new qta(this, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_Qms.jdField_v_of_type_AndroidViewViewGroup.setTag(2131362551, this.jdField_a_of_type_AndroidAnimationValueAnimator);
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
    if (this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = actn.a(26.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Qms.Q.setVisibility(8);
    this.jdField_a_of_type_Qms.w.setVisibility(8);
    this.jdField_a_of_type_Qms.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_Qms.x.setVisibility(8);
    localObject = this.jdField_a_of_type_Qms.g.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = actn.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = actn.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Qms.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_Qms.jdField_v_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Qms.jdField_v_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qms.Q.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = actn.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Qms.Q.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(VideoInfo paramVideoInfo, qms paramqms)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showNewShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qms = paramqms;
    for (;;)
    {
      try
      {
        if ((paramqms.jdField_t_of_type_AndroidViewViewGroup == null) && ((paramqms instanceof qmr)))
        {
          paramqms.jdField_t_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)paramqms.o.findViewById(2131378965)).inflate());
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setCornerRadius(actn.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject1).setColor(Color.parseColor("#E6FFFFFF"));
          paramqms.u = ((LinearLayout)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131378967));
          paramqms.u.setBackgroundDrawable((Drawable)localObject1);
          paramqms.u.setVisibility(0);
          paramqms.h = ((URLImageView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367489));
          paramqms.i = ((URLImageView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367488));
          paramqms.R = ((TextView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367487));
          paramqms.S = ((TextView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361963));
          paramqms.T = ((TextView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361960));
          paramqms.U = ((TextView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361962));
          paramqms.n = ((ImageView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361959));
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setCornerRadius(actn.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#12B7F5"));
          paramqms.jdField_a_of_type_AndroidWidgetButton = ((Button)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361958));
          paramqms.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject2);
          paramqms.b = ((ReadInjoyHeaderAdDownloadView)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367484));
          paramqms.jdField_v_of_type_AndroidViewViewGroup = ((ViewGroup)paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131361961));
          paramqms.jdField_v_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject1);
          paramqms.y = paramqms.jdField_t_of_type_AndroidViewViewGroup.findViewById(2131367490);
        }
        if (paramqms.jdField_t_of_type_AndroidViewViewGroup == null) {
          break;
        }
        paramqms.jdField_t_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject1 = "";
        if (a() != null) {
          localObject1 = a().a();
        }
        c();
        if (a() == 0)
        {
          a(paramqms.h, (String)localObject1, actn.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
          a(paramqms.i, (String)localObject1, actn.a(5.2F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 75, 1);
          paramqms.y.setVisibility(4);
          a(a(), paramqms);
          if (a() == null) {
            break label860;
          }
          str = a().b();
          i = a().a();
          localObject3 = a().a();
          localObject2 = a().c();
          localObject1 = a().d();
          paramqms.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
          paramqms.T.setText((CharSequence)localObject1);
          if (i == 0)
          {
            paramqms.T.setVisibility(0);
            paramqms.R.setText(str);
            paramqms.S.setText(str);
            paramqms.U.setText((CharSequence)localObject3);
            paramqms.jdField_t_of_type_AndroidViewViewGroup.setTag(paramqms);
            paramqms.jdField_t_of_type_AndroidViewViewGroup.setOnClickListener(this);
            paramqms.b.setTag(paramqms);
            paramqms.b.setOnClickListener(this);
            paramqms.n.setTag(paramqms);
            paramqms.n.setOnClickListener(this);
            paramqms.jdField_a_of_type_AndroidWidgetButton.setTag(paramqms);
            paramqms.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
            paramqms.u.setTag(paramqms);
            paramqms.u.setOnClickListener(this);
            paramqms.jdField_v_of_type_AndroidViewViewGroup.setTag(paramqms);
            paramqms.jdField_v_of_type_AndroidViewViewGroup.setOnClickListener(this);
            qol.a(paramqms.jdField_t_of_type_AndroidViewViewGroup, 200);
            if (a() == null) {
              break;
            }
            a().a(paramVideoInfo, paramqms);
            a().a(new qsy(this));
          }
        }
        else
        {
          a(paramqms.h, (String)localObject1, actn.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
          a(paramqms.i, (String)localObject1, actn.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
          paramqms.y.setVisibility(0);
          continue;
        }
        paramqms.T.setVisibility(4);
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
    if ((this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qms.jdField_v_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qms.u == null) || (this.jdField_a_of_type_Qms.h == null)) {
      return;
    }
    this.jdField_a_of_type_Qms.jdField_v_of_type_AndroidViewViewGroup.setVisibility(8);
    String str = "";
    if (a() != null) {
      str = a().a();
    }
    this.jdField_a_of_type_Qms.i.setVisibility(8);
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(actn.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    ((GradientDrawable)localObject).setColor(Color.parseColor("#E6FFFFFF"));
    this.jdField_a_of_type_Qms.u.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_Qms.u.setVisibility(0);
    localObject = this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = -2;
    ((ViewGroup.LayoutParams)localObject).width = -2;
    int i = actn.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.setPadding(0, i, 0, i);
    this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    a(this.jdField_a_of_type_Qms.h, str, actn.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
    a(this.jdField_a_of_type_Qms, true);
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup == null) || (a().b())) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    a(true, true);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.getLayoutParams();
    int j = this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.getMeasuredWidth();
    int k = this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.getMeasuredHeight();
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_Qms.g.getLayoutParams();
    int m = localLayoutParams1.width;
    int n = localLayoutParams1.height;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i1 = actn.a(41.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = actn.a(197.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = actn.a(33.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = this.jdField_a_of_type_Qms.jdField_v_of_type_AndroidViewView.getMeasuredWidth();
    if (a() == 1) {}
    for (int i = actn.a(123.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;; i = actn.a(140.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4)
    {
      ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_Qms.jdField_v_of_type_AndroidViewView.getLayoutParams();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new qtb(this, localLayoutParams, j, i2 - j, k, i1 - k, localLayoutParams1, m, i3 - n, n, localLayoutParams2, i4, i));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new qtc(this));
      this.jdField_a_of_type_Qms.jdField_t_of_type_AndroidViewViewGroup.setTag(2131362551, this.jdField_a_of_type_AndroidAnimationValueAnimator);
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
    if (this.jdField_a_of_type_Nzl != null) {
      this.jdField_a_of_type_Nzl.a();
    }
    if (this.jdField_a_of_type_Qtf != null) {
      this.jdField_a_of_type_Qtf.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (a() != null) {
      a().a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, qms paramqms)
  {
    ViewGroup.LayoutParams localLayoutParams = paramqms.jdField_v_of_type_AndroidViewViewGroup.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)paramqms.R.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramqms.i.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramqms.S.getLayoutParams();
    if (paramInt == 0)
    {
      paramqms.h.setPadding(0, 0, 0, 0);
      paramqms.i.setPadding(0, 0, 0, 0);
      localLayoutParams.height = actn.a(75.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = actn.a(246.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = actn.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = actn.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = actn.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = actn.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams3.topMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams3.topMargin = actn.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      paramqms.S.setLayoutParams(localLayoutParams3);
      paramqms.i.setLayoutParams(localLayoutParams2);
      paramqms.jdField_v_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      paramqms.R.setLayoutParams(localLayoutParams1);
      return;
      paramInt = actn.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramqms.h.setPadding(paramInt, paramInt, paramInt, paramInt);
      paramqms.i.setPadding(paramInt, paramInt, paramInt, paramInt);
      localLayoutParams.height = actn.a(68.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = actn.a(225.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = actn.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = actn.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = actn.a(-2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = actn.a(-3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
  }
  
  public void a(VideoInfo paramVideoInfo, qms paramqms, double paramDouble, long paramLong)
  {
    if (paramqms.d.getVisibility() == 0) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          if ((paramqms.jdField_t_of_type_AndroidViewViewGroup == null) || (paramqms.jdField_t_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
            break;
          }
        } while ((!this.jdField_a_of_type_Boolean) || (a() == null) || (!a().a(paramVideoInfo, paramqms, paramDouble, paramLong)));
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
        a(paramVideoInfo, paramqms);
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
    b(paramVideoInfo, paramqms);
  }
  
  public void a(qms paramqms)
  {
    if ((paramqms != null) && (paramqms.jdField_t_of_type_AndroidViewViewGroup != null))
    {
      paramqms.jdField_t_of_type_AndroidViewViewGroup.setVisibility(8);
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
      catch (Exception paramqms)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + paramqms.getMessage());
      }
    }
  }
  
  public void a(qms paramqms1, qms paramqms2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    a(paramqms1);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramqms2.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Qte = null;
  }
  
  public void a(qms paramqms, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {}
    while ((a() == null) || (paramqms == null)) {
      return;
    }
    a(paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramqms, paramDouble, paramLong);
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
 * Qualified Name:     qsx
 * JD-Core Version:    0.7.0.1
 */