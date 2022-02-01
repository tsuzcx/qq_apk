import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class nue
  implements View.OnClickListener
{
  nue(ntc paramntc, oag paramoag) {}
  
  public void onClick(View paramView)
  {
    aavs.a((BaseActivity)this.jdField_a_of_type_Ntc.jdField_a_of_type_JavaLangRefWeakReference.get(), new aavu(this.jdField_a_of_type_Ntc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ntc.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, this.jdField_a_of_type_Ntc.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary), 1, ntc.a(this.jdField_a_of_type_Ntc));
    ntc.a(this.jdField_a_of_type_Ntc, this.jdField_a_of_type_Oag.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nue
 * JD-Core Version:    0.7.0.1
 */