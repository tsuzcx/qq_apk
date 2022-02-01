package cooperation.qzone;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QzoneTranslucentBrowserFragment$1
  implements View.OnClickListener
{
  QzoneTranslucentBrowserFragment$1(QzoneTranslucentBrowserFragment paramQzoneTranslucentBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.getHostActivity() != null) {
      this.this$0.getHostActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneTranslucentBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */