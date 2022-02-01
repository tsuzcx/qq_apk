package com.tencent.open.base;

import android.view.View;
import android.widget.Toast;
import com.tencent.open.adapter.CommonDataAdapter;

class ToastUtil$3
  implements Runnable
{
  ToastUtil$3(ToastUtil paramToastUtil, View paramView, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.c == null)
    {
      this.this$0.c = new Toast(CommonDataAdapter.a().b());
      this.this$0.c.setView(this.a);
      this.this$0.c.setDuration(this.b);
      this.this$0.c.show();
      return;
    }
    this.this$0.c.setView(this.a);
    this.this$0.c.setDuration(this.b);
    this.this$0.c.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil.3
 * JD-Core Version:    0.7.0.1
 */