package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;
import bkzd;

public class AEGIFSinglePreviewFragment$8
  implements Runnable
{
  public AEGIFSinglePreviewFragment$8(bkzd parambkzd) {}
  
  public void run()
  {
    if (bkzd.a(this.this$0) == null)
    {
      bkzd.a(this.this$0, new Dialog(bkzd.a(this.this$0), 2131755801));
      bkzd.a(this.this$0).setCancelable(false);
      bkzd.a(this.this$0).setCanceledOnTouchOutside(false);
      bkzd.a(this.this$0).setContentView(2131559164);
    }
    if (bkzd.a(this.this$0) != null) {
      bkzd.a(this.this$0).setVisibility(0);
    }
    bkzd.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
 * JD-Core Version:    0.7.0.1
 */