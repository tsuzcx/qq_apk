package com.tencent.mobileqq.gamecenter.media;

import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DanmakuLayout$Track
  extends DanmakuLayout.Layout
{
  private List<DanmakuLayout.DrawItem> a = new ArrayList();
  
  DanmakuLayout$Track(DanmakuLayout paramDanmakuLayout)
  {
    super(paramDanmakuLayout);
  }
  
  void a(long paramLong)
  {
    if (this.a.size() > 0)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        DanmakuLayout.DrawItem localDrawItem = (DanmakuLayout.DrawItem)localIterator.next();
        if (!localDrawItem.a(paramLong, this.jdField_b_of_type_Int))
        {
          localDrawItem.a();
          localIterator.remove();
        }
      }
    }
  }
  
  boolean a()
  {
    return this.a.size() > 0;
  }
  
  boolean a(DanmakuLayout.DrawItem paramDrawItem)
  {
    boolean bool1 = a();
    boolean bool2 = true;
    if (!bool1)
    {
      bool1 = bool2;
    }
    else
    {
      Object localObject = this.a;
      localObject = (DanmakuLayout.DrawItem)((List)localObject).get(((List)localObject).size() - 1);
      double d1 = ((DanmakuLayout.DrawItem)localObject).jdField_a_of_type_Float;
      double d2 = ((DanmakuLayout.DrawItem)localObject).jdField_b_of_type_Int + 40;
      double d3 = Math.random();
      Double.isNaN(d2);
      if (d1 > d2 + d3 * 40.0D)
      {
        DanmakuLayout.DrawItem.a(paramDrawItem);
        bool1 = bool2;
        if (paramDrawItem.jdField_b_of_type_Float < ((DanmakuLayout.DrawItem)localObject).jdField_b_of_type_Float) {
          break label175;
        }
        if ((((DanmakuLayout.DrawItem)localObject).jdField_a_of_type_Float - ((DanmakuLayout.DrawItem)localObject).jdField_b_of_type_Int) / (paramDrawItem.jdField_b_of_type_Float - ((DanmakuLayout.DrawItem)localObject).jdField_b_of_type_Float) > (DanmakuLayout.a(this.jdField_b_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout) + ((DanmakuLayout.DrawItem)localObject).jdField_b_of_type_Int - ((DanmakuLayout.DrawItem)localObject).jdField_a_of_type_Float) / ((DanmakuLayout.DrawItem)localObject).jdField_b_of_type_Float)
        {
          bool1 = bool2;
          break label175;
        }
      }
      bool1 = false;
    }
    label175:
    if (bool1)
    {
      this.a.add(paramDrawItem);
      if (paramDrawItem.jdField_a_of_type_AndroidWidgetTextView.getParent() == null) {
        this.jdField_b_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout.addView(paramDrawItem.jdField_a_of_type_AndroidWidgetTextView);
      }
    }
    return bool1;
  }
  
  boolean b()
  {
    boolean bool;
    if (this.a.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ((DanmakuLayout.DrawItem)localIterator.next()).a();
        localIterator.remove();
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuLayout.Track
 * JD-Core Version:    0.7.0.1
 */