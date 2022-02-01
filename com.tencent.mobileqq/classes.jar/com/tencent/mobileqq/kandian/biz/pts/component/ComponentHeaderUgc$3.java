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
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.h = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc.a.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc.a.setText(HardCodeUtil.a(2131702453));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc.a.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.h = 2;
      ReadInJoyLogicEngine.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      ReadInJoyLogicEngine.a().c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a.a, paramInt);
      ReadInJoyLogicEngineEventDispatcher.a().c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc.a.setEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc.a.setText(HardCodeUtil.a(2131702450));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc.a.getPaint().setFakeBoldText(true);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc.getContext(), HardCodeUtil.a(2131702483), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderUgc.3
 * JD-Core Version:    0.7.0.1
 */