package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;

class ComponentHeaderTopicRecommend$4
  implements Ox978RespCallBack
{
  ComponentHeaderTopicRecommend$4(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 2)) {
      ThreadManager.post(new ComponentHeaderTopicRecommend.4.1(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderTopicRecommend.4
 * JD-Core Version:    0.7.0.1
 */