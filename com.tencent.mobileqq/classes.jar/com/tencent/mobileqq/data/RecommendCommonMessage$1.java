package com.tencent.mobileqq.data;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class RecommendCommonMessage$1
  implements Runnable
{
  RecommendCommonMessage$1(RecommendCommonMessage paramRecommendCommonMessage, WeakReference paramWeakReference) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface != null) {
      localQQAppInterface.a().a(this.this$0.frienduin, this.this$0.istroop, this.this$0.uniseq, "extStr", this.this$0.extStr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendCommonMessage.1
 * JD-Core Version:    0.7.0.1
 */