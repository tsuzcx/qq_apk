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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;

public class snz
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private soc jdField_a_of_type_Soc;
  private sod jdField_a_of_type_Sod;
  private swu jdField_a_of_type_Swu;
  private uiy jdField_a_of_type_Uiy;
  private boolean jdField_a_of_type_Boolean;
  private VideoInfo b;
  
  public snz(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Int = AIOUtils.dp2px(2.0F, paramActivity.getResources());
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Uiy = new uiy();
    this.jdField_a_of_type_Uiy.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
    this.jdField_a_of_type_Sod = new sod();
    this.jdField_a_of_type_Sod.a(paramQQAppInterface, paramActivity, paramVideoFeedsRecyclerView);
  }
  
  private soc a()
  {
    if (this.jdField_a_of_type_Soc != null) {
      return this.jdField_a_of_type_Soc;
    }
    if ((this.b.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_a_of_type_Sod.a(this.b))) {}
    for (this.jdField_a_of_type_Soc = this.jdField_a_of_type_Sod;; this.jdField_a_of_type_Soc = this.jdField_a_of_type_Uiy) {
      do
      {
        if (this.jdField_a_of_type_Soc != null) {
          this.jdField_a_of_type_Soc.a(this.b);
        }
        return this.jdField_a_of_type_Soc;
      } while ((this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType != 2));
    }
  }
  
  private void a(VideoInfo paramVideoInfo, swu paramswu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showSamleGameShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Swu = paramswu;
    try
    {
      Object localObject;
      if ((paramswu.jdField_w_of_type_AndroidViewViewGroup == null) && ((paramswu instanceof swr)))
      {
        paramswu.jdField_w_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)((ViewGroup)((ViewStub)paramswu.jdField_n_of_type_AndroidViewViewGroup.findViewById(2131380888)).inflate()).findViewById(2131381032)).inflate());
        int i = AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        paramswu.jdField_w_of_type_AndroidViewViewGroup.setPadding(i, i, i, i);
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#99242424"));
        paramswu.jdField_w_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
        paramswu.g = ((URLImageView)paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131368169));
        paramswu.I = ((TextView)paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131368176));
        paramswu.J = ((TextView)paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131368175));
        paramswu.s = paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131370343);
        paramswu.t = paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131368174);
        paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView = ((ReadInjoyHeaderAdDownloadView)paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131368166));
        paramswu.jdField_u_of_type_AndroidViewView = paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131368168);
        paramswu.K = ((TextView)paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131367515));
        paramswu.jdField_v_of_type_AndroidViewView = paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131367529);
        paramswu.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131362117));
        paramswu.e = ((LinearLayout)paramswu.jdField_w_of_type_AndroidViewViewGroup.findViewById(2131380892));
      }
      if ((paramswu.jdField_w_of_type_AndroidViewViewGroup != null) && (paramswu.g != null) && (paramswu.I != null) && (paramswu.J != null) && (paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView != null) && (paramswu.t != null))
      {
        paramswu.jdField_w_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject = "";
        if (a() != null) {
          localObject = a().a();
        }
        a(paramswu.g, (String)localObject, this.jdField_a_of_type_Int, 18, -1);
        String str = "";
        localObject = str;
        if (a() != null)
        {
          localObject = str;
          if (a().b() != null) {
            localObject = a().b();
          }
        }
        paramswu.I.setText((CharSequence)localObject);
        paramswu.I.setVisibility(0);
        paramswu.g.setVisibility(0);
        localObject = "";
        if (a() != null) {
          localObject = a().a();
        }
        paramswu.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(paramswu);
        paramswu.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
        paramswu.J.setText((CharSequence)localObject);
        paramswu.jdField_w_of_type_AndroidViewViewGroup.setTag(paramswu);
        paramswu.jdField_w_of_type_AndroidViewViewGroup.setOnClickListener(this);
        paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setTag(paramswu);
        paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setOnClickListener(this);
        paramswu.t.setTag(paramswu);
        paramswu.t.setOnClickListener(this);
        six.a(paramswu.jdField_w_of_type_AndroidViewViewGroup, 200);
        if ((a() != null) && (!TextUtils.isEmpty(a().c())) && (paramswu.K != null)) {
          paramswu.K.setText(a().c());
        }
        if (a() != null) {
          a().a(paramVideoInfo, paramswu);
        }
      }
      return;
    }
    catch (Throwable paramVideoInfo)
    {
      QLog.e("VideoFeedsSoftAdBarController", 2, "show shunt bar error:" + paramVideoInfo.getMessage());
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
          localURLDrawable.setTag(bgxc.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(bgxc.k);
        }
        catch (Exception paramURLImageView)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(bgxc.j);
          continue;
        }
        paramURLImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(bgxc.k);
      }
    }
  }
  
  private void a(swu paramswu, boolean paramBoolean)
  {
    int j = 0;
    boolean bool = bmhv.d();
    Object localObject;
    if ((!bool) && (paramswu.i != null))
    {
      localObject = paramswu.i;
      if (paramBoolean)
      {
        i = 0;
        ((ViewGroup)localObject).setVisibility(i);
      }
    }
    else
    {
      if (paramswu.jdField_v_of_type_AndroidWidgetTextView != null)
      {
        localObject = paramswu.jdField_v_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label143;
        }
        i = 0;
        label57:
        ((TextView)localObject).setVisibility(i);
      }
      if ((bool) && (paramswu.jdField_w_of_type_AndroidViewView != null) && (paramswu.jdField_w_of_type_AndroidViewView.findViewById(2131368129) != null))
      {
        localObject = paramswu.jdField_w_of_type_AndroidViewView.findViewById(2131368129);
        if (!paramBoolean) {
          break label149;
        }
        i = 0;
        label106:
        ((View)localObject).setVisibility(i);
      }
      if (paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
      {
        paramswu = paramswu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
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
      paramswu.setVisibility(i);
      return;
      i = 8;
      break;
      i = 8;
      break label57;
      i = 8;
      break label106;
    }
  }
  
  private void b(VideoInfo paramVideoInfo, swu paramswu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsSoftAdBarController", 2, "showSoftAdShuntBar");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Swu = paramswu;
    try
    {
      Object localObject;
      if ((paramswu.x == null) && ((paramswu instanceof swr)))
      {
        paramswu.x = ((ViewGroup)((ViewStub)((ViewGroup)((ViewStub)paramswu.jdField_n_of_type_AndroidViewViewGroup.findViewById(2131380888)).inflate()).findViewById(2131381033)).inflate());
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#E6FFFFFF"));
        paramswu.jdField_u_of_type_AndroidViewViewGroup = ((LinearLayout)paramswu.x.findViewById(2131380893));
        paramswu.jdField_u_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
        paramswu.jdField_u_of_type_AndroidViewViewGroup.setVisibility(0);
        paramswu.h = ((URLImageView)paramswu.x.findViewById(2131368172));
        paramswu.L = ((TextView)paramswu.x.findViewById(2131362026));
        paramswu.M = ((TextView)paramswu.x.findViewById(2131362024));
        paramswu.N = ((TextView)paramswu.x.findViewById(2131362025));
        paramswu.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)paramswu.x.findViewById(2131362021));
        paramswu.jdField_v_of_type_AndroidViewViewGroup = ((ViewGroup)paramswu.x.findViewById(2131362023));
        paramswu.e = ((LinearLayout)paramswu.x.findViewById(2131380892));
        paramswu.c = ((RIJDownloadView)paramswu.x.findViewById(2131362059));
      }
      if ((paramswu.c != null) && (this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
      {
        ukq.a("AD_DOWNLOAD_TAG", "setAdvertisementInfo: videoTitle = " + this.b.c);
        paramswu.c.setAdvertisementInfo(this.b.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        paramswu.c.setDownloadScene(AdDownloadScene.SoftButton);
        paramswu.c.setActivity(new SoftReference(this.jdField_a_of_type_AndroidAppActivity));
        paramswu.c.setProgressStyle(RoundProgressStyle.VideoSoftAd);
        paramswu.c.setOnClickListener(this);
        paramswu.c.a(true);
      }
      if (paramswu.x != null)
      {
        paramswu.x.setVisibility(0);
        localObject = "";
        if (a() != null) {
          localObject = a().a();
        }
        e();
        if ((a() instanceof uiy)) {
          this.jdField_a_of_type_Uiy.a(paramswu);
        }
        a(paramswu.h, (String)localObject, AIOUtils.dp2px(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 40, -1);
        String str = "";
        localObject = "";
        if (a() != null)
        {
          str = a().b();
          a().a();
          localObject = a().a();
          a().c();
          a().d();
        }
        paramswu.L.setText(str);
        paramswu.M.setText((CharSequence)localObject);
        paramswu.x.setTag(paramswu);
        paramswu.x.setOnClickListener(this);
        paramswu.jdField_n_of_type_AndroidWidgetImageView.setTag(paramswu);
        paramswu.jdField_n_of_type_AndroidWidgetImageView.setOnClickListener(this);
        paramswu.c.setTag(paramswu);
        paramswu.jdField_u_of_type_AndroidViewViewGroup.setTag(paramswu);
        paramswu.jdField_u_of_type_AndroidViewViewGroup.setOnClickListener(this);
        paramswu.jdField_v_of_type_AndroidViewViewGroup.setTag(paramswu);
        paramswu.jdField_v_of_type_AndroidViewViewGroup.setOnClickListener(this);
        six.a(paramswu.x, 200);
        if (a() != null)
        {
          a().a(paramVideoInfo, paramswu);
          a().a(new soa(this, paramswu));
        }
      }
      return;
    }
    catch (Throwable paramVideoInfo)
    {
      QLog.d("VideoFeedsSoftAdBarController", 2, "后台下发的url格式有问题：" + paramVideoInfo.getMessage());
    }
  }
  
  private void b(VideoInfo paramVideoInfo, swu paramswu, double paramDouble, long paramLong)
  {
    if ((paramswu.jdField_w_of_type_AndroidViewViewGroup != null) && (paramswu.jdField_w_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
      if ((this.jdField_a_of_type_Boolean) && (a() != null) && (a().a(paramVideoInfo, paramswu, paramDouble, paramLong))) {
        this.jdField_a_of_type_Sod.a(this.jdField_a_of_type_Int);
      }
    }
    while ((paramVideoInfo == null) || (a() == null) || (!a().a()) || (!a().a(paramVideoInfo))) {
      return;
    }
    a(paramVideoInfo, paramswu);
  }
  
  private void c(VideoInfo paramVideoInfo, swu paramswu, double paramDouble, long paramLong)
  {
    if ((paramswu.x != null) && (paramswu.x.getVisibility() == 0)) {}
    for (;;)
    {
      return;
      if ((paramVideoInfo == null) || (a() == null) || (!a().a()) || (!a().a(paramVideoInfo))) {
        continue;
      }
      paramDouble = paramLong / 1000L * paramDouble / 100.0D;
      int j = 0;
      int i = j;
      if (paramVideoInfo != null)
      {
        i = j;
        if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
        {
          i = j;
          if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
          {
            i = j;
            if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.C == null) {}
          }
        }
      }
      try
      {
        i = Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.C).intValue();
        if ((paramDouble == 0.0D) || (paramDouble <= i)) {
          continue;
        }
        b(paramVideoInfo, paramswu);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.d("VideoFeedsSoftAdBarController", 2, "smallCardShowTime Format error");
          i = j;
        }
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Swu.jdField_w_of_type_AndroidViewViewGroup == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Swu.jdField_w_of_type_AndroidViewViewGroup.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.dp2px(26.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Swu.jdField_w_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Swu.J.setVisibility(8);
    this.jdField_a_of_type_Swu.t.setVisibility(8);
    this.jdField_a_of_type_Swu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyHeaderAdDownloadView.setVisibility(8);
    this.jdField_a_of_type_Swu.jdField_u_of_type_AndroidViewView.setVisibility(8);
    localObject = this.jdField_a_of_type_Swu.g.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = AIOUtils.dp2px(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.dp2px(18.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Swu.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_Swu.s.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -2;
    this.jdField_a_of_type_Swu.s.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_Swu.J.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.dp2px(1.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Swu.J.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Swu.K.setVisibility(8);
    this.jdField_a_of_type_Swu.jdField_v_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Swu.x == null) || (this.jdField_a_of_type_Swu.jdField_v_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Swu.jdField_u_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Swu.h == null)) {
      return;
    }
    this.jdField_a_of_type_Swu.jdField_v_of_type_AndroidViewViewGroup.setVisibility(8);
    a(this.jdField_a_of_type_Swu, true);
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
    if (this.jdField_a_of_type_Uiy != null) {
      this.jdField_a_of_type_Uiy.b();
    }
    if (this.jdField_a_of_type_Sod != null) {
      this.jdField_a_of_type_Sod.b();
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    if (this.jdField_a_of_type_Uiy != null) {
      this.jdField_a_of_type_Uiy.b(paramVideoInfo);
    }
    if (this.jdField_a_of_type_Sod != null) {
      this.jdField_a_of_type_Sod.b(paramVideoInfo);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, swu paramswu, double paramDouble, long paramLong)
  {
    if (paramswu.d.getVisibility() == 0) {}
    while ((paramVideoInfo != null) && (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    try
    {
      if (a() == 3)
      {
        b(paramVideoInfo, paramswu, paramDouble, paramLong);
        return;
      }
    }
    catch (Throwable paramVideoInfo)
    {
      QLog.d("VideoFeedsSoftAdBarController", 2, "tryToShowShuntBar error");
      return;
    }
    c(paramVideoInfo, paramswu, paramDouble, paramLong);
  }
  
  public void a(swu paramswu)
  {
    if ((paramswu != null) && (paramswu.x != null))
    {
      paramswu.x.setVisibility(8);
      if ((a() instanceof uiy)) {
        ((uiy)a()).jdField_a_of_type_Boolean = false;
      }
    }
    try
    {
      e();
      if ((paramswu != null) && (paramswu.jdField_w_of_type_AndroidViewViewGroup != null))
      {
        paramswu.jdField_w_of_type_AndroidViewViewGroup.setVisibility(8);
        if ((a() instanceof uiy)) {
          ((uiy)a()).jdField_a_of_type_Boolean = false;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          d();
          return;
        }
        catch (Exception paramswu)
        {
          QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + paramswu.getMessage());
        }
        localException = localException;
        QLog.d("VideoFeedsSoftAdBarController", 2, "reset ex:" + localException.getMessage());
      }
    }
  }
  
  public void a(swu paramswu1, swu paramswu2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Sod.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Sod.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_Sod.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_Sod.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_Sod.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    a(paramswu1);
    if (this.jdField_a_of_type_Soc != null) {
      this.jdField_a_of_type_Soc.a();
    }
    this.b = paramswu2.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    this.jdField_a_of_type_Soc = null;
  }
  
  public void a(swu paramswu, boolean paramBoolean, double paramDouble, long paramLong)
  {
    if (paramBoolean) {}
    do
    {
      do
      {
        return;
      } while ((a() == null) || (paramswu == null));
      a().a((paramLong * paramDouble));
    } while (((a() instanceof uiy)) && (((uiy)a()).jdField_a_of_type_Boolean));
    a(paramswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramswu, paramDouble, paramLong);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Uiy != null) {
      this.jdField_a_of_type_Uiy.c();
    }
    if (this.jdField_a_of_type_Sod != null) {
      this.jdField_a_of_type_Sod.c();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Uiy != null) {
      this.jdField_a_of_type_Uiy.d();
    }
    if (this.jdField_a_of_type_Sod != null) {
      this.jdField_a_of_type_Sod.d();
    }
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
 * Qualified Name:     snz
 * JD-Core Version:    0.7.0.1
 */