package com.tencent.mobileqq.qqlive.widget;

class PortraitImageView$3
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.a, (float)(l - this.b));
    float f2 = this.c;
    float f3 = this.d;
    this.this$0.a(f2 + f3 * f1, this.e, this.f);
    if (f1 < this.a) {
      this.this$0.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.widget.PortraitImageView.3
 * JD-Core Version:    0.7.0.1
 */