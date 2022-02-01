package com.tencent.mtt.hippy.modules.nativemodules.animation;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.ArrayList;

public class b
{
  private final int a;
  private final HippyRootView b;
  private final ArrayList<a> c;
  private HippyMap d;
  
  public b(int paramInt, HippyRootView paramHippyRootView)
  {
    this.a = paramInt;
    this.b = paramHippyRootView;
    this.c = new ArrayList();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(HippyMap paramHippyMap)
  {
    this.d = paramHippyMap;
  }
  
  public void a(a parama)
  {
    if (!this.c.contains(parama)) {
      this.c.add(parama);
    }
  }
  
  public HippyRootView b()
  {
    return this.b;
  }
  
  public HippyMap c()
  {
    return this.d;
  }
  
  public ArrayList<a> d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.b
 * JD-Core Version:    0.7.0.1
 */