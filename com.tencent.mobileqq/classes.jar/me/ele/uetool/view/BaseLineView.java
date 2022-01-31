package me.ele.uetool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.util.ViewKnife;

public class BaseLineView
  extends View
{
  private int SCALE_GAP = 5;
  private int SCALE_LENGTH = DimenUtil.dip2px(4.0F);
  private final Paint defPaint = new BaseLineView.4(this, 1);
  @BaseLineView.Direction
  private int direction;
  private float downX;
  private float downY;
  private int heightDP;
  private float initX;
  private float initY;
  private float lastX;
  private float lastY;
  private float moveStartX;
  private float moveStartY;
  private Paint mutablePaint = new BaseLineView.3(this, 1);
  private Paint oldPaint = new BaseLineView.2(this, 1);
  private float oldX;
  private float oldY;
  private Paint paint = new BaseLineView.1(this, 1);
  private int touchSlop;
  private int widthDP;
  
  public BaseLineView(Context paramContext)
  {
    super(paramContext);
    setLayerType(1, null);
    this.touchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public float getLastX()
  {
    return this.lastX;
  }
  
  public float getLastY()
  {
    return this.lastY;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    super.onDraw(paramCanvas);
    paramCanvas.drawRect(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), this.defPaint);
    if (this.initY > 0.0F) {
      paramCanvas.drawLine(0.0F, this.initY, getMeasuredWidth(), this.initY, this.paint);
    }
    if (this.initX > 0.0F) {
      paramCanvas.drawLine(this.initX, 0.0F, this.initX, getMeasuredHeight(), this.paint);
    }
    int i = 0;
    int j;
    float f1;
    float f2;
    float f3;
    for (;;)
    {
      j = k;
      if (i >= this.heightDP) {
        break;
      }
      f1 = this.initX;
      f2 = DimenUtil.dip2px(i);
      f3 = this.initX;
      paramCanvas.drawLine(f1, f2, this.SCALE_LENGTH + f3, DimenUtil.dip2px(i), this.paint);
      i += this.SCALE_GAP;
    }
    while (j < this.widthDP)
    {
      paramCanvas.drawLine(DimenUtil.dip2px(j), this.initY, DimenUtil.dip2px(j), this.initY + this.SCALE_LENGTH, this.paint);
      j += this.SCALE_GAP;
    }
    String str;
    if (this.direction == 1)
    {
      paramCanvas.drawLine(this.initX + this.lastX - this.moveStartX, 0.0F, this.initX + this.lastX - this.moveStartX, getMeasuredHeight(), this.paint);
      f1 = this.lastX - this.moveStartX;
      paramCanvas.drawLine(this.initX, this.initY, this.initX + f1, this.initY, this.mutablePaint);
      this.mutablePaint.setTextAlign(Paint.Align.CENTER);
      str = DimenUtil.px2dip(f1) + "dp";
      f2 = this.initX;
      paramCanvas.drawText(str, f1 / 2.0F + f2, this.initY - DimenUtil.dip2px(12.0F), this.mutablePaint);
    }
    for (;;)
    {
      if (this.oldX > 0.0F) {
        paramCanvas.drawLine(this.oldX, 0.0F, this.oldX, getMeasuredHeight(), this.oldPaint);
      }
      if (this.oldY > 0.0F) {
        paramCanvas.drawLine(0.0F, this.oldY, getMeasuredWidth(), this.oldY, this.oldPaint);
      }
      return;
      if (this.direction == 2)
      {
        paramCanvas.drawLine(0.0F, this.initY + this.lastY - this.moveStartY, getMeasuredWidth(), this.initY + this.lastY - this.moveStartY, this.paint);
        f1 = this.lastY - this.moveStartY;
        paramCanvas.drawLine(this.initX, this.initY, this.initX, this.initY + f1, this.mutablePaint);
        this.mutablePaint.setTextAlign(Paint.Align.LEFT);
        str = DimenUtil.px2dip(f1) + "dp";
        f2 = this.initX;
        f3 = DimenUtil.dip2px(12.0F);
        float f4 = this.initY;
        paramCanvas.drawText(str, f2 + f3, f1 / 2.0F + f4, this.mutablePaint);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.heightDP = ViewKnife.px2dip(getMeasuredHeight());
    this.widthDP = ViewKnife.px2dip(getMeasuredWidth());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      float f1 = paramMotionEvent.getX();
      this.lastX = f1;
      this.downX = f1;
      f1 = paramMotionEvent.getY();
      this.lastY = f1;
      this.downY = f1;
      super.onTouchEvent(paramMotionEvent);
      return true;
      this.lastX = paramMotionEvent.getX();
      this.lastY = paramMotionEvent.getY();
      f1 = this.lastX;
      float f2 = this.downX;
      float f3 = this.lastY;
      float f4 = this.downY;
      if (this.direction == 0)
      {
        if (Math.abs(f1 - f2) <= this.touchSlop) {
          break label188;
        }
        this.direction = 1;
        this.moveStartX = this.lastX;
        this.oldX = this.initX;
        if (this.initY <= 0.0F) {
          this.initY = this.lastY;
        }
      }
      while (this.direction != 0)
      {
        invalidate();
        break;
        label188:
        if (Math.abs(f3 - f4) > this.touchSlop)
        {
          this.direction = 2;
          this.moveStartY = this.lastY;
          this.oldY = this.initY;
          if (this.initX <= 0.0F) {
            this.initX = this.lastX;
          }
        }
      }
      if (this.direction != 0) {
        break;
      }
      this.oldY = 0.0F;
      this.oldX = 0.0F;
      this.initX = paramMotionEvent.getX();
      this.initY = paramMotionEvent.getY();
      invalidate();
    }
    if (this.direction == 1)
    {
      this.oldX = this.initX;
      this.initX += paramMotionEvent.getX() - this.moveStartX;
    }
    for (;;)
    {
      this.direction = 0;
      break;
      if (this.direction == 2)
      {
        this.oldY = this.initY;
        this.initY += paramMotionEvent.getY() - this.moveStartY;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.view.BaseLineView
 * JD-Core Version:    0.7.0.1
 */