package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.ArrayList;

public class TencentMapGestureListenerList
  implements TencentMapGestureListener
{
  private ArrayList<TencentMapGestureListener> a = new ArrayList();
  
  public void addListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    if (paramTencentMapGestureListener != null) {}
    try
    {
      if (!this.a.contains(paramTencentMapGestureListener)) {
        this.a.add(paramTencentMapGestureListener);
      }
    }
    finally {}
  }
  
  public boolean onDoubleTap(float paramFloat1, float paramFloat2)
  {
    try
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.a.get(i)).onDoubleTap(paramFloat1, paramFloat2);
        i -= 1;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean onDown(float paramFloat1, float paramFloat2)
  {
    try
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.a.get(i)).onDown(paramFloat1, paramFloat2);
        i -= 1;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean onFling(float paramFloat1, float paramFloat2)
  {
    try
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.a.get(i)).onFling(paramFloat1, paramFloat2);
        i -= 1;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean onLongPress(float paramFloat1, float paramFloat2)
  {
    try
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.a.get(i)).onLongPress(paramFloat1, paramFloat2);
        i -= 1;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onMapStable()
  {
    try
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.a.get(i)).onMapStable();
        i -= 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean onScroll(float paramFloat1, float paramFloat2)
  {
    try
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.a.get(i)).onScroll(paramFloat1, paramFloat2);
        i -= 1;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean onSingleTap(float paramFloat1, float paramFloat2)
  {
    try
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.a.get(i)).onSingleTap(paramFloat1, paramFloat2);
        i -= 1;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean onUp(float paramFloat1, float paramFloat2)
  {
    try
    {
      int i = this.a.size() - 1;
      while (i >= 0)
      {
        ((TencentMapGestureListener)this.a.get(i)).onUp(paramFloat1, paramFloat2);
        i -= 1;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void removeListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    try
    {
      this.a.remove(paramTencentMapGestureListener);
      return;
    }
    finally
    {
      paramTencentMapGestureListener = finally;
      throw paramTencentMapGestureListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList
 * JD-Core Version:    0.7.0.1
 */