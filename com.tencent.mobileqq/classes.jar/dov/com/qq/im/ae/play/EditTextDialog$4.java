package dov.com.qq.im.ae.play;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditTextDialog$4
  implements View.OnClickListener
{
  EditTextDialog$4(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    EditTextDialog.access$300(this.this$0).setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextDialog.4
 * JD-Core Version:    0.7.0.1
 */