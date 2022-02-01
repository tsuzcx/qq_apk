package com.tencent.tkd.topicsdk.publisharticle;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import com.tencent.tkd.weibo.richEditText.EditObjectListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/publisharticle/PublishArticlePage$addEditObjectListener$1", "Lcom/tencent/tkd/weibo/richEditText/EditObjectListener;", "addRichEditObjectFailed", "", "editObject", "Lcom/tencent/tkd/weibo/bean/EditObject;", "onRichEditObjectChanged", "isAdd", "", "type", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "id", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishArticlePage$addEditObjectListener$1
  implements EditObjectListener
{
  public void a(@NotNull EditObject paramEditObject)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObject, "editObject");
    if ((this.a.a() != null) && (Intrinsics.areEqual(PublishArticlePage.a(this.a).getPublishScene(), "rijugc"))) {
      paramEditObject = paramEditObject.getType();
    }
    switch (PublishArticlePage.WhenMappings.a[paramEditObject.ordinal()])
    {
    default: 
      TLog.d("PublishArticleFragment", "addRichEditObjectFailed invalid editObject type.");
      return;
    case 1: 
      paramEditObject = this.a.a();
      if (paramEditObject == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(paramEditObject, "activity!!");
      paramEditObject = paramEditObject.getResources().getString(R.string.aD);
      Intrinsics.checkExpressionValueIsNotNull(paramEditObject, "activity!!.resources.get…                        )");
      TopicSDKHelperKt.a(paramEditObject, false, null, 6, null);
      return;
    }
    paramEditObject = this.a.a();
    if (paramEditObject == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(paramEditObject, "activity!!");
    paramEditObject = paramEditObject.getResources().getString(R.string.aE);
    Intrinsics.checkExpressionValueIsNotNull(paramEditObject, "activity!!.resources.get…tle_out_of_limit_tips_at)");
    TopicSDKHelperKt.a(paramEditObject, false, null, 6, null);
  }
  
  public void a(boolean paramBoolean, @NotNull EditObject.EditObjectType paramEditObjectType, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramEditObjectType, "type");
    Intrinsics.checkParameterIsNotNull(paramString, "id");
    DispatchManager localDispatchManager = DispatchManager.a;
    RichEditTextEvent localRichEditTextEvent = new RichEditTextEvent();
    localRichEditTextEvent.a(ReportEventPage.PAGE_PUBLISH);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localRichEditTextEvent.a(i);
      localRichEditTextEvent.a(paramString);
      localRichEditTextEvent.a(paramEditObjectType);
      localDispatchManager.a((IEvent)localRichEditTextEvent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.addEditObjectListener.1
 * JD-Core Version:    0.7.0.1
 */