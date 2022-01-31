package me.ele.uetool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;

public class RelativePositionLayout
  extends CollectViewsLayout
{
  private Paint areaPaint = new RelativePositionLayout.1(this);
  private final int elementsNum = 2;
  private Element[] relativeElements = new Element[2];
  private int searchCount = 0;
  
  public RelativePositionLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RelativePositionLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RelativePositionLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayerType(1, null);
  }
  
  private void drawNestedAreaLine(Canvas paramCanvas, Rect paramRect1, Rect paramRect2)
  {
    if ((paramRect2.left >= paramRect1.left) && (paramRect2.right <= paramRect1.right) && (paramRect2.top >= paramRect1.top) && (paramRect2.bottom <= paramRect1.bottom))
    {
      drawLineWithText(paramCanvas, paramRect2.left, paramRect2.top + paramRect2.height() / 2, paramRect1.left, paramRect2.top + paramRect2.height() / 2);
      drawLineWithText(paramCanvas, paramRect2.right, paramRect2.top + paramRect2.height() / 2, paramRect1.right, paramRect2.top + paramRect2.height() / 2);
      drawLineWithText(paramCanvas, paramRect2.left + paramRect2.width() / 2, paramRect2.top, paramRect2.left + paramRect2.width() / 2, paramRect1.top);
      drawLineWithText(paramCanvas, paramRect2.left + paramRect2.width() / 2, paramRect2.bottom, paramRect2.left + paramRect2.width() / 2, paramRect1.bottom);
    }
  }
  
  protected void drawLineWithText(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    drawLineWithText(paramCanvas, paramInt1, paramInt2, paramInt3, paramInt4, DimenUtil.dip2px(2.0F));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.relativeElements = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.relativeElements == null) {}
    int i;
    do
    {
      return;
      i = 1;
      localObject = this.relativeElements;
      int k = localObject.length;
      int j = 0;
      if (j < k)
      {
        localRect = localObject[j];
        if (localRect != null)
        {
          localRect = localRect.getRect();
          paramCanvas.drawLine(0.0F, localRect.top, this.screenWidth, localRect.top, this.dashLinePaint);
          paramCanvas.drawLine(0.0F, localRect.bottom, this.screenWidth, localRect.bottom, this.dashLinePaint);
          paramCanvas.drawLine(localRect.left, 0.0F, localRect.left, this.screenHeight, this.dashLinePaint);
          paramCanvas.drawLine(localRect.right, 0.0F, localRect.right, this.screenHeight, this.dashLinePaint);
          paramCanvas.drawRect(localRect, this.areaPaint);
        }
        for (;;)
        {
          j += 1;
          break;
          i = 0;
        }
      }
    } while (i == 0);
    Object localObject = this.relativeElements[(this.searchCount % 2)].getRect();
    Rect localRect = this.relativeElements[((this.searchCount - 1) % 2)].getRect();
    if (localRect.top > ((Rect)localObject).bottom)
    {
      i = localRect.left + localRect.width() / 2;
      drawLineWithText(paramCanvas, i, ((Rect)localObject).bottom, i, localRect.top);
    }
    if (((Rect)localObject).top > localRect.bottom)
    {
      i = localRect.left + localRect.width() / 2;
      drawLineWithText(paramCanvas, i, localRect.bottom, i, ((Rect)localObject).top);
    }
    if (localRect.left > ((Rect)localObject).right)
    {
      i = localRect.top + localRect.height() / 2;
      drawLineWithText(paramCanvas, localRect.left, i, ((Rect)localObject).right, i);
    }
    if (((Rect)localObject).left > localRect.right)
    {
      i = localRect.top + localRect.height() / 2;
      drawLineWithText(paramCanvas, localRect.right, i, ((Rect)localObject).left, i);
    }
    drawNestedAreaLine(paramCanvas, (Rect)localObject, localRect);
    drawNestedAreaLine(paramCanvas, localRect, (Rect)localObject);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      paramMotionEvent = getTargetElement(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (paramMotionEvent != null)
      {
        this.relativeElements[(this.searchCount % 2)] = paramMotionEvent;
        this.searchCount += 1;
        invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.view.RelativePositionLayout
 * JD-Core Version:    0.7.0.1
 */