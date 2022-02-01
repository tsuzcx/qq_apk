package com.tencent.mobileqq.flashshow.viewmodel.layer;

import com.tencent.mobileqq.flashshow.basedata.FSDataTransFromHelper;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;

class FSLayerDetailViewModel$FeedDetailCall$2
  implements Runnable
{
  FSLayerDetailViewModel$FeedDetailCall$2(FSLayerDetailViewModel.FeedDetailCall paramFeedDetailCall, List paramList, FSLayerDetailViewModel.GetFeedDetailRspListener paramGetFeedDetailRspListener, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = FSDataTransFromHelper.a(this.a);
    this.b.d(UIStateData.a(this.c).a(false, localArrayList).c(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.layer.FSLayerDetailViewModel.FeedDetailCall.2
 * JD-Core Version:    0.7.0.1
 */