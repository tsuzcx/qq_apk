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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class okt
  implements View.OnClickListener
{
  public okt(ReadInJoyNewFeedsActivity.5 param5, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (qtq)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.app.getManager(270);
    if (((qtq)localObject).a() == 1)
    {
      ((qtq)localObject).a(false);
      localObject = ((qtq)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0, 0);
      if (localObject != null)
      {
        ((RefreshData)localObject).isShown = false;
        bhsi.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.app.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
      }
    }
    bhsi.s(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.a.skinData.toJson().toString());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.a.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.a);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "set skin ：id = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.a.skinData.id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okt
 * JD-Core Version:    0.7.0.1
 */