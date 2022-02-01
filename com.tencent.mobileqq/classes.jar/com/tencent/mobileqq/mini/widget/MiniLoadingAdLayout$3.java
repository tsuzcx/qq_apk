package com.tencent.mobileqq.mini.widget;

import android.os.Handler;
import android.widget.TextView;

class MiniLoadingAdLayout$3
  implements Runnable
{
  MiniLoadingAdLayout$3(MiniLoadingAdLayout paramMiniLoadingAdLayout, MiniLoadingAdLayout.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    MiniLoadingAdLayout.access$410(this.this$0);
    if (MiniLoadingAdLayout.access$400(this.this$0) == MiniLoadingAdLayout.access$500(this.this$0)) {
      MiniLoadingAdLayout.access$600(this.this$0).setVisibility(0);
    }
    if (MiniLoadingAdLayout.access$400(this.this$0) > 0)
    {
      TextView localTextView = MiniLoadingAdLayout.access$700(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MiniLoadingAdLayout.access$400(this.this$0));
      localStringBuilder.append("秒");
      localTextView.setText(localStringBuilder.toString());
      MiniLoadingAdLayout.access$800(this.this$0).postDelayed(this, 1000L);
      return;
    }
    this.this$0.dismiss(false, this.val$onDismissListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.3
 * JD-Core Version:    0.7.0.1
 */