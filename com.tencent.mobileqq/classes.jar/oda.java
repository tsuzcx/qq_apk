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

public class oda
  extends rmr
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
  private ViewGroup d;
  
  static
  {
    jdField_a_of_type_JavaLangString = oda.class.getSimpleName();
  }
  
  public oda(View paramView, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramView, paramActivity, 1);
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = ((ViewGroup)paramView.findViewById(2131367575));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131367576));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131367573));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376570));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = ((MultiVideoAdFooterView)paramView.findViewById(2131370843));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = ((MultiVideoAdFooterView)paramView.findViewById(2131370844));
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
    if (this.d != null) {
      this.d.setOnClickListener(this);
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
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_Rng.a(this))
    {
      this.jdField_a_of_type_Rnr.a().f();
      paramView = oen.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      oee.a(paramView, 1000, this.jdField_a_of_type_Rng.a());
      szl.b(this.jdField_a_of_type_AndroidAppActivity, paramView, null, 3, false, null);
      ocz.a(this.jdField_a_of_type_AndroidAppActivity, noy.ay, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView.setData(this, paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Rng);
      if ((this.jdField_a_of_type_Rnr instanceof odb))
      {
        ((odb)this.jdField_a_of_type_Rnr).a.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_AndroidAppActivity;
        ((odb)this.jdField_a_of_type_Rnr).a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        ((odb)this.jdField_a_of_type_Rnr).a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdMultiVideoMultiVideoAdFooterView;
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
      ode.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
    }
    this.d.setTag(this);
    this.d.setOnClickListener(this);
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
    if (!this.jdField_a_of_type_Rng.a(this)) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = oen.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
    this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = szl.a(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, null, 3, false, null);
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      this.jdField_a_of_type_Long = l;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131367573: 
      case 2131367574: 
        oee.a(localAdvertisementInfo, 2, this.jdField_a_of_type_Rng.a());
        szl.b(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, null, 3, false, null);
        ocz.a(this.jdField_a_of_type_AndroidAppActivity, noy.aq, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        return;
      }
    }
    this.jdField_a_of_type_Rng.b(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    return;
    oee.a(localAdvertisementInfo, 1000, this.jdField_a_of_type_Rng.a());
    szl.b(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, null, 3, false, null);
    ocz.a(this.jdField_a_of_type_AndroidAppActivity, noy.ay, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    return;
    oee.a(localAdvertisementInfo, 3, this.jdField_a_of_type_Rng.a());
    szl.b(this.jdField_a_of_type_AndroidAppActivity, localAdvertisementInfo, null, 3, false, null);
    ocz.a(this.jdField_a_of_type_AndroidAppActivity, noy.ar, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oda
 * JD-Core Version:    0.7.0.1
 */