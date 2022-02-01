package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class FeedItemCell$10
  implements Runnable
{
  FeedItemCell$10(FeedItemCell paramFeedItemCell, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, Object paramObject, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.size())
    {
      localArrayList.add(((IReadInJoyModel)this.a.get(i)).k());
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("headerUninterestConfirm,");
      Object localObject = this.b;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = ((ArrayList)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("FeedItemCell", 2, localStringBuilder.toString());
    }
    this.this$0.g.b(this.c, localArrayList, this.b, this.d, false, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.10
 * JD-Core Version:    0.7.0.1
 */