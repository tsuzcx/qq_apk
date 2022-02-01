package cooperation.qzone.music;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QzoneWebMusicJsPlugin$19
  implements View.OnClickListener
{
  QzoneWebMusicJsPlugin$19(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(View paramView)
  {
    QzoneWebMusicJsPlugin.access$300(this.this$0, "buttonclick");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.19
 * JD-Core Version:    0.7.0.1
 */