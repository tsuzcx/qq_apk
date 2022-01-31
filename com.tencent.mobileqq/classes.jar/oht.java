import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.EditTextDialogEventListener;

public class oht
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private oht(EditTextDialog paramEditTextDialog) {}
  
  public void onGlobalLayout()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText.getBottom() - this.a.c > this.a.b)
    {
      this.a.dismiss();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.a(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oht
 * JD-Core Version:    0.7.0.1
 */