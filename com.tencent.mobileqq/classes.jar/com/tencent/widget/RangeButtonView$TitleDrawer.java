package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class RangeButtonView$TitleDrawer
{
  private List<RangeButtonView.Title> titles;
  
  public RangeButtonView$TitleDrawer(List<RangeButtonView.Title> paramList)
  {
    Object localObject;
    this.titles = localObject;
  }
  
  public void drawTitles(Canvas paramCanvas, Paint paramPaint)
  {
    Object localObject = this.titles;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((RangeButtonView.Title)((Iterator)localObject).next()).draw(paramCanvas, paramPaint, this.this$0.params);
    }
  }
  
  public void setTitlePoints(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (this.titles == null) {
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      RangeButtonView.Title localTitle = (RangeButtonView.Title)this.titles.get(i);
      localTitle.point = new Point(((Integer)paramArrayList.get(i)).intValue() - (localTitle.getTextWidth() >> 1), paramInt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.RangeButtonView.TitleDrawer
 * JD-Core Version:    0.7.0.1
 */