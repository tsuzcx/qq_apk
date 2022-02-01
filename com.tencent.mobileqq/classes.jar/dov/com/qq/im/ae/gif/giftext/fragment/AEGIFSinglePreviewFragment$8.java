package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;
import bnss;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class AEGIFSinglePreviewFragment$8
  implements Runnable
{
  public AEGIFSinglePreviewFragment$8(bnss parambnss) {}
  
  public void run()
  {
    if (bnss.a(this.this$0) == null)
    {
      bnss.a(this.this$0, new ReportDialog(bnss.a(this.this$0), 2131755823));
      bnss.a(this.this$0).setCancelable(false);
      bnss.a(this.this$0).setCanceledOnTouchOutside(false);
      bnss.a(this.this$0).setContentView(2131559242);
    }
    if (bnss.a(this.this$0) != null) {
      bnss.a(this.this$0).setVisibility(0);
    }
    bnss.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
 * JD-Core Version:    0.7.0.1
 */