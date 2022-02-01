package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Context;
import bodt;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ForwardPhotoOption$PhotoRunnable
  implements Runnable
{
  WeakReference<Activity> a;
  
  ForwardPhotoOption$PhotoRunnable(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPhotoOption", 2, "preload peak");
    }
    if (((this.a.get() instanceof Activity)) && (!((Activity)this.a.get()).isFinishing())) {
      bodt.a((Context)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption.PhotoRunnable
 * JD-Core Version:    0.7.0.1
 */