package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.QueryCallback;

class EmotionBatchForwardOption$2$1
  implements QueryCallback<Emoticon>
{
  EmotionBatchForwardOption$2$1(EmotionBatchForwardOption.2 param2, SessionInfo paramSessionInfo) {}
  
  public void a(Emoticon paramEmoticon)
  {
    ChatActivityFacade.a(this.b.this$0.q, this.b.this$0.I, this.a, paramEmoticon, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.EmotionBatchForwardOption.2.1
 * JD-Core Version:    0.7.0.1
 */