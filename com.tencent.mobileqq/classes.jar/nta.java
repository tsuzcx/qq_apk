import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nta
  implements View.OnClickListener
{
  nta(nst paramnst, ntf paramntf) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ntf.jdField_a_of_type_AndroidWidgetTextView.setText(2131694792);
    this.jdField_a_of_type_Ntf.b.setVisibility(4);
    this.jdField_a_of_type_Ntf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    nty.a(this.jdField_a_of_type_Nst.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_Nst.jdField_a_of_type_JavaLangString), ((AccountDetailActivity)this.jdField_a_of_type_Nst.jdField_a_of_type_AndroidAppActivity).a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nta
 * JD-Core Version:    0.7.0.1
 */