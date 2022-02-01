package com.tencent.mobileqq.kandian.biz.ugc.selecttopic;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/kandian/biz/ugc/selecttopic/SelectTopicFragment$handleVideoAddToTopicResult$1$1"}, k=3, mv={1, 1, 16})
final class SelectTopicFragment$handleVideoAddToTopicResult$$inlined$apply$lambda$1
  implements View.OnClickListener
{
  SelectTopicFragment$handleVideoAddToTopicResult$$inlined$apply$lambda$1(BaseActivity paramBaseActivity, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(RIJUgcUtils.a());
    paramView.append(this.jdField_a_of_type_Int);
    paramView = paramView.toString();
    ViolaAccessHelper.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "", paramView, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selecttopic.SelectTopicFragment.handleVideoAddToTopicResult..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */