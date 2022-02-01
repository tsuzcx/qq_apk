package com.tencent.mobileqq.forward;

import android.view.WindowManager;
import atmx;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

public class ForwardNewVersionDialog$8
  implements Runnable
{
  public ForwardNewVersionDialog$8(atmx paramatmx) {}
  
  public void run()
  {
    if (atmx.b(this.this$0)) {
      return;
    }
    atmx.a(this.this$0).addView(atmx.a(this.this$0), atmx.a(this.this$0));
    atmx.a(this.this$0, true);
    atmx.a(this.this$0).post(new ForwardNewVersionDialog.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.8
 * JD-Core Version:    0.7.0.1
 */