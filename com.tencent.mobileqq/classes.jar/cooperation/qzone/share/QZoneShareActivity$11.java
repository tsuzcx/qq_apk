package cooperation.qzone.share;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

class QZoneShareActivity$11
  implements View.OnTouchListener
{
  QZoneShareActivity$11(QZoneShareActivity paramQZoneShareActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.this$0.hideEmoView();
    if ((!this.this$0.hintHidden) && (this.this$0.mViewEdit != null))
    {
      this.this$0.mViewEdit.setHint("");
      this.this$0.hintHidden = true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.11
 * JD-Core Version:    0.7.0.1
 */