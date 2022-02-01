package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent.Companion;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "editObject", "Lcom/tencent/tkd/weibo/bean/EditObject;", "outputBundle", "Landroid/os/Bundle;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$showTopicListView$1
  extends Lambda
  implements Function2<EditObject, Bundle, Unit>
{
  PublishArticlePage$showTopicListView$1(PublishArticlePage paramPublishArticlePage, Activity paramActivity)
  {
    super(2);
  }
  
  public final void invoke(@Nullable EditObject paramEditObject, @Nullable Bundle paramBundle)
  {
    if (paramEditObject != null)
    {
      JSONObject localJSONObject = RichEditTextEvent.a.a(1);
      PublishArticlePage.h(this.this$0).a(paramEditObject, localJSONObject);
    }
    if ((paramEditObject != null) || ((paramBundle != null) && (paramBundle.getBoolean("isSoftInputActive") == true))) {
      InputMethodUtils.a.a((Context)this.$activity, (View)PublishArticlePage.h(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.showTopicListView.1
 * JD-Core Version:    0.7.0.1
 */