package cooperation.qzone;

import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import bbdv;
import bhac;

public class QzoneGiftFullScreenViewController$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$2(bhac parambhac) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.a.getLayoutParams();
    localLayoutParams.rightMargin = ((int)bbdv.a(bhac.a(this.this$0), 10.0F));
    this.this$0.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.2
 * JD-Core Version:    0.7.0.1
 */