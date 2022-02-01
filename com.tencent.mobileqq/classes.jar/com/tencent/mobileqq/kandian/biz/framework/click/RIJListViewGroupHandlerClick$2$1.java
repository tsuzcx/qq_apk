package com.tencent.mobileqq.kandian.biz.framework.click;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

class RIJListViewGroupHandlerClick$2$1
  implements Runnable
{
  RIJListViewGroupHandlerClick$2$1(RIJListViewGroupHandlerClick.2 param2, PBRepeatMessageField paramPBRepeatMessageField, PBStringField paramPBStringField) {}
  
  public void run()
  {
    RIJListViewGroupHandlerClick.a(this.c.f, this.c.d);
    int i = this.c.d.d().getCount();
    if (this.c.e < i)
    {
      Object localObject = this.c.d.d().getItem(this.c.e);
      if ((localObject instanceof BaseArticleInfo))
      {
        localObject = (AbsBaseArticleInfo)localObject;
        BaseArticleInfoKt.a((AbsBaseArticleInfo)localObject, this.c.d.e().getString(2131891079), this.a, this.b);
        ((AbsBaseArticleInfo)localObject).invalidateProteusTemplateBean();
      }
    }
    ReadInJoyLogicEngineEventDispatcher.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.click.RIJListViewGroupHandlerClick.2.1
 * JD-Core Version:    0.7.0.1
 */