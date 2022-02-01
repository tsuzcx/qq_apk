package com.tencent.mobileqq.forward;

import android.view.WindowManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

class ForwardNewVersionDialog$8
  implements Runnable
{
  ForwardNewVersionDialog$8(ForwardNewVersionDialog paramForwardNewVersionDialog) {}
  
  public void run()
  {
    if (ForwardNewVersionDialog.b(this.this$0)) {
      return;
    }
    ForwardNewVersionDialog.a(this.this$0).addView(ForwardNewVersionDialog.a(this.this$0), ForwardNewVersionDialog.a(this.this$0));
    ForwardNewVersionDialog.a(this.this$0, true);
    ForwardNewVersionDialog.a(this.this$0).post(new ForwardNewVersionDialog.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.8
 * JD-Core Version:    0.7.0.1
 */