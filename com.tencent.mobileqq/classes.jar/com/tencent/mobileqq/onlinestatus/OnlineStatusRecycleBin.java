package com.tencent.mobileqq.onlinestatus;

import android.util.SparseArray;
import android.view.View;

public class OnlineStatusRecycleBin
{
  private SparseArray<View> a = new SparseArray();
  
  public View a(int paramInt)
  {
    if (this.a.size() > 0)
    {
      View localView = (View)this.a.get(paramInt);
      if (localView != null) {
        this.a.remove(paramInt);
      }
      return localView;
    }
    return null;
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.a.size() >= 3) {
      return;
    }
    this.a.put(paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusRecycleBin
 * JD-Core Version:    0.7.0.1
 */