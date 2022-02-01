package com.tencent.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class RangeButtonView$TitleDrawer
{
  private List<RangeButtonView.Title> jdField_a_of_type_JavaUtilList;
  
  public RangeButtonView$TitleDrawer(List<RangeButtonView.Title> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((RangeButtonView.Title)localIterator.next()).a(paramCanvas, paramPaint, this.jdField_a_of_type_ComTencentWidgetRangeButtonView.a);
      }
    }
  }
  
  public void a(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        RangeButtonView.Title localTitle = (RangeButtonView.Title)this.jdField_a_of_type_JavaUtilList.get(i);
        localTitle.a = new Point(((Integer)paramArrayList.get(i)).intValue() - (localTitle.a() >> 1), paramInt);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.RangeButtonView.TitleDrawer
 * JD-Core Version:    0.7.0.1
 */