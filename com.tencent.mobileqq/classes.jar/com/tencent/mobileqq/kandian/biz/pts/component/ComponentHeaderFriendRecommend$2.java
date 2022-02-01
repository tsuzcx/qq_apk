package com.tencent.mobileqq.kandian.biz.pts.component;

import android.text.TextPaint;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ComponentHeaderFriendRecommend$2
  implements Ox978RespCallBack
{
  ComponentHeaderFriendRecommend$2(ComponentHeaderFriendRecommend paramComponentHeaderFriendRecommend, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("978 resp, result : ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", data : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", distUin : ");
    localStringBuilder.append(paramString);
    QLog.d("ComponentHeaderFriendRecommend", 2, localStringBuilder.toString());
    if ((paramBoolean) && (paramInt == 2))
    {
      this.a.mSocialFeedInfo.o = paramInt;
      this.b.l.setEnabled(false);
      this.b.l.getPaint().setFakeBoldText(false);
      this.b.l.setText(HardCodeUtil.a(2131900489));
      this.a.mSocialFeedInfo.o = 2;
      ReadInJoyLogicEngine.a().c(this.a);
      ReadInJoyLogicEngine.a().c(this.a.mSocialFeedInfo.c.a, paramInt);
      ReadInJoyLogicEngineEventDispatcher.a().c();
      return;
    }
    this.b.l.setEnabled(true);
    this.b.l.getPaint().setFakeBoldText(true);
    this.b.l.setText(HardCodeUtil.a(2131899712));
    QQToast.makeText(this.b.getContext(), HardCodeUtil.a(2131900526), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderFriendRecommend.2
 * JD-Core Version:    0.7.0.1
 */