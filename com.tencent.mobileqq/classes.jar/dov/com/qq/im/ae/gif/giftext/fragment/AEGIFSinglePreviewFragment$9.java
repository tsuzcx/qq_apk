package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import bnnu;

public class AEGIFSinglePreviewFragment$9
  implements Runnable
{
  public AEGIFSinglePreviewFragment$9(bnnu parambnnu) {}
  
  public void run()
  {
    if (!bnnu.a(this.this$0).isFinishing())
    {
      if ((bnnu.a(this.this$0) != null) && (bnnu.a(this.this$0).isShowing())) {
        bnnu.a(this.this$0).dismiss();
      }
      if (bnnu.a(this.this$0) != null) {
        bnnu.a(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */