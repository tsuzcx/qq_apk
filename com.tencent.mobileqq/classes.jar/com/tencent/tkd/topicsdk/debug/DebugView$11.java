package com.tencent.tkd.topicsdk.debug;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.managetopic.EditTopicPage;
import com.tencent.tkd.topicsdk.managetopic.EditTopicPage.Companion;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class DebugView$11
  implements View.OnClickListener
{
  DebugView$11(Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    paramView = EditTopicPage.a;
    Context localContext = this.a;
    TopicInfo localTopicInfo = new TopicInfo(0L, null, null, null, false, 0L, 0, 127, null);
    localTopicInfo.setTopicId(1024L);
    localTopicInfo.setTitle("我是栏目名称");
    localTopicInfo.setIntro("我是栏目简介");
    localTopicInfo.setCoverUrl("https://pub.idqqimg.com/pc/misc/files/20190323/594394ee14534627b0698e7cb39e37c9.jpg");
    paramView.a(localContext, localTopicInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.debug.DebugView.11
 * JD-Core Version:    0.7.0.1
 */