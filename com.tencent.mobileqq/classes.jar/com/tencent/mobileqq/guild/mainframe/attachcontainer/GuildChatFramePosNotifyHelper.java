package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.view.MotionEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GuildChatFramePosNotifyHelper
{
  NotifyData a = null;
  private Set<AbsGestureListener> b = new HashSet();
  
  public GuildChatFramePosNotifyHelper(float paramFloat1, float paramFloat2)
  {
    this.a = new NotifyData(paramFloat1, paramFloat2);
  }
  
  public int a()
  {
    return this.a.a();
  }
  
  public void a(float paramFloat)
  {
    this.a.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(AbsGestureListener paramAbsGestureListener)
  {
    if (paramAbsGestureListener != null) {
      this.b.add(paramAbsGestureListener);
    }
  }
  
  public void a(NotifyData paramNotifyData)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      AbsGestureListener localAbsGestureListener = (AbsGestureListener)localIterator.next();
      if (localAbsGestureListener != null) {
        localAbsGestureListener.a(paramNotifyData);
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      AbsGestureListener localAbsGestureListener = (AbsGestureListener)localIterator.next();
      if ((localAbsGestureListener != null) && (localAbsGestureListener.a(paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    return this.a.c();
  }
  
  public void b(float paramFloat)
  {
    this.a.b(paramFloat);
  }
  
  public void b(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void b(AbsGestureListener paramAbsGestureListener)
  {
    if (paramAbsGestureListener != null) {
      this.b.remove(paramAbsGestureListener);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      AbsGestureListener localAbsGestureListener = (AbsGestureListener)localIterator.next();
      if (localAbsGestureListener != null) {
        localAbsGestureListener.a(this.a);
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.a.c(paramInt);
  }
  
  public void d()
  {
    Set localSet = this.b;
    if (localSet != null) {
      localSet.clear();
    }
  }
  
  public void d(int paramInt)
  {
    this.a.d(paramInt);
  }
  
  public boolean e(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      AbsGestureListener localAbsGestureListener = (AbsGestureListener)localIterator.next();
      if ((localAbsGestureListener != null) && (localAbsGestureListener.a(paramInt))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFramePosNotifyHelper
 * JD-Core Version:    0.7.0.1
 */