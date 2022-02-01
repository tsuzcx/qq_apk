package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public class NearbyWorkspaceView
  extends WorkSpaceView
{
  private int c = 0;
  
  public NearbyWorkspaceView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int n = getChildCount();
    float f = getScrollX() / getWidth();
    int j;
    int i;
    int k;
    int m;
    if ((f < 0.0F) && (this.b))
    {
      j = n - 1;
      i = 0;
    }
    else
    {
      k = (int)f % n;
      m = k + 1;
      j = k;
      i = m;
      if (this.b)
      {
        i = m % n;
        j = k;
      }
    }
    if (n > 1)
    {
      paramCanvas = (View)getChildAt(j).getTag();
      View localView = (View)getChildAt(i).getTag();
      if (paramCanvas != null)
      {
        if (localView == null) {
          return;
        }
        Rect localRect1 = new Rect();
        Rect localRect2 = new Rect();
        paramCanvas.getGlobalVisibleRect(localRect1);
        localView.getGlobalVisibleRect(localRect2);
        k = getWidth() - (getScrollX() + getWidth()) % getWidth();
        m = this.c;
        if (m == j)
        {
          if ((localRect1.left < 0) || (k < localRect1.right))
          {
            this.c = -1;
            paramCanvas.setVisibility(4);
          }
        }
        else if (m == i)
        {
          if ((k > localRect2.left) || (getWidth() < localRect2.right))
          {
            this.c = -1;
            localView.setVisibility(4);
          }
        }
        else if (m != -1)
        {
          ((View)getChildAt(m).getTag()).setVisibility(4);
          this.c = -1;
        }
        if (this.c == -1)
        {
          if ((localRect1.left >= 0) && (k >= localRect1.right))
          {
            this.c = j;
            paramCanvas.setVisibility(0);
            return;
          }
          if ((k <= localRect2.left) && (getWidth() >= localRect2.right))
          {
            this.c = i;
            localView.setVisibility(0);
          }
        }
      }
    }
  }
  
  public void removeAllViews()
  {
    View localView = getChildAt(this.c);
    if ((localView != null) && (localView.getTag() != null)) {
      ((View)localView.getTag()).setVisibility(4);
    }
    super.removeAllViews();
  }
  
  public void setVisibility(int paramInt)
  {
    View localView = getChildAt(this.c);
    if ((localView != null) && (localView.getTag() != null))
    {
      localView = (View)localView.getTag();
      if ((paramInt != 8) && (paramInt != 4)) {
        localView.setVisibility(0);
      } else {
        localView.setVisibility(4);
      }
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NearbyWorkspaceView
 * JD-Core Version:    0.7.0.1
 */