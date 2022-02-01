package cooperation.qzone;

import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import bhmg;
import bmuu;

public class QzoneGiftFullScreenViewController$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$2(bmuu parambmuu) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.a.getLayoutParams();
    localLayoutParams.rightMargin = ((int)bhmg.a(bmuu.a(this.this$0), 10.0F));
    this.this$0.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.2
 * JD-Core Version:    0.7.0.1
 */