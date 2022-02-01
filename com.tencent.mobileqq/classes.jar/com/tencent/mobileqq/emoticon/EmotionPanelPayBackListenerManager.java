package com.tencent.mobileqq.emoticon;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class EmotionPanelPayBackListenerManager
{
  private static EmotionPanelPayBackListenerManager b;
  ArrayList<WeakReference<EmotionPanelPayBackListener>> a = new ArrayList();
  
  public static EmotionPanelPayBackListenerManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new EmotionPanelPayBackListenerManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmotionPanelPayBackListener localEmotionPanelPayBackListener = (EmotionPanelPayBackListener)((WeakReference)((Iterator)localObject).next()).get();
        if (localEmotionPanelPayBackListener != null) {
          localEmotionPanelPayBackListener.onPayBack(paramInt);
        }
      }
    }
  }
  
  public void a(EmotionPanelPayBackListener paramEmotionPanelPayBackListener)
  {
    if (paramEmotionPanelPayBackListener == null) {
      return;
    }
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramEmotionPanelPayBackListener) {
          return;
        }
      }
      paramEmotionPanelPayBackListener = new WeakReference(paramEmotionPanelPayBackListener);
      this.a.add(paramEmotionPanelPayBackListener);
      return;
    }
    for (;;)
    {
      throw paramEmotionPanelPayBackListener;
    }
  }
  
  public void b()
  {
    synchronized (this.a)
    {
      this.a.clear();
      return;
    }
  }
  
  public void b(EmotionPanelPayBackListener paramEmotionPanelPayBackListener)
  {
    if (paramEmotionPanelPayBackListener == null) {
      return;
    }
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramEmotionPanelPayBackListener) {
          localIterator.remove();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramEmotionPanelPayBackListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmotionPanelPayBackListenerManager
 * JD-Core Version:    0.7.0.1
 */