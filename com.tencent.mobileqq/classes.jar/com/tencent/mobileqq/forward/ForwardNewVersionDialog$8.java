package com.tencent.mobileqq.forward;

import android.view.WindowManager;
import auhv;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

public class ForwardNewVersionDialog$8
  implements Runnable
{
  public ForwardNewVersionDialog$8(auhv paramauhv) {}
  
  public void run()
  {
    if (auhv.b(this.this$0)) {
      return;
    }
    auhv.a(this.this$0).addView(auhv.a(this.this$0), auhv.a(this.this$0));
    auhv.a(this.this$0, true);
    auhv.a(this.this$0).post(new ForwardNewVersionDialog.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.8
 * JD-Core Version:    0.7.0.1
 */