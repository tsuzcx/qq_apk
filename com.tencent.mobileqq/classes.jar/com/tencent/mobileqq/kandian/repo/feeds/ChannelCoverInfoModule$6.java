package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelCoverInfoModule$6
  implements Runnable
{
  ChannelCoverInfoModule$6(ChannelCoverInfoModule paramChannelCoverInfoModule) {}
  
  public void run()
  {
    List localList = this.this$0.e();
    if (localList.isEmpty())
    {
      localList.add(new ChannelSection(TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG, HardCodeUtil.a(2131899775), HardCodeUtil.a(2131899749)));
      localList.add(new ChannelSection(TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG, HardCodeUtil.a(2131899765), HardCodeUtil.a(2131899773)));
    }
    Object localObject2 = new HashMap();
    Object localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (ChannelSection)((Iterator)localObject1).next();
      ((HashMap)localObject2).put(Long.valueOf(((ChannelSection)localObject3).a), ((ChannelSection)localObject3).d);
    }
    localObject1 = ((ChannelSection)localList.get(0)).d;
    Object localObject3 = ChannelCoverInfoModule.b(this.this$0);
    Object localObject4;
    Object localObject5;
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject4 = localList.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((ChannelSection)((Iterator)localObject4).next()).d.clear();
      }
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (TabChannelCoverInfo)((Iterator)localObject3).next();
        QLog.d("ChannelCoverInfoModule", 2, ((TabChannelCoverInfo)localObject4).toString());
        if (!TextUtils.isEmpty(((TabChannelCoverInfo)localObject4).redPointJson)) {
          try
          {
            ((TabChannelCoverInfo)localObject4).redPoint = ((TabChannelCoverInfo.RedPoint)JSONUtils.b(new JSONObject(((TabChannelCoverInfo)localObject4).redPointJson), TabChannelCoverInfo.RedPoint.class));
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("loadAllChannelCoverListFromDb: ");
              localStringBuilder.append(localJSONException);
              QLog.e("ChannelCoverInfoModule", 2, localStringBuilder.toString());
            }
          }
        }
        localObject5 = (List)((HashMap)localObject2).get(Long.valueOf(((TabChannelCoverInfo)localObject4).channelConfigType));
        if (localObject5 != null) {
          ((List)localObject5).add(localObject4);
        }
      }
      localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        Collections.sort(((ChannelSection)((Iterator)localObject2).next()).d, new ChannelCoverInfoModule.6.1(this));
      }
      if (((List)localObject1).size() == 0)
      {
        QLog.d("ChannelCoverInfoModule", 2, "loadAllChannelCoverListFromDb mylist empty");
        ((List)localObject1).addAll(this.this$0.d());
        ((ChannelSection)localList.get(1)).d.clear();
        localObject2 = ChannelCoverInfoModule.c(this.this$0).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TabChannelCoverInfo)((Iterator)localObject2).next();
          localObject4 = ((List)localObject1).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (TabChannelCoverInfo)((Iterator)localObject4).next();
            if (((TabChannelCoverInfo)localObject3).mChannelCoverId == ((TabChannelCoverInfo)localObject5).mChannelCoverId)
            {
              i = 1;
              break label549;
            }
          }
          int i = 0;
          label549:
          if (i == 0) {
            ((ChannelSection)localList.get(1)).d.add(localObject3);
          }
        }
      }
      localObject2 = ChannelCoverInfoModule.a(this.this$0, (List)localObject1, TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG);
      ((List)localObject1).clear();
      ((List)localObject1).addAll((Collection)localObject2);
      localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ChannelSection)((Iterator)localObject2).next();
        localObject4 = ((ChannelSection)localObject3).d;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("loadAllChannelCoverListFromDb ");
        ((StringBuilder)localObject5).append(((ChannelSection)localObject3).a);
        ChannelCoverInfoModule.a((List)localObject4, ((StringBuilder)localObject5).toString());
      }
      ChannelCoverInfoModule.a(this.this$0, true, (List)localObject1);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "loadAllChannelCoverListFromDb list is null");
      }
      ((List)localObject1).addAll(this.this$0.d());
      ((ChannelSection)localList.get(1)).d.clear();
      ((ChannelSection)localList.get(1)).d.addAll(ChannelCoverInfoModule.c(this.this$0));
      localObject2 = localList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ChannelSection)((Iterator)localObject2).next();
        localObject4 = ((ChannelSection)localObject3).d;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("loadAllChannelCoverListFromDb default");
        ((StringBuilder)localObject5).append(((ChannelSection)localObject3).a);
        ChannelCoverInfoModule.a((List)localObject4, ((StringBuilder)localObject5).toString());
      }
      ChannelCoverInfoModule.a(this.this$0, true, (List)localObject1);
    }
    ChannelCoverInfoModule.a(this.this$0, localList);
    ThreadManager.getUIHandler().post(new ChannelCoverInfoModule.6.2(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.6
 * JD-Core Version:    0.7.0.1
 */