package com.tencent.mobileqq.leba;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

class Leba$MyStudyModeChangeListener
  implements StudyModeChangeListener
{
  private WeakReference<Leba> a;
  
  Leba$MyStudyModeChangeListener(Leba paramLeba)
  {
    this.a = new WeakReference(paramLeba);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a == null) {}
    Leba localLeba;
    do
    {
      return;
      localLeba = (Leba)this.a.get();
    } while (localLeba == null);
    QLog.i("LebaFrame", 1, "StudyModeChange onChange " + paramBoolean);
    ((ILebaHelperService)localLeba.a.getRuntimeService(ILebaHelperService.class, "multi")).checkModleAndRefesh();
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(new Leba.MyStudyModeChangeListener.1(this, localLeba));
      return;
    }
    localLeba.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.MyStudyModeChangeListener
 * JD-Core Version:    0.7.0.1
 */