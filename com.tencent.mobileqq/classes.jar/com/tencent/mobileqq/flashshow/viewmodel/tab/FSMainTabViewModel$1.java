package com.tencent.mobileqq.flashshow.viewmodel.tab;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.flashshow.api.bean.FSFolderBean;
import com.tencent.mobileqq.flashshow.manager.FSMainTabInfoManager;
import feedcloud.FeedCloudMeta.StGPSV2;

class FSMainTabViewModel$1
  implements Runnable
{
  FSMainTabViewModel$1(FSMainTabViewModel paramFSMainTabViewModel, FeedCloudMeta.StGPSV2 paramStGPSV2, FSFolderBean paramFSFolderBean) {}
  
  public void run()
  {
    FSMainTabViewModel.a(this.this$0).postValue(FSMainTabInfoManager.a().c(this.a, this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.tab.FSMainTabViewModel.1
 * JD-Core Version:    0.7.0.1
 */