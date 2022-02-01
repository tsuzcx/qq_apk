package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TabWidget;
import com.tencent.common.app.BaseApplicationImpl;

public class SlideTabWidget
  extends TabWidget
{
  private static int d = (int)(BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density * 3.0F + 0.5F);
  private int a = -1;
  private int b = -1;
  private boolean c = false;
  private float e;
  private Paint f = new Paint();
  private boolean g = false;
  private boolean h = false;
  private SlideTabWidget.OnTabSlideCompleteListener i;
  private Handler j = new SlideTabWidget.1(this);
  
  public SlideTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f.setColor(getResources().getColor(2131168002));
  }
  
  public SlideTabWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f.setColor(getResources().getColor(2131168002));
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.g) && ((this.e >= 1.0F) || (this.b == this.a))) {
      return;
    }
    View localView1 = getChildTabViewAt(this.b);
    if (localView1 != null)
    {
      int n = localView1.getLeft();
      int i1 = localView1.getRight();
      int m = n;
      int k = i1;
      if (this.e > 0.0F)
      {
        View localView2 = getChildAt(this.a);
        m = n;
        k = i1;
        if (localView2 != null)
        {
          m = (int)(localView1.getLeft() + this.e * (localView2.getLeft() - localView1.getLeft()));
          k = (int)(localView1.getRight() + this.e * (localView2.getRight() - localView1.getRight()));
        }
      }
      paramCanvas.drawRect(m, getHeight() - d, k, getHeight(), this.f);
    }
    if ((!this.g) && (this.i != null) && (this.h))
    {
      this.h = false;
      post(new SlideTabWidget.2(this));
    }
  }
  
  public void setCurrentTab(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= getTabCount()))
    {
      if (paramInt == this.b) {
        return;
      }
      this.h = true;
      this.a = paramInt;
      if (this.c)
      {
        this.g = true;
        this.j.sendEmptyMessage(0);
      }
      else
      {
        this.b = this.a;
      }
      super.setCurrentTab(paramInt);
    }
  }
  
  public void setOnTabSlideCompleteListener(SlideTabWidget.OnTabSlideCompleteListener paramOnTabSlideCompleteListener)
  {
    this.i = paramOnTabSlideCompleteListener;
  }
  
  public void setSlideAnimaPlay(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideTabWidget
 * JD-Core Version:    0.7.0.1
 */