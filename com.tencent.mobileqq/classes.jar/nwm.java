import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.5;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class nwm
  implements View.OnClickListener
{
  public nwm(ReadInJoyNewFeedsActivity.5 param5, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    paramView = (pyz)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.app.getManager(270);
    if (paramView.a() == 1)
    {
      paramView.a(false);
      paramView = paramView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0, 0);
      if (paramView != null)
      {
        paramView.isShown = false;
        bbkb.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.app.getCurrentAccountUin(), paramView.toJson().toString(), 0);
      }
    }
    ((pzf)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.app.getManager(261)).a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.a.skinData.id, false);
    bbkb.r(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.a.skinData.toJson().toString());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.a.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.a);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "set skin ：id = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.a.skinData.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwm
 * JD-Core Version:    0.7.0.1
 */