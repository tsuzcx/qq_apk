package com.tencent.widget;

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
  protected String TAG = SwipRightMenuBuilder.class.getSimpleName();
  protected final int mMaxMenuCount;
  protected final Stack<View>[] mMenuViewCache;
  protected final SwipRightMenuBuilder.SwipRightMenuItem[] mTempMenus;
  
  public SwipRightMenuBuilder(int paramInt1, int paramInt2)
  {
    this.mMaxMenuCount = paramInt1;
    paramInt1 = this.mMaxMenuCount;
    if ((paramInt1 >= 0) && ((paramInt1 <= 0) || (paramInt2 >= 1)))
    {
      this.mMenuViewCache = new Stack[paramInt2];
      int i = 0;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        this.mMenuViewCache[paramInt1] = new Stack();
        paramInt1 += 1;
      }
      this.mTempMenus = new SwipRightMenuBuilder.SwipRightMenuItem[this.mMaxMenuCount];
      paramInt1 = i;
      while (paramInt1 < this.mMaxMenuCount)
      {
        this.mTempMenus[paramInt1] = new SwipRightMenuBuilder.SwipRightMenuItem();
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
  
  public abstract View createRightMenuItem(Context paramContext, int paramInt);
  
  public View createView(Context paramContext, View paramView, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, int paramInt)
  {
    if ((paramSwipItemBaseHolder != null) && (paramView != null))
    {
      int i = this.mMaxMenuCount;
      if (i > 0)
      {
        paramSwipItemBaseHolder.rightMenuItems = new SwipRightMenuBuilder.SwipRightMenuItem[i];
        i = 0;
        while (i < this.mMaxMenuCount)
        {
          paramSwipItemBaseHolder.rightMenuItems[i] = new SwipRightMenuBuilder.SwipRightMenuItem();
          paramSwipItemBaseHolder.rightMenuItems[i].menuType = -1;
          paramSwipItemBaseHolder.rightMenuItems[i].menuWidth = 0;
          paramSwipItemBaseHolder.rightMenuItems[i].menuView = null;
          i += 1;
        }
        paramContext = new LinearLayout(paramContext);
        paramContext.setOrientation(0);
        paramContext.addView(paramView, new LinearLayout.LayoutParams(paramInt, -2));
      }
      else
      {
        paramSwipItemBaseHolder.rightMenuItems = null;
        paramContext = paramView;
      }
      paramSwipItemBaseHolder.leftView = paramView;
      return paramContext;
    }
    paramContext = new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    for (;;)
    {
      throw paramContext;
    }
  }
  
  public abstract void getRightMenuItemInfo(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem);
  
  protected void recycleMenuView(SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem)
  {
    if (paramSwipRightMenuItem == null) {
      return;
    }
    if (paramSwipRightMenuItem.menuView != null)
    {
      ??? = paramSwipRightMenuItem.menuView.getParent();
      if (??? != null)
      {
        if ((??? instanceof ViewGroup)) {
          ((ViewGroup)???).removeView(paramSwipRightMenuItem.menuView);
        }
      }
      else {
        synchronized (this.mMenuViewCache)
        {
          if ((paramSwipRightMenuItem.menuType >= 0) && (paramSwipRightMenuItem.menuType < this.mMenuViewCache.length)) {
            this.mMenuViewCache[paramSwipRightMenuItem.menuType].push(paramSwipRightMenuItem.menuView);
          }
        }
      }
      throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
    }
    paramSwipRightMenuItem.reset();
  }
  
  public abstract View updateRightMenuItem(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, View.OnClickListener paramOnClickListener);
  
  public int updateRightMenuView(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    if (((paramView instanceof LinearLayout)) && (paramSwipItemBaseHolder != null) && (paramSwipItemBaseHolder.rightMenuItems != null) && (paramSwipItemBaseHolder.rightMenuItems.length != 0))
    {
      if (paramSwipItemBaseHolder.rightMenuItems.length > this.mMaxMenuCount) {
        return 0;
      }
      LinearLayout localLinearLayout = (LinearLayout)paramView;
      getRightMenuItemInfo(paramInt, paramObject, this.mTempMenus);
      int j = 0;
      int m = 0;
      int i;
      for (int k = 0; j < this.mMaxMenuCount; k = i)
      {
        i = this.mMenuViewCache.length;
        int i1 = 1;
        if ((i > 1) && (paramSwipItemBaseHolder.rightMenuItems[j].menuType != this.mTempMenus[j].menuType)) {
          recycleMenuView(paramSwipItemBaseHolder.rightMenuItems[j]);
        }
        paramSwipItemBaseHolder.rightMenuItems[j].menuType = this.mTempMenus[j].menuType;
        paramSwipItemBaseHolder.rightMenuItems[j].menuId = this.mTempMenus[j].menuId;
        paramSwipItemBaseHolder.rightMenuItems[j].menuWidth = 0;
        paramSwipItemBaseHolder.rightMenuItems[j].menuHeight = -1;
        i = paramSwipItemBaseHolder.rightMenuItems[j].menuType;
        View localView = paramSwipItemBaseHolder.rightMenuItems[j].menuView;
        if (i >= 0)
        {
          Object localObject = this.mMenuViewCache;
          if (i < localObject.length)
          {
            if (localView == null) {
              try
              {
                if (!this.mMenuViewCache[i].isEmpty()) {
                  localView = (View)this.mMenuViewCache[i].pop();
                }
                if (localView == null) {
                  localView = createRightMenuItem(paramContext, i);
                }
                if (localView != null)
                {
                  paramSwipItemBaseHolder.rightMenuItems[j].menuView = localView;
                  break label341;
                }
                throw new NullPointerException("updateRightMenuView menuView is null");
              }
              finally {}
            } else {
              i1 = 0;
            }
            label341:
            updateRightMenuItem(paramInt, paramObject, paramSwipItemBaseHolder.rightMenuItems[j], paramOnClickListener);
            if (paramSwipItemBaseHolder.rightMenuItems[j].menuWidth >= 0)
            {
              m += paramSwipItemBaseHolder.rightMenuItems[j].menuWidth;
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
                localObject = new LinearLayout.LayoutParams(paramSwipItemBaseHolder.rightMenuItems[j].menuWidth, paramSwipItemBaseHolder.rightMenuItems[j].menuHeight);
                localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
              else
              {
                ((LinearLayout.LayoutParams)localObject).width = paramSwipItemBaseHolder.rightMenuItems[j].menuWidth;
                ((LinearLayout.LayoutParams)localObject).height = paramSwipItemBaseHolder.rightMenuItems[j].menuHeight;
              }
              ((LinearLayout.LayoutParams)localObject).gravity = 16;
              localLinearLayout.addView(localView, k);
              n = m;
              i = k;
              break label602;
            }
            paramContext = new StringBuilder();
            paramContext.append("updateRightMenuView, menuWidth = ");
            paramContext.append(paramSwipItemBaseHolder.rightMenuItems[j].menuWidth);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.SwipRightMenuBuilder
 * JD-Core Version:    0.7.0.1
 */