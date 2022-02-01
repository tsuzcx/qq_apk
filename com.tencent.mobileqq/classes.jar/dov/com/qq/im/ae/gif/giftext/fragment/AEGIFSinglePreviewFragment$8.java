package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;
import bnnu;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class AEGIFSinglePreviewFragment$8
  implements Runnable
{
  public AEGIFSinglePreviewFragment$8(bnnu parambnnu) {}
  
  public void run()
  {
    if (bnnu.a(this.this$0) == null)
    {
      bnnu.a(this.this$0, new ReportDialog(bnnu.a(this.this$0), 2131755829));
      bnnu.a(this.this$0).setCancelable(false);
      bnnu.a(this.this$0).setCanceledOnTouchOutside(false);
      bnnu.a(this.this$0).setContentView(2131559288);
    }
    if (bnnu.a(this.this$0) != null) {
      bnnu.a(this.this$0).setVisibility(0);
    }
    bnnu.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
 * JD-Core Version:    0.7.0.1
 */