package com.tencent.tkd.topicsdk.publisharticle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

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
    if (paramEditObject != null) {
      RichEditText.a(PublishArticlePage.a(this.this$0), paramEditObject, false, 2, null);
    }
    for (;;)
    {
      if ((paramEditObject != null) || ((paramBundle != null) && (paramBundle.getBoolean("isSoftInputActive") == true))) {
        InputMethodUtils.a.a((Context)this.$activity, (View)PublishArticlePage.a(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.showTopicListView.1
 * JD-Core Version:    0.7.0.1
 */