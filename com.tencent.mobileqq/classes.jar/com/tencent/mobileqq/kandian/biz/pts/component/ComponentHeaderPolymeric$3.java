package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class ComponentHeaderPolymeric$3
  implements Ox978RespCallBack
{
  ComponentHeaderPolymeric$3(ComponentHeaderPolymeric paramComponentHeaderPolymeric, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("followPubAccount() unfollowUin uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" followStatus = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mPolymericInfo.e);
      QLog.d("ComponentHeaderPolymeric", 2, localStringBuilder.toString());
    }
    if (!paramString.equals(ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric).getTag())) {
      return;
    }
    ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric, true);
    if (paramBoolean)
    {
      ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric, false);
      ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 1);
      return;
    }
    ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPolymeric, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPolymeric.3
 * JD-Core Version:    0.7.0.1
 */