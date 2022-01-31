import android.text.format.DateFormat;
import android.widget.TextView;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

public class svr
  implements Runnable
{
  public svr(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  public void run()
  {
    String str1 = StringUtil.a(this.a.c, 0, 32);
    String str2 = StringUtil.a(this.a.e, 0, 32);
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + String.format("(%d人)", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()) }));
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(str2 + " 创建于 " + DateFormat.format("yy-M-d", this.a.jdField_b_of_type_Long));
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svr
 * JD-Core Version:    0.7.0.1
 */