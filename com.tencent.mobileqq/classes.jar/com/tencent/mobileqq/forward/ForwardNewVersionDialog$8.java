package com.tencent.mobileqq.forward;

import android.view.WindowManager;
import auzt;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

public class ForwardNewVersionDialog$8
  implements Runnable
{
  public ForwardNewVersionDialog$8(auzt paramauzt) {}
  
  public void run()
  {
    if (auzt.b(this.this$0)) {
      return;
    }
    auzt.a(this.this$0).addView(auzt.a(this.this$0), auzt.a(this.this$0));
    auzt.a(this.this$0, true);
    auzt.a(this.this$0).post(new ForwardNewVersionDialog.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.8
 * JD-Core Version:    0.7.0.1
 */