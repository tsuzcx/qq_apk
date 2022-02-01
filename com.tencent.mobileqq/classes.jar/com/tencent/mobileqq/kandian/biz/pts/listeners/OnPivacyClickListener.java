package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PrivacyShowInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class OnPivacyClickListener
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public OnPivacyClickListener(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((paramViewBase != null) && (paramViewBase.mSocialFeedInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a == null) {
        return;
      }
      paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a;
      if (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin() != this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Long) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("privacy type is  ");
      ((StringBuilder)localObject).append(paramViewBase.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("| feedsid is ");
      ((StringBuilder)localObject).append(paramViewBase.b);
      QLog.d("OnPivacyClickListener", 2, ((StringBuilder)localObject).toString());
      if (paramViewBase.jdField_a_of_type_Int == 1)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("feeds_id", paramViewBase.b);
        PublicFragmentActivity.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, ReadInJoyPrivacyListFragment.class);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnPivacyClickListener
 * JD-Core Version:    0.7.0.1
 */