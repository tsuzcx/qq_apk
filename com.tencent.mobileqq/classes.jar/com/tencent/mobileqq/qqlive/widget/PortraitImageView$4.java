package com.tencent.mobileqq.qqlive.widget;

class PortraitImageView$4
  implements Runnable
{
  float a;
  float b;
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.c, (float)(l - this.d));
    float f2 = this.this$0.a(f1, 0.0F, this.e, this.c);
    float f3 = this.this$0.a(f1, 0.0F, this.f, this.c);
    this.this$0.a(f2 - this.a, f3 - this.b);
    PortraitImageView localPortraitImageView = this.this$0;
    localPortraitImageView.setImageMatrix(localPortraitImageView.getImageViewMatrix());
    this.a = f2;
    this.b = f3;
    if (f1 < this.c) {
      this.this$0.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.widget.PortraitImageView.4
 * JD-Core Version:    0.7.0.1
 */