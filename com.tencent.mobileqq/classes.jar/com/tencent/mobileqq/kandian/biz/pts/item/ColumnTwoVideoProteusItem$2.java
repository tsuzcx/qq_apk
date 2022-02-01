package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.SubVideoInfo;
import java.util.List;

class ColumnTwoVideoProteusItem$2
  implements ViewBase.OnClickListener
{
  ColumnTwoVideoProteusItem$2(ColumnTwoVideoProteusItem paramColumnTwoVideoProteusItem, Context paramContext, MultiVideoColumnInfo paramMultiVideoColumnInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidContentContext, ((SubVideoInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityMultiVideoColumnInfo.a.get(0)).a);
    ColumnTwoVideoProteusItem.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemColumnTwoVideoProteusItem, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.ColumnTwoVideoProteusItem.2
 * JD-Core Version:    0.7.0.1
 */