import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class nof
  implements View.OnClickListener
{
  nof(noe paramnoe) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Nnw.b == 2)
    {
      paramView = new Intent((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("url", this.a.jdField_a_of_type_Nnw.jdField_c_of_type_JavaLangString);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      noy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 3, 0);
    }
    while (this.a.jdField_a_of_type_Nnw.b != 1) {
      return;
    }
    switch (this.a.jdField_c_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 0: 
      noe.a(this.a);
      return;
    case 1: 
      noy.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_Nnw.f);
      noy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 1, 0);
      return;
    }
    noy.a(this.a.jdField_a_of_type_Nnw);
    noy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 4, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nof
 * JD-Core Version:    0.7.0.1
 */