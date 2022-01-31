import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class nlm
  implements View.OnClickListener
{
  nlm(nll paramnll) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Nld.b == 2)
    {
      paramView = new Intent((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", this.a.jdField_a_of_type_Nld.jdField_c_of_type_JavaLangString);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      nmf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 3, 0);
    }
    while (this.a.jdField_a_of_type_Nld.b != 1) {
      return;
    }
    switch (this.a.jdField_c_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 0: 
      nll.a(this.a);
      return;
    case 1: 
      nmf.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_Nld.f);
      nmf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 1, 0);
      return;
    }
    nmf.a(this.a.jdField_a_of_type_Nld);
    nmf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 4, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlm
 * JD-Core Version:    0.7.0.1
 */