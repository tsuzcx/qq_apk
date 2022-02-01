package com.tencent.mobileqq.rely;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Stack;

public abstract class SwipRightMenuBuilder
{
  protected String a = SwipRightMenuBuilder.class.getSimpleName();
  protected final Stack<View>[] b;
  protected final int c;
  protected final SwipRightMenuBuilder.SwipRightMenuItem[] d;
  
  public SwipRightMenuBuilder(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    paramInt1 = this.c;
    if ((paramInt1 >= 0) && ((paramInt1 <= 0) || (paramInt2 >= 1)))
    {
      this.b = new Stack[paramInt2];
      int i = 0;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        this.b[paramInt1] = new Stack();
        paramInt1 += 1;
      }
      this.d = new SwipRightMenuBuilder.SwipRightMenuItem[this.c];
      paramInt1 = i;
      while (paramInt1 < this.c)
      {
        this.d[paramInt1] = new SwipRightMenuBuilder.SwipRightMenuItem();
        paramInt1 += 1;
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SwipRightMenuBuilder, menuTypeCount = ");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public int a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    if (((paramView instanceof LinearLayout)) && (paramSwipItemBaseHolder != null) && (paramSwipItemBaseHolder.b != null) && (paramSwipItemBaseHolder.b.length != 0))
    {
      if (paramSwipItemBaseHolder.b.length > this.c) {
        return 0;
      }
      LinearLayout localLinearLayout = (LinearLayout)paramView;
      a(paramInt, paramObject, this.d);
      int j = 0;
      int m = 0;
      int i;
      for (int k = 0; j < this.c; k = i)
      {
        i = this.b.length;
        int i1 = 1;
        if ((i > 1) && (paramSwipItemBaseHolder.b[j].a != this.d[j].a)) {
          a(paramSwipItemBaseHolder.b[j]);
        }
        paramSwipItemBaseHolder.b[j].a = this.d[j].a;
        paramSwipItemBaseHolder.b[j].b = this.d[j].b;
        paramSwipItemBaseHolder.b[j].c = 0;
        paramSwipItemBaseHolder.b[j].d = -1;
        i = paramSwipItemBaseHolder.b[j].a;
        View localView = paramSwipItemBaseHolder.b[j].e;
        if (i >= 0)
        {
          Object localObject = this.b;
          if (i < localObject.length)
          {
            if (localView == null) {
              try
              {
                if (!this.b[i].isEmpty()) {
                  localView = (View)this.b[i].pop();
                }
                if (localView == null) {
                  localView = a(paramContext, i);
                }
                if (localView != null)
                {
                  paramSwipItemBaseHolder.b[j].e = localView;
                  break label341;
                }
                throw new NullPointerException("updateRightMenuView menuView is null");
              }
              finally {}
            } else {
              i1 = 0;
            }
            label341:
            a(paramInt, paramObject, paramSwipItemBaseHolder.b[j], paramOnClickListener);
            if (paramSwipItemBaseHolder.b[j].c >= 0)
            {
              m += paramSwipItemBaseHolder.b[j].c;
              k += 1;
              localView.setVisibility(0);
              n = m;
              i = k;
              if (i1 == 0) {
                break label602;
              }
              localObject = (LinearLayout.LayoutParams)localView.getLayoutParams();
              if (localObject == null)
              {
                localObject = new LinearLayout.LayoutParams(paramSwipItemBaseHolder.b[j].c, paramSwipItemBaseHolder.b[j].d);
                localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              else
              {
                ((LinearLayout.LayoutParams)localObject).width = paramSwipItemBaseHolder.b[j].c;
                ((LinearLayout.LayoutParams)localObject).height = paramSwipItemBaseHolder.b[j].d;
              }
              ((LinearLayout.LayoutParams)localObject).gravity = 16;
              localLinearLayout.addView(localView, k);
              n = m;
              i = k;
              break label602;
            }
            paramContext = new StringBuilder();
            paramContext.append("updateRightMenuView, menuWidth = ");
            paramContext.append(paramSwipItemBaseHolder.b[j].c);
            throw new IllegalArgumentException(paramContext.toString());
          }
        }
        int n = m;
        i = k;
        if (localView != null)
        {
          localView.setVisibility(8);
          i = k + 1;
          n = m;
        }
        label602:
        j += 1;
        m = n;
      }
      paramView.setTag(-3, Integer.valueOf(m));
      return m;
    }
    return 0;
  }
  
  public abstract View a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, View.OnClickListener paramOnClickListener);
  
  public abstract View a(Context paramContext, int paramInt);
  
  public View a(Context paramContext, View paramView, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, int paramInt)
  {
    if ((paramSwipItemBaseHolder != null) && (paramView != null))
    {
      int i = this.c;
      if (i > 0)
      {
        paramSwipItemBaseHolder.b = new SwipRightMenuBuilder.SwipRightMenuItem[i];
        i = 0;
        while (i < this.c)
        {
          paramSwipItemBaseHolder.b[i] = new SwipRightMenuBuilder.SwipRightMenuItem();
          paramSwipItemBaseHolder.b[i].a = -1;
          paramSwipItemBaseHolder.b[i].c = 0;
          paramSwipItemBaseHolder.b[i].e = null;
          i += 1;
        }
        paramContext = new LinearLayout(paramContext);
        paramContext.setOrientation(0);
        paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
      }
      else
      {
        paramSwipItemBaseHolder.b = null;
        paramContext = paramView;
      }
      paramSwipItemBaseHolder.a = paramView;
      return paramContext;
    }
    paramContext = new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    for (;;)
    {
      throw paramContext;
    }
  }
  
  public abstract void a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem);
  
  protected void a(SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem)
  {
    if (paramSwipRightMenuItem == null) {
      return;
    }
    if (paramSwipRightMenuItem.e != null)
    {
      ??? = paramSwipRightMenuItem.e.getParent();
      if (??? != null)
      {
        if ((??? instanceof ViewGroup)) {
          ((ViewGroup)???).removeView(paramSwipRightMenuItem.e);
        }
      }
      else {
        synchronized (this.b)
        {
          if ((paramSwipRightMenuItem.a >= 0) && (paramSwipRightMenuItem.a < this.b.length)) {
            this.b[paramSwipRightMenuItem.a].push(paramSwipRightMenuItem.e);
          }
        }
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
    paramSwipRightMenuItem.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.rely.SwipRightMenuBuilder
 * JD-Core Version:    0.7.0.1
 */