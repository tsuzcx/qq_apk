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

public class rig
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ocs jdField_a_of_type_Ocs;
  private rbt jdField_a_of_type_Rbt;
  private rin jdField_a_of_type_Rin;
  private rio jdField_a_of_type_Rio;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public rig(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Int = aekt.a(2.0F, paramActivity.getResources());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Ocs = new ocs();
    this.jdField_a_of_type_Ocs.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Rio = new rio();
    this.jdField_a_of_type_Rio.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private rin a()
  {
    if (this.jdField_a_of_type_Rin != null) {
      return this.jdField_a_of_type_Rin;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_a_of_type_Rio.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))) {}
    for (this.jdField_a_of_type_Rin = this.jdField_a_of_type_Rio;; this.jdField_a_of_type_Rin = this.jdField_a_of_type_Ocs) {
      do
      {
        if (this.jdField_a_of_type_Rin != null) {
          this.jdField_a_of_type_Rin.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        }
        return this.jdField_a_of_type_Rin;
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType != 2));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, rbt paramrbt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rbt = paramrbt;
    Object localObject;
    if ((paramrbt.u == null) && ((paramrbt instanceof rbs)))
    {
      paramrbt.u = ((ViewGroup)((ViewStub)((rbs)paramrbt).p.findViewById(2131379627)).inflate());
      int i = aekt.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrbt.u.setPadding(i, i, i, i);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(aekt.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
      paramrbt.u.setBackgroundDrawable((Drawable)localObject);
      paramrbt.h = ((URLImageView)paramrbt.u.findViewById(2131367614));
      paramrbt.P = ((TextView)paramrbt.u.findViewById(2131367621));
      paramrbt.Q = ((TextView)paramrbt.u.findViewById(2131367620));
      paramrbt.jdField_v_of_type_AndroidViewView = paramrbt.u.findViewById(2131369651);
      paramrbt.jdField_w_of_type_AndroidViewView = paramrbt.u.findViewById(2131367619);
      paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramrbt.u.findViewById(2131367611));
      paramrbt.x = paramrbt.u.findViewById(2131367613);
    }
    if (paramrbt.u != null)
    {
      paramrbt.u.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      a(paramrbt.h, (String)localObject, this.jdField_a_of_type_Int, 18, -1);
      localObject = "";
      if (a() != null) {
        localObject = a().b();
      }
      paramrbt.P.setText((CharSequence)localObject);
      paramrbt.P.setVisibility(0);
      paramrbt.h.setVisibility(0);
      localObject = "";
      if (a() != null) {
        localObject = a().a();
      }
      paramrbt.Q.setText((CharSequence)localObject);
      paramrbt.u.setTag(paramrbt);
      paramrbt.u.setOnClickListener(this);
      paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setTag(paramrbt);
      paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
      paramrbt.jdField_w_of_type_AndroidViewView.setTag(paramrbt);
      paramrbt.jdField_w_of_type_AndroidViewView.setOnClickListener(this);
      rdm.a(paramrbt.u, 200);
      if (a() != null) {
        a().a(paramVideoInfo, paramrbt);
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
          localURLDrawableOptions.mRequestWidth = aekt.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawableOptions.mRequestHeight = aekt.a(paramInt2, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localURLDrawable.setTag(bcuq.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(bcuq.j);
        }
        catch (Exception paramURLImageView)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(bcuq.i);
          continue;
        }
        paramURLImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(bcuq.j);
      }
    }
  }
  
  private void a(rbt paramrbt, boolean paramBoolean)
  {
    int k = 0;
    int j;
    if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1)
    {
      i = 1;
      Object localObject;
      if ((i == 0) && (paramrbt.l != null))
      {
        localObject = paramrbt.l;
        if (!paramBoolean) {
          break label158;
        }
        j = 0;
        label46:
        ((ViewGroup)localObject).setVisibility(j);
      }
      if (paramrbt.B != null)
      {
        localObject = paramrbt.B;
        if (!paramBoolean) {
          break label165;
        }
        j = 0;
        label73:
        ((TextView)localObject).setVisibility(j);
      }
      if ((i != 0) && (paramrbt.t != null) && (paramrbt.t.findViewById(2131367567) != null))
      {
        localObject = paramrbt.t.findViewById(2131367567);
        if (!paramBoolean) {
          break label172;
        }
        i = 0;
        label122:
        ((View)localObject).setVisibility(i);
      }
      if (paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
      {
        paramrbt = paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
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
      paramrbt.setVisibility(i);
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
        if ((this.jdField_a_of_type_Rbt == null) || (this.jdField_a_of_type_Rbt.jdField_w_of_type_AndroidViewViewGroup == null)) {
          continue;
        }
        localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rbt.u.getLayoutParams();
        i = this.jdField_a_of_type_Rbt.u.getMeasuredHeight();
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
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new rii(this, localLayoutParams, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new rij(this, paramBoolean1, paramBoolean2));
      this.jdField_a_of_type_Rbt.jdField_w_of_type_AndroidViewViewGroup.setTag(2131362578, this.jdField_a_of_type_AndroidAnimationValueAnimator);
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
    if (this.jdField_a_of_type_Rbt.u == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Rbt.u.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = aekt.a(26.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Rbt.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Rbt.Q.setVisibility(8);
    this.jdField_a_of_type_Rbt.jdField_w_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Rbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_Rbt.x.setVisibility(8);
    localObject = this.jdField_a_of_type_Rbt.h.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = aekt.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = aekt.a(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rbt.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_Rbt.jdField_v_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Rbt.jdField_v_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rbt.Q.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = aekt.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rbt.Q.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(VideoInfo paramVideoInfo, rbt paramrbt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showNewShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rbt = paramrbt;
    for (;;)
    {
      try
      {
        if ((paramrbt.u == null) && ((paramrbt instanceof rbs)))
        {
          paramrbt.u = ((ViewGroup)((ViewStub)paramrbt.p.findViewById(2131379627)).inflate());
          localObject1 = new GradientDrawable();
          ((GradientDrawable)localObject1).setCornerRadius(aekt.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject1).setColor(Color.parseColor("#E6FFFFFF"));
          paramrbt.jdField_v_of_type_AndroidViewViewGroup = ((LinearLayout)paramrbt.u.findViewById(2131379629));
          paramrbt.jdField_v_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject1);
          paramrbt.jdField_v_of_type_AndroidViewViewGroup.setVisibility(0);
          paramrbt.i = ((URLImageView)paramrbt.u.findViewById(2131367617));
          paramrbt.j = ((URLImageView)paramrbt.u.findViewById(2131367616));
          paramrbt.R = ((TextView)paramrbt.u.findViewById(2131367615));
          paramrbt.S = ((TextView)paramrbt.u.findViewById(2131361964));
          paramrbt.T = ((TextView)paramrbt.u.findViewById(2131361961));
          paramrbt.U = ((TextView)paramrbt.u.findViewById(2131361963));
          paramrbt.m = ((ImageView)paramrbt.u.findViewById(2131361960));
          localObject2 = new GradientDrawable();
          ((GradientDrawable)localObject2).setCornerRadius(aekt.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject2).setColor(Color.parseColor("#12B7F5"));
          paramrbt.jdField_a_of_type_AndroidWidgetButton = ((Button)paramrbt.u.findViewById(2131361959));
          paramrbt.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable((Drawable)localObject2);
          paramrbt.b = ((ReadInjoyHeaderAdDownloadView)paramrbt.u.findViewById(2131367612));
          paramrbt.jdField_w_of_type_AndroidViewViewGroup = ((ViewGroup)paramrbt.u.findViewById(2131361962));
          paramrbt.jdField_w_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject1);
          paramrbt.y = paramrbt.u.findViewById(2131367618);
        }
        if (paramrbt.u == null) {
          break;
        }
        paramrbt.u.setVisibility(0);
        localObject1 = "";
        if (a() != null) {
          localObject1 = a().a();
        }
        c();
        if (a() == 0)
        {
          a(paramrbt.i, (String)localObject1, aekt.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
          a(paramrbt.j, (String)localObject1, aekt.a(5.2F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 75, 1);
          paramrbt.y.setVisibility(4);
          a(a(), paramrbt);
          if (a() == null) {
            break label860;
          }
          str = a().b();
          i = a().a();
          localObject3 = a().a();
          localObject2 = a().c();
          localObject1 = a().d();
          paramrbt.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
          paramrbt.T.setText((CharSequence)localObject1);
          if (i == 0)
          {
            paramrbt.T.setVisibility(0);
            paramrbt.R.setText(str);
            paramrbt.S.setText(str);
            paramrbt.U.setText((CharSequence)localObject3);
            paramrbt.u.setTag(paramrbt);
            paramrbt.u.setOnClickListener(this);
            paramrbt.b.setTag(paramrbt);
            paramrbt.b.setOnClickListener(this);
            paramrbt.m.setTag(paramrbt);
            paramrbt.m.setOnClickListener(this);
            paramrbt.jdField_a_of_type_AndroidWidgetButton.setTag(paramrbt);
            paramrbt.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
            paramrbt.jdField_v_of_type_AndroidViewViewGroup.setTag(paramrbt);
            paramrbt.jdField_v_of_type_AndroidViewViewGroup.setOnClickListener(this);
            paramrbt.jdField_w_of_type_AndroidViewViewGroup.setTag(paramrbt);
            paramrbt.jdField_w_of_type_AndroidViewViewGroup.setOnClickListener(this);
            rdm.a(paramrbt.u, 200);
            if (a() == null) {
              break;
            }
            a().a(paramVideoInfo, paramrbt);
            a().a(new rih(this));
          }
        }
        else
        {
          a(paramrbt.i, (String)localObject1, aekt.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
          a(paramrbt.j, (String)localObject1, aekt.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, -1);
          paramrbt.y.setVisibility(0);
          continue;
        }
        paramrbt.T.setVisibility(4);
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
    if ((this.jdField_a_of_type_Rbt.u == null) || (this.jdField_a_of_type_Rbt.jdField_w_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rbt.jdField_v_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rbt.i == null)) {
      return;
    }
    this.jdField_a_of_type_Rbt.jdField_w_of_type_AndroidViewViewGroup.setVisibility(8);
    String str = "";
    if (a() != null) {
      str = a().a();
    }
    this.jdField_a_of_type_Rbt.j.setVisibility(8);
    Object localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(aekt.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    ((GradientDrawable)localObject).setColor(Color.parseColor("#E6FFFFFF"));
    this.jdField_a_of_type_Rbt.jdField_v_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_Rbt.jdField_v_of_type_AndroidViewViewGroup.setVisibility(0);
    localObject = this.jdField_a_of_type_Rbt.u.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = -2;
    ((ViewGroup.LayoutParams)localObject).width = -2;
    int i = aekt.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Rbt.u.setPadding(0, i, 0, i);
    this.jdField_a_of_type_Rbt.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
    a(this.jdField_a_of_type_Rbt.i, str, aekt.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 72, 0);
    a(this.jdField_a_of_type_Rbt, true);
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Rbt.u == null) || (a().b())) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    a(true, true);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Rbt.u == null) || (this.jdField_a_of_type_Rbt.u.getVisibility() != 0)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rbt.u.getLayoutParams();
    int j = this.jdField_a_of_type_Rbt.u.getMeasuredWidth();
    int k = this.jdField_a_of_type_Rbt.u.getMeasuredHeight();
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_Rbt.h.getLayoutParams();
    int m = localLayoutParams1.width;
    int n = localLayoutParams1.height;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i1 = aekt.a(41.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = aekt.a(197.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = aekt.a(33.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i4 = this.jdField_a_of_type_Rbt.jdField_v_of_type_AndroidViewView.getMeasuredWidth();
    if (a() == 1) {}
    for (int i = aekt.a(123.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4;; i = aekt.a(140.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()) - i4)
    {
      ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_Rbt.jdField_v_of_type_AndroidViewView.getLayoutParams();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new rik(this, localLayoutParams, j, i2 - j, k, i1 - k, localLayoutParams1, m, i3 - n, n, localLayoutParams2, i4, i));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ril(this));
      this.jdField_a_of_type_Rbt.u.setTag(2131362578, this.jdField_a_of_type_AndroidAnimationValueAnimator);
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
    if (this.jdField_a_of_type_Ocs != null) {
      this.jdField_a_of_type_Ocs.a();
    }
    if (this.jdField_a_of_type_Rio != null) {
      this.jdField_a_of_type_Rio.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (a() != null) {
      a().a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, rbt paramrbt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramrbt.jdField_w_of_type_AndroidViewViewGroup.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)paramrbt.R.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramrbt.j.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramrbt.S.getLayoutParams();
    if (paramInt == 0)
    {
      paramrbt.i.setPadding(0, 0, 0, 0);
      paramrbt.j.setPadding(0, 0, 0, 0);
      localLayoutParams.height = aekt.a(75.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = aekt.a(246.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = aekt.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = aekt.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = aekt.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = aekt.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams3.topMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams3.topMargin = aekt.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      paramrbt.S.setLayoutParams(localLayoutParams3);
      paramrbt.j.setLayoutParams(localLayoutParams2);
      paramrbt.jdField_w_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      paramrbt.R.setLayoutParams(localLayoutParams1);
      return;
      paramInt = aekt.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      paramrbt.i.setPadding(paramInt, paramInt, paramInt, paramInt);
      paramrbt.j.setPadding(paramInt, paramInt, paramInt, paramInt);
      localLayoutParams.height = aekt.a(68.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = aekt.a(225.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.topMargin = aekt.a(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams1.bottomMargin = aekt.a(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.rightMargin = aekt.a(-2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams2.leftMargin = aekt.a(-3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
  }
  
  public void a(VideoInfo paramVideoInfo, rbt paramrbt, double paramDouble, long paramLong)
  {
    if (paramrbt.d.getVisibility() == 0) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          if ((paramrbt.u == null) || (paramrbt.u.getVisibility() != 0)) {
            break;
          }
        } while ((!this.jdField_a_of_type_Boolean) || (a() == null) || (!a().a(paramVideoInfo, paramrbt, paramDouble, paramLong)));
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
        a(paramVideoInfo, paramrbt);
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
    b(paramVideoInfo, paramrbt);
  }
  
  public void a(rbt paramrbt)
  {
    if ((paramrbt != null) && (paramrbt.u != null))
    {
      paramrbt.u.setVisibility(8);
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
      catch (Exception paramrbt)
      {
        QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + paramrbt.getMessage());
      }
    }
  }
  
  public void a(rbt paramrbt1, rbt paramrbt2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    a(paramrbt1);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramrbt2.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Rin = null;
  }
  
  public void a(rbt paramrbt, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {}
    while ((a() == null) || (paramrbt == null)) {
      return;
    }
    a(paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramrbt, paramDouble, paramLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rig
 * JD-Core Version:    0.7.0.1
 */