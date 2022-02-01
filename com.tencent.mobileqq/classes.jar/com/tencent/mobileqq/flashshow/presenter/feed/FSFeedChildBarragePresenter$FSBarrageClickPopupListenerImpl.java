package com.tencent.mobileqq.flashshow.presenter.feed;

import com.tencent.mobileqq.flashshow.viewmodel.barrage.IFSBarrageViewModel.OnBarrageClickPopupListener;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean.BarrageHolderParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FSFeedChildBarragePresenter$FSBarrageClickPopupListenerImpl
  implements IFSBarrageViewModel.OnBarrageClickPopupListener
{
  private WeakReference<FSFeedChildBarragePresenter> b;
  
  public FSFeedChildBarragePresenter$FSBarrageClickPopupListenerImpl(FSFeedChildBarragePresenter paramFSFeedChildBarragePresenter1, FSFeedChildBarragePresenter paramFSFeedChildBarragePresenter2)
  {
    this.b = new WeakReference(paramFSFeedChildBarragePresenter2);
  }
  
  public void a(BarrageHolderParam paramBarrageHolderParam)
  {
    Object localObject = this.b;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSFeedChildBarragePresenter)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("FSBarrageClickPopupListenerImpl", 1, "[onBarrageClickPopupShow] presenter should not be null.");
      return;
    }
    FSFeedChildBarragePresenter.a((FSFeedChildBarragePresenter)localObject, paramBarrageHolderParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildBarragePresenter.FSBarrageClickPopupListenerImpl
 * JD-Core Version:    0.7.0.1
 */