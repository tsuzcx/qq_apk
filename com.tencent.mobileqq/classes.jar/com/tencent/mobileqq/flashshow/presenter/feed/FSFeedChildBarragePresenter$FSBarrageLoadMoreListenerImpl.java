package com.tencent.mobileqq.flashshow.presenter.feed;

import com.tencent.mobileqq.flashshow.viewmodel.barrage.IFSBarrageViewModel.OnBarrageLoadMoreListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FSFeedChildBarragePresenter$FSBarrageLoadMoreListenerImpl
  implements IFSBarrageViewModel.OnBarrageLoadMoreListener
{
  private WeakReference<FSFeedChildBarragePresenter> a;
  
  public FSFeedChildBarragePresenter$FSBarrageLoadMoreListenerImpl(FSFeedChildBarragePresenter paramFSFeedChildBarragePresenter)
  {
    this.a = new WeakReference(paramFSFeedChildBarragePresenter);
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (FSFeedChildBarragePresenter)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("FSBarrageLoadMoreListenerImpl", 1, "[onBarrageLoadMore] presenter should not be null.");
      return;
    }
    FSFeedChildBarragePresenter.b((FSFeedChildBarragePresenter)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildBarragePresenter.FSBarrageLoadMoreListenerImpl
 * JD-Core Version:    0.7.0.1
 */