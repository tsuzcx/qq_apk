package cooperation.qzone.share;

import android.text.Editable;
import android.widget.EditText;

class QZoneShareActivity$14
  implements Runnable
{
  QZoneShareActivity$14(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    Editable localEditable;
    if (this.this$0.a != null)
    {
      localEditable = this.this$0.a.getText();
      if (localEditable == null) {
        break label71;
      }
    }
    label71:
    for (int i = localEditable.length();; i = 0)
    {
      this.this$0.a.setSelection(i);
      if ((!this.this$0.isFinishing()) && (!this.this$0.d)) {
        this.this$0.h();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.14
 * JD-Core Version:    0.7.0.1
 */