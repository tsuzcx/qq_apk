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

public class tbt
  extends uxv
  implements View.OnClickListener
{
  public EditText a;
  public tda a;
  public EditText b;
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    super.a(paramBundle1, paramBundle2);
    this.jdField_a_of_type_Tda = ((tda)tdc.a(29));
    a(2131558442);
    a(2131363544).setOnClickListener(this);
    a(2131363591).setOnClickListener(this);
    a(2131363497).setOnClickListener(this);
    a(2131363619).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131365520));
    this.b = ((EditText)a(2131365487));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363544: 
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.1(this), true);
      return;
    case 2131363591: 
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.2(this), true);
      return;
    case 2131363497: 
      ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.3(this));
      return;
    case 2131363500: 
      this.b.getText().toString();
      this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      this.b.getText().clear();
      this.jdField_a_of_type_AndroidWidgetEditText.getText().clear();
      new tbs(BaseApplicationImpl.getApplication().getRuntime().getAccount()).a();
      return;
    }
    ThreadManager.executeOnSubThread(new DebugPromoteTaskCode.4(this, this.b.getText().toString(), this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbt
 * JD-Core Version:    0.7.0.1
 */