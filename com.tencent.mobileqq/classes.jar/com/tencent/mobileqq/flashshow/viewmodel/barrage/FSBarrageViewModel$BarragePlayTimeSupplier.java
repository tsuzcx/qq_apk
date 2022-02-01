package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import com.tencent.rfw.barrage.inject.IRFWBarragePlayTimeSupplier;
import java.lang.ref.WeakReference;

class FSBarrageViewModel$BarragePlayTimeSupplier
  implements IRFWBarragePlayTimeSupplier
{
  private final WeakReference<FSBarrageViewModel> a;
  
  public FSBarrageViewModel$BarragePlayTimeSupplier(FSBarrageViewModel paramFSBarrageViewModel)
  {
    this.a = new WeakReference(paramFSBarrageViewModel);
  }
  
  public long a()
  {
    FSBarrageViewModel localFSBarrageViewModel = (FSBarrageViewModel)this.a.get();
    if (localFSBarrageViewModel == null) {
      return 0L;
    }
    return FSBarrageViewModel.a(localFSBarrageViewModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBarrageViewModel.BarragePlayTimeSupplier
 * JD-Core Version:    0.7.0.1
 */