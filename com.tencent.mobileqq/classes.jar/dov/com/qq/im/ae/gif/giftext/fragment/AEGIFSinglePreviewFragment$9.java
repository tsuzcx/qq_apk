package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import bkzd;

public class AEGIFSinglePreviewFragment$9
  implements Runnable
{
  public AEGIFSinglePreviewFragment$9(bkzd parambkzd) {}
  
  public void run()
  {
    if (!bkzd.a(this.this$0).isFinishing())
    {
      if ((bkzd.a(this.this$0) != null) && (bkzd.a(this.this$0).isShowing())) {
        bkzd.a(this.this$0).dismiss();
      }
      if (bkzd.a(this.this$0) != null) {
        bkzd.a(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */