package me.ele.uetool.dialog;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import me.ele.uetool.util.Util;

class MultipleAttrsDialog$Adapter$EditTextViewHolder$2
  implements View.OnClickListener
{
  MultipleAttrsDialog$Adapter$EditTextViewHolder$2(MultipleAttrsDialog.Adapter.EditTextViewHolder paramEditTextViewHolder, View paramView) {}
  
  public void onClick(View paramView)
  {
    MultipleAttrsDialog.access$002(this.this$0.getAdapterPosition());
    Util.showColorPickerDialog(Color.parseColor(this.this$0.vDetail.getText().toString()), new MultipleAttrsDialog.Adapter.EditTextViewHolder.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.Adapter.EditTextViewHolder.2
 * JD-Core Version:    0.7.0.1
 */