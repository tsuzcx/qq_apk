package com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView;
import com.tencent.qphone.base.util.QLog;

class ViolaCommentManager$2
  implements View.OnLayoutChangeListener
{
  ViolaCommentManager$2(ViolaCommentManager paramViolaCommentManager, VVideoView paramVVideoView, View paramView, int[] paramArrayOfInt, int paramInt1, int paramInt2) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramView.removeOnLayoutChangeListener(this);
    paramView.setTranslationX(ViolaCommentManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager)[0]);
    paramView.setTranslationY(ViolaCommentManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager)[1]);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("vvvideo w:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.getWidth());
    ((StringBuilder)localObject).append(" h:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVVideoView.getHeight());
    ((StringBuilder)localObject).append(" vW:");
    ((StringBuilder)localObject).append(paramView.getWidth());
    ((StringBuilder)localObject).append(" vH:");
    ((StringBuilder)localObject).append(paramView.getHeight());
    QLog.d("ViolaCommentManager", 1, ((StringBuilder)localObject).toString());
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewView, ViolaCommentManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager), ViolaCommentManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager), this.jdField_a_of_type_ArrayOfInt, new int[] { this.jdField_a_of_type_Int, this.b }, 300L, true);
    paramView = ViolaCommentManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager);
    paramInt1 = ViolaCommentManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager)[1];
    paramInt2 = ViolaCommentManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager)[1];
    localObject = ViolaCommentManager.c(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager);
    paramInt3 = VideoFeedsHelper.b(ViolaCommentManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager))[1];
    paramInt4 = ViolaCommentManager.c(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager)[1];
    int[] arrayOfInt = ViolaCommentManager.c(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewTopicvideoViolaCommentManager);
    VideoFeedsHelper.a(paramView, new int[] { 0, paramInt1 + paramInt2 }, (int[])localObject, new int[] { 0, paramInt3 - paramInt4 }, arrayOfInt, 300L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager.2
 * JD-Core Version:    0.7.0.1
 */