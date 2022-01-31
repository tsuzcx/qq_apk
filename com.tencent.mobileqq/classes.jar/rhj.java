import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMessageHelper;
import com.tencent.mobileqq.statistics.ReportController;

public class rhj
  implements View.OnClickListener
{
  public rhj(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent();
    paramView.putExtra("param_wzry_data", AddRequestActivity.a(this.a));
    SystemMessageHelper.a(this.a.app, this.a, this.a.jdField_a_of_type_JavaLangString, AddRequestActivity.a(this.a), this.a.jdField_a_of_type_Int, AddRequestActivity.a(this.a), paramView);
    if (AddRequestActivity.a(this.a) != null) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800843E", "0X800843E", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rhj
 * JD-Core Version:    0.7.0.1
 */