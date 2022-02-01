package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FSBarrageViewModel$FSSourceDrawFinishRunnableImpl
  implements Runnable
{
  private WeakReference<FSBarrageViewModel> a;
  
  public FSBarrageViewModel$FSSourceDrawFinishRunnableImpl(FSBarrageViewModel paramFSBarrageViewModel)
  {
    this.a = new WeakReference(paramFSBarrageViewModel);
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
    FSBarrageViewModel.c((FSBarrageViewModel)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBarrageViewModel.FSSourceDrawFinishRunnableImpl
 * JD-Core Version:    0.7.0.1
 */