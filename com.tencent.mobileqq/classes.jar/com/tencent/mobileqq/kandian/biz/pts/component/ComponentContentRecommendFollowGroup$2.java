package com.tencent.mobileqq.kandian.biz.pts.component;

import com.tencent.mobileqq.kandian.repo.follow.BatchFollowModel;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule.BatchFollowCallBack;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ComponentContentRecommendFollowGroup$2
  implements UserOperationModule.BatchFollowCallBack
{
  ComponentContentRecommendFollowGroup$2(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup, List paramList, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, ArrayList<BatchFollowModel> paramArrayList, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("followThem, isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", followList = ");
      localStringBuilder.append(paramArrayList);
      localStringBuilder.append(", errorMsg = ");
      localStringBuilder.append(paramString);
      QLog.e("ComponentContentRecommendFollowGroup", 2, localStringBuilder.toString());
    }
    int i = 0;
    if (paramBoolean)
    {
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramArrayList = (RecommendFollowInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        paramArrayList.isFollowed = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup.b(paramArrayList);
        i += 1;
      }
      ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup).notifyDataSetChanged();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentRecommendFollowGroup.getContext(), 1, 2131717970, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup.2
 * JD-Core Version:    0.7.0.1
 */