import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nyz
  implements View.OnClickListener
{
  nyz(nyy paramnyy) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Nyq.b == 2)
    {
      Intent localIntent = new Intent((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.a.jdField_a_of_type_Nyq.jdField_c_of_type_JavaLangString);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      nzq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 3, 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_Nyq.b == 1) {
        switch (this.a.jdField_c_of_type_Int)
        {
        case 3: 
        default: 
          break;
        case 0: 
          nyy.a(this.a);
          break;
        case 1: 
          nzq.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_Nyq.f);
          nzq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 1, 0);
          break;
        case 2: 
          nzq.a(this.a.jdField_a_of_type_Nyq);
          nzq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_c_of_type_JavaLangString, 3, 4, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyz
 * JD-Core Version:    0.7.0.1
 */