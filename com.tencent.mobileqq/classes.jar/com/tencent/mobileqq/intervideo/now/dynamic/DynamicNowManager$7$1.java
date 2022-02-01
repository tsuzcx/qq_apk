package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.intervideo.now.dynamic.strategy.IEnterRoomStrategy;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.api.login.IBizLoginObserver;
import org.json.JSONObject;

class DynamicNowManager$7$1
  extends DefaultLiveTicketObserver
{
  DynamicNowManager$7$1(DynamicNowManager.7 param7, IBizLoginObserver paramIBizLoginObserver) {}
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    IBizLoginObserver localIBizLoginObserver = this.a;
    if (localIBizLoginObserver != null) {
      localIBizLoginObserver.a(paramInt, paramString);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (this.a != null)
    {
      paramJSONObject = new BizLoginRequest();
      paramJSONObject.a = DynamicNowManager.a(this.b.b).b(this.b.a);
      paramJSONObject.b = 8;
      paramJSONObject.i = DynamicNowManager.d(this.b.b).c();
      paramJSONObject.h = DynamicNowManager.d(this.b.b).d();
      paramJSONObject.c = "101490787";
      this.a.a(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.7.1
 * JD-Core Version:    0.7.0.1
 */