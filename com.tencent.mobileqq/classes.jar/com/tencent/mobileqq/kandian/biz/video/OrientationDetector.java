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
  private int jdField_a_of_type_Int = 1;
  private volatile OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  private volatile OrientationDetector.RotationObserver jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector$RotationObserver;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video.");
    localStringBuilder.append(OrientationDetector.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public OrientationDetector(Activity paramActivity, OrientationDetector.OnOrientationChangedListener paramOnOrientationChangedListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new OrientationDetector.1(this, paramActivity, paramActivity, new WeakReference(paramOnOrientationChangedListener));
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
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Long.valueOf(l));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
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
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (Context)localWeakReference.get();
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destory: ");
    }
    a(false, true);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector$RotationObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector$RotationObserver.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector$RotationObserver = null;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener == null) {
      return false;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a(true, false);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "mRotateSettingSwitch is false : enable failure");
      }
      return false;
    }
    a(false, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.OrientationDetector
 * JD-Core Version:    0.7.0.1
 */