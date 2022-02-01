package com.tencent.mobileqq.flashshow.presenter.feed;

import com.tencent.mobileqq.flashshow.viewmodel.barrage.IFSBarrageViewModel.OnMeasureBarrageListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FSFeedChildBarragePresenter$FSBarrageListenerImpl
  implements IFSBarrageViewModel.OnMeasureBarrageListener
{
  private WeakReference<FSFeedChildBarragePresenter> a;
  
  public FSFeedChildBarragePresenter$FSBarrageListenerImpl(FSFeedChildBarragePresenter paramFSFeedChildBarragePresenter)
  {
    this.a = new WeakReference(paramFSFeedChildBarragePresenter);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSFeedChildBarragePresenter)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[loadMeasureFinish] presenter should not be null.");
      return;
    }
    FSFeedChildBarragePresenter.a((FSFeedChildBarragePresenter)localObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildBarragePresenter.FSBarrageListenerImpl
 * JD-Core Version:    0.7.0.1
 */