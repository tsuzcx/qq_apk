import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class lei
  implements View.OnClickListener
{
  lei(leg paramleg, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    paramView = (ReadInJoyRefreshManager)this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.app.getManager(269);
    if (paramView.a() == 1)
    {
      paramView.a(false);
      paramView = paramView.a(this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity);
      if (paramView != null)
      {
        paramView.isShown = false;
        SharedPreUtils.v(this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity, this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.app.getCurrentAccountUin(), paramView.toJson().toString());
      }
    }
    ((ReadInJoySkinManager)this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.app.getManager(260)).a(1, this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id);
    SharedPreUtils.u(this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity, this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.app.getCurrentAccountUin(), this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.toJson().toString());
    this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity.a);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "set skin ：id = " + this.jdField_a_of_type_Leg.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lei
 * JD-Core Version:    0.7.0.1
 */