package com.tencent.trackrecordlib.d;

import android.view.View;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class b
  implements c
{
  private static final String a = "ExposureRecorderImpl";
  private final Set<View> b = Collections.newSetFromMap(new WeakHashMap());
  private final Set<View> c = Collections.unmodifiableSet(this.b);
  
  public static b c()
  {
    return b.a.a();
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(View paramView)
  {
    this.b.add(paramView);
  }
  
  public void a(Collection<View> paramCollection)
  {
    this.b.removeAll(paramCollection);
  }
  
  public Set<View> b()
  {
    return this.c;
  }
  
  public boolean b(View paramView)
  {
    return this.b.contains(paramView);
  }
  
  public void c(View paramView)
  {
    this.b.remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.d.b
 * JD-Core Version:    0.7.0.1
 */