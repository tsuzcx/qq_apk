import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.1;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.2;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.3;
import com.tencent.biz.qqstory.debug.activities.DebugPromoteTaskCode.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;

public class sox
  extends ukz
  implements View.OnClickListener
{
  public EditText a;
  public sqe a;
  public EditText b;
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    super.a(paramBundle1, paramBundle2);
    this.jdField_a_of_type_Sqe = ((sqe)sqg.a(29));
    a(2131492905);
    a(2131297994).setOnClickListener(this);
    a(2131298041).setOnClickListener(this);
    a(2131297950).setOnClickListener(this);
    a(2131298069).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131299940));
    this.b = ((EditText)a(2131299907));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297994: 
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.1(this), true);
      return;
    case 2131298041: 
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.2(this), true);
      return;
    case 2131297950: 
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.3(this));
      return;
    case 2131297952: 
      this.b.getText().toString();
      this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      this.b.getText().clear();
      this.jdField_a_of_type_AndroidWidgetEditText.getText().clear();
      new sow(BaseApplicationImpl.getApplication().getRuntime().getAccount()).a();
      return;
    }
    ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.4(this, this.b.getText().toString(), this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sox
 * JD-Core Version:    0.7.0.1
 */