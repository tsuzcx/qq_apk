package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdObserver;
import com.tencent.mobileqq.util.JSONUtils;
import org.json.JSONObject;

class MessengerService$11
  extends EcshopAdObserver
{
  MessengerService$11(MessengerService paramMessengerService) {}
  
  public void a(Object paramObject)
  {
    if (this.a.a != null)
    {
      this.a.a.putString("data", JSONUtils.a(paramObject).toString());
      this.a.a(this.a.a);
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.11
 * JD-Core Version:    0.7.0.1
 */