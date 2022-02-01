package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DotIndexView
  extends LinearLayout
{
  protected LinearLayout a;
  protected int b = 2130844991;
  protected Context c;
  protected int d = 0;
  protected int e = 8;
  
  public DotIndexView(Context paramContext)
  {
    super(paramContext);
    this.a = new LinearLayout(paramContext);
    this.c = this.a.getContext();
  }
  
  public DotIndexView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new LinearLayout(paramContext);
    this.c = this.a.getContext();
  }
  
  public void setDotDrawable(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      if ((this.a != null) && (this.d != 0))
      {
        Drawable localDrawable = this.c.getResources().getDrawable(this.b);
        paramInt = 0;
        while (paramInt < this.d)
        {
          View localView = this.a.getChildAt(paramInt);
          if ((localView != null) && ((localView instanceof ImageView))) {
            ((ImageView)localView).setImageDrawable(localDrawable);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void setDotSelected(int paramInt, boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    if (paramBoolean)
    {
      int i = 0;
      while (i < this.d)
      {
        if (this.a.getChildAt(i) != null) {
          this.a.getChildAt(i).setSelected(false);
        }
        i += 1;
      }
    }
    if (this.a.getChildAt(paramInt) != null) {
      this.a.getChildAt(paramInt).setSelected(paramBoolean);
    }
  }
  
  public void setMargin(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.DotIndexView
 * JD-Core Version:    0.7.0.1
 */