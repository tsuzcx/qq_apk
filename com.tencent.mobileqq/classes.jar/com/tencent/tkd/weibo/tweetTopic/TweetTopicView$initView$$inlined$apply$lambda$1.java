package com.tencent.tkd.weibo.tweetTopic;

import com.tencent.tkd.topicsdk.common.KeyBoardChangeListener.KeyboardListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/tweetTopic/TweetTopicView$initView$1$1", "Lcom/tencent/tkd/topicsdk/common/KeyBoardChangeListener$KeyboardListener;", "onKeyboardChange", "", "isShow", "", "keyboardHeight", "", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TweetTopicView$initView$$inlined$apply$lambda$1
  implements KeyBoardChangeListener.KeyboardListener
{
  TweetTopicView$initView$$inlined$apply$lambda$1(TweetTopicView paramTweetTopicView) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    TweetTopicView.a(this.a, paramBoolean);
    if (!paramBoolean) {
      this.a.requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.TweetTopicView.initView..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */