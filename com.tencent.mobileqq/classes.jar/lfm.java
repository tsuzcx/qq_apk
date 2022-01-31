import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lfm
  implements ActionSheet.OnButtonClickListener
{
  public lfm(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ReadInJoyVideoSubChannelActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, false);
      ReadInJoyVideoSubChannelActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfm
 * JD-Core Version:    0.7.0.1
 */