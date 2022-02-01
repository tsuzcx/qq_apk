import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class nsf
  implements View.OnClickListener
{
  nsf(nre paramnre, nyl paramnyl) {}
  
  public void onClick(View paramView)
  {
    aarp.b((Activity)this.jdField_a_of_type_Nre.jdField_a_of_type_JavaLangRefWeakReference.get(), new aarr(this.jdField_a_of_type_Nre.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_Nre.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, nre.a(this.jdField_a_of_type_Nre));
    nre.a(this.jdField_a_of_type_Nre, this.jdField_a_of_type_Nyl.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsf
 * JD-Core Version:    0.7.0.1
 */