package cooperation.qzone.share;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;

class QZoneShareActivity$13
  implements Runnable
{
  QZoneShareActivity$13(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    this.this$0.viewEmoView.setVisibility(0);
    this.this$0.viewDivider.setVisibility(0);
    this.this$0.viewSmiley.setImageResource(2130848980);
    this.this$0.emoShow = true;
    this.this$0.emoShowing = false;
    QZoneShareActivity.access$1700(this.this$0, this.this$0.emoShow);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.13
 * JD-Core Version:    0.7.0.1
 */