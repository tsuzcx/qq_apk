package com.tencent.tkd.topicsdk.publisharticle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.widget.AddToTopicLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initEditVideoSettingsLayout$7
  implements View.OnClickListener
{
  PublishArticlePage$initEditVideoSettingsLayout$7(PublishArticlePage paramPublishArticlePage) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a;
    TopicInfo localTopicInfo = PublishArticlePage.a(this.a).a();
    if (localTopicInfo != null) {}
    for (long l = localTopicInfo.getTopicId();; l = 0L)
    {
      PublishArticlePage.a(paramView, l, (Function1)new PublishArticlePage.initEditVideoSettingsLayout.7.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initEditVideoSettingsLayout.7
 * JD-Core Version:    0.7.0.1
 */