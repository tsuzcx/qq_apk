package com.tencent.mobileqq.worldcup;

import akya;
import akyb;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class TouchSliceView
  extends View
{
  private float jdField_a_of_type_Float = 3.0F;
  private int jdField_a_of_type_Int = 15;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Shader jdField_a_of_type_AndroidGraphicsShader;
  public Runnable a;
  private Deque jdField_a_of_type_JavaUtilDeque = new ArrayDeque(this.jdField_a_of_type_Int);
  private boolean jdField_a_of_type_Boolean;
  Runnable jdField_b_of_type_JavaLangRunnable = new akyb(this);
  private Deque jdField_b_of_type_JavaUtilDeque = new ArrayDeque(this.jdField_a_of_type_Int);
  
  public TouchSliceView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new akya(this);
    a();
  }
  
  public TouchSliceView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangRunnable = new akya(this);
    a();
  }
  
  public TouchSliceView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new akya(this);
    a();
  }
  
  private Path a()
  {
    Object localObject = null;
    PointF localPointF = (PointF)this.jdField_a_of_type_JavaUtilDeque.peek();
    Path localPath = new Path();
    if (localPointF == null) {
      return null;
    }
    localPath.moveTo(localPointF.x, localPointF.y);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilDeque.iterator();
    int i = 1;
    float f2;
    if (localIterator.hasNext())
    {
      localPointF = (PointF)localIterator.next();
      if (localIterator.hasNext())
      {
        f2 = i / 2;
        if (localObject == null) {
          break label333;
        }
      }
    }
    label333:
    for (float f1 = (localPointF.y - ((PointF)localObject).y) / (localPointF.x - ((PointF)localObject).x);; f1 = 0.0F)
    {
      if (Math.abs(1.0F - f1) < 0.9D)
      {
        localPath.lineTo(localPointF.x, localPointF.y - f2);
        this.jdField_b_of_type_JavaUtilDeque.addFirst(new PointF(localPointF.x, f2 + localPointF.y));
        localObject = localPointF;
      }
      for (;;)
      {
        i = (int)(i + this.jdField_a_of_type_Float);
        break;
        localPath.lineTo(localPointF.x - f2, localPointF.y - f2);
        this.jdField_b_of_type_JavaUtilDeque.addFirst(new PointF(localPointF.x + f2, f2 + localPointF.y));
        localObject = localPointF;
        continue;
        localPath.lineTo(localPointF.x, localPointF.y);
      }
      while (this.jdField_b_of_type_JavaUtilDeque.peekFirst() != null)
      {
        localObject = (PointF)this.jdField_b_of_type_JavaUtilDeque.pollFirst();
        if (localObject != null) {
          localPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
        }
      }
      localPath.close();
      return localPath;
    }
  }
  
  private void a()
  {
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(new CornerPathEffect(5.0F));
    int i = Color.parseColor("#f8f8f8");
    int j = Color.parseColor("#C0C0C0");
    int k = Color.parseColor("#f8f8f8");
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.jdField_a_of_type_AndroidGraphicsShader = new LinearGradient(0.0F, 0.0F, 40.0F, 60.0F, new int[] { i, j, k }, null, localTileMode);
    this.jdField_a_of_type_Float = ViewUtils.b(1.5F);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_JavaUtilDeque.size() >= this.jdField_a_of_type_Int - 1) {
      this.jdField_a_of_type_JavaUtilDeque.pollFirst();
    }
    this.jdField_a_of_type_JavaUtilDeque.addLast(new PointF(paramFloat1, paramFloat2));
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Boolean = true;
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, 80L);
      this.jdField_a_of_type_JavaUtilDeque.clear();
      this.jdField_a_of_type_JavaUtilDeque.addLast(new PointF(paramMotionEvent.getX() - this.jdField_a_of_type_AndroidGraphicsRect.left, paramMotionEvent.getY() - this.jdField_a_of_type_AndroidGraphicsRect.top));
      postInvalidate();
      return;
    case 2: 
      a(paramMotionEvent.getX() - this.jdField_a_of_type_AndroidGraphicsRect.left, paramMotionEvent.getY() - this.jdField_a_of_type_AndroidGraphicsRect.top);
      postInvalidate();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    postDelayed(this.jdField_b_of_type_JavaLangRunnable, 400L);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((PointF)this.jdField_a_of_type_JavaUtilDeque.peek() == null) {}
    Path localPath;
    do
    {
      return;
      localPath = a();
    } while (localPath == null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#E500FCFF"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(ViewUtils.b(3.0F));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#E5FFFFFF"));
    paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.TouchSliceView
 * JD-Core Version:    0.7.0.1
 */