import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.22;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class qun
  implements View.OnClickListener
{
  public qun(ReadinjoyTabFrame.22 param22, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    paramView = (pnh)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.this$0.a.getManager(270);
    if (paramView.a() == 1)
    {
      paramView.a(false);
      paramView = paramView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.this$0.a(), 0);
      if (paramView != null)
      {
        paramView.isShown = false;
        baig.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.this$0.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.this$0.a.getCurrentAccountUin(), paramView.toJson().toString(), 0);
      }
    }
    ((pnn)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.this$0.a.getManager(261)).a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.a.skinData.id, false);
    ReadinjoyTabFrame.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.this$0).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(ReadinjoyTabFrame.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.this$0));
    ReadinjoyTabFrame.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.this$0, null);
    baig.r(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.this$0.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.this$0.a.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.a.skinData.toJson().toString());
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabFrame", 2, "set skin ：id = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$22.a.skinData.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qun
 * JD-Core Version:    0.7.0.1
 */