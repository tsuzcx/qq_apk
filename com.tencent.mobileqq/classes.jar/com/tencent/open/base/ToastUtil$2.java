package com.tencent.open.base;

import android.widget.Toast;
import bizw;
import bjkv;

public class ToastUtil$2
  implements Runnable
{
  public ToastUtil$2(bjkv parambjkv, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      this.this$0.a = Toast.makeText(bizw.a().a(), this.a, this.b);
      this.this$0.a.show();
      return;
    }
    this.this$0.a.setText(this.a);
    this.this$0.a.setDuration(this.b);
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.base.ToastUtil.2
 * JD-Core Version:    0.7.0.1
 */