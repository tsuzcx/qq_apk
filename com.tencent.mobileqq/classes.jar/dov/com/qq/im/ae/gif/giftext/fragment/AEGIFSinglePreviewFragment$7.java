package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import bitt;

public class AEGIFSinglePreviewFragment$7
  implements Runnable
{
  public AEGIFSinglePreviewFragment$7(bitt parambitt) {}
  
  public void run()
  {
    if (!bitt.a(this.this$0).isFinishing())
    {
      if ((bitt.a(this.this$0) != null) && (bitt.a(this.this$0).isShowing())) {
        bitt.a(this.this$0).dismiss();
      }
      if (bitt.a(this.this$0) != null) {
        bitt.a(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.7
 * JD-Core Version:    0.7.0.1
 */