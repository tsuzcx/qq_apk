package com.tencent.tkd.weibo.tweetTopic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.tkd.topicsdk.mvp.BaseListView;
import com.tencent.tkd.weibo.component.R.drawable;
import com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/tweetTopic/TweetTopicView$initSearchTopicView$1", "Landroid/text/TextWatcher;", "addTextClearView", "", "afterTextChanged", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TweetTopicView$initSearchTopicView$1
  implements TextWatcher
{
  private final void a()
  {
    Object localObject = this.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources().getDrawable(R.drawable.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "drawable");
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    TweetTopicView.b(this.a).setCompoundDrawables(TweetTopicView.c(this.a), null, (Drawable)localObject, null);
    TweetTopicView.h(this.a);
  }
  
  public void afterTextChanged(@Nullable Editable paramEditable)
  {
    if (paramEditable != null)
    {
      paramEditable = paramEditable.toString();
      if (paramEditable != null) {}
    }
    else
    {
      paramEditable = "";
    }
    int i;
    if (((CharSequence)paramEditable).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      TweetTopicView.b(this.a).setCompoundDrawables(TweetTopicView.c(this.a), null, null, null);
      TweetTopicView.d(this.a).setVisibility(8);
      return;
    }
    a();
    TweetTopicView.d(this.a).setVisibility(0);
    TweetTopicView.e(this.a).a(paramEditable);
    TweetTopicView.f(this.a).a(paramEditable);
    TweetTopicView.g(this.a).a(Boolean.valueOf(false));
  }
  
  public void beforeTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(@Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView.initSearchTopicView.1
 * JD-Core Version:    0.7.0.1
 */