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

class ComponentHeaderUgc$3
  implements Ox978RespCallBack
{
  ComponentHeaderUgc$3(ComponentHeaderUgc paramComponentHeaderUgc, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("978 resp, result : ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", data : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", distUin : ");
    localStringBuilder.append(paramString);
    QLog.d("ComponentHeaderUgc", 2, localStringBuilder.toString());
    if ((paramBoolean) && (paramInt == 2))
    {
      this.a.mSocialFeedInfo.o = paramInt;
      this.b.g.setEnabled(false);
      this.b.g.setText(HardCodeUtil.a(2131900455));
      this.b.g.getPaint().setFakeBoldText(false);
      this.a.mSocialFeedInfo.o = 2;
      ReadInJoyLogicEngine.a().c(this.a);
      ReadInJoyLogicEngine.a().c(this.a.mSocialFeedInfo.c.a, paramInt);
      ReadInJoyLogicEngineEventDispatcher.a().c();
      return;
    }
    this.b.g.setEnabled(true);
    this.b.g.setText(HardCodeUtil.a(2131899712));
    this.b.g.getPaint().setFakeBoldText(true);
    QQToast.makeText(this.b.getContext(), HardCodeUtil.a(2131900484), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderUgc.3
 * JD-Core Version:    0.7.0.1
 */