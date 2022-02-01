package com.tencent.mobileqq.kandian.biz.follow.popup;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJPopupWindowUtil$showFollowRecommendPopup$1
  implements Runnable
{
  RIJPopupWindowUtil$showFollowRecommendPopup$1(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public final void run()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendFollowInfos;
      int i;
      if (localObject2 != null) {
        i = ((RecommendFollowInfos)localObject2).b;
      } else {
        i = 1;
      }
      int j;
      if (i == 2) {
        j = 2131560321;
      } else {
        j = 2131560207;
      }
      localObject2 = LayoutInflater.from((Context)localObject1).inflate(j, null);
      if (localObject2 != null)
      {
        localObject2 = (LinearLayout)localObject2;
        localObject1 = new RIJBottomDialog((Context)localObject1, i);
        ((RIJBottomDialog)localObject1).setContentView((View)localObject2);
        RIJFollowPackUtils.a.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, (ViewGroup)localObject2, (RIJBottomDialog)localObject1);
        RIJPopupWindowUtil.a(RIJPopupWindowUtil.a, (RIJBottomDialog)localObject1);
        RIJPopupWindowUtil.a(RIJPopupWindowUtil.a, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, (RIJBottomDialog)localObject1);
        ((RIJBottomDialog)localObject1).setOnShowListener((DialogInterface.OnShowListener)RIJPopupWindowUtil.showFollowRecommendPopup.1.1.1.a);
        ((RIJBottomDialog)localObject1).setOnDismissListener((DialogInterface.OnDismissListener)RIJPopupWindowUtil.showFollowRecommendPopup.1.1.2.a);
        ((RIJBottomDialog)localObject1).show();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJPopupWindowUtil.showFollowRecommendPopup.1
 * JD-Core Version:    0.7.0.1
 */