import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nvk
  implements View.OnClickListener
{
  nvk(num paramnum, String paramString, obr paramobr) {}
  
  public void onClick(View paramView)
  {
    num.c(this.jdField_a_of_type_Num, this.jdField_a_of_type_JavaLangString);
    PublicAccountHandler.a(this.jdField_a_of_type_Num.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Num.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "Clk_msg");
    num.a(this.jdField_a_of_type_Num, this.jdField_a_of_type_Obr.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvk
 * JD-Core Version:    0.7.0.1
 */