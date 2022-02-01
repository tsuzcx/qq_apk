package com.tencent.mobileqq.kandian.biz.share;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

class AbstractReadInjoyWebShareHelper$ItemClickProcessor$1
  implements ITroopMemberApiClientApi.Callback
{
  AbstractReadInjoyWebShareHelper$ItemClickProcessor$1(AbstractReadInjoyWebShareHelper.ItemClickProcessor paramItemClickProcessor, ActionItem paramActionItem) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("isSuccess");
    this.b.a.a(this.a.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.ItemClickProcessor.1
 * JD-Core Version:    0.7.0.1
 */