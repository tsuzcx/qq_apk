package com.tencent.mobileqq.surfaceviewaction.nv;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import bdxv;
import bdyb;
import bdzt;
import java.util.ArrayList;
import java.util.Iterator;

public class SpriteNativeView
  extends FrameLayout
  implements bdyb<bdzt>, Runnable
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ArrayList<bdzt> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  
  public SpriteNativeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SpriteNativeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((bdzt)localIterator.next()).c() | bool) {}
    if (bool) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 16L);
    }
  }
  
  public void a(int paramInt, bdzt parambdzt)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(parambdzt))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, parambdzt);
      parambdzt.d();
    }
  }
  
  public void a(bdzt parambdzt)
  {
    a(this.jdField_a_of_type_JavaUtilArrayList.size(), parambdzt);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bdxv)localIterator.next()).b();
    }
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bdxv)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bdxv)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    a();
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView
 * JD-Core Version:    0.7.0.1
 */