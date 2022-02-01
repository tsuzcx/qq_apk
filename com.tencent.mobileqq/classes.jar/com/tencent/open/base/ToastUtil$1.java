package com.tencent.open.base;

import android.widget.Toast;
import com.tencent.open.adapter.CommonDataAdapter;

class ToastUtil$1
  implements Runnable
{
  ToastUtil$1(ToastUtil paramToastUtil, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.b == null)
    {
      this.this$0.b = Toast.makeText(CommonDataAdapter.a().b(), this.a, this.b);
      this.this$0.b.show();
      return;
    }
    this.this$0.b.setText(this.a);
    this.this$0.b.setDuration(this.b);
    this.this$0.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil.1
 * JD-Core Version:    0.7.0.1
 */