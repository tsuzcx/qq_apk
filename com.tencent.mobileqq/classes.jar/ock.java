import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ock
  implements View.OnClickListener
{
  ock(obm paramobm, String paramString, oji paramoji) {}
  
  public void onClick(View paramView)
  {
    obm.c(this.jdField_a_of_type_Obm, this.jdField_a_of_type_JavaLangString);
    PublicAccountHandler.a(this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Obm.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "Clk_msg");
    obm.a(this.jdField_a_of_type_Obm, this.jdField_a_of_type_Oji.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ock
 * JD-Core Version:    0.7.0.1
 */