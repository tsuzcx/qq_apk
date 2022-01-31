import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsOptView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class qqf
  implements View.OnClickListener
{
  public qqf(VideoFeedsOptView paramVideoFeedsOptView, qls paramqls, String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Qls.a.put(this.jdField_a_of_type_JavaLangString, Integer.valueOf(((Integer)this.jdField_a_of_type_Qls.a.get(this.jdField_a_of_type_JavaLangString)).intValue() + 1));
    bbjn.a("ug_prefix_ug_1get3_opt_day_click_" + this.jdField_a_of_type_JavaLangString, bbjn.a("ug_prefix_ug_1get3_opt_day_click_" + this.jdField_a_of_type_JavaLangString) + 1);
    VideoFeedsOptView.a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, "3"));
    paramView = new qze(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
    if (this.jdField_a_of_type_Int == 1)
    {
      paramView.a(false).f(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)).a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)).x(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
      if ((this.b == 1) && (!TextUtils.isEmpty(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView))))
      {
        awvy.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.getContext(), VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
        VideoFeedsOptView.a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, "108"));
      }
    }
    while (VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView))
    {
      noo.a(null, null, "0X80092A0", "0X80092A0", 0, 0, String.valueOf(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)), "", "", paramView.a().a(), false);
      return;
      paramView.a(true).f(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)).a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)).x(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
      if ((this.b == 2) && (!TextUtils.isEmpty(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView))))
      {
        VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
        VideoFeedsOptView.a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, "7"));
      }
      else if ((this.b == 1) && (!TextUtils.isEmpty(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView))))
      {
        awvy.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView.getContext(), VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView));
        VideoFeedsOptView.a(VideoFeedsOptView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView, "108"));
      }
    }
    noo.a(null, null, "0X8009034", "0X8009034", 0, 0, String.valueOf(VideoFeedsOptView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsOptView)), "", "", paramView.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqf
 * JD-Core Version:    0.7.0.1
 */