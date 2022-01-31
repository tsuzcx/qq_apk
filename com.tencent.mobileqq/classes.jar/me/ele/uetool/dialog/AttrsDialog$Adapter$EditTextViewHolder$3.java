package me.ele.uetool.dialog;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import me.ele.uetool.base.Application;

class AttrsDialog$Adapter$EditTextViewHolder$3
  implements View.OnClickListener
{
  AttrsDialog$Adapter$EditTextViewHolder$3(AttrsDialog.Adapter.EditTextViewHolder paramEditTextViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.vDetail.getText().length() == 0)
    {
      this.this$0.vDetail.requestFocus();
      ((InputMethodManager)Application.getApplicationContext().getSystemService("input_method")).showSoftInput(this.this$0.vDetail, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.EditTextViewHolder.3
 * JD-Core Version:    0.7.0.1
 */