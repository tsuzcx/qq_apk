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
    boolean bool;
    if (!a()) {
      bool = true;
    }
    for (;;)
    {
      if (bool)
      {
        this.a.add(paramDrawItem);
        if (paramDrawItem.jdField_a_of_type_AndroidWidgetTextView.getParent() == null) {
          this.jdField_b_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout.addView(paramDrawItem.jdField_a_of_type_AndroidWidgetTextView);
        }
      }
      return bool;
      DanmakuLayout.DrawItem localDrawItem = (DanmakuLayout.DrawItem)this.a.get(this.a.size() - 1);
      if (localDrawItem.jdField_a_of_type_Float > localDrawItem.jdField_b_of_type_Int + 40 + Math.random() * 40.0D)
      {
        DanmakuLayout.DrawItem.a(paramDrawItem);
        if ((paramDrawItem.jdField_b_of_type_Float < localDrawItem.jdField_b_of_type_Float) || ((localDrawItem.jdField_a_of_type_Float - localDrawItem.jdField_b_of_type_Int) / (paramDrawItem.jdField_b_of_type_Float - localDrawItem.jdField_b_of_type_Float) > (DanmakuLayout.a(this.jdField_b_of_type_ComTencentMobileqqGamecenterMediaDanmakuLayout) + localDrawItem.jdField_b_of_type_Int - localDrawItem.jdField_a_of_type_Float) / localDrawItem.jdField_b_of_type_Float))
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
  }
  
  boolean b()
  {
    if (this.a.size() > 0) {}
    for (boolean bool = true; bool; bool = false)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuLayout.Track
 * JD-Core Version:    0.7.0.1
 */