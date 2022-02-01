package com.tencent.mobileqq.flashshow.personal.interceptor;

import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.basedata.FSDataTransFromHelper;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.personal.request.FSGetFeedListLikeRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;

public class FSGetFeedListUIStateManager
  extends FSUIStateBaseManager<FSFeedData, FSGetFeedListLikeRequest, FeedCloudRead.StGetFeedListRsp>
{
  private String a;
  
  protected void a(FSGetFeedListLikeRequest paramFSGetFeedListLikeRequest)
  {
    if ((paramFSGetFeedListLikeRequest != null) && (!TextUtils.isEmpty(this.a))) {
      paramFSGetFeedListLikeRequest.setAttachInfo(this.a);
    }
  }
  
  public boolean a(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    return paramStGetFeedListRsp.isFinish.get() > 0;
  }
  
  public List<FSFeedData> b(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    this.a = paramStGetFeedListRsp.feedAttchInfo.get();
    return FSDataTransFromHelper.a(paramStGetFeedListRsp.vecFeed.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.interceptor.FSGetFeedListUIStateManager
 * JD-Core Version:    0.7.0.1
 */