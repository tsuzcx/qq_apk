package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.IRFWBarrageExposureCallback;
import java.lang.ref.WeakReference;

class FSBarrageViewModel$FSBarrageExportImpl
  implements IRFWBarrageExposureCallback
{
  private WeakReference<FSBarrageViewModel> a;
  
  public FSBarrageViewModel$FSBarrageExportImpl(FSBarrageViewModel paramFSBarrageViewModel)
  {
    this.a = new WeakReference(paramFSBarrageViewModel);
  }
  
  public void a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSBarrageViewModel)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("FSBarrageExportImpl", 1, "[onFirstExposure] model should not be null.");
      return;
    }
    FSBarrageViewModel.a((FSBarrageViewModel)localObject, paramRFWBaseBarrage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBarrageViewModel.FSBarrageExportImpl
 * JD-Core Version:    0.7.0.1
 */