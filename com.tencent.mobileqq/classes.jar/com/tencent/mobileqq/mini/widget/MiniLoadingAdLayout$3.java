package com.tencent.mobileqq.mini.widget;

import android.os.Handler;
import android.widget.TextView;

class MiniLoadingAdLayout$3
  implements Runnable
{
  MiniLoadingAdLayout$3(MiniLoadingAdLayout paramMiniLoadingAdLayout, MiniLoadingAdLayout.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    MiniLoadingAdLayout.access$610(this.this$0);
    if (MiniLoadingAdLayout.access$600(this.this$0) == MiniLoadingAdLayout.access$700(this.this$0)) {
      MiniLoadingAdLayout.access$800(this.this$0).setVisibility(0);
    }
    if (MiniLoadingAdLayout.access$600(this.this$0) > 0)
    {
      MiniLoadingAdLayout.access$900(this.this$0).setText(MiniLoadingAdLayout.access$600(this.this$0) + "秒");
      MiniLoadingAdLayout.access$1000(this.this$0).postDelayed(this, 1000L);
      return;
    }
    this.this$0.dismiss(false, this.val$onDismissListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.3
 * JD-Core Version:    0.7.0.1
 */