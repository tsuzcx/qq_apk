package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public class GlowCountRecyclerView
  extends RecyclerView
  implements Handler.Callback
{
  int jdField_a_of_type_Int = -1;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  int e;
  int f;
  int g = -1;
  
  public GlowCountRecyclerView(Context paramContext)
  {
    this(paramContext, null);
    b();
  }
  
  public GlowCountRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    b();
  }
  
  public GlowCountRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b()
  {
    float f1 = getResources().getDisplayMetrics().density;
    this.b = ((int)(8.0F * f1));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(14.0F * f1);
    this.f = ((int)(f1 * 3.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130845828);
  }
  
  private void c()
  {
    Object localObject = new Rect();
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    String str = this.jdField_a_of_type_JavaLangString;
    localPaint.getTextBounds(str, 0, str.length(), (Rect)localObject);
    this.d = ((Rect)localObject).width();
    localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    this.e = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top + 0.5F));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 750L);
      invalidate();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1 = false;
    if ((bool2) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Object localObject = getLayoutManager();
    int i;
    if ((localObject instanceof LinearLayoutManager)) {
      i = ((LinearLayoutManager)localObject).findFirstCompletelyVisibleItemPosition();
    } else if ((localObject instanceof StaggeredGridLayoutManager)) {
      i = ((StaggeredGridLayoutManager)localObject).findFirstCompletelyVisibleItemPositions(null)[0];
    } else {
      i = -1;
    }
    if ((a()) && (i == 0))
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      i = this.d;
      int j = this.f;
      ((Drawable)localObject).setBounds(0, 0, i + j * 2, this.e + j * 2);
      i = (int)(getPaddingLeft() + getResources().getDisplayMetrics().density * 5.0F);
      localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
      float f1 = (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom()) * 0.5F - (this.e + this.f * 2) * 0.5F);
      j = (int)(f1 - ((Paint.FontMetrics)localObject).top + this.f);
      paramCanvas.save();
      paramCanvas.translate(i, f1);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(i + this.f, 0.0F);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.d * 0.5F, j, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      invalidate();
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return bool;
        }
        a();
        this.jdField_a_of_type_Int = -1;
        return bool;
      }
      a();
      this.jdField_a_of_type_Int = -1;
      return bool;
    }
    this.jdField_a_of_type_Int = ((int)paramMotionEvent.getX());
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return bool;
          }
          a();
          this.jdField_a_of_type_Int = -1;
          return bool;
        }
        if ((this.jdField_a_of_type_Int >= 0) && (!this.jdField_a_of_type_Boolean))
        {
          if ((int)(paramMotionEvent.getX() - this.jdField_a_of_type_Int) > this.b) {
            this.jdField_a_of_type_Boolean = true;
          }
          if (QLog.isColorLevel()) {
            QLog.i("GlowCountRecyclerView", 2, "move show");
          }
          invalidate();
          return bool;
        }
      }
      else
      {
        a();
        this.jdField_a_of_type_Int = -1;
        return bool;
      }
    }
    else {
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getX());
    }
    return bool;
  }
  
  public void setText(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      c();
      invalidate();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (paramInt != this.g)
    {
      this.g = paramInt;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
      invalidate();
    }
  }
  
  public void setTextSizeDp(int paramInt)
  {
    paramInt = (int)(paramInt * getResources().getDisplayMetrics().density);
    if (paramInt != this.c)
    {
      this.c = paramInt;
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramInt);
      c();
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.GlowCountRecyclerView
 * JD-Core Version:    0.7.0.1
 */