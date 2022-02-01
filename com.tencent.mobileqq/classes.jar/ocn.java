import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class ocn
  implements View.OnClickListener
{
  ocn(obm paramobm, oji paramoji) {}
  
  public void onClick(View paramView)
  {
    aahr.b((Activity)this.jdField_a_of_type_Obm.jdField_a_of_type_JavaLangRefWeakReference.get(), new aaht(this.jdField_a_of_type_Obm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_Obm.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, obm.a(this.jdField_a_of_type_Obm));
    obm.a(this.jdField_a_of_type_Obm, this.jdField_a_of_type_Oji.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ocn
 * JD-Core Version:    0.7.0.1
 */