package com.tencent.mobileqq.vas.ui;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class VipPngPlayAnimationDrawable$DecodeNextFrameTask
  extends AsyncTask<Long, Void, Void>
{
  private Object b;
  
  public VipPngPlayAnimationDrawable$DecodeNextFrameTask(VipPngPlayAnimationDrawable paramVipPngPlayAnimationDrawable, Object paramObject)
  {
    this.b = paramObject;
  }
  
  protected Void a(Long... paramVarArgs)
  {
    try
    {
      long l1 = paramVarArgs[0].longValue();
      long l2 = paramVarArgs[1].longValue();
      long l3 = paramVarArgs[2].longValue();
      paramVarArgs = this.a.a((int)l3, this.b, (int)l2);
      if ((paramVarArgs != null) && (!isCancelled()))
      {
        this.a.q = paramVarArgs;
        l2 = SystemClock.uptimeMillis();
        if (l2 < l1)
        {
          this.a.v.postDelayed(this.a, l1 - l2);
          return null;
        }
        this.a.v.post(this.a);
        return null;
      }
    }
    catch (Throwable paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("VipPngPlayAnimationDrawable", 4, "", paramVarArgs);
      }
      paramVarArgs = this.a;
      paramVarArgs.q = null;
      paramVarArgs.w = true;
      return null;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("VipPngPlayAnimationDrawable", 4, "", paramVarArgs);
      }
      paramVarArgs = this.a;
      paramVarArgs.q = null;
      paramVarArgs.w = true;
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    this.a.x = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable.DecodeNextFrameTask
 * JD-Core Version:    0.7.0.1
 */