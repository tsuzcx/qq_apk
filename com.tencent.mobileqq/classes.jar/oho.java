import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;

public class oho
  implements View.OnFocusChangeListener
{
  public oho(EditTextDialog paramEditTextDialog) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    SLog.b("EditTextDialog", "onFocusChange:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oho
 * JD-Core Version:    0.7.0.1
 */