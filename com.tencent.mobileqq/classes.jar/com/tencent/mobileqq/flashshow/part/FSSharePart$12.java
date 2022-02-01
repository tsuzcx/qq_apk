package com.tencent.mobileqq.flashshow.part;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.flashshow.bean.FSShareInfo;
import com.tencent.mobileqq.flashshow.request.feed.FSDeleteFeedRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;

class FSSharePart$12
  implements DialogInterface.OnClickListener
{
  FSSharePart$12(FSSharePart paramFSSharePart) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (FSSharePart.m(this.a).a.isRecomFd.get())
      {
        paramDialogInterface = new FeedCloudMeta.StFeed();
        paramDialogInterface.id.set(FSSharePart.m(this.a).a.recomForward.id.get());
        paramDialogInterface.poster.set(FSSharePart.m(this.a).a.recomForward.poster.get());
      }
      else
      {
        paramDialogInterface = FSSharePart.m(this.a).a;
      }
      String str = paramDialogInterface.id.get();
      paramDialogInterface = new FSDeleteFeedRequest(paramDialogInterface);
      VSNetworkHelper.getInstance().sendRequest(paramDialogInterface, new FSSharePart.12.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSSharePart.12
 * JD-Core Version:    0.7.0.1
 */