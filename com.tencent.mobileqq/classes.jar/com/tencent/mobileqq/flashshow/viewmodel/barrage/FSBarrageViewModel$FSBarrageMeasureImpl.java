package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FSBarrageViewModel$FSBarrageMeasureImpl
  implements Runnable
{
  private WeakReference<FSBarrageViewModel> a;
  private volatile boolean b = false;
  
  public FSBarrageViewModel$FSBarrageMeasureImpl(FSBarrageViewModel paramFSBarrageViewModel, boolean paramBoolean)
  {
    this.a = new WeakReference(paramFSBarrageViewModel);
    this.b = paramBoolean;
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
    FSBarrageViewModel.a((FSBarrageViewModel)localObject, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBarrageViewModel.FSBarrageMeasureImpl
 * JD-Core Version:    0.7.0.1
 */