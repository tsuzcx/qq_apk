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
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if (paramLong == ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.a.a)
    {
      if (paramBoolean)
      {
        this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702479));
        this.a.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
        ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.h = 2;
        ((AbsBaseArticleInfo)localObject).isNeedShowBtnWhenFollowed = true;
      }
      else
      {
        this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        this.a.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702484));
        this.a.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
        ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.h = 1;
      }
      ReadInJoyLogicEngineEventDispatcher.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderUgc.4
 * JD-Core Version:    0.7.0.1
 */