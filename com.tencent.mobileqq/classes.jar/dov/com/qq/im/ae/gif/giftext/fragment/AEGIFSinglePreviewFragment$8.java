package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;
import blyk;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class AEGIFSinglePreviewFragment$8
  implements Runnable
{
  public AEGIFSinglePreviewFragment$8(blyk paramblyk) {}
  
  public void run()
  {
    if (blyk.a(this.this$0) == null)
    {
      blyk.a(this.this$0, new ReportDialog(blyk.a(this.this$0), 2131755826));
      blyk.a(this.this$0).setCancelable(false);
      blyk.a(this.this$0).setCanceledOnTouchOutside(false);
      blyk.a(this.this$0).setContentView(2131559249);
    }
    if (blyk.a(this.this$0) != null) {
      blyk.a(this.this$0).setVisibility(0);
    }
    blyk.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
 * JD-Core Version:    0.7.0.1
 */