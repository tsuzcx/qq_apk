package com.tencent.tkd.topicsdk.adapter.publisharticle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent;
import com.tencent.tkd.topicsdk.framework.events.RichEditTextEvent.Companion;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.richEditText.RichEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "editObjects", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lkotlin/collections/ArrayList;", "outputBundle", "Landroid/os/Bundle;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$showAtContactListView$1
  extends Lambda
  implements Function2<ArrayList<EditObject>, Bundle, Unit>
{
  PublishArticlePage$showAtContactListView$1(PublishArticlePage paramPublishArticlePage, boolean paramBoolean, Activity paramActivity)
  {
    super(2);
  }
  
  public final void invoke(@Nullable ArrayList<EditObject> paramArrayList, @Nullable Bundle paramBundle)
  {
    if ((paramArrayList != null) && ((((Collection)paramArrayList).isEmpty() ^ true)))
    {
      if (this.$hasInputAtInEditText)
      {
        localObject = PublishArticlePage.h(this.this$0);
        if ((((RichEditText)localObject).getText().length() > ((RichEditText)localObject).getSelectionStart() - 1) && (((RichEditText)localObject).getText().charAt(((RichEditText)localObject).getSelectionStart() - 1) == '@')) {
          ((RichEditText)localObject).getText().delete(((RichEditText)localObject).getSelectionStart() - 1, ((RichEditText)localObject).getSelectionStart());
        }
      }
      Object localObject = ((Iterable)paramArrayList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EditObject localEditObject = (EditObject)((Iterator)localObject).next();
        JSONObject localJSONObject = RichEditTextEvent.a.a(1);
        PublishArticlePage.h(this.this$0).a(localEditObject, localJSONObject);
      }
    }
    if ((paramArrayList != null) || ((paramBundle != null) && (paramBundle.getBoolean("isSoftInputActive") == true))) {
      InputMethodUtils.a.a((Context)this.$activity, (View)PublishArticlePage.h(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.showAtContactListView.1
 * JD-Core Version:    0.7.0.1
 */