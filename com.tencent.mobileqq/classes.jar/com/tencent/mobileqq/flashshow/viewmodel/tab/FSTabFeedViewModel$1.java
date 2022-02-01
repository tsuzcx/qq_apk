package com.tencent.mobileqq.flashshow.viewmodel.tab;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.request.feed.FSTabFeedCall.GetFeedRspListener;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

class FSTabFeedViewModel$1
  implements FSTabFeedCall.GetFeedRspListener
{
  FSTabFeedViewModel$1(FSTabFeedViewModel paramFSTabFeedViewModel) {}
  
  public void a(UIStateData<List<FSFeedData>> paramUIStateData)
  {
    if (!paramUIStateData.m()) {
      FSDataCenter.a().a(FSFeedData.a((List)paramUIStateData.e()), true);
    }
    FSTabFeedViewModel.a(this.a).postValue(paramUIStateData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.tab.FSTabFeedViewModel.1
 * JD-Core Version:    0.7.0.1
 */