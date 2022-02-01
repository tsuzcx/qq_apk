package com.tencent.mobileqq.kandian.biz.message;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;

class RIJTipMessageManager$1
  implements MessageObserver
{
  RIJTipMessageManager$1(RIJTipMessageManager paramRIJTipMessageManager) {}
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    RIJTipMessageManager.a(this.a).b().runOnUiThread(new RIJTipMessageManager.1.2(this));
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    RIJTipMessageManager.a(this.a).b().runOnUiThread(new RIJTipMessageManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.RIJTipMessageManager.1
 * JD-Core Version:    0.7.0.1
 */