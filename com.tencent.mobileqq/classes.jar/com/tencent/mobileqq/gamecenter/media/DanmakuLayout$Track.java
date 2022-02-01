package com.tencent.mobileqq.gamecenter.media;

import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DanmakuLayout$Track
  extends DanmakuLayout.Layout
{
  private List<DanmakuLayout.DrawItem> g = new ArrayList();
  
  DanmakuLayout$Track(DanmakuLayout paramDanmakuLayout)
  {
    super(paramDanmakuLayout);
  }
  
  void a(long paramLong)
  {
    if (this.g.size() > 0)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        DanmakuLayout.DrawItem localDrawItem = (DanmakuLayout.DrawItem)localIterator.next();
        if (!localDrawItem.a(paramLong, this.b))
        {
          localDrawItem.a();
          localIterator.remove();
        }
      }
    }
  }
  
  boolean a()
  {
    return this.g.size() > 0;
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
      Object localObject = this.g;
      localObject = (DanmakuLayout.DrawItem)((List)localObject).get(((List)localObject).size() - 1);
      double d1 = ((DanmakuLayout.DrawItem)localObject).d;
      double d2 = ((DanmakuLayout.DrawItem)localObject).h + 40;
      double d3 = Math.random();
      Double.isNaN(d2);
      if (d1 > d2 + d3 * 40.0D)
      {
        DanmakuLayout.DrawItem.a(paramDrawItem);
        bool1 = bool2;
        if (paramDrawItem.f < ((DanmakuLayout.DrawItem)localObject).f) {
          break label175;
        }
        if ((((DanmakuLayout.DrawItem)localObject).d - ((DanmakuLayout.DrawItem)localObject).h) / (paramDrawItem.f - ((DanmakuLayout.DrawItem)localObject).f) > (DanmakuLayout.g(this.f) + ((DanmakuLayout.DrawItem)localObject).h - ((DanmakuLayout.DrawItem)localObject).d) / ((DanmakuLayout.DrawItem)localObject).f)
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
      this.g.add(paramDrawItem);
      if (paramDrawItem.k.getParent() == null) {
        this.f.addView(paramDrawItem.k);
      }
    }
    return bool1;
  }
  
  boolean b()
  {
    boolean bool;
    if (this.g.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        ((DanmakuLayout.DrawItem)localIterator.next()).a();
        localIterator.remove();
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuLayout.Track
 * JD-Core Version:    0.7.0.1
 */