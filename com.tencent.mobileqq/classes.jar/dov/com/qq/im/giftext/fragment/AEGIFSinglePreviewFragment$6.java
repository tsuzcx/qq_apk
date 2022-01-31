package dov.com.qq.im.giftext.fragment;

import android.app.Dialog;
import android.view.View;
import bhtr;

public class AEGIFSinglePreviewFragment$6
  implements Runnable
{
  public AEGIFSinglePreviewFragment$6(bhtr parambhtr) {}
  
  public void run()
  {
    if (bhtr.a(this.this$0) == null)
    {
      bhtr.a(this.this$0, new Dialog(bhtr.a(this.this$0), 2131690181));
      bhtr.a(this.this$0).setCancelable(false);
      bhtr.a(this.this$0).setCanceledOnTouchOutside(false);
      bhtr.a(this.this$0).setContentView(2131493552);
    }
    if (bhtr.a(this.this$0) != null) {
      bhtr.a(this.this$0).setVisibility(0);
    }
    bhtr.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.giftext.fragment.AEGIFSinglePreviewFragment.6
 * JD-Core Version:    0.7.0.1
 */