package com.tencent.mobileqq.forward;

import android.view.WindowManager;
import aurs;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

public class ForwardNewVersionDialog$8
  implements Runnable
{
  public ForwardNewVersionDialog$8(aurs paramaurs) {}
  
  public void run()
  {
    if (aurs.b(this.this$0)) {
      return;
    }
    aurs.a(this.this$0).addView(aurs.a(this.this$0), aurs.a(this.this$0));
    aurs.a(this.this$0, true);
    aurs.a(this.this$0).post(new ForwardNewVersionDialog.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.8
 * JD-Core Version:    0.7.0.1
 */