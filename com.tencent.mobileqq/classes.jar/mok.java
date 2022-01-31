import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class mok
  implements View.OnClickListener
{
  mok(moi parammoi, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    paramView = (ReadInJoyRefreshManager)this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a.getManager(269);
    if (paramView.a() == 1)
    {
      paramView.a(false);
      paramView = paramView.a(this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a());
      if (paramView != null)
      {
        paramView.isShown = false;
        SharedPreUtils.v(this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a(), this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a.getCurrentAccountUin(), paramView.toJson().toString());
      }
    }
    ((ReadInJoySkinManager)this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a.getManager(260)).a(1, this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id);
    ReadinjoyTabFrame.a(this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(ReadinjoyTabFrame.a(this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame));
    ReadinjoyTabFrame.a(this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame, null);
    SharedPreUtils.u(this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a(), this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a.getCurrentAccountUin(), this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.toJson().toString());
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabFrame", 2, "set skin ：id = " + this.jdField_a_of_type_Moi.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mok
 * JD-Core Version:    0.7.0.1
 */