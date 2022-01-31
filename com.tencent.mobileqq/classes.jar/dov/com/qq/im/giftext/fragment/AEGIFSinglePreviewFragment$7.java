package dov.com.qq.im.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import bhtr;

public class AEGIFSinglePreviewFragment$7
  implements Runnable
{
  public AEGIFSinglePreviewFragment$7(bhtr parambhtr) {}
  
  public void run()
  {
    if (!bhtr.a(this.this$0).isFinishing())
    {
      if ((bhtr.a(this.this$0) != null) && (bhtr.a(this.this$0).isShowing())) {
        bhtr.a(this.this$0).dismiss();
      }
      if (bhtr.a(this.this$0) != null) {
        bhtr.a(this.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.giftext.fragment.AEGIFSinglePreviewFragment.7
 * JD-Core Version:    0.7.0.1
 */