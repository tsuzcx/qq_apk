package cooperation.qzone.share;

import android.view.View;
import android.view.View.OnClickListener;

class QZoneShareActivity$12
  implements View.OnClickListener
{
  QZoneShareActivity$12(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.this$0.emoShow)
    {
      this.this$0.showEmoView();
      return;
    }
    this.this$0.showKeyboard();
    this.this$0.hideEmoView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.12
 * JD-Core Version:    0.7.0.1
 */