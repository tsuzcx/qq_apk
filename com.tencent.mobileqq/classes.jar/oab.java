import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oab
  implements View.OnClickListener
{
  oab(nzu paramnzu, oag paramoag) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Oag.jdField_a_of_type_AndroidWidgetTextView.setText(2131695000);
    this.jdField_a_of_type_Oag.b.setVisibility(4);
    this.jdField_a_of_type_Oag.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    oaz.a(this.jdField_a_of_type_Nzu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_Nzu.jdField_a_of_type_JavaLangString), ((AccountDetailActivity)this.jdField_a_of_type_Nzu.jdField_a_of_type_AndroidAppActivity).a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oab
 * JD-Core Version:    0.7.0.1
 */