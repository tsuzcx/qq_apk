package com.tencent.mobileqq.flashshow.viewmodel.tab;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.flashshow.api.bean.FSFolderBean;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import feedcloud.FeedCloudMeta.StGPSV2;
import java.util.List;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class FSMainTabViewModel
  extends BaseViewModel
{
  private final MutableLiveData<List<QQCircleFeedBase.StTabInfo>> a = new MutableLiveData();
  
  public String a()
  {
    return "FSMainTabViewModel";
  }
  
  public void a(FeedCloudMeta.StGPSV2 paramStGPSV2, FSFolderBean paramFSFolderBean)
  {
    FSThreadUtils.d(new FSMainTabViewModel.1(this, paramStGPSV2, paramFSFolderBean));
  }
  
  public MutableLiveData<List<QQCircleFeedBase.StTabInfo>> b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.tab.FSMainTabViewModel
 * JD-Core Version:    0.7.0.1
 */