package com.tencent.mobileqq.kandian.repo.pts.network;

import android.os.Handler;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.glue.pts.WeakNetHelper;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class WeakNetManager
{
  private static WeakNetManager a;
  private Runnable b;
  private ToServiceMsg c;
  
  public static WeakNetManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WeakNetManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (!WeakNetHelper.a(paramToServiceMsg))
      {
        QLog.d("WeakNetManager", 1, "no need to show toast delay.");
        return;
      }
      long l = WeakNetHelper.b();
      if (this.b == null) {
        this.b = new WeakNetManager.1(this, l);
      }
      RIJThreadHandler.b().removeCallbacks(this.b);
      if (QLog.isColorLevel()) {
        QLog.d("WeakNetManager", 2, "removeCallbacks in showToastDelay.");
      }
      this.c = paramToServiceMsg;
      RIJThreadHandler.b().postDelayed(this.b, l);
      QLog.d("WeakNetManager", 1, new Object[] { "showToastDelay, delayTime = ", Long.valueOf(l) });
      return;
    }
    finally {}
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (this.c == paramToServiceMsg)
      {
        RIJThreadHandler.b().removeCallbacks(this.b);
        this.c = null;
        QLog.d("WeakNetManager", 1, "removeCallbacks in cancelToastRunnable.");
      }
      else
      {
        QLog.d("WeakNetManager", 1, "no need to cancel toastRunnable.");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.pts.network.WeakNetManager
 * JD-Core Version:    0.7.0.1
 */