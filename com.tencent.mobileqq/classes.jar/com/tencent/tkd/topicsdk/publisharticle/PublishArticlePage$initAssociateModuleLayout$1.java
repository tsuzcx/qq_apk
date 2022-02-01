package com.tencent.tkd.topicsdk.publisharticle;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout;
import com.tencent.tkd.topicsdk.mediaselector.PanelType;
import com.tencent.tkd.topicsdk.widget.AssociateModuleLayout;
import com.tencent.tkd.topicsdk.widget.MediaDisplayLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initAssociateModuleLayout$1
  implements View.OnClickListener
{
  PublishArticlePage$initAssociateModuleLayout$1(PublishArticlePage paramPublishArticlePage) {}
  
  public final void onClick(View paramView)
  {
    int k = 1;
    int j;
    if (PublishArticlePage.a(this.a).a() == PanelType.PHOTO)
    {
      i = 1;
      ArrayList localArrayList = PublishArticlePage.a(this.a).a();
      if ((localArrayList.size() <= 0) || (((DisplayItem)localArrayList.get(0)).getMedia().getType() != MediaType.PHOTO)) {
        break label116;
      }
      j = 1;
      label64:
      if ((i == 0) && (j == 0)) {
        break label124;
      }
      paramView = this.a.a();
      if (paramView == null) {
        break label121;
      }
      paramView = paramView.getResources().getString(R.string.aq);
      Intrinsics.checkExpressionValueIsNotNull(paramView, "resources.getString(R.st….topic_panel_disable_tip)");
      TopicSDKHelperKt.a(paramView, false, null, 6, null);
    }
    label116:
    label121:
    for (;;)
    {
      return;
      i = 0;
      break;
      j = 0;
      break label64;
    }
    label124:
    if (((CharSequence)PublishArticlePage.a(this.a).a()).length() > 0) {}
    for (int i = k;; i = 0)
    {
      if (i != 0)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
        paramView = paramView.getResources().getString(R.string.f);
        Intrinsics.checkExpressionValueIsNotNull(paramView, "it.resources.getString(R…ng.associate_topic_toast)");
        TopicSDKHelperKt.a(paramView, false, null, 6, null);
      }
      PublishArticlePage.a(this.a, PublishArticlePage.a(this.a).a(), (Function1)new PublishArticlePage.initAssociateModuleLayout.1.2(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initAssociateModuleLayout.1
 * JD-Core Version:    0.7.0.1
 */