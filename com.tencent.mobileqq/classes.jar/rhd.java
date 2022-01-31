import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;

public class rhd
  implements Runnable
{
  public rhd(AddRequestActivity paramAddRequestActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.a.b))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.b);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rhd
 * JD-Core Version:    0.7.0.1
 */