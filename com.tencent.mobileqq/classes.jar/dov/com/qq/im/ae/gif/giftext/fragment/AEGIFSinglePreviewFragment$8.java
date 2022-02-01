package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class AEGIFSinglePreviewFragment$8
  implements Runnable
{
  AEGIFSinglePreviewFragment$8(AEGIFSinglePreviewFragment paramAEGIFSinglePreviewFragment) {}
  
  public void run()
  {
    if (AEGIFSinglePreviewFragment.a(this.this$0) == null)
    {
      AEGIFSinglePreviewFragment.a(this.this$0, new ReportDialog(AEGIFSinglePreviewFragment.a(this.this$0), 2131755842));
      AEGIFSinglePreviewFragment.a(this.this$0).setCancelable(false);
      AEGIFSinglePreviewFragment.a(this.this$0).setCanceledOnTouchOutside(false);
      AEGIFSinglePreviewFragment.a(this.this$0).setContentView(2131559329);
    }
    if (AEGIFSinglePreviewFragment.a(this.this$0) != null) {
      AEGIFSinglePreviewFragment.a(this.this$0).setVisibility(0);
    }
    AEGIFSinglePreviewFragment.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
 * JD-Core Version:    0.7.0.1
 */