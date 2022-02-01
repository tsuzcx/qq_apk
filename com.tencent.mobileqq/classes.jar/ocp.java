import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class ocp
  implements View.OnClickListener
{
  ocp(obm paramobm, int paramInt, oji paramoji) {}
  
  public void onClick(View paramView)
  {
    aahr.a((BaseActivity)this.jdField_a_of_type_Obm.jdField_a_of_type_JavaLangRefWeakReference.get(), new aaht(this.jdField_a_of_type_Obm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, obm.a(this.jdField_a_of_type_Obm), this.jdField_a_of_type_Int);
    obm.a(this.jdField_a_of_type_Obm, this.jdField_a_of_type_Oji.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ocp
 * JD-Core Version:    0.7.0.1
 */