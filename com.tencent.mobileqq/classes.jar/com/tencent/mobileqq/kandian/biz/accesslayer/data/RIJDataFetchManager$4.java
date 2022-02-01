package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.mobileqq.kandian.repo.comment.entity.CommentInfo;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class RIJDataFetchManager$4
  implements IRIJBiuAndCommentMixDataManager.BiuAndCommentListener
{
  RIJDataFetchManager$4(RIJDataFetchManager paramRIJDataFetchManager, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    if (paramRIJBiuAndCommentRespData.a() == 0)
    {
      ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, new CommentInfo(), false);
      QQToast.a(RIJDataFetchManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager).a(), 2, RIJDataFetchManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager).a().getString(2131717822), 0).a();
    }
    else
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131712831), 0).a();
    }
    RIJDataFetchManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager);
    RIJDataFetchManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.4
 * JD-Core Version:    0.7.0.1
 */