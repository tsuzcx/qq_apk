package com.tencent.mobileqq.widget.participle;

import android.graphics.RectF;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ParticipleView$ParticipleEntity
{
  QQText a;
  private List<RectF> b = new ArrayList();
  private List<QQText> c = new ArrayList();
  private boolean d;
  private float e = 0.0F;
  private long f;
  
  private ParticipleView$ParticipleEntity(QQText paramQQText)
  {
    this.a = paramQQText;
  }
  
  private void a(RectF paramRectF, QQText paramQQText)
  {
    if (this.b.size() > 0)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        if (paramRectF.equals((RectF)localIterator.next()))
        {
          i = 1;
          break label57;
        }
      }
    }
    int i = 0;
    label57:
    if (i == 0)
    {
      this.b.add(paramRectF);
      this.c.add(paramQQText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.participle.ParticipleView.ParticipleEntity
 * JD-Core Version:    0.7.0.1
 */