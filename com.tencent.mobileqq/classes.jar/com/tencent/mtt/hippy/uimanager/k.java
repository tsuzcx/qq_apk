package com.tencent.mtt.hippy.uimanager;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;
import java.util.ArrayList;
import java.util.Collections;

public class k
{
  private final ViewGroup a;
  private int b = 0;
  private int[] c;
  
  public k(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (this.c == null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramInt1)
      {
        localArrayList.add(this.a.getChildAt(i));
        i += 1;
      }
      Collections.sort(localArrayList, new k.1(this));
      this.c = new int[paramInt1];
      i = 0;
      while (i < paramInt1)
      {
        View localView = (View)localArrayList.get(i);
        this.c[i] = this.a.indexOfChild(localView);
        i += 1;
      }
    }
    if (paramInt2 >= this.c.length)
    {
      Log.e("VGDrawingOrderHelper", "WRONG, index out of mDrawingOrderIndices length");
      return 0;
    }
    return this.c[paramInt2];
  }
  
  public void a(View paramView)
  {
    if (HippyViewGroupController.getViewZIndex(paramView) != null) {
      this.b += 1;
    }
    this.c = null;
  }
  
  public boolean a()
  {
    return this.b > 0;
  }
  
  public void b()
  {
    int i = 0;
    this.b = 0;
    while (i < this.a.getChildCount())
    {
      if (HippyViewGroupController.getViewZIndex(this.a.getChildAt(i)) != null) {
        this.b += 1;
      }
      i += 1;
    }
    this.c = null;
  }
  
  public void b(View paramView)
  {
    if (HippyViewGroupController.getViewZIndex(paramView) != null) {
      this.b -= 1;
    }
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.k
 * JD-Core Version:    0.7.0.1
 */