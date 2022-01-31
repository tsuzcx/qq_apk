import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EditInfoActivity;

class sqp
  implements Runnable
{
  sqp(sqn paramsqn, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_Sqn.a.a.setText(this.jdField_a_of_type_Sqn.a.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_Sqn.a.jdField_c_of_type_Int)
    {
      this.jdField_a_of_type_Sqn.a.a.setTextColor(-65536);
      this.jdField_a_of_type_Sqn.a.rightViewText.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_Sqn.a.a.setTextColor(Color.rgb(119, 119, 119));
    this.jdField_a_of_type_Sqn.a.rightViewText.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sqp
 * JD-Core Version:    0.7.0.1
 */