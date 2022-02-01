package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import blyk;

public class AEGIFSinglePreviewFragment$9
  implements Runnable
{
  public AEGIFSinglePreviewFragment$9(blyk paramblyk) {}
  
  public void run()
  {
    if (!blyk.a(this.this$0).isFinishing())
    {
      if ((blyk.a(this.this$0) != null) && (blyk.a(this.this$0).isShowing())) {
        blyk.a(this.this$0).dismiss();
      }
      if (blyk.a(this.this$0) != null) {
        blyk.a(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */