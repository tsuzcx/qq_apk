import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

class prd
  implements View.OnClickListener
{
  prd(prc paramprc, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3) {}
  
  public void onClick(View paramView)
  {
    bhvy.f(onh.a(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getTop() + this.b.getTop() + this.c.getTop());
    paramView = this.jdField_a_of_type_Prc.jdField_a_of_type_Ram.a();
    if (paramView != null) {
      paramView.a(null, ((pau)this.jdField_a_of_type_Prc.jdField_a_of_type_JavaLangObject).a(), 2);
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "firstlayout top" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "firstlayout width" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "thirdlayout top" + this.b.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "thirdlayout width" + this.b.getWidth() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "secondlayout top" + this.c.getTop() });
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", "secondlayout width" + this.c.getWidth() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     prd
 * JD-Core Version:    0.7.0.1
 */