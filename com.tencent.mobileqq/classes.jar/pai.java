import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;

class pai
  implements View.OnClickListener
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RecommendFollowInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  private pai(ozx paramozx) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300919: 
      paramView = this.jdField_a_of_type_Ozx;
      RecommendFollowInfo localRecommendFollowInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.isFollowed) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.a(localRecommendFollowInfo, bool);
        ndn.a(null, obz.a() + "", "0X800984A", "0X800984A", 0, 0, "1", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.uin + "", "", "", false);
        return;
      }
    }
    ozx.b(this.jdField_a_of_type_Ozx, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
    ndn.a(null, obz.a() + "", "0X8009849", "0X8009849", 0, 0, "1", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.uin + "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pai
 * JD-Core Version:    0.7.0.1
 */