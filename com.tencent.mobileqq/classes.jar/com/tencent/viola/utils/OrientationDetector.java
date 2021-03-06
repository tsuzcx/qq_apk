package com.tencent.viola.utils;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.viola.core.ViolaSDKManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class OrientationDetector
{
  public static final String TAG = "OrientationDetector";
  private WeakReference<Context> mContextRef;
  private int mCurrentOrientation = 1;
  private volatile OrientationEventListener mEventListener;
  private int mHorizontalAngle = 20;
  private Object mLock = new Object();
  private HashMap<Integer, Long> mOrientationEventMap;
  private boolean mRotateSettingSwitch = false;
  private volatile OrientationDetector.RotationObserver mRotationObserver;
  private int mVerticalAngle = 30;
  
  public OrientationDetector(Activity paramActivity, OrientationDetector.OnOrientationChangedListener paramOnOrientationChangedListener)
  {
    this.mContextRef = new WeakReference(paramActivity);
    this.mOrientationEventMap = new HashMap();
    ViolaSDKManager.getInstance().postOnThreadPool(new OrientationDetector.1(this, paramActivity));
    synchronized (this.mLock)
    {
      this.mEventListener = new OrientationDetector.2(this, paramActivity, paramOnOrientationChangedListener);
      return;
    }
  }
  
  private boolean innerCheckCanDetectOrientation(int paramInt)
  {
    if ((paramInt >= 70) && (paramInt <= 110)) {
      paramInt = 1;
    } else if ((paramInt >= 250) && (paramInt <= 290)) {
      paramInt = 2;
    } else {
      paramInt = 0;
    }
    long l = System.currentTimeMillis();
    this.mOrientationEventMap.put(Integer.valueOf(paramInt), Long.valueOf(l));
    Iterator localIterator = this.mOrientationEventMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() != paramInt) && (l - ((Long)localEntry.getValue()).longValue() < 200L)) {
        return false;
      }
    }
    return true;
  }
  
  private void innerEnable(boolean paramBoolean1, boolean paramBoolean2)
  {
    ViolaSDKManager.getInstance().postOnThreadPool(new OrientationDetector.3(this, paramBoolean1, paramBoolean2));
  }
  
  public void destroy()
  {
    ViolaLogUtils.d("OrientationDetector", "viola OrientationDetector destroy");
    innerEnable(false, true);
    if (this.mRotationObserver != null)
    {
      this.mRotationObserver.unregisterObserver();
      this.mRotationObserver = null;
    }
  }
  
  public boolean enable(boolean paramBoolean)
  {
    if (this.mEventListener == null) {
      return false;
    }
    if (paramBoolean)
    {
      if (this.mRotateSettingSwitch)
      {
        innerEnable(true, false);
        return true;
      }
      ViolaLogUtils.d("OrientationDetector", "mRotateSettingSwitch is false : enable failure");
      return false;
    }
    innerEnable(false, false);
    return true;
  }
  
  public Context getContext()
  {
    WeakReference localWeakReference = this.mContextRef;
    if (localWeakReference != null) {
      return (Context)localWeakReference.get();
    }
    return null;
  }
  
  public void setHorizontalAngle(int paramInt)
  {
    this.mHorizontalAngle = paramInt;
  }
  
  public void setVerticalAngle(int paramInt)
  {
    this.mVerticalAngle = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.utils.OrientationDetector
 * JD-Core Version:    0.7.0.1
 */