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
    this.this$0.viewSmiley.setImageResource(2130851022);
    QZoneShareActivity localQZoneShareActivity = this.this$0;
    localQZoneShareActivity.emoShow = true;
    localQZoneShareActivity.emoShowing = false;
    QZoneShareActivity.access$1700(localQZoneShareActivity, localQZoneShareActivity.emoShow);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.13
 * JD-Core Version:    0.7.0.1
 */