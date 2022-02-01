import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nrr
  implements View.OnClickListener
{
  nrr(nrk paramnrk, nrw paramnrw) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Nrw.jdField_a_of_type_AndroidWidgetTextView.setText(2131694676);
    this.jdField_a_of_type_Nrw.b.setVisibility(4);
    this.jdField_a_of_type_Nrw.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    nsp.a(this.jdField_a_of_type_Nrk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_Nrk.jdField_a_of_type_JavaLangString), ((AccountDetailActivity)this.jdField_a_of_type_Nrk.jdField_a_of_type_AndroidAppActivity).a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrr
 * JD-Core Version:    0.7.0.1
 */