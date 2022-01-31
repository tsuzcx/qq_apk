package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import bldk;

public class AEGIFSinglePreviewFragment$9
  implements Runnable
{
  public AEGIFSinglePreviewFragment$9(bldk parambldk) {}
  
  public void run()
  {
    if (!bldk.a(this.this$0).isFinishing())
    {
      if ((bldk.a(this.this$0) != null) && (bldk.a(this.this$0).isShowing())) {
        bldk.a(this.this$0).dismiss();
      }
      if (bldk.a(this.this$0) != null) {
        bldk.a(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */