package com.tencent.mobileqq.kandian.biz.pts.component;

import android.os.Looper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ComponentContentRecommend$7
  extends ReadInJoyObserver
{
  ComponentContentRecommend$7(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QLog.e(ComponentContentRecommend.a, 2, "Please call this method in main thread!!!");
      return;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = ComponentContentRecommend.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onUpdateAfterAccountFollow uin = ");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(" isFollow = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = ComponentContentRecommend.d(this.a).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecommendFollowInfo)((Iterator)localObject1).next();
      if (paramLong == ((RecommendFollowInfo)localObject2).uin) {
        ((RecommendFollowInfo)localObject2).isFollowed = paramBoolean;
      }
    }
    ComponentContentRecommend.e(this.a).notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList)
  {
    if ((ComponentContentRecommend.b(this.a) != null) && (ComponentContentRecommend.b(this.a).mRecommendFollowInfos != null))
    {
      if (ComponentContentRecommend.b(this.a).mArticleID != paramLong) {
        return;
      }
      if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
      {
        ComponentContentRecommend.a(this.a).clearAnimation();
        ComponentContentRecommend.b(this.a).mRecommendFollowInfos.c.clear();
        ComponentContentRecommend.b(this.a).mRecommendFollowInfos.c.addAll(paramList);
        ReadInJoyLogicEngine.a().f(ComponentContentRecommend.b(this.a));
        ComponentContentRecommend.d(this.a).clear();
        ComponentContentRecommend.d(this.a).addAll(paramList);
        ComponentContentRecommend.e(this.a).notifyDataSetChanged();
        return;
      }
      QQToast.makeText(ComponentContentRecommend.f(this.a), 1, HardCodeUtil.a(2131900507), 1).show();
      ComponentContentRecommend.a(this.a).clearAnimation();
      return;
    }
    QQToast.makeText(ComponentContentRecommend.f(this.a), 1, HardCodeUtil.a(2131900504), 1).show();
    ComponentContentRecommend.a(this.a).clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend.7
 * JD-Core Version:    0.7.0.1
 */