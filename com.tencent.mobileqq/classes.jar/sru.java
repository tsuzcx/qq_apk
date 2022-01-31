import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;

public class sru
  implements View.OnClickListener
{
  public sru(LimitWordCountEditText paramLimitWordCountEditText) {}
  
  public final void onClick(View paramView)
  {
    if (!LimitWordCountEditText.a(this.a).hasFocus())
    {
      LimitWordCountEditText.a(this.a).requestFocus();
      LimitWordCountEditText.a(this.a).setSelection(LimitWordCountEditText.a(this.a).getText().length());
    }
    paramView = (InputMethodManager)this.a.getContext().getSystemService("input_method");
    if (paramView != null) {
      paramView.showSoftInput(LimitWordCountEditText.a(this.a), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sru
 * JD-Core Version:    0.7.0.1
 */