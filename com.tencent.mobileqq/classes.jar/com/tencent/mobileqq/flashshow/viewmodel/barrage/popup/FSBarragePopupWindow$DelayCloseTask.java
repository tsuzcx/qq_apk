package com.tencent.mobileqq.flashshow.viewmodel.barrage.popup;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FSBarragePopupWindow$DelayCloseTask
  implements Runnable
{
  private WeakReference<FSBarragePopupWindow> a;
  
  public FSBarragePopupWindow$DelayCloseTask(FSBarragePopupWindow paramFSBarragePopupWindow)
  {
    this.a = new WeakReference(paramFSBarragePopupWindow);
  }
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSBarragePopupWindow)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("DM-FSPopupWindowHelper", 1, "[run] window should not be null.");
      return;
    }
    FSBarragePopupWindow.a((FSBarragePopupWindow)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.popup.FSBarragePopupWindow.DelayCloseTask
 * JD-Core Version:    0.7.0.1
 */