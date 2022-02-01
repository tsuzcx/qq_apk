package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;

class NativeAwesomeCommentView$4
  implements View.OnClickListener
{
  NativeAwesomeCommentView$4(NativeAwesomeCommentView paramNativeAwesomeCommentView, AwesomeCommentInfo paramAwesomeCommentInfo) {}
  
  public void onClick(View paramView)
  {
    if (NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAwesomeCommentView))
    {
      NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAwesomeCommentView, false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructAwesomeCommentInfo != null)
    {
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAwesomeCommentView.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructAwesomeCommentInfo.a, this.jdField_a_of_type_ComTencentMobileqqKandianRepoDbStructAwesomeCommentInfo.c);
      AwesomeCommentInfo.a(NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAwesomeCommentView).a, "0X8009B77", RIJBaseItemViewType.a(NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeAwesomeCommentView).a, 0), NativeAwesomeCommentView.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAwesomeCommentView.4
 * JD-Core Version:    0.7.0.1
 */