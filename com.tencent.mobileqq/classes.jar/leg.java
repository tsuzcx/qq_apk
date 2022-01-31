import android.app.Activity;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;

public class leg
  implements Runnable
{
  public leg(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity, GuideData paramGuideData, String paramString, int paramInt) {}
  
  public void run()
  {
    FrameLayout localFrameLayout = (FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.getActivity().getWindow().getDecorView();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a = new ReadInJoySkinGuideView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.app, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.id, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, new leh(this, localFrameLayout), new lei(this, localFrameLayout));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a() == 0)
    {
      localFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a, -1, -1);
      return;
    }
    ReadInJoyNewFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     leg
 * JD-Core Version:    0.7.0.1
 */