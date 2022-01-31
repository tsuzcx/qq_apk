package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.view.View;
import biuk;

public class AEGIFSinglePreviewFragment$6
  implements Runnable
{
  public AEGIFSinglePreviewFragment$6(biuk parambiuk) {}
  
  public void run()
  {
    if (biuk.a(this.this$0) == null)
    {
      biuk.a(this.this$0, new Dialog(biuk.a(this.this$0), 2131755791));
      biuk.a(this.this$0).setCancelable(false);
      biuk.a(this.this$0).setCanceledOnTouchOutside(false);
      biuk.a(this.this$0).setContentView(2131559121);
    }
    if (biuk.a(this.this$0) != null) {
      biuk.a(this.this$0).setVisibility(0);
    }
    biuk.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.6
 * JD-Core Version:    0.7.0.1
 */