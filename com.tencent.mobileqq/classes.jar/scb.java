import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class scb
  implements sca
{
  public static final String a;
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = 2147483647;
  Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private rvv jdField_a_of_type_Rvv;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = scb.class.getSimpleName();
  }
  
  private void a(Context paramContext, VideoInfo paramVideoInfo)
  {
    rdz localrdz;
    int i;
    if ((paramVideoInfo != null) && (paramContext != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt != null))
    {
      a(paramContext, paramVideoInfo, this.jdField_a_of_type_Rvv, obb.jdField_a_of_type_Int);
      MiniAppLauncher.startMiniApp(paramContext, paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt.k, 2103, null);
      localrdz = new rdz();
      localrdz.e = (paramVideoInfo.a() * 1000);
      localrdz.d = ((int)(localrdz.e * this.jdField_a_of_type_Double));
      localrdz.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
        break label155;
      }
    }
    label155:
    for (paramContext = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; paramContext = "")
    {
      ofe.b(paramVideoInfo, i, 25, -1, localrdz, paramContext);
      return;
    }
  }
  
  private void a(Context paramContext, VideoInfo paramVideoInfo, rvv paramrvv, int paramInt)
  {
    String str1;
    long l1;
    long l2;
    if ((paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt != null) && (this.jdField_a_of_type_JavaUtilSet != null) && (paramrvv != null))
    {
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt.j;
      if (paramInt != obb.jdField_a_of_type_Int) {
        break label169;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label161;
      }
      l1 = 5040504L;
      l2 = 3L;
    }
    for (;;)
    {
      label69:
      obb.a(paramContext, new nzz().a(504L).b(50405L).c(l1).d(str1).d(l2).a(paramVideoInfo.g).b(paramVideoInfo.c).i(String.valueOf(paramrvv.jdField_b_of_type_Int)).c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt.o).g(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt.k).a());
      label161:
      label169:
      label239:
      do
      {
        String str2;
        do
        {
          return;
          l1 = 5040502L;
          break;
          l2 = 6L;
          if (!this.jdField_a_of_type_Boolean) {
            break label239;
          }
          str2 = paramVideoInfo.jdField_a_of_type_JavaLangString + "_B";
        } while (this.jdField_a_of_type_JavaUtilSet.contains(str2));
        l1 = 5040503L;
        this.jdField_a_of_type_JavaUtilSet.add(str2);
        break label69;
      } while (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
      l1 = 5040501L;
      this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_Int);
  }
  
  private boolean e()
  {
    return (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt.o));
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
      return twr.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_Int, "人在玩");
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_b_of_type_JavaLangString;
  }
  
  public String a()
  {
    if ((a() == 3) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt != null)) {
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt.l;
    }
    if (this.jdField_a_of_type_Boolean) {
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
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(VideoInfo paramVideoInfo, rvv paramrvv)
  {
    this.jdField_b_of_type_Int += 1;
    a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo, paramrvv, obb.jdField_b_of_type_Int);
    this.jdField_a_of_type_Rvv = paramrvv;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((TextUtils.isEmpty(bkwm.a("sp_key_ad_soft_total_area"))) || ("1".equals(bkwm.a("sp_key_ad_soft_total_area")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = obg.a(bkwm.a("sp_key_ad_soft_kd_max"), 2147483647);
      this.jdField_b_of_type_Int = rwv.a(paramQQAppInterface);
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate() mConfigIsOpen = " + this.jdField_b_of_type_Boolean + ", mConfigMaxShowCount = " + this.jdField_a_of_type_Int + ", mTodayShowCount = " + this.jdField_b_of_type_Int);
      }
      return;
    }
  }
  
  public void a(rvv paramrvv)
  {
    paramrvv.N.setVisibility(0);
    paramrvv.w.setVisibility(0);
    if ((a() == 3) && (paramrvv.jdField_y_of_type_AndroidViewView != null) && (paramrvv.O != null))
    {
      paramrvv.jdField_y_of_type_AndroidViewView.setVisibility(0);
      paramrvv.O.setVisibility(0);
      paramrvv.w.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo, paramrvv, obb.jdField_b_of_type_Int);
  }
  
  public void a(sbz paramsbz) {}
  
  public boolean a()
  {
    return ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null)) || (e());
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return d();
  }
  
  public boolean a(VideoInfo paramVideoInfo, rvv paramrvv, double paramDouble, long paramLong)
  {
    int i = Aladdin.getConfig(318).getIntegerFromString("small_game_change_bigger_position", 30);
    if ((paramrvv.jdField_y_of_type_AndroidViewViewGroup != null) && (paramrvv.jdField_y_of_type_AndroidViewViewGroup.getVisibility() == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null))
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
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt.o;
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Int != 0) {
      rwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy() mTodayShowCount = " + this.jdField_b_of_type_Int);
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void b(rvv paramrvv) {}
  
  public boolean b()
  {
    return false;
  }
  
  public String c()
  {
    if ((a() == 3) && (e())) {
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Trt.n;
    }
    return "";
  }
  
  public void c(rvv paramrvv) {}
  
  public boolean c()
  {
    return false;
  }
  
  public String d()
  {
    return "";
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
    rwv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
    paramView = new sie("", "", this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).i(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo);
    odq.b(null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.j, "0X800A2F7", "0X800A2F7", 0, 0, "0", "", "", paramView.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     scb
 * JD-Core Version:    0.7.0.1
 */