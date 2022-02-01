package com.tencent.mobileqq.flashshow.viewmodel.barrage;

import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.rfw.barrage.core.RFWBarrageManager.IBarrageListener;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.tool.RFWClickResult;
import com.tencent.rfw.barrage.tool.RFWTouchPoint;
import java.lang.ref.WeakReference;
import java.util.List;

class FSBarrageViewModel$BarragePlayListener
  implements RFWBarrageManager.IBarrageListener
{
  private WeakReference<FSBarrageViewModel> a;
  
  public FSBarrageViewModel$BarragePlayListener(FSBarrageViewModel paramFSBarrageViewModel)
  {
    this.a = new WeakReference(paramFSBarrageViewModel);
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSBarrageViewModel)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    FSThreadUtils.b(new FSBarrageViewModel.FSSourceDrawFinishRunnableImpl((FSBarrageViewModel)localObject));
  }
  
  public void a(RFWBaseBarrage paramRFWBaseBarrage, RFWTouchPoint paramRFWTouchPoint, RFWClickResult paramRFWClickResult)
  {
    paramRFWTouchPoint = this.a;
    if (paramRFWTouchPoint == null) {
      paramRFWTouchPoint = null;
    } else {
      paramRFWTouchPoint = (FSBarrageViewModel)paramRFWTouchPoint.get();
    }
    if (paramRFWTouchPoint == null) {
      return;
    }
    FSThreadUtils.b(new FSBarrageViewModel.FSBarrageClickRunnableImpl(paramRFWTouchPoint, paramRFWBaseBarrage));
  }
  
  public void a(List<RFWBaseBarrage> paramList) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSBarrageViewModel)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    FSThreadUtils.b(new FSBarrageViewModel.FSBarrageLoadMoreRunnableImpl((FSBarrageViewModel)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBarrageViewModel.BarragePlayListener
 * JD-Core Version:    0.7.0.1
 */