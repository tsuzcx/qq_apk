package com.tencent.mobileqq.shortvideo.widget;

import android.graphics.Canvas;
import android.graphics.Paint;

class TCProgressBar$BlinkBlock
  extends TCProgressBar.Draw
{
  TCProgressBar$BlinkBlock(TCProgressBar paramTCProgressBar)
  {
    super(paramTCProgressBar);
  }
  
  void a(Canvas paramCanvas)
  {
    this.a.y.left = this.k;
    this.a.y.right = (this.k + this.l);
    this.a.i.setColor(this.a.w);
    paramCanvas.drawRect(this.a.y, this.a.i);
    super.a(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.TCProgressBar.BlinkBlock
 * JD-Core Version:    0.7.0.1
 */