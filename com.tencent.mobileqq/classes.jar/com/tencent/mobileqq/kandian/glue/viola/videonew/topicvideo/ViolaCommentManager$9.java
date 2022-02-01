package com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ViolaCommentManager$9
  implements View.OnLayoutChangeListener
{
  ViolaCommentManager$9(ViolaCommentManager paramViolaCommentManager, VVideoView paramVVideoView, View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, int paramInt) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    ViolaCommentManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager).removeOnLayoutChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager.9
 * JD-Core Version:    0.7.0.1
 */