package com.tencent.mobileqq.kandian.biz.video;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class OrientationDetector
{
  public static final String a;
  private volatile OrientationEventListener b;
  private int c = 1;
  private volatile OrientationDetector.RotationObserver d;
  private WeakReference<Context> e;
  private boolean f = false;
  private HashMap<Integer, Long> g;
  private Object h = new Object();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video.");
    localStringBuilder.append(OrientationDetector.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public OrientationDetector(Activity paramActivity, OrientationDetector.OnOrientationChangedListener paramOnOrientationChangedListener)
  {
    this.e = new WeakReference(paramActivity);
    this.g = new HashMap();
    synchronized (this.h)
    {
      this.b = new OrientationDetector.1(this, paramActivity, paramActivity, new WeakReference(paramOnOrientationChangedListener));
      ThreadManager.executeOnSubThread(new OrientationDetector.2(this, paramActivity));
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.executeOnSubThread(new OrientationDetector.3(this, paramBoolean1, paramBoolean2));
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt >= 70) && (paramInt <= 110)) {
      paramInt = 1;
    } else if ((paramInt >= 250) && (paramInt <= 290)) {
      paramInt = 2;
    } else {
      paramInt = 0;
    }
    long l = System.currentTimeMillis();
    this.g.put(Integer.valueOf(paramInt), Long.valueOf(l));
    Iterator localIterator = this.g.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() != paramInt) && (l - ((Long)localEntry.getValue()).longValue() < 200L)) {
        return false;
      }
    }
    return true;
  }
  
  public Context a()
  {
    WeakReference localWeakReference = this.e;
    if (localWeakReference != null) {
      return (Context)localWeakReference.get();
    }
    return null;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.b == null) {
      return false;
    }
    if (paramBoolean)
    {
      if (this.f)
      {
        a(true, false);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.w(a, 2, "mRotateSettingSwitch is false : enable failure");
      }
      return false;
    }
    a(false, false);
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "destory: ");
    }
    a(false, true);
    if (this.d != null)
    {
      this.d.c();
      this.d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.OrientationDetector
 * JD-Core Version:    0.7.0.1
 */