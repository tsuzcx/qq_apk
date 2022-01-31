package com.tencent.mobileqq.nearby.smooth;

import aeyy;
import aeyz;
import aeza;
import aezb;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Adapter;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ItemLoader
{
  public Handler a;
  Map jdField_a_of_type_JavaUtilMap;
  ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  public Map b;
  
  static String a(int paramInt1, int paramInt2)
  {
    return String.valueOf(paramInt1) + String.valueOf(paramInt2);
  }
  
  public int a(Adapter paramAdapter, int paramInt)
  {
    return 1;
  }
  
  aeza a(View paramView)
  {
    aeza localaeza2 = (aeza)this.jdField_a_of_type_JavaUtilMap.get(paramView);
    aeza localaeza1 = localaeza2;
    if (localaeza2 == null)
    {
      localaeza1 = new aeza();
      localaeza1.jdField_a_of_type_JavaLangObject = null;
      localaeza1.jdField_a_of_type_Boolean = false;
      localaeza1.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilMap.put(paramView, localaeza1);
    }
    return localaeza1;
  }
  
  public abstract Object a(Adapter paramAdapter, int paramInt);
  
  public abstract Object a(Object paramObject, int paramInt);
  
  void a(int paramInt1, int paramInt2)
  {
    String str = a(paramInt1, paramInt2);
    aeyz localaeyz = (aeyz)this.b.get(str);
    if (localaeyz == null) {}
    do
    {
      return;
      this.b.remove(str);
    } while (localaeyz.jdField_a_of_type_JavaUtilConcurrentFuture == null);
    localaeyz.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
  }
  
  void a(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("Null itemContainer in cancelRequestsForContainer");
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      aeyz localaeyz = (aeyz)localIterator.next();
      if ((View)localaeyz.jdField_a_of_type_JavaLangRefSoftReference.get() == paramView)
      {
        if (localaeyz.jdField_a_of_type_JavaUtilConcurrentFuture != null) {
          localaeyz.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
        }
        localIterator.remove();
      }
    }
  }
  
  void a(View paramView1, View paramView2, aeza paramaeza, int paramInt, long paramLong)
  {
    int i = paramaeza.jdField_a_of_type_Int;
    Object localObject = paramaeza.jdField_a_of_type_JavaLangObject;
    String str = a(i, paramInt);
    aeyz localaeyz = (aeyz)this.b.get(str);
    if (localaeyz == null)
    {
      paramView1 = new aeyz(str, paramView1, paramView2, localObject, i, paramInt, paramLong);
      this.b.put(str, paramView1);
    }
    for (;;)
    {
      paramaeza.jdField_a_of_type_Boolean = false;
      paramView2 = b(localObject, paramInt);
      if (paramView2 == null) {
        break;
      }
      a(i, paramInt);
      paramView1.c = new SoftReference(paramView2);
      this.jdField_a_of_type_AndroidOsHandler.post(new aeyy(this, paramView1, true));
      return;
      localaeyz.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
      localaeyz.b = new SoftReference(paramView2);
      paramView1 = localaeyz;
    }
    paramView1.jdField_a_of_type_JavaUtilConcurrentFuture = this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new aezb(this, paramView1));
  }
  
  void a(View paramView1, View paramView2, Adapter paramAdapter, int paramInt, boolean paramBoolean)
  {
    Object localObject = a(paramAdapter, paramInt);
    if (localObject == null) {}
    for (;;)
    {
      return;
      aeza localaeza = a(paramView2);
      localaeza.jdField_a_of_type_JavaLangObject = localObject;
      localaeza.jdField_a_of_type_Int = paramInt;
      localaeza.jdField_a_of_type_Boolean = true;
      int i = a(paramAdapter, paramInt);
      paramInt = 0;
      while (paramInt < i)
      {
        if ((paramBoolean) || (a(localObject, paramInt))) {
          a(paramView1, paramView2, localaeza, paramInt, SystemClock.uptimeMillis());
        }
        paramInt += 1;
      }
    }
  }
  
  public abstract void a(View paramView, Object paramObject, int paramInt, boolean paramBoolean);
  
  public boolean a(aeyz paramaeyz)
  {
    if (paramaeyz.b == null) {
      return false;
    }
    View localView = (View)paramaeyz.b.get();
    if (localView == null) {
      return true;
    }
    int i = a(localView).jdField_a_of_type_Int;
    return (i == -1) || (paramaeyz.jdField_a_of_type_Int != i);
  }
  
  boolean a(Object paramObject, int paramInt)
  {
    return b(paramObject, paramInt) != null;
  }
  
  public abstract Object b(Object paramObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemLoader
 * JD-Core Version:    0.7.0.1
 */