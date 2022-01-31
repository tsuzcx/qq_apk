package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public class NearbyWorkspaceView
  extends WorkSpaceView
{
  private int b = 0;
  
  public NearbyWorkspaceView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int m = getChildCount();
    float f = getScrollX() / getWidth();
    int i;
    int j;
    if ((f < 0.0F) && (this.a))
    {
      i = 0;
      j = m - 1;
    }
    for (;;)
    {
      View localView;
      if (m > 1)
      {
        paramCanvas = (View)getChildAt(j).getTag();
        localView = (View)getChildAt(i).getTag();
        if ((paramCanvas != null) && (localView != null)) {
          break label120;
        }
      }
      label120:
      Rect localRect2;
      label327:
      do
      {
        for (;;)
        {
          return;
          i = (int)f % m;
          j = i + 1;
          if (!this.a) {
            break label361;
          }
          k = j % m;
          j = i;
          i = k;
          break;
          Rect localRect1 = new Rect();
          localRect2 = new Rect();
          paramCanvas.getGlobalVisibleRect(localRect1);
          localView.getGlobalVisibleRect(localRect2);
          k = getWidth() - (getScrollX() + getWidth()) % getWidth();
          if (this.b == j) {
            if ((localRect1.left < 0) || (k < localRect1.right))
            {
              this.b = -1;
              paramCanvas.setVisibility(4);
            }
          }
          while (this.b == -1)
          {
            if ((localRect1.left < 0) || (k < localRect1.right)) {
              break label327;
            }
            this.b = j;
            paramCanvas.setVisibility(0);
            return;
            if (this.b == i)
            {
              if ((k > localRect2.left) || (getWidth() < localRect2.right))
              {
                this.b = -1;
                localView.setVisibility(4);
              }
            }
            else if (this.b != -1)
            {
              ((View)getChildAt(this.b).getTag()).setVisibility(4);
              this.b = -1;
            }
          }
        }
      } while ((k > localRect2.left) || (getWidth() < localRect2.right));
      this.b = i;
      localView.setVisibility(0);
      return;
      label361:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public void removeAllViews()
  {
    View localView = getChildAt(this.b);
    if ((localView != null) && (localView.getTag() != null)) {
      ((View)localView.getTag()).setVisibility(4);
    }
    super.removeAllViews();
  }
  
  public void setVisibility(int paramInt)
  {
    View localView = getChildAt(this.b);
    if ((localView != null) && (localView.getTag() != null))
    {
      localView = (View)localView.getTag();
      if ((paramInt != 8) && (paramInt != 4)) {
        break label50;
      }
      localView.setVisibility(4);
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      label50:
      localView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NearbyWorkspaceView
 * JD-Core Version:    0.7.0.1
 */