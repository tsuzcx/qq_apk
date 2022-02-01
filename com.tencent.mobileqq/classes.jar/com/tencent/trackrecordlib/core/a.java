package com.tencent.trackrecordlib.core;

import android.content.Context;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.trackrecordlib.f.c.a;
import com.tencent.trackrecordlib.f.d;
import com.tencent.trackrecordlib.f.e;
import com.tencent.trackrecordlib.f.f;
import com.tencent.trackrecordlib.g.i;
import com.tencent.trackrecordlib.models.ViewRecord;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static Class g;
  private static Class h;
  private static Method i;
  private static Field j;
  private static Field k;
  private static Field l;
  private com.tencent.trackrecordlib.f.c b = b();
  private e c;
  private d d;
  private View.AccessibilityDelegate e;
  private ViewRecord f = new ViewRecord();
  
  static
  {
    try
    {
      g = Class.forName("android.view.View");
      h = Class.forName("android.view.View$ListenerInfo");
      i = g.getDeclaredMethod("getListenerInfo", new Class[0]);
      i.setAccessible(true);
      k = h.getDeclaredField("mOnTouchListener");
      k.setAccessible(true);
      l = h.getDeclaredField("mOnKeyListener");
      l.setAccessible(true);
      j = g.getDeclaredField("mAccessibilityDelegate");
      j.setAccessible(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static a a()
  {
    return a.b.a();
  }
  
  private void a(int paramInt)
  {
    this.f.mRecentTotalViewNum = paramInt;
    this.f.mRecentHookTime = System.currentTimeMillis();
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (c(paramView)) {
        l(paramView);
      }
      i(paramView);
      if (f(paramView)) {
        k(paramView);
      }
    } while (!e(paramView));
    j(paramView);
  }
  
  private boolean a(List<View> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    View localView = (View)paramList.get(0);
    if (!i.g(localView)) {
      h(localView);
    }
    for (;;)
    {
      return true;
      if ((localView.hashCode() == this.f.mRecentDecorViewHashcode) && (paramList.size() == this.f.mRecentTotalViewNum) && (Math.abs(System.currentTimeMillis() - this.f.mRecentHookTime) < 200L)) {
        return false;
      }
      this.f.mRecentDecorViewHashcode = localView.hashCode();
    }
  }
  
  private com.tencent.trackrecordlib.f.c b()
  {
    c.a locala = new c.a();
    locala.a(new a.3(this)).a(new a.2(this));
    return com.tencent.trackrecordlib.f.c.a(locala);
  }
  
  private boolean b(View paramView)
  {
    try
    {
      paramView = (View.AccessibilityDelegate)j.get(paramView);
      if (paramView != null)
      {
        boolean bool = paramView instanceof com.tencent.trackrecordlib.f.a;
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
    return false;
  }
  
  private void c()
  {
    b.a(new a.4(this));
  }
  
  private boolean c(View paramView)
  {
    return (paramView != null) && ((paramView.hasOnClickListeners()) || (paramView.isClickable()) || (paramView.isLongClickable()) || (paramView.isFocusable()));
  }
  
  private void d()
  {
    ArrayList localArrayList = i.a();
    if (!a(localArrayList)) {
      return;
    }
    Iterator localIterator = localArrayList.iterator();
    int m = 0;
    if (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      com.tencent.trackrecordlib.d.a.b().a(localView);
      if ((m == 0) && (g(localView)))
      {
        com.tencent.trackrecordlib.g.b.a(i.c(localView));
        m = 1;
      }
      for (;;)
      {
        break;
        a(localView);
      }
    }
    a(localArrayList.size());
  }
  
  private boolean d(View paramView)
  {
    return (paramView != null) && (paramView.getClass().getName().contains("Layout"));
  }
  
  private boolean e(View paramView)
  {
    return (paramView != null) && (paramView.getClass().getName().contains("EditText"));
  }
  
  private boolean f(View paramView)
  {
    return (paramView != null) && (paramView.getClass().getName().contains("canvasui.CanvasTitleView"));
  }
  
  private boolean g(View paramView)
  {
    return (paramView != null) && ((paramView instanceof TextView)) && (!"".equals(com.tencent.trackrecordlib.g.c.c)) && (com.tencent.trackrecordlib.g.c.c.equals(i.a(paramView)));
  }
  
  private void h(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      try
      {
        paramView = paramView.getViewTreeObserver();
        if ((paramView != null) && (paramView.isAlive()))
        {
          paramView.addOnGlobalLayoutListener(new a.5(this));
          paramView.addOnWindowFocusChangeListener(new a.6(this));
          return;
        }
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  private void i(View paramView)
  {
    try
    {
      paramView = i.invoke(paramView, new Object[0]);
      localObject = (View.OnTouchListener)k.get(paramView);
      if ((localObject != null) && ((localObject instanceof e))) {
        return;
      }
      if (localObject == null)
      {
        if (this.c == null) {
          this.c = new e(null, this.b.a);
        }
        k.set(paramView, this.c);
        return;
      }
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
      return;
    }
    Object localObject = new e((View.OnTouchListener)localObject, this.b.a);
    k.set(paramView, localObject);
  }
  
  private void j(View paramView)
  {
    try
    {
      paramView = i.invoke(paramView, new Object[0]);
      localObject = (View.OnKeyListener)l.get(paramView);
      if ((localObject != null) && ((localObject instanceof d))) {
        return;
      }
      if (localObject == null)
      {
        if (this.d == null) {
          this.d = new d(null, this.b.b);
        }
        l.set(paramView, this.d);
        return;
      }
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
      return;
    }
    Object localObject = new d((View.OnKeyListener)localObject, this.b.b);
    l.set(paramView, localObject);
  }
  
  private void k(View paramView)
  {
    if (paramView == null) {}
    TouchDelegate localTouchDelegate;
    do
    {
      return;
      localTouchDelegate = paramView.getTouchDelegate();
      if (localTouchDelegate == null)
      {
        paramView.setTouchDelegate(new f(null, null, paramView));
        return;
      }
    } while ((localTouchDelegate instanceof f));
    try
    {
      paramView.setTouchDelegate(new f(localTouchDelegate, null, paramView));
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  private void l(View paramView)
  {
    try
    {
      if ((View.AccessibilityDelegate)j.get(paramView) != null) {
        return;
      }
      if (this.e == null) {
        this.e = new com.tencent.trackrecordlib.f.a(null);
      }
      paramView.setAccessibilityDelegate(this.e);
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void a(Context paramContext)
  {
    com.tencent.trackrecordlib.g.b.a(paramContext, new a.1(this));
  }
  
  public void b(Context paramContext)
  {
    com.tencent.trackrecordlib.g.b.a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.a
 * JD-Core Version:    0.7.0.1
 */