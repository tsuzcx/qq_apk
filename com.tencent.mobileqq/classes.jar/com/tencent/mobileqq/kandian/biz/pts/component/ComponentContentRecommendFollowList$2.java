package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ComponentContentRecommendFollowList$2
  implements Ox978RespCallBack
{
  ComponentContentRecommendFollowList$2(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("978 resp, result : ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", data : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", distUin : ");
      localStringBuilder.append(paramString);
      QLog.d("ComponentContentRecommendFollowList", 2, localStringBuilder.toString());
    }
    boolean bool = false;
    if (paramBoolean)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo;
      paramBoolean = bool;
      if (paramInt == 2) {
        paramBoolean = true;
      }
      paramString.isFollowed = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo);
      ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList).notifyDataSetChanged();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowList.getContext(), 1, 2131717970, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList.2
 * JD-Core Version:    0.7.0.1
 */