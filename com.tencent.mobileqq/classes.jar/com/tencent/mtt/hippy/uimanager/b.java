package com.tencent.mtt.hippy.uimanager;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;

public class b
{
  private final SparseArray<View> a = new SparseArray();
  private final SparseArray<View> b = new SparseArray();
  private final Map<String, a> c = new HashMap();
  
  public int a()
  {
    return this.b.size();
  }
  
  public View a(int paramInt)
  {
    View localView2 = (View)this.a.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = (View)this.b.get(paramInt);
    }
    return localView1;
  }
  
  public a a(String paramString)
  {
    return (a)this.c.get(paramString);
  }
  
  public void a(View paramView)
  {
    this.a.put(paramView.getId(), paramView);
  }
  
  public void a(HippyRootView paramHippyRootView)
  {
    this.b.put(paramHippyRootView.getId(), paramHippyRootView);
  }
  
  public void a(String paramString, a parama)
  {
    this.c.put(paramString, parama);
  }
  
  public int b(int paramInt)
  {
    return this.b.keyAt(paramInt);
  }
  
  public HippyViewController b(String paramString)
  {
    try
    {
      HippyViewController localHippyViewController = ((a)this.c.get(paramString)).a;
      return localHippyViewController;
    }
    catch (Throwable localThrowable)
    {
      LogUtils.e("Hippy", "error className=" + paramString);
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public View c(int paramInt)
  {
    return (View)this.b.get(paramInt);
  }
  
  public void d(int paramInt)
  {
    this.a.remove(paramInt);
  }
  
  public void e(int paramInt)
  {
    this.b.remove(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.b
 * JD-Core Version:    0.7.0.1
 */