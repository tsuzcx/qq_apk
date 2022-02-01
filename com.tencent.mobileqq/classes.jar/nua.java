import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nua
  implements View.OnClickListener
{
  nua(ntc paramntc, String paramString, oag paramoag) {}
  
  public void onClick(View paramView)
  {
    ntc.c(this.jdField_a_of_type_Ntc, this.jdField_a_of_type_JavaLangString);
    PublicAccountHandler.a(this.jdField_a_of_type_Ntc.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ntc.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "Clk_msg");
    ntc.a(this.jdField_a_of_type_Ntc, this.jdField_a_of_type_Oag.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nua
 * JD-Core Version:    0.7.0.1
 */