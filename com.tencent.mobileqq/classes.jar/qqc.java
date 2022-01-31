import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsOptView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class qqc
  implements View.OnClickListener
{
  public qqc(VideoFeedsOptView paramVideoFeedsOptView, qlp paramqlp, String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Qlp.a.put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(((Integer)this.jdField_a_of_type_Qlp.a.get(this.jdField_a_of_type_JavaLangString)).intValue() + 1));
    bbkb.a("ug_prefix_ug_1get3_opt_day_click_" + this.jdField_a_of_type_JavaLangString, bbkb.a("ug_prefix_ug_1get3_opt_day_click_" + this.jdField_a_of_type_JavaLangString) + 1);
    VideoFeedsOptView.a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, "3"));
    paramView = new qzb(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
    if (this.jdField_a_of_type_Int == 1)
    {
      paramView.a(false).f(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)).a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)).x(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
      if ((this.b == 1) && (!TextUtils.isEmpty(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView))))
      {
        awwa.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.getContext(), VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
        VideoFeedsOptView.a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, "108"));
      }
    }
    while (VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView))
    {
      nol.a(null, null, "0X80092A0", "0X80092A0", 0, 0, String.valueOf(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)), "", "", paramView.a().a(), false);
      return;
      paramView.a(true).f(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)).a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)).x(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
      if ((this.b == 2) && (!TextUtils.isEmpty(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView))))
      {
        VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
        VideoFeedsOptView.a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, "7"));
      }
      else if ((this.b == 1) && (!TextUtils.isEmpty(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView))))
      {
        awwa.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.getContext(), VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
        VideoFeedsOptView.a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, "108"));
      }
    }
    nol.a(null, null, "0X8009034", "0X8009034", 0, 0, String.valueOf(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)), "", "", paramView.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqc
 * JD-Core Version:    0.7.0.1
 */