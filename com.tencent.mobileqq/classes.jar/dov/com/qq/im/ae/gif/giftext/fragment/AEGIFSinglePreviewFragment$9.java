package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import bouf;

public class AEGIFSinglePreviewFragment$9
  implements Runnable
{
  public AEGIFSinglePreviewFragment$9(bouf parambouf) {}
  
  public void run()
  {
    if (!bouf.a(this.this$0).isFinishing())
    {
      if ((bouf.a(this.this$0) != null) && (bouf.a(this.this$0).isShowing())) {
        bouf.a(this.this$0).dismiss();
      }
      if (bouf.a(this.this$0) != null) {
        bouf.a(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */