package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class WordNavView$MySimpleGestureDetector
  extends GestureDetector.SimpleOnGestureListener
{
  private WordNavView$MySimpleGestureDetector(WordNavView paramWordNavView) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    float f = paramMotionEvent.getY();
    Iterator localIterator = WordNavView.a(this.a).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((f >= ((Float)localEntry.getKey()).floatValue() - this.a.getHeight() / WordNavView.b(this.a).size() / 2) && (f <= ((Float)localEntry.getKey()).floatValue() + this.a.getHeight() / WordNavView.b(this.a).size() / 2)) {
        if (WordNavView.c(this.a) != null) {
          WordNavView.c(this.a).a((String)localEntry.getValue());
        }
      }
    }
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.WordNavView.MySimpleGestureDetector
 * JD-Core Version:    0.7.0.1
 */