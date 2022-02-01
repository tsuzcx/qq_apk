package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

final class DialogUtil$4
  extends QQCustomDialog
{
  private Handler d = new Handler(Looper.getMainLooper());
  private int e = this.a;
  
  DialogUtil$4(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    super(paramContext, paramInt1);
  }
  
  private Runnable a()
  {
    return new DialogUtil.4.1(this);
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.e > 0)
    {
      this.lBtn.setText(String.format("%s(%d)", new Object[] { this.c, Integer.valueOf(this.e) }));
      this.d.postDelayed(paramRunnable, 1000L);
      return;
    }
    this.lBtn.setText(this.c);
    this.e = this.a;
    this.lBtn.setEnabled(true);
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.d.removeCallbacksAndMessages(null);
  }
  
  public void onBackPressed() {}
  
  public void show()
  {
    super.show();
    if ((this.b) && (this.e > 0))
    {
      this.lBtn.setText(String.format("%s(%d)", new Object[] { this.c, Integer.valueOf(this.e) }));
      this.lBtn.setEnabled(false);
      this.d.postDelayed(a(), 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil.4
 * JD-Core Version:    0.7.0.1
 */