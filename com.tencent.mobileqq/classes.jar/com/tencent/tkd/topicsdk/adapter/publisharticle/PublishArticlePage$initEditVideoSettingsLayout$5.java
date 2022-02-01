package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.widget.AddToTopicLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initEditVideoSettingsLayout$5
  implements View.OnClickListener
{
  PublishArticlePage$initEditVideoSettingsLayout$5(PublishArticlePage paramPublishArticlePage) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a;
    TopicInfo localTopicInfo = PublishArticlePage.d(paramView).getSelectedTopic();
    long l;
    if (localTopicInfo != null) {
      l = localTopicInfo.getTopicId();
    } else {
      l = 0L;
    }
    PublishArticlePage.a(paramView, l, (Function1)new PublishArticlePage.initEditVideoSettingsLayout.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.initEditVideoSettingsLayout.5
 * JD-Core Version:    0.7.0.1
 */