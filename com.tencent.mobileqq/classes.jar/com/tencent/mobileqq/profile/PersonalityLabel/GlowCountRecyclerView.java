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
  int a = -1;
  boolean b;
  Paint c;
  int d;
  String e = "";
  int f;
  int g;
  int h;
  int i;
  int j = -1;
  Drawable k;
  Handler l = new Handler(this);
  
  public GlowCountRecyclerView(Context paramContext)
  {
    this(paramContext, null);
    c();
  }
  
  public GlowCountRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    c();
  }
  
  public GlowCountRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c()
  {
    float f1 = getResources().getDisplayMetrics().density;
    this.d = ((int)(8.0F * f1));
    this.c = new Paint(1);
    this.c.setTextAlign(Paint.Align.CENTER);
    this.c.setColor(-1);
    this.c.setTextSize(14.0F * f1);
    this.i = ((int)(f1 * 3.0F));
    this.k = getResources().getDrawable(2130847298);
  }
  
  private void d()
  {
    Object localObject = new Rect();
    Paint localPaint = this.c;
    String str = this.e;
    localPaint.getTextBounds(str, 0, str.length(), (Rect)localObject);
    this.g = ((Rect)localObject).width();
    localObject = this.c.getFontMetrics();
    this.h = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top + 0.5F));
  }
  
  public void a()
  {
    if (this.b)
    {
      this.l.removeMessages(0);
      this.l.sendEmptyMessageDelayed(0, 750L);
      invalidate();
    }
    this.b = false;
  }
  
  public boolean b()
  {
    boolean bool2 = this.b;
    boolean bool1 = false;
    if ((bool2) || (this.l.hasMessages(0))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Object localObject = getLayoutManager();
    int m;
    if ((localObject instanceof LinearLayoutManager)) {
      m = ((LinearLayoutManager)localObject).findFirstCompletelyVisibleItemPosition();
    } else if ((localObject instanceof StaggeredGridLayoutManager)) {
      m = ((StaggeredGridLayoutManager)localObject).findFirstCompletelyVisibleItemPositions(null)[0];
    } else {
      m = -1;
    }
    if ((b()) && (m == 0))
    {
      localObject = this.k;
      m = this.g;
      int n = this.i;
      ((Drawable)localObject).setBounds(0, 0, m + n * 2, this.h + n * 2);
      m = (int)(getPaddingLeft() + getResources().getDisplayMetrics().density * 5.0F);
      localObject = this.c.getFontMetrics();
      float f1 = (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom()) * 0.5F - (this.h + this.i * 2) * 0.5F);
      n = (int)(f1 - ((Paint.FontMetrics)localObject).top + this.i);
      paramCanvas.save();
      paramCanvas.translate(m, f1);
      this.k.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(m + this.i, 0.0F);
      paramCanvas.drawText(this.e, this.g * 0.5F, n, this.c);
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
    this.l.removeCallbacksAndMessages(null);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 3) {
          return bool;
        }
        a();
        this.a = -1;
        return bool;
      }
      a();
      this.a = -1;
      return bool;
    }
    this.a = ((int)paramMotionEvent.getX());
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            return bool;
          }
          a();
          this.a = -1;
          return bool;
        }
        if ((this.a >= 0) && (!this.b))
        {
          if ((int)(paramMotionEvent.getX() - this.a) > this.d) {
            this.b = true;
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
        this.a = -1;
        return bool;
      }
    }
    else {
      this.a = ((int)paramMotionEvent.getX());
    }
    return bool;
  }
  
  public void setText(String paramString)
  {
    if (!TextUtils.equals(paramString, this.e))
    {
      this.e = paramString;
      d();
      invalidate();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (paramInt != this.j)
    {
      this.j = paramInt;
      this.c.setColor(paramInt);
      invalidate();
    }
  }
  
  public void setTextSizeDp(int paramInt)
  {
    paramInt = (int)(paramInt * getResources().getDisplayMetrics().density);
    if (paramInt != this.f)
    {
      this.f = paramInt;
      this.c.setTextSize(paramInt);
      d();
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.GlowCountRecyclerView
 * JD-Core Version:    0.7.0.1
 */