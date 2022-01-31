import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;

class mkq
  implements View.OnClickListener
{
  mkq(mkp parammkp, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.jdField_a_of_type_Mkp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(ReadinjoyTabFrame.a(this.jdField_a_of_type_Mkp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame));
    ReadinjoyTabFrame.a(this.jdField_a_of_type_Mkp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame, null);
    if (260 == this.jdField_a_of_type_Mkp.jdField_a_of_type_Int) {
      SharedPreUtils.u(this.jdField_a_of_type_Mkp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a(), this.jdField_a_of_type_Mkp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a.getCurrentAccountUin(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkq
 * JD-Core Version:    0.7.0.1
 */