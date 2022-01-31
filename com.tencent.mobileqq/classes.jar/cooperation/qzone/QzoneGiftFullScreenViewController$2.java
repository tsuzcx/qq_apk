package cooperation.qzone;

import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import bdcq;
import bjbf;

public class QzoneGiftFullScreenViewController$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$2(bjbf parambjbf) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.a.getLayoutParams();
    localLayoutParams.rightMargin = ((int)bdcq.a(bjbf.a(this.this$0), 10.0F));
    this.this$0.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.2
 * JD-Core Version:    0.7.0.1
 */