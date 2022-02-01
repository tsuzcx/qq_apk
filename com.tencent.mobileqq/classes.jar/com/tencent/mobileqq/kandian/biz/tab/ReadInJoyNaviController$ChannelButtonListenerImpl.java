package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ReadInJoyNaviController$ChannelButtonListenerImpl
  implements ReadInJoyNavigationAdapter.ChannelButtonListener
{
  private WeakReference<ReadInJoyNaviController> a;
  
  ReadInJoyNaviController$ChannelButtonListenerImpl(ReadInJoyNaviController paramReadInJoyNaviController)
  {
    this.a = new WeakReference(paramReadInJoyNaviController);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    ReadInJoyNaviController localReadInJoyNaviController = (ReadInJoyNaviController)this.a.get();
    if ((localReadInJoyNaviController != null) && (!ReadInJoyNaviController.a(localReadInJoyNaviController).a()))
    {
      localReadInJoyNaviController.a(paramChannelCoverInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController.ChannelButtonListenerImpl
 * JD-Core Version:    0.7.0.1
 */