package com.tencent.mtt.hippy.modules.nativemodules.animation;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.ArrayList;

public class b
{
  private int a;
  private HippyRootView b;
  private HippyMap c;
  private ArrayList<a> d;
  
  public b(int paramInt, HippyRootView paramHippyRootView)
  {
    this.a = paramInt;
    this.b = paramHippyRootView;
    this.d = new ArrayList();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(HippyMap paramHippyMap)
  {
    this.c = paramHippyMap;
  }
  
  public void a(a parama)
  {
    if (!this.d.contains(parama)) {
      this.d.add(parama);
    }
  }
  
  public HippyRootView b()
  {
    return this.b;
  }
  
  public HippyMap c()
  {
    return this.c;
  }
  
  public ArrayList<a> d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.b
 * JD-Core Version:    0.7.0.1
 */