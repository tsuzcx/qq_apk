package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.widget.TextView;

class ReadInJoyNewFeedsActivity$16
  implements Runnable
{
  ReadInJoyNewFeedsActivity$16(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    if (i <= 0)
    {
      this.this$0.a.setText(2131719442);
      return;
    }
    if (i > 99)
    {
      this.this$0.a.setText(String.format("%s(%d+)", new Object[] { this.this$0.getString(2131719442), Integer.valueOf(99) }));
      return;
    }
    this.this$0.a.setText(String.format("%s(%d)", new Object[] { this.this$0.getString(2131719442), Integer.valueOf(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity.16
 * JD-Core Version:    0.7.0.1
 */