package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.os.Build.VERSION;
import bqcu;
import bqhs;

public class EditProviderPart$3
  implements Runnable
{
  public EditProviderPart$3(bqcu parambqcu) {}
  
  public void run()
  {
    if ((this.this$0.b) || (this.this$0.a == null)) {}
    while ((this.this$0.a.getActivity() == null) || (this.this$0.a.getActivity().isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (this.this$0.a.getActivity().isDestroyed()))) {
      return;
    }
    this.this$0.b = true;
    this.this$0.d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.3
 * JD-Core Version:    0.7.0.1
 */