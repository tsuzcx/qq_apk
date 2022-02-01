package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelCoverInfoModule$11
  implements Runnable
{
  ChannelCoverInfoModule$11(ChannelCoverInfoModule paramChannelCoverInfoModule, List paramList1, List paramList2) {}
  
  public void run()
  {
    Object localObject = this.a.iterator();
    TabChannelCoverInfo localTabChannelCoverInfo;
    while (((Iterator)localObject).hasNext())
    {
      localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      this.this$0.removeEntityIfExistsInDB(localTabChannelCoverInfo);
    }
    localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      localTabChannelCoverInfo.setStatus(1000);
      JSONObject localJSONObject;
      if (localTabChannelCoverInfo.redPoint != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("startTimestamp", localTabChannelCoverInfo.redPoint.b);
        localJSONObject.put("endTimestamp", localTabChannelCoverInfo.redPoint.c);
        localJSONObject.put("animationTimestamp", localTabChannelCoverInfo.redPoint.d);
        localJSONObject.put("isShow", localTabChannelCoverInfo.redPoint.a);
        localJSONObject.put("type", localTabChannelCoverInfo.redPoint.e);
        localJSONObject.put("titleText", localTabChannelCoverInfo.redPoint.f);
        localJSONObject.put("titleColor", localTabChannelCoverInfo.redPoint.g);
        localJSONObject.put("titleBgColor", localTabChannelCoverInfo.redPoint.h);
        localTabChannelCoverInfo.redPointJson = localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        label214:
        break label214;
      }
      if ((localTabChannelCoverInfo.mChannelCoverId == 70) && (!TextUtils.isEmpty(localTabChannelCoverInfo.mChannelJumpUrl))) {
        ViolaAccessHelper.i(localTabChannelCoverInfo.mChannelJumpUrl);
      }
      this.this$0.updateEntity(localTabChannelCoverInfo);
    }
    localObject = ChannelCoverInfoModule.b(this.this$0);
    if (localObject != null)
    {
      QLog.i("ChannelCoverInfoModule", 1, "now channels in db are:\n");
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        QLog.i("ChannelCoverInfoModule", 1, ((TabChannelCoverInfo)((Iterator)localObject).next()).toString());
      }
    }
    QLog.i("ChannelCoverInfoModule", 1, "now channels in db are null:\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.11
 * JD-Core Version:    0.7.0.1
 */