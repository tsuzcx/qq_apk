import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nsc
  implements View.OnClickListener
{
  nsc(nre paramnre, String paramString, nyl paramnyl) {}
  
  public void onClick(View paramView)
  {
    nre.c(this.jdField_a_of_type_Nre, this.jdField_a_of_type_JavaLangString);
    PublicAccountHandler.a(this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Nre.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "Clk_msg");
    nre.a(this.jdField_a_of_type_Nre, this.jdField_a_of_type_Nyl.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsc
 * JD-Core Version:    0.7.0.1
 */