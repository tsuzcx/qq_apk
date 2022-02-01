package com.tencent.mobileqq.danmaku.render;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.danmaku.tool.TouchPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewDanmakuRender$ViewHolder
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  protected final View a;
  
  public ViewDanmakuRender$ViewHolder(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      return;
    }
    throw new IllegalArgumentException("itemView may not be null");
  }
  
  private View a(View paramView, float paramFloat1, float paramFloat2)
  {
    RectF localRectF = new RectF();
    Iterator localIterator = paramView.getTouchables().iterator();
    int i = 0;
    View localView1 = null;
    while (localIterator.hasNext())
    {
      View localView2 = (View)localIterator.next();
      float f1 = localView2.getX();
      float f2 = localView2.getY();
      localRectF.set(f1, f2, localView2.getMeasuredWidth() + f1, localView2.getMeasuredWidth() + f2);
      if (localRectF.contains(paramFloat1, paramFloat2)) {
        if (localView2.equals(paramView)) {
          i = 1;
        } else if ((localView2 instanceof ViewGroup)) {
          localView1 = a(paramView, paramFloat1 - f1, paramFloat2 - paramFloat1);
        } else {
          return localView2;
        }
      }
    }
    if ((i != 0) && (localView1 == null)) {
      return paramView;
    }
    return localView1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View a(TouchPoint paramTouchPoint)
  {
    return a(this.jdField_a_of_type_AndroidViewView, paramTouchPoint.a(), paramTouchPoint.b());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(this.jdField_a_of_type_AndroidViewView.getAlpha() * 255.0F));
    int i = paramCanvas.saveLayer(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint, 31);
    this.jdField_a_of_type_AndroidViewView.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.render.ViewDanmakuRender.ViewHolder
 * JD-Core Version:    0.7.0.1
 */