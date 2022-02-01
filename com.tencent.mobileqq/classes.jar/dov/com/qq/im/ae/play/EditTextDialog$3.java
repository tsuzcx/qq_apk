package dov.com.qq.im.ae.play;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditTextDialog$3
  implements View.OnClickListener
{
  EditTextDialog$3(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    EditTextDialog.access$300(this.this$0).setText(null);
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextDialog.3
 * JD-Core Version:    0.7.0.1
 */