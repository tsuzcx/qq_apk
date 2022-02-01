package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;
import bouf;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class AEGIFSinglePreviewFragment$8
  implements Runnable
{
  public AEGIFSinglePreviewFragment$8(bouf parambouf) {}
  
  public void run()
  {
    if (bouf.a(this.this$0) == null)
    {
      bouf.a(this.this$0, new ReportDialog(bouf.a(this.this$0), 2131755824));
      bouf.a(this.this$0).setCancelable(false);
      bouf.a(this.this$0).setCanceledOnTouchOutside(false);
      bouf.a(this.this$0).setContentView(2131559242);
    }
    if (bouf.a(this.this$0) != null) {
      bouf.a(this.this$0).setVisibility(0);
    }
    bouf.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
 * JD-Core Version:    0.7.0.1
 */