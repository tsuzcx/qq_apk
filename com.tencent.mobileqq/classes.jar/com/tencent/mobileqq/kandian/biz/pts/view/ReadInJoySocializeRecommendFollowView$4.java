package com.tencent.mobileqq.kandian.biz.pts.view;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ReadInJoySocializeRecommendFollowView$4
  implements Ox978RespCallBack
{
  ReadInJoySocializeRecommendFollowView$4(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("followPubAccount() onFollowPublicAccount uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFollowRecommendFollowInfo;
      paramString.isFollowed = true;
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView, paramString);
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView).notifyDataSetChanged();
      return;
    }
    QQToast.a(ReadInJoySocializeRecommendFollowView.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewReadInJoySocializeRecommendFollowView).getContext(), 1, 2131717970, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.4
 * JD-Core Version:    0.7.0.1
 */