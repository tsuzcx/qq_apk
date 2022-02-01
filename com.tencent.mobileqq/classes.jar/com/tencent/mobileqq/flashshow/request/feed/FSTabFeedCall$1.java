package com.tencent.mobileqq.flashshow.request.feed;

import com.tencent.mobileqq.flashshow.basedata.FSDataTransFromHelper;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;

class FSTabFeedCall$1
  implements Runnable
{
  FSTabFeedCall$1(FSTabFeedCall paramFSTabFeedCall, List paramList, boolean paramBoolean, FSTabFeedCall.Param paramParam, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp) {}
  
  public void run()
  {
    Object localObject = FSDataTransFromHelper.a(this.a);
    localObject = UIStateData.a(this.b).a(FSTabFeedCall.Param.c(this.c), localObject);
    boolean bool;
    if (this.d.isFinish.get() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = ((UIStateData)localObject).c(bool);
    FSTabFeedCall.Param.d(this.c).a((UIStateData)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.feed.FSTabFeedCall.1
 * JD-Core Version:    0.7.0.1
 */