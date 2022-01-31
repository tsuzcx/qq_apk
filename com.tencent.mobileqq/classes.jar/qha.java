import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class qha
  implements qgz
{
  public static final String a;
  private int jdField_a_of_type_Int = 2147483647;
  Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = qha.class.getSimpleName();
  }
  
  private boolean b()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int < this.jdField_a_of_type_Int);
  }
  
  public int a()
  {
    return 0;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.b;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.d;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Int != 0) {
      qcn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy() mTodayShowCount = " + this.jdField_b_of_type_Int);
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(VideoInfo paramVideoInfo, qaq paramqaq)
  {
    this.jdField_b_of_type_Int += 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((TextUtils.isEmpty(bgmq.a("sp_key_ad_soft_total_area"))) || ("1".equals(bgmq.a("sp_key_ad_soft_total_area")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = nbj.a(bgmq.a("sp_key_ad_soft_kd_max"), 2147483647);
      this.jdField_b_of_type_Int = qcn.a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate() mConfigIsOpen = " + this.jdField_b_of_type_Boolean + ", mConfigMaxShowCount = " + this.jdField_a_of_type_Int + ", mTodayShowCount = " + this.jdField_b_of_type_Int);
      }
      return;
    }
  }
  
  public void a(qaq paramqaq)
  {
    paramqaq.J.setVisibility(0);
    paramqaq.w.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null);
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return b();
  }
  
  public boolean a(VideoInfo paramVideoInfo, qaq paramqaq, double paramDouble)
  {
    return (paramqaq.u != null) && (paramqaq.u.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (paramDouble > this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Int);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void b(qaq paramqaq) {}
  
  public void c(qaq paramqaq) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    qcn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
    paramView = new qmv("", "", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;; i = 0)
    {
      paramView = paramView.t(i).q(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e);
      ndn.b(null, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j, "0X800A2F7", "0X800A2F7", 0, 0, "0", "", "", paramView.a().a(), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qha
 * JD-Core Version:    0.7.0.1
 */