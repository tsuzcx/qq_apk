package com.tencent.mobileqq.shortvideo.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qphone.base.util.QLog;

class TCProgressBar$ProgressBlock
  extends TCProgressBar.Draw
{
  boolean a;
  int b;
  int c;
  int d;
  boolean e;
  boolean f;
  boolean g = false;
  boolean h = false;
  
  TCProgressBar$ProgressBlock(TCProgressBar paramTCProgressBar, boolean paramBoolean)
  {
    super(paramTCProgressBar);
    this.f = paramBoolean;
  }
  
  void a(Canvas paramCanvas)
  {
    if (this.f)
    {
      this.i.y.left = this.k;
      this.i.y.right = (this.k + this.l);
      this.i.i.setColor(this.i.q);
      paramCanvas.drawRect(this.i.y, this.i.i);
      this.i.i.setColor(this.i.r);
    }
    else
    {
      int j;
      if (this.o)
      {
        j = this.l;
      }
      else
      {
        j = this.l - this.i.v;
        this.i.y.left = (this.k + j);
        this.i.y.right = (this.k + this.l);
        this.i.i.setColor(this.i.u);
        paramCanvas.drawRect(this.i.y, this.i.i);
      }
      boolean bool = a(this.b - 5);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ProgressBlock:hasMorePart=");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" bounds=");
        localStringBuilder.append(bool);
        QLog.d("TCProgressBar", 2, localStringBuilder.toString());
      }
      if ((this.a) && (bool))
      {
        this.i.y.left = this.k;
        this.i.y.right = this.b;
        this.i.i.setColor(this.i.s);
        paramCanvas.drawRect(this.i.y, this.i.i);
        this.i.y.left = this.b;
        this.i.y.right = (this.k + j);
        this.i.i.setColor(this.i.t);
        paramCanvas.drawRect(this.i.y, this.i.i);
      }
      else
      {
        this.i.y.left = this.k;
        this.i.y.right = (this.k + j);
        if (this.e) {
          this.i.i.setColor(this.i.t);
        } else {
          this.i.i.setColor(this.i.s);
        }
        paramCanvas.drawRect(this.i.y, this.i.i);
      }
    }
    super.a(paramCanvas);
  }
  
  boolean a(int paramInt)
  {
    return (paramInt > this.k) && (paramInt < this.k + this.l - this.i.v);
  }
  
  boolean b(int paramInt)
  {
    return (paramInt < this.k) || (a(paramInt));
  }
  
  boolean c(int paramInt)
  {
    return (paramInt > this.k + this.l) || (a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.TCProgressBar.ProgressBlock
 * JD-Core Version:    0.7.0.1
 */