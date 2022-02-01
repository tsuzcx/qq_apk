import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class nvo
  implements View.OnClickListener
{
  nvo(num paramnum, obr paramobr) {}
  
  public void onClick(View paramView)
  {
    zsf.a((BaseActivity)this.jdField_a_of_type_Num.jdField_a_of_type_JavaLangRefWeakReference.get(), new zsh(this.jdField_a_of_type_Num.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Num.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_Num.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, num.a(this.jdField_a_of_type_Num));
    num.a(this.jdField_a_of_type_Num, this.jdField_a_of_type_Obr.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvo
 * JD-Core Version:    0.7.0.1
 */