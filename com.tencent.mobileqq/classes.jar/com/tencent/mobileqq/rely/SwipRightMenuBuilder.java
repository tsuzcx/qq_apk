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
  protected final int a;
  protected String a;
  protected final SwipRightMenuBuilder.SwipRightMenuItem[] a;
  protected final Stack<View>[] a;
  
  public SwipRightMenuBuilder(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = SwipRightMenuBuilder.class.getSimpleName();
    this.jdField_a_of_type_Int = paramInt1;
    paramInt1 = this.jdField_a_of_type_Int;
    if ((paramInt1 >= 0) && ((paramInt1 <= 0) || (paramInt2 >= 1)))
    {
      this.jdField_a_of_type_ArrayOfJavaUtilStack = new Stack[paramInt2];
      int i = 0;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        this.jdField_a_of_type_ArrayOfJavaUtilStack[paramInt1] = new Stack();
        paramInt1 += 1;
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem = new SwipRightMenuBuilder.SwipRightMenuItem[this.jdField_a_of_type_Int];
      paramInt1 = i;
      while (paramInt1 < this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[paramInt1] = new SwipRightMenuBuilder.SwipRightMenuItem();
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
    if (((paramView instanceof LinearLayout)) && (paramSwipItemBaseHolder != null) && (paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem != null) && (paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem.length != 0))
    {
      if (paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem.length > this.jdField_a_of_type_Int) {
        return 0;
      }
      LinearLayout localLinearLayout = (LinearLayout)paramView;
      a(paramInt, paramObject, this.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem);
      int j = 0;
      int m = 0;
      int i;
      for (int k = 0; j < this.jdField_a_of_type_Int; k = i)
      {
        i = this.jdField_a_of_type_ArrayOfJavaUtilStack.length;
        int i1 = 1;
        if ((i > 1) && (paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].jdField_a_of_type_Int != this.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].jdField_a_of_type_Int)) {
          a(paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j]);
        }
        paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].jdField_a_of_type_Int;
        paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].b = this.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].b;
        paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].c = 0;
        paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].d = -1;
        i = paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].jdField_a_of_type_Int;
        View localView = paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].jdField_a_of_type_AndroidViewView;
        if (i >= 0)
        {
          Object localObject = this.jdField_a_of_type_ArrayOfJavaUtilStack;
          if (i < localObject.length)
          {
            if (localView == null) {
              try
              {
                if (!this.jdField_a_of_type_ArrayOfJavaUtilStack[i].isEmpty()) {
                  localView = (View)this.jdField_a_of_type_ArrayOfJavaUtilStack[i].pop();
                }
                if (localView == null) {
                  localView = a(paramContext, i);
                }
                if (localView != null)
                {
                  paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].jdField_a_of_type_AndroidViewView = localView;
                  break label341;
                }
                throw new NullPointerException("updateRightMenuView menuView is null");
              }
              finally {}
            } else {
              i1 = 0;
            }
            label341:
            a(paramInt, paramObject, paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j], paramOnClickListener);
            if (paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].c >= 0)
            {
              m += paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].c;
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
                localObject = new LinearLayout.LayoutParams(paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].c, paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].d);
                localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              else
              {
                ((LinearLayout.LayoutParams)localObject).width = paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].c;
                ((LinearLayout.LayoutParams)localObject).height = paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].d;
              }
              ((LinearLayout.LayoutParams)localObject).gravity = 16;
              localLinearLayout.addView(localView, k);
              n = m;
              i = k;
              break label602;
            }
            paramContext = new StringBuilder();
            paramContext.append("updateRightMenuView, menuWidth = ");
            paramContext.append(paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[j].c);
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
      int i = this.jdField_a_of_type_Int;
      if (i > 0)
      {
        paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem = new SwipRightMenuBuilder.SwipRightMenuItem[i];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[i] = new SwipRightMenuBuilder.SwipRightMenuItem();
          paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[i].jdField_a_of_type_Int = -1;
          paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[i].c = 0;
          paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem[i].jdField_a_of_type_AndroidViewView = null;
          i += 1;
        }
        paramContext = new LinearLayout(paramContext);
        paramContext.setOrientation(0);
        paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
      }
      else
      {
        paramSwipItemBaseHolder.jdField_a_of_type_ArrayOfComTencentMobileqqRelySwipRightMenuBuilder$SwipRightMenuItem = null;
        paramContext = paramView;
      }
      paramSwipItemBaseHolder.jdField_a_of_type_AndroidViewView = paramView;
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
    if (paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView != null)
    {
      ??? = paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView.getParent();
      if (??? != null)
      {
        if ((??? instanceof ViewGroup)) {
          ((ViewGroup)???).removeView(paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView);
        }
      }
      else {
        synchronized (this.jdField_a_of_type_ArrayOfJavaUtilStack)
        {
          if ((paramSwipRightMenuItem.jdField_a_of_type_Int >= 0) && (paramSwipRightMenuItem.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaUtilStack.length)) {
            this.jdField_a_of_type_ArrayOfJavaUtilStack[paramSwipRightMenuItem.jdField_a_of_type_Int].push(paramSwipRightMenuItem.jdField_a_of_type_AndroidViewView);
          }
        }
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
    paramSwipRightMenuItem.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.rely.SwipRightMenuBuilder
 * JD-Core Version:    0.7.0.1
 */