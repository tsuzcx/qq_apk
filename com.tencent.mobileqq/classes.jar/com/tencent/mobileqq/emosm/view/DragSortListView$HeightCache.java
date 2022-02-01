package com.tencent.mobileqq.emosm.view;

import android.util.SparseIntArray;
import java.util.ArrayList;

class DragSortListView$HeightCache
{
  private SparseIntArray b;
  private ArrayList<Integer> c;
  private int d;
  
  public DragSortListView$HeightCache(DragSortListView paramDragSortListView, int paramInt)
  {
    this.b = new SparseIntArray(paramInt);
    this.c = new ArrayList(paramInt);
    this.d = paramInt;
  }
  
  public int a(int paramInt)
  {
    return this.b.get(paramInt, -1);
  }
  
  public void a()
  {
    this.b.clear();
    this.c.clear();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = this.b.get(paramInt1, -1);
    if (i != paramInt2)
    {
      if (i == -1)
      {
        if (this.b.size() == this.d) {
          this.b.delete(((Integer)this.c.remove(0)).intValue());
        }
      }
      else {
        this.c.remove(Integer.valueOf(paramInt1));
      }
      this.b.put(paramInt1, paramInt2);
      this.c.add(Integer.valueOf(paramInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.HeightCache
 * JD-Core Version:    0.7.0.1
 */