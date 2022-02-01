package com.tencent.mobileqq.kandian.biz.pts.component;

import android.os.Looper;
import android.text.TextPaint;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

class ComponentHeaderUgc$4
  extends ReadInJoyObserver
{
  ComponentHeaderUgc$4(ComponentHeaderUgc paramComponentHeaderUgc) {}
  
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
      QLog.e("ComponentHeaderUgc", 2, "Please call this method in main thread!!!");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateAfterAccountFollow uin = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" isFollow = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ComponentHeaderUgc", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.a.a.k();
    if (paramLong == ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.c.a)
    {
      if (paramBoolean)
      {
        this.a.g.setEnabled(false);
        this.a.g.setText(HardCodeUtil.a(2131900481));
        this.a.g.getPaint().setFakeBoldText(false);
        ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.o = 2;
        ((AbsBaseArticleInfo)localObject).isNeedShowBtnWhenFollowed = true;
      }
      else
      {
        this.a.g.setEnabled(true);
        this.a.g.setText(HardCodeUtil.a(2131899712));
        this.a.g.getPaint().setFakeBoldText(true);
        ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.o = 1;
      }
      ReadInJoyLogicEngineEventDispatcher.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderUgc.4
 * JD-Core Version:    0.7.0.1
 */