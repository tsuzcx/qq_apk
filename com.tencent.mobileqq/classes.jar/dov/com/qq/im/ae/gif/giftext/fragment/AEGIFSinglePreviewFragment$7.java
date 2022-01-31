package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import biuk;

public class AEGIFSinglePreviewFragment$7
  implements Runnable
{
  public AEGIFSinglePreviewFragment$7(biuk parambiuk) {}
  
  public void run()
  {
    if (!biuk.a(this.this$0).isFinishing())
    {
      if ((biuk.a(this.this$0) != null) && (biuk.a(this.this$0).isShowing())) {
        biuk.a(this.this$0).dismiss();
      }
      if (biuk.a(this.this$0) != null) {
        biuk.a(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.7
 * JD-Core Version:    0.7.0.1
 */