package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import java.lang.ref.WeakReference;

class FSBarrageViewModel$FSBarrageClickRunnableImpl
  implements Runnable
{
  private WeakReference<FSBarrageViewModel> a;
  private RFWBaseBarrage b;
  
  public FSBarrageViewModel$FSBarrageClickRunnableImpl(FSBarrageViewModel paramFSBarrageViewModel, RFWBaseBarrage paramRFWBaseBarrage)
  {
    this.a = new WeakReference(paramFSBarrageViewModel);
    this.b = paramRFWBaseBarrage;
  }
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSBarrageViewModel)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("DM-FSBarrageViewModel", 1, "[run] model should not be null.");
      return;
    }
    FSBarrageViewModel.b((FSBarrageViewModel)localObject, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBarrageViewModel.FSBarrageClickRunnableImpl
 * JD-Core Version:    0.7.0.1
 */