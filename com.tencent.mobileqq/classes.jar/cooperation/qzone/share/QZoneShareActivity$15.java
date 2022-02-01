package cooperation.qzone.share;

import android.text.Editable;
import android.widget.EditText;

class QZoneShareActivity$15
  implements Runnable
{
  QZoneShareActivity$15(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    if (this.this$0.mViewEdit != null)
    {
      Editable localEditable = this.this$0.mViewEdit.getText();
      int i;
      if (localEditable != null) {
        i = localEditable.length();
      } else {
        i = 0;
      }
      this.this$0.mViewEdit.setSelection(i);
    }
    if ((!this.this$0.isFinishing()) && (!this.this$0.emoShow)) {
      this.this$0.showKeyboard();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.15
 * JD-Core Version:    0.7.0.1
 */