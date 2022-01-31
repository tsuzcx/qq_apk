package me.ele.uetool.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import me.ele.uetool.base.item.AddMinusEditItem.CustomAddMin;

class AttrsDialog$Adapter$AddMinusEditViewHolder$2
  implements View.OnClickListener
{
  AttrsDialog$Adapter$AddMinusEditViewHolder$2(AttrsDialog.Adapter.AddMinusEditViewHolder paramAddMinusEditViewHolder) {}
  
  public void onClick(View paramView)
  {
    try
    {
      float f = Float.valueOf(this.this$0.vDetail.getText().toString()).floatValue();
      if (f > 0.0F) {
        this.this$0.vDetail.setText(String.valueOf(AttrsDialog.Adapter.AddMinusEditViewHolder.access$200(this.this$0).min((int)f)));
      }
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.dialog.AttrsDialog.Adapter.AddMinusEditViewHolder.2
 * JD-Core Version:    0.7.0.1
 */