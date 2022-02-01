import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class sod
  implements soc
{
  public static final String a;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = 2147483647;
  public ValueAnimator a;
  Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private swu jdField_a_of_type_Swu;
  public boolean a;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = sod.class.getSimpleName();
  }
  
  private void a(Context paramContext, VideoInfo paramVideoInfo)
  {
    rqg localrqg;
    int i;
    if ((paramVideoInfo != null) && (paramContext != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge != null))
    {
      a(paramContext, paramVideoInfo, this.jdField_a_of_type_Swu, 1);
      MiniAppLauncher.startMiniApp(paramContext, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge.k, 2103, null);
      localrqg = new rqg();
      localrqg.e = (paramVideoInfo.a() * 1000);
      localrqg.d = ((int)(localrqg.e * this.jdField_a_of_type_Double));
      localrqg.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
        break label153;
      }
    }
    label153:
    for (paramContext = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; paramContext = "")
    {
      omx.b(paramVideoInfo, i, 25, -1, localrqg, paramContext);
      return;
    }
  }
  
  private void a(Context paramContext, VideoInfo paramVideoInfo, swu paramswu, int paramInt)
  {
    String str1;
    long l1;
    long l2;
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge != null) && (this.jdField_a_of_type_JavaUtilSet != null) && (paramswu != null))
    {
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge.j;
      if (paramInt != 1) {
        break label167;
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label159;
      }
      l1 = 5040504L;
      l2 = 3L;
    }
    for (;;)
    {
      label67:
      ois.a(paramContext, new ogz().a(504L).b(50405L).c(l1).d(str1).d(l2).a(paramVideoInfo.g).b(paramVideoInfo.c).i(String.valueOf(paramswu.jdField_b_of_type_Int)).c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge.o).g(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge.k).a());
      label159:
      label167:
      label237:
      do
      {
        String str2;
        do
        {
          return;
          l1 = 5040502L;
          break;
          l2 = 6L;
          if (!this.jdField_b_of_type_Boolean) {
            break label237;
          }
          str2 = paramVideoInfo.jdField_a_of_type_JavaLangString + "_B";
        } while (this.jdField_a_of_type_JavaUtilSet.contains(str2));
        l1 = 5040503L;
        this.jdField_a_of_type_JavaUtilSet.add(str2);
        break label67;
      } while (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
      l1 = 5040501L;
      this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, "后台下发的url格式有问题：" + paramString);
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
  
  private boolean b()
  {
    return (this.c) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_Int);
  }
  
  private boolean c()
  {
    return (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge.o));
  }
  
  public int a()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.e)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "soft ad small game");
      return 3;
    }
    return 0;
  }
  
  public CharSequence a()
  {
    if (a() == 3) {
      return uks.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_Int, "人在玩");
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_JavaLangString;
  }
  
  public String a()
  {
    if ((a() == 3) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge != null)) {
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge.l;
    }
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.d;
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public void a(double paramDouble)
  {
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Swu.w == null) || (this.jdField_a_of_type_Swu.w.getVisibility() != 0)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_Swu.w.getLayoutParams();
    int i = this.jdField_a_of_type_Swu.w.getMeasuredWidth();
    int j = this.jdField_a_of_type_Swu.w.getMeasuredHeight();
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_Swu.g.getLayoutParams();
    int k = localLayoutParams1.width;
    int m = localLayoutParams1.height;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int n = AIOUtils.dp2px(41.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i1 = AIOUtils.dp2px(197.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i2 = AIOUtils.dp2px(33.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    int i3 = this.jdField_a_of_type_Swu.s.getMeasuredWidth();
    int i4 = AIOUtils.dp2px(115.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_Swu.s.getLayoutParams();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new soe(this, localLayoutParams, i, i1 - i, j, n - j, localLayoutParams1, k, i2 - m, m, localLayoutParams2, i3, i4 - i3));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new sof(this, paramInt));
    this.jdField_a_of_type_Swu.w.setTag(2131362716, this.jdField_a_of_type_AndroidAnimationValueAnimator);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(VideoInfo paramVideoInfo, swu paramswu)
  {
    this.jdField_b_of_type_Int += 1;
    a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo, paramswu, 2);
    this.jdField_a_of_type_Swu = paramswu;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((TextUtils.isEmpty(bmhv.a("sp_key_ad_soft_total_area"))) || ("1".equals(bmhv.a("sp_key_ad_soft_total_area")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      this.jdField_a_of_type_Int = oix.a(bmhv.a("sp_key_ad_soft_kd_max"), 2147483647);
      this.jdField_b_of_type_Int = six.a(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate() mConfigIsOpen = " + this.c + ", mConfigMaxShowCount = " + this.jdField_a_of_type_Int + ", mTodayShowCount = " + this.jdField_b_of_type_Int);
      }
      return;
    }
  }
  
  public void a(sob paramsob) {}
  
  public void a(swu paramswu)
  {
    paramswu.J.setVisibility(0);
    paramswu.t.setVisibility(0);
    if ((a() == 3) && (paramswu.v != null) && (paramswu.K != null))
    {
      paramswu.v.setVisibility(0);
      paramswu.K.setVisibility(0);
      paramswu.t.setVisibility(8);
    }
    this.jdField_b_of_type_Boolean = true;
    a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo, paramswu, 2);
  }
  
  public boolean a()
  {
    return ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null)) || (c());
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return b();
  }
  
  public boolean a(VideoInfo paramVideoInfo, swu paramswu, double paramDouble, long paramLong)
  {
    int i = Aladdin.getConfig(318).getIntegerFromString("small_game_change_bigger_position", 30);
    if ((paramswu.w != null) && (paramswu.w.getVisibility() == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null))
    {
      if (a() == 3) {}
      while (paramDouble > i)
      {
        return true;
        i = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Int;
      }
    }
    return false;
  }
  
  public String b()
  {
    if (a() == 3) {
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge.o;
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Swu != null) && (this.jdField_a_of_type_Swu.c != null)) {
      this.jdField_a_of_type_Swu.c.a();
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void b(swu paramswu) {}
  
  public String c()
  {
    if ((a() == 3) && (c())) {
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Uge.n;
    }
    return "";
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Swu != null) && (this.jdField_a_of_type_Swu.c != null)) {
      this.jdField_a_of_type_Swu.c.b();
    }
  }
  
  public void c(swu paramswu) {}
  
  public String d()
  {
    return "";
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Int != 0) {
      six.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy() mTodayShowCount = " + this.jdField_b_of_type_Int);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (a() == 3) {
      a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
    }
    six.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
    paramView = new suu("", "", this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).i(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo);
    olh.b(null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.j, "0X800A2F7", "0X800A2F7", 0, 0, "0", "", "", paramView.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sod
 * JD-Core Version:    0.7.0.1
 */