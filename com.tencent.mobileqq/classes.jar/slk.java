import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class slk
  implements View.OnClickListener
{
  public slk(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    Intent localIntent = this.a.getIntent();
    localIntent.putExtra("result", paramView);
    if (this.a.jdField_a_of_type_Int == 103) {
      localIntent.putExtra("hasChange", EditActivity.b(this.a));
    }
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     slk
 * JD-Core Version:    0.7.0.1
 */