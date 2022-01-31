import android.app.Activity;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.multiVideo.MultiVideoAdFooterView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.app.QQAppInterface;

public class nzt
  extends qxf
{
  public static final String a;
  public long a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private MultiVideoAdFooterView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  public GdtHandler.Params a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MultiVideoAdFooterView b;
  private MultiVideoAdFooterView c;
  private ViewGroup e;
  
  static
  {
    jdField_a_of_type_JavaLangString = nzt.class.getSimpleName();
  }
  
  public nzt(View paramView, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramView, paramActivity, 1);
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.e = ((ViewGroup)paramView.findViewById(2131367437));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131367438));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131367435));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376015));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = ((MultiVideoAdFooterView)paramView.findViewById(2131370519));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = ((MultiVideoAdFooterView)paramView.findViewById(2131370520));
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    if (this.e != null) {
      this.e.setOnClickListener(this);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    }
    a();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.d != null) {
      this.d.setVisibility(8);
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Qxu.a(this))
    {
      this.jdField_a_of_type_Qyj.a().f();
      paramView = oay.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      oau.a(paramView, 1000, this.jdField_a_of_type_Qxu.a());
      sht.b(this.jdField_a_of_type_AndroidAppActivity, paramView, null, 3, false, null);
      nzs.a(this.jdField_a_of_type_AndroidAppActivity, nmf.ay, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    super.a(paramVideoInfo);
    if (paramVideoInfo.c)
    {
      paramVideoInfo.a.a = true;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView.setVisibility(8);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView.setVisibility(8);
      VideoAdInfo localVideoAdInfo = paramVideoInfo.a;
      if ((localVideoAdInfo != null) && (localVideoAdInfo.m != 1)) {
        break label150;
      }
    }
    label150:
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView;; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView.setData(this, paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qxu);
      if ((this.jdField_a_of_type_Qyj instanceof nzu))
      {
        ((nzu)this.jdField_a_of_type_Qyj).a.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
        ((nzu)this.jdField_a_of_type_Qyj).a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        ((nzu)this.jdField_a_of_type_Qyj).a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView;
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView.b();
    super.a(paramBoolean);
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getPaint().setFakeBoldText(true);
        VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k);
        VideoFeedsAccessibilityHelper.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.k);
      }
      nzx.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    }
    this.e.setTag(this);
    this.e.setOnClickListener(this);
    a();
  }
  
  public void c()
  {
    super.c();
    this.jdField_b_of_type_AndroidWidgetTextView.setText("广告");
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Qxu.a(this)) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = oay.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
    this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = sht.a(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, null, 3, false, null);
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      this.jdField_a_of_type_Long = l;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131367435: 
      case 2131367436: 
        oau.a(localAdvertisementInfo, 2, this.jdField_a_of_type_Qxu.a());
        sht.b(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, null, 3, false, null);
        nzs.a(this.jdField_a_of_type_AndroidAppActivity, nmf.aq, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        return;
      }
    }
    this.jdField_a_of_type_Qxu.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    return;
    oau.a(localAdvertisementInfo, 1000, this.jdField_a_of_type_Qxu.a());
    sht.b(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, null, 3, false, null);
    nzs.a(this.jdField_a_of_type_AndroidAppActivity, nmf.ay, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    return;
    oau.a(localAdvertisementInfo, 3, this.jdField_a_of_type_Qxu.a());
    sht.b(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, null, 3, false, null);
    nzs.a(this.jdField_a_of_type_AndroidAppActivity, nmf.ar, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzt
 * JD-Core Version:    0.7.0.1
 */