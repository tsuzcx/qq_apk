package com.tencent.tkd.weibo.tweetTopic;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.tkd.weibo.tweetTopic.hotTopic.HotTopicListView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/tkd/weibo/tweetTopic/TweetTopicView$initSearchResultView$2$3"}, k=3, mv={1, 1, 16})
final class TweetTopicView$initSearchResultView$$inlined$apply$lambda$2
  extends Lambda
  implements Function0<Unit>
{
  TweetTopicView$initSearchResultView$$inlined$apply$lambda$2(TweetTopicView paramTweetTopicView, Context paramContext)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (TweetTopicView.a(this.this$0))
    {
      Object localObject = this.$context$inlined.getSystemService("input_method");
      if (localObject != null)
      {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(TweetTopicView.a(this.this$0).getWindowToken(), 0);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView.initSearchResultView..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */