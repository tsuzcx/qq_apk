package com.tencent.mobileqq.confess;

import android.graphics.Rect;
import java.util.Comparator;

class TagUtils$TagArrangementEngine$3
  implements Comparator<Rect>
{
  TagUtils$TagArrangementEngine$3(TagUtils.TagArrangementEngine paramTagArrangementEngine) {}
  
  public int a(Rect paramRect1, Rect paramRect2)
  {
    if (paramRect1.height() * paramRect1.width() > paramRect2.height() * paramRect2.width()) {}
    do
    {
      return -1;
      if (paramRect1.height() * paramRect1.width() < paramRect2.height() * paramRect2.width()) {
        return 1;
      }
    } while (paramRect1.width() > paramRect2.width());
    if (paramRect1.width() < paramRect2.width()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TagUtils.TagArrangementEngine.3
 * JD-Core Version:    0.7.0.1
 */