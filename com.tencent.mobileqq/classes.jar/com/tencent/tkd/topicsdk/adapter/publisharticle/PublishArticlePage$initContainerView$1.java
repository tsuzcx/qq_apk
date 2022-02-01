package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initContainerView$1
  implements View.OnClickListener
{
  PublishArticlePage$initContainerView$1(PublishArticlePage paramPublishArticlePage, Activity paramActivity, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    if (InputMethodUtils.a.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      paramView = InputMethodUtils.a;
      Context localContext = (Context)this.jdField_a_of_type_AndroidAppActivity;
      IBinder localIBinder = this.jdField_a_of_type_AndroidWidgetLinearLayout.getWindowToken();
      Intrinsics.checkExpressionValueIsNotNull(localIBinder, "container.windowToken");
      paramView.a(localContext, localIBinder);
      return;
    }
    InputMethodUtils.a.a((Context)this.jdField_a_of_type_AndroidAppActivity, (View)PublishArticlePage.a(this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterPublisharticlePublishArticlePage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initContainerView.1
 * JD-Core Version:    0.7.0.1
 */