package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;
import bldk;

public class AEGIFSinglePreviewFragment$8
  implements Runnable
{
  public AEGIFSinglePreviewFragment$8(bldk parambldk) {}
  
  public void run()
  {
    if (bldk.a(this.this$0) == null)
    {
      bldk.a(this.this$0, new Dialog(bldk.a(this.this$0), 2131755801));
      bldk.a(this.this$0).setCancelable(false);
      bldk.a(this.this$0).setCanceledOnTouchOutside(false);
      bldk.a(this.this$0).setContentView(2131559163);
    }
    if (bldk.a(this.this$0) != null) {
      bldk.a(this.this$0).setVisibility(0);
    }
    bldk.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8
 * JD-Core Version:    0.7.0.1
 */