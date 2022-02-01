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
  
  public void onChange(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (Leba)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StudyModeChange onChange ");
    localStringBuilder.append(paramBoolean);
    QLog.i("LebaFrame", 1, localStringBuilder.toString());
    ((ILebaHelperService)((Leba)localObject).a.getRuntimeService(ILebaHelperService.class, "multi")).checkModleAndRefesh();
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManagerV2.getUIHandlerV2().post(new Leba.MyStudyModeChangeListener.1(this, (Leba)localObject));
      return;
    }
    ((Leba)localObject).m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.MyStudyModeChangeListener
 * JD-Core Version:    0.7.0.1
 */