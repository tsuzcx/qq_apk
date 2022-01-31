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

public class rio
  implements rin
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
    jdField_a_of_type_JavaLangString = rio.class.getSimpleName();
  }
  
  private boolean d()
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
      rdm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int);
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
  
  public void a(VideoInfo paramVideoInfo, rbt paramrbt)
  {
    this.jdField_b_of_type_Int += 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((TextUtils.isEmpty(bkbq.a("sp_key_ad_soft_total_area"))) || ("1".equals(bkbq.a("sp_key_ad_soft_total_area")))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = npd.a(bkbq.a("sp_key_ad_soft_kd_max"), 2147483647);
      this.jdField_b_of_type_Int = rdm.a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate() mConfigIsOpen = " + this.jdField_b_of_type_Boolean + ", mConfigMaxShowCount = " + this.jdField_a_of_type_Int + ", mTodayShowCount = " + this.jdField_b_of_type_Int);
      }
      return;
    }
  }
  
  public void a(rbt paramrbt)
  {
    paramrbt.Q.setVisibility(0);
    paramrbt.w.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(rim paramrim) {}
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null);
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return d();
  }
  
  public boolean a(VideoInfo paramVideoInfo, rbt paramrbt, double paramDouble, long paramLong)
  {
    return (paramrbt.u != null) && (paramrbt.u.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo != null) && (paramDouble > this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_Int);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void b(rbt paramrbt) {}
  
  public boolean b()
  {
    return false;
  }
  
  public String c()
  {
    return "";
  }
  
  public void c(rbt paramrbt) {}
  
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
    rdm.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
    paramView = new ron("", "", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g).h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.e()) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;; i = 0)
    {
      paramView = paramView.t(i).q(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e);
      nrt.b(null, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j, "0X800A2F7", "0X800A2F7", 0, 0, "0", "", "", paramView.a().a(), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rio
 * JD-Core Version:    0.7.0.1
 */