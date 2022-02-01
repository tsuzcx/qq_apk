package com.tencent.mobileqq.flashshow.personal.interceptor;

import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.basedata.FSDataTransFromHelper;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.personal.request.FSGetMainPageRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;

public class FSGetMainUIStateManager
  extends FSUIStateBaseManager<FSFeedData, FSGetMainPageRequest, FeedCloudRead.StGetMainPageRsp>
{
  private String a;
  
  protected void a(FSGetMainPageRequest paramFSGetMainPageRequest)
  {
    if ((paramFSGetMainPageRequest != null) && (!TextUtils.isEmpty(this.a))) {
      paramFSGetMainPageRequest.setAttachInfo(this.a);
    }
  }
  
  public boolean a(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    return paramStGetMainPageRsp.isFinish.get() > 0;
  }
  
  public List<FSFeedData> b(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    this.a = paramStGetMainPageRsp.feedAttchInfo.get();
    return FSDataTransFromHelper.a(paramStGetMainPageRsp.vecFeed.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.interceptor.FSGetMainUIStateManager
 * JD-Core Version:    0.7.0.1
 */